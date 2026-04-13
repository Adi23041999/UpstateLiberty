#include "ModelTraits.h"
#include "CFileMgr.h"
#include "CFileLoader.h"
#include "CGarages.h"

CGarage* ModelTraits::aGarages = nullptr;
std::vector<int32> ModelTraits::DoorModelIds;
std::vector<int32> ModelTraits::TreeModelIds;
std::vector<int32> ModelTraits::BannerModelIds;
std::vector<int32> ModelTraits::GlassModelIds;

void ModelTraits::Initialize()
{
	Events::initRwEvent.after += []
		{
			DoPatches();
		};
	Events::initScriptsEvent.after += []
		{ 
			CollectModels();
		};
}

void ModelTraits::DoPatches()
{
	aGarages = injector::ReadMemory<CGarage*>(0x421E74 + 1);

	injector::MakeJMP(0x428D90, Patch_IsModelIndexADoor);
	injector::MakeJMP(0x427510, Patch_SetGarageDoorToRotate);

	injector::MakeInline<0x41B730>([](injector::reg_pack& regs) // CCarCtrl::WeaveForObject
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsTreeModel(modelIndex) ? 0x41B7D2 : 0x41B7D6;
		});
	injector::MakeInline<0x4743E0>([](injector::reg_pack& regs) // CEntity::PreRender
		{
			int16 modelIndex = regs.ebx;
			regs.eip = IsTreeModel(modelIndex) ? 0x474482 : 0x474486;
		});
	injector::MakeInline<0x4B4348>([](injector::reg_pack& regs) // CWorld::RepositionCertainDynamicObjects
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsTreeModel(modelIndex) ? 0x4B4534 : 0x4B441A;
		});

	injector::MakeInline<0x4744A0>([](injector::reg_pack& regs) // CEntity::PreRender
		{
			int16 modelIndex = regs.ebx;
			regs.eip = IsBannerModel(modelIndex) ? 0x474542 : 0x474549;
		});

	injector::MakeInline<0x4749F8>([](injector::reg_pack& regs) // CRender::PreRender
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x474A01 : 0x474A70;
		});
	injector::MakeInline<0x478808>([](injector::reg_pack& regs) // CFileLoader::LoadObjectInstance
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x478811 : 0x478880;
		});
	injector::MakeInline<0x49756E>([](injector::reg_pack& regs) // CPhysical::ApplyCollision
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x497577 : 0x4975F0;
		});
	injector::MakeInline<0x497654>([](injector::reg_pack& regs) // CPhysical::ApplyCollision
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x49765D : 0x4976D0;
		});
	injector::MakeInline<0x497B9C>([](injector::reg_pack& regs) // CPhysical::ApplyCollision
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x497BA5 : 0x497C20;
		});
	injector::MakeInline<0x497D1C>([](injector::reg_pack& regs) // CPhysical::ApplyCollision
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x497D25 : 0x497DA0;
		});
	injector::MakeInline<0x4A9C78>([](injector::reg_pack& regs) // CRenderer::ScanSectorList
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x4A9C81 : 0x4A9CF0;
		});
	injector::MakeInline<0x4A9F05>([](injector::reg_pack& regs) // CRenderer::ScanSectorList_Priority
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x4A9F0E : 0x4A9F80;
		});
	injector::MakeInline<0x4B14A2>([](injector::reg_pack& regs) // CWorld::TriggerExplosionSectorList
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x4B14AB : 0x4B1520;
		});
	injector::MakeInline<0x4F44C5>([](injector::reg_pack& regs) // CPopulation::ConvertToRealObject
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x4F44CE : 0x4F4540;
		});
	injector::MakeInline<0x4F45E0>([](injector::reg_pack& regs) // CPopulation::ConvertToDummyObject
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x4F45E9 : 0x4F4660;
		});
	injector::MakeInline<0x50467D>([](injector::reg_pack& regs) // CGlass::WasGlassHitByBullet
		{
			int16 modelIndex = regs.eax;
			regs.eip = IsGlassModel(modelIndex) ? 0x504686 : 0x504700;
		});
}

void ModelTraits::CollectModels()
{
	enum {
		NONE,
		DOOR,
		TREE,
		BANNER,
		GLASS,
	};
	char* line;
	int32 section = NONE;
	char modelName[24];
	int32 modelId = -1;

	CFileMgr::ChangeDir("\\");
	int32 fd = CFileMgr::OpenFile("data\\modelTraits.dat", "r");
	if (!fd)
	{
		assert(false && "No modelTraits.dat found!");
		return;
	}

	for (line = CFileLoader::LoadLine(fd); line; line = CFileLoader::LoadLine(fd)) {
		if (*line == '\0' || *line == '#')
			continue;

		if (section == NONE) {
			if (strncmp(line, "door", 4) == 0)
				section = DOOR;
			else if (strncmp(line, "tree", 4) == 0)
				section = TREE;
			else if (strncmp(line, "banner", 6) == 0)
				section = BANNER;
			else if (strncmp(line, "glass", 5) == 0)
				section = GLASS;
		}
		else if (strncmp(line, "end", 3) == 0) {
			section = NONE;
		}
		else switch (section) {
		case DOOR: {
			sscanf(line, "%s", modelName);
			CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
			if (modelInfo)
				DoorModelIds.push_back(modelId);
			break;
		}
		case TREE: {
			sscanf(line, "%s", modelName);
			CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
			if (modelInfo)
				TreeModelIds.push_back(modelId);
			break;
		}
		case BANNER: {
			sscanf(line, "%s", modelName);
			CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
			if (modelInfo)
				BannerModelIds.push_back(modelId);
			break;
		}
		case GLASS: {
			sscanf(line, "%s", modelName);
			CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
			if (modelInfo)
				GlassModelIds.push_back(modelId);
			break;
		}
		}
	}
	CFileMgr::CloseFile(fd);
}

bool ModelTraits::Patch_IsModelIndexADoor(int32 modelIndexDoor)
{
	return std::find(DoorModelIds.begin(), DoorModelIds.end(), modelIndexDoor) != DoorModelIds.end();
}

void ModelTraits::Patch_SetGarageDoorToRotate(int16 garageIndex)
{
	CGarage& pGarage = aGarages[garageIndex];
	if (pGarage.m_bDoorSwingOpen)
		return;
	pGarage.m_bDoorSwingOpen = true;
	pGarage.m_fDoorOpenAngle /= 2.0f;
	pGarage.m_fDoorOpenAngle -= 0.1f;

	// VC fix for rotated doors that are initially open
	pGarage.m_fDoorCurrentAngle = Min(pGarage.m_fDoorOpenAngle, pGarage.m_fDoorCurrentAngle);
	pGarage.UpdateDoorsHeight();
}

bool ModelTraits::IsTreeModel(int16 modelIndex)
{
	return std::find(TreeModelIds.begin(), TreeModelIds.end(), modelIndex) != TreeModelIds.end();
}

bool ModelTraits::IsBannerModel(int16 modelIndex)
{
	return std::find(BannerModelIds.begin(), BannerModelIds.end(), modelIndex) != BannerModelIds.end();
}

bool ModelTraits::IsGlassModel(int16 modelIndex)
{
	return std::find(GlassModelIds.begin(), GlassModelIds.end(), modelIndex) != GlassModelIds.end();
}

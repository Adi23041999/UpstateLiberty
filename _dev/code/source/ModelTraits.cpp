#include "ModelTraits.h"
#include "CFileMgr.h"
#include "CFileLoader.h"
#include "CGarages.h"
#include "Upstate.h"

static inline CdeclEvent <AddressListMulti<0x44E912, GAME_10EN, H_CALL>, PRIORITY_AFTER, ArgPickN<int16, 0>, void(int16)> setGarageDoorToRotateEvent;

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
	setGarageDoorToRotateEvent += [](int16 garageIndex)
		{
			CGarage& pGarage = Upstate::GetGarages()[garageIndex];

			// VC fix for rotated doors that are initially open
			pGarage.m_fDoorCurrentAngle = Min(pGarage.m_fDoorOpenAngle, pGarage.m_fDoorCurrentAngle);
			pGarage.UpdateDoorsHeight();
		};
}

void ModelTraits::DoPatches()
{
	injector::MakeJMP(0x428D90, Patch_IsModelIndexADoor);

	static auto Tree_CCarCtrl__WeaveForObject = safetyhook::create_mid(0x41B730, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsTreeModel(modelIndex)) regs.eip = 0x41B7D2;
		});
	static auto Tree_CEntity__PreRender = safetyhook::create_mid(0x4743E0, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.ebx;
			if (IsTreeModel(modelIndex)) regs.eip = 0x474482;
		});
	static auto Tree_CWorld__RepositionCertainDynamicObjects = safetyhook::create_mid(0x4B4348, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsTreeModel(modelIndex)) regs.eip = 0x4B4534;
		});
	static auto Banner_CEntity__PreRender = safetyhook::create_mid(0x4744A0, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.ebx;
			if (IsBannerModel(modelIndex)) regs.eip = 0x474542;
		});
	static auto Glass_CEntity__PreRender = safetyhook::create_mid(0x4749F8, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x474A01;
		});
	static auto Glass_CFileLoader__LoadObjectInstance = safetyhook::create_mid(0x478808, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x478811;
		});
	static auto Glass_CPhysical__ApplyCollision = safetyhook::create_mid(0x49756E, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x497577;
		});
	static auto Glass_CPhysical__ApplyCollision2 = safetyhook::create_mid(0x497654, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x49765D;
		});
	static auto Glass_CPhysical__ApplyCollision3 = safetyhook::create_mid(0x497B9C, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x497BA5;
		});
	static auto Glass_CPhysical__ApplyCollision4 = safetyhook::create_mid(0x497D1C, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x497D25;
		});
	static auto Glass_CRenderer__ScanSectorList = safetyhook::create_mid(0x4A9C78, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x4A9C81;
		});
	static auto Glass_CRenderer__ScanSectorList_Priority = safetyhook::create_mid(0x4A9F05, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x4A9F0E;
		});
	static auto Glass_CWorld__TriggerExplosionSectorList = safetyhook::create_mid(0x4B14A2, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x4B14AB;
		});
	static auto Glass_CPopulation__ConvertToRealObject = safetyhook::create_mid(0x4F44C5, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x4F44CE;
		});
	static auto Glass_CPopulation__ConvertToDummyObject = safetyhook::create_mid(0x4F45E0, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x4F45E9;
		});
	static auto Glass_CGlass__WasGlassHitByBullet = safetyhook::create_mid(0x50467D, +[](SafetyHookContext& regs)
		{
			int16 modelIndex = regs.eax;
			if (IsGlassModel(modelIndex)) regs.eip = 0x504686;
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
		//IsStreetLight
		//IsExplosiveThingModel
		//IsFence
		//MI_BUOY
		//MI_FIRE_HYDRANT
		//CWorld::RepositionOneObject
	};
	char* line;
	int32 section = NONE;
	char modelName[24];
	int32 modelId = -1;

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
			if (sscanf(line, "%s", modelName) == 1)
			{
				CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
				if (modelInfo)
					DoorModelIds.push_back(modelId);
			}
			break;
		}
		case TREE: {
			if (sscanf(line, "%s", modelName) == 1)
			{
				CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
				if (modelInfo)
					TreeModelIds.push_back(modelId);
			}
			break;
		}
		case BANNER: {
			if (sscanf(line, "%s", modelName) == 1)
			{
				CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
				if (modelInfo)
					BannerModelIds.push_back(modelId);
			}
			break;
		}
		case GLASS: {
			if (sscanf(line, "%s", modelName) == 1)
			{
				CBaseModelInfo* modelInfo = CModelInfo::GetModelInfo(modelName, &modelId);
				if (modelInfo)
					GlassModelIds.push_back(modelId);
			}
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

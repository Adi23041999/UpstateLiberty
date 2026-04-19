#include "Rubbish.h"
#include "CRubbish.h"
#include "CTxdStore.h"
#include "CTheZones.h"

RwTexture* Rubbish::gpRuralRubbishTexture[NumRubbishTextures];

void Rubbish::Initialize()
{
	Events::initGameEvent.after += []()
	{
		CTxdStore::PushCurrentTxd();
		int slot = CTxdStore::FindTxdSlot("particle");
		CTxdStore::SetCurrentTxd(slot);
		gpRuralRubbishTexture[0] = RwTextureRead("gameleaf01_64", nullptr);
		gpRuralRubbishTexture[1] = RwTextureRead("gameleaf02_64", nullptr);
		gpRuralRubbishTexture[2] = RwTextureRead("gameleaf01_64", nullptr);
		gpRuralRubbishTexture[3] = RwTextureRead("gameleaf02_64", nullptr);
		CTxdStore::PopCurrentTxd();

		injector::MakeInline<0x5121E2>([](injector::reg_pack& regs)
			{
				int16 sheetIdx = regs.ebp;
				RwTexture* desiredTexture = GetDesiredRubbishTexture(sheetIdx);
				RwRenderStateSet(rwRENDERSTATETEXTURERASTER, RwTextureGetRaster(desiredTexture));
			});
	};

	Events::shutdownRwEvent += []()
	{
		for (int i = 0; i < NumRubbishTextures; i++) {
			if (gpRuralRubbishTexture[i]) {
				RwTextureDestroy(gpRuralRubbishTexture[i]);
				gpRuralRubbishTexture[i] = nullptr;
			}
		}
	};
}

RwTexture* Rubbish::GetDesiredRubbishTexture(int32 idx)
{
	assert(idx >= 0 && idx < NumRubbishTextures);
	CPlayerPed* pPed = FindPlayerPed();
	if (pPed)
	{
		CVector& pPos = pPed->GetPosition();
		
		int16 zoneId = CTheZones::FindZoneByLabelAndReturnIndex("UL_ZON0");
		CZone* ulZone = CTheZones::GetZone(zoneId);
		if (ulZone && CTheZones::PointLiesWithinZone(&pPos, ulZone))
		{
			zoneId = CTheZones::FindZoneByLabelAndReturnIndex("GT_ZON0");
			CZone* zone = CTheZones::GetZone(zoneId);
			if (zone && CTheZones::PointLiesWithinZone(&pPos, zone))
				return gpRubbishTexture[idx];
			zoneId = CTheZones::FindZoneByLabelAndReturnIndex("BAXTER");
			zone = CTheZones::GetZone(zoneId);
			if (zone && CTheZones::PointLiesWithinZone(&pPos, zone))
				return gpRubbishTexture[idx];
			zoneId = CTheZones::FindZoneByLabelAndReturnIndex("WARSAW");
			zone = CTheZones::GetZone(zoneId);
			if (zone && CTheZones::PointLiesWithinZone(&pPos, zone))
				return gpRubbishTexture[idx];
			zoneId = CTheZones::FindZoneByLabelAndReturnIndex("CARRIN");
			zone = CTheZones::GetZone(zoneId);
			if (zone && CTheZones::PointLiesWithinZone(&pPos, zone))
				return gpRubbishTexture[idx];

			return gpRuralRubbishTexture[idx];
		}
	}

	return gpRubbishTexture[idx];
}

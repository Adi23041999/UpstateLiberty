#include "Debug.h"
#include "CMessages.h"
#include "CGarages.h"
#include "CTheZones.h"
#include "CMenuManager.h"
#include "C_PcSave.h"
#include "CTheScripts.h"
#include "CHud.h"

void Debug::Initialize()
{
	//int32 slot = 0;
	Events::gameProcessEvent.after += []
		{
			//wchar_t* slotfilename = injector::ReadMemory<wchar_t*>(0x6F07C8);

			//if (FindPlayerPed())
			//{
			//	CVector& pPos = FindPlayerPed()->GetPosition();
			//	CZone* zone = CTheZones::FindSmallestZonePositionILN(pPos);
			//	if (zone)
			//	{
			//		if (strncmp(zone->m_aName, "UL_", 3) == 0 && zone->m_aName[3] != *"Z")
			//		{
			//			CMessages::AddMessage("on highway", 1, 0);
			//		}
			//	}
			//}
			/*const uint32 NumGarages = CGarages::NumGarages;*/


			//CMessages::AddMessageWithNumber("Slot ID: ~1~", 1, 0, FrontEndMenuManager.m_bWantToRestart, -1, -1, -1, -1, -1);
		};

	//Events::initScriptsEvent.before += [&slot]
	//	{
	////LVAR_INT new_game
	//	//READ_MEMORY 0x8F59D8 + 0x114 new_game

	//		char var = injector::ReadMemory<char>(0x8F59D8 + 0x114);
	//		CMessages::AddMessageWithNumber("Slot ID: ~1~", 5000, 0, var, -1, -1, -1, -1, -1);
	//	};
}

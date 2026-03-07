#include "ULCommon.h"
#include "Upstate.h"

void Init()
{
	Upstate::Initialize();
}

BOOL APIENTRY DllMain(HMODULE hModule, DWORD reason, LPVOID lpReserved)
{
    if (reason == DLL_PROCESS_ATTACH)
    {
        Init();
    }
    return TRUE;
}
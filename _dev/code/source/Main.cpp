#include "ULCommon.h"
#include "Upstate.h"
#include "Debug.h"

void Init()
{
	Upstate::Initialize();
#if DEBUG
	Debug::Initialize();
#endif
}

BOOL APIENTRY DllMain(HMODULE hModule, DWORD reason, LPVOID lpReserved)
{
    if (reason == DLL_PROCESS_ATTACH)
    {
        Init();
    }
    return TRUE;
}
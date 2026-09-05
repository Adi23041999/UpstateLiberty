#include "Upstate.h"
#include "Debug.h"
#include "ModelTraits.h"
#include "Misc.h"
#include "Rubbish.h"
#include "PoliceZones.h"

void Upstate::Initialize()
{
	ModelTraits::Initialize();
	Rubbish::Initialize();
	PoliceZones::Initialize();
	Misc::Initialize();
#if DEBUG
	Debug::Initialize();
#endif
}

CGarage* Upstate::GetGarages()
{
	return injector::ReadMemory<CGarage*>(0x421E74 + 1);
}

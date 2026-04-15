#include "Upstate.h"
#include "Debug.h"
#include "ModelTraits.h"
#include "Misc.h"

void Upstate::Initialize()
{
	ModelTraits::Initialize();
	Misc::Initialize();
#if DEBUG
	Debug::Initialize();
#endif
}

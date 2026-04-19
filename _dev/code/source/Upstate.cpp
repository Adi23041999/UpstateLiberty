#include "Upstate.h"
#include "Debug.h"
#include "ModelTraits.h"
#include "Misc.h"
#include "Rubbish.h"

void Upstate::Initialize()
{
	ModelTraits::Initialize();
	Rubbish::Initialize();
	Misc::Initialize();
#if DEBUG
	Debug::Initialize();
#endif
}

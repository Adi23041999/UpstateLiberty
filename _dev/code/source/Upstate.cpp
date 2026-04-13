#include "Upstate.h"
#include "Debug.h"
#include "ModelTraits.h"

void Upstate::Initialize()
{
	ModelTraits::Initialize();
#if DEBUG
	Debug::Initialize();
#endif
}

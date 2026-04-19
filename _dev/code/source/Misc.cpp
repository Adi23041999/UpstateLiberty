#include "Misc.h"

void Misc::Initialize()
{
	Events::initRwEvent += []()
	{
		// remove NumParkedCars from traffic cap calculations
		static int32 DummyParkedCars = 0;

		injector::WriteMemory<int32*>(0x416721 + 2, &DummyParkedCars, true);
		injector::WriteMemory<int32*>(0x41FC81 + 2, &DummyParkedCars, true);
		injector::WriteMemory<int32*>(0x4F4AF3 + 2, &DummyParkedCars, true);

		// Rescale the loading bar to match Upstate
		// The stock game's bar goes from 0 to 73, Upstate's goes from 0 to 102,
		// so for optimal compatibility with other mods, add 29 to the value present in the binary.
		static float NewNumChunksLoaded;
		NewNumChunksLoaded = 1.0f / (29.0f + (1.0f / *injector::ReadMemory<float*>(0x48D875 + 2)));
		injector::WriteMemory<float*>(0x48D875 + 2, &NewNumChunksLoaded, true);
	};
}

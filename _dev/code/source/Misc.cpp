#include "Misc.h"

int32 Misc::DummyParkedCars = 0;

void Misc::Initialize()
{
	// remove NumParkedCars from traffic cap calculations
	Events::initGameEvent += []()
	{
		injector::WriteMemory<int32*>(0x416721 + 2, &DummyParkedCars, true);
		injector::WriteMemory<int32*>(0x41FC81 + 2, &DummyParkedCars, true);
		injector::WriteMemory<int32*>(0x4F4AF3 + 2, &DummyParkedCars, true);
	};
}

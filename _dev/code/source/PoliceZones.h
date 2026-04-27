// Copyright (c) 2026 Adi <adriank3d@gmail.com>
#pragma once

struct tPoliceRadioZone {
    char m_aName[8];
    unsigned int m_nSampleIndex;
    int field_12;
};

class PoliceZones
{
public:
	static void Initialize();
	static void InitializePoliceRadioZones();
};

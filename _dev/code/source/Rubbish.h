// Copyright (c) 2026 Adi <adriank3d@gmail.com>
#pragma once
#include "rwcore.h"

constexpr int NumRubbishTextures = 4;

class Rubbish
{
public:
	static RwTexture* gpRuralRubbishTexture[NumRubbishTextures];

	static void Initialize();
	static RwTexture* GetDesiredRubbishTexture(int32 idx);
};

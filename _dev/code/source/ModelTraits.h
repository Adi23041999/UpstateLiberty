// Model traits let us assign behaviors to a model such as door models used in garages or trees which move on wind
// Copyright (c) 2026 Adi <adriank3d@gmail.com>

#pragma once

class ModelTraits
{
public:
	static class CGarage* aGarages;
	static std::vector<int32> DoorModelIds;
	static std::vector<int32> TreeModelIds;
	static std::vector<int32> BannerModelIds;
	static std::vector<int32> GlassModelIds;

	static void Initialize();

	static void DoPatches();
	static void CollectModels();

	static bool Patch_IsModelIndexADoor(int32 modelIndexDoor);
	static void Patch_SetGarageDoorToRotate(int16 garageIndex);
	
	static bool IsTreeModel(int16 modelIndex);
	static bool IsBannerModel(int16 modelIndex);
	static bool IsGlassModel(int16 modelIndex);
};

workspace "Upstate"
	configurations { "Release", "Debug", }
	platforms { "GTA3"}
    location( "build" )
	startproject "Upstate"
	files {
		"source/**",
	}

project "Upstate"
	kind "SharedLib"
	language "C++"
	targetextension ".asi"
	characterset ("MBCS")
	cppdialect "C++latest"
	linkoptions "/SAFESEH:NO"
	buildoptions { "-std:c++latest", "/permissive" }
	defines { "_CRT_SECURE_NO_WARNINGS", "_CRT_NON_CONFORMING_SWPRINTFS", "_USE_MATH_DEFINES", "RW", "_SILENCE_CXX23_ALIGNED_STORAGE_DEPRECATION_WARNING" }
	--disablewarnings { "4244", "4800", "4305", "4073", "4838", "4996", "4221", "4430", "26812", "26495", "6031" }
    flags { "NoPCH" }

    defines { "PLUGIN_SGV_10EN" }

    includedirs {
		"$(PLUGIN_SDK_DIR)/shared/",
		"$(PLUGIN_SDK_DIR)/shared/game/",
		"$(PLUGIN_SDK_DIR)/injector/",
	}
    forceincludes { "ULCommon.h" }
    flags {
        staticruntime "on",
        "NoImportLib",
        rtti ("Off"),
        "NoBufferSecurityCheck"
    }

    defines {
        "INJECTOR_GVM_HAS_TRANSLATOR",
        'INJECTOR_GVM_PLUGIN_NAME=\"Upstate\"'    -- (additional quotes needed for gmake)
    }

    defines {
        "_CRT_SECURE_NO_WARNINGS",
        "_SCL_SECURE_NO_WARNINGS"
    }

	libdirs { "$(PLUGIN_SDK_DIR)/output/lib" }

    largeaddressaware "on"

	filter "configurations:Debug"
		defines { "DEBUG" }
		symbols "on"

	filter "configurations:Release"
		defines { "NDEBUG" }
		symbols "on"
		optimize "speed"
		linktimeoptimization "on"
		inlining "auto"
		runtime "Release"

	filter { "configurations:Debug", "platforms:GTA3" }
		links { "plugin_iii_d" }

	filter { "configurations:Release", "platforms:GTA3" }
		links { "plugin_iii" }

	filter { "platforms:GTA3" }
		targetdir "output/bin/GTA3/"
		objdir ("output/bin/GTA3/GTA3/")
		targetname "III.Upstate"
		defines { "III", "GTA3" }
		--debugdir "$(GTA_III_DIR)"
		--debugcommand "$(GTA_III_DIR)/gta3.exe"
		debugcommand "D:/Projects/3D/GTA/Liberty City Countryside/GTA 3 UL/gta3.exe"
		debugdir "D:/Projects/3D/GTA/Liberty City Countryside/GTA 3 UL"
		includedirs {
			"$(PLUGIN_SDK_DIR)/plugin_III/",
			"$(PLUGIN_SDK_DIR)/plugin_III/game_III/",
			"$(PLUGIN_SDK_DIR)/plugin_III/game_III/rw",
		}
		postbuildcommands {
		"copy /y \"$(TargetPath)\" \"$(GTA_III_DIR)\\scripts\\III.Upstate.asi\"",
		"copy /y \"$(TargetPath)\" \"D:\\Projects\\3D\\GTA\\Liberty City Countryside\\GTA 3 UL\\scripts\\III.Upstate.asi\"",
		}

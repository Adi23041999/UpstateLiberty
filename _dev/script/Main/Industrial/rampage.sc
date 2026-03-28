MISSION_START

SET_DEATHARREST_STATE OFF

SCRIPT_NAME rampage

VAR_INT rampage_reward frenzy_status total_rampages_passed

VAR_INT rampage_01 rampage_02 rampage_03 rampage_04 rampage_05 
VAR_INT rampage_06 rampage_07 rampage_08 rampage_09 rampage_10 
VAR_INT rampage_11 rampage_12 rampage_13 rampage_14 rampage_15 
VAR_INT rampage_16 rampage_17 rampage_18 rampage_19 rampage_20

VAR_INT rampage_01_flag rampage_02_flag rampage_03_flag rampage_04_flag rampage_05_flag
VAR_INT rampage_06_flag rampage_07_flag rampage_08_flag rampage_09_flag rampage_10_flag
VAR_INT rampage_11_flag rampage_12_flag rampage_13_flag	rampage_14_flag rampage_15_flag
VAR_INT rampage_16_flag rampage_17_flag rampage_18_flag	rampage_19_flag rampage_20_flag

VAR_INT rampage_01_failed rampage_02_failed rampage_03_failed rampage_04_failed rampage_05_failed
VAR_INT rampage_06_failed rampage_07_failed rampage_08_failed rampage_09_failed rampage_10_failed
VAR_INT rampage_11_failed rampage_12_failed rampage_13_failed rampage_14_failed rampage_15_failed
VAR_INT rampage_16_failed rampage_17_failed rampage_18_failed rampage_19_failed rampage_20_failed

VAR_INT rampage_01_kills rampage_02_kills rampage_03_kills rampage_04_kills rampage_05_kills
VAR_INT rampage_06_kills rampage_07_kills rampage_08_kills rampage_09_kills rampage_10_kills
VAR_INT rampage_11_kills rampage_12_kills rampage_13_kills rampage_14_kills rampage_15_kills
VAR_INT rampage_16_kills rampage_17_kills rampage_18_kills rampage_19_kills rampage_20_kills

rampage_reward = 5000
frenzy_status = 0
total_rampages_passed = 0

rampage_01_flag = 0
rampage_02_flag = 0
rampage_03_flag = 0
rampage_04_flag = 0
rampage_05_flag = 0
rampage_06_flag = 0
rampage_07_flag = 0
rampage_08_flag = 0
rampage_09_flag = 0
rampage_10_flag = 0
rampage_11_flag = 0
rampage_12_flag = 0
rampage_13_flag = 0
rampage_14_flag = 0
rampage_15_flag = 0
rampage_16_flag = 0
rampage_17_flag = 0
rampage_18_flag = 0
rampage_19_flag = 0
rampage_20_flag = 0

rampage_01_failed = 0
rampage_02_failed = 0
rampage_03_failed = 0
rampage_04_failed = 0
rampage_05_failed = 0
rampage_06_failed = 0
rampage_07_failed = 0
rampage_08_failed = 0
rampage_09_failed = 0
rampage_10_failed = 0
rampage_11_failed = 0
rampage_12_failed = 0
rampage_13_failed = 0
rampage_14_failed = 0
rampage_15_failed = 0
rampage_16_failed = 0
rampage_17_failed = 0
rampage_18_failed = 0
rampage_19_failed = 0
rampage_20_failed = 0

CREATE_PICKUP killfrenzy PICKUP_ONCE  958.0 -431.0 14.5 rampage_01  //OPPOSITE LUIGI'S IN AN ALLEYWAY
CREATE_PICKUP killfrenzy PICKUP_ONCE 1076.9 -859.9 15.2 rampage_02  //BOTTOM OF CALAHAN BRIDGE
CREATE_PICKUP killfrenzy PICKUP_ONCE 1312.3 -315.7 42.6 rampage_03  //ST MARKS BEHIND TONI'S
CREATE_PICKUP killfrenzy PICKUP_ONCE  883.3 -806.2 15.0 rampage_04  //BEHIND BUILDING CHINATOWN NEAR BRIDGE
CREATE_PICKUP killfrenzy PICKUP_ONCE 1274.7 -742.7 15.0 rampage_05  //IN ALLEY NEAR DOG FOOD FACTORY
CREATE_PICKUP killfrenzy PICKUP_ONCE 1195.3 -497.9 39.3 rampage_06  //ON TOP TRAIN TRACKS BY HOSPITAL

CREATE_PICKUP killfrenzy PICKUP_ONCE  204.1 -1237.4 45.1 rampage_07  //ON ROOF ON AMCO BUILDING COMMERCIAL
CREATE_PICKUP killfrenzy PICKUP_ONCE  -22.1 -1526.9 26.1 rampage_08  //CARPARK AREA OPPOSITE LOVES BUILDING
CREATE_PICKUP killfrenzy PICKUP_ONCE    8.0  -910.0 26.5 rampage_09  //SOUTH WEST CORNER OF PARK
CREATE_PICKUP killfrenzy PICKUP_ONCE  181.1  -338.2 16.5 rampage_10  //BEHIND UNIVERSITY	SOUTH
CREATE_PICKUP killfrenzy PICKUP_ONCE  -57.5 -1070.8 26.3 rampage_11  //IN GRAVEYARD BY CATHEDRAL
CREATE_PICKUP killfrenzy PICKUP_ONCE  392.9  -795.4 31.3 rampage_12  //BETWEEN OVERPASS LANES NEAR ASUKA'S KENDO
CREATE_PICKUP killfrenzy PICKUP_ONCE  -41.6  -451.8 16.6 rampage_13  //BEHIND FIRESTATION

CREATE_PICKUP killfrenzy PICKUP_ONCE -585.4  284.7 64.0 rampage_14  //BEHIND A GARAGE IN THE MANSION AREA SUBURBIA
CREATE_PICKUP killfrenzy PICKUP_ONCE -560.3  -23.6  9.3 rampage_15  //ONTOP OF A GARAGE IN THE PROJECTS AREA UNDER OVERPASS
CREATE_PICKUP killfrenzy PICKUP_ONCE -867.0 -145.4 49.8 rampage_16  //ONTOP OF WAREHOUSE PIKE CREEK AIRPORT END
CREATE_PICKUP killfrenzy PICKUP_ONCE -705.9 -617.5 16.4 rampage_17  //BEHIND BILLBOARD AT AIRPORT
CREATE_PICKUP killfrenzy PICKUP_ONCE -987.7 -206.1 33.6 rampage_18  //BEHIND A GUARD BOX SOUTH PIKE CREEK
CREATE_PICKUP killfrenzy PICKUP_ONCE -1186.3  41.0 68.8 rampage_19  //BEHIND BOX IN THE BAIT WAREHOUSE
CREATE_PICKUP killfrenzy PICKUP_ONCE -431.6  110.9 15.6 rampage_20  //BEHIND BILLBOARD NORTH PROJECTS

SET_TOTAL_NUMBER_OF_KILL_FRENZIES 20

rampage_01_kills = 30
rampage_02_kills = 13
rampage_03_kills = 20
rampage_04_kills = 25
rampage_05_kills = 20
rampage_06_kills = 10
rampage_07_kills = 17
rampage_08_kills = 25
rampage_09_kills = 8
rampage_10_kills = 15
rampage_11_kills = 30
rampage_12_kills = 16
rampage_13_kills = 25
rampage_14_kills = 20
rampage_15_kills = 20
rampage_16_kills = 15
rampage_17_kills = 20
rampage_18_kills = 7
rampage_19_kills = 15
rampage_20_kills = 20

//START_KILL_FRENZY StartMessage WeaponType TimeLimit TargetNumber PedOrCarModel ExtraModel1 ExtraModel2 ExtraModel3 FrenzyText
//				   | TEXT LABEL	|		   | MILLISEC |		  	  |	-1 ALL PEDS	 |									 | True	- Has Kill Frenzy text
//				   | 			|		   |		  |			  |	-2 ALL CARS	 |		-1 TO IGNORE THESE			 | False - No text

rampage_pickup_loop:

WAIT 500

//IF IS_GERMAN_GAME
//OR IS_FRENCH_GAME
//	GOTO german_rampage_over
//ENDIF

IF rampage_01_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_01
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_M16 120000 rampage_01_kills PED_GANG_DIABLO_A PED_GANG_DIABLO_B -1 -1 FALSE // "Murder 20 Diablos in 120 seconds!"
		REQUEST_MODEL PED_GANG_DIABLO_A
		REQUEST_MODEL PED_GANG_DIABLO_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_DIABLO
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_01 rampage_01_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_01_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5
			REMOVE_PICKUP rampage_01
			IF rampage_01_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 987.6 -907.3 15.3 rampage_01  //NEXT TO FUZZBALL
				rampage_01_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE 958.0 -431.0 14.5 rampage_01  //OPPOSITE LUIGI'S IN AN ALLEYWAY
				rampage_01_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_02_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_02
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_ROCKET 120000 rampage_02_kills -2 -1 -1 -1 FALSE // "Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_02 rampage_02_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_02_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5
			REMOVE_PICKUP rampage_02
			IF rampage_02_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 982.4 -1009.4 14.9 rampage_02  //EAST OF GREASY JOES
				rampage_02_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1076.9 -859.9 15.2 rampage_02  //BOTTOM OF CALAHAN BRIDGE
				rampage_02_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_03_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_03
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_CHAINGUN 120000 rampage_03_kills PED_GANG_MAFIA_A PED_GANG_MAFIA_B -1 -1 FALSE // "Kill 20 Mafia in 120 seconds!"
		REQUEST_MODEL PED_GANG_MAFIA_A
		REQUEST_MODEL PED_GANG_MAFIA_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_MAFIA
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_03 rampage_03_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_03_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5
			IF rampage_03_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1209.5 -380.1 25.5 rampage_03  //JUST SOUTH OF TONI'S BEHIND WALL
				rampage_03_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1312.3 -315.7 42.6 rampage_03  //ST MARKS BEHIND TONI'S			
				rampage_03_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_04_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_04
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_UZI 120000 rampage_04_kills PED_GANG_TRIAD_A PED_GANG_TRIAD_B -1 -1 FALSE // "Kill 20 Triads in 120 seconds!"
		REQUEST_MODEL PED_GANG_TRIAD_A
		REQUEST_MODEL PED_GANG_TRIAD_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_TRIAD
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_04 rampage_04_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_04_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_04_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1253.9 -572.9 12.5 rampage_04  //SUPASAVE
				rampage_04_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  883.3 -806.2 15.0 rampage_04  //BEHIND BUILDING CHINATOWN NEAR BRIDGE
				rampage_04_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_05_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_05
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_SHOTGUN 120000 rampage_05_kills PED_GANG_TRIAD_A PED_GANG_TRIAD_B -1 -1 FALSE // "Kill 20 Triads in 120 seconds!"
		REQUEST_MODEL PED_GANG_TRIAD_A
		REQUEST_MODEL PED_GANG_TRIAD_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_TRIAD
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_05 rampage_05_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_05_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_05_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1179.2 -566.0 27.3 rampage_05  //ON TOP OF HOSPITAL ROOF
				rampage_05_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1274.7 -742.7 15.0 rampage_05  //IN ALLEY NEAR DOG FOOD FACTORY
				rampage_05_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_06_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_06
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_GRENADE 120000 rampage_06_kills -2 -1 -1 -1 FALSE // "Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_06 rampage_06_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_06_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_06_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1124.6 -816.8 26.5 rampage_06  //ON TOP OF TRAIN TRACKS NEAR FUZZ BALL
				rampage_06_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE 1195.3 -497.9 39.3 rampage_06  //ON TOP TRAIN TRACKS BY HOSPITAL
				rampage_06_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_07_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_07
		flag_player_on_mission = 1
		START_KILL_FRENZY_HEADSHOT PAGE_00 WEAPONTYPE_SNIPERRIFLE 120000 rampage_07_kills PED_GANG_YARDIE_A PED_GANG_YARDIE_B -1 -1 FALSE // "Pop 20 Yardie heads in 120 seconds!"
		REQUEST_MODEL PED_GANG_YARDIE_A
		REQUEST_MODEL PED_GANG_YARDIE_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_YARDIE
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_07 rampage_07_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_07_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_07_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  440.3 -1391.2 44.2 rampage_07  //ON TOP OF CASINO
				rampage_07_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  204.1 -1237.4 45.1 rampage_07  //ON ROOF ON AMCO BUILDING COMMERCIAL
				rampage_07_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_08_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_08
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_FLAMETHROWER 120000 rampage_08_kills PED_GANG_YAKUZA_A PED_GANG_YAKUZA_B -1 -1 FALSE // "Burn 20 Yakuza in 120 seconds!"
		REQUEST_MODEL PED_GANG_YAKUZA_A
		REQUEST_MODEL PED_GANG_YAKUZA_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_YAKUZA
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_08 rampage_08_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_08_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_08_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -22.7 -1116.7 26.1 rampage_08  //SOUTH END OF CATHEDRAL
				rampage_08_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -22.1 -1526.9 26.1 rampage_08  //CARPARK AREA OPPOSITE LOVES BUILDING
				rampage_08_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_09_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_09
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_SHOTGUN 120000 rampage_09_kills -2 -1 -1 -1 FALSE // "Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_09 rampage_09_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_09_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_09_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE 134.2 -552.8 26.0 rampage_09  //NORTH EAST CORNER OF PARK
				rampage_09_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE   8.0  -910.0 26.5 rampage_09  //SOUTH WEST CORNER OF PARK
				rampage_09_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_10_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_10
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_M16 120000 rampage_10_kills -2 -1 -1 -1 FALSE // "Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_10 rampage_10_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_10_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_10_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  434.3 -147.8 20.9 rampage_10  //IN CONTRUCTION YARD NE
				rampage_10_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE   181.1  -338.2 16.5 rampage_10  //BEHIND UNIVERSITY	SOUTH
				rampage_10_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_11_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_11
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_ROCKET 120000 rampage_11_kills PED_GANG_YARDIE_A PED_GANG_YARDIE_B -1 -1 FALSE // "Annihialate 20 Yardies in 120 seconds!"
		REQUEST_MODEL PED_GANG_YARDIE_A
		REQUEST_MODEL PED_GANG_YARDIE_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_YARDIE
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_11 rampage_11_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_11_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_11_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -101.4 -1386.8 26.3 rampage_11  //BY LIBERTY TREE BUILDING
				rampage_11_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE   -57.5 -1070.8 26.3 rampage_11  //IN GRAVEYARD BY CATHEDRAL
				rampage_11_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_12_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_12
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_MOLOTOV 120000 rampage_12_kills PED_GANG_YAKUZA_A PED_GANG_YAKUZA_B -1 -1 FALSE // "Torch 20 Yakuza in 120 seconds!"
		REQUEST_MODEL PED_GANG_YAKUZA_A
		REQUEST_MODEL PED_GANG_YAKUZA_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_YAKUZA
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_12 rampage_12_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_12_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_12_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  374.4  -609.4 26.7 rampage_12  //BEHIND MULTISTOREY
				rampage_12_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  392.9  -795.4 31.3 rampage_12  //BETWEEN OVERPASS LANES NEAR ASUKA'S KENDO
				rampage_12_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_13_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_13
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_GRENADE 120000 rampage_13_kills PED_GANG_YARDIE_A PED_GANG_YARDIE_B -1 -1 FALSE // "Explode 20 Yardies in 120 seconds!"
		REQUEST_MODEL PED_GANG_YARDIE_A
		REQUEST_MODEL PED_GANG_YARDIE_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_YARDIE
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_13 rampage_13_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_13_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_13_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  176.8  -360.1 16.2 rampage_13  //ALLEYWAY BETWEEN STADIUM AND PARK
				rampage_13_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE   -41.6  -451.8 16.6 rampage_13  //BEHIND FIRESTATION
				rampage_13_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_14_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_14
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_FLAMETHROWER 120000 rampage_14_kills PED_GANG_COLOMBIAN_A PED_GANG_COLOMBIAN_B -1 -1 FALSE // "Fry 20 Colombians in 120 seconds!"
		REQUEST_MODEL PED_GANG_COLOMBIAN_A
		REQUEST_MODEL PED_GANG_COLOMBIAN_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_COLOMBIAN
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_14 rampage_14_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_14_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_14_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -1149.2 160.5 58.9 rampage_14  //NORTH PIKE CREEK IN WAREHOUSE COURTYARD
				rampage_14_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -585.4  284.7 64.0 rampage_14  //BEHIND A GARAGE IN THE MANSION AREA SUBURBIA
				rampage_14_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_15_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_15
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_SHOTGUN 120000 rampage_15_kills PED_GANG_HOOD_A PED_GANG_HOOD_B -1 -1 FALSE // "Splatter 20 Hoods in 120 seconds!"
		REQUEST_MODEL PED_GANG_HOOD_A
		REQUEST_MODEL PED_GANG_HOOD_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_HOOD
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_15 rampage_15_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_15_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_15_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -632.1 -413.8 18.0 rampage_15  //BEHIND BILLBOARD NEAR AIRPORT
				rampage_15_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -560.3  -23.6  9.3 rampage_15  //ONTOP OF A GARAGE IN THE PROJECTS AREA UNDER OVERPASS
				rampage_15_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_16_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_16
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_ROCKET 120000 rampage_16_kills -2 -1 -1 -1 FALSE // "Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_16 rampage_16_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_16_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_16_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -939.0 -303.3 33.6 rampage_16  //BEHIND BILLBOARD BETWEEN AIRPORT & PIKE CREEK
				rampage_16_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -867.0 -145.4 49.8 rampage_16  //ONTOP OF WAREHOUSE PIKE CREEK AIRPORT END
				rampage_16_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_17_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_17
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_RUNOVERBYCAR 120000 rampage_17_kills PED_GANG_COLOMBIAN_A PED_GANG_COLOMBIAN_B -1 -1 FALSE // "Splatter 20 Colombians with a car in 120 seconds!"
		REQUEST_MODEL PED_GANG_COLOMBIAN_A
		REQUEST_MODEL PED_GANG_COLOMBIAN_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_COLOMBIAN
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_17 rampage_17_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_17_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_17_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -1181.9 -264.8 46.0 rampage_17  //IN GRASSY HILLY AREA NORTH OF AIRPORT
				rampage_17_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -705.9 -617.5 16.4 rampage_17  //BEHIND BILLBOARD AT AIRPORT
				rampage_17_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_18_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_18
		flag_player_on_mission = 1
		START_KILL_FRENZY PAGE_00 WEAPONTYPE_UZI_DRIVEBY 120000 rampage_18_kills -2 -1 -1 -1 FALSE // "Driveby and Destroy 20 vehicles in 120 seconds!"
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_18 rampage_18_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status

//		IF flag_done_drive_by_help = 0
//			GET_CONTROLLER_MODE	controlmode
//			IF controlmode = 0
//				PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
//				flag_done_drive_by_help = 1
//			ENDIF
//			IF controlmode = 1
//				PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
//				flag_done_drive_by_help = 1
//			ENDIF
//			IF controlmode = 2
//				PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
//				flag_done_drive_by_help = 1
//			ENDIF
//			IF controlmode = 3
//				PRINT_HELP ( DRIVE_B ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~R1 button~w~ to fire."
//				flag_done_drive_by_help = 1
//			ENDIF
//		ENDIF
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_18_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_18_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -1080.2 208.4 3.7 rampage_18  //BEHIND ROCK AT BOTTOM OF DAM
				rampage_18_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -987.7 -206.1 33.6 rampage_18  //BEHIND A GUARD BOX SOUTH PIKE CREEK
				rampage_18_failed = 0
			ENDIF
		ENDIF
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_19_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_19
		flag_player_on_mission = 1
		START_KILL_FRENZY_HEADSHOT PAGE_00 WEAPONTYPE_SNIPERRIFLE 120000 rampage_19_kills PED_GANG_COLOMBIAN_A PED_GANG_COLOMBIAN_B -1 -1 FALSE // "Remove 20 Colombian heads in 120 seconds!"
		REQUEST_MODEL PED_GANG_COLOMBIAN_A
		REQUEST_MODEL PED_GANG_COLOMBIAN_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_COLOMBIAN
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_19 rampage_19_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_19_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_19_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -1170.2 -42.2 59.2 rampage_19  //ONTOP OF ROOF SOUTH OF BAIT WAREHOUSE
				rampage_19_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -1186.3  41.0 68.8 rampage_19  //BEHIND BOX IN THE BAIT WAREHOUSE
				rampage_19_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF rampage_20_flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED rampage_20
		flag_player_on_mission = 1
		START_KILL_FRENZY_HEADSHOT PAGE_00 WEAPONTYPE_M16 120000 rampage_20_kills PED_GANG_HOOD_A PED_GANG_HOOD_B -1 -1 FALSE // "Behead 20 Hoods in 120 seconds!"
		REQUEST_MODEL PED_GANG_HOOD_A
		REQUEST_MODEL PED_GANG_HOOD_B
		FORCE_RANDOM_PED_TYPE PEDTYPE_GANG_HOOD
		PRINT_BIG RAMPAGE 5000 5
		PRINT_WITH_NUMBER_BIG PAGE_20 rampage_20_kills 6000 6
		READ_KILL_FRENZY_STATUS frenzy_status
		
		WHILE frenzy_status = 1
			WAIT 0
			READ_KILL_FRENZY_STATUS frenzy_status
		ENDWHILE

		IF frenzy_status = 2
			rampage_20_flag = 1
			GOSUB rampage_rewards
		ENDIF

		IF frenzy_status = 3
			PRINT_BIG RAMP_F 5000 5			
			IF rampage_20_failed = 0
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -798.4 126.0 29.0 rampage_20  //BEHIND BILLBOARD NW PROJECTS
				rampage_20_failed = 1
			ELSE
				CREATE_PICKUP killfrenzy PICKUP_ONCE  -431.6  110.9 15.6 rampage_20  //BEHIND BILLBOARD NORTH PROJECTS
				rampage_20_failed = 0
			ENDIF
		ENDIF
		FORCE_RANDOM_PED_TYPE -1
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_A
		MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_B
		flag_player_on_mission = 0
	ENDIF
ENDIF

IF total_rampages_passed = 20
	GOTO rampage_passed
ENDIF

GOTO rampage_pickup_loop

rampage_passed:

MISSION_HAS_FINISHED

//german_rampage_over:

PLAYER_MADE_PROGRESS 1
MISSION_END


rampage_rewards:

	++ total_rampages_passed
	rampage_reward = total_rampages_passed * 5000
	CLEAR_WANTED_LEVEL player
	
	IF total_rampages_passed < 20
		ADD_SCORE player rampage_reward			
		PRINT_BIG RAMP_P 5000 5
		PRINT_WITH_NUMBER_BIG REWARD rampage_reward	6000 6
	ELSE
		ADD_SCORE player 1000000			
		PRINT_BIG RAMP_A 5000 5	//"ALL RAMPAGES COMPLETED!"
		PRINT_WITH_NUMBER_BIG REWARD 1000000 6000 6
	ENDIF

RETURN

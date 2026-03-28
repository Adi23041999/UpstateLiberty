MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Deablo mission 3**************************************
// ***********************************BURN, BURN THEM ALL!!!!*********************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_diablo3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_diablo3_failed
ENDIF

GOSUB mission_cleanup_diablo3

MISSION_END

// Variables for mission

//VAR_INT countdown_diablo3 // On screen countdown timer

//VAR_INT counter1_dm3

VAR_INT counter_diablo3 // Counts up number of mission triads killed

VAR_INT burn_man1 burn_man2 burn_man3 burn_man4 burn_man5 burn_man6 

VAR_INT dead_burn_man1 dead_burn_man2 dead_burn_man3 dead_burn_man4 dead_burn_man5 dead_burn_man6

VAR_INT blip1_diablo3 flamethrower_diablo3

VAR_INT all_gang_created_before	traid_threat_cleared_D3

VAR_INT CurrentStatus given_money_before

// ***************************************Mission Start*************************************

mission_start_diablo3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_diablo_mission = 1
SCRIPT_NAME diablo3
WAIT 0


REQUEST_MODEL PED_GANG_TRIAD_A
REQUEST_MODEL PED_GANG_TRIAD_B

traid_threat_cleared_D3 = 0

{

SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA_OF_CHARS 890.3 -309.1 0.0 1038.1 -132.9 10.0


LOAD_CUTSCENE EL_PH4
SET_CUTSCENE_OFFSET 938.27 -229.561 4.023
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player


DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( DIAB3_A ) 10000 1 

WHILE cs_time < 5553
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_B ) 10000 1 

WHILE cs_time < 7767
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_C ) 10000 1 

WHILE cs_time < 11105
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_D ) 10000 1 

WHILE cs_time < 14603
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_E ) 10000 1 

WHILE cs_time < 17813
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_F ) 10000 1 

WHILE cs_time < 22948
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB3_G ) 10000 1 

WHILE cs_time < 23775
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 26333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE



DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

WAIT 500

DO_FADE 1500 FADE_IN

SET_PED_DENSITY_MULTIPLIER 1.0
						  
SETUP_ZONE_PED_INFO CHINA DAY (30) 0 650 0 (0 0 0 0) 0  
SETUP_ZONE_PED_INFO CHINA NIGHT (30) 0 650 0 (0 0 0 0) 0      


// START MISSION

all_gang_created_before = 0
counter_diablo3 = 0
dead_burn_man1 = 0
dead_burn_man2 = 0
dead_burn_man3 = 0
dead_burn_man4 = 0
dead_burn_man5 = 0
dead_burn_man6 = 0
given_money_before = 0


IF IS_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
	CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
	traid_threat_cleared_D3 = 1
ENDIF

RESET_NUM_OF_MODELS_KILLED_BY_PLAYER

CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ONCE 0 879.2 -810.0 -100.0 flamethrower_diablo3     
ADD_SPRITE_BLIP_FOR_COORD 879.2 -810.0 -100.0 RADAR_SPRITE_WEAPON blip1_diablo3
//CHANGE_BLIP_DISPLAY blip1_diablo3 BLIP_ONLY

WHILE NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
OR NOT HAS_MODEL_LOADED	PED_GANG_TRIAD_B
	WAIT 0

ENDWHILE

WHILE NOT HAS_PICKUP_BEEN_COLLECTED flamethrower_diablo3 
	WAIT 0

ENDWHILE

REMOVE_BLIP blip1_diablo3

START_KILL_FRENZY (DIAB3_1) WEAPONTYPE_FLAMETHROWER 151000 25 PED_GANG_TRIAD_A PED_GANG_TRIAD_B -1 -1 FALSE

Diablo3_loop:

WAIT 0

READ_KILL_FRENZY_STATUS CurrentStatus

	IF CurrentStatus = 2
		GOTO mission_diablo3_passed
	ENDIF

	IF CurrentStatus = 3
		GOTO mission_diablo3_failed
	ENDIF

	IF IS_PLAYER_IN_AREA_2D player 1038.0 -781.0 838.0 -915.0 FALSE

		IF all_gang_created_before = 0
			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 932.0 -846.0 14.5 burn_man1
			GIVE_WEAPON_TO_CHAR burn_man1 WEAPONTYPE_PISTOL 60

			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 933.0 -846.0 14.5 burn_man2
			GIVE_WEAPON_TO_CHAR burn_man2 WEAPONTYPE_PISTOL 60
			SET_CHAR_AS_LEADER burn_man2 burn_man1

			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 934.0 -846.0 14.5 burn_man3
			GIVE_WEAPON_TO_CHAR burn_man3 WEAPONTYPE_PISTOL 60
			SET_CHAR_AS_LEADER burn_man3 burn_man1
			
			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 935.0 -846.0 14.5 burn_man4
			GIVE_WEAPON_TO_CHAR burn_man4 WEAPONTYPE_PISTOL 60
			SET_CHAR_AS_LEADER burn_man4 burn_man1

			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 936.0 -846.0 14.5 burn_man5
			GIVE_WEAPON_TO_CHAR burn_man5 WEAPONTYPE_PISTOL 60
			SET_CHAR_AS_LEADER burn_man5 burn_man1

			CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 937.0 -846.0 14.5 burn_man6
			GIVE_WEAPON_TO_CHAR burn_man6 WEAPONTYPE_PISTOL 60
			SET_CHAR_AS_LEADER burn_man6 burn_man1

			all_gang_created_before = 1
		ENDIF
		

		IF IS_CHAR_DEAD burn_man1 
		AND dead_burn_man1 = 0
			++ counter_diablo3
			dead_burn_man1 = 1	
		ENDIF

		IF IS_CHAR_DEAD burn_man2 
		AND dead_burn_man2 = 0
			++ counter_diablo3
			dead_burn_man2 = 1	
		ENDIF

		IF IS_CHAR_DEAD burn_man3 
		AND dead_burn_man3 = 0
			++ counter_diablo3
			dead_burn_man3 = 1	
		ENDIF

		IF IS_CHAR_DEAD burn_man4 
		AND dead_burn_man4 = 0
			++ counter_diablo3
			dead_burn_man4 = 1	
		ENDIF

		IF IS_CHAR_DEAD burn_man5 
		AND dead_burn_man5 = 0
			++ counter_diablo3
			dead_burn_man5 = 1	
		ENDIF

		IF IS_CHAR_DEAD burn_man6 
		AND dead_burn_man6 = 0
			++ counter_diablo3
			dead_burn_man6 = 1	
		ENDIF

		IF counter_diablo3 = 6
		AND given_money_before = 0
			ADD_SCORE player 6000
			GET_PLAYER_COORDINATES Player player_X player_Y player_Z
			ADD_ONE_OFF_SOUND player_X player_Y player_Z SOUND_PART_MISSION_COMPLETE
			given_money_before = 1
		ENDIF
		
		IF IS_PLAYER_SHOOTING_IN_AREA Player 916.0 -863.0 956.0 -830.0 FALSE
		OR IS_PLAYER_IN_AREA_2D player 916.0 -863.0 956.0 -830.0 FALSE

			IF dead_burn_man1 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man1 Player
			ENDIF
			IF dead_burn_man2 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man2 Player
			ENDIF
			IF dead_burn_man3 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man3 Player
			ENDIF
			IF dead_burn_man4 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man4 Player
			ENDIF
			IF dead_burn_man5 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man5 Player
			ENDIF
			IF dead_burn_man6 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT burn_man6 Player
			ENDIF			
		ENDIF

	ENDIF

READ_KILL_FRENZY_STATUS CurrentStatus

GOTO Diablo3_loop


}
 // Mission toni1 failed

mission_diablo3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission toni1 passed

mission_diablo3_passed:

flag_diablo_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED	DIAB3
PLAYER_MADE_PROGRESS 1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
START_NEW_SCRIPT diablo_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_diablo3:

flag_player_on_mission = 0
flag_player_on_diablo_mission = 0
REMOVE_BLIP blip1_diablo3
REMOVE_PICKUP flamethrower_diablo3
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
    SETUP_ZONE_PED_INFO CHINA DAY   (20) 0 200 0 (0 0 0 0) 20 //China town 
    SETUP_ZONE_PED_INFO CHINA NIGHT (10) 0 300 0 (0 0 0 0) 10
IF traid_threat_cleared_D3 = 1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
ENDIF
MISSION_HAS_FINISHED
RETURN

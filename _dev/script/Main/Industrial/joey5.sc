MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 5****************************************
// *********************************Dead Skunk in the Trunk***********************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_joey5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey5_failed
ENDIF

GOSUB mission_cleanup_joey5

MISSION_END


// Variables for mission


VAR_INT deadman_car blip1_j5 blip2_j5
 
VAR_INT lipsbrother1_car lipsbrother2_car is_lipsbrother1_car_dead is_lipsbrother2_car_dead

VAR_INT lipsbrother1 lipsbrother2 skunk_message_played_before

VAR_INT flag_car_blip_displayed_j5 flag_car_crushed_joey5

VAR_INT on_new_objective_joey5_1 on_new_objective_joey5_2 

VAR_INT flag_dont_do_car_check_joey5 flag_leave_car_message_joey5 flag_car_in_area_joey5

// ***************************************Mission Start*************************************

mission_start_joey5:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
SCRIPT_NAME joey5
WAIT 0

skunk_message_played_before = 0
flag_dont_do_car_check_joey5 = 0
flag_leave_car_message_joey5 = 0
flag_car_in_area_joey5 = 0

{

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_MODEL cut_obj1 JOEYH
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL cut_obj3 TROLL
REQUEST_MODEL CAR_IDAHO
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint

//LOAD_SCENE 1190.07 -869.86 13.97

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
OR NOT HAS_MODEL_LOADED CAR_IDAHO
	WAIT 0
ENDWHILE


LOAD_CUTSCENE J5_DST
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CAR CAR_IDAHO 1182.5 -857.0 14.1 cut_car2_lm3
SET_CAR_HEADING cut_car2_lm3 291.2

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ1 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT CUT_OBJ3 cs_troll
SET_CUTSCENE_ANIM cs_troll TROLL
									   	
CLEAR_AREA 1191.9 -870.4 15.0 1.0 TRUE
SET_PLAYER_COORDINATES player 1191.9 -870.4 -100.0

SET_PLAYER_HEADING player 230.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 1250
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM5_A ) 10000 2 // Mission brief

WHILE cs_time < 5658
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM5_B ) 10000 2 // Mission brief

WHILE cs_time < 8419
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM5_C ) 10000 2 // Mission brief

WHILE cs_time < 12522
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM5_D ) 10000 2 // Mission brief

WHILE cs_time < 16368
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM5_E ) 10000 2 // Mission brief

WHILE cs_time < 18855
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 20000
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

DELETE_CAR cut_car2_lm3

on_new_objective_joey5_1 = 0
on_new_objective_joey5_2 = 0
is_lipsbrother1_car_dead = 0
is_lipsbrother2_car_dead = 0
flag_car_blip_displayed_j5 = TRUE
flag_car_crushed_joey5 = 0

REQUEST_MODEL PED_GANG_MAFIA_B
REQUEST_MODEL CAR_CORPSE
REQUEST_MODEL CAR_SENTINEL

	WHILE NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
	OR NOT HAS_MODEL_LOADED CAR_CORPSE
	OR NOT HAS_MODEL_LOADED CAR_SENTINEL
		WAIT 0
	ENDWHILE	

// START OF MISSION

CREATE_CAR CAR_CORPSE 867.2 -992.8 -100.0 deadman_car
ADD_BLIP_FOR_CAR deadman_car blip1_j5

CREATE_CAR CAR_SENTINEL 892.0 -992.3 4.6 lipsbrother1_car
SET_CAR_HEADING lipsbrother1_car 90.0
SET_CAR_STRONG lipsbrother1_car	TRUE
CREATE_CHAR_INSIDE_CAR lipsbrother1_car PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B lipsbrother1
GIVE_WEAPON_TO_CHAR lipsbrother1 WEAPONTYPE_PISTOL 60
CAR_SET_IDLE  lipsbrother1_car
LOCK_CAR_DOORS lipsbrother1_car CARLOCK_LOCKED
SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother1_car TRUE

CREATE_CAR CAR_SENTINEL 800.0 -961.9 -100.0 lipsbrother2_car
SET_CAR_HEADING lipsbrother2_car 241.0
SET_CAR_STRONG lipsbrother2_car	TRUE
CREATE_CHAR_INSIDE_CAR lipsbrother2_car PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B lipsbrother2
GIVE_WEAPON_TO_CHAR lipsbrother2 WEAPONTYPE_PISTOL 60
CAR_SET_IDLE  lipsbrother2_car
LOCK_CAR_DOORS lipsbrother2_car CARLOCK_LOCKED
SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother2_car TRUE

	WHILE NOT IS_PLAYER_IN_CAR player deadman_car
		WAIT 0

		IF IS_CAR_DEAD deadman_car
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey5_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN deadman_car
		AND IS_CAR_STOPPED deadman_car
			PRINT_NOW ( WRECKED ) 5000 1
   			GOTO mission_joey5_failed
   		ENDIF

		IF IS_CHAR_DEAD lipsbrother1
		AND is_lipsbrother1_car_dead = 0
			ADD_SCORE player 5000 
			is_lipsbrother1_car_dead = 1
		ENDIF

		IF IS_CHAR_DEAD lipsbrother2
		AND is_lipsbrother2_car_dead = 0
			ADD_SCORE player 5000 
			is_lipsbrother2_car_dead = 1
		ENDIF

		IF NOT IS_CAR_DEAD lipsbrother1_car
			IF NOT IS_CAR_HEALTH_GREATER lipsbrother1_car 999
				PRINT_NOW ( JM5_2 ) 5000 1 // Gosh! it's the Forelis! 
				GOTO kill_the_player
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD lipsbrother2_car
			IF NOT IS_CAR_HEALTH_GREATER lipsbrother2_car 999
				PRINT_NOW ( JM5_2 ) 5000 1 // Gosh! it's the Forelis! 
				GOTO kill_the_player
			ENDIF
		ENDIF

	ENDWHILE 

SET_POLICE_IGNORE_PLAYER Player ON
SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 863.389 -988.698 4.350 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 864.217 -989.236 4.507 JUMP_CUT
SET_PED_DENSITY_MULTIPLIER 0.0

PRINT_NOW ( JM5_2 ) 5000 1 // Gosh! it's the Forelis! 

WAIT 1500

	IF NOT IS_CHAR_DEAD lipsbrother1
		IF NOT IS_CAR_DEAD lipsbrother1_car
			SET_CAR_MISSION lipsbrother1_car MISSION_RAMPLAYER_FARAWAY
			SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother1_car FALSE
			SET_CAR_CRUISE_SPEED lipsbrother1_car 40.0
			SET_CAR_DRIVING_STYLE lipsbrother1_car 2
			SET_CHAR_THREAT_SEARCH lipsbrother1 THREAT_PLAYER1
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD lipsbrother2
		IF NOT IS_CAR_DEAD lipsbrother2_car
			SET_CAR_MISSION lipsbrother2_car MISSION_BLOCKPLAYER_FARAWAY
			SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother2_car FALSE
			SET_CAR_CRUISE_SPEED lipsbrother2_car 40.0
			SET_CAR_DRIVING_STYLE lipsbrother2_car 2
			SET_CHAR_THREAT_SEARCH lipsbrother2 THREAT_PLAYER1
		ENDIF
	ENDIF

WAIT 1500

SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER Player OFF
SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

kill_the_player:
		
		IF NOT IS_CHAR_DEAD lipsbrother1
			IF NOT IS_CAR_DEAD lipsbrother1_car
				SET_CAR_MISSION lipsbrother1_car MISSION_RAMPLAYER_FARAWAY
				SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother1_car FALSE
				SET_CAR_CRUISE_SPEED lipsbrother1_car 40.0
				SET_CAR_DRIVING_STYLE lipsbrother1_car 2
				SET_CHAR_THREAT_SEARCH lipsbrother1 THREAT_PLAYER1
			ENDIF
		ENDIF
		
		IF NOT IS_CHAR_DEAD lipsbrother2
			IF NOT IS_CAR_DEAD lipsbrother2_car
				SET_CAR_MISSION lipsbrother2_car MISSION_RAMPLAYER_FARAWAY
				SET_CAR_ONLY_DAMAGED_BY_PLAYER lipsbrother2_car FALSE
				SET_CAR_CRUISE_SPEED lipsbrother2_car 40.0
				SET_CAR_DRIVING_STYLE lipsbrother2_car 2
				SET_CHAR_THREAT_SEARCH lipsbrother2 THREAT_PLAYER1
			ENDIF
		ENDIF

ADD_BLIP_FOR_COORD 1139.0 54.5.0 -100.0 blip2_j5
	   
//	char_dead1 = 0
//	char_dead2 = 0

REMOVE_BLIP blip2_j5

blob_flag = 1

car_not_quite_under_crane:
	WAIT 0

	IF IS_CAR_DEAD deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ENDIF

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D deadman_car 1135.8 55.5 -1.0 1149.8 46.3 30.0 blob_flag
	WAIT 0

	GOSUB skunk_car_check
	
	IF IS_CAR_DEAD deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ELSE
		
		IF IS_CAR_IN_AREA_3D deadman_car 1135.8 55.5 -1.0 1149.8 46.3 30.0 FALSE
			flag_dont_do_car_check_joey5 = 1
		
			IF flag_leave_car_message_joey5 = 0
				PRINT_NOW ( OUT_VEH ) 4000 1 //"Get out of the car!"
				flag_leave_car_message_joey5 = 1
			ENDIF

		ELSE
			flag_leave_car_message_joey5 = 0
			flag_dont_do_car_check_joey5 = 0
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN deadman_car
	AND IS_CAR_STOPPED deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ENDIF

	IF flag_dont_do_car_check_joey5 = 0
		IF NOT IS_CAR_DEAD deadman_car
			IF IS_PLAYER_IN_CAR player deadman_car
				IF flag_car_blip_displayed_j5 = TRUE
					ADD_BLIP_FOR_COORD 1139.0 54.5.0 -100.0 blip2_j5
					CHANGE_BLIP_DISPLAY blip2_j5 BLIP_ONLY
					REMOVE_BLIP blip1_j5
					flag_car_blip_displayed_j5 = FALSE
					blob_flag = 1
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player deadman_car
				IF flag_car_blip_displayed_j5 = FALSE
					ADD_BLIP_FOR_CAR deadman_car blip1_j5
					REMOVE_BLIP blip2_j5
					PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
					flag_car_blip_displayed_j5 = TRUE
					blob_flag = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF flag_player_had_crusher_help_hm5 = 0
	
		IF LOCATE_PLAYER_ANY_MEANS_2D player 1140.3 50.1 20.0 20.0 FALSE
			IF IS_PLAYER_IN_CAR player deadman_car
				PRINT_HELP ( CRUSH ) //"To crush the car..."
				flag_player_had_crusher_help_hm5 = 1
			ENDIF
		ENDIF

	ENDIF

	IF IS_PLAYER_IN_CAR player deadman_car
	AND skunk_message_played_before = 0
		PRINT_NOW ( JM5_1 ) 4000 1 // Take it to the crusher
		skunk_message_played_before = 1
	ENDIF

ENDWHILE


	IF IS_CAR_DEAD deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ENDIF

	blob_flag = 1


WHILE NOT IS_CRANE_LIFTING_CAR 1120.0 46.0 deadman_car
	WAIT 0

	GOSUB skunk_car_check
	
	IF IS_CAR_DEAD deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ENDIF
		
	IF IS_CAR_UPSIDEDOWN deadman_car
	AND IS_CAR_STOPPED deadman_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey5_failed
	ENDIF

	IF IS_CAR_STOPPED_IN_AREA_3D deadman_car 1135.8 55.5 -1.0 1149.8 46.3 20.0 blob_flag
		flag_car_in_area_joey5 = 1
	ELSE
		flag_car_in_area_joey5 = 0
	ENDIF

	IF flag_car_in_area_joey5 = 0
		IF NOT IS_CAR_DEAD deadman_car
			IF IS_PLAYER_IN_CAR player deadman_car
				IF flag_car_blip_displayed_j5 = TRUE
					ADD_BLIP_FOR_COORD 1139.0 54.5.0 -100.0 blip2_j5
					CHANGE_BLIP_DISPLAY blip2_j5 BLIP_ONLY
					REMOVE_BLIP blip1_j5
					flag_car_blip_displayed_j5 = FALSE
					blob_flag = 1
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player deadman_car
				IF flag_car_blip_displayed_j5 = FALSE
					ADD_BLIP_FOR_CAR deadman_car blip1_j5
					REMOVE_BLIP blip2_j5
					PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
					flag_car_blip_displayed_j5 = TRUE
					blob_flag = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ENDWHILE

REMOVE_BLIP blip1_j5
REMOVE_BLIP blip2_j5
CLEAR_PRINTS

WHILE NOT IS_CAR_CRUSHED deadman_car
								 
		GOSUB skunk_car_check

		IF IS_CAR_DEAD deadman_car
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey5_failed
		ENDIF
		
		IF IS_CAR_CRUSHED deadman_car
			GOTO mission_joey5_passed	
		ENDIF
			
		IF IS_CAR_UPSIDEDOWN deadman_car
		AND IS_CAR_STOPPED deadman_car
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey5_failed
		ENDIF

	 	WAIT 0
ENDWHILE


GOTO mission_joey5_passed

}

 // Mission joey5 failed

mission_joey5_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission joey5 passed

mission_joey5_passed:

flag_joey_mission5_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000 
REGISTER_MISSION_PASSED	JM5
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT joey_mission6_loop
RETURN
		


// mission cleanup

mission_cleanup_joey5:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
REMOVE_BLIP blip1_j5
REMOVE_BLIP blip2_j5
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CORPSE
IF NOT IS_CAR_DEAD lipsbrother1_car
	LOCK_CAR_DOORS lipsbrother1_car CARLOCK_UNLOCKED 
ENDIF
IF NOT IS_CAR_DEAD lipsbrother2_car
	LOCK_CAR_DOORS lipsbrother2_car CARLOCK_UNLOCKED 
ENDIF 
MISSION_HAS_FINISHED
RETURN

// *********************************************************

skunk_car_check:
{
					
	IF IS_CHAR_DEAD lipsbrother1
	AND is_lipsbrother1_car_dead = 0
		ADD_SCORE player 5000 
		is_lipsbrother1_car_dead = 1
	ENDIF

	IF IS_CHAR_DEAD lipsbrother2
	AND is_lipsbrother2_car_dead = 0
		ADD_SCORE player 5000 
		is_lipsbrother2_car_dead = 1
	ENDIF

	IF NOT IS_CAR_DEAD lipsbrother1_car

		IF IS_CAR_UPSIDEDOWN lipsbrother1_car
		AND IS_CAR_STOPPED lipsbrother1_car
		AND on_new_objective_joey5_1 = 0
			IF NOT IS_CHAR_DEAD	lipsbrother1
				LOCK_CAR_DOORS lipsbrother1_car CARLOCK_UNLOCKED
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lipsbrother1 Player
			ENDIF
			on_new_objective_joey5_1 = 1
		ENDIF

		IF IS_CAR_IN_AREA_2D lipsbrother1_car 1122.7 2.9 1183.8 111.9 FALSE
		AND on_new_objective_joey5_1 = 0
			IF NOT IS_CHAR_DEAD	lipsbrother1
				LOCK_CAR_DOORS lipsbrother1_car CARLOCK_UNLOCKED
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lipsbrother1 Player
			ENDIF
			on_new_objective_joey5_1 = 1
		ENDIF

	ENDIF

	IF NOT IS_CAR_DEAD lipsbrother2_car

		IF IS_CAR_UPSIDEDOWN lipsbrother2_car
		AND IS_CAR_STOPPED lipsbrother2_car
		AND on_new_objective_joey5_2 = 0
			IF NOT IS_CHAR_DEAD	lipsbrother2
				LOCK_CAR_DOORS lipsbrother2_car CARLOCK_UNLOCKED
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lipsbrother2 Player
			ENDIF
			on_new_objective_joey5_2 = 1
		ENDIF

		IF NOT IS_CAR_DEAD lipsbrother2_car
			IF IS_CAR_IN_AREA_2D lipsbrother2_car 1122.7 2.9 1183.8 111.9 FALSE
			AND on_new_objective_joey5_1 = 0
				IF NOT IS_CHAR_DEAD	lipsbrother2
					LOCK_CAR_DOORS lipsbrother2_car CARLOCK_UNLOCKED
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lipsbrother2 Player
				ENDIF
				on_new_objective_joey5_1 = 1
			ENDIF
		ENDIF

	ENDIF

RETURN
}



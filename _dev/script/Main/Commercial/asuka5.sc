MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************asuka mission 5******************************** 
// ********************************************Kill Tanner**********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_asuka5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_asuka5_failed
ENDIF

GOSUB mission_cleanup_asuka5

MISSION_END
 
// Variables for mission

VAR_INT blip1_as5 blip2_as5 blip3_as5

VAR_INT tanner_car got_to_coord_once old_tanner_health

VAR_INT tanner	cleared_timer_once_asuka5

VAR_INT test_tanner_health_counter test_tanner_health_counter2

VAR_FLOAT test_tanner_health_float

// ****************************************Mission Start************************************

mission_start_asuka5:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_asuka_mission = 1
SCRIPT_NAME asuka5
WAIT 0

SET_MAX_WANTED_LEVEL 5

cleared_timer_once_asuka5 = 0
got_to_coord_once = 0

{

LOAD_SPECIAL_MODEL cut_obj2	NOTE
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
REQUEST_MODEL condo_ivy
REQUEST_MODEL kmricndo01


LOAD_ALL_MODELS_NOW
 
WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED condo_ivy
OR NOT HAS_MODEL_LOADED	kmricndo01
	WAIT 0

ENDWHILE


LOAD_CUTSCENE A5_K2FT
SET_CUTSCENE_OFFSET 523.102 -636.96 15.616

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT cut_obj2 cs_note
SET_CUTSCENE_ANIM cs_note NOTE

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 523.6 -639.4 16.6 1.0 TRUE
SET_PLAYER_COORDINATES player 523.6 -639.4 16.0

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 2220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM5_A ) 10000 1 

WHILE cs_time < 4363
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM5_B ) 10000 1 

WHILE cs_time < 11558
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM5_C ) 10000 1 

WHILE cs_time < 16227
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM5_D ) 10000 1 

WHILE cs_time < 17342
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 17666
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

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED condo_ivy
MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01

REQUEST_MODEL CAR_ESPERANTO
LOAD_SPECIAL_CHARACTER 1 tanner
		    
	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1 
	OR NOT HAS_MODEL_LOADED CAR_ESPERANTO
		WAIT 0
	ENDWHILE

	LOAD_MISSION_AUDIO A5_A

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE


//START MISSION

CREATE_CAR CAR_ESPERANTO 420.9 -1396.5 26.0 tanner_car //TEST INDUSTRIAL!!!!!!!!!
SET_CAR_HEADING tanner_car 90.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER tanner_car TRUE
LOCK_CAR_DOORS tanner_car CARLOCK_LOCKOUT_PLAYER_ONLY
SET_CAR_STAYS_IN_CURRENT_LEVEL tanner_car TRUE
SET_CAR_AVOID_LEVEL_TRANSITIONS tanner_car TRUE

ADD_BLIP_FOR_COORD 414.0 -1378.0 -100.0 blip1_as5
CHANGE_BLIP_DISPLAY blip1_as5 BLIP_ONLY

	WHILE NOT IS_PLAYER_STOPPED_IN_AREA_3D Player 411.8 -1375.3 25.6 417.0 -1381.9 28.6 TRUE
		WAIT 0

			IF IS_CAR_DEAD tanner_car
				GOTO mission_asuka5_failed	
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER tanner_car 999
			OR NOT IS_CAR_IN_AREA_2D tanner_car	417.1 -1398.0 425.4 -1394.9 FALSE
				PRINT_NOW ( AM5_1 ) 5000 1
				GOTO mission_asuka5_failed 
			ENDIF


	ENDWHILE

REMOVE_BLIP blip1_as5

ADD_BLIP_FOR_CAR tanner_car blip2_as5

SET_PLAYER_CONTROL Player Off
CLEAR_AREA 427.9 -1392.7 21.1 20.0 TRUE
SET_POLICE_IGNORE_PLAYER Player On
SWITCH_WIDESCREEN ON

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 436.5 -1399.8 33.7 tanner	//TEST INDUSTRIAL!!!!!!!!
SET_CHAR_RUNNING tanner TRUE

SET_FIXED_CAMERA_POSITION 437.4 -1387.4 30.9 0.0 0.0 0.0 //TEST INDUSTRIAL!!!!!!!!
POINT_CAMERA_AT_CHAR tanner FIXED JUMP_CUT

TIMERB = 0
SET_CHAR_OBJ_RUN_TO_COORD tanner 435.7 -1388.8

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED tanner
		WAIT 0

			IF IS_CHAR_DEAD tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
				GOTO mission_asuka5_failed	
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES tanner 435.7 -1388.8 -100.0
				ENDIF
			ENDIF

	ENDWHILE

TIMERB = 0
SET_CHAR_OBJ_RUN_TO_COORD tanner 423.5 -1388.8

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED tanner
		WAIT 0

			IF IS_CHAR_DEAD tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
				GOTO mission_asuka5_failed	
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES tanner 427.3 -1388.6 25.0
				ENDIF
			ENDIF

	ENDWHILE

TIMERB = 0
SET_CHAR_OBJ_RUN_TO_COORD tanner 423.6 -1393.1

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED tanner
		WAIT 0

			IF IS_CHAR_DEAD tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
				GOTO mission_asuka5_failed	
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES tanner 423.6 -1393.1 25.0
				ENDIF
			ENDIF

	ENDWHILE


SET_FIXED_CAMERA_POSITION 436.0 -1390.8 31.0 0.0 0.0 0.0 //TEST INDUSTRIAL!!!!!!!!
POINT_CAMERA_AT_CHAR tanner FIXED INTERPOLATION

SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER tanner tanner_car

	WHILE NOT IS_CHAR_IN_CAR tanner tanner_car 
		 WAIT 0
		   
			IF IS_CHAR_DEAD tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
				GOTO mission_asuka5_failed	
			ENDIF

	ENDWHILE

	IF IS_CHAR_DEAD tanner
		GOTO mission_asuka5_passed
	ENDIF


CLEAR_AREA 427.9 -1392.7 21.1 20.0 TRUE
POINT_CAMERA_AT_CAR tanner_car FIXED INTERPOLATION

DISPLAY_ONSCREEN_COUNTER_WITH_STRING test_tanner_health_counter COUNTER_DISPLAY_BAR (DAM)

GOSUB tanner_health

CAR_GOTO_COORDINATES_ACCURATE tanner_car 319.9 -1388.6 -100.0
SET_CAR_MISSION tanner_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE
SET_CAR_CRUISE_SPEED tanner_car 20.0
SET_CAR_DRIVING_STYLE tanner_car 2

WAIT 1000

	RESTORE_CAMERA_JUMPCUT
	SET_PLAYER_CONTROL Player ON
	SET_POLICE_IGNORE_PLAYER Player OFF
	SWITCH_WIDESCREEN OFF

IF NOT IS_CAR_DEAD tanner_car

	WHILE IS_CAR_HEALTH_GREATER tanner_car 999
		WAIT 0

			IF IS_CHAR_DEAD tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
			AND cleared_timer_once_asuka5 = 0
				CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
				cleared_timer_once_asuka5 = 1	
			ENDIF

			IF NOT LOCATE_CAR_2D tanner_car 319.9 -1388.6 8.0 8.0 FALSE
				IF got_to_coord_once = 0 
					CAR_GOTO_COORDINATES_ACCURATE tanner_car 319.9 -1388.6 -100.0
					SET_CAR_MISSION tanner_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE
				ENDIF
			ELSE
				CAR_WANDER_RANDOMLY tanner_car
				got_to_coord_once = 1
			ENDIF

			IF IS_CAR_UPSIDEDOWN tanner_car
			AND IS_CAR_STOPPED tanner_car
				GOTO tanner_shits_it
			ENDIF

			GOSUB tanner_health

	ENDWHILE

ENDIF

	IF IS_CHAR_DEAD tanner
		GOTO mission_asuka5_passed
	ENDIF

	IF IS_CAR_DEAD tanner_car
	AND cleared_timer_once_asuka5 = 0
		CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
		cleared_timer_once_asuka5 = 1	
	ENDIF

PLAY_MISSION_AUDIO
SET_CAR_CRUISE_SPEED tanner_car 30.0
ALTER_WANTED_LEVEL_NO_DROP Player 4

IF NOT IS_CAR_DEAD tanner_car
	GET_CAR_HEALTH tanner_car old_tanner_health
ENDIF

	WHILE IS_CAR_HEALTH_GREATER tanner_car 300
		WAIT 0
		
			IF IS_CHAR_DEAD	tanner
				GOTO mission_asuka5_passed
			ENDIF

			IF IS_CAR_DEAD tanner_car
			AND cleared_timer_once_asuka5 = 0
				CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
				cleared_timer_once_asuka5 = 1	
			ENDIF

			IF NOT LOCATE_CAR_2D tanner_car 319.9 -1388.6 6.0 6.0 FALSE
				IF got_to_coord_once = 0 
					CAR_GOTO_COORDINATES_ACCURATE tanner_car 319.9 -1388.6 -100.0
					SET_CAR_MISSION tanner_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE
				ENDIF
			ELSE
				CAR_WANDER_RANDOMLY tanner_car
				got_to_coord_once = 1
			ENDIF

			IF IS_CAR_UPSIDEDOWN tanner_car
			AND IS_CAR_STOPPED tanner_car
				GOTO tanner_shits_it
			ENDIF

			GOSUB tanner_health

	ENDWHILE

tanner_shits_it:

	IF IS_CHAR_DEAD tanner
		GOTO mission_asuka5_passed
	ENDIF

	CLEAR_ONSCREEN_COUNTER test_tanner_health_counter

REMOVE_BLIP blip2_as5
LOCK_CAR_DOORS tanner_car CARLOCK_UNLOCKED
SET_CHAR_OBJ_LEAVE_CAR tanner tanner_car
ADD_BLIP_FOR_CHAR tanner blip3_as5
SET_CAR_CRUISE_SPEED tanner_car 0.0
SET_CAR_MISSION tanner_car MISSION_STOP_FOREVER

	WHILE IS_CHAR_IN_CAR tanner tanner_car 
	 	WAIT 0
	 	
 		IF IS_CHAR_DEAD	tanner
			GOTO mission_asuka5_passed
		ENDIF  

		IF IS_CAR_DEAD tanner_car
		AND cleared_timer_once_asuka5 = 0
			CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
			cleared_timer_once_asuka5 = 1	
		ENDIF
		
	ENDWHILE

	IF IS_CHAR_DEAD tanner
		GOTO mission_asuka5_passed
	ENDIF

	SET_CHAR_ONLY_DAMAGED_BY_PLAYER tanner True

	IF IS_CAR_DEAD tanner_car
	AND cleared_timer_once_asuka5 = 0
		CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
		cleared_timer_once_asuka5 = 1	
	ENDIF

SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS tanner Player
SET_ANIM_GROUP_FOR_CHAR tanner ANIM_PANIC_CHUNKYPED 

	WHILE NOT IS_CHAR_DEAD tanner 
		WAIT 0

		IF IS_CAR_DEAD tanner_car
		AND cleared_timer_once_asuka5 = 0
			CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
			cleared_timer_once_asuka5 = 1	
		ENDIF

	ENDWHILE


GOTO mission_asuka5_passed

}	   		

// Mission asuka5 failed

mission_asuka5_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission asuka5 passed

mission_asuka5_passed:

flag_asuka_mission5_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 20000
REMOVE_BLIP asuka_contact_blip
REGISTER_MISSION_PASSED	AM5
PLAYER_MADE_PROGRESS 1
RETURN
		


// mission cleanup

mission_cleanup_asuka5:

flag_player_on_mission = 0
flag_player_on_asuka_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ESPERANTO
UNLOAD_SPECIAL_CHARACTER 1
IF NOT IS_CHAR_DEAD	tanner
	REMOVE_CHAR_ELEGANTLY tanner
ENDIF
REMOVE_BLIP blip1_as5
REMOVE_BLIP blip2_as5
REMOVE_BLIP blip3_as5
CLEAR_ONSCREEN_COUNTER test_tanner_health_counter
MISSION_HAS_FINISHED
RETURN
		


tanner_health:

{

IF NOT IS_CAR_DEAD tanner_car
	GET_CAR_HEALTH tanner_car test_tanner_health_counter

	IF test_tanner_health_counter < old_tanner_health
		ALTER_WANTED_LEVEL_NO_DROP Player 4
	ENDIF 

	old_tanner_health = test_tanner_health_counter

	test_tanner_health_counter2 = 1000 - test_tanner_health_counter

	IF test_tanner_health_counter2 > 700
	    test_tanner_health_counter2 = 700
	ENDIF

	test_tanner_health_counter = test_tanner_health_counter2 / 7

ENDIF

RETURN

}
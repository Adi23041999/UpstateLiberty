MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************A ride in the Park******************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_4x4two
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_4x4two_failed
ENDIF
GOSUB mission_cleanup_4x4two
MISSION_END

// Variables for mission

//VAR_INT player_4x4_two
//VAR_INT counter_4x4_pickups timer_4x4 
//VAR_INT wanted_4x4
//VAR_INT intro_time_lapsed timer_intro_now timer_intro_start flag_intro
//VAR_INT flag_timer
/*
VAR_INT blip_1 blip_2 blip_3
VAR_INT blip_4 blip_5 blip_6
VAR_INT blip_7 blip_8 blip_9
VAR_INT blip_10 blip_11 blip_12

VAR_INT flag_blip_1 flag_blip_2 flag_blip_3 flag_blip_4 
VAR_INT flag_blip_5 flag_blip_6 flag_blip_7 flag_blip_8 
VAR_INT flag_blip_9 flag_blip_10 flag_blip_11 flag_blip_12

//variables called in 4x4_1.sc

VAR_FLOAT x_1 y_1 z_1 
VAR_FLOAT x_2 y_2 z_2 
VAR_FLOAT x_3 y_3 z_3 
VAR_FLOAT x_4 y_4 z_4 
VAR_FLOAT x_5 y_5 z_5 
VAR_FLOAT x_6 y_6 z_6 
VAR_FLOAT x_7 y_7 z_7 
VAR_FLOAT x_8 y_8 z_8 
VAR_FLOAT x_9 y_9 z_9 
VAR_FLOAT x_10 y_10 z_10 
VAR_FLOAT x_11 y_11 z_11 
VAR_FLOAT x_12 y_12 z_12 
*/

// ****************************************Mission Start************************************

mission_start_4x4two:
REGISTER_MISSION_GIVEN
SCRIPT_NAME t4x4_2 
flag_player_on_mission = 1
//flag_player_on_4x4_mission = 1

PRINT_BIG ( T4X4_2 ) 15000 2

WAIT 0

//Set Variables

counter_4x4_pickups = 0
timer_4x4 = 0
flag_intro = 0
flag_4x4two_trigger = 1
flag_timer = 0
flag_intro_jump = 0

flag_blip_1 = 0
flag_blip_2 = 0
flag_blip_3 = 0
flag_blip_4 = 0
flag_blip_5 = 0
flag_blip_6 = 0
flag_blip_7 = 0
flag_blip_8 = 0
flag_blip_9 = 0
flag_blip_10 = 0
flag_blip_11 = 0
flag_blip_12 = 0

record_temp = 0

//Set Coords

x_1 = 6.52
y_1 = -701.37
z_1 = 29.0

x_2 = 6.53
y_2 = -745.1
z_2 = 29.0

x_3 = 51.87
y_3 = -605.19
z_3 = 25.94

x_4 = 52.85
y_4 = -639.2
z_4 = 28.55

x_5 = 53.89
y_5 = -885.37
z_5 = 31.95

x_6 = 81.66
y_6 = -779.26
z_6 = 26.65

x_7 = 64.26
y_7 = -777.5
z_7 = 25.74

x_8 = 90.30
y_8 = -732.48
z_8 = 31.23

x_9 = 83.48
y_9 = -724.55
z_9 = 31.6

x_10 = 39.61
y_10 = -724.42
z_10 = 22.77

x_11 = 11.63
y_11 = -743.12
z_11 = 28.54

x_12 = 68.55
y_12 = -773.13
z_12 = 22.92

//Mission Script 

STORE_WANTED_LEVEL player wanted_4x4
CLEAR_WANTED_LEVEL player
STORE_CAR_PLAYER_IS_IN player player_4x4 
IF NOT IS_CAR_DEAD player_4x4
	LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
ENDIF
SET_PLAYER_CONTROL player off
SWITCH_WIDESCREEN on 
 
		
ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1
ADD_BLIP_FOR_COORD x_2 y_2 z_2 blip_2
ADD_BLIP_FOR_COORD x_3 y_3 z_3 blip_3
ADD_BLIP_FOR_COORD x_4 y_4 z_4 blip_4
ADD_BLIP_FOR_COORD x_5 y_5 z_5 blip_5
ADD_BLIP_FOR_COORD x_6 y_6 z_6 blip_6
ADD_BLIP_FOR_COORD x_7 y_7 z_7 blip_7
ADD_BLIP_FOR_COORD x_8 y_8 z_8 blip_8
ADD_BLIP_FOR_COORD x_9 y_9 z_9 blip_9
ADD_BLIP_FOR_COORD x_10 y_10 z_10 blip_10
ADD_BLIP_FOR_COORD x_11 y_11 z_11 blip_11
ADD_BLIP_FOR_COORD x_12 y_12 z_12 blip_12

WHILE counter_4x4_pickups < 12

	WAIT 0

	IF counter_4x4_pickups = 1
	AND flag_timer = 0
		DISPLAY_ONSCREEN_TIMER timer_4x4
		flag_timer = 1
	ENDIF

	IF flag_blip_1 = 0
		DRAW_CORONA x_1 y_1 z_1 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_1 y_1 z_1 2.5 2.5 3.5 false
			REMOVE_BLIP blip_1
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_1 y_1 z_1 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_1 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_2 = 0
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_2 y_2 z_2 2.5 2.5 3.5 false
			REMOVE_BLIP blip_2
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_2 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_3 = 0
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_3 y_3 z_3 2.5 2.5 3.5 false
			REMOVE_BLIP blip_3
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_3 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_4 = 0
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_4 y_4 z_4 2.5 2.5 3.5 false
			REMOVE_BLIP blip_4
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_4 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_5 = 0
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_5 y_5 z_5 2.5 2.5 3.5 false
			REMOVE_BLIP blip_5
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_5 y_5 z_5 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_5 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_6 = 0
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_6 y_6 z_6 2.5 2.5 3.5 false
			REMOVE_BLIP blip_6
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_6 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_7 = 0
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_7 y_7 z_7 2.5 2.5 3.5 false
			REMOVE_BLIP blip_7
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_7 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_8 = 0
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_8 y_8 z_8 2.5 2.5 3.5 false
			REMOVE_BLIP blip_8
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_8 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_9 = 0
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_9 y_9 z_9 2.5 2.5 3.5 false
			REMOVE_BLIP blip_9
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_9 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_10 = 0
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_10 y_10 z_10 2.5 2.5 3.5 false
			REMOVE_BLIP blip_10
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_10 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_11 = 0
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_11 y_11 z_11 2.5 2.5 3.5 false
			REMOVE_BLIP blip_11
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_11 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_12 = 0
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_12 y_12 z_12 2.5 2.5 3.5 false
			REMOVE_BLIP blip_12
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 10000
			flag_blip_12 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_2B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_intro2_before = 1
		IF flag_intro_jump = 0
		AND flag_intro < 5
			IF IS_BUTTON_PRESSED PAD1 CROSS
				intro_time_lapsed = 10501
				flag_intro = 4
				flag_intro_jump = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		SET_FIXED_CAMERA_POSITION 50.48 -727.5 27.0 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		//WAIT 1500
		LOAD_SCENE 50.48 -727.5 27.0
		POINT_CAMERA_AT_POINT x_8 y_8 z_8 JUMP_CUT
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		//WAIT 1500
		PRINT_NOW (T4X4_2A) 5000 1
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF
	
	IF intro_time_lapsed > 3500
	AND flag_intro = 1
		POINT_CAMERA_AT_POINT x_9 y_9 z_9 INTERPOLATION
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 6500
	AND flag_intro = 2
	   PRINT_NOW (T4X4_2C) 5500 1
	   flag_intro = 3
	ENDIF
	
	IF intro_time_lapsed > 7000
	AND flag_intro = 3
		POINT_CAMERA_AT_POINT x_10 y_10 z_10 INTERPOLATION
		flag_intro = 4
	ENDIF
	
	IF intro_time_lapsed > 10500
	AND flag_intro = 4
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		LOAD_SCENE 50.0 -930.0 20.0
		RESTORE_CAMERA_JUMPCUT 
		SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player on
		IF NOT IS_CAR_DEAD player_4x4
			LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
		ENDIF
		ALTER_WANTED_LEVEL player wanted_4x4
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		SET_MUSIC_DOES_FADE TRUE
		flag_intro = 5
		flag_intro2_before = 1
	ENDIF
	
	IF flag_timer = 1
		IF timer_4x4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_4x4two_failed
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_MODEL player CAR_LANDSTALKER
		PRINT_NOW (T4x4_F) 3000 1
		GOTO mission_4x4two_failed
	ENDIF

ENDWHILE

IF counter_4x4_pickups = 12
	GOTO mission_4x4two_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_4x4two_failed:


PRINT_BIG ( M_FAIL ) 2000 1


RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_4x4two_passed:

IF flag_4x4_mission2_passed = 0
	record_4x4_two = 120000 - timer_4x4
	record_4x4_two = record_4x4_two / 1000
ENDIF

IF flag_4x4_mission2_passed = 1
	record_temp = 120000 - timer_4x4
	record_temp = record_temp / 1000
	
	IF record_temp < record_4x4_two
		record_4x4_two = record_temp
	ENDIF
ENDIF


PRINT_WITH_NUMBER_BIG ( M_PASS ) 30000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
//PRINT_WITH_NUMBER_NOW (Y1_1ST) counter_player_points 4000 1
CLEAR_WANTED_LEVEL player
ADD_SCORE player 30000
REGISTER_4X4_TWO_TIME record_4x4_two

IF flag_4x4_mission2_passed = 0
	REGISTER_MISSION_PASSED T4X4_2
	flag_4x4_mission2_passed = 1
	PLAYER_MADE_PROGRESS 1 
ENDIF
//START_NEW_SCRIPT t4x4_mission3_loop

RETURN
		


// mission cleanup

mission_cleanup_4x4two:
CLEAR_ONSCREEN_TIMER timer_4x4

RESTORE_CAMERA_JUMPCUT 
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on

REMOVE_BLIP blip_1
REMOVE_BLIP blip_2
REMOVE_BLIP blip_3
REMOVE_BLIP blip_4
REMOVE_BLIP blip_5
REMOVE_BLIP blip_6
REMOVE_BLIP blip_7
REMOVE_BLIP blip_8
REMOVE_BLIP blip_9
REMOVE_BLIP blip_10
REMOVE_BLIP blip_11
REMOVE_BLIP blip_12


flag_player_on_mission = 0
//flag_player_on_4x4_mission = 0


MISSION_HAS_FINISHED
RETURN

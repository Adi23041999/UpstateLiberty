MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************4x4 by Far**************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_4x4one
GOSUB mission_cleanup_4x4one
MISSION_END

// Variables for mission

VAR_INT player_4x4
VAR_INT counter_4x4_pickups timer_4x4
VAR_INT wanted_4x4 flag_timer
VAR_INT intro_time_lapsed timer_intro_now timer_intro_start flag_intro
VAR_INT flag_intro_jump

VAR_INT flag_blip_1 flag_blip_2 flag_blip_3 flag_blip_4 
VAR_INT flag_blip_5 flag_blip_6 flag_blip_7 flag_blip_8 
VAR_INT flag_blip_9 flag_blip_10 flag_blip_11 flag_blip_12
VAR_INT flag_blip_13 flag_blip_14 flag_blip_15 flag_blip_16
VAR_INT flag_blip_17 flag_blip_18 flag_blip_19 flag_blip_20

VAR_INT blip_1 blip_2 blip_3 blip_4 
VAR_INT blip_5 blip_6 blip_7 blip_8 
VAR_INT blip_9 blip_10 blip_11 blip_12
VAR_INT blip_13 blip_14 blip_15 blip_16
VAR_INT blip_17 blip_18 blip_19 blip_20

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
VAR_FLOAT x_13 y_13 z_13 
VAR_FLOAT x_14 y_14 z_14 
VAR_FLOAT x_15 y_15 z_15 
VAR_FLOAT x_16 y_16 z_16 
VAR_FLOAT x_17 y_17 z_17 
VAR_FLOAT x_18 y_18 z_18 
VAR_FLOAT x_19 y_19 z_19 
VAR_FLOAT x_20 y_20 z_20 


// ****************************************Mission Start************************************

mission_start_4x4one:
REGISTER_MISSION_GIVEN
SCRIPT_NAME t4x4_1 
flag_player_on_mission = 1
//flag_player_on_4x4_mission = 1

PRINT_BIG (T4X4_1) 5000 2

WAIT 0

//Set Variables

counter_4x4_pickups = 0
timer_4x4 = 0
flag_intro = 0
flag_timer = 0
flag_4x4one_trigger = 1
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
flag_blip_13 = 0
flag_blip_14 = 0
flag_blip_15 = 0

record_temp = 0

//Set Coords

x_1 = 1391.7
y_1 = -135.0
z_1 = 54.8
x_2 = 1428.7
y_2 = -350.53
z_2 = 39.82
x_3 = 1473.0
y_3 = -602.5
z_3 = 3.2
x_4 = 1508.74
y_4 = -150.43
z_4 = 40.31
x_5 = 1417.4
y_5 = -108.22
z_5 = 46.04
x_6 = 1619.44
y_6 = -263.8
z_6 = 27.49
x_7 = 1414.36
y_7 = -58.32
z_7 = 25.68
x_8 = 1481.34
y_8 = -146.62
z_8 = 26.85
x_9 = 1547.19
y_9 = -196.93
z_9 = 18.45
x_10 = 1557.45
y_10 = -60.88
z_10 = 17.62
x_11 = 1436.13
y_11 = -210.94
z_11 = 31.74
x_12 = 1520.62
y_12 = -293.49
z_12 = 3.03
x_13 = 1417.28
y_13 = -571.96
z_13 = 20.0
x_14 = 1423.66
y_14 = -488.49
z_14 = 36.57
x_15 = 1320.99
y_15 = -541.66
z_15 = 37.82

//Mission Script 

STORE_WANTED_LEVEL player wanted_4x4
CLEAR_WANTED_LEVEL player
STORE_CAR_PLAYER_IS_IN player player_4x4
IF NOT IS_CAR_DEAD player_4x4
	LOCK_CAR_DOORS player_4x4 CARLOCK_LOCKED
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
ADD_BLIP_FOR_COORD x_13 y_13 z_13 blip_13
ADD_BLIP_FOR_COORD x_14 y_14 z_14 blip_14
ADD_BLIP_FOR_COORD x_15 y_15 z_15 blip_15

WHILE counter_4x4_pickups < 15

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
			timer_4x4 = timer_4x4 + 20000
			flag_blip_1 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_2 = 0
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_2 y_2 z_2 2.5 2.5 3.5 false
			REMOVE_BLIP blip_2
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_2 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_3 = 0
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_3 y_3 z_3 2.5 2.5 3.5 false
			REMOVE_BLIP blip_3
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_3 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_4 = 0
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_4 y_4 z_4 2.5 2.5 3.5 false
			REMOVE_BLIP blip_4
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_4 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_5 = 0
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_5 y_5 z_5 2.5 2.5 3.5 false
			REMOVE_BLIP blip_5
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_5 y_5 z_5 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_5 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_6 = 0
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_6 y_6 z_6 2.5 2.5 3.5 false
			REMOVE_BLIP blip_6
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_6 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_7 = 0
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_7 y_7 z_7 2.5 2.5 3.5 false
			REMOVE_BLIP blip_7
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_7 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_8 = 0
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_8 y_8 z_8 2.5 2.5 3.5 false
			REMOVE_BLIP blip_8
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_8 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_9 = 0
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_9 y_9 z_9 2.5 2.5 3.5 false
			REMOVE_BLIP blip_9
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_9 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_10 = 0
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_10 y_10 z_10 2.5 2.5 3.5 false
			REMOVE_BLIP blip_10
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_10 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_11 = 0
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_11 y_11 z_11 2.5 2.5 3.5 false
			REMOVE_BLIP blip_11
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_11 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_12 = 0
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_12 y_12 z_12 2.5 2.5 3.5 false
			REMOVE_BLIP blip_12
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_12 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_13 = 0
		DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_13 y_13 z_13 2.5 2.5 3.5 false
			REMOVE_BLIP blip_13
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_13 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_14 = 0
		DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_14 y_14 z_14 2.5 2.5 3.5 false
			REMOVE_BLIP blip_14
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_14 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_blip_15 = 0
		DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_15 y_15 z_15 2.5 2.5 3.5 false
			REMOVE_BLIP blip_15
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 20000
			flag_blip_15 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_1B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_intro1_before = 1
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
		SET_FIXED_CAMERA_POSITION 1458.0 -564.0 28.0 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		LOAD_SCENE 1458.0 -564.0 28.0
		POINT_CAMERA_AT_POINT x_3 y_3 z_3 JUMP_CUT
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PRINT_NOW (T4X4_1A) 5500 1 
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF

	IF intro_time_lapsed > 3500
	AND flag_intro = 1
		POINT_CAMERA_AT_POINT x_14 y_14 z_14 INTERPOLATION
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 6500
	AND flag_intro = 2
	   PRINT_NOW (T4X4_1C) 5500 1
	   flag_intro = 3
	ENDIF

	IF intro_time_lapsed > 7000
	AND flag_intro = 3
		POINT_CAMERA_AT_POINT x_13 y_13 z_13 INTERPOLATION
		//PRINT_NOW (T4X4_1C) 5500 1
		flag_intro = 4
	ENDIF
	
	IF intro_time_lapsed > 10500
	AND flag_intro = 4
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		LOAD_SCENE 1301.0 -650.0 12.0
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
		flag_intro1_before = 1
	ENDIF
	
	IF flag_timer = 1
		IF timer_4x4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_4x4one_failed
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_MODEL player CAR_PATRIOT
		PRINT_NOW (T4x4_F) 3000 1
		GOTO mission_4x4one_failed
	ENDIF

ENDWHILE

IF counter_4x4_pickups = 15
	GOTO mission_4x4one_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_4x4one_failed:


PRINT_BIG ( M_FAIL ) 2000 1


RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_4x4one_passed:

IF flag_4x4_mission1_passed = 0
	record_4x4_one = 300000 - timer_4x4
	record_4x4_one = record_4x4_one / 1000
ENDIF

IF flag_4x4_mission1_passed = 1
	record_temp = 300000 - timer_4x4
	record_temp = record_temp / 1000
	
	IF record_temp < record_4x4_one
		record_4x4_one = record_temp
	ENDIF
ENDIF


PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 20000
REGISTER_4X4_ONE_TIME record_4x4_one
IF flag_4x4_mission1_passed = 0
	REGISTER_MISSION_PASSED T4X4_1
	flag_4x4_mission1_passed = 1
	PLAYER_MADE_PROGRESS 1 

ENDIF

//START_NEW_SCRIPT t4x4_mission2_loop
//START_NEW_SCRIPT multistorey_mission_loop

RETURN
		


// mission cleanup

mission_cleanup_4x4one:

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
REMOVE_BLIP blip_13
REMOVE_BLIP blip_14
REMOVE_BLIP blip_15

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on

CLEAR_ONSCREEN_TIMER timer_4x4
flag_player_on_mission = 0
//flag_player_on_4x4_mission = 0

MISSION_HAS_FINISHED
RETURN

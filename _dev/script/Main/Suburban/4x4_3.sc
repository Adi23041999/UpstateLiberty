MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************GRIPPED, SORTED*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_4x4three
GOSUB mission_cleanup_4x4three
MISSION_END

// Variables for mission

//VAR_INT player_4x4_three
//VAR_INT counter_4x4_pickups timer_4x4
//VAR_INT flag_timer_patriot
//VAR_INT intro_time_lapsed timer_intro_now timer_intro_start flag_intro
/*
VAR_INT blip_1 blip_2 blip_3
VAR_INT blip_4 blip_5 blip_6
VAR_INT blip_7 blip_8 blip_9
VAR_INT blip_10 blip_11 blip_12
VAR_INT blip_13 blip_14 blip_15

VAR_INT flag_blip_17 flag_blip_2 flag_blip_3 flag_blip_4 
VAR_INT flag_blip_5 flag_blip_6 flag_blip_7 flag_blip_8 
VAR_INT flag_blip_9 flag_blip_10 flag_blip_11 flag_blip_12
VAR_INT flag_blip_13 flag_blip_14 flag_blip_15 flag_blip_16

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
*/

// ****************************************Mission Start************************************

mission_start_4x4three:
REGISTER_MISSION_GIVEN
SCRIPT_NAME t4x4_3 
flag_player_on_mission = 1
//flag_player_on_4x4_mission = 1

PRINT_BIG (T4X4_3) 5000 2

WAIT 0

//Set Variables

counter_4x4_pickups = 0
timer_4x4 = 0
flag_intro = 0
flag_timer = 0
flag_4x4three_trigger = 1
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
flag_blip_16 = 0
flag_blip_17 = 0
flag_blip_18 = 0
flag_blip_19 = 0
flag_blip_20 = 0

record_temp = 0

//Set Coords

x_1 = -236.5
y_1 = 188.8
z_1 = 11.6

x_2 = -288.6
y_2 = 153.7
z_2 = 8.4

x_3 = -346.8
y_3 = 158.0
z_3 = 25.0

x_4 = -399.8
y_4 = 194.6
z_4 = 50.7

x_5 = -389.4 
y_5 = 195.7
z_5 = 50.3

x_6 = -335.9
y_6 = 202.2
z_6 = 54.7

x_7 = -445.3
y_7 = 205.6
z_7 = 63.8

x_8 = -296.9
y_8 = 262.4
z_8 = 66.7

x_9 = -210.2
y_9 = 399.9
z_9 = 98.3

x_10 = -187.6
y_10 = 557.6
z_10 = 141.6

x_11 = -230.1
y_11 = 609.3
z_11 = 138.2

x_12 = -393.5
y_12 = 502.8
z_12 = 150.3

x_13 = -526.5
y_13 = 497.2
z_13 = 165.4

x_14 = -393.2
y_14 = 403.8
z_14 = 133.9

x_15 = -499.4
y_15 = 407.9
z_15 = 116.2

x_16 = -686.6
y_16 = 386.3
z_16 = 103.1


x_17 = -744.4
y_17 = 507.8
z_17 = 159.0

x_18 = -814.9
y_18 = 563.1
z_18 = 120.5

x_19 = -879.9
y_19 = 585.7
z_19 = 94.0

x_20 = -829.3
y_20 = 412.3
z_20 = 93.5

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
ADD_BLIP_FOR_COORD x_13 y_13 z_13 blip_13
ADD_BLIP_FOR_COORD x_14 y_14 z_14 blip_14
ADD_BLIP_FOR_COORD x_15 y_15 z_15 blip_15
ADD_BLIP_FOR_COORD x_16 y_16 z_16 blip_16
ADD_BLIP_FOR_COORD x_17 y_17 z_17 blip_17
ADD_BLIP_FOR_COORD x_18 y_18 z_18 blip_18
ADD_BLIP_FOR_COORD x_19 y_19 z_19 blip_19
ADD_BLIP_FOR_COORD x_20 y_20 z_20 blip_20

WHILE counter_4x4_pickups < 20

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
			timer_4x4 = timer_4x4 + 15000
			flag_blip_1 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_2 = 0
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_2 y_2 z_2 2.5 2.5 3.5 false
			REMOVE_BLIP blip_2
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_2 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_3 = 0
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_3 y_3 z_3 2.5 2.5 3.5 false
			REMOVE_BLIP blip_3
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_3 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_4 = 0
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_4 y_4 z_4 2.5 2.5 3.5 false
			REMOVE_BLIP blip_4
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_4 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_5 = 0
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_5 y_5 z_5 2.5 2.5 3.5 false
			REMOVE_BLIP blip_5
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_5 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_6 = 0
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_6 y_6 z_6 2.5 2.5 3.5 false
			REMOVE_BLIP blip_6
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_6 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_7 = 0
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_7 y_7 z_7 2.5 2.5 3.5 false
			REMOVE_BLIP blip_7
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_7 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_8 = 0
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_8 y_8 z_8 2.5 2.5 3.5 false
			REMOVE_BLIP blip_8
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_8 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_9 = 0
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_9 y_9 z_9 2.5 2.5 3.5 false
			REMOVE_BLIP blip_9
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_9 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_10 = 0
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_10 y_10 z_10 2.5 2.5 3.5 false
			REMOVE_BLIP blip_10
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_10 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_11 = 0
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_11 y_11 z_11 2.5 2.5 3.5 false
			REMOVE_BLIP blip_11
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_11 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_12 = 0
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_12 y_12 z_12 2.5 2.5 3.5 false
			REMOVE_BLIP blip_12
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_12 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_13 = 0
		DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_13 y_13 z_13 2.5 2.5 3.5 false
			REMOVE_BLIP blip_13
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_13 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_14 = 0
		DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_14 y_14 z_14 2.5 2.5 3.5 false
			REMOVE_BLIP blip_14
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_14 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_blip_15 = 0
		DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_15 y_15 z_15 2.5 2.5 3.5 false
			REMOVE_BLIP blip_15
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_15 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_blip_16 = 0
		DRAW_CORONA x_16 y_16 z_16 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_16 y_16 z_16 2.5 2.5 3.5 false
			REMOVE_BLIP blip_16
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_16 y_16 z_16 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_16 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_17 = 0
		DRAW_CORONA x_17 y_17 z_17 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_17 y_17 z_17 2.5 2.5 3.5 false
			REMOVE_BLIP blip_17
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_17 y_17 z_17 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_17 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_18 = 0
		DRAW_CORONA x_18 y_18 z_18 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_18 y_18 z_18 2.5 2.5 3.5 false
			REMOVE_BLIP blip_18
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_18 y_18 z_18 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_18 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_19 = 0
		DRAW_CORONA x_19 y_19 z_19 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_19 y_19 z_19 2.5 2.5 3.5 false
			REMOVE_BLIP blip_19
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_19 y_19 z_19 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_19 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_20 = 0
		DRAW_CORONA x_20 y_20 z_20 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_20 y_20 z_20 2.5 2.5 3.5 false
			REMOVE_BLIP blip_20
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_20 y_20 z_20 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 15000
			flag_blip_20 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_intro3_before = 1
		IF flag_intro_jump = 0
		AND flag_intro < 4
			IF IS_BUTTON_PRESSED PAD1 CROSS
				intro_time_lapsed = 8501
				flag_intro = 3
				flag_intro_jump = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		SET_FIXED_CAMERA_POSITION -328.0 132.0 25.0 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		LOAD_SCENE -328.0 132.0 25.0
		POINT_CAMERA_AT_POINT x_2 y_2 z_2 JUMP_CUT
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PRINT_NOW (T4X4_3A) 5000 1 
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF
	
	IF intro_time_lapsed > 4500
	AND flag_intro = 1
		POINT_CAMERA_AT_POINT x_3 y_3 z_3 INTERPOLATION
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 6000
	AND flag_intro = 2
		POINT_CAMERA_AT_POINT x_4 y_4 z_4 INTERPOLATION
		PRINT_NOW (T4X4_3B) 5000 1
		flag_intro = 3
	ENDIF
	
	IF intro_time_lapsed > 8500
	AND flag_intro = 3
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		LOAD_SCENE -230.0 270.0 20.0
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
		flag_intro = 4
		flag_intro3_before = 1
	ENDIF
	
	IF flag_timer = 1
		IF timer_4x4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_4x4three_failed
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_MODEL player CAR_PATRIOT
		PRINT_NOW (T4x4_F) 3000 1
		GOTO mission_4x4three_failed
	ENDIF

ENDWHILE

IF counter_4x4_pickups = 20
	GOTO mission_4x4three_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_4x4three_failed:


PRINT_BIG ( M_FAIL ) 2000 1


RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_4x4three_passed:

IF flag_4x4_mission3_passed = 0
	record_4x4_three = 300000 - timer_4x4
	record_4x4_three = record_4x4_three / 1000
ENDIF

IF flag_4x4_mission3_passed = 1
	record_temp = 300000 - timer_4x4
	record_temp = record_temp / 1000
	
	IF record_temp < record_4x4_three
		record_4x4_three = record_temp
	ENDIF
ENDIF


PRINT_WITH_NUMBER_BIG ( M_PASS ) 40000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 40000
REGISTER_4X4_THREE_TIME record_4x4_three

IF flag_4x4_mission3_passed = 0
	REGISTER_MISSION_PASSED T4X4_3
	flag_4x4_mission3_passed = 1
	PLAYER_MADE_PROGRESS 1 
ENDIF

//START_NEW_SCRIPT t4x4_mission2_loop
//START_NEW_SCRIPT multistorey_mission_loop

RETURN
		


// mission cleanup

mission_cleanup_4x4three:

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
REMOVE_BLIP blip_13
REMOVE_BLIP blip_14
REMOVE_BLIP blip_15
REMOVE_BLIP blip_16
REMOVE_BLIP blip_17
REMOVE_BLIP blip_18
REMOVE_BLIP blip_19
REMOVE_BLIP blip_20

CLEAR_ONSCREEN_TIMER timer_4x4
flag_player_on_mission = 0
//flag_player_on_4x4_mission = 0

MISSION_HAS_FINISHED
RETURN

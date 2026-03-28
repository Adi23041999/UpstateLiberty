MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************Multi-storey Mayhem******************************* 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_mayhem
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_mayhem_failed
ENDIF
GOSUB mission_cleanup_mayhem
MISSION_END

// Variables for mission
/* variables called in T4x4_1.sc
VAR_INT player_carpark
VAR_INT counter_4x4_pickups timer_4x4
VAR_INT wanted_4x4
VAR_INT intro_time_lapsed timer_intro_now timer_intro_start flag_intro
VAR_INT record_mayhem

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
*/

// ****************************************Mission Start************************************

mission_start_mayhem:
REGISTER_MISSION_GIVEN
SCRIPT_NAME mayhem 
flag_player_on_mission = 1
//flag_player_on_carpark_mission = 1

PRINT_BIG ( MM_1 ) 15000 2

WAIT 0

//Set Variables

counter_4x4_pickups = 0
timer_4x4 = 20000
flag_intro = 0
flag_mayhem_trigger = 1
record_temp = 0
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

//Set Coords

x_1 = 286.0//ground floor
y_1 = -519.0
z_1 = 26.2

x_2 = 302.0
y_2 = -532.0
z_2 = 26.2

x_3 = 271.0
y_3 = -547.0
z_3 = 26.2

x_4 = 303.0
y_4 = -577.0
z_4 = 26.2


x_5 = 327.5//first tier
y_5 = -583.0
z_5 = 29.2

x_6 = 324.5
y_6 = -536.5
z_6 = 29.2

x_7 = 340.0
y_7 = -492.0
z_7 = 29.2

x_8 = 311.0
y_8	= -510.0
z_8 = 29.2


x_9 = 293.0//2nd tier
y_9 = -484.0
z_9 = 31.6

x_10 = 302.0
y_10 = -511.0
z_10 = 31.6

x_11 = 301.0
y_11 = -560.0
z_11 = 31.6

x_12 = 301.0
y_12 = -606.0
z_12 = 31.6


x_13 = 314.5//3rd tier
y_13 = -595.0
z_13 = 33.9

x_14 = 338.0
y_14 = -565.0
z_14 = 33.9

x_15 = 317.0
y_15 = -545.0
z_15 = 33.9

x_16 = 337.0
y_16 = -523.0
z_16 = 33.9


x_17 = 302.0//4th tier
y_17 = -606.5
z_17 = 36.3

x_18 = 304.0
y_18 = -544.5
z_18 = 36.3

x_19 = 266.24
y_19 = -627.00
z_19 = 40.5

x_20 = 272.0
y_20 = -537.0
z_20 = 36.3

//Mission Script 

STORE_WANTED_LEVEL player wanted_4x4
CLEAR_WANTED_LEVEL player
STORE_CAR_PLAYER_IS_IN player player_4x4

SET_PLAYER_CONTROL player off
SWITCH_WIDESCREEN on 

IF NOT IS_CAR_DEAD player_4x4
	LOCK_CAR_DOORS player_4x4 CARLOCK_LOCKED 
ENDIF

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


	IF flag_blip_1 = 0
		DRAW_CORONA x_1 y_1 z_1 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_1 y_1 z_1 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_1 y_1 z_1 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_1
			flag_blip_1 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_2 = 0
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_2 y_2 z_2 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_2
			flag_blip_2 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_3 = 0
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_3 y_3 z_3 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_3
			flag_blip_3 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_4 = 0
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_4 y_4 z_4 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_4
			flag_blip_4 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_5 = 0
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_5 y_5 z_5 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_5 y_5 z_5 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_5
			flag_blip_5 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_6 = 0
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_6 y_6 z_6 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_6
			flag_blip_6 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_7 = 0
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_7 y_7 z_7 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_7
			flag_blip_7 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_8 = 0
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_8 y_8 z_8 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_8
			flag_blip_8 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_9 = 0
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_9 y_9 z_9 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_9
			flag_blip_9 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_10 = 0
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_10 y_10 z_10 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_10
			flag_blip_10 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_11 = 0
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_11 y_11 z_11 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_11
			flag_blip_11 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_12 = 0
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_12 y_12 z_12 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_12
			flag_blip_12 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_13 = 0
		DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_13 y_13 z_13 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_13
			flag_blip_13 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_14 = 0
		DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_14 y_14 z_14 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_14
			flag_blip_14 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_15 = 0
		DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_15 y_15 z_15 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_15
			flag_blip_15 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_16 = 0
		DRAW_CORONA x_16 y_16 z_16 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_16 y_16 z_16 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_16 y_16 z_16 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_16
			flag_blip_16 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_17 = 0
		DRAW_CORONA x_17 y_17 z_17 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_17 y_17 z_17 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_17 y_17 z_17 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_17
			flag_blip_17 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_18 = 0
		DRAW_CORONA x_18 y_18 z_18 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_18 y_18 z_18 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_18 y_18 z_18 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_18
			flag_blip_18 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_19 = 0
		DRAW_CORONA x_19 y_19 z_19 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_19 y_19 z_19 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_19 y_19 z_19 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_19
			flag_blip_19 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_20 = 0
		DRAW_CORONA x_20 y_20 z_20 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player x_20 y_20 z_20 2.0 2.0 2.0 false
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_20 y_20 z_20 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + 5000
			REMOVE_BLIP blip_20
			flag_blip_20 = 1
			PRINT_WITH_NUMBER_NOW (MM_1_B) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_intro_mayhem_before = 1
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
		SET_FIXED_CAMERA_POSITION 281.48 -526.25 26.4 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		POINT_CAMERA_AT_POINT x_1 y_1 z_1 JUMP_CUT 
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PRINT_NOW (MM_1_A) 5500 1 
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF
	
	IF intro_time_lapsed > 3500
	AND flag_intro = 1
		POINT_CAMERA_AT_POINT x_2 y_2 z_2 INTERPOLATION
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 5500
	AND flag_intro = 2
		PRINT_NOW (MM_1_C) 5000 1
		flag_intro = 3
	ENDIF

	IF intro_time_lapsed > 7000
	AND flag_intro = 3
		POINT_CAMERA_AT_POINT x_3 y_3 z_3 INTERPOLATION
		flag_intro = 4
	ENDIF
	
	IF intro_time_lapsed > 10500
	AND flag_intro = 4
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		RESTORE_CAMERA_JUMPCUT
		SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player on
		ALTER_WANTED_LEVEL player wanted_4x4
		IF NOT IS_CAR_DEAD player_4x4
			LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED 
		ENDIF
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		DISPLAY_ONSCREEN_TIMER timer_4x4
		SET_MUSIC_DOES_FADE TRUE
		flag_intro = 5
		flag_intro_mayhem_before = 1
	ENDIF
	
	IF timer_4x4 < 1
		PRINT_NOW (taxi2) 3000 1
		GOTO mission_mayhem_failed
	ENDIF
	
	IF NOT IS_PLAYER_IN_MODEL player CAR_STALLION
		PRINT_NOW (T4x4_F) 3000 1
		GOTO mission_mayhem_failed
	ENDIF

ENDWHILE

IF counter_4x4_pickups = 20
	GOTO mission_mayhem_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_mayhem_failed:


PRINT_BIG ( M_FAIL ) 2000 1

RETURN
   


// -------------------------Mission passed-------------------------------------------------

mission_mayhem_passed:

IF flag_mayhem_mission1_passed = 0
	record_mayhem = 120000 - timer_4x4
	record_mayhem = record_mayhem / 1000
ENDIF

IF flag_mayhem_mission1_passed = 1
	record_temp = 120000 - timer_4x4
	record_temp = record_temp / 1000
	
	IF record_temp < record_mayhem
		record_mayhem = record_temp
	ENDIF
ENDIF


PRINT_WITH_NUMBER_BIG ( M_PASS ) 30000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
//PRINT_WITH_NUMBER_NOW (Y1_1ST) counter_player_points 4000 1
CLEAR_WANTED_LEVEL player
ADD_SCORE player 30000
REGISTER_4X4_MAYHEM_TIME record_mayhem
IF flag_mayhem_mission1_passed = 0
	REGISTER_MISSION_PASSED MM_1 
	flag_mayhem_mission1_passed = 1
	PLAYER_MADE_PROGRESS 1 
ENDIF
//START_NEW_SCRIPT carpark_mission2_loop

RETURN
		


// mission cleanup

mission_cleanup_mayhem:

SET_PLAYER_CONTROL player on
CLEAR_ONSCREEN_TIMER timer_4x4
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off

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

flag_player_on_mission = 0
//flag_player_on_carpark_mission = 0


MISSION_HAS_FINISHED
RETURN

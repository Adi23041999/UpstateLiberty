MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************YARDIE MISSION ONE DRUG RUSH******************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_yd1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_yd1_failed
ENDIF
GOSUB mission_cleanup_yd1
MISSION_END

 
// Variables for mission

VAR_INT hot_rod_1 hot_rod_2 hot_rod_3
VAR_INT player_car wanted_yd1

VAR_INT street_racer_1 street_racer_2 street_racer_3


VAR_INT blip_hot_rod_3 blip_hot_rod_2 blip_hot_rod_1

VAR_INT blip_rush_destination flag_random_yd1 random_yd1

VAR_INT blip_start_yd1

VAR_FLOAT start_x start_y

VAR_FLOAT finish_x finish_y

VAR_FLOAT x_sum y_sum x_sum_player y_sum_player

VAR_FLOAT hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_dist
VAR_FLOAT hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_dist
VAR_FLOAT hot_rod_3_x hot_rod_3_y hot_rod_3_z
VAR_FLOAT hot_rod_heading

VAR_FLOAT player_car_x player_car_y player_car_z player_dist

VAR_INT counter_rush_start counter_hotrods
VAR_INT flag_hotrod1_start flag_hotrod2_start flag_hotrod3_start 

VAR_INT flag_drive_mode_1 flag_drive_mode_2 flag_drive_mode_3

VAR_INT flag_leader

VAR_INT counter_player_points reward_yd1 

VAR_INT counter_nonplayer1_points counter_nonplayer2_points counter_nonplayer3_points

VAR_INT counter_finish
VAR_INT flag_corona_yd1

VAR_INT counter_placing counter_joint_placing

VAR_INT timer_reset_hr1 timer_reset_hr2 timer_reset_hr3
VAR_INT timer_start_hr1 timer_start_hr2 timer_start_hr3
VAR_INT timer_current_hr1 timer_current_hr2 timer_current_hr3
VAR_INT hr1_time_dif hr2_time_dif hr3_time_dif

// ****************************************Mission Start************************************

mission_start_yd1:
REGISTER_MISSION_GIVEN
SCRIPT_NAME yard1 
flag_player_on_mission = 1
flag_player_on_yardie_mission = 1

WAIT 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_yd1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//SWITCH_STREAMING OFF

PRINT_BIG ( YD1 ) 15000 2 //"Yardie Mission 1"	 

TIMERA = 0

WHILE TIMERA < 1500					  
	WAIT 0

ENDWHILE
*/

// ******************************************CUTSCENE***************************************



{

SET_PED_DENSITY_MULTIPLIER 0.0
SET_POLICE_IGNORE_PLAYER player on

//WHILE NOT HAS_MODEL_LOADED cut_obj1
//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE YD_PH1
SET_CUTSCENE_OFFSET 121.0 -272.3 15.25
CLEAR_AREA_OF_CHARS 100.5 -250.0 0.0 130.5 -290.0 25.0
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

//CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
//SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

//SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

//SWITCH_STREAMING OFF
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2237
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( YD1_A ) 10000 1 

WHILE cs_time < 3791
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD1_A1 ) 10000 1 

WHILE cs_time < 8312
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD1_B ) 10000 1 

WHILE cs_time < 12880
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD1_C ) 10000 1 

WHILE cs_time < 15965
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD1_D ) 10000 1 

WHILE cs_time < 20462
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD1_D1 ) 10000 1 
/*

WHILE cs_time < 24139
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_G ) 10000 1 

WHILE cs_time < 28919
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_H ) 10000 1 
*/
WHILE cs_time < 25166
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE



DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

SWITCH_STREAMING ON
CLEAR_PRINTS
CLEAR_CUTSCENE
//SET_CAMERA_IN_FRONT_OF_PLAYER
SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER player off
WAIT 500

DO_FADE 1500 FADE_IN
}

//------------LOCATION VARIABLES---(NB: ALL LOCATIONS SHOULD HAVE X Y & Z IN FINISHED SCRIPT!!)-----------------------------------------------------

finish_x = 107.0

finish_y = -288.0

start_x = 50.0

start_y = 70.0

flag_corona_yd1 = 0
flag_hotrod1_start = 0
flag_hotrod2_start = 0
flag_hotrod3_start = 0


counter_rush_start = 0
counter_hotrods = 0
counter_player_points = 0
counter_nonplayer1_points = 0
counter_nonplayer2_points = 0
counter_nonplayer3_points = 0
counter_finish = 0
counter_placing = 0
counter_joint_placing = 0

ADD_BLIP_FOR_COORD start_x start_y -100.0 blip_start_yd1

flag_leader = 0
flag_random_yd1 = 0

REQUEST_MODEL PED_MALE2
REQUEST_MODEL CAR_PATRIOT
REQUEST_MODEL CAR_CHEETAH
REQUEST_MODEL CAR_BOBCAT

WHILE NOT HAS_MODEL_LOADED PED_MALE2
OR NOT HAS_MODEL_LOADED CAR_PATRIOT
OR NOT HAS_MODEL_LOADED CAR_CHEETAH
OR NOT HAS_MODEL_LOADED CAR_BOBCAT

WAIT 1000

ENDWHILE



// --------Mission stuff goes here-----------------------------------------------------

is_player_there:

IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_2D player 45.0 65.0 55.0 75.0 true
	STORE_CAR_PLAYER_IS_IN player player_car
	GOTO player_is_there   
ENDIF

IF LOCATE_PLAYER_ON_FOOT_2D player start_x start_y 5.0 5.0 false
	PRINT_NOW ( YD1_G) 2000 1
ENDIF
WAIT 0

GOTO is_player_there

player_is_there:

STORE_WANTED_LEVEL player wanted_yd1
CLEAR_WANTED_LEVEL player

REMOVE_BLIP blip_start_yd1

SET_PLAYER_CONTROL player off
LOCK_CAR_DOORS player_car CARLOCK_LOCKED
SET_FIXED_CAMERA_POSITION 66.7 51.0 18.0 0.0 0.0 0.0
DO_FADE 1500 FADE_OUT
WAIT 1500
POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
SWITCH_WIDESCREEN on

SET_FADING_COLOUR 0 0 0
DO_FADE 1500 FADE_IN
WAIT 1500
 

CLEAR_AREA 90.0 50.0 16.0 20.0 true
CLEAR_AREA 93.0 57.0 16.0 20.0 true
CLEAR_AREA 78.0 50.0 16.0 20.0 true
CLEAR_AREA 93.0 43.0 16.0 20.0 true

SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

WAIT 2000

POINT_CAMERA_AT_POINT 90.0 50.0 16.0 INTERPOLATION

CLEAR_AREA 102.0 90.0 16.0 20.0 true
CREATE_CAR CAR_PATRIOT 102.0 90.0 16.0 hot_rod_1
CREATE_CHAR_INSIDE_CAR hot_rod_1 PEDTYPE_CIVMALE PED_MALE2 street_racer_1
SET_CAR_WATERTIGHT hot_rod_1 true
SET_UPSIDEDOWN_CAR_NOT_DAMAGED hot_rod_1 true
LOCK_CAR_DOORS hot_rod_1 CARLOCK_LOCKED
SET_CAR_HEADING hot_rod_1 190.0
SET_CAR_CRUISE_SPEED hot_rod_1 20.0
SET_CAR_DRIVING_STYLE hot_rod_1 0
CAR_GOTO_COORDINATES_ACCURATE hot_rod_1 93.0 57.0 16.0

CLEAR_AREA 75.0 76.0 16.0 20.0 true
CREATE_CAR CAR_CHEETAH 75.0 76.0 16.0 hot_rod_2
CREATE_CHAR_INSIDE_CAR hot_rod_2 PEDTYPE_CIVMALE PED_MALE2 street_racer_2
SET_CAR_WATERTIGHT hot_rod_2 true
SET_UPSIDEDOWN_CAR_NOT_DAMAGED hot_rod_2 true
LOCK_CAR_DOORS hot_rod_2 CARLOCK_LOCKED
SET_CAR_HEADING hot_rod_2 220.0
SET_CAR_CRUISE_SPEED hot_rod_2 20.0
SET_CAR_DRIVING_STYLE hot_rod_2 0
CAR_GOTO_COORDINATES_ACCURATE hot_rod_2 78.0 50.0 16.0

CLEAR_AREA 108.0 3.0 16.0 20.0 true
CREATE_CAR CAR_BOBCAT 108.0 3.0 16.0 hot_rod_3
CREATE_CHAR_INSIDE_CAR hot_rod_3 PEDTYPE_CIVMALE PED_MALE2 street_racer_3
SET_CAR_WATERTIGHT hot_rod_3 true
SET_UPSIDEDOWN_CAR_NOT_DAMAGED hot_rod_3 true
LOCK_CAR_DOORS hot_rod_3 CARLOCK_LOCKED
//SET_CAR_HEADING hot_rod_3 360.0
SET_CAR_CRUISE_SPEED hot_rod_3 10.0
SET_CAR_DRIVING_STYLE hot_rod_3 0
CAR_GOTO_COORDINATES_ACCURATE hot_rod_3 93.0 43.0 16.0

ADD_BLIP_FOR_CAR hot_rod_3 blip_hot_rod_3
ADD_BLIP_FOR_CAR hot_rod_2 blip_hot_rod_2
ADD_BLIP_FOR_CAR hot_rod_1 blip_hot_rod_1

PRINT_NOW ( YD1_E ) 3000 2


ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination


WHILE counter_hotrods < 3

	WAIT 0

	IF NOT IS_CAR_DEAD hot_rod_1
		IF LOCATE_CAR_2D hot_rod_1 93.0 57.0 3.0 3.0 false
		AND flag_hotrod1_start = 0
			CAR_SET_IDLE hot_rod_1
			flag_hotrod1_start = 1
			++ counter_hotrods
		ENDIF
	ENDIF
	SET_CAR_HEALTH hot_rod_1 1000

	IF NOT IS_CAR_DEAD hot_rod_2
		IF LOCATE_CAR_2D hot_rod_2 78.0 50.0 3.0 3.0 false
		AND flag_hotrod2_start = 0
			CAR_SET_IDLE hot_rod_2
			flag_hotrod2_start = 1
			++ counter_hotrods
		ENDIF
	ENDIF
	SET_CAR_HEALTH hot_rod_2 1000

	IF NOT IS_CAR_DEAD hot_rod_3
		IF LOCATE_CAR_2D hot_rod_3 93.0 43.0 3.0 3.0 false
		AND flag_hotrod3_start = 0
			CAR_SET_IDLE hot_rod_3
			flag_hotrod3_start = 1
			++ counter_hotrods
		ENDIF
	ENDIF
	SET_CAR_HEALTH hot_rod_3 1000

ENDWHILE

WAIT 1500

SET_FADING_COLOUR 0 0 0
DO_FADE 1500 FADE_OUT
WAIT 1500

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
ALTER_WANTED_LEVEL player wanted_yd1

DO_FADE 1500 FADE_IN
WAIT 1500

IF NOT IS_CAR_DEAD player_car
	LOCK_CAR_DOORS player_car CARLOCK_UNLOCKED
ENDIF

SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

//----------------GENERATE ROUTE FLAG--------------------------------------------

GENERATE_RANDOM_INT random_yd1

IF random_yd1 > 21845
AND random_yd1 < 43691
	flag_random_yd1 = 1
ENDIF

IF random_yd1 > 43690
	flag_random_yd1 = 2
ENDIF

//-----------TURN OFF TUNNEL NODES-------------------------


SWITCH_ROADS_OFF 500.0 60.0 -25.0 600.0 140.0 0.0
SWITCH_ROADS_OFF -400.0 60.0 -25.0 -300.0 140.0 0.0

//-----------------RACE COUNTDOWN-----------------------------------------------


IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player player_car
ENDIF

WHILE NOT IS_CAR_DEAD player_car
AND LOCATE_CAR_2D player_car start_x start_y 10.0 10.0 false
		WAIT 1000
		IF counter_rush_start = 4
			GOTO and_its_go_go_go
		ENDIF

		IF counter_rush_start = 3
			PRINT_BIG ( YD1GO ) 1000 4
			++ counter_rush_start
			SET_PLAYER_CONTROL player on
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
		ENDIF
		
		IF counter_rush_start = 2
			PRINT_BIG ( YD1_1 ) 1000 4
			++ counter_rush_start
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
		ENDIF
		
		IF counter_rush_start = 1
			PRINT_BIG ( YD1_2 ) 1000 4
			++ counter_rush_start
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
		ENDIF

		IF counter_rush_start = 0
			PRINT_BIG ( YD1_3 ) 1000 4
			++ counter_rush_start
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
		ENDIF
ENDWHILE	   

	   
PRINT_NOW ( YD1_F ) 4000 2


//-------------------RACE START-------------------------------------------------------------

and_its_go_go_go:

GOSUB driving_style_car_1
GOSUB driving_style_car_2
GOSUB driving_style_car_3


//------------------MAIN LOOP--------------------------------------------------------------

main_loop:

IF flag_corona_yd1 = 0
	DRAW_CORONA finish_x finish_y -100.0 2.0 CORONATYPE_CIRCLE FLARETYPE_NONE 200 120 120
/*ELSE
	DRAW_CORONA finish_x finish_y 16.1 2.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200*/
ENDIF

IF IS_PLAYER_IN_ANY_CAR player


		STORE_CAR_PLAYER_IS_IN player player_car

	
		GET_CAR_COORDINATES player_car player_car_x player_car_y player_car_z
		
		x_sum = finish_x - player_car_x

		y_sum = finish_y - player_car_y

		x_sum = x_sum * x_sum

		y_sum = y_sum * y_sum

		player_dist = x_sum + y_sum

		
		
		
	IF NOT IS_CAR_DEAD hot_rod_1
	OR IS_CAR_IN_WATER hot_rod_1

		IF NOT IS_CHAR_DEAD	street_racer_1
		AND NOT IS_PLAYER_IN_CAR player hot_rod_1

			GET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z

			IF hot_rod_1_z < 0.0 //no collision warp
				GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_heading
				//GET_CLOSEST_CAR_NODE hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z
				IF NOT IS_POINT_ON_SCREEN hot_rod_1_x hot_rod_1_y hot_rod_1_z 3.0
					SET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
					SET_CAR_HEADING hot_rod_1 hot_rod_heading
				ENDIF
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER hot_rod_1 450
				SET_CAR_HEALTH hot_rod_1 600
			ENDIF

			IF IS_CAR_UPSIDEDOWN hot_rod_1
			AND IS_CAR_STOPPED hot_rod_1
				SET_CHAR_OBJ_LEAVE_CAR street_racer_1 hot_rod_1
				IF NOT IS_CAR_ON_SCREEN hot_rod_1
					GET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_1_x hot_rod_1_y hot_rod_1_z 3.0
						SET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
						SET_CAR_HEADING hot_rod_1 hot_rod_heading
						DELETE_CHAR street_racer_1
						CREATE_CHAR_INSIDE_CAR hot_rod_1 PEDTYPE_CIVMALE PED_MALE2 street_racer_1
					ENDIF
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER hot_rod_1
				//PRINT_BIG (Y1_TEST) 2000 1//CAR IN WATER!!
				IF NOT IS_CAR_ON_SCREEN hot_rod_1
					GET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_1_x hot_rod_1_y hot_rod_1_z 3.0
						SET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
						SET_CAR_HEADING hot_rod_1 hot_rod_heading
						DELETE_CHAR street_racer_1
						CREATE_CHAR_INSIDE_CAR hot_rod_1 PEDTYPE_CIVMALE PED_MALE2 street_racer_1
					ENDIF
				ENDIF
			ENDIF

			IF timer_reset_hr1 = 1
				IF NOT IS_CAR_STOPPED hot_rod_1
					timer_reset_hr1 = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED hot_rod_1
				IF timer_reset_hr1 = 0
					GET_GAME_TIMER timer_start_hr1
					timer_reset_hr1 = 1
				ENDIF

				IF timer_reset_hr1 = 1
					GET_GAME_TIMER timer_current_hr1
					hr1_time_dif = timer_current_hr1 - timer_start_hr1
				ENDIF

				IF hr1_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN hot_rod_1
						GET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_heading
						//GET_CLOSEST_CAR_NODE hot_rod_1_x hot_rod_1_y hot_rod_1_z hot_rod_1_x hot_rod_1_y hot_rod_1_z
						IF NOT IS_POINT_ON_SCREEN hot_rod_1_x hot_rod_1_y hot_rod_1_z 3.0
							SET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z
							SET_CAR_HEADING hot_rod_1 hot_rod_heading
							timer_reset_hr1 = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF

		
		
			GET_CAR_COORDINATES hot_rod_1 hot_rod_1_x hot_rod_1_y hot_rod_1_z

			x_sum = finish_x - hot_rod_1_x

			y_sum = finish_y - hot_rod_1_y
		
			x_sum = x_sum * x_sum

			y_sum = y_sum * y_sum

			hot_rod_1_dist = x_sum + y_sum
		
			IF hot_rod_1_dist > player_dist
				SET_CAR_MISSION hot_rod_1 2 //MISSION_RAMPLAYER_FARAWAY
			ENDIF

			IF player_dist > hot_rod_1_dist
				GOSUB driving_style_car_1
			ENDIF
		ELSE
			CAR_SET_IDLE hot_rod_1
		ENDIF
	ENDIF

	   		
		

	IF NOT IS_CAR_DEAD hot_rod_2
	OR IS_CAR_IN_WATER hot_rod_2

		IF NOT IS_CHAR_DEAD street_racer_2
		AND NOT IS_PLAYER_IN_CAR player hot_rod_2

			GET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z

			IF hot_rod_2_z < 0.0 //no collision warp
				GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_heading
				//GET_CLOSEST_CAR_NODE hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z
				IF NOT IS_POINT_ON_SCREEN hot_rod_2_x hot_rod_2_y hot_rod_2_z 3.0
					SET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
					SET_CAR_HEADING hot_rod_2 hot_rod_heading
				ENDIF
			ENDIF
				
			IF NOT IS_CAR_HEALTH_GREATER hot_rod_2 450
				SET_CAR_HEALTH hot_rod_2 600
			ENDIF

			IF IS_CAR_UPSIDEDOWN hot_rod_2
			AND IS_CAR_STOPPED hot_rod_2
				SET_CHAR_OBJ_LEAVE_CAR street_racer_2 hot_rod_2
				IF NOT IS_CAR_ON_SCREEN hot_rod_2
					GET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_2_x hot_rod_2_y hot_rod_2_z 3.0
						SET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
						SET_CAR_HEADING hot_rod_2 hot_rod_heading
						DELETE_CHAR street_racer_2
						CREATE_CHAR_INSIDE_CAR hot_rod_2 PEDTYPE_CIVMALE PED_MALE2 street_racer_2
					ENDIF
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER hot_rod_2
				//PRINT_BIG (Y1_TEST) 2000 1
				IF NOT IS_CAR_ON_SCREEN hot_rod_2
					GET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_2_x hot_rod_2_y hot_rod_2_z 3.0
						SET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
						SET_CAR_HEADING hot_rod_2 hot_rod_heading
						DELETE_CHAR street_racer_2
						CREATE_CHAR_INSIDE_CAR hot_rod_2 PEDTYPE_CIVMALE PED_MALE2 street_racer_2
					ENDIF
				ENDIF
			ENDIF

			IF timer_reset_hr2 = 1
				IF NOT IS_CAR_STOPPED hot_rod_2
					timer_reset_hr2 = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED hot_rod_2
				IF timer_reset_hr2 = 0
					GET_GAME_TIMER timer_start_hr2
					timer_reset_hr2 = 1
				ENDIF

				IF timer_reset_hr2 = 1
					GET_GAME_TIMER timer_current_hr2
					hr2_time_dif = timer_current_hr2 - timer_start_hr2
				ENDIF

				IF hr2_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN hot_rod_2
						GET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_heading
						//GET_CLOSEST_CAR_NODE hot_rod_2_x hot_rod_2_y hot_rod_2_z hot_rod_2_x hot_rod_2_y hot_rod_2_z
						IF NOT IS_POINT_ON_SCREEN hot_rod_2_x hot_rod_2_y hot_rod_2_z 3.0
							SET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
							SET_CAR_HEADING hot_rod_2 hot_rod_heading
							timer_reset_hr2 = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			GET_CAR_COORDINATES hot_rod_2 hot_rod_2_x hot_rod_2_y hot_rod_2_z
			
			x_sum = finish_x - hot_rod_2_x

			y_sum = finish_y - hot_rod_2_y

			x_sum = x_sum * x_sum

			y_sum = y_sum * y_sum

			hot_rod_2_dist = x_sum + y_sum



			IF hot_rod_2_dist > player_dist 
				SET_CAR_MISSION hot_rod_2 2 //RAMPLAYER_FARAWAY
			ENDIF

			
			IF player_dist > hot_rod_2_dist
				GOSUB driving_style_car_2
			ENDIF
		ELSE
			CAR_SET_IDLE hot_rod_2
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD hot_rod_3
	OR IS_CAR_IN_WATER hot_rod_3

		IF NOT IS_CHAR_DEAD street_racer_3
		AND NOT IS_PLAYER_IN_CAR player hot_rod_3

			GET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
			
			IF hot_rod_3_z < 0.0 //no collision warp
				GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_heading
				//GET_CLOSEST_CAR_NODE hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z
				IF NOT IS_POINT_ON_SCREEN hot_rod_3_x hot_rod_3_y hot_rod_3_z 3.0
					SET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
					SET_CAR_HEADING hot_rod_3 hot_rod_heading
				ENDIF
			ENDIF
				
			IF NOT IS_CAR_HEALTH_GREATER hot_rod_3 450
				SET_CAR_HEALTH hot_rod_3 600
			ENDIF

			IF IS_CAR_UPSIDEDOWN hot_rod_3
			AND IS_CAR_STOPPED hot_rod_3
				SET_CHAR_OBJ_LEAVE_CAR street_racer_3 hot_rod_3
				IF NOT IS_CAR_ON_SCREEN hot_rod_3
					GET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_3_x hot_rod_3_y hot_rod_3_z 3.0
						SET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
						SET_CAR_HEADING hot_rod_3 hot_rod_heading
						DELETE_CHAR street_racer_3
						CREATE_CHAR_INSIDE_CAR hot_rod_3 PEDTYPE_CIVMALE PED_MALE2 street_racer_3
					ENDIF
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER hot_rod_3
				//PRINT_BIG (Y1_TEST) 2000 1
				IF NOT IS_CAR_ON_SCREEN hot_rod_3
					GET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_heading
					//GET_CLOSEST_CAR_NODE hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z
					IF NOT IS_POINT_ON_SCREEN hot_rod_3_x hot_rod_3_y hot_rod_3_z 3.0
						SET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
						SET_CAR_HEADING hot_rod_3 hot_rod_heading
						DELETE_CHAR street_racer_3
						CREATE_CHAR_INSIDE_CAR hot_rod_3 PEDTYPE_CIVMALE PED_MALE2 street_racer_3
					ENDIF
				ENDIF
			ENDIF

			IF timer_reset_hr3 = 1
				IF NOT IS_CAR_STOPPED hot_rod_3
					timer_reset_hr3 = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED hot_rod_3
				IF timer_reset_hr3 = 0
					GET_GAME_TIMER timer_start_hr3
					timer_reset_hr3 = 1
				ENDIF

				IF timer_reset_hr3 = 1
					GET_GAME_TIMER timer_current_hr3
					hr3_time_dif = timer_current_hr3 - timer_start_hr3
				ENDIF

				IF hr3_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN hot_rod_3
						GET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_heading
						//GET_CLOSEST_CAR_NODE hot_rod_3_x hot_rod_3_y hot_rod_3_z hot_rod_3_x hot_rod_3_y hot_rod_3_z
						IF NOT IS_POINT_ON_SCREEN hot_rod_3_x hot_rod_3_y hot_rod_3_z 3.0
							SET_CAR_COORDINATES hot_rod_3 hot_rod_3_x hot_rod_3_y hot_rod_3_z
							SET_CAR_HEADING hot_rod_3 hot_rod_heading
							timer_reset_hr3 = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			CAR_SET_IDLE hot_rod_3
		ENDIF
	ENDIF
	
ENDIF	
		
IF NOT IS_PLAYER_IN_ANY_CAR player
	GOSUB driving_style_car_1
	GOSUB driving_style_car_2
	GOSUB driving_style_car_3
ENDIF


IF LOCATE_PLAYER_IN_CAR_2D player finish_x finish_y 6.0 6.0 false 
	GOSUB player_points
ENDIF

IF NOT IS_CAR_DEAD hot_rod_1
	IF LOCATE_CAR_2D hot_rod_1 finish_x finish_y 6.0 6.0 false
		GOSUB nonplayer_points_1
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD hot_rod_2
	IF LOCATE_CAR_2D hot_rod_2 finish_x finish_y 6.0 6.0 false
		GOSUB nonplayer_points_2
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD hot_rod_3
	IF LOCATE_CAR_2D hot_rod_3 finish_x finish_y 6.0 6.0 false
		GOSUB nonplayer_points_3
	ENDIF
ENDIF

WAIT 0

GOSUB driving_style_car_3

IF counter_finish = 15
	GOTO race_finished
ENDIF

GOTO main_loop




//------------------------------RACE FINISHED---------------------------------------------

race_finished:

IF counter_player_points = counter_nonplayer1_points
	++ counter_joint_placing
ENDIF

IF counter_player_points = counter_nonplayer2_points
	++ counter_joint_placing
ENDIF

IF counter_player_points = counter_nonplayer3_points
	++ counter_joint_placing
ENDIF

IF counter_player_points > counter_nonplayer1_points
	++ counter_placing
ENDIF

IF counter_player_points > counter_nonplayer2_points
	++ counter_placing
ENDIF

IF counter_player_points > counter_nonplayer3_points
	++ counter_placing
ENDIF

IF counter_placing = 3
	GOTO mission_yd1_passed
ENDIF

IF counter_placing < 3
	GOTO mission_yd1_failed
ENDIF



// --------------------------Race failed-----------------------------------------------

mission_yd1_failed:


PRINT_BIG ( M_FAIL ) 2000 1

WAIT 2000

IF counter_joint_placing = 0
	IF counter_placing = 2
		PRINT_WITH_NUMBER_NOW (Y1_2ND) counter_player_points 4000 1
		WAIT 2000
	ENDIF

	IF counter_placing = 1
		PRINT_WITH_NUMBER_NOW (Y1_3RD) counter_player_points 4000 1
		WAIT 2000
	ENDIF

	IF counter_placing = 0
		PRINT_WITH_NUMBER_NOW (Y1_LAST) counter_player_points 4000 1
		WAIT 2000
	ENDIF
ENDIF


IF counter_joint_placing = 1
	IF counter_placing = 2
		PRINT_WITH_NUMBER_NOW (Y1_J1ST) counter_player_points 4000 1
		WAIT 2000
	ENDIF

	IF counter_placing = 1
		PRINT_WITH_NUMBER_NOW (Y1_J2ND) counter_player_points 4000 1
		WAIT 2000
	ENDIF

	IF counter_placing = 0
		PRINT_WITH_NUMBER_NOW (Y1JLAST) counter_player_points 4000 1
		WAIT 2000
	ENDIF
ENDIF

IF counter_joint_placing = 2
	IF counter_placing = 1
		PRINT_WITH_NUMBER_NOW (Y1_J1ST) counter_player_points 4000 1
		WAIT 2000
	ENDIF

	IF counter_placing = 0
		PRINT_WITH_NUMBER_NOW (Y1JLAST) counter_player_points 4000 1
		WAIT 2000
	ENDIF
ENDIF

RETURN
   




// Race passed

mission_yd1_passed:

IF flag_yardie_mission4_passed = 0
	REGISTER_MISSION_PASSED YD1
	PLAYER_MADE_PROGRESS 1 
	flag_yardie_mission1_passed = 1
	START_NEW_SCRIPT yardie_mission2_loop
ENDIF

reward_yd1 = 1000 * counter_player_points
PRINT_WITH_NUMBER_BIG ( M_PASS ) reward_yd1 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
PRINT_WITH_NUMBER_NOW (Y1_1ST) counter_player_points 4000 1
CLEAR_WANTED_LEVEL player
ADD_SCORE player reward_yd1
REGISTER_HIGHEST_SCORE 0 counter_player_points

RETURN
		


// mission cleanup

mission_cleanup_yd1:

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
//SET_PLAYER_CONTROL player on

REMOVE_BLIP blip_hot_rod_1
REMOVE_BLIP blip_hot_rod_2
REMOVE_BLIP blip_hot_rod_3
REMOVE_BLIP blip_start_yd1

MARK_MODEL_AS_NO_LONGER_NEEDED PED_MALE2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PATRIOT
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BOBCAT

SWITCH_ROADS_ON 500.0 60.0 -25.0 600.0 140.0 0.0
SWITCH_ROADS_ON -400.0 60.0 -25.0 -300.0 140.0 0.0

flag_player_on_mission = 0
flag_player_on_ray_mission = 0

//DELETE_CHAR street_racer_1

REMOVE_BLIP blip_rush_destination

MISSION_HAS_FINISHED
RETURN
		

//---------------------------GOSUBS-----------------------------------------------

driving_style_car_1:
	IF NOT IS_CAR_DEAD hot_rod_1
		SET_CAR_CRUISE_SPEED hot_rod_1 40.0
		SET_CAR_DRIVING_STYLE hot_rod_1 3
		CAR_GOTO_COORDINATES_ACCURATE hot_rod_1 finish_x finish_y -1.0
		flag_drive_mode_1 = 0
	ENDIF
RETURN

driving_style_car_2:
	IF NOT IS_CAR_DEAD hot_rod_2 
		SET_CAR_CRUISE_SPEED hot_rod_2 45.0
		SET_CAR_DRIVING_STYLE hot_rod_2 2
		CAR_GOTO_COORDINATES_ACCURATE hot_rod_2 finish_x finish_y -1.0
		flag_drive_mode_2 = 0
	ENDIF
RETURN

driving_style_car_3:
	IF NOT IS_CAR_DEAD hot_rod_3
		SET_CAR_CRUISE_SPEED hot_rod_3 35.0
		SET_CAR_DRIVING_STYLE hot_rod_3 2
		CAR_GOTO_COORDINATES_ACCURATE hot_rod_3 finish_x finish_y -1.0
		flag_drive_mode_3 = 0
	ENDIF
RETURN


player_points:
	++ counter_player_points
	++ counter_finish
	//ADD_SCORE player 1000
	//PRINT_BIG ( YD1_BON ) 1000 4
	PRINT_WITH_NUMBER_BIG (YD1_CNT) counter_player_points 2000 4
	ADD_ONE_OFF_SOUND player_car_x player_car_y player_car_z SOUND_PART_MISSION_COMPLETE
	GOSUB finish_coord_generator
RETURN

nonplayer_points_1:
	++ counter_nonplayer1_points
	++ counter_finish
	ADD_ONE_OFF_SOUND player_car_x player_car_y player_car_z SOUND_PART_MISSION_COMPLETE
	GOSUB finish_coord_generator
RETURN

nonplayer_points_2:
	++ counter_nonplayer2_points
	++ counter_finish
	ADD_ONE_OFF_SOUND player_car_x player_car_y player_car_z SOUND_PART_MISSION_COMPLETE
	GOSUB finish_coord_generator
RETURN

nonplayer_points_3:
	++ counter_nonplayer3_points
	++ counter_finish
	ADD_ONE_OFF_SOUND player_car_x player_car_y player_car_z SOUND_PART_MISSION_COMPLETE
	GOSUB finish_coord_generator
RETURN



//----------------FINISH COORD GENERATOR--------------------------------------

finish_coord_generator:


IF flag_random_yd1 = 0

	IF counter_finish = 1
		REMOVE_BLIP blip_rush_destination
		finish_x = 106.0
		finish_y = -403.36
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 1
	ENDIF

	IF counter_finish = 2
		REMOVE_BLIP blip_rush_destination
		finish_x = 86.8
		finish_y = -538.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 0
	ENDIF

	IF counter_finish = 3
		REMOVE_BLIP blip_rush_destination
		finish_x = 173.5
		finish_y = -696.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 4
		REMOVE_BLIP blip_rush_destination
		finish_x = 165.0
		finish_y = -886.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 5
		REMOVE_BLIP blip_rush_destination
		finish_x = 78.5
		finish_y = -945.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 6
		REMOVE_BLIP blip_rush_destination
		finish_x = -69.4
		finish_y = -926.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 7
		REMOVE_BLIP blip_rush_destination
		finish_x = 207.8
		finish_y = -1041.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 8
		REMOVE_BLIP blip_rush_destination
		finish_x = 49.1
		finish_y = -1034.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 9
		REMOVE_BLIP blip_rush_destination
		finish_x = 74.3
		finish_y = -920.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 10
		REMOVE_BLIP blip_rush_destination
		finish_x = 105.5
		finish_y = -1095.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 11
		REMOVE_BLIP blip_rush_destination
		finish_x = -114.0
		finish_y = -499.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 12
		REMOVE_BLIP blip_rush_destination
		finish_x = -10.79
		finish_y = -463.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 13
		REMOVE_BLIP blip_rush_destination
		finish_x = 346.0
		finish_y = -1211.4
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF
	/*
	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = 524.3
		finish_y = -519.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
		finish_x = 530.4
		finish_y = -55.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 16
		REMOVE_BLIP blip_rush_destination
		finish_x = 548.5
		finish_y = -370.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 17
		REMOVE_BLIP blip_rush_destination
		finish_x = 69.8
		finish_y = 107.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 18
		REMOVE_BLIP blip_rush_destination
		finish_x = -41.6 
		finish_y = -1353.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF
	*/
	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = start_x
		finish_y = start_y
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
	ENDIF

ENDIF

IF flag_random_yd1 = 1

	IF counter_finish = 1
		REMOVE_BLIP blip_rush_destination
		finish_x = 173.5
		finish_y = -696.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 2
		REMOVE_BLIP blip_rush_destination
		finish_x = -114.0
		finish_y = -499.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 3
		REMOVE_BLIP blip_rush_destination
		finish_x = -10.79
		finish_y = -463.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 4
		REMOVE_BLIP blip_rush_destination
		finish_x = 78.5
		finish_y = -945.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 5
		REMOVE_BLIP blip_rush_destination
		finish_x = -69.4
		finish_y = -926.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 6
		REMOVE_BLIP blip_rush_destination
		finish_x = -73.4
		finish_y = -1013.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 7
		REMOVE_BLIP blip_rush_destination
		finish_x = 207.8
		finish_y = -1041.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 8
		REMOVE_BLIP blip_rush_destination
		finish_x = 86.8
		finish_y = -538.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 0
	ENDIF

	IF counter_finish = 9
		REMOVE_BLIP blip_rush_destination
		finish_x = 49.1
		finish_y = -1034.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 10
		REMOVE_BLIP blip_rush_destination
		finish_x = 74.3
		finish_y = -920.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 11
		REMOVE_BLIP blip_rush_destination
		finish_x = 105.5
		finish_y = -1095.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 12
		REMOVE_BLIP blip_rush_destination
		finish_x = 346.0
		finish_y = -1211.4
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 13
		REMOVE_BLIP blip_rush_destination
		finish_x = -8.4
		finish_y = -803.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF
	/*
	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = 548.5
		finish_y = -370.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
		finish_x = 165.0
		finish_y = -886.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 16
		REMOVE_BLIP blip_rush_destination
		finish_x = 69.8
		finish_y = 107.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 17
		REMOVE_BLIP blip_rush_destination
		finish_x = -41.6 
		finish_y = -1353.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 18
		REMOVE_BLIP blip_rush_destination
		finish_x = 106.0
		finish_y = -403.36
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 1
	ENDIF
	*/
	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = start_x
		finish_y = start_y
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
	ENDIF
ENDIF

IF flag_random_yd1 = 2

	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = start_x
		finish_y = start_y
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF
	/*
	IF counter_finish = 18
		REMOVE_BLIP blip_rush_destination
		finish_x = -10.79
		finish_y = -463.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 17
		REMOVE_BLIP blip_rush_destination
		finish_x = 78.5
		finish_y = -945.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 16
		REMOVE_BLIP blip_rush_destination
		finish_x = -69.4
		finish_y = -926.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
		finish_x = 524.3
		finish_y = -519.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 14
		REMOVE_BLIP blip_rush_destination
		finish_x = 172.8
		finish_y = -1066.9
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF
	*/
	IF counter_finish = 13
		REMOVE_BLIP blip_rush_destination
		finish_x = 86.8
		finish_y = -538.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 0
	ENDIF

	IF counter_finish = 12
		REMOVE_BLIP blip_rush_destination
		finish_x = 49.1
		finish_y = -1034.1
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 11
		REMOVE_BLIP blip_rush_destination
		finish_x = 74.3
		finish_y = -920.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 10
		REMOVE_BLIP blip_rush_destination
		finish_x = 105.5
		finish_y = -1095.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 9
		REMOVE_BLIP blip_rush_destination
		finish_x = 346.0
		finish_y = -1211.4
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF


	IF counter_finish = 8
		REMOVE_BLIP blip_rush_destination
		finish_x = -8.4
		finish_y = -803.2
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 7
		REMOVE_BLIP blip_rush_destination
		finish_x = 251.5
		finish_y = -208.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 6
		REMOVE_BLIP blip_rush_destination
		finish_x = 165.0
		finish_y = -886.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 5
		REMOVE_BLIP blip_rush_destination
		finish_x = -72.5
		finish_y = -803.0
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 4
		REMOVE_BLIP blip_rush_destination
		finish_x = -41.6 
		finish_y = -1353.5
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 3
		REMOVE_BLIP blip_rush_destination
		finish_x = 106.0
		finish_y = -403.36
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
		//flag_corona_yd1 = 1
	ENDIF

	IF counter_finish = 2
		REMOVE_BLIP blip_rush_destination
		finish_x = 122.1
		finish_y = -932.0 
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 1
		REMOVE_BLIP blip_rush_destination
		finish_x = 173.5
		finish_y = -696.6
		ADD_BLIP_FOR_COORD finish_x finish_y -100.0 blip_rush_destination
	ENDIF

	IF counter_finish = 15
		REMOVE_BLIP blip_rush_destination
	ENDIF
ENDIF

RETURN




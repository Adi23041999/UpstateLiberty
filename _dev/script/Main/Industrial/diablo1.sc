MISSION_START
// *****************************************************************************************
// ***********************************    Diablo 1 	  **************************************
// *********************************** Low Rider Race **************************************
// *****************************************************************************************
// *** There will be a race to see who is the man. It will start at the top of the 		 ***
// *** bridge and encompass most of the industrial sector. The player must get to the 	 ***
// *** end before his three Hispanic rivals.											 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_d1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_d1_failed
ENDIF

GOSUB mission_cleanup_d1

MISSION_END
 
// Variables for mission

//VAR_INT	player_cpcounter_test//TEST VARS
VAR_FLOAT car1_x car1_y car1_z car2_x car2_y car2_z car3_x car3_y car3_z players_x players_y players_z
VAR_FLOAT difference_x_float_d difference_y_float_d	sum_difference_d_xy	ai_car1_locate_size ai_car2_locate_size ai_car3_locate_size
VAR_FLOAT car2_distance_from_cp car1_distance_from_cp car3_distance_from_cp players_distance_from_cp
VAR_FLOAT car1_stuck_x car1_stuck_y car1_stuck_z
VAR_FLOAT car2_stuck_x car2_stuck_y car2_stuck_z
VAR_FLOAT car3_stuck_x car3_stuck_y car3_stuck_z
VAR_FLOAT player_x_d1 player_y_d1 player_z_d1
VAR_FLOAT car1_x_d1 car1_y_d1 car1_z_d1
VAR_FLOAT car2_x_d1 car2_y_d1 car2_z_d1
VAR_FLOAT car3_x_d1 car3_y_d1 car3_z_d1
VAR_FLOAT blip_2nd_x blip_2nd_y blip_2nd_z
VAR_FLOAT cp2_x_d1 cp2_y_d1 cp2_z_d1
VAR_FLOAT cp3_x_d1 cp3_y_d1 cp3_z_d1
VAR_FLOAT cp4_x_d1 cp4_y_d1 cp4_z_d1
VAR_FLOAT cp5_x_d1 cp5_y_d1 cp5_z_d1
VAR_FLOAT cp6_x_d1 cp6_y_d1 cp6_z_d1
VAR_FLOAT cp7_x_d1 cp7_y_d1 cp7_z_d1
VAR_FLOAT cp8_x_d1 cp8_y_d1 cp8_z_d1
VAR_FLOAT cp9_x_d1 cp9_y_d1 cp9_z_d1
VAR_FLOAT cp10_x_d1 cp10_y_d1 cp10_z_d1
VAR_FLOAT cp11_x_d1 cp11_y_d1 cp11_z_d1
VAR_FLOAT cp12_x_d1 cp12_y_d1 cp12_z_d1
VAR_FLOAT cp13_x_d1 cp13_y_d1 cp13_z_d1
VAR_FLOAT cp14_x_d1 cp14_y_d1 cp14_z_d1
VAR_FLOAT cp15_x_d1 cp15_y_d1 cp15_z_d1
VAR_FLOAT cp16_x_d1 cp16_y_d1 cp16_z_d1
VAR_FLOAT cp17_x_d1 cp17_y_d1 cp17_z_d1
VAR_FLOAT cp18_x_d1 cp18_y_d1 cp18_z_d1												   //players_car_speed
VAR_INT blip_chase_d1 second_blip blip_car1_d1 blip_car2_d1 blip_car3_d1			   //players_car_speed_int
VAR_INT car1_d1 car2_d1 car3_d1 car1_health car2_health car3_health	
VAR_INT ped_car1_driver_d1 ped_car2_driver_d1 ped_car3_driver_d1
VAR_INT game_timer_start_d1 game_timer_end_d1 player_cpcounter car1_cpcounter car2_cpcounter car3_cpcounter
VAR_INT behind_car1 behind_car2 behind_car3 position timera_reset_flag_d1 timerb_reset_flag_d1  
VAR_INT timerc timerc_started timerc_current timerc_reset_flag_d1
VAR_INT timerd timerd_started timerd_current timerd_reset_flag
VAR_INT timere timere_started timere_current timere_reset_flag
VAR_INT timerf timerf_started timerf_current timerf_reset_flag

// ****************************************Mission Start************************************

mission_start_d1:

flag_player_on_mission = 1
flag_player_on_diablo_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME diablo1

game_timer_start_d1  = 0
game_timer_end_d1	 = 0
player_cpcounter 	 = 0
car1_cpcounter 	 	 = 0
car2_cpcounter 	 	 = 0
car3_cpcounter 		 = 0
behind_car1 		 = 0
behind_car2 		 = 0
behind_car3 	 	 = 0
position			 = 0
timera_reset_flag_d1 = 0
timerb_reset_flag_d1 = 0
timerc_reset_flag_d1 = 0
timerc_started 		 = 0
timerc_current 	 	 = 0
timerc				 = 0
timerd 				 = 0
timerd_started 		 = 0
timerd_current 	 	 = 0
timerd_reset_flag	 = 0
ai_car1_locate_size  = 7.0
ai_car2_locate_size  = 7.0
ai_car3_locate_size  = 7.0
timere_reset_flag = 0
timerf_reset_flag = 0
car1_stuck_x = 0.0
car1_stuck_y = 0.0
car1_stuck_z = 0.0
car2_stuck_x = 0.0
car2_stuck_y = 0.0
car2_stuck_z = 0.0
car3_stuck_x = 0.0
car3_stuck_y = 0.0
car3_stuck_z = 0.0

//_____________Check Points____________//

//cp1_x_d1 = 776.0
//cp1_y_d1 = -917.5
//cp1_z_d1 = 39.0

cp2_x_d1 =  1050.859
cp2_y_d1 =  -929.54
cp2_z_d1 =  14.4

cp3_x_d1 =  1314.0
cp3_y_d1 =  -945.0
cp3_z_d1 =  14.8

cp4_x_d1 =  1092.0
cp4_y_d1 =  -1061.0
cp4_z_d1 =  14.3

cp5_x_d1 =  842.0
cp5_y_d1 =  -1009.0
cp5_z_d1 =  4.4

cp6_x_d1 =  855.0
cp6_y_d1 =  -768.8
cp6_z_d1 =  14.6

cp7_x_d1 =  1004.0
cp7_y_d1 =  -822.0
cp7_z_d1 =  14.5

cp8_x_d1 =  1126.0
cp8_y_d1 =  -602.0
cp8_z_d1 =  14.4

cp9_x_d1 =  1196.0
cp9_y_d1 =  -254.0
cp9_z_d1 =  24.4

cp10_x_d1 = 1116.0
cp10_y_d1 = -14.0
cp10_z_d1 = 6.0

cp11_x_d1 = 934.0
cp11_y_d1 = -38.7
cp11_z_d1 = 7.0

cp12_x_d1 = 876.0
cp12_y_d1 = -131.0
cp12_z_d1 = 4.5

cp13_x_d1 = 870.0
cp13_y_d1 = -453.0
cp13_z_d1 = 14.4

cp14_x_d1 = 1049.0
cp14_y_d1 = -473.0
cp14_z_d1 = 14.4

cp15_x_d1 = 1337.0
cp15_y_d1 = -490.0
cp15_z_d1 = 46.0

cp16_x_d1 = 1337.0
cp16_y_d1 = -215.0
cp16_z_d1 = 45.4

cp17_x_d1 = 1048.0
cp17_y_d1 = -249.0
cp17_z_d1 = 5.0

cp18_x_d1 = 980.0
cp18_y_d1 = -565.0
cp18_z_d1 = 14.5

//______________________________________//

{

SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA_OF_CHARS 890.3 -309.1 0.0 1038.1 -132.9 10.0

TIMERA = 0

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//	SWITCH_STREAMING OFF

PRINT_BIG ( DIAB1 ) 15000 2 //"Diablo Mission 1"

IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_d1_failed
ENDIF

WHILE TIMERA < 1500					  
	WAIT 0

ENDWHILE

*/

LOAD_CUTSCENE EL_PH1
//SET_CUTSCENE_OFFSET 939.4 -230.1 3.9
SET_CUTSCENE_OFFSET 938.27 -229.561 4.023
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

DO_FADE 1500 FADE_IN

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW DIAB1_B 10000 1 //"This is El Buro of the Diablos."

WHILE cs_time < 4731
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW DIAB1_D 10000 1 //"You're new in Liberty, but already you are gaining a reputation on the streets."

WHILE cs_time < 10501
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW DIAB1_E 10000 1 //"There's a street race starting by the old school hall near the Callahan Bridge."

WHILE cs_time < 15111
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW DIAB1_F 10000 1 //"Get yourself some wheels and first through all the checkpoints wins the prize."

WHILE cs_time < 20500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_PRINTS
SWITCH_STREAMING ON

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE
SET_PED_DENSITY_MULTIPLIER 1.0

WAIT 500

DO_FADE 1500 FADE_IN

//____________________________________________________________________//


REQUEST_MODEL PED_GANG_DIABLO_A
REQUEST_MODEL PED_GANG_DIABLO_B
REQUEST_MODEL CAR_CHEETAH

WHILE NOT HAS_MODEL_LOADED CAR_CHEETAH
OR NOT HAS_MODEL_LOADED	PED_GANG_DIABLO_A
OR NOT HAS_MODEL_LOADED	PED_GANG_DIABLO_B
	WAIT 0
ENDWHILE

//WHILE NOT IS_BUTTON_PRESSED PAD1 LEFTSHOCK
//	WAIT 0
//ENDWHILE

SWITCH_ROADS_OFF 1034.0 -956.0 12.0 1063.0 -847.0 20.0

CREATE_CAR CAR_CHEETAH 1048.1465 -858.6693 13.7827 car1_d1
LOCK_CAR_DOORS car1_d1 CARLOCK_LOCKED
SET_CAR_PROOFS car1_d1 TRUE TRUE TRUE FALSE TRUE
SET_CAR_WATERTIGHT car1_d1 TRUE
SET_CAR_STRONG car1_d1 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED car1_d1 TRUE

CREATE_CAR CAR_CHEETAH 1053.3384 -859.3337 13.7827 car2_d1
LOCK_CAR_DOORS car2_d1 CARLOCK_LOCKED
SET_CAR_PROOFS car2_d1 TRUE TRUE TRUE FALSE TRUE
SET_CAR_WATERTIGHT car2_d1 TRUE
SET_CAR_STRONG car2_d1 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED car2_d1 TRUE

CREATE_CAR CAR_CHEETAH 1058.6385 -859.2989 13.7827 car3_d1
LOCK_CAR_DOORS car3_d1 CARLOCK_LOCKED
SET_CAR_PROOFS car3_d1 TRUE TRUE TRUE FALSE TRUE
SET_CAR_WATERTIGHT car3_d1 TRUE
SET_CAR_STRONG car3_d1 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED car3_d1 TRUE

CREATE_CHAR_INSIDE_CAR car1_d1 PEDTYPE_CIVMALE PED_GANG_DIABLO_A ped_car1_driver_d1	
CREATE_CHAR_INSIDE_CAR car2_d1 PEDTYPE_CIVMALE PED_GANG_DIABLO_B ped_car2_driver_d1	
CREATE_CHAR_INSIDE_CAR car3_d1 PEDTYPE_CIVMALE PED_GANG_DIABLO_A ped_car3_driver_d1

SET_CHAR_CANT_BE_DRAGGED_OUT ped_car1_driver_d1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT ped_car2_driver_d1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT ped_car3_driver_d1 TRUE	

SET_CAR_HEADING car1_d1 180.0
SET_CAR_HEADING car2_d1 180.0
SET_CAR_HEADING car3_d1 180.0

CAR_SET_IDLE car1_d1
CAR_SET_IDLE car2_d1
CAR_SET_IDLE car3_d1

SET_CAR_DRIVING_STYLE car1_d1 2
SET_CAR_CRUISE_SPEED car1_d1 50.0

SET_CAR_DRIVING_STYLE car2_d1 2
SET_CAR_CRUISE_SPEED car2_d1 50.0

SET_CAR_DRIVING_STYLE car3_d1 2
SET_CAR_CRUISE_SPEED car3_d1 50.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER car1_d1 TRUE
SET_CAR_ONLY_DAMAGED_BY_PLAYER car2_d1 TRUE
SET_CAR_ONLY_DAMAGED_BY_PLAYER car3_d1 TRUE

ADD_BLIP_FOR_COORD 1042.9772 -858.7398 13.7827 blip_chase_d1

PRINT_NOW DIAB1_4 5000 1 //"~g~Get a fast car and get to the starting grid."					

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player 1042.9772 -858.7398 13.7827 2.0 2.0 2.0 1
							   
	WAIT 0

	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player 1042.9772 -858.7398 13.7827 2.0 2.0 2.0 1
		PRINT_NOW YD1_G 5000 1
	ENDIF

	IF IS_CAR_DEAD car1_d1
		GOTO mission_d1_failed
	ENDIF

	IF IS_CAR_DEAD car2_d1
		GOTO mission_d1_failed
	ENDIF

	IF IS_CAR_DEAD car3_d1
		GOTO mission_d1_failed
	ENDIF

	GET_CAR_HEALTH car1_d1 timerc

	IF timerc < 1000
		timerc = 9
		GOTO race_start
	ENDIF

	GET_CAR_HEALTH car2_d1 timerc

	IF timerc < 1000
		timerc = 9
		GOTO race_start
	ENDIF

	GET_CAR_HEALTH car3_d1 timerc

	IF timerc < 1000
		timerc = 9
		GOTO race_start
	ENDIF

//	IF IS_PLAYER_IN_ANY_CAR player
//		STORE_CAR_PLAYER_IS_IN player players_car
//		GET_CAR_SPEED players_car players_car_speed
//		players_car_speed_int =# players_car_speed
//		PRINT_WITH_NUMBER_NOW NUMBER players_car_speed_int 50 1
//	ENDIF

ENDWHILE

race_start:

SET_CAR_ONLY_DAMAGED_BY_PLAYER car1_d1 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER car2_d1 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER car3_d1 FALSE

IF timerc = 9
	PRINT_BIG DIAB1_1 1200 4 // "3..2..1.. GO GO GO!"
ELSE
	SET_PLAYER_CONTROL player OFF
	SET_EVERYONE_IGNORE_PLAYER player TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	PRINT_BIG ( YD1_3 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
	WAIT 1000
	PRINT_BIG ( YD1_2 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
	WAIT 1000
	PRINT_BIG ( YD1_1 ) 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
	WAIT 1000
	PRINT_BIG ( YD1GO ) 800 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
	SET_PLAYER_CONTROL player ON
	SET_EVERYONE_IGNORE_PLAYER player FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
ENDIF

IF IS_CAR_DEAD car1_d1
	GOTO mission_d1_failed
ENDIF

IF IS_CAR_DEAD car2_d1
	GOTO mission_d1_failed
ENDIF

IF IS_CAR_DEAD car3_d1
	GOTO mission_d1_failed
ENDIF

timerc = 0

REMOVE_BLIP blip_chase_d1

ADD_BLIP_FOR_CAR_OLD car1_d1 RED MARKER_ONLY blip_car1_d1
ADD_BLIP_FOR_CAR_OLD car2_d1 RED MARKER_ONLY blip_car2_d1
ADD_BLIP_FOR_CAR_OLD car3_d1 RED MARKER_ONLY blip_car3_d1

player_x_d1 = cp2_x_d1
player_y_d1 = cp2_y_d1
player_z_d1 = cp2_z_d1
blip_2nd_x = cp3_x_d1
blip_2nd_y = cp3_y_d1
blip_2nd_z = cp3_z_d1

car1_x_d1 = cp2_x_d1
car1_y_d1 = cp2_y_d1
car1_z_d1 = cp2_z_d1

car2_x_d1 = cp2_x_d1
car2_y_d1 = cp2_y_d1
car2_z_d1 = cp2_z_d1

car3_x_d1 = cp2_x_d1
car3_y_d1 = cp2_y_d1
car3_z_d1 = cp2_z_d1

ADD_BLIP_FOR_COORD player_x_d1 player_y_d1 player_z_d1 blip_chase_d1
ADD_BLIP_FOR_COORD_OLD blip_2nd_x blip_2nd_y blip_2nd_z PURPLE BLIP_ONLY second_blip
CHANGE_BLIP_SCALE second_blip 2
DIM_BLIP second_blip TRUE
CAR_GOTO_COORDINATES car1_d1 car1_x_d1 car1_y_d1 car1_z_d1
CAR_GOTO_COORDINATES car2_d1 car2_x_d1 car2_y_d1 car2_z_d1
CAR_GOTO_COORDINATES car3_d1 car3_x_d1 car3_y_d1 car3_z_d1

GET_GAME_TIMER game_timer_start_d1
GET_GAME_TIMER game_timer_end_d1
game_timer_end_d1 = game_timer_end_d1 - game_timer_start_d1
game_timer_end_d1 = game_timer_end_d1 / 1000
DISPLAY_ONSCREEN_COUNTER_WITH_STRING game_timer_end_d1 COUNTER_DISPLAY_NUMBER DIAB1_5


loop1:

WAIT 0

GET_GAME_TIMER game_timer_end_d1
game_timer_end_d1 = game_timer_end_d1 - game_timer_start_d1
game_timer_end_d1 = game_timer_end_d1 / 1000
 	
position = 0 + behind_car1 
position += behind_car2 
position += behind_car3

IF position = 0
	PRINT_NOW FIRST 100 1 //"1st"
ENDIF

IF position = 1
	PRINT_NOW SECOND 100 1 //"2nd"
ENDIF

IF position = 2
	PRINT_NOW THIRD 100 1 //"3rd"
ENDIF

IF position = 3
	PRINT_NOW FOURTH 100 1 //"4th"
ENDIF

IF player_cpcounter = 17
	DRAW_CORONA player_x_d1 player_y_d1 player_z_d1 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 100 0 0
ELSE
	DRAW_CORONA player_x_d1 player_y_d1 player_z_d1 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 100
ENDIF

IF LOCATE_PLAYER_IN_CAR_3D player player_x_d1 player_y_d1 player_z_d1 6.0 6.0 6.0 0
	
	++ player_cpcounter
	
	REMOVE_BLIP blip_chase_d1
	REMOVE_BLIP second_blip
	
	IF player_cpcounter = 1
		player_x_d1 = cp3_x_d1
		player_y_d1 = cp3_y_d1
		player_z_d1 = cp3_z_d1
		blip_2nd_x = cp4_x_d1
		blip_2nd_y = cp4_y_d1
		blip_2nd_z = cp4_z_d1
	ENDIF

	IF player_cpcounter = 2
		player_x_d1 = cp4_x_d1
		player_y_d1 = cp4_y_d1
		player_z_d1 = cp4_z_d1
		blip_2nd_x = cp5_x_d1
		blip_2nd_y = cp5_y_d1
		blip_2nd_z = cp5_z_d1
	ENDIF

	IF player_cpcounter = 3
		player_x_d1 = cp5_x_d1
		player_y_d1 = cp5_y_d1
		player_z_d1 = cp5_z_d1
		blip_2nd_x = cp6_x_d1
		blip_2nd_y = cp6_y_d1
		blip_2nd_z = cp6_z_d1
	ENDIF

	IF player_cpcounter = 4
		player_x_d1 = cp6_x_d1
		player_y_d1 = cp6_y_d1
		player_z_d1 = cp6_z_d1
		blip_2nd_x = cp7_x_d1
		blip_2nd_y = cp7_y_d1
		blip_2nd_z = cp7_z_d1
	ENDIF

	IF player_cpcounter = 5
		player_x_d1 = cp7_x_d1
		player_y_d1 = cp7_y_d1
		player_z_d1 = cp7_z_d1
		blip_2nd_x = cp8_x_d1
		blip_2nd_y = cp8_y_d1
		blip_2nd_z = cp8_z_d1
	ENDIF

	IF player_cpcounter = 6
		player_x_d1 = cp8_x_d1
		player_y_d1 = cp8_y_d1
		player_z_d1 = cp8_z_d1
		blip_2nd_x = cp9_x_d1
		blip_2nd_y = cp9_y_d1
		blip_2nd_z = cp9_z_d1
	ENDIF

	IF player_cpcounter = 7
		player_x_d1 = cp9_x_d1
		player_y_d1 = cp9_y_d1
		player_z_d1 = cp9_z_d1
		blip_2nd_x = cp10_x_d1
		blip_2nd_y = cp10_y_d1
		blip_2nd_z = cp10_z_d1
	ENDIF

	IF player_cpcounter = 8
		player_x_d1 = cp10_x_d1
		player_y_d1 = cp10_y_d1
		player_z_d1 = cp10_z_d1
		blip_2nd_x = cp11_x_d1
		blip_2nd_y = cp11_y_d1
		blip_2nd_z = cp11_z_d1
	ENDIF

	IF player_cpcounter = 9
		player_x_d1 = cp11_x_d1
		player_y_d1 = cp11_y_d1
		player_z_d1 = cp11_z_d1
		blip_2nd_x = cp12_x_d1
		blip_2nd_y = cp12_y_d1
		blip_2nd_z = cp12_z_d1
	ENDIF

	IF player_cpcounter = 10
		player_x_d1 = cp12_x_d1
		player_y_d1 = cp12_y_d1
		player_z_d1 = cp12_z_d1
		blip_2nd_x = cp13_x_d1
		blip_2nd_y = cp13_y_d1
		blip_2nd_z = cp13_z_d1
	ENDIF

	IF player_cpcounter = 11
		player_x_d1 = cp13_x_d1
		player_y_d1 = cp13_y_d1
		player_z_d1 = cp13_z_d1
		blip_2nd_x = cp14_x_d1
		blip_2nd_y = cp14_y_d1
		blip_2nd_z = cp14_z_d1
	ENDIF

	IF player_cpcounter = 12
		player_x_d1 = cp14_x_d1
		player_y_d1 = cp14_y_d1
		player_z_d1 = cp14_z_d1
		blip_2nd_x = cp15_x_d1
		blip_2nd_y = cp15_y_d1
		blip_2nd_z = cp15_z_d1
	ENDIF

	IF player_cpcounter = 13
		player_x_d1 = cp15_x_d1
		player_y_d1 = cp15_y_d1
		player_z_d1 = cp15_z_d1
		blip_2nd_x = cp16_x_d1
		blip_2nd_y = cp16_y_d1
		blip_2nd_z = cp16_z_d1
	ENDIF

	IF player_cpcounter = 14
		player_x_d1 = cp16_x_d1
		player_y_d1 = cp16_y_d1
		player_z_d1 = cp16_z_d1
		blip_2nd_x = cp17_x_d1
		blip_2nd_y = cp17_y_d1
		blip_2nd_z = cp17_z_d1
	ENDIF

	IF player_cpcounter = 15
		player_x_d1 = cp17_x_d1
		player_y_d1 = cp17_y_d1
		player_z_d1 = cp17_z_d1
		blip_2nd_x = cp18_x_d1
		blip_2nd_y = cp18_y_d1
		blip_2nd_z = cp18_z_d1
	ENDIF

	IF player_cpcounter = 16
		player_x_d1 = cp18_x_d1
		player_y_d1 = cp18_y_d1
		player_z_d1 = cp18_z_d1
		blip_2nd_x = cp2_x_d1
		blip_2nd_y = cp2_y_d1
		blip_2nd_z = cp2_z_d1
	ENDIF

	IF player_cpcounter = 17
		player_x_d1 = cp2_x_d1
		player_y_d1 = cp2_y_d1
		player_z_d1 = cp2_z_d1
		blip_2nd_x = cp2_x_d1
		blip_2nd_y = cp2_y_d1
		blip_2nd_z = cp2_z_d1
	ENDIF

	IF player_cpcounter = 18
//	AND	position = 0
		GOTO mission_d1_passed		
	ENDIF

	ADD_BLIP_FOR_COORD_OLD blip_2nd_x blip_2nd_y blip_2nd_z PURPLE BLIP_ONLY second_blip
	DIM_BLIP second_blip ON
	CHANGE_BLIP_SCALE second_blip 2
	ADD_BLIP_FOR_COORD player_x_d1 player_y_d1 player_z_d1 blip_chase_d1

ENDIF
		
IF NOT IS_CAR_DEAD car1_d1

	GET_CAR_HEALTH car1_d1 car1_health
	IF car1_health < 500
		SET_CAR_HEALTH car1_d1 1000
	ENDIF

	IF NOT player_cpcounter	= car1_cpcounter
		IF player_cpcounter < car1_cpcounter
			behind_car1 = 1
		ELSE
			behind_car1 = 0
		ENDIF  
	ELSE
		GET_CAR_COORDINATES	car1_d1 car1_x car1_y car1_z
		difference_x_float_d = car1_x - player_x_d1
		difference_y_float_d = car1_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy car1_distance_from_cp

		GET_PLAYER_COORDINATES player players_x players_y players_z
		difference_x_float_d = players_x - player_x_d1
		difference_y_float_d = players_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy players_distance_from_cp

		IF players_distance_from_cp < car1_distance_from_cp
			behind_car1 = 0
		ELSE
			behind_car1 = 1
		ENDIF
	ENDIF

	IF LOCATE_CAR_3D car1_d1 car1_stuck_x car1_stuck_y car1_stuck_z 4.0 4.0 4.0 0
		IF timerd_reset_flag = 0
			GET_GAME_TIMER timerd_started
			timerd_reset_flag = 1
		ENDIF

		IF timerd_reset_flag = 1
			GET_GAME_TIMER timerd_current
			timerd = timerd_current - timerd_started
			IF timerd > 8000
				IF NOT IS_CAR_ON_SCREEN car1_d1
					GET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
					GET_CLOSEST_CAR_NODE car1_x car1_y car1_z car1_x car1_y car1_z
					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_x car1_y car1_z 4.0 4.0 4.0
						IF NOT IS_POINT_ON_SCREEN car1_x car1_y car1_z 4.0
							SET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
							TURN_CAR_TO_FACE_COORD car1_d1 car1_x_d1 car1_y_d1
							timerd_reset_flag = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT LOCATE_CAR_3D car1_d1 car1_stuck_x car1_stuck_y car1_stuck_z 4.0 4.0 4.0 0
		GET_CAR_COORDINATES car1_d1 car1_stuck_x car1_stuck_y car1_stuck_z
		timerd_reset_flag = 0
	ENDIF
	
	IF IS_CAR_UPSIDEDOWN car1_d1
	AND IS_CAR_STOPPED car1_d1
		IF NOT IS_CAR_ON_SCREEN car1_d1
			GET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
			GET_CLOSEST_CAR_NODE car1_x car1_y car1_z car1_x car1_y car1_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_x car1_y car1_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car1_x car1_y car1_z 3.0
					SET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
					TURN_CAR_TO_FACE_COORD car1_d1 car1_x_d1 car1_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF timera_reset_flag_d1 = 1
		IF NOT IS_CAR_STOPPED car1_d1
			timera_reset_flag_d1 = 0
		ENDIF
	ENDIF
		
	IF IS_CAR_STOPPED car1_d1
		IF timera_reset_flag_d1 = 0
			TIMERA = 0
			timera_reset_flag_d1 = 1
		ENDIF

		IF TIMERA > 5000
		AND timera_reset_flag_d1 = 1
			IF NOT IS_CAR_ON_SCREEN car1_d1
				GET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
				GET_CLOSEST_CAR_NODE car1_x car1_y car1_z car1_x car1_y car1_z
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_x car1_y car1_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN car1_x car1_y car1_z 4.0
						SET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
						TURN_CAR_TO_FACE_COORD car1_d1 car1_x_d1 car1_y_d1
						timera_reset_flag_d1 = 0
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF LOCATE_CAR_3D car1_d1 car1_x_d1 car1_y_d1 car1_z_d1 ai_car1_locate_size ai_car1_locate_size ai_car1_locate_size 0
		++ car1_cpcounter

		IF car1_cpcounter = 1
			car1_x_d1 = cp3_x_d1
			car1_y_d1 = cp3_y_d1
			car1_z_d1 = cp3_z_d1
		ENDIF

		IF car1_cpcounter = 2
			car1_x_d1 = cp4_x_d1
			car1_y_d1 = cp4_y_d1
			car1_z_d1 = cp4_z_d1
			SWITCH_ROADS_ON 1034.0 -956.0 12.0 1063.0 -847.0 20.0
		ENDIF

		IF car1_cpcounter = 3
			car1_x_d1 = cp5_x_d1
			car1_y_d1 = cp5_y_d1
			car1_z_d1 = cp5_z_d1
		ENDIF

		IF car1_cpcounter = 4
			car1_x_d1 = cp6_x_d1
			car1_y_d1 = cp6_y_d1
			car1_z_d1 = cp6_z_d1
		ENDIF

		IF car1_cpcounter = 5
			car1_x_d1 = cp7_x_d1
			car1_y_d1 = cp7_y_d1
			car1_z_d1 = cp7_z_d1
		ENDIF

		IF car1_cpcounter = 6
			car1_x_d1 = cp8_x_d1
			car1_y_d1 = cp8_y_d1
			car1_z_d1 = cp8_z_d1
		ENDIF

		IF car1_cpcounter = 7
			car1_x_d1 = cp9_x_d1
			car1_y_d1 = cp9_y_d1
			car1_z_d1 = cp9_z_d1
		ENDIF

		IF car1_cpcounter = 8
			car1_x_d1 = cp10_x_d1
			car1_y_d1 = cp10_y_d1
			car1_z_d1 = cp10_z_d1
		ENDIF

		IF car1_cpcounter = 9
			car1_x_d1 = cp11_x_d1
			car1_y_d1 = cp11_y_d1
			car1_z_d1 = cp11_z_d1
		ENDIF

		IF car1_cpcounter = 10
			car1_x_d1 = cp12_x_d1
			car1_y_d1 = cp12_y_d1
			car1_z_d1 = cp12_z_d1
		ENDIF

		IF car1_cpcounter = 11
			car1_x_d1 = cp13_x_d1
			car1_y_d1 = cp13_y_d1
			car1_z_d1 = cp13_z_d1
		ENDIF

		IF car1_cpcounter = 12
			car1_x_d1 = cp14_x_d1
			car1_y_d1 = cp14_y_d1
			car1_z_d1 = cp14_z_d1
		ENDIF

		IF car1_cpcounter = 13
			car1_x_d1 = cp15_x_d1
			car1_y_d1 = cp15_y_d1
			car1_z_d1 = cp15_z_d1
		ENDIF

		IF car1_cpcounter = 14
			car1_x_d1 = cp16_x_d1
			car1_y_d1 = cp16_y_d1
			car1_z_d1 = cp16_z_d1
		ENDIF

		IF car1_cpcounter = 15
			car1_x_d1 = cp17_x_d1
			car1_y_d1 = cp17_y_d1
			car1_z_d1 = cp17_z_d1
		ENDIF

		IF car1_cpcounter = 16
			car1_x_d1 = cp18_x_d1
			car1_y_d1 = cp18_y_d1
			car1_z_d1 = cp18_z_d1
		ENDIF

		IF car1_cpcounter = 17
			car1_x_d1 = cp2_x_d1
			car1_y_d1 = cp2_y_d1
			car1_z_d1 = cp2_z_d1
			ai_car1_locate_size = 6.0
		ENDIF

		IF car1_cpcounter = 18
//		AND	position > 0
			PRINT_NOW DIAB1_3 5000 1 //"~r~You failed to win the race!"
			GOTO mission_d1_failed		
		ENDIF
		
		IF ai_car1_locate_size = 7.0
			CAR_GOTO_COORDINATES car1_d1 car1_x_d1 car1_y_d1 car1_z_d1
		ELSE
			CAR_GOTO_COORDINATES_ACCURATE car1_d1 car1_x_d1 car1_y_d1 car1_z_d1
		ENDIF

	ENDIF
ELSE

	IF NOT IS_CAR_IN_WATER car1_d1
		behind_car1 = 0
		car1_cpcounter	= 0
	ENDIF

	IF IS_CAR_IN_WATER car1_d1
		IF NOT IS_CAR_ON_SCREEN car1_d1
			GET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
			GET_CLOSEST_CAR_NODE car1_x car1_y car1_z car1_x car1_y car1_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_x car1_y car1_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car1_x car1_y car1_z 3.0
					SET_CAR_COORDINATES car1_d1 car1_x car1_y car1_z
					TURN_CAR_TO_FACE_COORD car1_d1 car1_x_d1 car1_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
ENDIF

IF NOT IS_CAR_DEAD car2_d1
	
	GET_CAR_HEALTH car2_d1 car2_health
	IF car2_health < 500
		SET_CAR_HEALTH car2_d1 1000
	ENDIF

	IF NOT player_cpcounter	= car2_cpcounter	
		IF player_cpcounter < car2_cpcounter
			behind_car2 = 1
		ELSE
			behind_car2 = 0
		ENDIF
	ELSE
		GET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
		difference_x_float_d = car2_x - player_x_d1
		difference_y_float_d = car2_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy car2_distance_from_cp

		GET_PLAYER_COORDINATES player players_x players_y players_z
		difference_x_float_d = players_x - player_x_d1
		difference_y_float_d = players_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy players_distance_from_cp

		IF players_distance_from_cp < car2_distance_from_cp
			behind_car2 = 0
		ELSE
			behind_car2 = 1
		ENDIF
	ENDIF
		
	IF LOCATE_CAR_3D car2_d1 car2_stuck_x car2_stuck_y car2_stuck_z 4.0 4.0 4.0 0
		IF timere_reset_flag = 0
			GET_GAME_TIMER timere_started
			timere_reset_flag = 1
		ENDIF

		IF timere_reset_flag = 1
			GET_GAME_TIMER timere_current
			timere = timere_current - timere_started
			IF timere > 8000
				IF NOT IS_CAR_ON_SCREEN car2_d1
					GET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
					GET_CLOSEST_CAR_NODE car2_x car2_y car2_z car2_x car2_y car2_z
					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_x car2_y car2_z 4.0 4.0 4.0
						IF NOT IS_POINT_ON_SCREEN car2_x car2_y car2_z 4.0
							SET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
							TURN_CAR_TO_FACE_COORD car2_d1 car2_x_d1 car2_y_d1
							timere_reset_flag = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT LOCATE_CAR_3D car2_d1 car2_stuck_x car2_stuck_y car2_stuck_z 4.0 4.0 4.0 0
		GET_CAR_COORDINATES car2_d1 car2_stuck_x car2_stuck_y car2_stuck_z
		timere_reset_flag = 0
	ENDIF
	
	IF IS_CAR_UPSIDEDOWN car2_d1
	AND IS_CAR_STOPPED car2_d1
		IF NOT IS_CAR_ON_SCREEN car2_d1
			GET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
			GET_CLOSEST_CAR_NODE car2_x car2_y car2_z car2_x car2_y car2_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_x car2_y car2_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car2_x car2_y car2_z 3.0
					SET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
					TURN_CAR_TO_FACE_COORD car2_d1 car2_x_d1 car2_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF timerb_reset_flag_d1 = 1
		IF NOT IS_CAR_STOPPED car2_d1
			timerb_reset_flag_d1 = 0
		ENDIF
	ENDIF
		
	IF IS_CAR_STOPPED car2_d1
		IF timerb_reset_flag_d1 = 0
			TIMERB = 0
			timerb_reset_flag_d1 = 1
		ENDIF

		IF TIMERB > 5000
		AND timerb_reset_flag_d1 = 1
			IF NOT IS_CAR_ON_SCREEN car2_d1
				GET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
				GET_CLOSEST_CAR_NODE car2_x car2_y car2_z car2_x car2_y car2_z
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_x car2_y car2_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN car2_x car2_y car2_z 4.0
						SET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
						TURN_CAR_TO_FACE_COORD car2_d1 car2_x_d1 car2_y_d1
						timerb_reset_flag_d1 = 0
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF LOCATE_CAR_3D car2_d1 car2_x_d1 car2_y_d1 car2_z_d1 ai_car2_locate_size ai_car2_locate_size ai_car2_locate_size 0
		++ car2_cpcounter

		IF car2_cpcounter = 1
			car2_x_d1 = cp3_x_d1
			car2_y_d1 = cp3_y_d1
			car2_z_d1 = cp3_z_d1
		ENDIF

		IF car2_cpcounter = 2
			car2_x_d1 = cp4_x_d1
			car2_y_d1 = cp4_y_d1
			car2_z_d1 = cp4_z_d1
		ENDIF

		IF car2_cpcounter = 3
			car2_x_d1 = cp5_x_d1
			car2_y_d1 = cp5_y_d1
			car2_z_d1 = cp5_z_d1
		ENDIF

		IF car2_cpcounter = 4
			car2_x_d1 = cp6_x_d1
			car2_y_d1 = cp6_y_d1
			car2_z_d1 = cp6_z_d1
		ENDIF

		IF car2_cpcounter = 5
			car2_x_d1 = cp7_x_d1
			car2_y_d1 = cp7_y_d1
			car2_z_d1 = cp7_z_d1
		ENDIF

		IF car2_cpcounter = 6
			car2_x_d1 = cp8_x_d1
			car2_y_d1 = cp8_y_d1
			car2_z_d1 = cp8_z_d1
		ENDIF

		IF car2_cpcounter = 7
			car2_x_d1 = cp9_x_d1
			car2_y_d1 = cp9_y_d1
			car2_z_d1 = cp9_z_d1
		ENDIF

		IF car2_cpcounter = 8
			car2_x_d1 = cp10_x_d1
			car2_y_d1 = cp10_y_d1
			car2_z_d1 = cp10_z_d1
		ENDIF

		IF car2_cpcounter = 9
			car2_x_d1 = cp11_x_d1
			car2_y_d1 = cp11_y_d1
			car2_z_d1 = cp11_z_d1
		ENDIF

		IF car2_cpcounter = 10
			car2_x_d1 = cp12_x_d1
			car2_y_d1 = cp12_y_d1
			car2_z_d1 = cp12_z_d1
		ENDIF

		IF car2_cpcounter = 11
			car2_x_d1 = cp13_x_d1
			car2_y_d1 = cp13_y_d1
			car2_z_d1 = cp13_z_d1
		ENDIF

		IF car2_cpcounter = 12
			car2_x_d1 = cp14_x_d1
			car2_y_d1 = cp14_y_d1
			car2_z_d1 = cp14_z_d1
		ENDIF

		IF car2_cpcounter = 13
			car2_x_d1 = cp15_x_d1
			car2_y_d1 = cp15_y_d1
			car2_z_d1 = cp15_z_d1
		ENDIF

		IF car2_cpcounter = 14
			car2_x_d1 = cp16_x_d1
			car2_y_d1 = cp16_y_d1
			car2_z_d1 = cp16_z_d1
		ENDIF

		IF car2_cpcounter = 15
			car2_x_d1 = cp17_x_d1
			car2_y_d1 = cp17_y_d1
			car2_z_d1 = cp17_z_d1
		ENDIF
		
		IF car2_cpcounter = 16
			car2_x_d1 = cp18_x_d1
			car2_y_d1 = cp18_y_d1
			car2_z_d1 = cp18_z_d1
		ENDIF
		
		IF car2_cpcounter = 17
			car2_x_d1 = cp2_x_d1
			car2_y_d1 = cp2_y_d1
			car2_z_d1 = cp2_z_d1
			ai_car2_locate_size = 6.0
		ENDIF

		IF car2_cpcounter = 18
//		AND	position > 0
			PRINT_NOW DIAB1_3 5000 1 //"~r~You failed to win the race!"
			GOTO mission_d1_failed		
		ENDIF
		
		IF ai_car2_locate_size = 7.0
			CAR_GOTO_COORDINATES car2_d1 car2_x_d1 car2_y_d1 car2_z_d1
		ELSE
			CAR_GOTO_COORDINATES_ACCURATE car2_d1 car2_x_d1 car2_y_d1 car2_z_d1
		ENDIF

	ENDIF
ELSE

	IF NOT IS_CAR_IN_WATER car2_d1
		behind_car2 = 0
		car2_cpcounter = 0
	ENDIF

	IF IS_CAR_IN_WATER car2_d1
		IF NOT IS_CAR_ON_SCREEN car2_d1
			GET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
			GET_CLOSEST_CAR_NODE car2_x car2_y car2_z car2_x car2_y car2_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_x car2_y car2_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car2_x car2_y car2_z 3.0
					SET_CAR_COORDINATES car2_d1 car2_x car2_y car2_z
					TURN_CAR_TO_FACE_COORD car2_d1 car2_x_d1 car2_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD car3_d1
	
	GET_CAR_HEALTH car3_d1 car3_health
	IF car3_health < 500
		SET_CAR_HEALTH car3_d1 1000
	ENDIF

	IF NOT player_cpcounter	= car3_cpcounter	
		IF player_cpcounter < car3_cpcounter
			behind_car3 = 1
		ELSE
			behind_car3 = 0
		ENDIF
	ELSE
		GET_CAR_COORDINATES	car3_d1 car3_x car3_y car3_z
		difference_x_float_d = car3_x - player_x_d1
		difference_y_float_d = car3_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy car3_distance_from_cp

		GET_PLAYER_COORDINATES player players_x players_y players_z
		difference_x_float_d = players_x - player_x_d1
		difference_y_float_d = players_y - player_y_d1
		difference_x_float_d = difference_x_float_d * difference_x_float_d
		difference_y_float_d = difference_y_float_d * difference_y_float_d
		sum_difference_d_xy = difference_x_float_d + difference_y_float_d
		SQRT sum_difference_d_xy players_distance_from_cp

		IF players_distance_from_cp < car3_distance_from_cp
			behind_car3 = 0
		ELSE
			behind_car3 = 1
		ENDIF
	ENDIF
	
	IF LOCATE_CAR_3D car3_d1 car3_stuck_x car3_stuck_y car3_stuck_z 4.0 4.0 4.0 0
		IF timerf_reset_flag = 0
			GET_GAME_TIMER timerf_started
			timerf_reset_flag = 1
		ENDIF

		IF timerf_reset_flag = 1
			GET_GAME_TIMER timerf_current
			timerf = timerf_current - timerf_started
			IF timerf > 8000
				IF NOT IS_CAR_ON_SCREEN car3_d1
					GET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
					GET_CLOSEST_CAR_NODE car3_x car3_y car3_z car3_x car3_y car3_z
					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_x car3_y car3_z 4.0 4.0 4.0
						IF NOT IS_POINT_ON_SCREEN car3_x car3_y car3_z 4.0
							SET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
							TURN_CAR_TO_FACE_COORD car3_d1 car3_x_d1 car3_y_d1
							timerf_reset_flag = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF NOT LOCATE_CAR_3D car3_d1 car3_stuck_x car3_stuck_y car3_stuck_z 4.0 4.0 4.0 0
		GET_CAR_COORDINATES car3_d1 car3_stuck_x car3_stuck_y car3_stuck_z
		timerf_reset_flag = 0
	ENDIF
	
	IF IS_CAR_UPSIDEDOWN car3_d1
	AND IS_CAR_STOPPED car3_d1
		IF NOT IS_CAR_ON_SCREEN car3_d1
			GET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
			GET_CLOSEST_CAR_NODE car3_x car3_y car3_z car3_x car3_y car3_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_x car3_y car3_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car3_x car3_y car3_z 3.0
					SET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
					TURN_CAR_TO_FACE_COORD car3_d1 car3_x_d1 car3_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF timerc_reset_flag_d1 = 1
		IF NOT IS_CAR_STOPPED car3_d1
			timerc_reset_flag_d1 = 0
		ENDIF
	ENDIF
		
	IF IS_CAR_STOPPED car3_d1
		IF timerc_reset_flag_d1 = 0
			GET_GAME_TIMER timerc_started
			timerc_reset_flag_d1 = 1
		ENDIF

		IF timerc_reset_flag_d1 = 1
			GET_GAME_TIMER timerc_current
			timerc = timerc_current - timerc_started
			IF timerc > 5000
				IF NOT IS_CAR_ON_SCREEN car3_d1
					GET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
					GET_CLOSEST_CAR_NODE car3_x car3_y car3_z car3_x car3_y car3_z
					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_x car3_y car3_z 4.0 4.0 4.0
						IF NOT IS_POINT_ON_SCREEN car3_x car3_y car3_z 4.0
							SET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
							TURN_CAR_TO_FACE_COORD car3_d1 car3_x_d1 car3_y_d1
							timerc_reset_flag_d1 = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF LOCATE_CAR_3D car3_d1 car3_x_d1 car3_y_d1 car3_z_d1 ai_car3_locate_size ai_car3_locate_size ai_car3_locate_size 0
		++ car3_cpcounter

		IF car3_cpcounter = 1
			car3_x_d1 = cp3_x_d1
			car3_y_d1 = cp3_y_d1
			car3_z_d1 = cp3_z_d1
		ENDIF

		IF car3_cpcounter = 2
			car3_x_d1 = cp4_x_d1
			car3_y_d1 = cp4_y_d1
			car3_z_d1 = cp4_z_d1
		ENDIF

		IF car3_cpcounter = 3
			car3_x_d1 = cp5_x_d1
			car3_y_d1 = cp5_y_d1
			car3_z_d1 = cp5_z_d1
		ENDIF

		IF car3_cpcounter = 4
			car3_x_d1 = cp6_x_d1
			car3_y_d1 = cp6_y_d1
			car3_z_d1 = cp6_z_d1
		ENDIF

		IF car3_cpcounter = 5
			car3_x_d1 = cp7_x_d1
			car3_y_d1 = cp7_y_d1
			car3_z_d1 = cp7_z_d1
		ENDIF

		IF car3_cpcounter = 6
			car3_x_d1 = cp8_x_d1
			car3_y_d1 = cp8_y_d1
			car3_z_d1 = cp8_z_d1
		ENDIF

		IF car3_cpcounter = 7
			car3_x_d1 = cp9_x_d1
			car3_y_d1 = cp9_y_d1
			car3_z_d1 = cp9_z_d1
		ENDIF

		IF car3_cpcounter = 8
			car3_x_d1 = cp10_x_d1
			car3_y_d1 = cp10_y_d1
			car3_z_d1 = cp10_z_d1
		ENDIF

		IF car3_cpcounter = 9
			car3_x_d1 = cp11_x_d1
			car3_y_d1 = cp11_y_d1
			car3_z_d1 = cp11_z_d1
		ENDIF

		IF car3_cpcounter = 10
			car3_x_d1 = cp12_x_d1
			car3_y_d1 = cp12_y_d1
			car3_z_d1 = cp12_z_d1
		ENDIF

		IF car3_cpcounter = 11
			car3_x_d1 = cp13_x_d1
			car3_y_d1 = cp13_y_d1
			car3_z_d1 = cp13_z_d1
		ENDIF

		IF car3_cpcounter = 12
			car3_x_d1 = cp14_x_d1
			car3_y_d1 = cp14_y_d1
			car3_z_d1 = cp14_z_d1
		ENDIF

		IF car3_cpcounter = 13
			car3_x_d1 = cp15_x_d1
			car3_y_d1 = cp15_y_d1
			car3_z_d1 = cp15_z_d1
		ENDIF

		IF car3_cpcounter = 14
			car3_x_d1 = cp16_x_d1
			car3_y_d1 = cp16_y_d1
			car3_z_d1 = cp16_z_d1
		ENDIF

		IF car3_cpcounter = 15
			car3_x_d1 = cp17_x_d1
			car3_y_d1 = cp17_y_d1
			car3_z_d1 = cp17_z_d1
		ENDIF
		
		IF car3_cpcounter = 16
			car3_x_d1 = cp18_x_d1
			car3_y_d1 = cp18_y_d1
			car3_z_d1 = cp18_z_d1
		ENDIF
		
		IF car3_cpcounter = 17
			car3_x_d1 = cp2_x_d1
			car3_y_d1 = cp2_y_d1
			car3_z_d1 = cp2_z_d1
			ai_car3_locate_size = 6.0
		ENDIF

		IF car3_cpcounter = 18
//		AND	position > 0
			PRINT_NOW DIAB1_3 5000 1 //"~r~You failed to win the race!"
			GOTO mission_d1_failed		
		ENDIF

		IF ai_car3_locate_size = 7.0
			CAR_GOTO_COORDINATES car3_d1 car3_x_d1 car3_y_d1 car3_z_d1 
		ELSE
			CAR_GOTO_COORDINATES_ACCURATE car3_d1 car3_x_d1 car3_y_d1 car3_z_d1 
		ENDIF

	ENDIF
ELSE

	IF NOT IS_CAR_IN_WATER car3_d1
		behind_car3 = 0
		car3_cpcounter = 0
	ENDIF

	IF IS_CAR_IN_WATER car3_d1
		IF NOT IS_CAR_ON_SCREEN car3_d1
			GET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
			GET_CLOSEST_CAR_NODE car3_x car3_y car3_z car3_x car3_y car3_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_x car3_y car3_z 4.0 4.0 4.0
				IF NOT IS_POINT_ON_SCREEN car3_x car3_y car3_z 3.0
					SET_CAR_COORDINATES car3_d1 car3_x car3_y car3_z
					TURN_CAR_TO_FACE_COORD car3_d1 car3_x_d1 car3_y_d1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ENDIF

GOTO loop1
}	   		
	
// Mission d1 failed

mission_d1_failed:
PRINT_BIG M_FAIL 2000 1
RETURN

   

// mission d1 passed

mission_d1_passed:

GET_GAME_TIMER game_timer_end_d1
game_timer_end_d1 = game_timer_end_d1 - game_timer_start_d1
game_timer_end_d1 = game_timer_end_d1 / 1000
ADD_SCORE player 10000
PRINT_WITH_NUMBER_BIG M_PASS 10000 5000 1
PRINT_WITH_NUMBER_NOW DIAB1_2 game_timer_end_d1 5000 1 //"Race time: ~1~ seconds"
REGISTER_EL_BURRO_TIME game_timer_end_d1
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
//CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_DIABLO THREAT_PLAYER1

IF flag_diablo1_passed_before = 0
	REGISTER_MISSION_PASSED	DIAB1
	PLAYER_MADE_PROGRESS 1
	flag_diablo_mission1_passed = 1
	START_NEW_SCRIPT diablo_mission2_loop
	flag_diablo1_passed_before = 1
ENDIF

RETURN
		

// mission cleanup

mission_cleanup_d1:

SWITCH_ROADS_ON 1034.0 -956.0 12.0 1063.0 -847.0 20.0

REMOVE_BLIP blip_car1_d1
REMOVE_BLIP blip_car2_d1
REMOVE_BLIP blip_car3_d1
REMOVE_BLIP blip_chase_d1
REMOVE_BLIP second_blip
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_B
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
CLEAR_ONSCREEN_COUNTER game_timer_end_d1

flag_player_on_mission = 0
flag_player_on_diablo_mission = 0
MISSION_HAS_FINISHED
RETURN
		



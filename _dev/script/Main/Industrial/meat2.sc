MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// ***********************************Meat Factory Mission 2**********************************
// *****************************************"The Thieves"*************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME meat2

// Mission Start Stuff

GOSUB mission_start_meat2

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_failed_meat2
	ENDIF

GOSUB mission_cleanup_meat2

MISSION_END


// Variable for mission

VAR_INT car_meat2

VAR_INT victim1_meat2

VAR_INT victim2_meat2

VAR_INT radar_blip_car_meat2

VAR_INT radar_blip_ped1_meat2

VAR_INT radar_blip_ped2_meat2

VAR_INT flag_player_had_car_message_meat2

VAR_INT radar_blip_coord2_meat2

VAR_INT flag_victim1_in_area

VAR_INT flag_victim2_in_area

VAR_INT radar_blip_coord3_meat2

VAR_INT flag_car_in_area_meat2

VAR_FLOAT doorx

VAR_FLOAT doory

VAR_FLOAT doorz

VAR_INT flag_remove_blip1_meat2

VAR_INT flag_remove_blip2_meat2

VAR_INT flag_car_in_zone2_meat2

VAR_INT radar_blip_coord4_meat2

VAR_INT flag_player_had_out_car_message_meat2

// ****************************************Mission Start************************************

mission_start_meat2:

flag_player_on_mission = 1

flag_player_on_meat_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_meat2 = 0

flag_victim1_in_area = 0

flag_victim2_in_area = 0

flag_car_in_area_meat2 = 0

blob_flag = 1

flag_remove_blip1_meat2 = 0

flag_remove_blip2_meat2 = 0

flag_car_in_zone2_meat2 = 0

flag_player_had_out_car_message_meat2 = 0

{

// *******************************START OF CUTSCENE*****************************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_failed_meat2
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( MEA2 ) 15000 2 //"THE THIEVES"

SWITCH_STREAMING OFF

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH	 

WHILE GET_FADING_STATUS
					  
	WAIT 0

ENDWHILE
*/


SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 1164.25 -888.87 10.0 1291.76 -811.71 20.0

//LOAD_ALL_MODELS_NOW

//WHILE NOT HAS_MODEL_LOADED cut_obj1

//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE mt_ph2 
SET_CUTSCENE_OFFSET 1223.88 -839.414 13.95
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player


DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( MEA2_A ) 10000 1 //"I hired some..." 

WHILE cs_time < 4424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_B ) 10000 1  //"and steal some..." 

WHILE cs_time < 8124
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_C ) 10000 1  //"The thieveing bastards..." 

WHILE cs_time < 10996
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_D ) 10000 1 //"IF I don't...." 

WHILE cs_time < 12362
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_E ) 10000 1 //"Can you believe..." 

WHILE cs_time < 13728
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_F ) 10000 1  //I've left a car..." 

WHILE cs_time < 16082
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_G ) 10000 1  //"Use it to..." 

WHILE cs_time < 19591
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA2_H ) 10000 1  //"Them bring 'em..."

WHILE cs_time < 24155
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( MEA2_H )

WHILE cs_time < 25233
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

//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

SET_PED_DENSITY_MULTIPLIER 1.0

// **************************************END OF CUTSCENE************************************


REQUEST_MODEL PED_CRIMINAL1

REQUEST_MODEL PED_CRIMINAL2

REQUEST_MODEL CAR_SENTINEL


WHILE NOT HAS_MODEL_LOADED PED_CRIMINAL1
OR NOT HAS_MODEL_LOADED PED_CRIMINAL2
OR NOT HAS_MODEL_LOADED CAR_SENTINEL

	WAIT 0

ENDWHILE

//PRINT_BIG ( MEA2 ) 15000 2 //"The Thieves"

//WAIT 1000

CREATE_CAR CAR_SENTINEL 1190.0 -796.0 13.8 car_meat2

SET_CAR_HEADING car_meat2 300.0

ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_meat2

	WAIT 0
		
	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_car_meat2

PRINT_NOW ( MEA2_B3 ) 7000 1 //"Go and meet the creditors."

CREATE_CHAR PEDTYPE_CIVMALE PED_CRIMINAL1 869.0 -611.0 -100.0 victim1_meat2

CLEAR_CHAR_THREAT_SEARCH victim1_meat2

TURN_CHAR_TO_FACE_COORD victim1_meat2 869.0 -615.0 -100.0

SET_CHAR_CANT_BE_DRAGGED_OUT victim1_meat2 TRUE

ADD_BLIP_FOR_CHAR victim1_meat2 radar_blip_ped1_meat2

CREATE_CHAR PEDTYPE_CIVMALE PED_CRIMINAL2 871.0 -612.0 -100.0 victim2_meat2

CLEAR_CHAR_THREAT_SEARCH victim2_meat2

TURN_CHAR_TO_FACE_COORD victim2_meat2 869.0 -615.0 -100.0

SET_CHAR_CANT_BE_DRAGGED_OUT victim2_meat2 TRUE

ADD_BLIP_FOR_CHAR victim2_meat2 radar_blip_ped2_meat2

// waiting for the player to get to the creditors

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player victim1_meat2 8.0 8.0 FALSE
OR NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player victim2_meat2 8.0 8.0 FALSE 
OR NOT IS_PLAYER_IN_CAR player car_meat2

	WAIT 0
		
	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF
	
	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
   	
	IF NOT IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2
		REMOVE_BLIP radar_blip_ped1_meat2
		REMOVE_BLIP radar_blip_ped2_meat2
		flag_player_had_car_message_meat2 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 1
		REMOVE_BLIP radar_blip_car_meat2
		ADD_BLIP_FOR_CHAR victim1_meat2 radar_blip_ped1_meat2
		ADD_BLIP_FOR_CHAR victim2_meat2 radar_blip_ped2_meat2
		flag_player_had_car_message_meat2 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF
	
ENDWHILE

// tells the two thieves to get into the car

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER victim1_meat2 car_meat2

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER victim2_meat2 car_meat2 
		 				 
WHILE NOT IS_CHAR_IN_CAR victim1_meat2 car_meat2
OR NOT IS_CHAR_IN_CAR victim2_meat2 car_meat2
OR NOT IS_PLAYER_IN_CAR player car_meat2
   
	WAIT 0
      	
	IF IS_CAR_DEAD car_meat2

		IF IS_CHAR_DEAD victim1_meat2
		OR IS_CHAR_DEAD victim2_meat2
			PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
			GOTO mission_failed_meat2
		ELSE 
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim1_meat2 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA2_4 ) 5000 1 //"You have left a creditor behind!"
			GOTO mission_failed_meat2
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim2_meat2 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA2_4 ) 5000 1 //"You have left a creditor behind!"
			GOTO mission_failed_meat2
		ENDIF

	ENDIF
	
	IF NOT IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2
		REMOVE_BLIP radar_blip_ped1_meat2
		REMOVE_BLIP radar_blip_ped2_meat2
		flag_player_had_car_message_meat2 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 1
		REMOVE_BLIP radar_blip_car_meat2
		ADD_BLIP_FOR_CHAR victim1_meat2 radar_blip_ped1_meat2
		ADD_BLIP_FOR_CHAR victim2_meat2 radar_blip_ped2_meat2
		flag_player_had_car_message_meat2 = 0
		blob_flag = 1
	ENDIF

    IF IS_CHAR_IN_CAR victim1_meat2 car_meat2
	AND flag_remove_blip1_meat2 = 0
	   REMOVE_BLIP radar_blip_ped1_meat2
	   flag_remove_blip1_meat2 = 1
	ENDIF
	
	IF IS_CHAR_IN_CAR victim2_meat2 car_meat2
	AND flag_remove_blip2_meat2 = 0
	   REMOVE_BLIP radar_blip_ped2_meat2
	   flag_remove_blip2_meat2 = 1
	ENDIF
	
	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF 
      
ENDWHILE

REMOVE_BLIP radar_blip_ped1_meat2

REMOVE_BLIP radar_blip_ped2_meat2

PRINT_NOW ( MEA2_B4 ) 7000 1 //"Take us to the Bitch'n Dog Food Factory"

ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat2

blob_flag = 1

WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_3D	victim1_meat2 1205.7 -789.2 13.9 4.0 4.0 6.0 blob_flag
OR NOT LOCATE_STOPPED_CHAR_IN_CAR_3D victim2_meat2 1205.7 -789.2 13.9 4.0 4.0 6.0 FALSE
OR NOT IS_CHAR_IN_CAR victim1_meat2 car_meat2
OR NOT IS_CHAR_IN_CAR victim2_meat2 car_meat2

	WAIT 0
			
	IF IS_CAR_DEAD car_meat2

		IF IS_CHAR_DEAD victim1_meat2
		OR IS_CHAR_DEAD victim2_meat2
			PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
			GOTO mission_failed_meat2
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat2
		ENDIF
		
	ENDIF
	
	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim1_meat2 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA2_4 ) 5000 1 //"You have left a creditor behind!"
			GOTO mission_failed_meat2
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim2_meat2 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA2_4 ) 5000 1 //"You have left a creditor behind!"
			GOTO mission_failed_meat2
		ENDIF

	ENDIF
	
   	IF NOT IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2
		REMOVE_BLIP radar_blip_coord2_meat2
		flag_player_had_car_message_meat2 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 1
		REMOVE_BLIP radar_blip_car_meat2
		ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat2
		flag_player_had_car_message_meat2 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord2_meat2

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_CHAR_CANT_BE_DRAGGED_OUT victim1_meat2 FALSE

SET_CHAR_OBJ_LEAVE_CAR victim1_meat2 car_meat2

SET_CHAR_CANT_BE_DRAGGED_OUT victim2_meat2 FALSE

SET_CHAR_OBJ_LEAVE_CAR victim2_meat2 car_meat2

WHILE IS_CHAR_IN_CAR victim1_meat2 car_meat2
AND IS_CHAR_IN_CAR victim2_meat2 car_meat2 
	
	WAIT 0
      	
	IF IS_CAR_DEAD car_meat2

		IF IS_CHAR_DEAD victim1_meat2
		OR IS_CHAR_DEAD victim2_meat2
			PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
			GOTO mission_failed_meat2
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat2
		ENDIF
		
	ENDIF
	
	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT victim1_meat2 1203.3 -801.7

WAIT 500

IF IS_CHAR_DEAD victim2_meat2
	PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
	GOTO mission_failed_meat2
ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT victim2_meat2 1202.4 -800.0

SET_FIXED_CAMERA_POSITION 1201.8 -784.7 17.0 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1204.4 -802.7 15.0 JUMP_CUT

CLEAR_AREA 1201.8 -799.7 13.8 10.0 TRUE

timerb = 0

// Waiting for the blokes to get to the meat grinding area

WHILE NOT flag_victim1_in_area = 2
OR NOT flag_victim2_in_area = 2

	WAIT 0
	
	IF NOT ROTATE_OBJECT doggy_door 135.0 5.0 FALSE					   				   
		GET_OBJECT_COORDINATES doggy_door doorx doory doorz					   						 
	ENDIF

	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF
	   			
	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
	
   	IF flag_victim1_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D victim1_meat2 1203.3 -801.7 0.5 0.5 FALSE
			flag_victim1_in_area = 1
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT victim1_meat2 1209.4 -807.2
		ENDIF

	ENDIF

	IF flag_victim1_in_area = 1

		IF LOCATE_CHAR_ON_FOOT_3D victim1_meat2 1209.4 -807.2 14.0 4.0 4.0 4.0 FALSE
			flag_victim1_in_area = 2
		ENDIF

	ENDIF
		
	
	IF flag_victim2_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D victim2_meat2 1202.4 -800.0 0.5 0.5 FALSE
			flag_victim2_in_area = 1
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT victim2_meat2 1209.4 -807.2
		ENDIF
	
	ENDIF

	IF flag_victim2_in_area = 1

		IF LOCATE_CHAR_ON_FOOT_3D victim2_meat2 1209.4 -807.2 14.0 4.0 4.0 4.0 FALSE
			flag_victim2_in_area = 2
		ENDIF
	
	ENDIF

	IF timerb >= 30000

		IF NOT flag_victim1_in_area = 2
		OR NOT flag_victim2_in_area = 2
			REMOVE_CHAR_ELEGANTLY victim1_meat2
			REMOVE_CHAR_ELEGANTLY victim2_meat2
			GOTO mission_bloke_stuck 
		ENDIF
		
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF

ENDWHILE

mission_bloke_stuck:

LOAD_MISSION_AUDIO MF4_B

// Shuts the door

WHILE NOT ROTATE_OBJECT doggy_door 45.0 5.0 FALSE
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF
	   			
	IF IS_CHAR_DEAD victim1_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF
	
	IF IS_CHAR_DEAD victim2_meat2
		PRINT_NOW ( MEA2_2 ) 5000 1 //"A creditor's dead!"
		GOTO mission_failed_meat2
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF
	
ENDWHILE

RESTORE_CAMERA_JUMPCUT

REMOVE_CHAR_ELEGANTLY victim1_meat2

REMOVE_CHAR_ELEGANTLY victim2_meat2

PLAY_MISSION_AUDIO

WHILE NOT HAS_MISSION_AUDIO_FINISHED 

	WAIT 0

	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF

ENDWHILE

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

PRINT_SOON ( MEA2_B6 ) 5000 1 //"Take the car to the crusher to get rid of evidence, get out of the car and the crane will pick it up."

ADD_SPRITE_BLIP_FOR_COORD 924.0 -361.0 10.0 RADAR_SPRITE_SPRAY radar_blip_coord3_meat2 

HAS_RESPRAY_HAPPENED sprayshop1

// waiting for the player to respray the car

WHILE NOT HAS_RESPRAY_HAPPENED sprayshop1
OR NOT IS_PLAYER_IN_CAR player car_meat2
OR NOT IS_PLAYER_STOPPED_IN_AREA_2D player 922.6 -366.1 928.6 -354.3 FALSE

	WAIT 0

	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2
		REMOVE_BLIP radar_blip_coord3_meat2
		flag_player_had_car_message_meat2 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat2
	AND flag_player_had_car_message_meat2 = 1
		REMOVE_BLIP radar_blip_car_meat2
		ADD_SPRITE_BLIP_FOR_COORD 924.0 -361.0 10.0 RADAR_SPRITE_SPRAY radar_blip_coord3_meat2
		flag_player_had_car_message_meat2 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord3_meat2

PRINT_NOW ( MEA2_3 ) 5000 1 //"Dump the car by the road bridge in Chinatown."

ADD_BLIP_FOR_COORD 1195.6 -805.0 13.7 radar_blip_coord4_meat2

blob_flag = 1

WHILE NOT LOCATE_STOPPED_CAR_3D car_meat2 1195.6 -805.0 13.7 4.0 4.0 4.0 blob_flag
OR IS_PLAYER_IN_CAR player car_meat2

	WAIT 0

	IF IS_CAR_DEAD car_meat2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat2
	ENDIF

	IF LOCATE_STOPPED_CAR_3D car_meat2 1195.6 -805.0 13.7 4.0 4.0 4.0 FALSE
		
		IF flag_player_had_out_car_message_meat2 = 0
			PRINT_NOW ( OUT_VEH ) 5000 1 //"Get out of the vehicle!"
			flag_player_had_out_car_message_meat2 = 1
		ENDIF
		flag_car_in_zone2_meat2 = 1
	ELSE
		flag_car_in_zone2_meat2 = 0
		flag_player_had_out_car_message_meat2 = 0
	ENDIF

	IF flag_car_in_zone2_meat2 = 0

		IF NOT IS_PLAYER_IN_CAR player car_meat2
		AND flag_player_had_car_message_meat2 = 0
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
			ADD_BLIP_FOR_CAR car_meat2 radar_blip_car_meat2
			REMOVE_BLIP radar_blip_coord4_meat2
			flag_player_had_car_message_meat2 = 1
			blob_flag = 0
		ENDIF

		IF IS_PLAYER_IN_CAR player car_meat2
		AND flag_player_had_car_message_meat2 = 1
			REMOVE_BLIP radar_blip_car_meat2
			ADD_BLIP_FOR_COORD 1195.6 -805.0 13.7 radar_blip_coord4_meat2
			flag_player_had_car_message_meat2 = 0
			blob_flag = 1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat2
	AND IS_CAR_STOPPED car_meat2
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat2
	ENDIF
	
ENDWHILE

IF NOT IS_CAR_DEAD car_meat2
	CHANGE_CAR_LOCK car_meat2 CARLOCK_LOCKED
ENDIF

REMOVE_BLIP radar_blip_coord4_meat2

}

GOTO mission_passed_meat2

// Mission Failed

mission_failed_meat2:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


		
// Mission Passed
	
mission_passed_meat2:

PRINT_WITH_NUMBER_BIG ( m_pass ) 3000 5000 1 //"Mission Passed!"
REGISTER_MISSION_PASSED ( MEA2 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 2000
flag_meat_mission2_passed = 1
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT meat_mission3_loop
RETURN


// Mission Cleanup

mission_cleanup_meat2:

flag_player_on_mission = 0
flag_player_on_meat_mission = 0
REMOVE_CHAR_ELEGANTLY victim1_meat2
REMOVE_CHAR_ELEGANTLY victim2_meat2
MARK_MODEL_AS_NO_LONGER_NEEDED PED_CRIMINAL1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_CRIMINAL2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
REMOVE_BLIP radar_blip_ped1_meat2
REMOVE_BLIP radar_blip_ped2_meat2
REMOVE_BLIP radar_blip_car_meat2
REMOVE_BLIP radar_blip_coord2_meat2
REMOVE_BLIP radar_blip_coord3_meat2
REMOVE_BLIP radar_blip_coord4_meat2
MISSION_HAS_FINISHED
RETURN



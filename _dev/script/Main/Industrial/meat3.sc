MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// ***********************************Meat Factory Mission 3**********************************
// *****************************************"The Wife"****************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME meat3

// Mission Start Stuff

GOSUB mission_start_meat3

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_failed_meat3
	ENDIF

GOSUB mission_cleanup_meat3

MISSION_END


// Variable for mission

VAR_INT car_meat3

VAR_INT wife_meat3

VAR_INT radar_blip_car_meat3

VAR_INT radar_blip_ped1_meat3

VAR_INT flag_player_had_car_message_meat3

VAR_INT radar_blip_coord2_meat3

VAR_INT flag_wife_in_area

// ****************************************Mission Start************************************

mission_start_meat3:

flag_player_on_mission = 1

flag_player_on_meat_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_meat3 = 0

flag_wife_in_area = 0

blob_flag = 1

{

// *****************************************START OF CUTSCENE*******************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_failed_meat3
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( MEA3 ) 15000 2 //"THE WIFE"	

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

LOAD_CUTSCENE mt_ph3 
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
PRINT_NOW ( MEA3_A ) 10000 1 //"The business..." 

WHILE cs_time < 6470
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA3_B ) 10000 1  //"My wife has..." 

WHILE cs_time < 11321
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA3_C ) 10000 1  //"I've left a car..." 

WHILE cs_time < 13506
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA3_D ) 10000 1 //"Go and pick her...."

WHILE cs_time < 17471
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( MEA3_D ) 

WHILE cs_time < 18333
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

// *****************************************END OF CUTSCENE*********************************

REQUEST_MODEL PED_FEMALE2

REQUEST_MODEL CAR_ESPERANTO

LOAD_MISSION_AUDIO MF2_A

WHILE NOT HAS_MODEL_LOADED PED_FEMALE2
OR NOT HAS_MODEL_LOADED CAR_ESPERANTO
OR NOT HAS_MISSION_AUDIO_LOADED 

	WAIT 0

ENDWHILE

CREATE_CAR CAR_ESPERANTO 1190.0 -796.0 13.8 car_meat3

SET_CAR_HEADING car_meat3 300.0

ADD_BLIP_FOR_CAR car_meat3 radar_blip_car_meat3

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_meat3

	WAIT 0
	    	
	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF
      	
ENDWHILE

REMOVE_BLIP radar_blip_car_meat3

PRINT_NOW ( MEA3_B3 ) 7000 1 //"Get the wife, press the horn to get her into the car!"

CREATE_CHAR PEDTYPE_CIVFEMALE PED_FEMALE2 1064.0 -378.0 13.9 wife_meat3

CLEAR_CHAR_THREAT_SEARCH wife_meat3

TURN_CHAR_TO_FACE_COORD wife_meat3 1059.0 -378.0 100.0

ADD_BLIP_FOR_CHAR wife_meat3 radar_blip_ped1_meat3

SET_CHAR_CANT_BE_DRAGGED_OUT wife_meat3 TRUE

// Waiting for the player to be in the area

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player wife_meat3 8.0 8.0 FALSE
OR NOT IS_PLAYER_IN_CAR player car_meat3

	WAIT 0
  	
	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF
	
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF
	
   	IF NOT IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat3 radar_blip_car_meat3
		REMOVE_BLIP radar_blip_ped1_meat3
		flag_player_had_car_message_meat3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 1
		REMOVE_BLIP radar_blip_car_meat3
		ADD_BLIP_FOR_CHAR wife_meat3 radar_blip_ped1_meat3
		flag_player_had_car_message_meat3 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF
	
ENDWHILE

// tells the wife to get into players car

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER wife_meat3 car_meat3

WHILE NOT IS_CHAR_IN_CAR wife_meat3 car_meat3
OR NOT IS_PLAYER_IN_CAR player car_meat3

	WAIT 0
	
	IF IS_CAR_DEAD car_meat3

		IF IS_CHAR_DEAD wife_meat3
			PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
			GOTO mission_failed_meat3
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat3
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player wife_meat3 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA3_3 ) 5000 1 //"You have left his wife behind"
			GOTO mission_failed_meat3
		ENDIF
	
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat3 radar_blip_car_meat3
		REMOVE_BLIP radar_blip_ped1_meat3
		flag_player_had_car_message_meat3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 1
		REMOVE_BLIP radar_blip_car_meat3
		ADD_BLIP_FOR_CHAR wife_meat3 radar_blip_ped1_meat3
		flag_player_had_car_message_meat3 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF
			
ENDWHILE 

REMOVE_BLIP radar_blip_ped1_meat3

PLAY_MISSION_AUDIO

PRINT_NOW ( MEA3_B4 ) 7000 1 //"Marty wants to see me? Well it better be quick because I have a slot booked at the gym, and a hair appointment after that."

ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat3

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( MEA3_B4 )
ENDIF

blob_flag = 1

// waiting for the wife to be at the factory

WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_3D	wife_meat3 1205.7 -789.2 13.9 4.0 4.0 6.0 blob_flag
OR NOT IS_CHAR_IN_CAR wife_meat3 car_meat3
	
	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED
		CLEAR_THIS_PRINT ( MEA3_B4 )
	ENDIF
		
	IF IS_CAR_DEAD car_meat3

		IF IS_CHAR_DEAD wife_meat3
			PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
			GOTO mission_failed_meat3
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat3
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player wife_meat3 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA3_3 ) 5000 1 //"You have left his wife behind"
			GOTO mission_failed_meat3
		ENDIF
	
	ENDIF	
      
	IF NOT IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat3 radar_blip_car_meat3
		REMOVE_BLIP radar_blip_coord2_meat3
		flag_player_had_car_message_meat3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat3
	AND flag_player_had_car_message_meat3 = 1
		REMOVE_BLIP radar_blip_car_meat3
		ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat3
		flag_player_had_car_message_meat3 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord2_meat3

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_CHAR_CANT_BE_DRAGGED_OUT wife_meat3 FALSE

SET_CHAR_OBJ_LEAVE_CAR wife_meat3 car_meat3

WHILE IS_CHAR_IN_CAR wife_meat3 car_meat3

	WAIT 0
    	
	IF IS_CAR_DEAD car_meat3

		IF IS_CHAR_DEAD wife_meat3
			PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
			GOTO mission_failed_meat3
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat3
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF
      
ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT wife_meat3 1204.2 -801.9

SET_FIXED_CAMERA_POSITION 1201.8 -784.7 17.0 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1204.4 -802.7 15.0 JUMP_CUT

CLEAR_AREA 1200.8 -799.3 14.0 10.0 TRUE

timerb = 0

// Waiting for the wifes to get to the meat grinding area

WHILE NOT flag_wife_in_area = 1

	WAIT 0
      
	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF
			
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF
         
	IF flag_wife_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D wife_meat3 1204.2 -801.9 0.5 0.5 FALSE
			flag_wife_in_area = 1
		ENDIF

	ENDIF

	IF timerb >= 25000

		IF NOT flag_wife_in_area = 1
			SET_CHAR_COORDINATES wife_meat3 1204.2 -801.9 13.7
			GOTO wife_stuck1
		ENDIF
		
	ENDIF
	
	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF 
		      
ENDWHILE

wife_stuck1:

// opens the door

WHILE NOT ROTATE_OBJECT doggy_door 135.0 5.0 FALSE

	WAIT 0

	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF
			
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT wife_meat3 1205.9 -805.8

timerb = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_3D wife_meat3 1205.9 -805.8 14.0 1.0 1.0 1.0 FALSE

	WAIT 0
	
	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF
			
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF

	IF timerb >= 25000
		
		IF NOT LOCATE_CHAR_ON_FOOT_3D wife_meat3 1205.9 -805.8 14.0 1.0 1.0 1.0 FALSE
			REMOVE_CHAR_ELEGANTLY wife_meat3
			GOTO mission_bloke_stuck_meat3
		ENDIF
		
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF

ENDWHILE

// Shuts the door

mission_bloke_stuck_meat3:

LOAD_MISSION_AUDIO MF4_C

WHILE NOT ROTATE_OBJECT doggy_door 45.0 5.0 FALSE
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF
			
	IF IS_CHAR_DEAD wife_meat3
		PRINT_NOW ( MEA3_1 ) 5000 1 //"The wife's dead!"
		GOTO mission_failed_meat3
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF

ENDWHILE

RESTORE_CAMERA_JUMPCUT	

REMOVE_CHAR_ELEGANTLY wife_meat3

PLAY_MISSION_AUDIO

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CAR_DEAD car_meat3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat3
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat3
	AND IS_CAR_STOPPED car_meat3
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat3
	ENDIF

ENDWHILE

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

PRINT_NOW ( MEA3_B6 ) 5000 1 //"Take the car and dump it into the sea, this will get rid of any evidence."

IF IS_CAR_DEAD car_meat3
	PRINT_NOW ( MEA3_2 ) 5000 1 //"You were told to dump the vehicle in the sea!"
	GOTO mission_failed_meat3
ENDIF

IF IS_CAR_UPSIDEDOWN car_meat3
AND IS_CAR_STOPPED car_meat3
	PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
	GOTO mission_failed_meat3
ENDIF

// waiting for the car to be dumped in the water

WHILE NOT IS_CAR_IN_WATER car_meat3

	WAIT 0

	IF IS_CAR_DEAD car_meat3
		
		IF NOT IS_CAR_IN_WATER car_meat3 
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat3
		ENDIF

	ELSE

		IF NOT IS_PLAYER_IN_CAR player car_meat3
		AND flag_player_had_car_message_meat3 = 0
			ADD_BLIP_FOR_CAR car_meat3 radar_blip_car_meat3
			flag_player_had_car_message_meat3 = 1
		ENDIF

		IF IS_PLAYER_IN_CAR player car_meat3
		AND flag_player_had_car_message_meat3 = 1
			REMOVE_BLIP radar_blip_car_meat3
			PRINT_NOW ( MEA3_B6 ) 5000 1 //"Dump the vehicle in the sea!"
			flag_player_had_car_message_meat3 = 0
		ENDIF

	ENDIF
			
ENDWHILE

} 			   
GOTO mission_passed_meat3



// Mission Failed

mission_failed_meat3:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


		
// Mission Passed
	
mission_passed_meat3:

PRINT_WITH_NUMBER_BIG ( m_pass ) 2000 5000 1 //"Mission Passed!"
REGISTER_MISSION_PASSED ( MEA3 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 3000
flag_meat_mission3_passed = 1
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT meat_mission4_loop
RETURN


// Mission Cleanup

mission_cleanup_meat3:

flag_player_on_mission = 0
flag_player_on_meat_mission = 0
REMOVE_CHAR_ELEGANTLY wife_meat3 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_FEMALE2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ESPERANTO
REMOVE_BLIP radar_blip_ped1_meat3
REMOVE_BLIP radar_blip_car_meat3
REMOVE_BLIP radar_blip_coord2_meat3
MISSION_HAS_FINISHED
RETURN



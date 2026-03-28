MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// ***********************************Meat Factory Mission 1**********************************
// *************************************"The Bank Manager"************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME meat1

// Mission Start Stuff

GOSUB mission_start_meat1

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_failed_meat1
	ENDIF

GOSUB mission_cleanup_meat1

MISSION_END


// Variable for mission

VAR_INT car_meat1

VAR_INT bankmanager_meat1

VAR_INT radar_blip_car_meat1

VAR_INT radar_blip_ped1_meat1

VAR_INT radar_blip_coord3_meat1

VAR_INT flag_player_had_car_message_meat1

VAR_INT radar_blip_coord2_meat1

VAR_INT flag_bankmanager_in_area

VAR_INT flag_car_crushed_meat1

VAR_INT flag_car_in_area_meat1

VAR_INT flag_leave_car_message_meat1

VAR_INT flag_dont_do_car_check_meat1

VAR_INT flag_player_had_crusher_help_hm5

VAR_INT flag_bankman_moved_meat1

// ****************************************Mission Start************************************

mission_start_meat1:

flag_player_on_mission = 1

flag_player_on_meat_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_meat1 = 0

flag_bankmanager_in_area = 0

flag_car_crushed_meat1 = 0

flag_car_in_area_meat1 = 0

flag_leave_car_message_meat1 = 0

flag_dont_do_car_check_meat1 = 0

blob_flag = 1

flag_player_had_crusher_help_hm5 = 0

flag_bankman_moved_meat1 = 0
{

// ******************************************START OF CUTSCENE******************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_failed_meat1
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( MEA1 ) 15000 2 //"THE CROOK"	 

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

LOAD_CUTSCENE mt_ph1 
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
PRINT_NOW ( MEA1_B ) 10000 1 //"The names Marty..." 

WHILE cs_time < 4424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_C ) 10000 1  //"I run the..." 

WHILE cs_time < 7668
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_D ) 10000 1  //"I got money..." 

WHILE cs_time < 9604
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_E ) 10000 1 //"I'm meeting...." 

WHILE cs_time < 12652
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_F ) 10000 1 //"He's a crooked..." 

WHILE cs_time < 17740
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_G ) 10000 1  //Take my car..." 

WHILE cs_time < 21290
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA1_H ) 10000 1  //"I've got a..."

WHILE cs_time < 24535
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( MEA1_H ) 

WHILE cs_time < 25666
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

// ******************************************END OF CUTSCENE********************************

REQUEST_MODEL PED_B_MAN1

REQUEST_MODEL CAR_PERENNIAL

LOAD_MISSION_AUDIO MF1_A

WHILE NOT HAS_MODEL_LOADED PED_B_MAN1
OR NOT HAS_MODEL_LOADED CAR_PERENNIAL
OR NOT HAS_MISSION_AUDIO_LOADED 

	WAIT 0

ENDWHILE

CREATE_CAR CAR_PERENNIAL 1190.0 -796.0 13.8 car_meat1

SET_CAR_HEADING car_meat1 300.0

ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_meat1

	WAIT 0
		
	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_car_meat1

PRINT_NOW ( MEA1_B3 ) 7000 1 //"Go and meet the Bank Manager."

CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN1 1039.0 -695.0 13.9 bankmanager_meat1

CLEAR_CHAR_THREAT_SEARCH bankmanager_meat1

TURN_CHAR_TO_FACE_COORD bankmanager_meat1 1042.0 -695.0 -100.0

ADD_BLIP_FOR_CHAR bankmanager_meat1 radar_blip_ped1_meat1

SET_CHAR_CANT_BE_DRAGGED_OUT bankmanager_meat1 TRUE

// waiting for the player and the Bank manager to be in the same area

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player bankmanager_meat1 8.0 8.0 FALSE
OR NOT IS_PLAYER_IN_CAR player car_meat1

	WAIT 0
			
	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF
      
	IF NOT IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1
		REMOVE_BLIP radar_blip_ped1_meat1
		flag_player_had_car_message_meat1 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 1
		REMOVE_BLIP radar_blip_car_meat1
		ADD_BLIP_FOR_CHAR bankmanager_meat1 radar_blip_ped1_meat1
		flag_player_had_car_message_meat1 = 0
		blob_flag = 1
	ENDIF
	
ENDWHILE
 
// player is at the bank manager

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER bankmanager_meat1 car_meat1

// waiting for them both to be in the car 

WHILE NOT IS_CHAR_IN_CAR bankmanager_meat1 car_meat1
OR NOT IS_PLAYER_IN_CAR player car_meat1

	WAIT 0
		
	IF IS_CAR_DEAD car_meat1

		IF IS_CHAR_DEAD bankmanager_meat1
			PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
			GOTO mission_failed_meat1
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player bankmanager_meat1 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA1_4 ) 5000 1 //You have left the Bank Manager behind!"
			GOTO mission_failed_meat1
		ENDIF

	ENDIF
		   
	IF NOT IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1
		REMOVE_BLIP radar_blip_ped1_meat1
		flag_player_had_car_message_meat1 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 1
		REMOVE_BLIP radar_blip_car_meat1
	   	ADD_BLIP_FOR_CHAR bankmanager_meat1 radar_blip_ped1_meat1
		flag_player_had_car_message_meat1 = 0
		blob_flag = 1
	ENDIF
      
ENDWHILE

REMOVE_BLIP radar_blip_ped1_meat1

PLAY_MISSION_AUDIO

PRINT_NOW ( MEA1_B4 ) 7000 1 //"Mr. Chonks sent you? Ok, take me to see him."

ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat1

IF HAS_MISSION_AUDIO_FINISHED 
	CLEAR_THIS_PRINT ( MEA1_B4 )
ENDIF

blob_flag = 1

//waiting for them to be at the Dogfood factory

WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_3D	bankmanager_meat1 1205.7 -789.2 14.8 4.0 4.0 6.0 blob_flag
OR NOT IS_CHAR_IN_CAR bankmanager_meat1 car_meat1

	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED 
		CLEAR_THIS_PRINT ( MEA1_B4 )
	ENDIF
      	
	IF IS_CAR_DEAD car_meat1

		IF IS_CHAR_DEAD bankmanager_meat1
			CLEAR_MISSION_AUDIO
			PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
			GOTO mission_failed_meat1
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
	IF IS_CHAR_DEAD bankmanager_meat1
		CLEAR_MISSION_AUDIO
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player bankmanager_meat1 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA1_4 ) 5000 1 //You have left the Bank Manager behind!"
			GOTO mission_failed_meat1
		ENDIF

	ENDIF
      
	IF NOT IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1
		REMOVE_BLIP radar_blip_coord2_meat1
		flag_player_had_car_message_meat1 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat1
	AND flag_player_had_car_message_meat1 = 1
		REMOVE_BLIP radar_blip_car_meat1
		ADD_BLIP_FOR_COORD 1205.7 -789.2 -100.0 radar_blip_coord2_meat1
		flag_player_had_car_message_meat1 = 0
		blob_flag = 1
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_coord2_meat1

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

CLEAR_AREA 1201.8 -799.7 13.8 5.0 TRUE

SET_POLICE_IGNORE_PLAYER player ON

SET_CHAR_CANT_BE_DRAGGED_OUT bankmanager_meat1 FALSE

SET_CHAR_OBJ_LEAVE_CAR bankmanager_meat1 car_meat1

WHILE IS_CHAR_IN_CAR bankmanager_meat1 car_meat1

	WAIT 0
		
	IF IS_CAR_DEAD car_meat1

		IF IS_CHAR_DEAD bankmanager_meat1
			PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
			GOTO mission_failed_meat1
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF
   
ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT bankmanager_meat1 1204.2 -801.9

SET_FIXED_CAMERA_POSITION 1201.8 -784.7 17.0 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1204.4 -802.7 15.0 JUMP_CUT

CLEAR_AREA 1200.8 -799.3 14.0 10.0 TRUE

// Waiting for the blokes to get to the meat grinding area

timerb = 0

WHILE NOT flag_bankmanager_in_area = 1

	WAIT 0
  			
	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
		
	IF flag_bankmanager_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D bankmanager_meat1 1204.2 -801.9 0.5 0.5 FALSE
			flag_bankmanager_in_area = 1
		ENDIF

	ENDIF

	IF flag_bankman_moved_meat1 = 0
		
		IF timerb >= 20000
			SET_CHAR_COORDINATES bankmanager_meat1 1204.2 -801.9 13.7 
			flag_bankman_moved_meat1 = 1
		ENDIF

	ENDIF
      
ENDWHILE

// opens the door

WHILE NOT ROTATE_OBJECT doggy_door 135.0 5.0 FALSE

	WAIT 0

	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT bankmanager_meat1 1205.9 -805.8

timerb = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_3D bankmanager_meat1 1205.9 -805.8 14.0 1.0 1.0 1.0 FALSE

	WAIT 0
	
	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF timerb >= 20000

		IF NOT LOCATE_CHAR_ON_FOOT_3D bankmanager_meat1 1205.9 -805.8 14.0 1.0 1.0 1.0 FALSE
			REMOVE_CHAR_ELEGANTLY bankmanager_meat1
			GOTO bloke_got_stuck_meat1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF

ENDWHILE

// Shuts the door

bloke_got_stuck_meat1:

LOAD_MISSION_AUDIO MF4_A

WHILE NOT ROTATE_OBJECT doggy_door 45.0 5.0 FALSE
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD bankmanager_meat1
		PRINT_NOW ( MEA1_1 ) 5000 1 //The Bank Managers dead!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF

ENDWHILE

RESTORE_CAMERA_JUMPCUT

REMOVE_CHAR_ELEGANTLY bankmanager_meat1

PLAY_MISSION_AUDIO

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
ENDWHILE	

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

PRINT_SOON ( MEA1_B6 ) 5000 1 //"Take the car to the crusher to get rid of evidence, get out of the car and the crane will pick it up."

ADD_BLIP_FOR_COORD 1138.0 52.0 -100.0 radar_blip_coord3_meat1

// waiting for the car to get to the area to be crushed

blob_flag = 1

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D car_meat1 1135.8 55.5 -1.0 1149.8 46.3 9.0 blob_flag

	WAIT 0
	         	
	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( MEA1_2 ) 5000 1 //" You idiot! The cops will find the evidence in the car."
		GOTO mission_failed_meat1
	ELSE

		IF IS_CAR_STOPPED_IN_AREA_3D car_meat1 1135.8 55.5 -1.0 1149.8 46.3 9.0 FALSE

			flag_dont_do_car_check_meat1 = 1
		
			IF flag_leave_car_message_meat1 = 0
				PRINT_NOW ( MEA1_3 ) 5000 1 //"Get out of the car!"
				flag_leave_car_message_meat1 = 1
			ENDIF

		ELSE
			flag_leave_car_message_meat1 = 0
			flag_dont_do_car_check_meat1 = 0
		ENDIF

	ENDIF

	IF flag_dont_do_car_check_meat1 = 0
			      
		IF NOT IS_PLAYER_IN_CAR player car_meat1
		AND flag_player_had_car_message_meat1 = 0
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
			ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1
			REMOVE_BLIP radar_blip_coord3_meat1
			flag_player_had_car_message_meat1 = 1
			blob_flag = 0
		ENDIF

		IF IS_PLAYER_IN_CAR player car_meat1
		AND flag_player_had_car_message_meat1 = 1
			REMOVE_BLIP radar_blip_car_meat1
			ADD_BLIP_FOR_COORD 1138.0 52.0 -100.0 radar_blip_coord3_meat1
			flag_player_had_car_message_meat1 = 0
			blob_flag = 1
		ENDIF

	ENDIF

	IF flag_player_had_crusher_help_hm5 = 0
	
		IF LOCATE_PLAYER_ANY_MEANS_2D player 1140.3 50.1 20.0 20.0 FALSE
		AND IS_PLAYER_IN_CAR player car_meat1
			PRINT_HELP ( CRUSH ) //"To crush the car..."
			flag_player_had_crusher_help_hm5 = 1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF

ENDWHILE

// waiting for the crane to pick up the car

blob_flag = 1

WHILE NOT IS_CRANE_LIFTING_CAR 1120.0 46.0 car_meat1

	WAIT 0
	   	   	
	IF IS_CAR_DEAD car_meat1
		PRINT_NOW ( MEA1_2 ) 5000 1 //" You idiot! The cops will find the evidence in the car."
		GOTO mission_failed_meat1
	ENDIF

	IF IS_CAR_STOPPED_IN_AREA_3D car_meat1 1135.8 55.5 -1.0 1149.8 46.3 20.0 blob_flag
		flag_car_in_area_meat1 = 1
	ELSE
		flag_car_in_area_meat1 = 0
	ENDIF

	IF flag_car_in_area_meat1 = 0
		      
		IF NOT IS_PLAYER_IN_CAR player car_meat1
		AND flag_player_had_car_message_meat1 = 0
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
			ADD_BLIP_FOR_CAR car_meat1 radar_blip_car_meat1
			REMOVE_BLIP radar_blip_coord3_meat1
			flag_player_had_car_message_meat1 = 1
			blob_flag = 0
		ENDIF

		IF IS_PLAYER_IN_CAR player car_meat1
		AND flag_player_had_car_message_meat1 = 1
			REMOVE_BLIP radar_blip_car_meat1
			ADD_BLIP_FOR_COORD 1138.0 52.0 -100.0 radar_blip_coord3_meat1
			flag_player_had_car_message_meat1 = 0
			blob_flag = 1
		ENDIF

	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat1
	AND IS_CAR_STOPPED car_meat1
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat1
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_coord3_meat1


// waiting for the car to be crushed

WHILE flag_car_crushed_meat1 = 0

	WAIT 0
		
	IF IS_CAR_CRUSHED car_meat1
		flag_car_crushed_meat1 = 1
		GOTO mission_passed_meat1
	ELSE
	
		IF IS_CAR_DEAD car_meat1
			PRINT_NOW ( MEA1_2 ) 5000 1 //"You idiot! The cops will find the evidence in the car."
			GOTO mission_failed_meat1
		ENDIF

	ENDIF
		
ENDWHILE

}

// Mission Failed

mission_failed_meat1:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


		
// Mission Passed
	
mission_passed_meat1:

PRINT_WITH_NUMBER_BIG ( m_pass ) 1000 5000 1 //"Mission Passed!"
REGISTER_MISSION_PASSED ( MEA1 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 1000
flag_meat_mission1_passed = 1
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT meat_mission2_loop
RETURN


// Mission Cleanup

mission_cleanup_meat1:

flag_player_on_mission = 0
flag_player_on_meat_mission = 0
REMOVE_CHAR_ELEGANTLY bankmanager_meat1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_B_MAN1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PERENNIAL
REMOVE_BLIP radar_blip_ped1_meat1
REMOVE_BLIP radar_blip_car_meat1
REMOVE_BLIP radar_blip_coord2_meat1
REMOVE_BLIP radar_blip_coord3_meat1
MISSION_HAS_FINISHED
RETURN



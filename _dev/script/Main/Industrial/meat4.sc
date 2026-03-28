MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// ***********************************Meat Factory Mission 4**********************************
// **************************************"The Loan Shark"*************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME meat4

// Mission Start Stuff

GOSUB mission_start_meat4

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_failed_meat4
	ENDIF

GOSUB mission_cleanup_meat4

MISSION_END


// Variable for mission

VAR_INT car_meat4

VAR_INT loanshark_meat4

VAR_INT owner_meat4

VAR_INT radar_blip_car_meat4

VAR_INT radar_blip_ped1_meat4

VAR_INT flag_player_had_car_message_meat4

VAR_INT radar_blip_coord2_meat4

VAR_INT flag_owner_dead_meat4

VAR_INT flag_loanshark_in_area

// ****************************************Mission Start************************************

mission_start_meat4:

flag_player_on_mission = 1

flag_player_on_meat_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_meat4 = 0

flag_loanshark_in_area = 0

flag_owner_dead_meat4 = 0

blob_flag = 1

{

// ********************************START OF CUTSCENE****************************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_failed_meat4
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( MEA4 ) 15000 2 //"HER LOVER"

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

LOAD_CUTSCENE mt_ph4 
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

WHILE cs_time < 2096
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( MEA4_A ) 10000 1 //"Damn I'm in trouble..." 

WHILE cs_time < 3885
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_B ) 10000 1  //"Turns out my wife..." 

WHILE cs_time < 7252
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_C ) 10000 1  //"He's got real..." 

WHILE cs_time < 10502
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_D ) 10000 1 //"I've agreed to see him...." 

WHILE cs_time < 11844
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_E ) 10000 1 //"He thinks that..." 

WHILE cs_time < 13374
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_F ) 10000 1  //but my guess..." 

WHILE cs_time < 14622
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( MEA4_G ) 10000 1  //"Liberty's dogs..."

WHILE cs_time < 17623
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( MEA4_G ) 

WHILE cs_time < 18233
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

// ********************************END OF CUTSCENE******************************************

REQUEST_MODEL PED_FAN_MAN2

REQUEST_MODEL PED_B_MAN2

REQUEST_MODEL CAR_STALLION

LOAD_MISSION_AUDIO MF3_A

WHILE NOT HAS_MODEL_LOADED PED_FAN_MAN2
OR NOT HAS_MODEL_LOADED PED_B_MAN2
OR NOT HAS_MODEL_LOADED CAR_STALLION
OR NOT HAS_MISSION_AUDIO_LOADED 

	WAIT 0

ENDWHILE


CREATE_CAR CAR_STALLION 1190.0 -796.0 13.8 car_meat4

SET_CAR_HEADING car_meat4 300.0

ADD_BLIP_FOR_CAR car_meat4 radar_blip_car_meat4

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_meat4

	WAIT 0
			
	IF IS_CAR_DEAD car_meat4
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat4
	AND IS_CAR_STOPPED car_meat4
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat4
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_car_meat4

PRINT_NOW ( MEA4_B3 ) 7000 1 //"Pick up the Loan Shark, press the horn to get him into the car!"

CREATE_CHAR PEDTYPE_CIVMALE PED_FAN_MAN2 897.0 -476.0 14.6 loanshark_meat4

SET_CHAR_PERSONALITY loanshark_meat4 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH loanshark_meat4

TURN_CHAR_TO_FACE_COORD loanshark_meat4 895.0 -486.0 -100.0

ADD_BLIP_FOR_CHAR loanshark_meat4 radar_blip_ped1_meat4

SET_CHAR_CANT_BE_DRAGGED_OUT loanshark_meat4 TRUE

// player is in area

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player loanshark_meat4 8.0 8.0 FALSE
OR NOT IS_PLAYER_IN_CAR player car_meat4

	WAIT 0
		
	IF IS_CAR_DEAD car_meat4
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_failed_meat4
	ENDIF
	
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF
      
	IF NOT IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat4 radar_blip_car_meat4
		REMOVE_BLIP radar_blip_ped1_meat4
		flag_player_had_car_message_meat4 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 1
		REMOVE_BLIP radar_blip_car_meat4
		ADD_BLIP_FOR_CHAR loanshark_meat4 radar_blip_ped1_meat4
		flag_player_had_car_message_meat4 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat4
	AND IS_CAR_STOPPED car_meat4
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat4
	ENDIF
	
ENDWHILE

// tells the bloke to get into the players car

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER loanshark_meat4 car_meat4

WHILE NOT IS_CHAR_IN_CAR loanshark_meat4 car_meat4
OR NOT IS_PLAYER_IN_CAR player car_meat4

	WAIT 0
			
	IF IS_CAR_DEAD car_meat4

		IF IS_CHAR_DEAD loanshark_meat4
			PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
			GOTO mission_failed_meat4
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat4
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player loanshark_meat4 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA4_3 ) 5000 1 //"You left the Loan Shark behind"
			GOTO mission_failed_meat4
		ENDIF

	ENDIF
			

	IF NOT IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat4 radar_blip_car_meat4
		REMOVE_BLIP radar_blip_ped1_meat4
		flag_player_had_car_message_meat4 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 1
		REMOVE_BLIP radar_blip_car_meat4
		ADD_BLIP_FOR_CHAR loanshark_meat4 radar_blip_ped1_meat4
		flag_player_had_car_message_meat4 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat4
	AND IS_CAR_STOPPED car_meat4
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat4
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_ped1_meat4

PLAY_MISSION_AUDIO 

PRINT_NOW ( MEA4_B4 ) 10000 1 //"This little "Spank" junkie better have my money, get me to the factory"

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( MEA4_B4 )
ENDIF

ADD_BLIP_FOR_COORD 1217.0 -794.0 -100.0 radar_blip_coord2_meat4

CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN2 1208.0 -789.0 13.9 owner_meat4

CLEAR_CHAR_THREAT_SEARCH owner_meat4

TURN_CHAR_TO_FACE_COORD owner_meat4 1210.0 -791.0 -100.0

blob_flag = 1

WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_3D	loanshark_meat4 1217.0 -794.0 13.9 4.0 4.0 6.0 blob_flag
OR NOT IS_CHAR_IN_CAR loanshark_meat4 car_meat4

	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED
		CLEAR_THIS_PRINT ( MEA4_B4 )
	ENDIF
		
	IF IS_CAR_DEAD car_meat4

		IF IS_CHAR_DEAD loanshark_meat4
			PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
			GOTO mission_failed_meat4
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat4
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ELSE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player loanshark_meat4 30.0 30.0 30.0 FALSE
			PRINT_NOW ( MEA4_3 ) 5000 1 //"You left the Loan Shark behind"
			GOTO mission_failed_meat4
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF
    
	IF NOT IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		ADD_BLIP_FOR_CAR car_meat4 radar_blip_car_meat4
		REMOVE_BLIP radar_blip_coord2_meat4
		flag_player_had_car_message_meat4 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_CAR player car_meat4
	AND flag_player_had_car_message_meat4 = 1
		REMOVE_BLIP radar_blip_car_meat4
		ADD_BLIP_FOR_COORD 1217.0 -794.0 -100.0 radar_blip_coord2_meat4
		flag_player_had_car_message_meat4 = 0
		blob_flag = 1
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat4
	AND IS_CAR_STOPPED car_meat4
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord2_meat4

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

LEAVE_GROUP loanshark_meat4

SET_CHAR_CANT_BE_DRAGGED_OUT loanshark_meat4 FALSE

SET_CHAR_OBJ_LEAVE_CAR loanshark_meat4 car_meat4

WHILE IS_CHAR_IN_CAR loanshark_meat4 car_meat4

	WAIT 0
			
	IF IS_CAR_DEAD car_meat4

		IF IS_CHAR_DEAD loanshark_meat4
			PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
			GOTO mission_failed_meat4
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_failed_meat4
		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CAR_UPSIDEDOWN car_meat4
	AND IS_CAR_STOPPED car_meat4
		PRINT_NOW ( UPSIDE ) 5000 1 //"The vehicle's upsidedown!"
		GOTO mission_failed_meat4
	ENDIF
	
ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT loanshark_meat4 1209.6 -791.0

SET_FIXED_CAMERA_POSITION 1218.1 -795.0 16.0 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1204.6 -785.7 13.9 JUMP_CUT

CLEAR_AREA 1212.0 -792.0 14.0 10.0 TRUE

LOAD_MISSION_AUDIO MF3_B

// Waiting for the blokes to get to the meat grinding area

timerb = 0

WHILE NOT flag_loanshark_in_area = 1
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0
					
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF
	   
	IF flag_loanshark_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D loanshark_meat4 1209.6 -791.0 0.5 0.5 FALSE
			flag_loanshark_in_area = 1
		ENDIF

	ENDIF

	IF timerb >= 25000

		IF NOT flag_loanshark_in_area = 1
			SET_CHAR_COORDINATES loanshark_meat4 1209.6 -791.0 13.7  
			GOTO loanshark_got_stuck
		ENDIF

	ENDIF
		
ENDWHILE

loanshark_got_stuck:

CHAR_SET_IDLE loanshark_meat4

TURN_CHAR_TO_FACE_CHAR loanshark_meat4 owner_meat4  	

PLAY_MISSION_AUDIO

PRINT_NOW ( MEA4_B5 ) 10000 1 //"Emm hi, I need more time to get the money."

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( MEA4_B5 )

LOAD_MISSION_AUDIO MF3_B1

TURN_CHAR_TO_FACE_CHAR loanshark_meat4 owner_meat4

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

TURN_CHAR_TO_FACE_CHAR loanshark_meat4 owner_meat4

PLAY_MISSION_AUDIO

PRINT_NOW ( MEA4_B7 ) 20000 1 //"But if you just step into my office I could..."

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

TURN_CHAR_TO_FACE_CHAR loanshark_meat4 owner_meat4

CLEAR_THIS_PRINT ( MEA4_B7 )

LOAD_MISSION_AUDIO MF3_C

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

TURN_CHAR_TO_FACE_CHAR loanshark_meat4 owner_meat4

PLAY_MISSION_AUDIO

PRINT_NOW ( MEA4_B6 ) 10000 1 //"I warned you about defaulting on a payment!"

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		PRINT_NOW ( MEA4_2 ) 5000 1 //"The factory owners dead!"
		GOTO mission_failed_meat4
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( MEA4_B6 )

GIVE_WEAPON_TO_CHAR loanshark_meat4 WEAPONTYPE_SHOTGUN 2

SET_CHAR_OBJ_KILL_CHAR_ON_FOOT loanshark_meat4 owner_meat4

// Waiting for the owner to be killed

timera = 0

WHILE NOT flag_owner_dead_meat4 = 1

	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED
		CLEAR_THIS_PRINT ( MEA4_B6 )
	ENDIF

	IF IS_CHAR_DEAD owner_meat4
		flag_owner_dead_meat4 = 1
	ENDIF
					
	IF IS_CHAR_DEAD loanshark_meat4
		PRINT_NOW ( MEA4_1 ) 5000 1 //"The Loan Sharks dead!"
		GOTO mission_failed_meat4
	ENDIF

	IF timera > 10000
		
		IF NOT IS_CHAR_DEAD owner_meat4
			flag_owner_dead_meat4 = 1
		ENDIF
		
	ENDIF	

ENDWHILE

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( MEA4_B6 )
ENDIF

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

RESTORE_CAMERA_JUMPCUT

}
 			   
GOTO mission_passed_meat4



// Mission Failed

mission_failed_meat4:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF NOT IS_CHAR_DEAD owner_meat4
	REMOVE_CHAR_ELEGANTLY owner_meat4
ENDIF

IF NOT IS_CHAR_DEAD loanshark_meat4
	REMOVE_CHAR_ELEGANTLY loanshark_meat4
ENDIF

RETURN


		
// Mission Passed
	
mission_passed_meat4:

PRINT_WITH_NUMBER_BIG ( m_pass ) 4000 5000 1 //"Mission Passed!"
REGISTER_MISSION_PASSED ( MEA4 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 4000
flag_meat_mission4_passed = 1
CLEAR_WANTED_LEVEL player
RETURN


// Mission Cleanup

mission_cleanup_meat4:

flag_player_on_mission = 0
flag_player_on_meat_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED PED_FAN_MAN2
MARK_MODEL_AS_NO_LONGER_NEEDED PED_B_MAN2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
REMOVE_BLIP radar_blip_ped1_meat4
REMOVE_BLIP radar_blip_car_meat4
REMOVE_BLIP radar_blip_coord2_meat4
MISSION_HAS_FINISHED
RETURN



MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Luigi mission 1********************************* 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************



// Mission start stuff

GOSUB mission_start_luigi1

IF HAS_DEATHARREST_BEEN_EXECUTED 

	GOSUB mission_luigi1_failed

ENDIF

GOSUB mission_cleanup_luigi1

MISSION_END

 
// Variable for mission

VAR_INT radar_blip_coord1_lm1

VAR_INT radar_blip_ped1_lm1

VAR_INT radar_blip_ped2_lm1

VAR_INT girl1_lm1

VAR_INT girl2_lm1

VAR_INT car_lm1

VAR_INT flag_player_had_car_message_lm1

VAR_INT flag_player_not_in_car_message_lm1

VAR_INT flag_luigi_created_lm1

VAR_INT no_of_passengers_car_lm1

VAR_INT flag_girl1_in_car_lm1

VAR_INT flag_girl2_in_car_lm1

VAR_INT passenger_count_lm1

VAR_INT total_space_in_car_lm1

VAR_INT flag_blip_on_girl1_lm1

VAR_INT flag_blip_on_girl2_lm1

VAR_INT flag_coord_blip_on

// ****************************************Mission Start************************************

mission_start_luigi1:

flag_player_on_mission = 1

flag_player_on_luigi_mission = 1

WAIT 0

flag_player_had_car_message_lm1 = 0

flag_player_not_in_car_message_lm1 = 0

flag_luigi_created_lm1 = 0

no_of_passengers_car_lm1 = 0

flag_girl1_in_car_lm1 = 0

flag_girl2_in_car_lm1 = 0

passenger_count_lm1 = 0

total_space_in_car_lm1 = 0

flag_blip_on_girl1_lm1 = 0

flag_blip_on_girl2_lm1 = 0

flag_coord_blip_on = 0


LOAD_SPECIAL_CHARACTER 1 MICKY
LOAD_SPECIAL_CHARACTER 2 EIGHT
LOAD_SPECIAL_CHARACTER 3 LUIGI

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR
LOAD_SPECIAL_MODEL cut_obj2 MICKYH
LOAD_SPECIAL_MODEL cut_obj3 EIGHT
LOAD_SPECIAL_MODEL cut_obj4	LUIGI

{

IF flag_failed_luigi1 = 0

SET_FADING_COLOUR 0 0 0

DO_FADE 250 FADE_OUT

PRINT_BIG ( LM2 ) 10000 2 //"  "

TIMERA = 0
	
// Cutscene stuff



WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED cut_obj1 
OR NOT HAS_MODEL_LOADED cut_obj2

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4

	WAIT 0

ENDWHILE

//WHILE GET_FADING_STATUS

//	WAIT 0

//ENDWHILE

	

LOAD_CUTSCENE luigi1

SET_CUTSCENE_OFFSET 901.82 -426.3 13.85

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_micky

SET_CUTSCENE_ANIM cs_micky micky

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_eight

SET_CUTSCENE_ANIM cs_eight eight

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_luigi

SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_HEAD cs_micky CUT_OBJ2 cs_mickyhead

SET_CUTSCENE_HEAD_ANIM cs_mickyhead micky

CREATE_CUTSCENE_HEAD cs_eight CUT_OBJ3 cs_eighthead

SET_CUTSCENE_HEAD_ANIM cs_eighthead eight

CREATE_CUTSCENE_HEAD cs_luigi CUT_OBJ4 cs_luigihead

SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor

SET_CUTSCENE_ANIM cs_ludoor LUDOOR

WHILE TIMERA < 3500

	WAIT 0

ENDWHILE

DO_FADE 250 FADE_IN

//WHILE GET_FADING_STATUS 
//	WAIT 0
//ENDWHILE

START_CUTSCENE

SET_PLAYER_VISIBLE player OFF

//SET_PLAYER_COORDINATES player 903.1 -424.8 13.9
SET_PLAYER_COORDINATES player 896.6 -426.2 13.9

SET_PLAYER_HEADING player 180.0

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 16000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_A ) 5000 1 //"There's a new high on the street goes by the name of SPANK. Some wiseguy's been introducing this trash to my girls down Portland Harbour.

WHILE cs_time < 21000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_B ) 5000 1//"Go and introduce a bat to his face, then take his car, get it resprayed and take it to the lockup. I want compensation for this insult!"

WHILE NOT HAS_CUTSCENE_FINISHED

	WAIT 0

ENDWHILE

CLEAR_CUTSCENE

CLEAR_PRINTS

UNLOAD_SPECIAL_CHARACTER 1

UNLOAD_SPECIAL_CHARACTER 2

UNLOAD_SPECIAL_CHARACTER 3

ENDIF 



//SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player off

REQUEST_MODEL PED_PROSTITUTE

LOAD_SPECIAL_CHARACTER 2 misty

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED PED_PROSTITUTE
 
	WAIT 0

ENDWHILE

/*
CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 889.83 -415.93 15.5 luigi

flag_luigi_created_lm1 = 1

CLEAR_CHAR_THREAT_SEARCH luigi

CHAR_SET_IDLE luigi

SET_POLICE_IGNORE_PLAYER player ON

GET_PLAYER_CHAR player script_controlled_player

CLEAR_CHAR_THREAT_SEARCH script_controlled_player

CHAR_SET_IDLE script_controlled_player

//SET_OBJECT_HEADING luigi_club_door 270.0

//SET_CHAR_OBJ_GOTO_COORD_ON_FOOT luigi 890.50 -415.84

//WHILE NOT IS_CHAR_OBJECTIVE_PASSED luigi

//	WAIT 0

//ENDWHILE

TURN_CHAR_TO_FACE_COORD luigi 882.0 -415.0 -100.0

TURN_PLAYER_TO_FACE_CHAR player luigi

SET_FIXED_CAMERA_POSITION 886.0 -415.0 16.0 0.0 0.0 0.0 

POINT_CAMERA_AT_CHAR luigi fixed interpolation

SET_GANG_PLAYER_ATTITUDE GANG_MAFIA LOVES player //The Mafia now like the player

PRINT_BIG ( LM1 ) 5000 1

WAIT 1000

PRINT_NOW ( LM1_A ) 7000 1 //"But he vouched for you. So I was thinking maybe you can do me a favour."
	  	  
MESSAGE_WAIT 7000 flag_played_luigi1_already

PRINT_NOW ( LM1_B ) 7000 1 //"A couple of my girls need a ride so grab a car and pick up Trixie from the Reverend Flannery's and Misty from the clinic."  
	
MESSAGE_WAIT 7000 flag_played_luigi1_already

PRINT_NOW ( LM1_C ) 7000 1 //"Then bring them back here. Remember no one messes with my girls so keep your hands on the wheel!"

MESSAGE_WAIT 7000 flag_played_luigi1_already

PRINT_NOW ( LM1_D ) 7000 1 //"If you don't mess this up there might be more work for you."

MESSAGE_WAIT 7000 flag_played_luigi1_already

DELETE_CHAR luigi

flag_luigi_created_lm1 = 0

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA
*/

SET_PLAYER_CONTROL player on

SET_POLICE_IGNORE_PLAYER player OFF

// Creates the first girl

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1158.0 -536.0 20.0 girl1_lm1

CLEAR_CHAR_THREAT_SEARCH girl1_lm1

TURN_CHAR_TO_FACE_COORD girl1_lm1 1158.0 -541.0 -100.0

ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1

// Creates second girl

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 1383.0 -392.0 -100.0 girl2_lm1

CLEAR_CHAR_THREAT_SEARCH girl2_lm1

TURN_CHAR_TO_FACE_COORD girl2_lm1 1380.0 -391.0 -100.0

ADD_BLIP_FOR_CHAR girl2_lm1 radar_blip_ped2_lm1

// Waiting for the player to be in a car

WHILE NOT IS_PLAYER_IN_ANY_CAR player

	WAIT 0
	
ENDWHILE

STORE_CAR_PLAYER_IS_IN player car_lm1

GET_MAXIMUM_NUMBER_OF_PASSENGERS car_lm1 no_of_passengers_car_lm1


// Waiting for the player and the girls all to be in the one car

WHILE NOT IS_PLAYER_IN_ANY_CAR player
OR NOT flag_girl1_in_car_lm1 = 1
OR NOT flag_girl2_in_car_lm1 = 1

	WAIT 0

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_luigi1_failed
	ENDIF

	IF IS_CHAR_DEAD girl2_lm1
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_luigi1_failed
	ENDIF

IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player car_lm1
	GET_MAXIMUM_NUMBER_OF_PASSENGERS car_lm1 no_of_passengers_car_lm1
	flag_player_not_in_car_message_lm1 = 0

// Checks for girl1

	IF flag_girl1_in_car_lm1 = 0
	
		IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
		AND IS_PLAYER_STOPPED player

			flag_player_had_car_message_lm1 = 0

			GET_NUMBER_OF_PASSENGERS car_lm1 passenger_count_lm1

			total_space_in_car_lm1 = no_of_passengers_car_lm1 - passenger_count_lm1
		
			IF total_space_in_car_lm1 >= 1

				SET_PLAYER_AS_LEADER girl1_lm1 player
		
					WHILE NOT IS_CHAR_IN_CAR girl1_lm1 car_lm1
			
						WAIT 0

						IF IS_CAR_DEAD car_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF
			
						IF IS_CHAR_DEAD girl1_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF

						IF IS_CHAR_DEAD girl2_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF

						//IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
						//AND IS_PLAYER_STOPPED player
						//	SET_PLAYER_AS_LEADER girl1_lm1 player
						//ENDIF

					ENDWHILE
											
					REMOVE_BLIP radar_blip_ped1_lm1
					flag_girl1_in_car_lm1 = 1
			ELSE
					
				IF flag_player_had_car_message_lm1 = 0
					PRINT_NOW (NODOORS ) 7000 1 //"The cars not big enough get another one!"
					flag_player_had_car_message_lm1 = 1
				ENDIF

			ENDIF
		   		
		ENDIF

	ENDIF
	
// Checks for girl 2

	IF flag_girl2_in_car_lm1 = 0

		IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl2_lm1 8.0 8.0 FALSE
		AND IS_PLAYER_STOPPED player

			flag_player_had_car_message_lm1 = 0

			GET_NUMBER_OF_PASSENGERS car_lm1 passenger_count_lm1

			total_space_in_car_lm1 = no_of_passengers_car_lm1 - passenger_count_lm1
			

			IF total_space_in_car_lm1 >= 1

				SET_PLAYER_AS_LEADER girl2_lm1 player
		
					WHILE NOT IS_CHAR_IN_CAR girl2_lm1 car_lm1
			
						WAIT 0

						IF IS_CAR_DEAD car_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF
			
						IF IS_CHAR_DEAD girl1_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF

						IF IS_CHAR_DEAD girl2_lm1
							PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
							GOTO mission_luigi1_failed
						ENDIF

						//IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl2_lm1 8.0 8.0 FALSE
						//AND IS_PLAYER_STOPPED player
						//	SET_PLAYER_AS_LEADER girl2_lm1 player
						//ENDIF

					ENDWHILE
					REMOVE_BLIP radar_blip_ped2_lm1
					flag_girl2_in_car_lm1 = 1
						 						 						
			ELSE
				
				IF flag_player_had_car_message_lm1 = 0
					PRINT_NOW ( NODOORS ) 7000 1 //"The cars not big enough get another one!"
					flag_player_had_car_message_lm1 = 1
				ENDIF

	  		ENDIF
						
		ENDIF
	
	ENDIF


	IF flag_girl1_in_car_lm1 = 1

		IF NOT IS_CHAR_IN_PLAYERS_GROUP girl1_lm1 player
		AND flag_blip_on_girl1_lm1 = 0
			PRINT_SOON ( HEY ) 5000 1 //"Hey wait for me!"
			ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
			flag_girl1_in_car_lm1 = 0
			flag_blip_on_girl1_lm1 = 1
		ENDIF
	
		//IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
		//AND flag_blip_on_girl1_lm1 = 1
		//	SET_PLAYER_AS_LEADER girl1_lm1 player
		//	REMOVE_BLIP radar_blip_ped1_lm1
		//	flag_blip_on_girl1_lm1 = 0
		//ENDIF

		//IF IS_CHAR_DEAD girl1_lm1
		//	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		//	GOTO mission_luigi1_failed
		//ENDIF
		//
		//IF IS_CHAR_DEAD girl2_lm1
		//	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		//	GOTO mission_luigi1_failed
		//ENDIF
	
	ENDIF

	IF flag_girl2_in_car_lm1 = 1

		IF NOT IS_CHAR_IN_PLAYERS_GROUP girl2_lm1 player
		AND flag_blip_on_girl2_lm1 = 0
			PRINT_SOON ( HEY ) 5000 1 //"Hey wait for me!"
			ADD_BLIP_FOR_CHAR girl2_lm1 radar_blip_ped2_lm1
			flag_girl2_in_car_lm1 = 0
			flag_blip_on_girl2_lm1 = 1
		ENDIF

		//IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl2_lm1 8.0 8.0 FALSE
	   //	AND flag_blip_on_girl2_lm1 = 1
	   //		SET_PLAYER_AS_LEADER girl2_lm1 player
	   //		REMOVE_BLIP radar_blip_ped2_lm1
	   //		flag_blip_on_girl2_lm1 = 0
	   //	ENDIF

		//IF IS_CHAR_DEAD girl1_lm1
		//	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		//	GOTO mission_luigi1_failed
		//ENDIF

		//IF IS_CHAR_DEAD girl2_lm1
		//	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		//	GOTO mission_luigi1_failed
		//ENDIF

	ENDIF

ELSE
	
	IF flag_player_not_in_car_message_lm1 = 0
		PRINT_NOW ( IN_VEH2 ) 7000 1 //"Get a vehicle and get on with the mission!"
		flag_player_not_in_car_message_lm1 = 1
	ENDIF

ENDIF
   
ENDWHILE

PRINT_NOW ( LM1_2 ) 7000 1 //"Hi take us to the Red Light District please, we'll be ever so 'grateful'!"

ADD_BLIP_FOR_COORD 908.0 -425.0 -100.0 radar_blip_coord1_lm1

flag_coord_blip_on = 1 

// waiting for the player to get to luigi's

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_2D player 908.0 -425.0 4.0 4.0 TRUE
OR NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D girl1_lm1 908.0 -425.0 4.0 4.0 FALSE
OR NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D girl2_lm1 908.0 -425.0 4.0 4.0 FALSE
	   
	WAIT 0

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_luigi1_failed
	ENDIF
	
	IF IS_CHAR_DEAD girl2_lm1
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_luigi1_failed
	ENDIF

	IF IS_PLAYER_IN_ANY_CAR player
	//AND flag_player_not_in_car_message_lm1 = 1
	 	STORE_CAR_PLAYER_IS_IN player car_lm1
		GET_MAXIMUM_NUMBER_OF_PASSENGERS car_lm1 no_of_passengers_car_lm1

		//IF IS_CHAR_IN_CAR girl1_lm1 car_lm1
		//AND IS_CHAR_IN_CAR girl2_lm1 car_lm1 
		//	ADD_BLIP_FOR_COORD 908.0 -425.0 -100.0 radar_blip_coord1_lm1
		//	flag_player_not_in_car_message_lm1 = 0
		//ENDIF
			
		IF no_of_passengers_car_lm1 < 2
		AND flag_player_had_car_message_lm1 = 0
			PRINT_NOW ( NODOORS ) 7000 1 //"The car is not big enought get an other one!"
			flag_player_had_car_message_lm1 = 1
		ENDIF
				
		IF no_of_passengers_car_lm1 >= 2
		AND flag_player_had_car_message_lm1 = 1
			flag_player_had_car_message_lm1 = 0
		ENDIF

	ENDIF

	//IF NOT IS_PLAYER_IN_ANY_CAR player
	//AND flag_player_not_in_car_message_lm1 = 0
	//	PRINT_NOW ( IN_VEH2 ) 7000 1 //"Get a vehicle and get on with the mission!"
	//	REMOVE_BLIP radar_blip_coord1_lm1
	//	flag_player_not_in_car_message_lm1 = 1
	//ENDIF

	 

	IF NOT IS_CHAR_IN_PLAYERS_GROUP girl1_lm1 player
	AND flag_blip_on_girl1_lm1 = 0
		PRINT_SOON ( HEY ) 5000 1 //"Hey wait for me!"
		ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
		REMOVE_BLIP radar_blip_coord1_lm1
		flag_blip_on_girl1_lm1 = 1
	ENDIF
	
	IF NOT IS_CHAR_IN_PLAYERS_GROUP girl2_lm1 player
	AND flag_blip_on_girl2_lm1 = 0
		PRINT_SOON ( HEY ) 5000 1 //"Hey wait for me!"
		ADD_BLIP_FOR_CHAR girl2_lm1 radar_blip_ped2_lm1
		REMOVE_BLIP radar_blip_coord1_lm1
		flag_blip_on_girl2_lm1 = 1
	ENDIF 

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
	AND flag_blip_on_girl1_lm1 = 1
		SET_PLAYER_AS_LEADER girl1_lm1 player
		REMOVE_BLIP radar_blip_ped1_lm1
		flag_coord_blip_on = 0
		flag_blip_on_girl1_lm1 = 0
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl2_lm1 8.0 8.0 FALSE
	AND flag_blip_on_girl2_lm1 = 1
		SET_PLAYER_AS_LEADER girl2_lm1 player
		REMOVE_BLIP radar_blip_ped2_lm1
		flag_coord_blip_on = 0
		flag_blip_on_girl2_lm1 = 0
	ENDIF

	IF IS_CHAR_IN_PLAYERS_GROUP girl1_lm1 player
	AND IS_CHAR_IN_PLAYERS_GROUP girl2_lm1 player
	AND flag_coord_blip_on = 0
		ADD_BLIP_FOR_COORD 908.0 -425.0 -100.0 radar_blip_coord1_lm1
		flag_coord_blip_on = 1 
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord1_lm1

LEAVE_GROUP girl1_lm1

LEAVE_GROUP girl2_lm1

IF IS_CHAR_IN_ANY_CAR girl1_lm1
AND IS_CHAR_IN_ANY_CAR girl2_lm1

	STORE_CAR_CHAR_IS_IN girl1_lm1 car_lm1

	SET_CHAR_OBJ_LEAVE_CAR girl1_lm1 car_lm1

	STORE_CAR_CHAR_IS_IN girl2_lm1 car_lm1
	
	SET_CHAR_OBJ_LEAVE_CAR girl2_lm1 car_lm1

	WHILE IS_CHAR_IN_ANY_CAR girl1_lm1
	AND IS_CHAR_IN_ANY_CAR girl2_lm1

		WAIT 0

		IF IS_CHAR_DEAD girl1_lm1
			PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
			GOTO mission_luigi1_failed
		ENDIF

		IF IS_CHAR_DEAD girl2_lm1
			PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
			GOTO mission_luigi1_failed
		ENDIF

	ENDWHILE

ENDIF
 
} 

GOTO mission_luigi1_passed
	   		


// Mission Luigi1 failed

mission_luigi1_failed:
flag_failed_luigi1 = 1
START_NEW_SCRIPT luigi_mission1.2_loop
RETURN

   

// mission Luigi1 passed

mission_luigi1_passed:

flag_luigi_mission1_passed = 1
PRINT_BIG ( m_pass ) 2000 1
CLEAR_WANTED_LEVEL player
ADD_SCORE player 1500
START_NEW_SCRIPT luigi_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_luigi1:

flag_player_on_mission = 0
flag_player_on_luigi_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PROSTITUTE
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
RESTORE_CAMERA
SET_PLAYER_CONTROL player on
SET_POLICE_IGNORE_PLAYER player off
SWITCH_WIDESCREEN OFF

//IF flag_girl1_in_car_lm1 = 1
//AND flag_girl2_in_car_lm1 = 1
	REMOVE_BLIP radar_blip_coord1_lm1
//ENDIF

//IF flag_girl1_in_car_lm1 = 0
//OR flag_blip_on_girl1_lm1 = 1
	REMOVE_BLIP radar_blip_ped1_lm1
//ENDIF

//IF flag_girl2_in_car_lm1 = 0
//OR flag_blip_on_girl2_lm1 = 1
	REMOVE_BLIP radar_blip_ped2_lm1
//ENDIF
MISSION_HAS_FINISHED
RETURN
		



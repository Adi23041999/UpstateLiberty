MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************Luigi Mission 2***************************************
// *******************************Donna' "Spank" Ma Bitch Up********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME luigi2

// Mission start stuff

GOSUB mission_start_luigi2

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_luigi2_failed
	ENDIF

GOSUB mission_cleanup_luigi2

MISSION_END


// Variables for mission

VAR_INT radar_blip_ped1_lm2
 
VAR_INT victim_ped_lm2

VAR_INT flag_player_got_help_message_lm2

VAR_INT flag_victim_ped_lm2_changed

VAR_INT car_lm2

VAR_INT radar_blip_car1_lm2

VAR_INT radar_blip_coord1_lm2

VAR_INT radar_blip_coord2_lm2

VAR_INT flag_victim_dead_lm2

VAR_INT flag_player_had_car_message_lm2

VAR_INT flag_car_in_garage_lm2

VAR_INT flag_player_had_garage_message_lm2

VAR_INT flag_blip1_on_lm2

VAR_INT flag_blip2_on_lm2

VAR_INT buyer1_lm2

VAR_INT buyer2_lm2

VAR_INT flag_buyer1_dead_lm2

VAR_INT flag_buyer2_dead_lm2

VAR_INT flag_done_looking_bit_lm2

VAR_INT bat_lm2

VAR_INT sphere1_lm2

VAR_INT sphere2_lm2

VAR_INT flag_had_spray_help

VAR_INT flag_player_had_bat_message_lm2

VAR_INT bat_blip_lm2

VAR_INT flag_had_path_message_lm2

VAR_INT flag_lockup_message_lm2

VAR_INT flag_girl1_running_lm2

VAR_INT flag_girl2_running_lm2

VAR_INT flag_player_in_area_lm2

VAR_INT flag_player_in_car_lm2

// ********************************************Mission Start********************************    

mission_start_luigi2:

flag_player_on_mission = 1

flag_player_on_luigi_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_got_help_message_lm2 = 0

flag_victim_ped_lm2_changed = 0

flag_victim_dead_lm2 = 0

flag_car_in_garage_lm2 = 0

flag_player_had_car_message_lm2 = 0

flag_player_had_garage_message_lm2 = 0

flag_buyer1_dead_lm2 = 0

flag_buyer2_dead_lm2 = 0

flag_done_looking_bit_lm2 = 0

flag_had_spray_help = 0

flag_player_had_bat_message_lm2 = 0

flag_had_path_message_lm2 = 0

flag_lockup_message_lm2 = 0

flag_girl1_running_lm2 = 0

flag_girl2_running_lm2 = 0

flag_player_in_area_lm2 = 0

flag_player_in_car_lm2 = 0

{

REQUEST_MODEL PED_DOCKER2

REQUEST_MODEL PED_PROSTITUTE

REQUEST_MODEL PED_PROSTITUTE2

REQUEST_MODEL CAR_STALLION

CLEAR_HELP

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_luigi2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( LM2 ) 15000 2 //"Don'a SPANK ma bitch up"
*/

REQUEST_MODEL indhibuild3

REQUEST_MODEL luigiclubout

REQUEST_MODEL luigiineerclub

LOAD_SPECIAL_CHARACTER 1 MICKY

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR
LOAD_SPECIAL_MODEL cut_obj2 MICKYH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 NOTE

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 926.54 -471.72 1.0 830.76 -257.96 25.0

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED indhibuild3
OR NOT HAS_MODEL_LOADED luigiclubout
OR NOT HAS_MODEL_LOADED luigiineerclub

	WAIT 0
	
ENDWHILE 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE l2_dsb

SET_CUTSCENE_OFFSET 900.782 -427.523 13.829

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_micky

SET_CUTSCENE_ANIM cs_micky micky

CREATE_CUTSCENE_HEAD cs_micky CUT_OBJ2 cs_mickyhead

SET_CUTSCENE_HEAD_ANIM cs_mickyhead micky

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor

SET_CUTSCENE_ANIM cs_ludoor LUDOOR

CREATE_CUTSCENE_OBJECT cut_obj4 cs_note

SET_CUTSCENE_ANIM cs_note NOTE

CLEAR_AREA 896.6 -426.2 13.9 1.0 TRUE
SET_PLAYER_COORDINATES player 896.6 -426.2 13.9

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5634
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_C ) 10000 1 //"Luigi said to give you this so..."

WHILE cs_time < 7989
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_D ) 10000 1 //"So here, here take it"

WHILE cs_time < 12078
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_A ) 10000 1 //"There's a new high on the street goes by the name of SPANK."

WHILE cs_time < 15287
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_E ) 10000 1 //"Some wiseguy's been introducing this trash to my girls down Portland Harbour."

WHILE cs_time < 19558
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_B ) 10000 1//"Go and introduce a bat to his face!

WHILE cs_time < 23042
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_F ) 10000 1//"Then take his car, respray it and bring it back here."

WHILE cs_time < 25852
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM2_G ) 10000 1//"I want compensation for this insult!"

WHILE cs_time < 28632
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM2_G )

WHILE cs_time < 31000
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

SWITCH_STREAMING ON

SWITCH_RUBBISH ON

LOAD_SCENE 920.3 -425.4 15.0

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

SET_CAMERA_BEHIND_PLAYER

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4

MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3

MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout

MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub

SET_PED_DENSITY_MULTIPLIER 1.0

// ******************************************END OF CUTSCENE********************************

SWITCH_PED_ROADS_OFF 1609.8 -615.2 9.0 1557.8 -673.4 20.0

CREATE_PICKUP WEAPON_BAT PICKUP_ONCE 917.2 -425.3 14.5 bat_lm2

ADD_BLIP_FOR_PICKUP bat_lm2 bat_blip_lm2

WHILE NOT HAS_MODEL_LOADED CAR_STALLION
OR NOT HAS_MODEL_LOADED PED_DOCKER2
OR NOT HAS_MODEL_LOADED PED_PROSTITUTE
OR NOT HAS_MODEL_LOADED PED_PROSTITUTE2
 
	WAIT 0

ENDWHILE

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

SET_PLAYER_CONTROL player ON

PRINT_NOW ( BAT1 ) 5000 1 //"Pick up the bat!"

PRINT_HELP ( HELP14 ) //"To pick up weapons walk through them. These cannot be collected while in a vehicle"

// creates the dealer

CREATE_CHAR PEDTYPE_CIVFEMALE PED_DOCKER2 1399.64 -833.72 -100.0 victim_ped_lm2

TURN_CHAR_TO_FACE_COORD victim_ped_lm2 1397.46 -835.52 10.8 

CLEAR_CHAR_THREAT_SEARCH victim_ped_lm2

// creates prostitute one

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 1397.21 -832.86 -100.0 buyer1_lm2  //proper one

CLEAR_CHAR_THREAT_SEARCH buyer1_lm2

TURN_CHAR_TO_FACE_COORD buyer1_lm2 1399.64 -833.72 10.8 

// creates prostitute two

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE2 1397.28 -834.43 -100.0 buyer2_lm2

CLEAR_CHAR_THREAT_SEARCH buyer2_lm2

TURN_CHAR_TO_FACE_COORD buyer2_lm2 1399.64 -833.72 10.8 

// dealers car

CREATE_CAR CAR_STALLION 1396.67 -837.69 -100.0 car_lm2

SET_CAR_HEADING car_lm2 301.0

CHANGE_CAR_LOCK car_lm2 CARLOCK_LOCKED

ADD_BLIP_FOR_CHAR victim_ped_lm2 radar_blip_ped1_lm2

IF NOT IS_CHAR_DEAD victim_ped_lm2
		
	IF NOT IS_CHAR_DEAD buyer1_lm2  
		SET_CHARS_CHATTING victim_ped_lm2 buyer1_lm2 -1  // try -1 when this has been fixed
	ENDIF
	
ENDIF

WAIT 0

timerb = 0

WHILE NOT IS_CHAR_DEAD victim_ped_lm2

	GOSUB girls_running
	
	IF flag_player_had_bat_message_lm2 = 0

		IF HAS_PICKUP_BEEN_COLLECTED bat_lm2 
		   	PRINT_HELP ( GUN_1A )
		   	REMOVE_BLIP bat_blip_lm2
		   	CLEAR_THIS_PRINT ( BAT1 ) 
			flag_player_had_bat_message_lm2 = 1
		ENDIF

	ENDIF

	IF flag_had_path_message_lm2 = 0

		IF timerb >= 30000
			PRINT_HELP ( HELP13 ) //"Sometimes you may need to use pathways not shown on the radar."
			flag_had_path_message_lm2 = 1
		ENDIF

	ENDIF

/*   	
// Camera point at dealer stuff

IF flag_done_looking_bit_lm2 = 0

	IF IS_PLAYER_IN_AREA_3D player 1535.2 -615.1 10.0 1610.5 -681.0 20.0 FALSE
		
		IF IS_PLAYER_IN_ANY_CAR player
			APPLY_BRAKES_TO_PLAYERS_CAR player ON
		ENDIF

		SWITCH_WIDESCREEN ON
		CLEAR_WANTED_LEVEL player
		SET_POLICE_IGNORE_PLAYER player ON
		SET_PLAYER_CONTROL player OFF
		
		IF LOCATE_PLAYER_ANY_MEANS_3D player 1589.1 -641.4 11.1 1.0 1.0 1.0 FALSE
			SET_FIXED_CAMERA_POSITION 1587.8 -651.7 18.3 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 1587.5 -651.0 17.6 JUMP_CUT
		ELSE
			SET_FIXED_CAMERA_POSITION 1589.1 -641.4 11.1 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 1588.3 -642.0 11.3 JUMP_CUT
		ENDIF	
		

		WAIT 4500

		IF IS_CHAR_DEAD victim_ped_lm2
			REMOVE_BLIP radar_blip_ped1_lm2
			flag_victim_dead_lm2 = 1
		ENDIF

		IF IS_CAR_DEAD car_lm2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_luigi2_failed
		ELSE
			
			IF IS_CAR_UPSIDEDOWN car_lm2
			AND IS_CAR_STOPPED car_lm2
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_luigi2_failed
			ENDIF

		ENDIF

		IF IS_PLAYER_IN_ANY_CAR player
			APPLY_BRAKES_TO_PLAYERS_CAR player FALSE
		ENDIF

		SWITCH_WIDESCREEN OFF
		RESTORE_CAMERA_JUMPCUT
		SET_POLICE_IGNORE_PLAYER player OFF
		SET_PLAYER_CONTROL player ON
		flag_done_looking_bit_lm2 = 1
	ENDIF

	
ENDIF
*/

   
	IF IS_CHAR_DEAD victim_ped_lm2
		REMOVE_BLIP radar_blip_ped1_lm2
		flag_victim_dead_lm2 = 1
	ENDIF

	IF IS_CAR_DEAD car_lm2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_luigi2_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN car_lm2
		AND IS_CAR_STOPPED car_lm2
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_luigi2_failed
		ENDIF

	ENDIF

IF flag_done_looking_bit_lm2 = 1
OR IS_PLAYER_IN_AREA_3D player 1430.75 -807.0 9.0 1355.2 -883.2 20.0 FALSE
	flag_done_looking_bit_lm2 = 1  // set this here also to stop bloke going for player once he has got out of his car
	flag_player_in_area_lm2 = 1

	IF flag_victim_dead_lm2 = 0
		
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim_ped_lm2 10.0 10.0 10.0 FALSE
		AND flag_victim_ped_lm2_changed = 0
			TURN_CHAR_TO_FACE_PLAYER victim_ped_lm2 player
			SET_CHAR_THREAT_SEARCH victim_ped_lm2 THREAT_PLAYER1
			SET_CHAR_PERSONALITY victim_ped_lm2 PEDSTAT_TOUGH_GUY
			SET_CHAR_HEED_THREATS victim_ped_lm2 TRUE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT victim_ped_lm2 player 
			flag_victim_ped_lm2_changed = 1
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player victim_ped_lm2 6.0 6.0 15.0 FALSE
		AND flag_player_got_help_message_lm2 = 0

			GET_CONTROLLER_MODE controlmode

			IF controlmode = 0
				PRINT_HELP ( LM2_2A ) //"Use the circle button to punch and kick!"
				flag_player_got_help_message_lm2 = 1
			ENDIF

			IF controlmode = 1
				PRINT_HELP ( LM2_2A ) //"Use the circle button to punch and kick!"
				flag_player_got_help_message_lm2 = 1
			ENDIF

			IF controlmode = 2
				PRINT_HELP ( LM2_2C ) //"Use the circle button to punch and kick!"
				flag_player_got_help_message_lm2 = 1
			ENDIF

			IF controlmode = 3
				PRINT_HELP ( LM2_2D ) //"Use the circle button to punch and kick!"
				flag_player_got_help_message_lm2 = 1
			ENDIF
						
		ENDIF

	ENDIF

ENDIF
	
	WAIT 0
										
ENDWHILE

IF NOT HAS_PICKUP_BEEN_COLLECTED bat_lm2 
	REMOVE_BLIP bat_blip_lm2
	REMOVE_PICKUP bat_lm2
	flag_player_had_bat_message_lm2 = 1
ENDIF

REMOVE_BLIP radar_blip_ped1_lm2

IF IS_CAR_DEAD car_lm2
	PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
	GOTO mission_luigi2_failed
ELSE

	IF IS_CAR_UPSIDEDOWN car_lm2
	AND IS_CAR_STOPPED car_lm2
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_luigi2_failed
	ENDIF

ENDIF

CHANGE_CAR_LOCK car_lm2 CARLOCK_UNLOCKED

ADD_BLIP_FOR_CAR car_lm2 radar_blip_car1_lm2

PRINT_NOW ( LM2_1 ) 7000 1 //"Take the car and get it resprayed."

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_lm2

	WAIT 0

	GOSUB girls_running

	IF IS_CAR_DEAD car_lm2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_luigi2_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN car_lm2
		AND IS_CAR_STOPPED car_lm2
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_luigi2_failed
		ENDIF

	ENDIF
			
ENDWHILE

flag_player_in_car_lm2 = 1

SET_FREE_RESPRAYS ON

REMOVE_BLIP radar_blip_car1_lm2

ADD_SPRITE_BLIP_FOR_COORD 924.0 -361.0 10.0 RADAR_SPRITE_SPRAY radar_blip_coord1_lm2

ADD_SPHERE 925.1 -350.5 9.3 2.5 sphere1_lm2 

HAS_RESPRAY_HAPPENED sprayshop1

// waiting for the player to respray the car

WHILE NOT HAS_RESPRAY_HAPPENED sprayshop1
OR NOT IS_PLAYER_IN_CAR player car_lm2
OR NOT IS_PLAYER_STOPPED_IN_AREA_2D player 922.6 -366.1 928.6 -354.3 FALSE
	
 	WAIT 0

 	IF IS_CAR_DEAD car_lm2
 		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
 		GOTO mission_luigi2_failed
 	ELSE

		IF IS_CAR_UPSIDEDOWN car_lm2
		AND IS_CAR_STOPPED car_lm2
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_luigi2_failed
		ENDIF

	ENDIF

 	IF NOT IS_PLAYER_IN_CAR player car_lm2
 	AND flag_player_had_car_message_lm2 = 0
 		PRINT_NOW ( IN_VEH ) 7000 1 //"Get back into the car and get on with the mission!"
 		REMOVE_BLIP radar_blip_coord1_lm2
		REMOVE_SPHERE sphere1_lm2
 		ADD_BLIP_FOR_CAR car_lm2 radar_blip_car1_lm2
 		flag_player_had_car_message_lm2 = 1
 	ENDIF

	IF IS_PLAYER_IN_CAR player car_lm2
	AND flag_player_had_car_message_lm2 = 1
		REMOVE_BLIP radar_blip_car1_lm2
		ADD_SPRITE_BLIP_FOR_COORD 924.0 -361.0 10.0 RADAR_SPRITE_SPRAY radar_blip_coord1_lm2

			IF flag_had_spray_help = 0 
				ADD_SPHERE 925.1 -350.5 9.3 2.5 sphere1_lm2
			ENDIF

		flag_player_had_car_message_lm2 = 0
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player 925.1 -350.5 9.3 2.5 2.5 2.5 FALSE
	AND IS_PLAYER_IN_CAR player car_lm2
		
		IF flag_had_spray_help = 0
			PRINT_HELP ( SPRAY1 )
			REMOVE_SPHERE sphere1_lm2 
			flag_had_spray_help = 1
		ENDIF
		
	ENDIF 

ENDWHILE

REMOVE_SPHERE sphere1_lm2

REMOVE_BLIP radar_blip_coord1_lm2

ADD_BLIP_FOR_COORD 1087.0 -574.0 -100.0 radar_blip_coord2_lm2

ADD_SPHERE 1088.4 -574.4 13.7 2.5 sphere2_lm2

flag_blip2_on_lm2 = 1

SET_TARGET_CAR_FOR_MISSION_GARAGE garage_lm2 car_lm2

//PRINT_NOW ( LM2_3 ) 7000 1 //"Good now get the car to the lockup!"

timerb = 0

// Waiting for the player to get back to luigi's

WHILE NOT IS_CAR_IN_MISSION_GARAGE garage_lm2
	
	WAIT 0	

	IF flag_lockup_message_lm2 = 0
	
		IF timerb >= 3000
			PRINT_NOW ( LM2_3 ) 7000 1 //"Good now get the car to the lockup!"
			flag_lockup_message_lm2 = 1
		ENDIF

	ENDIF
		
IF flag_car_in_garage_lm2 = 0

	IF IS_CAR_DEAD car_lm2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_luigi2_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN car_lm2
		AND IS_CAR_STOPPED car_lm2
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_luigi2_failed
		ENDIF

	ENDIF
   
	IF NOT IS_PLAYER_IN_CAR player car_lm2
	AND flag_player_had_car_message_lm2 = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //" Get back in the car and get on with the mission!"
		REMOVE_SPHERE sphere2_lm2
		ADD_BLIP_FOR_CAR car_lm2 radar_blip_car1_lm2
		REMOVE_BLIP radar_blip_coord2_lm2
		flag_player_had_car_message_lm2 = 1
	ENDIF
	
	IF IS_PLAYER_IN_CAR player car_lm2
	AND flag_player_had_car_message_lm2 = 1
		REMOVE_BLIP radar_blip_car1_lm2 
		ADD_BLIP_FOR_COORD 1087.0 -574.0 -100.0 radar_blip_coord2_lm2

		IF flag_player_had_garage_message_lm2 = 0 
			ADD_SPHERE 1088.4 -574.4 13.7 2.5 sphere2_lm2
		ENDIF

		flag_player_had_car_message_lm2 = 0
	ENDIF

	IF flag_player_had_garage_message_lm2 = 0
			
		IF LOCATE_PLAYER_IN_CAR_3D player 1088.4 -574.4 13.7 2.5 2.5 2.5 FALSE
	 	AND IS_PLAYER_IN_CAR player car_lm2
			PRINT_HELP ( GARAGE ) //"Drive the car into the garage, get out of the car and walk outside of the garage"
			REMOVE_SPHERE sphere2_lm2
 			flag_player_had_garage_message_lm2 = 1
		ENDIF

	ENDIF
	
	IF NOT LOCATE_PLAYER_IN_CAR_3D player 1088.4 -574.4 13.7 2.5 2.5 2.5 FALSE
	AND flag_player_had_garage_message_lm2 = 1
		flag_player_had_garage_message_lm2 = 0
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD car_lm2 

	//	IF IS_CAR_STOPPED_IN_AREA_2D car_lm2 1074.0 -578.0 1085.0 -568.0 FALSE
	IF DOES_GARAGE_CONTAIN_CAR garage_lm2 car_lm2
		flag_car_in_garage_lm2 = 1
	ELSE
		flag_car_in_garage_lm2 = 0
	ENDIF

ENDIF
		
ENDWHILE

REMOVE_BLIP radar_blip_coord2_lm2

REMOVE_SPHERE sphere2_lm2

}
		
GOTO mission_luigi2_passed
		

// Mission luigi1 failed

mission_luigi2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN
		

// mission Luigi1 passed

mission_luigi2_passed:

flag_luigi_mission2_passed = 1
REGISTER_MISSION_PASSED ( LM2 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 4000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT luigi_mission3_loop   
RETURN

// mission cleanup

mission_cleanup_luigi2:

flag_player_on_mission = 0
flag_player_on_luigi_mission = 0

IF flag_player_had_bat_message_lm2 = 0
	REMOVE_BLIP bat_blip_lm2
	REMOVE_PICKUP bat_lm2
ENDIF

IF NOT IS_CAR_DEAD car_lm2
	CHANGE_CAR_LOCK car_lm2 CARLOCK_UNLOCKED
ENDIF

SET_TARGET_CAR_FOR_MISSION_GARAGE garage_lm2 -1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
MARK_MODEL_AS_NO_LONGER_NEEDED PED_DOCKER2
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PROSTITUTE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PROSTITUTE2
REMOVE_BLIP radar_blip_ped1_lm2
REMOVE_BLIP radar_blip_car1_lm2
REMOVE_BLIP radar_blip_coord1_lm2
REMOVE_BLIP radar_blip_coord2_lm2
REMOVE_BLIP bat_blip_lm2
REMOVE_SPHERE sphere1_lm2
REMOVE_SPHERE sphere2_lm2
SET_FREE_RESPRAYS OFF
SWITCH_PED_ROADS_ON 1609.8 -615.2 9.0 1557.8 -673.4 20.0
MISSION_HAS_FINISHED
RETURN


girls_running:

// checks for girl1

IF flag_player_in_car_lm2 = 0

	IF flag_player_in_area_lm2 = 1

		IF flag_victim_ped_lm2_changed = 1

			IF flag_buyer1_dead_lm2 = 0

				IF IS_CHAR_DEAD buyer1_lm2
					flag_buyer1_dead_lm2 = 1
				ELSE

					IF flag_girl1_running_lm2 = 0
						SET_CHAR_OBJ_RUN_TO_COORD buyer1_lm2 1387.21 -837.38
						flag_girl1_running_lm2 = 1
					ENDIF

					IF flag_girl1_running_lm2 = 1

						IF LOCATE_CHAR_ON_FOOT_3D buyer1_lm2 1387.21 -837.38 10.8 4.0 4.0 4.0 FALSE
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS buyer1_lm2 player
							flag_girl1_running_lm2 = 2   
						ENDIF

					ENDIF

				ENDIF 
					
			ENDIF
   
// checks for girl2

			IF flag_buyer2_dead_lm2 = 0

				IF IS_CHAR_DEAD buyer2_lm2
					flag_buyer2_dead_lm2 = 1
				ELSE

					IF flag_girl2_running_lm2 = 0
						SET_CHAR_OBJ_RUN_TO_COORD buyer2_lm2 1385.98 -839.30
						flag_girl2_running_lm2 = 1
					ENDIF

					IF flag_girl2_running_lm2 = 1

						IF LOCATE_CHAR_ON_FOOT_3D buyer2_lm2 1385.98 -839.30 10.8 4.0 4.0 4.0 FALSE
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS buyer2_lm2 player
							flag_girl2_running_lm2 = 2
						ENDIF
									
					ENDIF
															  
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

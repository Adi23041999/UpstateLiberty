MISSION_START

// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Luigi mission 3*********************************
// ***************************************"Drive Misty For Me"****************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME luigi3

// Mission Start Stuff

GOSUB mission_start_luigi3

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_luigi3_failed
	ENDIF

GOSUB mission_cleanup_luigi3

MISSION_END

// Variable for mission

VAR_INT radar_blip_coord1_lm3

VAR_INT radar_blip_coord2_lm3

VAR_INT misty_lm3

VAR_INT car_lm3

VAR_INT flag_player_got_message_lm3

VAR_INT flag_player_got_cops_message_lm3

VAR_INT flag_player_not_in_zone_lm3

VAR_FLOAT door1_position_lm3

VAR_FLOAT door2_position_lm3

VAR_FLOAT difference_in_heading_door1_lm3

VAR_FLOAT difference_in_heading_door2_lm3

VAR_INT flag_blip_on_misty_lm3

VAR_INT radar_blip_ped1_lm3

VAR_INT flag_had_bus_message_lm3

VAR_INT flag_camera_mode_lm3

VAR_INT cut_car_lm3

VAR_INT cut_car2_lm3

VAR_INT cut_car3_lm3

// ****************************************Mission Start************************************

mission_start_luigi3:

flag_player_on_mission = 1

flag_player_on_luigi_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_got_message_lm3 = 0

flag_player_got_cops_message_lm3 = 0

flag_player_not_in_zone_lm3 = 0

door1_position_lm3 = 0.0

door2_position_lm3 = 0.0

difference_in_heading_door1_lm3 = 0.0

difference_in_heading_door2_lm3 = 0.0

flag_blip_on_misty_lm3 = 0

blob_flag = 1

flag_had_bus_message_lm3 = 0

flag_camera_mode_lm3 = 0


// *****************************************START OF CUT_SCENE******************************
{
/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_luigi3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( LM3 ) 15000 2 //"Drive Misty For Me."
*/

LOAD_SPECIAL_CHARACTER 1 LUIGI
LOAD_SPECIAL_CHARACTER 2 MICKY

REQUEST_MODEL indhibuild3

REQUEST_MODEL luigiclubout

REQUEST_MODEL luigiineerclub

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR
LOAD_SPECIAL_MODEL cut_obj2 LUIGIH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 MICKYH

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 926.54 -471.72 1.0 830.76 -257.96 25.0

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
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

LOAD_CUTSCENE l3_dm

SET_CUTSCENE_OFFSET 900.782 -427.523 13.829

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_luigi

SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_micky

SET_CUTSCENE_ANIM cs_micky micky

CREATE_CUTSCENE_HEAD cs_luigi CUT_OBJ2 cs_luigihead

SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_micky CUT_OBJ4 cs_mickyhead

SET_CUTSCENE_HEAD_ANIM cs_mickyhead micky

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor

SET_CUTSCENE_ANIM cs_ludoor LUDOOR

CLEAR_AREA 896.6 -426.2 13.9 1.0 TRUE
SET_PLAYER_COORDINATES player 896.6 -426.2 13.9

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_A ) 10000 1 //"Hey I've gotta talk to you... All right Mick I talk to yah later"

WHILE cs_time < 5504
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM3_A )

WHILE cs_time < 8333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_B ) 10000 1 //"How yah doing kid?

WHILE cs_time < 9667
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_C ) 10000 1 //"The Don's son, Joey Leone, he wants some action from his regular girl Misty"

WHILE cs_time < 13833
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_D ) 10000 1 //"Go pick her up at Hepburn Heights..."

WHILE cs_time < 15467
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_E ) 10000 1 //"but watch yourself that's Diablo turf."

WHILE cs_time < 18233
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_F ) 10000 1 //"Then run her over to his garage in Trenton and make it quick,"

WHILE cs_time < 21100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_G ) 10000 1 //"Joey ain't the kinda you keep waiting, remember, this is your foot in the door..."

WHILE cs_time < 25333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_H ) 10000 1 //"so keep your eyes on the road and off Misty!"

WHILE cs_time < 27701
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM3_H )

WHILE cs_time < 29666
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

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4

MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3

MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout

MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub

SET_PED_DENSITY_MULTIPLIER 1.0

// *****************************************END OF CUTSCENE*********************************

LOAD_SPECIAL_CHARACTER 2 misty

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
 
	WAIT 0

ENDWHILE

WHILE GET_FADING_STATUS

    WAIT 0

ENDWHILE

PRINT_NOW ( LM3_10 ) 5000 1 //Get a vehicle!"

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	PRINT_HELP ( HELP15 ) //"Press the...."
ENDIF

IF controlmode = 1
	PRINT_HELP ( HELP15 ) //"Press the...."
ENDIF

IF controlmode = 2
	PRINT_HELP ( HELP15 ) //"Press the...."
ENDIF

IF controlmode = 3
	PRINT_HELP ( HELP15 ) //"Press the...."
ENDIF

// waiting for the player to get into a car

WHILE NOT IS_PLAYER_IN_ANY_CAR player

	WAIT 0
  
ENDWHILE

STORE_CAR_PLAYER_IS_IN player car_lm3

PRINT_NOW ( LM3_4 ) 7000 1 //"Now Pick up Misty!"

LOAD_MISSION_AUDIO L2_A

ADD_BLIP_FOR_COORD 937.9 -259.8 -100.0 radar_blip_coord1_lm3

// waiting for the player to get to Misty's flat

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_2D player 937.9 -259.8 3.0 3.0 blob_flag
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0
         	    	 
	IF NOT IS_PLAYER_IN_ANY_CAR player
	AND flag_player_got_message_lm3 = 0
		PRINT_NOW ( IN_VEH2 ) 5000 1 //"Get a vehicle and get on with the mission!"
		REMOVE_BLIP radar_blip_coord1_lm3
		flag_player_got_message_lm3 = 1
		blob_flag = 0
	ENDIF
	
	IF IS_PLAYER_IN_ANY_CAR player
	AND flag_player_got_message_lm3 = 1
	   	ADD_BLIP_FOR_COORD 937.9 -259.8 -100.0 radar_blip_coord1_lm3
		STORE_CAR_PLAYER_IS_IN player car_lm3
		flag_player_got_message_lm3 = 0
		blob_flag = 1
	ENDIF

ENDWHILE

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	PRINT_HELP ( LM3_1A ) //"Press the~h~ L3 button~w~ to activate the ~h~horn~w~ and let Misty know you are here."
ENDIF

IF controlmode = 1
	PRINT_HELP ( LM3_1B ) //"Press the~h~ L1 button~w~ to activate the ~h~horn~w~ and let Misty know you are here."
ENDIF

IF controlmode = 2
	PRINT_HELP ( LM3_1C ) //"Press the~h~ R1 button~w~ to activate the ~h~horn~w~ and let Misty know you are here."
ENDIF

IF controlmode = 3
	PRINT_HELP ( LM3_1A ) //"Press the~h~ L3 button~w~ to activate the ~h~horn~w~ and let Misty know you are here."
ENDIF

blob_flag = 1

WHILE NOT IS_PLAYER_PRESSING_HORN player
OR NOT LOCATE_STOPPED_PLAYER_IN_CAR_2D player 937.9 -259.8 3.0 3.0 blob_flag
OR NOT IS_PLAYER_SITTING_IN_ANY_CAR player
		
	WAIT 0
	
	IF NOT IS_PLAYER_IN_ANY_CAR player
	AND flag_player_got_message_lm3 = 0
		PRINT_NOW ( IN_VEH2 ) 5000 1 //"Get a vehicle and get on with the mission!"
		REMOVE_BLIP radar_blip_coord1_lm3
		flag_player_got_message_lm3 = 1
		blob_flag = 0
	ENDIF
	
	IF IS_PLAYER_IN_ANY_CAR player
	AND flag_player_got_message_lm3 = 1
		ADD_BLIP_FOR_COORD 937.9 -259.8 -100.0 radar_blip_coord1_lm3
		STORE_CAR_PLAYER_IS_IN player car_lm3
		flag_player_got_message_lm3 = 0
		blob_flag = 1
	ENDIF
	
ENDWHILE

CLEAR_HELP

GET_PLAYER_CHAR player script_controlled_player

SET_CHAR_CANT_BE_DRAGGED_OUT script_controlled_player TRUE

/*
IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN player car_lm3

	IF NOT IS_CAR_DEAD car_lm3
		LOCK_CAR_DOORS car_lm3 CARLOCK_LOCKED_PLAYER_INSIDE
	ENDIF

ENDIF
*/


WAIT 500

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

/*
IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN player car_lm3

	IF NOT IS_CAR_DEAD car_lm3
		LOCK_CAR_DOORS car_lm3 CARLOCK_LOCKED_PLAYER_INSIDE
	ENDIF

ENDIF
*/

CLEAR_AREA 936.2 -263.9 5.0 1.0 TRUE

IF LOCATE_PLAYER_IN_CAR_2D player 937.9 -259.8 3.0 3.0 FALSE

   	IF IS_PLAYER_IN_MODEL player CAR_BUS
	OR IS_PLAYER_IN_MODEL player CAR_COACH
	OR IS_PLAYER_IN_MODEL player CAR_FLATBED
	OR IS_PLAYER_IN_MODEL player CAR_FIRETRUCK
	OR IS_PLAYER_IN_MODEL player CAR_LANDSTALKER
	OR IS_PLAYER_IN_MODEL player CAR_LINERUNNER
		flag_camera_mode_lm3 = 1
	ENDIF
	
	IF IS_PLAYER_IN_MODEL player CAR_TRASHMASTER
	OR IS_PLAYER_IN_MODEL player CAR_PONY
	OR IS_PLAYER_IN_MODEL player CAR_MULE
	OR IS_PLAYER_IN_MODEL player CAR_AMBULANCE
	OR IS_PLAYER_IN_MODEL player CAR_MRWHOOPEE
	OR IS_PLAYER_IN_MODEL player CAR_ENFORCER
		flag_camera_mode_lm3 = 1
	ENDIF
		
	IF IS_PLAYER_IN_MODEL player CAR_RUMPO
	OR IS_PLAYER_IN_MODEL player CAR_BELLYUP
	OR IS_PLAYER_IN_MODEL player CAR_MRWONGS
	OR IS_PLAYER_IN_MODEL player CAR_YANKEE
	OR IS_PLAYER_IN_MODEL player CAR_SECURICAR
		flag_camera_mode_lm3 = 1
	ENDIF

ENDIF

IF flag_camera_mode_lm3 = 1
	CLEAR_AREA 930.112 -264.972 7.336 4.0 TRUE 
	SET_FIXED_CAMERA_POSITION 930.112 -264.972 7.336 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 930.959 -265.474 7.164 JUMP_CUT 
ELSE
	CLEAR_AREA 928.169 -267.549 4.0 4.0 TRUE
	SET_FIXED_CAMERA_POSITION 928.169 -267.549 5.623 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 929.162 -267.43 5.656 JUMP_CUT
ENDIF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

//CLEAR_AREA 943.8 -271.5 4.0 4.0 TRUE // This should get rid of any stuff to block the cut-scene area

CLEAR_AREA 941.7 -269.2 4.0 1.0 TRUE // Location misty is going to run to 

REMOVE_BLIP radar_blip_coord1_lm3

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 946.47 -275.50 3.9 misty_lm3

TURN_CHAR_TO_FACE_COORD misty_lm3 942.0 -268.0 -100.0

CLEAR_CHAR_THREAT_SEARCH misty_lm3

SET_ANIM_GROUP_FOR_CHAR misty_lm3 ANIM_SEXY_WOMANPED

// opens the doors

GET_OBJECT_HEADING misty_door1 door1_position_lm3

WHILE NOT door1_position_lm3 = 90.0

	WAIT 0

	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF

	difference_in_heading_door1_lm3 = 90.0 - door1_position_lm3

		IF difference_in_heading_door1_lm3 < 10.0
			door1_position_lm3 = 90.0
		ELSE
			door1_position_lm3 += 10.0
		ENDIF

	SET_OBJECT_HEADING misty_door1 door1_position_lm3

ENDWHILE

WAIT 0

IF IS_CHAR_DEAD misty_lm3
	PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
	GOTO mission_luigi3_failed
ENDIF

CLEAR_AREA 944.1 -270.7 4.0 2.0 TRUE 

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT misty_lm3 944.1 -270.7

//POINT_CAMERA_AT_CHAR misty_lm3 FIXED JUMP_CUT

timerb = 0 

WHILE NOT IS_CHAR_OBJECTIVE_PASSED misty_lm3  // Try this one to see if it passes ok

	WAIT 0
	     
	IF IS_PLAYER_IN_ANY_CAR player

		STORE_CAR_PLAYER_IS_IN player car_lm3
	
		IF IS_CAR_DEAD car_lm3
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!" 
			GOTO mission_luigi3_failed
		ENDIF

	ENDIF
		 				
	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF

	IF timerb >= 10000

		IF NOT IS_CHAR_OBJECTIVE_PASSED misty_lm3
			SET_CHAR_COORDINATES misty_lm3 944.1 -270.7 3.9
		ENDIF
	
	ENDIF 

ENDWHILE

CLEAR_AREA 941.0 -264.0 -100.0 4.0 TRUE


/*
// Close the door

WHILE NOT door1_position_lm3 = 0.0

	WAIT 0
			  				
	IF IS_PLAYER_IN_ANY_CAR player

		STORE_CAR_PLAYER_IS_IN player car_lm3
	
		IF IS_CAR_DEAD car_lm3
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!" 
			GOTO mission_luigi3_failed
		ENDIF

	ENDIF
 				
	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1  //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF

	difference_in_heading_door1_lm3 = door1_position_lm3

	IF difference_in_heading_door1_lm3 < 10.0
		door1_position_lm3 = 0.0
	ELSE
		door1_position_lm3 -= 10.0
	ENDIF

	SET_OBJECT_HEADING misty_door1 door1_position_lm3

ENDWHILE

*/
SET_FIXED_CAMERA_POSITION 934.2 -265.8 5.9 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 934.7 -264.9 5.7 JUMP_CUT

SET_OBJECT_HEADING misty_door1 0.0

IF NOT IS_CHAR_DEAD misty_lm3

	IF NOT IS_AREA_OCCUPIED 934.10 -266.46 2.0 935.08 -268.90 10.0 FALSE TRUE TRUE TRUE TRUE
		CLEAR_AREA 934.79 -267.47 3.9 1.0 TRUE 
		SET_CHAR_COORDINATES misty_lm3 934.79 -267.47 3.9
	ENDIF

ENDIF

IF IS_PLAYER_IN_ANY_CAR player
	
	STORE_CAR_PLAYER_IS_IN player car_lm3

	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER misty_lm3 car_lm3
	   
   //	IF NOT IS_CAR_DEAD car_lm3
   //		LOCK_CAR_DOORS car_lm3 CARLOCK_UNLOCKED
   //	ENDIF					  

	IF IS_CAR_DEAD car_lm3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!" 
		GOTO mission_luigi3_failed
	ENDIF

	// waiting for Misty to get into the car 
	
	WHILE NOT IS_CHAR_IN_CAR misty_lm3 car_lm3
		  
		WAIT 0

		IF IS_CAR_DEAD car_lm3
			
			IF IS_CHAR_DEAD misty_lm3
				PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
				GOTO mission_luigi3_failed
			ELSE
				PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!" 
				GOTO mission_luigi3_failed
			ENDIF

		ENDIF
	   			 				
		IF IS_CHAR_DEAD misty_lm3
			PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
			GOTO mission_luigi3_failed
		ENDIF
		     
	ENDWHILE

ELSE

	SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT misty_lm3 player

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED misty_lm3

		WAIT 0
			
		IF IS_PLAYER_IN_ANY_CAR player

			STORE_CAR_PLAYER_IS_IN player car_lm3
	
			IF IS_CAR_DEAD car_lm3
				PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!" 
				GOTO mission_luigi3_failed
			ENDIF

		ENDIF
 				
		IF IS_CHAR_DEAD misty_lm3
			PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
			GOTO mission_luigi3_failed
		ENDIF

	ENDWHILE

ENDIF

SET_PLAYER_AS_LEADER misty_lm3 player

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA

SET_CHAR_CANT_BE_DRAGGED_OUT script_controlled_player FALSE

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF

PLAY_MISSION_AUDIO

PRINT_NOW ( LM3_5 ) 7000 1 //"You working for Luigi regular huh? It's about time he got a driver we can trust!"

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF
  
	IF NOT IS_CHAR_IN_PLAYERS_GROUP misty_lm3 player
	AND flag_blip_on_misty_lm3 = 0
		PRINT_NOW ( HEY4 ) 5000 1 //"You have left Misty behind go and get her!"
		ADD_BLIP_FOR_CHAR misty_lm3 radar_blip_ped1_lm3
		//REMOVE_BLIP radar_blip_coord2_lm3
		flag_blip_on_misty_lm3 = 1
		blob_flag = 0
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player misty_lm3 8.0 8.0 FALSE
	AND flag_blip_on_misty_lm3 = 1
		SET_PLAYER_AS_LEADER misty_lm3 player
		//PRINT_NOW ( LM3_2 ) 5000 1 //"Take Misty to see Joey Leone."
		REMOVE_BLIP radar_blip_ped1_lm3
	  	//ADD_BLIP_FOR_COORD 1196.0 -874.0 -100.0 radar_blip_coord2_lm3
		flag_blip_on_misty_lm3 = 0
		blob_flag = 1
	ENDIF
	
ENDWHILE

CLEAR_THIS_PRINT ( LM3_5 )

PRINT_NOW ( LM3_2 ) 5000 1 //"Take Misty to see Joey Leone."

ADD_BLIP_FOR_COORD 1196.0 -874.0 -100.0 radar_blip_coord2_lm3

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_2D player 1196.0 -874.0 3.0 4.0 blob_flag
OR NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D misty_lm3 1196.0 -874.0 3.0 4.0 FALSE

	WAIT 0
		
	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF
    	
	IF NOT IS_CHAR_IN_PLAYERS_GROUP misty_lm3 player
	AND flag_blip_on_misty_lm3 = 0
		PRINT_NOW ( HEY4 ) 5000 1 //"You have left Misty behind go and get her!"
		ADD_BLIP_FOR_CHAR misty_lm3 radar_blip_ped1_lm3
		REMOVE_BLIP radar_blip_coord2_lm3
		flag_blip_on_misty_lm3 = 1
		blob_flag = 0
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player misty_lm3 8.0 8.0 FALSE
	AND flag_blip_on_misty_lm3 = 1
		SET_PLAYER_AS_LEADER misty_lm3 player
		PRINT_NOW ( LM3_2 ) 5000 1 //"Take Misty to see Joey Leone."
		REMOVE_BLIP radar_blip_ped1_lm3
	  	ADD_BLIP_FOR_COORD 1196.0 -874.0 -100.0 radar_blip_coord2_lm3
		flag_blip_on_misty_lm3 = 0
		blob_flag = 1
	ENDIF 
		
ENDWHILE

REMOVE_BLIP radar_blip_coord2_lm3

SET_FIXED_CAMERA_POSITION 1211.85 -882.40 19.42 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1210.99 -881.90 19.34 JUMP_CUT

IF IS_CHAR_DEAD misty_lm3
	PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
	GOTO mission_luigi3_failed
ENDIF

LEAVE_GROUP misty_lm3

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

CLEAR_WANTED_LEVEL player

CLEAR_AREA 1190.6 -869.1 -100.0 6.0 TRUE // This should get rid of any stuff to block the cut-scene area

SET_POLICE_IGNORE_PLAYER player ON

GET_PLAYER_CHAR player script_controlled_player

IF IS_CHAR_IN_ANY_CAR misty_lm3
	STORE_CAR_CHAR_IS_IN misty_lm3 car_lm3   
	SET_CHAR_OBJ_LEAVE_CAR misty_lm3 car_lm3
ENDIF

WHILE IS_CHAR_IN_ANY_CAR misty_lm3

	WAIT 0

	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF
   	 	
ENDWHILE

IF IS_CHAR_IN_ANY_CAR script_controlled_player
	STORE_CAR_CHAR_IS_IN script_controlled_player car_lm3
	SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_lm3
ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT misty_lm3 1193.1 -868.3

WHILE IS_CHAR_IN_ANY_CAR script_controlled_player

	WAIT 0

	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF
  	 	
ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 1193.1 -868.3

WAIT 500

IF IS_CHAR_DEAD misty_lm3
	PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
	GOTO mission_luigi3_failed
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED car_lm3   

// ********************************START OF CUT-SCENE PART TWO******************************

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway

	WAIT 0

	IF IS_CHAR_DEAD misty_lm3
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!" 
		GOTO mission_luigi3_failed
	ENDIF
	
	GET_GAME_TIMER breakout_timer

	breakout_diff = breakout_timer - breakout_timer_start
	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_MODEL cut_obj1 JOEDOOR
LOAD_SPECIAL_MODEL cut_obj2 JOEYH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 MISTYH
REQUEST_MODEL CAR_MAFIA
REQUEST_MODEL CAR_IDAHO
REQUEST_MODEL CAR_STALLION
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint


WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

CHAR_SET_IDLE script_controlled_player

IF NOT IS_CHAR_DEAD misty_lm3
	CHAR_SET_IDLE misty_lm3
ENDIF

LOAD_ALL_MODELS_NOW
	
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED CAR_IDAHO
OR NOT HAS_MODEL_LOADED CAR_MAFIA
OR NOT HAS_MODEL_LOADED CAR_STALLION

	WAIT 0

ENDWHILE
	
WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED jogarageext
OR NOT HAS_MODEL_LOADED jogarageint
	
	WAIT 0

ENDWHILE

LOAD_CUTSCENE j0_dm2

SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CAR CAR_MAFIA 1189.1 -858.8 14.0 cut_car_lm3

SET_CAR_HEADING cut_car_lm3 76.0

CREATE_CAR CAR_IDAHO 1182.5 -857.0 14.1 cut_car2_lm3

SET_CAR_HEADING cut_car2_lm3 291.2

CREATE_CAR CAR_STALLION 1192.9 -860.8 14.0 cut_car3_lm3

SET_CAR_HEADING cut_car3_lm3 150.0

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_misty
SET_CUTSCENE_ANIM cs_misty misty

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ2 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_misty CUT_OBJ4 cs_mistyhead
SET_CUTSCENE_HEAD_ANIM cs_mistyhead misty

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_joedoor
SET_CUTSCENE_ANIM cs_joedoor JOEDOOR

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 FALSE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 FALSE

CLEAR_AREA 1194.0 -872.5 14.0 2.0 TRUE

SET_PLAYER_COORDINATES player 1194.0 -872.5 -100.0

SET_PLAYER_HEADING player 230.0

DELETE_CHAR misty_lm3

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 10538
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_6 ) 10000 1 //"Joey..."

WHILE cs_time < 11896
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM3_6 )

WHILE cs_time < 14353
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_6A ) 10000 1 //"Am I goin' to play with our big end again?"

WHILE cs_time < 16869
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_7 ) 10000 1 //"I'll be with you In a minute spark plug."

WHILE cs_time < 20173
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_8 ) 10000 1 //"Hey, I'm Joey."

WHILE cs_time < 21116
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_9 ) 10000 1 //"Luigi said you were reliable so come back later,"

WHILE cs_time < 23397
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_9A ) 10000 1 //"There might be some work for you."

WHILE cs_time < 25088
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM3_9B ) 10000 1 //"Alright."

WHILE cs_time < 25723
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM3_9B )

WHILE cs_time < 26666
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

SWITCH_RUBBISH ON

SWITCH_STREAMING ON

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 TRUE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MAFIA
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

DELETE_CAR cut_car_lm3

DELETE_CAR cut_car2_lm3

DELETE_CAR cut_car3_lm3

// **********************************END OF CUT-SCENE PART TWO***********************************

} 

GOTO mission_luigi3_passed
	   		


// Mission Luigi1 failed

mission_luigi3_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

// mission Luigi1 passed

mission_luigi3_passed:

flag_luigi_mission3_passed = 1
REGISTER_MISSION_PASSED ( LM3 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 1000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 1000
CLEAR_WANTED_LEVEL player
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1191.7 -870.0 -100.0 RADAR_SPRITE_JOEY joey_contact_blip
START_NEW_SCRIPT luigi_mission4_loop
START_NEW_SCRIPT joey_mission1_loop
START_NEW_SCRIPT meat_mission1_loop
RETURN
		


// mission cleanup

mission_cleanup_luigi3:

flag_player_on_mission = 0
flag_player_on_luigi_mission = 0
/*
IF NOT IS_CAR_DEAD car_lm3
	LOCK_CAR_DOORS car_lm3 CARLOCK_UNLOCKED
ENDIF
*/
REMOVE_CHAR_ELEGANTLY misty_lm3 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MAFIA
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
REMOVE_BLIP radar_blip_coord1_lm3
REMOVE_BLIP radar_blip_coord2_lm3
MISSION_HAS_FINISHED
RETURN
		



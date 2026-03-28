MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Love Mission 1********************************* 
// **********************************Save The Old Japanese Gentleman************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME love1

// Mission start stuff

GOSUB mission_start_love1

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_love1_failed
	ENDIF

GOSUB mission_cleanup_love1

MISSION_END
 
// Variables For Mission

VAR_INT car_love1

VAR_INT car_love2  // Any car the ojg might be in

VAR_INT ojg_love1

VAR_INT baddie1_love1

VAR_INT baddie2_love1

VAR_INT baddie3_love1

VAR_INT baddie4_love1

VAR_INT baddie5_love1

VAR_INT baddie6_love1

VAR_INT garage_baddie1_love1

VAR_INT garage_baddie2_love1

VAR_INT garage_baddie3_love1

VAR_INT garage_baddie4_love1

VAR_INT garage_baddie5_love1

VAR_INT garage_baddie6_love1

VAR_INT radar_blip_ped1_love1

VAR_INT flag_ojg_in_group

VAR_INT radar_blip_coord1_love1

VAR_INT flag_blip_on_ojg_love1

VAR_INT car2_love1

VAR_INT flag_baddie1_dead_love1

VAR_INT flag_baddie2_dead_love1

VAR_INT flag_baddie3_dead_love1

VAR_INT flag_baddie4_dead_love1

VAR_INT flag_baddie5_dead_love1

VAR_INT flag_baddie6_dead_love1

VAR_INT flag_garage_baddie1_dead_love1

VAR_INT flag_garage_baddie2_dead_love1

VAR_INT flag_garage_baddie3_dead_love1

VAR_INT flag_garage_baddie4_dead_love1

VAR_INT flag_garage_baddie5_dead_love1

VAR_INT flag_garage_baddie6_dead_love1

VAR_INT flag_garage1_open

VAR_INT flag_garage2_open

VAR_INT flag_garage3_open

VAR_INT flag_garage4_open

VAR_INT flag_garage5_open

VAR_INT radar_blip_coord2_love1

VAR_INT ogg_position

VAR_INT garage_car1_love1

VAR_INT garage_car2_love1

VAR_INT flag_had_garage_message_love1

VAR_INT	ojg_in_area

VAR_INT flag_ojg_dead

VAR_INT flag_player_in_area_love1
		
VAR_INT flag_player_got_car_message_love1

VAR_INT flag_message_car_again 

VAR_INT flag_ojg_in_area

VAR_INT flag_kill_player_love1

VAR_INT flag_baddie3_in_area_love1

VAR_INT flag_baddie4_in_area_love1

VAR_INT flag_baddie5_in_area_love1

VAR_INT flag_baddie6_in_area_love1

VAR_INT flag_baddie1_in_area_love1

VAR_INT flag_baddie2_in_area_love1

 
// ****************************************Mission Start************************************

mission_start_love1:

flag_player_on_mission = 1

flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_ojg_in_group = 0

flag_blip_on_ojg_love1 = 0

flag_baddie1_dead_love1 = 0

flag_baddie2_dead_love1 = 0

flag_baddie3_dead_love1 = 0

flag_baddie4_dead_love1 = 0

flag_baddie5_dead_love1 = 0

flag_baddie6_dead_love1 = 0

flag_garage_baddie1_dead_love1 = 0

flag_garage_baddie2_dead_love1 = 0

flag_garage_baddie3_dead_love1 = 0

flag_garage_baddie4_dead_love1 = 0

flag_garage_baddie5_dead_love1 = 0

flag_garage_baddie6_dead_love1 = 0

flag_garage1_open = 0

flag_garage2_open = 0

flag_garage3_open = 0

flag_garage4_open = 0

flag_garage5_open = 0

ogg_position = 0

flag_had_garage_message_love1 = 0

ojg_in_area = 0

flag_ojg_dead = 0

flag_player_in_area_love1 = 0
		
flag_player_got_car_message_love1 = 0

flag_message_car_again = 0

blob_flag = 1

flag_ojg_in_area = 0

flag_baddie1_in_area_love1 = 0

flag_baddie2_in_area_love1 = 0

flag_baddie3_in_area_love1 = 0

flag_baddie4_in_area_love1 = 0

flag_baddie5_in_area_love1 = 0

flag_baddie6_in_area_love1 = 0



{

IF flag_failed_love1 = 1

	CLOSE_GARAGE garage1_love1

	CLOSE_GARAGE garage2_love1

	CLOSE_GARAGE garage3_love1

	CLOSE_GARAGE garage4_love1

	CLOSE_GARAGE garage5_love1

ENDIF

flag_failed_love1 = 0

flag_kill_player_love1 = 0

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_love1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( LOVE1 ) 15000 2  //"Resue the Old Oriental Gentleman"

SWITCH_STREAMING OFF
*/

// Cutscene stuff

LOAD_SPECIAL_CHARACTER 1 LOVE2
REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas
LOAD_SPECIAL_MODEL cut_obj1 LOVEH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED tshrorckgrdn
OR NOT HAS_MODEL_LOADED tshrorckgrdn_alfas

	WAIT 0

ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE d1_stog

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love

SET_CUTSCENE_ANIM cs_love love2

CREATE_CUTSCENE_HEAD cs_love CUT_OBJ1 cs_lovehead

SET_CUTSCENE_HEAD_ANIM cs_lovehead love

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 83.1 -1548.7 27.3 1.0 TRUE 

SET_PLAYER_COORDINATES player 83.1 -1548.7 27.3

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4111
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_A ) 10000 1 //"First of all, let me thank you for dealing with that personal matter."

WHILE cs_time < 7246
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_F ) 10000 1 //"People will read something into anything these days."

WHILE cs_time < 10311
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_B ) 10000 1 //"Experience has taught me that a man like you can be very loyal for the right price,"

WHILE cs_time < 14533
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_H ) 10000 1 //"but groups of men get greedy."

WHILE cs_time < 17000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_C ) 10000 1 //"A valued resource, an old oriental gentleman I know,"

WHILE cs_time < 20000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_I ) 10000 1 //"has been kept hostage by some South Americans in Aspatria."

WHILE cs_time < 23188 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_D ) 10000 1 //"They're trying to extort additional funds from me but I don't believe in re-negotiation."

WHILE cs_time < 28008 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_E ) 10000 1 //"A deal is a deal, so they'll not see a penny from me.

WHILE cs_time < 32454 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LOVE1_G ) 10000 1 //"Go and rescue my friend, do whatever it takes."

WHILE cs_time < 35034 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LOVE1_G )

WHILE cs_time < 38333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_PRINTS

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

SWITCH_STREAMING ON

SWITCH_RUBBISH ON

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

SET_CAMERA_BEHIND_PLAYER

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn

MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas 


// *******************************************END OF CUTSCENE*******************************

REQUEST_MODEL PED_GANG_COLOMBIAN_A

REQUEST_MODEL CAR_COLUMB

LOAD_SPECIAL_CHARACTER 2 OJG

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
OR NOT HAS_MODEL_LOADED CAR_COLUMB

	WAIT 0

ENDWHILE

PRINT_NOW ( LOVE1_1 ) 7000 1 //"Get a columbian gang car, you'll need it to infiltrate the hideout."

// Waiting for the player to be in a colombian car
  
WHILE NOT IS_PLAYER_IN_MODEL player CAR_COLUMB

	WAIT 0

ENDWHILE

ADD_BLIP_FOR_COORD 52.0 -343.0 -100.0 radar_blip_coord2_love1

// Random munber stuff to generate OGG position

GENERATE_RANDOM_INT_IN_RANGE 2 6 ogg_position

IF ogg_position = 2

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 25.2 -340.3 15.1 ojg_love1

	CLEAR_CHAR_THREAT_SEARCH ojg_love1

	TURN_CHAR_TO_FACE_COORD ojg_love1 57.0 -314.0 -100.0
	
	CHAR_SET_IDLE ojg_love1

ENDIF

IF ogg_position = 3

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 26.3 -339.7 15.1 ojg_love1

	CLEAR_CHAR_THREAT_SEARCH ojg_love1

   	TURN_CHAR_TO_FACE_COORD ojg_love1 29.0 -339.0 -100.0
	
	CHAR_SET_IDLE ojg_love1

ENDIF

IF ogg_position = 4

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 25.5 -350.4 15.1 ojg_love1

	CLEAR_CHAR_THREAT_SEARCH ojg_love1

	TURN_CHAR_TO_FACE_COORD ojg_love1 29.0 -350.0 -100.0
	
	CHAR_SET_IDLE ojg_love1

ENDIF

IF ogg_position = 5

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 47.0 -386.0 15.1 ojg_love1

	CLEAR_CHAR_THREAT_SEARCH ojg_love1

	TURN_CHAR_TO_FACE_COORD ojg_love1 47.0 -381.0 16.0
	
	CHAR_SET_IDLE ojg_love1

ENDIF

PRINT_NOW ( LOVE1_2 ) 7000 1 //"Rescue the Old Japanese Gentleman."

CREATE_CAR CAR_COLUMB 26.2 -365.5 15.1 garage_car1_love1

SET_CAR_HEADING garage_car1_love1 270.0

CREATE_CAR CAR_COLUMB 73.6 -352.7 15.1 garage_car2_love1

SET_CAR_HEADING garage_car2_love1 270.0


// Creates the first guard he follows route 0

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 71.0 -332.0 -100.0 baddie1_love1

SET_CHAR_THREAT_SEARCH baddie1_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie1_love1  WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie1_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie1_love1 100

TURN_CHAR_TO_FACE_COORD baddie1_love1 72.0 -318.0 -100.0

ADD_ROUTE_POINT 0 71.0 -319.0 -100.0

ADD_ROUTE_POINT 0 71.0 -332.0 -100.0 

SET_CHAR_OBJ_FOLLOW_ROUTE baddie1_love1 0 FOLLOW_ROUTE_LOOP

// Creates the second guard he follows route 1

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 61.0 -318.0 -100.0 baddie2_love1

SET_CHAR_THREAT_SEARCH baddie2_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie2_love1  WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie2_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie2_love1 100

TURN_CHAR_TO_FACE_COORD baddie2_love1 61.0 -335.0 -100.0

ADD_ROUTE_POINT 1 61.0 -318.0 -100.0

ADD_ROUTE_POINT 1 61.0 -335.0 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE baddie2_love1 1 FOLLOW_ROUTE_LOOP

// Creates the third guard - does not patrol

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 42.0 -375.0 -100.0 baddie3_love1

SET_CHAR_THREAT_SEARCH baddie3_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie3_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie3_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie3_love1 100

TURN_CHAR_TO_FACE_COORD baddie3_love1 42.0 -373.0 -100.0

// Creates the fourth guard - does not patrol

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 52.0 -375.0 -100.0 baddie4_love1

SET_CHAR_THREAT_SEARCH baddie4_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie4_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie4_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie4_love1 100

TURN_CHAR_TO_FACE_COORD baddie4_love1 52.0 -371.0 -100.0

// Creates the fifth guard - does not patrol

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 32.0 -345.0 -100.0 baddie5_love1

SET_CHAR_THREAT_SEARCH baddie5_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie5_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie5_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie5_love1 100

TURN_CHAR_TO_FACE_COORD baddie5_love1 -30.0 -367.0 -100.0

// Creates the sixth guard - does not patrol

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 33.0 -328.0 -100.0 baddie6_love1

SET_CHAR_THREAT_SEARCH baddie6_love1 threat_player1

GIVE_WEAPON_TO_CHAR baddie6_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY baddie6_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR baddie6_love1 100

TURN_CHAR_TO_FACE_COORD baddie6_love1 35.0 -328.0 -100.0

// Garage guard1 in garage 2

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 55.87 -312.77 15.1 garage_baddie1_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie1_love1

GIVE_WEAPON_TO_CHAR garage_baddie1_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie1_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie1_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie1_love1 56.0 -321.0 -100.0

// Garage guard2 in garage 2

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 58.24 -312.77 15.1 garage_baddie2_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie2_love1

GIVE_WEAPON_TO_CHAR garage_baddie2_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie2_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie2_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie2_love1 56.0 -321.0 -100.0

// Garage guard3 in garage 1

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 66.26 -309.99 15.1 garage_baddie3_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie3_love1

GIVE_WEAPON_TO_CHAR garage_baddie3_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie3_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie3_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie3_love1 65.37 -316.30 -100.0

// Garage guard4 in garage 3

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 28.64 -339.83 15.1 garage_baddie4_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie4_love1

GIVE_WEAPON_TO_CHAR garage_baddie4_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie4_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie4_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie4_love1 35.26 -339.72 -100.0


// Garage guard5 in garage 4

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 29.8 -350.5 15.1 garage_baddie5_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie5_love1

GIVE_WEAPON_TO_CHAR garage_baddie5_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie5_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie5_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie5_love1 34.6 -350.0 -100.0

// Garage guard6 in garage 5

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 46.7 -379.3 15.1 garage_baddie6_love1

CLEAR_CHAR_THREAT_SEARCH garage_baddie6_love1

GIVE_WEAPON_TO_CHAR garage_baddie6_love1 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

SET_CHAR_PERSONALITY garage_baddie6_love1 PEDSTAT_TOUGH_GUY

//ADD_ARMOUR_TO_CHAR garage_baddie6_love1 100

TURN_CHAR_TO_FACE_COORD garage_baddie6_love1 47.1 -375.9 -100.0

blob_flag = 0

// waiting for the player to get the OGG to Loves

WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D ojg_love1 49.0 -1550.0 3.0 4.0 blob_flag

	WAIT 0

	IF IS_CHAR_DEAD ojg_love1
		PRINT_NOW ( LOVE1_6 ) 5000 1 //"The Old Oriental Gentleman is dead!"
		GOTO mission_love1_failed
	ENDIF

// Checks to see while the player is not in the compound if he is in a colombian car or not

	IF flag_player_in_area_love1 = 0
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB

			IF flag_player_got_car_message_love1 = 0
				PRINT_NOW ( LOVE1_5 ) 5000 1 //"Get a colombian car and get on with the mission."
				REMOVE_BLIP radar_blip_coord2_love1
				flag_player_got_car_message_love1 = 1
			ENDIF

		ELSE
			
			IF flag_player_got_car_message_love1 = 1
				ADD_BLIP_FOR_COORD 52.0 -343.0 -100.0 radar_blip_coord2_love1
				flag_player_got_car_message_love1 = 0
			ENDIF
		
		ENDIF 
		
	ENDIF

// Checks to see if the player has located close enough to the player to be set into his group	

	IF flag_ojg_in_group = 0
 	AND LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ojg_love1 3.0 3.0 FALSE
		SET_PLAYER_AS_LEADER ojg_love1 player
		PRINT_NOW ( LOVE1_3 ) 7000 1 //"Thanks get me back to loves!"
		REMOVE_BLIP radar_blip_coord2_love1
		ADD_BLIP_FOR_COORD 49.1 -1550.5 -100.0 radar_blip_coord1_love1
		blob_flag = 1 
		flag_ojg_in_group = 1
	ENDIF

	IF flag_ojg_in_group = 0
	
		IF IS_PLAYER_IN_AREA_3D player 92.2 -329.4 15.0 96.4 -315.8 18.0 FALSE

			IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
			AND flag_message_car_again = 0
			AND flag_player_in_area_love1 = 1
				//PRINT_NOW ( LOVE1_5 ) 5000 1 //"Get a colombian car and get on with the mission
				PRINT_NOW ( LOVE1_7 ) 5000 1 //"The gate will only open for a Colombian Car.
				flag_message_car_again = 1
			ENDIF

		ELSE
			flag_message_car_again = 0
		ENDIF

	ENDIF
				
	 

// Checks for the normal guards in the compound
		 	
	IF flag_baddie1_dead_love1 = 0

		IF IS_CHAR_DEAD baddie1_love1
			flag_kill_player_love1 = 1
			flag_baddie1_dead_love1 = 1
		ENDIF

	ENDIF

	IF flag_baddie2_dead_love1 = 0

		IF IS_CHAR_DEAD baddie2_love1
			flag_kill_player_love1 = 1
			flag_baddie2_dead_love1 = 1
		ENDIF

	ENDIF

	IF flag_baddie3_dead_love1 = 0

		IF IS_CHAR_DEAD baddie3_love1
			flag_kill_player_love1 = 1
			flag_baddie3_dead_love1 = 1
		ENDIF

	ENDIF

	IF flag_baddie4_dead_love1 = 0

		IF IS_CHAR_DEAD baddie4_love1
		   flag_kill_player_love1 = 1
		   flag_baddie4_dead_love1 = 1
		ENDIF

	ENDIF

	IF flag_baddie5_dead_love1 = 0

		IF IS_CHAR_DEAD baddie5_love1
			flag_kill_player_love1 = 1
			flag_baddie5_dead_love1 = 1
		ENDIF

	ENDIF

	IF flag_baddie6_dead_love1 = 0

		IF IS_CHAR_DEAD baddie6_love1
			flag_kill_player_love1 = 1
			flag_baddie6_dead_love1 = 1
		ENDIF

	ENDIF

// Checks to see if the garage door is open and if the guards are still alive sets them to kill the player

	IF flag_garage_baddie1_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie1_love1
			flag_garage_baddie1_dead_love1 = 1
		ELSE

			IF flag_garage2_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie1_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie1_love1 player
			ENDIF

		ENDIF

	ENDIF

	IF flag_garage_baddie2_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie2_love1
			flag_garage_baddie2_dead_love1 = 1
		ELSE

			IF flag_garage2_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie2_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie2_love1 player
			ENDIF

		ENDIF

	ENDIF

	IF flag_garage_baddie3_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie3_love1
			flag_garage_baddie3_dead_love1 = 1
		ELSE

			IF flag_garage1_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie3_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie3_love1 player
			ENDIF

		ENDIF

	ENDIF

	IF flag_garage_baddie4_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie4_love1
			flag_garage_baddie4_dead_love1 = 1
		ELSE

			IF flag_garage3_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie4_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie4_love1 player
			ENDIF

		ENDIF

	ENDIF


	IF flag_garage_baddie5_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie5_love1
			flag_garage_baddie5_dead_love1 = 1
		ELSE

			IF flag_garage4_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie5_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie5_love1 player
			ENDIF

			ENDIF

	ENDIF

	IF flag_garage_baddie6_dead_love1 = 0

		IF IS_CHAR_DEAD garage_baddie6_love1
			flag_garage_baddie6_dead_love1 = 1
		ELSE

			IF flag_garage5_open = 1
				SET_CHAR_THREAT_SEARCH garage_baddie6_love1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS garage_baddie6_love1 player
			ENDIF

		ENDIF

	ENDIF
	
// Checks to see if the player is in the colombian compound and if the guards are alive sets them to kill the player
 	  
	 
	IF IS_PLAYER_IN_AREA_3D player 31.0 -317.0 14.0 91.0 -394.0 25.0 FALSE
		flag_kill_player_love1 = 1
	ENDIF		
		

	IF flag_kill_player_love1 = 1

		flag_player_in_area_love1 = 1
		
		//REMOVE_BLIP radar_blip_coord2_love1

		IF flag_had_garage_message_love1 = 0
			PRINT_NOW ( LOVE1_4 ) 7000 1 //"Walk towards the garages, the Old Oriental Gentleman is in one of them."
			flag_had_garage_message_love1 = 1
		ENDIF

		IF flag_baddie1_dead_love1 = 0
		
			IF NOT IS_CHAR_DEAD baddie1_love1
			
				IF flag_baddie1_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie1_love1 72.5 -321.9
					flag_baddie1_in_area_love1 = 1
				ENDIF
				
				IF flag_baddie1_in_area_love1 = 1
				
					IF LOCATE_CHAR_ANY_MEANS_2D baddie1_love1 72.5 -321.9 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie1_love1 72.5 -321.9 15.17
						TURN_CHAR_TO_FACE_PLAYER baddie1_love1 player   
				    	SET_CHAR_STAY_IN_SAME_PLACE baddie1_love1 TRUE
					ENDIF

				ENDIF

			ENDIF

		ENDIF
					
		IF flag_baddie2_dead_love1 = 0

			IF NOT IS_CHAR_DEAD baddie2_love1

				IF flag_baddie2_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie2_love1 66.5 -332.0
					flag_baddie2_in_area_love1 = 1
				ENDIF

				IF flag_baddie2_in_area_love1 = 1
		
					IF LOCATE_CHAR_ANY_MEANS_2D baddie2_love1 66.5 -332.0 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie2_love1 66.5 -332.0 15.17
						TURN_CHAR_TO_FACE_PLAYER baddie2_love1 player   
				    	SET_CHAR_STAY_IN_SAME_PLACE baddie2_love1 TRUE
					ENDIF
					
				ENDIF
				
			ENDIF	
						
		ENDIF

		IF flag_baddie3_dead_love1 = 0

			IF NOT IS_CHAR_DEAD baddie3_love1

				IF flag_baddie3_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie3_love1 44.4 -360.7
					flag_baddie3_in_area_love1 = 1
				ENDIF
						
				IF flag_baddie3_in_area_love1 = 1

					IF LOCATE_CHAR_ANY_MEANS_2D baddie3_love1 44.4 -360.7 0.5 0.5 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD baddie3_love1 47.9 -360.1
						flag_baddie3_in_area_love1 = 2
					ENDIF
				
				ENDIF
			
				IF flag_baddie3_in_area_love1 = 2
			
					IF LOCATE_CHAR_ANY_MEANS_2D baddie3_love1 47.9 -360.1 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie3_love1 47.9 -360.1 15.1
						TURN_CHAR_TO_FACE_PLAYER baddie3_love1 player   
				    	SET_CHAR_STAY_IN_SAME_PLACE baddie3_love1 TRUE
					ENDIF

				ENDIF

			ENDIF
						
		ENDIF

		IF flag_baddie4_dead_love1 = 0
		
			IF NOT IS_CHAR_DEAD baddie4_love1

				IF flag_baddie4_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie4_love1 57.0 -365.3
					flag_baddie4_in_area_love1 = 1
				ENDIF
				
				IF flag_baddie4_in_area_love1 = 1
				
					IF LOCATE_CHAR_ANY_MEANS_2D baddie4_love1 57.0 -365.3 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie4_love1 57.0 -365.3 15.1
						TURN_CHAR_TO_FACE_PLAYER baddie4_love1 player   
				    	SET_CHAR_STAY_IN_SAME_PLACE baddie4_love1 TRUE
					ENDIF
					
				ENDIF
				
			ENDIF  
			
		ENDIF

		IF flag_baddie5_dead_love1 = 0
			
			IF NOT IS_CHAR_DEAD baddie5_love1
			
				IF flag_baddie5_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie5_love1 38.7 -345.1
					flag_baddie5_in_area_love1 = 1
				ENDIF
				
				IF flag_baddie5_in_area_love1 = 1
				
					IF LOCATE_CHAR_ANY_MEANS_2D baddie5_love1 38.7 -345.1 0.5 0.5 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD baddie5_love1 45.8 -344.3
						flag_baddie5_in_area_love1 = 2
					ENDIF

				ENDIF

				IF flag_baddie5_in_area_love1 = 2
				
					IF LOCATE_CHAR_ANY_MEANS_2D baddie5_love1 45.8 -344.3 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie5_love1 45.8 -344.3 15.1
						TURN_CHAR_TO_FACE_PLAYER baddie5_love1 player   
				     	SET_CHAR_STAY_IN_SAME_PLACE baddie5_love1 TRUE
					ENDIF

				ENDIF

			ENDIF
			  			
		ENDIF

		IF flag_baddie6_dead_love1 = 0

			IF NOT IS_CHAR_DEAD baddie6_love1
			
				IF flag_baddie6_in_area_love1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD baddie6_love1 37.3 -331.0
					flag_baddie6_in_area_love1 = 1
				ENDIF
				
				IF flag_baddie6_in_area_love1 = 1
				
					IF LOCATE_CHAR_ANY_MEANS_2D baddie6_love1 37.3 -331.0 0.5 0.5 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD baddie6_love1 42.5 -331.8
						flag_baddie6_in_area_love1 = 2
					ENDIF

				ENDIF

				IF flag_baddie6_in_area_love1 = 2

					IF LOCATE_CHAR_ANY_MEANS_2D baddie6_love1 42.5 -331.8 0.5 0.5 FALSE
						SET_CHAR_OBJ_GUARD_SPOT baddie6_love1 42.5 -331.8 15.1
						TURN_CHAR_TO_FACE_PLAYER baddie6_love1 player   
				     	SET_CHAR_STAY_IN_SAME_PLACE baddie6_love1 TRUE
					ENDIF
					
				ENDIF
				 
			ENDIF 
			
		ENDIF

// Checks for garage1

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 63.01 -317.50 13.0 69.28 -321.73 20.0 FALSE
			
			IF flag_garage1_open = 0
				OPEN_GARAGE garage1_love1
				flag_garage1_open = 1
			ENDIF

		ENDIF
				
// Checks for garage2

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 53.7 -317.56 13.0 61.0 -320.46 20.0 FALSE
			
			IF flag_garage2_open = 0
			    OPEN_GARAGE	garage2_love1
				flag_garage2_open = 1
			ENDIF

		ENDIF
	   	   
// Checks for garage3

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 31.8 -344.4 13.0 35.1 -335.6 20.0 FALSE
			
			IF flag_garage3_open = 0
				OPEN_GARAGE	garage3_love1
				flag_garage3_open = 1
			ENDIF
			
		ENDIF
						 
// Checks for garage4		

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 31.41 -355.6 13.0 34.21 -344.81 20.0 FALSE
			
			IF flag_garage4_open = 0
				OPEN_GARAGE	garage4_love1
				flag_garage4_open = 1
			ENDIF

		ENDIF

		
// Checks for garage5

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 52.9 -376.3 13.0 42.0 -373.2 20.0 FALSE
			
			IF flag_garage5_open = 0
				OPEN_GARAGE	garage5_love1
				flag_garage5_open = 1
			ENDIF

		ENDIF
						
	ENDIF

// Checks to see if the OGG is in the players group and does the group breaking stuff
			
IF flag_ojg_in_group = 1

	IF IS_CHAR_DEAD ojg_love1
		PRINT_NOW ( LOVE1_6 ) 5000 1 //"The Old Oriental Gentleman is dead!"
		GOTO mission_love1_failed
	ENDIF
	
	IF NOT IS_CHAR_IN_PLAYERS_GROUP ojg_love1 player 
	AND flag_blip_on_ojg_love1 = 0
		PRINT_NOW ( HEY8 ) 5000 1 //"You have left the Old Oriental Gentleman behind go and get him!"
		ADD_BLIP_FOR_CHAR ojg_love1 radar_blip_ped1_love1
		REMOVE_BLIP radar_blip_coord1_love1
		flag_blip_on_ojg_love1 = 1
		blob_flag = 0
	ENDIF 

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ojg_love1 8.0 8.0 FALSE 
	AND flag_blip_on_ojg_love1 = 1
		SET_PLAYER_AS_LEADER ojg_love1 player
		PRINT_NOW ( LOVE1_3 ) 7000 1 //"Thanks get me back to loves!"
		REMOVE_BLIP radar_blip_ped1_love1
		ADD_BLIP_FOR_COORD 49.1 -1550.5 -100.0 radar_blip_coord1_love1
		flag_blip_on_ojg_love1 = 0
		blob_flag = 1
	ENDIF
	
ENDIF	

ENDWHILE

REMOVE_BLIP radar_blip_coord1_love1

LEAVE_GROUP ojg_love1

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

// Checks to see if the OJG is in a car, if so orders him to get out 

IF IS_CHAR_IN_ANY_CAR ojg_love1

	STORE_CAR_CHAR_IS_IN ojg_love1 car2_love1

	SET_CHAR_OBJ_LEAVE_CAR ojg_love1 car2_love1

	WHILE IS_CHAR_IN_ANY_CAR ojg_love1

		WAIT 0

		IF IS_CHAR_DEAD ojg_love1
			PRINT_NOW ( LOVe1_6 ) 5000 1 //"The Old Oriental Gentleman is dead!"
			GOTO mission_love1_failed
		ENDIF

	ENDWHILE

ENDIF

// Tells the OJG to go into Loves buildings

SET_CHAR_OBJ_RUN_TO_COORD ojg_love1 59.5 -1548.7

timerb = 0

WHILE timerb < 1500

	WAIT 0

	IF IS_CHAR_DEAD ojg_love1
		PRINT_NOW ( LOVe1_6 ) 5000 1 //"The Old Oriental Gentleman is dead!"
		GOTO mission_love1_failed
	ENDIF

ENDWHILE


SET_CHAR_COORDINATES ojg_love1 82.9 -1548.9 27.2 
SET_CHAR_HEADING ojg_love1 270.0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT ojg_love1 98.7 -1548.8

SET_FIXED_CAMERA_POSITION 77.5 -1548.8 28.2 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 93.9 -1548.9 28.3 JUMP_CUT

timerb = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_3D ojg_love1 98.7 -1548.8 27.3 0.5 0.5 4.0 FALSE

	WAIT 0

	IF IS_CHAR_DEAD ojg_love1
		PRINT_NOW ( LOVe1_6 ) 5000 1 //"The Old Oriental Gentleman is dead!"
		GOTO mission_love1_failed
	ENDIF

	IF timerb >= 8000

		IF NOT LOCATE_CHAR_ON_FOOT_3D ojg_love1 98.7 -1548.8 27.3 0.5 0.5 4.0 FALSE
			REMOVE_CHAR_ELEGANTLY ojg_love1
			GOTO mission_bloke_stuck_love1
		ENDIF
		
	ENDIF

ENDWHILE
 
mission_bloke_stuck_love1:

CHAR_SET_IDLE ojg_love1

RESTORE_CAMERA_JUMPCUT

REMOVE_CHAR_ELEGANTLY ojg_love1

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF
}

GOTO mission_love1_passed


// Mission Kenji5 failed

mission_love1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
flag_failed_love1 = 1

RETURN

   

// mission Kenji5 passed

mission_love1_passed:

flag_love_mission1_passed = 1
REGISTER_MISSION_PASSED ( LOVE1 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 40000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 40000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT love_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_love1:

flag_player_on_mission = 0
flag_player_on_love_mission = 0
REMOVE_ROUTE 0
REMOVE_ROUTE 1
SET_PLAYER_CONTROL player ON
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
REMOVE_BLIP radar_blip_ped1_love1
REMOVE_BLIP radar_blip_coord1_love1
REMOVE_BLIP radar_blip_coord2_love1

IF NOT IS_CHAR_DEAD baddie1_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie1_love1 FALSE
ENDIF

IF NOT IS_CHAR_DEAD baddie2_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie2_love1 FALSE
ENDIF

IF NOT IS_CHAR_DEAD baddie3_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie3_love1 FALSE
ENDIF

IF NOT IS_CHAR_DEAD baddie4_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie4_love1 FALSE
ENDIF

IF NOT IS_CHAR_DEAD baddie5_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie5_love1 FALSE
ENDIF

IF NOT IS_CHAR_DEAD baddie6_love1 
	SET_CHAR_STAY_IN_SAME_PLACE baddie6_love1 FALSE
ENDIF

MISSION_HAS_FINISHED
RETURN
		



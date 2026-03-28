MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Kenji Mission 3********************************* 
// *******************************************Deal Steal************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME kenji3

// Mission start stuff

GOSUB mission_start_kenji3

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_kenji3_failed
	ENDIF

GOSUB mission_cleanup_kenji3

MISSION_END
 
// Variables for mission

VAR_INT colombian_car1_km3

VAR_INT colombian_car2_km3

VAR_INT colombian1_km3

VAR_INT colombian2_km3

VAR_INT colombian5_km3

VAR_INT colombian6_km3

VAR_INT yakuza1_km3

VAR_INT counter_number_of_yardies_dead_km3

VAR_INT radar_blip_yardie_car_km3

VAR_INT radar_blip_ped1_km3

VAR_INT radar_blip_coord2_km3

VAR_INT flag_player_had_car_message_km3

VAR_INT flag_player_had_repair_message_km3

VAR_INT flag_player_been_bad_km3

VAR_INT radar_blip_colombian_car1_km3

VAR_INT radar_blip_colombian_car2_km3

VAR_INT radar_blip_colombian1_km3

VAR_INT radar_blip_colombian2_km3

VAR_INT radar_blip_colombian5_km3

VAR_INT radar_blip_colombian6_km3

VAR_INT counter_number_of_colombians_killed_km3

VAR_INT counter_all_colombian_cars_dead_km3

VAR_INT flag_colombian1_dead_km3

VAR_INT flag_colombian2_dead_km3

VAR_INT flag_colombian5_dead_km3

VAR_INT flag_colombian6_dead_km3

VAR_INT flag_colombian_car1_dead_km3

VAR_INT flag_colombian_car2_dead_km3

VAR_INT car_km3 // TEST TO COME OUT

VAR_INT flag_yakuza1_km3_dead

VAR_INT car2_km3

VAR_INT car3_km3

VAR_INT car_cut_km3

VAR_INT flag_blip_on_yakuza_km3

VAR_INT flag_yakuza_message_km3

VAR_INT flag_bloke_in_car_km3

VAR_INT flag_car1_created_km3

VAR_INT flag_car2_created_km3

VAR_INT money_km3

VAR_INT radar_blip_money_km3

VAR_INT money_been_picked_up_km3

VAR_INT radar_blip_coord3_km3

VAR_INT flag_money_created_km3

VAR_INT flag_go_for_player_km3

VAR_INT flag_trap_audio_removed_km3

VAR_INT flag_helper_not_in_car_km3

// ****************************************Mission Start************************************

mission_start_kenji3:

flag_player_on_mission = 1

flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_km3 = 0

flag_player_been_bad_km3 = 0

counter_number_of_colombians_killed_km3 = 0

counter_all_colombian_cars_dead_km3 = 0

flag_colombian1_dead_km3 = 0

flag_colombian2_dead_km3 = 0

flag_colombian5_dead_km3 = 0

flag_colombian6_dead_km3 = 0

flag_colombian_car1_dead_km3 = 0

flag_colombian_car2_dead_km3 = 0

flag_yakuza1_km3_dead = 0

flag_blip_on_yakuza_km3 = 0

blob_flag = 1

flag_yakuza_message_km3 = 0

flag_bloke_in_car_km3 = 0

flag_car1_created_km3 = 0

flag_car2_created_km3 = 0

money_been_picked_up_km3 = 0

flag_money_created_km3 = 0

flag_go_for_player_km3 = 0

flag_trap_audio_removed_km3 = 0

flag_helper_not_in_car_km3 = 0

SWITCH_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0
SWITCH_PED_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0

{

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_kenji3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( KM3 ) 15000 2  //"Kenji Mission 3"

SWITCH_STREAMING OFF
*/

// Cutscene stuff

LOAD_SPECIAL_CHARACTER 1 KENJI
REQUEST_MODEL PED_GANG_YAKUZA_A 
LOAD_SPECIAL_MODEL cut_obj1 KENJIH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
REQUEST_MODEL casino_garden 

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A 
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED casino_garden
	
	WAIT 0

ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE k3_ds

SET_CUTSCENE_OFFSET 476.380 -1382.168 67.347

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_kenji

SET_CUTSCENE_ANIM cs_kenji kenji

CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_A cs_yakuza

SET_CUTSCENE_ANIM cs_yakuza gang07

CREATE_CUTSCENE_HEAD cs_kenji CUT_OBJ1 cs_kenjihead

SET_CUTSCENE_HEAD_ANIM cs_kenjihead kenji

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 459.1 -1413.0 25.11 1.0 TRUE 

SET_PLAYER_COORDINATES player 459.1 -1413.0 25.11
							   
SET_PLAYER_HEADING player 132.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1533
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_A ) 10000 1 //"When trouble looms, the fool turns his back, while the wise man faces it down."

WHILE cs_time < 6549
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_B ) 10000 1 //"The Colombian Cartel have ignored repeated requests to leave our interests in Liberty well alone."

WHILE cs_time < 11426
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_C ) 10000 1 //"Now they are negotiating terms with the Jamaicans in order to humiliate us further."

WHILE cs_time < 15676
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_D ) 10000 1 //"They are finalizing a deal across town. Take some of my men, steal a Yardie car and go pay your respects to the Colombians."

WHILE cs_time < 17697
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_F ) 10000 1 //"Take one of my men, steal a Yardie car and go pay your respects to the Colombians."

WHILE cs_time < 22086
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM3_E ) 10000 1 //"Our honor demands that you leave no one alive."

WHILE cs_time < 24442
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( KM3_E )

WHILE cs_time < 25000//24666
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

SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 


//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED casino_garden


// *******************************************END OF CUTSCENE*******************************

REQUEST_MODEL CAR_YARDIE

REQUEST_MODEL CAR_COLUMB

REQUEST_MODEL PED_GANG_YARDIE_A

REQUEST_MODEL PED_GANG_COLOMBIAN_A

WHILE NOT HAS_MODEL_LOADED CAR_YARDIE
OR NOT HAS_MODEL_LOADED PED_GANG_YARDIE_A
OR NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
OR NOT HAS_MODEL_LOADED CAR_COLUMB
 	
	WAIT 0

ENDWHILE
 
PRINT_NOW ( KM3_1 ) 7000 1 //"First go and get the yardie car!"

// waiting for the player to steal a yardie car

LOAD_MISSION_AUDIO K3_A

WHILE NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
OR NOT HAS_MISSION_AUDIO_LOADED
	
	WAIT 0
		   
ENDWHILE

PRINT_NOW ( KM3_2 ) 7000 1 //"Good now pick up the boys in the yardie car, press the horn to get them into the car!"

// yakuza bloke 1

CREATE_CHAR PEDTYPE_CIVMALE PED_GANG_YAKUZA_A 99.6 -414.3 -100.0 yakuza1_km3

CLEAR_CHAR_THREAT_SEARCH yakuza1_km3

SET_CHAR_PERSONALITY yakuza1_km3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEADING yakuza1_km3 0.0

GIVE_WEAPON_TO_CHAR yakuza1_km3 WEAPONTYPE_UZI 30000 // sets weapon to infinate ammo

ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3

// waiting for the player to reach the yakuza gang members

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player yakuza1_km3 8.0 8.0 8.0 FALSE
OR NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
OR NOT IS_PLAYER_STOPPED player

	WAIT 0

	IF IS_CHAR_DEAD yakuza1_km3
		PRINT_NOW ( KM3_10 ) 5000 1 //"The contact is dead!"
		flag_yakuza1_km3_dead = 1
		GOTO mission_kenji3_failed
	ENDIF 
		
	IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 0
		PRINT_NOW ( KM3_8 ) 7000 1 //"Get a Yardie car and get on with the mission!"
		REMOVE_BLIP radar_blip_ped1_km3
		flag_player_had_car_message_km3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 1
		ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3
		flag_player_had_car_message_km3 = 0
		blob_flag = 1
	ENDIF

ENDWHILE

SET_PLAYER_AS_LEADER yakuza1_km3 player
REMOVE_BLIP radar_blip_ped1_km3

// waiting for the yakuza guy to get into the players car and give his message

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player yakuza1_km3 1.0 1.0 3.0 FALSE
OR NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
//OR NOT IS_PLAYER_STOPPED player
	
	WAIT 0

	IF IS_CHAR_DEAD yakuza1_km3
		PRINT_NOW ( KM3_10 ) 5000 1 //"The contact is dead!"
		flag_yakuza1_km3_dead = 1
		GOTO mission_kenji3_failed
	ENDIF 
		
	IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 0
		PRINT_NOW ( KM3_8 ) 7000 1 //"Get a Yardie car and get on with the mission!"
		REMOVE_BLIP radar_blip_ped1_km3
		flag_player_had_car_message_km3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 1
		ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3
		flag_player_had_car_message_km3 = 0
		blob_flag = 1
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP yakuza1_km3 player
	AND flag_yakuza_message_km3 = 0
		PRINT_NOW ( HEY9 ) 5000 1 //"You have not got the information from the contact go back and get it."
		ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3
		flag_yakuza_message_km3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza1_km3 8.0 8.0 FALSE
	AND flag_yakuza_message_km3 = 1
		SET_PLAYER_AS_LEADER yakuza1_km3 player
		REMOVE_BLIP radar_blip_ped1_km3
		flag_yakuza_message_km3 = 0
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_ped1_km3

PRINT_NOW ( KM3_3 ) 5000 1 //"Okay the meeting is being held at XXXXXXX!"

ADD_BLIP_FOR_COORD 231.1 -26.3 -100.0 radar_blip_coord2_km3

// Colombian car 1

CREATE_CAR CAR_COLUMB 230.3 -42.2 -100.0 colombian_car1_km3

SET_CAR_HEADING colombian_car1_km3 0.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car1_km3 TRUE

CHANGE_CAR_LOCK colombian_car1_km3 CARLOCK_LOCKOUT_PLAYER_ONLY

flag_car1_created_km3 = 1

// Colombian car 2 

CREATE_CAR CAR_COLUMB 235.9 -41.3 -100.0 colombian_car2_km3

SET_CAR_HEADING colombian_car2_km3 0.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car2_km3 TRUE

CHANGE_CAR_LOCK colombian_car2_km3 CARLOCK_LOCKOUT_PLAYER_ONLY

flag_car2_created_km3 = 1

// creates colombian 1 in car 1

CREATE_CHAR_INSIDE_CAR colombian_car1_km3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A colombian1_km3

GIVE_WEAPON_TO_CHAR colombian1_km3 WEAPONTYPE_CHAINGUN 30000  //AK47 set to infinate ammo

CLEAR_CHAR_THREAT_SEARCH colombian1_km3

CAR_SET_IDLE colombian_car1_km3

// creates colombian 2 in car 1

CREATE_CHAR_AS_PASSENGER colombian_car1_km3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 colombian2_km3

GIVE_WEAPON_TO_CHAR colombian2_km3 WEAPONTYPE_UZI 30000  //set to infinate ammo

CLEAR_CHAR_THREAT_SEARCH colombian2_km3

// creates colombian 5 in car 2

CREATE_CHAR_INSIDE_CAR colombian_car2_km3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A colombian5_km3

GIVE_WEAPON_TO_CHAR colombian5_km3 WEAPONTYPE_UZI 30000  //set to infinate ammo

CAR_SET_IDLE colombian_car2_km3

CLEAR_CHAR_THREAT_SEARCH colombian5_km3

// creates colombian 6 in car 2

CREATE_CHAR_AS_PASSENGER colombian_car2_km3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 colombian6_km3

GIVE_WEAPON_TO_CHAR colombian6_km3 WEAPONTYPE_CHAINGUN 30000  //AK47 set to infinate ammo

CLEAR_CHAR_THREAT_SEARCH colombian6_km3

// waiting for the player to get to the meeting

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_2D player 231.1 -26.3 6.0 6.0 blob_flag
OR NOT IS_PLAYER_IN_MODEL player CAR_YARDIE

	WAIT 0

IF flag_yakuza1_km3_dead = 0 

	IF IS_CHAR_DEAD yakuza1_km3
		flag_yakuza1_km3_dead = 1
	ELSE

		IF NOT IS_CHAR_IN_PLAYERS_GROUP yakuza1_km3 player
		AND flag_blip_on_yakuza_km3 = 0
			PRINT_NOW ( HEY7 ) 5000 1 //"You have left your contact behind go and get him!"
			ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3
			REMOVE_BLIP radar_blip_coord2_km3
			flag_blip_on_yakuza_km3 = 1
			blob_flag = 0
		ENDIF
	
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza1_km3 8.0 8.0 FALSE
		AND flag_blip_on_yakuza_km3 = 1
			SET_PLAYER_AS_LEADER yakuza1_km3 player
			REMOVE_BLIP radar_blip_ped1_km3
	  		ADD_BLIP_FOR_COORD 231.1 -26.3 -100.0 radar_blip_coord2_km3
			flag_blip_on_yakuza_km3 = 0
			blob_flag = 1
		ENDIF

	ENDIF

ENDIF

	IF IS_CAR_DEAD colombian_car1_km3
		flag_colombian_car1_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered.!"
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CAR_DEAD colombian_car2_km3
		flag_colombian_car2_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered.!
		GOTO mission_kenji3_failed
	ENDIF
	
	IF IS_CHAR_DEAD colombian1_km3
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF	

	IF IS_CHAR_DEAD colombian2_km3
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF
      
	IF IS_CHAR_DEAD colombian5_km3
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian6_km3
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF
   	   
	IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 0
		PRINT_NOW ( KM3_8 ) 7000 1 //"Get a Yardie car and get on with the mission!
		REMOVE_BLIP radar_blip_coord2_km3
		flag_player_had_car_message_km3 = 1
		blob_flag = 0
	ENDIF

	IF IS_PLAYER_IN_MODEL player CAR_YARDIE
	AND flag_player_had_car_message_km3 = 1
		ADD_BLIP_FOR_COORD 231.1 -26.3 -100.0 radar_blip_coord2_km3
		flag_player_had_car_message_km3 = 0
		blob_flag = 1
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player 231.1 -26.3 10.0 10.0 FALSE

   		IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
		OR IS_PLAYER_SHOOTING player
			PRINT_NOW ( KM3_14 ) 7000 1 //"You have been seen the deals off"
			GOSUB attack_player
   			GOTO mission_kenji3_failed
		ENDIF

	ENDIF
		    
ENDWHILE

REMOVE_BLIP radar_blip_coord2_km3

IF flag_colombian_car1_dead_km3 = 0
	SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car1_km3 FALSE
ENDIF

IF flag_colombian_car2_dead_km3 = 0
	SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car2_km3 FALSE
ENDIF 

PRINT_NOW ( KM3_5 ) 7000 1 //"Press the horn to get the deal going, as soon as the Columbians are out of the car kill them all!"

// waiting for the player to press the horn

blob_flag = 1

WHILE NOT IS_PLAYER_PRESSING_HORN player
OR NOT LOCATE_STOPPED_PLAYER_IN_CAR_2D player 231.1 -26.3 6.0 6.0 blob_flag
OR NOT IS_PLAYER_IN_MODEL player CAR_YARDIE

	WAIT 0

IF flag_yakuza1_km3_dead = 0
	
	IF IS_CHAR_DEAD yakuza1_km3
		flag_yakuza1_km3_dead = 1
	ELSE

		IF NOT IS_CHAR_IN_PLAYERS_GROUP yakuza1_km3 player
		AND flag_blip_on_yakuza_km3 = 0
			PRINT_NOW ( HEY7 ) 5000 1 //"You have left your contact behind go and get him!"
			ADD_BLIP_FOR_CHAR yakuza1_km3 radar_blip_ped1_km3
			REMOVE_BLIP radar_blip_coord2_km3
			flag_blip_on_yakuza_km3 = 1
			blob_flag = 0
		ENDIF
	
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza1_km3 8.0 8.0 FALSE
		AND flag_blip_on_yakuza_km3 = 1
			SET_PLAYER_AS_LEADER yakuza1_km3 player
			REMOVE_BLIP radar_blip_ped1_km3
	  		ADD_BLIP_FOR_COORD 231.1 -26.3 -100.0 radar_blip_coord2_km3
			flag_blip_on_yakuza_km3 = 0
			blob_flag = 1
		ENDIF

		SET_CHAR_THREAT_SEARCH yakuza1_km3 THREAT_GANG_COLOMBIAN

	ENDIF
	
ENDIF

	IF IS_CAR_DEAD colombian_car1_km3
		flag_colombian_car1_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The vehicle's KM3_11!
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CAR_DEAD colombian_car2_km3
		flag_colombian_car2_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The vehicle's KM3_11!
		GOTO mission_kenji3_failed
	ENDIF
	
	IF IS_CHAR_DEAD colombian1_km3
		flag_colombian1_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian2_km3
		flag_colombian2_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian5_km3		 
		flag_colombian5_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian6_km3
		flag_colombian6_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player 231.1 -26.3 10.0 10.0 FALSE

   		IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
		OR IS_PLAYER_SHOOTING player
			PRINT_NOW ( KM3_14 ) 7000 1 //"You have been seen the deals off"
			GOSUB attack_player
   			GOTO mission_kenji3_failed
		ENDIF

	ENDIF
    	
ENDWHILE

CLEAR_THIS_PRINT ( KM3_5 )

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

CLEAR_AREA 252.0 -45.75 20.8 1.0 TRUE 

SET_FIXED_CAMERA_POSITION 252.0 -45.75 20.8 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 251.1 -45.2 20.6 JUMP_CUT

SET_CHAR_OBJ_LEAVE_CAR colombian1_km3 colombian_car1_km3

SET_CHAR_OBJ_LEAVE_CAR colombian2_km3 colombian_car1_km3

SET_CHAR_OBJ_LEAVE_CAR colombian5_km3 colombian_car2_km3

SET_CHAR_OBJ_LEAVE_CAR colombian6_km3 colombian_car2_km3

IF NOT IS_CAR_DEAD colombian_car1_km3 
	CHANGE_CAR_LOCK colombian_car1_km3 CARLOCK_UNLOCKED
ENDIF

IF NOT IS_CAR_DEAD colombian_car2_km3
	CHANGE_CAR_LOCK colombian_car2_km3 CARLOCK_UNLOCKED
ENDIF   

// waiting for the guys to get out of the car

WHILE IS_CHAR_IN_CAR colombian1_km3 colombian_car1_km3
AND IS_CHAR_IN_CAR colombian2_km3 colombian_car1_km3
AND IS_CHAR_IN_CAR colombian5_km3 colombian_car2_km3
AND IS_CHAR_IN_CAR colombian6_km3 colombian_car2_km3

	WAIT 0

IF flag_yakuza1_km3_dead = 0 

	IF IS_CHAR_DEAD yakuza1_km3
		flag_yakuza1_km3_dead = 1
	ENDIF

ENDIF

	IF IS_CAR_DEAD colombian_car1_km3
		flag_colombian_car1_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CAR_DEAD colombian_car2_km3
		flag_colombian_car2_dead_km3 = 1
		PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered."
		GOTO mission_kenji3_failed
	ENDIF
	
	IF IS_CHAR_DEAD colombian1_km3
		flag_colombian1_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian2_km3
		flag_colombian2_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian5_km3
		flag_colombian5_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

	IF IS_CHAR_DEAD colombian6_km3
		flag_colombian6_dead_km3 = 1
		PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
		GOTO mission_kenji3_failed
	ENDIF

ENDWHILE

//IF NOT IS_CHAR_DEAD colombian2_km3 
//	POINT_CAMERA_AT_CHAR colombian2_km3 FOLLOWPED JUMP_CUT 
//ENDIF

IF flag_colombian2_dead_km3 = 0

	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT colombian2_km3 233.3 -37.1

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED colombian2_km3
	
		WAIT 0

		IF flag_yakuza1_km3_dead = 0 

			IF IS_CHAR_DEAD yakuza1_km3
				flag_yakuza1_km3_dead = 1
			ENDIF

		ENDIF
	   
		IF IS_CAR_DEAD colombian_car1_km3
			flag_colombian_car1_dead_km3 = 1
			PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered."
			GOTO mission_kenji3_failed
		ENDIF

		IF IS_CAR_DEAD colombian_car2_km3
			flag_colombian_car2_dead_km3 = 1
			PRINT_NOW ( KM3_11 ) 5000 1 //"The Cartel have been attacked and the briefcase has not been recovered."
			GOTO mission_kenji3_failed
		ENDIF
	
		IF IS_CHAR_DEAD colombian1_km3
			flag_colombian1_dead_km3 = 1
			PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
			GOTO mission_kenji3_failed
		ENDIF

		IF IS_CHAR_DEAD colombian2_km3
			flag_colombian2_dead_km3 = 1
			PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
			GOTO mission_kenji3_failed
		ENDIF

		IF IS_CHAR_DEAD colombian5_km3
			flag_colombian5_dead_km3 = 1
			PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
			GOTO mission_kenji3_failed
		ENDIF

		IF IS_CHAR_DEAD colombian6_km3
			flag_colombian6_dead_km3 = 1
			PRINT_NOW ( KM3_9 ) 5000 1 //"One of the Colombians is dead, the deals off."
			GOTO mission_kenji3_failed
		ENDIF

	ENDWHILE
	
	CREATE_PICKUP briefcase PICKUP_ONCE 233.7 -36.0 15.8 money_km3

	flag_money_created_km3 = 1
		
	
ENDIF

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA_JUMPCUT

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF 

PRINT_NOW ( KM3_12 ) 5000 1 //"Kill all of the Colombians, destory the vehicles and recover the briefcase."

timera = 0

WHILE flag_go_for_player_km3 = 0
			
	WAIT 0

	IF timera >= 4000
		flag_go_for_player_km3 = 1
	ENDIF
	
	IF flag_yakuza1_km3_dead = 0 

		IF IS_CHAR_DEAD yakuza1_km3
			flag_yakuza1_km3_dead = 1
		ELSE

			IF flag_helper_not_in_car_km3 = 0 
			
				IF IS_CHAR_IN_ANY_CAR yakuza1_km3
					STORE_CAR_CHAR_IS_IN yakuza1_km3 car3_km3

					IF NOT IS_CAR_DEAD car3_km3
						LEAVE_GROUP yakuza1_km3 
						SET_CHAR_OBJ_LEAVE_CAR yakuza1_km3 car3_km3
					ENDIF

				ELSE
					flag_helper_not_in_car_km3 = 1
				ENDIF

			ENDIF
					
			IF flag_helper_not_in_car_km3 = 1 
				SET_CHAR_THREAT_SEARCH yakuza1_km3 THREAT_GANG_COLOMBIAN
				SET_CHAR_PERSONALITY yakuza1_km3 PEDSTAT_TOUGH_GUY
			ENDIF
						
		ENDIF

	ENDIF
	   
	IF flag_colombian1_dead_km3 = 0

		IF IS_CHAR_DEAD colombian1_km3
			++ counter_number_of_colombians_killed_km3
			flag_go_for_player_km3 = 1
			flag_colombian1_dead_km3 = 1
		ENDIF

	ENDIF

	IF flag_colombian2_dead_km3 = 0

		IF IS_CHAR_DEAD colombian2_km3
			++ counter_number_of_colombians_killed_km3
			flag_go_for_player_km3 = 1
			flag_colombian2_dead_km3 = 1
		ENDIF

	ENDIF

 	IF flag_colombian5_dead_km3 = 0

		IF IS_CHAR_DEAD colombian5_km3
			++ counter_number_of_colombians_killed_km3
			flag_go_for_player_km3 = 1
			flag_colombian5_dead_km3 = 1
		ENDIF 

	ENDIF

	IF flag_colombian6_dead_km3 = 0

		IF IS_CHAR_DEAD colombian6_km3
			++ counter_number_of_colombians_killed_km3
			flag_go_for_player_km3 = 1
			flag_colombian6_dead_km3 = 1
		ENDIF

	ENDIF

   
	IF flag_colombian_car1_dead_km3 = 0

		IF IS_CAR_DEAD colombian_car1_km3
			++ counter_all_colombian_cars_dead_km3
			flag_go_for_player_km3 = 1
			flag_colombian_car1_dead_km3 = 1
		ENDIF

	ENDIF

	IF flag_colombian_car2_dead_km3 = 0

		IF IS_CAR_DEAD colombian_car2_km3
			++ counter_all_colombian_cars_dead_km3
			flag_go_for_player_km3 = 1
			flag_colombian_car2_dead_km3 = 1
		ENDIF

	ENDIF

	IF NOT IS_PLAYER_IN_MODEL player CAR_YARDIE
		flag_go_for_player_km3 = 1
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 231.1 -26.3 6.0 6.0 FALSE
		flag_go_for_player_km3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player 231.1 -26.3 6.0 6.0 FALSE
	
		IF IS_PLAYER_SHOOTING player
			flag_go_for_player_km3 = 1
		ENDIF
		
	ENDIF
	
	IF money_been_picked_up_km3 = 0

		IF HAS_PICKUP_BEEN_COLLECTED money_km3
			PRINT_NOW ( KM4_8 ) 5000 1 //"Briefcase collected!"
			flag_go_for_player_km3 = 1
			money_been_picked_up_km3 = 1
		ENDIF

	ENDIF	 	
	
ENDWHILE
 

kill_player_km3:

PLAY_MISSION_AUDIO

PRINT_NOW ( KM3_7 ) 7000 1 //"Hey... your not who we were expecting!"

// briefcase

IF money_been_picked_up_km3 = 0 
	ADD_BLIP_FOR_PICKUP money_km3 radar_blip_money_km3
ENDIF

// car 1

IF flag_colombian_car1_dead_km3 = 0 
	ADD_BLIP_FOR_CAR colombian_car1_km3 radar_blip_colombian_car1_km3
ENDIF

// car 2

IF flag_colombian_car2_dead_km3 = 0 
	ADD_BLIP_FOR_CAR colombian_car2_km3 radar_blip_colombian_car2_km3
ENDIF

// colombian1

IF flag_colombian1_dead_km3 = 0

	SET_CHAR_THREAT_SEARCH colombian1_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian1_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian1_km3 PEDSTAT_TOUGH_GUY

	//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT colombian1_km3 player

	ADD_BLIP_FOR_CHAR colombian1_km3 radar_blip_colombian1_km3

ENDIF

// colombian2

IF flag_colombian2_dead_km3 = 0

	SET_CHAR_THREAT_SEARCH colombian2_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian2_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian2_km3 PEDSTAT_TOUGH_GUY

	//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT colombian2_km3 player

	ADD_BLIP_FOR_CHAR colombian2_km3 radar_blip_colombian2_km3

ENDIF


// colombian5

IF flag_colombian5_dead_km3 = 0
	
	ADD_BLIP_FOR_CHAR colombian5_km3 radar_blip_colombian5_km3

	SET_CHAR_THREAT_SEARCH colombian5_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian5_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian5_km3 PEDSTAT_TOUGH_GUY

	//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colombian5_km3 player
	
ENDIF

// colombian6

IF flag_colombian6_dead_km3 = 0
	
	ADD_BLIP_FOR_CHAR colombian6_km3 radar_blip_colombian6_km3

	SET_CHAR_THREAT_SEARCH colombian6_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian6_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian6_km3 PEDSTAT_TOUGH_GUY

	//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT colombian6_km3 player
	 
ENDIF

timerb = 0

// waiting for all the columbains and their cars to be destroyed

WHILE NOT counter_number_of_colombians_killed_km3 = 4
OR NOT counter_all_colombian_cars_dead_km3 = 2
OR NOT money_been_picked_up_km3 = 1

	WAIT 0

	IF flag_trap_audio_removed_km3 = 0

		IF HAS_MISSION_AUDIO_FINISHED
			CLEAR_THIS_PRINT ( KM3_7 )
			flag_trap_audio_removed_km3 = 1
		ENDIF

	ENDIF

	IF money_been_picked_up_km3 = 0

		IF HAS_PICKUP_BEEN_COLLECTED money_km3
			PRINT_NOW ( KM4_8 ) 5000 1 //"Briefcase collected!"
			REMOVE_BLIP radar_blip_money_km3
			money_been_picked_up_km3 = 1
		ENDIF

	ENDIF


	IF flag_yakuza1_km3_dead = 0 

		IF IS_CHAR_DEAD yakuza1_km3
			flag_yakuza1_km3_dead = 1
		ELSE

			IF flag_helper_not_in_car_km3 = 0 
			
				IF IS_CHAR_IN_ANY_CAR yakuza1_km3
					STORE_CAR_CHAR_IS_IN yakuza1_km3 car3_km3

					IF NOT IS_CAR_DEAD car3_km3
						LEAVE_GROUP yakuza1_km3 
						SET_CHAR_OBJ_LEAVE_CAR yakuza1_km3 car3_km3
					ENDIF

				ELSE
					flag_helper_not_in_car_km3 = 1
				ENDIF
							
			ENDIF

			IF flag_helper_not_in_car_km3 = 1 
				SET_CHAR_THREAT_SEARCH yakuza1_km3 THREAT_GANG_COLOMBIAN
				SET_CHAR_PERSONALITY yakuza1_km3 PEDSTAT_TOUGH_GUY
			ENDIF
			
		ENDIF

	ENDIF

	IF counter_number_of_colombians_killed_km3 = 4
		
		IF NOT IS_CHAR_DEAD yakuza1_km3

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza1_km3 20.0 20.0 FALSE
				SET_PLAYER_AS_LEADER yakuza1_km3 player
			ENDIF
	
		ENDIF

	ENDIF

	IF flag_colombian1_dead_km3 = 0

		IF IS_CHAR_DEAD colombian1_km3
			REMOVE_BLIP radar_blip_colombian1_km3
			++ counter_number_of_colombians_killed_km3
			flag_colombian1_dead_km3 = 1
		ENDIF

	ENDIF

	IF flag_colombian2_dead_km3 = 0

		IF IS_CHAR_DEAD colombian2_km3
			REMOVE_BLIP radar_blip_colombian2_km3
			++ counter_number_of_colombians_killed_km3
			flag_colombian2_dead_km3 = 1
		ENDIF

	ENDIF

 	IF flag_colombian5_dead_km3 = 0

		IF IS_CHAR_DEAD colombian5_km3
			REMOVE_BLIP radar_blip_colombian5_km3
			++ counter_number_of_colombians_killed_km3
			flag_colombian5_dead_km3 = 1
		ENDIF 

	ENDIF

	IF flag_colombian6_dead_km3 = 0

		IF IS_CHAR_DEAD colombian6_km3
			REMOVE_BLIP radar_blip_colombian6_km3
			++ counter_number_of_colombians_killed_km3
			flag_colombian6_dead_km3 = 1
		ENDIF

	ENDIF

   
	IF flag_colombian_car1_dead_km3 = 0

		IF IS_CAR_DEAD colombian_car1_km3
			REMOVE_BLIP radar_blip_colombian_car1_km3
			++ counter_all_colombian_cars_dead_km3
			flag_colombian_car1_dead_km3 = 1
		ENDIF

	ENDIF

	IF flag_colombian_car2_dead_km3 = 0

		IF IS_CAR_DEAD colombian_car2_km3
			REMOVE_BLIP radar_blip_colombian_car2_km3
			++ counter_all_colombian_cars_dead_km3
			flag_colombian_car2_dead_km3 = 1
		ENDIF

	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD yakuza1_km3

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza1_km3 20.0 20.0 FALSE
		SET_PLAYER_AS_LEADER yakuza1_km3 player
	ENDIF
	
ENDIF  

PRINT_NOW ( KM3_13 ) 5000 1 //"Take the briefcase back to the casino."

ADD_BLIP_FOR_COORD 452.3 -1465.8 17.6 radar_blip_coord3_km3

blob_flag = 1 

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player 452.3 -1465.8 17.6 4.0 4.0 4.0 blob_flag

	WAIT 0
      
ENDWHILE

REMOVE_BLIP radar_blip_coord3_km3

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

GET_PLAYER_CHAR player script_controlled_player

IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN player car_cut_km3
	SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_cut_km3
	
	WHILE IS_PLAYER_IN_CAR player car_cut_km3
	
		WAIT 0

		IF IS_CAR_DEAD car_cut_km3
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicles wrecked!"
			GOTO mission_kenji3_failed
		ENDIF 
		
	ENDWHILE
	
ENDIF

SET_FIXED_CAMERA_POSITION 420.41 -1479.59 26.13 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 420.87 -1478.75 26.38 JUMP_CUT

SET_PLAYER_COORDINATES player 425.85 -1477.16 -100.0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 428.57 -1465.01

WHILE NOT IS_CHAR_OBJECTIVE_PASSED script_controlled_player

	WAIT 0
	
ENDWHILE

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0
	
ENDWHILE

SET_PLAYER_COORDINATES player 426.81 -1486.40 17.64

SET_PLAYER_HEADING player 180.0

RESTORE_CAMERA_JUMPCUT

SET_CAMERA_IN_FRONT_OF_PLAYER 

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0
	
ENDWHILE

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF
  

}

GOTO mission_kenji3_passed
 

// Mission Kenji3 failed

mission_kenji3_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

   

// mission Kenji3 passed

mission_kenji3_passed:

flag_kenji_mission3_passed = 1
REGISTER_MISSION_PASSED ( KM3 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 25000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 25000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT kenji_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_kenji3:

flag_player_on_mission = 0
flag_player_on_kenji_mission = 0

IF NOT IS_CAR_DEAD colombian_car1_km3 

	IF flag_colombian_car1_dead_km3 = 0
		CHANGE_CAR_LOCK colombian_car1_km3 CARLOCK_UNLOCKED
		SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car1_km3 FALSE
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD colombian_car2_km3

	IF flag_colombian_car2_dead_km3 = 0
		CHANGE_CAR_LOCK colombian_car2_km3 CARLOCK_UNLOCKED
		SET_CAR_ONLY_DAMAGED_BY_PLAYER colombian_car2_km3 FALSE
	ENDIF

ENDIF

IF flag_money_created_km3 = 1

	IF money_been_picked_up_km3 = 0
		REMOVE_PICKUP money_km3
	ENDIF

ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_YARDIE
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
REMOVE_BLIP radar_blip_ped1_km3
REMOVE_BLIP radar_blip_coord2_km3
REMOVE_BLIP radar_blip_colombian_car1_km3
REMOVE_BLIP radar_blip_colombian_car2_km3
REMOVE_BLIP radar_blip_colombian1_km3
REMOVE_BLIP radar_blip_colombian2_km3
REMOVE_BLIP radar_blip_colombian5_km3
REMOVE_BLIP radar_blip_colombian6_km3
REMOVE_BLIP radar_blip_money_km3
REMOVE_BLIP radar_blip_coord3_km3
MISSION_HAS_FINISHED
RETURN
	

attack_player:

// colombian1

IF flag_colombian1_dead_km3 = 0

	SET_CHAR_THREAT_SEARCH colombian1_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian1_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian1_km3 PEDSTAT_TOUGH_GUY

	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colombian1_km3 player

ENDIF

// colombian2

IF flag_colombian2_dead_km3 = 0

	SET_CHAR_THREAT_SEARCH colombian2_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian2_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian2_km3 PEDSTAT_TOUGH_GUY

	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colombian2_km3 player

ENDIF


// colombian5

IF flag_colombian5_dead_km3 = 0
	
	SET_CHAR_THREAT_SEARCH colombian5_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian5_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian5_km3 PEDSTAT_TOUGH_GUY

	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colombian5_km3 player   
	
ENDIF

// colombian6

IF flag_colombian6_dead_km3 = 0
	
	SET_CHAR_THREAT_SEARCH colombian6_km3 THREAT_PLAYER1

	SET_CHAR_THREAT_SEARCH colombian6_km3 THREAT_GANG_YAKUZA

	SET_CHAR_PERSONALITY colombian6_km3 PEDSTAT_TOUGH_GUY

	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS colombian6_km3 player	
		 
ENDIF

RETURN

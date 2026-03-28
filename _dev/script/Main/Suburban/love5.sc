MISSION_START
// *****************************************************************************************
// ********************************		Love 5 	   *****************************************
// ********************************	Escort Service ***************************************** 
// *****************************************************************************************
// *** The packages and the OJG need transporting to the <destination>. The player must  ***
// *** escort the van. The van will be attacked en-route by the Cartel, the player must  ***
// *** fight off any attackers and protect the van at all costs.						 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love5

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_love5_failed
ENDIF

GOSUB mission_cleanup_love5

MISSION_END
 
// Variables for mission

VAR_INT escort_truck truck_driver escort_truck_blip escort_truck_health escort_truck_flag ojg 
VAR_INT columbian_humvee1 columbian_humvee2 columbian_humvee3 columbian_driver_1 columbian_driver_2 columbian_driver_3
VAR_INT car1_attacking_flag	car2_attacking_flag car3_attacking_flag	tank_weapon	escort_truck_health2
VAR_INT colombian_1 colombian_2 colombian_3 colombian_4 colombian_5 colombian_6 colombian_7 colombian_8 colombian_9 colombian_10
VAR_INT colombian_1_flag colombian_2_flag colombian_3_flag colombian_4_flag colombian_5_flag colombian_6_flag colombian_7_flag colombian_8_flag colombian_9_flag colombian_10_flag
VAR_INT columbian_hitman_1 columbian_hitman_2 columbian_hitman_3 columbian_hitman_4	columbian_hitman_5 
VAR_INT columbian_hitman_6 columbian_hitman_7 columbian_hitman_8 columbian_hitman_9 dummy_health
VAR_INT car4_attacking_flag columbian_driver_4 columbian_hitman_10 columbian_hitman_11 columbian_hitman_12 columbian_humvee4

VAR_FLOAT escort_truck_speed columbian_humvee1_speed columbian_humvee2_speed columbian_humvee3_speed columbian_humvee4_speed

// ****************************************Mission Start************************************

mission_start_love5:

flag_player_on_mission 		= 1
flag_player_on_love_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME love5

car1_attacking_flag	= 0
car2_attacking_flag	= 0
car3_attacking_flag = 0
car4_attacking_flag = 0
escort_truck_flag = 0
colombian_1_flag = 0
colombian_2_flag = 0
colombian_3_flag = 0
colombian_4_flag = 0
dummy_health = 2000

// ****************************************START OF CUTSCENE********************************

//SET_FADING_COLOUR 0 0 0
//
//DO_FADE 1500 FADE_OUT
//
//IF CAN_PLAYER_START_MISSION player
//	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
//ELSE
//	GOTO mission_love5_failed
//ENDIF
//
//PRINT_BIG LOVE5 15000 2 

LOAD_SPECIAL_CHARACTER 1 love
REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas
LOAD_SPECIAL_MODEL cut_obj1 LOVEH

SWITCH_STREAMING OFF

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED tshrorckgrdn
OR NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED cut_obj1
	WAIT 0
ENDWHILE

LOAD_CUTSCENE D5_ES

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love
SET_CUTSCENE_ANIM cs_love love

CREATE_CUTSCENE_HEAD cs_love cut_obj1 cs_lovehead
SET_CUTSCENE_HEAD_ANIM cs_lovehead love

CLEAR_AREA 82.44 -1548.49 28.0 2.0 TRUE

SET_PLAYER_COORDINATES player 82.44 -1548.49 28.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

SWITCH_RUBBISH OFF

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1324
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE5_A 5000 1//"You are proving to be a safe investment, a rare thing these days."

WHILE cs_time < 6061
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT LOVE5_B 5000 1//"My Oriental friend will need an escort while he takes my latest acquisition to be authenticated."

WHILE cs_time < 10660
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT LOVE5_C 5000 1//"I want you to follow him, and make sure he and my package get to Pike Creek unharmed."

WHILE cs_time < 17500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1

REQUEST_MODEL CAR_SECURICAR 
REQUEST_MODEL CAR_COLUMB
REQUEST_MODEL PED_GANG_COLOMBIAN_A
LOAD_SPECIAL_CHARACTER 2 OJG
LOAD_SPECIAL_CHARACTER 3 S_GUARD

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
OR NOT HAS_MODEL_LOADED CAR_COLUMB
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CAR_SECURICAR
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON

DO_FADE 1500 FADE_IN 

// ******************************************END OF CUTSCENE********************************

CREATE_CAR CAR_SECURICAR 83.6 -1592.3 25.1 escort_truck
CHANGE_CAR_COLOUR escort_truck 0 0

IF IS_CAR_DEAD escort_truck
	PRINT_NOW LOVE5_5 5000 1 //"You failed to protect the truck!"
	GOTO mission_love5_failed
ENDIF
CREATE_CHAR_INSIDE_CAR escort_truck PEDTYPE_SPECIAL PED_SPECIAL3 truck_driver
CREATE_CHAR_AS_PASSENGER escort_truck PEDTYPE_SPECIAL PED_SPECIAL2 0 ojg
SET_CHAR_CANT_BE_DRAGGED_OUT truck_driver TRUE
LOCK_CAR_DOORS escort_truck CARLOCK_LOCKED
SET_CAR_HEADING escort_truck 180.0
SET_CAR_DRIVING_STYLE escort_truck 2
SET_CAR_CRUISE_SPEED escort_truck 18.0
CAR_SET_IDLE escort_truck
SET_CAR_STRONG escort_truck TRUE
SET_CAR_PROOFS escort_truck FALSE FALSE TRUE FALSE FALSE
//SET_CAR_HEALTH escort_truck 2000
ADD_BLIP_FOR_CAR escort_truck escort_truck_blip

CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ONCE 600 77.6708 -1589.0255 27.5 tank_weapon

WHILE NOT LOCATE_PLAYER_IN_CAR_CAR_2D player escort_truck 15.0 15.0 0
OR NOT IS_POINT_ON_SCREEN 83.6 -1592.3 25.1 4.0 

	WAIT 0

	IF IS_CAR_DEAD escort_truck
		PRINT_NOW LOVE5_5 5000 1 //"You failed to protect the truck!"
		GOTO mission_love5_failed
	ENDIF

	IF LOCATE_PLAYER_ON_FOOT_CAR_2D	player escort_truck 15.0 15.0 0
		PRINT_NOW LOVE5_2 5000 1 //"You'll need a car!"
	ENDIF

	IF LOCATE_PLAYER_ON_FOOT_CAR_2D	player escort_truck 1.0 1.0 0
	AND IS_PLAYER_STOPPED player
		GOTO car_goto_bit
	ENDIF

ENDWHILE

car_goto_bit:

CAR_GOTO_COORDINATES escort_truck 173.4898 76.3099 14.9781

PRINT_NOW LOVE5_1 5000 1 //"Lets go!"

GET_CAR_HEALTH escort_truck escort_truck_health
IF dummy_health > 499
	IF escort_truck_health < 500
		escort_truck_health += 500
		SET_CAR_HEALTH escort_truck escort_truck_health
		dummy_health -= 500
	ENDIF
ENDIF
GET_CAR_HEALTH escort_truck escort_truck_health
escort_truck_health += dummy_health
escort_truck_health = escort_truck_health / 3
escort_truck_health = escort_truck_health - 250
escort_truck_health = escort_truck_health * 100
escort_truck_health = escort_truck_health / 750
escort_truck_health2 = escort_truck_health
escort_truck_health = 100 - escort_truck_health2
DISPLAY_ONSCREEN_COUNTER_WITH_STRING escort_truck_health COUNTER_DISPLAY_BAR DAM

WHILE NOT escort_truck_flag = 11
	
	WAIT 0
	
    IF IS_CAR_DEAD escort_truck
		PRINT_NOW LOVE5_5 5000 1 //"You failed to protect the truck!"
    	GOTO mission_love5_failed
    ELSE
		IF IS_CAR_UPSIDEDOWN escort_truck
		AND IS_CAR_STOPPED escort_truck
	    	GOTO mission_love5_failed
		ENDIF
//    	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player escort_truck 220.0 220.0 0
//    		PRINT_NOW LOVE5_4 500 1 //"Get back to the truck and defend it!"
//    		GET_CAR_HEALTH escort_truck escort_truck_health
//    		escort_truck_health -= 3
//			IF escort_truck_health < 1
//				escort_truck_health = 1
//				EXPLODE_CAR escort_truck
//			ELSE
//    			SET_CAR_HEALTH escort_truck escort_truck_health
//			ENDIF
//		ENDIF
    ENDIF

    GET_CAR_HEALTH escort_truck escort_truck_health
	IF dummy_health > 499
		IF escort_truck_health < 500
			escort_truck_health += 500
			SET_CAR_HEALTH escort_truck escort_truck_health
			dummy_health -= 500
		ENDIF
	ENDIF
    GET_CAR_HEALTH escort_truck escort_truck_health
	escort_truck_health += dummy_health
	escort_truck_health = escort_truck_health / 3
	escort_truck_health = escort_truck_health - 250
	escort_truck_health = escort_truck_health * 100
	escort_truck_health = escort_truck_health / 750
	escort_truck_health2 = escort_truck_health
	escort_truck_health = 100 - escort_truck_health2
	IF escort_truck_health > 100
		escort_truck_health = 100
	ENDIF
	
	IF escort_truck_flag = 0
		IF LOCATE_CAR_2D escort_truck 173.4898 76.3099 10.0 10.0 0	//out front of hospital
			CAR_GOTO_COORDINATES escort_truck 559.5281 88.7876 -21.0725
			escort_truck_flag = 1
		ENDIF
	ENDIF

	IF escort_truck_flag = 1
		IF LOCATE_CAR_2D escort_truck 302.0435 -12.4083 10.0 10.0 0//291.4709 8.6224 10.0 10.0 0
			SET_CAR_IGNORE_LEVEL_TRANSITIONS escort_truck TRUE
			IF NOT IS_CHAR_DEAD	ojg
				SET_CHAR_STAYS_IN_CURRENT_LEVEL ojg FALSE
			ENDIF
			IF NOT IS_CHAR_DEAD	truck_driver
				SET_CHAR_STAYS_IN_CURRENT_LEVEL truck_driver FALSE
			ENDIF
			SET_CAR_DRIVING_STYLE escort_truck	1
			SET_CAR_DENSITY_MULTIPLIER 0.5
		ENDIF	
	ENDIF	

	IF escort_truck_flag = 1
		IF LOCATE_CAR_2D escort_truck 559.5281 88.7876 10.0 10.0 0	 //first junction in tunnel
			CAR_GOTO_COORDINATES escort_truck -320.4337 87.1647 -21.0725
			escort_truck_flag =	2
		ENDIF
	ENDIF

	IF escort_truck_flag = 2
		IF LOCATE_CAR_2D escort_truck -320.4337 87.1647 10.0 10.0 0  //before airport junction	in tunnel
			CAR_GOTO_COORDINATES escort_truck -573.8346 -426.376 -5.76
			escort_truck_flag =	3
		ENDIF
	ENDIF

	IF escort_truck_flag = 3
		IF LOCATE_CAR_2D escort_truck -573.8346 -426.376 10.0 10.0 0  //Before sububan collision loadup
			IF NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
				PRINT_NOW LOVE5_3 200 1 //"Go ahead to scout the tunnel exit!"
			ELSE
				escort_truck_flag =	4
			ENDIF
		ENDIF
	ENDIF

	IF escort_truck_flag = 4
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
			CAR_GOTO_COORDINATES escort_truck -634.9936 -491.1914 16.1379
			escort_truck_flag = 5
		ENDIF
	ENDIF

	IF escort_truck_flag = 5
		IF LOCATE_CAR_2D escort_truck -634.9936 -491.1914 10.0 10.0 0 //at mouth of tunnel at airport
			CAR_GOTO_COORDINATES escort_truck -864.45 -282.45 32.5
			SET_CAR_IGNORE_LEVEL_TRANSITIONS escort_truck FALSE
			SET_CAR_STAYS_IN_CURRENT_LEVEL escort_truck TRUE
			IF NOT IS_CHAR_DEAD	ojg
				SET_CHAR_STAYS_IN_CURRENT_LEVEL ojg TRUE
			ENDIF
			IF NOT IS_CHAR_DEAD	truck_driver
				SET_CHAR_STAYS_IN_CURRENT_LEVEL truck_driver TRUE
			ENDIF
			SET_CAR_DRIVING_STYLE escort_truck	2
			SET_CAR_DENSITY_MULTIPLIER 1.0
			escort_truck_flag =	6
		ENDIF
	ENDIF

	IF escort_truck_flag = 6
		IF LOCATE_CAR_2D escort_truck -864.45 -282.45 10.0 10.0 0
			CAR_GOTO_COORDINATES escort_truck -975.1670 -74.5367 36.9677
			escort_truck_flag =	7
		ENDIF
	ENDIF

	IF escort_truck_flag = 7
		IF LOCATE_CAR_2D escort_truck -975.1670 -74.5367 10.0 10.0 0 //before junction at warehouse
			GOSUB call_off_the_attackers
			CAR_GOTO_COORDINATES_ACCURATE escort_truck -1044.0 -73.4361 37.8615 // inside garage
			SET_CAR_CRUISE_SPEED escort_truck 12.0
			escort_truck_flag =	8
		ENDIF
	ENDIF

	IF escort_truck_flag = 8
		IF IS_CAR_IN_AREA_2D escort_truck -1022.11 -78.28 -1037.21 -69.17 0 //outside garage
			OPEN_GARAGE escort_garage
			SET_CAR_CRUISE_SPEED escort_truck 5.0
			escort_truck_flag =	9
		ENDIF
	ENDIF

	IF escort_truck_flag = 9
		IF IS_CAR_STOPPED_IN_AREA_2D escort_truck -1049.17 -77.47 -1037.21 -69.17 0
			IF NOT IS_PLAYER_IN_AREA_2D player	-1049.17 -77.47 -1037.21 -69.17 0
				CLOSE_GARAGE escort_garage
				escort_truck_flag =	10
			ENDIF
		ENDIF
	ENDIF

	IF escort_truck_flag = 10
		IF IS_PLAYER_IN_AREA_2D player	-1049.17 -77.47 -1037.21 -69.17 0
			OPEN_GARAGE	escort_garage
			escort_truck_flag = 9
		ENDIF
		IF IS_GARAGE_CLOSED	escort_garage
			DELETE_CAR escort_truck
			GOTO mission_love5_passed
			escort_truck_flag =	11
		ENDIF
	ENDIF

	////////	
IF escort_truck_flag < 9
	IF colombian_1_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player -13.0 -464.0 220.0 220.0 0	//South of Park Dude 1
		OR LOCATE_CAR_2D escort_truck -13.0 -464.0 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -13.0 -464.0 17.0 colombian_1
			SET_CHAR_HEADING colombian_1 270.0
			GIVE_WEAPON_TO_CHAR colombian_1 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_1 TRUE
			CHAR_SET_IDLE colombian_1
			SET_CHAR_PERSONALITY colombian_1 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_1 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_1 TRUE
			colombian_1_flag = 1
		ENDIF
	ENDIF

	IF colombian_1_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -13.0 -464.0 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck -13.0 -464.0 220.0 220.0 0
			DELETE_CHAR colombian_1
			colombian_1_flag = 0
		ENDIF
	ENDIF

	IF colombian_1_flag = 1
		IF IS_CHAR_DEAD colombian_1			
			colombian_1_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_1 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_1 escort_truck
			ENDIF
		ENDIF
	ENDIF

	////////	

	IF colombian_2_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player 3.7 -467.7 220.0 220.0 0 //South of Park Dude 2
		OR LOCATE_CAR_2D escort_truck 3.7 -467.7 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 3.7 -467.7 17.0 colombian_2
			SET_CHAR_HEADING colombian_2 85.0
			GIVE_WEAPON_TO_CHAR colombian_2 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_2 TRUE
			CHAR_SET_IDLE colombian_2
			SET_CHAR_PERSONALITY colombian_2 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_2 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_2 TRUE
			colombian_2_flag = 1
		ENDIF
	ENDIF

	IF colombian_2_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 3.7 -467.7 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck 3.7 -467.7 220.0 220.0 0
			DELETE_CHAR colombian_2
			colombian_2_flag = 0
		ENDIF
	ENDIF

	IF colombian_2_flag = 1
		IF IS_CHAR_DEAD colombian_2			
			colombian_2_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_2 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_2 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_3_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player 124.4 -111.2 220.0 220.0 0	//By the university
		OR LOCATE_CAR_2D escort_truck 124.4 -111.2 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 124.4 -111.2 16.0 colombian_3
			SET_CHAR_HEADING colombian_3 85.0
			GIVE_WEAPON_TO_CHAR colombian_3 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_3 TRUE
			CHAR_SET_IDLE colombian_3
			SET_CHAR_PERSONALITY colombian_3 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_3 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_3 TRUE
			colombian_3_flag = 1
		ENDIF
	ENDIF

	IF colombian_3_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 124.4 -111.2 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck 124.4 -111.2 220.0 220.0 0
			DELETE_CHAR colombian_3
			colombian_3_flag = 0
		ENDIF
	ENDIF

	IF colombian_3_flag = 1
		IF IS_CHAR_DEAD colombian_3
			colombian_3_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_3 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_3 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_4_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player 8.65 -262.74 220.0 220.0 0	//On the Stadium steps
		OR LOCATE_CAR_2D escort_truck 8.65 -262.74 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 8.65 -262.74 16.0 colombian_4
			SET_CHAR_HEADING colombian_4 163.0
			GIVE_WEAPON_TO_CHAR colombian_4 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_4 TRUE
			CHAR_SET_IDLE colombian_4
			SET_CHAR_PERSONALITY colombian_4 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_4 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_4 TRUE
			colombian_4_flag = 1
		ENDIF
	ENDIF

	IF colombian_4_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 8.65 -262.74 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck 8.65 -262.74 220.0 220.0 0
			DELETE_CHAR colombian_4
			colombian_4_flag = 0
		ENDIF
	ENDIF

	IF colombian_4_flag = 1
		IF IS_CHAR_DEAD colombian_4
			colombian_4_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_4 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_4 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_5_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player 287.5946 17.6184 220.0 220.0 0	// On entrance to tunnel commercial
		OR LOCATE_CAR_2D escort_truck 287.5946 17.6184 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 287.5946 17.6184 19.0714 colombian_5
			SET_CHAR_HEADING colombian_5 0.0
			GIVE_WEAPON_TO_CHAR colombian_5 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_5 TRUE
			CHAR_SET_IDLE colombian_5
			SET_CHAR_PERSONALITY colombian_5 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_5 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_5 TRUE
			colombian_5_flag = 1
		ENDIF
	ENDIF

	IF colombian_5_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 287.5946 17.6184 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck 287.5946 17.6184 220.0 220.0 0
			DELETE_CHAR colombian_5
			colombian_5_flag = 0
		ENDIF
	ENDIF

	IF colombian_5_flag = 1
		IF IS_CHAR_DEAD colombian_5
			colombian_5_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_5 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_5 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_6_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player 537.7727 119.5505 220.0 220.0 0 // In tunnel at first junction
		OR LOCATE_CAR_2D escort_truck 537.7727 119.5505 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 537.7727 119.5505 -20.3699 colombian_6
			SET_CHAR_HEADING colombian_6 238.1071
			GIVE_WEAPON_TO_CHAR colombian_6 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_6 TRUE
			CHAR_SET_IDLE colombian_6
			SET_CHAR_PERSONALITY colombian_6 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_6 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_6 TRUE
			colombian_6_flag = 1
		ENDIF
	ENDIF

	IF colombian_6_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 537.7727 119.5505 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck 537.7727 119.5505 220.0 220.0 0
			DELETE_CHAR colombian_6
			colombian_6_flag = 0
		ENDIF
	ENDIF

	IF colombian_6_flag = 1
		IF IS_CHAR_DEAD colombian_6
			colombian_6_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_6 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_6 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF escort_truck_flag > 4
		IF colombian_7_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -632.9545 -499.5869 220.0 220.0 0 // On top of the exit tunnel by airport
			OR LOCATE_CAR_2D escort_truck -632.9545 -499.5869 220.0 220.0 0
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -632.9545 -499.5869 22.3742 colombian_7
				SET_CHAR_HEADING colombian_7 15.2319
				GIVE_WEAPON_TO_CHAR colombian_7 WEAPONTYPE_CHAINGUN 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_7 TRUE
				CHAR_SET_IDLE colombian_7
				SET_CHAR_PERSONALITY colombian_7 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH colombian_7 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE colombian_7 TRUE
				colombian_7_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF colombian_7_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -632.9545 -499.5869 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck -632.9545 -499.5869 220.0 220.0 0
			DELETE_CHAR colombian_7
			colombian_7_flag = 0
		ENDIF
	ENDIF

	IF colombian_7_flag = 1
		IF IS_CHAR_DEAD colombian_7
			colombian_7_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_7 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_7 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_8_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player -982.5755 -115.7109 220.0 220.0 0 // By the warehouse
		OR LOCATE_CAR_2D escort_truck -982.5755 -115.7109 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -982.5755 -115.7109 33.0045 colombian_8
			SET_CHAR_HEADING colombian_8 234.9669
			GIVE_WEAPON_TO_CHAR colombian_8 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_8 TRUE
			CHAR_SET_IDLE colombian_8
			SET_CHAR_PERSONALITY colombian_8 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_8 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_8 TRUE
			colombian_8_flag = 1
		ENDIF
	ENDIF

	IF colombian_8_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -982.5755 -115.7109 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck -982.5755 -115.7109 220.0 220.0 0
			DELETE_CHAR colombian_8
			colombian_8_flag = 0
		ENDIF
	ENDIF

	IF colombian_8_flag = 1
		IF IS_CHAR_DEAD colombian_8
			colombian_8_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_8 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_8 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF colombian_9_flag = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player -967.8587 -103.2732 220.0 220.0 0 // By the warehouse
		OR LOCATE_CAR_2D escort_truck -967.8587 -103.2732 220.0 220.0 0
			CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -967.8587 -103.2732 34.2468 colombian_9
			SET_CHAR_HEADING colombian_9 110.3819
			GIVE_WEAPON_TO_CHAR colombian_9 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_9 TRUE
			CHAR_SET_IDLE colombian_9
			SET_CHAR_PERSONALITY colombian_9 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH colombian_9 THREAT_PLAYER1
			SET_CHAR_STAY_IN_SAME_PLACE colombian_9 TRUE
			colombian_9_flag = 1
		ENDIF
	ENDIF

	IF colombian_9_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -967.8587 -103.2732 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck -967.8587 -103.2732 220.0 220.0 0
			DELETE_CHAR colombian_9
			colombian_9_flag = 0
		ENDIF
	ENDIF

	IF colombian_9_flag = 1
		IF IS_CHAR_DEAD colombian_9
			colombian_9_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_9 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_9 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////	

	IF escort_truck_flag > 4
		IF colombian_10_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -655.9044 -405.6324 220.0 220.0 0 // On central reservation by airport
			OR LOCATE_CAR_2D escort_truck -655.9044 -405.6324 220.0 220.0 0
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -655.9044 -405.6324 17.8121 colombian_10
				SET_CHAR_HEADING colombian_10 234.7831
				GIVE_WEAPON_TO_CHAR colombian_10 WEAPONTYPE_CHAINGUN 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	colombian_10 TRUE
				CHAR_SET_IDLE colombian_10
				SET_CHAR_PERSONALITY colombian_10 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH colombian_10 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE colombian_10 TRUE
				colombian_10_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF colombian_10_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -655.9044 -405.6324 220.0 220.0 0
		OR NOT LOCATE_CAR_2D escort_truck -655.9044 -405.6324 220.0 220.0 0
			DELETE_CHAR colombian_10
			colombian_10_flag = 0
		ENDIF
	ENDIF

	IF colombian_10_flag = 1
		IF IS_CHAR_DEAD colombian_10
			colombian_10_flag = 2
		ELSE
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D colombian_10 escort_truck 40.0 40.0 0
				SET_CHAR_OBJ_DESTROY_CAR colombian_10 escort_truck
			ENDIF
		ENDIF
	ENDIF
	
	////////
	
	IF car1_attacking_flag = 0
    	IF LOCATE_CAR_2D escort_truck 41.0 -1070.0 40.0 40.0 0
			
			IF NOT IS_POINT_ON_SCREEN 122.0 -1099.0 26.0 4.0
				CREATE_CAR CAR_COLUMB 122.0 -1099.0 26.0 columbian_humvee1
				SET_CAR_HEADING columbian_humvee1 65.0
			ELSE
				CREATE_CAR CAR_COLUMB -50.0 -1021.0 26.0 columbian_humvee1
				SET_CAR_HEADING columbian_humvee1 240.0
			ENDIF

			SET_CAR_STAYS_IN_CURRENT_LEVEL columbian_humvee1 FALSE
			CREATE_CHAR_INSIDE_CAR columbian_humvee1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A columbian_driver_1
			CREATE_CHAR_AS_PASSENGER columbian_humvee1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 columbian_hitman_1
			CREATE_CHAR_AS_PASSENGER columbian_humvee1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 columbian_hitman_3
			CREATE_CHAR_AS_PASSENGER columbian_humvee1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 columbian_hitman_5
			SET_CAR_CRUISE_SPEED columbian_humvee1 40.0
			SET_CAR_HEALTH columbian_humvee1 650
			SET_CAR_DRIVING_STYLE columbian_humvee1 2
			SET_CAR_DRIVING_STYLE escort_truck 2
			SET_CAR_CRUISE_SPEED escort_truck 25.0
			CAR_SET_IDLE columbian_humvee1
    		SET_CAR_BLOCK_CAR columbian_humvee1 escort_truck
			car1_attacking_flag = 1
    	ENDIF
	ENDIF

	IF car1_attacking_flag > 0
		IF IS_CAR_DEAD columbian_humvee1
			car1_attacking_flag = -100
		ELSE
			IF NOT IS_CHAR_DEAD	columbian_driver_1
				IF NOT IS_CHAR_IN_CAR columbian_driver_1 columbian_humvee1
					GIVE_WEAPON_TO_CHAR	columbian_driver_1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_1	escort_truck
				ENDIF
			ENDIF
			IF IS_PLAYER_IN_CAR player columbian_humvee1
				IF NOT IS_CHAR_DEAD columbian_hitman_1
					GIVE_WEAPON_TO_CHAR	columbian_hitman_1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_1 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_3
					GIVE_WEAPON_TO_CHAR	columbian_hitman_3 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_3 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_5
					GIVE_WEAPON_TO_CHAR	columbian_hitman_5 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_5 player
				ENDIF
			ENDIF
			IF IS_CAR_UPSIDEDOWN columbian_humvee1
			AND IS_CAR_STOPPED columbian_humvee1
				IF NOT IS_CHAR_DEAD columbian_driver_1
					GIVE_WEAPON_TO_CHAR	columbian_driver_1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_1	escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_1
					GIVE_WEAPON_TO_CHAR	columbian_hitman_1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_1 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_3
					GIVE_WEAPON_TO_CHAR	columbian_hitman_3 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_3 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_5
					GIVE_WEAPON_TO_CHAR	columbian_hitman_5 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_5 escort_truck
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF car1_attacking_flag = 1
		IF NOT IS_CHAR_DEAD columbian_hitman_1
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee1 columbian_humvee1_speed
			IF columbian_humvee1_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_1 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_1 columbian_humvee1
					SET_CHAR_RUNNING columbian_hitman_1 TRUE
					car1_attacking_flag = 2
				ENDIF
			ENDIF
		ELSE
			car1_attacking_flag = 2
		ENDIF
	ENDIF

	IF car1_attacking_flag = 2
		IF NOT IS_CHAR_DEAD columbian_hitman_1
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_1
				GIVE_WEAPON_TO_CHAR columbian_hitman_1 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_1	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee1 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee1 escort_truck
				car1_attacking_flag = 3
			ENDIF
		ELSE
			car1_attacking_flag = 3
		ENDIF
	ENDIF

	IF car1_attacking_flag = 3
		IF NOT IS_CHAR_DEAD columbian_hitman_3
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee1 columbian_humvee1_speed
			IF columbian_humvee1_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_3 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_3 columbian_humvee1
					SET_CHAR_RUNNING columbian_hitman_3 TRUE
					car1_attacking_flag = 4
				ENDIF
			ENDIF
		ELSE
			car1_attacking_flag = 4
		ENDIF
	ENDIF

	IF car1_attacking_flag = 4
		IF NOT IS_CHAR_DEAD columbian_hitman_3
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_3
				GIVE_WEAPON_TO_CHAR columbian_hitman_3 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_3	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee1 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee1 escort_truck
				car1_attacking_flag = 5
			ENDIF
		ELSE
			car1_attacking_flag = 5
		ENDIF
	ENDIF

	IF car1_attacking_flag = 5
		IF NOT IS_CHAR_DEAD columbian_hitman_5
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee1 columbian_humvee1_speed
			IF columbian_humvee1_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_5 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_5 columbian_humvee1
					SET_CHAR_RUNNING columbian_hitman_5 TRUE
					car1_attacking_flag = 6
				ENDIF
			ENDIF
		ELSE
			car1_attacking_flag = 6
		ENDIF
	ENDIF

	IF car1_attacking_flag = 6
		IF NOT IS_CHAR_DEAD columbian_hitman_5
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_5
				GIVE_WEAPON_TO_CHAR columbian_hitman_5 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_5	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee1 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee1 escort_truck
				car1_attacking_flag = 7
			ENDIF
		ELSE
			car1_attacking_flag = 7
		ENDIF
	ENDIF

	IF car1_attacking_flag = 7
		SET_CAR_CRUISE_SPEED columbian_humvee1 40.0
		SET_CAR_RAM_CAR columbian_humvee1 escort_truck
		car1_attacking_flag = 8
	ENDIF
	
	 ////////////////////////////////////

	IF car2_attacking_flag = 0
    	IF LOCATE_CAR_2D escort_truck 2.0 -405.0 40.0 40.0 0
			
			IF NOT IS_POINT_ON_SCREEN -86.0 -409.0 16.0 4.0
				CREATE_CAR CAR_COLUMB -86.0 -409.0 16.0 columbian_humvee2
				SET_CAR_HEADING columbian_humvee2 270.0
			ELSE
				CREATE_CAR CAR_COLUMB -100.0 -409.0 16.0 columbian_humvee2
				SET_CAR_HEADING columbian_humvee2 90.0
			ENDIF
			
			SET_CAR_STAYS_IN_CURRENT_LEVEL columbian_humvee2 FALSE
			CREATE_CHAR_INSIDE_CAR columbian_humvee2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A columbian_driver_2
			CREATE_CHAR_AS_PASSENGER columbian_humvee2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 columbian_hitman_2
			CREATE_CHAR_AS_PASSENGER columbian_humvee2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 columbian_hitman_4
			CREATE_CHAR_AS_PASSENGER columbian_humvee2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 columbian_hitman_6
			SET_CAR_CRUISE_SPEED columbian_humvee2 40.0
			SET_CAR_DRIVING_STYLE columbian_humvee2 2
			SET_CAR_HEALTH columbian_humvee2 650
			CAR_SET_IDLE columbian_humvee2
    		SET_CAR_BLOCK_CAR columbian_humvee2 escort_truck
			car2_attacking_flag = 1
    	ENDIF
	ENDIF

	IF car2_attacking_flag > 0
		IF IS_CAR_DEAD columbian_humvee2
			car2_attacking_flag = -100
		ELSE
			IF NOT IS_CHAR_DEAD	columbian_driver_2
				IF NOT IS_CHAR_IN_CAR columbian_driver_2 columbian_humvee2
					GIVE_WEAPON_TO_CHAR	columbian_driver_2 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_2	escort_truck
				ENDIF
			ENDIF
			IF IS_PLAYER_IN_CAR player columbian_humvee2
				IF NOT IS_CHAR_DEAD columbian_hitman_2
					GIVE_WEAPON_TO_CHAR	columbian_hitman_2 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_2 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_4
					GIVE_WEAPON_TO_CHAR	columbian_hitman_4 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_4 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_6
					GIVE_WEAPON_TO_CHAR	columbian_hitman_6 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_6 player
				ENDIF
			ENDIF
			IF IS_CAR_UPSIDEDOWN columbian_humvee2
			AND IS_CAR_STOPPED columbian_humvee2
				IF NOT IS_CHAR_DEAD columbian_driver_2
					GIVE_WEAPON_TO_CHAR	columbian_driver_2 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_2	escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_2
					GIVE_WEAPON_TO_CHAR	columbian_hitman_2 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_2 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_4
					GIVE_WEAPON_TO_CHAR	columbian_hitman_4 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_4 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_6
					GIVE_WEAPON_TO_CHAR	columbian_hitman_6 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_6 escort_truck
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF car2_attacking_flag = 1
		IF NOT IS_CHAR_DEAD columbian_hitman_2
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee2 columbian_humvee2_speed
			IF columbian_humvee2_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_2 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_2 columbian_humvee2
					SET_CHAR_RUNNING columbian_hitman_2 TRUE
					car2_attacking_flag = 2
				ENDIF
			ENDIF
		ELSE
			car2_attacking_flag = 2
		ENDIF
	ENDIF

	IF car2_attacking_flag = 2
		IF NOT IS_CHAR_DEAD columbian_hitman_2
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_2
				GIVE_WEAPON_TO_CHAR columbian_hitman_2 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_2	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee2 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee2 escort_truck
				car2_attacking_flag = 3
			ENDIF
		ELSE
			car2_attacking_flag = 3
		ENDIF
	ENDIF

	IF car2_attacking_flag = 3
		IF NOT IS_CHAR_DEAD columbian_hitman_4
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee2 columbian_humvee2_speed
			IF columbian_humvee2_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_4 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_4 columbian_humvee2
					SET_CHAR_RUNNING columbian_hitman_4 TRUE
					car2_attacking_flag = 4
				ENDIF
			ENDIF
		ELSE
			car2_attacking_flag = 4
		ENDIF
	ENDIF

	IF car2_attacking_flag = 4
		IF NOT IS_CHAR_DEAD columbian_hitman_4
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_4
				GIVE_WEAPON_TO_CHAR columbian_hitman_4 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_4	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee2 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee2 escort_truck
				car2_attacking_flag = 5
			ENDIF
		ELSE
			car2_attacking_flag = 5
		ENDIF
	ENDIF
	
	IF car2_attacking_flag = 5
		IF NOT IS_CHAR_DEAD columbian_hitman_6
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee2 columbian_humvee2_speed
			IF columbian_humvee2_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_6 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_6 columbian_humvee2
					SET_CHAR_RUNNING columbian_hitman_6 TRUE
					car2_attacking_flag = 6
				ENDIF
			ENDIF
		ELSE
			car2_attacking_flag = 6
		ENDIF
	ENDIF

	IF car2_attacking_flag = 6
		IF NOT IS_CHAR_DEAD columbian_hitman_6
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_6
				GIVE_WEAPON_TO_CHAR columbian_hitman_6 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_6	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee2 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee2 escort_truck
				car2_attacking_flag = 7
			ENDIF
		ELSE
			car2_attacking_flag = 7
		ENDIF
	ENDIF

	IF car2_attacking_flag = 7
		SET_CAR_CRUISE_SPEED columbian_humvee2 40.0
		SET_CAR_RAM_CAR columbian_humvee2 escort_truck
		car2_attacking_flag = 8
	ENDIF

	////////////////////////////////////
	
	IF escort_truck_flag > 4
		IF car3_attacking_flag = 0
	    	IF LOCATE_CAR_2D escort_truck -645.8259 -435.9940 40.0 40.0 0
				
				IF NOT IS_POINT_ON_SCREEN -823.6705 -435.0647 10.0779 4.0
					CREATE_CAR CAR_COLUMB -823.6705 -435.0647 10.0779 columbian_humvee3
					SET_CAR_HEADING columbian_humvee3 272.1213
				ELSE
					CREATE_CAR CAR_COLUMB -735.5045 -577.3362 7.6714 columbian_humvee3
					SET_CAR_HEADING columbian_humvee3 7.8079
				ENDIF

				SET_CAR_STAYS_IN_CURRENT_LEVEL columbian_humvee3 FALSE
				CREATE_CHAR_INSIDE_CAR columbian_humvee3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A columbian_driver_3
				CREATE_CHAR_AS_PASSENGER columbian_humvee3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 columbian_hitman_7
				CREATE_CHAR_AS_PASSENGER columbian_humvee3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 columbian_hitman_8
				CREATE_CHAR_AS_PASSENGER columbian_humvee3 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 columbian_hitman_9
				SET_CAR_CRUISE_SPEED columbian_humvee3 40.0
				SET_CAR_HEALTH columbian_humvee3 650
				SET_CAR_DRIVING_STYLE columbian_humvee3 2
				CAR_SET_IDLE columbian_humvee3
	    		SET_CAR_BLOCK_CAR columbian_humvee3 escort_truck
				car3_attacking_flag = 1
	    	ENDIF
		ENDIF
	ENDIF
	
	IF car3_attacking_flag > 0
		IF IS_CAR_DEAD columbian_humvee3
			car3_attacking_flag = -100
		ELSE
			IF NOT IS_CHAR_DEAD	columbian_driver_3
				IF NOT IS_CHAR_IN_CAR columbian_driver_3 columbian_humvee3
					GIVE_WEAPON_TO_CHAR	columbian_driver_3 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_3	escort_truck
				ENDIF
			ENDIF
			IF IS_PLAYER_IN_CAR player columbian_humvee3
				IF NOT IS_CHAR_DEAD columbian_hitman_7
					GIVE_WEAPON_TO_CHAR	columbian_hitman_7 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_7 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_8
					GIVE_WEAPON_TO_CHAR	columbian_hitman_8 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_8 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_9
					GIVE_WEAPON_TO_CHAR	columbian_hitman_9 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_9 player
				ENDIF
			ENDIF
			IF IS_CAR_UPSIDEDOWN columbian_humvee3
			AND IS_CAR_STOPPED columbian_humvee3
				IF NOT IS_CHAR_DEAD columbian_driver_3
					GIVE_WEAPON_TO_CHAR	columbian_driver_3 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_3	escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_7
					GIVE_WEAPON_TO_CHAR	columbian_hitman_7 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_7 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_8
					GIVE_WEAPON_TO_CHAR	columbian_hitman_8 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_8 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_9
					GIVE_WEAPON_TO_CHAR	columbian_hitman_9 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_9 escort_truck
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF car3_attacking_flag = 1
		IF NOT IS_CHAR_DEAD columbian_hitman_7
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee3 columbian_humvee3_speed
			IF columbian_humvee3_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_7 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_7 columbian_humvee3
					SET_CHAR_RUNNING columbian_hitman_7 TRUE
					car3_attacking_flag = 2
				ENDIF
			ENDIF
		ELSE
			car3_attacking_flag = 2
		ENDIF
	ENDIF

	IF car3_attacking_flag = 2
		IF NOT IS_CHAR_DEAD columbian_hitman_7
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_7
				GIVE_WEAPON_TO_CHAR columbian_hitman_7 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_7	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee3 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee3 escort_truck
				car3_attacking_flag = 3
			ENDIF
		ELSE
			car3_attacking_flag = 3
		ENDIF
	ENDIF

	IF car3_attacking_flag = 3
		IF NOT IS_CHAR_DEAD columbian_hitman_8
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee3 columbian_humvee3_speed
			IF columbian_humvee3_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_8 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_8 columbian_humvee3
					SET_CHAR_RUNNING columbian_hitman_8 TRUE
					car3_attacking_flag = 4
				ENDIF
			ENDIF
		ELSE
			car3_attacking_flag = 4
		ENDIF
	ENDIF

	IF car3_attacking_flag = 4
		IF NOT IS_CHAR_DEAD columbian_hitman_8
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_8
				GIVE_WEAPON_TO_CHAR columbian_hitman_8 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_8	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee3 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee3 escort_truck
				car3_attacking_flag = 5
			ENDIF
		ELSE
			car3_attacking_flag = 5
		ENDIF
	ENDIF
	
	IF car3_attacking_flag = 5
		IF NOT IS_CHAR_DEAD columbian_hitman_9
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee3 columbian_humvee3_speed
			IF columbian_humvee3_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_9 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_9 columbian_humvee3
					SET_CHAR_RUNNING columbian_hitman_9 TRUE
					car3_attacking_flag = 6
				ENDIF
			ENDIF
		ELSE
			car3_attacking_flag = 6
		ENDIF
	ENDIF

	IF car3_attacking_flag = 6
		IF NOT IS_CHAR_DEAD columbian_hitman_9
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_9
				GIVE_WEAPON_TO_CHAR columbian_hitman_9 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_9	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee3 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee3 escort_truck
				car3_attacking_flag = 7
			ENDIF
		ELSE
			car3_attacking_flag = 7
		ENDIF
	ENDIF

	IF car3_attacking_flag = 7
		SET_CAR_CRUISE_SPEED columbian_humvee3 40.0
		SET_CAR_RAM_CAR columbian_humvee3 escort_truck
		car3_attacking_flag = 8
	ENDIF
	
	////////
	
	IF car4_attacking_flag = 0
    	IF LOCATE_CAR_2D escort_truck -645.8259 -435.9940 40.0 40.0 0
			
			IF NOT IS_POINT_ON_SCREEN -1017.6605 -226.1589 37.9967 4.0
				CREATE_CAR CAR_COLUMB -1017.6605 -226.1589 37.9967 columbian_humvee4
				SET_CAR_HEADING columbian_humvee4 284.9633
			ELSE
				CREATE_CAR CAR_COLUMB -878.8591 -229.1282 28.1703 columbian_humvee4
				SET_CAR_HEADING columbian_humvee4 84.5748
			ENDIF

			SET_CAR_STAYS_IN_CURRENT_LEVEL columbian_humvee4 FALSE
			CREATE_CHAR_INSIDE_CAR columbian_humvee4 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A columbian_driver_4
			CREATE_CHAR_AS_PASSENGER columbian_humvee4 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 0 columbian_hitman_10
			CREATE_CHAR_AS_PASSENGER columbian_humvee4 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 columbian_hitman_11
			CREATE_CHAR_AS_PASSENGER columbian_humvee4 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 columbian_hitman_12
			SET_CAR_CRUISE_SPEED columbian_humvee4 40.0
			SET_CAR_HEALTH columbian_humvee4 650
			SET_CAR_DRIVING_STYLE columbian_humvee4 2
			CAR_SET_IDLE columbian_humvee4
    		SET_CAR_BLOCK_CAR columbian_humvee4 escort_truck
			car4_attacking_flag = 1
    	ENDIF
	ENDIF

	IF car4_attacking_flag > 0
		IF IS_CAR_DEAD columbian_humvee4
			car4_attacking_flag = -100
		ELSE
			IF NOT IS_CHAR_DEAD	columbian_driver_4
				IF NOT IS_CHAR_IN_CAR columbian_driver_4 columbian_humvee4
					GIVE_WEAPON_TO_CHAR	columbian_driver_4 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_4	escort_truck
				ENDIF
			ENDIF
			IF IS_PLAYER_IN_CAR player columbian_humvee4
				IF NOT IS_CHAR_DEAD columbian_hitman_10
					GIVE_WEAPON_TO_CHAR	columbian_hitman_10 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_10 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_11
					GIVE_WEAPON_TO_CHAR	columbian_hitman_11 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_11 player
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_12
					GIVE_WEAPON_TO_CHAR	columbian_hitman_12 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT columbian_hitman_12 player
				ENDIF
			ENDIF
			IF IS_CAR_UPSIDEDOWN columbian_humvee4
			AND IS_CAR_STOPPED columbian_humvee4
				IF NOT IS_CHAR_DEAD columbian_driver_4
					GIVE_WEAPON_TO_CHAR	columbian_driver_4 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_driver_4	escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_10
					GIVE_WEAPON_TO_CHAR	columbian_hitman_10 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_10 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_11
					GIVE_WEAPON_TO_CHAR	columbian_hitman_11 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_11 escort_truck
				ENDIF
				IF NOT IS_CHAR_DEAD columbian_hitman_12
					GIVE_WEAPON_TO_CHAR	columbian_hitman_12 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_12 escort_truck
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF car4_attacking_flag = 1
		IF NOT IS_CHAR_DEAD columbian_hitman_10
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee4 columbian_humvee4_speed
			IF columbian_humvee4_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_10 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_10 columbian_humvee4
					SET_CHAR_RUNNING columbian_hitman_10 TRUE
					car4_attacking_flag = 2
				ENDIF
			ENDIF
		ELSE
			car4_attacking_flag = 2
		ENDIF
	ENDIF

	IF car4_attacking_flag = 2
		IF NOT IS_CHAR_DEAD columbian_hitman_10
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_10
				GIVE_WEAPON_TO_CHAR columbian_hitman_10 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_10	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee4 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee4 escort_truck
				car4_attacking_flag = 3
			ENDIF
		ELSE
			car4_attacking_flag = 3
		ENDIF
	ENDIF

	IF car4_attacking_flag = 3
		IF NOT IS_CHAR_DEAD columbian_hitman_11
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee4 columbian_humvee4_speed
			IF columbian_humvee4_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_11 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_11 columbian_humvee4
					SET_CHAR_RUNNING columbian_hitman_11 TRUE
					car4_attacking_flag = 4
				ENDIF
			ENDIF
		ELSE
			car4_attacking_flag = 4
		ENDIF
	ENDIF

	IF car4_attacking_flag = 4
		IF NOT IS_CHAR_DEAD columbian_hitman_11
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_11
				GIVE_WEAPON_TO_CHAR columbian_hitman_11 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_11	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee4 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee4 escort_truck
				car4_attacking_flag = 5
			ENDIF
		ELSE
			car4_attacking_flag = 5
		ENDIF
	ENDIF

	IF car4_attacking_flag = 5
		IF NOT IS_CHAR_DEAD columbian_hitman_12
			GET_CAR_SPEED escort_truck escort_truck_speed
			GET_CAR_SPEED columbian_humvee4 columbian_humvee4_speed
			IF columbian_humvee4_speed < 10.0
			AND escort_truck_speed < 4.0
				IF LOCATE_CHAR_IN_CAR_CAR_2D columbian_hitman_12 escort_truck 10.0 10.0 0
					SET_CHAR_OBJ_LEAVE_CAR columbian_hitman_12 columbian_humvee4
					SET_CHAR_RUNNING columbian_hitman_12 TRUE
					car4_attacking_flag = 6
				ENDIF
			ENDIF
		ELSE
			car4_attacking_flag = 6
		ENDIF
	ENDIF

	IF car4_attacking_flag = 6
		IF NOT IS_CHAR_DEAD columbian_hitman_12
			IF NOT IS_CHAR_IN_ANY_CAR columbian_hitman_12
				GIVE_WEAPON_TO_CHAR columbian_hitman_12 WEAPONTYPE_CHAINGUN 999
				SET_CHAR_OBJ_DESTROY_CAR columbian_hitman_12	escort_truck
				SET_CAR_CRUISE_SPEED columbian_humvee4 40.0
    			SET_CAR_BLOCK_CAR columbian_humvee4 escort_truck
				car4_attacking_flag = 7
			ENDIF
		ELSE
			car4_attacking_flag = 7
		ENDIF
	ENDIF

	IF car4_attacking_flag = 7
		SET_CAR_CRUISE_SPEED columbian_humvee4 40.0
		SET_CAR_RAM_CAR columbian_humvee4 escort_truck
		car4_attacking_flag = 8
	ENDIF
	
	 ////////////////////////////////////

ELSE
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee1
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee2
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee3

	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_driver_1
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_driver_2
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_driver_3

	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_1
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_2
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_3
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_4
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_5
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_6
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_7
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_8
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_9
	
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_1
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_2
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_3
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_4
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_5
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_6
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_7
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_8
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_9
	MARK_CHAR_AS_NO_LONGER_NEEDED colombian_10
ENDIF

ENDWHILE

GOTO mission_love5_passed
	   		
	
// Mission love 5 failed

mission_love5_failed:
PRINT_BIG M_FAIL 2000 1
RETURN

   

// mission love 5 passed

mission_love5_passed:

flag_love_mission5_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 40000 2000 1
ADD_SCORE player 40000
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED	LOVE5
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT love_mission6_loop
RETURN
		


// mission cleanup

mission_cleanup_love5:

flag_player_on_mission = 0
flag_player_on_love_mission = 0

IF NOT HAS_PICKUP_BEEN_COLLECTED tank_weapon
	REMOVE_PICKUP tank_weapon
ENDIF
CLEAR_ONSCREEN_COUNTER escort_truck_health
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SECURICAR
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
SET_CAR_DENSITY_MULTIPLIER 1.0

REMOVE_BLIP	escort_truck_blip

MISSION_HAS_FINISHED

RETURN
		


call_off_the_attackers:

	IF NOT IS_CAR_DEAD columbian_humvee1
		CAR_WANDER_RANDOMLY	columbian_humvee1
	ENDIF
	IF NOT IS_CAR_DEAD columbian_humvee2
		CAR_WANDER_RANDOMLY	columbian_humvee2
	ENDIF
	IF NOT IS_CAR_DEAD columbian_humvee3
		CAR_WANDER_RANDOMLY	columbian_humvee3
	ENDIF
	IF NOT IS_CAR_DEAD columbian_humvee4
		CAR_WANDER_RANDOMLY	columbian_humvee4
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_1
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_1 player
	ENDIF
	IF NOT IS_CHAR_DEAD columbian_hitman_2
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_2 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_3
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_3 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_4
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_4 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_5
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_5 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_6
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_6 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_7
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_7 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_8
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_8 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_9
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_9 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_10
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_10 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_11
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_11 player
	ENDIF
	IF NOT IS_CHAR_DEAD	columbian_hitman_12
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS columbian_hitman_12 player
	ENDIF
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee1
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee2
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee3
	MARK_CAR_AS_NO_LONGER_NEEDED columbian_humvee4
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_1
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_2
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_3
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_4
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_5
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_6
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_7
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_8
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_9
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_10
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_11
	MARK_CHAR_AS_NO_LONGER_NEEDED columbian_hitman_12
	car1_attacking_flag = -100
	car2_attacking_flag = -100
	car3_attacking_flag = -100
	car4_attacking_flag = -100

RETURN

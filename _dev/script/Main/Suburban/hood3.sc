MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// *************************************Hood Mission 3****************************************
// *************************************Rigged To Blow****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME hood3

// Mission start stuff

GOSUB mission_start_hood3

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_hood3_failed
	ENDIF

GOSUB mission_cleanup_hood3

MISSION_END


// Variables for mission

VAR_INT car_hm3

VAR_INT radar_blip_car1_hm3

VAR_INT timer_hm3

VAR_INT radar_blip_coord1_hm3

VAR_FLOAT carx_hm3

VAR_FLOAT cary_hm3

VAR_FLOAT carz_hm3

VAR_INT radar_blip_coord2_hm3

VAR_INT flag_player_had_repair_message_hm3

VAR_INT flag_player_had_car_message_hm3

VAR_INT flag_blip2_on

VAR_INT current_time_hm3

VAR_INT best_time_hm3

VAR_INT car_health_hm3

VAR_INT car_damage_hm3

VAR_INT flag_dont_check_stuff_hm3

VAR_INT flag_player_had_out_message_hm3

// ***************************************Mission Start*************************************

mission_start_hood3:

flag_player_on_mission = 1

flag_player_on_hood_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_repair_message_hm3 = 0

flag_player_had_car_message_hm3 = 0

flag_blip2_on = 0

blob_flag = 1

timer_hm3 = 361000  // 6 mins

car_health_hm3 = 1000

car_damage_hm3 = 0

flag_dont_check_stuff_hm3 = 0

flag_player_had_out_message_hm3 = 0

{

// ********************************************START OF CUTSCENE****************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_hood3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( HM_3 ) 15000 2 //"RIGGED TO BLOW"

SWITCH_STREAMING OFF

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH			

WHILE GET_FADING_STATUS
				  
	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS -414.57 97.73 1.0 -589.29 -101.77 20.0

//LOAD_ALL_MODELS_NOW

//WHILE NOT HAS_MODEL_LOADED cut_obj1

//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE hd_ph3 
SET_CUTSCENE_OFFSET -444.714 -6.321 2.9

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
PRINT_NOW ( HM3_A ) 10000 1  //"Some effa..." 

WHILE cs_time < 4262
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_B ) 10000 1 //"If I lose those wheels..." 

WHILE cs_time < 7770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_C ) 10000 1 //"Pick up my car..." 

WHILE cs_time < 11514
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_D ) 10000 1 //"Let them diffuse..." 

WHILE cs_time < 14528
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_E ) 10000 1 //"The clocks...." 

WHILE cs_time < 17707
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_F ) 10000 1 //"You hit one pot hole..." 

WHILE cs_time < 20250
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM3_G ) 10000 1 //"Now move it..."

WHILE cs_time < 20951
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( HM3_G ) 

WHILE cs_time < 21666
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

//SWITCH_STREAMING ON

WAIT 500

DO_FADE 1500 FADE_IN

//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

SET_PED_DENSITY_MULTIPLIER 1.0


// *********************************************END OF CUTSCENE*****************************

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_MAFIA THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_DIABLO THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_YAKUZA THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_YARDIE THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_COLOMBIAN THREAT_PLAYER1

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HOOD THREAT_PLAYER1

REQUEST_MODEL CAR_INFERNUS

WHILE NOT HAS_MODEL_LOADED CAR_INFERNUS
	
	WAIT 0

ENDWHILE

CREATE_CAR CAR_INFERNUS -682.0 76.0 -100.0 car_hm3

SET_CAR_HEADING car_hm3 0.0

SET_CAN_RESPRAY_CAR car_hm3 FALSE

ADD_BLIP_FOR_CAR car_hm3 radar_blip_car1_hm3

SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm3 car_hm3

DISPLAY_ONSCREEN_TIMER timer_hm3

IF IS_CAR_DEAD car_hm3
	PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
	GOTO mission_hood3_failed
ENDIF

// waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_hm3

	WAIT 0

	IF IS_CAR_DEAD car_hm3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_hood3_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN car_hm3
		AND IS_CAR_STOPPED car_hm3 
			PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
			GOTO mission_hood3_failed
		ENDIF
		
	ENDIF

	IF timer_hm3 = 0
		car_damage_hm3 = 100
		EXPLODE_CAR car_hm3
	ENDIF
			
ENDWHILE

REMOVE_BLIP radar_blip_car1_hm3

PRINT_NOW ( HM3_1 ) 7000 1 //"Get to the garage but watch out if the car takes too much damage it will blow!

ADD_BLIP_FOR_COORD 1354.7 -312.9 48.9 radar_blip_coord1_hm3

DISPLAY_ONSCREEN_COUNTER_WITH_STRING car_damage_hm3 COUNTER_DISPLAY_BAR ( DETON ) 

// waiting for the player to reach the garage

WHILE NOT IS_CAR_IN_MISSION_GARAGE garage_hm3

	WAIT 0
	
	IF IS_CAR_DEAD car_hm3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_hood3_failed
	ELSE

		GET_CAR_HEALTH car_hm3 car_health_hm3

		car_damage_hm3 = 1000 - car_health_hm3
		
		IF car_damage_hm3 > 100
			car_damage_hm3 = 100
		ENDIF


		IF IS_CAR_UPSIDEDOWN car_hm3
		AND IS_CAR_STOPPED car_hm3
			PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
			GOTO mission_hood3_failed
		ENDIF

	ENDIF
	
	IF timer_hm3 = 0
		car_damage_hm3 = 100
		EXPLODE_CAR car_hm3
	ENDIF

	IF car_damage_hm3 = 100
		EXPLODE_CAR car_hm3
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player car_hm3
	AND flag_player_had_car_message_hm3 = 0
		PRINT_NOW ( IN_VEH ) 7000 1 //" Get back in the car and get on with the mission!"
		REMOVE_BLIP radar_blip_coord1_hm3
		ADD_BLIP_FOR_CAR car_hm3 radar_blip_car1_hm3
		flag_player_had_car_message_hm3 = 1
	ENDIF

	IF IS_PLAYER_IN_CAR player car_hm3
	AND flag_player_had_car_message_hm3 = 1
		REMOVE_BLIP radar_blip_car1_hm3
		ADD_BLIP_FOR_COORD 1354.7 -312.9 48.9 radar_blip_coord1_hm3
		flag_player_had_car_message_hm3 = 0
	ENDIF
	
ENDWHILE

current_time_hm3 = 361000 - timer_hm3

current_time_hm3 = current_time_hm3 / 1000

REGISTER_DEFUSE_BOMB_TIME current_time_hm3

REMOVE_BLIP radar_blip_coord1_hm3

CLEAR_ONSCREEN_COUNTER car_damage_hm3

CLEAR_ONSCREEN_TIMER timer_hm3

PRINT_NOW ( HM3_2 ) 7000 1 //"Bring the car back and I want it mint - no damage!"

ADD_BLIP_FOR_COORD -682.0 76.0 -100.0 radar_blip_coord2_hm3

flag_blip2_on = 1

blob_flag = 1

WHILE NOT LOCATE_STOPPED_CAR_3D car_hm3 -682.0 76.0 17.4 3.0 4.0 4.0 blob_flag
OR IS_CAR_VISIBLY_DAMAGED car_hm3
OR IS_PLAYER_IN_CAR player car_hm3 	   
	
	WAIT 0
			   
	IF IS_CAR_DEAD car_hm3
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_hood3_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN car_hm3
		AND IS_CAR_STOPPED car_hm3
			PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
			GOTO mission_hood3_failed
		ENDIF

	ENDIF

	IF LOCATE_STOPPED_CAR_3D car_hm3 -682.0 76.0 17.4 3.0 4.0 4.0 FALSE

		IF NOT IS_CAR_VISIBLY_DAMAGED car_hm3
			flag_dont_check_stuff_hm3 = 1
		ENDIF

		IF flag_player_had_out_message_hm3 = 0
			PRINT_NOW ( OUT_VEH ) 5000 1 //"Get out of the vehicle!"
			flag_player_had_out_message_hm3 = 1
		ENDIF

	ELSE
		flag_dont_check_stuff_hm3 = 0
		flag_player_had_out_message_hm3 = 0
	ENDIF
	
	IF flag_dont_check_stuff_hm3 = 0 	
	
		IF IS_PLAYER_IN_CAR player car_hm3
				
			IF flag_player_had_car_message_hm3 = 1
				REMOVE_BLIP radar_blip_car1_hm3
				flag_player_had_car_message_hm3 = 0
			ENDIF

			IF IS_CAR_VISIBLY_DAMAGED car_hm3

				IF flag_player_had_repair_message_hm3 = 0
					PRINT_NOW ( HM3_3 ) 7000 1 //"Get the car repaired I want it mint!"
					REMOVE_BLIP radar_blip_coord2_hm3
					flag_blip2_on = 0
					flag_player_had_repair_message_hm3 = 1
				ENDIF

				blob_flag = 0
										    
			ELSE
			
				IF flag_blip2_on = 0
					ADD_BLIP_FOR_COORD -682.0 76.0 -100.0 radar_blip_coord2_hm3
					PRINT_NOW ( HM3_2 ) 7000 1 //"Bring the car back and I want it mint - no damage!"
					flag_blip2_on = 1
				ENDIF

				blob_flag = 1
						
				flag_player_had_repair_message_hm3 = 0
													
			ENDIF
			
		ELSE
	
			IF flag_player_had_car_message_hm3 = 0
				PRINT_NOW ( IN_VEH ) 7000 1 //" Get back in the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord2_hm3
				flag_blip2_on = 0
				ADD_BLIP_FOR_CAR car_hm3 radar_blip_car1_hm3
				flag_player_had_car_message_hm3 = 1
			ENDIF
			blob_flag = 0
			flag_player_had_repair_message_hm3 = 0		

		ENDIF

	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD car_hm3
	CHANGE_CAR_LOCK car_hm3 CARLOCK_LOCKED
ENDIF

REMOVE_BLIP radar_blip_coord2_hm3


}	
		    
GOTO mission_hood3_passed

 

// Mission hood3 failed

mission_hood3_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_SUBURBAN 
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_SUBURBAN
ENDIF

RETURN


   

// mission hood3 passed

mission_hood3_passed:

IF flag_hood_mission3_passed = 0
	REGISTER_MISSION_PASSED ( HM_3 )
	PLAYER_MADE_PROGRESS 1
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //Mission Passed!"
	PLAY_MISSION_PASSED_TUNE 1
	ADD_SCORE player 20000
	CLEAR_WANTED_LEVEL player
	START_NEW_SCRIPT hood_mission4_loop
	flag_hood_mission3_passed = 1

ELSE
	ADD_SCORE player 20000
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //Mission Passed!"
	PLAY_MISSION_PASSED_TUNE 1
	CLEAR_WANTED_LEVEL player
ENDIF

RETURN
		


// mission cleanup

mission_cleanup_hood3:

flag_player_on_mission = 0
flag_player_on_hood_mission = 0
SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm3 -1
CLEAR_ONSCREEN_TIMER timer_hm3
CLEAR_ONSCREEN_COUNTER car_damage_hm3
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_INFERNUS
REMOVE_BLIP radar_blip_car1_hm3
REMOVE_BLIP radar_blip_coord1_hm3
REMOVE_BLIP radar_blip_coord2_hm3
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_MAFIA THREAT_PLAYER1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_COLOMBIAN THREAT_PLAYER1

IF flag_yardie_mission2_passed = 1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_DIABLO THREAT_PLAYER1
ENDIF

IF flag_yardie_mission4_passed = 1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_YARDIE THREAT_PLAYER1
ENDIF	 

MISSION_HAS_FINISHED
RETURN
		

  
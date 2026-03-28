MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Kenji mission 2********************************* 
// ****************************************Gone In 30 Seconds*******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME kenji2

// Mission start stuff

GOSUB mission_start_kenji2

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_kenji2_failed
	ENDIF

GOSUB mission_cleanup_kenji2

MISSION_END
 
// Variables For Mission

VAR_INT car_to_steal1_km2  //Testarossa

VAR_INT car_to_steal2_km2  //Viper

VAR_INT car_to_steal3_km2  //Boxter

VAR_INT car_to_steal4_km2 //Diablo

VAR_INT car_to_steal5_km2  //Offroad

VAR_INT radar_blip_coord1_km2

VAR_INT radar_blip_car1_km2

VAR_INT radar_blip_car2_km2

VAR_INT radar_blip_car3_km2

VAR_INT radar_blip_car4_km2

VAR_INT radar_blip_car5_km2

VAR_INT timer_km2

VAR_INT flag_player_damage_message_car1_km2 

VAR_INT flag_player_damage_message_car2_km2

VAR_INT flag_player_damage_message_car3_km2

VAR_INT flag_player_damage_message_car4_km2

VAR_INT flag_player_damage_message_car5_km2

VAR_INT flag_car1_in_garage

VAR_INT flag_car2_in_garage

VAR_INT flag_car3_in_garage

VAR_INT flag_car4_in_garage

VAR_INT flag_car5_in_garage

VAR_INT counter_number_of_cars_in_garage_km2

VAR_INT flag_blip_car1_on

VAR_INT flag_blip_car2_on

VAR_INT flag_blip_car3_on

VAR_INT flag_blip_car4_on

VAR_INT flag_blip_car5_on

VAR_INT flag_car1_destroyed

VAR_INT flag_car2_destroyed

VAR_INT flag_car3_destroyed

VAR_INT flag_car4_destroyed

VAR_INT flag_car5_destroyed

VAR_INT flag_garage_no_blip_car1_km2

VAR_INT flag_garage_no_blip_car2_km2

VAR_INT flag_garage_no_blip_car3_km2

VAR_INT flag_garage_no_blip_car4_km2

VAR_INT flag_garage_no_blip_car5_km2

VAR_INT flag_spray_blip_on_car1_km2

VAR_INT flag_spray_blip_on_car2_km2

VAR_INT flag_spray_blip_on_car3_km2

VAR_INT flag_spray_blip_on_car4_km2

VAR_INT flag_spray_blip_on_car5_km2

VAR_INT spray_blip_km2

VAR_INT flag_player_had_garage_car1_message

VAR_INT flag_player_had_garage_car2_message

VAR_INT flag_player_had_garage_car3_message

VAR_INT flag_player_had_garage_car4_message

VAR_INT flag_player_had_garage_car5_message  

// ****************************************Mission Start************************************

mission_start_kenji2:

flag_player_on_mission = 1

flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_damage_message_car1_km2 = 0

flag_player_damage_message_car2_km2 = 0

flag_player_damage_message_car3_km2 = 0

flag_player_damage_message_car4_km2 = 0

flag_player_damage_message_car5_km2 = 0

flag_car1_in_garage = 0

flag_car2_in_garage = 0

flag_car3_in_garage = 0

flag_car4_in_garage = 0

flag_car5_in_garage = 0

counter_number_of_cars_in_garage_km2 = 0

flag_blip_car1_on = 0

flag_blip_car2_on = 0

flag_blip_car3_on = 0

flag_blip_car4_on = 0

flag_blip_car5_on = 0

flag_car1_destroyed = 0

flag_car2_destroyed = 0

flag_car3_destroyed = 0

flag_car4_destroyed = 0

flag_car5_destroyed = 0

flag_garage_no_blip_car1_km2 = 0

flag_garage_no_blip_car2_km2 = 0

flag_garage_no_blip_car3_km2 = 0

flag_garage_no_blip_car4_km2 = 0

flag_garage_no_blip_car5_km2 = 0

flag_spray_blip_on_car1_km2 = 0

flag_spray_blip_on_car2_km2 = 0

flag_spray_blip_on_car3_km2 = 0

flag_spray_blip_on_car4_km2 = 0

flag_spray_blip_on_car5_km2 = 0

//timer_km2 = 601000  //10 mins for Obbe, Les

timer_km2 = 361000  //6 mins

flag_player_had_garage_car1_message = 0

flag_player_had_garage_car2_message = 0

flag_player_had_garage_car3_message = 0

flag_player_had_garage_car4_message = 0

flag_player_had_garage_car5_message = 0

{
// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_kenji2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( KM2 ) 15000 2 //"Gone in Sixty"

SWITCH_STREAMING OFF
*/
 
// Cutscene stuff

LOAD_SPECIAL_CHARACTER 1 KENJI
LOAD_SPECIAL_MODEL cut_obj1 KENJIH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL cut_obj3 MINNOTE
REQUEST_MODEL casino_garden 

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED casino_garden
	 
	WAIT 0

ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE k2_gis

SET_CUTSCENE_OFFSET 476.380 -1382.168 67.347

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_kenji

SET_CUTSCENE_ANIM cs_kenji kenji

//CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_A cs_yakuza

//SET_CUTSCENE_ANIM cs_yakuza gang07

CREATE_CUTSCENE_HEAD cs_kenji CUT_OBJ1 cs_kenjihead

SET_CUTSCENE_HEAD_ANIM cs_kenjihead kenji

CREATE_CUTSCENE_OBJECT cut_obj3 cs_note

SET_CUTSCENE_ANIM cs_note MINNOTE

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

WHILE cs_time < 3902
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_A ) 10000 1 //"It is impossible to over-estimate the importance of etiquette in this line of work."

WHILE cs_time < 8570
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_B ) 10000 1 //"To my eternal shame, a man once did me a favor and I have never had the opportunity to repay his kindness."

WHILE cs_time < 15119
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_C ) 10000 1 //"The man's weakness is motor cars and he has requested that we acquire him certain models for his collection."

WHILE cs_time < 21459
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_D ) 10000 1 //"Needless to say, we must give him the cars as a gift, to repay the debt that is owed to him."

WHILE cs_time < 27033
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_E ) 10000 1 //"You must obtain the cars on the list and deliver them to a garage behind the car park in Newport. My honor demands it.

WHILE cs_time < 33164
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM2_F ) 10000 1 //"My honor demands it."

WHILE cs_time < 34918
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( KM2_F )

WHILE cs_time < 39333
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
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED casino_garden

// **************************************END OF CUSTSCENE***********************************

REQUEST_MODEL CAR_CHEETAH //car1 to steal 

REQUEST_MODEL CAR_STINGER  // car3 to steal

REQUEST_MODEL CAR_INFERNUS  // car4 to steal

//REQUEST_MODEL CAR_BANSHEE // car2 to steal

//REQUEST_MODEL CAR_LANDSTALKER  // car5 to steal

WHILE NOT HAS_MODEL_LOADED CAR_CHEETAH
OR NOT HAS_MODEL_LOADED CAR_STINGER
OR NOT HAS_MODEL_LOADED CAR_INFERNUS
//OR NOT HAS_MODEL_LOADED CAR_LANDSTALKER
//OR NOT HAS_MODEL_LOADED CAR_BANSHEE

	WAIT 0

ENDWHILE

PRINT_NOW ( KM2_3 ) 5000 1 //"~g~Remember the ~r~cars~g~ have to be in mint condition to be accepted by the ~p~garage~g~."

ADD_BLIP_FOR_COORD 375.0 -506.9 -100.0 radar_blip_coord1_km2

// creates car1 the testarossa

CREATE_CAR CAR_CHEETAH 348.3 -0.5 -100.0 car_to_steal1_km2

SET_CAR_HEADING car_to_steal1_km2 270.0

CHANGE_CAR_COLOUR car_to_steal1_km2 CARCOLOUR_RED4 CARCOLOUR_RED4

SET_CAN_RESPRAY_CAR car_to_steal1_km2 FALSE

ADD_BLIP_FOR_CAR car_to_steal1_km2 radar_blip_car1_km2

flag_blip_car1_on = 1

/*

// creates car2 the viper

CREATE_CAR CAR_BANSHEE 211.2 -312.4 15.5 car_to_steal2_km2

CHANGE_CAR_COLOUR car_to_steal2_km2 CARCOLOUR_RED4 CARCOLOUR_RED4

SET_CAN_RESPRAY_CAR car_to_steal2_km2 FALSE

ADD_BLIP_FOR_CAR car_to_steal2_km2 radar_blip_car2_km2

SET_CAR_HEADING car_to_steal2_km2 90.0 

flag_blip_car2_on = 1
*/

// creates car3 the boxster

CREATE_CAR CAR_STINGER -71.1 -1467.4 25.1 car_to_steal3_km2

CHANGE_CAR_COLOUR car_to_steal3_km2 CARCOLOUR_RED4 CARCOLOUR_RED4

SET_CAN_RESPRAY_CAR car_to_steal3_km2 FALSE

ADD_BLIP_FOR_CAR car_to_steal3_km2 radar_blip_car3_km2

SET_CAR_HEADING car_to_steal3_km2 270.0 

flag_blip_car3_on = 1

// creates car4 the Diablo

CREATE_CAR CAR_INFERNUS -61.7 -358.4 15.2 car_to_steal4_km2

CHANGE_CAR_COLOUR car_to_steal4_km2 CARCOLOUR_RED4 CARCOLOUR_RED4

SET_CAN_RESPRAY_CAR car_to_steal4_km2 FALSE

ADD_BLIP_FOR_CAR car_to_steal4_km2 radar_blip_car4_km2

SET_CAR_HEADING car_to_steal4_km2 90.0 

flag_blip_car4_on = 1


/*
// creates car5 the 4X4

CREATE_CAR CAR_LANDSTALKER 200.7 -1006.2 25.1 car_to_steal5_km2

CHANGE_CAR_COLOUR car_to_steal5_km2 CARCOLOUR_RED4 CARCOLOUR_RED4

SET_CAN_RESPRAY_CAR car_to_steal5_km2 FALSE

ADD_BLIP_FOR_CAR car_to_steal5_km2 radar_blip_car5_km2

SET_CAR_HEADING car_to_steal5_km2 90.0 

flag_blip_car5_on = 1

*/

DISPLAY_ONSCREEN_TIMER timer_km2

// waiting for all 5 vehicles to be in the range

WHILE timer_km2 > 0

	WAIT 0
	
 	IF counter_number_of_cars_in_garage_km2 = 3
		GOTO mission_kenji2_passed
	ENDIF
   
// if player in car checks for car damage and blip stuff

// checks for car 1

IF flag_car1_in_garage = 0

	IF IS_CAR_IN_MISSION_GARAGE garage_km2 // Testarossa
	AND flag_garage_no_blip_car1_km2 = 1
		flag_car1_destroyed = 1
		++ counter_number_of_cars_in_garage_km2
		ADD_ONE_OFF_SOUND 380.3 -506.8 26.1 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( KM2_2 ) 5000 1 //"Car delivered"
		IF NOT IS_CAR_DEAD car_to_steal1_km2
			DELETE_CAR car_to_steal1_km2
		ENDIF
		flag_car1_in_garage = 1
	ENDIF


	IF flag_car1_destroyed = 0
				
		IF IS_CAR_DEAD car_to_steal1_km2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			flag_car1_destroyed = 1
			GOTO mission_kenji2_failed
		ELSE
		
			IF IS_CAR_UPSIDEDOWN car_to_steal1_km2
			AND IS_CAR_STOPPED car_to_steal1_km2
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_kenji2_failed
			ENDIF
			
		ENDIF 										  
					
		IF IS_CAR_STOPPED_IN_AREA_3D car_to_steal1_km2 377.3 -511.4 25.1132 383.7 -502.0 30.0 FALSE

			IF NOT IS_CAR_VISIBLY_DAMAGED car_to_steal1_km2
				flag_garage_no_blip_car1_km2 = 1
			ENDIF

			IF DOES_GARAGE_CONTAIN_CAR garage_km2 car_to_steal1_km2

				IF flag_player_had_garage_car1_message = 0
					PRINT_NOW ( GARAGE1 ) 5000 1 //"Get out of the vehicle and walk outside!" 
					flag_player_had_garage_car1_message = 1
				ENDIF

			ELSE
				flag_player_had_garage_car1_message = 0
			ENDIF

		ELSE
			flag_garage_no_blip_car1_km2 = 0
		ENDIF
								
		IF IS_PLAYER_IN_CAR player car_to_steal1_km2
						
			IF flag_blip_car1_on = 1
				REMOVE_BLIP radar_blip_car1_km2
				flag_blip_car1_on = 0
			ENDIF

				IF IS_CAR_VISIBLY_DAMAGED car_to_steal1_km2 

					IF flag_player_damage_message_car1_km2 = 0
						PRINT_NOW ( KM2_1 ) 7000 1 //"Get the car reapaired the boss wants it mint!"
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_player_damage_message_car1_km2 = 1
					ENDIF

					IF flag_spray_blip_on_car1_km2 = 0
						ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km2
						flag_spray_blip_on_car1_km2 = 1
					ENDIF
										
				ELSE
										
					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 car_to_steal1_km2

					flag_player_damage_message_car1_km2 = 0

					IF flag_spray_blip_on_car1_km2 = 1
						REMOVE_BLIP spray_blip_km2
						flag_spray_blip_on_car1_km2 = 0
					ENDIF
									   				   
				ENDIF
		ELSE

			flag_player_damage_message_car1_km2 = 0
						
			IF flag_spray_blip_on_car1_km2 = 1
				REMOVE_BLIP spray_blip_km2
				flag_spray_blip_on_car1_km2 = 0
			ENDIF
									
			IF flag_blip_car1_on = 0

				IF flag_garage_no_blip_car1_km2 = 0
					ADD_BLIP_FOR_CAR car_to_steal1_km2 radar_blip_car1_km2
					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
					flag_blip_car1_on = 1
				ENDIF

			ENDIF
				
		ENDIF
	
	ENDIF

ENDIF


/*

// checks for car 2

IF flag_car2_in_garage = 0

	IF IS_CAR_IN_MISSION_GARAGE garage_km2 // Viper
	AND flag_garage_no_blip_car2_km2 = 1
		flag_car2_destroyed = 1
		++ counter_number_of_cars_in_garage_km2
		ADD_ONE_OFF_SOUND 380.3 -506.8 26.1 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( KM2_2 ) 5000 1 //"Car delivered"
		flag_car2_in_garage = 1
	ENDIF

	IF flag_car2_destroyed = 0

		IF IS_CAR_DEAD car_to_steal2_km2
			 PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			flag_car2_destroyed = 1
			GOTO mission_kenji2_failed
		ELSE

			IF IS_CAR_UPSIDEDOWN car_to_steal2_km2
			AND IS_CAR_STOPPED car_to_steal2_km2 
				 PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_kenji2_failed
			ENDIF

		ENDIF

		IF IS_CAR_STOPPED_IN_AREA_3D car_to_steal2_km2 377.3 -511.4 25.1132 383.7 -502.0 30.0 FALSE

			IF NOT IS_CAR_VISIBLY_DAMAGED car_to_steal2_km2 
				flag_garage_no_blip_car2_km2 = 1
			ENDIF

			IF DOES_GARAGE_CONTAIN_CAR garage_km2 car_to_steal2_km2

				IF flag_player_had_garage_car2_message = 0
					PRINT_NOW ( GARAGE1 ) 5000 1 //"Get out of the vehicle and walk outside!" 
					flag_player_had_garage_car2_message = 1
				ENDIF

			ELSE
				flag_player_had_garage_car2_message = 0
			ENDIF

		ELSE
			flag_garage_no_blip_car2_km2 = 0
		ENDIF

						
		IF IS_PLAYER_IN_CAR player car_to_steal2_km2
			
			IF flag_blip_car2_on = 1
				REMOVE_BLIP radar_blip_car2_km2
				flag_blip_car2_on = 0
			ENDIF

				IF IS_CAR_VISIBLY_DAMAGED car_to_steal2_km2 
										
					IF flag_player_damage_message_car2_km2 = 0
						PRINT_NOW ( KM2_1 ) 7000 1 //"Get the car reapaired the boss wants it mint!"
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_player_damage_message_car2_km2 = 1
					ENDIF

					IF flag_spray_blip_on_car2_km2 = 0
						ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km2
						flag_spray_blip_on_car2_km2 = 1
					ENDIF
				   				   					
				ELSE

					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 car_to_steal2_km2
					flag_player_damage_message_car2_km2 = 0

					IF flag_spray_blip_on_car2_km2 = 1
						REMOVE_BLIP spray_blip_km2
						flag_spray_blip_on_car2_km2 = 0
					ENDIF
								
				ENDIF
   		ELSE
			flag_player_damage_message_car2_km2 = 0

			IF flag_spray_blip_on_car2_km2 = 1
				REMOVE_BLIP spray_blip_km2
				flag_spray_blip_on_car2_km2 = 0
			ENDIF

			IF flag_blip_car2_on = 0

				IF flag_garage_no_blip_car2_km2 = 0
					ADD_BLIP_FOR_CAR car_to_steal2_km2 radar_blip_car2_km2
					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
					flag_blip_car2_on = 1
				ENDIF
				
			ENDIF

		ENDIF

	ENDIF
	
ENDIF

*/


// checks for car 3

IF flag_car3_in_garage = 0

	IF IS_CAR_IN_MISSION_GARAGE garage_km2 // Boxter
	AND flag_garage_no_blip_car3_km2 = 1
		flag_car3_destroyed = 1
		++ counter_number_of_cars_in_garage_km2
		ADD_ONE_OFF_SOUND 380.3 -506.8 26.1 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( KM2_2 ) 5000 1 //"Car delivered"
		IF NOT IS_CAR_DEAD car_to_steal3_km2
			DELETE_CAR car_to_steal3_km2
		ENDIF
		flag_car3_in_garage = 1
	ENDIF

	IF flag_car3_destroyed = 0

		IF IS_CAR_DEAD car_to_steal3_km2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			flag_car3_destroyed = 1
			GOTO mission_kenji2_failed
		ELSE

			IF IS_CAR_UPSIDEDOWN car_to_steal3_km2
			AND IS_CAR_STOPPED car_to_steal3_km2
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_kenji2_failed
			ENDIF

		ENDIF

		IF IS_CAR_STOPPED_IN_AREA_3D car_to_steal3_km2 377.3 -511.4 25.1132 383.7 -502.0 30.0 FALSE

			IF NOT IS_CAR_VISIBLY_DAMAGED car_to_steal3_km2
				flag_garage_no_blip_car3_km2 = 1
			ENDIF

			IF DOES_GARAGE_CONTAIN_CAR garage_km2 car_to_steal3_km2
			
				IF flag_player_had_garage_car3_message = 0
					PRINT_NOW ( GARAGE1 ) 5000 1 //"Get out of the vehicle and walk outside!" 
					flag_player_had_garage_car3_message = 1
				ENDIF

			ELSE
				flag_player_had_garage_car3_message = 0
			ENDIF

		ELSE
			flag_garage_no_blip_car3_km2 = 0
		ENDIF

						
			IF IS_PLAYER_IN_CAR player car_to_steal3_km2
								
				IF flag_blip_car3_on = 1
					REMOVE_BLIP radar_blip_car3_km2
					flag_blip_car3_on = 0
				ENDIF
					  
					IF IS_CAR_VISIBLY_DAMAGED car_to_steal3_km2 
					
						IF flag_player_damage_message_car3_km2 = 0
							PRINT_NOW ( KM2_1 ) 7000 1 //"Get the car reapaired the boss wants it mint!"
							SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
							flag_player_damage_message_car3_km2 = 1
						ENDIF
						
						IF flag_spray_blip_on_car3_km2 = 0
							ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km2
							flag_spray_blip_on_car3_km2 = 1
						ENDIF	

					ELSE
					   
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 car_to_steal3_km2
						flag_player_damage_message_car3_km2 = 0

						IF flag_spray_blip_on_car3_km2 = 1
							REMOVE_BLIP spray_blip_km2
							flag_spray_blip_on_car3_km2 = 0
						ENDIF

					ENDIF
			ELSE
				flag_player_damage_message_car3_km2 = 0

				IF flag_spray_blip_on_car3_km2 = 1
					REMOVE_BLIP spray_blip_km2
					flag_spray_blip_on_car3_km2 = 0
				ENDIF

				IF flag_blip_car3_on = 0

					IF flag_garage_no_blip_car3_km2 = 0
						ADD_BLIP_FOR_CAR car_to_steal3_km2 radar_blip_car3_km2
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_blip_car3_on = 1
					ENDIF

				ENDIF

			ENDIF

	ENDIF
		
ENDIF


// checks for car 4

IF flag_car4_in_garage = 0

	IF IS_CAR_IN_MISSION_GARAGE garage_km2 // Diablo
	AND flag_garage_no_blip_car4_km2 = 1
		flag_car4_destroyed = 1
		++ counter_number_of_cars_in_garage_km2
		ADD_ONE_OFF_SOUND 380.3 -506.8 26.1 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( KM2_2 ) 5000 1 //"Car delivered"
		IF NOT IS_CAR_DEAD car_to_steal4_km2
			DELETE_CAR car_to_steal4_km2
		ENDIF
		flag_car4_in_garage = 1
	ENDIF

	IF flag_car4_destroyed = 0

		IF IS_CAR_DEAD car_to_steal4_km2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			flag_car4_destroyed = 1
			GOTO mission_kenji2_failed
		ELSE

			IF IS_CAR_UPSIDEDOWN car_to_steal4_km2
			AND IS_CAR_STOPPED car_to_steal4_km2
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_kenji2_failed
			ENDIF

		ENDIF

		IF IS_CAR_STOPPED_IN_AREA_3D car_to_steal4_km2 377.3 -511.4 25.1132 383.7 -502.0 30.0 FALSE

			IF NOT IS_CAR_VISIBLY_DAMAGED car_to_steal4_km2
				flag_garage_no_blip_car4_km2 = 1
			ENDIF

			IF DOES_GARAGE_CONTAIN_CAR garage_km2 car_to_steal4_km2

				IF flag_player_had_garage_car4_message = 0
					PRINT_NOW ( GARAGE1 ) 5000 1 //"Get out of the vehicle and walk outside!" 
					flag_player_had_garage_car4_message = 1
				ENDIF

			ELSE
				flag_player_had_garage_car4_message = 0
			ENDIF

		ELSE
			flag_garage_no_blip_car4_km2 = 0
		ENDIF
						
			IF IS_PLAYER_IN_CAR player car_to_steal4_km2
								
				IF flag_blip_car4_on = 1
					REMOVE_BLIP radar_blip_car4_km2
					flag_blip_car4_on = 0
				ENDIF
				  
				IF IS_CAR_VISIBLY_DAMAGED car_to_steal4_km2

					IF flag_player_damage_message_car4_km2 = 0
						PRINT_NOW ( KM2_1 ) 7000 1 //"Get the car reapaired the boss wants it mint!"
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_player_damage_message_car4_km2 = 1
					ENDIF

					IF flag_spray_blip_on_car4_km2 = 0
						ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km2
						flag_spray_blip_on_car4_km2 = 1
					ENDIF
																			   
				ELSE

					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 car_to_steal4_km2
					flag_player_damage_message_car4_km2 = 0

					IF flag_spray_blip_on_car4_km2 = 1
						REMOVE_BLIP spray_blip_km2
						flag_spray_blip_on_car4_km2 = 0
					ENDIF
					
				ENDIF
			ELSE
				flag_player_damage_message_car4_km2 = 0

				IF flag_spray_blip_on_car4_km2 = 1
					REMOVE_BLIP spray_blip_km2
					flag_spray_blip_on_car4_km2 = 0
				ENDIF

				IF flag_blip_car4_on = 0

					IF flag_garage_no_blip_car4_km2 = 0
						ADD_BLIP_FOR_CAR car_to_steal4_km2 radar_blip_car4_km2
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_blip_car4_on = 1
					ENDIF		
				ENDIF
			ENDIF
	ENDIF

ENDIF

/*

// checks for car 5

IF flag_car5_in_garage = 0

	IF IS_CAR_IN_MISSION_GARAGE garage_km2 // Offroad
	AND flag_garage_no_blip_car5_km2 = 1
		flag_car5_destroyed = 1
		++ counter_number_of_cars_in_garage_km2
		ADD_ONE_OFF_SOUND 380.3 -506.8 26.1 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( KM2_2 ) 5000 1 //"Car delivered"
		flag_car5_in_garage = 1
	ENDIF


	IF flag_car5_destroyed = 0

		IF IS_CAR_DEAD car_to_steal5_km2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			flag_car5_destroyed = 1
			GOTO mission_kenji2_failed
		ELSE

			IF IS_CAR_UPSIDEDOWN car_to_steal5_km2
			AND IS_CAR_STOPPED car_to_steal5_km2
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_kenji2_failed
			ENDIF

		ENDIF

		IF IS_CAR_STOPPED_IN_AREA_3D car_to_steal5_km2 377.3 -511.4 25.1132 383.7 -502.0 30.0 FALSE
			
			IF NOT IS_CAR_VISIBLY_DAMAGED car_to_steal5_km2
				flag_garage_no_blip_car5_km2 = 1
			ENDIF

			IF DOES_GARAGE_CONTAIN_CAR garage_km2 car_to_steal5_km2
			
				IF flag_player_had_garage_car5_message = 0
					PRINT_NOW ( GARAGE1 ) 5000 1 //"Get out of the vehicle and walk outside!" 
					flag_player_had_garage_car5_message = 1
				ENDIF

			ELSE
				flag_player_had_garage_car5_message = 0
			ENDIF

		ELSE
			flag_garage_no_blip_car5_km2 = 0
		ENDIF

						
			IF IS_PLAYER_IN_CAR player car_to_steal5_km2
								
				IF flag_blip_car5_on = 1
					REMOVE_BLIP radar_blip_car5_km2
					flag_blip_car5_on = 0
				ENDIF
			   	 
				IF IS_CAR_VISIBLY_DAMAGED car_to_steal5_km2
					
					IF flag_player_damage_message_car5_km2 = 0
						PRINT_NOW ( KM2_1 ) 7000 1 //"Get the car reapaired the boss wants it mint!"
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_player_damage_message_car5_km2 = 1
					ENDIF

					IF flag_spray_blip_on_car5_km2 = 0
						ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km2
						flag_spray_blip_on_car5_km2 = 1
					ENDIF
																				
				ELSE

					SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 car_to_steal5_km2
					flag_player_damage_message_car5_km2 = 0
					
					IF flag_spray_blip_on_car5_km2 = 1
						REMOVE_BLIP spray_blip_km2
						flag_spray_blip_on_car5_km2 = 0
					ENDIF

				ENDIF
			ELSE
				flag_player_damage_message_car5_km2 = 0

				IF flag_spray_blip_on_car5_km2 = 1
					REMOVE_BLIP spray_blip_km2
					flag_spray_blip_on_car5_km2 = 0
				ENDIF

				IF flag_blip_car5_on = 0

					IF flag_garage_no_blip_car5_km2 = 0
						ADD_BLIP_FOR_CAR car_to_steal5_km2 radar_blip_car5_km2
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
						flag_blip_car5_on = 1
					ENDIF
									
				ENDIF
			 
		  	ENDIF
	ENDIF
	
ENDIF

*/
		
ENDWHILE
	
PRINT_NOW ( OUTTIME ) 5000 1 //"Out of time!"
GOTO mission_kenji2_failed
	   		


// Mission Kenji5 failed

mission_kenji2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

   

// mission Kenji5 passed

mission_kenji2_passed:

flag_kenji_mission2_passed = 1
REGISTER_MISSION_PASSED ( KM2 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 25000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 25000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT kenji_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_kenji2:

flag_player_on_mission = 0
flag_player_on_kenji_mission = 0
SET_TARGET_CAR_FOR_MISSION_GARAGE garage_km2 -1
CLEAR_ONSCREEN_TIMER timer_km2
REMOVE_BLIP radar_blip_coord1_km2
REMOVE_BLIP radar_blip_car1_km2
//REMOVE_BLIP radar_blip_car2_km2
REMOVE_BLIP radar_blip_car3_km2
REMOVE_BLIP radar_blip_car4_km2
//REMOVE_BLIP radar_blip_car5_km2
REMOVE_BLIP spray_blip_km2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
//MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BANSHEE
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STINGER
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_INFERNUS
//MARK_MODEL_AS_NO_LONGER_NEEDED CAR_LANDSTALKER
MISSION_HAS_FINISHED
RETURN
	
}
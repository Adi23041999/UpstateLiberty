MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************Frankie Mission 2*************************************
// **********************************"Cuttin' The Grass"************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME frank2

// Mission start stuff

GOSUB mission_start_frankie2

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_frankie2_failed
	ENDIF
			
GOSUB mission_cleanup_frankie2

MISSION_END


// Variables for mission

VAR_INT curley_bob_fm2

VAR_INT hours_fm2

VAR_INT minutes_fm2

VAR_INT hours_stuff_happen_fm2

VAR_INT mission_taxi_fm2

VAR_INT radar_blip_coord2_fm2

VAR_INT radar_blip_coord3_fm2

VAR_INT car_fm2

VAR_INT van_driver_fm2

VAR_INT radar_blip_coord1_fm2

VAR_INT radar_blip_ped1_fm2

VAR_INT radar_blip_car1_fm2

VAR_INT columbian_fm2

VAR_INT radar_blip_ped2_fm2

VAR_INT flag_player_too_far_message_fm2

VAR_INT minutes_stuff_happen_fm2

VAR_INT flag_player_got_car_message_fm2

VAR_INT flag_player_got_cops_message_fm2

VAR_INT time_car_stopped_fm2

VAR_INT current_time_fm2

VAR_INT flag_car_has_just_stopped

VAR_INT timer_difference

VAR_INT flag_taxi1_exit_car_fm2

VAR_INT flag_taxi2_exit_car_fm2

VAR_INT flag_car_fm2_created

VAR_INT flag_mission_taxi_fm2_created

VAR_INT flag_no_longer_mad

VAR_INT flag_curley_at_point1_fm2

VAR_INT flag_curley_at_point2_fm2

VAR_INT flag_curley_bob_fm2_dead

VAR_INT flag_bob_in_position_one

VAR_INT flag_bob_in_position_two

VAR_INT flag_bob_in_position_three

VAR_INT baddie_car_fm2

VAR_INT radar_blip_car2_fm2

VAR_INT flag_curley_bob_dead_fm2

VAR_INT car_health_fm2

VAR_INT flag_car_fm2_dead

VAR_FLOAT car_fm2_x

VAR_FLOAT car_fm2_y

VAR_FLOAT car_fm2_z

VAR_INT radar_blip_club_fm2

VAR_INT flag_curly_mad_fm2

VAR_INT spooked_counter

VAR_INT spooked_check

VAR_INT flag_player_had_warning1_fm2

VAR_INT flag_player_had_warning2_fm2

VAR_INT flag_curly_moved_fm2  // Moves curly if he gets stuck


// ****************************************Start Mission************************************
 
mission_start_frankie2:

flag_player_on_mission = 1

flag_player_on_frankie_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

hours_fm2 = 0

minutes_fm2 = 0

hours_stuff_happen_fm2 = 0

minutes_stuff_happen_fm2 = 0

flag_player_got_car_message_fm2 = 0

flag_player_got_cops_message_fm2 = 0

time_car_stopped_fm2 = 0

flag_car_has_just_stopped = 0

timer_difference = 0

flag_taxi1_exit_car_fm2 = 0

flag_taxi2_exit_car_fm2 = 0

flag_car_fm2_created = 0

flag_mission_taxi_fm2_created = 0

flag_no_longer_mad = 0

flag_curley_at_point1_fm2 = 0

flag_curley_at_point2_fm2 = 0

flag_curley_bob_fm2_dead = 0

flag_bob_in_position_one = 0

flag_bob_in_position_two = 0

flag_bob_in_position_three = 0

flag_curley_bob_dead_fm2 = 0

car_health_fm2 = 0

blob_flag = 1

flag_car_fm2_dead = 0

car_fm2_x = 0.0

car_fm2_y = 0.0

car_fm2_z = 0.0

flag_curly_mad_fm2 = 0

spooked_counter = 0

spooked_check = 0

flag_player_had_warning1_fm2 = 0

flag_player_had_warning2_fm2 = 0

flag_curly_moved_fm2 = 0 //moves curly if he gets stuck

{


// ******************************************START OF CUTSCENE******************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_frankie2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( FM2 ) 15000 2 //"Cuttin' The Grass"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 FRANKIE
REQUEST_MODEL PED_GANG_MAFIA_B
LOAD_SPECIAL_MODEL cut_obj1 FRANKH
//LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
REQUEST_MODEL franksclb02
REQUEST_MODEL salvsdetail
REQUEST_MODEL swank_inside

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
OR NOT HAS_MODEL_LOADED cut_obj1
//OR NOT HAS_MODEL_LOADED cut_obj2

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED franksclb02
OR NOT HAS_MODEL_LOADED	salvsdetail
OR NOT HAS_MODEL_LOADED swank_inside

	WAIT 0

ENDWHILE

LOAD_CUTSCENE s2_ctg

SET_CUTSCENE_OFFSET 1457.776 -185.348 54.925

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_frankie

SET_CUTSCENE_ANIM cs_frankie frankie

CREATE_CUTSCENE_HEAD cs_frankie CUT_OBJ1 cs_frankiehead

SET_CUTSCENE_HEAD_ANIM cs_frankiehead frank

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT PED_GANG_MAFIA_B cs_mafia

SET_CUTSCENE_ANIM cs_mafia gang02

CLEAR_AREA 1455.1 -187.8 -100.0 1.0 TRUE 

SET_PLAYER_COORDINATES player 1455.1 -187.8 -100.0 

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1726
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_J ) 10000 1 //"Leave us alone for a minute,"

WHILE cs_time < 2910
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM2_J )

WHILE cs_time < 4558
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_A ) 10000 1 //"The Colombian Cartel is making SPANK somewhere in Liberty.

WHILE cs_time < 7896
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_K ) 10000 1 //"But we don't know where, and they seem to know everything we're doin' before we do."

WHILE cs_time < 13257
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_B ) 10000 1 //"We got us a rat."

WHILE cs_time < 15103
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_L ) 10000 1 //"There is a guy named Curly Bob works the bar at Luigi's.

WHILE cs_time < 18415
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_M ) 10000 1 //"He's been throwing more money around than he's earning."

WHILE cs_time < 21238
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_C ) 10000 1 //"He ain't pimping or pushing so he must be talking."

WHILE cs_time < 25040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_N ) 10000 1 //"He usually gets a taxi home after work. So follow him."

WHILE cs_time < 28251
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_O ) 10000 1 //"And if he's rattin' us out...kill him."

WHILE cs_time < 30960
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM2_O )

WHILE cs_time < 38333
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

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

MARK_MODEL_AS_NO_LONGER_NEEDED franksclb02

MARK_MODEL_AS_NO_LONGER_NEEDED salvsdetail

MARK_MODEL_AS_NO_LONGER_NEEDED swank_inside

// *******************************************END OF CUTSCENE*******************************

LOAD_SPECIAL_CHARACTER 2 curly

REQUEST_MODEL CAR_TAXI
REQUEST_MODEL PED_TAXI_DRIVER 

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CAR_TAXI
OR NOT HAS_MODEL_LOADED PED_TAXI_DRIVER

	WAIT 0
	
ENDWHILE

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

SETUP_ZONE_PED_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0
SETUP_ZONE_PED_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

// CREATES THE TAXI FOR THE BLOKE TO GET INTO

PRINT_NOW ( FM2_11 ) 5000 1 //"Park out the front of Luigi's Club, Curly Bob will be leaving shortly."

ADD_BLIP_FOR_COORD 907.0 -424.7 13.8 radar_blip_club_fm2

CREATE_CAR CAR_TAXI 906.9 -433.7 -100.0 car_fm2

SET_CAR_ONLY_DAMAGED_BY_PLAYER car_fm2 TRUE

flag_car_fm2_created = 1

SET_CAR_HEADING car_fm2 180.0

CHANGE_CAR_LOCK car_fm2 CARLOCK_LOCKOUT_PLAYER_ONLY
		
CREATE_CHAR_INSIDE_CAR car_fm2 PEDTYPE_CIVMALE PED_TAXI_DRIVER van_driver_fm2

SET_CHAR_CANT_BE_DRAGGED_OUT van_driver_fm2 TRUE

CLEAR_CHAR_THREAT_SEARCH van_driver_fm2 

CAR_SET_IDLE car_fm2

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA

SET_PLAYER_CONTROL player on

SET_POLICE_IGNORE_PLAYER player off


timerb = 0


//GET_TIME_OF_DAY hours_fm2 minutes_fm2

//minutes_stuff_happen_fm2 = minutes_fm2 - 1

//IF minutes_stuff_happen_fm2 <= 0

//	minutes_stuff_happen_fm2 += 60

//ENDIF

// waiting for the time of day to be correct

//WHILE NOT minutes_fm2 = minutes_stuff_happen_fm2

//	WAIT 0 

//GET_TIME_OF_DAY hours_fm2 minutes_fm2
         		
//ENDWHILE


WHILE timerb < 60000

	WAIT 0

ENDWHILE

// checks to see where curly will be created

IF IS_PLAYER_IN_AREA_3D player 901.2 -427.8 12.0 878.1 -422.4 27.0 FALSE
OR IS_PLAYER_IN_AREA_3D player 878.1 -422.4 12.0 900.4 -404.2 27.0 FALSE 

	// creates curley bob infront of the club
	
	CLEAR_AREA 902.9 -398.8 14.0 1.0 TRUE    

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 902.9 -398.8 14.0 curley_bob_fm2

	ADD_BLIP_FOR_CHAR curley_bob_fm2 radar_blip_ped1_fm2

	CHANGE_BLIP_DISPLAY radar_blip_ped1_fm2 MARKER_ONLY 

	CLEAR_CHAR_THREAT_SEARCH curley_bob_fm2

	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT curley_bob_fm2 902.7 -430.4

	timerb = 0

	WHILE NOT LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 902.7 -430.4 1.0 1.0 FALSE

		WAIT 0
						
		IF IS_CHAR_DEAD curley_bob_fm2
			PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
			GOTO mission_frankie2_failed
		ELSE

			IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF

		ENDIF

		IF flag_curly_moved_fm2 = 0

			IF timerb >= 15000

				IF NOT LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 902.7 -430.4 1.0 1.0 FALSE
					SET_CHAR_COORDINATES curley_bob_fm2 902.7 -430.4 13.7
					flag_curly_moved_fm2 = 1
				ENDIF
				
			ENDIF
		
		ENDIF 
						
	ENDWHILE

	CHAR_SET_IDLE curley_bob_fm2
	
	GOTO mission_check 

ELSE
	
	// creates curley bob down the alleyway
	
	CLEAR_AREA 886.3 -422.2 13.8 1.0 TRUE    

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 886.3 -422.2 13.8 curley_bob_fm2

	ADD_BLIP_FOR_CHAR curley_bob_fm2 radar_blip_ped1_fm2

	CHANGE_BLIP_DISPLAY radar_blip_ped1_fm2 MARKER_ONLY

	CLEAR_CHAR_THREAT_SEARCH curley_bob_fm2

	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT curley_bob_fm2 888.0 -425.0
	
	CLEAR_AREA 887.4 -417.3 13.9 10.0 FALSE  // This should get rid of anything is his way

	CLEAR_AREA 892.8 -425.5 13.9 3.0 FALSE

	CLEAR_AREA 896.3 -425.6 13.8 3.0 FALSE

	CLEAR_AREA 899.1 -424.6 14.0 3.0 FALSE

	CLEAR_AREA 903.4 -425.6 13.9 2.0 FALSE
	
	//waiting for curly bob to get to the pavement

	timerb = 0

	WHILE NOT LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 904.0 -427.3 1.0 1.0 FALSE

		WAIT 0
						
		IF IS_CHAR_DEAD curley_bob_fm2
			PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
			GOTO mission_frankie2_failed
		ELSE

			IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF

		ENDIF
	   	   		
		IF LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 888.0 -425.0 1.0 1.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD curley_bob_fm2 892.1 -425.3
		ENDIF

   
		IF LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 892.1 -425.3 1.0 1.0 FALSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT curley_bob_fm2 904.0 -427.3
		ENDIF

		IF flag_curly_moved_fm2 = 0

			IF timerb >= 25000

				IF NOT LOCATE_CHAR_ON_FOOT_2D curley_bob_fm2 904.0 -427.3 1.0 1.0 FALSE 
					SET_CHAR_COORDINATES curley_bob_fm2 904.0 -427.3 13.9
					flag_curly_moved_fm2 = 1
				ENDIF

			ENDIF
		
		ENDIF 

	ENDWHILE

	CHAR_SET_IDLE curley_bob_fm2

ENDIF

mission_check:

REMOVE_BLIP radar_blip_club_fm2

// Checks to see which part of the mission the player will get

IF NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_2D player 905.0 -432.0 910.0 -419.0 FALSE
	GOTO mission_jump3
ENDIF

// Checks to see if the player is in the area in a taxi

IF IS_PLAYER_IN_MODEL player car_taxi
OR IS_PLAYER_IN_MODEL player car_cabbie
OR IS_PLAYER_IN_MODEL player car_borgnine
	STORE_CAR_PLAYER_IS_IN player mission_taxi_fm2
	flag_mission_taxi_fm2_created = 1
ELSE
	GOTO mission_jump3
ENDIF

// *********************If player is in a taxi luanches part one of the mission************* 

IF LOCATE_STOPPED_PLAYER_IN_CAR_2D player 906.0 -425.0 4.0 4.0 FALSE
AND IS_PLAYER_IN_CAR player mission_taxi_fm2
     			
	IF IS_CHAR_DEAD curley_bob_fm2
		PRINT_NOW ( FM2_9 ) 5000 1 //Curly Bob's dead!"
		GOTO mission_frankie2_failed
	ENDIF

	IF IS_PLAYER_IN_MODEL player car_taxi
	OR IS_PLAYER_IN_MODEL player car_cabbie
		STORE_CAR_PLAYER_IS_IN player mission_taxi_fm2
	ENDIF

// Checks to see if the taxi is damaged or not

	IF IS_CAR_DEAD mission_taxi_fm2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
		GOTO mission_frankie2_failed
	ELSE

		IF IS_CAR_UPSIDEDOWN mission_taxi_fm2
		AND IS_CAR_STOPPED mission_taxi_fm2 
			PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
			GOTO mission_frankie2_failed
		ENDIF

	ENDIF

	IF NOT IS_CAR_HEALTH_GREATER mission_taxi_fm2 700
		PRINT_NOW ( FM2_6 ) 5000 1 //"Get out of here! I'm not taking a ride in this shit-heap!"
		GOTO mission_frankie2_failed
	ENDIF
		 			
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER curley_bob_fm2 mission_taxi_fm2
	
		WHILE NOT IS_CHAR_IN_CAR curley_bob_fm2 mission_taxi_fm2

			WAIT 0

			IF IS_CAR_DEAD mission_taxi_fm2
				PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
				GOTO mission_frankie2_failed
			ELSE

				IF IS_CAR_UPSIDEDOWN mission_taxi_fm2
				AND IS_CAR_STOPPED mission_taxi_fm2 
					PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF

			IF IS_CHAR_DEAD curley_bob_fm2
				PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
				GOTO mission_frankie2_failed
			ELSE

				IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
					PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF
				
			IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player curley_bob_fm2 5.0 5.0 FALSE
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF
		   		   		   									
		ENDWHILE

		REMOVE_BLIP radar_blip_ped1_fm2

	 	PRINT_NOW ( FM2_5 ) 7000 1 //"Take me to the Portland Harbour East docks."

		ADD_BLIP_FOR_COORD 1529.0 -827.0 -100.0 radar_blip_coord2_fm2
	
	blob_flag = 1

	WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_2D player 1529.0 -827.0 3.0 4.0 blob_flag
	OR NOT IS_CHAR_IN_CAR curley_bob_fm2 mission_taxi_fm2
	OR NOT IS_PLAYER_IN_CAR player mission_taxi_fm2

		WAIT 0

		IF IS_CAR_DEAD mission_taxi_fm2
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
			GOTO mission_frankie2_failed
		ELSE

			IF IS_CAR_UPSIDEDOWN mission_taxi_fm2
			AND IS_CAR_STOPPED mission_taxi_fm2 
				PRINT_NOW ( UPSIDE ) 5000 1 //"You've flipped your wheels!"
				GOTO mission_frankie2_failed
			ENDIF

		ENDIF
			 			
  		IF IS_CHAR_DEAD curley_bob_fm2
  			PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
  			GOTO mission_frankie2_failed
  		ENDIF

		IF NOT IS_CHAR_IN_CAR curley_bob_fm2 mission_taxi_fm2
			PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
			GOTO mission_frankie2_failed
		ENDIF
							
		IF NOT IS_PLAYER_IN_CAR player mission_taxi_fm2
		AND flag_player_got_car_message_fm2 = 0
   			CLEAR_PRINTS
   			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission"
   			ADD_BLIP_FOR_CAR mission_taxi_fm2 radar_blip_car1_fm2
			REMOVE_BLIP radar_blip_coord2_fm2
   			flag_player_got_car_message_fm2 = 1
			blob_flag = 0
   		ENDIF

   		IF IS_PLAYER_IN_CAR player mission_taxi_fm2
		AND flag_player_got_car_message_fm2 = 1
	  		ADD_BLIP_FOR_COORD 1529.0 -827.0 -100.0 radar_blip_coord2_fm2
			CHANGE_BLIP_DISPLAY radar_blip_coord2_fm2 BLIP_ONLY
   			REMOVE_BLIP radar_blip_car1_fm2
   			flag_player_got_car_message_fm2 = 0
			blob_flag = 1
   		ENDIF

		IF IS_CAR_STOPPED mission_taxi_fm2
			IF flag_car_has_just_stopped = 0
				//GET_GAME_TIMER time_car_stopped_fm2
				timerb = 0
				flag_car_has_just_stopped = 1
			ENDIF
			//GET_GAME_TIMER current_time_fm2
			//timer_difference = current_time_fm2 - time_car_stopped_fm2
			//IF timer_difference > 10000
			IF timerb > 10000
				flag_taxi1_exit_car_fm2 = 1
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF
		ELSE
		 	flag_car_has_just_stopped = 0
		ENDIF	
		   	  			
  	ENDWHILE

	REMOVE_BLIP radar_blip_coord2_fm2

	GOTO mission_jump2
	
ENDIF

// *********If player does not have a taxi creates taxi for Curley Bob to get into**********

mission_jump3:

IF IS_CAR_DEAD car_fm2
	PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
	flag_car_fm2_dead = 1
	GOTO mission_frankie2_failed
ELSE

	IF IS_CAR_UPSIDEDOWN car_fm2
	AND IS_CAR_STOPPED car_fm2 
		PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
		GOTO mission_frankie2_failed
	ENDIF

ENDIF

IF LOCATE_STOPPED_CAR_2D car_fm2 906.9 -433.0 6.0 6.0 FALSE
AND NOT IS_CAR_UPSIDEDOWN car_fm2 
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER curley_bob_fm2 car_fm2
ELSE
	PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
	GOTO mission_frankie2_failed
ENDIF

//waiting for the character to get into the car

	WHILE NOT IS_CHAR_IN_CAR curley_bob_fm2 car_fm2

	 	WAIT 0
			 	  	  		 
  		IF IS_CHAR_DEAD curley_bob_fm2
			PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
			GOTO mission_frankie2_failed
		ELSE

			IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF

		ENDIF
	   	   
		IF IS_CAR_DEAD car_fm2

			IF IS_CHAR_DEAD curley_bob_fm2
  				PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
  				GOTO mission_frankie2_failed
  			ELSE
				PRINT_NOW ( WRECKED ) 5000 1 //The vehicle's wrecked!"
				flag_car_fm2_dead = 1
				GOTO mission_frankie2_failed
			ENDIF

		ELSE

			IF IS_CAR_UPSIDEDOWN car_fm2
			AND IS_CAR_STOPPED car_fm2 
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF

		ENDIF

	ENDWHILE

	REMOVE_BLIP radar_blip_ped1_fm2

	PRINT_NOW ( FM2_2 ) 7000 1 //Tail Curly Bob!"

	SWITCH_WIDESCREEN OFF

	RESTORE_CAMERA

	SET_PLAYER_CONTROL player on

	SET_POLICE_IGNORE_PLAYER player off
	
	ADD_BLIP_FOR_CAR car_fm2 radar_blip_car2_fm2

	CHANGE_BLIP_DISPLAY radar_blip_car2_fm2 MARKER_ONLY

	SET_CAR_CRUISE_SPEED car_fm2 30.0

   	CAR_GOTO_COORDINATES_ACCURATE car_fm2 1529.0 -827.0 -100.0

	SET_CAR_DRIVING_STYLE  car_fm2 DRIVINGMODE_SLOWDOWNFORCARS

	SET_CAR_CRUISE_SPEED car_fm2 20.0

	ADD_STUCK_CAR_CHECK car_fm2 5.0 30000

	DISPLAY_ONSCREEN_COUNTER_WITH_STRING spooked_counter COUNTER_DISPLAY_BAR ( FM2_16 )
	
	timerb = 0
	
	timera = 0		

// Waiting for the car to get to the bottom of the dock area

	WHILE NOT LOCATE_CAR_2D car_fm2 1529.0 -827.0 3.0 3.0 FALSE
	
		WAIT 0

		IF spooked_check = 0

			IF timerb > 1500
				 spooked_check = 1
			ENDIF

		ENDIF
		
		IF IS_CAR_DEAD car_fm2
			
			IF IS_CHAR_DEAD curley_bob_fm2
  				PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
  				GOTO mission_frankie2_failed
  			ELSE
				PRINT_NOW ( WRECKED ) 5000 1 //The vehicle's wrecked!"
				flag_car_fm2_dead = 1
				GOTO mission_frankie2_failed
			ENDIF

		ELSE

			IF IS_CAR_STUCK car_fm2
				spooked_counter = 100
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
  				GOTO mission_frankie2_failed
			ENDIF

			IF IS_CAR_UPSIDEDOWN car_fm2
			AND IS_CAR_STOPPED car_fm2
				spooked_counter = 100
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF
						
		ENDIF
					
		CLEAR_AREA 1529.0 -827.0 -100.0 4.0 FALSE // This should clear the area at the bottom of the docks
						
  	 	IF IS_CHAR_DEAD curley_bob_fm2
  	 		PRINT_NOW ( FM2_9 ) 5000 1 //"Curly's dead!"
  	 		GOTO mission_frankie2_failed
  	 	ELSE
		   
	   		IF spooked_check = 1

				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 40.0 40.0 40.0 FALSE
				   
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 30.0 30.0 30.0 FALSE
						
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 20.0 20.0 20.0 FALSE


							IF IS_PLAYER_IN_MODEL player CAR_MAFIA
							
								IF timera > 8
									++ spooked_counter
									timera = 0
				   				ENDIF 
															
							ELSE
							
								IF timera > 16
									++ spooked_counter
									timera = 0
				   				ENDIF

							ENDIF
											
						ELSE

							IF IS_PLAYER_IN_MODEL player CAR_MAFIA

								IF timera > 16
									++ spooked_counter
									timera = 0
				   				ENDIF

							ELSE

								IF timera > 32
									++ spooked_counter
									timera = 0
				   				ENDIF

							ENDIF
																													
						ENDIF

					ELSE

						IF IS_PLAYER_IN_MODEL player CAR_MAFIA

							IF timera > 32
								++ spooked_counter
								timera = 0
				   			ENDIF

						ELSE
						
							IF timera > 64
								++ spooked_counter
								timera = 0
				   			ENDIF

						ENDIF
					 							
					ENDIF

				ELSE

					IF IS_PLAYER_IN_MODEL player CAR_MAFIA

						IF timera > 500

							IF spooked_counter > 0
								-- spooked_counter
							ENDIF
							timera = 0
						ENDIF

					ELSE
										
						IF timera > 250

							IF spooked_counter > 0
								-- spooked_counter
							ENDIF
							timera = 0
						ENDIF
						
					ENDIF	
				
				ENDIF

			ENDIF
			

			IF spooked_counter > 10

				IF flag_player_had_warning1_fm2 = 0
					PRINT_NOW ( FM2_15 ) 5000 1 //"Don't get too close or curly will suspect something!"
					flag_player_had_warning1_fm2 = 1				
				ENDIF
		
			ENDIF	


			IF spooked_counter = 100
				PRINT_NOW ( FM2_14 ) 5000 1 //"You got too close and spooked Curly!"	
				GOTO mission_frankie2_failed
			ENDIF	


		 	IF NOT IS_CHAR_IN_CAR curley_bob_fm2 car_fm2
				spooked_counter = 100
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF

			IF IS_CHAR_IN_AREA_2D curley_bob_fm2 1538.0 -741.0 1304.0 -901.0 FALSE
				SET_CAR_DRIVING_STYLE car_fm2 1
				SET_CAR_CRUISE_SPEED car_fm2 10.0
				flag_no_longer_mad = 1
			ENDIF

			IF flag_no_longer_mad = 0

				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player curley_bob_fm2 30.0 30.0 FALSE
					SET_CAR_DRIVING_STYLE car_fm2 DRIVINGMODE_AVOIDCARS
					SET_CAR_CRUISE_SPEED car_fm2 25.0
				ELSE
			   		SET_CAR_DRIVING_STYLE car_fm2 DRIVINGMODE_SLOWDOWNFORCARS
					SET_CAR_CRUISE_SPEED car_fm2 20.0
				ENDIF

			ENDIF

		ENDIF			  	  	   	  	
							   
		IF IS_CAR_VISIBLY_DAMAGED car_fm2
		 		 		   
			IF IS_CHAR_DEAD curley_bob_fm2
  	 			PRINT_NOW ( FM2_9 ) 5000 1 //"Curly's dead!"
  	 			GOTO mission_frankie2_failed
  	 		ELSE
				spooked_counter = 100
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF
				
		ENDIF
		
		IF IS_CAR_STOPPED car_fm2
			IF flag_car_has_just_stopped = 0
				GET_GAME_TIMER time_car_stopped_fm2
				flag_car_has_just_stopped = 1
			ENDIF
			GET_GAME_TIMER current_time_fm2
			timer_difference = current_time_fm2 - time_car_stopped_fm2
			IF timer_difference > 15000
				flag_taxi2_exit_car_fm2 = 1
				spooked_counter = 100
				PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
				GOTO mission_frankie2_failed
			ENDIF
		ELSE
			flag_car_has_just_stopped = 0
		ENDIF	 
				
  	ENDWHILE

REMOVE_BLIP radar_blip_car2_fm2

REMOVE_STUCK_CAR_CHECK car_fm2
  
	      
// ********************Curley Bob gets out of the script controlled taxi********************

IF flag_car_fm2_created = 1
AND IS_CHAR_IN_CAR curley_bob_fm2 car_fm2
	flag_taxi2_exit_car_fm2 = 1
ENDIF

IF flag_taxi2_exit_car_fm2 = 1
   	SET_CHAR_OBJ_LEAVE_CAR curley_bob_fm2 car_fm2


  		WHILE IS_CHAR_IN_CAR curley_bob_fm2 car_fm2

  			WAIT 0
		   		  		  			
  			IF IS_CHAR_DEAD curley_bob_fm2
				PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
				GOTO mission_frankie2_failed
			ELSE

				IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
					PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF
			  			
  			IF IS_CAR_DEAD car_fm2

				IF IS_CHAR_DEAD curley_bob_fm2
  					PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
  					GOTO mission_frankie2_failed
  				ELSE
					PRINT_NOW ( WRECKED ) 5000 1 //The vehicle's wrecked!"
					flag_car_fm2_dead = 1
					GOTO mission_frankie2_failed
				ENDIF

			ELSE

				IF IS_CAR_UPSIDEDOWN car_fm2
				AND IS_CAR_STOPPED car_fm2 
					PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF

  		 ENDWHILE

CLEAR_ONSCREEN_COUNTER spooked_counter

IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 160.0 160.0 160.0 FALSE	
	PRINT_NOW ( FM2_12 ) 5000 1 //"You lost him!"
	GOTO mission_frankie2_failed
ENDIF

// Checks to see if the player is around the ramp and will fail the mission

IF IS_PLAYER_IN_AREA_3D player 1573.72 -876.49 5.0 1404.09 -1034.30 30.0 FALSE
	spooked_counter = 100
	PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
	GOTO mission_frankie2_failed
ENDIF

GOTO mission_jump4

ENDIF


// *****************Orders Curley Bob out of the taxi if the player is driving**************

mission_jump2:

IF flag_mission_taxi_fm2_created = 1
AND IS_CHAR_IN_CAR curley_bob_fm2 mission_taxi_fm2
	flag_taxi1_exit_car_fm2 = 1
ENDIF 

IF flag_taxi1_exit_car_fm2 = 1

	SET_CHAR_OBJ_LEAVE_CAR curley_bob_fm2 mission_taxi_fm2

		WHILE IS_CHAR_IN_CAR curley_bob_fm2 mission_taxi_fm2

			WAIT 0

			IF IS_CHAR_DEAD curley_bob_fm2
				PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
				GOTO mission_frankie2_failed
			ELSE

				IF NOT IS_CHAR_HEALTH_GREATER curley_bob_fm2 99
					PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF 
		  		  		  		  
			IF IS_CAR_DEAD mission_taxi_fm2

				IF IS_CHAR_DEAD curley_bob_fm2
  					PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
  					GOTO mission_frankie2_failed
  				ELSE
					PRINT_NOW ( WRECKED ) 5000 1 //The vehicle's wrecked!"
					GOTO mission_frankie2_failed
				ENDIF

			ELSE

				IF IS_CAR_UPSIDEDOWN mission_taxi_fm2
				AND IS_CAR_STOPPED mission_taxi_fm2
					PRINT_NOW ( FM2_7 ) 7000 1 //"Something's spooked Curly, the meeting's off!"
					GOTO mission_frankie2_failed
				ENDIF

			ENDIF
						
		 ENDWHILE

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 160.0 160.0 160.0 FALSE	
			PRINT_NOW ( FM2_12 ) 5000 1 //"You lost him!"
			GOTO mission_frankie2_failed
		ENDIF

ENDIF


// ***********************Curley Bob has finally got to the docks***************************

mission_jump4:

SWITCH_WIDESCREEN ON

IF IS_PLAYER_IN_ANY_CAR player
	APPLY_BRAKES_TO_PLAYERS_CAR player ON
ENDIF

SET_PLAYER_CONTROL player OFF

CLEAR_WANTED_LEVEL player // This might have to come out when this bit is an Alex cut-scene

IF NOT IS_CHAR_DEAD van_driver_fm2
	SET_CHAR_CANT_BE_DRAGGED_OUT van_driver_fm2 FALSE
ENDIF

SET_POLICE_IGNORE_PLAYER player ON

CLEAR_AREA 1546.56 -834.79 12.70 1.0 TRUE

SET_FIXED_CAMERA_POSITION 1546.56 -834.79 12.70 0.0 0.0 0.0 

POINT_CAMERA_AT_POINT 1545.50 -834.60 12.79 JUMP_CUT

SET_CHAR_OBJ_RUN_TO_COORD curley_bob_fm2 1532.0 -889.0

timerb = 0

WHILE timerb < 1500
	
	WAIT 0

	CLEAR_AREA 1532.0 -889.0 -100.0 3.0 FALSE // Clears area curly is running to. 
    	
	IF IS_CHAR_DEAD curley_bob_fm2
		PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
		flag_curley_bob_fm2_dead = 1
		GOTO mission_frankie2_failed
	ENDIF
      		
ENDWHILE

IF IS_CHAR_DEAD curley_bob_fm2
	PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
	flag_curley_bob_fm2_dead = 1
	GOTO mission_frankie2_failed
ENDIF

// ****************************************START OF CUTSCENE TWO****************************

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway

	WAIT 0

	IF IS_CHAR_DEAD curley_bob_fm2
		PRINT_NOW ( FM2_9 ) 5000 1 //"Curly Bob's dead!"
		flag_curley_bob_fm2_dead = 1
		GOTO mission_frankie2_failed
	ENDIF

	GET_GAME_TIMER breakout_timer

	breakout_diff = breakout_timer - breakout_timer_start
	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 3 miguel
LOAD_SPECIAL_CHARACTER 4 cat
LOAD_SPECIAL_MODEL cut_obj1 MIGUELH
LOAD_SPECIAL_MODEL cut_obj2 CATH
LOAD_SPECIAL_MODEL cut_obj3 CURLYH
REQUEST_MODEL CAR_COLUMB

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

IF NOT IS_CHAR_DEAD curley_bob_fm2
	CHAR_SET_IDLE curley_bob_fm2
ENDIF 

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED CAR_COLUMB
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
  	
	WAIT 0

ENDWHILE

// creates car

CREATE_CAR CAR_COLUMB 1542.9 -896.1975 10.6 baddie_car_fm2

SET_CAR_HEADING baddie_car_fm2 90.0 

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE s2_ctg2

SET_CUTSCENE_OFFSET 1573.8866 -906.0611 11.1

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_curly

SET_CUTSCENE_ANIM cs_curly curly

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_miguel

SET_CUTSCENE_ANIM cs_miguel miguel

CREATE_CUTSCENE_OBJECT PED_SPECIAL4 cs_catalina

SET_CUTSCENE_ANIM cs_catalina cat

CREATE_CUTSCENE_HEAD cs_miguel CUT_OBJ1 cs_miguelhead

SET_CUTSCENE_HEAD_ANIM cs_miguelhead miguel

CREATE_CUTSCENE_HEAD cs_catalina CUT_OBJ2 cs_catalinahead

SET_CUTSCENE_HEAD_ANIM cs_catalinahead cat

CREATE_CUTSCENE_HEAD cs_curly CUT_OBJ3 cs_curlyhead

SET_CUTSCENE_HEAD_ANIM cs_curlyhead curly

CLEAR_AREA 898.6 -425.6 13.9 1.0 TRUE 

//SET_PLAYER_COORDINATES player 898.6 -425.6 13.9  // Player is in a taxi so don't comment back in

DO_FADE 1500 FADE_IN

DELETE_CHAR curley_bob_fm2

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time <= 0
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_F ) 10000 1 //"Here comes our little friend. Mr. big mouth himself."

WHILE cs_time < 3225
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_G ) 10000 1 //"Were you followed? You know what goes on here is our little secret."

WHILE cs_time < 7047 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_H ) 10000 1 //"No..no, I wasn't followed, You got my stuff?"

WHILE cs_time < 10272
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_I ) 10000 1 //"Here's your SPANK, squealer, now talk."

WHILE cs_time < 13914
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_P ) 10000 1 //"OK, so the Leone's are fighting wars on two fronts."

WHILE cs_time < 16721
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_Q ) 10000 1 //"They're in a turf war with the Triads with no sign of either side giving up."

WHILE cs_time < 20483
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_R ) 10000 1 //"Meanwhile Loey Leone has stirred up some bad blood with the Forellis."

WHILE cs_time < 24246
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_S ) 10000 1 //"Every day they're losing men and influence in the city."

WHILE cs_time < 26993
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_T ) 10000 1 //"Salvatore is becoming dangerous and paranoid. He suspects everybody and everything."

WHILE cs_time < 31770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM2_U ) 10000 1 //"With loyalty like yours, what has he possibly got to worry about."

WHILE cs_time < 35267
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM2_U )

WHILE cs_time < 37000
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

IF flag_car_fm2_dead = 0

	IF NOT IS_CAR_DEAD car_fm2
		DELETE_CHAR van_driver_fm2
		DELETE_CAR car_fm2
		flag_car_fm2_dead = 0	
	ENDIF

ENDIF

DELETE_CAR baddie_car_fm2 

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3


// ******************************************END OF CUTSCENE TWO****************************

 

// ********************************Kill Curley Bob Stuff************************************

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1493.7 -886.6 -100.0 curley_bob_fm2

SET_CHAR_HEADING curley_bob_fm2 90.0

GIVE_WEAPON_TO_CHAR curley_bob_fm2 WEAPONTYPE_SHOTGUN 30000

SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS curley_bob_fm2 player

ADD_BLIP_FOR_CHAR curley_bob_fm2 radar_blip_ped2_fm2

PRINT_NOW ( FM2_8 ) 7000 1 //"Kill Curley Bob for his treachery!"

WHILE NOT flag_curley_bob_dead_fm2 = 1

	WAIT 0

IF flag_curley_bob_dead_fm2 = 0
	
	IF IS_CHAR_DEAD curley_bob_fm2
		flag_curley_bob_dead_fm2 = 1
	ELSE
		
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 25.0 25.0 25.0 FALSE

			IF flag_curly_mad_fm2 = 0
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS curley_bob_fm2 player
				flag_curly_mad_fm2 = 1
			ENDIF

		ELSE
			flag_curly_mad_fm2 = 0
			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS curley_bob_fm2 player
		ENDIF
			 

		IF NOT IS_CHAR_ON_SCREEN curley_bob_fm2
		AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player curley_bob_fm2 160.0 160.0 80.0 FALSE
			PRINT_NOW ( FM2_10 ) 5000 1 //"Curly got away!"
			GOTO mission_frankie2_failed
		ENDIF
		
	ENDIF	
	
ENDIF		
            		
ENDWHILE

REMOVE_BLIP radar_blip_ped2_fm2

}
 
GOTO mission_frankie2_passed
	   		


// Mission Frankie2 failed

mission_frankie2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
REMOVE_CHAR_ELEGANTLY curley_bob_fm2
RETURN

   

// mission Frankie2 passed

mission_frankie2_passed:

flag_frankie_mission2_passed = 1
REGISTER_MISSION_PASSED ( FM2 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 15000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 15000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT frankie_mission2.1_loop
START_NEW_SCRIPT toni4_pager_loop
	
IF flag_toni_mission5_passed = 0
	flag_frankie_switched_off = 1
	REMOVE_BLIP frankie_contact_blip
ENDIF

RETURN
		


// mission cleanup

mission_cleanup_frankie2:

flag_player_on_mission = 0
flag_player_on_frankie_mission = 0

IF flag_car_fm2_dead = 0

	IF NOT IS_CAR_DEAD car_fm2
		CHANGE_CAR_LOCK car_fm2 CARLOCK_UNLOCKED
		SET_CAR_ONLY_DAMAGED_BY_PLAYER car_fm2 FALSE
	ENDIF

ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_TAXI
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED PED_TAXI_DRIVER
REMOVE_BLIP radar_blip_club_fm2 
REMOVE_BLIP radar_blip_ped1_fm2
REMOVE_BLIP radar_blip_coord2_fm2
REMOVE_BLIP radar_blip_car1_fm2
REMOVE_BLIP radar_blip_car2_fm2
REMOVE_BLIP radar_blip_ped2_fm2
SETUP_ZONE_PED_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0
SETUP_ZONE_PED_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
CLEAR_ONSCREEN_COUNTER spooked_counter
MISSION_HAS_FINISHED
RETURN

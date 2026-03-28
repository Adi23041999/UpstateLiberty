MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// *************************************Hood Mission 4****************************************
// ****************************************The Race*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME hood4

// Mission start stuff

GOSUB mission_start_hood4

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_hood4_failed
	ENDIF

GOSUB mission_cleanup_hood4

MISSION_END


// Variables for mission

VAR_INT total_no_pills_carried_hm4  //Total no of pills eaten since race started

VAR_INT radar_blip_coord1_hm4

VAR_INT no_of_pills_carried_hm4  //no of pills player is carrying

VAR_INT flag_player_in_area_hm4

VAR_INT timer_hm4

VAR_INT car_hm4

VAR_INT radar_blip_car1_hm4

VAR_INT flag_player_had_car_message_hm4

VAR_INT flag_blip_added_hm4

VAR_INT radar_blip_coord2_hm4

	
// ***************************************Mission Start*************************************


mission_start_hood4:

flag_player_on_mission = 1

flag_player_on_hood_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

total_no_pills_carried_hm4 = 0

flag_player_in_area_hm4 = 0

timer_hm4 = 361000 // 6 mins

flag_player_had_car_message_hm4 = 0

flag_blip_added_hm4 = 0

{

// *******************************************START OF CUTSCENE*****************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_hood4_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( HM_4 ) 15000 2 //"GOLD GRAB"	

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

LOAD_CUTSCENE hd_ph4 
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

WHILE cs_time < 2096
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( HM4_A ) 10000 1 //"Yo a Federal..." 

WHILE cs_time < 5840
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM4_B ) 10000 1 //"There's platinum all..." 

WHILE cs_time < 8171
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM4_C ) 10000 1  //"Get a car..." 

WHILE cs_time < 11161
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM4_F ) 10000 1 //"You can drop..." 

WHILE cs_time < 13963
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM4_G ) 10000 1 //"This platinum..." 

WHILE cs_time < 17683
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM4_H ) 10000 1 //"So make regular drop..."

WHILE cs_time < 19787
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( HM4_H ) 

WHILE cs_time < 20433
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

PRINT_NOW ( HM4_D ) 5000 1 //"Get a vehicle!"

WHILE NOT IS_PLAYER_IN_ANY_CAR player

	WAIT 0
	
ENDWHILE

STORE_CAR_PLAYER_IS_IN player car_hm4

SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 car_hm4

//REMOVE_BLIP radar_blip_car1_hm4

ADD_BLIP_FOR_COORD -1080.0 -163.2 -100.0 radar_blip_coord2_hm4

PRINT_NOW ( HM4_1 ) 7000 1 //"Head to the location where the cargo is scattered!"

START_PACMAN_SCRAMBLE -1080.0 -163.2 -100.0 100.0 90  // 90 tokens are created

DISPLAY_ONSCREEN_TIMER timer_hm4

DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_no_pills_carried_hm4 COUNTER_DISPLAY_NUMBER collect 

// waiting for the player to get the correct number of pills

WHILE NOT total_no_pills_carried_hm4 >= 30

	WAIT 0
	
	GET_NUMBER_OF_POWER_PILLS_CARRIED no_of_pills_carried_hm4

	IF IS_PLAYER_IN_AREA_3D player -824.7 -165.5 32.8 -843.5 -171.7 37.0 FALSE
		CLEAR_WANTED_LEVEL player
	ENDIF

// Checks to see if any pills are carried and switches off airport blip and puts on the drop off blip

	IF no_of_pills_carried_hm4 > 0

		IF flag_blip_added_hm4 = 0
			REMOVE_BLIP radar_blip_coord2_hm4
			ADD_BLIP_FOR_COORD -844.9 -169.6 32.8 radar_blip_coord1_hm4  // Coords for where the gold is to be dropped off
			PRINT_NOW ( HM4_2 ) 7000 1 //"Remember when the vehicle becomes too heavy and slow goto the garage and drop off the cargo."
			flag_blip_added_hm4 = 1
		ENDIF

	ENDIF	
     	
// Checks and removes the no of pills that the player has collected	 
	
		IF IS_PLAYER_IN_ANY_CAR player

			STORE_CAR_PLAYER_IS_IN player car_hm4
			SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 car_hm4

		    IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player -824.7 -165.5 32.8 -843.5 -171.7 37.0 FALSE
			AND flag_player_in_area_hm4 = 0
				total_no_pills_carried_hm4 += no_of_pills_carried_hm4
				ADD_ONE_OFF_SOUND -834.9 -168.8 33.9 SOUND_UNLOAD_GOLD
				CLEAR_NUMBER_OF_POWER_PILLS_CARRIED
				flag_player_in_area_hm4 = 1
			ENDIF
	
			IF IS_PLAYER_IN_CAR player car_hm4
			AND NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player -824.7 -165.5 32.8 -843.5 -171.7 37.0 FALSE
			AND flag_player_in_area_hm4 = 1
				flag_player_in_area_hm4 = 0
			ENDIF

		ENDIF

// Checks for the player getting in and out of the car

		IF NOT IS_PLAYER_IN_ANY_CAR player

			SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 -1
			
			IF flag_player_had_car_message_hm4 = 0
				PRINT_NOW ( IN_VEH2 ) 5000 1 //"Get into the vehicle!"
				IF flag_blip_added_hm4 = 1
					REMOVE_BLIP radar_blip_coord1_hm4
				ENDIF
				flag_player_had_car_message_hm4 = 1
			ENDIF
			
		ELSE

			STORE_CAR_PLAYER_IS_IN player car_hm4
			SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 car_hm4
			
			IF flag_player_had_car_message_hm4 = 1
				IF flag_blip_added_hm4 = 1
					ADD_BLIP_FOR_COORD -844.9 -169.6 32.8 radar_blip_coord1_hm4
				ENDIF
				flag_player_had_car_message_hm4 = 0
			ENDIF
			
		ENDIF 
	
	IF timer_hm4 = 0
		PRINT_NOW ( OUTTIME ) 5000 1 //"Your out of time!"
		GOTO mission_hood4_failed
	ENDIF  
			
ENDWHILE

REMOVE_BLIP radar_blip_coord1_hm4

}  

GOTO mission_hood4_passed

 

// Mission hood4 failed

mission_hood4_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 -1

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_SUBURBAN 
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_SUBURBAN
ENDIF

RETURN


   

// mission hood4 passed

mission_hood4_passed:

flag_hood_mission4_passed = 1
REGISTER_MISSION_PASSED ( HM_4 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 25000 5000 1 //Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 25000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT hood_mission5_loop
RETURN
		


// mission cleanup

mission_cleanup_hood4:

flag_player_on_mission = 0
flag_player_on_hood_mission = 0
SET_TARGET_CAR_FOR_MISSION_GARAGE garage_hm4 -1
CLEAR_NUMBER_OF_POWER_PILLS_CARRIED
CLEAR_PACMAN
REMOVE_BLIP radar_blip_coord1_hm4
REMOVE_BLIP radar_blip_coord2_hm4
CLEAR_ONSCREEN_TIMER timer_hm4
CLEAR_ONSCREEN_COUNTER total_no_pills_carried_hm4 // TEST STUFF
MISSION_HAS_FINISHED
RETURN
		

  
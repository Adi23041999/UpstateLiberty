MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Hood Mission 2****************************************
// **************************************R C ASSASSIN*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME hood2

// Mission start stuff

GOSUB mission_start_hood2

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_hood2_failed
	ENDIF

GOSUB mission_cleanup_hood2

MISSION_END


// Variables for mission

VAR_INT mission_car_hm2

VAR_INT radar_blip_car1_hm2

VAR_INT target_van1_hm2

VAR_INT target_van2_hm2

VAR_INT target_van3_hm2

VAR_INT van_driver1_hm2  //Drives van 1

VAR_INT van_driver2_hm2  //Drives van 2

VAR_INT van_driver3_hm2  //Drives van 3

VAR_INT radar_blip_van1_hm2

VAR_INT radar_blip_van2_hm2

VAR_INT radar_blip_van3_hm2

VAR_INT flag_van1_dead_hm2

VAR_INT flag_van2_dead_hm2

VAR_INT flag_van3_dead_hm2

VAR_INT counter_all_vans_dead_hm2

VAR_INT counter_no_of_cars_player_had_hm2

VAR_INT flag_player_got_car_hm2

VAR_INT flag_buggy_help2_hm2

VAR_INT flag_buggy_help3_hm2

VAR_INT flag_buggy_help1_hm2

VAR_INT buggies_left_hm2

VAR_INT total_buggy_hm2
	
// ***************************************Mission Start*************************************


mission_start_hood2:

flag_player_on_mission = 1

flag_player_on_hood_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

counter_all_vans_dead_hm2 = 0

flag_van1_dead_hm2 = 0

flag_van2_dead_hm2 = 0

flag_van3_dead_hm2 = 0

counter_all_vans_dead_hm2 = 0

counter_no_of_cars_player_had_hm2 = 0

flag_player_got_car_hm2 = 0

flag_buggy_help2_hm2 = 0

flag_buggy_help3_hm2 = 0

flag_buggy_help1_hm2 = 0

buggies_left_hm2 = 0

total_buggy_hm2 = 5

{

// *****************************************START OF CUTSCENE*******************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_hood2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( HM_2 ) 15000 2 //"TOYMINATOR"

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

LOAD_CUTSCENE hd_ph2 
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
PRINT_NOW ( HM2_A ) 10000 1  //" Those Nines are..." 

WHILE cs_time < 3468
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM2_B ) 10000 1  //"These Bitches..." 

WHILE cs_time < 6630
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM2_C ) 10000 1  //"and slinging it to brothers..." 

WHILE cs_time < 8077
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM2_D ) 10000 1  //"Theres a car parked up the way..." 

WHILE cs_time < 9819
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM2_E ) 10000 1 //"There's some stuff in there.." 

WHILE cs_time < 12413
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM2_F ) 10000 1  //"and wreck all there..."

WHILE cs_time < 14200
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( HM2_F ) 

WHILE cs_time < 15333
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

// ******************************************END OF CUTSCENE********************************


REQUEST_MODEL CAR_TOYZ

REQUEST_MODEL CAR_SECURICAR

REQUEST_MODEL car_rcbandit

WHILE NOT HAS_MODEL_LOADED CAR_TOYZ
OR NOT HAS_MODEL_LOADED CAR_SECURICAR
OR NOT HAS_MODEL_LOADED car_rcbandit
	
	WAIT 0

ENDWHILE

CREATE_CAR CAR_TOYZ -682.02 76.60 -100.0 mission_car_hm2

//SET_CAR_HEADING mission_car_hm2 0.0

ADD_BLIP_FOR_CAR mission_car_hm2 radar_blip_car1_hm2

// waiting for the player to get into the control car

WHILE NOT IS_PLAYER_SITTING_IN_CAR player mission_car_hm2

	WAIT 0

	IF IS_CAR_DEAD mission_car_hm2
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
		GOTO mission_hood2_failed
	ENDIF

ENDWHILE

buggies_left_hm2 = total_buggy_hm2 - counter_no_of_cars_player_had_hm2

DISPLAY_ONSCREEN_COUNTER_WITH_STRING buggies_left_hm2 COUNTER_DISPLAY_NUMBER ( BUGGY )

SET_POLICE_IGNORE_PLAYER player ON

REMOVE_BLIP radar_blip_car1_hm2

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	PRINT_HELP ( HM2_1 ) //"Use the radio controlled cars to destroy the trucks press | to detonate"
	flag_buggy_help1_hm2 = 1
ENDIF

IF controlmode = 1
	PRINT_HELP ( HM2_1 ) //"Use the radio controlled cars to destroy the trucks press | to detonate"
	flag_buggy_help1_hm2 = 1
ENDIF

IF controlmode = 2
	PRINT_HELP ( HM2_1 ) //"Use the radio controlled cars to destroy the trucks press | to detonate"
	flag_buggy_help1_hm2 = 1
ENDIF

IF controlmode = 3
	PRINT_HELP ( HM2_1A ) //"Use the radio controlled cars to destroy the trucks press the R1 button to detonate."
	flag_buggy_help1_hm2 = 1
ENDIF

CLEAR_AREA -681.42 91.35 17.7 2.0 TRUE 

GIVE_REMOTE_CONTROLLED_CAR_TO_PLAYER player -681.42 91.35 17.7 94.0

++ counter_no_of_cars_player_had_hm2

// creates van 1

CREATE_CAR CAR_SECURICAR -841.0 -130.0 -100.0 target_van1_hm2

CREATE_CHAR_INSIDE_CAR target_van1_hm2 PEDTYPE_CIVMALE PED_MALE1 van_driver1_hm2

SET_CAR_ONLY_DAMAGED_BY_PLAYER target_van1_hm2 TRUE

SET_CAR_AVOID_LEVEL_TRANSITIONS target_van1_hm2 TRUE 

ADD_BLIP_FOR_CAR target_van1_hm2 radar_blip_van1_hm2

SET_CAR_DRIVING_STYLE target_van1_hm2 2

SET_CAR_CRUISE_SPEED target_van1_hm2 12.0

CAR_WANDER_RANDOMLY target_van1_hm2

// creates van 2

CREATE_CAR CAR_SECURICAR -437.0 -67.0 -100.0 target_van2_hm2

CREATE_CHAR_INSIDE_CAR target_van2_hm2 PEDTYPE_CIVMALE PED_MALE1 van_driver2_hm2

SET_CAR_ONLY_DAMAGED_BY_PLAYER target_van2_hm2 TRUE

SET_CAR_AVOID_LEVEL_TRANSITIONS target_van2_hm2 TRUE

ADD_BLIP_FOR_CAR target_van2_hm2 radar_blip_van2_hm2

SET_CAR_DRIVING_STYLE target_van2_hm2 2

SET_CAR_CRUISE_SPEED target_van2_hm2 12.0

CAR_WANDER_RANDOMLY target_van2_hm2

// creates van 3

CREATE_CAR CAR_SECURICAR -1172.0 467.0 -100.0 target_van3_hm2

CREATE_CHAR_INSIDE_CAR target_van3_hm2 PEDTYPE_CIVMALE PED_MALE1 van_driver3_hm2

SET_CAR_ONLY_DAMAGED_BY_PLAYER target_van3_hm2 TRUE

SET_CAR_AVOID_LEVEL_TRANSITIONS target_van3_hm2 TRUE

ADD_BLIP_FOR_CAR target_van3_hm2 radar_blip_van3_hm2

SET_CAR_DRIVING_STYLE target_van3_hm2 2

SET_CAR_CRUISE_SPEED target_van3_hm2 12.0

CAR_WANDER_RANDOMLY target_van3_hm2

// waiting for the player to destroy all of the vans

buggies_left_hm2 = total_buggy_hm2 - counter_no_of_cars_player_had_hm2

timerb = 0

WHILE NOT counter_all_vans_dead_hm2 = 3

	WAIT 0

	buggies_left_hm2 = total_buggy_hm2 - counter_no_of_cars_player_had_hm2 

	IF flag_buggy_help2_hm2 = 0
	AND flag_buggy_help1_hm2 = 1

		IF timerb > 7000
			PRINT_HELP ( HM2_3 ) //"The buggies can go underneath vehicles but if you touch the wheels the buggy will detonate instantly."
			flag_buggy_help2_hm2 = 1
			//timerb = 0
		ENDIF
		
	ENDIF
	
	IF flag_buggy_help3_hm2 = 0

		IF flag_buggy_help2_hm2 = 1 
	
			IF timerb > 14000
				PRINT_HELP ( HM2_4 ) //"The buggy will detonate if you get out of range!"
				flag_buggy_help3_hm2 = 1
			ENDIF
			
		ENDIF
		
	ENDIF  
	
	CLEAR_WANTED_LEVEL player

IF NOT IS_CAR_DEAD mission_car_hm2 

	IF NOT IS_PLAYER_IN_REMOTE_MODE player
	AND counter_no_of_cars_player_had_hm2 < 6
	AND flag_player_got_car_hm2 = 0
	AND IS_PLAYER_SITTING_IN_CAR player mission_car_hm2
		CLEAR_AREA -681.42 91.35 17.7 2.0 FALSE
		GIVE_REMOTE_CONTROLLED_CAR_TO_PLAYER player -681.42 91.35 17.7 94.0
		++ counter_no_of_cars_player_had_hm2
		flag_player_got_car_hm2 = 1 
	ENDIF

ENDIF

IF NOT IS_PLAYER_IN_REMOTE_MODE player
	flag_player_got_car_hm2 = 0
ENDIF

IF flag_van1_dead_hm2 = 0

	IF IS_CAR_DEAD target_van1_hm2
		++ counter_all_vans_dead_hm2
		PRINT_NOW ( HM2_6 ) 5000 1 //"Armoured Car destroyed!"
		REMOVE_BLIP radar_blip_van1_hm2
		flag_van1_dead_hm2 = 1
	 ENDIF

ENDIF

IF flag_van2_dead_hm2 = 0

	IF IS_CAR_DEAD target_van2_hm2
		++ counter_all_vans_dead_hm2
		PRINT_NOW ( HM2_6 ) 5000 1 //"Armoured Car destroyed!"
		REMOVE_BLIP radar_blip_van2_hm2
		flag_van2_dead_hm2 = 1
	 ENDIF

ENDIF

IF flag_van3_dead_hm2 = 0

	IF IS_CAR_DEAD target_van3_hm2
		++ counter_all_vans_dead_hm2
		PRINT_NOW ( HM2_6 ) 5000 1 //"Armoured Car destroyed!"
		REMOVE_BLIP radar_blip_van3_hm2
		flag_van3_dead_hm2 = 1
	 ENDIF

ENDIF

IF counter_no_of_cars_player_had_hm2 = 5
AND flag_player_got_car_hm2 = 0
AND NOT counter_all_vans_dead_hm2 = 3
	PRINT_NOW ( HM2_2 ) 5000 1 //"You failed to destroy all the armoured cars!"
	GOTO mission_hood2_failed

ENDIF

IF NOT IS_PLAYER_IN_ANY_CAR player
	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
	PRINT_NOW ( HM2_2 ) 5000 1 //"You failed to destroy all the armoured cars!"
	GOTO mission_hood2_failed
ENDIF 

ENDWHILE

BLOW_UP_RC_BUGGY

}

GOTO mission_hood2_passed

 

// Mission hood2 failed

mission_hood2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_SUBURBAN 
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_SUBURBAN
ENDIF

RETURN


   

// mission hood2 passed

mission_hood2_passed:

flag_hood_mission2_passed = 1
REGISTER_MISSION_PASSED ( HM_2 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT hood_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_hood2:

flag_player_on_mission = 0
flag_player_on_hood_mission = 0
LOAD_SCENE -660.9 76.0 18.7
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_TOYZ
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SECURICAR
MARK_MODEL_AS_NO_LONGER_NEEDED car_rcbandit
CLEAR_ONSCREEN_COUNTER buggies_left_hm2
REMOVE_BLIP radar_blip_car1_hm2
REMOVE_BLIP radar_blip_van1_hm2
REMOVE_BLIP radar_blip_van2_hm2
REMOVE_BLIP radar_blip_van3_hm2
MISSION_HAS_FINISHED
RETURN
		

  
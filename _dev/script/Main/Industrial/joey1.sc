MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 1****************************************
// ************************************Kill Mike Lips*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_joey1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey1_failed
ENDIF

GOSUB mission_cleanup_joey1

MISSION_END


// Variables for mission

VAR_INT mike_car // mission specific ped

VAR_FLOAT mikes_car_heading	

VAR_INT blip1_jm1 blip2_jm1 blip3_jm1 blip4_jm1

VAR_INT flag_player_got_joey1_message flag_car_blip_displayed_jm1

VAR_INT flag_displayed_wanted_message_jm1

VAR_INT countdown_jm1 mission_passed_for_lips_finished


// ***************************************Mission Start*************************************

mission_start_joey1:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
mission_passed_for_lips_finished = 0
SCRIPT_NAME joey1
WAIT 0

flag_displayed_wanted_message_jm1 = 0

{

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_CHARACTER 2 misty
LOAD_SPECIAL_MODEL cut_obj1 JOEDOOR
LOAD_SPECIAL_MODEL cut_obj2 JOEYH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 MISTYH
REQUEST_MODEL CAR_IDAHO
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint


LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
	WAIT 0
ENDWHILE

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CAR_IDAHO
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
	WAIT 0

ENDWHILE

LOAD_CUTSCENE J1_LFL
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CAR CAR_IDAHO 1182.5 -857.0 14.1 cut_car2_lm3
SET_CAR_HEADING cut_car2_lm3 291.2

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

CLEAR_AREA 1191.9 -870.4 15.0 1.0 TRUE
SET_PLAYER_COORDINATES player 1191.9 -870.4 -100.0

SET_PLAYER_HEADING player 230.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_A ) 10000 2 // Mission brief

WHILE cs_time < 2739
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_B ) 10000 2 // Mission brief

WHILE cs_time < 6344
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_C ) 10000 2 // Mission brief

WHILE cs_time < 8362
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_D ) 10000 2 // Mission brief

WHILE cs_time < 10700
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_E ) 10000 2 // Mission brief

WHILE cs_time < 12688
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_F ) 10000 2 // Mission brief

WHILE cs_time < 15858
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_G ) 10000 2 // Mission brief

WHILE cs_time < 19969
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_H ) 10000 2 // Mission brief

WHILE cs_time < 21519
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_I ) 3000 2 // Mission brief

WHILE cs_time < 24979
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_J ) 10000 2 // Mission brief

WHILE cs_time < 27466
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM1_K ) 10000 2 // Mission brief

WHILE cs_time < 29204
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 30000
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 TRUE
SET_CAMERA_IN_FRONT_OF_PLAYER

ADD_SPRITE_BLIP_FOR_COORD 1282.0 -104.0 -100.0 RADAR_SPRITE_BOMB blip2_jm1
ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY blip4_jm1
ADD_BLIP_FOR_COORD 1335.0 -455.0 -100.0 blip3_jm1
REMOVE_BLIP	blip2_jm1
REMOVE_BLIP	blip3_jm1
REMOVE_BLIP	blip4_jm1

WAIT 500

DO_FADE 1500 FADE_IN


UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

DELETE_CAR cut_car2_lm3
	

// START OF MISSION

LOAD_SPECIAL_CHARACTER 3 lips
REQUEST_MODEL CAR_IDAHO

	WHILE NOT HAS_MODEL_LOADED CAR_IDAHO
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
		WAIT 0

	ENDWHILE

IF timer_help_message_displayed	= 0
	PRINT_HELP ( TIMER )
	timer_help_message_displayed = 1
ENDIF

CREATE_CAR CAR_IDAHO 1336.2 -460.8 -100.0 mike_car
MAKE_CRAIGS_CAR_A_BIT_STRONGER mike_car TRUE
LOCK_CAR_DOORS mike_car CARLOCK_FORCE_SHUT_DOORS
SET_CAR_HEADING mike_car 90.0
SET_CAN_RESPRAY_CAR mike_car OFF
ADD_BLIP_FOR_CAR mike_car blip1_jm1
countdown_jm1 = 361000
DISPLAY_ONSCREEN_TIMER countdown_jm1


	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF


WHILE NOT IS_PLAYER_IN_CAR player mike_car
	WAIT 0

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
   
	IF IS_CAR_UPSIDEDOWN mike_car
	AND IS_CAR_STOPPED mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
		
	IF countdown_jm1 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey1_failed
	ENDIF

ENDWHILE 


PRINT_NOW ( JM1_1 ) 5000 1 //"Go to 8 Balls"

SET_FREE_BOMBS On


Go_to_8Balls:

flag_car_blip_displayed_jm1 = TRUE

WHILE NOT IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITION
AND NOT IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITIONACTIVE
	WAIT 0

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
   
	IF IS_CAR_UPSIDEDOWN mike_car
	AND IS_CAR_STOPPED mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
		
	IF countdown_jm1 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
   
	IF IS_PLAYER_IN_CAR player mike_car
		IF flag_car_blip_displayed_jm1 = TRUE
			IF NOT IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITIONACTIVE
			OR NOT IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITION
				REMOVE_BLIP blip2_jm1
				ADD_SPRITE_BLIP_FOR_COORD 1282.0 -104.0 -100.0 RADAR_SPRITE_BOMB blip2_jm1
				REMOVE_BLIP blip1_jm1
			ENDIF
		flag_car_blip_displayed_jm1 = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player mike_car
		IF flag_car_blip_displayed_jm1 = FALSE
		ADD_BLIP_FOR_CAR mike_car blip1_jm1
		REMOVE_BLIP blip2_jm1
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
		flag_car_blip_displayed_jm1 = TRUE
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_HEALTH_GREATER mike_car 700
	OR IS_CAR_VISIBLY_DAMAGED mike_car
		PRINT_SOON ( JM1_4 ) 5000 2 //Repair the car!
			REMOVE_BLIP blip1_jm1
			ADD_BLIP_FOR_CAR mike_car blip1_jm1
			CHANGE_BLIP_DISPLAY blip1_jm1 BLIP_ONLY
			flag_car_blip_displayed_jm1 = TRUE

				WHILE IS_CAR_VISIBLY_DAMAGED mike_car
					WAIT 0 

					IF IS_CAR_DEAD mike_car
						PRINT_NOW ( WRECKED ) 5000 1
						GOTO mission_joey1_failed
					ENDIF
				   
					IF IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITIONACTIVE
					OR IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITION
						REMOVE_BLIP blip2_jm1
					ENDIF

					IF IS_CAR_UPSIDEDOWN mike_car
					AND IS_CAR_STOPPED mike_car
						PRINT_NOW ( WRECKED ) 5000 1
						GOTO mission_joey1_failed
					ENDIF
						
					IF countdown_jm1 = 0
						PRINT_NOW ( OUTTIME ) 5000 1
						GOTO mission_joey1_failed
					ENDIF

					IF IS_PLAYER_IN_CAR player mike_car
						IF flag_car_blip_displayed_jm1 = TRUE
							REMOVE_BLIP	blip4_jm1
							ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY blip4_jm1
							REMOVE_BLIP blip1_jm1
						flag_car_blip_displayed_jm1 = FALSE
						ENDIF
					ENDIF

					IF NOT IS_PLAYER_IN_CAR player mike_car
						IF flag_car_blip_displayed_jm1 = FALSE
						ADD_BLIP_FOR_CAR mike_car blip1_jm1
						REMOVE_BLIP blip4_jm1
						PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
						flag_car_blip_displayed_jm1 = TRUE
						ENDIF
					ENDIF

				ENDWHILE

			REMOVE_BLIP blip4_jm1
			GOTO Go_to_8Balls
	ENDIF

ENDWHILE

	WAIT 4000

	PRINT_NOW ( jm1_2 ) 5000 2 // Car rigged
	REMOVE_BLIP blip1_jm1
	REMOVE_BLIP blip2_jm1
	REMOVE_BLIP blip4_jm1

one_before_joey_label1:

	SET_FREE_BOMBS Off

joey_label1: //Drop the car back at the bistro

WAIT 0
flag_car_blip_displayed_jm1 = TRUE

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF

blob_flag = 1

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D mike_car 1339.6 -459.5 49.0 1332.8 -462.8 53.0 blob_flag
OR IS_WANTED_LEVEL_GREATER Player 0
OR IS_CAR_VISIBLY_DAMAGED mike_car
	WAIT 0

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
   
	IF IS_CAR_UPSIDEDOWN mike_car
	AND IS_CAR_STOPPED mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
		
	IF countdown_jm1 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey1_failed
	ENDIF

	IF IS_PLAYER_IN_CAR player mike_car
		IF flag_car_blip_displayed_jm1 = TRUE
			REMOVE_BLIP	blip3_jm1
			ADD_BLIP_FOR_COORD 1335.0 -455.0 -100.0 blip3_jm1
			REMOVE_BLIP blip1_jm1
			blob_flag = 1
		flag_car_blip_displayed_jm1 = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player mike_car
		IF flag_car_blip_displayed_jm1 = FALSE
		ADD_BLIP_FOR_CAR mike_car blip1_jm1
		REMOVE_BLIP blip3_jm1
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
		blob_flag = 0
		flag_car_blip_displayed_jm1 = TRUE
		ENDIF
	ENDIF

	IF NOT IS_CAR_HEALTH_GREATER mike_car 700
	OR IS_CAR_VISIBLY_DAMAGED mike_car
		PRINT_SOON ( JM1_4 ) 5000 2 //Repair the car!
		REMOVE_BLIP blip3_jm1
		REMOVE_BLIP blip1_jm1
		ADD_BLIP_FOR_CAR mike_car blip1_jm1
		CHANGE_BLIP_DISPLAY blip1_jm1 BLIP_ONLY
		flag_car_blip_displayed_jm1 = TRUE

			WHILE IS_CAR_VISIBLY_DAMAGED mike_car
				WAIT 0 

				IF IS_CAR_DEAD mike_car
					PRINT_NOW ( WRECKED ) 5000 1
					GOTO mission_joey1_failed
				ENDIF
			   
				IF IS_CAR_UPSIDEDOWN mike_car
				AND IS_CAR_STOPPED mike_car
					PRINT_NOW ( WRECKED ) 5000 1
					GOTO mission_joey1_failed
				ENDIF
					
				IF countdown_jm1 = 0
					PRINT_NOW ( OUTTIME ) 5000 1
					GOTO mission_joey1_failed
				ENDIF

				IF IS_PLAYER_IN_CAR player mike_car
					IF flag_car_blip_displayed_jm1 = TRUE
						REMOVE_BLIP	blip4_jm1
						ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY blip4_jm1
						REMOVE_BLIP blip1_jm1
						blob_flag = 1
					flag_car_blip_displayed_jm1 = FALSE
					ENDIF
				ENDIF

				IF NOT IS_PLAYER_IN_CAR player mike_car
					IF flag_car_blip_displayed_jm1 = FALSE
					ADD_BLIP_FOR_CAR mike_car blip1_jm1
					REMOVE_BLIP blip4_jm1
					PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
					blob_flag = 0
					flag_car_blip_displayed_jm1 = TRUE
					ENDIF
				ENDIF

			ENDWHILE

		REMOVE_BLIP blip4_jm1
		GOTO joey_label1
	ENDIF

	IF IS_PLAYER_IN_AREA_IN_CAR_3D player 1339.6 -459.5 49.0 1332.8 -462.8 53.0 FALSE
		IF IS_WANTED_LEVEL_GREATER player 0
			IF flag_displayed_wanted_message_jm1 = 0
				PRINT_NOW ( WANTED1 ) 4000 1
				flag_displayed_wanted_message_jm1 = 1
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_PLAYER_IN_AREA_3D player 1339.6 -459.5 49.0 1332.8 -462.8 53.0 FALSE
			flag_displayed_wanted_message_jm1 = 0
		ENDIF
	ENDIF

ENDWHILE


REMOVE_BLIP blip1_jm1
REMOVE_BLIP blip2_jm1
REMOVE_BLIP blip3_jm1
REMOVE_BLIP blip4_jm1

IF countdown_jm1 = 0
	PRINT_NOW ( OUTTIME ) 5000 1
	GOTO mission_joey1_failed
ENDIF

IF NOT IS_CAR_DEAD mike_car

	GET_CAR_HEADING mike_car mikes_car_heading
	IF mikes_car_heading > 100.0
	OR mikes_car_heading < 80.0
		PRINT_NOW ( JM1_6 ) 5000 1 //Put the car back in the correct position
		GOTO joey_label1
	ENDIF 

	IF IS_PLAYER_IN_CAR	player mike_car
		PRINT_NOW ( JM1_3 ) 5000 2 //Activate the car bomb then get out of there!
	ENDIF

ENDIF

cars_rigged:
WAIT 0

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF


WHILE NOT IS_CAR_STOPPED_IN_AREA_3D mike_car 1339.6 -459.5 49.0 1332.8 -462.8 53.0 TRUE
OR IS_PLAYER_IN_AREA_3D player 1306.0 -482.0 49.0 1350.0 -444.0 59.0 FALSE
OR NOT IS_PLAYER_IN_AREA_3D player 1306.0 -484.0 49.0 1370.0 -434.0 69.0 FALSE 

	WAIT 0

	IF IS_CAR_DEAD mike_car
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
   
	IF IS_CAR_UPSIDEDOWN mike_car
	AND IS_CAR_STOPPED mike_car		
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey1_failed
	ENDIF
		
	IF countdown_jm1 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey1_failed
	ENDIF

	IF NOT IS_CAR_IN_AREA_3D mike_car 1339.6 -459.5 49.0 1332.8 -462.8 53.0 FALSE
		PRINT_NOW ( JM1_6 ) 5000 1
		GOTO joey_label1
	ENDIF

	GET_CAR_HEADING mike_car mikes_car_heading
	IF mikes_car_heading > 100.0
	OR mikes_car_heading < 80.0
		PRINT_NOW ( JM1_6 ) 5000 1
		GOTO joey_label1
	ENDIF 

	IF NOT IS_CAR_HEALTH_GREATER mike_car 700
	OR IS_CAR_VISIBLY_DAMAGED mike_car
		GOTO joey_label1
	ENDIF

ENDWHILE


	IF countdown_jm1 = 0
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey1_failed
	ENDIF

	IF NOT IS_CAR_ARMED_WITH_BOMB mike_car CARBOMB_ONIGNITIONACTIVE
 		PRINT_NOW ( JM1_5 ) 5000 1 // The vehicle bomb's not set!
		GOTO cars_rigged
	ENDIF
	


//LIPS CUT_SCENE

CLEAR_AREA 1325.5 -452.5 54.0 4.0 TRUE
CLEAR_AREA 1328.4 -453.0 54.0 4.0 TRUE
CLEAR_AREA 1330.0 -466.1 49.0 4.0 TRUE
CLEAR_AREA 1333.6 -465.3 49.0 4.0 TRUE

CLEAR_ONSCREEN_TIMER countdown_jm1
SET_POLICE_IGNORE_PLAYER Player On
SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON


CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL3 1325.5 -452.5 -100.0 lips
SET_CHAR_HEADING lips 270.0
 
SET_FIXED_CAMERA_POSITION 1337.814 -468.631 49.774 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1337.053 -468.016 49.982 JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lips 1328.4 -453.0

IF IS_CHAR_DEAD lips
	GOTO mission_joey1_passed
ENDIF

TIMERB = 0

IF NOT IS_CHAR_DEAD lips

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED lips
		WAIT 0
		
			IF IS_CAR_DEAD mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF
		   
			IF IS_CAR_UPSIDEDOWN mike_car
			AND IS_CAR_STOPPED mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF

			IF IS_CHAR_DEAD lips
				GOTO mission_joey1_passed
			ENDIF
	
			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES lips 1328.4 -453.0 -100.0
				ENDIF
			ENDIF

	ENDWHILE

ENDIF


TIMERB = 0

IF NOT IS_CHAR_DEAD lips
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lips 1330.0 -466.1
ENDIF

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED lips
		WAIT 0
		
			IF IS_CAR_DEAD mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF
		   
			IF IS_CAR_UPSIDEDOWN mike_car
			AND IS_CAR_STOPPED mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF

			IF IS_CHAR_DEAD lips
				GOTO mission_joey1_passed
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES lips 1330.0 -466.1 -100.0
				ENDIF
			ENDIF
				
	ENDWHILE


TIMERB = 0

IF NOT IS_CHAR_DEAD lips
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lips 1333.6 -465.3
ENDIF

SET_FIXED_CAMERA_POSITION 1344.8 -471.2 54.0 0.0 0.0 0.0

	IF NOT IS_CAR_DEAD mike_car
		POINT_CAMERA_AT_CAR mike_car FIXED JUMP_CUT	
	ENDIF

IF NOT IS_CHAR_DEAD lips

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED lips
		WAIT 0
		
			IF IS_CAR_DEAD mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF
		   
			IF IS_CAR_UPSIDEDOWN mike_car
			AND IS_CAR_STOPPED mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF

			IF IS_CHAR_DEAD lips
				GOTO mission_joey1_passed
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	lips
					SET_CHAR_COORDINATES lips 1333.6 -465.3 -100.0
				ENDIF
			ENDIF
	
	ENDWHILE

ENDIF

IF NOT IS_CHAR_DEAD lips
AND	NOT IS_CAR_DEAD mike_car
	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER lips mike_car
ENDIF

	WHILE NOT IS_CHAR_IN_CAR lips mike_car
		WAIT 0

			IF IS_CAR_DEAD mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF
		   
			IF IS_CAR_UPSIDEDOWN mike_car
			AND IS_CAR_STOPPED mike_car
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey1_failed
			ENDIF

			IF IS_CHAR_DEAD lips
				GOTO mission_joey1_passed
			ENDIF

	ENDWHILE

SET_ALL_CARS_CAN_BE_DAMAGED TRUE

WAIT 2500
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
ADD_SCORE player 10000
mission_passed_for_lips_finished = 1
WAIT 5000

SET_PLAYER_CONTROL Player On
SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER Player Off

}

GOTO mission_joey1_passed


 // Mission joey1 failed

mission_joey1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission joey1 passed

mission_joey1_passed:

flag_joey_mission1_passed = 1

IF mission_passed_for_lips_finished	= 0
	PLAY_MISSION_PASSED_TUNE 1
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
	ADD_SCORE player 10000
	mission_passed_for_lips_finished = 1
ENDIF

REGISTER_MISSION_PASSED JM1
PLAYER_MADE_PROGRESS 1
REMOVE_CHAR_ELEGANTLY lips
START_NEW_SCRIPT joey_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_joey1:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
REMOVE_BLIP blip1_jm1
REMOVE_BLIP blip2_jm1
REMOVE_BLIP blip3_jm1
REMOVE_BLIP blip4_jm1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
UNLOAD_SPECIAL_CHARACTER 3
CLEAR_ONSCREEN_TIMER countdown_jm1
IF NOT IS_CAR_DEAD mike_car
	SET_CAN_RESPRAY_CAR mike_car ON
	LOCK_CAR_DOORS mike_car CARLOCK_UNLOCKED
	MAKE_CRAIGS_CAR_A_BIT_STRONGER mike_car FALSE
ENDIF
SET_FREE_BOMBS Off
MISSION_HAS_FINISHED
RETURN


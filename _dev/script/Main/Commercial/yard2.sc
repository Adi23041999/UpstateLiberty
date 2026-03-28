MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************YARDIE MISSION 2******************************** 
// *****************************************************************************************
// ********************************************'UZI RIDER'**********************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_yd2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_yd2_failed
ENDIF
GOSUB mission_cleanup_yd2

MISSION_END
 
// Variables for mission

VAR_INT gang_car_yd2

VAR_INT chaperone_1 chaperone_2

VAR_INT body_count_yd2

VAR_INT player_yd2 wanted_yd2 flag_clear

VAR_INT blip_driveby_yd2

VAR_INT flag_upsidedown flag_chap_1_n&v flag_chap_2_n&v flag_out_of_car_message

VAR_INT	driveby_total_1 driveby_total_2
VAR_INT timer_dif_yd2 timer_start_yd2 timer_now_yd2	
	

VAR_FLOAT driveby_x driveby_y

VAR_FLOAT yd2turf_x yd2turf_y

VAR_FLOAT y2_x y2_y y2_z
//VAR_FLOAT yd2_x yd2_y yd2_z
//VAR_FLOAT chap_1_x chap_1_y chap_1_z
//VAR_FLOAT chap_2_x chap_2_y chap_2_z


// ****************************************Mission Start************************************

mission_start_yd2:
REGISTER_MISSION_GIVEN
SCRIPT_NAME yard2 
flag_player_on_mission = 1
flag_player_on_yardie_mission = 1
WAIT 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_yd2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//SWITCH_STREAMING OFF

PRINT_BIG ( YD2 ) 15000 2 //"Yardie Mission 1"	 

TIMERA = 0

WHILE TIMERA < 1500					  
	WAIT 0

ENDWHILE
*/

// ******************************************CUTSCENE***************************************



{

SET_PED_DENSITY_MULTIPLIER 0.0
SET_POLICE_IGNORE_PLAYER player on


//WHILE NOT HAS_MODEL_LOADED cut_obj1
//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE YD_PH2
SET_CUTSCENE_OFFSET 121.0 -272.3 15.25
CLEAR_AREA_OF_CHARS 100.5 -250.0 0.0 130.5 -290.0 25.0
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

//CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
//SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

//SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

//SWITCH_STREAMING OFF
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( YD2_A ) 10000 1 

WHILE cs_time < 4581
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD2_A1 ) 10000 1 

WHILE cs_time < 7135
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD2_B ) 10000 1 

WHILE cs_time < 10431
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD2_B1 ) 10000 1 
/*
WHILE cs_time < 13770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD2_D ) 10000 1 

WHILE cs_time < 18676
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD2_D1 ) 10000 1 


WHILE cs_time < 24139
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_G ) 10000 1 

WHILE cs_time < 28919
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_H ) 10000 1 
*/
WHILE cs_time < 13900
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE



DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE


SWITCH_STREAMING ON
CLEAR_PRINTS
CLEAR_CUTSCENE
//SET_CAMERA_IN_FRONT_OF_PLAYER

}

WAIT 0

REQUEST_MODEL CAR_PERENNIAL
REQUEST_MODEL PED_GANG_YARDIE_A
REQUEST_MODEL PED_GANG_YARDIE_B

WHILE NOT HAS_MODEL_LOADED CAR_PERENNIAL
OR NOT HAS_MODEL_LOADED PED_GANG_YARDIE_A
OR NOT HAS_MODEL_LOADED PED_GANG_YARDIE_B
	WAIT 0
ENDWHILE

//PRINT_BIG ( YD2 ) 15000 2

timer_dif_yd2 = 0
flag_out_of_car_message = 0
flag_upsidedown = 0
flag_chap_1_n&v = 0
flag_chap_2_n&v = 0
flag_clear = 0
body_count_yd2 = 0
driveby_total_1 = 0
driveby_total_2 = 0

RESET_NUM_OF_MODELS_KILLED_BY_PLAYER

//------------COORDS-----------------------

driveby_x = 940.0
driveby_y = -220.0

yd2turf_x = 231.0
yd2turf_y = -531.0

//------------------CUTSCENE-------------------------------
STORE_WANTED_LEVEL player wanted_yd2
CLEAR_WANTED_LEVEL player

SET_PLAYER_CONTROL player off
GET_PLAYER_CHAR player player_yd2

SET_FIXED_CAMERA_POSITION 117.3 -266.3 17.0 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
SWITCH_WIDESCREEN on

//clear traffic--------------------------

   // SETUP_ZONE_CAR_INFO STADIUM DAY   (10) (0 0 0) 0 0 0 0 20 300 300 300 0 0 0
   // SETUP_ZONE_CAR_INFO STADIUM NIGHT ( 7) (0 0 0) 0 0 0 0 10 300 300 300 0 0 0

SET_CAR_DENSITY_MULTIPLIER 0.0

/*
PRINT_NOW ( YD2_A ) 4000 1//I need to see if you're capable of doing my dirty work
WAIT 4000

PRINT_NOW ( YD2_B ) 4000 1//A couple of my boys will be there to meet you and take you for a ride.
WAIT 4000
*/
// Mission stuff goes here

//DO_FADE 1500 FADE_OUT
//WAIT 1500

CLEAR_AREA 4.2 -310.1 16.0 40.0 true
CLEAR_AREA 97.0 -285.5 16.0 50.0 true

DO_FADE 1500 FADE_IN
WAIT 1500

CREATE_CAR CAR_PERENNIAL 4.2 -310.1 16.0 gang_car_yd2
SET_CAR_HEADING gang_car_yd2 0.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER gang_car_yd2 True

CREATE_CHAR_INSIDE_CAR gang_car_yd2 PEDTYPE_CIVMALE PED_GANG_YARDIE_A chaperone_1
CREATE_CHAR_AS_PASSENGER gang_car_yd2 PEDTYPE_CIVMALE PED_GANG_YARDIE_B 0 chaperone_2


CAR_GOTO_COORDINATES gang_car_yd2 113.0 -272.0 16.0
SET_CAR_CRUISE_SPEED gang_car_yd2 25.0
SET_CAR_DRIVING_STYLE gang_car_yd2 3



IF NOT IS_CAR_DEAD gang_car_yd2
	POINT_CAMERA_AT_CAR gang_car_yd2 FIXED INTERPOLATION
ENDIF

WHILE NOT LOCATE_STOPPED_CAR_2D gang_car_yd2 113.0 -272.0 5.0 5.0 false
	WAIT 0
	IF IS_CAR_DEAD gang_car_yd2
		GOTO mission_yd2_failed_assert
	ENDIF
	IF flag_clear = 0
		CLEAR_AREA 115.0 -272.0 16.0 10.0 true
		flag_clear = 1
	ENDIF
ENDWHILE

TURN_CHAR_TO_FACE_COORD player_yd2 115.0 -272.0 16.0 

IF NOT IS_CAR_DEAD gang_car_yd2
	CAR_SET_IDLE gang_car_yd2
	IF NOT IS_CHAR_DEAD chaperone_2
	AND NOT IS_CHAR_DEAD chaperone_1
		SET_CHAR_OBJ_LEAVE_CAR chaperone_1 gang_car_yd2
		SET_CHAR_OBJ_LEAVE_CAR chaperone_2 gang_car_yd2
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CHAR_DEAD chaperone_1
AND NOT IS_CAR_DEAD gang_car_yd2
	WHILE IS_CHAR_IN_CAR chaperone_2 gang_car_yd2
	OR IS_CHAR_IN_CAR chaperone_1 gang_Car_yd2
		WAIT 0
		IF IS_CHAR_DEAD chaperone_2
		OR IS_CHAR_DEAD chaperone_1
		OR IS_CAR_DEAD gang_car_yd2
			GOTO mission_yd2_failed_assert
		ENDIF
	ENDWHILE
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

IF NOT IS_CHAR_DEAD	chaperone_2
	POINT_CAMERA_AT_CHAR chaperone_2 FIXED INTERPOLATION
ENDIF

IF NOT IS_CHAR_DEAD	chaperone_1
AND NOT IS_CHAR_DEAD player_yd2
	CHAR_LOOK_AT_CHAR_ALWAYS chaperone_1 player_yd2
ENDIF

plinky_yd2:

WAIT 0

GET_PLAYER_COORDINATES player y2_x y2_y y2_z

IF NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CHAR_DEAD chaperone_1
	SET_CHAR_HEALTH	chaperone_1 100
	SET_CHAR_HEALTH chaperone_2 100
	//y2_x = y2_x + 1.0
	y2_y = y2_y - 1.0
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT chaperone_2 y2_x y2_y
	SET_CHAR_OBJ_WAIT_ON_FOOT chaperone_1
	//GET_CHAR_COORDINATES chaperone_2 yd2_x yd2_y yd2_z
	CHAR_LOOK_AT_CHAR_ALWAYS chaperone_2 player_yd2
	CHAR_LOOK_AT_CHAR_ALWAYS player_yd2 chaperone_2
	IF NOT LOCATE_CHAR_ON_FOOT_2D chaperone_2 y2_X y2_Y 2.0 2.0 false
		GOTO plinky_yd2
	ENDIF
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

IF NOT IS_CHAR_DEAD chaperone_2
	TURN_CHAR_TO_FACE_PLAYER chaperone_2 player
	TURN_CHAR_TO_FACE_CHAR player_yd2 chaperone_2 
	SET_CHAR_OBJ_WAIT_ON_FOOT chaperone_2
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

LOAD_MISSION_AUDIO YD2_A
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW ( YD2_C ) 10000 1//We're going for a little ride into Hepburn Heights, Whack us some Diablo's.
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
CLEAR_PRINTS

IF NOT IS_CHAR_DEAD chaperone_1
	SET_CHAR_HEALTH	chaperone_1 100
ENDIF
IF NOT IS_CHAR_DEAD chaperone_2
	SET_CHAR_HEALTH	chaperone_2 100
ENDIF

LOAD_MISSION_AUDIO YD2_B
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW (YD2_D ) 10000 1//You do the driving and shooting. We'll make sure you don't get cold feet
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
CLEAR_PRINTS

IF NOT IS_CHAR_DEAD chaperone_1
	SET_CHAR_HEALTH	chaperone_1 100
ENDIF
IF NOT IS_CHAR_DEAD chaperone_2
	SET_CHAR_HEALTH	chaperone_2 100
ENDIF

LOAD_MISSION_AUDIO YD2_C
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW (YD2_CC) 10000 1//Here, you'll need a 'piece'
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO poodle
	ENDIF
ENDWHILE
CLEAR_PRINTS

poodle:
STOP_CHAR_LOOKING player_yd2
//SET_CHAR_OBJ_NO_OBJ player_yd2
//SET_PLAYER_CONTROL player on

GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_UZI 150
WAIT 1000
SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_UZI

WHILE NOT IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_UZI
	WAIT 0
ENDWHILE
	

//SET_PLAYER_CONTROL player off

POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION

IF NOT IS_CHAR_DEAD chaperone_1
	SET_CHAR_HEALTH	chaperone_1 100
	STOP_CHAR_LOOKING  chaperone_1
	IF NOT IS_CAR_DEAD gang_car_yd2
		SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER chaperone_1 gang_car_yd2
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD chaperone_2
	SET_CHAR_HEALTH	chaperone_2 100
	CHAR_LOOK_AT_CHAR_ALWAYS chaperone_2 player_yd2
ENDIF

SET_RADIO_CHANNEL JAH_RADIO 0

IF NOT IS_CAR_DEAD gang_car_yd2
	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER player_yd2 gang_car_yd2
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

WHILE NOT IS_CHAR_IN_CAR player_yd2 gang_car_yd2
	WAIT 0
	IF IS_CAR_DEAD gang_car_yd2
		GOTO mission_yd2_failed_assert
	ENDIF
	
	IF NOT IS_CHAR_DEAD chaperone_1
		SET_CHAR_HEALTH	chaperone_1 100
	ENDIF
	IF NOT IS_CHAR_DEAD chaperone_2
		SET_CHAR_HEALTH	chaperone_2 100
	ENDIF
ENDWHILE

IF NOT IS_CAR_DEAD gang_car_yd2
AND NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CHAR_DEAD chaperone_1
	STOP_CHAR_LOOKING chaperone_1
	STOP_CHAR_LOOKING chaperone_2
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER chaperone_2 gang_car_yd2

	WHILE NOT IS_CHAR_IN_CAR chaperone_2 gang_car_yd2
	OR NOT IS_CHAR_IN_CAR chaperone_1 gang_car_yd2
		WAIT 0
		IF IS_CHAR_DEAD chaperone_2
		OR IS_CHAR_DEAD chaperone_1
		OR IS_CAR_DEAD gang_car_yd2
			GOTO mission_yd2_failed_assert
		ENDIF
		IF NOT IS_CHAR_DEAD chaperone_1
			SET_CHAR_HEALTH	chaperone_1 100
		ENDIF
		IF NOT IS_CHAR_DEAD chaperone_2
			SET_CHAR_HEALTH	chaperone_2 100
		ENDIF
	ENDWHILE
	//LOCK_CAR_DOORS gang_car_yd2 CARLOCK_LOCKED
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

IF NOT IS_CAR_DEAD gang_car_yd2
	SET_CAR_ONLY_DAMAGED_BY_PLAYER gang_car_yd2 false
	//LOCK_CAR_DOORS gang_car_yd2 CARLOCK_LOCKED
ENDIF

IF NOT IS_CHAR_DEAD chaperone_1
	SET_CHAR_CANT_BE_DRAGGED_OUT chaperone_1 TRUE
	SET_CHAR_STAYS_IN_CURRENT_LEVEL chaperone_1 FALSE
ENDIF
IF NOT IS_CHAR_DEAD chaperone_2
	SET_CHAR_CANT_BE_DRAGGED_OUT chaperone_2 TRUE
	SET_CHAR_STAYS_IN_CURRENT_LEVEL chaperone_2 FALSE
ENDIF

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on

LOAD_MISSION_AUDIO YD2_C1
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_SOON ( YD2_E ) 4000 1//Let's drive!!
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

ADD_BLIP_FOR_COORD driveby_x driveby_y -100.0 blip_driveby_yd2

SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER player off


//----reset traffic density--------------------------

SET_CAR_DENSITY_MULTIPLIER 1.0

//---------------------SET PED DENSITIES----------------------------------------------------

SETUP_ZONE_PED_INFO	TOWERS DAY   (15) 0 0 700 (0 0 0 0) 20 
SETUP_ZONE_PED_INFO TOWERS NIGHT (10) 0 0 800 (0 0 0 0) 10


//-----------------------GETTING TO THE HIT-------------------------------------------------

ALTER_WANTED_LEVEL player wanted_yd2

getting_there:

IF NOT IS_CAR_DEAD gang_car_yd2
	WHILE NOT IS_PLAYER_IN_ZONE player TOWERS
		WAIT 0

		IF NOT IS_CAR_DEAD gang_car_yd2
			IF IS_CAR_UPSIDEDOWN gang_car_yd2
			AND IS_CAR_STOPPED gang_car_yd2
				flag_upsidedown = 1
				GOTO mission_yd2_failed
			ENDIF
			IF NOT IS_CAR_HEALTH_GREATER gang_car_yd2 250 //NB!! Add Sub spray shop
				IF NOT LOCATE_CAR_3D gang_car_yd2 379.0 -493.7 26.2 15.0 15.0 15.0 false//comm spray shop
				AND NOT LOCATE_CAR_3D gang_car_yd2 925.4 -358.7 10.8 15.0 15.0 15.0 false//ind spray shop
					flag_upsidedown = 1
					GOTO mission_yd2_failed
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
				flag_upsidedown = 2
				GOSUB player_out_of_car
				IF NOT IS_CAR_DEAD gang_car_yd2
					IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
						flag_upsidedown = 2
						GOTO mission_yd2_failed
					ENDIF
				ELSE
					GOTO mission_yd2_failed_assert
				ENDIF
				LOCK_CAR_DOORS gang_car_yd2 CARLOCK_LOCKED
			ENDIF
		ELSE
			GOTO mission_yd2_failed_assert
		ENDIF

	ENDWHILE
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

LOAD_MISSION_AUDIO YD2_F
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW (YD2_G1) 2500 1//Hepburn Heights -Diablo turf.
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO YD2_G
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_SOON (YD2_G2) 2500 1 //"Whack us five Diablos, but remember; you don't leave this car!"
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE


//------------------------------THE HIT-----------------------------------------------------------------

REMOVE_BLIP blip_driveby_yd2 
DISPLAY_ONSCREEN_COUNTER_WITH_STRING body_count_yd2 COUNTER_DISPLAY_NUMBER KILLS

WHILE body_count_yd2 < 10

	WAIT 0
		IF NOT IS_CAR_DEAD gang_car_yd2
			IF IS_CAR_UPSIDEDOWN gang_car_yd2
			AND IS_CAR_STOPPED gang_car_yd2
				flag_upsidedown = 1
				GOTO mission_yd2_failed
			ENDIF
			IF NOT IS_CAR_HEALTH_GREATER gang_car_yd2 250 //NB!! Add Sub spray shop
				IF NOT LOCATE_CAR_3D gang_car_yd2 379.0 -493.7 26.2 15.0 15.0 15.0 false//comm spray shop
				AND NOT LOCATE_CAR_3D gang_car_yd2 925.4 -358.7 10.8 15.0 15.0 15.0 false//ind spray shop
					flag_upsidedown = 1
					GOTO mission_yd2_failed
				ENDIF
			ENDIF
			IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
				GOSUB player_out_of_car
				IF NOT IS_CAR_DEAD gang_car_yd2
					IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
						flag_upsidedown = 2
						GOTO mission_yd2_failed
					ENDIF
				ELSE
					GOTO mission_yd2_failed_assert
				ENDIF
			ENDIF
		ELSE
			GOTO mission_yd2_failed_assert
		ENDIF

		GET_NUM_OF_MODELS_KILLED_BY_PLAYER PED_GANG_DIABLO_A driveby_total_1
		GET_NUM_OF_MODELS_KILLED_BY_PLAYER PED_GANG_DIABLO_B driveby_total_2
		body_count_yd2 = driveby_total_1 + driveby_total_2
		/*
		IF body_count_yd2 > 1
			SET_GANG_PLAYER_ATTITUDE GANG_DIABLO HATES player
			SET_GANG_WEAPONS GANG_DIABLO WEAPONTYPE_BASEBALLBAT WEAPONTYPE_UZI
		ELSE
			SET_GANG_PLAYER_ATTITUDE GANG_DIABLO NEUTRAL player
		ENDIF
		*/
ENDWHILE


//------------------------------------BACK TO YARDIE TURF-------------------------------------------------------
LOAD_MISSION_AUDIO YD2_H
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW (YD2_H) 2500 1//"OK, Get us back to Yardie turf, GO GO GO!!"
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

CLEAR_ONSCREEN_COUNTER body_count_yd2

back_to_yardie_turf:

ADD_BLIP_FOR_COORD yd2turf_x yd2turf_y 26.0 blip_driveby_yd2

IF NOT IS_CAR_DEAD gang_car_yd2
	WHILE NOT LOCATE_STOPPED_CAR_3D gang_car_yd2 yd2turf_x yd2turf_y 26.0 5.0 5.0 5.0 true   
		WAIT 0

			IF NOT IS_CAR_DEAD gang_car_yd2
				IF IS_CAR_UPSIDEDOWN gang_car_yd2
				AND IS_CAR_STOPPED gang_car_yd2
					flag_upsidedown = 1
					GOTO mission_yd2_failed
				ENDIF
				IF NOT IS_CAR_HEALTH_GREATER gang_car_yd2 250 //NB!! Add Sub spray shop
					IF NOT LOCATE_CAR_3D gang_car_yd2 379.0 -493.7 26.2 15.0 15.0 15.0 false//comm spray shop
					AND NOT LOCATE_CAR_3D gang_car_yd2 925.4 -358.7 10.8 15.0 15.0 15.0 false//ind spray shop
						flag_upsidedown = 1
						GOTO mission_yd2_failed
					ENDIF
				ENDIF
				IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
					GOSUB player_out_of_car
					IF NOT IS_CAR_DEAD gang_car_yd2
						IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
							flag_upsidedown = 2
							GOTO mission_yd2_failed
						ENDIF
					ELSE
						GOTO mission_yd2_failed_assert
					ENDIF
				ENDIF
			ELSE
				GOTO mission_yd2_failed_assert
			ENDIF
	ENDWHILE
ELSE
	GOTO mission_yd2_failed_assert
ENDIF
/*
PRINT_NOW (YD2_I) 4000 1//"OK, stop and drop us off."

//REMOVE_BLIP blip_driveby_yd2

IF NOT IS_CAR_DEAD gang_car_yd2
	WHILE NOT IS_CAR_STOPPED_IN_AREA_2D gang_car_yd2 yd2turf_x yd2turf_y 5.0 5.0 true

		WAIT 0
		IF NOT IS_CAR_DEAD gang_car_yd2
			IF NOT LOCATE_CAR_2D gang_car_yd2 yd2turf_x yd2turf_y 30.0 30.0 false
				PRINT_SOON (YD2_J) 4000 1//HEY! Where you going? Get us back to our turf!
				GOTO back_to_yardie_turf
			ENDIF
			IF IS_CAR_UPSIDEDOWN gang_car_yd2
			AND IS_CAR_STOPPED gang_car_yd2
				flag_upsidedown = 1
				GOTO mission_yd2_failed
			ENDIF
			IF NOT IS_CAR_HEALTH_GREATER gang_car_yd2 50
				flag_upsidedown = 1
				GOTO mission_yd2_failed
			ENDIF
			IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
				GOSUB player_out_of_car
				IF NOT IS_CAR_DEAD gang_car_yd2
					IF NOT IS_PLAYER_IN_CAR player gang_car_yd2
						flag_upsidedown = 2
						GOTO mission_yd2_failed
					ENDIF
				ELSE
					GOTO mission_yd2_failed_assert
				ENDIF
			ENDIF
		ELSE
			GOTO mission_yd2_failed_assert
		ENDIF

	ENDWHILE
ELSE
	GOTO mission_yd2_failed_assert
ENDIF
*/
SET_PLAYER_CONTROL player off

IF NOT IS_CHAR_DEAD chaperone_1
AND NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CAR_DEAD	gang_car_yd2
	SET_CAR_HEALTH gang_car_yd2 850
	SET_CHAR_OBJ_LEAVE_CAR chaperone_1 gang_car_yd2
	SET_CHAR_OBJ_LEAVE_CAR chaperone_2 gang_car_yd2
ELSE
	GOTO mission_yd2_failed_assert
ENDIF

LOAD_MISSION_AUDIO YD2_OK
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO
PRINT_NOW (YD2_L) 4000 1//"You did good Reaper Man!"
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player on

GOTO mission_yd2_passed
	   		


// Mission Yardie2 failed


mission_yd2_failed:

IF NOT IS_CHAR_DEAD chaperone_1
AND NOT IS_CAR_DEAD	gang_car_yd2
	SET_CHAR_OBJ_LEAVE_CAR chaperone_1 gang_car_yd2
ENDIF
IF NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CAR_DEAD	gang_car_yd2
	SET_CHAR_OBJ_LEAVE_CAR chaperone_2 gang_car_yd2
ENDIF

IF flag_upsidedown = 1
	LOAD_MISSION_AUDIO YD2_D
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE
	PLAY_MISSION_AUDIO
	PRINT_NOW (YD2_M) 4000 1//"He's wrecked my car!! Waste him!!"
ENDIF

IF flag_upsidedown = 2
	LOAD_MISSION_AUDIO YD2_E
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE
	PLAY_MISSION_AUDIO
	PRINT_NOW (YD2_F) 4000 1//"He's bailing out on us!"
ENDIF

IF NOT IS_CHAR_DEAD chaperone_1
AND NOT IS_CAR_DEAD gang_car_yd2
	WHILE IS_CHAR_IN_CAR chaperone_1 gang_car_yd2
		WAIT 0
		IF IS_CHAR_DEAD chaperone_1
			GOTO boddle
		ENDIF
		IF IS_CAR_DEAD gang_car_yd2
			GOTO boddle
		ENDIF
	ENDWHILE
ENDIF

boddle:
IF NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CAR_DEAD gang_car_yd2
	WHILE IS_CHAR_IN_CAR chaperone_2 gang_car_yd2
		WAIT 0
		IF IS_CHAR_DEAD chaperone_2
			GOTO mission_yd2_failed_assert
		ENDIF
		IF IS_CAR_DEAD gang_car_yd2
			GOTO mission_yd2_failed_assert
		ENDIF
	ENDWHILE
ENDIF

IF NOT IS_CHAR_DEAD chaperone_1
	GIVE_WEAPON_TO_CHAR chaperone_1 WEAPONTYPE_SHOTGUN 10
	WHILE NOT IS_CURRENT_CHAR_WEAPON chaperone_1 WEAPONTYPE_SHOTGUN
		WAIT 0
		IF IS_CHAR_DEAD	chaperone_1
			GOTO oink
		ENDIF
	ENDWHILE
	IF NOT IS_CHAR_DEAD chaperone_1
		TURN_CHAR_TO_FACE_PLAYER chaperone_1 player
		IF IS_PLAYER_IN_ZONE player TOWERS
			SET_CHAR_THREAT_SEARCH chaperone_1 THREAT_GANG_DIABLO
		ENDIF
		SET_CHAR_THREAT_SEARCH chaperone_1 THREAT_PLAYER1
	ENDIF
ENDIF

oink:

IF NOT IS_CHAR_DEAD chaperone_2
	GIVE_WEAPON_TO_CHAR chaperone_2 WEAPONTYPE_UZI 30
	WHILE NOT IS_CURRENT_CHAR_WEAPON chaperone_2 WEAPONTYPE_UZI
		WAIT 0
		IF IS_CHAR_DEAD	chaperone_2
			GOTO poink
		ENDIF
	ENDWHILE
	IF NOT IS_CHAR_DEAD chaperone_2
		TURN_CHAR_TO_FACE_PLAYER chaperone_2 player
		IF IS_PLAYER_IN_ZONE player TOWERS
			SET_CHAR_THREAT_SEARCH chaperone_2 THREAT_GANG_DIABLO
		ENDIF
		SET_CHAR_THREAT_SEARCH chaperone_2 THREAT_PLAYER1
	ENDIF
ENDIF

poink:
/*
//Yardies chase player off!!

WHILE NOT IS_PLAYER_DEAD player
	WAIT 0
	IF NOT IS_CHAR_DEAD	chaperone_1
		GET_CHAR_COORDINATES chaperone_1 chap_1_x chap_1_y chap_1_z
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player chap_1_x chap_1_y 30.0 30.0 false
			MARK_CHAR_AS_NO_LONGER_NEEDED chaperone_1
			flag_chap_1_n&v = 1
		ENDIF
	ELSE
		flag_chap_1_n&v = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	chaperone_2
		GET_CHAR_COORDINATES chaperone_2 chap_2_x chap_2_y chap_2_z
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player chap_2_x chap_2_y 30.0 30.0 false
			MARK_CHAR_AS_NO_LONGER_NEEDED chaperone_2
			flag_chap_2_n&v = 1
		ENDIF
	ELSE
		flag_chap_2_n&v = 1
	ENDIF
	IF flag_chap_1_n&v = 1
	AND flag_chap_2_n&v = 1
		GOTO mission_yd2_failed_assert
	ENDIF

ENDWHILE
*/		
mission_yd2_failed_assert:

PRINT_BIG ( M_FAIL ) 2000 1

RETURN   

// mission yd2 passed

mission_yd2_passed:

flag_yardie_mission2_passed = 1

IF NOT IS_CHAR_DEAD chaperone_1
AND NOT IS_CHAR_DEAD chaperone_2
AND NOT IS_CAR_DEAD	gang_car_yd2
	WHILE IS_CHAR_IN_CAR chaperone_1 gang_car_yd2
	OR IS_CHAR_IN_CAR chaperone_2 gang_car_yd2
		WAIT 0
		IF IS_CHAR_DEAD chaperone_1
		OR IS_CHAR_DEAD chaperone_2
		OR IS_CAR_DEAD	gang_car_yd2
			GOTO filby
		ENDIF
	ENDWHILE
ELSE
	GOTO filby
ENDIF

filby:
IF NOT IS_CHAR_DEAD	chaperone_1
	SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE chaperone_1
ENDIF
IF NOT IS_CHAR_DEAD	chaperone_2
	SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE chaperone_2
ENDIF


PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED YD2
PLAYER_MADE_PROGRESS 1 
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_DIABLO THREAT_PLAYER1
START_NEW_SCRIPT yardie_mission3_loop
RETURN
		

			   
// mission cleanup

mission_cleanup_yd2:

REMOVE_BLIP blip_driveby_yd2

flag_player_on_mission = 0
flag_player_on_yardie_mission = 0
CLEAR_ONSCREEN_COUNTER body_count_yd2
REMOVE_BLIP blip_driveby_yd2
//SET_PLAYER_CONTROL player on
SWITCH_WIDESCREEN off
RESTORE_CAMERA_JUMPCUT
IF NOT IS_CAR_DEAD gang_car_yd2
	LOCK_CAR_DOORS gang_car_yd2 CARLOCK_UNLOCKED
ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_B

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PERENNIAL

//------------RESTORE PED DENSITIES---------------------------------------

SETUP_ZONE_PED_INFO	TOWERS DAY   (15) 0 0 300 (0 0 0 0) 20 
SETUP_ZONE_PED_INFO TOWERS NIGHT (10) 0 0 500 (0 0 0 0) 10

MISSION_HAS_FINISHED
RETURN
		
//-----------------------------GOSUBS----------------------------------------------

player_out_of_car:
	IF NOT IS_CAR_DEAD gang_car_yd2
		LOCK_CAR_DOORS gang_car_yd2 CARLOCK_UNLOCKED
	ENDIF
	WHILE timer_dif_yd2 < 7500
		WAIT 0
		IF NOT IS_CAR_DEAD gang_car_yd2
			IF NOT IS_CAR_HEALTH_GREATER gang_car_yd2 250 //NB!! Add Sub spray shop
				IF NOT LOCATE_CAR_3D gang_car_yd2 379.0 -493.7 26.2 15.0 15.0 15.0 false//comm spray shop
				AND NOT LOCATE_CAR_3D gang_car_yd2 925.4 -358.7 10.8 15.0 15.0 15.0 false//ind spray shop
					flag_upsidedown = 1
					GOTO mission_yd2_failed
				ENDIF
			ENDIF
			IF flag_out_of_car_message = 0
				LOAD_MISSION_AUDIO YD2_ASS
				WHILE NOT HAS_MISSION_AUDIO_LOADED
					WAIT 0
				ENDWHILE
				PLAY_MISSION_AUDIO
				PRINT_NOW (YD2_N) 3000 1//you got five seconds to get back in this car.
				flag_out_of_car_message = 1
				GET_GAME_TIMER timer_start_yd2
			ENDIF
			GET_GAME_TIMER timer_now_yd2
			timer_dif_yd2 = timer_now_yd2 - timer_start_yd2
			
			IF NOT IS_CAR_DEAD gang_car_yd2
				IF IS_PLAYER_IN_CAR player gang_car_yd2
					flag_out_of_car_message = 0
					RETURN
				ENDIF
			ENDIF
		ENDIF
	ENDWHILE
	
	LOCK_CAR_DOORS gang_car_yd2 CARLOCK_LOCKED

RETURN

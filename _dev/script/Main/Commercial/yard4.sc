MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Yardie mission 4******************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_yardie4
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_yd4_failed
ENDIF
GOSUB mission_cleanup_yardie4
MISSION_END
 
// Variables for mission

VAR_INT abandoned_car_y4 flag_van1_arrived

VAR_INT timer_y4

VAR_INT blip_abandoned_car_y4

VAR_INT gen1_van gen2_van gen3_van gen4_van

VAR_INT human_bomb_1
//VAR_INT human_bomb_2
//VAR_INT human_bomb_3
VAR_INT human_bomb_4
//VAR_INT human_bomb_5
//VAR_INT human_bomb_6
VAR_INT human_bomb_7
//VAR_INT human_bomb_8
VAR_INT human_bomb_9
VAR_INT human_bomb_demo

VAR_INT blip_bomber_1 blip_bomber_4 blip_bomber_7 blip_bomber_9

VAR_INT flag_bomb1_active
VAR_INT flag_bomb4_active
VAR_INT flag_bomb7_active
VAR_INT flag_bomb9_active

//VAR_INT counter_bomb1 counter_bomb4 counter_bomb7
//VAR_INT counter_bomb9

//VAR_INT bomber_collective_1 bomber_collective_2 bomber_collective_3


//CO-ORD VARIABLES*****************************************************

VAR_FLOAT gen1_x gen1_y //gen1_z
VAR_FLOAT gen2_x gen2_y //gen2_z
VAR_FLOAT gen3_x gen3_y //gen3_z
VAR_FLOAT gen4_x gen4_y //gen4_z

VAR_FLOAT abandoned_car_x abandoned_car_y //abandoned_car_z

VAR_FLOAT y4_x y4_y y4_z

VAR_FLOAT bomb_x bomb_y bomb_z
VAR_FLOAT bomb4_x bomb4_y bomb4_z
VAR_FLOAT bomb7_x bomb7_y bomb7_z
VAR_FLOAT bomb9_x bomb9_y bomb9_z




// ****************************************Mission Start************************************

mission_start_yardie4:
REGISTER_MISSION_GIVEN
SCRIPT_NAME yard4 
flag_player_on_mission = 1
flag_player_on_yardie_mission = 1

WAIT 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_yd4_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//SWITCH_STREAMING OFF

PRINT_BIG ( YD4 ) 15000 2 //"Yardie Mission 4"	 

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

LOAD_CUTSCENE YD_PH4
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
PRINT_NOW ( YD4_A ) 10000 1 

WHILE cs_time < 3000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD4_A1 ) 10000 1 

WHILE cs_time < 5322
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD4_A2 ) 10000 1 
/*
WHILE cs_time < 10759
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD4_C ) 10000 1 

WHILE cs_time < 13770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD4_D ) 10000 1 

WHILE cs_time < 18676
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD4_D1 ) 10000 1 


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
WHILE cs_time < 8600
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

WAIT 500

SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER player off

DO_FADE 1500 FADE_IN
}



flag_van1_arrived = 0

flag_bomb1_active = 0
flag_bomb4_active = 0
flag_bomb7_active = 0
flag_bomb9_active = 0
gen1_x = -113.62
gen1_y = -1420.5
gen2_x = -90.54
gen2_y = -1480.0
gen3_x = -38.4
gen3_y = -1447.0
gen4_x = -53.2
gen4_y = -1501.0

//counter_bomb1 = 0
//counter_bomb4 = 0
//counter_bomb7 = 0
//counter_bomb9 = 0


abandoned_car_x = -71.5
abandoned_car_y = -1471.0


REQUEST_MODEL CAR_ESPERANTO
REQUEST_MODEL CAR_PONY
WHILE NOT HAS_MODEL_LOADED CAR_ESPERANTO
OR NOT HAS_MODEL_LOADED CAR_PONY
	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 bomber
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE


//PRINT_BIG ( YD4 ) 15000 2

//WAIT 1000




//PRINT_NOW ( YD4_A ) 8000 2

//WAIT 8000

timer_y4 = 90000

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

DISPLAY_ONSCREEN_TIMER timer_y4

create_car_yd5:

CREATE_CAR CAR_ESPERANTO abandoned_car_x abandoned_car_y -100.0 abandoned_car_y4
SET_CAR_HEADING abandoned_car_y4 270.0
CAR_SET_IDLE abandoned_car_y4
ADD_BLIP_FOR_CAR abandoned_car_y4 blip_abandoned_car_y4

CREATE_CAR CAR_PONY gen2_x gen2_y 27.0 gen2_van
SET_CAR_HEADING gen2_van 345.0
CAR_SET_IDLE gen2_van
LOCK_CAR_DOORS gen2_van CARLOCK_LOCKOUT_PLAYER_ONLY


// Mission stuff goes here

IF NOT IS_CAR_DEAD abandoned_car_y4
	WHILE NOT IS_PLAYER_IN_CAR player abandoned_car_y4
		WAIT 0
		IF timer_y4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_yd4_failed
		ENDIF
		IF IS_CAR_DEAD abandoned_car_y4
			PRINT_NOW (WRECKED) 3000 1
			GOTO mission_yd4_failed
		ENDIF
	ENDWHILE
ELSE
	PRINT_NOW (WRECKED) 3000 1
	GOTO mission_yd4_failed
ENDIF

REMOVE_BLIP blip_abandoned_car_y4
SET_PLAYER_CONTROL player Off 
CLEAR_ONSCREEN_TIMER timer_y4

CLEAR_AREA -113.4 -1431.5 26.0 20.0 true

CREATE_CAR CAR_PONY gen1_x gen1_y 26.2 gen1_van
SET_CAR_HEADING gen1_van 180.0
CAR_SET_IDLE gen1_van
LOCK_CAR_DOORS gen1_van CARLOCK_LOCKOUT_PLAYER_ONLY
CREATE_CHAR_AS_PASSENGER gen1_van PEDTYPE_SPECIAL PED_SPECIAL1 0 human_bomb_demo

CREATE_CAR CAR_PONY gen3_x gen3_y 26.2 gen3_van
SET_CAR_HEADING gen3_van 90.0
CAR_SET_IDLE gen3_van
LOCK_CAR_DOORS gen3_van CARLOCK_LOCKOUT_PLAYER_ONLY

CREATE_CAR CAR_PONY gen4_x gen4_y 26.2 gen4_van
SET_CAR_HEADING gen4_van 90.0
CAR_SET_IDLE gen4_van
LOCK_CAR_DOORS gen4_van CARLOCK_LOCKOUT_PLAYER_ONLY


SET_FIXED_CAMERA_POSITION -82.0 -1472.0 27.5 0.0 0.0 0.0
IF NOT IS_CAR_DEAD abandoned_car_y4
	POINT_CAMERA_AT_CAR abandoned_car_y4 FIXED JUMP_CUT
ENDIF
//POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
SWITCH_WIDESCREEN on


PRINT_NOW (YD4_B ) 3500 2
MESSAGE_WAIT 3500 true

PRINT_NOW (YD4_C) 3500 2
MESSAGE_WAIT 3500 true

PRINT_NOW (YD4_D) 2500 2
MESSAGE_WAIT 2500 true

IF NOT IS_CAR_DEAD gen1_van
	CAR_GOTO_COORDINATES_ACCURATE gen1_van -113.2 -1442.5 26.2
	POINT_CAMERA_AT_CAR gen1_van FIXED INTERPOLATION
ENDIF
IF NOT IS_CAR_DEAD gen3_van
	CAR_GOTO_COORDINATES gen3_van -53.5 -1446.7 26.2
ENDIF

WHILE flag_van1_arrived = 0
	WAIT 0
	IF NOT IS_CAR_DEAD gen1_van
		IF  LOCATE_CAR_2D gen1_van -113.2 -1442.5 4.0 4.0 false
			flag_van1_arrived = 1
		ENDIF
	ELSE
		GOTO mission_yd4_failed
	ENDIF
ENDWHILE 

IF NOT IS_CAR_DEAD gen1_van
AND NOT IS_CHAR_DEAD human_bomb_demo
	SET_CHAR_OBJ_LEAVE_CAR human_bomb_demo gen1_van
	WHILE IS_CHAR_IN_CAR human_bomb_demo gen1_van
		WAIT 0
		IF NOT IS_CHAR_DEAD human_bomb_demo
			GET_CHAR_COORDINATES human_bomb_demo bomb_z bomb_y bomb_z
		ENDIF
		IF IS_CHAR_DEAD human_bomb_demo
			GOTO selkirk
		ENDIF
		IF IS_CAR_DEAD gen1_van
			GOTO selkirk
		ENDIF
	ENDWHILE
ENDIF

SET_CHAR_HEADING human_bomb_demo 180.0 
SET_FIXED_CAMERA_POSITION -115.76 -1455.0 25.9 0.0 0.0 0.0
CHAR_SET_IDLE human_bomb_demo
POINT_CAMERA_AT_CHAR human_bomb_demo FIXED JUMP_CUT
//SET_CAMERA_ZOOM CAM_ZOOM_TWO
PRINT_NOW (YD4_1) 3000 1

IF NOT IS_CHAR_DEAD human_bomb_demo
	SET_CHAR_OBJ_RUN_TO_COORD human_bomb_demo -114.5 -1452.4
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D human_bomb_demo -114.5 -1452.4 3.0 3.0 0
		WAIT 0
		IF NOT IS_CHAR_DEAD human_bomb_demo
			GET_CHAR_COORDINATES human_bomb_demo bomb_x bomb_y bomb_z
		ELSE
			GOTO selkirk
		ENDIF
	ENDWHILE
ENDIF

WAIT 3000

IF NOT IS_CHAR_DEAD human_bomb_demo
GET_PLAYER_COORDINATES player y4_x y4_y y4_z
POINT_CAMERA_AT_CHAR human_bomb_demo FOLLOWPED INTERPOLATION
	SET_CHAR_OBJ_RUN_TO_COORD human_bomb_demo y4_x y4_y
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D human_bomb_demo y4_x y4_y 5.0 5.0 0
		WAIT 0
		IF NOT IS_CHAR_DEAD human_bomb_demo
			GET_CHAR_COORDINATES human_bomb_demo bomb_x bomb_y bomb_z
		ENDIF
		IF IS_CHAR_DEAD human_bomb_demo
			GOTO selkirk
		ENDIF
	ENDWHILE
ENDIF

selkirk:
ADD_EXPLOSION bomb_x bomb_y bomb_z EXPLOSION_GRENADE
ADD_ONE_OFF_SOUND bomb_x bomb_y bomb_z sound_test_1
SHAKE_CAM 500

WAIT 1000

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on
WAIT 0
MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_demo
PRINT_NOW (YD4_2) 3000 1

// Bomber generation loop

GOTO le_loop_de_mort

// GENERATORS*****GENERATORS*****GENERATORS*****GENERATORS*****GENERATORS*****GENERATORS*****

//111111111111111111111111111111111111111111111111111111111111111111111
generator_1_easy:
			
IF NOT IS_CAR_DEAD gen1_van

	CREATE_CHAR_AS_PASSENGER gen1_van PEDTYPE_SPECIAL PED_SPECIAL1 0 human_bomb_1
	flag_bomb1_active = 1
	SET_CHAR_OBJ_LEAVE_CAR human_bomb_1 gen1_van
	ADD_BLIP_FOR_CHAR human_bomb_1 blip_bomber_1

	WHILE IS_CHAR_IN_CAR human_bomb_1 gen1_van
		GET_CHAR_COORDINATES human_bomb_1 bomb_x bomb_y bomb_z
		WAIT 0
		IF IS_CHAR_DEAD human_bomb_1
		OR IS_CAR_DEAD gen1_van
			RETURN
		ENDIF
	ENDWHILE
ENDIF

RETURN




//222222222222222222222222222222222222222222222222222222222222222222222222
generator_2_easy:

IF NOT IS_CAR_DEAD gen2_van

	CREATE_CHAR_AS_PASSENGER gen2_van PEDTYPE_SPECIAL PED_SPECIAL1 0 human_bomb_4
	flag_bomb4_active = 1
	SET_CHAR_OBJ_LEAVE_CAR human_bomb_4 gen2_van
	ADD_BLIP_FOR_CHAR human_bomb_4 blip_bomber_4


	WHILE IS_CHAR_IN_CAR human_bomb_4 gen2_van
		GET_CHAR_COORDINATES human_bomb_4 bomb4_x bomb4_y bomb4_z
		WAIT 0
		IF IS_CHAR_DEAD human_bomb_4
		OR IS_CAR_DEAD gen2_van
			RETURN
		ENDIF
	ENDWHILE
ENDIF

RETURN

//333333333333333333333333333333333333333333333333333333333333333333333333
generator_3_easy:

IF NOT IS_CAR_DEAD gen3_van

	CREATE_CHAR_AS_PASSENGER gen3_van PEDTYPE_SPECIAL PED_SPECIAL1 0 human_bomb_7
	flag_bomb7_active = 1
	SET_CHAR_OBJ_LEAVE_CAR human_bomb_7 gen3_van
	ADD_BLIP_FOR_CHAR human_bomb_7 blip_bomber_7

	WHILE IS_CHAR_IN_CAR human_bomb_7 gen3_van
		GET_CHAR_COORDINATES human_bomb_7 bomb7_x bomb7_y bomb7_z
		WAIT 0
		IF IS_CHAR_DEAD human_bomb_7
		OR IS_CAR_DEAD gen3_van
			RETURN
		ENDIF
	ENDWHILE
ENDIF

RETURN

//444444444444444444444444444444444444444444444444444444444444444444444444
generator_4_easy:

IF NOT IS_CAR_DEAD gen4_van

	CREATE_CHAR_AS_PASSENGER gen4_van PEDTYPE_SPECIAL PED_SPECIAL1 0 human_bomb_9
	flag_bomb9_active = 1
	SET_CHAR_OBJ_LEAVE_CAR human_bomb_9 gen4_van
	ADD_BLIP_FOR_CHAR human_bomb_9 blip_bomber_9

	WHILE IS_CHAR_IN_CAR human_bomb_9 gen4_van
		GET_CHAR_COORDINATES human_bomb_9 bomb9_x bomb9_y bomb9_z
		WAIT 0
		IF IS_CHAR_DEAD human_bomb_9
		OR IS_CAR_DEAD gen4_van
			RETURN
		ENDIF
	ENDWHILE
ENDIF

RETURN

// MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****MAIN LOOP*****

le_loop_de_mort:

WAIT 0


IF flag_bomb1_active = 0
	GOSUB generator_1_easy
ELSE
	IF NOT IS_CHAR_DEAD	human_bomb_1
		GET_PLAYER_COORDINATES player y4_x y4_y y4_z
		SET_CHAR_OBJ_RUN_TO_COORD human_bomb_1 y4_x y4_y
		GET_CHAR_COORDINATES human_bomb_1 bomb_x bomb_y bomb_z
		CLEAR_CHAR_THREAT_SEARCH human_bomb_1
		IF LOCATE_CHAR_ANY_MEANS_3D human_bomb_1 y4_x y4_y y4_z 3.0 3.0 4.0 0
		OR NOT IS_CHAR_HEALTH_GREATER human_bomb_1 95
		   GOSUB detonate_1
		   MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_1
		   flag_bomb1_active = 0	
		   GOSUB generator_1_easy
		ENDIF
	ELSE
		GOSUB detonate_1
		MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_1
		flag_bomb1_active = 0	
	ENDIF
ENDIF


IF flag_bomb4_active = 0
	GOSUB generator_2_easy
ELSE
	IF NOT IS_CHAR_DEAD human_bomb_4
		GET_PLAYER_COORDINATES player y4_x y4_y y4_z
		SET_CHAR_OBJ_RUN_TO_COORD human_bomb_4 y4_x y4_y
		GET_CHAR_COORDINATES human_bomb_4 bomb4_x bomb4_y bomb4_z
		CLEAR_CHAR_THREAT_SEARCH human_bomb_4
		IF LOCATE_CHAR_ANY_MEANS_3D human_bomb_4 y4_x y4_y y4_z 3.0 3.0 4.0 0
		OR NOT IS_CHAR_HEALTH_GREATER human_bomb_4 95
		   GOSUB detonate_4	
		   MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_4
		   flag_bomb4_active = 0
		ENDIF
	ELSE
		GOSUB detonate_4
		MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_4
		flag_bomb4_active = 0	
	ENDIF
ENDIF


IF flag_bomb7_active = 0
	GOSUB generator_3_easy
ELSE
	IF NOT IS_CHAR_DEAD human_bomb_7
		GET_PLAYER_COORDINATES player y4_x y4_y y4_z
		SET_CHAR_OBJ_RUN_TO_COORD human_bomb_7 y4_x y4_y
		GET_CHAR_COORDINATES human_bomb_7 bomb7_x bomb7_y bomb7_z
		CLEAR_CHAR_THREAT_SEARCH human_bomb_7
		IF LOCATE_CHAR_ANY_MEANS_3D human_bomb_7 y4_x y4_y y4_z 3.0 3.0 4.0 0
		OR NOT IS_CHAR_HEALTH_GREATER human_bomb_7 95
		   GOSUB detonate_7
		   MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_7
		   flag_bomb7_active = 0
		ENDIF
	ELSE
		GOSUB detonate_7
		MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_7
		flag_bomb7_active = 0	
	ENDIF
ENDIF


IF flag_bomb9_active = 0
	GOSUB generator_4_easy
ELSE
	IF NOT IS_CHAR_DEAD human_bomb_9
		GET_PLAYER_COORDINATES player y4_x y4_y y4_z
		GET_CHAR_COORDINATES human_bomb_9 bomb9_x bomb9_y bomb9_z
		CLEAR_CHAR_THREAT_SEARCH human_bomb_9
		SET_CHAR_OBJ_RUN_TO_COORD human_bomb_9 y4_x y4_y
		IF LOCATE_CHAR_ANY_MEANS_3D human_bomb_9 y4_x y4_y y4_z 3.0 3.0 4.0 0
		OR NOT IS_CHAR_HEALTH_GREATER human_bomb_9 95
		   GOSUB detonate_9
		   MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_9
		   flag_bomb9_active = 0
		ENDIF
	ELSE
		GOSUB detonate_9
		MARK_CHAR_AS_NO_LONGER_NEEDED human_bomb_9
		flag_bomb9_active = 0	
	ENDIF
ENDIF


IF IS_CAR_DEAD gen1_van
AND IS_CAR_DEAD gen2_van
AND IS_CAR_DEAD gen3_van
AND IS_CAR_DEAD gen4_van
	IF IS_CHAR_DEAD human_bomb_1
	AND IS_CHAR_DEAD human_bomb_4
	AND IS_CHAR_DEAD human_bomb_7
	AND IS_CHAR_DEAD human_bomb_9
		GOTO mission_yardie4_passed
	ENDIF
ENDIF

GOTO le_loop_de_mort


// DETONATIONS*****DETONATIONS*****DETONATIONS*****DETONATIONS*****DETONATIONS*****DETONATIONS*****DETONATIONS*****

detonate_1:
	IF flag_bomb1_active = 1
		ADD_EXPLOSION bomb_x bomb_y bomb_z EXPLOSION_GRENADE
		ADD_ONE_OFF_SOUND bomb_x bomb_y bomb_z sound_test_1
		SHAKE_CAM 500
		flag_bomb1_active = 0
		REMOVE_BLIP blip_bomber_1

	ENDIF
RETURN

detonate_4:
	IF flag_bomb4_active = 1
		ADD_EXPLOSION bomb4_x bomb4_y bomb4_z EXPLOSION_GRENADE
		ADD_ONE_OFF_SOUND bomb4_x bomb4_y bomb4_z sound_test_1
		SHAKE_CAM 500		  
		REMOVE_BLIP blip_bomber_4

	ENDIF
RETURN

detonate_7:
	IF flag_bomb7_active = 1
		ADD_EXPLOSION bomb7_x bomb7_y bomb7_z EXPLOSION_GRENADE
		ADD_ONE_OFF_SOUND bomb7_x bomb7_y bomb7_z sound_test_1
		SHAKE_CAM 500
		flag_bomb7_active = 0
		REMOVE_BLIP blip_bomber_7

	ENDIF
RETURN

detonate_9:
	IF flag_bomb9_active = 1
		ADD_EXPLOSION bomb9_x bomb9_y bomb9_z EXPLOSION_GRENADE
		ADD_ONE_OFF_SOUND bomb9_x bomb9_y bomb9_z sound_test_1
		SHAKE_CAM 500
		flag_bomb9_active = 0
		REMOVE_BLIP blip_bomber_9

	ENDIF
RETURN








	   		



// Mission yardie4 failed

mission_yd4_failed:

PRINT_BIG ( M_FAIL ) 2000 1

RETURN

   

// mission yardie4 passed

mission_yardie4_passed:

flag_yardie_mission4_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED YD4
PLAYER_MADE_PROGRESS 1 
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_YARDIE THREAT_PLAYER1

REMOVE_BLIP	yardie_contact_blip
START_NEW_SCRIPT yardie_mission1_loop
flag_yardie_mission1_passed = 0
RETURN
		


// mission cleanup

mission_cleanup_yardie4:

flag_player_on_mission = 0

flag_player_on_yardie_mission = 0
REMOVE_BLIP blip_abandoned_car_y4
CLEAR_ONSCREEN_TIMER timer_y4
UNLOAD_SPECIAL_CHARACTER 1 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_SPECIAL1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ESPERANTO
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PONY
MISSION_HAS_FINISHED
RETURN
		



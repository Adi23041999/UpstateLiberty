MISSION_START
// *****************************************************************************************
// *********************************    Love mission 2   *********************************** 
// *********************************  Assassinate Kenji  ***********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_love2_failed
ENDIF

GOSUB mission_cleanup_love2

MISSION_END
 
// Variables for mission


VAR_FLOAT carpark_minx carpark_miny carpark_maxx carpark_maxy
VAR_FLOAT carpark_minz carpark_maxz

VAR_INT blip_carpark blip_kenji_love2
VAR_INT flag_carpark_blip

//VAR_INT test_car_love2//test stuff

VAR_INT flag_kenji_dead flag_yak_created_love2 flag_wanted_love2 flag_kenji_look
VAR_INT flag_message flag_yak_attack_love2 flag_player_clear flag_kenji_cut
VAR_INT timer_kenji_cut_start timer_kenji_cut_dif timer_kenji_cut_now

VAR_INT kenji_car_love2 yak_car_1_love2 yak_car_2_love2
VAR_INT yak_1_love2 yak_2_love2 yak_3_love2 yak_4_love2
VAR_INT yak_5_love2 yak_6_love2 yak_7_love2 yak_8_love2
VAR_INT counter_kenji_guards_dead
VAR_INT flag_1_dead_love2 flag_2_dead_love2 flag_3_dead_love2 flag_4_dead_love2
VAR_INT flag_5_dead_love2 flag_6_dead_love2 flag_7_dead_love2 flag_8_dead_love2
//VAR_INT flag_1_dead_love2 flag_1_dead_love2 flag_1_dead_love2 flag_1_dead_love2

//VAR_INT yak_9_love2 yak_10_love2 yak_11_love2 yak_12_love2

//VAR_INT kenji


//+++++++++++++++++++++++++++CREATE PEDS GOSUB++++++++++++++++++++++++++++++++++++++++++++
create_yakuza:

IF flag_yak_created_love2 = 0
		CREATE_CAR CAR_YAKUZA 302.0 -550.0 37.0 kenji_car_love2
		SET_CAR_HEADING kenji_car_love2 90.0
		CAR_SET_IDLE kenji_car_love2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER kenji_car_love2 False

		CREATE_CAR CAR_STRETCH 291.4 -547.0 37.0 yak_car_1_love2
		SET_CAR_HEADING yak_car_1_love2 320.0
		CAR_SET_IDLE yak_car_1_love2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER yak_car_1_love2 False
	
		CREATE_CAR CAR_YAKUZA 294.6 -558.0 37.0 yak_car_2_love2
		SET_CAR_HEADING yak_car_2_love2 96.0
		CAR_SET_IDLE yak_car_2_love2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER yak_car_2_love2 False
		
		CREATE_CAR CAR_STRETCH 299.4 -540.0 37.0 yak_car_1_love2
		SET_CAR_HEADING yak_car_1_love2 296.0
		CAR_SET_IDLE yak_car_1_love2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER yak_car_1_love2 False

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 286.4 -543.5 37.0 yak_1_love2
		SET_CHAR_HEADING yak_1_love2 180.0
		//SET_CHAR_OBJ_GUARD_AREA yak_1_love2 267.7 -592.0 306.0 -480.0

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B 304.5 -544.3 37.0 yak_2_love2
		SET_CHAR_HEADING yak_2_love2 40.0
		//SET_CHAR_OBJ_GUARD_AREA yak_2_love2 MinX MinY MaxX MaxY
		ADD_ARMOUR_TO_CHAR yak_2_love2 100

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 299.25 -534.0 37.0 yak_3_love2
		SET_CHAR_HEADING yak_3_love2 20.0
		//SET_CHAR_OBJ_GUARD_AREA yak_3_love2 MinX MinY MaxX MaxY

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B 295.0 -562.0 37.0 yak_4_love2
		SET_CHAR_HEADING yak_4_love2 180.0
		//SET_CHAR_OBJ_GUARD_AREA yak_4_love2 MinX MinY MaxX MaxY

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 295.0 -544.0 37.0 yak_5_love2
		SET_CHAR_HEADING yak_5_love2 15.0
		//SET_CHAR_OBJ_GUARD_AREA yak_5_love2 267.7 -592.0 306.0 -480.0
		ADD_ARMOUR_TO_CHAR yak_5_love2 100

		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B 300.0 -556.0 37.0 yak_6_love2
		SET_CHAR_HEADING yak_6_love2 160.0
		//SET_CHAR_OBJ_GUARD_AREA yak_4_love2 MinX MinY MaxX MaxY
		
		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B 301.0 -516.0 37.0 yak_7_love2
		SET_CHAR_HEADING yak_7_love2 45.0
		//SET_CHAR_OBJ_GUARD_AREA yak_4_love2 MinX MinY MaxX MaxY
		
		CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B 273.0 -570.0 37.0 yak_8_love2
		SET_CHAR_HEADING yak_8_love2 260.0
		//SET_CHAR_OBJ_GUARD_AREA yak_4_love2 MinX MinY MaxX MaxY

		GIVE_WEAPON_TO_CHAR yak_1_love2 WEAPONTYPE_M16 80
		GIVE_WEAPON_TO_CHAR yak_2_love2 WEAPONTYPE_UZI 60
		GIVE_WEAPON_TO_CHAR yak_3_love2 WEAPONTYPE_UZI 60
		SET_CHAR_ACCURACY yak_3_love2 40
		GIVE_WEAPON_TO_CHAR yak_4_love2 WEAPONTYPE_UZI 60
		SET_CHAR_ACCURACY yak_4_love2 40
		GIVE_WEAPON_TO_CHAR yak_5_love2 WEAPONTYPE_UZI 60
		SET_CHAR_ACCURACY yak_5_love2 40
		GIVE_WEAPON_TO_CHAR yak_6_love2 WEAPONTYPE_UZI 60
		GIVE_WEAPON_TO_CHAR yak_7_love2 WEAPONTYPE_SHOTGUN 25
		GIVE_WEAPON_TO_CHAR yak_8_love2 WEAPONTYPE_UZI 60
		SET_CHAR_ACCURACY yak_8_love2 40

		SET_CHAR_THREAT_SEARCH yak_1_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_2_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_3_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_4_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_5_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_6_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_7_love2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH yak_8_love2 THREAT_PLAYER1

		CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 304.2 -543.1 36.3 kenji
		SET_CHAR_HEADING kenji 140.0
		SET_CHAR_THREAT_SEARCH kenji THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kenji WEAPONTYPE_UZI 60
		ADD_ARMOUR_TO_CHAR kenji 100
		ADD_BLIP_FOR_CHAR kenji blip_kenji_love2
		SET_CHAR_STAY_IN_SAME_PLACE kenji true
		flag_yak_created_love2 = 1
	ENDIF


RETURN



player_wanted_love2:

	IF flag_yak_created_love2 = 1
	AND flag_wanted_love2 = 0
		IF IS_CHAR_DEAD yak_1_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_2_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_3_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_4_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_5_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_6_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_7_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF
		IF IS_CHAR_DEAD yak_8_love2
			ALTER_WANTED_LEVEL_NO_DROP player 3
			flag_wanted_love2 = 1
		ENDIF

	ENDIF


RETURN




// ****************************************Mission Start************************************

mission_start_love2:
REGISTER_MISSION_GIVEN
SCRIPT_NAME love2 
flag_player_on_mission = 1
flag_player_on_love_mission = 1
WAIT 0

flag_carpark_blip = 0
flag_kenji_dead = 0
flag_message = 0
flag_yak_created_love2 = 0
flag_wanted_love2 = 0
flag_yak_attack_love2 = 0
flag_player_clear = 0
flag_kenji_cut = 0
flag_kenji_look = 0

flag_1_dead_love2 = 0
flag_2_dead_love2 = 0
flag_3_dead_love2 = 0
flag_4_dead_love2 = 0
flag_5_dead_love2 = 0
flag_6_dead_love2 = 0
flag_7_dead_love2 = 0
flag_8_dead_love2 = 0

counter_kenji_guards_dead = 0

carpark_minx = 265.5
carpark_miny = -610.5
carpark_maxx = 345.5
carpark_maxy = -479.5

carpark_minz = 32.5
carpark_maxz = 50.0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_love2_failed
ENDIF

SET_FADING_COLOUR 0 0 0
 
DO_FADE 1500 FADE_OUT
 
PRINT_BIG ( LOVE2 ) 15000 2	//"Love Mission 2"

SWITCH_STREAMING OFF
*/

REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas

WHILE NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED tshrorckgrdn
 WAIT 0
ENDWHILE

// ****************************************START OF CUTSCENE********************************
 
LOAD_SPECIAL_CHARACTER 1 love
//LOAD_SPECIAL_CHARACTER 2 butler

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 LOVEH
//LOAD_SPECIAL_MODEL cut_obj3 BUTLERH 

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW


WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
//OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
//OR NOT HAS_MODEL_LOADED cut_obj3
 WAIT 0
ENDWHILE

 
LOAD_CUTSCENE d2_kk

SWITCH_STREAMING ON
 
SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422
 
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love
SET_CUTSCENE_ANIM cs_love love

//CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_butler
//SET_CUTSCENE_ANIM cs_butler butler
 
CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player
 
CREATE_CUTSCENE_HEAD cs_love CUT_OBJ2 cs_lovehead
SET_CUTSCENE_HEAD_ANIM cs_lovehead love

//CREATE_CUTSCENE_HEAD cs_butler CUT_OBJ3 cs_butlerhead
//SET_CUTSCENE_HEAD_ANIM cs_butlerhead butler
  
SET_PLAYER_COORDINATES player 85.0 -1548.2 28.3
 
SET_PLAYER_HEADING player 90.0
 
DO_FADE 250 FADE_IN

SWITCH_RUBBISH OFF 

START_CUTSCENE
//SWITCH_STREAMING OFF
 
// Displays cutscene text
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5434
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (LOVE2_A) 4000 1	//"Nothing drives down real estate prices like a good old fashi etc..."
//MESSAGE_WAIT 3000 true
 
WHILE cs_time < 9893
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (LOVE2_B) 4500 1	//"....but that might be going too far in this etc."
//MESSAGE_WAIT 3000 true
 
WHILE cs_time < 14631
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (LOVE2_C) 4000 1	//"I want you to kill the Yakuza WAKA-gashira, Kenji Kasen."
//MESSAGE_WAIT 3000 true
 
WHILE cs_time < 18811
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (LOVE2_D) 3000 1	//"I've learned .....t the top of the multi-story carpark in Newport."
//MESSAGE_WAIT 3000 true

WHILE cs_time < 21947
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (LOVE2_E) 3500 1	//"The Yakuza must blame.....Steal a Cartel car and take out Kenji!"
//MESSAGE_WAIT 3000 true

WHILE cs_time < 26266
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (LOVE2_F) 3500 1	//"The Yakuza must blame.....Steal a Cartel car and take out Kenji!"
//MESSAGE_WAIT 3000 true

WHILE cs_time < 30656
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (LOVE2_G) 3000 1	//"The Yakuza must blame.....Steal a Cartel car and take out Kenji!"
//MESSAGE_WAIT 3000 true

WHILE cs_time < 33442
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (LOVE2_H) 4500 1	//"The Yakuza must blame.....Steal a Cartel car and take out Kenji!"
//MESSAGE_WAIT 3000 true

WHILE cs_time < 41066
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
 
DO_FADE 0 FADE_OUT
 
SET_CAMERA_BEHIND_PLAYER
 
WAIT 500
 
DO_FADE 1500 FADE_IN 
 
//WHILE GET_FADING_STATUS
// WAIT 0
//ENDWHILE
 
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE
 
UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas

//SWITCH_STREAMING ON 
SWITCH_RUBBISH ON
// ******************************************END OF CUTSCENE********************************

/*
//++++++++++++++++++++++++++++++++++++++++++++CUT SCENE++++++++++++++++++++++++++++++++++

PRINT_BIG ( LOVE2 ) 15000 2	//"Love Mission 2"

SET_PLAYER_CONTROL player OFF
 
DO_FADE 1500 FADE_OUT
 
WAIT 1500
 
SWITCH_WIDESCREEN ON
 
SET_PLAYER_COORDINATES player 114.24 -1543.31 246.03
//SET_PLAYER_HEADING player Heading 
 
LOAD_SPECIAL_CHARACTER 1 misty
 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
 WAIT 0
ENDWHILE
 
CREATE_CHAR PEDTYPE_CIVMALE PED_SPECIAL1 126.6 -1556.5 246.39 love
TURN_CHAR_TO_FACE_PLAYER love player
 
DO_FADE 1500 FADE_IN
 
WAIT 1500
 
GET_PLAYER_CHAR player script_controlled_player

IF IS_CHAR_DEAD love
	GOTO mission_love2_failed 
ENDIF

SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT script_controlled_player love
 
WHILE NOT LOCATE_PLAYER_ON_FOOT_CHAR_2D player love 3.0 3.0 0
	WAIT 0
	IF IS_CHAR_DEAD love
		GOTO mission_love2_failed 
	ENDIF

ENDWHILE
 
TURN_CHAR_TO_FACE_PLAYER love player
TURN_CHAR_TO_FACE_CHAR script_controlled_player love
 
PRINT_NOW (LOVE2_A) 3000 1	//"Nothing drives down real estate prices like a good old fashi etc..."
MESSAGE_WAIT 3000 true
PRINT_NOW (LOVE2_B) 3000 1	//"....but that might be going too far in this etc."
MESSAGE_WAIT 3000 true
PRINT_NOW (LOVE2_C) 3000 1	//"I want you to kill the Yakuza WAKA-gashira, Kenji Kasen."
MESSAGE_WAIT 3000 true
PRINT_NOW (LOVE2_D) 3000 1	//"I've learned .....t the top of the multi-story carpark in Newport."
MESSAGE_WAIT 3000 true
PRINT_NOW (LOVE2_E) 3000 1	//"The Yakuza must blame.....Steal a Cartel car and take out Kenji!"
MESSAGE_WAIT 3000 true
*/
/* 
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 114.24 -1543.31
 
WHILE NOT IS_CHAR_OBJECTIVE_PASSED script_controlled_player
 WAIT 0
ENDWHILE

//SET_CHAR_OBJ_NO_OBJ script_controlled_player
 
DO_FADE 1500 FADE_OUT
WAIT 1500
 
SWITCH_WIDESCREEN OFF
SET_PLAYER_COORDINATES player 85.1 -1548.8 28.3
//SET_PLAYER_HEADING player Heading
 
DELETE_CHAR love
UNLOAD_SPECIAL_CHARACTER 1
 
DO_FADE 1500 FADE_IN
WAIT 1500
 
SET_PLAYER_CONTROL player ON



//++++++++++++++++++++++++++++++++++++++++++++++++CUTSCENE OVER+++++++++++++++++++++++++++++
*/


LOAD_SPECIAL_CHARACTER 1 kenji
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_GANG_YAKUZA_A
WHILE NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_GANG_YAKUZA_B
WHILE NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_B
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_YAKUZA
WHILE NOT HAS_MODEL_LOADED CAR_YAKUZA
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_STRETCH
WHILE NOT HAS_MODEL_LOADED CAR_STRETCH
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO LO2_A

/*
REQUEST_MODEL CAR_COLUMB//test stuff
WHILE NOT HAS_MODEL_LOADED CAR_COLUMB
	WAIT 0
ENDWHILE

PRINT_NOW (LOVE2_3) 3000 1//test stuff
CREATE_CAR CAR_COLUMB 54.0 -1625.0 -100.0 test_car_love2//test stuff
CAR_SET_IDLE test_car_love2//test stuff
*/

//While loop 1: player not at carpark AND player not in CAR_COLUMB

while_loop_1:
	WHILE flag_kenji_dead = 0
		WAIT 0
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 3
			GOTO while_loop_4
		ENDIF
		
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 1
			GOTO while_loop_2
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 2
			GOTO while_loop_3
		ENDIF
		IF flag_message = 0
			PRINT_NOW (LOVE2_1) 6000 1 //"Go and steal a Colombian Gangcar!"
			WAIT 3000
			flag_message = 1
		ENDIF



	ENDWHILE

		   		
//While loop 2: player not at carpark AND player in CAR_COLUMB

while_loop_2:
	WHILE flag_kenji_dead = 0
		WAIT 0
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 3
			GOTO while_loop_4
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 0
			GOTO while_loop_1
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 2
			GOTO while_loop_3
		ENDIF
		IF flag_message = 1
			PRINT_NOW (LOVE2_2) 4000 1 //"Now get to the multi-storey in Newport and kill Kenji!"
			WAIT 3000
			flag_message = 0
		ENDIF

		IF flag_carpark_blip = 0
			ADD_BLIP_FOR_COORD 305.0 -545.0 30.0 blip_carpark
			flag_carpark_blip = 1
		ENDIF



	ENDWHILE

//While loop 3: player at carpark AND NOT in CAR_COLUMB

while_loop_3:
	IF flag_carpark_blip = 1
		REMOVE_BLIP blip_carpark
		flag_carpark_blip = 0
	ENDIF

	WHILE flag_kenji_dead = 0
		WAIT 0
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 3
			GOTO while_loop_4
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 0
			GOTO while_loop_1
		ENDIF
		
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 1
			GOTO while_loop_2
		ENDIF

		IF flag_message = 2
			PRINT_NOW (LOVE2_3) 3000 1	//If you proceed without a Cartel car you will be identified!
			flag_message = 0
		ENDIF

		IF NOT IS_PLAYER_IN_ANY_CAR player 
		AND IS_PLAYER_IN_AREA_3D player carpark_minx carpark_miny carpark_minz carpark_maxx carpark_maxy carpark_maxz false
			PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
			IF flag_yak_created_love2 = 1
				IF NOT IS_CHAR_DEAD kenji
				AND NOT IS_CAR_DEAD kenji_car_love2
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER kenji kenji_car_love2
				ENDIF
			ENDIF
			GOTO mission_love2_failed
		ENDIF
		
		IF IS_PLAYER_IN_AREA_3D player carpark_minx carpark_miny 35.0 carpark_maxx carpark_maxy carpark_maxz false
			IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
				PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
				IF flag_yak_created_love2 = 1
					IF NOT IS_CHAR_DEAD kenji
					AND NOT IS_CAR_DEAD kenji_car_love2
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER kenji kenji_car_love2
					ENDIF
				ENDIF
				GOTO mission_love2_failed
			ENDIF
		ENDIF
					
		
		GOSUB create_yakuza
		GOSUB player_wanted_love2	
		
		IF flag_wanted_love2 = 1
			PLAY_MISSION_AUDIO
			flag_wanted_love2 = 2
		ENDIF

		 
	ENDWHILE

//While loop 4: player at carpark AND in CAR_COLUMB

while_loop_4:
	IF flag_carpark_blip = 1
		REMOVE_BLIP blip_carpark
		flag_carpark_blip = 0
	ENDIF
	
	WHILE flag_kenji_dead = 0
		WAIT 0
		
		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
			STORE_CAR_PLAYER_IS_IN player player_car
			SET_CAR_STRONG player_car true
		ENDIF
		/*
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_3D	player carpark_minx carpark_miny carpark_minz carpark_maxx carpark_maxy carpark_maxz false
			PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
			GOTO mission_love2_failed
		ENDIF
		*/
		IF flag_yak_attack_love2 = 0
		AND IS_PLAYER_IN_AREA_3D	player carpark_minx carpark_miny carpark_minz carpark_maxx carpark_maxy carpark_maxz false
			IF NOT IS_CHAR_DEAD yak_7_love2
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS yak_7_love2 player
			ENDIF
			IF NOT IS_CHAR_DEAD yak_8_love2
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS yak_8_love2 player
			ENDIF 
			flag_yak_attack_love2 = 1 
		ENDIF

		IF NOT IS_PLAYER_IN_ANY_CAR player 
		AND IS_PLAYER_IN_AREA_3D player carpark_minx carpark_miny carpark_minz carpark_maxx carpark_maxy carpark_maxz false
			PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
			IF flag_yak_created_love2 = 1
				IF NOT IS_CHAR_DEAD kenji
				AND NOT IS_CAR_DEAD kenji_car_love2
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER kenji kenji_car_love2
				ENDIF
			ENDIF
			GOTO mission_love2_failed
		ENDIF
		
		IF IS_PLAYER_IN_AREA_3D player carpark_minx carpark_miny 35.0 carpark_maxx carpark_maxy carpark_maxz false
			IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
				PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
				IF flag_yak_created_love2 = 1
					IF NOT IS_CHAR_DEAD kenji
					AND NOT IS_CAR_DEAD kenji_car_love2
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER kenji kenji_car_love2
					ENDIF
				ENDIF
				GOTO mission_love2_failed
			ELSE
				IF NOT IS_CHAR_DEAD kenji
					TURN_CHAR_TO_FACE_PLAYER kenji player
				ENDIF
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			IF NOT IS_CHAR_DEAD yak_7_love2
				SET_CHAR_OBJ_NO_OBJ yak_7_love2
			ENDIF
			IF NOT IS_CHAR_DEAD yak_8_love2
				SET_CHAR_OBJ_NO_OBJ yak_8_love2
			ENDIF
			flag_yak_attack_love2 = 0
			flag_message = 1
			GOTO while_loop_2
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND NOT IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 0
			GOTO while_loop_1
		ENDIF
		
		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_2D player carpark_minx carpark_miny carpark_maxx carpark_maxy false
			flag_message = 2
			GOTO while_loop_3
		ENDIF
		
		
		IF flag_yak_created_love2 = 1
		AND flag_kenji_cut = 0
		AND IS_PLAYER_IN_MODEL player CAR_COLUMB
			IF IS_PLAYER_IN_AREA_3D player 317.2 -603.5 33.0 332.0 -593.1 35.0 false
				flag_kenji_cut = 1
				GOSUB kenji_cut
			ENDIF
			IF IS_PLAYER_IN_AREA_3D player 317.2 -506.3 33.0 332.0 -497.3 35.0 false
				flag_kenji_cut = 2
				GOSUB kenji_cut
			ENDIF
		ENDIF

		GOSUB create_yakuza
		GOSUB player_wanted_love2	
		
		IF flag_wanted_love2 = 1
			PLAY_MISSION_AUDIO
			flag_wanted_love2 = 2
		ENDIF
		
		GOSUB yak_death_count

		IF IS_CHAR_DEAD kenji
			flag_kenji_dead = 1
			REMOVE_BLIP blip_kenji_love2
		ENDIF

	ENDWHILE

	WHILE flag_player_clear = 0
		WAIT 0
		
		IF flag_kenji_dead = 1
			PRINT_NOW (LOVE2_5) 3000 1//Kenji is dead!! Get out of NEWPORT and dump the Cartel car!!
			flag_kenji_dead = 2
		ENDIF
		
		GOSUB yak_death_count

		IF counter_kenji_guards_dead = 8
			PRINT_NOW (LOVE2_6) 3000 1//You've killed all the witnesses!!
			GOTO mission_love2_failed
		ENDIF

		IF NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND IS_PLAYER_IN_AREA_3D player carpark_minx carpark_miny carpark_minz carpark_maxx carpark_maxy carpark_maxz false
			PRINT_NOW (LOVE2_4) 3000 1 //The Yakuza have identified you!
			GOTO mission_love2_failed
		ENDIF
		
		IF NOT IS_PLAYER_IN_ZONE player COM_EAS
		AND IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND flag_kenji_dead = 2
			PRINT_NOW (LOVE2_7) 3000 1 //Now dump the car!
			flag_kenji_dead = 3
		ENDIF

		IF IS_PLAYER_IN_ZONE player COM_EAS
		AND NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
		AND flag_kenji_dead = 2
			PRINT_NOW (LOVE2_8) 3000 1 //Now get out of Newport!
			flag_kenji_dead = 3
		ENDIF
		
		IF NOT IS_PLAYER_IN_ZONE player COM_EAS
		AND NOT IS_PLAYER_IN_MODEL player CAR_COLUMB
			flag_player_clear = 1
		ENDIF

	ENDWHILE


GOTO mission_love2_passed

// Mission Love 2 failed

mission_love2_failed:

PRINT_BIG ( M_FAIL ) 2000 1
REMOVE_BLIP blip_kenji_love2
REMOVE_CHAR_ELEGANTLY kenji

RETURN

   

// mission Love 2 passed

mission_love2_passed:

flag_love_mission2_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 30000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 30000
REGISTER_MISSION_PASSED LOVE2
PLAYER_MADE_PROGRESS 1 
REMOVE_BLIP kenji_contact_blip
START_NEW_SCRIPT love_mission3_loop

RETURN
		


// mission cleanup

mission_cleanup_love2:


IF flag_carpark_blip = 1
	REMOVE_BLIP blip_carpark
ENDIF

REMOVE_BLIP blip_kenji_love2
REMOVE_CHAR_ELEGANTLY kenji


UNLOAD_SPECIAL_CHARACTER 1

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player on
SWITCH_WIDESCREEN off

flag_player_on_mission = 0
flag_player_on_love_mission = 0

MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_B
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STRETCH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_YAKUZA

MISSION_HAS_FINISHED
RETURN

//-----------------------------GOSUBS--------------------------------------

yak_death_count:

	IF IS_CHAR_DEAD yak_1_love2
	AND flag_1_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_1_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_2_love2
	AND flag_2_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_2_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_3_love2
	AND flag_3_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_3_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_4_love2
	AND flag_4_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_4_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_5_love2
	AND flag_5_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_5_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_6_love2
	AND flag_6_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_6_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_7_love2
	AND flag_7_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_7_dead_love2 = 1
	ENDIF
	IF IS_CHAR_DEAD yak_8_love2
	AND flag_8_dead_love2 = 0
		++ counter_kenji_guards_dead
		flag_8_dead_love2 = 1
	ENDIF

RETURN	

   

kenji_cut:

	IF flag_kenji_cut = 1
		APPLY_BRAKES_TO_PLAYERS_CAR player On
		SWITCH_WIDESCREEN on
		SET_PLAYER_CONTROL player off
		SET_FIXED_CAMERA_POSITION 303.11 -542.44 37.1 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 303.67 -543.36 36.92 JUMP_CUT
		GET_GAME_TIMER timer_kenji_cut_start
		timer_kenji_cut_dif = timer_kenji_cut_start - timer_kenji_cut_start
		WHILE timer_kenji_cut_dif < 7500
			WAIT 0
			//PRINT_WITH_NUMBER_NOW ( Z ) timer_kenji_cut_dif 1000 1
			GET_GAME_TIMER timer_kenji_cut_now
			timer_kenji_cut_dif = timer_kenji_cut_now - timer_kenji_cut_start
			IF timer_kenji_cut_dif > 1000
			AND flag_kenji_look = 0
				IF NOT IS_CHAR_DEAD kenji
				AND NOT IS_CHAR_DEAD yak_2_love2
					//CHAR_LOOK_AT_CHAR_ALWAYS kenji yak_3_love2
					SET_CHAR_WAIT_STATE kenji WAITSTATE_CROSS_ROAD_LOOK 4000
					SET_CHAR_WAIT_STATE yak_2_love2 WAITSTATE_PLAYANIM_CHAT 4000
					flag_kenji_look = 1
				ENDIF
			ENDIF
			IF timer_kenji_cut_dif > 2500
			AND flag_kenji_cut = 1
				/*IF NOT IS_CHAR_DEAD kenji
					STOP_CHAR_LOOKING kenji
				ENDIF*/
				IF NOT IS_CHAR_DEAD yak_3_love2
					POINT_CAMERA_AT_CHAR yak_3_love2 FIXED INTERPOLATION
				ENDIF
				flag_kenji_cut = 3
			ENDIF
			IF timer_kenji_cut_dif > 5000
			AND flag_kenji_cut = 3
				IF NOT IS_CHAR_DEAD yak_1_love2
					POINT_CAMERA_AT_CHAR yak_1_love2 FIXED INTERPOLATION
					flag_kenji_cut = 4
				ENDIF
			ENDIF
			
		ENDWHILE
		RESTORE_CAMERA_JUMPCUT
		SET_PLAYER_CONTROL player on
		SWITCH_WIDESCREEN off
	ENDIF
	
	IF flag_kenji_cut = 2
		APPLY_BRAKES_TO_PLAYERS_CAR player On
		SWITCH_WIDESCREEN on
		SET_PLAYER_CONTROL player off
		SET_FIXED_CAMERA_POSITION 303.32 -544.7 37.09 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT 303.83 -543.85 36.96 JUMP_CUT
		GET_GAME_TIMER timer_kenji_cut_start
		timer_kenji_cut_dif = timer_kenji_cut_start - timer_kenji_cut_start
		WHILE timer_kenji_cut_dif < 7500
			WAIT 0
			//PRINT_WITH_NUMBER_NOW ( Z ) timer_kenji_cut_dif 1000 1
			GET_GAME_TIMER timer_kenji_cut_now
			timer_kenji_cut_dif = timer_kenji_cut_now - timer_kenji_cut_start
			IF timer_kenji_cut_dif > 1000
			AND flag_kenji_look = 0
				IF NOT IS_CHAR_DEAD kenji
				AND NOT IS_CHAR_DEAD yak_2_love2
					//CHAR_LOOK_AT_CHAR_ALWAYS kenji yak_1_love2
					SET_CHAR_WAIT_STATE kenji WAITSTATE_CROSS_ROAD_LOOK 4000
					SET_CHAR_WAIT_STATE yak_2_love2 WAITSTATE_PLAYANIM_CHAT 4000
					flag_kenji_look = 1
				ENDIF
			ENDIF
			IF timer_kenji_cut_dif > 2500
			AND flag_kenji_cut = 2			
				/*IF NOT IS_CHAR_DEAD kenji
					STOP_CHAR_LOOKING kenji
				ENDIF*/
				IF NOT IS_CHAR_DEAD yak_1_love2
					POINT_CAMERA_AT_CHAR yak_1_love2 FIXED INTERPOLATION
				ENDIF
				flag_kenji_cut = 3
			ENDIF
			IF timer_kenji_cut_dif > 5000
			AND flag_kenji_cut = 3
				IF NOT IS_CHAR_DEAD yak_4_love2
					POINT_CAMERA_AT_CHAR yak_4_love2 FIXED INTERPOLATION
					flag_kenji_cut = 4
				ENDIF
			ENDIF 	
		ENDWHILE
		RESTORE_CAMERA_JUMPCUT
		SET_PLAYER_CONTROL player on
		SWITCH_WIDESCREEN off

	ENDIF




RETURN



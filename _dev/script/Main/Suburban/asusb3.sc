MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************ASUKA SUBURBAN MISSION 3****************************** 
// *****************************************************************************************
// ***************************************'Plane to Sea'************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_as3
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_as3_failed
ENDIF
GOSUB mission_cleanup_as3

MISSION_END
 
// Variables for mission
VAR_INT timer_as3 player_as3_boat dodo_as3

VAR_INT bouy_1_as3 bouy_2_as3 bouy_3_as3 bouy_4_as3 bouy_5_as3
VAR_INT bouy_6_as3 bouy_7_as3 bouy_8_as3 bouy_9_as3 bouy_10_as3
VAR_INT bouy_point

VAR_INT blip_as3_boat blip_as3_bouy blip_as3_dodo blip_stash
VAR_INT blip_charlie_1 blip_charlie_2 blip_charlie_3 blip_charlie_4
VAR_INT blip_charlie_5 blip_charlie_6 blip_charlie_7 blip_charlie_8

VAR_FLOAT platform_x platform_y
VAR_FLOAT dodo_as3_x dodo_as3_y dodo_as3_z

VAR_INT charlie_1 charlie_2 charlie_3 charlie_4
VAR_INT charlie_5 charlie_6 charlie_7 charlie_8
VAR_INT rocket_as3

VAR_FLOAT charlie_1_x charlie_1_y charlie_1_z
VAR_FLOAT charlie_2_x charlie_2_y charlie_2_z
VAR_FLOAT charlie_3_x charlie_3_y charlie_3_z
VAR_FLOAT charlie_4_x charlie_4_y charlie_4_z
VAR_FLOAT charlie_5_x charlie_5_y charlie_5_z
VAR_FLOAT charlie_6_x charlie_6_y charlie_6_z
VAR_FLOAT charlie_7_x charlie_7_y charlie_7_z
VAR_FLOAT charlie_8_x charlie_8_y charlie_8_z

VAR_FLOAT min_x max_x min_y max_y min_z max_z

VAR_INT counter_charlie flag_counter_message particle_time flag_particle flag_boat_message
VAR_INT flag_charlie_1 flag_charlie_2 flag_charlie_3 flag_charlie_4
VAR_INT flag_charlie_5 flag_charlie_6 flag_charlie_7 flag_charlie_8

VAR_INT flag_commence_approach flag_runway_blip flag_boat_blip flag_bouy_blip
VAR_INT timer_as3_start timer_as3_now timer_as3_dif
VAR_INT flag_created_baddies flag_mission_as3_failed

// ****************************************Mission Start************************************

mission_start_as3:
REGISTER_MISSION_GIVEN
SCRIPT_NAME asusb3 
//PRINT_BIG ( AS3 ) 5000 1

flag_player_on_mission = 1
flag_player_on_asuka_mission = 1

WAIT 0

//----------------------------SET FLAGS & VARIABLES--------------------------------------------
timer_as3 = 210000
counter_charlie = 0
flag_commence_approach = 0
flag_counter_message = 0
flag_runway_blip = 0
flag_boat_blip = 0
flag_bouy_blip = 0
particle_time = 0
flag_particle = 0

flag_charlie_1 = 0
flag_charlie_2 = 0
flag_charlie_3 = 0
flag_charlie_4 = 0
flag_charlie_5 = 0
flag_charlie_6 = 0
flag_charlie_7 = 0
flag_charlie_8 = 0

flag_messages = 0
flag_created_baddies = 0
flag_mission_as3_failed = 0
flag_boat_message = 0
// ---------------------------LOCATION COORDS--------------------------------------------------

platform_x = -805.0 
platform_y = -1310.0

killzone_min_x = -1460.0
killzone_min_y = -1050.0
killzone_max_x = -1450.0
killzone_max_y = -1040.0


//  ******************************************* START OF CUTSCENE ***************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_as3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 250 FADE_OUT

PRINT_BIG ( AS3 ) 15000 2

SWITCH_STREAMING OFF
*/

REQUEST_MODEL csitecutscene

LOAD_SPECIAL_CHARACTER 1 asuka
LOAD_SPECIAL_CHARACTER 2 miguel
LOAD_SPECIAL_CHARACTER 3 maria
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 ASUKAH
LOAD_SPECIAL_MODEL cut_obj3 MARIAH
LOAD_SPECIAL_MODEL cut_obj4 WHIP

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED csitecutscene
 WAIT 0
ENDWHILE
 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
 WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj4
 WAIT 0
ENDWHILE

LOAD_CUTSCENE a8_ps

SWITCH_STREAMING ON

SET_CUTSCENE_OFFSET 369.02 -327.5 18.46
  
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_OBJECT cut_obj4 cs_whip
SET_CUTSCENE_ANIM cs_whip WHIP
 
CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_maria CUT_OBJ3 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead maria
 
CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ2 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka
/*
CREATE_CUTSCENE_HEAD cs_miguel CUT_OBJ3 cs_miguelhead
SET_CUTSCENE_HEAD_ANIM cs_miguelhead miguel
*/
SET_PLAYER_COORDINATES player 373.7523 -327.2676 17.1950
 
SET_PLAYER_HEADING player 270.0
 
DO_FADE 250 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF
//SWITCH_WORLD_PROCESSING OFF

START_CUTSCENE

//------CUTSCENE TEXT-----------------------------
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 459
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (AS3_A) 5000 1
 
WHILE cs_time < 4401
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_B) 3000 1
 
WHILE cs_time < 7348
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_C) 5000 1
 
WHILE cs_time < 10448
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_C1) 5000 1

WHILE cs_time < 11597
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_D) 2000 1

WHILE cs_time < 13625
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_E) 3000 1

WHILE cs_time < 16457
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_F) 5000 1

WHILE cs_time < 19021
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_F1) 5000 1

WHILE cs_time < 22389
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_G) 5000 1

WHILE cs_time < 26064
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_G1) 5000 1

WHILE cs_time < 28628
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_H) 5000 1

WHILE cs_time < 33182
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_H1) 5000 1

WHILE cs_time < 35785
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_I) 3000 1

WHILE cs_time < 39765
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_J) 3000 1

WHILE cs_time < 42026
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS3_K) 3000 1

//WHILE cs_time < 12000
WHILE cs_time < 44333
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
 
DO_FADE 1000 FADE_IN 
  
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

MARK_MODEL_AS_NO_LONGER_NEEDED csitecutscene

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4

SWITCH_STREAMING ON 
SWITCH_RUBBISH ON
//SWITCH_WORLD_PROCESSING ON

// ******************************************END OF CUTSCENE********************************


// Mission stuff goes here

DISPLAY_ONSCREEN_TIMER timer_as3

//----------------------------LOAD MODELS------------------------------------------------------

REQUEST_MODEL BOAT_REEFER
WHILE NOT HAS_MODEL_LOADED BOAT_REEFER
	WAIT 0
ENDWHILE

CREATE_CAR BOAT_REEFER -330.5 -1462.4 0.0 player_as3_boat
SET_CAR_HEADING player_as3_boat 95.0

ADD_BLIP_FOR_CAR player_as3_boat blip_as3_boat
flag_boat_blip = 1

CREATE_PICKUP WEAPON_ROCKET PICKUP_ONCE -279.6 -1473.8 6.2 rocket_as3

REQUEST_MODEL PLANE_DEADDODO
WHILE NOT HAS_MODEL_LOADED PLANE_DEADDODO
	WAIT 0
ENDWHILE

REQUEST_MODEL packagelarge
WHILE NOT HAS_MODEL_LOADED packagelarge
	WAIT 0
ENDWHILE

REQUEST_MODEL bouy
WHILE NOT HAS_MODEL_LOADED bouy
	WAIT 0
ENDWHILE

REQUEST_MODEL PLANE_DODO
WHILE NOT HAS_MODEL_LOADED PLANE_DODO
	WAIT 0
ENDWHILE

/*
PRINT AS3_A 5000 1//"There is a plane coming into Francis International in (2/3/4/5/6) hours time. It is full of Catalina's poison."
MESSAGE_WAIT 5000 1

PRINT AS3_B 5000 1//"You can avoid airport security by getting a boat out to the runway-light pontoons and shooting the plane down on it's approach."
MESSAGE_WAIT 5000 1

PRINT AS3_C 5000 1//"Collect the charlie from the debris and stash it!"
MESSAGE_WAIT 5000 1

*/





CREATE_OBJECT bouy -825.0 -1360.0 2.0 bouy_1_as3
CREATE_OBJECT bouy -705.0 -1410.0 2.0 bouy_3_as3
CREATE_OBJECT bouy -585.0 -1460.0 2.0 bouy_5_as3
CREATE_OBJECT bouy -785.0 -1260.0 2.0 bouy_6_as3
CREATE_OBJECT bouy -665.0 -1310.0 2.0 bouy_8_as3
CREATE_OBJECT bouy -545.0 -1360.0 2.0 bouy_10_as3
CREATE_OBJECT bouy -765.0 -1385.0 2.0 bouy_2_as3
CREATE_OBJECT bouy -645.0 -1435.0 2.0 bouy_4_as3
CREATE_OBJECT bouy -725.0 -1285.0 2.0 bouy_7_as3
CREATE_OBJECT bouy -605.0 -1335.0 2.0 bouy_9_as3
CREATE_OBJECT bouy platform_x platform_y 2.0 bouy_point

SET_OBJECT_COLLISION bouy_1_as3 true
SET_OBJECT_DYNAMIC bouy_1_as3 true
SET_OBJECT_COLLISION bouy_2_as3 true
SET_OBJECT_DYNAMIC bouy_2_as3 true
SET_OBJECT_COLLISION bouy_3_as3 true
SET_OBJECT_DYNAMIC bouy_3_as3 true
SET_OBJECT_COLLISION bouy_4_as3 true
SET_OBJECT_DYNAMIC bouy_4_as3 true
SET_OBJECT_COLLISION bouy_5_as3 true
SET_OBJECT_DYNAMIC bouy_5_as3 true
SET_OBJECT_COLLISION bouy_6_as3 true
SET_OBJECT_DYNAMIC bouy_6_as3 true
SET_OBJECT_COLLISION bouy_7_as3 true
SET_OBJECT_DYNAMIC bouy_7_as3 true
SET_OBJECT_COLLISION bouy_8_as3 true
SET_OBJECT_DYNAMIC bouy_8_as3 true
SET_OBJECT_COLLISION bouy_9_as3 true
SET_OBJECT_DYNAMIC bouy_9_as3 true
SET_OBJECT_COLLISION bouy_10_as3 true
SET_OBJECT_DYNAMIC bouy_10_as3 true
SET_OBJECT_COLLISION bouy_point true
SET_OBJECT_DYNAMIC bouy_point true

//ADD_BLIP_FOR_OBJECT bouy_point blip_as3_bouy
//CHANGE_BLIP_COLOUR blip_as3_bouy 4

//-----------------CREATE CARTEL BADDIES--------------------------------------

REQUEST_MODEL PED_GANG_COLOMBIAN_A
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_GANG_COLOMBIAN_B
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_B
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_COLUMB
WHILE NOT HAS_MODEL_LOADED CAR_COLUMB
	WAIT 0
ENDWHILE

GOSUB baddies

loop_as3_1: //---player not at location and plane not triggered----------------

	WAIT 0

	IF flag_messages = 0
		IF flag_boat_message = 0
			PRINT_NOW (AS3_1) 4000 1//Find the boat and get to the runway marker bouys!
			flag_boat_message = 1
			flag_messages = 1
		ENDIF
	ENDIF
	IF flag_messages = 0
		IF flag_boat_message = 1
			PRINT_NOW (AS3_1A) 4000 1//~g~Now get to the ~b~marker buoy!
			flag_boat_message = 2
			flag_messages = 1
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_MODEL player BOAT_REEFER
	OR IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	OR IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 1
			REMOVE_BLIP	blip_as3_boat
			flag_boat_blip = 0
		ENDIF
		IF flag_bouy_blip = 0
			ADD_BLIP_FOR_OBJECT bouy_point blip_as3_bouy
			flag_bouy_blip = 1
			flag_messages = 0
		ENDIF

	ENDIF
	IF NOT IS_PLAYER_IN_MODEL player BOAT_REEFER
	AND NOT IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	AND NOT IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 0
		AND NOT IS_CAR_DEAD	player_as3_boat
			ADD_BLIP_FOR_CAR player_as3_boat blip_as3_boat
			flag_boat_blip = 1
		ENDIF
		IF flag_bouy_blip = 1
			REMOVE_BLIP blip_as3_bouy
			flag_bouy_blip = 0
			flag_messages = 0
		ENDIF
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player platform_x platform_y 160.0 160.0 false
		IF NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
			LOAD_COLLISION_WITH_SCREEN LEVEL_SUBURBAN
		ENDIF
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player platform_x platform_y 15.0 15.0 false
		REMOVE_BLIP	blip_as3_bouy
		CLEAR_PRINTS
		flag_messages = 0
		GOTO loop_as3_3
	ENDIF

	IF timer_as3 < 91000
		IF flag_commence_approach = 0
			START_DRUG_RUN
			flag_commence_approach = 1
			FIND_DRUG_PLANE_COORDINATES dodo_as3_x dodo_as3_y dodo_as3_z
			ADD_BLIP_FOR_COORD_OLD dodo_as3_x dodo_as3_y dodo_as3_z 4 blip_only blip_as3_dodo
			CHANGE_BLIP_SCALE blip_as3_dodo 2
		ENDIF
		CLEAR_PRINTS
		flag_messages = 0
		GOTO loop_as3_2
	ENDIF
	
	IF timer_as3 < 1
		CLEAR_ONSCREEN_TIMER timer_as3
	ENDIF
	GOSUB baddies
	
GOTO loop_as3_1
	

  
loop_as3_2: //---player not at location and plane is triggered-----------------

	WAIT 0
	REMOVE_BLIP blip_as3_dodo
	
	IF flag_messages = 0
		IF flag_boat_message = 0
			PRINT_NOW (AS3_1) 4000 1//Find the boat and get to the runway marker bouys!
			flag_boat_message = 1
			flag_messages = 1
		ENDIF
	ENDIF
	IF flag_messages = 0
		IF flag_boat_message = 1
			PRINT_NOW (AS3_2) 4000 1//Get to the runway marker buoys! The plane is on its final approach!!
			flag_boat_message = 2
			flag_messages = 1
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_MODEL player BOAT_REEFER
	OR IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	OR IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 1
			REMOVE_BLIP	blip_as3_boat
			flag_boat_blip = 0
		ENDIF
		IF flag_bouy_blip = 0
			ADD_BLIP_FOR_OBJECT bouy_point blip_as3_bouy
			flag_bouy_blip = 1
			flag_messages = 0
			flag_boat_message = 1
		ENDIF
	ENDIF
	IF NOT IS_PLAYER_IN_MODEL player BOAT_REEFER
	AND NOT IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	AND NOT IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 0
		AND NOT IS_CAR_DEAD	player_as3_boat
			ADD_BLIP_FOR_CAR player_as3_boat blip_as3_boat
			flag_boat_blip = 1
		ENDIF
		IF flag_bouy_blip = 1
			REMOVE_BLIP blip_as3_bouy
			flag_bouy_blip = 0
			flag_messages = 0
			flag_boat_message = 1
		ENDIF
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player platform_x platform_y 160.0 160.0 false
		IF NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
			LOAD_COLLISION_WITH_SCREEN LEVEL_SUBURBAN
		ENDIF
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player platform_x platform_y 15.0 15.0 false
		REMOVE_BLIP	blip_as3_bouy
		CLEAR_PRINTS
		flag_messages = 0
		GOTO loop_as3_4
	ENDIF

	IF HAS_DRUG_RUN_BEEN_COMPLETED
		GOTO mission_as3_failed
	ENDIF

	IF HAS_DRUG_PLANE_BEEN_SHOT_DOWN
		CLEAR_PRINTS
		CLEAR_ONSCREEN_TIMER timer_as3
		flag_messages = 0
		GOTO loop_as3_6
	ENDIF
	
	IF timer_as3 < 1
		CLEAR_ONSCREEN_TIMER timer_as3
	ENDIF
	
	//TEST BLIP FOR PLANE
	FIND_DRUG_PLANE_COORDINATES dodo_as3_x dodo_as3_y dodo_as3_z
	ADD_BLIP_FOR_COORD_OLD dodo_as3_x dodo_as3_y dodo_as3_z 4 blip_only blip_as3_dodo
	CHANGE_BLIP_SCALE blip_as3_dodo 3
	
	GOSUB area_check
	IF flag_mission_as3_failed = 1
		GOTO mission_as3_failed	
	ENDIF
	GOSUB baddies

GOTO loop_as3_2


loop_as3_3: //---player at location, plane not triggered-----------------------

	WAIT 0

	IF flag_messages = 0
		PRINT_NOW (AS3_3) 4000 1 //Wait for the plane to start its approach!
		flag_messages = 0
	ENDIF

	IF IS_PLAYER_IN_MODEL player BOAT_REEFER
	OR IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	OR IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 1
			REMOVE_BLIP	blip_as3_boat
			flag_boat_blip = 0
		ENDIF
		IF flag_bouy_blip = 0
			ADD_BLIP_FOR_OBJECT bouy_point blip_as3_bouy
			flag_bouy_blip = 1
			flag_messages = 0
		ENDIF
	ENDIF
	IF NOT IS_PLAYER_IN_MODEL player BOAT_REEFER
	AND NOT IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	AND NOT IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_boat_blip = 0
		AND NOT IS_CAR_DEAD	player_as3_boat
			ADD_BLIP_FOR_CAR player_as3_boat blip_as3_boat
			flag_boat_blip = 1
		ENDIF
		IF flag_bouy_blip = 1
			REMOVE_BLIP blip_as3_bouy
			flag_bouy_blip = 0
			flag_messages = 0
		ENDIF
	ENDIF

	IF timer_as3 < 91000
		IF flag_commence_approach = 0
			START_DRUG_RUN
			flag_commence_approach = 1
			FIND_DRUG_PLANE_COORDINATES dodo_as3_x dodo_as3_y dodo_as3_z
			ADD_BLIP_FOR_COORD_OLD dodo_as3_x dodo_as3_y dodo_as3_z 4 blip_only blip_as3_dodo
			CHANGE_BLIP_SCALE blip_as3_dodo 3
		ENDIF
		CLEAR_PRINTS
		flag_messages = 0
		GOTO loop_as3_4
	ENDIF

	IF timer_as3 < 1
		CLEAR_ONSCREEN_TIMER timer_as3
	ENDIF

	GOSUB baddies

GOTO loop_as3_3


loop_as3_4: //---player at location, plane triggered---------------------------

	WAIT 0
	
	REMOVE_BLIP blip_as3_dodo

	//IF NOT IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_ROCKET
	IF flag_messages = 0
		PRINT_NOW (AS3_4) 4000 1 //Use a rocket launcher to shoot the plane down!
		flag_messages = 1
	ENDIF

	IF NOT IS_CAR_DEAD player_as3_boat
		IF IS_PLAYER_IN_CAR	player player_as3_boat
		AND flag_boat_blip = 1
			REMOVE_BLIP	blip_as3_boat
			flag_boat_blip = 0
		ENDIF
		IF NOT IS_PLAYER_IN_CAR player player_as3_boat
		AND flag_boat_blip = 0
			ADD_BLIP_FOR_CAR player_as3_boat blip_as3_boat
			flag_boat_blip = 1
			flag_messages = 0
		ENDIF
	ENDIF
	
	IF HAS_DRUG_RUN_BEEN_COMPLETED
		GOTO mission_as3_failed
	ENDIF
	
	IF HAS_DRUG_PLANE_BEEN_SHOT_DOWN
		CLEAR_PRINTS
		CLEAR_ONSCREEN_TIMER timer_as3
		flag_messages = 0
		GOTO loop_as3_6
	ENDIF
	
	IF timer_as3 < 1
		CLEAR_ONSCREEN_TIMER timer_as3
	ENDIF

	//TEST BLIP FOR PLANE
	FIND_DRUG_PLANE_COORDINATES dodo_as3_x dodo_as3_y dodo_as3_z
	ADD_BLIP_FOR_COORD_OLD dodo_as3_x dodo_as3_y dodo_as3_z 4 blip_only blip_as3_dodo
	CHANGE_BLIP_SCALE blip_as3_dodo 2
	
	GOSUB area_check
	IF flag_mission_as3_failed = 1
		GOTO mission_as3_failed	
	ENDIF
	GOSUB baddies

GOTO loop_as3_4


loop_as3_6: //---drug shipment shot down---(NB not really a loop!)-------------

	//FIND_DRUG_PLANE_COORDINATES dodo_as3_x dodo_as3_y dodo_as3_z
	REMOVE_BLIP	blip_as3_boat
	REMOVE_BLIP blip_as3_bouy
	CREATE_CAR PLANE_DODO dodo_as3_x dodo_as3_y dodo_as3_z dodo_as3
	SET_CAR_HEALTH dodo_as3 1
	dodo_as3_x = dodo_as3_x + 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_1
	FLASH_OBJECT charlie_1 On	
	SET_OBJECT_COLLISION charlie_1 TRUE
	SET_OBJECT_DYNAMIC charlie_1 TRUE
	ADD_BLIP_FOR_OBJECT charlie_1 blip_charlie_1
	ADD_TO_OBJECT_VELOCITY charlie_1 18.0 12.0 6.0 //blossom pattern
	//ADD_TO_OBJECT_VELOCITY charlie_1 10.0 0.0 0.0 //dodo velocity


	dodo_as3_y = dodo_as3_y - 1.0
	
	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_2
	FLASH_OBJECT charlie_2 On	
	SET_OBJECT_COLLISION charlie_2 TRUE
	SET_OBJECT_DYNAMIC charlie_2 TRUE
	ADD_BLIP_FOR_OBJECT charlie_2 blip_charlie_2
	ADD_TO_OBJECT_VELOCITY charlie_2 14.0 -19.0 7.0


	dodo_as3_x = dodo_as3_x - 1.0
	
	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_3
	FLASH_OBJECT charlie_3 On	
	SET_OBJECT_COLLISION charlie_3 TRUE
	SET_OBJECT_DYNAMIC charlie_3 TRUE
	ADD_BLIP_FOR_OBJECT charlie_3 blip_charlie_3
	ADD_TO_OBJECT_VELOCITY charlie_3 13.0 -15.0 1.0

	dodo_as3_x = dodo_as3_x - 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_4
	FLASH_OBJECT charlie_4 On	
	SET_OBJECT_COLLISION charlie_4 TRUE
	SET_OBJECT_DYNAMIC charlie_4 TRUE
	ADD_BLIP_FOR_OBJECT charlie_4 blip_charlie_4
	ADD_TO_OBJECT_VELOCITY charlie_4 -18.0 -19.5 4.0

	dodo_as3_y = dodo_as3_y + 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_5
	FLASH_OBJECT charlie_5 On	
	SET_OBJECT_COLLISION charlie_5 TRUE
	SET_OBJECT_DYNAMIC charlie_5 TRUE
	ADD_BLIP_FOR_OBJECT charlie_5 blip_charlie_5
	ADD_TO_OBJECT_VELOCITY charlie_5 -7.0 11.0 8.0

	dodo_as3_y = dodo_as3_y + 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_6
	FLASH_OBJECT charlie_6 On	
	SET_OBJECT_COLLISION charlie_6 TRUE
	SET_OBJECT_DYNAMIC charlie_6 TRUE
	ADD_BLIP_FOR_OBJECT charlie_6 blip_charlie_6
	ADD_TO_OBJECT_VELOCITY charlie_6 -17.0 4.8 7.0

	dodo_as3_x = dodo_as3_x + 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_7
	FLASH_OBJECT charlie_7 On	
	SET_OBJECT_COLLISION charlie_7 TRUE
	SET_OBJECT_DYNAMIC charlie_7 TRUE
	ADD_BLIP_FOR_OBJECT charlie_7 blip_charlie_7
	ADD_TO_OBJECT_VELOCITY charlie_7 -11.0 12.0 7.0

	dodo_as3_x = dodo_as3_x + 1.0

	CREATE_OBJECT_NO_OFFSET packagelarge dodo_as3_x dodo_as3_y dodo_as3_z charlie_8
	FLASH_OBJECT charlie_8 On	
	SET_OBJECT_COLLISION charlie_8 TRUE
	SET_OBJECT_DYNAMIC charlie_8 TRUE
	ADD_BLIP_FOR_OBJECT charlie_8 blip_charlie_8
	ADD_TO_OBJECT_VELOCITY charlie_8 10.0 10.0 0.0

	GET_GAME_TIMER timer_as3_start

loop_as3_7: //----collect the packages!!--------------

WHILE counter_charlie  < 8

	WAIT 0

	GOSUB baddies

	IF flag_counter_message = 0
		PRINT_NOW (AS3_5) 5000 1//Collect the cargo!
		flag_counter_message = 1
	ENDIF
	
	GET_GAME_TIMER timer_as3_now
	timer_as3_dif = timer_as3_now - timer_as3_start
	IF timer_as3_dif > particle_time
		particle_time = timer_as3_dif + 200
		flag_particle = 1
	ENDIF
	
	IF flag_particle = 1

		IF flag_charlie_1 = 0
			GET_OBJECT_COORDINATES charlie_1 charlie_1_x charlie_1_y charlie_1_z
			/*
			min_x = charlie_1_x - 0.2
			max_x = charlie_1_x	+ 0.2
			min_y = charlie_1_y	- 0.2
			max_y = charlie_1_y	+ 0.2
			min_z = charlie_1_z	- 0.2
			max_z = charlie_1_z	+ 0.2
			REMOVE_PARTICLE_EFFECTS_IN_AREA Min_x Min_y Min_z Max_x Max_y Max_z
			*/
			IF timer_as3_dif < 6000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_1_x charlie_1_y charlie_1_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 6000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_1_x charlie_1_y charlie_1_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_2 = 0
			GET_OBJECT_COORDINATES charlie_2 charlie_2_x charlie_2_y charlie_2_z

			IF timer_as3_dif < 4000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_2_x charlie_2_y charlie_2_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 4000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_2_x charlie_2_y charlie_2_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_3 = 0
			GET_OBJECT_COORDINATES charlie_3 charlie_3_x charlie_3_y charlie_3_z

			IF timer_as3_dif < 7000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_3_x charlie_3_y charlie_3_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 7000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_3_x charlie_3_y charlie_3_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_4 = 0
			GET_OBJECT_COORDINATES charlie_4 charlie_4_x charlie_4_y charlie_4_z

			IF timer_as3_dif < 3500
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_4_x charlie_4_y charlie_4_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 3500
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_4_x charlie_4_y charlie_4_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_5 = 0
			GET_OBJECT_COORDINATES charlie_5 charlie_5_x charlie_5_y charlie_5_z

			IF timer_as3_dif < 8000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_5_x charlie_5_y charlie_5_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 8000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_5_x charlie_5_y charlie_5_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_6 = 0
			GET_OBJECT_COORDINATES charlie_6 charlie_6_x charlie_6_y charlie_6_z

			IF timer_as3_dif < 6000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_6_x charlie_6_y charlie_6_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 6000
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_6_x charlie_6_y charlie_6_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_7 = 0
			GET_OBJECT_COORDINATES charlie_7 charlie_7_x charlie_7_y charlie_7_z

			IF timer_as3_dif < 7500
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_7_x charlie_7_y charlie_7_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 7500
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_7_x charlie_7_y charlie_7_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		IF flag_charlie_8 = 0
			GET_OBJECT_COORDINATES charlie_8 charlie_8_x charlie_8_y charlie_8_z

			IF timer_as3_dif < 4750
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIRE_TRAIL  charlie_8_x charlie_8_y charlie_8_z 0.0 0.0 0.0 0.4 0 0 0 200
			ENDIF
			IF timer_as3_dif > 4750
				ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE  charlie_8_x charlie_8_y charlie_8_z 0.0 0.0 0.0 0.3 0 0 0 200
			ENDIF
		ENDIF
		
		flag_particle = 0
	

	ENDIF


	IF IS_PLAYER_IN_MODEL player BOAT_REEFER
	OR IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	OR IS_PLAYER_IN_MODEL player BOAT_SPEEDER
		IF flag_charlie_1 = 0		
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_1_x charlie_1_y charlie_1_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_1
				DELETE_OBJECT charlie_1
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_1 = 1
			ENDIF
		ENDIF
		IF flag_charlie_2 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_2_x charlie_2_y charlie_2_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_2
				DELETE_OBJECT charlie_2
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_2 = 1
			ENDIF
		ENDIF
		IF flag_charlie_3 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_3_x charlie_3_y charlie_3_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_3
				DELETE_OBJECT charlie_3
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_3 = 1
			ENDIF
		ENDIF
		IF flag_charlie_4 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_4_x charlie_4_y charlie_4_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_4
				DELETE_OBJECT charlie_4
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_4 = 1
			ENDIF
		ENDIF
		IF flag_charlie_5 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_5_x charlie_5_y charlie_5_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_5
				DELETE_OBJECT charlie_5
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_5 = 1
			ENDIF
		ENDIF
		IF flag_charlie_6 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_6_x charlie_6_y charlie_6_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_6
				DELETE_OBJECT charlie_6
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_6 = 1
			ENDIF
		ENDIF
		IF flag_charlie_7 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_7_x charlie_7_y charlie_7_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_7
				DELETE_OBJECT charlie_7
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_7 = 1
			ENDIF
		ENDIF
		IF flag_charlie_8 = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player charlie_8_x charlie_8_y charlie_8_z 4.0 4.0 4.0 false
				REMOVE_BLIP blip_charlie_8
				DELETE_OBJECT charlie_8
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_8 = 1
			ENDIF
		ENDIF
	ELSE
		IF flag_charlie_1 = 0		
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_1
				REMOVE_BLIP blip_charlie_1
				DELETE_OBJECT charlie_1
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_1 = 1
			ENDIF
		ENDIF
		IF flag_charlie_2 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_2
				REMOVE_BLIP blip_charlie_2
				DELETE_OBJECT charlie_2
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_2 = 1
			ENDIF
		ENDIF
		IF flag_charlie_3 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_3
				REMOVE_BLIP blip_charlie_3
				DELETE_OBJECT charlie_3
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_3 = 1
			ENDIF
		ENDIF
		IF flag_charlie_4 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_4
				REMOVE_BLIP blip_charlie_4
				DELETE_OBJECT charlie_4
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_4 = 1
			ENDIF
		ENDIF
		IF flag_charlie_5 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_5
				REMOVE_BLIP blip_charlie_5
				DELETE_OBJECT charlie_5
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_5 = 1
			ENDIF
		ENDIF
		IF flag_charlie_6 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_6
				REMOVE_BLIP blip_charlie_6
				DELETE_OBJECT charlie_6
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_6 = 1
			ENDIF
		ENDIF
		IF flag_charlie_7 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_7
				REMOVE_BLIP blip_charlie_7
				DELETE_OBJECT charlie_7
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_7 = 1
			ENDIF
		ENDIF
		IF flag_charlie_8 = 0
			IF IS_PLAYER_TOUCHING_OBJECT player charlie_8
				REMOVE_BLIP blip_charlie_8
				DELETE_OBJECT charlie_8
				++ counter_charlie
				PRINT_WITH_NUMBER_NOW (AS3_6) counter_charlie 3000 1
				flag_charlie_8 = 1
			ENDIF
		ENDIF

	ENDIF
	
	
ENDWHILE

//loop_as3_8: //------------------------------Stashing the Charlie-----------------------------------

PRINT_NOW (STASH) 4000 1

ADD_BLIP_FOR_COORD 367.25 -328.0 19.5 blip_stash

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player 366.939 -328.025 18.5 1.0 1.0 4.0 true
	WAIT 0
ENDWHILE

REMOVE_BLIP blip_stash
//  ******************************************* START OF CUTSCENE ***************************


MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( AS4 ) 15000 2

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

REQUEST_MODEL csitecutscene

LOAD_SPECIAL_CHARACTER 1 asuka
LOAD_SPECIAL_CHARACTER 2 miguel

LOAD_SPECIAL_MODEL cut_obj1 whip
LOAD_SPECIAL_MODEL cut_obj2 note

/*
WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW
 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED csitecutscene
	WAIT 0
ENDWHILE

LOAD_CUTSCENE a9_asd

SET_CUTSCENE_OFFSET 369.02 -327.5 18.46
  
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel
 
CREATE_CUTSCENE_OBJECT CUT_OBJ1 cs_whip
SET_CUTSCENE_ANIM cs_whip whip
 
CREATE_CUTSCENE_OBJECT CUT_OBJ2 cs_note
SET_CUTSCENE_ANIM cs_note note

//CREATE_CUTSCENE_HEAD cs_miguel CUT_OBJ3 cs_miguelhead
//SET_CUTSCENE_HEAD_ANIM cs_miguelhead miguel

SET_PLAYER_COORDINATES player 373.7523 -327.2676 17.1950
 
SET_PLAYER_HEADING player 270.0
 
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

//------CUTSCENE TEXT-----------------------------
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3000
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (CAT1_A) 5000 1
 
WHILE cs_time < 8000
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (CAT1_B) 4000 1
 
WHILE cs_time < 12444
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
  
CLEAR_PRINTS
 
CLEAR_CUTSCENE
 
//DO_FADE 0 FADE_OUT
 
SET_CAMERA_BEHIND_PLAYER
 
WAIT 500
 
DO_FADE 1500 FADE_IN 
  
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED csitecutscene

SWITCH_RUBBISH ON
// ******************************************END OF CUTSCENE********************************


GOTO mission_as3_passed
	   		


// Mission Asuka Sub3 failed

mission_as3_failed:
PRINT_BIG ( M_FAIL ) 2000 1

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_COMMERCIAL
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_COMMERCIAL
ENDIF

RETURN

   

// mission Asuka Sub3 passed

mission_as3_passed:

flag_asuka_suburban_mission3_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 45000 5000 1
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 45000
REMOVE_BLIP asuka_contact_blip
REMOVE_BLIP maria_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT -362.8 245.9 60.0 RADAR_SPRITE_CAT maria_contact_blip
START_NEW_SCRIPT cat_mission1_loop
REGISTER_MISSION_PASSED AS3
PLAYER_MADE_PROGRESS 1
//START_NEW_SCRIPT asuka_suburban_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_as3:

flag_player_on_mission = 0
flag_player_on_asuka_suburban_mission = 0

CLEAR_ONSCREEN_TIMER timer_as3
REMOVE_BLIP	blip_as3_boat
REMOVE_BLIP blip_as3_dodo
REMOVE_BLIP blip_as3_bouy
REMOVE_BLIP blip_stash

IF NOT HAS_PICKUP_BEEN_COLLECTED rocket_as3
	REMOVE_PICKUP rocket_as3
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED bouy
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_REEFER
MARK_MODEL_AS_NO_LONGER_NEEDED packagelarge
MARK_MODEL_AS_NO_LONGER_NEEDED PLANE_DEADDODO
MARK_MODEL_AS_NO_LONGER_NEEDED PLANE_DODO
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB


MISSION_HAS_FINISHED
RETURN
		

///________________________________GOSUBS_______GOSUBS________________________________BYTHEWAY


baddies:

IF flag_created_baddies = 0
	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1015.0 -1269.0 -100.0 kappa_cartel1
		SET_CHAR_HEADING kappa_cartel1 265.0
		SET_CHAR_THREAT_SEARCH kappa_cartel1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel1 WEAPONTYPE_CHAINGUN 100
		ADD_ARMOUR_TO_CHAR kappa_cartel1 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1013.0 -1260.7 -100.0 kappa_cartel2
		SET_CHAR_HEADING kappa_cartel2 300.0
		SET_CHAR_THREAT_SEARCH kappa_cartel2 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel2 WEAPONTYPE_M16 100
		ADD_ARMOUR_TO_CHAR kappa_cartel2 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel2 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1027.3 -1265.2 -100.0 kappa_cartel3
		SET_CHAR_HEADING kappa_cartel3 265.0
		SET_CHAR_THREAT_SEARCH kappa_cartel3 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel3 WEAPONTYPE_CHAINGUN 100
		ADD_ARMOUR_TO_CHAR kappa_cartel3 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel3 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1380.0 -1043.0 -100.0 kappa_cartel4
		SET_CHAR_HEADING kappa_cartel4 340.0
		SET_CHAR_THREAT_SEARCH kappa_cartel4 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel4 WEAPONTYPE_M16 100
		ADD_ARMOUR_TO_CHAR kappa_cartel4 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel4 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -1392.0 -1043.3 -100.0 kappa_cartel5
		SET_CHAR_HEADING kappa_cartel5 240.0
		SET_CHAR_THREAT_SEARCH kappa_cartel5 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel5 WEAPONTYPE_M16 100
		ADD_ARMOUR_TO_CHAR kappa_cartel5 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel5 true


		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1488.0 -1056.0 -100.0 kappa_cartel6
		SET_CHAR_HEADING kappa_cartel6 110.0
		SET_CHAR_THREAT_SEARCH kappa_cartel6 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel6 WEAPONTYPE_M16 100
		ADD_ARMOUR_TO_CHAR kappa_cartel6 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel6 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1473.0 -1062.0 -100.0 kappa_cartel7
		SET_CHAR_HEADING kappa_cartel7 280.0
		SET_CHAR_THREAT_SEARCH kappa_cartel7 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel7 WEAPONTYPE_M16 100
		ADD_ARMOUR_TO_CHAR kappa_cartel7 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel7 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B -849.0 -1235.0 -100.0 kappa_cartel8
		SET_CHAR_HEADING kappa_cartel8 250.0
		SET_CHAR_THREAT_SEARCH kappa_cartel8 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel8 WEAPONTYPE_CHAINGUN 100
		ADD_ARMOUR_TO_CHAR kappa_cartel8 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 true

		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1478.0 -1055.0 -100.0 kappa_cartel9
		SET_CHAR_HEADING kappa_cartel9 250.0
		SET_CHAR_THREAT_SEARCH kappa_cartel9 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel9 WEAPONTYPE_CHAINGUN 100
		ADD_ARMOUR_TO_CHAR kappa_cartel9 100
		//SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 true

		CREATE_CAR CAR_COLUMB -1019.0 -1263.0 -100.0 cartel_car_a_as1
		SET_CAR_HEADING cartel_car_a_as1 50.0

		CREATE_CAR CAR_COLUMB -1383.3 -1045.0 -100.0 cartel_car_b_as1
		SET_CAR_HEADING cartel_car_b_as1 231.5

		CREATE_CAR CAR_COLUMB -1478.3 -1062.8 -100.0 cartel_car_d_as1
		SET_CAR_HEADING cartel_car_b_as1 250.0
		
		CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1385.3 -1035.0 -100.0 kappa_cartel10
		SET_CHAR_HEADING kappa_cartel10 231.0
		SET_CHAR_THREAT_SEARCH kappa_cartel10 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR kappa_cartel10 WEAPONTYPE_ROCKET 5
		ADD_ARMOUR_TO_CHAR kappa_cartel10 100
		SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 true

		flag_created_baddies = 1
	ENDIF
ENDIF

IF flag_created_baddies = 1
	IF LOCATE_PLAYER_ANY_MEANS_2D player -1019.0 -1263.0 60.0 60.0 false
		IF NOT IS_CHAR_DEAD kappa_cartel3
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel3 player
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player -1385.3 -1035.0 80.0 80.0 false
		IF NOT IS_CHAR_DEAD kappa_cartel4
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel4 player
		ENDIF
		IF NOT IS_CHAR_DEAD kappa_cartel5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel5 player
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player -1478.3 -1062.8 80.0 80.0 false
		IF NOT IS_CHAR_DEAD kappa_cartel6
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel6 player
		ENDIF
		IF NOT IS_CHAR_DEAD kappa_cartel7
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel7 player
		ENDIF
		IF NOT IS_CHAR_DEAD kappa_cartel9
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel9 player
		ENDIF
	ENDIF
ENDIF

RETURN



area_check:

IF dodo_as3_x > killzone_min_x
AND dodo_as3_x < killzone_max_x
	IF dodo_as3_y > killzone_min_y
	AND dodo_as3_y < killzone_max_y
		IF dodo_as3_z > 5.0
		AND dodo_as3_z < 30.0
			flag_mission_as3_failed = 1
		ENDIF
	ENDIF
ENDIF

RETURN

MISSION_START
// *****************************************************************************************
// *******************************    Donald Love 7    ************************************* 
// *******************************    Left the Scene   *************************************
// *****************************************************************************************
// ***************************    	Love has disapeared!   *********************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love7

GOSUB mission_cleanup_love7

MISSION_END
 
// ****************************************Mission Start************************************

mission_start_love7:

flag_player_on_mission = 1
flag_player_on_love_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME love7

// ****************************************START OF CUTSCENE********************************

//SET_FADING_COLOUR 0 0 0
//
//DO_FADE 1500 FADE_OUT
//
//IF CAN_PLAYER_START_MISSION player
//	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
//ELSE
//	GOTO mission_love7_failed
//ENDIF
//
//PRINT_BIG LOVE7	15000 2

REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED tshrorckgrdn
	WAIT 0
ENDWHILE

LOAD_CUTSCENE D7_MLD

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CLEAR_AREA 82.44 -1548.49 28.0 2.0 TRUE

SET_PLAYER_COORDINATES player 82.44 -1548.49 28.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

SWITCH_RUBBISH OFF

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 15000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON
SWITCH_RUBBISH ON

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas

SET_CAMERA_BEHIND_PLAYER

DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

GOTO mission_love7_passed


// Mission Love 7 failed

mission_love7_failed:
RETURN

   

// mission Love 7 passed

mission_love7_passed:

flag_love_mission7_passed = 1
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP love_contact_blip
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED	LOVE7
RETURN
		


// mission cleanup

mission_cleanup_love7:

flag_player_on_mission = 0
flag_player_on_love_mission = 0
		
MISSION_HAS_FINISHED
RETURN
		



MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *************************************Frankie Mission 2.1*********************************
// ************************************Bomb Da Base Cash Wall*******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME frank21

// Mission start stuff

GOSUB mission_start_frankie2.1

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_frankie2.1_failed
	ENDIF

GOSUB mission_cleanup_frankie2.1

MISSION_END

// ***************************************Start Mission*************************************

mission_start_frankie2.1:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_on_frankie_mission = 1

{
// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_frankie2.1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( FM21 ) 15000 2 //"Bomb Da Base Part 1"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 FRANKIE
LOAD_SPECIAL_MODEL cut_obj1 FRANKH
//LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
REQUEST_MODEL PED_GANG_MAFIA_B

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
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
//OR NOT HAS_MODEL_LOADED cut_obj2

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED franksclb02
OR NOT HAS_MODEL_LOADED	salvsdetail
OR NOT HAS_MODEL_LOADED swank_inside

	WAIT 0

ENDWHILE

LOAD_CUTSCENE s3_rtc

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

/*
WHILE cs_time < 27
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_A ) 10000 1 //"We should take these Colombian bastards out"

WHILE cs_time < 1972
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_B ) 10000 1 //"but while we're at war with the Triads we just ain't strong enough"
*/

WHILE cs_time < 5136
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_C ) 10000 1 //"The Cartel has got bottomless funds from pushing this SPANK crap."

WHILE cs_time < 8848
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_D ) 10000 1 //"If we make an open attack on them, they'll wipe the floor with us."

WHILE cs_time < 12450
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_E ) 10000 1 //"They must be making SPANK on that big boat that Curly lead you to."

WHILE cs_time < 15984
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_F ) 10000 1 //"So we gotta use our heads -or rather one head. Your head."

WHILE cs_time < 20426
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_G ) 10000 1 //"I'm asking you to destroy that SPANK factory as a personal favor to me, Salvatore Leone."

WHILE cs_time < 27076
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_H ) 10000 1 //"If you do this for me, you will be a made man -anything you want."

WHILE cs_time < 32651
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_I ) 10000 1 //"Go and see 8-Ball, you'll need his expertise to blow-up that boat."

WHILE cs_time < 36233
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM3_I )

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

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2


MARK_MODEL_AS_NO_LONGER_NEEDED franksclb02

MARK_MODEL_AS_NO_LONGER_NEEDED salvsdetail

MARK_MODEL_AS_NO_LONGER_NEEDED swank_inside

// **************************************END OF CUTSCENE************************************
	
} 
GOTO mission_frankie2.1_passed


// Mission Frankie2.1 failed

mission_frankie2.1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


// mission Frankie2.1 passed

mission_frankie2.1_passed:

flag_frankie_mission2.1_passed = 1
flag_frankie_switched_off = 1
REGISTER_MISSION_PASSED ( FM21 )
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP frankie_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1272.2 -92.9 -100.0 RADAR_SPRITE_EIGHT eightball_contact_blip   
START_NEW_SCRIPT frankie_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_frankie2.1:

flag_player_on_mission = 0
flag_player_on_frankie_mission = 0
MISSION_HAS_FINISHED
RETURN

  
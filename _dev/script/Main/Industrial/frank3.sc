MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *************************************Frankie Mission 3***********************************
// ***************************************"BOMB DA BASE"************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME frank3

// Mission start stuff

GOSUB mission_start_frankie3

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_frankie3_failed
	ENDIF

GOSUB mission_cleanup_frankie3

MISSION_END


// Variables for mission

VAR_INT ped_8ball_fm3

VAR_INT radar_blip_ped2_fm3

VAR_INT radar_blip_coord3_fm3

VAR_INT guard1_fm3

VAR_INT guard2_fm3

VAR_INT guard3_fm3

VAR_INT guard4_fm3

VAR_INT guard5_fm3

VAR_INT guard6_fm3

VAR_INT guard7_fm3

VAR_INT guard8_fm3

VAR_INT guard9_fm3

VAR_INT guard10_fm3

VAR_INT guard11_fm3 

VAR_INT guard12_fm3

VAR_INT car_fm3

VAR_INT timer_fm3

VAR_INT radar_blip_coord2_fm3

VAR_INT flag_bloke_leave_group_fm3

VAR_INT flag_bloke_in_area_fm3

VAR_INT flag_guard1_fm3_dead

VAR_INT flag_guard2_fm3_dead

VAR_INT flag_guard3_fm3_dead

VAR_INT flag_guard4_fm3_dead

VAR_INT flag_guard5_fm3_dead

VAR_INT flag_guard6_fm3_dead

VAR_INT flag_guard7_fm3_dead

VAR_INT flag_guard8_fm3_dead

VAR_INT flag_guard9_fm3_dead

VAR_INT flag_guard10_fm3_dead

VAR_INT flag_guard11_fm3_dead

VAR_INT flag_guard12_fm3_dead

VAR_INT flag_got_message_fm3

VAR_INT flag_on_frankie3

VAR_INT flag_guard3_fm3_created

VAR_INT flag_guard4_fm3_created

VAR_INT flag_guard5_fm3_created

VAR_INT flag_guard6_fm3_created

VAR_INT flag_blip_on_eightball_fm3

// guards told to look for 8ball

VAR_INT flag_guard1_looking_for_8ball

VAR_INT flag_guard2_looking_for_8ball

VAR_INT flag_guard3_looking_for_8ball

VAR_INT flag_guard4_looking_for_8ball

VAR_INT flag_guard5_looking_for_8ball

VAR_INT flag_guard6_looking_for_8ball

VAR_INT flag_guard7_looking_for_8ball

VAR_INT flag_guard8_looking_for_8ball

VAR_INT flag_guard9_looking_for_8ball

VAR_INT flag_guard10_looking_for_8ball

VAR_INT flag_guard11_looking_for_8ball

VAR_INT flag_guard12_looking_for_8ball

VAR_INT flag_8ball_ordered_area1

VAR_INT crate_fm3

VAR_INT flag_drop_crate_fm3

VAR_INT counter_no_guards_dead_fm3  // Check to see if the player is cheating

VAR_INT flag_played_cops_audio_fm3

VAR_INT flag_played_8ball_audio_fm3

VAR_INT flag_gun_help1_fm3

VAR_INT flag_gun_help2_fm3

VAR_INT flag_gun_help3_fm3

VAR_INT flag_timer_fm3

VAR_INT flag_timer2_fm3

VAR_INT flag_timer3_fm3

VAR_INT flag_timer4_fm3

VAR_INT boat_barrel7

VAR_INT boat_barrel8

VAR_INT boat_barrel9

VAR_INT boat_barrel10

VAR_INT boat_barrel11

VAR_INT boat_barrel12

VAR_INT boat_barrel13

VAR_INT boat_barrel14

VAR_INT boat_barrel15

VAR_INT boat_barrel16

VAR_INT boat_barrel17

VAR_FLOAT eightball_x_fm3

VAR_FLOAT eightball_y_fm3

VAR_FLOAT eightball_z_fm3

VAR_INT car_columb1_fm3

VAR_INT car_columb2_fm3

VAR_INT flag_columb_car1_dead

VAR_INT flag_columb_car2_dead

VAR_INT flag_audio_cops_loaded_fm3

VAR_INT flag_timer_set_fm3 // if 8ball gets stuck timer to warp him to his next location

VAR_INT flag_8ball_moved1  // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved2 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved3 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved4 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved5 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved6 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved7 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved8 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved9 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved10 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved11 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_8ball_moved12 // if 8ball gets stuck these will warp him to his next location

VAR_INT flag_car_marked_fm3

VAR_INT flag_8ball_ducking_fm3


// ***************************************Start Mission*************************************

mission_start_frankie3:

flag_player_on_mission = 1

flag_player_on_frankie_mission = 1

WAIT 0

flag_on_frankie3 = 0

flag_bloke_leave_group_fm3 = 0

flag_bloke_in_area_fm3 = 0

timer_fm3 = 25000  // 25 secs

flag_guard1_fm3_dead = 0

flag_guard2_fm3_dead = 0

flag_guard3_fm3_dead = 0

flag_guard4_fm3_dead = 0

flag_guard5_fm3_dead = 0

flag_guard6_fm3_dead = 0

flag_guard7_fm3_dead = 0

flag_guard8_fm3_dead = 0

flag_guard9_fm3_dead = 0

flag_guard10_fm3_dead = 0

flag_guard11_fm3_dead = 0

flag_guard12_fm3_dead = 0

flag_got_message_fm3 = 0

flag_guard3_fm3_created = 0

flag_guard4_fm3_created = 0

flag_guard5_fm3_created = 0

flag_guard6_fm3_created = 0

flag_blip_on_eightball_fm3 = 0

flag_guard1_looking_for_8ball = 0

flag_guard2_looking_for_8ball = 0

flag_guard3_looking_for_8ball = 0

flag_guard4_looking_for_8ball = 0

flag_guard5_looking_for_8ball = 0

flag_guard6_looking_for_8ball = 0

flag_guard7_looking_for_8ball = 0

flag_guard8_looking_for_8ball = 0

flag_guard9_looking_for_8ball = 0

flag_guard10_looking_for_8ball = 0

flag_guard11_looking_for_8ball = 0

flag_guard12_looking_for_8ball = 0

flag_8ball_ordered_area1 = 0

flag_drop_crate_fm3 = 0

counter_no_guards_dead_fm3 = 0

blob_flag = 1

flag_played_cops_audio_fm3 = 0

flag_played_8ball_audio_fm3 = 0

flag_gun_help1_fm3 = 0

flag_gun_help2_fm3 = 0

flag_gun_help3_fm3 = 0

flag_timer_fm3 = 0

flag_timer2_fm3 = 0

flag_timer3_fm3 = 0

flag_timer4_fm3 = 0

eightball_x_fm3 = 0.0

eightball_y_fm3 = 0.0

eightball_z_fm3 = 0.0

flag_columb_car1_dead = 0

flag_columb_car2_dead = 0

flag_audio_cops_loaded_fm3 = 0

flag_timer_set_fm3 = 0

flag_8ball_moved1 = 0

flag_8ball_moved2 = 0

flag_8ball_moved3 = 0

flag_8ball_moved4 = 0

flag_8ball_moved5 = 0

flag_8ball_moved6 = 0

flag_8ball_moved7 = 0

flag_8ball_moved8 = 0

flag_8ball_moved9 = 0

flag_8ball_moved10 = 0

flag_8ball_moved11 = 0

flag_8ball_moved12 = 0

flag_car_marked_fm3 = 0

flag_8ball_ducking_fm3 = 0

{


IF flag_player_had_cut1_fm3 = 1

	IF flag_taken_money_off_fm3 = 1
	OR IS_SCORE_GREATER player 99999
		GOTO player_has_money
	ENDIF

ENDIF
  
player_not_got_money:

CLEAR_AREA 1272.6 -95.6 -100.0 2.0 TRUE


// ************************START OF CUTSCENE TWO "PLAYER NOT GOT THE MONEY"*****************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_frankie3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( FM3 ) 15000 2 //"Bomb Da Base"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 EIGHT2
LOAD_SPECIAL_MODEL cut_obj1 EITDOOR
LOAD_SPECIAL_MODEL cut_obj2 EIGHTH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
REQUEST_MODEL ind_land089c
REQUEST_MODEL mak_semtech
REQUEST_MODEL mak_bomb01

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj1

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED ind_land089c
OR NOT HAS_MODEL_LOADED mak_semtech
OR NOT HAS_MODEL_LOADED mak_bomb01

	WAIT 0
	
ENDWHILE  

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1271.8 -91.3 13.9 3.0 cs8_door FALSE	

LOAD_CUTSCENE s4_bdba

SET_CUTSCENE_OFFSET 1272.5 -90.7 13.8

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_eight

SET_CUTSCENE_ANIM cs_eight eight2

CREATE_CUTSCENE_HEAD cs_eight CUT_OBJ2 cs_eighthead

SET_CUTSCENE_HEAD_ANIM cs_eighthead eight

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_eitdoor

SET_CUTSCENE_ANIM cs_eitdoor EITDOOR

CLEAR_AREA 1272.6 -95.6 -100.0 1.0 TRUE

SET_PLAYER_COORDINATES player 1272.6 -95.6 -100.0

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2849
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8A ) 10000 1 //"Yo my man! Salvatore phoned ahead,"

WHILE cs_time < 5438
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8B ) 10000 1 //"but a job like this is gonna' need a lot of fireworks."

WHILE cs_time < 8136
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8C ) 10000 1 //"I'll need $100000 to cover expenses"

WHILE cs_time < 10752
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8D ) 10000 1 //"but you know with me you get a lot of bang for your bucks."

WHILE cs_time < 13578
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_CC ) 10000 1 //"Come back when you have the money."

WHILE cs_time < 14964
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM3_CC )

WHILE cs_time < 15666
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

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1271.8 -91.3 13.9 3.0 cs8_door TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED ind_land089c
MARK_MODEL_AS_NO_LONGER_NEEDED mak_semtech
MARK_MODEL_AS_NO_LONGER_NEEDED mak_bomb01

// ************************END OF CUTSCENE TWO "PLAYER NOT GOT THE MONEY********************

flag_player_had_cut1_fm3 = 1

GOTO mission_cleanup_frankie3

player_has_money:

CLEAR_AREA 1272.6 -95.6 -100.0 2.0 TRUE

// ********************************START OF CUTSCENE ONE "GOT THE MONEY"********************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_frankie3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( FM3 ) 15000 2 //"Bomb Da Base"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 EIGHT2
LOAD_SPECIAL_MODEL cut_obj1 EITDOOR
LOAD_SPECIAL_MODEL cut_obj2 EIGHTH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 rifle
LOAD_SPECIAL_MODEL cut_obj5	cs_bomb
REQUEST_MODEL ind_land089c
REQUEST_MODEL mak_semtech
REQUEST_MODEL mak_bomb01

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED cut_obj5

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED ind_land089c
OR NOT HAS_MODEL_LOADED mak_semtech
OR NOT HAS_MODEL_LOADED mak_bomb01

	WAIT 0
	
ENDWHILE 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1271.8 -91.3 13.9 3.0 cs8_door FALSE	

LOAD_CUTSCENE s4_bdbb

SET_CUTSCENE_OFFSET 1272.5 -90.7 13.8

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_eight

SET_CUTSCENE_ANIM cs_eight eight2

CREATE_CUTSCENE_HEAD cs_eight CUT_OBJ2 cs_eighthead

SET_CUTSCENE_HEAD_ANIM cs_eighthead eight

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_eitdoor

SET_CUTSCENE_ANIM cs_eitdoor EITDOOR

CREATE_CUTSCENE_OBJECT cut_obj4 cs_rifle

SET_CUTSCENE_ANIM cs_rifle rifle

CREATE_CUTSCENE_OBJECT cut_obj5 cs_bomb

SET_CUTSCENE_ANIM cs_bomb cs_bomb

CLEAR_AREA 1272.6 -95.6 -100.0 1.0 TRUE

SET_PLAYER_COORDINATES player 1272.6 -95.6 -100.0

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3123
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8E ) 10000 1 //"Okay, let's do this thing!"

WHILE cs_time < 4903
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8F ) 10000 1 //"I can set this baby to detonate, but I still can't use a piece with these hands."

WHILE cs_time < 8643
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM3_8G ) 10000 1 //"Here, this rifle should help you pop some heads!"

WHILE cs_time < 10635
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( FM3_8G )

WHILE cs_time < 17000
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

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1271.8 -91.3 13.9 3.0 cs8_door TRUE

//UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ5
MARK_MODEL_AS_NO_LONGER_NEEDED ind_land089c
MARK_MODEL_AS_NO_LONGER_NEEDED mak_semtech
MARK_MODEL_AS_NO_LONGER_NEEDED mak_bomb01


//GOTO wiltest  //TEST STUFF TO COME OUT!!!!!!!!!!!!!!





// ********************************END OF CUTSCENE ONE "GOT THE MONEY"**********************

IF flag_taken_money_off_fm3 = 0
	ADD_SCORE player -100000
	REGISTER_MISSION_GIVEN
	flag_taken_money_off_fm3 = 1
ENDIF


// *********************************START OF THE MISSION STUFF******************************

REQUEST_MODEL PED_GANG_COLOMBIAN_A

REQUEST_MODEL PED_GANG_COLOMBIAN_B

REQUEST_MODEL barrel4

REQUEST_MODEL CAR_COLUMB


WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_B
OR NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
OR NOT HAS_MODEL_LOADED barrel4
OR NOT HAS_MODEL_LOADED CAR_COLUMB
//OR NOT HAS_SPECIAL_CHARACTER_LOADED 1

	WAIT 0

ENDWHILE

SETUP_ZONE_PED_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0
SETUP_ZONE_PED_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

// barrels on the boat 1 - 6, 10 - 14 removed as they were doubles

CREATE_OBJECT barrel4 1535.15 -930.763 18.7294 boat_barrel7

CREATE_OBJECT barrel4 1535.18 -929.604 18.7294 boat_barrel8

CREATE_OBJECT barrel4 1535.21 -928.446 18.7294 boat_barrel9

CREATE_OBJECT barrel4 1484.85 -942.803 18.7328 boat_barrel15

CREATE_OBJECT barrel4 1483.69 -942.752 18.7328 boat_barrel16

CREATE_OBJECT barrel4 1482.53 -942.701 18.7328 boat_barrel17

CLEAR_AREA 1272.8 -96.5 -100.0 1.0 TRUE

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 1272.8 -96.5 -100.0 ped_8ball_fm3

SET_CHAR_HEADING ped_8ball_fm3 270.0

CLEAR_CHAR_THREAT_SEARCH ped_8ball_fm3

CHAR_SET_IDLE ped_8ball_fm3

GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_SNIPERRIFLE 30

SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_SNIPERRIFLE

SET_PLAYER_AS_LEADER ped_8ball_fm3 player

ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP ped_8ball_fm3 player
	AND flag_blip_on_eightball_fm3 = 0
		PRINT_NOW ( HEY3 ) 5000 1 //"You have left 8-ball behind go and get him!"
		ADD_BLIP_FOR_CHAR ped_8ball_fm3 radar_blip_ped2_fm3
		REMOVE_BLIP radar_blip_coord2_fm3
		blob_flag = 0
		flag_blip_on_eightball_fm3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8ball_fm3 8.0 8.0 FALSE
	AND flag_blip_on_eightball_fm3 = 1
		SET_PLAYER_AS_LEADER ped_8ball_fm3 player
		REMOVE_BLIP radar_blip_ped2_fm3
		ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3
		blob_flag = 1
		flag_blip_on_eightball_fm3 = 0
	ENDIF

ENDWHILE

GET_CONTROLLER_MODE controlmode

LOAD_MISSION_AUDIO S3_A

timera = 0

WHILE timera < 7000
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP ped_8ball_fm3 player
	AND flag_blip_on_eightball_fm3 = 0
		PRINT_NOW ( HEY3 ) 5000 1 //"You have left 8-ball behind go and get him!"
		ADD_BLIP_FOR_CHAR ped_8ball_fm3 radar_blip_ped2_fm3
		REMOVE_BLIP radar_blip_coord2_fm3
		blob_flag = 0
		flag_blip_on_eightball_fm3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8ball_fm3 8.0 8.0 FALSE
	AND flag_blip_on_eightball_fm3 = 1
		SET_PLAYER_AS_LEADER ped_8ball_fm3 player
		REMOVE_BLIP radar_blip_ped2_fm3
		ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3
		blob_flag = 1
		flag_blip_on_eightball_fm3 = 0
	ENDIF

	IF flag_gun_help1_fm3 = 0

		IF controlmode = 0
			PRINT_HELP ( HELP7_A ) //"Press and hold the R1 button to target with the sniper rifle."
			flag_gun_help1_fm3 = 1
		ENDIF

		IF controlmode = 1
			PRINT_HELP ( HELP7_A ) //"Press and hold the R1 button to target with the sniper rifle."
			flag_gun_help1_fm3 = 1
		ENDIF

		IF controlmode = 2
			PRINT_HELP ( HELP7_A ) //"Press and hold the R1 button to target with the sniper rifle."
			flag_gun_help1_fm3 = 1
		ENDIF

		IF controlmode = 3
			PRINT_HELP ( HELP7_D ) //"Press and hold the L1 button to target with the sniper rifle."
			flag_gun_help1_fm3 = 1
		ENDIF

	ENDIF

ENDWHILE

GET_CONTROLLER_MODE controlmode

timera = 0

WHILE timera < 7000

	WAIT 0

	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP ped_8ball_fm3 player
	AND flag_blip_on_eightball_fm3 = 0
		PRINT_NOW ( HEY3 ) 5000 1 //"You have left 8-ball behind go and get him!"
		ADD_BLIP_FOR_CHAR ped_8ball_fm3 radar_blip_ped2_fm3
		REMOVE_BLIP radar_blip_coord2_fm3
		blob_flag = 0
		flag_blip_on_eightball_fm3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8ball_fm3 8.0 8.0 FALSE
	AND flag_blip_on_eightball_fm3 = 1
		SET_PLAYER_AS_LEADER ped_8ball_fm3 player
		REMOVE_BLIP radar_blip_ped2_fm3
		ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3
		blob_flag = 1
		flag_blip_on_eightball_fm3 = 0
	ENDIF

	IF flag_gun_help2_fm3 = 0

		IF controlmode = 0
			PRINT_HELP ( HELP8_A ) //"Press the ^ button to zoom in with the rifle and the / button to zoom out again."
			flag_gun_help2_fm3 = 1
		ENDIF

		IF controlmode = 1
			PRINT_HELP ( HELP8_A ) //"Press the ^ button to zoom in with the rifle and the / button to zoom out again."
			flag_gun_help2_fm3 = 1
		ENDIF

		IF controlmode = 2
			PRINT_HELP ( HELP8_B ) //"Press the \ button to zoom in with the rifle and the ^ button to zoom out again."
			flag_gun_help2_fm3 = 1
		ENDIF

		IF controlmode = 3
			PRINT_HELP ( HELP8_A ) //"Press the ^ button to zoom in with the rifle and the / button to zoom out again."
			flag_gun_help2_fm3 = 1
		ENDIF

	ENDIF

ENDWHILE

GET_CONTROLLER_MODE controlmode

timera = 0

WHILE timera < 7000

	WAIT 0

	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP ped_8ball_fm3 player
	AND flag_blip_on_eightball_fm3 = 0
		PRINT_NOW ( HEY3 ) 5000 1 //"You have left 8-ball behind go and get him!"
		ADD_BLIP_FOR_CHAR ped_8ball_fm3 radar_blip_ped2_fm3
		REMOVE_BLIP radar_blip_coord2_fm3
		blob_flag = 0
		flag_blip_on_eightball_fm3 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8ball_fm3 8.0 8.0 FALSE
	AND flag_blip_on_eightball_fm3 = 1
		SET_PLAYER_AS_LEADER ped_8ball_fm3 player
		REMOVE_BLIP radar_blip_ped2_fm3
		ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3
		blob_flag = 1
		flag_blip_on_eightball_fm3 = 0
	ENDIF

	IF flag_gun_help3_fm3 = 0

		IF controlmode = 0
			PRINT_HELP ( HELP9_A ) //"Press the | button to fire the sniper rifle."
			flag_gun_help3_fm3 = 1
		ENDIF

		IF controlmode = 1
			PRINT_HELP ( HELP9_A ) //"Press the | button to fire the sniper rifle."
			flag_gun_help3_fm3 = 1
		ENDIF

		IF controlmode = 2
			PRINT_HELP ( HELP9_B ) //"Press the / button to fire the sniper rifle."
			flag_gun_help3_fm3 = 1
		ENDIF

		IF controlmode = 3
			PRINT_HELP ( HELP9_C ) //"Press the R1 button to fire the sniper rifle."
			flag_gun_help3_fm3 = 1
		ENDIF

	ENDIF

ENDWHILE

//sets up the default guards on the boat

//guard1 on quayside righthand side of the ramp

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1524.0 -900.0 -100.0 guard1_fm3

TURN_CHAR_TO_FACE_COORD guard1_fm3 1524.0 -887.0 -100.0  

GIVE_WEAPON_TO_CHAR guard1_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard1_fm3

SET_CHAR_THREAT_SEARCH guard1_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard1_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard1_fm3 true

//guard2 on quayside left side of the ramp

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1530.0 -901.0 -100.0 guard2_fm3

TURN_CHAR_TO_FACE_COORD guard2_fm3 1530.0 -887.0 -100.0  

GIVE_WEAPON_TO_CHAR guard2_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard2_fm3

SET_CHAR_THREAT_SEARCH guard2_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard2_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard2_fm3 true

//guard3 on boat left hand side by exploding creates

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1534.6 -936.8 18.4 guard3_fm3 //follows route 0

ADD_ROUTE_POINT 0 1533.9 -926.0 -100.0

ADD_ROUTE_POINT 0 1534.6 -936.8 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard3_fm3 0 follow_route_loop 

GIVE_WEAPON_TO_CHAR guard3_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard3_fm3

SET_CHAR_THREAT_SEARCH guard3_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard3_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard3_fm3 true
 

//guard4 on boat walks behind the large containers towards the rear of the shop

CREATE_CHAR	PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1510.2 -941.7 18.4 guard4_fm3  //follows route 1

ADD_ROUTE_POINT 1 1527.5 -942.9 -100.0

ADD_ROUTE_POINT 1 1510.2 -941.7 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard4_fm3 1 follow_route_loop

GIVE_WEAPON_TO_CHAR guard4_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard4_fm3

SET_CHAR_THREAT_SEARCH guard4_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard4_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard4_fm3 true

//guard5 on boat just behid the first row of boxes

CREATE_CHAR	PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1502.6 -926.7 -100.0 guard5_fm3  //follows route 2

ADD_ROUTE_POINT 2 1512.2 -927.6 -100.0

ADD_ROUTE_POINT 2 1502.6 -926.7 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard5_fm3 2 follow_route_loop

GIVE_WEAPON_TO_CHAR guard5_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard5_fm3

SET_CHAR_THREAT_SEARCH guard5_fm3 THREAT_PLAYER1

SET_CHAR_THREAT_SEARCH guard5_fm3 THREAT_SPECIAL

SET_CHAR_PERSONALITY guard5_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard5_fm3 true

//guard6 on boat by the rail of the boat

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1472.5 -917.7 -100.0 guard6_fm3  //follows route 3

ADD_ROUTE_POINT 3 1507.1 -918.7 -100.0

ADD_ROUTE_POINT 3 1472.5 -917.7 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard6_fm3 3 follow_route_loop 

GIVE_WEAPON_TO_CHAR guard6_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard6_fm3

SET_CHAR_THREAT_SEARCH guard6_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard6_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard6_fm3 true


//guard7 on boat end of large boxes by crate 4

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1500.3 -922.2 -100.0 guard7_fm3  //follows route 4

ADD_ROUTE_POINT 4 1499.1 -943.7 -100.0

ADD_ROUTE_POINT 4 1500.3 -922.2 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard7_fm3 4 follow_route_loop 

GIVE_WEAPON_TO_CHAR guard7_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard7_fm3

SET_CHAR_THREAT_SEARCH guard7_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard7_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard7_fm3 true

//Guard8 between second last container and crates 5,6 and 7

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1489.5 -955.8 -100.0 guard8_fm3  //follows route 5

ADD_ROUTE_POINT 5 1490.2 -924.8 -100.0

ADD_ROUTE_POINT 5 1489.5 -955.8 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard8_fm3 5 follow_route_loop 

GIVE_WEAPON_TO_CHAR guard8_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard8_fm3

SET_CHAR_THREAT_SEARCH guard8_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard8_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard8_fm3 true


//guard9 stands on top of crate6 does not patrol

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1484.4 -930.5 19.8 guard9_fm3

TURN_CHAR_TO_FACE_COORD guard9_fm3 1487.8 -925.6 -100.0

GIVE_WEAPON_TO_CHAR guard9_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard9_fm3

SET_CHAR_THREAT_SEARCH guard9_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard9_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard9_fm3 true

//guard10 walks from right hand side boat door to behind containers and back again

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1476.8 -950.9 -100.0 guard10_fm3  //follows route 6

ADD_ROUTE_POINT 6 1476.8 -950.9 -100.0

ADD_ROUTE_POINT 6 1476.8 -927.2 -100.0

SET_CHAR_OBJ_FOLLOW_ROUTE guard10_fm3 6 follow_route_loop 

GIVE_WEAPON_TO_CHAR guard10_fm3 WEAPONTYPE_CHAINGUN 30000 // sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard10_fm3

SET_CHAR_THREAT_SEARCH guard10_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard10_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard10_fm3 true


//guard11 on boat top right of the gang plank

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1524.0 -919.0 -100.0 guard11_fm3

TURN_CHAR_TO_FACE_COORD guard11_fm3 1525.0 -897.0 -100.0

GIVE_WEAPON_TO_CHAR guard11_fm3 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard11_fm3

SET_CHAR_THREAT_SEARCH guard11_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard11_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard11_fm3 true

//guard12 on boat top left hand side of the gang plank

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1529.0 -919.0 -100.0 guard12_fm3

TURN_CHAR_TO_FACE_COORD guard12_fm3 1525.0 -897.0 -100.0

GIVE_WEAPON_TO_CHAR guard12_fm3 WEAPONTYPE_CHAINGUN 30000 // AK47 sets weapon to infinate ammo

CLEAR_CHAR_THREAT_SEARCH guard12_fm3

SET_CHAR_THREAT_SEARCH guard12_fm3 THREAT_PLAYER1

SET_CHAR_PERSONALITY guard12_fm3 PEDSTAT_TOUGH_GUY

SET_CHAR_HEED_THREATS guard12_fm3 true

CREATE_CAR CAR_COLUMB 1534.4 -891.5 10.8 car_columb1_fm3

SET_CAR_HEADING car_columb1_fm3 90.0

CREATE_CAR CAR_COLUMB 1515.7 -896.3 10.8 car_columb2_fm3

SET_CAR_HEADING car_columb2_fm3 314.0 


// waiting for the boat to be destroyed

blob_flag = 1

WHILE NOT flag_bloke_in_area_fm3 = 13 

	WAIT 0

	GOSUB car_dead_check
	
	GOSUB guard_death_check
	
	//GOSUB clear_area_check_fm3	   

	IF flag_bloke_leave_group_fm3 = 0

		IF counter_no_guards_dead_fm3 > 0
			PRINT_NOW ( FM3_8 ) 5000 1 //"The guards have been alerted!"
			GOTO mission_frankie3_failed
		ENDIF

	ENDIF
		
	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ELSE
		GET_CHAR_COORDINATES ped_8ball_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
	ENDIF 
   
	IF flag_bloke_leave_group_fm3 = 0
			
		IF NOT IS_CHAR_IN_PLAYERS_GROUP ped_8ball_fm3 player
		AND flag_blip_on_eightball_fm3 = 0
			PRINT_NOW ( HEY3 ) 5000 1 //"You have left 8-ball behind go and get him!"
			ADD_BLIP_FOR_CHAR ped_8ball_fm3 radar_blip_ped2_fm3
			REMOVE_BLIP radar_blip_coord2_fm3
			blob_flag = 0
			flag_blip_on_eightball_fm3 = 1
		ENDIF
	
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8ball_fm3 8.0 8.0 FALSE
		AND flag_blip_on_eightball_fm3 = 1
			SET_PLAYER_AS_LEADER ped_8ball_fm3 player
			REMOVE_BLIP radar_blip_ped2_fm3
			ADD_BLIP_FOR_COORD 1529.0 -824.0 -100.0 radar_blip_coord2_fm3
		   //	CHANGE_BLIP_DISPLAY radar_blip_coord2_fm3 blip_only 
			blob_flag = 1
			flag_blip_on_eightball_fm3 = 0
		ENDIF

	ENDIF

	IF IS_PLAYER_IN_ANY_CAR player
		STORE_CAR_PLAYER_IS_IN player car_fm3
	ENDIF

	IF IS_CHAR_DEAD ped_8ball_fm3
		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
		GOTO mission_frankie3_failed
	ENDIF

IF flag_bloke_leave_group_fm3 = 0
	
	IF LOCATE_STOPPED_PLAYER_ANY_MEANS_2D player 1529.0 -824.0 3.0 4.0 blob_flag
	AND LOCATE_STOPPED_CHAR_ANY_MEANS_2D ped_8ball_fm3 1529.0 -824.0 3.0 4.0 TRUE
	AND flag_bloke_leave_group_fm3 = 0

		REMOVE_BLIP radar_blip_coord2_fm3
		LEAVE_GROUP ped_8ball_fm3
		flag_bloke_leave_group_fm3 = 1

		SWITCH_WIDESCREEN ON
		SET_PLAYER_CONTROL player OFF
		SET_POLICE_IGNORE_PLAYER player ON
		SET_EVERYONE_IGNORE_PLAYER player ON
	
		IF flag_got_message_fm3 = 0
		AND flag_bloke_leave_group_fm3 = 1
		
			IF flag_played_8ball_audio_fm3 = 0
				PLAY_MISSION_AUDIO
				flag_played_8ball_audio_fm3 = 1
			ENDIF 
	   		PRINT_NOW ( FM3_8I ) 5000 1 //"Get a good vantage point and I'll head in when you fire the first shot."
			ADD_BLIP_FOR_COORD 1498.7 -870.5 -100.0 radar_blip_coord3_fm3
	 		flag_bloke_in_area_fm3 = 1
			flag_got_message_fm3 = 1
		ENDIF

		WHILE NOT HAS_MISSION_AUDIO_FINISHED

			WAIT 0

			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3

			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF

		ENDWHILE

 // Camera looks at the boat and guards		

		SET_FIXED_CAMERA_POSITION 1543.01 -877.81 16.84 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1542.43 -878.62 16.75 JUMP_CUT

		IF flag_timer_fm3 = 0
			timera = 0
			flag_timer_fm3 = 1
		ENDIF

		WHILE timera <= 5000

			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO camera_jump_fm3
			ENDIF  
			
			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3

			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF

		ENDWHILE
		
		CLEAR_AREA 1536.8 -895.0 10.8 1.0 FALSE 
		SET_FIXED_CAMERA_POSITION 1537.1 -899.8 12.5 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1536.4 -900.4 12.7 JUMP_CUT

		IF flag_timer_fm3 = 1
		AND flag_timer2_fm3 = 0
			timera = 0
			flag_timer2_fm3 = 1
		ENDIF
		
		WHILE timera <= 5000

			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO camera_jump_fm3
			ENDIF  
			
			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3

			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF

		ENDWHILE

		CLEAR_AREA 1522.839 -916.137 19.602 1.0 FALSE 
		SET_FIXED_CAMERA_POSITION 1522.839 -916.137 19.602 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1521.984 -916.648 19.699 JUMP_CUT
		
		IF flag_timer3_fm3 = 0
		AND flag_timer2_fm3 = 1
			timera = 0
			flag_timer3_fm3 = 1
		ENDIF

		WHILE timera <= 5000

			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO camera_jump_fm3
			ENDIF

			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3

			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF

		ENDWHILE

		CLEAR_AREA 1476.3 -922.7 19.0 1.0 FALSE
		SET_FIXED_CAMERA_POSITION 1476.3 -922.7 19.0 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1477.1 -923.3 19.1 JUMP_CUT
		
		IF flag_timer4_fm3 = 0
		AND flag_timer3_fm3 = 1
			timera = 0
			flag_timer4_fm3 = 1
		ENDIF

		WHILE timera <= 5000
		
			WAIT 0

			IF IS_BUTTON_PRESSED PAD1 CROSS
				GOTO camera_jump_fm3
			ENDIF

			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3

			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF

		ENDWHILE

camera_jump_fm3:

		RESTORE_CAMERA_JUMPCUT

		GOSUB car_dead_check
	
		GOSUB guard_death_check
	
		GOSUB clear_area_check_fm3

		IF IS_CHAR_DEAD ped_8ball_fm3
			PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
			GOTO mission_frankie3_failed
		ENDIF
		
		// checks to see if the player is in a vehicle

		IF IS_CHAR_IN_ANY_CAR ped_8ball_fm3

			//PRINT_NOW ( FM3_4 ) 7000 1 //"Stop the vehicle and let me out!"

			STORE_CAR_CHAR_IS_IN ped_8ball_fm3 car_fm3
											
			WHILE NOT IS_CAR_STOPPED car_fm3

				WAIT 0

				GOSUB car_dead_check
	
				GOSUB guard_death_check
	
				GOSUB clear_area_check_fm3
			   							
				IF IS_CAR_DEAD car_fm3

					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ELSE
						PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle wrecked!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDIF
								
				IF IS_CHAR_DEAD ped_8ball_fm3
					PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
					GOTO mission_frankie3_failed
				ENDIF

			ENDWHILE
					
			WAIT 0

			GOSUB car_dead_check
	
			GOSUB guard_death_check
	
			GOSUB clear_area_check_fm3
						
			IF IS_CAR_DEAD car_fm3

				IF IS_CHAR_DEAD ped_8ball_fm3
					PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
					GOTO mission_frankie3_failed
				ELSE
					PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle wrecked!"
					GOTO mission_frankie3_failed
				ENDIF

			ENDIF
								
			IF IS_CHAR_DEAD ped_8ball_fm3
				PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
				GOTO mission_frankie3_failed
			ENDIF
			
			SET_CHAR_OBJ_LEAVE_CAR ped_8ball_fm3 car_fm3

				WHILE IS_CHAR_IN_CAR ped_8ball_fm3 car_fm3

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
					
					IF IS_CAR_DEAD car_fm3

						IF IS_CHAR_DEAD ped_8ball_fm3
							PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
							GOTO mission_frankie3_failed
						ELSE
							PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle wrecked!"
							GOTO mission_frankie3_failed
						ENDIF

					ENDIF
								
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

		ENDIF
				
		SWITCH_WIDESCREEN OFF
		SET_PLAYER_CONTROL player ON
		SET_POLICE_IGNORE_PLAYER player OFF
		SET_EVERYONE_IGNORE_PLAYER player OFF
		
	ENDIF
	
ENDIF

// tells players mate to go to his stageing area

IF flag_bloke_in_area_fm3 < 13

	GOSUB car_dead_check
	
	GOSUB guard_death_check
	
	GOSUB clear_area_check_fm3
	
	IF LOCATE_PLAYER_ON_FOOT_3D player 1498.7 -870.5 26.8 3.0 3.0 2.0 FALSE 
		REMOVE_BLIP radar_blip_coord3_fm3
	ENDIF

	IF flag_played_8ball_audio_fm3 = 1
	
		IF flag_played_cops_audio_fm3 = 0	

			IF HAS_MISSION_AUDIO_FINISHED 
				CLEAR_THIS_PRINT ( FM3_8I )
			ENDIF

		ENDIF

	ENDIF

	IF flag_bloke_in_area_fm3 = 1

		IF flag_8ball_ordered_area1 = 0
			SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1545.9 -867.7
			timera = 0
			flag_8ball_ordered_area1 = 1
		ENDIF
		
		IF flag_8ball_moved1 = 0

			IF timera >= 25000
			
				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1545.9 -867.7 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1545.9 -867.7 10.8
					flag_8ball_moved1 = 1
				ENDIF

			ENDIF
					
		ENDIF
		
		IF flag_8ball_ducking_fm3 = 0 
			
			IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1545.9 -867.7 1.0 1.0 FALSE
				flag_8ball_moved1 = 1
				SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 10000
				flag_8ball_ducking_fm3 = 1
			ENDIF

		ENDIF

		IF counter_no_guards_dead_fm3 > 0
		OR IS_PLAYER_SHOOTING_IN_AREA player 1610.6 -614.6 1340.9 -1074.5 FALSE
				
			TIMERB = 0

			WHILE TIMERB < 5000

				WAIT 0

				GOSUB car_dead_check
	
				GOSUB guard_death_check
	
				GOSUB clear_area_check_fm3
				
				IF IS_CHAR_DEAD ped_8ball_fm3
					PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
					GOTO mission_frankie3_failed
				ENDIF

			ENDWHILE

			flag_bloke_in_area_fm3 = 2

			IF flag_car_marked_fm3 = 0
				MARK_CAR_AS_NO_LONGER_NEEDED car_columb1_fm3  
				MARK_CAR_AS_NO_LONGER_NEEDED car_columb2_fm3
			flag_car_marked_fm3 = 1
			ENDIF
			
		ENDIF


	ENDIF

// Bottom of boat ramp 

	IF flag_bloke_in_area_fm3 = 2
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1527.0 -899.0

		IF flag_timer_set_fm3 = 0
			timera = 0
			flag_timer_set_fm3 = 1
		ENDIF
		
		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1527.0 -899.0 2.0 2.0 FALSE
			flag_8ball_moved2 = 1
			flag_bloke_in_area_fm3 = 3
		ENDIF

		IF flag_8ball_moved2 = 0

			IF timera >= 20000
		
				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1527.0 -899.0 2.0 2.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1527.0 -899.0 10.8
					flag_8ball_moved2 = 1
				ENDIF

			ENDIF
			
		ENDIF 	

	ENDIF

// Top of the boat ramp

	IF flag_bloke_in_area_fm3 = 3
					
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1526.0 -919.0

		IF flag_timer_set_fm3 = 1
			timera = 0
			flag_timer_set_fm3 = 2
		ENDIF
		
		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1526.0 -919.0 2.0 2.0 FALSE
			flag_8ball_moved3 = 1
			flag_bloke_in_area_fm3 = 4
		ENDIF

		IF flag_8ball_moved3 = 0

			IF timera >= 20000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1526.0 -919.0 2.0 2.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1526.0 -919.0 18.4
					flag_8ball_moved3 = 1
				ENDIF
			
			ENDIF
			
		ENDIF  

	ENDIF

// create one on the boat
	
	IF flag_bloke_in_area_fm3 = 4
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1522.9 -924.3

		IF flag_timer_set_fm3 = 2
			timera = 0
			flag_timer_set_fm3 = 3
		ENDIF

		IF flag_8ball_moved4 = 0
		
			IF timera >= 25000
			   
				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1522.9 -924.3 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1522.9 -924.3 18.4
					flag_8ball_moved4 = 1
				ENDIF

			ENDIF

		ENDIF
		
		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1522.9 -924.3 1.0 1.0 FALSE

			flag_8ball_moved4 = 1
									
			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 1
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 2
				ENDIF

				TIMERB = 0

				WHILE TIMERB < 5000

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
				
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
				flag_bloke_in_area_fm3 = 5
		ENDIF
		
	ENDIF

// Create two on the boat

	IF flag_bloke_in_area_fm3 = 5
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1517.0 -929.0

		IF flag_timer_set_fm3 = 3
			timera = 0
			flag_timer_set_fm3 = 4
		ENDIF

		IF flag_8ball_moved5 = 0

			IF timera >= 25000
					
				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1517.0 -929.0 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1517.0 -929.0 18.4
					flag_8ball_moved5 = 1
				ENDIF
				
			ENDIF

		ENDIF
		
		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1517.0 -929.0 1.0 1.0 FALSE

			flag_8ball_moved5 = 1

			LOAD_MISSION_AUDIO S3_B

			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 2
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 3
				ENDIF
				
				TIMERB = 0

				WHILE TIMERB < 5000
				
					WAIT 0
					
					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
								
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
			flag_bloke_in_area_fm3 = 6

			IF HAS_MISSION_AUDIO_LOADED
				flag_audio_cops_loaded_fm3 = 1
			ENDIF


			IF flag_played_cops_audio_fm3 = 0

				IF flag_audio_cops_loaded_fm3 = 1
					PLAY_MISSION_AUDIO
					flag_played_cops_audio_fm3 = 1
				ENDIF
								
			ENDIF
			
		ENDIF
		
	ENDIF

// Create three on the boat

	IF flag_bloke_in_area_fm3 = 6
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1510.0 -923.0

		IF flag_timer_set_fm3 = 4
			timera = 0
			flag_timer_set_fm3 = 5
		ENDIF

		IF flag_8ball_moved6 = 0

			IF timera >= 25000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1510.0 -923.0 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1510.0 -923.0 18.4
					flag_8ball_moved6 = 1
				ENDIF
				
			ENDIF
			
		ENDIF  

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1510.0 -923.0 1.0 1.0 FALSE

			flag_8ball_moved6 = 1

			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 3
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 4
				ENDIF

				TIMERB = 0

				WHILE TIMERB < 5000

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
								
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
			flag_bloke_in_area_fm3 = 7
		ENDIF

	ENDIF

// Create four on the boat

	IF flag_bloke_in_area_fm3 = 7
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1504.4 -928.6

		IF flag_timer_set_fm3 = 5
			timera = 0
			flag_timer_set_fm3 = 6
		ENDIF

		IF flag_8ball_moved7 = 0

			IF timera >= 25000
				
				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1504.4 -928.6 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1504.4 -928.6 18.4
					flag_8ball_moved7 = 1
				ENDIF
				
			ENDIF
			
		ENDIF 

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1504.4 -928.6 1.0 1.0 FALSE

			flag_8ball_moved7 = 1

			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 4
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 5
				ENDIF

				TIMERB = 0

				WHILE TIMERB < 5000

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
								
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
			flag_bloke_in_area_fm3 = 8
		ENDIF

	ENDIF

// Create five on the boat

	IF flag_bloke_in_area_fm3 = 8
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1493.7 -922.1

		IF flag_timer_set_fm3 = 6
			timera = 0
			flag_timer_set_fm3 = 7
		ENDIF

		IF flag_8ball_moved8 = 0

			IF timera >= 25000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1493.7 -922.1 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1493.7 -922.1 18.4
					flag_8ball_moved8 = 1
				ENDIF

			ENDIF

		ENDIF
		
		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1493.7 -922.1 1.0 1.0 FALSE

			flag_8ball_moved8 = 1

			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 5
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 6
				ENDIF

				TIMERB = 0

				WHILE TIMERB < 5000

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
			   
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
			flag_bloke_in_area_fm3 = 9
		ENDIF

	ENDIF

// Create six on the boat

	IF flag_bloke_in_area_fm3 = 9
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1487.0 -930.2

		IF flag_timer_set_fm3 = 7
			timera = 0
			flag_timer_set_fm3 = 8
		ENDIF

		IF flag_8ball_moved9 = 0

			IF timera >= 25000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1487.0 -930.2 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1487.0 -930.2 18.4
					flag_8ball_moved9 = 1
				ENDIF
				
			ENDIF
			
		ENDIF  

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1487.0 -930.2 1.0 1.0 FALSE

			flag_8ball_moved9 = 1

			IF counter_no_guards_dead_fm3 < 12

				IF flag_8ball_ducking_fm3 = 6
					SET_CHAR_WAIT_STATE ped_8ball_fm3 WAITSTATE_PLAYANIM_DUCK 5000
					flag_8ball_ducking_fm3 = 7
				ENDIF

				TIMERB = 0

				WHILE TIMERB < 5000

					WAIT 0

					GOSUB car_dead_check
	
					GOSUB guard_death_check
	
					GOSUB clear_area_check_fm3
			   
					IF IS_CHAR_DEAD ped_8ball_fm3
						PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
						GOTO mission_frankie3_failed
					ENDIF

				ENDWHILE

			ENDIF
			flag_bloke_in_area_fm3 = 10
		ENDIF

	ENDIF

// just past crate six

	IF flag_bloke_in_area_fm3 = 10
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1481.5 -926.8

		IF flag_timer_set_fm3 = 8
			timera = 0
			flag_timer_set_fm3 = 9
		ENDIF

		IF flag_8ball_moved10 = 0

			IF timera >= 15000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1481.5 -926.8 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1481.5 -926.8 18.4
					flag_8ball_moved10 = 1
				ENDIF
				
			ENDIF
			
		ENDIF  

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1481.5 -926.8 1.0 1.0 FALSE
			flag_8ball_moved10 = 1
			flag_bloke_in_area_fm3 = 11
		ENDIF

	ENDIF

// Outside the door on the boat

	IF flag_bloke_in_area_fm3 = 11
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1475.8 -940.3

		IF flag_timer_set_fm3 = 9
			timera = 0
			flag_timer_set_fm3 = 10
		ENDIF

		IF flag_8ball_moved11 = 0

			IF timera >= 15000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1475.8 -940.3 1.0 1.0 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1475.8 -940.3 18.4
					flag_8ball_moved11 = 1
				ENDIF
				
			ENDIF
			
		ENDIF  

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1475.8 -940.3 1.0 1.0 FALSE
			flag_8ball_moved11 = 1
			flag_bloke_in_area_fm3 = 12
		ENDIF

	ENDIF

// Inside the door on the boat

	IF flag_bloke_in_area_fm3 = 12
	
		SET_CHAR_OBJ_RUN_TO_COORD ped_8ball_fm3 1474.2 -940.2

		IF flag_timer_set_fm3 = 10
			timera = 0
			flag_timer_set_fm3 = 11
		ENDIF

		IF flag_8ball_moved12 = 0

			IF timera >= 25000

				IF NOT LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1474.2 -940.2 0.5 0.5 FALSE
					SET_CHAR_COORDINATES ped_8ball_fm3 1474.2 -940.2 18.4
					flag_8ball_moved12 = 1
				ENDIF
				
			ENDIF
			
		ENDIF 

		IF LOCATE_CHAR_ON_FOOT_2D ped_8ball_fm3 1474.2 -940.2 0.5 0.5 FALSE

			flag_8ball_moved12 = 1
			CHAR_SET_IDLE ped_8ball_fm3
			flag_bloke_in_area_fm3 = 13
			TIMERB = 0
			WHILE TIMERB < 3000

				WAIT 0

				GOSUB car_dead_check
	
				GOSUB guard_death_check
	
				GOSUB clear_area_check_fm3
				
				IF IS_CHAR_DEAD ped_8ball_fm3
					PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
					GOTO mission_frankie3_failed
				ENDIF

			ENDWHILE
			
		ENDIF

	ENDIF
   
ENDIF

ENDWHILE

// *********waiting for 8ball to place the bomb and then he legs it off of the boat********

timera = 0

WHILE timera < 3000

	WAIT 0

	GOSUB car_dead_check
	
	GOSUB guard_death_check
	
	IF IS_CHAR_DEAD ped_8ball_fm3
   		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
   		GOTO mission_frankie3_failed
   	ENDIF
	
ENDWHILE


// ***********************************BOAT BLOWING UP CUTSCENE******************************

//wiltest:  // TEST STUFF TO COME OUT!!!!!!!!!!!!!!!!!!!!!!!!

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway

	WAIT 0

	IF IS_CHAR_DEAD ped_8ball_fm3
   		PRINT_NOW ( FM3_7 ) 5000 1 //"8-Ball's dead!"
   		GOTO mission_frankie3_failed
   	ENDIF

	GET_GAME_TIMER breakout_timer

	breakout_diff = breakout_timer - breakout_timer_start
	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player 

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

// Cutscene stuff
LOAD_SPECIAL_MODEL cut_obj1 ship
LOAD_SPECIAL_MODEL cut_obj2 gangp
//LOAD_SPECIAL_CHARACTER 1 EIGHT2  // TEST STUFF

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE


REMOVE_CHAR_ELEGANTLY guard1_fm3
REMOVE_CHAR_ELEGANTLY guard2_fm3
REMOVE_CHAR_ELEGANTLY guard3_fm3
REMOVE_CHAR_ELEGANTLY guard4_fm3
REMOVE_CHAR_ELEGANTLY guard5_fm3
REMOVE_CHAR_ELEGANTLY guard6_fm3
REMOVE_CHAR_ELEGANTLY guard7_fm3
REMOVE_CHAR_ELEGANTLY guard8_fm3
REMOVE_CHAR_ELEGANTLY guard9_fm3
REMOVE_CHAR_ELEGANTLY guard10_fm3
REMOVE_CHAR_ELEGANTLY guard11_fm3
REMOVE_CHAR_ELEGANTLY guard12_fm3


CLEAR_AREA 1519.02 -934.60 18.4 25.0 TRUE


DELETE_OBJECT boat_barrel7
DELETE_OBJECT boat_barrel8
DELETE_OBJECT boat_barrel9
DELETE_OBJECT boat_barrel15
DELETE_OBJECT boat_barrel16
DELETE_OBJECT boat_barrel17


LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
//OR NOT HAS_SPECIAL_CHARACTER_LOADED 1 // TEST STUFF

	WAIT 0

ENDWHILE

// Swaps boat for building lod then sets boat lod to invisible

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE  1508.77 -937.206 20.6832 50.0 rustship_structure FALSE

SWAP_NEAREST_BUILDING_MODEL  1508.77 -937.206 20.6832 50.0 rustship_structure LOD_land014

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE  1508.77 -937.206 20.6832 50.0 LODtship_structure FALSE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1526.75 -907.423 14.2965 50.0 boatramp1 FALSE

SWAP_NEAREST_BUILDING_MODEL 1526.75 -907.423 14.2965 50.0 boatramp1 LOD_land014

LOAD_CUTSCENE s4_bdbd

SET_CUTSCENE_OFFSET 1573.8866 -906.0611 11.1

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_eight

SET_CUTSCENE_ANIM cs_eight eight2

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ship

SET_CUTSCENE_ANIM cs_ship ship

CREATE_CUTSCENE_OBJECT cut_obj2 cs_gangplank

SET_CUTSCENE_ANIM cs_gangplank gangp

CLEAR_AREA 1526.5 -894.8 -100.0 1.0 TRUE

SET_PLAYER_COORDINATES player 1526.5 -894.8 -100.0

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

DELETE_CHAR ped_8ball_fm3 

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

START_BOAT_FOAM_ANIMATION

UPDATE_BOAT_FOAM_ANIMATION cs_ship 

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1478.48 -936.52 20.4 EXPLOSION_HELI

WHILE cs_time < 2565
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1479.48 -936.52 20.4 EXPLOSION_HELI

WHILE cs_time < 3433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1481.48 -936.52 20.4 EXPLOSION_HELI

WHILE cs_time < 4433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1487.92 -933.90 20.4 EXPLOSION_HELI

WHILE cs_time < 5833
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1490.70 -928.15 20.4 EXPLOSION_HELI

WHILE cs_time < 6433 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1595.53 -921.84 20.4 EXPLOSION_HELI

WHILE cs_time < 7433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1500.53 -921.84 20.4 EXPLOSION_HELI

WHILE cs_time < 8433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1502.53 -921.84 20.4 EXPLOSION_HELI

WHILE cs_time < 9633
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1510.5 -918.2 20.4 EXPLOSION_HELI

WHILE cs_time < 12833
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1510.5 -918.2 20.4 EXPLOSION_HELI

WHILE cs_time < 13000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
ENDWHILE

ADD_EXPLOSION 1518.02 -931.86 19.4 EXPLOSION_HELI

WHILE cs_time < 33333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	UPDATE_BOAT_FOAM_ANIMATION cs_ship
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
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

// *****************************END OF BOAT BLOWING UP CUTSCENE*****************************

GOTO mission_frankie3_passed

}
	   		
// Mission Failed stuff

mission_frankie3_failed:

SET_PLAYER_AMMO player WEAPONTYPE_SNIPERRIFLE 0

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


// mission Frankie3 passed

mission_frankie3_passed:

flag_frankie_mission3_passed = 1
REGISTER_MISSION_PASSED ( FM3 )
PLAYER_MADE_PROGRESS 1
CANCEL_OVERRIDE_RESTART 
PRINT_WITH_NUMBER_BIG ( m_pass ) 150000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 150000
CLEAR_WANTED_LEVEL player
REMOVE_BLIP eightball_contact_blip
flag_frankie_switched_off = 0
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
START_NEW_SCRIPT frankie_mission4_loop
START_NEW_SCRIPT emergency_crane_pager
RETURN
		


// mission cleanup

mission_cleanup_frankie3:

flag_player_on_mission = 0
flag_player_on_frankie_mission = 0
flag_on_frankie3 = 0
IF NOT IS_CHAR_DEAD guard1_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard1_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard2_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard2_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard3_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard3_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard4_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard4_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard5_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard5_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard6_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard6_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard7_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard7_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard8_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard8_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard9_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard9_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard10_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard10_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard11_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard11_fm3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD guard12_fm3
	SET_CHAR_STAY_IN_SAME_PLACE guard12_fm3 FALSE
ENDIF

REMOVE_CHAR_ELEGANTLY ped_8ball_fm3
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_CHAR_AS_NO_LONGER_NEEDED ped_8ball_fm3
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
REMOVE_BLIP radar_blip_coord2_fm3
REMOVE_BLIP radar_blip_coord3_fm3
CLEAR_ONSCREEN_TIMER timer_fm3
REMOVE_ROUTE 0
REMOVE_ROUTE 1
REMOVE_ROUTE 2
REMOVE_ROUTE 3
REMOVE_ROUTE 4
REMOVE_ROUTE 5
REMOVE_ROUTE 6
SETUP_ZONE_PED_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0
SETUP_ZONE_PED_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E DAY 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
SETUP_ZONE_CAR_INFO PORT_E NIGHT 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
DELETE_OBJECT boat_barrel7
DELETE_OBJECT boat_barrel8
DELETE_OBJECT boat_barrel9
DELETE_OBJECT boat_barrel15
DELETE_OBJECT boat_barrel16
DELETE_OBJECT boat_barrel17
MISSION_HAS_FINISHED
RETURN




guard_death_check:


// guard1

	IF flag_guard1_fm3_dead = 0

		IF IS_CHAR_DEAD guard1_fm3
			flag_guard1_fm3_dead = 1
			++ counter_no_guards_dead_fm3
	  	ELSE

			IF flag_guard1_looking_for_8ball = 0

				IF flag_bloke_in_area_fm3 = 2
				OR flag_guard2_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1

					IF flag_columb_car2_dead = 0 
						SET_CHAR_OBJ_RUN_TO_COORD guard1_fm3 1517.6 -896.6
					ELSE
						SET_CHAR_OBJ_RUN_TO_COORD guard1_fm3 1523.3 -893.7
					ENDIF
					SET_CHAR_THREAT_SEARCH guard1_fm3 THREAT_SPECIAL  //Guard now looks out for 8-ball
					flag_guard1_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard1_looking_for_8ball = 1

				IF flag_columb_car2_dead = 0 

					IF LOCATE_CHAR_ON_FOOT_3D guard1_fm3 1517.6 -896.6 10.8 0.5 0.5 2.0 FALSE
						SET_CHAR_OBJ_GUARD_SPOT guard1_fm3 1517.6 -896.6 10.8
						SET_CHAR_STAY_IN_SAME_PLACE guard1_fm3 TRUE
						TURN_CHAR_TO_FACE_COORD guard1_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					ENDIF

				ELSE
					
					IF LOCATE_CHAR_ON_FOOT_3D guard1_fm3 1523.3 -893.7 10.8 0.5 0.5 2.0 FALSE
						SET_CHAR_OBJ_GUARD_SPOT guard1_fm3 1523.3 -893.7 10.8
						SET_CHAR_STAY_IN_SAME_PLACE guard1_fm3 TRUE
						TURN_CHAR_TO_FACE_COORD guard1_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					ENDIF 

				ENDIF

			ENDIF
			
		ENDIF
	  				
	ENDIF

// guard2

	IF flag_guard2_fm3_dead = 0

		IF IS_CHAR_DEAD guard2_fm3
			flag_guard2_fm3_dead = 1
			++ counter_no_guards_dead_fm3
	  	ELSE	
			
			IF flag_guard2_looking_for_8ball = 0

				IF flag_bloke_in_area_fm3 = 2
				OR flag_guard1_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					
					IF flag_columb_car1_dead =  0 
						SET_CHAR_OBJ_RUN_TO_COORD guard2_fm3 1532.9 -893.8
					ELSE
						SET_CHAR_OBJ_RUN_TO_COORD guard2_fm3 1528.6 -892.2	
					ENDIF
					SET_CHAR_THREAT_SEARCH guard2_fm3 THREAT_SPECIAL  //Guard now looks out for 8-ball
					flag_guard2_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard2_looking_for_8ball = 1

				IF flag_columb_car1_dead =  0 

					IF LOCATE_CHAR_ON_FOOT_3D guard2_fm3 1532.9 -893.8 10.8 0.5 0.5 2.0 FALSE
						SET_CHAR_OBJ_GUARD_SPOT guard2_fm3 1532.9 -893.8 10.8 
						TURN_CHAR_TO_FACE_COORD guard2_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
						SET_CHAR_STAY_IN_SAME_PLACE guard2_fm3 TRUE
					ENDIF

				ELSE
					
					IF LOCATE_CHAR_ON_FOOT_3D guard2_fm3 1528.6 -892.2 10.8 0.5 0.5 2.0 FALSE
						SET_CHAR_OBJ_GUARD_SPOT guard2_fm3 1528.6 -892.2 10.8 
						TURN_CHAR_TO_FACE_COORD guard2_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
						SET_CHAR_STAY_IN_SAME_PLACE guard2_fm3 TRUE
					ENDIF
				
				ENDIF
				
			ENDIF	 

		ENDIF
	  				
	ENDIF

// guard3

	IF flag_guard3_fm3_dead = 0
		
		IF IS_CHAR_DEAD guard3_fm3
			flag_guard3_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE

			IF flag_guard3_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 = 2  //8ball has reached the gangplank of the boat
				OR counter_no_guards_dead_fm3 > 0
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					SET_CHAR_THREAT_SEARCH guard3_fm3 THREAT_SPECIAL //Guard3 now looks out for 8-ball
					SET_CHAR_OBJ_RUN_TO_COORD guard3_fm3 1534.1 -931.2
					flag_guard3_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard3_looking_for_8ball = 1

				IF LOCATE_CHAR_ON_FOOT_3D guard3_fm3 1534.1 -931.2 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard3_fm3 1534.1 -931.2 18.4
					TURN_CHAR_TO_FACE_COORD guard3_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard3_fm3 TRUE
					//flag_guard3_looking_for_8ball = 2
				ENDIF
				
			ENDIF
		   			
		ENDIF

	ENDIF

// guard4
	
	IF flag_guard4_fm3_dead = 0
	
		IF IS_CHAR_DEAD guard4_fm3
			flag_guard4_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
			
			IF flag_guard4_looking_for_8ball = 0

				IF flag_bloke_in_area_fm3 =	4 //8-ball has reached the second create on the boat
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
				OR counter_no_guards_dead_fm3 > 0
					SET_CHAR_OBJ_RUN_TO_COORD guard4_fm3 1517.5 -940.6
					SET_CHAR_THREAT_SEARCH guard4_fm3 THREAT_SPECIAL //Guard4 now looks out for 8-ball
					flag_guard4_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard4_looking_for_8ball = 1
			
				IF LOCATE_CHAR_ANY_MEANS_3D guard4_fm3 1517.5 -940.6 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard4_fm3 1516.1 -932.6
					flag_guard4_looking_for_8ball = 2
				ENDIF
				
			ENDIF
			
			IF flag_guard4_looking_for_8ball = 2
			
				IF LOCATE_CHAR_ANY_MEANS_3D guard4_fm3 1516.1 -932.6 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard4_fm3 1516.1 -932.6 18.4
					TURN_CHAR_TO_FACE_COORD guard4_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard4_fm3 TRUE	  
				ENDIF
			
			ENDIF
			
		ENDIF

		

	ENDIF

// Guard5

	IF flag_guard5_fm3_dead = 0
		
		IF IS_CHAR_DEAD guard5_fm3
			flag_guard5_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE

			IF flag_guard5_looking_for_8ball = 0

				IF flag_bloke_in_area_fm3 = 5
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
				OR flag_guard6_fm3_dead = 1
				OR flag_guard7_fm3_dead = 1
				 	SET_CHAR_OBJ_RUN_TO_COORD guard5_fm3 1505.6 -926.1
					SET_CHAR_THREAT_SEARCH guard5_fm3 THREAT_SPECIAL //Guard5 now looks out for 8-ball
					flag_guard5_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard5_looking_for_8ball = 1

				IF LOCATE_CHAR_ANY_MEANS_3D guard5_fm3 1505.6 -926.1 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard5_fm3 1507.2 -924.0
					flag_guard5_looking_for_8ball = 2
				ENDIF
				
			ENDIF
			
			IF flag_guard5_looking_for_8ball = 2
			
				IF LOCATE_CHAR_ANY_MEANS_3D guard5_fm3 1507.2 -924.0 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard5_fm3 1507.2 -924.0 18.4
					TURN_CHAR_TO_FACE_COORD guard5_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard5_fm3 TRUE
				ENDIF
				
			ENDIF	 

		ENDIF
			
	ENDIF

// Guard6

	IF flag_guard6_fm3_dead = 0

		IF IS_CHAR_DEAD guard6_fm3
			flag_guard6_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
		
			IF flag_guard6_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 = 5
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
				OR flag_guard5_fm3_dead = 1
				OR flag_guard7_fm3_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard6_fm3 1501.0 -919.8
					SET_CHAR_THREAT_SEARCH guard6_fm3 THREAT_SPECIAL //Guard6 now looks out for 8-ball
					flag_guard6_looking_for_8ball = 1
				ENDIF
								
			ENDIF

			IF flag_guard6_looking_for_8ball = 1

				IF LOCATE_CHAR_ANY_MEANS_3D guard6_fm3 1501.0 -919.8 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard6_fm3 1501.0 -919.8 18.4
					TURN_CHAR_TO_FACE_COORD guard6_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard6_fm3 TRUE
				ENDIF
				
			ENDIF	

		ENDIF

	ENDIF

// Guard7

IF flag_guard7_fm3_dead = 0

		IF IS_CHAR_DEAD guard7_fm3
			flag_guard7_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
		
			IF flag_guard7_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 = 5
				OR flag_guard5_fm3_dead = 1
				OR flag_guard6_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard7_fm3 1499.4 -937.8
					SET_CHAR_THREAT_SEARCH guard7_fm3 THREAT_SPECIAL //Guard7 now looks out for 8-ball
					flag_guard7_looking_for_8ball = 1
				ENDIF
								
			ENDIF

			IF flag_guard7_looking_for_8ball = 1

				IF LOCATE_CHAR_ANY_MEANS_3D guard7_fm3 1499.4 -937.8 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard7_fm3 1502.2 -930.8
					flag_guard7_looking_for_8ball = 2
				ENDIF

			ENDIF

			IF flag_guard7_looking_for_8ball = 2

				IF LOCATE_CHAR_ANY_MEANS_3D guard7_fm3 1502.2 -930.8 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard7_fm3 1502.2 -930.8 18.4
					TURN_CHAR_TO_FACE_COORD guard7_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard7_fm3 TRUE
				ENDIF
			
			ENDIF	 

		ENDIF

	ENDIF

// Guard8

IF flag_guard8_fm3_dead = 0

		IF IS_CHAR_DEAD guard8_fm3
			flag_guard8_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
		
			IF flag_guard8_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 =	 5
				OR flag_guard9_fm3_dead = 1
				OR flag_guard10_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard8_fm3 1491.6 -935.8
					SET_CHAR_THREAT_SEARCH guard8_fm3 THREAT_SPECIAL //Guard8 now looks out for 8-ball
					flag_guard8_looking_for_8ball = 1
				ENDIF
								
			ENDIF

			IF flag_guard8_looking_for_8ball = 1

				IF LOCATE_CHAR_ANY_MEANS_3D guard8_fm3 1491.6 -935.8 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard8_fm3 1487.6 -933.6
					flag_guard8_looking_for_8ball = 2
				ENDIF

			ENDIF

			IF flag_guard8_looking_for_8ball = 2

				IF LOCATE_CHAR_ANY_MEANS_3D guard8_fm3 1487.6 -933.6 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard8_fm3 1487.6 -933.6 18.4
					TURN_CHAR_TO_FACE_COORD guard8_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard8_fm3 TRUE
				ENDIF
				
			ENDIF	

		ENDIF

	ENDIF

// Guard9

IF flag_guard9_fm3_dead = 0

		IF IS_CHAR_DEAD guard9_fm3
			flag_guard9_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
		
			IF flag_guard9_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 = 6
				OR flag_guard8_fm3_dead = 1
				OR flag_guard10_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					SET_CHAR_OBJ_GUARD_SPOT guard9_fm3 1484.4 -930.5 19.8
					SET_CHAR_THREAT_SEARCH guard9_fm3 THREAT_SPECIAL //Guard9 now looks out for 8-ball
					SET_CHAR_STAY_IN_SAME_PLACE guard9_fm3 TRUE
					TURN_CHAR_TO_FACE_COORD guard9_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					flag_guard9_looking_for_8ball = 1
				ENDIF
								
			ENDIF

		ENDIF

	ENDIF

// Guard10

IF flag_guard10_fm3_dead = 0

		IF IS_CHAR_DEAD guard10_fm3
			flag_guard10_fm3_dead = 1
			++ counter_no_guards_dead_fm3
		ELSE
		
			IF flag_guard10_looking_for_8ball = 0
			
				IF flag_bloke_in_area_fm3 = 6
				OR flag_guard8_fm3_dead = 1
				OR flag_guard9_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard10_fm3 1476.7 -936.3
					SET_CHAR_THREAT_SEARCH guard10_fm3 THREAT_SPECIAL //Guard10 now looks out for 8-ball
					flag_guard10_looking_for_8ball = 1
				ENDIF
								
			ENDIF

			IF flag_guard10_looking_for_8ball = 1

				IF LOCATE_CHAR_ANY_MEANS_3D guard10_fm3 1476.7 -936.3 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard10_fm3 1482.6 -930.5
					flag_guard10_looking_for_8ball = 2
				ENDIF

			ENDIF

			IF flag_guard10_looking_for_8ball = 2

				IF LOCATE_CHAR_ANY_MEANS_3D guard10_fm3 1482.6 -930.5 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard10_fm3 1482.6 -930.5 18.4
					TURN_CHAR_TO_FACE_COORD guard10_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard10_fm3 TRUE
				ENDIF
				
			ENDIF	

		ENDIF

	ENDIF

// Guard11

	IF flag_guard11_fm3_dead = 0

		IF IS_CHAR_DEAD guard11_fm3
			flag_guard11_fm3_dead = 1
			++ counter_no_guards_dead_fm3
	  	ELSE

			IF flag_guard11_looking_for_8ball = 0

				IF flag_bloke_in_area_fm3 = 2
				OR flag_guard12_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
				OR flag_guard1_fm3_dead = 1
				OR flag_guard2_fm3_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard11_fm3 1528.5 -927.5 
					SET_CHAR_THREAT_SEARCH guard11_fm3 THREAT_SPECIAL  //Guard now looks out for 8-ball
					flag_guard11_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard11_looking_for_8ball = 1
				
				IF LOCATE_CHAR_ANY_MEANS_3D guard11_fm3 1528.5 -927.5 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard11_fm3 1521.5 -927.2
					flag_guard11_looking_for_8ball = 2
				ENDIF

			ENDIF

			IF flag_guard11_looking_for_8ball = 2

				IF LOCATE_CHAR_ANY_MEANS_3D guard11_fm3 1521.5 -927.2 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard11_fm3 1521.5 -927.2 18.4
					TURN_CHAR_TO_FACE_COORD guard11_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard11_fm3 TRUE
				ENDIF
				
			ENDIF 

		ENDIF
	  				
	ENDIF

// Guard12

	IF flag_guard12_fm3_dead = 0

		IF IS_CHAR_DEAD guard12_fm3
			flag_guard12_fm3_dead = 1
			++ counter_no_guards_dead_fm3
	  	ELSE

			IF flag_guard12_looking_for_8ball = 0
				
				IF flag_bloke_in_area_fm3 = 2
				OR flag_guard11_fm3_dead = 1
				OR flag_columb_car1_dead = 1
				OR flag_columb_car2_dead = 1
				OR flag_guard1_fm3_dead = 1
				OR flag_guard2_fm3_dead = 1
					SET_CHAR_OBJ_RUN_TO_COORD guard12_fm3 1517.6 -923.1
					SET_CHAR_THREAT_SEARCH guard12_fm3 THREAT_SPECIAL  //Guard now looks out for 8-ball
					flag_guard12_looking_for_8ball = 1
				ENDIF

			ENDIF

			IF flag_guard12_looking_for_8ball = 1
			
				IF LOCATE_CHAR_ANY_MEANS_3D guard12_fm3 1517.6 -923.1 18.4 0.5 0.5 2.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD guard12_fm3 1512.7 -929.0
					flag_guard12_looking_for_8ball = 2
				ENDIF
				
			ENDIF
			
			IF flag_guard12_looking_for_8ball = 2
				
				IF LOCATE_CHAR_ANY_MEANS_3D guard12_fm3 1512.7 -929.0 18.4 0.2 0.2 2.0 FALSE
					SET_CHAR_OBJ_GUARD_SPOT guard12_fm3 1512.7 -929.0 18.4
					TURN_CHAR_TO_FACE_COORD guard12_fm3 eightball_x_fm3 eightball_y_fm3 eightball_z_fm3
					SET_CHAR_STAY_IN_SAME_PLACE guard12_fm3 TRUE
				ENDIF
				
			ENDIF	 

		ENDIF
	  				
	ENDIF
				
RETURN


car_dead_check:

	IF flag_columb_car1_dead = 0
	
		IF IS_CAR_DEAD car_columb1_fm3
			flag_columb_car1_dead = 1
		ENDIF
		
	ENDIF
	
	IF flag_columb_car2_dead = 0
	
		IF IS_CAR_DEAD car_columb2_fm3
			flag_columb_car2_dead = 1
		ENDIF
		
	ENDIF

RETURN

clear_area_check_fm3:

IF flag_bloke_in_area_fm3 <= 2
	CLEAR_AREA 1545.9 -867.7 10.8 1.0 FALSE
	CLEAR_AREA 1527.0 -899.0 10.8 1.0 FALSE
	CLEAR_AREA 1526.0 -919.0 18.4 1.0 FALSE
	CLEAR_AREA 1522.9 -924.3 18.4 1.0 FALSE
	CLEAR_AREA 1517.0 -929.0 18.4 1.0 FALSE
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF
	
IF flag_bloke_in_area_fm3 = 3
	CLEAR_AREA 1527.0 -899.0 10.8 1.0 FALSE
	CLEAR_AREA 1526.0 -919.0 18.4 1.0 FALSE
	CLEAR_AREA 1522.9 -924.3 18.4 1.0 FALSE
	CLEAR_AREA 1517.0 -929.0 18.4 1.0 FALSE
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 4
	CLEAR_AREA 1526.0 -919.0 18.4 1.0 FALSE
	CLEAR_AREA 1522.9 -924.3 18.4 1.0 FALSE
	CLEAR_AREA 1517.0 -929.0 18.4 1.0 FALSE
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 5
	CLEAR_AREA 1522.9 -924.3 18.4 1.0 FALSE
	CLEAR_AREA 1517.0 -929.0 18.4 1.0 FALSE
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 6
	CLEAR_AREA 1517.0 -929.0 18.4 1.0 FALSE
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 7
	CLEAR_AREA 1510.0 -923.0 18.4 1.0 FALSE
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 8
	CLEAR_AREA 1504.4 -928.6 18.4 1.0 FALSE
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 9
	CLEAR_AREA 1493.7 -922.1 18.4 1.0 FALSE
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 10
	CLEAR_AREA 1487.0 -930.2 18.4 1.0 FALSE
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF


IF flag_bloke_in_area_fm3 = 11
	CLEAR_AREA 1481.5 -926.8 18.4 1.0 FALSE
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

IF flag_bloke_in_area_fm3 = 12
	CLEAR_AREA 1475.8 -940.3 18.4 1.0 FALSE
	CLEAR_AREA 1474.2 -940.2 18.4 1.0 FALSE
ENDIF

RETURN
 
 
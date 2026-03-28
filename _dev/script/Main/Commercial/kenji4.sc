MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Kenji mission 4********************************* 
// *********************************************"Shima"*************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME kenji4

// Mission start stuff

GOSUB mission_start_kenji4

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_kenji4_failed
	ENDIF

GOSUB mission_cleanup_kenji4

MISSION_END
 
// Variables for mission

VAR_INT briefcase1_km4

VAR_INT briefcase2_km4

VAR_INT briefcase3_km4

VAR_INT hispanic1_km4

VAR_INT hispanic2_km4

VAR_INT hispanic3_km4

VAR_INT hispanic4_km4

VAR_INT hispanic5_km4

VAR_INT hispanic6_km4

VAR_INT radar_blip_coord2_km4

VAR_INT radar_blip_coord3_km4

VAR_INT radar_blip_coord4_km4

VAR_INT radar_blip_coord5_km4

VAR_INT radar_blip_ped_km4

VAR_INT radar_blip_coord1_km4

VAR_INT counter_number_of_hispanics_dead

VAR_INT flag_hispanic1_km4_dead

VAR_INT flag_hispanic2_km4_dead

VAR_INT flag_hispanic3_km4_dead

VAR_INT flag_hispanic4_km4_dead

VAR_INT flag_hispanic5_km4_dead

VAR_INT flag_hispanic6_km4_dead

VAR_INT flag_briefcase3_pickedup_km4

VAR_INT flag_hispanic1_hate_player_km4

VAR_INT flag_hispanic2_hate_player_km4

VAR_INT flag_hispanic3_hate_player_km4

VAR_INT flag_hispanic4_hate_player_km4

VAR_INT flag_hispanic5_hate_player_km4

VAR_INT radar_blip_diablo1_km4

VAR_INT radar_blip_diablo2_km4

VAR_INT radar_blip_diablo3_km4

VAR_INT radar_blip_diablo4_km4

VAR_INT radar_blip_diablo5_km4

VAR_INT radar_blip_dummy1_km4

VAR_INT radar_blip_dummy2_km4

VAR_INT radar_blip_dummy3_km4

VAR_INT radar_blip_dummy4_km4

VAR_INT radar_blip_dummy5_km4

VAR_INT flag_player_had_message_km4

VAR_INT car_km4

VAR_INT flag_briefcase1_created_km4

VAR_INT flag_briefcase2_created_km4

VAR_INT flag_briefcase3_created_km4

VAR_INT flag_briefcase1_collected_km4

VAR_INT flag_briefcase2_collected_km4

VAR_INT flag_briefcase3_collected_km4

VAR_INT radar_blip_coord6_km4

VAR_INT car_cut_km4

// ****************************************Mission Start************************************

mission_start_kenji4:

flag_player_on_mission = 1

flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

counter_number_of_hispanics_dead = 0

flag_hispanic1_km4_dead = 0

flag_hispanic2_km4_dead = 0

flag_hispanic3_km4_dead = 0

flag_hispanic4_km4_dead = 0

flag_hispanic5_km4_dead = 0

flag_hispanic6_km4_dead = 0

flag_briefcase3_pickedup_km4 = 0

flag_hispanic1_hate_player_km4 = 0

flag_hispanic2_hate_player_km4 = 0

flag_hispanic3_hate_player_km4 = 0

flag_hispanic4_hate_player_km4 = 0

flag_hispanic5_hate_player_km4 = 0

switch_gang_diablo_off = 1

flag_player_had_message_km4 = 0

flag_briefcase1_created_km4 = 0

flag_briefcase2_created_km4 = 0

flag_briefcase3_created_km4 = 0

flag_briefcase1_collected_km4 = 0

flag_briefcase2_collected_km4 = 0

flag_briefcase3_collected_km4 = 0

SWAP_NEAREST_BUILDING_MODEL -88.371 -487.666 15.166 50.0 convstore01 convstre_dmge01

{
// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_kenji4_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( KM4 ) 15000 2  //"SHIMA"

SWITCH_STREAMING OFF
*/

// Cutscene stuff

LOAD_SPECIAL_CHARACTER 1 KENJI
REQUEST_MODEL PED_GANG_YAKUZA_A 
LOAD_SPECIAL_MODEL cut_obj1 KENJIH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
REQUEST_MODEL casino_garden

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A 
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED casino_garden
	
	WAIT 0

ENDWHILE

LOAD_CUTSCENE k4_shi

SET_CUTSCENE_OFFSET 476.380 -1382.168 67.347

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_kenji

SET_CUTSCENE_ANIM cs_kenji kenji

CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_A cs_yakuza

SET_CUTSCENE_ANIM cs_yakuza gang07

CREATE_CUTSCENE_HEAD cs_kenji CUT_OBJ1 cs_kenjihead

SET_CUTSCENE_HEAD_ANIM cs_kenjihead kenji

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 459.1 -1413.0 25.11 1.0 TRUE 

SET_PLAYER_COORDINATES player 459.1 -1413.0 25.11
							   
SET_PLAYER_HEADING player 132.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3580
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_A ) 10000 1 //"To be truly strong, it is important that you never show weakness."

WHILE cs_time < 8316
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_B ) 10000 1 //"The business's that are fortunate enough to have our protection settle their accounts today."

WHILE cs_time < 13513
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_C ) 10000 1 //"Please go and collect the money immediately, so we can enter it into the casino accounts."

WHILE cs_time < 17808
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( KM4_C )

WHILE cs_time < 18333
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

SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 


UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED casino_garden

// *******************************************END OF CUTSCENE*******************************

REQUEST_MODEL PED_GANG_DIABLO_A

WHILE NOT HAS_MODEL_LOADED PED_GANG_DIABLO_A

	WAIT 0

ENDWHILE

CREATE_PICKUP briefcase pickup_once 236.8 -1580.0 25.7 briefcase1_km4

flag_briefcase1_created_km4 = 1

ADD_BLIP_FOR_PICKUP briefcase1_km4 radar_blip_coord2_km4 

// waits for the player to get the first briefcase

WHILE NOT HAS_PICKUP_BEEN_COLLECTED briefcase1_km4 

	WAIT 0
      
ENDWHILE

flag_briefcase1_collected_km4 = 1

PRINT_NOW ( KM4_8 ) 5000 1 //"Briefcase collected!"

REMOVE_BLIP radar_blip_coord2_km4

CREATE_PICKUP briefcase pickup_once 119.56 -1110.51 25.66 briefcase2_km4

flag_briefcase2_created_km4 = 1

ADD_BLIP_FOR_PICKUP briefcase2_km4 radar_blip_coord3_km4 

// creates Diablo 6 who is by the second briefcase

CREATE_CHAR PEDTYPE_CIVMALE PED_GANG_DIABLO_A 122.2 -1113.2 25.2 hispanic6_km4

GIVE_WEAPON_TO_CHAR hispanic6_km4 WEAPONTYPE_UZI 30000  // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic6_km4

TURN_CHAR_TO_FACE_COORD hispanic6_km4 120.6 -1111.8 -100.0

// waiting for the player to get the second briefcase

SET_PED_DENSITY park DAY 0
SET_PED_DENSITY park NIGHT 0

WHILE NOT HAS_PICKUP_BEEN_COLLECTED briefcase2_km4

	WAIT 0
      
	IF flag_hispanic6_km4_dead = 0

		IF IS_CHAR_DEAD hispanic6_km4
			flag_hispanic6_km4_dead = 1
		ELSE
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player hispanic6_km4 10.0 10.0 FALSE
				SET_CHAR_THREAT_SEARCH hispanic6_km4 THREAT_PLAYER1 
				SET_CHAR_PERSONALITY hispanic6_km4 PEDSTAT_TOUGH_GUY
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic6_km4 player
			ENDIF
		
		ENDIF
		
	ENDIF 

ENDWHILE

flag_briefcase2_collected_km4 = 1

PRINT_NOW ( KM4_8 ) 5000 1 //"Briefcase collected!"

REMOVE_BLIP radar_blip_coord3_km4

ADD_BLIP_FOR_COORD -91.5 -484.2 15.2 radar_blip_coord5_km4

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player -91.5 -484.2 15.2 4.0 4.0 3.0 TRUE

	WAIT 0
       	
ENDWHILE

SWITCH_WIDESCREEN ON

REMOVE_BLIP radar_blip_coord5_km4

SET_PLAYER_CONTROL player OFF

CLEAR_AREA -91.0 -488.9 18.7 2.0 TRUE

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

SET_FIXED_CAMERA_POSITION -87.33 -502.99 21.33 0.0 0.0 0.0

POINT_CAMERA_AT_POINT -87.37 -502.06 20.97 JUMP_CUT

GET_PLAYER_CHAR player script_controlled_player

IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN player car_km4
			
	SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_km4

	WHILE IS_CHAR_IN_CAR script_controlled_player car_km4

		WAIT 0
	   	   
		IF IS_CAR_DEAD car_km4
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicles dead!"
			GOTO mission_kenji4_failed
		ENDIF
			

	ENDWHILE

ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player -92.07 -488.84

timerb = 0

	WHILE timerb < 1000

		WAIT 0

	ENDWHILE

// **************************************CUT SCENE WITH SHOP KEEPER*************************

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway

	WAIT 0

	GET_GAME_TIMER breakout_timer

	breakout_diff = breakout_timer - breakout_timer_start
	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

// Cutscene stuff

LOAD_SPECIAL_CHARACTER 2 KEEPER
LOAD_SPECIAL_MODEL cut_obj1 KEEPERH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL CUT_OBJ3 SHDOOR 

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

CHAR_SET_IDLE script_controlled_player

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS -117.66 -565.7 10.0 12.34 -396.77 20.0

LOAD_ALL_MODELS_NOW	

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj1

	WAIT 0

ENDWHILE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -88.3 -487.6 15.1 6.0 convstore01_door FALSE	

LOAD_CUTSCENE k4_shi2

SET_CUTSCENE_OFFSET -88.1829 -491.4236 15.1439  //Proper one

//SET_CUTSCENE_OFFSET -90.1829 -491.4236 15.143  // Test one

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_keeper

SET_CUTSCENE_ANIM cs_keeper keeper

CREATE_CUTSCENE_OBJECT cut_obj3 cs_shopdoor

SET_CUTSCENE_ANIM cs_shopdoor shdoor

CREATE_CUTSCENE_HEAD cs_keeper CUT_OBJ1 cs_keeperhead

SET_CUTSCENE_HEAD_ANIM cs_keeperhead keeper

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA -93.01 -489.43 15.16 1.0 TRUE
 
SET_PLAYER_COORDINATES player -93.01 -489.43 15.16

SET_PLAYER_HEADING player 101.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2690
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_1 ) 10000 1 //"I can't pay you and I wouldn't pay you if I could!"

WHILE cs_time < 4898
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_9 ) 10000 1 //"Some young gang just jacked out the place, they took everything."

WHILE cs_time < 7467
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM4_2 ) 10000 1 //"You guys are useless."

WHILE cs_time < 8511
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE					

PRINT_NOW ( KM4_10 ) 10000 1 //"What kind of Yakuza are you anyway?"

WHILE cs_time < 10710
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE	

CLEAR_THIS_PRINT ( KM4_10 )

WHILE cs_time < 11000
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

SET_CAMERA_BEHIND_PLAYER

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -88.3 -487.6 15.1 6.0 convstore01_door TRUE

UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

SET_PED_DENSITY_MULTIPLIER 1.0


// **********************************END OF CUTSCENE WITH SHOPKEEPER************************

SWITCH_WIDESCREEN OFF

SET_POLICE_IGNORE_PLAYER player OFF

SET_PLAYER_CONTROL player ON

SET_PED_DENSITY park DAY 1
SET_PED_DENSITY park NIGHT 1

SET_EVERYONE_IGNORE_PLAYER player OFF

ADD_BLIP_FOR_COORD_OLD 938.0 -180.0 -100.0 5 BOTH radar_blip_coord1_km4

CHANGE_BLIP_SCALE radar_blip_coord1_km4 3

ADD_BLIP_FOR_COORD_OLD 930.0 -190.0 -100.0 1 BOTH radar_blip_dummy1_km4

CHANGE_BLIP_SCALE radar_blip_dummy1_km4 3 

ADD_BLIP_FOR_COORD_OLD 931.0 -184.0 -100.0 1 BOTH radar_blip_dummy2_km4

CHANGE_BLIP_SCALE radar_blip_dummy2_km4 3

ADD_BLIP_FOR_COORD_OLD 943.0 -182.0 -100.0 1 BOTH radar_blip_dummy3_km4

CHANGE_BLIP_SCALE radar_blip_dummy3_km4 3

ADD_BLIP_FOR_COORD_OLD 943.0 -190.0 -100.0 1 BOTH radar_blip_dummy4_km4

CHANGE_BLIP_SCALE radar_blip_dummy4_km4 3

ADD_BLIP_FOR_COORD_OLD 939.0 -183.0 -100.0 1 BOTH radar_blip_dummy5_km4

CHANGE_BLIP_SCALE radar_blip_dummy5_km4 3

PRINT_NOW ( KM4_4 ) 7000 1 //"Punish the gang responsible and retrieve the protection money!"

// creates the final briefcase and the hispanics

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	WAIT 0
         
ENDWHILE

CREATE_PICKUP briefcase pickup_once 938.0 -180.0 4.5 briefcase3_km4

flag_briefcase3_created_km4 = 1

ADD_BLIP_FOR_PICKUP briefcase3_km4 radar_blip_coord4_km4 

REMOVE_BLIP radar_blip_coord1_km4

// hispanic 1

CREATE_CHAR PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_A 930.0 -190.0 -100.0 hispanic1_km4

ADD_BLIP_FOR_CHAR hispanic1_km4 radar_blip_diablo1_km4

REMOVE_BLIP radar_blip_dummy1_km4 

GIVE_WEAPON_TO_CHAR hispanic1_km4 WEAPONTYPE_UZI 30000  // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic1_km4

SET_CHAR_PERSONALITY hispanic1_km4 PEDSTAT_TOUGH_GUY

// hispanic 2

CREATE_CHAR PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_A 931.0 -184.0 -100.0 hispanic2_km4

ADD_BLIP_FOR_CHAR hispanic2_km4 radar_blip_diablo2_km4

REMOVE_BLIP radar_blip_dummy2_km4

GIVE_WEAPON_TO_CHAR hispanic2_km4 WEAPONTYPE_UZI 30000 // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic2_km4

SET_CHAR_PERSONALITY hispanic2_km4 PEDSTAT_TOUGH_GUY

// hispanic 3

CREATE_CHAR PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_A 943.0 -182.0 -100.0 hispanic3_km4

ADD_BLIP_FOR_CHAR hispanic3_km4 radar_blip_diablo3_km4

REMOVE_BLIP radar_blip_dummy3_km4

GIVE_WEAPON_TO_CHAR hispanic3_km4 WEAPONTYPE_UZI 30000 // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic3_km4

SET_CHAR_PERSONALITY hispanic3_km4 PEDSTAT_TOUGH_GUY

// hispanic 4

CREATE_CHAR PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_A 943.0 -190.0 -100.0 hispanic4_km4

ADD_BLIP_FOR_CHAR hispanic4_km4 radar_blip_diablo4_km4

REMOVE_BLIP radar_blip_dummy4_km4

GIVE_WEAPON_TO_CHAR hispanic4_km4 WEAPONTYPE_UZI 30000 // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic4_km4

SET_CHAR_PERSONALITY hispanic4_km4 PEDSTAT_TOUGH_GUY

// hispanic 5

CREATE_CHAR PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_A 939.0 -183.0 -100.0 hispanic5_km4

ADD_BLIP_FOR_CHAR hispanic5_km4 radar_blip_diablo5_km4

REMOVE_BLIP radar_blip_dummy5_km4

GIVE_WEAPON_TO_CHAR hispanic5_km4 WEAPONTYPE_UZI 30000 // sets weapon to have infinate bullets

CLEAR_CHAR_THREAT_SEARCH hispanic5_km4

SET_CHAR_PERSONALITY hispanic5_km4 PEDSTAT_TOUGH_GUY


WHILE flag_briefcase3_pickedup_km4 = 0
OR counter_number_of_hispanics_dead < 5

	WAIT 0

	IF flag_hispanic1_km4_dead = 0

		IF IS_CHAR_DEAD hispanic1_km4
			REMOVE_BLIP radar_blip_diablo1_km4
			++ counter_number_of_hispanics_dead
			flag_hispanic1_km4_dead = 1
		ENDIF

	ENDIF

	IF flag_hispanic2_km4_dead = 0

		IF IS_CHAR_DEAD hispanic2_km4
			REMOVE_BLIP radar_blip_diablo2_km4
			++ counter_number_of_hispanics_dead
			flag_hispanic2_km4_dead = 1
		ENDIF

	ENDIF

	IF flag_hispanic3_km4_dead = 0

		IF IS_CHAR_DEAD hispanic3_km4
			REMOVE_BLIP radar_blip_diablo3_km4
			++ counter_number_of_hispanics_dead
			flag_hispanic3_km4_dead = 1
		ENDIF

	ENDIF

	IF flag_hispanic4_km4_dead = 0

		IF IS_CHAR_DEAD hispanic4_km4
			REMOVE_BLIP radar_blip_diablo4_km4
			++ counter_number_of_hispanics_dead
			flag_hispanic4_km4_dead = 1
		ENDIF

	ENDIF

	IF flag_hispanic5_km4_dead = 0

		IF IS_CHAR_DEAD hispanic5_km4
			REMOVE_BLIP radar_blip_diablo5_km4
			++ counter_number_of_hispanics_dead
			flag_hispanic5_km4_dead = 1
		ENDIF

	ENDIF
         
	IF flag_briefcase3_pickedup_km4 = 0 

		IF HAS_PICKUP_BEEN_COLLECTED briefcase3_km4
			REMOVE_BLIP radar_blip_coord4_km4
			PRINT_NOW ( KM4_8 ) 5000 1 //"Briefcase collected!"
			flag_briefcase3_collected_km4 = 1
			flag_briefcase3_pickedup_km4 = 1
		ENDIF

	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player 940.0 -185.0 4.2 25.0 25.0 10.0 FALSE
			
		IF flag_hispanic1_km4_dead = 0
		AND flag_hispanic1_hate_player_km4 = 0
			SET_CHAR_THREAT_SEARCH hispanic1_km4 THREAT_PLAYER1
			TURN_CHAR_TO_FACE_PLAYER hispanic1_km4 player
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic1_km4 player 
			flag_hispanic1_hate_player_km4 = 1 
		ENDIF

		IF flag_hispanic2_km4_dead = 0
		AND flag_hispanic2_hate_player_km4 = 0
			SET_CHAR_THREAT_SEARCH hispanic2_km4 THREAT_PLAYER1
			TURN_CHAR_TO_FACE_PLAYER hispanic2_km4 player
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic2_km4 player 
			flag_hispanic2_hate_player_km4 = 1
		ENDIF

		IF flag_hispanic3_km4_dead = 0
		AND flag_hispanic3_hate_player_km4 = 0
			SET_CHAR_THREAT_SEARCH hispanic3_km4 THREAT_PLAYER1
			TURN_CHAR_TO_FACE_PLAYER hispanic3_km4 player
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic3_km4 player
			flag_hispanic3_hate_player_km4 = 1 
		ENDIF

		IF flag_hispanic4_km4_dead = 0
		AND flag_hispanic4_hate_player_km4 = 0
			SET_CHAR_THREAT_SEARCH hispanic4_km4 THREAT_PLAYER1
			TURN_CHAR_TO_FACE_PLAYER hispanic4_km4 player
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic4_km4 player
			flag_hispanic4_hate_player_km4 = 1 
		ENDIF

		IF flag_hispanic5_km4_dead = 0
		AND flag_hispanic5_hate_player_km4 = 0
			SET_CHAR_THREAT_SEARCH hispanic5_km4 THREAT_PLAYER1
			TURN_CHAR_TO_FACE_PLAYER hispanic5_km4 player
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS hispanic5_km4 player
			flag_hispanic5_hate_player_km4 = 1 
		ENDIF
						
	ENDIF
			
ENDWHILE

PRINT_NOW ( KM4_11 ) 5000 1 //"Take the money back to the casino!"

ADD_BLIP_FOR_COORD 452.3 -1465.8 17.6 radar_blip_coord6_km4

blob_flag = 1 

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player 452.3 -1465.8 17.6 4.0 4.0 4.0 blob_flag

	WAIT 0
  
ENDWHILE

REMOVE_BLIP radar_blip_coord6_km4

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

GET_PLAYER_CHAR player script_controlled_player

IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN player car_cut_km4
	SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_cut_km4
	
	WHILE IS_PLAYER_IN_CAR player car_cut_km4
	
		WAIT 0

		IF IS_CAR_DEAD car_cut_km4
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicles wrecked!"
			GOTO mission_kenji4_failed
		ENDIF 
		
	ENDWHILE
	
ENDIF

SET_FIXED_CAMERA_POSITION 420.41 -1479.59 26.13 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 420.87 -1478.75 26.38 JUMP_CUT

SET_PLAYER_COORDINATES player 425.85 -1477.16 -100.0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 428.57 -1465.01

WHILE NOT IS_CHAR_OBJECTIVE_PASSED script_controlled_player

	WAIT 0
	
ENDWHILE

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0
	
ENDWHILE

SET_PLAYER_COORDINATES player 426.81 -1486.40 17.64

SET_PLAYER_HEADING player 180.0

RESTORE_CAMERA_JUMPCUT

SET_CAMERA_IN_FRONT_OF_PLAYER 

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0
	
ENDWHILE

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF

}

GOTO mission_kenji4_passed
	   		


// Mission Kenji3 failed

mission_kenji4_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

   

// mission Kenji3 passed

mission_kenji4_passed:

flag_kenji_mission4_passed = 1
REGISTER_MISSION_PASSED ( KM4 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 10000 5000 1  //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT kenji_mission5_loop
RETURN
		


// mission cleanup

mission_cleanup_kenji4:

flag_player_on_mission = 0
flag_player_on_kenji_mission = 0
switch_gang_diablo_off = 0

IF flag_briefcase1_created_km4 = 1

	IF flag_briefcase1_collected_km4 = 0
		REMOVE_PICKUP briefcase1_km4
	ENDIF

ENDIF

IF flag_briefcase2_created_km4 = 1

	IF flag_briefcase2_collected_km4 = 0
		REMOVE_PICKUP briefcase2_km4
	ENDIF

ENDIF

IF flag_briefcase3_created_km4 = 1

	IF flag_briefcase3_collected_km4 = 0
		REMOVE_PICKUP briefcase3_km4
	ENDIF

ENDIF

REMOVE_BLIP radar_blip_diablo1_km4
REMOVE_BLIP radar_blip_diablo2_km4
REMOVE_BLIP radar_blip_diablo3_km4
REMOVE_BLIP radar_blip_diablo4_km4
REMOVE_BLIP radar_blip_diablo5_km4
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
REMOVE_BLIP radar_blip_coord2_km4
REMOVE_BLIP radar_blip_coord3_km4
REMOVE_BLIP radar_blip_coord4_km4
REMOVE_BLIP radar_blip_coord5_km4
REMOVE_BLIP radar_blip_coord1_km4
REMOVE_BLIP radar_blip_coord6_km4
REMOVE_BLIP radar_blip_dummy1_km4
REMOVE_BLIP radar_blip_dummy2_km4
REMOVE_BLIP radar_blip_dummy3_km4
REMOVE_BLIP radar_blip_dummy4_km4
REMOVE_BLIP radar_blip_dummy5_km4
SET_PED_DENSITY park DAY 1
SET_PED_DENSITY park NIGHT 1
MISSION_HAS_FINISHED
RETURN
	
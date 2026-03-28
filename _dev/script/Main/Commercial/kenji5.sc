MISSION_START
// *****************************************************************************************
// *******************************   Kenji Mission 5   ************************************* 
// *******************************     Smack Down      *************************************
// *****************************************************************************************
// *** Kenji wants you to hit the Yardies pushing Spank for the Cartel. They're dotted   ***
// *** about Liberty dealing in gangs or from vehicles. The player must race round the 	 ***
// *** city splattering and killing all the dealers within a time limit. Occasionally 	 ***
// *** they may have a 'backup vehicle' that will give chase to make the mission harder. ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_kenji5

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_kenji5_failed
ENDIF

GOSUB mission_cleanup_kenji5

MISSION_END
 
// Variables For Mission

VAR_INT number_of_peds ped_2_exists ped_2_blip ped_2 delete_oldest_ped_time	on_screen_counter_flag
VAR_INT ped_3_exists ped_3_blip ped_3 ped_4_exists ped_4_blip ped_4 dead_peds minimum_kills	reward_kills
VAR_INT ped_1_time ped_2_time ped_3_time ped_4_time oldest_ped_time oldest_ped random_direction
VAR_INT ped_1_blip ped_1_exists ped_1
VAR_INT ped_5_blip ped_5_exists ped_5 ped_5_time
VAR_INT ped_6_blip ped_6_exists ped_6 ped_6_time
VAR_INT ped_7_blip ped_7_exists ped_7 ped_7_time			 cs_yakuza2
VAR_INT ped_8_blip ped_8_exists ped_8 ped_8_time
VAR_INT ped_9_blip ped_9_exists ped_9 ped_9_time
VAR_INT ped_10_blip ped_10_exists ped_10 ped_10_time
VAR_INT ped_11_blip ped_11_exists ped_11 ped_11_time
VAR_INT ped_12_blip ped_12_exists ped_12 ped_12_time
VAR_INT ped_13_blip ped_13_exists ped_13 ped_13_time
VAR_INT ped_14_blip ped_14_exists ped_14 ped_14_time
VAR_INT ped_15_blip ped_15_exists ped_15 ped_15_time

VAR_FLOAT ped_15_x ped_15_y ped_15_z 
VAR_FLOAT ped_14_x ped_14_y ped_14_z 
VAR_FLOAT ped_13_x ped_13_y ped_13_z 
VAR_FLOAT ped_12_x ped_12_y ped_12_z 
VAR_FLOAT ped_11_x ped_11_y ped_11_z 
VAR_FLOAT ped_10_x ped_10_y ped_10_z 
VAR_FLOAT ped_9_x ped_9_y ped_9_z 
VAR_FLOAT ped_8_x ped_8_y ped_8_z 
VAR_FLOAT ped_7_x ped_7_y ped_7_z 
VAR_FLOAT ped_6_x ped_6_y ped_6_z 
VAR_FLOAT ped_5_x ped_5_y ped_5_z 
VAR_FLOAT ped_1_x ped_1_y ped_1_z 
VAR_FLOAT ped_2_x ped_2_y ped_2_z ped_3_x ped_3_y ped_3_z 
VAR_FLOAT ped_4_x ped_4_y ped_4_z random_commercial_x random_commercial_y garbage_x	garbage_y garbage_z
VAR_FLOAT difference_x difference_y sum_diff distance

// ****************************************Mission Start************************************

mission_start_kenji5:

flag_player_on_mission = 1
flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME kenji5

number_of_peds 			= 0
ped_2_exists 			= 0
delete_oldest_ped_time	= 0
on_screen_counter_flag  = 0
ped_3_exists  			= 0
ped_4_exists 			= 0
dead_peds  				= 0
minimum_kills  			= 0
ped_1_time  			= 0
ped_2_time  			= 0
ped_3_time 	 			= 0
ped_4_time  			= 0
oldest_ped_time  		= 0
oldest_ped  			= 0
random_direction 		= 0
ped_1_exists 			= 0
ped_5_exists  			= 0
ped_5_time 				= 0
ped_6_exists  			= 0
ped_6_time 				= 0
ped_7_exists  			= 0
ped_7_time 				= 0
ped_8_exists  			= 0
ped_8_time  			= 0
ped_9_exists  			= 0
ped_9_time				= 0
ped_10_exists  			= 0
ped_10_time	 			= 0
ped_11_exists  			= 0
ped_11_time	 			= 0
ped_12_exists  			= 0
ped_12_time				= 0
ped_13_exists  			= 0
ped_13_time	 			= 0
ped_14_exists  			= 0
ped_14_time	 			= 0
ped_15_exists  			= 0
ped_15_time	 			= 0

minimum_kills = 8
{
// ****************************************START OF CUTSCENE********************************

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_kenji5_failed
ENDIF

SWITCH_STREAMING OFF

PRINT_BIG KM5 15000 2 // "SMACK DOWN"
*/

LOAD_SPECIAL_CHARACTER 1 KENJI
REQUEST_MODEL PED_GANG_YAKUZA_A
REQUEST_MODEL PED_GANG_YAKUZA_B
REQUEST_MODEL PED_GANG_YARDIE_A
LOAD_SPECIAL_MODEL cut_obj1 KENJIH
REQUEST_MODEL casino_garden 

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A 
OR NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_B
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED casino_garden
	WAIT 0
ENDWHILE

LOAD_CUTSCENE K5_SD

SET_CUTSCENE_OFFSET 476.380 -1382.168 67.347

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_kenji
SET_CUTSCENE_ANIM cs_kenji kenji

CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_A cs_yakuza
SET_CUTSCENE_ANIM cs_yakuza gang07

CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_B cs_yakuza2
SET_CUTSCENE_ANIM cs_yakuza2 gang08

CREATE_CUTSCENE_HEAD cs_kenji cut_obj1 cs_kenjihead
SET_CUTSCENE_HEAD_ANIM cs_kenjihead kenji

//CREATE_CUTSCENE_HEAD cs_player cut_obj2 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 459.1 -1413.0 25.11 1.0 TRUE 
SET_PLAYER_COORDINATES player 459.1 -1413.0 25.11							   
SET_PLAYER_HEADING player 132.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6121
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_A 7000 1 //"YOU! How fitting you should choose this moment to show your worthless face!"

WHILE cs_time < 11088
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_B 7000 1 //"It would appear your attempts to dissuade the Jamaicans"

WHILE cs_time < 13770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_B1 7000 1 //"from becoming bed fellows with the Cartel were wholly inadequate!"

WHILE cs_time < 17324
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_C 7000 1 //"Yardie pushers line Liberty's streets selling packets of SPANK like they were selling hotdogs!"

WHILE cs_time < 22060
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_D 7000 1 //"Those Cartel pigs are laughing at us, at me!" 

WHILE cs_time < 24716
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_E 7000 1 //"I will give you one last chance to prove my sister's faith in you to be well founded!"

WHILE cs_time < 29220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW KM5_F 7000 1 //"Run these scumbags into the ground and wash your shame in rivers of our enemies' blood!!!"

WHILE cs_time < 33666
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

SWITCH_STREAMING ON

SWITCH_RUBBISH ON

DO_FADE 1500 FADE_IN 

SET_CAMERA_IN_FRONT_OF_PLAYER

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_B
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED casino_garden 

// *******************************************END OF CUTSCENE*******************************


WHILE NOT HAS_MODEL_LOADED PED_GANG_YARDIE_A
	WAIT 0
ENDWHILE

GOTO main_part_of_script

create_random_ped://///////////////////////////////////////////////////////////////////////////

IF delete_oldest_ped_time > 10000
	delete_oldest_ped_time = delete_oldest_ped_time - 5000
ENDIF

IF ped_1_exists = 0	
	generate_coord_ped_1:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_1_x ped_1_y ped_1_z
	difference_x = garbage_x - ped_1_x
	difference_y = garbage_y - ped_1_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_1
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_1_x ped_1_y ped_1_z GREEN BLIP_ONLY ped_1_blip
	CHANGE_BLIP_SCALE ped_1_blip 3
	ped_1_exists = 1
	GET_GAME_TIMER ped_1_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_2_exists = 0	
	generate_coord_ped_2:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_2_x ped_2_y ped_2_z
	difference_x = garbage_x - ped_2_x
	difference_y = garbage_y - ped_2_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_2
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_2_x ped_2_y ped_2_z GREEN BLIP_ONLY ped_2_blip
	CHANGE_BLIP_SCALE ped_2_blip 3
	ped_2_exists = 1
	GET_GAME_TIMER ped_2_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_3_exists = 0	
	generate_coord_ped_3:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_3_x ped_3_y ped_3_z
	difference_x = garbage_x - ped_3_x
	difference_y = garbage_y - ped_3_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_3
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_3_x ped_3_y ped_3_z GREEN BLIP_ONLY ped_3_blip
	CHANGE_BLIP_SCALE ped_3_blip 3
	ped_3_exists = 1
	GET_GAME_TIMER ped_3_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_4_exists = 0	
	generate_coord_ped_4:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_4_x ped_4_y ped_4_z
	difference_x = garbage_x - ped_4_x
	difference_y = garbage_y - ped_4_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_4
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_4_x ped_4_y ped_4_z GREEN BLIP_ONLY ped_4_blip
	CHANGE_BLIP_SCALE ped_4_blip 3
	ped_4_exists = 1
	GET_GAME_TIMER ped_4_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_5_exists = 0	
	generate_coord_ped_5:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_5_x ped_5_y ped_5_z
	difference_x = garbage_x - ped_5_x
	difference_y = garbage_y - ped_5_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_5
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_5_x ped_5_y ped_5_z GREEN BLIP_ONLY ped_5_blip
	CHANGE_BLIP_SCALE ped_5_blip 3
	ped_5_exists = 1
	GET_GAME_TIMER ped_5_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_6_exists = 0	
	generate_coord_ped_6:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_6_x ped_6_y ped_6_z
	difference_x = garbage_x - ped_6_x
	difference_y = garbage_y - ped_6_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_6
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_6_x ped_6_y ped_6_z GREEN BLIP_ONLY ped_6_blip
	CHANGE_BLIP_SCALE ped_6_blip 3
	ped_6_exists = 1
	GET_GAME_TIMER ped_6_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_7_exists = 0	
	generate_coord_ped_7:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_7_x ped_7_y ped_7_z
	difference_x = garbage_x - ped_7_x
	difference_y = garbage_y - ped_7_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_7
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_7_x ped_7_y ped_7_z GREEN BLIP_ONLY ped_7_blip
	CHANGE_BLIP_SCALE ped_7_blip 3
	ped_7_exists = 1
	GET_GAME_TIMER ped_7_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_8_exists = 0	
	generate_coord_ped_8:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_8_x ped_8_y ped_8_z
	difference_x = garbage_x - ped_8_x
	difference_y = garbage_y - ped_8_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_8
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_8_x ped_8_y ped_8_z GREEN BLIP_ONLY ped_8_blip
	CHANGE_BLIP_SCALE ped_8_blip 3
	ped_8_exists = 1
	GET_GAME_TIMER ped_8_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_9_exists = 0	
	generate_coord_ped_9:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_9_x ped_9_y ped_9_z
	difference_x = garbage_x - ped_9_x
	difference_y = garbage_y - ped_9_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_9
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_9_x ped_9_y ped_9_z GREEN BLIP_ONLY ped_9_blip
	CHANGE_BLIP_SCALE ped_9_blip 3
	ped_9_exists = 1
	GET_GAME_TIMER ped_9_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_10_exists = 0	
	generate_coord_ped_10:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_10_x ped_10_y ped_10_z
	difference_x = garbage_x - ped_10_x
	difference_y = garbage_y - ped_10_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_10
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_10_x ped_10_y ped_10_z GREEN BLIP_ONLY ped_10_blip
	CHANGE_BLIP_SCALE ped_10_blip 3
	ped_10_exists = 1
	GET_GAME_TIMER ped_10_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_11_exists = 0	
	generate_coord_ped_11:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_11_x ped_11_y ped_11_z
	difference_x = garbage_x - ped_11_x
	difference_y = garbage_y - ped_11_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_11
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_11_x ped_11_y ped_11_z GREEN BLIP_ONLY ped_11_blip
	CHANGE_BLIP_SCALE ped_11_blip 3
	ped_11_exists = 1
	GET_GAME_TIMER ped_11_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_12_exists = 0	
	generate_coord_ped_12:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_12_x ped_12_y ped_12_z
	difference_x = garbage_x - ped_12_x
	difference_y = garbage_y - ped_12_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_12
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_12_x ped_12_y ped_12_z GREEN BLIP_ONLY ped_12_blip
	CHANGE_BLIP_SCALE ped_12_blip 3
	ped_12_exists = 1
	GET_GAME_TIMER ped_12_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_13_exists = 0	
	generate_coord_ped_13:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_13_x ped_13_y ped_13_z
	difference_x = garbage_x - ped_13_x
	difference_y = garbage_y - ped_13_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_13
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_13_x ped_13_y ped_13_z GREEN BLIP_ONLY ped_13_blip
	CHANGE_BLIP_SCALE ped_13_blip 3
	ped_13_exists = 1
	GET_GAME_TIMER ped_13_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_14_exists = 0	
	generate_coord_ped_14:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_14_x ped_14_y ped_14_z
	difference_x = garbage_x - ped_14_x
	difference_y = garbage_y - ped_14_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_14
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_14_x ped_14_y ped_14_z GREEN BLIP_ONLY ped_14_blip
	CHANGE_BLIP_SCALE ped_14_blip 3
	ped_14_exists = 1
	GET_GAME_TIMER ped_14_time
	++ number_of_peds
	RETURN
ENDIF

IF ped_15_exists = 0	
	generate_coord_ped_15:
	GENERATE_RANDOM_FLOAT_IN_RANGE -173.0 460.0 random_commercial_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1627.0 100.0 random_commercial_y
	GET_PLAYER_COORDINATES player garbage_x	garbage_y garbage_z
	GET_CLOSEST_CHAR_NODE random_commercial_x random_commercial_y garbage_z ped_15_x ped_15_y ped_15_z
	difference_x = garbage_x - ped_15_x
	difference_y = garbage_y - ped_15_y
	difference_x = difference_x * difference_x
	difference_y = difference_y * difference_y
	sum_diff = difference_x + difference_y
	SQRT sum_diff distance
	IF distance < 110.0
		GOTO generate_coord_ped_15
	ENDIF
	ADD_BLIP_FOR_COORD_OLD ped_15_x ped_15_y ped_15_z GREEN BLIP_ONLY ped_15_blip
	CHANGE_BLIP_SCALE ped_15_blip 3
	ped_15_exists = 1
	GET_GAME_TIMER ped_15_time
	++ number_of_peds
	RETURN
ENDIF

RETURN


main_part_of_script:///////////////////////////////////////////////////////////////////////////

ped_1_x	= 39.3
ped_1_y	= -880.6
ped_1_z	= 34.0

ped_2_x	= -55.4331
ped_2_y	= -974.3467
ped_2_z	= 25.4

delete_oldest_ped_time = 80000

ADD_BLIP_FOR_COORD_OLD ped_1_x ped_1_y ped_1_z GREEN BLIP_ONLY ped_1_blip
CHANGE_BLIP_SCALE ped_1_blip 3

ADD_BLIP_FOR_COORD_OLD ped_2_x ped_2_y ped_2_z GREEN BLIP_ONLY ped_2_blip
CHANGE_BLIP_SCALE ped_2_blip 3

PRINT_NOW KM5_6 5000 1 //"You must murder at least 8 Yardie dealers."
PRINT_SOON KM5_7 6000 1	//"Kill them quickly!  Once they've pushed their SPANK they're off the streets."

DISPLAY_ONSCREEN_COUNTER_WITH_STRING dead_peds COUNTER_DISPLAY_NUMBER KILLS

ped_1_exists = 1
ped_2_exists = 1
number_of_peds = 2
TIMERA = 0

WHILE number_of_peds > 0
	
	WAIT 0
	
	IF dead_peds > 0
		IF TIMERA > delete_oldest_ped_time
			TIMERA = 0
			GOSUB delete_oldest_ped
		ENDIF
	ENDIF
	
	IF ped_1_exists > 0
		IF ped_1_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_1_x ped_1_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_1_x ped_1_y ped_1_z ped_1
    			GIVE_WEAPON_TO_CHAR	ped_1 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_1 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_1 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_1 random_direction
				REMOVE_BLIP ped_1_blip
				ADD_BLIP_FOR_CHAR_OLD ped_1 GREEN BOTH ped_1_blip
				CHANGE_BLIP_SCALE ped_1_blip 3
				ped_1_exists = 2
			ENDIF
		ENDIF
		IF ped_1_exists = 2
			IF IS_CHAR_DEAD ped_1
				REMOVE_BLIP ped_1_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_1
				ped_1_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				IF on_screen_counter_flag = 0
					PRINT_SOON KM5_7 6000 1	//"Kill them quickly!  Once they've pushed their SPANK they're off the streets."
					TIMERA = 0
					on_screen_counter_flag = 1
				ENDIF
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_1_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_1 90.0 90.0 0
					GET_CHAR_COORDINATES ped_1 ped_1_x ped_1_y ped_1_z
					REMOVE_BLIP ped_1_blip
					ADD_BLIP_FOR_COORD_OLD ped_1_x ped_1_y ped_1_z GREEN BLIP_ONLY ped_1_blip
					CHANGE_BLIP_SCALE ped_1_blip 3
					DELETE_CHAR ped_1
					ped_1_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_2_exists > 0
		IF ped_2_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_2_x ped_2_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_2_x ped_2_y ped_2_z ped_2
    			GIVE_WEAPON_TO_CHAR	ped_2 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_2 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_2 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_2 TRUE
				REMOVE_BLIP ped_2_blip
				ADD_BLIP_FOR_CHAR_OLD ped_2 GREEN BOTH ped_2_blip
				CHANGE_BLIP_SCALE ped_2_blip 3
				ped_2_exists = 2
			ENDIF
		ENDIF
		IF ped_2_exists = 2
			IF IS_CHAR_DEAD ped_2
				REMOVE_BLIP ped_2_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_2
				ped_2_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				IF on_screen_counter_flag = 0
					PRINT_SOON KM5_7 6000 1	//"Kill them quickly!  Once they've pushed their SPANK they're off the streets."
					TIMERA = 0
					on_screen_counter_flag = 1
				ENDIF
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_2_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_2 90.0 90.0 0
					GET_CHAR_COORDINATES ped_2 ped_2_x ped_2_y ped_2_z
					REMOVE_BLIP ped_2_blip
					ADD_BLIP_FOR_COORD_OLD ped_2_x ped_2_y ped_2_z GREEN BLIP_ONLY ped_2_blip
					CHANGE_BLIP_SCALE ped_2_blip 3
					DELETE_CHAR ped_2
					ped_2_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_3_exists > 0
		IF ped_3_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_3_x ped_3_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_3_x ped_3_y ped_3_z ped_3
    			GIVE_WEAPON_TO_CHAR	ped_3 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_3 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_3 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_3 random_direction
				REMOVE_BLIP ped_3_blip
				ADD_BLIP_FOR_CHAR_OLD ped_3 GREEN BOTH ped_3_blip
				CHANGE_BLIP_SCALE ped_3_blip 3
				ped_3_exists = 2
			ENDIF
		ENDIF
		IF ped_3_exists = 2
			IF IS_CHAR_DEAD ped_3
				REMOVE_BLIP ped_3_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_3
				ped_3_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_3_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_3 90.0 90.0 0
					GET_CHAR_COORDINATES ped_3 ped_3_x ped_3_y ped_3_z
					REMOVE_BLIP ped_3_blip
					ADD_BLIP_FOR_COORD_OLD ped_3_x ped_3_y ped_3_z GREEN BLIP_ONLY ped_3_blip
					CHANGE_BLIP_SCALE ped_3_blip 3
					DELETE_CHAR ped_3
					ped_3_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_4_exists > 0
		IF ped_4_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_4_x ped_4_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_4_x ped_4_y ped_4_z ped_4
    			GIVE_WEAPON_TO_CHAR	ped_4 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_4 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_4 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_4 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_4 random_direction
				REMOVE_BLIP ped_4_blip
				ADD_BLIP_FOR_CHAR_OLD ped_4 GREEN BOTH ped_4_blip
				CHANGE_BLIP_SCALE ped_4_blip 3
				ped_4_exists = 2
			ENDIF
		ENDIF
		IF ped_4_exists = 2
			IF IS_CHAR_DEAD ped_4
				REMOVE_BLIP ped_4_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_4
				ped_4_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_4_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_4 90.0 90.0 0
					GET_CHAR_COORDINATES ped_4 ped_4_x ped_4_y ped_4_z
					REMOVE_BLIP ped_4_blip
					ADD_BLIP_FOR_COORD_OLD ped_4_x ped_4_y ped_4_z GREEN BLIP_ONLY ped_4_blip
					CHANGE_BLIP_SCALE ped_4_blip 3
					DELETE_CHAR ped_4
					ped_4_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_5_exists > 0
		IF ped_5_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_5_x ped_5_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_5_x ped_5_y ped_5_z ped_5
    			GIVE_WEAPON_TO_CHAR	ped_5 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_5 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_5 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_5 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_5 random_direction
				REMOVE_BLIP ped_5_blip
				ADD_BLIP_FOR_CHAR_OLD ped_5 GREEN BOTH ped_5_blip
				CHANGE_BLIP_SCALE ped_5_blip 3
				ped_5_exists = 2
			ENDIF
		ENDIF
		IF ped_5_exists = 2
			IF IS_CHAR_DEAD ped_5
				REMOVE_BLIP ped_5_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_5
				ped_5_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_5_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_5 90.0 90.0 0
					GET_CHAR_COORDINATES ped_5 ped_5_x ped_5_y ped_5_z
					REMOVE_BLIP ped_5_blip
					ADD_BLIP_FOR_COORD_OLD ped_5_x ped_5_y ped_5_z GREEN BLIP_ONLY ped_5_blip
					CHANGE_BLIP_SCALE ped_5_blip 3
					DELETE_CHAR ped_5
					ped_5_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_6_exists > 0
		IF ped_6_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_6_x ped_6_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_6_x ped_6_y ped_6_z ped_6
    			GIVE_WEAPON_TO_CHAR	ped_6 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_6 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_6 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_6 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_6 random_direction
				REMOVE_BLIP ped_6_blip
				ADD_BLIP_FOR_CHAR_OLD ped_6 GREEN BOTH ped_6_blip
				CHANGE_BLIP_SCALE ped_6_blip 3
				ped_6_exists = 2
			ENDIF
		ENDIF
		IF ped_6_exists = 2
			IF IS_CHAR_DEAD ped_6
				REMOVE_BLIP ped_6_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_6
				ped_6_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_6_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_6 90.0 90.0 0
					GET_CHAR_COORDINATES ped_6 ped_6_x ped_6_y ped_6_z
					REMOVE_BLIP ped_6_blip
					ADD_BLIP_FOR_COORD_OLD ped_6_x ped_6_y ped_6_z GREEN BLIP_ONLY ped_6_blip
					CHANGE_BLIP_SCALE ped_6_blip 3
					DELETE_CHAR ped_6
					ped_6_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_7_exists > 0
		IF ped_7_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_7_x ped_7_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_7_x ped_7_y ped_7_z ped_7
    			GIVE_WEAPON_TO_CHAR	ped_7 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_7 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_7 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_7 random_direction
				REMOVE_BLIP ped_7_blip
				ADD_BLIP_FOR_CHAR_OLD ped_7 GREEN BOTH ped_7_blip
				CHANGE_BLIP_SCALE ped_7_blip 3
				ped_7_exists = 2
			ENDIF
		ENDIF
		IF ped_7_exists = 2
			IF IS_CHAR_DEAD ped_7
				REMOVE_BLIP ped_7_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_7
				ped_7_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_7_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_7 90.0 90.0 0
					GET_CHAR_COORDINATES ped_7 ped_7_x ped_7_y ped_7_z
					REMOVE_BLIP ped_7_blip
					ADD_BLIP_FOR_COORD_OLD ped_7_x ped_7_y ped_7_z GREEN BLIP_ONLY ped_7_blip
					CHANGE_BLIP_SCALE ped_7_blip 3
					DELETE_CHAR ped_7
					ped_7_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_8_exists > 0
		IF ped_8_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_8_x ped_8_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_8_x ped_8_y ped_8_z ped_8
    			GIVE_WEAPON_TO_CHAR	ped_8 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_8 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_8 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_8 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_8 random_direction
				REMOVE_BLIP ped_8_blip
				ADD_BLIP_FOR_CHAR_OLD ped_8 GREEN BOTH ped_8_blip
				CHANGE_BLIP_SCALE ped_8_blip 3
				ped_8_exists = 2
			ENDIF
		ENDIF
		IF ped_8_exists = 2
			IF IS_CHAR_DEAD ped_8
				REMOVE_BLIP ped_8_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_8
				ped_8_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_8_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_8 90.0 90.0 0
					GET_CHAR_COORDINATES ped_8 ped_8_x ped_8_y ped_8_z
					REMOVE_BLIP ped_8_blip
					ADD_BLIP_FOR_COORD_OLD ped_8_x ped_8_y ped_8_z GREEN BLIP_ONLY ped_8_blip
					CHANGE_BLIP_SCALE ped_8_blip 3
					DELETE_CHAR ped_8
					ped_8_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_9_exists > 0
		IF ped_9_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_9_x ped_9_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_9_x ped_9_y ped_9_z ped_9
    			GIVE_WEAPON_TO_CHAR	ped_9 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_9 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_9 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_9 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_9 random_direction
				REMOVE_BLIP ped_9_blip
				ADD_BLIP_FOR_CHAR_OLD ped_9 GREEN BOTH ped_9_blip
				CHANGE_BLIP_SCALE ped_9_blip 3
				ped_9_exists = 2
			ENDIF
		ENDIF
		IF ped_9_exists = 2
			IF IS_CHAR_DEAD ped_9
				REMOVE_BLIP ped_9_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_9
				ped_9_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_9_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_9 90.0 90.0 0
					GET_CHAR_COORDINATES ped_9 ped_9_x ped_9_y ped_9_z
					REMOVE_BLIP ped_9_blip
					ADD_BLIP_FOR_COORD_OLD ped_9_x ped_9_y ped_9_z GREEN BLIP_ONLY ped_9_blip
					CHANGE_BLIP_SCALE ped_9_blip 3
					DELETE_CHAR ped_9
					ped_9_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_10_exists > 0
		IF ped_10_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_10_x ped_10_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_10_x ped_10_y ped_10_z ped_10
    			GIVE_WEAPON_TO_CHAR	ped_10 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_10 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_10 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_10 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_10 random_direction
				REMOVE_BLIP ped_10_blip
				ADD_BLIP_FOR_CHAR_OLD ped_10 GREEN BOTH ped_10_blip
				CHANGE_BLIP_SCALE ped_10_blip 3
				ped_10_exists = 2
			ENDIF
		ENDIF
		IF ped_10_exists = 2
			IF IS_CHAR_DEAD ped_10
				REMOVE_BLIP ped_10_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_10
				ped_10_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_10_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_10 90.0 90.0 0
					GET_CHAR_COORDINATES ped_10 ped_10_x ped_10_y ped_10_z
					REMOVE_BLIP ped_10_blip
					ADD_BLIP_FOR_COORD_OLD ped_10_x ped_10_y ped_10_z GREEN BLIP_ONLY ped_10_blip
					CHANGE_BLIP_SCALE ped_10_blip 3
					DELETE_CHAR ped_10
					ped_10_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_11_exists > 0
		IF ped_11_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_11_x ped_11_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_11_x ped_11_y ped_11_z ped_11
    			GIVE_WEAPON_TO_CHAR	ped_11 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_11 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_11 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_11 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_11 random_direction
				REMOVE_BLIP ped_11_blip
				ADD_BLIP_FOR_CHAR_OLD ped_11 GREEN BOTH ped_11_blip
				CHANGE_BLIP_SCALE ped_11_blip 3
				ped_11_exists = 2
			ENDIF
		ENDIF
		IF ped_11_exists = 2
			IF IS_CHAR_DEAD ped_11
				REMOVE_BLIP ped_11_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_11
				ped_11_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_11_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_11 90.0 90.0 0
					GET_CHAR_COORDINATES ped_11 ped_11_x ped_11_y ped_11_z
					REMOVE_BLIP ped_11_blip
					ADD_BLIP_FOR_COORD_OLD ped_11_x ped_11_y ped_11_z GREEN BLIP_ONLY ped_11_blip
					CHANGE_BLIP_SCALE ped_11_blip 3
					DELETE_CHAR ped_11
					ped_11_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_12_exists > 0
		IF ped_12_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_12_x ped_12_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_12_x ped_12_y ped_12_z ped_12
    			GIVE_WEAPON_TO_CHAR	ped_12 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_12 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_12 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_12 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_12 random_direction
				REMOVE_BLIP ped_12_blip
				ADD_BLIP_FOR_CHAR_OLD ped_12 GREEN BOTH ped_12_blip
				CHANGE_BLIP_SCALE ped_12_blip 3
				ped_12_exists = 2
			ENDIF
		ENDIF
		IF ped_12_exists = 2
			IF IS_CHAR_DEAD ped_12
				REMOVE_BLIP ped_12_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_12
				ped_12_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_12_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_12 90.0 90.0 0
					GET_CHAR_COORDINATES ped_12 ped_12_x ped_12_y ped_12_z
					REMOVE_BLIP ped_12_blip
					ADD_BLIP_FOR_COORD_OLD ped_12_x ped_12_y ped_12_z GREEN BLIP_ONLY ped_12_blip
					CHANGE_BLIP_SCALE ped_12_blip 3
					DELETE_CHAR ped_12
					ped_12_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_13_exists > 0
		IF ped_13_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_13_x ped_13_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_13_x ped_13_y ped_13_z ped_13
    			GIVE_WEAPON_TO_CHAR	ped_13 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_13 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_13 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_13 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_13 random_direction
				REMOVE_BLIP ped_13_blip
				ADD_BLIP_FOR_CHAR_OLD ped_13 GREEN BOTH ped_13_blip
				CHANGE_BLIP_SCALE ped_13_blip 3
				ped_13_exists = 2
			ENDIF
		ENDIF
		IF ped_13_exists = 2
			IF IS_CHAR_DEAD ped_13
				REMOVE_BLIP ped_13_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_13
				ped_13_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_13_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_13 90.0 90.0 0
					GET_CHAR_COORDINATES ped_13 ped_13_x ped_13_y ped_13_z
					REMOVE_BLIP ped_13_blip
					ADD_BLIP_FOR_COORD_OLD ped_13_x ped_13_y ped_13_z GREEN BLIP_ONLY ped_13_blip
					CHANGE_BLIP_SCALE ped_13_blip 3
					DELETE_CHAR ped_13
					ped_13_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_14_exists > 0
		IF ped_14_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_14_x ped_14_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_14_x ped_14_y ped_14_z ped_14
    			GIVE_WEAPON_TO_CHAR	ped_14 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_14 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_14 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_14 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_14 random_direction
				REMOVE_BLIP ped_14_blip
				ADD_BLIP_FOR_CHAR_OLD ped_14 GREEN BOTH ped_14_blip
				CHANGE_BLIP_SCALE ped_14_blip 3
				ped_14_exists = 2
			ENDIF
		ENDIF
		IF ped_14_exists = 2
			IF IS_CHAR_DEAD ped_14
				REMOVE_BLIP ped_14_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_14
				ped_14_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_14_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_14 90.0 90.0 0
					GET_CHAR_COORDINATES ped_14 ped_14_x ped_14_y ped_14_z
					REMOVE_BLIP ped_14_blip
					ADD_BLIP_FOR_COORD_OLD ped_14_x ped_14_y ped_14_z GREEN BLIP_ONLY ped_14_blip
					CHANGE_BLIP_SCALE ped_14_blip 3
					DELETE_CHAR ped_14
					ped_14_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF ped_15_exists > 0
		IF ped_15_exists = 1
			IF LOCATE_PLAYER_ANY_MEANS_2D player ped_15_x ped_15_y 90.0 90.0 0
				CREATE_CHAR	PEDTYPE_GANG_YARDIE PED_GANG_YARDIE_A ped_15_x ped_15_y ped_15_z ped_15
    			GIVE_WEAPON_TO_CHAR	ped_15 WEAPONTYPE_UZI 999
				SET_CHAR_PERSONALITY ped_15 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_GUN
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_PLAYER2
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_PLAYER3
				SET_CHAR_THREAT_SEARCH ped_15 THREAT_PLAYER4
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_15 TRUE
				GENERATE_RANDOM_INT_IN_RANGE 0 8 random_direction
				CHAR_WANDER_DIR ped_15 random_direction
				REMOVE_BLIP ped_15_blip
				ADD_BLIP_FOR_CHAR_OLD ped_15 GREEN BOTH ped_15_blip
				CHANGE_BLIP_SCALE ped_15_blip 3
				ped_15_exists = 2
			ENDIF
		ENDIF
		IF ped_15_exists = 2
			IF IS_CHAR_DEAD ped_15
				REMOVE_BLIP ped_15_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED ped_15
				ped_15_exists = 0
				++ dead_peds
				-- number_of_peds
				PRINT_NOW KM5_1 2000 1 // "One down, two more to kill."
				GOSUB create_random_ped
				GOSUB create_random_ped
			ENDIF
			IF ped_15_exists = 2
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ped_15 90.0 90.0 0
					GET_CHAR_COORDINATES ped_15 ped_15_x ped_15_y ped_15_z
					REMOVE_BLIP ped_15_blip
					ADD_BLIP_FOR_COORD_OLD ped_15_x ped_15_y ped_15_z GREEN BLIP_ONLY ped_15_blip
					CHANGE_BLIP_SCALE ped_15_blip 3
					DELETE_CHAR ped_15
					ped_15_exists = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ENDWHILE

IF dead_peds > minimum_kills
OR dead_peds = minimum_kills
	GOTO mission_kenji5_passed
ELSE
	GOTO mission_kenji5_failed
ENDIF


delete_oldest_ped://///////////////////////////////////////////////////////////////////////////

oldest_ped = 0

GET_GAME_TIMER oldest_ped_time

IF ped_1_exists = 1
AND ped_1_time < oldest_ped_time
	oldest_ped = 1
	oldest_ped_time = ped_1_time
ENDIF

IF ped_2_exists = 1
AND ped_2_time < oldest_ped_time
	oldest_ped = 2
	oldest_ped_time = ped_2_time
ENDIF

IF ped_3_exists = 1
AND ped_3_time < oldest_ped_time
	oldest_ped = 3
	oldest_ped_time = ped_3_time
ENDIF

IF ped_4_exists = 1
AND ped_4_time < oldest_ped_time
	oldest_ped = 4
	oldest_ped_time = ped_4_time
ENDIF

IF ped_5_exists = 1
AND ped_5_time < oldest_ped_time
	oldest_ped = 5
	oldest_ped_time = ped_5_time
ENDIF

IF ped_6_exists = 1
AND ped_6_time < oldest_ped_time
	oldest_ped = 6
	oldest_ped_time = ped_6_time
ENDIF

IF ped_7_exists = 1
AND ped_7_time < oldest_ped_time
	oldest_ped = 7
	oldest_ped_time = ped_7_time
ENDIF

IF ped_8_exists = 1
AND ped_8_time < oldest_ped_time
	oldest_ped = 8
	oldest_ped_time = ped_8_time
ENDIF

IF ped_9_exists = 1
AND ped_9_time < oldest_ped_time
	oldest_ped = 9
	oldest_ped_time = ped_9_time
ENDIF

IF ped_10_exists = 1
AND ped_10_time < oldest_ped_time
	oldest_ped = 10
	oldest_ped_time = ped_10_time
ENDIF

IF ped_11_exists = 1
AND ped_11_time < oldest_ped_time
	oldest_ped = 11
	oldest_ped_time = ped_11_time
ENDIF

IF ped_12_exists = 1
AND ped_12_time < oldest_ped_time
	oldest_ped = 12
	oldest_ped_time = ped_12_time
ENDIF

IF ped_13_exists = 1
AND ped_13_time < oldest_ped_time
	oldest_ped = 13
	oldest_ped_time = ped_13_time
ENDIF

IF ped_14_exists = 1
AND ped_14_time < oldest_ped_time
	oldest_ped = 14
	oldest_ped_time = ped_14_time
ENDIF

IF ped_15_exists = 1
AND ped_15_time < oldest_ped_time
	oldest_ped = 15
	oldest_ped_time = ped_15_time
ENDIF

///////////////////////////////////////

IF oldest_ped = 1
	REMOVE_BLIP ped_1_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_1
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_1_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 2
	REMOVE_BLIP ped_2_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_2
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_2_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 3
	REMOVE_BLIP ped_3_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_3
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_3_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 4
	REMOVE_BLIP ped_4_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_4
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_4_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 5
	REMOVE_BLIP ped_5_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_5
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_5_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 6
	REMOVE_BLIP ped_6_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_6
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_6_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 7
	REMOVE_BLIP ped_7_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_7
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_7_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 8
	REMOVE_BLIP ped_8_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_8
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_8_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 9
	REMOVE_BLIP ped_9_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_9
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_9_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 10
	REMOVE_BLIP ped_10_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_10
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_10_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 11
	REMOVE_BLIP ped_11_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_11
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_11_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 12
	REMOVE_BLIP ped_12_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_12
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_12_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 13
	REMOVE_BLIP ped_13_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_13
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_13_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 14
	REMOVE_BLIP ped_14_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_14
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_14_exists = 0
	-- number_of_peds
ENDIF

IF oldest_ped = 15
	REMOVE_BLIP ped_15_blip
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_15
	PRINT_NOW KM5_2 2000 1 // "A Yardie has gone to ground."
	ped_15_exists = 0
	-- number_of_peds
ENDIF

RETURN

}

// Mission Kenji5 failed

mission_kenji5_failed:
PRINT_BIG ( M_FAIL ) 5000 1
PRINT_WITH_NUMBER_NOW KM5_3 minimum_kills 3000 1 // "You failed to kill at least ~1~ yardies."
RETURN

   

// mission Kenji5 passed

mission_kenji5_passed:

flag_kenji_mission5_passed = 1
PRINT_WITH_NUMBER_BIG m_pass 10000 5000 1
ADD_SCORE player 10000
IF dead_peds = 8
	PRINT_WITH_NUMBER_NOW KM5_4 dead_peds 3000 1 // "Congratulations you killed ~1~ Yardies."
ELSE
	reward_kills = dead_peds - minimum_kills
	reward_kills = reward_kills * 1000
	PRINT_WITH_2_NUMBERS_NOW KM5_5 dead_peds reward_kills 3000 1 // "Congratulations you killed ~1~ Yardies."
ENDIF	
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	KM5
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP kenji_contact_blip
RETURN
		


// mission cleanup

mission_cleanup_kenji5:

flag_player_on_mission = 0
flag_player_on_kenji_mission = 0

REMOVE_BLIP ped_1_blip
REMOVE_BLIP ped_2_blip
REMOVE_BLIP ped_3_blip
REMOVE_BLIP ped_4_blip
REMOVE_BLIP ped_5_blip
REMOVE_BLIP ped_6_blip
REMOVE_BLIP ped_7_blip
REMOVE_BLIP ped_8_blip

REMOVE_BLIP ped_9_blip
REMOVE_BLIP ped_10_blip
REMOVE_BLIP ped_11_blip
REMOVE_BLIP ped_12_blip
REMOVE_BLIP ped_13_blip
REMOVE_BLIP ped_14_blip
REMOVE_BLIP ped_15_blip

CLEAR_ONSCREEN_COUNTER dead_peds

MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YARDIE_A

MISSION_HAS_FINISHED

RETURN
		



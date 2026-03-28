MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 1****************************************
// ***************************************Laundry day*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_toni1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_toni1_failed
ENDIF

GOSUB mission_cleanup_toni1

MISSION_END

// Variables for mission

VAR_INT t1_triad_van1 t1_triad_van2 t1_triad_van3 //t1_triad_van4 // Vehicle for mission

VAR_INT blip1_van1 blip2_van2 blip3_van3 //blip4_van4

VAR_INT counter1_toni1 // Counts up number of mission vans destroyed

VAR_INT vanman1 vanman2 vanman3 in_van1 in_van2 in_van3 //vanman4 in_van4
 
VAR_INT dead_van1 dead_van2 dead_van3 //dead_van4

VAR_INT grenade_blip picked_up_grenades

VAR_INT triad_hates_you	free_greandes

// ***************************************Mission Start*************************************

mission_start_toni1:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_toni_mission = 1
SCRIPT_NAME toni1
WAIT 0

picked_up_grenades = 0
counter1_toni1 = 0
dead_van1 = 0
dead_van2 = 0
dead_van3 = 0
//dead_van4 = 0
in_van1 = 0
in_van2	= 0
in_van3	= 0
//in_van4	= 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_toni1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( TM1 ) 15000 2 //"Toni Mission 1"	 
*/

{

LOAD_SPECIAL_CHARACTER 1 tony
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 TONYH
REQUEST_MODEL ind_newrizzos

/*
WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE
*/

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED ind_newrizzos
	WAIT 0

ENDWHILE

LOAD_CUTSCENE t1_tol
SET_CUTSCENE_OFFSET 1218.42 -314.5 28.9
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_tony
SET_CUTSCENE_ANIM cs_tony tony

CREATE_CUTSCENE_HEAD cs_tony CUT_OBJ2 cs_tonyhead
SET_CUTSCENE_HEAD_ANIM cs_tonyhead tony

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

SET_PLAYER_HEADING player 180.0

CLEAR_AREA 1216.1 -313.0 29.9 10.0 TRUE	//TONIS RESTAURANT

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 171
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_A ) 10000 1 // Mission brief

WHILE cs_time < 3769
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_B ) 10000 1 // Mission brief

WHILE cs_time < 5825
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_C ) 10000 1 // Mission brief

WHILE cs_time < 8026
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_D ) 10000 1 // Mission brief

WHILE cs_time < 11500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 15961
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_G ) 10000 1 // Mission brief

WHILE cs_time < 21005
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_H ) 10000 1 // Mission brief

WHILE cs_time < 22997
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_I ) 10000 1 // Mission brief

WHILE cs_time < 27589
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_J ) 10000 1 // Mission brief

WHILE cs_time < 29796
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 31666
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

REQUEST_MODEL CAR_MRWONGS
REQUEST_MODEL PED_CT_MAN1
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER


WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED ind_newrizzos

	WHILE NOT HAS_MODEL_LOADED CAR_MRWONGS
	OR NOT HAS_MODEL_LOADED PED_CT_MAN1
		WAIT 0

	ENDWHILE
	 
// START OF MISSION

SWITCH_CAR_GENERATOR gen_car31 0 

CREATE_PICKUP_WITH_AMMO WEAPON_GRENADE PICKUP_ONCE 10 1278.8 -81.5 15.1 free_greandes
ADD_SPRITE_BLIP_FOR_PICKUP free_greandes RADAR_SPRITE_WEAPON grenade_blip

CREATE_CAR CAR_MRWONGS 854.0 -778.0 -100.0 t1_triad_van1  
CREATE_CHAR_INSIDE_CAR t1_triad_van1 PEDTYPE_CIVMALE PED_CT_MAN1 vanman1
ADD_BLIP_FOR_CAR t1_triad_van1 blip1_van1
SET_CAR_CRUISE_SPEED  t1_triad_van1 17.0
SET_CAR_DRIVING_STYLE t1_triad_van1 0
SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van1 TRUE
SET_CHAR_PERSONALITY vanman1 PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH t1_triad_van1 600

CREATE_CAR CAR_MRWONGS 1020.0 -677.0 -100.0 t1_triad_van2
CREATE_CHAR_INSIDE_CAR t1_triad_van2 PEDTYPE_CIVMALE PED_CT_MAN1 vanman2
ADD_BLIP_FOR_CAR t1_triad_van2 blip2_van2
SET_CAR_CRUISE_SPEED  t1_triad_van2 17.0
SET_CAR_DRIVING_STYLE t1_triad_van2 0
SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van2 TRUE
SET_CHAR_PERSONALITY vanman2 PEDSTAT_GEEK_GUY
//SET_CAR_HEALTH t1_triad_van2 600

CREATE_CAR CAR_MRWONGS 904.0 -579.0 -100.0 t1_triad_van3
CREATE_CHAR_INSIDE_CAR t1_triad_van3 PEDTYPE_CIVMALE PED_CT_MAN1 vanman3
ADD_BLIP_FOR_CAR t1_triad_van3 blip3_van3
SET_CAR_CRUISE_SPEED  t1_triad_van3 17.0
SET_CAR_DRIVING_STYLE t1_triad_van3 0
SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van3 TRUE
SET_CHAR_PERSONALITY vanman3 PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH t1_triad_van3 600
/*
CREATE_CAR CAR_MRWONGS 996.0 -463.0 14.0 t1_triad_van4
CREATE_CHAR_INSIDE_CAR t1_triad_van4 PEDTYPE_CIVMALE PED_CT_MAN1 vanman4
ADD_BLIP_FOR_CAR t1_triad_van4 blip4_van4
SET_CAR_CRUISE_SPEED  t1_triad_van4 17.0
SET_CAR_DRIVING_STYLE t1_triad_van4 0
SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van4 TRUE
SET_CHAR_PERSONALITY vanman4 PEDSTAT_GEEK_GUY
SET_CAR_HEALTH t1_triad_van4 600
*/

WHILE NOT counter1_toni1 = 3
	WAIT 0

		IF IS_CAR_DEAD t1_triad_van1 
		AND dead_van1 = 0
			REMOVE_BLIP blip1_van1
			dead_van1 = 1
			++ counter1_toni1	
		ENDIF
	
		IF NOT IS_CAR_DEAD t1_triad_van1 
			IF NOT IS_CAR_HEALTH_GREATER t1_triad_van1 999
				IF NOT IS_CHAR_DEAD vanman1
					IF IS_CHAR_IN_CAR vanman1 t1_triad_van1
						SET_CAR_CRUISE_SPEED t1_triad_van1 18.0
						SET_CAR_DRIVING_STYLE t1_triad_van1 2
						SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van1 FALSE
					ENDIF
				ENDIF
			ENDIF
		ENDIF
 
		IF NOT IS_CAR_DEAD t1_triad_van1
			IF IS_PLAYER_IN_CAR player t1_triad_van1
			AND in_van1 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van1 FALSE
				in_van1 = 1
			ENDIF
		ENDIF

		IF IS_CAR_DEAD t1_triad_van2
		AND dead_van2 = 0 
			REMOVE_BLIP blip2_van2
			dead_van2 = 1
			++ counter1_toni1
		ENDIF
	   	
		IF NOT IS_CAR_DEAD t1_triad_van2
			IF NOT IS_CAR_HEALTH_GREATER t1_triad_van2 999
				IF NOT IS_CHAR_DEAD vanman2
					IF IS_CHAR_IN_CAR vanman2 t1_triad_van2
						SET_CAR_CRUISE_SPEED t1_triad_van2 17.0
						SET_CAR_DRIVING_STYLE t1_triad_van2 2
						SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van2 FALSE
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD t1_triad_van2
			IF IS_PLAYER_IN_CAR player t1_triad_van2
			AND in_van2 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van2 FALSE
				in_van2 = 1
			ENDIF
		ENDIF

	   	IF IS_CAR_DEAD t1_triad_van3
		AND dead_van3 = 0 
			REMOVE_BLIP blip3_van3
			dead_van3 = 1
			++ counter1_toni1
		ENDIF
		
		IF NOT IS_CAR_DEAD t1_triad_van3
			IF NOT IS_CAR_HEALTH_GREATER t1_triad_van3 999
				IF NOT IS_CHAR_DEAD vanman3
					IF IS_CHAR_IN_CAR vanman3 t1_triad_van3
						SET_CAR_CRUISE_SPEED t1_triad_van3 19.0
						SET_CAR_DRIVING_STYLE t1_triad_van3 2
						SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van3 FALSE
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD t1_triad_van3
			IF IS_PLAYER_IN_CAR player t1_triad_van3
			AND in_van3 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van3 FALSE
				in_van3 = 1
			ENDIF
		ENDIF
		/*
		IF IS_CAR_DEAD t1_triad_van4
		AND dead_van4 = 0 
			REMOVE_BLIP blip4_van4
			dead_van4 = 1
			++ counter1_toni1
		ENDIF
		
		IF NOT IS_CAR_DEAD t1_triad_van4
			IF NOT IS_CAR_HEALTH_GREATER t1_triad_van4 599
				IF NOT IS_CHAR_DEAD vanman4
					IF IS_CHAR_IN_CAR vanman4 t1_triad_van4
						SET_CAR_CRUISE_SPEED t1_triad_van4 20.0
						SET_CAR_DRIVING_STYLE t1_triad_van4 2
						SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van4 FALSE		
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD t1_triad_van4
			IF IS_PLAYER_IN_CAR player t1_triad_van4
			AND in_van4 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER t1_triad_van4 FALSE
				in_van4 = 1
			ENDIF
		ENDIF
		*/
		IF HAS_PICKUP_BEEN_COLLECTED free_greandes
		AND picked_up_grenades = 0
			WAIT 1500
			GET_CONTROLLER_MODE controlmode
			IF controlmode = 0
			OR controlmode = 1
				PRINT_HELP GREN_1
			ENDIF
			IF controlmode = 2
				PRINT_HELP GREN_2
			ENDIF
			IF controlmode = 3
				PRINT_HELP GREN_3
			ENDIF
			picked_up_grenades = 1
		ENDIF
		 
ENDWHILE

}

GOTO mission_toni1_passed 

 // Mission toni1 failed

mission_toni1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission toni1 passed

mission_toni1_passed:

flag_toni_mission1_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 20000
REGISTER_MISSION_PASSED	TM1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT toni_mission2_loop 
RETURN
		


// mission cleanup

mission_cleanup_toni1:

flag_player_on_mission = 0
flag_player_on_toni_mission = 0
REMOVE_BLIP blip1_van1
REMOVE_BLIP blip2_van2
REMOVE_BLIP blip3_van3
//REMOVE_BLIP blip4_van4
REMOVE_BLIP grenade_blip
REMOVE_PICKUP free_greandes
SWITCH_CAR_GENERATOR gen_car31 101
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MRWONGS
MARK_MODEL_AS_NO_LONGER_NEEDED PED_CT_MAN1
MISSION_HAS_FINISHED
RETURN

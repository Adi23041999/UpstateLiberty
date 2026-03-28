MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Deablo mission 4**************************************
// ***************************************Donkey Porn*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_diablo4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_diablo4_failed
ENDIF

GOSUB mission_cleanup_diablo4

MISSION_END

// Variables for mission

VAR_INT counter_diablo4 // Counts up number of mission vans destroyed

VAR_INT porn_man porn_van blip1_porn_van blip2_porn_shop blip3_pornman

VAR_INT NumEaten_diablo4 NumEaten_diablo4_total eaten_all_the_porn

VAR_INT diablo_collect_porn_van	audio_loop_diablo4

VAR_INT flag_car_blip_displayed_dm4	found_perv_before

VAR_INT donkeymag1, donkeymag2, donkeymag3, pervert1, pervert2, pervert3, pervert4, pervert5, pervert6, pervert7, pervert8

//VAR_INT pac_man_record_on	//Create a new race

 
// ***************************************Mission Start*************************************

mission_start_diablo4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_diablo_mission = 1
SCRIPT_NAME diablo4

audio_loop_diablo4 = 0
NumEaten_diablo4_total = 0 
found_perv_before = 0
eaten_all_the_porn = 0

WAIT 0


{

SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA_OF_CHARS 890.3 -309.1 0.0 1038.1 -132.9 10.0

LOAD_CUTSCENE EL_PH3
SET_CUTSCENE_OFFSET 938.27 -229.561 4.023
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_A ) 10000 1 

WHILE cs_time < 7326
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_B ) 10000 1 

WHILE cs_time < 10740
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_C ) 10000 1 

WHILE cs_time < 12550
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_D ) 10000 1 

WHILE cs_time < 17195
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_E ) 10000 1 

WHILE cs_time < 22417
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_F ) 10000 1 

WHILE cs_time < 24124
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_G ) 10000 1 

WHILE cs_time < 28426
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB4_H ) 10000 1 

WHILE cs_time < 33574
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 34000
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

WAIT 500

DO_FADE 1500 FADE_IN

SET_PED_DENSITY_MULTIPLIER 1.0


LOAD_MISSION_AUDIO EL3_A

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0

ENDWHILE


NumEaten_diablo4 = 0

	IF flag_asuka_mission1_passed = 1
		SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_UZI //The Mafia
	ENDIF

	REQUEST_MODEL CAR_RUMPO
	REQUEST_MODEL PED_MALE2
    LOAD_SPECIAL_CHARACTER 1 DONKY
						  
	WHILE NOT HAS_MODEL_LOADED CAR_RUMPO
	OR NOT HAS_MODEL_LOADED PED_MALE2
		WAIT 0
	ENDWHILE

	CLEAR_AREA 918.2 -269.7 5.0 5.0	TRUE
	CREATE_CAR CAR_RUMPO 918.2 -269.7 -100.0 diablo_collect_porn_van  
	ADD_BLIP_FOR_CAR diablo_collect_porn_van blip1_porn_van

	IF IS_CAR_DEAD diablo_collect_porn_van
		GOTO mission_diablo4_failed	
	ENDIF

//GOTO pervert_test //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

WHILE NOT IS_PLAYER_IN_CAR player diablo_collect_porn_van
	WAIT 0
	
	IF IS_CAR_DEAD diablo_collect_porn_van
		GOTO mission_diablo4_failed	
	ENDIF

ENDWHILE

START_PACMAN_RACE 0

SET_POLICE_IGNORE_PLAYER Player ON
SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON


IF LOCATE_CAR_2D diablo_collect_porn_van 918.2 -269.7 10.0 10.0 FALSE
	SET_FIXED_CAMERA_POSITION 914.282 -157.729 6.409 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT 914.107 -156.829 6.012 INTERPOLATION
ELSE
	SET_FIXED_CAMERA_POSITION 914.282 -157.729 6.409 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT 914.107 -156.829 6.012 JUMP_CUT
ENDIF

WAIT 4000

SET_POLICE_IGNORE_PLAYER Player OFF
SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

	REMOVE_BLIP blip1_porn_van

	CREATE_CAR CAR_RUMPO 1577.1 -679.0 -100.0 porn_van
	SET_CAR_HEADING porn_van 309.0
	 
	CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_MALE2 1574.0 -681.1 -100.0 porn_man
	ADD_BLIP_FOR_CHAR porn_man blip3_pornman
	CHANGE_BLIP_DISPLAY blip3_pornman MARKER_ONLY

	counter_diablo4 = 26000
	DISPLAY_ONSCREEN_TIMER counter_diablo4


	IF IS_CAR_DEAD diablo_collect_porn_van
		GOTO mission_diablo4_failed	
	ENDIF

	flag_car_blip_displayed_dm4 = TRUE


WHILE NOT IS_CHAR_DEAD porn_man 
	WAIT 0	

	IF IS_CAR_DEAD diablo_collect_porn_van
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_diablo4_failed	
	ENDIF

	IF NOT IS_CHAR_DEAD	porn_man
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player porn_man 30.0 30.0 FALSE
		AND found_perv_before = 0
			CLEAR_ONSCREEN_TIMER counter_diablo4
			found_perv_before = 1
		ENDIF
	ENDIF

	IF counter_diablo4 = 0
		GOTO mission_diablo4_failed
	ENDIF

	GET_NUMBER_OF_POWER_PILLS_EATEN NumEaten_diablo4

	IF NumEaten_diablo4 > 0
	AND IS_PLAYER_IN_CAR player diablo_collect_porn_van
		counter_diablo4 = counter_diablo4 + 1300
		CLEAR_NUMBER_OF_POWER_PILLS_EATEN
		NumEaten_diablo4_total ++
	ENDIF

	IF NumEaten_diablo4_total > 0
	AND audio_loop_diablo4 = 0 
		PLAY_MISSION_AUDIO
		audio_loop_diablo4 = 1
	ENDIF

	IF IS_PLAYER_IN_CAR player diablo_collect_porn_van
		IF flag_car_blip_displayed_dm4 = TRUE
			REMOVE_BLIP blip1_porn_van
			CLEAR_THIS_PRINT  ( IN_VEH )
			flag_car_blip_displayed_dm4 = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player diablo_collect_porn_van
		IF flag_car_blip_displayed_dm4 = FALSE
			ADD_BLIP_FOR_CAR diablo_collect_porn_van blip1_porn_van
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
			flag_car_blip_displayed_dm4 = TRUE
		ENDIF
	ENDIF

	IF NumEaten_diablo4_total = 106
	AND eaten_all_the_porn = 0
		ADD_SCORE player 10000
		GET_PLAYER_COORDINATES Player player_X player_Y player_Z
		ADD_ONE_OFF_SOUND player_X player_Y player_Z SOUND_PART_MISSION_COMPLETE
		eaten_all_the_porn = 1			
	ENDIF

ENDWHILE

	REMOVE_BLIP blip3_pornman
	REMOVE_BLIP blip1_porn_van
	ADD_BLIP_FOR_COORD 973.9 -428.3 -100.0 blip2_porn_shop
	REMOVE_BLIP blip2_porn_shop

	CLEAR_ONSCREEN_TIMER counter_diablo4
	CLEAR_PACMAN

	PRINT_NOW ( DIAB4_1 ) 5000 1 // Mission brief

	IF IS_CAR_DEAD diablo_collect_porn_van 
		GOTO mission_diablo4_failed	
	ENDIF

	IF IS_PLAYER_IN_CAR	player diablo_collect_porn_van
		flag_car_blip_displayed_dm4 = TRUE
	ELSE
	    flag_car_blip_displayed_dm4 = FALSE
	ENDIF
 

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D diablo_collect_porn_van 976.5 -422.8 14.5 970.8 -433.4 16.9 TRUE
	WAIT 0

		IF IS_CAR_DEAD diablo_collect_porn_van
			PRINT_NOW ( WRECKED ) 5000 1 
			GOTO mission_diablo4_failed
		ENDIF

		IF IS_PLAYER_IN_CAR player diablo_collect_porn_van
			IF flag_car_blip_displayed_dm4 = TRUE
				ADD_BLIP_FOR_COORD 973.9 -428.3 -100.0 blip2_porn_shop
				REMOVE_BLIP blip1_porn_van
				CLEAR_THIS_PRINT  ( IN_VEH ) 
			flag_car_blip_displayed_dm4 = FALSE
			ENDIF
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player diablo_collect_porn_van
			IF flag_car_blip_displayed_dm4 = FALSE
				ADD_BLIP_FOR_CAR diablo_collect_porn_van blip1_porn_van
				REMOVE_BLIP blip2_porn_shop
				PRINT_SOON ( IN_VEH ) 5000 1 //"Get back in the car!"
				flag_car_blip_displayed_dm4 = TRUE
			ENDIF
		ENDIF

ENDWHILE

//PERVERTS CUT SCENE*********************************************************************

//pervert_test:

	SET_POLICE_IGNORE_PLAYER Player On
	SET_PLAYER_CONTROL Player Off
	SWITCH_WIDESCREEN ON
	SET_PED_DENSITY_MULTIPLIER 0.0

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1  
		WAIT 0

	ENDWHILE

WAIT 1000

SET_MUSIC_DOES_FADE FALSE
SET_FADING_COLOUR 0 0 0
DO_FADE 1000 FADE_OUT

WAIT 1000

CLEAR_AREA 988.9 -444.7 14.9 10.0 TRUE

CREATE_CHAR PEDTYPE_CIVMALE PED_SPECIAL1 988.7 -444.5 14.1 pervert1
SET_CHAR_HEADING pervert1 180.0
 
CREATE_CHAR PEDTYPE_CIVMALE PED_SPECIAL1 987.7 -444.3 13.9 pervert2
SET_CHAR_HEADING pervert2 140.0

CREATE_CHAR PEDTYPE_CIVMALE PED_SPECIAL1 986.9 -444.9 13.9 pervert3
SET_CHAR_HEADING pervert3 140.0

CREATE_CHAR PEDTYPE_CIVMALE PED_MALE2 990.4 -441.9 14.1 pervert4
SET_CHAR_HEADING pervert4 83.0

CREATE_CHAR PEDTYPE_CIVMALE PED_MALE2 991.1 -440.7 13.9 pervert5
SET_CHAR_HEADING pervert5 128.0

CREATE_CHAR PEDTYPE_CIVMALE PED_MALE2 992.1 -439.1 13.9 pervert6
SET_CHAR_HEADING pervert6 141.0

CREATE_CHAR PEDTYPE_CIVMALE PED_MALE2 992.0 -437.7 13.9 pervert7
SET_CHAR_HEADING pervert7 180.0

CREATE_CHAR PEDTYPE_CIVMALE PED_MALE2 992.1 -436.1 13.9 pervert8
SET_CHAR_HEADING pervert8 180.0

SET_FIXED_CAMERA_POSITION 982.705 -448.508 16.014 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 982.707 -447.632 16.496 JUMP_CUT

SET_CHAR_WAIT_STATE pervert1 WAITSTATE_CROSS_ROAD_LOOK 10000
SET_CHAR_WAIT_STATE pervert3 WAITSTATE_CROSS_ROAD_LOOK 10000
SET_CHAR_WAIT_STATE pervert2 WAITSTATE_CROSS_ROAD_LOOK 10000

SET_CHAR_AS_LEADER pervert1 pervert3
SET_CHAR_AS_LEADER pervert2 pervert3

DO_FADE 1000 FADE_IN

WAIT 2000

SET_FIXED_CAMERA_POSITION 986.596 -448.508 16.014 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 986.514 -447.632 16.496 INTERPOLATION

WAIT 3000

IF NOT IS_CHAR_DEAD pervert3
	SET_FIXED_CAMERA_POSITION 988.078 -445.869 16.3 0.0 0.0 0.0 
	POINT_CAMERA_AT_CHAR pervert3 FIXED INTERPOLATION
ENDIF

WAIT 3000

CLEAR_AREA 978.9 -444.4 14.9 3.0 TRUE

IF NOT IS_CHAR_DEAD	pervert3
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT pervert3 935.6 -445.8
ENDIF

WAIT 4000

SET_PED_DENSITY_MULTIPLIER 1.0

SET_FIXED_CAMERA_POSITION 994.524 -451.391 18.02 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 994.048 -450.563 17.724 INTERPOLATION

WAIT 6000

IF NOT IS_CHAR_DEAD	pervert3
	CHAR_WANDER_DIR pervert3 90
ENDIF

IF NOT IS_CHAR_DEAD	pervert2
	CHAR_WANDER_DIR pervert2 90
ENDIF

IF NOT IS_CHAR_DEAD	pervert1
	CHAR_WANDER_DIR pervert1 90		   
ENDIF


//PERVERTS CUT SCENE END******************************************************************

IF NOT IS_CAR_DEAD diablo_collect_porn_van
	IF IS_PLAYER_IN_CAR player diablo_collect_porn_van
		CLEAR_AREA 978.3 -442.7 13.9 1.0 TRUE
		WARP_PLAYER_FROM_CAR_TO_COORD player 978.3 -442.7 13.9
		SET_PLAYER_HEADING Player 180.0
	ELSE
		CLEAR_AREA 978.3 -442.7 13.9 1.0 TRUE
	   	SET_PLAYER_COORDINATES Player 978.3 -442.7 13.9
	   	SET_PLAYER_HEADING Player 180.0
	ENDIF
ENDIF


GOTO mission_diablo4_passed

}

 // Mission toni1 failed

mission_diablo4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN
 

// mission toni1 passed

mission_diablo4_passed:

flag_diablo_mission4_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 20000
CREATE_OBJECT donkeymag 895.2 -308.2 7.4 donkeymag1
DONT_REMOVE_OBJECT donkeymag1
CREATE_OBJECT donkeymag 896.1 -308.6 7.4 donkeymag2
DONT_REMOVE_OBJECT donkeymag2
CREATE_OBJECT donkeymag	890.1 -309.6 7.4 donkeymag3
DONT_REMOVE_OBJECT donkeymag3
SET_OBJECT_HEADING donkeymag1 260.0
SET_OBJECT_HEADING donkeymag2 280.0
SET_OBJECT_HEADING donkeymag3 190.0
flag_diablo_mission1_passed = 0
REMOVE_BLIP diablo_contact_blip
START_NEW_SCRIPT diablo_mission1_loop
REGISTER_MISSION_PASSED DIAB4
PLAYER_MADE_PROGRESS 1
RETURN
		


// mission cleanup

mission_cleanup_diablo4:

flag_player_on_mission = 0
flag_player_on_diablo_mission = 0
REMOVE_BLIP blip1_porn_van
REMOVE_BLIP blip2_porn_shop
REMOVE_BLIP blip3_pornman
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_MALE2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_RUMPO
CLEAR_ONSCREEN_TIMER counter_diablo4
CLEAR_PACMAN
SET_MUSIC_DOES_FADE TRUE
UNLOAD_SPECIAL_CHARACTER 1
	IF flag_asuka_mission1_passed = 1
		SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_SHOTGUN //The Mafia
	ENDIF
MISSION_HAS_FINISHED
RETURN

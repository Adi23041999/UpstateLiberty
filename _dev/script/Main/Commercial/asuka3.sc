MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *************************************Asuka mission 3************************************* 
// *************************************Boat Spy thing**************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_asuka3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_asuka3_failed
ENDIF
										  
GOSUB mission_cleanup_asuka3

MISSION_END
 
// Variables for mission

VAR_INT blip1_as3 blip2_as3 cop_boat been_in_cop_boat_before  
VAR_INT spy_boat spy_bloke spy_car 
VAR_INT spy_blokes_car asuka_boat
VAR_INT boat_coord_number boat_health boat_health2
VAR_INT help1_displayed help2_displayed
// ****************************************Mission Start************************************

mission_start_asuka3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_asuka_mission = 1
help1_displayed = 0
help2_displayed = 0
SCRIPT_NAME asuka3
WAIT 0

been_in_cop_boat_before = 0

{

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2	NOTE
REQUEST_MODEL PED_MALE1
REQUEST_MODEL BOAT_REEFER
REQUEST_MODEL BOAT_SPEEDER
REQUEST_MODEL BOAT_PREDATOR
REQUEST_MODEL CAR_STALLION
REQUEST_MODEL condo_ivy
REQUEST_MODEL kmricndo01

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED condo_ivy
OR NOT HAS_MODEL_LOADED	kmricndo01
	WAIT 0

ENDWHILE

LOAD_CUTSCENE A2_PP
SET_CUTSCENE_OFFSET 523.102 -636.96 15.616

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj2 cs_note
SET_CUTSCENE_ANIM cs_note NOTE

CLEAR_AREA 523.6 -639.4 16.6 1.0 TRUE
SET_PLAYER_COORDINATES player 523.6 -639.4 16.0

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 3406
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM3_A ) 10000 1 

WHILE cs_time < 5677
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM3_B ) 10000 1 

WHILE cs_time < 11354
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( AM3_C ) 10000 1 

WHILE cs_time < 16000
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 1000

DO_FADE 1500 FADE_IN

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED condo_ivy
MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01

WHILE NOT HAS_MODEL_LOADED PED_MALE1
OR NOT HAS_MODEL_LOADED BOAT_SPEEDER
OR NOT HAS_MODEL_LOADED CAR_STALLION
OR NOT HAS_MODEL_LOADED BOAT_PREDATOR
OR NOT HAS_MODEL_LOADED BOAT_REEFER 
	WAIT 0
ENDWHILE

CLEAR_AREA 640.0 -608.0 0.0 6.0 TRUE
CREATE_CAR BOAT_SPEEDER 612.0 -597.0 0.0 spy_boat
SET_CAR_HEADING spy_boat 0.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER spy_boat TRUE
SET_CAR_HEALTH spy_boat 1500
SET_CAR_STRONG spy_boat TRUE

CREATE_CHAR_INSIDE_CAR spy_boat PEDTYPE_CIVMALE PED_MALE1 spy_bloke

CLEAR_AREA 568.0 -686.0 0.0 6.0 TRUE
CREATE_CAR BOAT_REEFER 568.0 -686.0 0.0 asuka_boat
SET_CAR_HEADING asuka_boat 180.0

CLEAR_AREA 554.8 -767.6 0.0 6.0 TRUE
CREATE_CAR BOAT_PREDATOR 554.8 -767.6 0.0 cop_boat
ADD_BLIP_FOR_CAR cop_boat blip1_as3	


// START MISSION			

IF NOT IS_CHAR_DEAD spy_bloke 
	ADD_BLIP_FOR_CHAR spy_bloke blip2_as3
	CHANGE_BLIP_DISPLAY blip2_as3 MARKER_ONLY	
ENDIF

WAIT 1500

SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 526.0 -643.3 19.6 0.0 0.0 0.0

IF NOT IS_CAR_DEAD spy_boat
	POINT_CAMERA_AT_CAR spy_boat FIXED JUMP_CUT
ENDIF

WAIT 3000

SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA


IF NOT IS_CAR_DEAD spy_boat 
	GET_CAR_HEALTH spy_boat boat_health
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING boat_health COUNTER_DISPLAY_BAR (DAM)
	GOSUB boat_health
ENDIF
	
TIMERB = 0

	WHILE NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 55.0 55.0 FALSE
	AND IS_CAR_HEALTH_GREATER spy_boat 1499
		WAIT 0
			
		IF help1_displayed = 0		
			IF TIMERB > 4000
				GET_CONTROLLER_MODE controlmode
				IF controlmode = 3
					PRINT_HELP BOATIN3
				ELSE
					PRINT_HELP BOATIN1 
				ENDIF
				help1_displayed = 1
			ENDIF
		ENDIF

		IF help2_displayed = 0
			IF TIMERB > 11000
				GET_CONTROLLER_MODE controlmode
				IF controlmode = 3
					PRINT_HELP BOATIN4
				ELSE
					PRINT_HELP BOATIN2
				ENDIF
				help2_displayed = 1
			ENDIF
		ENDIF
	
		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE



IF NOT IS_CAR_DEAD spy_boat
	SET_CAR_ONLY_DAMAGED_BY_PLAYER spy_boat FALSE 
	SET_BOAT_CRUISE_SPEED spy_boat 48.0
ENDIF



WAIT 0
//LOCATION1
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 744.8 -350.1 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 744.8 -350.1 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION2
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 728.9 -133.7 0.0
	SET_BOAT_CRUISE_SPEED spy_boat 45.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 728.9 -133.7 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION3
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 635.5 24.7 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 635.5 24.7 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION4
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 746.6 252.9 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 746.6 252.9 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION5
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 872.1 335.9 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 872.1 335.9 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION6
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 1064.5 180.8 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1064.5 180.8 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION7
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 1262.0 166.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1262.0 166.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION8
IF NOT IS_CAR_DEAD spy_boat 
	BOAT_GOTO_COORDS spy_boat 1566.0 52.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1566.0 52.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION9
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1595.0 -154.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1595.0 -154.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION10
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1555.0 -299.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1555.0 -299.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF


		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION11
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1617.0 -600.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1617.0 -600.0 0.0 5.0 5.0 5.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF


		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

	   	IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION12
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1617.0 -762.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1617.0 -762.0 0.0 5.0 5.0 5.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION13
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1637.0 -950.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1637.0 -950.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION14
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1535.0 -1173.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1535.0 -1173.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION15
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 1268.0 -1273.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 1268.0 -1273.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF


		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION16
IF NOT IS_CAR_DEAD spy_boat 	
	BOAT_GOTO_COORDS spy_boat 938.1 -1226.4 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 938.1 -1226.4 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF


		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION17
IF NOT IS_CAR_DEAD spy_boat
	SET_BOAT_CRUISE_SPEED spy_boat 45.0
	BOAT_GOTO_COORDS spy_boat 618.0 -1083.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 618.0 -1083.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION18
IF NOT IS_CAR_DEAD spy_boat
	SET_BOAT_CRUISE_SPEED spy_boat 35.0
	BOAT_GOTO_COORDS spy_boat 560.0 -899.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 560.0 -899.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

//LOCATION19
IF NOT IS_CAR_DEAD spy_boat
	SET_BOAT_CRUISE_SPEED spy_boat 20.0
	BOAT_GOTO_COORDS spy_boat 548.0 -795.0 0.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_boat 548.0 -795.0 0.0 6.0 6.0 6.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_boat
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CAR_DEAD spy_boat
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_boat 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_boat
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_boat 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead
										   
		IF NOT IS_CAR_DEAD spy_boat
			GOSUB boat_health
		ENDIF

	ENDWHILE

WAIT 1000

IF NOT IS_CAR_DEAD spy_boat
AND NOT IS_CHAR_DEAD spy_bloke 	
	BOAT_STOP spy_boat
	ANCHOR_BOAT spy_boat TRUE
	WARP_CHAR_FROM_CAR_TO_COORD spy_bloke 547.3 -778.4 -100.0
	CLEAR_ONSCREEN_COUNTER boat_health	
ENDIF

CREATE_CAR CAR_STALLION 499.7 -734.4 -100.0 spy_car
SET_CAR_HEADING spy_car 90.0

SET_CHAR_RUNNING spy_bloke TRUE
SET_CHAR_OBJ_RUN_TO_COORD spy_bloke 510.0 -775.6

WHILE NOT IS_CHAR_OBJECTIVE_PASSED spy_bloke
	WAIT 0

		IF IS_CHAR_DEAD spy_bloke
			GOTO mission_asuka3_passed
		ENDIF

		GOSUB check_boats_dead

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD spy_bloke 505.2 -751.1

WHILE NOT IS_CHAR_OBJECTIVE_PASSED spy_bloke
	WAIT 0

		IF IS_CHAR_DEAD spy_bloke
			GOTO mission_asuka3_passed
		ENDIF

		GOSUB check_boats_dead

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD spy_bloke 501.1 -749.5

WHILE NOT IS_CHAR_OBJECTIVE_PASSED spy_bloke
	WAIT 0

		IF IS_CHAR_DEAD spy_bloke
			GOTO mission_asuka3_passed
		ENDIF

		GOSUB check_boats_dead

ENDWHILE


IF NOT IS_CAR_DEAD spy_car
	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER spy_bloke spy_car
ENDIF

WHILE NOT IS_CHAR_IN_CAR spy_bloke spy_car
	WAIT 0

		IF IS_CHAR_DEAD spy_bloke
			GOTO mission_asuka3_passed
		ENDIF

		IF IS_CAR_DEAD spy_car
		AND NOT IS_CHAR_DEAD spy_bloke
			GOTO is_he_dead_yet
		ENDIF

		GOSUB check_boats_dead

ENDWHILE


IF NOT IS_CAR_DEAD spy_car
	CAR_GOTO_COORDINATES_ACCURATE spy_car 463.0 -727.4 16.1
	SET_CAR_MISSION spy_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE
   	SET_CAR_DRIVING_STYLE spy_car 1
	SET_CAR_CRUISE_SPEED spy_car 15.0
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_car 463.0 -727.4 16.1 3.0 3.0 3.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_car
		 	GOTO mission_asuka3_passed
		ENDIF

		IF IS_CHAR_DEAD spy_bloke
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CHAR_IN_CAR spy_bloke spy_car
			GOTO is_he_dead_yet	
		ENDIF

		IF NOT IS_CAR_DEAD spy_car
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_car 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_car
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_car 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead
	
	ENDWHILE

IF NOT IS_CAR_DEAD spy_car
	CAR_GOTO_COORDINATES_ACCURATE spy_car 456.0 -707.1 16.0
	SET_CAR_MISSION spy_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_car 456.0 -707.1 16.0 3.0 3.0 3.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_car
		 	GOTO mission_asuka3_passed
		ENDIF

		IF IS_CHAR_DEAD spy_bloke
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CHAR_IN_CAR spy_bloke spy_car
			GOTO is_he_dead_yet	
		ENDIF

		IF NOT IS_CAR_DEAD spy_car
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_car 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_car
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_car 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

	ENDWHILE


IF NOT IS_CAR_DEAD spy_car
	CAR_GOTO_COORDINATES_ACCURATE spy_car 459.0 -678.1 16.0
	SET_CAR_MISSION spy_car MISSION_GOTOCOORDS_STRAIGHT_ACCURATE 
ENDIF

	WHILE NOT LOCATE_CAR_3D spy_car 459.0 -678.1 16.0 3.0 3.0 3.0 FALSE
		WAIT 0

		IF IS_CAR_DEAD spy_car
		 	GOTO mission_asuka3_passed
		ENDIF
							  
		IF IS_CHAR_DEAD spy_bloke
		 	GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CHAR_IN_CAR spy_bloke spy_car
			GOTO is_he_dead_yet	
		ENDIF

		IF NOT IS_CAR_DEAD spy_car
			IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D Player spy_car 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CAR_DEAD spy_car
				AND NOT IS_CHAR_DEAD spy_bloke
					DELETE_CAR spy_car 
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

	ENDWHILE


IF NOT IS_CAR_DEAD spy_car
	CAR_WANDER_RANDOMLY spy_car
	SET_CAR_DRIVING_STYLE spy_car 2
	SET_CAR_CRUISE_SPEED spy_car 25.0
ENDIF

WHILE NOT IS_CHAR_DEAD spy_bloke
	WAIT 0

		IF NOT IS_CHAR_DEAD spy_bloke
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player spy_bloke 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CHAR_DEAD spy_bloke
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		IF IS_CAR_DEAD spy_car
			GOTO mission_asuka3_passed
		ENDIF

		IF NOT IS_CHAR_IN_CAR spy_bloke spy_car
			GOTO is_he_dead_yet	
		ENDIF

		GOSUB check_boats_dead

ENDWHILE


is_he_dead_yet:

SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS spy_bloke Player


WHILE NOT IS_CHAR_DEAD spy_bloke
	WAIT 0

		IF NOT IS_CHAR_DEAD spy_bloke
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player spy_bloke 160.0 160.0 FALSE
				PRINT_NOW ( AWAY ) 5000 2 // Mission brief
				IF NOT IS_CHAR_DEAD spy_bloke
					DELETE_CHAR	spy_bloke
				ENDIF
				GOTO mission_asuka3_failed
			ENDIF
		ENDIF

		GOSUB check_boats_dead

ENDWHILE


GOTO mission_asuka3_passed

}	   		


// Mission asuka3 failed

mission_asuka3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission asuka3 passed

mission_asuka3_passed:

CLEAR_ONSCREEN_COUNTER boat_health
flag_asuka_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED	AM3
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT asuka_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_asuka3:

flag_player_on_mission = 0
flag_player_on_asuka_mission = 0
REMOVE_BLIP blip1_as3
REMOVE_BLIP blip2_as3
MARK_MODEL_AS_NO_LONGER_NEEDED PED_MALE1
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_SPEEDER
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_REEFER
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_PREDATOR
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
CLEAR_ONSCREEN_COUNTER boat_health
MISSION_HAS_FINISHED
RETURN



boat_health:
{
	GET_CAR_HEALTH spy_boat boat_health
	
	boat_health2 = 1500 - boat_health

	IF boat_health2 > 1500
   		boat_health2 = 1500
	ENDIF

	boat_health = boat_health2 / 15

RETURN

}


check_boats_dead:
{
	IF NOT IS_CAR_DEAD cop_boat
		IF IS_PLAYER_IN_CAR	player cop_boat
		AND been_in_cop_boat_before = 0
			GET_CONTROLLER_MODE controlmode
			IF NOT controlmode = 3
				PRINT_HELP PBOAT_1
			ELSE
				PRINT_HELP PBOAT_2
			ENDIF
			REMOVE_BLIP blip1_as3 
			been_in_cop_boat_before = 1
		ENDIF
	ELSE
		IF been_in_cop_boat_before = 0
			REMOVE_BLIP blip1_as3
			been_in_cop_boat_before = 1
		ENDIF
	ENDIF

RETURN
}
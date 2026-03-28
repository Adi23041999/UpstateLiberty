MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 3****************************************
// ***************************************Van heist*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_joey3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey3_failed
ENDIF

GOSUB mission_cleanup_joey3

MISSION_END


// Variables for mission

VAR_INT van_jm3 in_the_locate_joey3

VAR_INT blip1_jm3 blip2_jm3 

VAR_INT	flag_car_blip_displayed_jm3

VAR_INT van_man1_jm3 van_man2_jm3 old_van_health 

VAR_INT test_van_health_counter	test_van_health_counter2

// ***************************************Mission Start*************************************

mission_start_joey3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
SCRIPT_NAME joey3
WAIT 0

in_the_locate_joey3 = 0


{

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_MODEL cut_obj1 JOEYH
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL cut_obj3 TROLL
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint


LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED	cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
	WAIT 0
ENDWHILE


LOAD_CUTSCENE J3_VH
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977 

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ1 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT CUT_OBJ3 cs_troll
SET_CUTSCENE_ANIM cs_troll TROLL
									   	
CLEAR_AREA 1191.9 -870.4 15.0 1.0 TRUE
SET_PLAYER_COORDINATES player 1191.9 -870.4 -100.0

SET_PLAYER_HEADING player 230.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 5515
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_A ) 10000 2 // Mission brief

WHILE cs_time < 7894
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_B ) 10000 2 // Mission brief

WHILE cs_time < 10381
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_C ) 10000 2 // Mission brief

WHILE cs_time < 14589
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_D ) 10000 2 // Mission brief

WHILE cs_time < 17518
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_E ) 10000 2 // Mission brief

WHILE cs_time < 21627
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM3_F ) 10000 2 // Mission brief

WHILE cs_time < 24675
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 27333 
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

WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

LOAD_SPECIAL_CHARACTER 2 S_GUARD
REQUEST_MODEL CAR_SECURICAR

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CAR_SECURICAR 
	WAIT 0
ENDWHILE


// START OF MISSION

CREATE_CAR CAR_SECURICAR 1063.0 -805.0 14.6 van_jm3
LOCK_CAR_DOORS van_jm3 CARLOCK_LOCKOUT_PLAYER_ONLY
SET_CAR_ONLY_DAMAGED_BY_PLAYER van_jm3 TRUE
SET_CAR_PROOFS van_jm3 TRUE TRUE FALSE FALSE TRUE
SET_CAR_CRUISE_SPEED  van_jm3 14.0
SET_CAR_DRIVING_STYLE  van_jm3 0
ADD_BLIP_FOR_CAR van_jm3 blip1_jm3

CREATE_CHAR_INSIDE_CAR van_jm3 PEDTYPE_SPECIAL PED_SPECIAL2 van_man1_jm3
SET_CHAR_PERSONALITY van_man1_jm3 PEDSTAT_GEEK_GUY

CREATE_CHAR_AS_PASSENGER van_jm3 PEDTYPE_SPECIAL PED_SPECIAL2 0 van_man2_jm3
SET_CHAR_PERSONALITY van_man2_jm3 PEDSTAT_GEEK_GUY

GET_CAR_HEALTH van_jm3 test_van_health_counter
DISPLAY_ONSCREEN_COUNTER_WITH_STRING test_van_health_counter COUNTER_DISPLAY_BAR (DAM) //TEST STUFF!!!!!!!!!!!!!

GET_CAR_HEALTH van_jm3 test_van_health_counter 
	test_van_health_counter2 = 1000 - test_van_health_counter

	IF test_van_health_counter2 > 400
		test_van_health_counter2 = 400
	ENDIF

	test_van_health_counter = test_van_health_counter2 / 4


WHILE IS_CAR_HEALTH_GREATER van_jm3 999
	WAIT 0
	   
	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF  
	
	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

	GET_CAR_HEALTH van_jm3 test_van_health_counter 
		test_van_health_counter2 = 1000 - test_van_health_counter

	IF test_van_health_counter2 > 400
		test_van_health_counter2 = 400
	ENDIF

	test_van_health_counter = test_van_health_counter2 / 4

ENDWHILE

	IF NOT IS_CAR_DEAD van_jm3
		SET_CAR_DRIVING_STYLE van_jm3 2
		SET_CAR_CRUISE_SPEED van_jm3 20.0
		ALTER_WANTED_LEVEL_NO_DROP Player 1
		SET_CAR_ONLY_DAMAGED_BY_PLAYER van_jm3 FALSE
		GET_CAR_HEALTH van_jm3 old_van_health
	ENDIF

WHILE IS_CAR_HEALTH_GREATER van_jm3 750
	WAIT 0
	   
	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF  

	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

	IF NOT IS_CAR_DEAD van_jm3
		GET_CAR_HEALTH van_jm3 test_van_health_counter

		IF test_van_health_counter < old_van_health
			ALTER_WANTED_LEVEL_NO_DROP Player 1
		ENDIF	

		old_van_health = test_van_health_counter
	 
		test_van_health_counter2 = 1000 - test_van_health_counter

		IF test_van_health_counter2 > 400
			test_van_health_counter2 = 400
		ENDIF

		test_van_health_counter = test_van_health_counter2 / 4
	ENDIF
						
ENDWHILE

WHILE IS_CAR_HEALTH_GREATER van_jm3 600
	WAIT 0
	   
	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF  

	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

	IF NOT IS_CAR_DEAD van_jm3
		GET_CAR_HEALTH van_jm3 test_van_health_counter

		IF test_van_health_counter < old_van_health
			ALTER_WANTED_LEVEL_NO_DROP Player 2
		ENDIF	

		old_van_health = test_van_health_counter
	 
		test_van_health_counter2 = 1000 - test_van_health_counter

		IF test_van_health_counter2 > 400
			test_van_health_counter2 = 400
		ENDIF

		test_van_health_counter = test_van_health_counter2 / 4
	ENDIF
						
ENDWHILE


	IF NOT IS_CAR_DEAD van_jm3
		LOCK_CAR_DOORS van_jm3 CARLOCK_UNLOCKED
		CLEAR_ONSCREEN_COUNTER test_van_health_counter

		IF NOT IS_CHAR_DEAD van_man1_jm3
			SET_CHAR_OBJ_LEAVE_CAR van_man1_jm3 van_jm3
		ENDIF

		IF NOT IS_CHAR_DEAD van_man2_jm3
			SET_CHAR_OBJ_LEAVE_CAR van_man2_jm3 van_jm3
		ENDIF
	ENDIF

	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF

WHILE NOT IS_CHAR_IN_CAR van_man1_jm3 van_jm3
OR NOT IS_CHAR_IN_CAR van_man2_jm3 van_jm3 
	WAIT 0

	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF 

	IF IS_CHAR_DEAD van_man1_jm3
	OR IS_CHAR_DEAD van_man2_jm3
	ENDIF
	 
	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

ENDWHILE
	
	WAIT 1600

	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF

	IF NOT IS_CHAR_DEAD van_man1_jm3
	AND NOT IS_CHAR_DEAD van_man2_jm3
		SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS van_man1_jm3 player
		SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS van_man2_jm3 player
		SET_CHAR_SAY van_man2_jm3 SOUND_SECURITY_GUARD_RUN_AWAY_SHOUT
	ENDIF

	IF NOT IS_CAR_DEAD van_jm3
		SET_TARGET_CAR_FOR_MISSION_GARAGE Garage_bank van_jm3
	ENDIF

	flag_car_blip_displayed_jm3 = TRUE

	garage_stop:

	TIMERB = 0

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D van_jm3 1440.7 -805.6 10.9 1449.8 -782.1 15.9 FALSE
OR NOT IS_PLAYER_IN_CAR player van_jm3
	WAIT 0

	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF
   
	IF IS_PLAYER_IN_CAR player van_jm3
		IF flag_car_blip_displayed_jm3 = TRUE
			ADD_BLIP_FOR_COORD 1445.8 -796.7 -100.0 blip2_jm3
			CHANGE_BLIP_DISPLAY blip2_jm3 BLIP_ONLY
			REMOVE_BLIP blip1_jm3
			PRINT_NOW ( jm3_1 ) 5000 1
		flag_car_blip_displayed_jm3 = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player van_jm3									
		IF flag_car_blip_displayed_jm3 = FALSE
		ADD_BLIP_FOR_CAR van_jm3 blip1_jm3
		REMOVE_BLIP blip2_jm3
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the Van!"
		flag_car_blip_displayed_jm3 = TRUE
		ENDIF
	ENDIF

	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

	IF NOT IS_CHAR_DEAD	van_man2_jm3
		IF TIMERB > 4000
			TIMERB = 0
			SET_CHAR_SAY van_man2_jm3 SOUND_SECURITY_GUARD_RUN_AWAY_SHOUT
		ENDIF
	ENDIF
		
	IF in_the_locate_joey3 = 0
		IF LOCATE_PLAYER_IN_CAR_3D player 1445.0 -811.5 11.8 4.0 6.0 4.0 TRUE
			CLEAR_WANTED_LEVEL player
			in_the_locate_joey3 = 1
		ENDIF
	ENDIF

	IF in_the_locate_joey3 = 1
		IF NOT IS_CAR_IN_AREA_3D van_jm3 1440.7 -805.6 10.9 1449.8 -782.1 15.9 FALSE
		AND NOT LOCATE_PLAYER_IN_CAR_3D player 1445.0 -811.5 11.8 4.0 6.0 4.0 FALSE
			in_the_locate_joey3 = 0
		ENDIF
	ENDIF

ENDWHILE


	PRINT_NOW ( OUT_VEH ) 5000 2 //Get out of the van

WHILE NOT IS_CAR_IN_MISSION_GARAGE Garage_bank
		
	IF IS_CAR_DEAD van_jm3
		PRINT_NOW ( WRECKED ) 5000 1
		GOTO mission_joey3_failed
	ENDIF
	 
	IF NOT IS_CAR_IN_AREA_3D van_jm3 1440.7 -805.6 10.9 1449.8 -782.1 15.9 FALSE
		GOTO garage_stop
	ENDIF 

	IF IS_CAR_UPSIDEDOWN van_jm3
	AND IS_CAR_STOPPED van_jm3
		GOTO mission_joey3_failed
	ENDIF

	WAIT 0
ENDWHILE


REMOVE_BLIP blip2_jm3

}

GOTO mission_joey3_passed


 // Mission joey3 failed

mission_joey3_failed:
PRINT_BIG ( m_fail ) 2000 1
RETURN

   

// mission joey3 passed

mission_joey3_passed:

flag_joey_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 20000
REGISTER_MISSION_PASSED	JM3
PLAYER_MADE_PROGRESS 1
CHANGE_GARAGE_TYPE_WITH_CAR_MODEL Garage_bank GARAGE_COLLECTSPECIFICCARS CAR_SECURICAR
START_NEW_SCRIPT joey_mission4_loop
START_NEW_SCRIPT diablo_phone_start
START_NEW_SCRIPT van_heist_garage_pager
RETURN
		


// mission cleanup

mission_cleanup_joey3:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
REMOVE_BLIP blip1_jm3
REMOVE_BLIP blip2_jm3
UNLOAD_SPECIAL_CHARACTER 2
SET_TARGET_CAR_FOR_MISSION_GARAGE Garage_bank -1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SECURICAR
CLEAR_ONSCREEN_COUNTER test_van_health_counter
MISSION_HAS_FINISHED
RETURN
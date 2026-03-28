MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// **************************************RC Destruction Derby*********************************
// ***************************************Diablo Demolition***********************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME RC4

// Mission start stuff

GOSUB mission_start_rc4

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_rc4_failed
ENDIF
GOSUB mission_cleanup_rc4

MISSION_END


// Variables for mission

/*
VAR_INT counter_RCDD rc_van
VAR_INT timer_RCDD
VAR_INT reward_RCDD

VAR_FLOAT cam_x cam_y cam_z
VAR_FLOAT rc_x rc_y rc_z
*/	
// ***************************************Mission Start*************************************


mission_start_rc4:

flag_player_on_mission = 1

IF flag_rc4_passed = 0
	REGISTER_MISSION_GIVEN
ENDIF
PRINT_BIG ( RC3 ) 15000 2

WAIT 0

counter_RCDD = 0
flag_buggy_help1_hm2 = 0
controlmode = 0
reward_RCDD = 0

cam_x = 370.0	
cam_y = -1316.0
cam_z =	29.0

rc_x = 373.0
rc_y = -1317.0
rc_z = 26.5

timer_RCDD = 120000

RESET_NUM_OF_MODELS_KILLED_BY_PLAYER

SET_POLICE_IGNORE_PLAYER player ON
SET_PLAYER_CONTROL player off
STORE_WANTED_LEVEL player wanted_4x4
CLEAR_WANTED_LEVEL player
STORE_CAR_PLAYER_IS_IN player rc_van
SWITCH_WIDESCREEN on 

//UP GANGCAR NUMBERS AND DENSITY

    SETUP_ZONE_CAR_INFO YAKUSA DAY   (20) (0 0 0) 270 0 0 0 10 300 200 200 0 0 0
    SETUP_ZONE_CAR_INFO YAKUSA NIGHT (15) (0 0 0) 290 0 0 0 10 300 200 200 0 0 0

SET_FIXED_CAMERA_POSITION cam_x cam_y cam_z 0.0 0.0 0.0
IF NOT IS_CAR_DEAD rc_van
	LOCK_CAR_DOORS rc_van CARLOCK_LOCKED
	POINT_CAMERA_AT_CAR rc_van FIXED JUMP_CUT 
	CLEAR_AREA rc_x rc_y rc_z 5.0 true
ENDIF

PRINT_NOW (RC_3) 4000 1 //You have 4 minutes to blow up as many Diablo Gang Cars as possible!

REQUEST_MODEL car_rcbandit
//REQUEST_MODEL car_yakuza

WHILE NOT HAS_MODEL_LOADED car_rcbandit
//OR NOT HAS_MODEL_LOADED car_yakuza
	WAIT 0
ENDWHILE


//GIVE_REMOTE_CONTROLLED_CAR_TO_PLAYER player rc_x rc_y rc_z 180.0
DISPLAY_ONSCREEN_COUNTER_WITH_STRING counter_RCDD COUNTER_DISPLAY_NUMBER KILLS
DISPLAY_ONSCREEN_TIMER timer_RCDD
GET_GAME_TIMER timer_intro_start

WHILE NOT timer_RCDD < 1

	WAIT 0
		
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
		
		IF IS_CAR_DEAD rc_van
			PRINT_NOW ( WRECKED ) 3000 1 //"The vehicle's wrecked!"
			GOTO mission_rc4_failed
		ENDIF
		
	IF IS_PLAYER_PLAYING player	
		CLEAR_WANTED_LEVEL player
		
		IF intro_time_lapsed > 4000
		AND	flag_buggy_help1_hm2 = 0
			GET_CONTROLLER_MODE controlmode

			IF controlmode = 0
				PRINT_HELP ( RCHELP ) //"Press |, or drive the RC car into a vehicle's wheels to detonate"
				flag_buggy_help1_hm2 = 1
			ENDIF

			IF controlmode = 1
				PRINT_HELP ( RCHELP ) //"Press |, or drive the RC car into a vehicle's wheels to detonate"
				flag_buggy_help1_hm2 = 1
			ENDIF

			IF controlmode = 2
				PRINT_HELP ( RCHELP ) //"Press |, or drive the RC car into a vehicle's wheels to detonate"
				flag_buggy_help1_hm2 = 1
			ENDIF

			IF controlmode = 3
				PRINT_HELP ( RCHELPA ) //"Press the R1 button, or drive the RC car into a vehicle's wheels to detonate"
				flag_buggy_help1_hm2 = 1
			ENDIF

			SWITCH_WIDESCREEN off
			SET_PLAYER_CONTROL player on
			RESTORE_CAMERA

		ENDIF

		IF NOT IS_PLAYER_SITTING_IN_CAR player rc_van
			GOTO mission_rc4_failed
		ENDIF
	ELSE
		GOTO mission_rc4_failed
	ENDIF
	
	GET_NUM_OF_MODELS_KILLED_BY_PLAYER car_yakuza counter_RCDD
		
	IF intro_time_lapsed > 4000
		IF NOT IS_PLAYER_IN_REMOTE_MODE player
			GIVE_REMOTE_CONTROLLED_CAR_TO_PLAYER player rc_x rc_y rc_z 60.0
		ENDIF
	ENDIF

ENDWHILE

CLEAR_ONSCREEN_TIMER timer_RCDD
CLEAR_ONSCREEN_COUNTER counter_RCDD

BLOW_UP_RC_BUGGY

{
TIMERA = 0
 
WHILE TIMERA < 1500
 
 WAIT 0
 
ENDWHILE
}

IF counter_RCDD > rec_rc4
	reward_RCDD = counter_RCDD - rec_rc4
	reward_RCDD = reward_RCDD * 1000
	rec_rc4 = counter_RCDD
	GOTO mission_rc4_passed
ENDIF

 

// Mission rc4 failed

mission_rc4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
PRINT_NOW ( NRECORD ) 5000 1

RETURN


   

// mission rc4 passed

mission_rc4_passed:


//reward_RCDD = counter_RCDD * 1000
PRINT_WITH_NUMBER_BIG ( M_PASS ) reward_RCDD 5000 1 //"Mission Passed!"
PRINT_NOW (RECORD) 3000 1
PLAY_MISSION_PASSED_TUNE 1 
ADD_SCORE player reward_RCDD
IF flag_rc4_passed = 0
	PLAYER_MADE_PROGRESS 1
	flag_rc4_passed = 1 
	REGISTER_MISSION_PASSED	RC3
ENDIF
REGISTER_HIGHEST_SCORE 3 rec_rc4

RETURN
		


// mission cleanup

mission_cleanup_rc4:

flag_player_on_mission = 0
flag_just_done_rc_mission = 1
LOAD_SCENE cam_x cam_y cam_z
MARK_MODEL_AS_NO_LONGER_NEEDED car_rcbandit
SET_POLICE_IGNORE_PLAYER player OFF
SET_PLAYER_CONTROL player ON
RESTORE_CAMERA
SWITCH_WIDESCREEN OFF
ALTER_WANTED_LEVEL player wanted_4x4

CLEAR_ONSCREEN_TIMER timer_RCDD
CLEAR_ONSCREEN_COUNTER counter_RCDD

BLOW_UP_RC_BUGGY

IF NOT IS_CAR_DEAD rc_van
	LOCK_CAR_DOORS rc_van CARLOCK_UNLOCKED
ENDIF

    SETUP_ZONE_CAR_INFO YAKUSA DAY   (20) (0 0 0) 100 0 0 0 20 350 200 250 0 0 0
    SETUP_ZONE_CAR_INFO YAKUSA NIGHT (15) (0 0 0) 150 0 0 0 10 350 200 200 0 0 0

//MARK_MODEL_AS_NO_LONGER_NEEDED car_yakuza

MISSION_HAS_FINISHED
RETURN
		

  
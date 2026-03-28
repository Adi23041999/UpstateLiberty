MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************HEALTH INFO*************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB health_info_start
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB health_info_cleanup
ENDIF
GOSUB health_info_cleanup
MISSION_END

// Variables for info script

VAR_INT amb_info medic_info	flag_bottom
VAR_INT health_pickup_info	armour_pickup_info
VAR_INT info_time_lapsed info_time_now info_time_start flag_info


// ****************************************Mission Start************************************

health_info_start:
//REGISTER_MISSION_GIVEN
SCRIPT_NAME health 
flag_player_on_mission = 1

WAIT 0

//Set Variables
info_time_lapsed =0
info_time_now = 0
info_time_start = 0
flag_info = 0
flag_bottom = 0
wanted_level = 0
flag_intro_jump = 0
//Set Coords


//Mission Script 
SET_PLAYER_CONTROL player off

STORE_WANTED_LEVEL player wanted_level
CLEAR_WANTED_LEVEL player
SET_POLICE_IGNORE_PLAYER player on
//SWITCH_WIDESCREEN on 
 
REQUEST_MODEL CAR_AMBULANCE
REQUEST_MODEL PED_MEDIC

WHILE NOT HAS_MODEL_LOADED CAR_AMBULANCE
OR NOT HAS_MODEL_LOADED PED_MEDIC
	WAIT 0
ENDWHILE		
		
SET_FIXED_CAMERA_POSITION 1138.6 -600.0 18.0 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION

WHILE flag_info < 8

	WAIT 0
	

	IF flag_info = 0
		GET_GAME_TIMER info_time_start
		/*SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_OUT
		WAIT 1500*/
		CLEAR_AREA 1141.0 -622.0 14.8 30.0 true
		CLEAR_AREA 1125.77 -594.0 14.8 10.0 true
		SET_CAR_DENSITY_MULTIPLIER 0.0
		SET_PED_DENSITY_MULTIPLIER 0.0
		CREATE_CAR CAR_AMBULANCE 1140.2 -621.5 14.8 amb_info
		SET_CAR_HEADING amb_info 90.0
		CREATE_CHAR PEDTYPE_CIVMALE PED_MEDIC 1136.75 -617.8 14.7 medic_info
		SET_CHAR_HEADING medic_info 25.0
		CHAR_SET_IDLE medic_info
		SET_CHAR_STAY_IN_SAME_PLACE	medic_info true
		//CAR_SET_IDLE amb_info 
		/*SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_IN
		WAIT 1500*/
		PRINT_HELP (HEAL_A)
		FLASH_HUD_OBJECT HUD_FLASH_HEALTH 
		flag_info = 1
	ENDIF
	
	IF flag_intro_jump = 0
		GET_GAME_TIMER info_time_now
		info_time_lapsed = info_time_now - info_time_start
	ENDIF
	
	IF info_time_lapsed > 3000
	AND flag_info < 2
		FLASH_HUD_OBJECT -1
	ENDIF 

	IF info_time_lapsed > 5000
	AND flag_info = 1
		PRINT_HELP (HEAL_B)
		flag_info = 2
	ENDIF

	IF info_time_lapsed > 11000
	AND flag_info = 2
		IF NOT IS_CAR_DEAD amb_info
		AND NOT IS_CHAR_DEAD medic_info
			SET_FIXED_CAMERA_POSITION 1133.0 -613.5 17.0 0.0 0.0 0.0
			POINT_CAMERA_AT_CAR amb_info FIXED JUMP_CUT
			SET_CHAR_STAY_IN_SAME_PLACE	medic_info false
			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER medic_info amb_info 
		ENDIF
		PRINT_HELP (HEAL_C)
		flag_info = 3
	ENDIF

	IF info_time_lapsed > 14000
	AND flag_info = 3
		PRINT_HELP (WANT_I)
		flag_info = 4
	ENDIF

	IF info_time_lapsed > 17500
	AND flag_info = 4
		flag_info = 5
	ENDIF
	
	IF info_time_lapsed > 19500
	AND flag_info = 5
		PRINT_HELP (HEAL_E)
		SET_FIXED_CAMERA_POSITION 1138.6 -600.0 18.0 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1144.3 -603.5 15.0 JUMP_CUT
		CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1144.3 -603.5 15.0 health_pickup_info
		IF NOT IS_CAR_DEAD amb_info
			CAR_WANDER_RANDOMLY amb_info
		ENDIF
		flag_info = 6
	ENDIF
	
	IF info_time_lapsed > 22500
	AND flag_info = 6
		POINT_CAMERA_AT_POINT 1147.0 -601.1 15.0 INTERPOLATION
		CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1147.0 -601.1 15.0 armour_pickup_info
		flag_info = 7
	ENDIF
	
	IF info_time_lapsed > 24000
	AND flag_info = 7
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_OUT
		CLEAR_HELP
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		DELETE_CAR amb_info
		DELETE_CHAR medic_info
		REMOVE_PICKUP health_pickup_info
		REMOVE_PICKUP armour_pickup_info
		RESTORE_CAMERA_JUMPCUT
		//SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player on
		ALTER_WANTED_LEVEL player wanted_level
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		flag_info = 8
	ENDIF
	
	IF info_time_lapsed > 16500
	AND flag_info < 7
		IF NOT IS_CAR_DEAD amb_info
		AND NOT IS_CHAR_DEAD medic_info
			IF IS_CHAR_IN_CAR medic_info amb_info
			AND flag_bottom = 0
				SET_CAR_CRUISE_SPEED amb_info 40.0
				SET_CAR_DRIVING_STYLE  amb_info 2
				SWITCH_CAR_SIREN amb_info ON
				CAR_GOTO_COORDINATES amb_info 1023.0 -480.0 19.7
				flag_bottom = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_intro_jump = 0
	AND flag_info < 7
		IF IS_BUTTON_PRESSED PAD1 CROSS
			info_time_lapsed = 24001
			flag_info = 7
			flag_intro_jump = 1
		ENDIF
	ENDIF

ENDWHILE

RETURN
		


// mission cleanup

health_info_cleanup:

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on
SET_POLICE_IGNORE_PLAYER player off

MARK_CAR_AS_NO_LONGER_NEEDED amb_info
MARK_CHAR_AS_NO_LONGER_NEEDED medic_info

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_AMBULANCE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_MEDIC

SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

//REMOVE_PICKUP heal_info
flag_player_on_mission = 0
flag_health_info = 1

MISSION_HAS_FINISHED
RETURN


//----main stuff-------
/*
//health info/wanted info
VAR_INT heal_info wanted_info flag_health_info flag_wanted_info

flag_health_info = 0
flag_wanted_info = 0

CREATE_PICKUP info PICKUP_ONCE 1144.2 -596.9 14.9 heal_info //hospital info cut
START_NEW_SCRIPT hospital_info_loop

hospital_info_loop:
{
WAIT 0

IF IS_PLAYER_PLAYING player
	IF IS_PLAYER_IN_ZONE player S_VIEW
		IF HAS_PICKUP_BEEN_COLLECTED heal_info
			LAUNCH_MISSION health.sc
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF
ENDIF

GOTO hospital_info_loop
} 
*/
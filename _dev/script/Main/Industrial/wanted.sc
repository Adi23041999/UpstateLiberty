MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************WANTED INFO*************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB wanted_info_start
GOSUB wanted_info_cleanup
MISSION_END

// Variables for info script

VAR_INT copcar_info copcar2_info swatvan_info cop_info cop2_info flag_copcar_progress
VAR_INT swat1_info swat2_info flag_swat_progress bribe_pickup
VAR_INT wanted_level diablocar_info diablo_info
//VAR_INT health_pickup_info	armour_pickup_info
//VAR_INT info_time_lapsed info_time_now info_time_start flag_info

VAR_FLOAT car_x car_y car_z

// ****************************************Mission Start************************************

wanted_info_start:
//REGISTER_MISSION_GIVEN
SCRIPT_NAME wanted 
flag_player_on_mission = 1


WAIT 0

//Set Variables
info_time_lapsed =0
info_time_now = 0
info_time_start = 0
flag_info = 0
flag_copcar_progress = 0
flag_swat_progress = 0
flag_intro_jump = 0
wanted_level = 0


//Set Coords


//Mission Script 

STORE_WANTED_LEVEL player wanted_level
//CLEAR_WANTED_LEVEL player
SET_POLICE_IGNORE_PLAYER player on 
SET_PLAYER_CONTROL player off
//SWITCH_WIDESCREEN on 

SWITCH_STREAMING OFF 

//SET_SWAT_REQUIRED TRUE
REQUEST_MODEL CAR_ENFORCER
//REQUEST_MODEL CAR_RUMPO
REQUEST_MODEL PED_SWAT
REQUEST_MODEL CAR_DIABLOS
REQUEST_MODEL PED_GANG_DIABLO_B

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_ENFORCER
	WAIT 0
	//PRINT_NOW TEST1 1000 1
ENDWHILE		
WHILE NOT HAS_MODEL_LOADED PED_SWAT
	WAIT 0
	//PRINT_NOW TEST2 1000 1
ENDWHILE

WHILE NOT HAS_MODEL_LOADED PED_GANG_DIABLO_B
	WAIT 0
	//PRINT_NOW TEST3 1000 1
ENDWHILE		
WHILE NOT HAS_MODEL_LOADED CAR_DIABLOS
	WAIT 0
	//PRINT_NOW TEST4 1000 1
ENDWHILE		

SWITCH_STREAMING ON

WHILE flag_info < 13

	WAIT 0
	

	IF flag_info = 0
		GET_GAME_TIMER info_time_start
		//SET_FIXED_CAMERA_POSITION 1135.0 -672.5 15.5 0.0 0.0 0.0
		//POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION
		/*SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_OUT
		WAIT 1500*/
		
		CREATE_CAR CAR_POLICE 1110.0 -823.0 15.0 copcar_info
		SET_CAR_HEADING copcar_info 330.0
		CREATE_CHAR_INSIDE_CAR copcar_info PEDTYPE_CIVMALE PED_COP cop_info
		//CAR_SET_IDLE copcar_info
		
		CREATE_CAR CAR_POLICE 1105.0 -828.0 15.0 copcar2_info
		SET_CAR_HEADING copcar2_info 330.0
		CREATE_CHAR_INSIDE_CAR copcar2_info PEDTYPE_CIVMALE PED_COP cop2_info
		//CAR_SET_IDLE copcar2_info

		CREATE_CAR CAR_DIABLOS 1115.0 -818.0 15.0 diablocar_info
		SET_CAR_HEADING diablocar_info 0.0
		CREATE_CHAR_INSIDE_CAR diablocar_info PEDTYPE_GANG_DIABLO PED_GANG_DIABLO_B diablo_info
		//CAR_SET_IDLE diablocar_info
		
		SET_CAR_DENSITY_MULTIPLIER 0.3
		SET_PED_DENSITY_MULTIPLIER 0.0
		/*SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_IN
		WAIT 1500*/
		PRINT_HELP (WANT_A) 
		flag_info = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER info_time_now
		info_time_lapsed = info_time_now - info_time_start
	ENDIF
	
	IF info_time_lapsed > 3500
	AND flag_info = 1
		PRINT_HELP (WANT_G)//When you are arrested you will be returned to the nearest police station and you will lose all your weapons
		IF NOT IS_CAR_DEAD copcar_info
		AND NOT IS_CAR_DEAD copcar2_info
		AND NOT IS_CAR_DEAD diablocar_info
			SET_CAR_CRUISE_SPEED copcar2_info 75.0
			SET_CAR_DRIVING_STYLE  copcar2_info 3
			SET_CAR_RAM_CAR copcar2_info diablocar_info
			
			SET_CAR_CRUISE_SPEED copcar_info 70.0
			SET_CAR_DRIVING_STYLE  copcar_info 3
			SET_CAR_RAM_CAR copcar_info diablocar_info
		ENDIF
			
		SET_FIXED_CAMERA_POSITION 1134.0 -695.0 18.0 0.0 0.0 0.0
		
		IF NOT IS_CAR_DEAD diablocar_info
			POINT_CAMERA_AT_CAR diablocar_info FIXED JUMP_CUT
		ENDIF
		
		IF NOT IS_CAR_DEAD diablocar_info
			SET_CAR_CRUISE_SPEED diablocar_info 50.0
			SET_CAR_DRIVING_STYLE  diablocar_info 2
			CAR_GOTO_COORDINATES diablocar_info 982.0 -617.0 15.0
			//GET_CAR_COORDINATES diablocar_info car_x car_y car_z
		ENDIF
		IF NOT IS_CAR_DEAD copcar_info
		AND NOT IS_CAR_DEAD copcar2_info
			SWITCH_CAR_SIREN copcar_info ON
			SWITCH_CAR_SIREN copcar2_info ON
		ENDIF
		flag_info = 2
	ENDIF
	
	IF info_time_lapsed > 5500
	AND flag_copcar_progress = 0
		
		CLEAR_AREA 1142.0 -666.0 14.8 10.0 true

		CREATE_CAR CAR_ENFORCER 1142.0 -666.0 14.8 swatvan_info
		//CREATE_CAR CAR_RUMPO 1142.0 -666.0 14.8 swatvan_info
		SET_CAR_HEADING swatvan_info 90.0
		LOCK_CAR_DOORS swatvan_info CARLOCK_UNLOCKED
		CAR_SET_IDLE swatvan_info
		CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 1138.0 -671.0 15.0 swat2_info
		CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 1137.8 -661.3 15.0 swat1_info
		GIVE_WEAPON_TO_CHAR swat1_info WEAPONTYPE_M16 60
		SET_CHAR_HEADING swat2_info 110.0
		SET_CHAR_HEADING swat1_info 80.0
		GIVE_WEAPON_TO_CHAR swat1_info WEAPONTYPE_SHOTGUN 10
		IF NOT IS_CHAR_DEAD	diablo_info
			CHAR_LOOK_AT_CHAR_ALWAYS swat1_info diablo_info
		ENDIF
		IF NOT IS_CHAR_DEAD cop_info
			CHAR_LOOK_AT_CHAR_ALWAYS swat2_info cop_info
		ENDIF 
		
		flag_copcar_progress = 1
	ENDIF

	IF info_time_lapsed > 7500
	AND flag_info = 2
		PRINT_HELP (WANT_H)//The cops will take some of your cash as a bribe
		flag_info = 3
	ENDIF

	IF info_time_lapsed > 10500
	AND flag_info = 3
		PRINT_HELP (WANT_I)//Any mission you were on will fail.
		flag_info = 4
	ENDIF
	
	IF info_time_lapsed > 12500
	AND flag_info = 4
		PRINT_HELP (WANT_B)//your wanted level is represented by the row of stars in the .....
		IF NOT IS_CAR_DEAD swatvan_info
			SET_FIXED_CAMERA_POSITION 1135.8 -673.0 14.8 0.0 0.0 0.0
			POINT_CAMERA_AT_CAR swatvan_info FIXED JUMP_CUT
			DELETE_CAR copcar_info
			DELETE_CAR copcar2_info
			DELETE_CAR diablocar_info
		ENDIF
		flag_info = 5
	ENDIF
	
	IF info_time_lapsed > 13500
	AND flag_info = 5
		IF NOT IS_CAR_DEAD swatvan_info
		AND NOT IS_CHAR_DEAD swat2_info
			STOP_CHAR_LOOKING swat2_info
			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER swat2_info swatvan_info
		ENDIF
		flag_info = 6
	ENDIF
	
	IF info_time_lapsed > 16000
	AND flag_info = 6
		PRINT_HELP (WANT_C)//You now have a wanted level of one....
		ALTER_WANTED_LEVEL player 1
		IF NOT IS_CAR_DEAD swatvan_info
		AND NOT IS_CHAR_DEAD swat1_info
			SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER swat1_info swatvan_info
		ENDIF
		flag_info = 7
	ENDIF
	
	
	IF info_time_lapsed > 18000
	AND flag_info = 7
		PRINT_HELP (WANT_D)//Two....
		ALTER_WANTED_LEVEL player 2
		flag_info = 8
	ENDIF
	
	
	IF info_time_lapsed > 20000
	AND flag_info = 8
		PRINT_HELP (WANT_E)//Three....
		ALTER_WANTED_LEVEL player 3
		flag_info = 9
	ENDIF
	

	IF info_time_lapsed > 22000
	AND flag_info = 9
		PRINT_HELP (WANT_F)//As your wanted level increases you will attract more powerful forms of law enforcement
		flag_info = 10
	ENDIF

	IF info_time_lapsed > 26000
	AND flag_info = 10
		SET_FIXED_CAMERA_POSITION 1135.0 -672.5 15.5 0.0 0.0 0.0
		POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT		
		PRINT_HELP (WANT_J)// You will find ways of reducing.......
		CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1143.0 -671.0 15.0 bribe_pickup
		POINT_CAMERA_AT_POINT 1143.0 -671.0 15.0 INTERPOLATION
		flag_info = 11
	ENDIF

	
	IF info_time_lapsed > 30000
	AND flag_info = 11
		flag_info = 12
	ENDIF
	
	IF info_time_lapsed > 34000
	AND flag_info = 12
		CLEAR_HELP
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		REMOVE_PICKUP bribe_pickup
		DELETE_CHAR diablo_info
		DELETE_CAR diablocar_info
		DELETE_CHAR cop_info
		DELETE_CAR copcar_info
		DELETE_CHAR cop2_info
		DELETE_CAR copcar2_info
		DELETE_CHAR swat1_info
		DELETE_CHAR swat2_info
		DELETE_CAR swatvan_info
		//REMOVE_PICKUP armour_pickup_info
		RESTORE_CAMERA_JUMPCUT
		//SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player on
		ALTER_WANTED_LEVEL player wanted_level
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1500 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		flag_info = 13
	ENDIF
	/*
	IF NOT IS_CAR_DEAD copcar_info
		IF LOCATE_CAR_2D copcar_info 1132.0 -671.4 4.0 4.0 false 
		AND flag_copcar_progress = 0
			CAR_GOTO_COORDINATES_ACCURATE copcar_info 1124.0 -505.0 19.7
			SET_CAR_CRUISE_SPEED copcar_info 18.0
			SET_CAR_DRIVING_STYLE  copcar_info 2
			SWITCH_CAR_SIREN copcar_info ON
			flag_copcar_progress = 1
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD copcar_info
	AND flag_copcar_progress = 1
		CAR_GOTO_COORDINATES copcar_info car_x car_y car_z
	ENDIF
	*/
	IF NOT IS_CAR_DEAD swatvan_info
	AND NOT IS_CHAR_DEAD swat1_info
	AND NOT IS_CHAR_DEAD swat2_info
		IF flag_swat_progress = 0
		AND info_time_lapsed > 21000
			IF IS_CHAR_IN_CAR swat1_info swatvan_info
			AND IS_CHAR_IN_CAR swat2_info swatvan_info
				SET_CAR_CRUISE_SPEED swatvan_info 10.0
				SET_CAR_DRIVING_STYLE  swatvan_info 2
				CAR_GOTO_COORDINATES_ACCURATE swatvan_info 1133.0 -669.0 15.0
				flag_swat_progress = 1
			ENDIF
		ENDIF
	ENDIF
				
	IF NOT IS_CAR_DEAD swatvan_info
		IF LOCATE_CAR_2D swatvan_info 1133.0 -669.0 3.0 3.0 false 
		AND	flag_swat_progress = 1
		AND info_time_lapsed > 22000
			CAR_GOTO_COORDINATES swatvan_info 982.0 -617.0 15.0
			SET_CAR_CRUISE_SPEED swatvan_info 30.0
			SET_CAR_DRIVING_STYLE  swatvan_info 3
			SWITCH_CAR_SIREN swatvan_info ON
			flag_swat_progress = 2
		ENDIF
	ENDIF
				
	IF flag_intro_jump = 0
	AND flag_info < 12
		IF IS_BUTTON_PRESSED PAD1 CROSS
			info_time_lapsed = 34001
			flag_info = 12
			flag_intro_jump = 1
		ENDIF
	ENDIF

ENDWHILE

RETURN
		


// mission cleanup

wanted_info_cleanup:

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player on
SET_POLICE_IGNORE_PLAYER player off

IF NOT IS_CAR_DEAD swatvan_info
	CAR_WANDER_RANDOMLY swatvan_info
ENDIF
IF NOT IS_CAR_DEAD copcar_info
	CAR_WANDER_RANDOMLY copcar_info
ENDIF
IF NOT IS_CAR_DEAD diablocar_info
	CAR_WANDER_RANDOMLY diablocar_info
ENDIF

SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

MARK_CAR_AS_NO_LONGER_NEEDED swatvan_info
MARK_CAR_AS_NO_LONGER_NEEDED copcar_info
MARK_CAR_AS_NO_LONGER_NEEDED diablocar_info
MARK_CHAR_AS_NO_LONGER_NEEDED cop_info
MARK_CHAR_AS_NO_LONGER_NEEDED swat1_info
MARK_CHAR_AS_NO_LONGER_NEEDED swat2_info
MARK_CHAR_AS_NO_LONGER_NEEDED diablo_info


MARK_MODEL_AS_NO_LONGER_NEEDED PED_COP
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_SWAT
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_DIABLOS
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ENFORCER
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_POLICE
SET_SWAT_REQUIRED FALSE
//REMOVE_PICKUP heal_info
flag_player_on_mission = 0
flag_wanted_info = 1

MISSION_HAS_FINISHED
RETURN


//----main stuff-------
/*

CREATE_PICKUP info PICKUP_ONCE 1143.9 -675.2 15.0 wanted_info //police info cut
START_NEW_SCRIPT police_info_loop

police_info_loop:
{
WAIT 0

IF IS_PLAYER_PLAYING player
	IF IS_PLAYER_IN_ZONE player S_VIEW
		IF HAS_PICKUP_BEEN_COLLECTED wanted_info
			LAUNCH_MISSION wanted.sc
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDIF
ENDIF

GOTO hospital_info_loop 
*/
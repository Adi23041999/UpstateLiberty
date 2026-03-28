MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *********************************** Cop Car Mission ************************************* 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_cop_car

GOSUB cop_car_failed

MISSION_END
 
// Variables for mission

VAR_INT	got_range_message	player_in_range	car_model criminal_car	range_int mission_end_button total_criminals_killed players_cop_car_health
VAR_INT criminal_created_flag criminal criminal_blip random_gun	cop_time_limit got_car_crim_is_in timer_reset_flag vigilante_bonus_kills location got_cop_breif
VAR_INT game_time_flag game_timer_start	copcar_timer game_time_present game_time_difference	timer_in_secs players_cop_car vigilante	vigilante_score copcar_cancelled_flag

VAR_FLOAT player_c_x player_c_y	player_c_z random_crim_x random_crim_y criminal_coord_x criminal_coord_y criminal_coord_z 
VAR_FLOAT diff_x_float diff_y_float sum_of_diff_xy players_distance_from_criminal cop_time_limit_float criminal_heading	warp_heading_cop

// ****************************************Mission Start************************************

mission_start_cop_car:

flag_player_on_mission 		= 1
flag_player_on_cop_mission 	= 1
vigilante_bonus_kills = 5

SCRIPT_NAME copcar

total_criminals_killed = 0
got_cop_breif 		  = 0

WAIT 0

next_cop_car:

got_range_message 	  = 0
player_in_range 	  = 0
car_model 			  = 0
criminal_car 		  = 0
criminal_created_flag = 0
criminal 			  = 0
criminal_blip 		  = 0
random_gun 			  = 0
cop_time_limit 		  = 0
got_car_crim_is_in 	  = 0
timer_reset_flag 	  = 0
game_time_flag		  = 0
mission_end_button	  = 0
location			  = 0
copcar_cancelled_flag = 0

player_c_x 		 = 0.0 
player_c_y 		 = 0.0	
player_c_z 		 = 0.0 
random_crim_x 	 = 0.0 
random_crim_y 	 = 0.0 
criminal_coord_x = 0.0 
criminal_coord_y = 0.0 
criminal_coord_z = 0.0
diff_x_float 	 = 0.0 
diff_y_float 	 = 0.0 
sum_of_diff_xy 	 = 0.0 
players_distance_from_criminal = 0.0 
cop_time_limit_float = 0.0 
criminal_heading 	 = 0.0

GET_PLAYER_COORDINATES player player_c_x player_c_y player_c_z
REQUEST_MODEL CAR_SENTINEL
{
criminal_in_car://////////////////////////////////////////////////////////////////////////////////////////////////////

WAIT 0

IF got_cop_breif = 0
	PRINT_NOW LEGAL 3000 1
	TIMERB = 0
	got_cop_breif = 1
ELSE
	TIMERB = 3000
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE 778.0 1540.0 random_crim_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1110.0 190.0 random_crim_y
	got_range_message = 0
	player_in_range = 1
	location = 1
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE -192.0 545.0 random_crim_x  
	GENERATE_RANDOM_FLOAT_IN_RANGE -1626.0 98.0 random_crim_y
	got_range_message = 0
	player_in_range = 1
	location = 2
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	GENERATE_RANDOM_FLOAT_IN_RANGE -1300.0 -414.0 random_crim_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -608.8 380.0 random_crim_y
	got_range_message = 0
	player_in_range = 1
	location = 3
ENDIF

IF player_in_range = 0
	IF got_range_message = 0
		PRINT_NOW C_RANGE 5000 1 //"The radio is out of range, get closer to a police station!"
		got_range_message = 1
	ENDIF
	GOTO cop_car_failed
ENDIF													  

GOSUB copcar_cancelled_checks
IF copcar_cancelled_flag = 1
	GOTO cop_car_failed
ENDIF

GET_CLOSEST_CAR_NODE random_crim_x random_crim_y player_c_z criminal_coord_x criminal_coord_y criminal_coord_z

IF criminal_coord_x 	> 1398.0 //MIN_X // COLOMBIAN BOAT
AND criminal_coord_x	< 1615.0 //MAX_X
AND criminal_coord_y	> -965.0 //MIN_Y
AND criminal_coord_y	< -902.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 879.0	 //MIN_X // BACK OF LUIGI'S
AND criminal_coord_x	< 892.0  //MAX_X
AND criminal_coord_y	> -427.0 //MIN_Y
AND criminal_coord_y	< -407.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 944.8	  //MIN_X // FISH FACTORY
AND criminal_coord_x	< 1017.1  //MAX_X
AND criminal_coord_y	> -1148.8 //MIN_Y
AND criminal_coord_y	< -1076.6 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 920.8	 //MIN_X // CHINATOWN MARKET
AND criminal_coord_x	< 1004.0 //MAX_X
AND criminal_coord_y	> -754.2 //MIN_Y
AND criminal_coord_y	< -670.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 670.0	 //MIN_X // CALAHAN BRIDGE
AND criminal_coord_x	< 1035.0 //MAX_X
AND criminal_coord_y	> -953.0 //MIN_Y
AND criminal_coord_y	< -912.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 1364.0  //MIN_X // DOCKS INDUSTRIAL
AND criminal_coord_x	< 1641.0  //MAX_X
AND criminal_coord_y	> -1165.0 //MIN_Y
AND criminal_coord_y	< -617.0  //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 649.0	 //MIN_X // TUNNEL ENTRANCE INDUSTRIAL
AND criminal_coord_x	< 1066.0 //MAX_X
AND criminal_coord_y	> 25.0   //MIN_Y
AND criminal_coord_y	< 217.0  //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> -1611.5 //MIN_X // AIRPORT SUBURBAN
AND criminal_coord_x	< -745.3  //MAX_X
AND criminal_coord_y	> -1001.9 //MIN_Y
AND criminal_coord_y	< -371.2  //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 939.8  //MIN_X // OLD SCHOOL HALL AND PARK AREA
AND criminal_coord_x	< 1035.6 //MAX_X
AND criminal_coord_y	> -901.3 //MIN_Y
AND criminal_coord_y	< -828.2 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 1215.3 //MIN_X // DOG FOOD FACTORY
AND criminal_coord_x	< 1223.7 //MAX_X
AND criminal_coord_y	> -839.4 //MIN_Y
AND criminal_coord_y	< -763.6 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 845.3  //MIN_X // INDUSTRIAL SAFEHOUSE
AND criminal_coord_x	< 899.6  //MAX_X
AND criminal_coord_y	> -312.6 //MIN_Y
AND criminal_coord_y	< -295.7 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 113.3   //MIN_X // DOJO COMMERCIAL
AND criminal_coord_x	< 99.7    //MAX_X
AND criminal_coord_y	> -1284.8 //MIN_Y
AND criminal_coord_y	< -1273.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 18.33   //MIN_X // COLOMBIAN OJG COMPOUND
AND criminal_coord_x	< 92.06   //MAX_X
AND criminal_coord_y	> -388.7  //MIN_Y
AND criminal_coord_y	< -312.38 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> -1255.4 //MIN_X // BAIT WAREHOUSE CARPARK SUBURBIA
AND criminal_coord_x	< -1187.9 //MAX_X
AND criminal_coord_y	> 80.6    //MIN_Y
AND criminal_coord_y	< 123.4   //MAX_Y
	GOTO criminal_in_car
ENDIF

IF criminal_coord_x 	> 1386.4 //MIN_X // FRANKIES HOUSE
AND criminal_coord_x	< 1475.8 //MAX_X
AND criminal_coord_y	> -292.1 //MIN_Y
AND criminal_coord_y	< -168.0 //MAX_Y
	GOTO criminal_in_car
ENDIF

IF location = 1
	IF NOT criminal_coord_x > 778.0 //MIN_X // INDUSTRIAL
	OR NOT criminal_coord_x	< 1540.0 //MAX_X
	OR NOT criminal_coord_y	> -1110.0 //MIN_Y
	OR NOT criminal_coord_y	< 190.0 //MAX_Y
		GOTO criminal_in_car
	ENDIF
ENDIF

IF location = 2
	IF NOT criminal_coord_x > -192.0 //MIN_X // COMMERCIAL
	OR NOT criminal_coord_x	< 545.0 //MAX_X
	OR NOT criminal_coord_y	> -1626.0 //MIN_Y
	OR NOT criminal_coord_y	< 98.0 //MAX_Y
		GOTO criminal_in_car
	ENDIF
ENDIF

IF location = 3
	IF NOT criminal_coord_x > -1300.0 //MIN_X // SUBURBIA
	OR NOT criminal_coord_x	< -414.0 //MAX_X
	OR NOT criminal_coord_y	> -608.8 //MIN_Y
	OR NOT criminal_coord_y	< 380.0 //MAX_Y
		GOTO criminal_in_car
	ENDIF
ENDIF

IF criminal_coord_z < -1.0
	GOTO criminal_in_car
ENDIF

diff_x_float = player_c_x - criminal_coord_x
diff_y_float = player_c_y - criminal_coord_y
diff_x_float = diff_x_float * diff_x_float
diff_y_float = diff_y_float * diff_y_float
sum_of_diff_xy = diff_x_float + diff_y_float
SQRT sum_of_diff_xy players_distance_from_criminal

IF players_distance_from_criminal < 150.0
	GOTO criminal_in_car
ENDIF

cop_time_limit_float = players_distance_from_criminal / 4.0
cop_time_limit_float = cop_time_limit_float * 1000.0
cop_time_limit =# cop_time_limit_float

IF cop_time_limit < 120000
	cop_time_limit = 120000
ENDIF

generate_car_model:

GENERATE_RANDOM_INT_IN_RANGE 90 140 car_model

IF car_model > 113  // CAR_BUGGY CAR_CORPSE CAR_POLICE CAR_ENFORCER CAR_SECURICAR CAR_BANSHEE BOAT_PREDATOR CAR_BUS	
AND car_model < 128 // CAR_RHINO CAR_BARRACKS TRAIN_SUBWAY HELI_POLICE PLANE_DODO CAR_COACH
	GOTO generate_car_model
ENDIF

IF car_model = 97	// CAR_FIRETRUCK
	GOTO generate_car_model
ENDIF

IF car_model = 106	// CAR_AMBULANCE
OR car_model = 107	// CAR_FBI
OR car_model = 131	// CAR_RCBANDIT
OR car_model = 140	// PLANE_AIRTRAIN
	GOTO generate_car_model
ENDIF

REQUEST_MODEL car_model

WHILE NOT HAS_MODEL_LOADED car_model
	WAIT 0

	GOSUB copcar_cancelled_checks
	IF copcar_cancelled_flag = 1
		GOTO cop_car_failed
	ENDIF

ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 criminal_heading

WHILE NOT TIMERB > 3000
	WAIT 0
	
	GOSUB copcar_cancelled_checks
	IF copcar_cancelled_flag = 1
		GOTO cop_car_failed
	ENDIF

ENDWHILE

CREATE_CAR car_model criminal_coord_x criminal_coord_y criminal_coord_z criminal_car
SET_CAR_AVOID_LEVEL_TRANSITIONS criminal_car TRUE
SET_CAR_HEALTH criminal_car 800
MARK_MODEL_AS_NO_LONGER_NEEDED car_model
SET_CAR_HEADING criminal_car criminal_heading

GET_CLOSEST_CHAR_NODE criminal_coord_x criminal_coord_y criminal_coord_z criminal_coord_x criminal_coord_y criminal_coord_z
CREATE_RANDOM_CHAR criminal_coord_x criminal_coord_y criminal_coord_z criminal
SET_CHAR_IS_CHRIS_CRIMINAL criminal TRUE
//SET_CHAR_AVOID_LEVEL_TRANSITIONS criminal TRUE
WARP_CHAR_INTO_CAR criminal criminal_car
SET_CHAR_RUNNING criminal TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER criminal TRUE

CLEAR_CHAR_THREAT_SEARCH criminal

SET_CHAR_PERSONALITY criminal PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH criminal THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH criminal THREAT_PLAYER2
SET_CHAR_THREAT_SEARCH criminal THREAT_PLAYER3
SET_CHAR_THREAT_SEARCH criminal THREAT_PLAYER4
SET_CHAR_THREAT_SEARCH criminal THREAT_CIVMALE
SET_CHAR_THREAT_SEARCH criminal THREAT_CIVFEMALE
SET_CHAR_THREAT_SEARCH criminal THREAT_COP	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_MAFIA	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_DIABLO	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_TRIAD	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_YARDIE	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_COLOMBIAN	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_HOOD	
SET_CHAR_THREAT_SEARCH criminal THREAT_GANG_YAKUZA	
SET_CHAR_THREAT_SEARCH criminal THREAT_EMERGENCY
SET_CHAR_THREAT_SEARCH criminal THREAT_PROSTITUTE
SET_CHAR_THREAT_SEARCH criminal THREAT_CRIMINAL
SET_CHAR_THREAT_SEARCH criminal THREAT_GUN	
SET_CHAR_THREAT_SEARCH criminal THREAT_COP_CAR
SET_CHAR_THREAT_SEARCH criminal THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH criminal THREAT_FIREMAN

SET_CHAR_HEED_THREATS criminal TRUE

MARK_CAR_AS_NO_LONGER_NEEDED criminal_car  

IF flag_industrial_passed = 0
	GENERATE_RANDOM_INT_IN_RANGE 0 5 random_gun
ENDIF

IF flag_industrial_passed = 1
	GENERATE_RANDOM_INT_IN_RANGE 2 6 random_gun
ENDIF

IF flag_commercial_passed = 1
	GENERATE_RANDOM_INT_IN_RANGE 3 10 random_gun
ENDIF

GIVE_WEAPON_TO_CHAR criminal random_gun 1000

ADD_BLIP_FOR_CHAR criminal criminal_blip

CLEAR_HELP

IF got_siren_help_before = 0
	GET_CONTROLLER_MODE	controlmode
	IF controlmode = 0
		PRINT_HELP SIREN_1 //"To turn on this vehicles sirens tap the ~h~L1 button~w~."
	ENDIF
	IF controlmode = 1
		PRINT_HELP SIREN_2 //"To turn on this vehicles sirens tap the ~h~L1 button~w~."
	ENDIF
	IF controlmode = 2
		PRINT_HELP SIREN_3 //"To turn on this vehicles sirens tap the ~h~R1 button~w~."
	ENDIF
	IF controlmode = 3
		PRINT_HELP SIREN_4 //"To turn on this vehicles sirens tap the ~h~L3 button~w~."
	ENDIF
	got_siren_help_before = 1
ENDIF

IF IS_CHAR_IN_ZONE criminal PORT_W
	PRINT_STRING_IN_STRING_NOW C_BREIF PORT_W 5000 1 // The suspect is in the Callahan Point area.
ENDIF

IF IS_CHAR_IN_ZONE criminal PORT_S
	PRINT_STRING_IN_STRING_NOW C_BREIF PORT_S 5000 1 // The suspect is in the Atlantic Quays area.
ENDIF

IF IS_CHAR_IN_ZONE criminal PORT_E
	PRINT_STRING_IN_STRING_NOW C_BREIF PORT_E 5000 1 // The suspect is in the Portland Harbour area.
ENDIF

IF IS_CHAR_IN_ZONE criminal PORT_I
	PRINT_STRING_IN_STRING_NOW C_BREIF PORT_I 5000 1 // The suspect is in the Trenton area.
ENDIF

IF IS_CHAR_IN_ZONE criminal S_VIEW
	PRINT_STRING_IN_STRING_NOW C_BREIF S_VIEW 5000 1 // The suspect is in the Portland View area.
ENDIF

IF IS_CHAR_IN_ZONE criminal CHINA
	PRINT_STRING_IN_STRING_NOW C_BREIF CHINA 5000 1 // The criminal is proceeding south in Chinatown
ENDIF

IF IS_CHAR_IN_ZONE criminal EASTBAY
	PRINT_STRING_IN_STRING_NOW C_BREIF EASTBAY 5000 1 // The criminal is proceeding south in Portland Beach
ENDIF

IF IS_CHAR_IN_ZONE criminal LITTLEI
	PRINT_STRING_IN_STRING_NOW C_BREIF LITTLEI 5000 1 // The criminal is proceeding south in Saint Mark's
ENDIF

IF IS_CHAR_IN_ZONE criminal REDLIGH
	PRINT_STRING_IN_STRING_NOW C_BREIF REDLIGH 5000 1 // The criminal is proceeding south in Red Light District
ENDIF

IF IS_CHAR_IN_ZONE criminal TOWERS
	PRINT_STRING_IN_STRING_NOW C_BREIF TOWERS 5000 1 // The criminal is proceeding south in Hepburn Heights
ENDIF

IF IS_CHAR_IN_ZONE criminal HARWOOD
	PRINT_STRING_IN_STRING_NOW C_BREIF HARWOOD 5000 1 // The criminal is proceeding south in Harwood
ENDIF

IF IS_CHAR_IN_ZONE criminal ROADBR1
	PRINT_STRING_IN_STRING_NOW C_BREIF ROADBR1 5000 1 // The criminal is proceeding south in Callahan Bridge
ENDIF

IF IS_CHAR_IN_ZONE criminal ROADBR2
	PRINT_STRING_IN_STRING_NOW C_BREIF ROADBR2 5000 1 // The criminal is proceeding south in Callahan Bridge
ENDIF

//IF IS_CHAR_IN_ZONE criminal TUNNELP
//	PRINT_STRING_IN_STRING_NOW C_BREIF TUNNELP 5000 1 // The criminal is proceeding south in Porter Tunnel
//ENDIF

IF IS_CHAR_IN_ZONE criminal STADIUM
	PRINT_STRING_IN_STRING_NOW C_BREIF STADIUM 5000 1 // The criminal is proceeding south in Aspatria
ENDIF

IF IS_CHAR_IN_ZONE criminal HOSPI_2
	PRINT_STRING_IN_STRING_NOW C_BREIF HOSPI_2 5000 1 // The criminal is proceeding south in Rockford
ENDIF

IF IS_CHAR_IN_ZONE criminal UNIVERS
	PRINT_STRING_IN_STRING_NOW C_BREIF UNIVERS 5000 1 // The criminal is proceeding south in Liberty Campus
ENDIF

IF IS_CHAR_IN_ZONE criminal CONSTRU
	PRINT_STRING_IN_STRING_NOW C_BREIF CONSTRU 5000 1 // The criminal is proceeding south in Fort Staunton
ENDIF

IF IS_CHAR_IN_ZONE criminal PARK
	PRINT_STRING_IN_STRING_NOW C_BREIF PARK 5000 1 // The criminal is proceeding south in Belleville Park
ENDIF

IF IS_CHAR_IN_ZONE criminal COM_EAS
	PRINT_STRING_IN_STRING_NOW C_BREIF COM_EAS 5000 1 // The criminal is proceeding south in Newport
ENDIF

IF IS_CHAR_IN_ZONE criminal SHOPING
	PRINT_STRING_IN_STRING_NOW C_BREIF SHOPING 5000 1 // The criminal is proceeding south in Bedford Point
ENDIF

IF IS_CHAR_IN_ZONE criminal YAKUSA
	PRINT_STRING_IN_STRING_NOW C_BREIF YAKUSA 5000 1 // The criminal is proceeding south in Torrington
ENDIF

IF IS_CHAR_IN_ZONE criminal AIRPORT
	PRINT_STRING_IN_STRING_NOW C_BREIF AIRPORT 5000 1 // The criminal is proceeding south in Francis International Airport
ENDIF

IF IS_CHAR_IN_ZONE criminal PROJECT
	PRINT_STRING_IN_STRING_NOW C_BREIF PROJECT 5000 1 // The criminal is proceeding south in Wichita Gardens
ENDIF

IF IS_CHAR_IN_ZONE criminal SUB_IND
	PRINT_STRING_IN_STRING_NOW C_BREIF SUB_IND 5000 1 // The criminal is proceeding south in Pike Creek
ENDIF

IF IS_CHAR_IN_ZONE criminal SWANKS
	PRINT_STRING_IN_STRING_NOW C_BREIF SWANKS 5000 1 // The criminal is proceeding south in Cedar Grove
ENDIF

IF IS_CHAR_IN_ZONE criminal BIG_DAM
	PRINT_STRING_IN_STRING_NOW C_BREIF BIG_DAM 5000 1 // The criminal is proceeding south in Cochrane Dam
ENDIF

GET_CHAR_COORDINATES criminal criminal_coord_x criminal_coord_y criminal_coord_z
POLICE_RADIO_MESSAGE criminal_coord_x criminal_coord_y criminal_coord_z

TIMERB = 0

DISPLAY_ONSCREEN_TIMER cop_time_limit

WHILE NOT IS_CHAR_DEAD criminal

	IF cop_time_limit < 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 100.0 100.0 0
			REMOVE_BLIP	criminal_blip
			DELETE_CHAR	criminal
			criminal_created_flag = 0
			PRINT_NOW C_ESCP 3000 1//"The suspect has escaped!"
		ELSE
			PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
		ENDIF
		GOTO cop_car_failed
	ENDIF

	GOSUB copcar_cancelled_checks
	IF copcar_cancelled_flag = 1
		GOTO cop_car_failed
	ENDIF

	IF got_car_crim_is_in = 0
		IF NOT IS_CHAR_HEALTH_GREATER criminal 70
			SET_CHAR_OBJ_STEAL_ANY_CAR criminal
		ENDIF
	ENDIF
		
	IF IS_CHAR_IN_ANY_CAR criminal
	AND got_car_crim_is_in = 0
		MARK_CAR_AS_NO_LONGER_NEEDED criminal_car
		STORE_CAR_CHAR_IS_IN criminal criminal_car
		SET_UPSIDEDOWN_CAR_NOT_DAMAGED criminal_car TRUE
		SET_CAR_DRIVING_STYLE criminal_car 2
		SET_CAR_CRUISE_SPEED criminal_car 42.0
		CAR_WANDER_RANDOMLY criminal_car
		SET_CAR_AVOID_LEVEL_TRANSITIONS criminal_car TRUE
		got_car_crim_is_in = 1
	ENDIF
		
	IF got_car_crim_is_in = 1
		IF NOT IS_CHAR_IN_ANY_CAR criminal
			GENERATE_RANDOM_INT_IN_RANGE 0 5 range_int
			IF range_int = 0
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE criminal player
			ENDIF
			IF range_int = 1
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 150.0 150.0 0
					SET_CHAR_OBJ_STEAL_ANY_CAR criminal
				ELSE
					IF HAS_MODEL_LOADED CAR_SENTINEL
						GET_CHAR_COORDINATES criminal criminal_coord_x criminal_coord_y criminal_coord_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING criminal_coord_x criminal_coord_y criminal_coord_z criminal_coord_x criminal_coord_y criminal_coord_z warp_heading_cop
						MARK_CAR_AS_NO_LONGER_NEEDED criminal_car
						CREATE_CAR CAR_SENTINEL	criminal_coord_x criminal_coord_y criminal_coord_z criminal_car
						SET_CAR_HEADING	criminal_car warp_heading_cop
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal criminal_car
					ELSE
						SET_CHAR_OBJ_STEAL_ANY_CAR criminal
					ENDIF
				ENDIF
			ENDIF
			IF range_int = 2
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal player
			ENDIF
			IF range_int = 3
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_cop_car
					SET_CHAR_OBJ_DESTROY_CAR criminal players_cop_car
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal player
				ENDIF
			ENDIF
			IF range_int = 4
				GENERATE_RANDOM_INT_IN_RANGE 0 8 range_int
				CHAR_WANDER_DIR criminal -1//range_int//
			ENDIF
			got_car_crim_is_in = 0
		ENDIF
	ENDIF
	
	IF got_car_crim_is_in = 1

		IF NOT IS_CAR_DEAD criminal_car

			IF TIMERB > 1000
				TIMERB = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 20.0 20.0 0
					SET_CAR_CRUISE_SPEED criminal_car 46.0
				ELSE
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 50.0 50.0 0
						SET_CAR_CRUISE_SPEED criminal_car 39.0
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 90.0 90.0 0
							SET_CAR_CRUISE_SPEED criminal_car 32.0
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 130.0 130.0 0
								SET_CAR_CRUISE_SPEED criminal_car 26.0
							ELSE
								SET_CAR_CRUISE_SPEED criminal_car 18.0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		
			IF IS_CAR_STOPPED criminal_car
				IF timer_reset_flag = 0
					TIMERA = 0
					timer_reset_flag = 1
				ENDIF

				IF TIMERA > 8000
				AND timer_reset_flag = 1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 90.0 90.0 0
						SET_CHAR_OBJ_LEAVE_CAR criminal criminal_car
						timer_reset_flag = 0
					ELSE
						IF NOT IS_CAR_ON_SCREEN criminal_car
							GET_CAR_COORDINATES criminal_car criminal_coord_x criminal_coord_y criminal_coord_z
							GET_CLOSEST_CAR_NODE_WITH_HEADING criminal_coord_x criminal_coord_y criminal_coord_z criminal_coord_x criminal_coord_y criminal_coord_z warp_heading_cop
							IF NOT IS_POINT_ON_SCREEN criminal_coord_x criminal_coord_y criminal_coord_z 4.0
								SET_CAR_COORDINATES criminal_car criminal_coord_x criminal_coord_y criminal_coord_z
								SET_CAR_HEADING	criminal_car warp_heading_cop
								timer_reset_flag = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
					
			IF IS_CAR_UPSIDEDOWN criminal_car
			AND IS_CAR_STOPPED criminal_car
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player criminal 90.0 90.0 0
					SET_CHAR_OBJ_LEAVE_CAR criminal criminal_car
					SET_UPSIDEDOWN_CAR_NOT_DAMAGED criminal_car FALSE
				ELSE
					IF NOT IS_CAR_ON_SCREEN criminal_car
						GET_CAR_COORDINATES criminal_car criminal_coord_x criminal_coord_y criminal_coord_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING criminal_coord_x criminal_coord_y criminal_coord_z criminal_coord_x criminal_coord_y criminal_coord_z warp_heading_cop
						IF NOT IS_POINT_ON_SCREEN criminal_coord_x criminal_coord_y criminal_coord_z 4.0
							SET_CAR_COORDINATES criminal_car criminal_coord_x criminal_coord_y criminal_coord_z
							SET_CAR_HEADING	criminal_car warp_heading_cop
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER criminal_car 250
				SET_CHAR_OBJ_LEAVE_CAR criminal criminal_car
			ENDIF
		
		ENDIF

	ENDIF

	WAIT 0

ENDWHILE
}

MARK_CHAR_AS_NO_LONGER_NEEDED criminal
MARK_CAR_AS_NO_LONGER_NEEDED criminal_car

++ total_criminals_killed
REGISTER_CRIMINAL_CAUGHT
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
IF total_criminals_killed = 1
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
ENDIF

REMOVE_BLIP criminal_blip
vigilante_score	= total_criminals_killed * 500
PRINT_BIG C_PASS 5000 5
PRINT_WITH_NUMBER_BIG REWARD vigilante_score 5000 6
ADD_SCORE player vigilante_score

IF total_criminals_killed = vigilante_bonus_kills
	vigilante = total_criminals_killed * 2
	vigilante *= 500
	PRINT_BIG_Q C_VIGIL 5000 5
	PRINT_WITH_NUMBER_BIG_Q REWARD vigilante 6000 6
	ADD_SCORE player vigilante
	//FLASH_HUD_OBJECT OnscreenCounter
	IF vigilante_bonus_kills = 10
		//ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Get out of jail free!"
		SET_GET_OUT_OF_JAIL_FREE player TRUE
	ENDIF
	vigilante_bonus_kills += 5
ENDIF

IF location = 1
	++ ind_copcar_kills
ENDIF

IF location = 2
	++ com_copcar_kills
ENDIF

IF location = 3
	++ sub_copcar_kills
ENDIF

IF play_pager_message1 = 0
	IF ind_copcar_kills = 10
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message1 = 1
	ENDIF
ENDIF

IF play_pager_message1 = 1
	IF ind_copcar_kills = 20
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message1 = 2
	ENDIF
ENDIF

IF play_pager_message2 = 0
	IF com_copcar_kills = 10
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message2 = 1
	ENDIF
ENDIF

IF play_pager_message2 = 1
	IF com_copcar_kills = 20
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message2 = 2
	ENDIF
ENDIF

IF play_pager_message3 = 0
	IF sub_copcar_kills = 10
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message3 = 1
	ENDIF
ENDIF

IF play_pager_message3 = 1
	IF sub_copcar_kills = 20
		ADD_PAGER_MESSAGE PAGEB12 140 100 1	//"Police Bribe delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		play_pager_message3 = 2
	ENDIF
ENDIF

WHILE NOT IS_PLAYER_IN_MODEL player CAR_POLICE
AND NOT IS_PLAYER_IN_MODEL player CAR_ENFORCER
AND NOT IS_PLAYER_IN_MODEL player CAR_RHINO
AND NOT IS_PLAYER_IN_MODEL player CAR_FBI
	IF game_time_flag = 0
		GET_GAME_TIMER game_timer_start
		IF cop_time_limit > 60000 
			copcar_timer = 60000
		ELSE
			copcar_timer = cop_time_limit
		ENDIF 
		game_time_flag = 1
	ENDIF
	GET_GAME_TIMER game_time_present
	game_time_difference = game_time_present - game_timer_start
	copcar_timer -= game_time_difference
	game_timer_start = game_time_present
	timer_in_secs = copcar_timer / 1000
	PRINT_WITH_NUMBER_NOW COPCART timer_in_secs 200 1	//You have ~1~ seconds to return to the car before the mission ends.
	IF timer_in_secs < 1 
		PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
		GOTO cop_car_failed
	ENDIF

	WAIT 0

ENDWHILE

IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player players_cop_car
	GET_CAR_HEALTH players_cop_car players_cop_car_health
	players_cop_car_health += 100
	SET_CAR_HEALTH players_cop_car players_cop_car_health
ENDIF

GOTO cop_car_passed


/////////////////////////////////////////////////////////////
cop_car_passed://////////////////////////////////////////////
/////////////////////////////////////////////////////////////

CLEAR_ONSCREEN_TIMER cop_time_limit
REMOVE_BLIP criminal_blip

IF criminal_created_flag = 1
	MARK_CHAR_AS_NO_LONGER_NEEDED criminal
	criminal_created_flag = 0
ENDIF

GOTO next_cop_car


/////////////////////////////////////////////////////////////
cop_car_failed://////////////////////////////////////////////
/////////////////////////////////////////////////////////////

PRINT_BIG C_FAIL 5000 5
PRINT_WITH_NUMBER_BIG C_KILLS total_criminals_killed 6000 6
CLEAR_ONSCREEN_TIMER cop_time_limit
CLEAR_ONSCREEN_COUNTER total_criminals_killed
REMOVE_BLIP criminal_blip
CLEAR_HELP
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED car_model

IF criminal_created_flag = 1
	MARK_CHAR_AS_NO_LONGER_NEEDED criminal
	criminal_created_flag = 0
ENDIF

flag_player_on_mission = 0
flag_player_on_cop_mission = 0
MISSION_HAS_FINISHED
RETURN

	   		
	
copcar_cancelled_checks:////////////////////////////////////////////////////////////////

IF NOT IS_PLAYER_IN_MODEL player CAR_POLICE
AND NOT IS_PLAYER_IN_MODEL player CAR_ENFORCER
AND NOT IS_PLAYER_IN_MODEL player CAR_RHINO
AND NOT IS_PLAYER_IN_MODEL player CAR_FBI
	IF game_time_flag = 0
		GET_GAME_TIMER game_timer_start
		IF cop_time_limit > 60000 
			copcar_timer = 60000
		ELSE
			copcar_timer = cop_time_limit
		ENDIF 
		game_time_flag = 1
	ENDIF
	GET_GAME_TIMER game_time_present
	game_time_difference = game_time_present - game_timer_start
	copcar_timer -= game_time_difference
	game_timer_start = game_time_present
	timer_in_secs = copcar_timer / 1000
	PRINT_WITH_NUMBER_NOW COPCART timer_in_secs 200 1	//You have ~1~ seconds to return to a squad car before the mission ends.
	IF timer_in_secs < 1 
		PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
		copcar_cancelled_flag = 1
		RETURN
	ENDIF
ENDIF

GET_CONTROLLER_MODE controlmode

IF IS_PLAYER_IN_MODEL player CAR_POLICE
OR IS_PLAYER_IN_MODEL player CAR_ENFORCER
OR IS_PLAYER_IN_MODEL player CAR_RHINO
OR IS_PLAYER_IN_MODEL player CAR_FBI
	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			mission_end_button = 1
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			mission_end_button = 1
		ENDIF
	ENDIF
	game_time_flag = 0
ENDIF

IF mission_end_button = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW C_CANC 3000 1//"Police mission cancelled!"
			copcar_cancelled_flag = 1
			RETURN
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW C_CANC 3000 1//"Police mission cancelled!"
			copcar_cancelled_flag = 1
			RETURN
		ENDIF
	ENDIF
ENDIF

RETURN///////////////////////////////////////////////////////////////////////////////////

		



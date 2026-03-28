MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *************************************** Fire missions *********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_fire

GOSUB failed

MISSION_END
 
// Variables for mission

VAR_INT	fire_time_limit	fire_to_extinguish fire_to_extinguish_blip car_on_fire random_car_model	fires_extinguished
VAR_INT car_on_fire_created	player_in_range_fire flag_got_range_mssg intermediate_int score_ft displayed_timer 
VAR_INT total_score displayed_counter first_fire_flag mission_end_button_ft	fire_location dummy_ped_for_zone
VAR_INT players_firetruck players_firetruck_health car_on_fire_health 

VAR_FLOAT random_fire_x random_fire_y time_divider time_divider_divider
VAR_FLOAT player1_x	player1_y player1_z
VAR_FLOAT fire_coord_x fire_coord_y	fire_coord_z
VAR_FLOAT difference_x_float difference_y_float	sum_difference_xy
VAR_FLOAT players_distance_from_fire fire_time_limit_float random_car_heading


// ****************************************Mission Start************************************

mission_start_fire:

flag_player_on_mission = 1
flag_player_on_fire_mission = 1

SCRIPT_NAME firetru

WAIT 0

fire_time_limit			= 0
fire_to_extinguish  	= 0
fire_to_extinguish_blip = 0
car_on_fire 			= 0
random_car_model 		= 0
car_on_fire_created		= 0
player_in_range_fire 	= 0
flag_got_range_mssg		= 0
score_ft				= 250
displayed_timer			= 0
fires_extinguished		= 0
displayed_counter		= 0
total_score				= 0
first_fire_flag			= 0
mission_end_button_ft	= 0
fire_location			= 0
time_divider_divider	= 2.0


next_fire:

WAIT 0

SET_WANTED_MULTIPLIER 0.5

GET_PLAYER_COORDINATES player player1_x player1_y player1_z

IF NOT IS_PLAYER_IN_MODEL player CAR_FIRETRUCK
	PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
	GOTO failed
ENDIF

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ft = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ft = 1
	ENDIF
ENDIF

IF mission_end_button_ft = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
			GOTO failed
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
			GOTO failed
		ENDIF
	ENDIF
ENDIF

//IF IS_PLAYER_IN_AREA_2D player 778.0 -1110.0 1540.0 190.0 0	 //INDUSTRIAL
IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE 778.0 1540.0 random_fire_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1110.0 190.0 random_fire_y
	flag_got_range_mssg = 0
	player_in_range_fire = 1
	fire_location = 1
	time_divider = 13.0
ENDIF

//IF IS_PLAYER_IN_AREA_2D player -192.0 -1626.0 545.0 98.0 0  //COMMERCIAL
IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE -192.0 545.0 random_fire_x  
	GENERATE_RANDOM_FLOAT_IN_RANGE -1626.0 98.0 random_fire_y
	flag_got_range_mssg = 0
	player_in_range_fire = 1
	fire_location = 2
	time_divider = 14.0
ENDIF

//IF IS_PLAYER_IN_AREA_2D player -1300.0 -608.8 -265.0 380.0 0  //SUBURBIA
IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	GENERATE_RANDOM_FLOAT_IN_RANGE -1300.0 -414.0 random_fire_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -608.8 380.0 random_fire_y
	flag_got_range_mssg = 0
	player_in_range_fire = 1
	fire_location = 3
	time_divider = 11.0
ENDIF

IF player_in_range_fire = 0
AND flag_got_range_mssg = 0
	IF flag_got_range_mssg = 0
		PRINT_NOW F_RANGE 5000 1 //"The radio is out of range, get closer."
		flag_got_range_mssg = 1
	ENDIF
	GOTO failed
ENDIF													  

GET_CLOSEST_CAR_NODE random_fire_x random_fire_y player1_z fire_coord_x fire_coord_y fire_coord_z

IF fire_coord_x 	> 670.0	 //MIN_X // CALAHAN BRIDGE
AND fire_coord_x	< 1035.0 //MAX_X
AND fire_coord_y	> -953.0 //MIN_Y
AND fire_coord_y	< -912.0 //MAX_Y
	GOTO next_fire
ENDIF

IF fire_coord_x 	> 649.0	 //MIN_X // TUNNEL ENTRANCE INDUSTRIAL
AND fire_coord_x	< 1066.0 //MAX_X
AND fire_coord_y	> 25.0   //MIN_Y
AND fire_coord_y	< 217.0  //MAX_Y
	GOTO next_fire
ENDIF

IF fire_coord_x 	> -1611.5 //MIN_X // AIRPORT SUBURBAN
AND fire_coord_x	< -745.3  //MAX_X
AND fire_coord_y	> -1001.9 //MIN_Y
AND fire_coord_y	< -371.2  //MAX_Y
	GOTO next_fire
ENDIF

IF fire_coord_x 	> -1255.4 //MIN_X // BAIT WAREHOUSE CARPARK SUBURBIA
AND fire_coord_x	< -1187.9 //MAX_X
AND fire_coord_y	> 80.6    //MIN_Y
AND fire_coord_y	< 123.4   //MAX_Y
	GOTO next_fire
ENDIF

IF fire_coord_x 	> 1386.4 //MIN_X // FRANKIES HOUSE
AND fire_coord_x	< 1475.8 //MAX_X
AND fire_coord_y	> -292.1 //MIN_Y
AND fire_coord_y	< -168.0 //MAX_Y
	GOTO next_fire
ENDIF

IF fire_location = 1
	IF NOT fire_coord_x > 778.0 //MIN_X // INDUSTRIAL
	OR NOT fire_coord_x	< 1540.0 //MAX_X
	OR NOT fire_coord_y	> -1110.0 //MIN_Y
	OR NOT fire_coord_y	< 190.0 //MAX_Y
		GOTO next_fire
	ENDIF
ENDIF

IF fire_location = 2
	IF NOT fire_coord_x > -192.0 //MIN_X // COMMERCIAL
	OR NOT fire_coord_x	< 545.0 //MAX_X
	OR NOT fire_coord_y	> -1626.0 //MIN_Y
	OR NOT fire_coord_y	< 98.0 //MAX_Y
		GOTO next_fire
	ENDIF
ENDIF

IF fire_location = 3
	IF NOT fire_coord_x > -1300.0 //MIN_X // SUBURBIA
	OR NOT fire_coord_x	< -414.0 //MAX_X
	OR NOT fire_coord_y	> -608.8 //MIN_Y
	OR NOT fire_coord_y	< 380.0 //MAX_Y
		GOTO next_fire
	ENDIF
ENDIF

IF fire_coord_z < -1.0
	GOTO next_fire
ENDIF

difference_x_float = player1_x - fire_coord_x
difference_y_float = player1_y - fire_coord_y
difference_x_float = difference_x_float * difference_x_float
difference_y_float = difference_y_float * difference_y_float
sum_difference_xy = difference_x_float + difference_y_float
SQRT sum_difference_xy players_distance_from_fire

IF players_distance_from_fire < 200.0
	GOTO next_fire
ENDIF

fire_time_limit_float = players_distance_from_fire / time_divider

time_divider += time_divider_divider
time_divider_divider += 2.0

fire_time_limit_float = fire_time_limit_float * 1000.0
intermediate_int =#	fire_time_limit_float
fire_time_limit += intermediate_int

IF fires_extinguished = 0
	IF fire_time_limit < 50000
		fire_time_limit = 50000
	ENDIF
ENDIF

generate_model:

GENERATE_RANDOM_INT_IN_RANGE 90 140 random_car_model //INC 90 NOT INC 140

IF random_car_model > 113  // CAR_BUGGY CAR_CORPSE CAR_POLICE CAR_ENFORCER CAR_SECURICAR CAR_BANSHEE BOAT_PREDATOR CAR_BUS	
AND random_car_model < 128 // CAR_RHINO CAR_BARRACKS TRAIN_SUBWAY HELI_POLICE PLANE_DODO CAR_COACH
	GOTO generate_model
ENDIF

IF random_car_model = 92	// CAR_BOXTER
OR random_car_model = 97	// CAR_FIRETRUCK
OR random_car_model = 101	// CAR_INFERNUS
OR random_car_model = 105	// CAR_CHEETAH
	GOTO generate_model
ENDIF

IF random_car_model = 106	// CAR_AMBULANCE
OR random_car_model = 107	// CAR_FBI
OR random_car_model = 131	// CAR_RCBANDIT
OR random_car_model = 140	// PLANE_AIRTRAIN
	GOTO generate_model
ENDIF

REQUEST_MODEL random_car_model
{
IF first_fire_flag = 1
	TIMERA = 0
ELSE
	TIMERA = 3001
	first_fire_flag = 1
ENDIF

WHILE NOT HAS_MODEL_LOADED random_car_model
OR NOT TIMERA > 3000
	WAIT 0
	
	IF fire_time_limit < 1
		PRINT_NOW F_FAIL2 5000 1
		GOTO failed
	ENDIF
		
	IF NOT IS_PLAYER_IN_MODEL player CAR_FIRETRUCK
		PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
		GOTO failed
	ENDIF

	GET_CONTROLLER_MODE controlmode

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			mission_end_button_ft = 1
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			mission_end_button_ft = 1
		ENDIF
	ENDIF

	IF mission_end_button_ft = 1
		IF NOT controlmode = 3
			IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
				PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
				GOTO failed
			ENDIF
		ELSE
			IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
				PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
				GOTO failed
			ENDIF
		ENDIF
	ENDIF
	
ENDWHILE
}
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_car_heading

IF car_on_fire_created = 0	
	CREATE_CAR random_car_model fire_coord_x fire_coord_y fire_coord_z car_on_fire
	car_on_fire_created = 1
ENDIF

CREATE_CHAR_INSIDE_CAR car_on_fire PEDTYPE_CIVMALE PED_MALE1 dummy_ped_for_zone
MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model
SET_CAR_HEADING car_on_fire random_car_heading  
START_CAR_FIRE car_on_fire fire_to_extinguish
ADD_BLIP_FOR_CAR car_on_fire fire_to_extinguish_blip
CAR_SET_IDLE car_on_fire
CHAR_SET_IDLE dummy_ped_for_zone
SET_CAR_CRUISE_SPEED car_on_fire 0.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER car_on_fire TRUE

//PRINT_NOW F_START 3000 1

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PORT_W
	PRINT_STRING_IN_STRING_NOW F_START PORT_W 5000 1 // The suspect is in the Callahan Point area.
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PORT_S
	PRINT_STRING_IN_STRING_NOW F_START PORT_S 5000 1 // The suspect is in the Atlantic Quays area.
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PORT_E
	PRINT_STRING_IN_STRING_NOW F_START PORT_E 5000 1 // The suspect is in the Portland Harbour area.
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PORT_I
	PRINT_STRING_IN_STRING_NOW F_START PORT_I 5000 1 // The suspect is in the Trenton area.
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone S_VIEW
	PRINT_STRING_IN_STRING_NOW F_START S_VIEW 5000 1 // The suspect is in the Portland View area.
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone CHINA
	PRINT_STRING_IN_STRING_NOW F_START CHINA 5000 1 // The dummy_ped_for_zone is proceeding south in Chinatown
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone EASTBAY
	PRINT_STRING_IN_STRING_NOW F_START EASTBAY 5000 1 // The dummy_ped_for_zone is proceeding south in Portland Beach
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone LITTLEI
	PRINT_STRING_IN_STRING_NOW F_START LITTLEI 5000 1 // The dummy_ped_for_zone is proceeding south in Saint Mark's
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone REDLIGH
	PRINT_STRING_IN_STRING_NOW F_START REDLIGH 5000 1 // The dummy_ped_for_zone is proceeding south in Red Light District
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone TOWERS
	PRINT_STRING_IN_STRING_NOW F_START TOWERS 5000 1 // The dummy_ped_for_zone is proceeding south in Hepburn Heights
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone HARWOOD
	PRINT_STRING_IN_STRING_NOW F_START HARWOOD 5000 1 // The dummy_ped_for_zone is proceeding south in Harwood
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone ROADBR1
	PRINT_STRING_IN_STRING_NOW F_START ROADBR1 5000 1 // The dummy_ped_for_zone is proceeding south in Callahan Bridge
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone ROADBR2
	PRINT_STRING_IN_STRING_NOW F_START ROADBR2 5000 1 // The dummy_ped_for_zone is proceeding south in Callahan Bridge
ENDIF

//IF IS_CHAR_IN_ZONE dummy_ped_for_zone TUNNELP
//	PRINT_STRING_IN_STRING_NOW F_START TUNNELP 5000 1 // The dummy_ped_for_zone is proceeding south in Porter Tunnel
//ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone STADIUM
	PRINT_STRING_IN_STRING_NOW F_START STADIUM 5000 1 // The dummy_ped_for_zone is proceeding south in Aspatria
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone HOSPI_2
	PRINT_STRING_IN_STRING_NOW F_START HOSPI_2 5000 1 // The dummy_ped_for_zone is proceeding south in Rockford
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone UNIVERS
	PRINT_STRING_IN_STRING_NOW F_START UNIVERS 5000 1 // The dummy_ped_for_zone is proceeding south in Liberty Campus
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone CONSTRU
	PRINT_STRING_IN_STRING_NOW F_START CONSTRU 5000 1 // The dummy_ped_for_zone is proceeding south in Fort Staunton
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PARK
	PRINT_STRING_IN_STRING_NOW F_START PARK 5000 1 // The dummy_ped_for_zone is proceeding south in Belleville Park
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone COM_EAS
	PRINT_STRING_IN_STRING_NOW F_START COM_EAS 5000 1 // The dummy_ped_for_zone is proceeding south in Newport
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone SHOPING
	PRINT_STRING_IN_STRING_NOW F_START SHOPING 5000 1 // The dummy_ped_for_zone is proceeding south in Bedford Point
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone YAKUSA
	PRINT_STRING_IN_STRING_NOW F_START YAKUSA 5000 1 // The dummy_ped_for_zone is proceeding south in Torrington
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone AIRPORT
	PRINT_STRING_IN_STRING_NOW F_START AIRPORT 5000 1 // The dummy_ped_for_zone is proceeding south in Francis International Airport
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone PROJECT
	PRINT_STRING_IN_STRING_NOW F_START PROJECT 5000 1 // The dummy_ped_for_zone is proceeding south in Wichita Gardens
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone SUB_IND
	PRINT_STRING_IN_STRING_NOW F_START SUB_IND 5000 1 // The dummy_ped_for_zone is proceeding south in Pike Creek
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone SWANKS
	PRINT_STRING_IN_STRING_NOW F_START SWANKS 5000 1 // The dummy_ped_for_zone is proceeding south in Cedar Grove
ENDIF

IF IS_CHAR_IN_ZONE dummy_ped_for_zone BIG_DAM
	PRINT_STRING_IN_STRING_NOW F_START BIG_DAM 5000 1 // The dummy_ped_for_zone is proceeding south in Cochrane Dam
ENDIF

DELETE_CHAR dummy_ped_for_zone

IF displayed_timer = 0
	DISPLAY_ONSCREEN_TIMER fire_time_limit
	displayed_timer = 1
ENDIF

CLEAR_HELP

IF got_siren_help_before = 1
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
	got_siren_help_before = 2
ENDIF

IF got_siren_help_before = 0
	GET_CONTROLLER_MODE	controlmode
	IF controlmode = 0
		PRINT_HELP SPRAY_1 //"To turn on this vehicles sirens tap the ~h~L1 button~w~."
	ENDIF
	IF controlmode = 1
		PRINT_HELP SPRAY_1 //"To turn on this vehicles sirens tap the ~h~L1 button~w~."
	ENDIF
	IF controlmode = 2
		PRINT_HELP SPRAY_1 //"To turn on this vehicles sirens tap the ~h~R1 button~w~."
	ENDIF
	IF controlmode = 3
		PRINT_HELP SPRAY_4 //"To turn on this vehicles sirens tap the ~h~L3 button~w~."
	ENDIF
	got_siren_help_before = 1
ENDIF

WHILE NOT IS_SCRIPT_FIRE_EXTINGUISHED fire_to_extinguish
	WAIT 0
	
	IF IS_CAR_DEAD car_on_fire
		PRINT_NOW F_FAIL2 5000 1
		GOTO failed
	ENDIF
	
	IF fire_time_limit < 1
		PRINT_NOW F_FAIL2 5000 1
		GOTO failed
	ENDIF
	
	IF NOT IS_PLAYER_IN_MODEL player CAR_FIRETRUCK
		PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
		GOTO failed
	ENDIF

	GET_CAR_HEALTH car_on_fire car_on_fire_health
	
	IF car_on_fire_health < 900
		EXPLODE_CAR car_on_fire
	ENDIF

	GET_CONTROLLER_MODE controlmode

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			mission_end_button_ft = 1
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			mission_end_button_ft = 1
		ENDIF
	ENDIF

	IF mission_end_button_ft = 1
		IF NOT controlmode = 3
			IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
				PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
				GOTO failed
			ENDIF
		ELSE
			IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
				PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
				GOTO failed
			ENDIF
		ENDIF
	ENDIF

ENDWHILE

GOTO passed


/////////////////////////////////////////////////
passed://////////////////////////////////////////
/////////////////////////////////////////////////

++ fires_extinguished
PRINT_BIG F_PASS1 5000 5
PRINT_WITH_NUMBER_BIG REWARD score_ft 6000 6
REGISTER_FIRE_EXTINGUISHED

IF fire_location = 1
	++ ind_fires_exting
ENDIF

IF fire_location = 2
	++ com_fires_exting
ENDIF

IF fire_location = 3
	++ sub_fires_exting
ENDIF

IF earned_free_flamethrower = 0
	IF ind_fires_exting > 19
	AND com_fires_exting > 19
	AND sub_fires_exting > 19
		ADD_PAGER_MESSAGE PAGEB11 140 100 1	//"Flamethrower delivered to hideout"
		PLAYER_MADE_PROGRESS 1
		earned_free_flamethrower = 1
	ENDIF
ENDIF

ADD_SCORE player score_ft
total_score += score_ft
score_ft += 250
REMOVE_ALL_SCRIPT_FIRES
REMOVE_BLIP fire_to_extinguish_blip
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

IF IS_PLAYER_IN_ANY_CAR	player
	STORE_CAR_PLAYER_IS_IN player players_firetruck
	GET_CAR_HEALTH players_firetruck players_firetruck_health
	players_firetruck_health += 150
	SET_CAR_HEALTH players_firetruck players_firetruck_health
ENDIF

//earned_free_flamethrower PAGEB11

IF displayed_counter = 0
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
	displayed_counter = 1
ENDIF

IF car_on_fire_created = 1
	MARK_CAR_AS_NO_LONGER_NEEDED car_on_fire
	IF NOT IS_CAR_DEAD car_on_fire
		SET_CAR_ONLY_DAMAGED_BY_PLAYER car_on_fire FALSE
	ENDIF
	car_on_fire_created = 0
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model

GOTO next_fire


/////////////////////////////////////////////////
failed://////////////////////////////////////////
/////////////////////////////////////////////////

CLEAR_ONSCREEN_TIMER fire_time_limit
CLEAR_ONSCREEN_COUNTER fires_extinguished
PRINT_BIG F_FAIL1 5000 5
PRINT_WITH_NUMBER_BIG TSCORE total_score 6000 6
REMOVE_ALL_SCRIPT_FIRES
REMOVE_BLIP fire_to_extinguish_blip
CLEAR_HELP
SET_WANTED_MULTIPLIER 1.0

IF car_on_fire_created = 1
	IF NOT IS_CAR_DEAD car_on_fire
		SET_CAR_ONLY_DAMAGED_BY_PLAYER car_on_fire FALSE
		EXPLODE_CAR car_on_fire
	ENDIF
	MARK_CAR_AS_NO_LONGER_NEEDED car_on_fire
	car_on_fire_created = 0
ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model

flag_player_on_mission = 0
flag_player_on_fire_mission	= 0
MISSION_HAS_FINISHED
RETURN

	   		
	
		



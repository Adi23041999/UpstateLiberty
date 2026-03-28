MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *********************************** Ambulance missions ********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ambulance

GOSUB ambulance_failed

MISSION_END
 
// Variables for mission

VAR_INT	ped_time_limit players_ambulance flag_got_range_message	ped_time_limit_temp	ped_counter	number_of_injured_peds brackets_var
VAR_INT ambulance_health_last ambulance_health_now time_drop max_peds_in_car peds_in_car player_in_range_flag score_am bonus_time_flag
VAR_INT saved_peds	hospital_blip first_rescue_flag	time_chunk first_chunk_flag	ambulance_level	time_chunk_in_secs car_full_flag paramedic_location
VAR_INT drop_off_time_bonus	hospital_blip_flag random_scream mission_end_button_ambulance ped_sex_flag players_ambulance_health	saved_peds_this_go
VAR_INT injured_ped_1 injured_ped_1_blip injured_ped_1_flag
VAR_INT injured_ped_2 injured_ped_2_blip injured_ped_2_flag
VAR_INT injured_ped_3 injured_ped_3_blip injured_ped_3_flag
VAR_INT injured_ped_4 injured_ped_4_blip injured_ped_4_flag
VAR_INT injured_ped_5 injured_ped_5_blip injured_ped_5_flag
VAR_INT injured_ped_6 injured_ped_6_blip injured_ped_6_flag
VAR_INT injured_ped_7 injured_ped_7_blip injured_ped_7_flag
VAR_INT injured_ped_8 injured_ped_8_blip injured_ped_8_flag
VAR_INT injured_ped_9 injured_ped_9_blip injured_ped_9_flag
VAR_INT injured_ped_10 injured_ped_10_blip injured_ped_10_flag
VAR_INT injured_ped_11 injured_ped_11_blip injured_ped_11_flag
VAR_INT injured_ped_12 injured_ped_12_blip injured_ped_12_flag
//VAR_INT injured_ped_13 injured_ped_13_blip injured_ped_13_flag
//VAR_INT injured_ped_14 injured_ped_14_blip injured_ped_14_flag
//VAR_INT injured_ped_15 injured_ped_15_blip injured_ped_15_flag

VAR_FLOAT random_x random_y	hospital_x hospital_y hospital_z
VAR_FLOAT player1_a_x	player1_a_y player1_a_z	hospital_door_x	hospital_door_y
VAR_FLOAT ped_coord_x ped_coord_y	ped_coord_z	sound_x sound_y sound_z
VAR_FLOAT difference_x_float_a difference_y_float_a	sum_difference_a_xy	
VAR_FLOAT players_distance_from_ped peds_distance_from_hospital ped_time_limit_float random_ped_heading	time_chunk_divider


// ****************************************Mission Start************************************

mission_start_ambulance:

flag_player_on_mission = 1
flag_player_on_ambulance_mission = 1

WAIT 0

SCRIPT_NAME ambulan

ped_time_limit 			= 0
players_ambulance  		= 0
flag_got_range_message 	= 0
ambulance_health_last  	= 0
ambulance_health_now  	= 0
time_drop  				= 0
max_peds_in_car  		= 0
peds_in_car  			= 0
player_in_range_flag 	= 0
number_of_injured_peds	= 1
ped_counter 			= 0
injured_ped_1_flag		= 0
injured_ped_2_flag		= 0
injured_ped_3_flag		= 0
injured_ped_4_flag		= 0
injured_ped_5_flag		= 0
injured_ped_6_flag		= 0
injured_ped_7_flag		= 0
injured_ped_8_flag		= 0
injured_ped_9_flag		= 0
injured_ped_10_flag		= 0
injured_ped_11_flag		= 0
injured_ped_12_flag		= 0
//injured_ped_13_flag		= 0
//injured_ped_14_flag		= 0
//injured_ped_15_flag		= 0
saved_peds				= 0
first_rescue_flag		= 0
first_chunk_flag		= 0
time_chunk_divider		= 11.0
ambulance_level			= 1
time_chunk				= 0 
time_chunk_in_secs 		= 0
score_am				= 0
bonus_time_flag			= 0
drop_off_time_bonus		= 0
hospital_blip_flag		= 0
mission_end_button_ambulance = 0
car_full_flag = 0
saved_peds_this_go = 0
paramedic_location = 0

PRINT_NOW ATUTOR2 3000 1 // Take the injured people to the Hospital

WAIT 3000

SET_WANTED_MULTIPLIER 0.5

mission_root:

PRINT_WITH_NUMBER_NOW ALEVEL ambulance_level 5000 4 // Ambulance Mission Level ~1~

CLEAR_ONSCREEN_TIMER ped_time_limit

ped_time_limit = 0

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

WHILE number_of_injured_peds > ped_counter
	GOSUB generate_random_coord
	GOSUB create_random_injured_ped
	GOSUB generate_timelimit
	++ ped_counter
ENDWHILE

IF number_of_injured_peds > 3
	bonus_time_flag = 1
ELSE
	bonus_time_flag = 0
ENDIF

time_chunk = ped_time_limit / number_of_injured_peds
time_chunk /= 2
brackets_var = number_of_injured_peds + 1
time_chunk *= brackets_var
ped_time_limit += time_chunk
ped_time_limit = ped_time_limit / number_of_injured_peds
time_chunk = ped_time_limit
time_chunk /= 2

DISPLAY_ONSCREEN_TIMER ped_time_limit

IF flag_player_on_mission = 0
	ADD_BLIP_FOR_COORD hospital_x hospital_y hospital_z hospital_blip
ENDIF

GOTO ambulance_loop

////////////////

create_random_injured_ped:

IF number_of_injured_peds > 0
AND injured_ped_1_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_1
	injured_ped_1_flag = 1
	SET_CHAR_BLEEDING injured_ped_1 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_1 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_1 random_ped_heading
	SET_CHAR_RUNNING injured_ped_1 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_1
	ADD_BLIP_FOR_CHAR injured_ped_1 injured_ped_1_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_1
	RETURN
ENDIF

IF number_of_injured_peds > 1
AND injured_ped_2_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_2
	injured_ped_2_flag = 1
	SET_CHAR_BLEEDING injured_ped_2 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_2 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_2 random_ped_heading
	SET_CHAR_RUNNING injured_ped_2 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_2
	ADD_BLIP_FOR_CHAR injured_ped_2 injured_ped_2_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_2
	RETURN
ENDIF

IF number_of_injured_peds > 2
AND injured_ped_3_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_3
	injured_ped_3_flag = 1
	SET_CHAR_BLEEDING injured_ped_3 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_3 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_3 random_ped_heading
	SET_CHAR_RUNNING injured_ped_3 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_3
	ADD_BLIP_FOR_CHAR injured_ped_3 injured_ped_3_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_3
	RETURN
ENDIF

IF number_of_injured_peds > 3
AND injured_ped_4_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_4
	injured_ped_4_flag = 1
	SET_CHAR_BLEEDING injured_ped_4 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_4 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_4 random_ped_heading
	SET_CHAR_RUNNING injured_ped_4 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_4
	ADD_BLIP_FOR_CHAR injured_ped_4 injured_ped_4_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_4
	RETURN
ENDIF

IF number_of_injured_peds > 4
AND injured_ped_5_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_5
	injured_ped_5_flag = 1
	SET_CHAR_BLEEDING injured_ped_5 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_5 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_5 random_ped_heading
	SET_CHAR_RUNNING injured_ped_5 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_5
	ADD_BLIP_FOR_CHAR injured_ped_5 injured_ped_5_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_5
	RETURN
ENDIF

IF number_of_injured_peds > 5
AND injured_ped_6_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_6
	injured_ped_6_flag = 1
	SET_CHAR_BLEEDING injured_ped_6 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_6 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_6 random_ped_heading
	SET_CHAR_RUNNING injured_ped_6 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_6
	ADD_BLIP_FOR_CHAR injured_ped_6 injured_ped_6_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_6
	RETURN
ENDIF

IF number_of_injured_peds > 6
AND injured_ped_7_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_7
	injured_ped_7_flag = 1
	SET_CHAR_BLEEDING injured_ped_7 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_7 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_7 random_ped_heading
	SET_CHAR_RUNNING injured_ped_7 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_7
	ADD_BLIP_FOR_CHAR injured_ped_7 injured_ped_7_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_7
	RETURN
ENDIF

IF number_of_injured_peds > 7
AND injured_ped_8_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_8
	injured_ped_8_flag = 1
	SET_CHAR_BLEEDING injured_ped_8 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_8 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_8 random_ped_heading
	SET_CHAR_RUNNING injured_ped_8 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_8
	ADD_BLIP_FOR_CHAR injured_ped_8 injured_ped_8_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_8
	RETURN
ENDIF

IF number_of_injured_peds > 8
AND injured_ped_9_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_9
	injured_ped_9_flag = 1
	SET_CHAR_BLEEDING injured_ped_9 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_9 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_9 random_ped_heading
	SET_CHAR_RUNNING injured_ped_9 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_9
	ADD_BLIP_FOR_CHAR injured_ped_9 injured_ped_9_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_9
	RETURN
ENDIF

IF number_of_injured_peds > 9
AND injured_ped_10_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_10
	injured_ped_10_flag = 1
	SET_CHAR_BLEEDING injured_ped_10 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_10 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_10 random_ped_heading
	SET_CHAR_RUNNING injured_ped_10 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_10
	ADD_BLIP_FOR_CHAR injured_ped_10 injured_ped_10_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_10
	RETURN
ENDIF

IF number_of_injured_peds > 10
AND injured_ped_11_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_11
	injured_ped_11_flag = 1
	SET_CHAR_BLEEDING injured_ped_11 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_11 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_11 random_ped_heading
	SET_CHAR_RUNNING injured_ped_11 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_11
	ADD_BLIP_FOR_CHAR injured_ped_11 injured_ped_11_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_11
	RETURN
ENDIF

IF number_of_injured_peds > 11
AND injured_ped_12_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_12
	injured_ped_12_flag = 1
	SET_CHAR_BLEEDING injured_ped_12 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_12 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_12 random_ped_heading
	SET_CHAR_RUNNING injured_ped_12 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_12
	ADD_BLIP_FOR_CHAR injured_ped_12 injured_ped_12_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_12
	RETURN
ENDIF

//IF number_of_injured_peds > 12
//AND injured_ped_13_flag = 0
//	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_13
//	injured_ped_13_flag = 1
//	SET_CHAR_BLEEDING injured_ped_13 TRUE
//	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
//	SET_CHAR_HEADING injured_ped_13 random_ped_heading
//	SET_CHAR_RUNNING injured_ped_13 TRUE
//	CLEAR_CHAR_THREAT_SEARCH injured_ped_13
//	ADD_BLIP_FOR_CHAR injured_ped_13 injured_ped_13_blip
//	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_13
//	RETURN
//ENDIF
//
//IF number_of_injured_peds > 13
//AND injured_ped_14_flag = 0
//	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_14
//	injured_ped_14_flag = 1
//	SET_CHAR_BLEEDING injured_ped_14 TRUE
//	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
//	SET_CHAR_HEADING injured_ped_14 random_ped_heading
//	SET_CHAR_RUNNING injured_ped_14 TRUE
//	CLEAR_CHAR_THREAT_SEARCH injured_ped_14
//	ADD_BLIP_FOR_CHAR injured_ped_14 injured_ped_14_blip
//	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_14
//	RETURN
//ENDIF
//
//IF number_of_injured_peds > 14
//AND injured_ped_15_flag = 0
//	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_15
//	injured_ped_15_flag = 1
//	SET_CHAR_BLEEDING injured_ped_15 TRUE
//	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
//	SET_CHAR_HEADING injured_ped_15 random_ped_heading
//	SET_CHAR_RUNNING injured_ped_15 TRUE
//	CLEAR_CHAR_THREAT_SEARCH injured_ped_15
//	ADD_BLIP_FOR_CHAR injured_ped_15 injured_ped_15_blip
//	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_15
//	RETURN
//ENDIF

RETURN

////////////////

generate_random_coord:

WAIT 0

GET_PLAYER_COORDINATES player player1_a_x player1_a_y player1_a_z

IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE 778.0 1540.0 random_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1110.0 0.0 random_y
	hospital_x = 1141.5 
	hospital_y = -595.2402
	hospital_z = 13.9
	hospital_door_x = 1149.1873
	hospital_door_y = -597.3521
	flag_got_range_message = 0
	player_in_range_flag = 1
	paramedic_location = 1
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	GENERATE_RANDOM_FLOAT_IN_RANGE -192.0 545.0 random_x  
	GENERATE_RANDOM_FLOAT_IN_RANGE -1626.0 98.0 random_y
	hospital_x = 178.5
	hospital_y = -23.6
	hospital_z = 15.2
	hospital_door_x = 182.75
	hospital_door_y = -15.8
	flag_got_range_message = 0
	player_in_range_flag = 1
	paramedic_location = 2
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	GENERATE_RANDOM_FLOAT_IN_RANGE -1300.0 -414.0 random_x   
	GENERATE_RANDOM_FLOAT_IN_RANGE -608.8 380.0 random_y   
	hospital_x = -1255.5 										  
	hospital_y = -144.4254
	hospital_z = 57.8										  
	hospital_door_x = -1246.7969 									  
	hospital_door_y = -139.1016									  
	flag_got_range_message = 0							  
	player_in_range_flag = 1
	paramedic_location = 3							  
ENDIF

IF player_in_range_flag = 0
AND flag_got_range_message = 0
	IF flag_got_range_message = 0
		PRINT_NOW A_RANGE 5000 1 //"The ambulance radio is out of range, get closer to a hospital."
		flag_got_range_message = 1
	ENDIF
	GOTO ambulance_failed
ENDIF													  

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ambulance = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ambulance = 1
	ENDIF
ENDIF

IF mission_end_button_ambulance = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ENDIF
ENDIF

IF NOT IS_PLAYER_IN_MODEL player CAR_AMBULANCE
	PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
	GOTO ambulance_failed
ENDIF

GET_CLOSEST_CHAR_NODE random_x random_y player1_a_z ped_coord_x ped_coord_y ped_coord_z

IF ped_coord_x > 1398.0	 //MIN_X // COLOMBIAN BOAT
AND ped_coord_x	< 1615.0 //MAX_X
AND ped_coord_y	> -965.0 //MIN_Y
AND ped_coord_y	< -902.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 879.0	 //MIN_X // BACK OF LUIGI'S
AND ped_coord_x	< 892.0  //MAX_X
AND ped_coord_y	> -427.0 //MIN_Y
AND ped_coord_y	< -407.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 944.8	  //MIN_X // FISH FACTORY
AND ped_coord_x	< 1017.1  //MAX_X
AND ped_coord_y	> -1148.8 //MIN_Y
AND ped_coord_y	< -1076.6 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 920.8	 //MIN_X // CHINATOWN MARKET
AND ped_coord_x	< 1004.0 //MAX_X
AND ped_coord_y	> -754.2 //MIN_Y
AND ped_coord_y	< -670.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 670.0	 //MIN_X // CALAHAN BRIDGE
AND ped_coord_x	< 1035.0 //MAX_X
AND ped_coord_y	> -953.0 //MIN_Y
AND ped_coord_y	< -912.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 1364.0	  //MIN_X // DOCKS INDUSTRIAL
AND ped_coord_x	< 1641.0  //MAX_X
AND ped_coord_y	> -1165.0 //MIN_Y
AND ped_coord_y	< -617.0  //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x > 649.0	 //MIN_X // TUNNEL ENTRANCE INDUSTRIAL
AND ped_coord_x	< 1066.0 //MAX_X
AND ped_coord_y	> 25.0   //MIN_Y
AND ped_coord_y	< 217.0  //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> -1611.5 //MIN_X // AIRPORT SUBURBAN
AND ped_coord_x	< -745.3  //MAX_X
AND ped_coord_y	> -1001.9 //MIN_Y
AND ped_coord_y	< -371.2  //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 939.8  //MIN_X // OLD SCHOOL HALL AND PARK AREA
AND ped_coord_x	< 1035.6 //MAX_X
AND ped_coord_y	> -901.3 //MIN_Y
AND ped_coord_y	< -828.2 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 1215.3 //MIN_X // DOG FOOD FACTORY
AND ped_coord_x	< 1223.7 //MAX_X
AND ped_coord_y	> -839.4 //MIN_Y
AND ped_coord_y	< -763.6 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 845.3  //MIN_X // INDUSTRIAL SAFEHOUSE
AND ped_coord_x	< 899.6  //MAX_X
AND ped_coord_y	> -312.6 //MIN_Y
AND ped_coord_y	< -295.7 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 113.3   //MIN_X // DOJO COMMERCIAL
AND ped_coord_x	< 99.7    //MAX_X
AND ped_coord_y	> -1284.8 //MIN_Y
AND ped_coord_y	< -1273.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 18.33   //MIN_X // COLOMBIAN OJG COMPOUND
AND ped_coord_x	< 92.06   //MAX_X
AND ped_coord_y	> -388.7  //MIN_Y
AND ped_coord_y	< -312.38 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> -1255.4 //MIN_X // BAIT WAREHOUSE CARPARK SUBURBIA
AND ped_coord_x	< -1187.9 //MAX_X
AND ped_coord_y	> 80.6    //MIN_Y
AND ped_coord_y	< 123.4   //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 1386.4 //MIN_X // FRANKIES HOUSE
AND ped_coord_x	< 1475.8 //MAX_X
AND ped_coord_y	> -292.1 //MIN_Y
AND ped_coord_y	< -168.0 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF ped_coord_x 	> 766.7  //MIN_X // FOOT BRIDGE CHINATOWN
AND ped_coord_x	< 851.8  //MAX_X
AND ped_coord_y	> -604.1 //MIN_Y
AND ped_coord_y	< -558.2 //MAX_Y
	GOTO generate_random_coord
ENDIF

IF paramedic_location = 1
	IF NOT ped_coord_x 	> 778.0 //MIN_X // INDUSTRIAL
	OR NOT ped_coord_x	< 1540.0 //MAX_X
	OR NOT ped_coord_y	> -1110.0 //MIN_Y
	OR NOT ped_coord_y	< 190.0 //MAX_Y
		GOTO generate_random_coord
	ENDIF
ENDIF

IF paramedic_location = 2
	IF NOT ped_coord_x 	> -192.0 //MIN_X // COMMERCIAL
	OR NOT ped_coord_x	< 545.0 //MAX_X
	OR NOT ped_coord_y	> -1626.0 //MIN_Y
	OR NOT ped_coord_y	< 98.0 //MAX_Y
		GOTO generate_random_coord
	ENDIF
ENDIF

IF paramedic_location = 3
	IF NOT ped_coord_x 	> -1300.0 //MIN_X // SUBURBIA
	OR NOT ped_coord_x	< -414.0 //MAX_X
	OR NOT ped_coord_y	> -608.8 //MIN_Y
	OR NOT ped_coord_y	< 380.0 //MAX_Y
		GOTO generate_random_coord
	ENDIF
ENDIF

IF ped_coord_z < -1.0
	GOTO generate_random_coord
ENDIF

difference_x_float_a = player1_a_x - ped_coord_x
difference_y_float_a = player1_a_y - ped_coord_y
difference_x_float_a = difference_x_float_a * difference_x_float_a
difference_y_float_a = difference_y_float_a * difference_y_float_a
sum_difference_a_xy = difference_x_float_a + difference_y_float_a
SQRT sum_difference_a_xy players_distance_from_ped

IF players_distance_from_ped < 120.0
	GOTO generate_random_coord
ENDIF

difference_x_float_a = hospital_x - ped_coord_x
difference_y_float_a = hospital_y - ped_coord_y
difference_x_float_a = difference_x_float_a * difference_x_float_a
difference_y_float_a = difference_y_float_a * difference_y_float_a
sum_difference_a_xy = difference_x_float_a + difference_y_float_a
SQRT sum_difference_a_xy peds_distance_from_hospital

IF peds_distance_from_hospital < 100.0
	GOTO generate_random_coord
ENDIF

IF injured_ped_1_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_1
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_1 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_2_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_2
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_2 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_3_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_3
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_3 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_4_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_4
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_4 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_5_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_5
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_5 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_6_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_6
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_6 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_7_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_7
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_7 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_8_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_8
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_8 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_9_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_9
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_9 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_10_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_10
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_10 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_11_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_11
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_11 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

//IF injured_ped_12_flag > 0
//	IF NOT IS_CHAR_DEAD injured_ped_12
//		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_12 ped_coord_x ped_coord_y 25.0 25.0 0
//			GOTO generate_random_coord
//		ENDIF
//	ENDIF
//ENDIF
//
//IF injured_ped_13_flag > 0
//	IF NOT IS_CHAR_DEAD injured_ped_13
//		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_13 ped_coord_x ped_coord_y 25.0 25.0 0
//			GOTO generate_random_coord
//		ENDIF
//	ENDIF
//ENDIF
//
//IF injured_ped_14_flag > 0
//	IF NOT IS_CHAR_DEAD injured_ped_14
//		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_14 ped_coord_x ped_coord_y 25.0 25.0 0
//			GOTO generate_random_coord
//		ENDIF
//	ENDIF
//ENDIF

RETURN

////////////////

generate_timelimit:

IF paramedic_location = 3
	time_chunk_divider = 10.0
ENDIF

ped_time_limit_float = peds_distance_from_hospital / time_chunk_divider
ped_time_limit_float = ped_time_limit_float * 1000.0
ped_time_limit_temp =# ped_time_limit_float
ped_time_limit += ped_time_limit_temp

RETURN

///////////////

ambulance_loop:

WAIT 0

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ambulance = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ambulance = 1
	ENDIF
ENDIF

IF mission_end_button_ambulance = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ENDIF
ENDIF

IF NOT IS_PLAYER_IN_MODEL player CAR_AMBULANCE
	PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
	GOTO ambulance_failed
ELSE
	STORE_CAR_PLAYER_IS_IN player players_ambulance
ENDIF

IF number_of_injured_peds > 6
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 0
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

IF number_of_injured_peds > 9
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 1
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

IF number_of_injured_peds > 12
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 2
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

IF ambulance_pager_flag = 0
	IF total_saved_peds > 34
		ADD_PAGER_MESSAGE PAGEB13 140 100 1	//"Health delivered to hideout"
		GOSUB progress_counter1
		ambulance_pager_flag = 1
	ENDIF
ENDIF
IF ambulance_pager_flag = 1
	IF total_saved_peds > 69
		ADD_PAGER_MESSAGE PAGEB14 140 100 1	//"Adrenaline delivered to hideout"
		GOSUB progress_counter2
		ambulance_pager_flag = 2
	ENDIF
ENDIF

IF injured_ped_1_flag > 0
	IF IS_CHAR_DEAD injured_ped_1
		PRINT_NOW A_FAIL3 3000 1//The patient is dead
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_1
		REMOVE_CHAR_ELEGANTLY injured_ped_1
		PRINT_NOW A_FAIL2 3000 1//"Your too late"
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_1_flag = 3
		IF IS_CHAR_MALE injured_ped_1
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_1 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_1_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_1 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_1 players_ambulance
				injured_ped_1_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_1_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_1 25.0 25.0 0
			injured_ped_1_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_1_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_1 
			REMOVE_BLIP injured_ped_1_blip
			GOSUB chunk3_ambulance
			injured_ped_1_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_1_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_1 players_ambulance
			injured_ped_1_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_1_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_1	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_1 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_1
			GOSUB chunk4_ambulance
			injured_ped_1_flag = 0
		ENDIF
	ENDIF
ENDIF

/////////////////

IF injured_ped_2_flag > 0
	IF IS_CHAR_DEAD injured_ped_2
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_2
		REMOVE_CHAR_ELEGANTLY injured_ped_2
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_2_flag = 3
		IF IS_CHAR_MALE injured_ped_2
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_2 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_2_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_2 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_2 players_ambulance
				injured_ped_2_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_2_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_2 25.0 25.0 0
			injured_ped_2_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_2_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_2 
			REMOVE_BLIP injured_ped_2_blip
			GOSUB chunk3_ambulance
			injured_ped_2_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_2_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_2 players_ambulance
			injured_ped_2_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_2_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_2	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_2 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_2
			GOSUB chunk4_ambulance
			injured_ped_2_flag = 0
		ENDIF
	ENDIF
ENDIF

//////////////////

IF injured_ped_3_flag > 0
	IF IS_CHAR_DEAD injured_ped_3
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_3
		REMOVE_CHAR_ELEGANTLY injured_ped_3
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_3_flag = 3
		IF IS_CHAR_MALE injured_ped_3
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_3 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_3_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_3 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_3 players_ambulance
				injured_ped_3_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_3_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_3 25.0 25.0 0
			injured_ped_3_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_3_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_3 
			REMOVE_BLIP injured_ped_3_blip
			GOSUB chunk3_ambulance
			injured_ped_3_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_3_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_3 players_ambulance
			injured_ped_3_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_3_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_3	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_3 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_3
			GOSUB chunk4_ambulance
			injured_ped_3_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_4_flag > 0
	IF IS_CHAR_DEAD injured_ped_4
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_4
		REMOVE_CHAR_ELEGANTLY injured_ped_4
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_4_flag = 3
		IF IS_CHAR_MALE injured_ped_4
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_4 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_4_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_4 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_4 players_ambulance
				injured_ped_4_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_4_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_4 25.0 25.0 0
			injured_ped_4_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_4_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_4 
			REMOVE_BLIP injured_ped_4_blip
			GOSUB chunk3_ambulance
			injured_ped_4_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_4_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_4 players_ambulance
			injured_ped_4_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_4_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_4	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_4 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_4
			GOSUB chunk4_ambulance
			injured_ped_4_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_5_flag > 0
	IF IS_CHAR_DEAD injured_ped_5
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_5
		REMOVE_CHAR_ELEGANTLY injured_ped_5
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_5_flag = 3
		IF IS_CHAR_MALE injured_ped_5
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_5 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_5_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_5 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_5 players_ambulance
				injured_ped_5_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_5_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_5 25.0 25.0 0
			injured_ped_5_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_5_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_5 
			REMOVE_BLIP injured_ped_5_blip
			GOSUB chunk3_ambulance
			injured_ped_5_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_5_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_5 players_ambulance
			injured_ped_5_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_5_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_5	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_5 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_5
			GOSUB chunk4_ambulance
			injured_ped_5_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_6_flag > 0
	IF IS_CHAR_DEAD injured_ped_6
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_6
		REMOVE_CHAR_ELEGANTLY injured_ped_6
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_6_flag = 3
		IF IS_CHAR_MALE injured_ped_6
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_6 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_6_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_6 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_6 players_ambulance
				injured_ped_6_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_6_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_6 25.0 25.0 0
			injured_ped_6_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_6_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_6 
			REMOVE_BLIP injured_ped_6_blip
			GOSUB chunk3_ambulance
			injured_ped_6_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_6_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_6 players_ambulance
			injured_ped_6_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_6_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_6	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_6 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_6
			GOSUB chunk4_ambulance
			injured_ped_6_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_7_flag > 0
	IF IS_CHAR_DEAD injured_ped_7
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_7
		REMOVE_CHAR_ELEGANTLY injured_ped_7
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_7_flag = 3
		IF IS_CHAR_MALE injured_ped_7
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_7 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_7_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_7 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_7 players_ambulance
				injured_ped_7_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_7_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_7 25.0 25.0 0
			injured_ped_7_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_7_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_7 
			REMOVE_BLIP injured_ped_7_blip
			GOSUB chunk3_ambulance
			injured_ped_7_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_7_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_7 players_ambulance
			injured_ped_7_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_7_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_7	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_7 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_7
			GOSUB chunk4_ambulance
			injured_ped_7_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_8_flag > 0
	IF IS_CHAR_DEAD injured_ped_8
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_8
		REMOVE_CHAR_ELEGANTLY injured_ped_8
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_8_flag = 3
		IF IS_CHAR_MALE injured_ped_8
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_8 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_8_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_8 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_8 players_ambulance
				injured_ped_8_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_8_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_8 25.0 25.0 0
			injured_ped_8_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_8_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_8 
			REMOVE_BLIP injured_ped_8_blip
			GOSUB chunk3_ambulance
			injured_ped_8_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_8_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_8 players_ambulance
			injured_ped_8_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_8_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_8	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_8 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_8
			GOSUB chunk4_ambulance
			injured_ped_8_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_9_flag > 0
	IF IS_CHAR_DEAD injured_ped_9
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_9
		REMOVE_CHAR_ELEGANTLY injured_ped_9
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_9_flag = 3
		IF IS_CHAR_MALE injured_ped_9
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_9 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_9_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_9 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_9 players_ambulance
				injured_ped_9_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_9_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_9 25.0 25.0 0
			injured_ped_9_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_9_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_9 
			REMOVE_BLIP injured_ped_9_blip
			GOSUB chunk3_ambulance
			injured_ped_9_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_9_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_9 players_ambulance
			injured_ped_9_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_9_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_9	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_9 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_9
			GOSUB chunk4_ambulance
			injured_ped_9_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_10_flag > 0
	IF IS_CHAR_DEAD injured_ped_10
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_10
		REMOVE_CHAR_ELEGANTLY injured_ped_10
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_10_flag = 3
		IF IS_CHAR_MALE injured_ped_10
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_10 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_10_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_10 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_10 players_ambulance
				injured_ped_10_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_10_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_10 25.0 25.0 0
			injured_ped_10_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_10_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_10 
			REMOVE_BLIP injured_ped_10_blip
			GOSUB chunk3_ambulance
			injured_ped_10_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_10_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_10 players_ambulance
			injured_ped_10_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_10_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_10	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_10 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_10
			GOSUB chunk4_ambulance
			injured_ped_10_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_11_flag > 0
	IF IS_CHAR_DEAD injured_ped_11
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_11
		REMOVE_CHAR_ELEGANTLY injured_ped_11
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_11_flag = 3
		IF IS_CHAR_MALE injured_ped_11
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_11 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_11_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_11 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_11 players_ambulance
				injured_ped_11_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_11_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_11 25.0 25.0 0
			injured_ped_11_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_11_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_11 
			REMOVE_BLIP injured_ped_11_blip
			GOSUB chunk3_ambulance
			injured_ped_11_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_11_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_11 players_ambulance
			injured_ped_11_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_11_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_11	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_11 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_11
			GOSUB chunk4_ambulance
			injured_ped_11_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

IF injured_ped_12_flag > 0
	IF IS_CHAR_DEAD injured_ped_12
		PRINT_NOW A_FAIL3 3000 1
		GOTO ambulance_failed
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD injured_ped_12
		REMOVE_CHAR_ELEGANTLY injured_ped_12
		PRINT_NOW A_FAIL2 3000 1
		GOTO ambulance_failed
	ENDIF

	IF injured_ped_12_flag = 3
		IF IS_CHAR_MALE injured_ped_12
			ped_sex_flag = 0
		ELSE
			ped_sex_flag = 1
		ENDIF
		GET_CHAR_COORDINATES injured_ped_12 sound_x sound_y sound_z
		GOSUB chunk1_ambulance
	ENDIF

	IF injured_ped_12_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_12 10.0 10.0 2.0 0
			GOSUB chunk2_ambulance
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_12 players_ambulance
				injured_ped_12_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF injured_ped_12_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_12 25.0 25.0 0
			injured_ped_12_flag = 1
		ENDIF
	ENDIF	

	IF injured_ped_12_flag = 2
		IF IS_CHAR_IN_ANY_CAR injured_ped_12 
			REMOVE_BLIP injured_ped_12_blip
			GOSUB chunk3_ambulance
			injured_ped_12_flag = 3
		ENDIF
	ENDIF

	IF injured_ped_12_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_LEAVE_CAR injured_ped_12 players_ambulance
			injured_ped_12_flag = 4
		ENDIF	
	ENDIF

	IF injured_ped_12_flag = 4
		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_12	
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_12 hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_12
			GOSUB chunk4_ambulance
			injured_ped_12_flag = 0
		ENDIF
	ENDIF
ENDIF

////////////////

//IF injured_ped_13_flag > 0
//	IF IS_CHAR_DEAD injured_ped_13
//		PRINT_NOW A_FAIL3 3000 1
//		GOTO ambulance_failed
//	ENDIF
//		
//	IF ped_time_limit = 0
//		EXPLODE_CHAR_HEAD injured_ped_13
//		REMOVE_CHAR_ELEGANTLY injured_ped_13
//		PRINT_NOW A_FAIL2 3000 1
//		GOTO ambulance_failed
//	ENDIF
//
//	IF injured_ped_13_flag = 3
//		IF IS_CHAR_MALE injured_ped_13
//			ped_sex_flag = 0
//		ELSE
//			ped_sex_flag = 1
//		ENDIF
//		GET_CHAR_COORDINATES injured_ped_13 sound_x sound_y sound_z
//		GOSUB chunk1_ambulance
//	ENDIF
//
//	IF injured_ped_13_flag = 1
//		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_13 10.0 10.0 2.0 0
//			GOSUB chunk2_ambulance
//			IF car_full_flag = 0
//				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_13 players_ambulance
//				injured_ped_13_flag = 2
//			ENDIF
//		ENDIF
//	ENDIF
//
//	IF injured_ped_13_flag = 2
//		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_13 25.0 25.0 0
//			injured_ped_13_flag = 1
//		ENDIF
//	ENDIF	
//
//	IF injured_ped_13_flag = 2
//		IF IS_CHAR_IN_ANY_CAR injured_ped_13 
//			REMOVE_BLIP injured_ped_13_blip
//			GOSUB chunk3_ambulance
//			injured_ped_13_flag = 3
//		ENDIF
//	ENDIF
//
//	IF injured_ped_13_flag = 3
//		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
//			SET_CHAR_OBJ_LEAVE_CAR injured_ped_13 players_ambulance
//			injured_ped_13_flag = 4
//		ENDIF	
//	ENDIF
//
//	IF injured_ped_13_flag = 4
//		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_13	
//			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_13 hospital_door_x hospital_door_y
//			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_13
//			GOSUB chunk4_ambulance
//			injured_ped_13_flag = 0
//		ENDIF
//	ENDIF
//ENDIF

////////////////

//IF injured_ped_14_flag > 0
//	IF IS_CHAR_DEAD injured_ped_14
//		PRINT_NOW A_FAIL3 3000 1
//		GOTO ambulance_failed
//	ENDIF
//		
//	IF ped_time_limit = 0
//		EXPLODE_CHAR_HEAD injured_ped_14
//		REMOVE_CHAR_ELEGANTLY injured_ped_14
//		PRINT_NOW A_FAIL2 3000 1
//		GOTO ambulance_failed
//	ENDIF
//
//	IF injured_ped_14_flag = 3
//		IF IS_CHAR_MALE injured_ped_14
//			ped_sex_flag = 0
//		ELSE
//			ped_sex_flag = 1
//		ENDIF
//		GET_CHAR_COORDINATES injured_ped_14 sound_x sound_y sound_z
//		GOSUB chunk1_ambulance
//	ENDIF
//
//	IF injured_ped_14_flag = 1
//		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_14 10.0 10.0 2.0 0
//			GOSUB chunk2_ambulance
//			IF car_full_flag = 0
//				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_14 players_ambulance
//				injured_ped_14_flag = 2
//			ENDIF
//		ENDIF
//	ENDIF
//
//	IF injured_ped_14_flag = 2
//		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_14 25.0 25.0 0
//			injured_ped_14_flag = 1
//		ENDIF
//	ENDIF	
//
//	IF injured_ped_14_flag = 2
//		IF IS_CHAR_IN_ANY_CAR injured_ped_14 
//			REMOVE_BLIP injured_ped_14_blip
//			GOSUB chunk3_ambulance
//			injured_ped_14_flag = 3
//		ENDIF
//	ENDIF
//
//	IF injured_ped_14_flag = 3
//		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
//			SET_CHAR_OBJ_LEAVE_CAR injured_ped_14 players_ambulance
//			injured_ped_14_flag = 4
//		ENDIF	
//	ENDIF
//
//	IF injured_ped_14_flag = 4
//		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_14	
//			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_14 hospital_door_x hospital_door_y
//			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_14
//			GOSUB chunk4_ambulance
//			injured_ped_14_flag = 0
//		ENDIF
//	ENDIF
//ENDIF

////////////////

//IF injured_ped_15_flag > 0
//	IF IS_CHAR_DEAD injured_ped_15
//		PRINT_NOW A_FAIL3 3000 1
//		GOTO ambulance_failed
//	ENDIF
//		
//	IF ped_time_limit = 0
//		EXPLODE_CHAR_HEAD injured_ped_15
//		REMOVE_CHAR_ELEGANTLY injured_ped_15
//		PRINT_NOW A_FAIL2 3000 1
//		GOTO ambulance_failed
//	ENDIF
//
//	IF injured_ped_15_flag = 3
//		IF IS_CHAR_MALE injured_ped_15
//			ped_sex_flag = 0
//		ELSE
//			ped_sex_flag = 1
//		ENDIF
//		GET_CHAR_COORDINATES injured_ped_15 sound_x sound_y sound_z
//		GOSUB chunk1_ambulance
//	ENDIF
//
//	IF injured_ped_15_flag = 1
//		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player injured_ped_15 10.0 10.0 2.0 0
//			GOSUB chunk2_ambulance
//			IF car_full_flag = 0
//				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER injured_ped_15 players_ambulance
//				injured_ped_15_flag = 2
//			ENDIF
//		ENDIF
//	ENDIF
//
//	IF injured_ped_15_flag = 2
//		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player injured_ped_15 25.0 25.0 0
//			injured_ped_15_flag = 1
//		ENDIF
//	ENDIF	
//
//	IF injured_ped_15_flag = 2
//		IF IS_CHAR_IN_ANY_CAR injured_ped_15 
//			REMOVE_BLIP injured_ped_15_blip
//			GOSUB chunk3_ambulance
//			injured_ped_15_flag = 3
//		ENDIF
//	ENDIF
//
//	IF injured_ped_15_flag = 3
//		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
//			SET_CHAR_OBJ_LEAVE_CAR injured_ped_15 players_ambulance
//			injured_ped_15_flag = 4
//		ENDIF	
//	ENDIF
//
//	IF injured_ped_15_flag = 4
//		IF NOT IS_CHAR_IN_ANY_CAR injured_ped_15	
//			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT injured_ped_15 hospital_door_x hospital_door_y
//			MARK_CHAR_AS_NO_LONGER_NEEDED injured_ped_15
//			GOSUB chunk4_ambulance
//			injured_ped_15_flag = 0
//		ENDIF
//	ENDIF
//ENDIF

/////////////////

IF saved_peds = number_of_injured_peds
	score_am = saved_peds * ambulance_level
	score_am *= 100
	PRINT_WITH_NUMBER_BIG REWARD score_am 6000 6
	total_saved_peds += saved_peds
	IF ambulance_pager_flag = 0
		IF total_saved_peds > 34
			ADD_PAGER_MESSAGE PAGEB13 140 100 1	//"Health delivered to hideout"
			GOSUB progress_counter1
			ambulance_pager_flag = 1
		ENDIF
	ENDIF
	IF ambulance_pager_flag = 1
		IF total_saved_peds > 69
			ADD_PAGER_MESSAGE PAGEB14 140 100 1	//"Adrenaline delivered to hideout"
			GOSUB progress_counter2
			ambulance_pager_flag = 2
		ENDIF
	ENDIF
	saved_peds_this_go += saved_peds
	++ number_of_injured_peds
	saved_peds = 0
	ped_counter = 0
	ADD_SCORE player score_am
	hospital_blip_flag = 0
	REMOVE_BLIP hospital_blip
	REMOVE_BLIP injured_ped_1_blip
	REMOVE_BLIP injured_ped_2_blip
	REMOVE_BLIP injured_ped_3_blip
	REMOVE_BLIP injured_ped_4_blip
	REMOVE_BLIP injured_ped_5_blip
	REMOVE_BLIP injured_ped_6_blip
	REMOVE_BLIP injured_ped_7_blip
	REMOVE_BLIP injured_ped_8_blip
	REMOVE_BLIP injured_ped_9_blip
	REMOVE_BLIP injured_ped_10_blip
	REMOVE_BLIP injured_ped_11_blip
	REMOVE_BLIP injured_ped_12_blip
//	REMOVE_BLIP injured_ped_13_blip
//	REMOVE_BLIP injured_ped_14_blip
//	REMOVE_BLIP injured_ped_15_blip
	REGISTER_AMBULANCE_LEVEL ambulance_level
	++ ambulance_level
	IF ambulance_level = 13
		PRINT_BIG A_COMP1 5000 5 //"Ambulance missions complete!"
		PRINT_BIG A_COMP2 6000 6 //"You will never get tired!"
		ADD_PAGER_MESSAGE A_COMP3 140 100 1	//"Ambulance missions complete! You will never get tired when running!"
		PLAY_MISSION_PASSED_TUNE 1
		SET_PLAYER_NEVER_GETS_TIRED player TRUE
		PLAYER_MADE_PROGRESS 1
		RETURN
	ENDIF
	GOTO mission_root
ENDIF

GOTO ambulance_loop


ambulance_failed:

CLEAR_ONSCREEN_TIMER ped_time_limit
CLEAR_HELP
PRINT_BIG A_FAIL1 5000 5
PRINT_WITH_NUMBER_BIG A_SAVES saved_peds_this_go 6000 6//PEOPLE SAVED: ~1~

hospital_blip_flag = 0
REMOVE_BLIP hospital_blip
REMOVE_BLIP injured_ped_1_blip
REMOVE_BLIP injured_ped_2_blip
REMOVE_BLIP injured_ped_3_blip
REMOVE_BLIP injured_ped_4_blip
REMOVE_BLIP injured_ped_5_blip
REMOVE_BLIP injured_ped_6_blip
REMOVE_BLIP injured_ped_7_blip
REMOVE_BLIP injured_ped_8_blip
REMOVE_BLIP injured_ped_9_blip
REMOVE_BLIP injured_ped_10_blip
REMOVE_BLIP injured_ped_11_blip
REMOVE_BLIP injured_ped_12_blip
//REMOVE_BLIP injured_ped_13_blip
//REMOVE_BLIP injured_ped_14_blip
//REMOVE_BLIP injured_ped_15_blip

SET_WANTED_MULTIPLIER 1.0

flag_player_on_mission = 0
flag_player_on_ambulance_mission = 0
MISSION_HAS_FINISHED
RETURN



//////////////////////////////////////////////////////////////////////
chunk1_ambulance:
	   		
GET_CAR_HEALTH players_ambulance ambulance_health_now
IF ambulance_health_now < ambulance_health_last
	time_drop = ambulance_health_last - ambulance_health_now
	time_drop = time_drop * 50
	ped_time_limit = ped_time_limit - time_drop
	GENERATE_RANDOM_INT_IN_RANGE 0 2 random_scream
	IF ped_sex_flag = 0
		IF random_scream = 0
			ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_INJURED_PED_MALE_OUCH_S
		ELSE
			ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_INJURED_PED_MALE_OUCH_L
		ENDIF
	ELSE
		IF random_scream = 0
			ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_INJURED_PED_FEMALE_OUCH_S
		ELSE
			ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_INJURED_PED_FEMALE_OUCH_L
		ENDIF
	ENDIF
	IF ped_time_limit < 0
		ped_time_limit = 0
	ENDIF		
	ambulance_health_last = ambulance_health_now
ENDIF

RETURN
//////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////
chunk2_ambulance:

GET_NUMBER_OF_PASSENGERS players_ambulance peds_in_car
GET_MAXIMUM_NUMBER_OF_PASSENGERS players_ambulance max_peds_in_car

IF peds_in_car = max_peds_in_car
	PRINT_NOW A_FULL 5000 1 //"I'm not getting in there, its full of injured people."
	car_full_flag = 1
ELSE
	car_full_flag = 0
ENDIF

GET_CAR_HEALTH players_ambulance ambulance_health_last

RETURN
//////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////
chunk3_ambulance:
	   		
IF hospital_blip_flag = 0
	ADD_BLIP_FOR_COORD hospital_x hospital_y hospital_z hospital_blip
	hospital_blip_flag = 1
ENDIF
time_chunk_in_secs = time_chunk / 1000
PRINT_WITH_NUMBER_BIG A_TIME time_chunk_in_secs 6000 6	//+~1~ Seconds
ped_time_limit += time_chunk

RETURN	
//////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////
chunk4_ambulance:

PRINT_BIG A_PASS 3000 5
IF bonus_time_flag = 1
	time_chunk_in_secs = time_chunk / 1000
	PRINT_WITH_NUMBER_BIG A_TIME time_chunk_in_secs 6000 6	//+~1~ Seconds
	STORE_CAR_PLAYER_IS_IN player players_ambulance
	GET_CAR_HEALTH players_ambulance players_ambulance_health
	players_ambulance_health += 110
	SET_CAR_HEALTH players_ambulance players_ambulance_health
	ped_time_limit += time_chunk
	++ bonus_time_flag
ENDIF
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
++ saved_peds
REGISTER_LIFE_SAVED

RETURN
//////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////
progress_counter1:
	PLAYER_MADE_PROGRESS 1
RETURN
//////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
progress_counter2:
	PLAYER_MADE_PROGRESS 1
RETURN
//////////////////////////////////////////////////////////////////////


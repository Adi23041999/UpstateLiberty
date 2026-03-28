MISSION_START

// *****************************************************************************************
// ****************************************Stunt Jump*************************************** 
// *****************************************************************************************

// Variables for mission

VAR_INT	car_player_is_in_hj
VAR_INT flag_takeoff_hj
VAR_INT height_int_hj
VAR_INT flag_wheels_hj
VAR_INT stunt_flags_hj
VAR_INT flag_car_upsidedown_hj
VAR_INT counter_stunt_rolls_hj
VAR_INT	height_decimals_int_hj
VAR_INT	distance_decimals_int_hj
VAR_INT jumpdistance_int_hj
VAR_INT counter_land_on_wheels_hj
VAR_INT counter_wheels_hj
VAR_INT	total_rotation_int
VAR_INT longest_flight_time
VAR_INT got_flight_start
VAR_INT flight_timer_start
VAR_INT flight_timer_end
VAR_INT flight_time	flag_flight_hj
VAR_INT collision_counter
VAR_INT cash_reward cash_reward_temp
VAR_FLOAT height_float_hj
VAR_FLOAT x_float_hj
VAR_FLOAT y_float_hj
VAR_FLOAT z_float_hj
VAR_FLOAT takeoff_x_float_hj
VAR_FLOAT takeoff_y_float_hj
VAR_FLOAT takeoff_z_float_hj
VAR_FLOAT jumpend_x_float_hj
VAR_FLOAT jumpend_y_float_hj
VAR_FLOAT difference_x_float_hj
VAR_FLOAT difference_y_float_hj
VAR_FLOAT sum_difference_xy_hj
VAR_FLOAT jumpdistance_float_hj
VAR_FLOAT heading_hj
VAR_FLOAT temp_float
VAR_FLOAT old_heading_hj
VAR_FLOAT heading_difference
VAR_FLOAT heading_difference_temp
VAR_FLOAT total_rotation

// ****************************************Mission Start************************************

SET_DEATHARREST_STATE OFF
SCRIPT_NAME hj

longest_flight_time = 0

mission_start_hj:

WAIT 0

IF NOT IS_PLAYER_PLAYING player
	GOTO mission_start_hj
ENDIF

IF ARE_ANY_CAR_CHEATS_ACTIVATED
	GOTO mission_start_hj
ENDIF

IF IS_PLAYER_IN_ANY_CAR player

	STORE_CAR_PLAYER_IS_IN_NO_SAVE player car_player_is_in_hj

	IF NOT IS_BOAT car_player_is_in_hj

		IF IS_CAR_IN_AIR_PROPER car_player_is_in_hj
			
			total_rotation_int			= 0
			heading_hj					= 0.0
			flag_wheels_hj				= 0
			counter_land_on_wheels_hj 	= 0
			counter_stunt_rolls_hj 		= 0
			flag_car_upsidedown_hj 		= 0
			counter_wheels_hj 			= 0
			stunt_flags_hj		  		= 0
			flag_takeoff_hj	       		= 0
			height_int_hj          		= 0
			height_float_hj		   		= -100.0
			x_float_hj		       		= 0.0
			y_float_hj			   		= 0.0
			z_float_hj			   		= 0.0
			takeoff_x_float_hj	   		= 0.0
			takeoff_y_float_hj	   		= 0.0
			takeoff_z_float_hj	   		= 0.0
			jumpend_x_float_hj	   		= 0.0
			jumpend_y_float_hj	   		= 0.0
			difference_x_float_hj  		= 0.0
			difference_y_float_hj  		= 0.0
			sum_difference_xy_hj   		= 0.0
			jumpdistance_float_hj  		= 0.0
			jumpdistance_int_hj	  		= 0
			distance_decimals_int_hj	= 0
			height_decimals_int_hj		= 0
			temp_float					= 0.0
			heading_difference			= 0.0
			total_rotation				= 0.0
			heading_difference_temp		= 0.0
			old_heading_hj				= 0.0
			got_flight_start			= 0
			flight_timer_start			= 0
			flight_timer_end			= 0
			flight_time					= 0
			flag_flight_hj				= 0
			collision_counter			= 0

			IF IS_CAR_MODEL car_player_is_in_hj PLANE_DODO
				GOTO dodo_flight_time
			ENDIF

	    	WHILE IS_CAR_IN_AIR_PROPER car_player_is_in_hj
			OR collision_counter < 10

				++ collision_counter

	    		GET_CAR_COORDINATES car_player_is_in_hj x_float_hj y_float_hj z_float_hj
	    	
				old_heading_hj = heading_hj
				
	    		IF flag_takeoff_hj = 0
	    			GET_CAR_HEADING car_player_is_in_hj old_heading_hj
	    			takeoff_x_float_hj = x_float_hj
	    			takeoff_y_float_hj = y_float_hj
	    			takeoff_z_float_hj = z_float_hj
	    			flag_takeoff_hj = 1
	    		ENDIF

	    		WAIT 0

				IF IS_CAR_DEAD car_player_is_in_hj
					GOTO mission_start_hj
				ENDIF

	    		IF NOT IS_PLAYER_PLAYING player
	    			GOTO mission_start_hj
	    		ENDIF 			
	    		
	    		IF NOT IS_PLAYER_IN_ANY_CAR player
	    			GOTO mission_start_hj
	    		ENDIF

	    		IF NOT IS_CAR_UPRIGHT car_player_is_in_hj
	    		AND flag_car_upsidedown_hj = 0
	    			flag_car_upsidedown_hj = 1
	    		ENDIF

	    		IF IS_CAR_UPRIGHT car_player_is_in_hj
	    		AND flag_car_upsidedown_hj = 1
	    			++ counter_stunt_rolls_hj
	    			flag_car_upsidedown_hj = 0
	    		ENDIF

	    		GET_CAR_HEADING car_player_is_in_hj heading_hj

				heading_difference = heading_hj - old_heading_hj

				IF heading_difference > 180.0
					heading_difference_temp = heading_difference     
					heading_difference = 360.0 - heading_difference_temp
				ELSE
					IF heading_difference < -180.0
						heading_difference_temp = heading_difference     
						heading_difference = 360.0 + heading_difference_temp
					ENDIF
				ENDIF

				IF heading_difference < 0.0
					heading_difference_temp = heading_difference
					heading_difference = 0.0 - heading_difference_temp
				ENDIF

				total_rotation = total_rotation + heading_difference

				total_rotation_int =# total_rotation 
				
	    		IF z_float_hj > height_float_hj
	    			height_float_hj = z_float_hj	 
	    		ENDIF
	    	
	    		z_float_hj = 0.0
	    			 
	    	ENDWHILE

		ELSE
			GOTO mission_start_hj
		ENDIF
	ELSE
		GOTO mission_start_hj
	ENDIF
ELSE
	GOTO mission_start_hj
ENDIF 

IF flag_takeoff_hj = 1
	GET_CAR_COORDINATES car_player_is_in_hj jumpend_x_float_hj jumpend_y_float_hj temp_float
		
	WHILE counter_land_on_wheels_hj < 90
		
		IF IS_CAR_DEAD car_player_is_in_hj
			GOTO mission_start_hj
		ELSE
			IF NOT IS_CAR_IN_AIR car_player_is_in_hj
				++ counter_wheels_hj
			ENDIF
		ENDIF
		
		WAIT 0

		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_start_hj
		ENDIF

		++ counter_land_on_wheels_hj

	ENDWHILE

	counter_land_on_wheels_hj = 0

  	difference_x_float_hj = takeoff_x_float_hj - jumpend_x_float_hj
	difference_y_float_hj = takeoff_y_float_hj - jumpend_y_float_hj
	difference_x_float_hj = difference_x_float_hj * difference_x_float_hj
	difference_y_float_hj = difference_y_float_hj * difference_y_float_hj
	sum_difference_xy_hj = difference_x_float_hj + difference_y_float_hj
	SQRT sum_difference_xy_hj jumpdistance_float_hj
	REGISTER_JUMP_DISTANCE jumpdistance_float_hj
	jumpdistance_int_hj =# jumpdistance_float_hj
	height_float_hj = height_float_hj - takeoff_z_float_hj
	REGISTER_JUMP_HEIGHT height_float_hj
	height_int_hj =# height_float_hj
	temp_float =# jumpdistance_int_hj
	jumpdistance_float_hj = jumpdistance_float_hj - temp_float
	temp_float = jumpdistance_float_hj * 100.0
	distance_decimals_int_hj =# temp_float
	temp_float =# height_int_hj
	height_float_hj = height_float_hj - temp_float
	temp_float = height_float_hj * 100.0
	height_decimals_int_hj =# temp_float
	REGISTER_JUMP_FLIPS counter_stunt_rolls_hj
	REGISTER_JUMP_SPINS total_rotation_int
ENDIF

IF height_float_hj > 4.0	   	//4 METERS HIGH
	++ stunt_flags_hj
ENDIF

IF jumpdistance_int_hj > 30    	//30 METERS LONG
	++ stunt_flags_hj
ENDIF

IF counter_stunt_rolls_hj > 0  	//1 ROLLS/FLIPS IN MID AIR
	++ stunt_flags_hj
ENDIF

IF total_rotation_int > 360    	//360 SPIN IN MID AIR
	++ stunt_flags_hj
ENDIF

IF counter_wheels_hj > 60 		//LAND ON WHEELS
   	flag_wheels_hj = 1
ENDIF

IF stunt_flags_hj > 0

	cash_reward = counter_stunt_rolls_hj * 180
	cash_reward += total_rotation_int
	cash_reward_temp = jumpdistance_int_hj * 6
	cash_reward += cash_reward_temp
	cash_reward_temp = height_int_hj * 45
	cash_reward += cash_reward_temp
	IF flag_wheels_hj = 1
		cash_reward *= 2
	ENDIF
	cash_reward *= stunt_flags_hj
	cash_reward /= 3
	ADD_SCORE player cash_reward

    IF stunt_flags_hj = 1
    AND flag_wheels_hj = 0
    	PRINT_WITH_NUMBER HJ_IS cash_reward 2000 1 //"INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 1
    ENDIF

    IF stunt_flags_hj = 1
    AND flag_wheels_hj = 1
    	PRINT_WITH_NUMBER HJ_PIS cash_reward 2000 1 //"PERFECT INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 2
    ENDIF

    IF stunt_flags_hj = 2
    AND flag_wheels_hj = 0
    	PRINT_WITH_NUMBER HJ_DIS cash_reward 2000 1 //"DOUBLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 3
    ENDIF

    IF stunt_flags_hj = 2
    AND flag_wheels_hj = 1
    	PRINT_WITH_NUMBER HJ_PDIS cash_reward 2000 1 //"PERFECT DOUBLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 4
    ENDIF

    IF stunt_flags_hj = 3
    AND flag_wheels_hj = 0
    	PRINT_WITH_NUMBER HJ_TIS cash_reward 2000 1 //"TRIPLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 5
    ENDIF

    IF stunt_flags_hj = 3
    AND flag_wheels_hj = 1
    	PRINT_WITH_NUMBER HJ_PTIS cash_reward 2000 1 //"PERFECT TRIPLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 6
    ENDIF

    IF stunt_flags_hj = 4
    AND flag_wheels_hj = 0
    	PRINT_WITH_NUMBER HJ_QIS cash_reward 2000 1 //"QUADRUPLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 7
    ENDIF

    IF stunt_flags_hj = 4
    AND flag_wheels_hj = 1
    	PRINT_WITH_NUMBER HJ_PQIS cash_reward 3000 1 //"PERFECT QUADRUPLE INSANE STUNT BONUS"
		REGISTER_JUMP_STUNT 8
    ENDIF

	IF ARE_MEASUREMENTS_IN_METRES
	    IF flag_wheels_hj = 1
	    	PRINT_WITH_6_NUMBERS HJSTATW jumpdistance_int_hj distance_decimals_int_hj height_int_hj height_decimals_int_hj counter_stunt_rolls_hj total_rotation_int 5000 5
	    ELSE
	    	PRINT_WITH_6_NUMBERS HJSTAT jumpdistance_int_hj distance_decimals_int_hj height_int_hj height_decimals_int_hj counter_stunt_rolls_hj total_rotation_int 5000 5
		ENDIF
	ELSE
		CONVERT_METRES_TO_FEET_INT jumpdistance_int_hj jumpdistance_int_hj
		CONVERT_METRES_TO_FEET_INT height_int_hj height_int_hj
	    IF flag_wheels_hj = 1
	    	PRINT_WITH_4_NUMBERS HJSTAWF jumpdistance_int_hj height_int_hj counter_stunt_rolls_hj total_rotation_int 5000 5
	    ELSE
	    	PRINT_WITH_4_NUMBERS HJSTATF jumpdistance_int_hj height_int_hj counter_stunt_rolls_hj total_rotation_int 5000 5
		ENDIF
	ENDIF

	//ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

ENDIF

GOTO mission_start_hj

dodo_flight_time:

WHILE IS_CAR_IN_AIR_PROPER car_player_is_in_hj

	IF got_flight_start	= 0
		GET_GAME_TIMER flight_timer_start
		flag_flight_hj = 1
		got_flight_start = 1
	ENDIF

	IF IS_CAR_IN_WATER car_player_is_in_hj
		GOTO cessna_fight_bit
	ENDIF

	WAIT 0

	IF IS_CAR_DEAD car_player_is_in_hj
		GOTO mission_start_hj
	ENDIF

	IF NOT IS_PLAYER_PLAYING player
		GOTO mission_start_hj
	ENDIF 			
    		
	IF NOT IS_PLAYER_IN_ANY_CAR player
		GOTO mission_start_hj
	ENDIF

ENDWHILE

cessna_fight_bit:

IF flag_flight_hj = 1
	GET_GAME_TIMER flight_timer_end

	flight_time = flight_timer_end - flight_timer_start

	flight_time = flight_time / 1000

	IF flight_time > 1
		IF flight_time > longest_flight_time
			longest_flight_time = flight_time
		ENDIF

		PRINT_WITH_NUMBER_NOW DODO_FT flight_time 5000 1

		REGISTER_LONGEST_DODO_FLIGHT flight_time
	ENDIF
ENDIF

GOTO mission_start_hj

MISSION_END
 
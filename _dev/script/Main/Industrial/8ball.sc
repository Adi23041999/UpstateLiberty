MISSION_START 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **************************************8Ball Mission**************************************
// **************************************Luigi's Girls**************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME eight


// Mission start stuff

GOSUB mission_start_eightball

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_eightball_failed
ENDIF

GOSUB mission_cleanup_eightball

MISSION_END


// Variables for mission


VAR_INT radar_blip_car1_eightball

VAR_INT radar_blip_coord1_eightball

VAR_INT radar_blip_coord2_eightball

VAR_INT eightball 	

VAR_INT car_eightball  //Any car the player might get into

VAR_INT van_8ball //Car that I create

VAR_INT flag_blip_on_eightball

VAR_INT flag_player_got_cops_message_eightball

VAR_INT flag_player_got_car_message1_eightball

VAR_INT radar_blip_ped1_eightball

VAR_INT flag_player_in_area

VAR_INT flag_eightball_in_area


// Luigi variables for missions

VAR_INT radar_blip_coord1_lm1

VAR_INT radar_blip_ped1_lm1

VAR_INT radar_blip_ped2_lm1

VAR_INT girl1_lm1

VAR_INT car_lm1

VAR_INT flag_player_had_car_message_lm1

VAR_INT flag_player_not_in_car_message_lm1

VAR_INT no_of_passengers_car_lm1

VAR_INT flag_girl1_in_car_lm1

VAR_INT passenger_count_lm1

VAR_INT total_space_in_car_lm1

VAR_INT flag_blip_on_girl1_lm1

VAR_INT flag_coord_blip_on

VAR_INT flag_luigi_coord1_blip_created

VAR_INT flag_luigi_ped1_blip_created

VAR_INT flag_girl1_in_group_lm1

VAR_INT flag_player_had_vehicle_message_lm1

VAR_INT flag_player_in_area_lm1

VAR_INT flag_eightball_in_area_lm1

VAR_INT flag_help_8ball1

VAR_INT flag_help_8ball2

// car variables for restart

VAR_FLOAT car_8ball_x

VAR_FLOAT car_8ball_y

VAR_FLOAT car_8ball_z

VAR_FLOAT car_8ball_heading

VAR_INT flag_car_message_8ball

VAR_INT cop_car1_8ball

VAR_INT cop_car2_8ball

VAR_INT cop1_8ball

VAR_INT cop2_8ball

VAR_INT flag_brake_message  // Brake message

VAR_INT flag_hbrake_message  // Handbrake message

VAR_INT flag_look2_8ball  // Look right message

VAR_INT flag_look3_8ball // Look behind message

VAR_INT flag_misty_stop  // Misty message to tell player to stop and let her in the car

VAR_INT flag_player_had_camera_message_8ball // Tells player how to change camera modes

VAR_INT car_colour1_8ball

VAR_INT	car_colour2_8ball

VAR_INT flag_girl_in_group_lm1

VAR_INT radar_blip_car1_lm1

VAR_INT flag_timer_stopped_flashing_8ball  // Stops the radar flashing

VAR_INT fire_sound_8ball 

// ***************************************Mission Start*************************************

mission_start_eightball:

flag_player_on_mission = 1

flag_player_on_eightball_mission = 1

REGISTER_MISSION_GIVEN

FORCE_WEATHER_NOW WEATHER_CLOUDY

SET_TIME_OF_DAY 4 0 

LOAD_SCENE 807.0 -937.0 36.6  // THIS MIGHT HAVE TO COME OUT!!!!!!!!!!!!!!!!!!!!!!!!!!!

WAIT 0

flag_blip_on_eightball = 0

flag_player_got_cops_message_eightball = 0

flag_player_got_car_message1_eightball = 0

flag_player_in_area = 0 

flag_eightball_in_area = 0

// luigi variables

flag_player_had_car_message_lm1 = 0

flag_player_not_in_car_message_lm1 = 0

no_of_passengers_car_lm1 = 0

flag_girl1_in_car_lm1 = 0

passenger_count_lm1 = 0

total_space_in_car_lm1 = 0

flag_blip_on_girl1_lm1 = 0

flag_coord_blip_on = 0

blob_flag = 1

// luigi blip stuff

flag_luigi_coord1_blip_created = 0
flag_luigi_ped1_blip_created = 0
flag_girl1_in_group_lm1 = 0
flag_player_had_vehicle_message_lm1 = 0

flag_player_in_area_lm1 = 0

flag_eightball_in_area_lm1 = 0

flag_help_8ball1 = 0

flag_help_8ball2 = 0

flag_car_message_8ball = 0

flag_brake_message = 0

flag_hbrake_message = 0

flag_look2_8ball = 0

flag_look3_8ball = 0

flag_misty_stop = 0

flag_player_had_camera_message_8ball = 0

flag_girl_in_group_lm1 = 0

flag_timer_stopped_flashing_8ball = 0

{	
IF flag_reached_hideout = 0

	REQUEST_MODEL CAR_KURUMA

	LOAD_SPECIAL_CHARACTER 1 eight
	
	LOAD_ALL_MODELS_NOW

	car_8ball_x = 0.0

	car_8ball_y = 0.0

	car_8ball_z = 0.0

	car_8ball_heading = 0.0

	car_colour1_8ball = 0

	car_colour2_8ball = 0
				
ELSE
	
	GOTO hideout_reached

ENDIF

IF flag_bridge_created_8ball = 0
	CREATE_OBJECT_NO_OFFSET bridgefuka 715.746 -937.908 40.194 damagea
	DONT_REMOVE_OBJECT damagea

	CREATE_OBJECT_NO_OFFSET bridgefukb 787.835 -939.24 38.971 damageb
	DONT_REMOVE_OBJECT damageb
	flag_bridge_created_8ball = 1
ENDIF

SET_PLAYER_HEADING player 180.0

CREATE_CAR CAR_KURUMA 812.0131 -945.5528 35.7889 car_eightball  // new Aaron position

CHANGE_CAR_COLOUR car_eightball 58 1

SET_CAR_HEADING car_eightball 262.3871

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 811.90 -942.47 -100.0 eightball  // New Aaron position

SET_ANIM_GROUP_FOR_CHAR eightball ANIM_GANG2_PED

CLEAR_CHAR_THREAT_SEARCH eightball

TURN_CHAR_TO_FACE_COORD eightball 811.90 -939.95 35.8  // New Aaron position

CHAR_LOOK_AT_PLAYER_ALWAYS eightball player

OVERRIDE_NEXT_RESTART 811.90 -939.95 35.8 180.0 //Restarts at the bridge

SET_OBJECT_HEADING playersdoor 0.0

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

ADD_PARTICLE_EFFECT 4 791.661 -936.916 38.313 FALSE //SMOKE ON CARS
ADD_PARTICLE_EFFECT 4 788.337 -938.467 38.073 FALSE
ADD_PARTICLE_EFFECT 4 786.493 -942.398 39.8   FALSE

ADD_PARTICLE_EFFECT 10 783.572 -938.549 38.448 FALSE //FIRE ON CARS
ADD_PARTICLE_EFFECT 10 790.537 -935.67  38.005 FALSE
ADD_PARTICLE_EFFECT 10 789.295 -938.882 38.127 FALSE

REMOVE_SOUND fire_sound_8ball

ADD_CONTINUOUS_SOUND 790.537 -935.67  38.005 SOUND_PRETEND_FIRE_LOOP fire_sound_8ball

SET_POLICE_IGNORE_PLAYER player ON

SET_FIXED_CAMERA_POSITION 785.0 -936.77 39.75 0.0 0.0 0.0 // New position

POINT_CAMERA_AT_CHAR eightball fixed jump_cut

LOAD_MISSION_AUDIO LIB_A1

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
	
SET_FADING_COLOUR 0 0 0

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

ENDWHILE

WAIT 2000

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

SET_FIXED_CAMERA_POSITION 804.5746 -933.048 39.9828 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 805.1921 -933.7454 39.6193 JUMP_CUT

PRINT_BIG ( EBAL ) 15000 2 //"Give me Liberty"

PLAY_MISSION_AUDIO

PRINT_NOW ( EBAL_A ) 5000 1 //"I know a place on the edge of the Red Light District where we can lay low,

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( EBAL_A )

LOAD_MISSION_AUDIO LIB_A2

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO

PRINT_NOW ( EBAL_A1 ) 5000 1 //"but my hands are badly burned so you'll have to drive.""

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_A1 )
ENDIF

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

STOP_CHAR_LOOKING eightball

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER eightball car_eightball

WHILE NOT IS_CHAR_IN_CAR eightball car_eightball

	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED
		CLEAR_THIS_PRINT ( EBAL_A1 )
	ENDIF

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ENDIF

   	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
      	
ENDWHILE

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_A1 )
ENDIF

// This will tune the radio to HEAD RADIO

IF flag_done_radio_8ball = 0
	SET_RADIO_CHANNEL HEAD_RADIO 0
	flag_done_radio_8ball = 1
ELSE
   SET_RADIO_CHANNEL HEAD_RADIO -1
ENDIF

SET_CHAR_CANT_BE_DRAGGED_OUT eightball TRUE

SWITCH_WIDESCREEN OFF

RESTORE_CAMERA

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball

GOSUB car_gen_start_8ball  // This turns on all the car generators in the level

WAIT 500

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_A1 )
ENDIF

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

// gives the player the help message for entering cars

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	PRINT_HELP ( EBAL_1 ) //"Press Triangle to enter a vehicle." 
ENDIF

IF controlmode = 1
	PRINT_HELP ( EBAL_1 ) //"Press Triangle to enter a vehicle."
ENDIF

IF controlmode = 2
	PRINT_HELP ( EBAL_1B ) //"Press Triangle to enter a vehicle."
ENDIF

IF controlmode = 3
	PRINT_HELP ( EBAL_1 ) //"Press Triangle to enter a vehicle."
ENDIF

timerb = 0 // Timer for police wanted level stuff

WAIT 3000

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF
		
// Waiting for the player to get into the car

WHILE NOT IS_PLAYER_IN_CAR player car_eightball
OR NOT IS_CHAR_IN_CAR eightball car_eightball

	WAIT 0

	IF timerb < 120000  // 2 mins
		CLEAR_WANTED_LEVEL player
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF
								
ENDWHILE

// creates two cops cars that drive onto the bridge

CREATE_CAR car_police 1083.2 -945.0 13.8 cop_car1_8ball

CREATE_CHAR_INSIDE_CAR cop_car1_8ball PEDTYPE_CIVMALE PED_COP cop1_8ball

CLEAR_CHAR_THREAT_SEARCH cop1_8ball

SET_CAR_HEADING cop_car1_8ball 90.0

SWITCH_CAR_SIREN cop_car1_8ball ON

SET_CAR_DRIVING_STYLE cop_car1_8ball 2

SET_CAR_CRUISE_SPEED  cop_car1_8ball 20.0

CAR_GOTO_COORDINATES cop_car1_8ball 713.9 -916.7 42.0

CREATE_CAR car_police 1074.1 -946.7 13.8 cop_car2_8ball

CREATE_CHAR_INSIDE_CAR cop_car2_8ball PEDTYPE_CIVMALE PED_COP cop2_8ball

CLEAR_CHAR_THREAT_SEARCH cop2_8ball

SET_CAR_HEADING cop_car2_8ball 90.0

SWITCH_CAR_SIREN cop_car2_8ball ON

SET_CAR_DRIVING_STYLE cop_car2_8ball 2

SET_CAR_CRUISE_SPEED cop_car2_8ball 20.0

CAR_GOTO_COORDINATES cop_car2_8ball 718.7 -922.2 42.0 

REMOVE_BLIP radar_blip_car1_eightball

// Accelertation help messages

WAIT 500

IF timerb < 120000  // 2 mins
	CLEAR_WANTED_LEVEL player
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	PRINT_HELP ( HELP4_A ) //"Press the / button to accelerate."
ENDIF

IF controlmode = 1
	PRINT_HELP ( HELP4_A ) //"Press the / button to accelerate."
ENDIF

IF controlmode = 2
	PRINT_HELP ( HELP4_A ) //"Press the / button to accelerate."
ENDIF

IF controlmode = 3
	PRINT_HELP ( HELP4_D ) //"Press the / button to accelerate."
ENDIF

ADD_BLIP_FOR_COORD 875.0 -309.0 -100.0 radar_blip_coord1_eightball

timera = 0

blob_flag = 1

IF timerb < 120000  // 2 mins
	CLEAR_WANTED_LEVEL player
ENDIF

LOAD_MISSION_AUDIO LIB_A


timera = 0

WHILE timera < 10000

	WAIT 0

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF
		   	   	
	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord1_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
				ADD_BLIP_FOR_COORD 875.0 -309.0 -100.0 radar_blip_coord1_eightball
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   
	
	IF LOCATE_PLAYER_IN_CAR_2D player 875.0 -309.0 20.0 20.0 FALSE
	AND IS_PLAYER_IN_CAR player car_eightball
	AND flag_help_8ball1 = 0
		PRINT_HELP ( HELP1 ) //Stop in the centre of the red dome."
		flag_help_8ball1 = 1
	ENDIF
	
ENDWHILE

PRINT_HELP ( EBAL_3 ) //"Follow the "blip" to find the hideout!"

FLASH_HUD_OBJECT HUD_FLASH_RADAR

timera = 0

// waiting for the player to get to Luigi's

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 879.4 -303.4 7.3 870.1 -311.7 10.0 blob_flag
OR NOT IS_CHAR_STOPPED_IN_AREA_IN_CAR_3D eightball 879.4 -303.4 7.3 870.1 -311.7 10.0 FALSE
OR NOT IS_PLAYER_SITTING_IN_CAR player car_eightball
OR NOT IS_CHAR_SITTING_IN_CAR eightball car_eightball
OR NOT HAS_MISSION_AUDIO_LOADED 

 	WAIT 0

	IF timerb < 120000  // 2 mins
		CLEAR_WANTED_LEVEL player
	ENDIF

	IF flag_timer_stopped_flashing_8ball = 0

		IF timera > 4000
			FLASH_HUD_OBJECT -1
			flag_timer_stopped_flashing_8ball = 1
		ENDIF

	ENDIF
	
	IF flag_brake_message = 0

		IF timera >= 10000
			
			GET_CONTROLLER_MODE controlmode

			IF controlmode = 0
				PRINT_HELP ( HELP5_A ) //"Press the ^ button to brake, when stopped this will make the vehicle reverse."
			ENDIF

			IF controlmode = 1
				PRINT_HELP ( HELP5_A ) //"Press the ^ button to brake, when stopped this will make the vehicle reverse."
			ENDIF

			IF controlmode = 2
				PRINT_HELP ( HELP5_A ) //"Press the ^ button to brake, when stopped this will make the vehicle reverse."
			ENDIF

			IF controlmode = 3
				PRINT_HELP ( HELP5_D ) //"Press the ^ button to brake, when stopped this will make the vehicle reverse."
			ENDIF

			flag_brake_message = 1
			timera = 0

		ENDIF

	ENDIF

	IF timera > 10000
			  		 
		IF flag_hbrake_message = 0
	 
			GET_CONTROLLER_MODE controlmode

			IF controlmode = 0
				PRINT_HELP ( HELP6_A ) //"Press the R1 button to apply the vehicle's handbrake."
			ENDIF

			IF controlmode = 1
				PRINT_HELP ( HELP6_A ) //"Press the R1 button to apply the vehicle's handbrake."
			ENDIF

			IF controlmode = 2
				PRINT_HELP ( HELP6_C ) //"Press the R1 button to apply the vehicle's handbrake."
			ENDIF

			IF controlmode = 3
				PRINT_HELP ( HELP6_D ) //"Press the R1 button to apply the vehicle's handbrake."
			ENDIF

			flag_hbrake_message = 1
			
		ENDIF
					
	ENDIF
		
	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF
		   	   	
	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord1_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
				ADD_BLIP_FOR_COORD 875.0 -309.0 -100.0 radar_blip_coord1_eightball
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   
	
	IF LOCATE_PLAYER_IN_CAR_2D player 875.0 -309.0 20.0 20.0 FALSE
	AND IS_PLAYER_IN_CAR player car_eightball
	AND flag_help_8ball1 = 0
		PRINT_HELP ( HELP1 ) //Stop in the centre of the red dome."
		flag_help_8ball1 = 1
	ENDIF
            	 	   
ENDWHILE

CLEAR_HELP

REMOVE_BLIP radar_blip_coord1_eightball

// ******************************Player and 8ball are at base scripted cutscene*************

SWITCH_WIDESCREEN ON

CLEAR_WANTED_LEVEL player

SET_POLICE_IGNORE_PLAYER player ON

SET_PLAYER_CONTROL player OFF

IF NOT IS_CAR_DEAD cop_car1_8ball
	DELETE_CAR cop_car1_8ball
ENDIF

IF NOT IS_CAR_DEAD cop_car2_8ball
	DELETE_CAR cop_car2_8ball
ENDIF


CLEAR_AREA 886.8 -310.1 -100.0 2.0 TRUE

GET_CAR_COORDINATES car_eightball car_8ball_x car_8ball_y car_8ball_z

GET_CAR_HEADING car_eightball car_8ball_heading

GET_CAR_COLOURS car_eightball car_colour1_8ball car_colour2_8ball 

WHILE NOT ROTATE_OBJECT playersdoor 210.0 10.0 FALSE

	WAIT 0

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
			
	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF

ENDWHILE

CLEAR_AREA 889.7 -308.2 8.6 3.0 TRUE  // This should remove any stuff that is in the way for the cut-scene 

GET_PLAYER_CHAR player script_controlled_player

CLEAR_CHAR_THREAT_SEARCH script_controlled_player
	 	  
SET_CHAR_OBJ_LEAVE_CAR eightball car_eightball

WHILE IS_CHAR_IN_CAR eightball car_eightball 

	WAIT 0

	IF IS_CHAR_DEAD eightball
	  	 PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
	   
ENDWHILE

PLAY_MISSION_AUDIO

PRINT_NOW ( EBAL_B ) 7000 1 //"This is the place! Let's get off the street and find a change of clothes!"

SET_CHAR_OBJ_RUN_TO_COORD eightball 892.7 -308.6

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_B )
ENDIF

WAIT 1000

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_B )
ENDIF

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

IF HAS_MISSION_AUDIO_FINISHED
	CLEAR_THIS_PRINT ( EBAL_B )
ENDIF
 
SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_eightball
							
CLEAR_AREA 868.63 -311.7 8.3 1.0 TRUE

IF IS_AREA_OCCUPIED 870.4 -309.9 6.0 865.2 -314.7 12.0 FALSE TRUE TRUE TRUE TRUE
	SET_FIXED_CAMERA_POSITION 848.265 -295.26 19.136 0.0 0.0 0.0  //high camera that points to the water tower
	POINT_CAMERA_AT_POINT 849.11 -295.79 19.18 jump_cut
ELSE 
	SET_FIXED_CAMERA_POSITION 868.63 -311.7 8.3 0.0 0.0 0.0  //low new camera that points to the save house
	POINT_CAMERA_AT_POINT 869.59 -311.53 8.53 jump_cut
ENDIF

WHILE IS_CHAR_IN_CAR script_controlled_player car_eightball
			
	WAIT 0

	IF HAS_MISSION_AUDIO_FINISHED
    	CLEAR_THIS_PRINT ( EBAL_B )
    ENDIF

	IF IS_CHAR_DEAD eightball
	  	 PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
	   
ENDWHILE

//Make player walk into the doors and get a change of clothes

SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 892.4 -308.5

timerb = 0

WHILE NOT flag_player_in_area = 2 
OR NOT flag_eightball_in_area = 2

	WAIT 0
	
	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD eightball
	  	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	GOTO mission_eightball_failed
	ENDIF
			
	IF flag_player_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D script_controlled_player 892.4 -308.5 0.5 0.5 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 892.4 -305.6
			flag_player_in_area = 1
		ENDIF

	ENDIF
	

	IF flag_eightball_in_area = 0

		IF LOCATE_CHAR_ON_FOOT_2D eightball 892.7 -308.6 0.5 0.5 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD eightball 894.2 -304.3
			flag_eightball_in_area = 1
		ENDIF
	
	ENDIF
	
	IF flag_player_in_area = 1

		IF LOCATE_CHAR_ON_FOOT_2D script_controlled_player 892.4 -305.6 0.5 0.5 FALSE
			flag_player_in_area = 2
		ENDIF
	
	ENDIF

	IF flag_eightball_in_area = 1

		IF LOCATE_CHAR_ON_FOOT_2D eightball 894.2 -304.3 0.5 0.5 FALSE
			flag_eightball_in_area = 2
		ENDIF
	
	ENDIF

	IF timerb >= 10000

		IF NOT flag_player_in_area = 2
		OR NOT flag_eightball_in_area = 2
			SET_PLAYER_COORDINATES player 892.4 -305.6 7.7
			CHAR_SET_IDLE script_controlled_player
			SET_CHAR_COORDINATES eightball 894.2 -304.3 7.7
			CHAR_SET_IDLE eightball
			GOTO mission_bloke_stuck_8ball
		ENDIF
		
	ENDIF
				  	
ENDWHILE

mission_bloke_stuck_8ball:

SET_FIXED_CAMERA_POSITION 886.8 -310.1 9.9 0.0 0.0 0.0 

POINT_CAMERA_AT_POINT 887.7 -309.8 9.8 JUMP_CUT

CHAR_SET_IDLE eightball

SET_CHAR_OBJ_NO_OBJ script_controlled_player

PRINT_HELP ( S_PROMP ) //"When not on a mission you can save your game here, this will also advance time six hours."

WAIT 4000

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF
	
IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF


PRINT_HELP ( S_PROM2 ) //"The garage next door can store one car."

POINT_CAMERA_AT_POINT 887.8 -310.5 9.7 interpolation

SET_PLAYER_COORDINATES player 895.9 -311.4 7.7

SET_CHAR_COORDINATES eightball 884.3 -309.2 7.6

// Clothes change

//8-BAll change
		   
IF NOT IS_CHAR_DEAD eightball
	
	UNDRESS_CHAR eightball eight2
	WHILE NOT HAS_MODEL_LOADED PED_SPECIAL1 
	
		WAIT 0

		IF IS_CAR_DEAD car_eightball
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ELSE

			IF IS_CAR_UPSIDEDOWN car_eightball
			AND IS_CAR_STOPPED car_eightball 
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_eightball_failed
   			ENDIF

		ENDIF
				
	ENDWHILE
	
	IF NOT IS_CHAR_DEAD eightball
		DRESS_CHAR eightball
	ENDIF

ENDIF

//Player change

IF NOT IS_CHAR_DEAD script_controlled_player
	
	UNDRESS_CHAR script_controlled_player player
	WHILE NOT HAS_MODEL_LOADED PED_PLAYER 
	
		WAIT 0

		IF IS_CAR_DEAD car_eightball
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ELSE

			IF IS_CAR_UPSIDEDOWN car_eightball
			AND IS_CAR_STOPPED car_eightball 
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_eightball_failed
   			ENDIF

		ENDIF
		
	ENDWHILE
	
	IF NOT IS_CHAR_DEAD script_controlled_player
		DRESS_CHAR script_controlled_player
	ENDIF
ENDIF

WAIT 3000

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF
	
IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

SET_PLAYER_COORDINATES player 883.5 -308.2 7.6

RELEASE_WEATHER
 
SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER eightball car_eightball

WAIT 1500

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

IF IS_CAR_DEAD car_eightball

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
		GOTO mission_eightball_failed
	ELSE
		PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   		GOTO mission_eightball_failed
   	ENDIF

ELSE

	IF IS_CAR_UPSIDEDOWN car_eightball
	AND IS_CAR_STOPPED car_eightball 
		PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
		GOTO mission_eightball_failed
   	ENDIF

ENDIF

SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER script_controlled_player car_eightball

CLEAR_AREA 868.63 -311.7 8.3 1.0 TRUE 

IF IS_AREA_OCCUPIED 870.4 -309.9 6.0 865.2 -314.7 12.0 FALSE TRUE TRUE TRUE TRUE
	SET_FIXED_CAMERA_POSITION 848.265 -295.26 19.136 0.0 0.0 0.0  //high camera that points to the water tower
	POINT_CAMERA_AT_POINT 849.11 -295.79 19.18 jump_cut
ELSE 
	SET_FIXED_CAMERA_POSITION 868.63 -311.7 8.3 0.0 0.0 0.0  //low new camera that points to the save house
	POINT_CAMERA_AT_POINT 869.59 -311.53 8.53 jump_cut
ENDIF

CLEAR_HELP

WHILE NOT IS_PLAYER_IN_CAR player car_eightball
OR NOT IS_CHAR_IN_CAR eightball car_eightball

	WAIT 0

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

	  	IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

	IF IS_CHAR_DEAD eightball
	  	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	GOTO mission_eightball_failed
	ENDIF

ENDWHILE

WHILE NOT ROTATE_OBJECT playersdoor 0.0 10.0 FALSE

	WAIT 0

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF

ENDWHILE

RESTORE_CAMERA_JUMPCUT

SET_CAMERA_IN_FRONT_OF_PLAYER

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

//ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball

blob_flag = 1

// *************Restart function for 8ball and the player at players hideout***************

hideout_reached:

IF flag_reached_hideout = 1

	SWITCH_WIDESCREEN ON

	SET_PLAYER_CONTROL player OFF

	SET_POLICE_IGNORE_PLAYER player ON
	
	SET_PLAYER_HEADING player 90.0
	
	CLEAR_AREA 868.63 -311.7 8.3 1.0 TRUE 

	IF IS_AREA_OCCUPIED 870.4 -309.9 6.0 865.2 -314.7 12.0 FALSE TRUE TRUE TRUE TRUE
		SET_FIXED_CAMERA_POSITION 848.265 -295.26 19.136 0.0 0.0 0.0  //high camera that points to the water tower
		POINT_CAMERA_AT_POINT 849.11 -295.79 19.18 jump_cut
	ELSE 
		SET_FIXED_CAMERA_POSITION 868.63 -311.7 8.3 0.0 0.0 0.0  //low new camera that points to the save house
		POINT_CAMERA_AT_POINT 869.59 -311.53 8.53 jump_cut
	ENDIF
	
	SET_OBJECT_HEADING playersdoor 0.0

	LOAD_SPECIAL_CHARACTER 1 eight2
	
	REQUEST_MODEL CAR_KURUMA

	LOAD_ALL_MODELS_NOW
        		
	//CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 887.2 -308.4 7.6 eightball

	 CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 884.3 -309.2 7.6 eightball

   	SET_ANIM_GROUP_FOR_CHAR eightball ANIM_GANG2_PED
	
	SET_CHAR_HEADING eightball 90.0

	CLEAR_CHAR_THREAT_SEARCH eightball
	
	CREATE_CAR CAR_KURUMA car_8ball_x car_8ball_y car_8ball_z car_eightball

	SET_CAR_HEADING car_eightball car_8ball_heading

	CHANGE_CAR_COLOUR car_eightball car_colour1_8ball car_colour2_8ball
	
	RELEASE_WEATHER 
	
	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER script_controlled_player car_eightball

	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER eightball car_eightball

	WHILE NOT IS_PLAYER_IN_CAR player car_eightball
	OR NOT IS_CHAR_IN_CAR eightball car_eightball

		WAIT 0

		IF IS_CAR_DEAD car_eightball

			IF IS_CHAR_DEAD eightball
				PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
				GOTO mission_eightball_failed
			ELSE
				PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   				GOTO mission_eightball_failed
   			ENDIF

		ELSE

			IF IS_CAR_UPSIDEDOWN car_eightball
			AND IS_CAR_STOPPED car_eightball 
				PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
				GOTO mission_eightball_failed
   			ENDIF

		ENDIF

		IF IS_CHAR_DEAD eightball
	  		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  		GOTO mission_eightball_failed
		ENDIF

	ENDWHILE

	SET_CHAR_CANT_BE_DRAGGED_OUT eightball TRUE

	RESTORE_CAMERA_JUMPCUT

	SET_CAMERA_IN_FRONT_OF_PLAYER

	SWITCH_WIDESCREEN OFF

	SET_PLAYER_CONTROL player ON

	SET_POLICE_IGNORE_PLAYER player OFF
		
ENDIF

// **************************************end of the restart stuff***************************

IF flag_reached_hideout = 0
	REMOVE_PARTICLE_EFFECTS_IN_AREA 804.02 -948.03 30.0 765.15 -924.32 50.0
	REMOVE_SOUND fire_sound_8ball
	DELETE_OBJECT damagea
	DELETE_OBJECT damageb
   	SWAP_NEAREST_BUILDING_MODEL 1027.26 -933.796 15.042 50.0 LOD_land014 indhelix_barrier	
	SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1027.26 -933.796 15.042 50.0 indhelix_barrier TRUE
ENDIF 
flag_reached_hideout = 1

OVERRIDE_NEXT_RESTART 883.5 -308.2 7.6 90.0  // Players hideout

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball  //Luigis blip

LOAD_MISSION_AUDIO LIB_B

WHILE NOT HAS_MISSION_AUDIO_LOADED 

	WAIT 0
						   	   	
	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord2_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
			   	ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball //Luigis
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF
	
ENDWHILE

PLAY_MISSION_AUDIO

PRINT_NOW ( EBAL_D ) 5000 1 //"I know a guy, he's connected, Names Luigi.

WAIT 2000

IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord2_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
			   	ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball //Luigis
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF


PRINT_NOW ( EBAL_D1 ) 7000 1 //"Me an' him go back so I could probably get you some work."

//waiting for the player to got to Luigi's

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
			   	REMOVE_BLIP radar_blip_coord2_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
				ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball //Luigis
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF
	
ENDWHILE

CLEAR_THIS_PRINT ( EBAL_D )

CLEAR_THIS_PRINT ( EBAL_D1 )

// waiting for the player to get to luigi's
   
LOAD_MISSION_AUDIO LIB_C

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 903.8 -420.2 14.0 908.3 -431.1 18.0 blob_flag 
OR NOT IS_CHAR_STOPPED_IN_AREA_IN_CAR_3D eightball 903.8 -420.2 14.0 908.3 -431.1 18.0 FALSE
OR NOT IS_PLAYER_IN_CAR player car_eightball
OR NOT IS_CHAR_IN_CAR eightball car_eightball
OR NOT HAS_MISSION_AUDIO_LOADED 

	WAIT 0
				   	   	
	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_eightball

			blob_flag = 0
			
			IF flag_car_message_8ball = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the car and get on with the mission!"
				REMOVE_BLIP radar_blip_coord2_eightball
				ADD_BLIP_FOR_CAR car_eightball radar_blip_car1_eightball
				flag_car_message_8ball = 1
			ENDIF
			
		ELSE

			blob_flag = 1
		
			IF flag_car_message_8ball = 1
				REMOVE_BLIP radar_blip_car1_eightball
				ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord2_eightball //Luigis
				flag_car_message_8ball = 0
			ENDIF
			
		ENDIF
		
	ENDIF   

	IF IS_CHAR_DEAD eightball
		PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	    GOTO mission_eightball_failed
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_2D player 902.8 -425.6 15.0 15.0 FALSE
	AND IS_PLAYER_IN_CAR player car_eightball
	AND flag_help_8ball2 = 0
		PRINT_HELP ( HELP1 ) //Stop in the centre of the red dome."
		flag_help_8ball2 = 1
	ENDIF
	      		
ENDWHILE

CLEAR_HELP

REMOVE_BLIP radar_blip_coord2_eightball

SWITCH_WIDESCREEN ON

CLEAR_WANTED_LEVEL player

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

SET_PLAYER_CONTROL player OFF

CLEAR_AREA 887.4 -417.3 13.9 10.0 TRUE // This should get rid of any stuff for the cut-scene

GET_PLAYER_CHAR player script_controlled_player

CLEAR_CHAR_THREAT_SEARCH script_controlled_player

SET_CHAR_OBJ_LEAVE_CAR script_controlled_player car_eightball
 
SET_CHAR_OBJ_LEAVE_CAR eightball car_eightball

PLAY_MISSION_AUDIO

PRINT_NOW ( EBAL_G ) 7000 1 //"Here's Luigi's club. c'mon lets go round the back and use the service door."


WHILE IS_CHAR_IN_CAR script_controlled_player car_eightball
			
	WAIT 0

	IF IS_CHAR_DEAD eightball
	  	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

	IF HAS_MISSION_AUDIO_FINISHED
	   CLEAR_THIS_PRINT ( EBAL_G )
	ENDIF	
	   
ENDWHILE

IF IS_CHAR_DEAD eightball
	PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	GOTO mission_eightball_failed
ENDIF

WHILE IS_CHAR_IN_CAR eightball car_eightball

	WAIT 0

	IF IS_CAR_DEAD car_eightball

		IF IS_CHAR_DEAD eightball
			PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
   			GOTO mission_eightball_failed
   		ENDIF

	ELSE

		IF IS_CAR_UPSIDEDOWN car_eightball
		AND IS_CAR_STOPPED car_eightball 
			PRINT_NOW ( UPSIDE ) 5000 1 //You've flipped your wheels!"
			GOTO mission_eightball_failed
   		ENDIF

	ENDIF

	IF IS_CHAR_DEAD eightball
	  	 PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

	IF HAS_MISSION_AUDIO_FINISHED
	   CLEAR_THIS_PRINT ( EBAL_G )
	ENDIF
	   
ENDWHILE

MARK_CAR_AS_NO_LONGER_NEEDED car_eightball

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 897.1 -426.3

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT eightball 897.3 -424.6


WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD eightball
	  	 PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( EBAL_G )

SET_EVERYONE_IGNORE_PLAYER player OFF

SET_POLICE_IGNORE_PLAYER player OFF

SET_CHAR_CANT_BE_DRAGGED_OUT eightball FALSE

CLEAR_HELP

// ****************************Player and eightball cut-scene at luigi's********************

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION Player
AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway

	WAIT 0

	IF IS_CHAR_DEAD eightball
	  	 PRINT_NOW ( EBAL_4 ) 5000 1 //"8-Balls dead!
	  	 GOTO mission_eightball_failed
	ENDIF

	GET_GAME_TIMER breakout_timer

	breakout_diff = breakout_timer - breakout_timer_start
	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( LM1 ) 15000 2 //"Luigi's Girls"

REQUEST_MODEL indhibuild3
REQUEST_MODEL luigiclubout
REQUEST_MODEL luigiineerclub

LOAD_SPECIAL_CHARACTER 2 MICKY
LOAD_SPECIAL_CHARACTER 3 LUIGI

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR
LOAD_SPECIAL_MODEL cut_obj2 MICKYH
LOAD_SPECIAL_MODEL cut_obj3 EIGHTH
LOAD_SPECIAL_MODEL cut_obj4	LUIGIH
LOAD_SPECIAL_MODEL cut_obj5	PLAYERH

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

LOAD_ALL_MODELS_NOW

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 926.54 -471.72 1.0 830.76 -257.96 25.0

IF NOT IS_CHAR_DEAD eightball 
	SET_CHAR_OBJ_WAIT_ON_FOOT eightball
ENDIF

SET_CHAR_OBJ_WAIT_ON_FOOT script_controlled_player
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED cut_obj1 
OR NOT HAS_MODEL_LOADED cut_obj2

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED cut_obj5
OR NOT HAS_MODEL_LOADED indhibuild3
OR NOT HAS_MODEL_LOADED luigiclubout
OR NOT HAS_MODEL_LOADED luigiineerclub

	WAIT 0

ENDWHILE

DELETE_CHAR eightball

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE

LOAD_CUTSCENE l1_lg

SET_CUTSCENE_OFFSET 900.782 -427.523 13.829

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_micky

SET_CUTSCENE_ANIM cs_micky micky

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_eight

SET_CUTSCENE_ANIM cs_eight eight2

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_luigi

SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_HEAD cs_micky CUT_OBJ2 cs_mickyhead

SET_CUTSCENE_HEAD_ANIM cs_mickyhead micky

CREATE_CUTSCENE_HEAD cs_eight CUT_OBJ3 cs_eighthead

SET_CUTSCENE_HEAD_ANIM cs_eighthead eight

CREATE_CUTSCENE_HEAD cs_luigi CUT_OBJ4 cs_luigihead

SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ5 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor

SET_CUTSCENE_ANIM cs_ludoor LUDOOR

CLEAR_AREA 896.6 -426.2 13.9 1.0 TRUE
SET_PLAYER_COORDINATES player 896.6 -426.2 13.9

SET_PLAYER_HEADING player 270.0

TIMERA = 0

WHILE TIMERA < 3500

	WAIT 0

ENDWHILE

DO_FADE 1500 FADE_IN

CLEAR_AREA 887.4 -417.3 13.9 10.0 TRUE  // This should get rid of anything in the alleway

CLEAR_AREA 892.8 -425.5 13.9 3.0 TRUE

CLEAR_AREA 896.3 -425.6 13.8 3.0 TRUE

CLEAR_AREA 899.7 -425.7 14.0 0.5 TRUE


SWITCH_RUBBISH OFF

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

SET_PLAYER_VISIBLE player OFF

// Displays cutscene text

WHILE cs_time < 11165
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_H ) 10000 1 //"Wait here while I go in and talk to Luigi."

WHILE cs_time < 13416
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( EBAL_H )

//PRINT_NOW ( EBAL_I ) 10000 1 //"Da boss will be out to see you shortly..."

WHILE cs_time < 30834
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_J ) 10000 1 //"8-Ball's got some business up stairs."

WHILE cs_time < 33186
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_K ) 10000 1 //"Maybe you can do me a favor."

WHILE cs_time < 35235
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_L ) 10000 1 //"One of my girls needs a ride so grab a car and pick up Misty from the clinic. Then bring her back here"

WHILE cs_time < 41551
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_M ) 10000 1//"Remember no one messes with my girls"

WHILE cs_time < 45634
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_N ) 10000 1//"So keep your hands on the wheel!"

WHILE cs_time < 47560
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( EBAL_O ) 10000 1 //"If you don't mess this up there might be more work for you."

WHILE cs_time < 51911
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( EBAL_O )

WHILE cs_time < 52500
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

SET_CAMERA_BEHIND_PLAYER

WAIT 500

SWITCH_STREAMING ON

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH ON

LOAD_SCENE 920.3 -425.4 15.0

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1

UNLOAD_SPECIAL_CHARACTER 2

UNLOAD_SPECIAL_CHARACTER 3

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj4

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj5

MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3

MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout

MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub

SET_PLAYER_CONTROL player ON

SET_PED_DENSITY_MULTIPLIER 1.0

// ************************************************END OF CUT_SCENE*************************


// *****************************************LUIGI'S GIRLS***********************************

LOAD_SPECIAL_CHARACTER 2 MISTY

PRINT_NOW ( EBAL_5 ) 5000 1 //"Get a vehicle!"

// Waiting for the player to be in a car

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2

	WAIT 0
				
ENDWHILE

// Creates the first girl

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1144.6 -592.8 13.9 girl1_lm1

CLEAR_CHAR_THREAT_SEARCH girl1_lm1

SET_CHAR_HEADING girl1_lm1 90.0

SET_ANIM_GROUP_FOR_CHAR girl1_lm1 ANIM_SEXY_WOMANPED

ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1

flag_blip_on_girl1_lm1 = 1

LOAD_MISSION_AUDIO LIB_D

WHILE NOT IS_PLAYER_IN_ANY_CAR player
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ENDIF

	IF IS_PLAYER_IN_ANY_CAR player
		STORE_CAR_PLAYER_IS_IN player car_lm1
	ENDIF

ENDWHILE

GET_CONTROLLER_MODE controlmode

IF controlmode = 0
	CLEAR_HELP
	PRINT_HELP ( RADIO_A ) //"Press the L1 button to cycle through the radio stations."
ENDIF

IF controlmode = 1
	CLEAR_HELP
	PRINT_HELP ( RADIO_B ) //"Press the SELECT button to cycle through the radio stations.
ENDIF

IF controlmode = 2
	CLEAR_HELP
	PRINT_HELP ( RADIO_C ) //"Press the L3 button to cycle through the radio stations."
ENDIF

IF controlmode = 3
	CLEAR_HELP
	PRINT_HELP ( RADIO_D ) //"Press the | button to cycle through the radio stations."
ENDIF

PRINT_NOW ( EBAL_6 ) 5000 1 //"Pick up Misty!"

// Waiting for the player and the girls all to be in the one car

WHILE flag_girl1_in_car_lm1 = 0

	WAIT 0

IF flag_girl_in_group_lm1 = 0 

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ENDIF

	IF flag_misty_stop = 0

		IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl1_lm1 20.0 20.0 FALSE
			PRINT_HELP ( LM1_7 ) //"Stop the vehicle next to Misty and allow her to enter it."
			flag_misty_stop = 1
		ENDIF
				
	ENDIF
	
	IF NOT IS_PLAYER_IN_ANY_CAR player

		IF flag_player_had_vehicle_message_lm1 = 0
			PRINT_NOW ( IN_VEH2 ) 5000 1 //"Get a vehicle and get on with the mission!"

			IF flag_blip_on_girl1_lm1 = 1
				REMOVE_BLIP radar_blip_ped1_lm1 
				flag_blip_on_girl1_lm1 = 0
			ENDIF

			flag_player_had_vehicle_message_lm1 = 1
		ENDIF

	ELSE
		
		STORE_CAR_PLAYER_IS_IN player car_lm1

		IF flag_player_had_vehicle_message_lm1 = 1
			PRINT_NOW ( EBAL_6 ) 5000 1 //"Pick up Misty!"

			IF flag_blip_on_girl1_lm1 = 0
				ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
				flag_blip_on_girl1_lm1 = 1
			ENDIF

			flag_player_had_vehicle_message_lm1 = 0
		ENDIF
		
	ENDIF
	 
	   	IF IS_PLAYER_IN_ANY_CAR player
			STORE_CAR_PLAYER_IS_IN player car_lm1

			IF LOCATE_PLAYER_IN_CAR_CHAR_2D player girl1_lm1 8.0 8.0 FALSE

				IF IS_PLAYER_STOPPED player
									   				
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER girl1_lm1 car_lm1
					
						WHILE NOT IS_CHAR_IN_CAR girl1_lm1 car_lm1
						OR NOT IS_PLAYER_IN_CAR player car_lm1

							WAIT 0

							IF IS_CHAR_DEAD girl1_lm1
								PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
								GOTO mission_eightball_failed
							ENDIF

							IF IS_CAR_DEAD car_lm1
								
								IF IS_CHAR_DEAD girl1_lm1
									PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
									GOTO mission_eightball_failed
								ELSE
									PRINT_NOW ( WRECKED ) 5000 1 //"The Vehicles wrecked"
									GOTO mission_eightball_failed
								ENDIF

							ENDIF
								
							IF IS_CHAR_IN_CAR girl1_lm1 car_lm1
								SET_CHAR_CANT_BE_DRAGGED_OUT girl1_lm1 TRUE
							ENDIF 
														
							IF NOT IS_PLAYER_IN_CAR player car_lm1

								IF flag_player_had_vehicle_message_lm1 = 0
									PRINT_NOW ( IN_VEH ) 5000 1 //"Get a vehicle and get on with the mission!"
										
										IF flag_blip_on_girl1_lm1 = 1
											REMOVE_BLIP radar_blip_ped1_lm1
											ADD_BLIP_FOR_CAR car_lm1 radar_blip_car1_lm1 
											flag_blip_on_girl1_lm1 = 0
										ENDIF

									flag_player_had_vehicle_message_lm1 = 1
								ENDIF

							ELSE

								IF flag_player_had_vehicle_message_lm1 = 1

									PRINT_NOW ( EBAL_6 ) 5000 1 //"Pick up Misty!"

									IF flag_blip_on_girl1_lm1 = 0
										ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
										REMOVE_BLIP radar_blip_car1_lm1
										flag_blip_on_girl1_lm1 = 1
									ENDIF
																		
									flag_player_had_vehicle_message_lm1 = 0
								ENDIF
		
							ENDIF
							
						ENDWHILE
						REMOVE_BLIP radar_blip_ped1_lm1
						REMOVE_BLIP radar_blip_car1_lm1
						flag_blip_on_girl1_lm1 = 0
						flag_girl_in_group_lm1 = 1
				ENDIF

			ENDIF

		ENDIF

ENDIF

	IF flag_girl_in_group_lm1 = 1

		IF IS_CHAR_DEAD girl1_lm1
			PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
			GOTO mission_eightball_failed
		ENDIF

		IF IS_CAR_DEAD car_lm1
								
			IF IS_CHAR_DEAD girl1_lm1
				PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
				GOTO mission_eightball_failed
			ELSE
				PRINT_NOW ( WRECKED ) 5000 1 //"The Vehicles wrecked"
				GOTO mission_eightball_failed
			ENDIF

		ENDIF

		IF NOT IS_PLAYER_IN_CAR player car_lm1

			IF flag_player_had_car_message_lm1 = 0
				PRINT_NOW ( IN_VEH ) 5000 1 //Get into the car and get on with the mission"
				ADD_BLIP_FOR_CAR car_lm1 radar_blip_car1_lm1
				flag_player_had_car_message_lm1 = 1
			ENDIF

		ENDIF

		IF IS_PLAYER_IN_CAR player car_lm1

			IF IS_CHAR_IN_CAR girl1_lm1 car_lm1
				PRINT_NOW ( LM1_9 ) 10000 1 //"Hey I'm Misty!"
				PLAY_MISSION_AUDIO
				SET_CHAR_CANT_BE_DRAGGED_OUT girl1_lm1 FALSE
				flag_girl1_in_car_lm1 = 1 
			ENDIF
		
			IF flag_player_had_car_message_lm1 = 1
				REMOVE_BLIP radar_blip_car1_lm1
				flag_player_had_car_message_lm1 = 0
			ENDIF
			
		ENDIF 
		
	ENDIF
	     
ENDWHILE

REMOVE_BLIP radar_blip_ped1_lm1

SET_PLAYER_AS_LEADER girl1_lm1 player

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ELSE
		
		IF NOT IS_CHAR_IN_PLAYERS_GROUP girl1_lm1 player
		AND flag_blip_on_girl1_lm1 = 0
			PRINT_NOW ( HEY4 ) 5000 1 //"You have left Misty behind go and get her!"
			ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
	   		flag_blip_on_girl1_lm1 = 1
		ENDIF
		
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
		AND flag_blip_on_girl1_lm1 = 1
			SET_PLAYER_AS_LEADER girl1_lm1 player
			//PRINT_NOW ( LM1_2 ) 7000 1 //"Hi take us to the Red Light District please, we'll be ever so 'grateful'!"
			REMOVE_BLIP radar_blip_ped1_lm1
			flag_blip_on_girl1_lm1 = 0
		ENDIF

	ENDIF

	IF IS_CAR_DEAD car_lm1
								
		IF IS_CHAR_DEAD girl1_lm1
			PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
			GOTO mission_eightball_failed
		ELSE
			PRINT_NOW ( WRECKED ) 5000 1 //"The Vehicles wrecked"
			GOTO mission_eightball_failed
		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( LM1_9 )
	
PRINT_NOW ( LM1_2 ) 7000 1 //"Hi take us to the Red Light District please, we'll be ever so 'grateful'!"

ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord1_lm1

blob_flag = 1

PRINT_HELP ( LOOK_A ) //"Press and hold the ~h~L2 button to look left~w~ while in a vehicle." 

timera = 0

// waiting for the player to get to luigi's

WHILE NOT IS_CHAR_STOPPED_IN_AREA_3D girl1_lm1 903.8 -420.2 14.0 908.3 -431.1 18.0 blob_flag
OR NOT IS_PLAYER_STOPPED_IN_AREA_3D player 903.8 -420.2 14.0 908.3 -431.1 18.0 FALSE   
	   
	WAIT 0

	IF flag_player_had_camera_message_8ball = 0
		
		GET_CONTROLLER_MODE controlmode

		IF timera > 10000

			IF controlmode = 0
				PRINT_HELP ( CAM_A ) //"Press the ~h~SELECT button~w~ to change ~h~camera ~w~modes when on foot or in a vehicle."
				flag_player_had_camera_message_8ball = 1
			ENDIF	

			IF controlmode = 0
				PRINT_HELP ( CAM_B ) //"Press the ~h~directional button up~w~ and ~h~down~w~ to change ~h~camera ~w~modes when on foot or in a vehicle."
				flag_player_had_camera_message_8ball = 1
			ENDIF

			IF controlmode = 0
				PRINT_HELP ( CAM_A ) //"Press the ~h~SELECT button~w~ to change ~h~camera ~w~modes when on foot or in a vehicle."
				flag_player_had_camera_message_8ball = 1
			ENDIF

			IF controlmode = 0
				PRINT_HELP ( CAM_A ) //"Press the ~h~SELECT button~w~ to change ~h~camera ~w~modes when on foot or in a vehicle."
				flag_player_had_camera_message_8ball = 1
			ENDIF

		ENDIF

	ENDIF
	
	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ELSE
		
		IF NOT IS_CHAR_IN_PLAYERS_GROUP girl1_lm1 player
		AND flag_blip_on_girl1_lm1 = 0
			PRINT_NOW ( HEY4 ) 5000 1 //"You have left Misty behind go and get her!"
			ADD_BLIP_FOR_CHAR girl1_lm1 radar_blip_ped1_lm1
	   		REMOVE_BLIP radar_blip_coord1_lm1
			blob_flag = 0
			flag_blip_on_girl1_lm1 = 1
		ENDIF
		
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player girl1_lm1 8.0 8.0 FALSE
		AND flag_blip_on_girl1_lm1 = 1
			SET_PLAYER_AS_LEADER girl1_lm1 player
			PRINT_NOW ( LM1_2 ) 7000 1 //"Hi take us to the Red Light District please, we'll be ever so 'grateful'!"
			ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 radar_blip_coord1_lm1
			REMOVE_BLIP radar_blip_ped1_lm1
			blob_flag = 1
			flag_blip_on_girl1_lm1 = 0
		ENDIF

	ENDIF
    
ENDWHILE

REMOVE_BLIP radar_blip_coord1_lm1

LEAVE_GROUP girl1_lm1

// *********************************MISTY CUT AT END****************************************

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

CLEAR_WANTED_LEVEL player

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

CLEAR_AREA 887.4 -417.3 13.9 10.0 TRUE // This should get rid of any stuff for the cut-scene

REQUEST_MODEL indhibuild3
REQUEST_MODEL luigiclubout
REQUEST_MODEL luigiineerclub

IF IS_CHAR_IN_ANY_CAR girl1_lm1
	
	SET_CHAR_CANT_BE_DRAGGED_OUT girl1_lm1 FALSE

	STORE_CAR_CHAR_IS_IN girl1_lm1 car_lm1

	SET_CHAR_OBJ_LEAVE_CAR girl1_lm1 car_lm1

	WHILE IS_CHAR_IN_ANY_CAR girl1_lm1
			
		WAIT 0

		IF IS_CHAR_DEAD girl1_lm1
			PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
			GOTO mission_eightball_failed
		ENDIF
	 
	ENDWHILE

ENDIF

WHILE NOT HAS_MODEL_LOADED indhibuild3
OR NOT HAS_MODEL_LOADED	luigiclubout
OR NOT HAS_MODEL_LOADED	luigiineerclub

	WAIT 0

	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ENDIF

ENDWHILE

// Misty walks to the top of the alleyway

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT girl1_lm1 900.17 -425.4 

timerb = 0

WHILE timerb < 1000

	WAIT 0
	
	IF IS_CHAR_DEAD girl1_lm1
		PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
		GOTO mission_eightball_failed
	ENDIF

ENDWHILE

IF IS_CHAR_DEAD girl1_lm1
	PRINT_NOW ( MISTY1 ) 5000 1 //"Misty's dead!
	GOTO mission_eightball_failed
ENDIF

SET_CHAR_COORDINATES girl1_lm1 898.9 -425.8 13.9 
SET_CHAR_HEADING girl1_lm1 90.0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT girl1_lm1 887.1 -425.22

SWITCH_WIDESCREEN ON
SET_FIXED_CAMERA_POSITION 882.6 -425.6 14.4 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 890.2 -421.1 15.0 jump_cut 

PRINT_WITH_NUMBER_BIG ( M_PASS ) 1500 5000 1 //"Mission Passed!"
ADD_SCORE player 1500 
PLAY_MISSION_PASSED_TUNE 1 //plays the mission complete tune

timerb = 0

WHILE timerb < 5000

	WAIT 0
		   
ENDWHILE

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

WAIT 0

SET_CAMERA_BEHIND_PLAYER

WAIT 0

SWITCH_WIDESCREEN OFF

WAIT 0

RESTORE_CAMERA_JUMPCUT

WAIT 750

DO_FADE 250 FADE_IN

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF

GOTO mission_eightball_passed



// Mission 8ball failed

mission_eightball_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

flag_eightball_mission_launched = 0

IF flag_reached_hideout = 0
	RESTART_CRITICAL_MISSION 811.90 -939.95 35.8 180.0 // New bridge restart	
ELSE
	RESTART_CRITICAL_MISSION 883.5 -308.2 7.6 90.0  // Player hideout
ENDIF

MISSION_HAS_FINISHED	//	marks models as no longer needed so that they can be deleted before the player is teleported

WHILE NOT IS_PLAYER_PLAYING player

	WAIT 0
    		
ENDWHILE

RETURN


// mission eightball passed

mission_eightball_passed:

CANCEL_OVERRIDE_RESTART
flag_eightball_mission_passed = 1
REGISTER_MISSION_PASSED ( LM1 )
PLAYER_MADE_PROGRESS 1
flag_luigi_mission1_passed = 1
CLEAR_WANTED_LEVEL player
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 892.8 -425.8 13.9 RADAR_SPRITE_LUIGI luigi_contact_blip  // New blip down alleyway
START_NEW_SCRIPT luigi_mission2_loop
START_NEW_SCRIPT blob_help_loop
START_NEW_SCRIPT luigi_message
RETURN
}

// mission cleanup

mission_cleanup_eightball:

flag_player_on_mission = 0
flag_player_on_eightball_mission = 0
REMOVE_PARTICLE_EFFECTS_IN_AREA 804.02 -948.03 30.0 765.15 -924.32 50.0
REMOVE_SOUND fire_sound_8ball
SET_FADING_COLOUR 0 0 0
MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3
MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout
MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_KURUMA
REMOVE_BLIP radar_blip_coord1_eightball
REMOVE_BLIP radar_blip_coord2_eightball
REMOVE_BLIP radar_blip_car1_eightball
DELETE_CHAR eightball
DELETE_CHAR girl1_lm1
REMOVE_BLIP radar_blip_coord1_lm1
REMOVE_BLIP radar_blip_ped1_lm1
REMOVE_BLIP radar_blip_car1_lm1
FLASH_HUD_OBJECT -1

IF NOT IS_CAR_DEAD cop_car1_8ball 
	MARK_CAR_AS_NO_LONGER_NEEDED cop_car1_8ball
ENDIF

IF NOT IS_CAR_DEAD cop_car2_8ball 
	MARK_CAR_AS_NO_LONGER_NEEDED cop_car2_8ball
ENDIF

IF NOT IS_CHAR_DEAD girl1_lm1
	SET_CHAR_CANT_BE_DRAGGED_OUT girl1_lm1 FALSE
ENDIF

MISSION_HAS_FINISHED
RETURN
		
  
car_gen_start_8ball:

// Switches on the car generators from Greasy Joes and Fish Factory

SWITCH_CAR_GENERATOR gen_car44 101

SWITCH_CAR_GENERATOR gen_car45 101

SWITCH_CAR_GENERATOR gen_car46 101

SWITCH_CAR_GENERATOR gen_car47 101

SWITCH_CAR_GENERATOR gen_car48 101

SWITCH_CAR_GENERATOR gen_car49 101

// switches on the car generators from the fuzz ball

SWITCH_CAR_GENERATOR gen_car28 101

SWITCH_CAR_GENERATOR gen_car29 101

SWITCH_CAR_GENERATOR gen_car1 101

SWITCH_CAR_GENERATOR gen_car2 101

SWITCH_CAR_GENERATOR gen_car3 101 
	 
SWITCH_CAR_GENERATOR gen_car4 101

SWITCH_CAR_GENERATOR gen_car5 101 

SWITCH_CAR_GENERATOR gen_car6 101

SWITCH_CAR_GENERATOR gen_car6 101

SWITCH_CAR_GENERATOR gen_car9 101

SWITCH_CAR_GENERATOR gen_car10 101

SWITCH_CAR_GENERATOR gen_car11 101

SWITCH_CAR_GENERATOR gen_car12 101

SWITCH_CAR_GENERATOR gen_car13 101

SWITCH_CAR_GENERATOR gen_car15 101

SWITCH_CAR_GENERATOR gen_car16 101

SWITCH_CAR_GENERATOR gen_car17 101

SWITCH_CAR_GENERATOR gen_car18 101

SWITCH_CAR_GENERATOR gen_car57 101

SWITCH_CAR_GENERATOR gen_car58 101

SWITCH_CAR_GENERATOR gen_car19 101

SWITCH_CAR_GENERATOR gen_car20 101

SWITCH_CAR_GENERATOR gen_car21 101

SWITCH_CAR_GENERATOR gen_car22 101

SWITCH_CAR_GENERATOR gen_car24 101

SWITCH_CAR_GENERATOR gen_car25 101

SWITCH_CAR_GENERATOR gen_car59 101

SWITCH_CAR_GENERATOR gen_car23 101

SWITCH_CAR_GENERATOR gen_car30 101

SWITCH_CAR_GENERATOR gen_car31 101

SWITCH_CAR_GENERATOR gen_car53 101

SWITCH_CAR_GENERATOR gen_car8 101

SWITCH_CAR_GENERATOR gen_car32 101

SWITCH_CAR_GENERATOR gen_car34 101

SWITCH_CAR_GENERATOR gen_car36 101

SWITCH_CAR_GENERATOR gen_car37 101

SWITCH_CAR_GENERATOR gen_car38 101

SWITCH_CAR_GENERATOR gen_car40 101	

SWITCH_CAR_GENERATOR gen_car41 101

SWITCH_CAR_GENERATOR gen_car42 101

SWITCH_CAR_GENERATOR gen_car43 101

SWITCH_CAR_GENERATOR gen_car54 101

SWITCH_CAR_GENERATOR gen_car55 101

SWITCH_CAR_GENERATOR gen_car56 101

SWITCH_CAR_GENERATOR gen_car33 101
	 
SWITCH_CAR_GENERATOR gen_car51 101 								   

SWITCH_CAR_GENERATOR gen_car52 101

SWITCH_CAR_GENERATOR gen_car64 101

SWITCH_CAR_GENERATOR com_car1 101

SWITCH_CAR_GENERATOR com_car2 101

SWITCH_CAR_GENERATOR com_car25 101

SWITCH_CAR_GENERATOR com_car26 101

SWITCH_CAR_GENERATOR com_car3 101

SWITCH_CAR_GENERATOR com_car4 101

SWITCH_CAR_GENERATOR com_car5 101

SWITCH_CAR_GENERATOR com_car6 101

SWITCH_CAR_GENERATOR com_car7 101

SWITCH_CAR_GENERATOR com_car8 101

SWITCH_CAR_GENERATOR com_car9 101

SWITCH_CAR_GENERATOR com_car10 101

SWITCH_CAR_GENERATOR com_car11 101

SWITCH_CAR_GENERATOR com_car12 101

SWITCH_CAR_GENERATOR com_car20 101

SWITCH_CAR_GENERATOR com_car21 101

SWITCH_CAR_GENERATOR com_car27 101

SWITCH_CAR_GENERATOR com_car28 101

SWITCH_CAR_GENERATOR com_car29 101

SWITCH_CAR_GENERATOR com_car30 101

SWITCH_CAR_GENERATOR com_car31 101

SWITCH_CAR_GENERATOR com_car32 101

SWITCH_CAR_GENERATOR com_car33 101

SWITCH_CAR_GENERATOR com_car34 101

SWITCH_CAR_GENERATOR com_car35 101

SWITCH_CAR_GENERATOR com_car36 101

SWITCH_CAR_GENERATOR com_car37 101

SWITCH_CAR_GENERATOR com_car38 101

SWITCH_CAR_GENERATOR com_car39 101

SWITCH_CAR_GENERATOR com_car40 101

SWITCH_CAR_GENERATOR gen_car60 0

SWITCH_CAR_GENERATOR gen_car61 0

SWITCH_CAR_GENERATOR gen_car62 0

SWITCH_CAR_GENERATOR com_car41 101

SWITCH_CAR_GENERATOR com_car42 101

SWITCH_CAR_GENERATOR com_car43 101

SWITCH_CAR_GENERATOR com_car44 101

SWITCH_CAR_GENERATOR com_car45 101

SWITCH_CAR_GENERATOR gen_car35 101

SWITCH_CAR_GENERATOR com_car15 101

SWITCH_CAR_GENERATOR com_car16 101

SWITCH_CAR_GENERATOR com_car17 101

SWITCH_CAR_GENERATOR com_car19 101

SWITCH_CAR_GENERATOR com_car24 101

SWITCH_CAR_GENERATOR com_car13 101

SWITCH_CAR_GENERATOR com_car23 0

SWITCH_CAR_GENERATOR com_car14 101

SWITCH_CAR_GENERATOR com_car22 101

SWITCH_CAR_GENERATOR phil_car 101

SWITCH_CAR_GENERATOR com_car46 101

SWITCH_CAR_GENERATOR com_car47 101

SWITCH_CAR_GENERATOR com_car48 101

SWITCH_CAR_GENERATOR com_car49 101

SWITCH_CAR_GENERATOR special_tank 0
 
SWITCH_CAR_GENERATOR sub_car1 101

SWITCH_CAR_GENERATOR sub_car2 101

SWITCH_CAR_GENERATOR sub_car3 101

SWITCH_CAR_GENERATOR sub_car4 101

SWITCH_CAR_GENERATOR sub_car5 101

SWITCH_CAR_GENERATOR sub_car6 101

SWITCH_CAR_GENERATOR sub_car7 101

SWITCH_CAR_GENERATOR sub_car25 101	  

SWITCH_CAR_GENERATOR gen_car63 0

SWITCH_CAR_GENERATOR sub_car40 101

SWITCH_CAR_GENERATOR sub_car41 101

SWITCH_CAR_GENERATOR sub_car42 101

SWITCH_CAR_GENERATOR sub_car43 101

SWITCH_CAR_GENERATOR sub_car44 101

SWITCH_CAR_GENERATOR sub_car45 101

SWITCH_CAR_GENERATOR sub_car46 101

SWITCH_CAR_GENERATOR sub_car8 101	  

SWITCH_CAR_GENERATOR sub_car9 101	  

SWITCH_CAR_GENERATOR sub_car10 101	  

SWITCH_CAR_GENERATOR sub_car11 101	  

SWITCH_CAR_GENERATOR sub_car12 101	  

SWITCH_CAR_GENERATOR sub_car13 101	  

SWITCH_CAR_GENERATOR sub_car14 101	  

SWITCH_CAR_GENERATOR sub_car15 101	  

SWITCH_CAR_GENERATOR sub_car16 101	  

SWITCH_CAR_GENERATOR sub_car19 101	  

SWITCH_CAR_GENERATOR sub_car20 101	  

SWITCH_CAR_GENERATOR sub_car17 101	  

SWITCH_CAR_GENERATOR sub_car18 101	  

SWITCH_CAR_GENERATOR sub_car21 101	  

SWITCH_CAR_GENERATOR sub_car22 101	  

SWITCH_CAR_GENERATOR sub_car23 101	  

SWITCH_CAR_GENERATOR sub_car24 101	  

SWITCH_CAR_GENERATOR sub_car30 101

SWITCH_CAR_GENERATOR sub_car31 101

SWITCH_CAR_GENERATOR rc_van1 101

SWITCH_CAR_GENERATOR rc_van2 101

SWITCH_CAR_GENERATOR rc_van3 101

SWITCH_CAR_GENERATOR rc_van4 101

RETURN








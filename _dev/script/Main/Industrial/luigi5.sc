MISSION_START

// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Luigi mission 5********************************* 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME luigi5

// Mission Start Stuff

GOSUB mission_start_luigi5

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_luigi5_failed
	ENDIF

GOSUB mission_cleanup_luigi5

MISSION_END

// Vehicles for mission

VAR_INT vehicle_lm5

// radar_blips

VAR_INT flag_blip_on_prossie1_lm5

VAR_INT flag_blip_on_prossie2_lm5

VAR_INT flag_blip_on_prossie3_lm5

VAR_INT flag_blip_on_prossie4_lm5

VAR_INT flag_blip_on_prossie5_lm5

VAR_INT flag_blip_on_prossie6_lm5

VAR_INT flag_blip_on_prossie7_lm5

VAR_INT flag_blip_on_prossie8_lm5


VAR_INT radar_blip_coord1_lm5  //location of the fuzz ball

VAR_INT radarped_prossie1_lm5 //blip for real char

VAR_INT	radarped_prossie2_lm5 //blip for real char

VAR_INT radarped_prossie3_lm5 //blip for real char

VAR_INT	radarped_prossie4_lm5 //blip for real char

VAR_INT radarped_prossie5_lm5 //blip for real char

VAR_INT	radarped_prossie6_lm5 //blip for real char

VAR_INT radarped_prossie7_lm5 //blip for real char

VAR_INT	radarped_prossie8_lm5 //blip for real char

// timers

VAR_INT timer_lm5

// Characters for mission

VAR_INT prossie1_lm5

VAR_INT prossie2_lm5

VAR_INT prossie3_lm5

VAR_INT prossie4_lm5

VAR_INT prossie5_lm5

VAR_INT prossie6_lm5

VAR_INT prossie7_lm5

VAR_INT prossie8_lm5


//Character created and at ball flags

VAR_INT flag_prossie1_at_ball

VAR_INT flag_prossie2_at_ball

VAR_INT flag_prossie3_at_ball

VAR_INT flag_prossie4_at_ball

VAR_INT flag_prossie5_at_ball

VAR_INT flag_prossie6_at_ball

VAR_INT flag_prossie7_at_ball

VAR_INT flag_prossie8_at_ball


// girls in car flag

VAR_INT flag_prossie1_lm5_in_car

VAR_INT flag_prossie2_lm5_in_car

VAR_INT flag_prossie3_lm5_in_car

VAR_INT flag_prossie4_lm5_in_car

VAR_INT flag_prossie5_lm5_in_car

VAR_INT flag_prossie6_lm5_in_car

VAR_INT flag_prossie7_lm5_in_car

VAR_INT flag_prossie8_lm5_in_car


// no of passenger stuff

VAR_INT max_no_of_passengers_lm5

VAR_INT room_left_in_car_lm5

VAR_INT no_of_passengers_lm5

VAR_INT flag_had_room_message_lm5


// Scoreing stuff

VAR_INT counter_no_of_girls_at_the_ball

VAR_INT score_lm5


// PEds in to the building stuff

VAR_INT flag_prossie2_in_car_park
		
VAR_INT flag_prossie2_told_to_go_into_ball

VAR_INT flag_prossie1_in_car_park
		
VAR_INT flag_prossie1_told_to_go_into_ball

VAR_INT flag_prossie3_in_car_park
		
VAR_INT flag_prossie3_told_to_go_into_ball

VAR_INT flag_prossie4_in_car_park
		
VAR_INT flag_prossie4_told_to_go_into_ball

VAR_INT flag_prossie5_in_car_park
		
VAR_INT flag_prossie5_told_to_go_into_ball

VAR_INT flag_prossie6_in_car_park
		
VAR_INT flag_prossie6_told_to_go_into_ball

VAR_INT flag_prossie7_in_car_park
		
VAR_INT flag_prossie7_told_to_go_into_ball

VAR_INT flag_prossie8_in_car_park
		
VAR_INT flag_prossie8_told_to_go_into_ball

VAR_INT fuzzball_sign

VAR_INT number_of_dead_prossies

VAR_INT ball_sounds

// Door Stuff

VAR_INT flag_moved_door1_lm5

VAR_INT flag_moved_door2_lm5

// Message from girl to tell player to get a car

VAR_INT flag_had_car_message1_lm5

VAR_INT flag_had_car_message2_lm5

VAR_INT flag_had_car_message3_lm5

VAR_INT flag_had_car_message4_lm5

VAR_INT flag_had_car_message5_lm5

VAR_INT flag_had_car_message6_lm5

VAR_INT flag_had_car_message7_lm5

VAR_INT flag_had_car_message8_lm5

VAR_INT sphere_lm5

VAR_INT cop_car1_lm5

VAR_INT cop_car2_lm5

VAR_INT counter_girls_trying_to_get_to_ball

VAR_INT flag_timer_prossie1_lm5 // If the girls get stuck

VAR_INT flag_timer_prossie2_lm5 // If the girls get stuck

VAR_INT flag_timer_prossie3_lm5 // If the girls get stuck

VAR_INT flag_timer_prossie4_lm5	// If the girls get stuck

VAR_INT flag_timer_prossie5_lm5 // If the girls get stuck

VAR_INT flag_timer_prossie6_lm5 // If the girls get stuck

VAR_INT flag_timer_prossie7_lm5	// If the girls get stuck

VAR_INT flag_timer_prossie8_lm5	// If the girls get stuck


// ******************************************Mission Start**********************************

mission_start_luigi5:

flag_player_on_mission = 1

flag_player_on_luigi_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

max_no_of_passengers_lm5 = 0

flag_prossie1_at_ball = 0

flag_prossie2_at_ball = 0

flag_prossie3_at_ball = 0

flag_prossie4_at_ball = 0

flag_prossie5_at_ball = 0

flag_prossie6_at_ball = 0

flag_prossie7_at_ball = 0

flag_prossie8_at_ball = 0

room_left_in_car_lm5 = 0

no_of_passengers_lm5 = 0

flag_had_room_message_lm5 = 0

counter_no_of_girls_at_the_ball = 0

score_lm5 = 0

flag_prossie2_in_car_park = 0
		
flag_prossie2_told_to_go_into_ball = 0

flag_prossie1_in_car_park = 0

flag_prossie1_told_to_go_into_ball = 0

timer_lm5 = 301000  // 5 mins

flag_blip_on_prossie1_lm5 = 0

flag_blip_on_prossie2_lm5 = 0

flag_blip_on_prossie3_lm5 = 0

flag_blip_on_prossie4_lm5 = 0

flag_blip_on_prossie5_lm5 = 0

flag_blip_on_prossie6_lm5 = 0

flag_blip_on_prossie7_lm5 = 0

flag_blip_on_prossie8_lm5 = 0

flag_prossie1_lm5_in_car = 0

flag_prossie2_lm5_in_car = 0

flag_prossie3_lm5_in_car = 0

flag_prossie4_lm5_in_car = 0

flag_prossie5_lm5_in_car = 0

flag_prossie6_lm5_in_car = 0

flag_prossie7_lm5_in_car = 0

flag_prossie8_lm5_in_car = 0

flag_prossie3_in_car_park = 0

flag_prossie3_told_to_go_into_ball = 0

flag_prossie4_in_car_park = 0

flag_prossie4_told_to_go_into_ball = 0

flag_prossie5_in_car_park = 0

flag_prossie5_told_to_go_into_ball = 0

flag_prossie6_in_car_park = 0

flag_prossie6_told_to_go_into_ball = 0

flag_prossie7_in_car_park = 0

flag_prossie7_told_to_go_into_ball = 0

flag_prossie8_in_car_park = 0

flag_prossie8_told_to_go_into_ball = 0

number_of_dead_prossies = 0

flag_moved_door1_lm5 = 0

flag_moved_door2_lm5 = 0

flag_had_car_message1_lm5 = 0

flag_had_car_message2_lm5 = 0

flag_had_car_message3_lm5 = 0

flag_had_car_message4_lm5 = 0

flag_had_car_message5_lm5 = 0

flag_had_car_message6_lm5 = 0

flag_had_car_message7_lm5 = 0

flag_had_car_message8_lm5 = 0

counter_girls_trying_to_get_to_ball = 0

flag_timer_prossie1_lm5 = 0  // If the girls get stuck

flag_timer_prossie2_lm5 = 0 // If the girls get stuck

flag_timer_prossie3_lm5 = 0 // If the girls get stuck

flag_timer_prossie4_lm5 = 0	// If the girls get stuck

flag_timer_prossie5_lm5 = 0 // If the girls get stuck

flag_timer_prossie6_lm5 = 0 // If the girls get stuck

flag_timer_prossie7_lm5 = 0	// If the girls get stuck

flag_timer_prossie8_lm5 = 0	// If the girls get stuck


// *****************************************START OF CUTSCENE*******************************
{

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_luigi5_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( LM5 ) 15000 2 //"Fuzz Ball"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 LUIGI
LOAD_SPECIAL_CHARACTER 2 MICKY

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR
LOAD_SPECIAL_MODEL cut_obj2 LUIGIH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 MICKYH
REQUEST_MODEL indhibuild3
REQUEST_MODEL luigiclubout
REQUEST_MODEL luigiineerclub

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 926.54 -471.72 1.0 830.76 -257.96 25.0

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED indhibuild3
OR NOT HAS_MODEL_LOADED luigiclubout
OR NOT HAS_MODEL_LOADED	luigiineerclub

	WAIT 0

ENDWHILE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE l5_tfb

SET_CUTSCENE_OFFSET 900.782 -427.523 13.829

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_luigi

SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_micky

SET_CUTSCENE_ANIM cs_micky micky

CREATE_CUTSCENE_HEAD cs_luigi CUT_OBJ2 cs_luigihead

SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_micky CUT_OBJ4 cs_mickyhead

SET_CUTSCENE_HEAD_ANIM cs_mickyhead micky

CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor

SET_CUTSCENE_ANIM cs_ludoor LUDOOR

//CLEAR_AREA 902.2 -425.8 13.9 1.0 TRUE
//SET_PLAYER_COORDINATES player 902.2 -425.8 13.9

CLEAR_AREA 896.6 -426.2 13.9 1.0 TRUE
SET_PLAYER_COORDINATES player 896.6 -426.2 13.9

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 11950
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM5_A ) 10000 1 //"The Policeman's Ball is being held at the old school hall near the Callahan Bridge"

WHILE cs_time < 15702
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM5_B ) 10000 1 //"and they'll be looking for some "old school action."

WHILE cs_time < 17617
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM5_C ) 10000 1 //"Now I got girls all over town walking the streets."

WHILE cs_time < 20281
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM5_D ) 10000 1 //"Get 'em to the ball they'll make a bundle"

WHILE cs_time < 22295
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM5_E ) 10000 1 //"Get as many of them there as you can before those cops have drunk away their green."

WHILE cs_time < 25606
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM5_E )

WHILE cs_time < 26000
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

SWITCH_RUBBISH ON

SWITCH_STREAMING ON

LOAD_SCENE 920.3 -425.4 15.0

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4

MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3

MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout

MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub

SET_PED_DENSITY_MULTIPLIER 1.0

// *****************************************END OF CUTSCENE*********************************
SWITCH_CAR_GENERATOR gen_car28 0

ADD_SPHERE 999.9 -879.3 14.0 4.0 sphere_lm5

REQUEST_MODEL PED_PROSTITUTE

REQUEST_MODEL PED_PROSTITUTE2

WHILE NOT HAS_MODEL_LOADED PED_PROSTITUTE
OR NOT HAS_MODEL_LOADED PED_PROSTITUTE2
 
	WAIT 0

ENDWHILE

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

CREATE_CAR CAR_POLICE 1027.7 -873.1 13.9 cop_car1_lm5

SET_CAR_HEADING cop_car1_lm5 90.0

LOCK_CAR_DOORS cop_car1_lm5 CARLOCK_UNLOCKED

CREATE_CAR CAR_POLICE 998.68 -860.80 14.5 cop_car2_lm5

SET_CAR_HEADING cop_car2_lm5 90.0

LOCK_CAR_DOORS cop_car2_lm5 CARLOCK_UNLOCKED

CREATE_OBJECT_NO_OFFSET policeballsigns 1010.74 -896.46 24.161 fuzzball_sign

ADD_CONTINUOUS_SOUND 999.9 -892.4 16.0 SOUND_POLICE_BALL_LOOP_L ball_sounds

SET_OBJECT_HEADING fuzz_door1 270.0

SET_OBJECT_HEADING fuzz_door2 270.0 

DISPLAY_ONSCREEN_TIMER timer_lm5

ADD_BLIP_FOR_COORD 999.9 -879.3 -100.0 radar_blip_coord1_lm5

// creates prossie 1

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE2 870.0 -482.0 -100.0 prossie1_lm5

SET_CHAR_HEADING prossie1_lm5 180.0

CLEAR_CHAR_THREAT_SEARCH prossie1_lm5

ADD_BLIP_FOR_CHAR prossie1_lm5 radarped_prossie1_lm5

flag_blip_on_prossie1_lm5 = 1

SET_CHAR_RUNNING prossie1_lm5 TRUE


// creates prossie 2

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 916.0 -90.0 -100.0 prossie2_lm5

SET_CHAR_HEADING prossie2_lm5 180.0 
		
CLEAR_CHAR_THREAT_SEARCH prossie2_lm5

ADD_BLIP_FOR_CHAR prossie2_lm5 radarped_prossie2_lm5

flag_blip_on_prossie2_lm5 = 1

SET_CHAR_RUNNING prossie2_lm5 TRUE

// creates prossie 3

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE2 1203.0 23.0 -100.0 prossie3_lm5

CLEAR_CHAR_THREAT_SEARCH prossie3_lm5

ADD_BLIP_FOR_CHAR prossie3_lm5 radarped_prossie3_lm5

flag_blip_on_prossie3_lm5 = 1

SET_CHAR_RUNNING prossie3_lm5 TRUE

// creates prossie 4

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 1240.0 -336.0 -100.0 prossie4_lm5

SET_CHAR_HEADING prossie4_lm5 180.0 

CLEAR_CHAR_THREAT_SEARCH prossie4_lm5

ADD_BLIP_FOR_CHAR prossie4_lm5 radarped_prossie4_lm5

flag_blip_on_prossie4_lm5 = 1

SET_CHAR_RUNNING prossie4_lm5 TRUE

// creates prossie 5

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE2 1231.0 -511.0 -100.0 prossie5_lm5

CLEAR_CHAR_THREAT_SEARCH prossie5_lm5

ADD_BLIP_FOR_CHAR prossie5_lm5 radarped_prossie5_lm5

flag_blip_on_prossie5_lm5 = 1

SET_CHAR_RUNNING prossie5_lm5 TRUE

// creates prossie 6

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 1360.0 -798.0 -100.0 prossie6_lm5

CLEAR_CHAR_THREAT_SEARCH prossie6_lm5

ADD_BLIP_FOR_CHAR prossie6_lm5 radarped_prossie6_lm5

flag_blip_on_prossie6_lm5 = 1

SET_CHAR_RUNNING prossie6_lm5 TRUE

// creates prossie 7

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE2 1093.0 -973.0 -100.0 prossie7_lm5

CLEAR_CHAR_THREAT_SEARCH prossie7_lm5

ADD_BLIP_FOR_CHAR prossie7_lm5 radarped_prossie7_lm5

flag_blip_on_prossie7_lm5 = 1

SET_CHAR_RUNNING prossie7_lm5 TRUE

// creates prossie 8

CREATE_CHAR PEDTYPE_PROSTITUTE PED_PROSTITUTE 975.0 -754.0 -100.0 prossie8_lm5

SET_CHAR_HEADING prossie8_lm5 180.0

CLEAR_CHAR_THREAT_SEARCH prossie8_lm5

ADD_BLIP_FOR_CHAR prossie8_lm5 radarped_prossie8_lm5

flag_blip_on_prossie8_lm5 = 1

SET_CHAR_RUNNING prossie8_lm5 TRUE

IF timer_help_message_displayed = 0
	PRINT_HELP ( TIMER ) //"This is a timed mission, you must complete it before the timer runs out."
	timer_help_message_displayed = 1
ENDIF

PRINT_NOW ( LM5_7 ) 7000 1 //"You need to get a minimum of four girls to the ball!"

DISPLAY_ONSCREEN_COUNTER_WITH_STRING counter_no_of_girls_at_the_ball COUNTER_DISPLAY_NUMBER ( LM5_9 )

// checking to see how many girls the player get to the ball

prossie_checks:

WHILE timer_lm5 > 0
		
	WAIT 0

	CLEAR_AREA 1000.4 -886.7 14.4 6.0 FALSE // This should clear the area

	GOSUB check_for_dead_prossies

	IF number_of_dead_prossies > 0
		PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
		GOTO mission_luigi5_failed
	ENDIF
		
	IF counter_no_of_girls_at_the_ball = 8
		GOTO mission_luigi5_passed
	ENDIF
	
	IF IS_PLAYER_IN_ANY_CAR player
		STORE_CAR_PLAYER_IS_IN player vehicle_lm5
		GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
		GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
	ENDIF

	room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
		
//starts checking for prossie1
		
IF flag_prossie1_at_ball = 0
		   
	IF flag_prossie1_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie1_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message1_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message1_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie1_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message1_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie1_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie1_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie1_lm5 player
			ENDIF
			
			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5 
				ENDIF

				IF room_left_in_car_lm5 > 0
									
					SET_PLAYER_AS_LEADER prossie1_lm5 player
					REMOVE_BLIP radarped_prossie1_lm5
					flag_blip_on_prossie1_lm5 = 0
											   					
						WHILE NOT IS_CHAR_IN_CAR prossie1_lm5 vehicle_lm5

							WAIT 0
								
							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
														
							IF flag_prossie1_at_ball = 0 
							
								IF IS_CHAR_DEAD prossie1_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE
									
									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie1_lm5 player
									AND flag_blip_on_prossie1_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie1_lm5 radarped_prossie1_lm5
										flag_blip_on_prossie1_lm5 = 1
										GOTO prossie_checks 
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie1_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie1_lm5 = 1
										SET_PLAYER_AS_LEADER prossie1_lm5 player
										REMOVE_BLIP radarped_prossie1_lm5 
										flag_blip_on_prossie1_lm5 = 0
									ENDIF

								ENDIF	
								
							ENDIF
						    						   							
						ENDWHILE
					   	flag_prossie1_lm5_in_car = 1
		 				SET_CHAR_RUNNING prossie1_lm5 FALSE
		 
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	
	   	   
		IF flag_prossie1_lm5_in_car = 1

			IF flag_prossie1_in_car_park = 0
				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie1_lm5 player
				AND flag_blip_on_prossie1_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie1_lm5 radarped_prossie1_lm5
					flag_blip_on_prossie1_lm5 = 1
					flag_prossie1_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie1_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie1_lm5 = 1
					SET_PLAYER_AS_LEADER prossie1_lm5 player
					REMOVE_BLIP radarped_prossie1_lm5 
					flag_blip_on_prossie1_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie1_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie1_at_ball = 0
			AND flag_prossie1_in_car_park = 0
				WAIT 0

					IF flag_prossie1_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie1_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie1_lm5

				IF IS_CHAR_IN_ANY_CAR prossie1_lm5
					STORE_CAR_CHAR_IS_IN prossie1_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie1_lm5 vehicle_lm5
				ENDIF
				flag_prossie1_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie1_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie1_lm5
			AND flag_prossie1_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie1_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie1_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie1_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie1_told_to_go_into_ball = 1

			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie1_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie1_lm5
				REMOVE_CHAR_ELEGANTLY prossie1_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie1_at_ball = 1
			ENDIF

			IF flag_prossie1_told_to_go_into_ball = 1
			
				IF flag_prossie1_at_ball = 0

					IF flag_timer_prossie1_lm5 = 0
						timerb = 0
						flag_timer_prossie1_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie1_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF



//starts checking for prossie2
		
IF flag_prossie2_at_ball = 0

		IF IS_CHAR_DEAD prossie2_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie2_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie2_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message2_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message2_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie2_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message2_lm5 = 0
		ENDIF	
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie2_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie2_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie2_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5 
				ENDIF
				
				IF room_left_in_car_lm5 > 0

						SET_PLAYER_AS_LEADER prossie2_lm5 player
						REMOVE_BLIP radarped_prossie2_lm5
						flag_blip_on_prossie2_lm5 = 0
											
						WHILE NOT IS_CHAR_IN_CAR prossie2_lm5 vehicle_lm5

							WAIT 0

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
							
							
							IF flag_prossie2_at_ball = 0

								IF IS_CHAR_DEAD prossie2_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie2_lm5 player
									AND flag_blip_on_prossie2_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie2_lm5 radarped_prossie2_lm5
										flag_blip_on_prossie2_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie2_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie2_lm5 = 1
										SET_PLAYER_AS_LEADER prossie2_lm5 player
										REMOVE_BLIP radarped_prossie2_lm5 
										flag_blip_on_prossie2_lm5 = 0
									ENDIF

								ENDIF

							ENDIF
						  						  							
						ENDWHILE
						flag_prossie2_lm5_in_car = 1
						SET_CHAR_RUNNING prossie2_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	


	   	   
		IF flag_prossie2_lm5_in_car = 1

			IF flag_prossie2_in_car_park = 0
				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie2_lm5 player
				AND flag_blip_on_prossie2_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie2_lm5 radarped_prossie2_lm5
					flag_blip_on_prossie2_lm5 = 1
					flag_prossie2_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie2_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie2_lm5 = 1
					SET_PLAYER_AS_LEADER prossie2_lm5 player
					REMOVE_BLIP radarped_prossie2_lm5 
					flag_blip_on_prossie2_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie2_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie2_at_ball = 0
			AND flag_prossie2_in_car_park = 0
				WAIT 0

					IF flag_prossie2_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie2_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie2_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie2_lm5
					STORE_CAR_CHAR_IS_IN prossie2_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie2_lm5 vehicle_lm5
				ENDIF
				flag_prossie2_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie2_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie2_lm5
			AND flag_prossie2_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie2_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie2_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie2_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
			   	//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie2_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie2_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie2_lm5
				REMOVE_CHAR_ELEGANTLY prossie2_lm5
				//++ counter_no_of_girls_at_the_ball
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie2_at_ball = 1
			ENDIF

			IF flag_prossie2_told_to_go_into_ball = 1
			
				IF flag_prossie2_at_ball = 0

					IF flag_timer_prossie2_lm5 = 0
						timerb = 0
						flag_timer_prossie2_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie2_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF
  	


// starts check for prossie 3

IF flag_prossie3_at_ball = 0

		IF IS_CHAR_DEAD prossie3_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie3_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie3_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message3_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message3_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie3_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message3_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie3_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie3_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie3_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF

				IF room_left_in_car_lm5 > 0
					
						SET_PLAYER_AS_LEADER prossie3_lm5 player
						REMOVE_BLIP radarped_prossie3_lm5
						flag_blip_on_prossie3_lm5 = 0 
					
						WHILE NOT IS_CHAR_IN_CAR prossie3_lm5 vehicle_lm5

							WAIT 0

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle has been wrecked!"
								GOTO mission_luigi5_failed
							ENDIF

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF
													
														
							IF flag_prossie3_at_ball = 0
								
								IF IS_CHAR_DEAD prossie3_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie3_lm5 player
									AND flag_blip_on_prossie3_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie3_lm5 radarped_prossie3_lm5
										flag_blip_on_prossie3_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie3_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie3_lm5 = 1
										SET_PLAYER_AS_LEADER prossie3_lm5 player
										REMOVE_BLIP radarped_prossie3_lm5 
										flag_blip_on_prossie3_lm5 = 0
									ENDIF

								ENDIF
									
							ENDIF

	  					ENDWHILE
						flag_prossie3_lm5_in_car = 1
						SET_CHAR_RUNNING prossie3_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	
	   	   
		IF flag_prossie3_lm5_in_car = 1

			IF flag_prossie3_in_car_park = 0
							

				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie3_lm5 player
				AND flag_blip_on_prossie3_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie3_lm5 radarped_prossie3_lm5
					flag_blip_on_prossie3_lm5 = 1
					flag_prossie3_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie3_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie3_lm5 = 1
					SET_PLAYER_AS_LEADER prossie3_lm5 player
					REMOVE_BLIP radarped_prossie3_lm5 
					flag_blip_on_prossie3_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie3_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie3_at_ball = 0
			AND flag_prossie3_in_car_park = 0
				WAIT 0

					IF flag_prossie3_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie3_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie3_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie3_lm5
					STORE_CAR_CHAR_IS_IN prossie3_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie3_lm5 vehicle_lm5
				ENDIF
				flag_prossie3_in_car_park = 1				
			ENDIF
		
		ENDIF
		
		IF flag_prossie3_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie3_lm5
			AND flag_prossie3_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie3_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie3_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie3_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie3_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie3_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie3_lm5
				REMOVE_CHAR_ELEGANTLY prossie3_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie3_at_ball = 1
			ENDIF

			IF flag_prossie3_told_to_go_into_ball = 1
			
				IF flag_prossie3_at_ball = 0

					IF flag_timer_prossie3_lm5 = 0
						timerb = 0
						flag_timer_prossie3_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie3_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF
  	
  
 
// checks for prossie 4

IF flag_prossie4_at_ball = 0

		IF IS_CHAR_DEAD prossie4_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie4_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie4_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message4_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message4_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie4_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message4_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie4_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie4_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie4_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF

				IF room_left_in_car_lm5 > 0
					
						SET_PLAYER_AS_LEADER prossie4_lm5 player
						REMOVE_BLIP radarped_prossie4_lm5
						flag_blip_on_prossie4_lm5 = 0
											
						WHILE NOT IS_CHAR_IN_CAR prossie4_lm5 vehicle_lm5

							WAIT 0

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF


							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
						   						

							IF flag_prossie4_at_ball = 0

								IF IS_CHAR_DEAD prossie4_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie4_lm5 player
									AND flag_blip_on_prossie4_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie4_lm5 radarped_prossie4_lm5
										flag_blip_on_prossie4_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie4_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie4_lm5 = 1
										SET_PLAYER_AS_LEADER prossie4_lm5 player
										REMOVE_BLIP radarped_prossie4_lm5 
										flag_blip_on_prossie4_lm5 = 0
									ENDIF

								ENDIF

							ENDIF

														
						ENDWHILE
						flag_prossie4_lm5_in_car = 1
						SET_CHAR_RUNNING prossie4_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	
 
 	   	   
		IF flag_prossie4_lm5_in_car = 1

			IF flag_prossie4_in_car_park = 0
								
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie4_lm5 player
				AND flag_blip_on_prossie4_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie4_lm5 radarped_prossie4_lm5
					flag_blip_on_prossie4_lm5 = 1
					flag_prossie4_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie4_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie4_lm5 = 1
					SET_PLAYER_AS_LEADER prossie4_lm5 player
					REMOVE_BLIP radarped_prossie4_lm5 
					flag_blip_on_prossie4_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie4_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie4_at_ball = 0
			AND flag_prossie4_in_car_park = 0
				WAIT 0

					IF flag_prossie4_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie4_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie4_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie4_lm5
					STORE_CAR_CHAR_IS_IN prossie4_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie4_lm5 vehicle_lm5
				ENDIF
				flag_prossie4_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie4_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie4_lm5
			AND flag_prossie4_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie4_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie4_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie4_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie4_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie4_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie4_lm5
				REMOVE_CHAR_ELEGANTLY prossie4_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie4_at_ball = 1
			ENDIF

			IF flag_prossie4_told_to_go_into_ball = 1
			
				IF flag_prossie4_at_ball = 0

					IF flag_timer_prossie4_lm5 = 0
						timerb = 0
						flag_timer_prossie4_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie4_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF
 

 
  	
// checks for prossie 5

IF flag_prossie5_at_ball = 0

		IF IS_CHAR_DEAD prossie5_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie5_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie5_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message5_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message5_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie5_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message5_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie5_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie5_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie5_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF
				
				IF room_left_in_car_lm5 > 0
										
						SET_PLAYER_AS_LEADER prossie5_lm5 player
						REMOVE_BLIP radarped_prossie5_lm5
						flag_blip_on_prossie5_lm5 = 0
					
						WHILE NOT IS_CHAR_IN_CAR prossie5_lm5 vehicle_lm5

							WAIT 0

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
								
						   	IF flag_prossie5_at_ball = 0
							
								IF IS_CHAR_DEAD prossie5_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie5_lm5 player
									AND flag_blip_on_prossie5_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie5_lm5 radarped_prossie5_lm5
										flag_blip_on_prossie5_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie5_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie5_lm5 = 1
										SET_PLAYER_AS_LEADER prossie5_lm5 player
										REMOVE_BLIP radarped_prossie5_lm5 
										flag_blip_on_prossie5_lm5 = 0
									ENDIF

								ENDIF

							ENDIF

												   							
						ENDWHILE
						flag_prossie5_lm5_in_car = 1
						SET_CHAR_RUNNING prossie5_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	

	   	   
		IF flag_prossie5_lm5_in_car = 1

			IF flag_prossie5_in_car_park = 0
				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie5_lm5 player
				AND flag_blip_on_prossie5_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie5_lm5 radarped_prossie5_lm5
					flag_blip_on_prossie5_lm5 = 1
					flag_prossie5_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie5_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie5_lm5 = 1
					SET_PLAYER_AS_LEADER prossie5_lm5 player
					REMOVE_BLIP radarped_prossie5_lm5 
					flag_blip_on_prossie5_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie5_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie5_at_ball = 0
			AND flag_prossie5_in_car_park = 0
				WAIT 0

					IF flag_prossie5_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie5_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie5_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie5_lm5
					STORE_CAR_CHAR_IS_IN prossie5_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie5_lm5 vehicle_lm5
				ENDIF
				flag_prossie5_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie5_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie5_lm5
			AND flag_prossie5_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie5_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie5_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie5_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie5_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie5_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie5_lm5
				REMOVE_CHAR_ELEGANTLY prossie5_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie5_at_ball = 1
			ENDIF

			IF flag_prossie5_told_to_go_into_ball = 1
			
				IF flag_prossie5_at_ball = 0

					IF flag_timer_prossie5_lm5 = 0
						timerb = 0
						flag_timer_prossie5_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie5_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF

 
// checks for prossie 6

IF flag_prossie6_at_ball = 0

		IF IS_CHAR_DEAD prossie6_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie6_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie6_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message6_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message6_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie6_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message6_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie6_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie6_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie6_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF

				IF room_left_in_car_lm5 > 0
										
						SET_PLAYER_AS_LEADER prossie6_lm5 player
						REMOVE_BLIP radarped_prossie6_lm5
						flag_blip_on_prossie6_lm5 = 0
											
						WHILE NOT IS_CHAR_IN_CAR prossie6_lm5 vehicle_lm5

							WAIT 0
								
							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
											   							
						   
							IF flag_prossie6_at_ball = 0

								IF IS_CHAR_DEAD prossie6_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie6_lm5 player
									AND flag_blip_on_prossie6_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie6_lm5 radarped_prossie6_lm5
										flag_blip_on_prossie6_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie6_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie6_lm5 = 1
										SET_PLAYER_AS_LEADER prossie6_lm5 player
										REMOVE_BLIP radarped_prossie6_lm5 
										flag_blip_on_prossie6_lm5 = 0
									ENDIF

								ENDIF

							ENDIF

						   							
						ENDWHILE
						
						flag_prossie6_lm5_in_car = 1
						
						SET_CHAR_RUNNING prossie6_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	

	   	   
		IF flag_prossie6_lm5_in_car = 1

			IF flag_prossie6_in_car_park = 0

				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie6_lm5 player
				AND flag_blip_on_prossie6_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie6_lm5 radarped_prossie6_lm5
					flag_blip_on_prossie6_lm5 = 1
					flag_prossie6_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie6_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie6_lm5 = 1
					SET_PLAYER_AS_LEADER prossie6_lm5 player
					REMOVE_BLIP radarped_prossie6_lm5 
					flag_blip_on_prossie6_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie6_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie6_at_ball = 0
			AND flag_prossie6_in_car_park = 0
				WAIT 0

					IF flag_prossie6_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie6_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie6_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie6_lm5
					STORE_CAR_CHAR_IS_IN prossie6_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie6_lm5 vehicle_lm5
				ENDIF
				flag_prossie6_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie6_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie6_lm5
			AND flag_prossie6_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie6_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie6_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie6_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie6_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie6_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie6_lm5
				REMOVE_CHAR_ELEGANTLY prossie6_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie6_at_ball = 1
			ENDIF

			IF flag_prossie6_told_to_go_into_ball = 1
			
				IF flag_prossie6_at_ball = 0

					IF flag_timer_prossie6_lm5 = 0
						timerb = 0
						flag_timer_prossie6_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie6_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF

  	
// checks for prossie 7

IF flag_prossie7_at_ball = 0

		IF IS_CHAR_DEAD prossie7_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie7_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie7_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message7_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message7_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie7_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message7_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie7_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie7_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie7_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF

				IF room_left_in_car_lm5 > 0
																	
						SET_PLAYER_AS_LEADER prossie7_lm5 player
						REMOVE_BLIP radarped_prossie7_lm5
						flag_blip_on_prossie7_lm5 = 0
					
						WHILE NOT IS_CHAR_IN_CAR prossie7_lm5 vehicle_lm5

							WAIT 0

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
													   
							IF flag_prossie7_at_ball = 0

								IF IS_CHAR_DEAD prossie7_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie7_lm5 player
									AND flag_blip_on_prossie7_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie7_lm5 radarped_prossie7_lm5
										flag_blip_on_prossie7_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie7_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie7_lm5 = 1
										SET_PLAYER_AS_LEADER prossie7_lm5 player
										REMOVE_BLIP radarped_prossie7_lm5 
										flag_blip_on_prossie7_lm5 = 0
									ENDIF

								ENDIF

							ENDIF

														
						ENDWHILE
						flag_prossie7_lm5_in_car = 1
						SET_CHAR_RUNNING prossie7_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF
	
 
 	   	   
		IF flag_prossie7_lm5_in_car = 1

			IF flag_prossie7_in_car_park = 0

				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie7_lm5 player
				AND flag_blip_on_prossie7_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie7_lm5 radarped_prossie7_lm5
					flag_blip_on_prossie7_lm5 = 1
					flag_prossie7_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie7_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie7_lm5 = 1
					SET_PLAYER_AS_LEADER prossie7_lm5 player
					REMOVE_BLIP radarped_prossie7_lm5 
					flag_blip_on_prossie7_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie7_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie7_at_ball = 0
			AND flag_prossie7_in_car_park = 0
				WAIT 0

					IF flag_prossie7_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie7_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie7_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie7_lm5
					STORE_CAR_CHAR_IS_IN prossie7_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie7_lm5 vehicle_lm5
				ENDIF
				flag_prossie7_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie7_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie7_lm5
			AND flag_prossie7_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie7_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie7_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie7_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie7_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie7_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie7_lm5
				REMOVE_CHAR_ELEGANTLY prossie7_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie7_at_ball = 1
			ENDIF

			IF flag_prossie7_told_to_go_into_ball = 1
			
				IF flag_prossie7_at_ball = 0

					IF flag_timer_prossie7_lm5 = 0
						timerb = 0
						flag_timer_prossie7_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie7_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

ENDIF


// checks for prossie 8

IF flag_prossie8_at_ball = 0

		IF IS_CHAR_DEAD prossie8_lm5
			PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
			GOTO mission_luigi5_failed
		ENDIF

	IF flag_prossie8_lm5_in_car = 0

		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player prossie8_lm5 8.0 8.0 2.0 FALSE
		AND flag_had_car_message8_lm5 = 0
			PRINT_NOW ( LM5_3 ) 5000 1 //"You need a car!"
			flag_had_car_message8_lm5 = 1
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player prossie8_lm5 8.0 8.0 2.0 FALSE
			flag_had_car_message8_lm5 = 0
		ENDIF
		
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player prossie8_lm5 8.0 8.0 2.0 FALSE

			IF flag_prossie8_lm5_in_car = 0
				TURN_CHAR_TO_FACE_PLAYER prossie8_lm5 player
			ENDIF

			IF IS_PLAYER_STOPPED player

				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player vehicle_lm5
					GET_MAXIMUM_NUMBER_OF_PASSENGERS vehicle_lm5 max_no_of_passengers_lm5
					GET_NUMBER_OF_PASSENGERS vehicle_lm5 no_of_passengers_lm5 
					room_left_in_car_lm5 = max_no_of_passengers_lm5 - no_of_passengers_lm5
				ENDIF
				
				IF room_left_in_car_lm5 > 0
										
						SET_PLAYER_AS_LEADER prossie8_lm5 player
						REMOVE_BLIP radarped_prossie8_lm5
						flag_blip_on_prossie8_lm5 = 0
					
						WHILE NOT IS_CHAR_IN_CAR prossie8_lm5 vehicle_lm5

							WAIT 0

							GOSUB check_for_dead_prossies

							IF number_of_dead_prossies > 0
								PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
								GOTO mission_luigi5_failed
							ENDIF

							IF IS_CAR_DEAD vehicle_lm5
								PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle is wrecked!"
								GOTO mission_luigi5_failed
							ENDIF
													  
							IF flag_prossie8_at_ball = 0

								IF IS_CHAR_DEAD prossie8_lm5
									PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
									GOTO mission_luigi5_failed
								ELSE

									IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie8_lm5 player
									AND flag_blip_on_prossie8_lm5 = 0
										PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
										ADD_BLIP_FOR_CHAR prossie8_lm5 radarped_prossie8_lm5
										flag_blip_on_prossie8_lm5 = 1
										GOTO prossie_checks
									ENDIF
	
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie8_lm5 8.0 8.0 FALSE
									AND flag_blip_on_prossie8_lm5 = 1
										SET_PLAYER_AS_LEADER prossie8_lm5 player
										REMOVE_BLIP radarped_prossie8_lm5 
										flag_blip_on_prossie8_lm5 = 0
									ENDIF
																	
								ENDIF

							ENDIF
							
						ENDWHILE
						flag_prossie8_lm5_in_car = 1
						SET_CHAR_RUNNING prossie8_lm5 FALSE
				ELSE
					IF flag_had_room_message_lm5 = 0
						PRINT_NOW ( LM5_1 ) 7000 1 //"Get a bigger car!"
						flag_had_room_message_lm5 = 1
					ENDIF //room message
				ENDIF //room left in car
			ENDIF  //stopped
		ELSE
			flag_had_room_message_lm5 = 0
		ENDIF  // locate
	ENDIF

	
	   	   
		IF flag_prossie8_lm5_in_car = 1

			IF flag_prossie8_in_car_park = 0

				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP prossie8_lm5 player
				AND flag_blip_on_prossie8_lm5 = 0
					PRINT_NOW ( HEY5 ) 5000 1 //"You have left one of the girls behind go and get her!"
					ADD_BLIP_FOR_CHAR prossie8_lm5 radarped_prossie8_lm5
					flag_blip_on_prossie8_lm5 = 1
					flag_prossie8_lm5_in_car = 0
				ENDIF
	
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player prossie8_lm5 8.0 8.0 FALSE
				AND flag_blip_on_prossie8_lm5 = 1
					SET_PLAYER_AS_LEADER prossie8_lm5 player
					REMOVE_BLIP radarped_prossie8_lm5 
					flag_blip_on_prossie8_lm5 = 0
				ENDIF

			ENDIF

			IF IS_CHAR_STOPPED_IN_AREA_3D prossie8_lm5 1003.5 -883.0 13.9 996.8 -876.4 18.0 FALSE
			AND flag_prossie8_at_ball = 0
			AND flag_prossie8_in_car_park = 0
				WAIT 0

					IF flag_prossie8_at_ball = 0 
							
						IF IS_CHAR_DEAD prossie8_lm5
							PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
							GOTO mission_luigi5_failed
						ENDIF

					ENDIF

				LEAVE_GROUP prossie8_lm5
				
				IF IS_CHAR_IN_ANY_CAR prossie8_lm5
					STORE_CAR_CHAR_IS_IN prossie8_lm5 vehicle_lm5
					SET_CHAR_OBJ_LEAVE_CAR prossie8_lm5 vehicle_lm5
				ENDIF
				flag_prossie8_in_car_park = 1				
			ENDIF
		
		ENDIF

		IF flag_prossie8_in_car_park = 1
	
			IF NOT IS_CHAR_IN_ANY_CAR prossie8_lm5
			AND flag_prossie8_told_to_go_into_ball = 0
				WAIT 0

				IF flag_prossie8_at_ball = 0 
							
					IF IS_CHAR_DEAD prossie8_lm5
						PRINT_NOW ( LM5_2 ) 5000 1 //"A girl has died!"
						GOTO mission_luigi5_failed
					ENDIF

				ENDIF

				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie8_lm5 999.0 -891.0
				++ counter_no_of_girls_at_the_ball
				ADD_ONE_OFF_SOUND 999.9 -879.3 15.0 SOUND_PART_MISSION_COMPLETE
			   //	PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				CLEAR_WANTED_LEVEL player
				flag_prossie8_told_to_go_into_ball = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_2D prossie8_lm5 999.0 -891.0 1.0 1.0 FALSE
				CHAR_SET_IDLE prossie8_lm5
				REMOVE_CHAR_ELEGANTLY prossie8_lm5
				//++ counter_no_of_girls_at_the_ball
				//PRINT_WITH_NUMBER_NOW ( LM5_8 ) counter_no_of_girls_at_the_ball 5000 1 // Girls at ball
				flag_prossie8_at_ball = 1
			ENDIF

			IF flag_prossie8_told_to_go_into_ball = 1
			
				IF flag_prossie8_at_ball = 0

					IF flag_timer_prossie8_lm5 = 0
						timerb = 0
						flag_timer_prossie8_lm5 = 1
					ENDIF

					IF timerb > 20000
						SET_CHAR_COORDINATES prossie8_lm5 999.0 -891.0 14.3
					ENDIF
					
				ENDIF
				
			ENDIF  

		ENDIF

ENDIF

	      		
ENDWHILE

// pass or fail checks

IF  counter_no_of_girls_at_the_ball < 4
	PRINT_NOW ( OUTTIME ) 5000 1 //"You ran out of time!"
	GOTO mission_luigi5_failed
ELSE
	GOTO mission_luigi5_passed
ENDIF
	   		


// Mission Luigi1 failed

mission_luigi5_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN
		
		
// mission Luigi1 passed

mission_luigi5_passed:

FREEZE_ONSCREEN_TIMER TRUE

GOSUB mission_end_cutscene

IF counter_girls_trying_to_get_to_ball > 0
	REMOVE_SPHERE sphere_lm5
	SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL player OFF
	SET_POLICE_IGNORE_PLAYER player ON
	SET_EVERYONE_IGNORE_PLAYER player ON
	CLEAR_AREA 1006.845 -885.5 14.7 2.0 TRUE 
	SET_FIXED_CAMERA_POSITION 1006.845 -885.5 14.7 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 1005.9 -885.0 14.6 JUMP_CUT
	GOSUB mission_end_cutscene2
	SWITCH_WIDESCREEN OFF
	RESTORE_CAMERA_JUMPCUT
	SET_PLAYER_CONTROL player ON
	SET_POLICE_IGNORE_PLAYER player OFF
	SET_EVERYONE_IGNORE_PLAYER player OFF
ENDIF 

flag_luigi_mission5_passed = 1
flag_all_luigi_missions_passed = 1
REGISTER_MISSION_PASSED ( LM5 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1												 
score_lm5 = counter_no_of_girls_at_the_ball * 500
PRINT_WITH_NUMBER_BIG ( M_PASS ) score_lm5 10000 1 //"Mission Passed!"
ADD_SCORE player score_lm5
CLEAR_WANTED_LEVEL player
IF counter_no_of_girls_at_the_ball = 8
	PRINT_WITH_NUMBER_NOW ( BONUS ) 2000 5000 1 //"Bonus of $2000!" 
	ADD_SCORE player 2000
ENDIF
REMOVE_BLIP luigi_contact_blip
RETURN		
		


// mission cleanup

mission_cleanup_luigi5:

flag_player_on_mission = 0
flag_player_on_luigi_mission = 0
SWITCH_CAR_GENERATOR gen_car28 101
REMOVE_SOUND ball_sounds
REMOVE_SPHERE sphere_lm5
MARK_OBJECT_AS_NO_LONGER_NEEDED fuzzball_sign 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PROSTITUTE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PROSTITUTE2
CLEAR_ONSCREEN_TIMER timer_lm5
FREEZE_ONSCREEN_TIMER FALSE
CLEAR_ONSCREEN_COUNTER counter_no_of_girls_at_the_ball 
REMOVE_BLIP radar_blip_coord1_lm5
REMOVE_BLIP radarped_prossie1_lm5
REMOVE_BLIP radarped_prossie2_lm5
REMOVE_BLIP radarped_prossie3_lm5
REMOVE_BLIP radarped_prossie4_lm5
REMOVE_BLIP radarped_prossie5_lm5
REMOVE_BLIP radarped_prossie6_lm5
REMOVE_BLIP radarped_prossie7_lm5
REMOVE_BLIP radarped_prossie8_lm5
MISSION_HAS_FINISHED


START_NEW_SCRIPT close_fuzz_doors	

RETURN

check_for_dead_prossies:


number_of_dead_prossies = 0

	IF flag_prossie1_at_ball = 0 
		IF IS_CHAR_DEAD prossie1_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

	IF flag_prossie2_at_ball = 0
		IF IS_CHAR_DEAD prossie2_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF
	
	IF flag_prossie3_at_ball = 0
		IF IS_CHAR_DEAD prossie3_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

	IF flag_prossie4_at_ball = 0
		IF IS_CHAR_DEAD prossie4_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF


	IF flag_prossie5_at_ball = 0
		IF IS_CHAR_DEAD prossie5_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

	IF flag_prossie6_at_ball = 0
		IF IS_CHAR_DEAD prossie6_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

	IF flag_prossie7_at_ball = 0
		IF IS_CHAR_DEAD prossie7_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

	IF flag_prossie8_at_ball = 0
		IF IS_CHAR_DEAD prossie8_lm5
			number_of_dead_prossies++
		ENDIF
	ENDIF

RETURN


mission_end_cutscene:

	IF flag_prossie1_at_ball = 0

		IF flag_prossie1_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie1_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie1_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie2_at_ball = 0
		
		 IF flag_prossie2_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie2_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie2_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie3_at_ball = 0

		IF flag_prossie3_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie3_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie3_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie4_at_ball = 0

		IF flag_prossie4_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie4_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie4_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie5_at_ball = 0

		IF flag_prossie5_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie5_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie5_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie6_at_ball = 0

		IF flag_prossie6_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie6_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie6_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie7_at_ball = 0

		IF flag_prossie7_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie7_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie7_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF

	IF flag_prossie8_at_ball = 0

		IF flag_prossie8_in_car_park = 1

			IF NOT IS_CHAR_DEAD prossie8_lm5 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT prossie8_lm5 999.0 -891.0
				++ counter_girls_trying_to_get_to_ball
			ENDIF

		ENDIF

	ENDIF


RETURN


mission_end_cutscene2:

timerb = 0

WHILE counter_girls_trying_to_get_to_ball > 0

	WAIT 0

	CLEAR_AREA 1000.4 -886.7 14.4 6.0 FALSE // This should clear the area
	
	IF flag_prossie1_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie1_lm5
						
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie1_lm5 999.0 -891.0 14.3
				ENDIF   
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie1_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie1_lm5
					REMOVE_CHAR_ELEGANTLY prossie1_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie1_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie1_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie2_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie2_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie2_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie2_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie2_lm5
					REMOVE_CHAR_ELEGANTLY prossie2_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie2_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie2_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie3_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie3_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie3_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie3_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie3_lm5
					REMOVE_CHAR_ELEGANTLY prossie3_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie3_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie3_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie4_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie4_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie4_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie4_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie4_lm5
					REMOVE_CHAR_ELEGANTLY prossie4_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie4_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie4_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie5_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie5_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie5_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie5_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie5_lm5
					REMOVE_CHAR_ELEGANTLY prossie5_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie5_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie5_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie6_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie6_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie6_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie6_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie6_lm5
					REMOVE_CHAR_ELEGANTLY prossie6_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie6_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie6_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie7_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie7_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie7_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie7_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie7_lm5
					REMOVE_CHAR_ELEGANTLY prossie7_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie7_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie7_at_ball = 1
			ENDIF
				
		ENDIF

		IF flag_prossie8_at_ball = 0

			IF NOT IS_CHAR_DEAD prossie8_lm5
			
				IF timerb > 20000
					SET_CHAR_COORDINATES prossie8_lm5 999.0 -891.0 14.3
				ENDIF 
		
				IF LOCATE_CHAR_ON_FOOT_2D prossie8_lm5 999.0 -891.0 1.0 1.0 FALSE
					CHAR_SET_IDLE prossie8_lm5
					REMOVE_CHAR_ELEGANTLY prossie8_lm5
					-- counter_girls_trying_to_get_to_ball
					flag_prossie8_at_ball = 1
				ENDIF

			ELSE
				-- counter_girls_trying_to_get_to_ball
				flag_prossie8_at_ball = 1
			ENDIF
				
		ENDIF

ENDWHILE

RETURN

}
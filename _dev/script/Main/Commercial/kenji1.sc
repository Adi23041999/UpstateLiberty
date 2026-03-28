MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Kenji mission 1********************************* 
// ******************************************KANBU BUST OUT*********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME kenji1

// Mission start stuff

GOSUB mission_start_kenji1

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_kenji1_failed
	ENDIF

GOSUB mission_cleanup_kenji1

MISSION_END
 
// Variables for mission

VAR_INT mission_cop_car_km1

VAR_INT radar_blip_coord1_km1

VAR_INT radar_blip_coord2_km1

VAR_INT radar_blip_coord3_km1

VAR_INT flag_player_had_car_message_km1

VAR_INT flag_player_had_bomb_message_km1

VAR_INT	flag_player_got_cops_message_km1

VAR_INT yakuza_ped1_km1

VAR_INT mission_car_km1

VAR_INT flag_player_wanted_level_changed

VAR_INT flag_blip_on_yakuza_ped1_km1

VAR_INT radar_blip_ped1_km1

VAR_INT flag_car_got_bomb_km1

VAR_INT total_counter_km1

VAR_INT	counter_bomb_km1

VAR_INT	counter_police_km1

VAR_INT car_km1 //Car at end at dojo

VAR_INT flag_had_bomb_message_km1

VAR_INT flag_blip_on_km1

VAR_INT flag_area_bomb_message_km1

VAR_INT police_alarm

VAR_INT spray_blip_km1

VAR_INT flag_spray_blip_on_km1

VAR_INT flag_bomb_km1

VAR_INT cell_beating

VAR_INT debris1

VAR_INT debris2

VAR_INT debris3

VAR_INT debris4

VAR_FLOAT debris1_x

VAR_FLOAT debris1_y

VAR_FLOAT debris1_z

VAR_FLOAT debris2_x

VAR_FLOAT debris2_y

VAR_FLOAT debris2_z

VAR_FLOAT debris3_x

VAR_FLOAT debris3_y

VAR_FLOAT debris3_z

VAR_FLOAT debris4_x

VAR_FLOAT debris4_y

VAR_FLOAT debris4_z

VAR_INT flag_dojo_blip_on

VAR_INT flag_player_wanted

VAR_INT flag_kanbu_in_group

VAR_INT sphere_km1

VAR_INT flag_player_had_dome_message_km1

VAR_INT flag_played_cop_radio_km1

// ****************************************Mission Start************************************

mission_start_kenji1:

flag_player_on_mission = 1

flag_player_on_kenji_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_had_car_message_km1 = 0

flag_player_had_bomb_message_km1 = 0

flag_player_got_cops_message_km1 = 0

flag_player_wanted_level_changed = 0

flag_blip_on_yakuza_ped1_km1 = 0

flag_car_got_bomb_km1 = 0

total_counter_km1 = 0

counter_bomb_km1 = 0

counter_police_km1 = 0

flag_had_bomb_message_km1 = 0

flag_blip_on_km1 = 0

blob_flag = 1

flag_area_bomb_message_km1 = 0

flag_spray_blip_on_km1 = 0

flag_bomb_km1 = 0

debris1_x = 0.0

debris1_y = 0.0

debris1_z = 0.0

debris2_x = 0.0

debris2_y = 0.0

debris2_z = 0.0

debris3_x = 0.0

debris3_y = 0.0

debris3_z = 0.0

debris4_x = 0.0

debris4_y = 0.0

debris4_z = 0.0

flag_dojo_blip_on = 0

flag_player_wanted = 0

flag_kanbu_in_group = 0

flag_player_had_dome_message_km1 = 0

flag_played_cop_radio_km1 = 0


{

IF flag_need_wall_change_km1 = 1
	SWAP_NEAREST_BUILDING_MODEL 328.026 -1090.262 26.941 2.0 police_celhole police_cell_wall
	flag_need_wall_change_km1 = 0
ENDIF

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_kenji1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( KM1 ) 15000 2 //"Kanbu Bust out"

SWITCH_STREAMING OFF
*/

// Cutscene stuff

LOAD_SPECIAL_CHARACTER 1 KENJI
REQUEST_MODEL PED_GANG_YAKUZA_A
REQUEST_MODEL casino_garden 

LOAD_SPECIAL_MODEL cut_obj1 KENJIH 
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A 
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED casino_garden
	 
	WAIT 0

ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE k1_kbo

SET_CUTSCENE_OFFSET 476.380 -1382.168 67.347

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_kenji

SET_CUTSCENE_ANIM cs_kenji kenji

CREATE_CUTSCENE_OBJECT PED_GANG_YAKUZA_A cs_yakuza

SET_CUTSCENE_ANIM cs_yakuza gang07

CREATE_CUTSCENE_HEAD cs_kenji CUT_OBJ1 cs_kenjihead

SET_CUTSCENE_HEAD_ANIM cs_kenjihead kenji

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 459.1 -1413.0 25.11 1.0 TRUE 

SET_PLAYER_COORDINATES player 459.1 -1413.0 25.11
							   
SET_PLAYER_HEADING player 132.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 8392
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_A ) 10000 1 //"My sister speaks highly of you,"

WHILE cs_time < 9918
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_E ) 10000 1 //"though I am yet to be convinced that a gaijin can offer anything but disappointment. We shall see..."

WHILE cs_time < 13732
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_B ) 10000 1 //"Perhaps you could help deal with a situation that has me at a disadvantage."

WHILE cs_time < 17547
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_F ) 10000 1 //"Of course failure has it's own disgrace."

WHILE cs_time < 20683
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_C ) 10000 1 //"A Yakuza Kanbu is in custody awaiting transfer for trial."

WHILE cs_time < 23650
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_G ) 10000 1 //"He is a valued member of the family."

WHILE cs_time < 25430
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KM1_H ) 10000 1 //"Break him out of custody and get him to the dojo."

WHILE cs_time < 28749
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( KM1_H )
 
WHILE cs_time < 31200
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

SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 


//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED casino_garden 

// *******************************************END OF CUTSCENE*******************************

PRINT_NOW ( KM1_1 ) 5000 1 //"Steal a cop car!"

REQUEST_MODEL rubble01
REQUEST_MODEL rubble02
LOAD_MISSION_AUDIO K1_A

WHILE NOT HAS_MODEL_LOADED rubble01
OR NOT HAS_MODEL_LOADED rubble02
OR NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0
	
ENDWHILE 

// waiting for the player to be in a cop car

ADD_CONTINUOUS_SOUND 326.4 -1092.4 26.0 SOUND_POLICE_CELL_BEATING_LOOP_L cell_beating

WHILE NOT IS_PLAYER_IN_MODEL player CAR_POLICE

	WAIT 0
   
ENDWHILE

STORE_CAR_PLAYER_IS_IN player mission_cop_car_km1

PRINT_NOW ( KM1_2 ) 5000 1 //"Get the car rigged with a bomb!"

ADD_SPHERE 373.9 -576.4 25.1 4.0 sphere_km1

ADD_SPRITE_BLIP_FOR_COORD 380.0 -577.0 25.1 RADAR_SPRITE_BOMB radar_blip_coord1_km1 

// waiting for the cop car to be rigged

WHILE NOT flag_car_got_bomb_km1 = 1

	WAIT 0
	
	IF IS_PLAYER_IN_MODEL player CAR_POLICE

		STORE_CAR_PLAYER_IS_IN player mission_cop_car_km1

		IF flag_player_had_car_message_km1 = 1
			ADD_SPRITE_BLIP_FOR_COORD 380.0 -577.0 25.1 RADAR_SPRITE_BOMB radar_blip_coord1_km1

			IF flag_player_had_dome_message_km1 = 0 
				ADD_SPHERE 373.9 -576.4 25.1 4.0 sphere_km1
			ENDIF

			flag_player_had_car_message_km1 = 0
		ENDIF

		IF IS_CAR_ARMED_WITH_BOMB mission_cop_car_km1 CARBOMB_TIMED
			flag_car_got_bomb_km1 = 1
		ELSE

			IF flag_had_bomb_message_km1 = 0
				PRINT_NOW ( KM1_2 ) 5000 1 //"Get the car rigged with a bomb!"
				flag_had_bomb_message_km1 = 1
			ENDIF

		ENDIF

	ELSE

		IF flag_player_had_car_message_km1 = 0
			PRINT_NOW ( KM1_4 ) 7000 1 //"Get a cop car and get on with the mission"
			REMOVE_BLIP radar_blip_coord1_km1
			REMOVE_SPHERE sphere_km1
			flag_player_had_car_message_km1 = 1
		ENDIF

		flag_had_bomb_message_km1 = 0

 	ENDIF

	IF LOCATE_PLAYER_IN_CAR_2D player 373.9 -576.4 2.0 2.0 FALSE
		
		IF flag_player_had_dome_message_km1 = 0
			PRINT_HELP ( KM1_13 ) //"Drive the car...
			REMOVE_SPHERE sphere_km1
			flag_player_had_dome_message_km1 = 1
		ENDIF

	ELSE
		flag_player_had_dome_message_km1 = 0
	ENDIF

		
	    
ENDWHILE

REMOVE_BLIP radar_blip_coord1_km1

REMOVE_SPHERE sphere_km1

PRINT_NOW ( KM1_5 ) 7000 1 //"Okay now go to the police station

ADD_BLIP_FOR_COORD 327.0 -1086.0 -100.0 radar_blip_coord2_km1

blob_flag = 1

flag_blip_on_km1 = 1
 				  	   
// waiting for the player to activate the car bomb and the car to be in the area

blob_flag = 1

WHILE counter_bomb_km1 = 0

	WAIT 0

	IF flag_area_bomb_message_km1 = 0

		IF IS_PLAYER_IN_MODEL player CAR_POLICE
	
			STORE_CAR_PLAYER_IS_IN player mission_cop_car_km1
								
			flag_player_had_car_message_km1 = 0
																	
			IF IS_CAR_ARMED_WITH_BOMB mission_cop_car_km1 CARBOMB_TIMED
			OR IS_CAR_ARMED_WITH_BOMB mission_cop_car_km1 CARBOMB_TIMEDACTIVE

				IF flag_player_had_bomb_message_km1 = 1
					REMOVE_BLIP radar_blip_coord1_km1  // bombshop
					flag_player_had_bomb_message_km1 = 0
				ENDIF

				IF flag_blip_on_km1 = 0
					ADD_BLIP_FOR_COORD 327.0 -1086.0 -100.0 radar_blip_coord2_km1 // police station
					flag_blip_on_km1 = 1
					blob_flag = 1
				ENDIF
								
				IF IS_CAR_IN_AREA_3D mission_cop_car_km1 331.7 -1091.0 24.0 323.7 -1078.3 33.0 blob_flag

					GET_CONTROLLER_MODE controlmode

					IF flag_bomb_km1 = 0

						IF controlmode = 0
							PRINT_HELP ( KM1_8A ) //"Press circle to detonate the bomb, remember to get out of the way!"
						ENDIF

						IF controlmode = 1
							PRINT_HELP ( KM1_8A ) //"Press circle to detonate the bomb, remember to get out of the way!"
						ENDIF

						IF controlmode = 2
   							PRINT_HELP ( KM1_8A ) //"Press circle to detonate the bomb, remember to get out of the way!"
						ENDIF

						IF controlmode = 3
							PRINT_HELP ( KM1_8D ) //"Press circle to detonate the bomb, remember to get out of the way!"
						ENDIF 
												
						flag_bomb_km1 = 1

					ENDIF
	
					IF IS_CAR_ARMED_WITH_BOMB mission_cop_car_km1 CARBOMB_TIMEDACTIVE
						counter_bomb_km1 = 1
						flag_area_bomb_message_km1 = 1
					ELSE
						flag_area_bomb_message_km1 = 0
						//counter_bomb_km1 = 0
					ENDIF

				ENDIF
			   			
			ELSE
							
				IF flag_area_bomb_message_km1 = 0

					IF flag_player_had_bomb_message_km1 = 0
						PRINT_NOW ( KM1_6 ) 7000 1 //"Get a bomb fitted to the car!"
						ADD_SPRITE_BLIP_FOR_COORD 380.0 -577.0 25.1 RADAR_SPRITE_BOMB radar_blip_coord1_km1 //bombshop
						flag_player_had_bomb_message_km1 = 1
					
						IF flag_blip_on_km1 = 1
							REMOVE_BLIP radar_blip_coord2_km1  // police station
							flag_blip_on_km1 = 0
							blob_flag = 0
						ENDIF
				   					
					ENDIF

				ENDIF
																											 						
			ENDIF

		ELSE

			blob_flag = 0
			
			IF flag_player_had_car_message_km1 = 0
				PRINT_NOW ( KM1_4 ) 7000 1 //"Get a cop car and get on with the mission"
				REMOVE_BLIP radar_blip_coord2_km1  // Police station
				flag_blip_on_km1 = 0
				flag_player_had_car_message_km1 = 1
			ENDIF
						
			IF flag_player_had_bomb_message_km1 = 1
		   		REMOVE_BLIP radar_blip_coord1_km1  // bombshop
				flag_player_had_bomb_message_km1 = 0
			ENDIF	

		ENDIF
    
    ENDIF
    	
ENDWHILE

CLEAR_HELP

REMOVE_BLIP radar_blip_coord2_km1  // police station 

// Waiting for the player to destroy the car outside the cell

WHILE NOT IS_EXPLOSION_IN_AREA EXPLOSION_CAR 323.3 -1072.6 24.0 335.5 -1094.0 33.0
	
	IF IS_CAR_DEAD mission_cop_car_km1
		PRINT_NOW ( KM1_11 ) 5000 1 //"You have alerted the cops"
		ALTER_WANTED_LEVEL_NO_DROP player 3
		GOTO mission_kenji1_failed
	ENDIF

	WAIT 0
	   	
ENDWHILE

IF NOT IS_CAR_DEAD mission_cop_car_km1
	PRINT_NOW ( KM1_11 ) 5000 1 //"You have alerted the cops"
	ALTER_WANTED_LEVEL_NO_DROP player 3
	GOTO mission_kenji1_failed
ELSE
      
   GOSUB wall_explosion
    
ENDIF

REMOVE_SOUND cell_beating 

ADD_CONTINUOUS_SOUND 328.418 -1088.174 28.3 SOUND_BANK_ALARM_LOOP_L police_alarm

CLEAR_AREA 327.0 -1086.0 -100.0 4.0 TRUE

SWAP_NEAREST_BUILDING_MODEL 328.026 -1090.262 26.941 2.0 police_cell_wall police_celhole

flag_need_wall_change_km1 = 1 // If player fails the wall needs to be changed back 

REMOVE_BLIP radar_blip_coord2_km1

WAIT 500

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 328.2 -1092.2 24.9 yakuza_ped1_km1

SET_CHAR_RUNNING yakuza_ped1_km1 TRUE  

CLEAR_CHAR_THREAT_SEARCH yakuza_ped1_km1

SET_PLAYER_AS_LEADER yakuza_ped1_km1 player

PRINT_NOW ( KM1_12 ) 7000 1 //"Get him to the dojo but get rid of the cops first!"

ALTER_WANTED_LEVEL_NO_DROP player 3

ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km1

// waiting for the player to get rid of his wanted level

timera = 0

WHILE IS_WANTED_LEVEL_GREATER player 0

	WAIT 0
	
	IF flag_played_cop_radio_km1 = 0

		IF timera > 2000
			PLAY_MISSION_AUDIO
			flag_played_cop_radio_km1 = 1
		ENDIF
		
	ENDIF	
	
	IF IS_CHAR_DEAD yakuza_ped1_km1
		PRINT_NOW ( KM1_10 ) 5000 1 //"The Yakuza Kanbu is dead!"
		GOTO mission_kenji1_failed
	ENDIF
		
	IF NOT IS_CHAR_IN_PLAYERS_GROUP yakuza_ped1_km1 player
		
		IF flag_blip_on_yakuza_ped1_km1 = 0
			PRINT_NOW ( HEY6 ) 5000 1 //You have left the Yakuza Kanbu behind go and get him!"
			ADD_BLIP_FOR_CHAR yakuza_ped1_km1 radar_blip_ped1_km1
			REMOVE_BLIP spray_blip_km1
			flag_blip_on_yakuza_ped1_km1 = 1
		ENDIF
				
	ENDIF	
				
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza_ped1_km1 8.0 8.0 FALSE
	AND flag_blip_on_yakuza_ped1_km1 = 1
		SET_PLAYER_AS_LEADER yakuza_ped1_km1 player
		ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km1
		REMOVE_BLIP radar_blip_ped1_km1
	   	flag_blip_on_yakuza_ped1_km1 = 0
	ENDIF
	
ENDWHILE

REMOVE_BLIP spray_blip_km1  

PRINT_NOW ( KM1_3 ) 7000 1 //"Get me to the Dojo!"

ADD_BLIP_FOR_COORD 105.6 -1292.68 -100.0 radar_blip_coord3_km1

flag_dojo_blip_on = 1

LOAD_MISSION_AUDIO k1_b

// Waiting for the player to be back at the safehouse

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_2D player 105.6 -1292.68 3.0 4.0 blob_flag
OR NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D yakuza_ped1_km1 105.6 -1292.68 3.0 4.0 FALSE
OR NOT HAS_MISSION_AUDIO_LOADED
OR IS_WANTED_LEVEL_GREATER player 0

	WAIT 0
	
	IF IS_CHAR_DEAD yakuza_ped1_km1
		PRINT_NOW ( KM1_10 ) 5000 1 //"The Yakuza Kanbu is dead!"
		GOTO mission_kenji1_failed
	ENDIF
	   
   	IF NOT IS_CHAR_IN_PLAYERS_GROUP yakuza_ped1_km1 player
		
		IF flag_blip_on_yakuza_ped1_km1 = 0
			PRINT_NOW ( HEY6 ) 5000 1 //You have left the Yakuza Kanbu behind go and get him!"
			ADD_BLIP_FOR_CHAR yakuza_ped1_km1 radar_blip_ped1_km1
			flag_blip_on_yakuza_ped1_km1 = 1
			blob_flag = 0
		ENDIF

		IF flag_spray_blip_on_km1 = 1
			REMOVE_BLIP spray_blip_km1
			flag_spray_blip_on_km1 = 0
			flag_player_got_cops_message_km1 = 0
		ENDIF 
				
	ENDIF	
				
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player yakuza_ped1_km1 8.0 8.0 FALSE
	AND flag_blip_on_yakuza_ped1_km1 = 1
		SET_PLAYER_AS_LEADER yakuza_ped1_km1 player
		REMOVE_BLIP radar_blip_ped1_km1
	   	flag_blip_on_yakuza_ped1_km1 = 0
		blob_flag = 1
	ENDIF
	   		
   	IF IS_WANTED_LEVEL_GREATER player 0
				
   		IF flag_player_got_cops_message_km1 = 0

			IF flag_blip_on_yakuza_ped1_km1 = 0
   				PRINT_NOW ( WANTED1 ) 7000 1 //"Get rid of the cops!"
				ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY spray_blip_km1 
   				flag_player_got_cops_message_km1 = 1
				flag_spray_blip_on_km1 = 1
			ENDIF

		ENDIF
	ELSE
	 	flag_player_got_cops_message_km1 = 0

		IF flag_spray_blip_on_km1 = 1
			REMOVE_BLIP spray_blip_km1
			flag_spray_blip_on_km1 = 0
		ENDIF

	ENDIF

	IF flag_spray_blip_on_km1 = 0

		IF flag_blip_on_yakuza_ped1_km1 = 0

			IF flag_dojo_blip_on = 0
				ADD_BLIP_FOR_COORD 105.6 -1292.68 -100.0 radar_blip_coord3_km1
				PRINT_NOW ( KM1_3 ) 7000 1 //"Get me to the Dojo!"
				blob_flag = 1
				flag_dojo_blip_on = 1
			ENDIF

		ENDIF

	ENDIF

	IF flag_dojo_blip_on = 1
		
		IF flag_spray_blip_on_km1 = 1
		OR flag_blip_on_yakuza_ped1_km1 = 1
			REMOVE_BLIP radar_blip_coord3_km1
			blob_flag = 0
			flag_dojo_blip_on = 0
		ENDIF
		
	ENDIF  

ENDWHILE

REMOVE_BLIP radar_blip_coord3_km1

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

SWITCH_WIDESCREEN ON

LEAVE_GROUP yakuza_ped1_km1

PLAY_MISSION_AUDIO

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD yakuza_ped1_km1
		PRINT_NOW ( KM1_10 ) 5000 1 //"The Yakuza Kanbu is dead!"
		GOTO mission_kenji1_failed
	ENDIF
	
ENDWHILE

SET_FIXED_CAMERA_POSITION 93.45 -1279.27 35.08 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 94.19 -1279.91 34.79 JUMP_CUT

SET_CHAR_RUNNING yakuza_ped1_km1 FALSE

// Tells ped to get out of car 

IF IS_CHAR_IN_ANY_CAR yakuza_ped1_km1

	STORE_CAR_CHAR_IS_IN yakuza_ped1_km1 car_km1
	
	SET_CHAR_OBJ_LEAVE_CAR yakuza_ped1_km1 car_km1
	
	WHILE IS_CHAR_IN_CAR yakuza_ped1_km1 car_km1
		
		WAIT 0

		IF IS_CHAR_DEAD yakuza_ped1_km1
			PRINT_NOW ( KM1_10 ) 5000 1 //"The Yakuza Kanbu is dead!"
			GOTO mission_kenji1_failed
		ENDIF

		IF IS_CAR_DEAD car_km1
			PRINT_NOW ( WRECKED ) 5000 1 //"The vehicle's wrecked!"
			GOTO mission_kenji1_failed
		ENDIF

	ENDWHILE

ENDIF

CLEAR_AREA 111.05 -1274.75 25.16 6.0 TRUE

SET_CHAR_OBJ_RUN_TO_COORD yakuza_ped1_km1 111.05 -1274.75

timerb = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_3D yakuza_ped1_km1 111.05 -1274.75 25.16 2.0 2.0 2.0 FALSE

	WAIT 0

	IF IS_CHAR_DEAD yakuza_ped1_km1
		PRINT_NOW ( KM1_10 ) 5000 1 //"The Yakuza Kanbu is dead!"
		GOTO mission_kenji1_failed
	ENDIF

	IF timerb >= 8000

		IF NOT LOCATE_CHAR_ON_FOOT_3D yakuza_ped1_km1 111.05 -1274.75 25.16 2.0 2.0 2.0 FALSE
			REMOVE_CHAR_ELEGANTLY yakuza_ped1_km1
			GOTO mission_bloke_got_stuck_km1
		ENDIF
		
	ENDIF  
			
ENDWHILE

mission_bloke_got_stuck_km1:

DELETE_CHAR yakuza_ped1_km1

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF

RESTORE_CAMERA_JUMPCUT

GOTO mission_kenji1_passed
	   		


// Mission Kemuri1 failed

mission_kenji1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

   

// mission Kemuri1 passed

mission_kenji1_passed:

flag_kenji_mission1_passed = 1
REGISTER_MISSION_PASSED ( KM1 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 30000 5000 1 //"Mission Passed"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 30000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT kenji_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_kenji1:

flag_player_on_mission = 0
flag_player_on_kenji_mission = 0
REMOVE_SOUND police_alarm
REMOVE_SOUND cell_beating
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_MODEL_AS_NO_LONGER_NEEDED rubble01
MARK_MODEL_AS_NO_LONGER_NEEDED rubble02 
REMOVE_BLIP radar_blip_coord1_km1
REMOVE_BLIP radar_blip_coord2_km1
REMOVE_BLIP radar_blip_coord3_km1
REMOVE_BLIP radar_blip_ped1_km1
REMOVE_BLIP spray_blip_km1
REMOVE_SPHERE sphere_km1
MISSION_HAS_FINISHED
RETURN
		


wall_explosion:

ADD_EXPLOSION 328.1 -1087.5 27.7 EXPLOSION_HELI
ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 328.1 -1088.3 26.0 0.0 0.0 0.0 4.0 0 0 0 3000
CREATE_OBJECT rubble02 328.1 -1084.1 27.0 debris1
CREATE_OBJECT rubble02 328.5 -1084.7 27.0 debris2
CREATE_OBJECT rubble01 326.6 -1083.7 26.0 debris3
CREATE_OBJECT rubble01 330.0 -1084.4 27.0 debris4
SET_OBJECT_DYNAMIC debris1 TRUE
SET_OBJECT_DYNAMIC debris2 TRUE
SET_OBJECT_DYNAMIC debris3 TRUE
SET_OBJECT_DYNAMIC debris4 TRUE 
SET_OBJECT_VELOCITY debris1 3.0 16.0 15.0
SET_OBJECT_VELOCITY debris2 -5.0 10.0 5.0
SET_OBJECT_VELOCITY debris3 7.0 7.0 7.0
SET_OBJECT_VELOCITY debris4 -4.0 13.0 10.0

RETURN

}	


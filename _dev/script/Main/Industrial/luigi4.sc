MISSION_START

// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Luigi mission 4*********************************
// *****************************************Pump Action Pimp******************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME luigi4

// Mission Start Stuff

GOSUB mission_start_luigi4

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_luigi4_failed
	ENDIF

GOSUB mission_cleanup_luigi4

MISSION_END


// Variable for mission

VAR_INT radar_blip_ped1_lm4

VAR_INT radar_blip_coord1_lm4

VAR_INT radar_blip_car1_lm4

VAR_INT rival_pimp_to_kill

VAR_INT car_lm4

VAR_INT flag_player_got_message_luigi4

VAR_INT car_health_lm4

VAR_INT flag_car_dead_lm4

VAR_INT flag_pimp_dead_lm4

VAR_INT gun_lm4

VAR_FLOAT car_lm4_x

VAR_FLOAT car_lm4_y

VAR_FLOAT car_lm4_z

VAR_INT flag_collected_gun_lm4

VAR_INT flag_gun_message_lm4

VAR_INT flag_pimp2_dead_lm4

VAR_INT pimp_lm4

VAR_INT flag_pimp_kill_player_luigi4

VAR_INT radar_blip_ped2_lm4

VAR_INT	flag_ped1_not_in_car

VAR_INT flag_ped2_not_in_car

VAR_INT flag_player_had_shop_audio_lm4

VAR_INT flag_player_had_message1_lm4

VAR_INT flag_player_had_message2_lm4

VAR_INT flag_blokes_get_out_of_car_lm4

VAR_INT flag_car_blip_on_lm4

VAR_INT flag_done_camera_lm4

VAR_INT flag_set_car_driving_lm4

// **********************************************Mission Start******************************

mission_start_luigi4:

flag_player_on_mission = 1

flag_player_on_luigi_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_player_got_message_luigi4 = 0

car_health_lm4 = 0

flag_car_dead_lm4 = 0

flag_pimp_dead_lm4 = 0

car_lm4_x = 0.0

car_lm4_y = 0.0

car_lm4_z = 0.0

flag_collected_gun_lm4 = 0

flag_gun_message_lm4 = 0

flag_pimp2_dead_lm4 = 0

flag_pimp_kill_player_luigi4 = 0

flag_ped1_not_in_car = 0

flag_ped2_not_in_car = 0

flag_player_had_shop_audio_lm4 = 0

flag_player_had_message1_lm4 = 0

flag_player_had_message2_lm4 = 0

flag_blokes_get_out_of_car_lm4 = 0

flag_car_blip_on_lm4 = 0

flag_done_camera_lm4 = 0

flag_set_car_driving_lm4 = 0

// ***************************************START OF CUTSCENE*********************************
{
/*
IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_luigi4_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( LM4 ) 15000 2 //"Pump Action Pimp"

SWITCH_STREAMING OFF
*/

LOAD_SPECIAL_CHARACTER 1 LUIGI

LOAD_SPECIAL_MODEL cut_obj1 LUDOOR

LOAD_SPECIAL_MODEL cut_obj2 LUIGIH

LOAD_SPECIAL_MODEL cut_obj3 PLAYERH

REQUEST_MODEL indhibuild3

REQUEST_MODEL luigiclubout

REQUEST_MODEL luigiineerclub

REQUEST_MODEL CAR_DIABLOS
REQUEST_MODEL PED_GANG_DIABLO_A
REQUEST_MODEL PED_PIMP

/*
WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS 926.54 -471.72 1.0 830.76 -257.96 25.0

LOAD_ALL_MODELS_NOW
	
// Cutscene stuff

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED indhibuild3
OR NOT HAS_MODEL_LOADED luigiclubout
OR NOT HAS_MODEL_LOADED luigiineerclub
OR NOT HAS_MODEL_LOADED CAR_DIABLOS
OR NOT HAS_MODEL_LOADED PED_GANG_DIABLO_A
OR NOT HAS_MODEL_LOADED PED_PIMP

	WAIT 0
	
ENDWHILE  

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE	

LOAD_CUTSCENE l4_pap

SET_CUTSCENE_OFFSET 900.782 -427.523 13.829

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_luigi

SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_HEAD cs_luigi CUT_OBJ2 cs_luigihead

SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead

SET_CUTSCENE_HEAD_ANIM cs_playerhead player

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

WHILE cs_time < 8775
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM4_A ) 10000 1 //"Some Diablo skumball has been pimping his skuzzy bitches in my backyard."

WHILE cs_time < 12872
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM4_B ) 10000 1 //"Go and take care of things for me."

WHILE cs_time < 14886
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LM4_C ) 10000 1 //"If you need a "piece" go round the back of AmmuNation opposite the subway."

WHILE cs_time < 18506
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( LM4_C )

WHILE cs_time < 19333
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

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3

MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout

MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub

SET_PED_DENSITY_MULTIPLIER 1.0

// ******************************************END OF CUT_SCENE*******************************

REQUEST_MODEL CAR_DIABLOS
REQUEST_MODEL PED_GANG_DIABLO_A
REQUEST_MODEL PED_PIMP

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_DIABLOS
OR NOT HAS_MODEL_LOADED PED_GANG_DIABLO_A
OR NOT HAS_MODEL_LOADED PED_PIMP
 
	WAIT 0

ENDWHILE

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player OFF

SET_POLICE_IGNORE_PLAYER player ON

SET_EVERYONE_IGNORE_PLAYER player ON

CREATE_CAR CAR_DIABLOS 1058.5 -421.0 -100.0 car_lm4

LOCK_CAR_DOORS car_lm4 CARLOCK_LOCKOUT_PLAYER_ONLY

SET_CAR_HEADING car_lm4 360.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER car_lm4 TRUE

SET_CAR_WATERTIGHT car_lm4 TRUE 

CREATE_CHAR_INSIDE_CAR car_lm4 PEDTYPE_CIVMALE PED_GANG_DIABLO_A rival_pimp_to_kill

CLEAR_CHAR_THREAT_SEARCH rival_pimp_to_kill

GIVE_WEAPON_TO_CHAR rival_pimp_to_kill WEAPONTYPE_UZI 30000  // sets weapon to infinate ammo

CREATE_CHAR_AS_PASSENGER car_lm4 PEDTYPE_CIVMALE PED_PIMP 0 pimp_lm4

CLEAR_CHAR_THREAT_SEARCH pimp_lm4

GIVE_WEAPON_TO_CHAR pimp_lm4 WEAPONTYPE_SHOTGUN 30000  // sets weapon to infinate ammo

SET_CAR_MISSION car_lm4 MISSION_STOP_FOREVER

ADD_BLIP_FOR_CAR car_lm4 radar_blip_car1_lm4

flag_car_blip_on_lm4 = 1

LOAD_SCENE 1065.1 -398.6 14.97

SET_FIXED_CAMERA_POSITION 1048.1 -398.3 15.5 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 1049.1 -398.3 15.5 JUMP_CUT

CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 pickup_once 45 1080.5 -396.0 14.5 gun_lm4

ADD_SPRITE_BLIP_FOR_PICKUP gun_lm4 RADAR_SPRITE_WEAPON radar_blip_coord1_lm4


timerb = 0

WHILE timerb < 8400

	WAIT 0

	
	IF flag_set_car_driving_lm4 = 0
		
		IF timerb >= 2000
					
			IF NOT IS_CAR_DEAD car_lm4
				SET_CAR_MISSION car_lm4 MISSION_CRUISE
				SET_CAR_CRUISE_SPEED car_lm4 20.0
				flag_set_car_driving_lm4 = 1
			ENDIF

		ENDIF

	ENDIF

	IF flag_done_camera_lm4 = 0

		IF NOT IS_CAR_DEAD car_lm4

			IF LOCATE_CAR_2D car_lm4 1058.5 -398.5 6.0 6.0 FALSE
				POINT_CAMERA_AT_POINT 1048.6 -397.4 15.5 INTERPOLATION
				flag_done_camera_lm4 = 1
			ENDIF

		ENDIF

	ENDIF

	GOSUB car_check_lm4

	GOSUB ped_death_check_lm4
	
	GOSUB help_text_check_lm4
		
	IF flag_collected_gun_lm4 = 0
	 
		IF HAS_PICKUP_BEEN_COLLECTED gun_lm4
		 	REMOVE_BLIP radar_blip_coord1_lm4
			flag_collected_gun_lm4 = 1
		ENDIF

			
		IF flag_player_had_shop_audio_lm4 = 0
	
			IF IS_PLAYER_IN_AREA_3D player 1066.6 -403.5 14.0 1072.8 -394.0 18.0 FALSE

				IF camera_ammu1 = 1

					GOSUB audio_load_lm4

				ENDIF
		
			ENDIF
		
		ENDIF
		
	ENDIF   
	
	
	IF flag_ped2_not_in_car = 1
	AND flag_ped1_not_in_car = 1
		IF flag_car_blip_on_lm4 = 1
			REMOVE_BLIP radar_blip_car1_lm4
			flag_car_blip_on_lm4 = 0
		ENDIF
	ENDIF		 	
			 

ENDWHILE

LOAD_SCENE 920.3 -425.4 15.0

RESTORE_CAMERA_JUMPCUT

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

SET_POLICE_IGNORE_PLAYER player OFF

SET_EVERYONE_IGNORE_PLAYER player OFF

  	
WHILE flag_pimp_dead_lm4 = 0
OR flag_pimp2_dead_lm4 = 0

	WAIT 0

	GOSUB car_check_lm4

	GOSUB ped_death_check_lm4
	
	GOSUB help_text_check_lm4 
	
	IF flag_collected_gun_lm4 = 0
	 
		IF HAS_PICKUP_BEEN_COLLECTED gun_lm4
		 	REMOVE_BLIP radar_blip_coord1_lm4
			flag_collected_gun_lm4 = 1
		ENDIF

			
		IF flag_player_had_shop_audio_lm4 = 0
	
			IF IS_PLAYER_IN_AREA_3D player 1066.6 -403.5 14.0 1072.8 -394.0 18.0 FALSE
				GOSUB audio_load_lm4
			ENDIF
		
		ENDIF
		
	ENDIF   
		
	IF flag_ped2_not_in_car = 1
	AND flag_ped1_not_in_car = 1
		IF flag_car_blip_on_lm4 = 1
			REMOVE_BLIP radar_blip_car1_lm4
			flag_car_blip_on_lm4 = 0
		ENDIF
	ENDIF		 	
							   	   							   	 		 		   	   
ENDWHILE

REMOVE_BLIP radar_blip_coord1_lm4

//timera = 0

//WHILE timera < 3000

//	WAIT 0

//ENDWHILE
		
GOTO mission_luigi4_passed
	   		

// Mission Luigi1 failed

mission_luigi4_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF NOT IS_CHAR_DEAD rival_pimp_to_kill
	REMOVE_CHAR_ELEGANTLY rival_pimp_to_kill
ENDIF

IF IS_CHAR_DEAD pimp_lm4 
	REMOVE_CHAR_ELEGANTLY pimp_lm4
ENDIF

RETURN

		
// mission Luigi1 passed

mission_luigi4_passed:

flag_luigi_mission4_passed = 1
REGISTER_MISSION_PASSED ( LM4 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( m_pass ) 4000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 4000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT luigi_mission5_loop

IF out_of_stock_pistol = 0
	START_NEW_SCRIPT pistol_message
ENDIF

RETURN
		


// mission cleanup

mission_cleanup_luigi4:

flag_player_on_mission = 0
flag_player_on_luigi_mission = 0
special_ammu_audio = 0

IF flag_car_dead_lm4 = 0

	IF NOT IS_CAR_DEAD car_lm4
		SET_CAR_ONLY_DAMAGED_BY_PLAYER car_lm4 FALSE
		LOCK_CAR_DOORS car_lm4 CARLOCK_UNLOCKED
		SET_CAR_WATERTIGHT car_lm4 FALSE
	ENDIF

ENDIF

REMOVE_PICKUP gun_lm4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_DIABLOS
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_DIABLO_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_PIMP
IF flag_collected_gun_lm4 = 0
	REMOVE_PICKUP gun_lm4 
ENDIF
GOSUB shite_complier_bit
MISSION_HAS_FINISHED
RETURN


// *************************PED GOSUB HAS TO GO HERE FOR STUPID COMPILER********************

ped_death_check_lm4:

// Checks for the Diablo

	IF flag_pimp_dead_lm4 = 0

		IF NOT IS_CHAR_DEAD rival_pimp_to_kill

			IF flag_blokes_get_out_of_car_lm4 = 1
			OR NOT IS_CHAR_IN_CAR rival_pimp_to_kill car_lm4
					
				IF flag_player_got_message_luigi4 = 0
	 				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS rival_pimp_to_kill player
					SET_CHAR_THREAT_SEARCH rival_pimp_to_kill THREAT_PLAYER1
					SET_CHAR_PERSONALITY rival_pimp_to_kill PEDSTAT_TOUGH_GUY
					flag_player_got_message_luigi4 = 1
				ENDIF

			ENDIF

			IF flag_ped1_not_in_car = 0

				IF NOT IS_CHAR_IN_CAR rival_pimp_to_kill car_lm4
					ADD_BLIP_FOR_CHAR rival_pimp_to_kill radar_blip_ped1_lm4
					flag_ped1_not_in_car = 1
				ENDIF
						
			ENDIF
						
		ENDIF

		IF IS_CHAR_DEAD rival_pimp_to_kill 
			REMOVE_BLIP radar_blip_ped1_lm4
			flag_pimp_dead_lm4 = 1
		ENDIF

	ENDIF
  
// Checks for the pimp model
	
	IF flag_pimp2_dead_lm4 = 0
	
		IF NOT IS_CHAR_DEAD pimp_lm4

			IF flag_blokes_get_out_of_car_lm4 = 1
			OR NOT IS_CHAR_IN_CAR pimp_lm4 car_lm4
					
				IF flag_pimp_kill_player_luigi4 = 0
	 				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS pimp_lm4 player
					SET_CHAR_THREAT_SEARCH pimp_lm4 THREAT_PLAYER1
					SET_CHAR_PERSONALITY pimp_lm4 PEDSTAT_TOUGH_GUY
					flag_pimp_kill_player_luigi4 = 1
				ENDIF

			ENDIF

			IF flag_ped2_not_in_car = 0
					
				IF NOT IS_CHAR_IN_CAR pimp_lm4 car_lm4
					ADD_BLIP_FOR_CHAR pimp_lm4 radar_blip_ped2_lm4
					flag_ped2_not_in_car = 1
				ENDIF

			ENDIF
						
		ENDIF

		IF IS_CHAR_DEAD pimp_lm4
			REMOVE_BLIP radar_blip_ped2_lm4
		 	flag_pimp2_dead_lm4 = 1
		ENDIF
					   
	ENDIF

RETURN


// **************************************************END OF PED GOSUB******************************

audio_load_lm4:

 IF IS_PLAYER_IN_AREA_3D player 1066.6 -403.5 14.0 1072.8 -394.0 18.0 FALSE

	special_ammu_audio = 1

	IF camera_ammu1 = 1

 		IF NOT IS_CHAR_DEAD ammu_shop_bloke1
				
			IF flag_player_had_message1_lm4 = 0
				LOAD_MISSION_AUDIO AMMU_A
				flag_player_had_message1_lm4 = 1
			ENDIF

			IF flag_player_had_message1_lm4 = 1 
		 		
 	   			IF HAS_MISSION_AUDIO_LOADED
		  			PLAY_MISSION_AUDIO
 					PRINT_NOW ( AMMU_A ) 5000 1 //"Luigi said..."
					flag_player_had_message1_lm4 = 2
	   			ENDIF

			ENDIF

			IF flag_player_had_message1_lm4 = 2
			 			
 				IF HAS_MISSION_AUDIO_FINISHED
 					CLEAR_THIS_PRINT ( AMMU_A )
					flag_player_had_message1_lm4 = 3
				ENDIF

			ENDIF
		
			IF flag_player_had_message1_lm4 = 3
			AND flag_player_had_message2_lm4  = 0 
				LOAD_MISSION_AUDIO AMMU_C
				flag_player_had_message2_lm4 = 1
			ENDIF

			IF flag_player_had_message2_lm4  = 1
 		
 				IF HAS_MISSION_AUDIO_LOADED
 		 			PLAY_MISSION_AUDIO
 					PRINT_NOW ( AMMU_C ) 5000 1 //"Go round the back..."	
 					flag_player_had_message2_lm4  = 2		
				ENDIF

 			ENDIF

			IF flag_player_had_message2_lm4  = 2
 			 			
 				IF HAS_MISSION_AUDIO_FINISHED
 					CLEAR_THIS_PRINT ( AMMU_C )
 					flag_player_had_shop_audio_lm4 = 1
					special_ammu_audio = 0
					flag_player_had_message2_lm4  = 3
 				ENDIF
 	   			
			ENDIF

		ELSE
			CLEAR_MISSION_AUDIO
			special_ammu_audio = 0
		ENDIF

	ENDIF

ELSE
	CLEAR_MISSION_AUDIO
	special_ammu_audio = 0
ENDIF

RETURN


car_check_lm4:

	IF flag_car_dead_lm4 = 0
		
		IF IS_CAR_DEAD car_lm4

			IF flag_car_blip_on_lm4 = 1
				REMOVE_BLIP radar_blip_car1_lm4
				flag_car_blip_on_lm4 = 0
			ENDIF

			flag_car_dead_lm4 = 1
		ELSE

			IF IS_CAR_IN_WATER car_lm4
						
				IF IS_CAR_ON_SCREEN car_lm4
					SET_CAR_WATERTIGHT car_lm4 FALSE
					
				ELSE
					GET_CAR_COORDINATES car_lm4 car_lm4_x car_lm4_y car_lm4_z
					GET_CLOSEST_CAR_NODE car_lm4_x car_lm4_y car_lm4_z car_lm4_x car_lm4_y car_lm4_z
				ENDIF

				IF NOT IS_POINT_ON_SCREEN car_lm4_x car_lm4_y car_lm4_z 5.0
					SET_CAR_COORDINATES car_lm4 car_lm4_x car_lm4_y car_lm4_z
				ENDIF
									
			ENDIF
			
			GET_CAR_HEALTH car_lm4 car_health_lm4
									
			IF car_health_lm4 < 999
				flag_blokes_get_out_of_car_lm4 = 1
			ELSE
				flag_blokes_get_out_of_car_lm4 = 0
			ENDIF

		ENDIF

	ENDIF
	
RETURN


help_text_check_lm4:

IF flag_player_had_gun_message = 0

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 1075.2 -384.8 14.0 1086.2 -403.3 17.0 FALSE
		
			GET_CONTROLLER_MODE controlmode

			IF controlmode = 0
								
				IF flag_gun_message_lm4 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_lm4 = 1
				ENDIF

				IF flag_gun_message_lm4 = 1

					IF timerb > 10000
						PRINT_HELP ( GUN_2A ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_lm4 = 2
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 2

					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_lm4 = 3
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 3

					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_lm4 = 4
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 4

					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_lm4 = 5
						flag_player_had_gun_message = 1
					ENDIF

				ENDIF

			ENDIF

// Control Mode 1

			IF controlmode = 1
			
				IF flag_gun_message_lm4 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_lm4 = 1
				ENDIF

				IF flag_gun_message_lm4 = 1

					IF timerb > 10000
						PRINT_HELP ( GUN_2A ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_lm4 = 2
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 2

					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_lm4 = 3
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 3

					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_lm4 = 4
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 4

					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_lm4 = 5
						flag_player_had_gun_message = 1
					ENDIF

				ENDIF

							
			ENDIF

// Control Mode 2

			IF controlmode = 2
			
				IF flag_gun_message_lm4 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_lm4 = 1
				ENDIF

				IF flag_gun_message_lm4 = 1

					IF timerb > 10000
						PRINT_HELP ( GUN_2C ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_lm4 = 2
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 2

					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_lm4 = 3
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 3

					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_lm4 = 4
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 4

					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_lm4 = 5
						flag_player_had_gun_message = 1
					ENDIF

				ENDIF
								
			ENDIF

// Control Mode 3

			IF controlmode = 3
			
				IF flag_gun_message_lm4 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_lm4 = 1
				ENDIF

				IF flag_gun_message_lm4 = 1

					IF timerb > 10000
						PRINT_HELP ( GUN_2D ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_lm4 = 2
					   //	flag_player_had_gun_message = 1
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 1

					IF timerb > 10000
						PRINT_HELP ( GUN_2C ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_lm4 = 2
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 2

					IF timerb > 10000
						PRINT_HELP ( GUN_3B ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_lm4 = 3
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 3

					IF timerb > 10000
						PRINT_HELP ( GUN_4B ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_lm4 = 4
					ENDIF

				ENDIF

				IF flag_gun_message_lm4 = 4

					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_lm4 = 5
						flag_player_had_gun_message = 1
					ENDIF

				ENDIF
								
			ENDIF
				
		ENDIF

	ENDIF

RETURN


shite_complier_bit:

REMOVE_BLIP radar_blip_ped1_lm4
REMOVE_BLIP radar_blip_ped2_lm4
REMOVE_BLIP radar_blip_coord1_lm4
REMOVE_BLIP radar_blip_car1_lm4

RETURN

}
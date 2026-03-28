MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 5****************************************
// **********************************Destroy Fish Factory*************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_toni5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_toni5_failed
ENDIF

GOSUB mission_cleanup_toni5

MISSION_END

// Variables for mission

VAR_INT blip1_tm5 blip2_tm5 
 
VAR_INT explosive_truck countdown_tm5 

VAR_INT fish_factory_destroyed triads_spot_you

VAR_INT flag_car_blip_displayed_tm5	explosive_truck_health explosive_truck_health2

VAR_INT fish_fire2 fish_fire3 fish_fire4 fish_fire5 fish_fire6 fish_fire7

VAR_INT debris1_tm5 debris2_tm5 debris3_tm5 debris4_tm5 debris5_tm5 debris6_tm5 debris7_tm5 debris8_tm5 debris9_tm5 debris10_tm5

VAR_FLOAT truck_x truck_y truck_z  

// ***************************************Mission Start*************************************

mission_start_toni5:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_toni_mission = 1
SCRIPT_NAME toni5
WAIT 0

{

LOAD_SPECIAL_CHARACTER 1 tony
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 TONYH
REQUEST_MODEL ind_newrizzos

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1  
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED ind_newrizzos
	WAIT 0

ENDWHILE


LOAD_CUTSCENE t5_bf
SET_CUTSCENE_OFFSET 1218.42 -314.5 28.9

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_tony
SET_CUTSCENE_ANIM cs_tony tony

CREATE_CUTSCENE_HEAD cs_tony CUT_OBJ2 cs_tonyhead
SET_CUTSCENE_HEAD_ANIM cs_tonyhead tony

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

SET_PLAYER_HEADING player 180.0

CLEAR_AREA 1216.1 -313.0 29.9 10.0 TRUE	//TONIS RESTAURANT

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1350
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_B ) 10000 1 // Mission brief

WHILE cs_time < 3169
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_C ) 10000 1 // Mission brief

WHILE cs_time < 5730
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_D ) 10000 1 // Mission brief

WHILE cs_time < 7755
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_E ) 10000 1 // Mission brief

WHILE cs_time < 12490
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_F ) 10000 1 // Mission brief

WHILE cs_time < 17220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_G ) 10000 1 // Mission brief

WHILE cs_time < 21330
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_H ) 10000 1 // Mission brief

WHILE cs_time < 24141
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_I ) 10000 1 // Mission brief

WHILE cs_time < 25817
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM5_J ) 10000 1 // Mission brief

WHILE cs_time < 28632
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 30000
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED ind_newrizzos

REQUEST_MODEL CAR_TRASHMASTER

WHILE NOT HAS_MODEL_LOADED CAR_TRASHMASTER
	WAIT 0
ENDWHILE


triads_spot_you = 0
clear_triads_threats = 0

// START MISSION

CREATE_CAR CAR_TRASHMASTER 1314.0 -106.0 -100.0 explosive_truck
SET_CAR_PROOFS explosive_truck TRUE TRUE FALSE FALSE TRUE
ARM_CAR_WITH_BOMB explosive_truck CARBOMB_TIMED

fish_factory_destroyed = 0

ADD_BLIP_FOR_CAR explosive_truck blip1_tm5

	WHILE NOT IS_PLAYER_IN_CAR player explosive_truck
		WAIT 0

		IF IS_CAR_DEAD explosive_truck
			GOTO mission_toni5_failed
		ENDIF		
	
		GOSUB triad_AI

		IF NOT IS_CAR_HEALTH_GREATER explosive_truck 860
		AND NOT IS_CAR_IN_AREA_3D explosive_truck 961.0 -1112.5 12.5 969.5 -1122.8 15.0 FALSE
		    EXPLODE_CAR explosive_truck
			GOTO mission_toni5_failed
		ENDIF

	ENDWHILE 


countdown_tm5 = 151000
DISPLAY_ONSCREEN_TIMER countdown_tm5

GET_CAR_HEALTH explosive_truck explosive_truck_health
DISPLAY_ONSCREEN_COUNTER_WITH_STRING explosive_truck_health COUNTER_DISPLAY_BAR (DAM)
explosive_truck_health2 = 1000 - explosive_truck_health
	IF explosive_truck_health2 > 100
		explosive_truck_health2 = 100
	ENDIF
explosive_truck_health = explosive_truck_health2

flag_car_blip_displayed_tm5 = TRUE
blob_flag = 1

toni5_wait_for_van:
WAIT 0

		IF IS_CAR_DEAD explosive_truck
			GOTO mission_toni5_failed
		ENDIF

	WHILE NOT IS_CAR_STOPPED_IN_AREA_3D explosive_truck 961.0 -1112.5 12.5 969.5 -1122.8 15.0 blob_flag
		WAIT 0

			IF IS_CAR_DEAD explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO mission_toni5_failed
			ENDIF

			GOSUB triad_AI

			GOSUB Truck_health

			GET_CAR_COORDINATES explosive_truck truck_x truck_y truck_z

			IF IS_PLAYER_IN_CAR player explosive_truck
				IF flag_car_blip_displayed_tm5 = TRUE
					ADD_BLIP_FOR_COORD 965.0 -1117.0 -100.0 blip2_tm5
					blob_flag = 1
					REMOVE_BLIP blip1_tm5
				flag_car_blip_displayed_tm5 = FALSE
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player explosive_truck
				IF flag_car_blip_displayed_tm5 = FALSE
				ADD_BLIP_FOR_CAR explosive_truck blip1_tm5
				blob_flag = 0
				REMOVE_BLIP blip2_tm5
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
				flag_car_blip_displayed_tm5 = TRUE
				ENDIF
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER explosive_truck 900
			AND NOT IS_CAR_IN_AREA_3D explosive_truck 961.0 -1112.5 12.5 969.5 -1122.8 15.0 FALSE
			    EXPLODE_CAR explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO mission_toni5_failed
			ENDIF

			IF countdown_tm5 = 0
			AND NOT IS_CAR_IN_AREA_3D explosive_truck 961.0 -1112.5 12.5 969.5 -1122.8 15.0 FALSE
				EXPLODE_CAR explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO mission_toni5_failed
			ENDIF

	ENDWHILE

REQUEST_MODEL fshfctry_dstryd
PRINT_NOW ( JM1_3 ) 5000 2 //Activate the car bomb then get out of there!
FORCE_WEATHER WEATHER_SUNNY

		IF IS_CAR_DEAD explosive_truck
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_toni5_failed
		ENDIF

	WHILE NOT IS_EXPLOSION_IN_AREA EXPLOSION_CAR 961.0 -1112.5 12.5 969.5 -1122.8 15.0
		WAIT 0

			IF IS_CAR_DEAD explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO explosion
			ENDIF

			GOSUB triad_AI

			GOSUB Truck_health

			GET_CAR_COORDINATES explosive_truck truck_x truck_y truck_z
			
			IF NOT IS_CAR_IN_AREA_3D explosive_truck 961.0 -1112.5 12.5 969.5 -1122.8 15.0 FALSE
				GOTO toni5_wait_for_van
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player explosive_truck
		   	AND NOT IS_CAR_ARMED_WITH_BOMB explosive_truck CARBOMB_TIMEDACTIVE
		 		PRINT_NOW ( JM1_5 ) 5000 1 // The vehicle bomb's not set!
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER explosive_truck 900
			    EXPLODE_CAR explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO explosion
			ENDIF

			IF countdown_tm5 = 0
				EXPLODE_CAR explosive_truck
				ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE truck_x truck_y truck_z 0.0 0.0 0.0 4.0 0 0 0 4000
				GOTO explosion
			ENDIF

	ENDWHILE

explosion:
	
	
	CLEAR_ONSCREEN_TIMER countdown_tm5

	SET_PLAYER_CONTROL Player Off
	SWITCH_WIDESCREEN ON
	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player ON

	SET_FIXED_CAMERA_POSITION 940.279 -1136.787 16.550 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 941.065 -1136.169 16.522 JUMP_CUT
	
	REMOVE_BLIP blip1_tm5
	REMOVE_BLIP blip2_tm5
	WAIT 300

	SHAKE_CAM 300
    //ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 965.8 -1111.9 15.5 0.0 0.0 0.0 4.0 0 0 0 4000
	ADD_EXPLOSION 965.8 -1111.9 15.5 EXPLOSION_HELI
	//ADD_ONE_OFF_SOUND 965.8 -1111.9 15.5 sound_test_1
	START_SCRIPT_FIRE 966.0 -1111.8 13.8 fish_Fire3

	//ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 966.0 -1123.0 15.4 0.0 0.0 0.0 4.0 0 0 0 4000
	ADD_EXPLOSION 966.0 -1123.0 15.4 EXPLOSION_HELI
	//ADD_ONE_OFF_SOUND 966.0 -1123.0 15.4 sound_test_1
	WAIT 600

		SHAKE_CAM 400
		ADD_EXPLOSION 970.0 -1119.0 16.0 EXPLOSION_HELI
		WAIT 300

	SHAKE_CAM 300
	ADD_EXPLOSION 985.0 -1119.0 14.0 EXPLOSION_HELI
	WAIT 400

		SHAKE_CAM 400
		ADD_EXPLOSION 985.0 -1120.0 20.0 EXPLOSION_HELI
		WAIT 200
	
	SHAKE_CAM 300
	SET_FIXED_CAMERA_POSITION 960.5 -1094.0 21.1 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 961.2 -1094.7 20.8 JUMP_CUT

	ADD_EXPLOSION 969.2 -1104.0 18.3 EXPLOSION_HELI
	WAIT 300

		SHAKE_CAM 400
		ADD_EXPLOSION 968.4 -1119.2 17.4 EXPLOSION_HELI
		WAIT 200
	
	SHAKE_CAM 300
	ADD_EXPLOSION 979.4 -1103.9 18.9 EXPLOSION_HELI
	WAIT 300

		SHAKE_CAM 400
		ADD_EXPLOSION 976.0 -1108.3 21.4 EXPLOSION_HELI
		WAIT 300
	
	SHAKE_CAM 300
	ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 969.8 -1104.9 18.7 0.0 0.0 0.0 5.0 0 0 0 5000
	//ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 986.3 -1103.4 14.7 0.0 0.0 0.0 4.0 0 0 0 4000
	ADD_EXPLOSION 972.7 -1102.2 18.5 EXPLOSION_HELI
	ADD_EXPLOSION 986.3 -1103.4 14.7 EXPLOSION_HELI
	CREATE_OBJECT fish01 972.7 -1103.6 20.6 debris1_tm5
	CREATE_OBJECT fish01 972.7 -1103.2 20.6 debris2_tm5
	CREATE_OBJECT fish01 978.8 -1107.2 21.6 debris3_tm5
	CREATE_OBJECT fish01 979.8 -1105.2 21.6 debris4_tm5
	SET_OBJECT_DYNAMIC debris1_tm5 TRUE
	SET_OBJECT_DYNAMIC debris2_tm5 TRUE
	SET_OBJECT_DYNAMIC debris3_tm5 TRUE
	SET_OBJECT_DYNAMIC debris4_tm5 TRUE
	SET_OBJECT_VELOCITY debris1_tm5 -10.0 6.0 18.0
	SET_OBJECT_VELOCITY debris2_tm5 8.0 7.0 16.0
	SET_OBJECT_VELOCITY debris3_tm5 -7.0 10.0 14.0
	SET_OBJECT_VELOCITY debris4_tm5 9.0 6.0 15.0
	ADD_ONE_OFF_SOUND 969.8 -1104.9 18.7 sound_test_1
	//ADD_ONE_OFF_SOUND 971.7 -1101.2 17.5 sound_test_1

	WAIT 400
	SHAKE_CAM 500
	
	ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 974.2 -1129.8 19.5 0.0 0.0 0.0 5.0 0 0 0 5000
	//ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 973.6 -1128.8 19.6 0.0 0.0 0.0 4.0 0 0 0 4000
	ADD_EXPLOSION 982.0 -1102.8 17.4 EXPLOSION_HELI
	ADD_EXPLOSION 973.6 -1128.8 19.6 EXPLOSION_HELI
		CREATE_OBJECT fish01 982.0 -1103.8 20.4 debris5_tm5
		CREATE_OBJECT fish01 982.0 -1103.0 20.4 debris6_tm5
		CREATE_OBJECT fish01 983.0 -1112.0 20.4 debris7_tm5
		CREATE_OBJECT fish01 985.0 -1108.0 19.4 debris8_tm5
		CREATE_OBJECT fish01 977.0 -1113.0 21.4 debris9_tm5
		CREATE_OBJECT fish01 976.0 -1115.0 21.4 debris10_tm5
		SET_OBJECT_DYNAMIC debris5_tm5 TRUE
		SET_OBJECT_DYNAMIC debris6_tm5 TRUE
		SET_OBJECT_DYNAMIC debris7_tm5 TRUE
		SET_OBJECT_DYNAMIC debris8_tm5 TRUE
		SET_OBJECT_DYNAMIC debris9_tm5 TRUE
		SET_OBJECT_DYNAMIC debris10_tm5 TRUE
		SET_OBJECT_VELOCITY debris5_tm5 -3.0 6.0 18.0
		SET_OBJECT_VELOCITY debris6_tm5 5.0 7.0 16.0
		SET_OBJECT_VELOCITY debris7_tm5 -6.0 7.0 17.0
		SET_OBJECT_VELOCITY debris8_tm5 8.0 9.0 16.0
		SET_OBJECT_VELOCITY debris9_tm5 -7.0 8.0 14.0
		SET_OBJECT_VELOCITY debris10_tm5 -1.0 10.0 14.0
	ADD_ONE_OFF_SOUND 974.2 -1129.8 19.5 sound_test_1
	//ADD_ONE_OFF_SOUND 983.0 -1103.8 18.4 sound_test_1

	SET_FADING_COLOUR 255 255 255
	
	DO_FADE 400 FADE_OUT
	IF NOT IS_PLAYER_DEAD player
		SWAP_NEAREST_BUILDING_MODEL 981.5 -1123.9 16.7 80.0 fishfctory fshfctry_dstryd
	ENDIF
	DO_FADE 400 FADE_IN

	START_SCRIPT_FIRE 979.3 -1106.1 14.7 fish_Fire2
	START_SCRIPT_FIRE 981.0 -1132.0 14.0 fish_fire4
	START_SCRIPT_FIRE 970.6 -1107.5 18.5 fish_fire6
	START_SCRIPT_FIRE 965.8 -1123.4 14.0 fish_fire7

	fish_factory_destroyed = 1

	WAIT 3000

	RELEASE_WEATHER
	SWITCH_WIDESCREEN OFF
	SET_PLAYER_CONTROL Player ON
	SET_POLICE_IGNORE_PLAYER Player OFF
	SET_EVERYONE_IGNORE_PLAYER Player OFF
	RESTORE_CAMERA_JUMPCUT

}

GOTO mission_toni5_passed
 

 // Mission toni5 failed

mission_toni5_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission toni5 passed

mission_toni5_passed:

flag_toni_mission5_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 30000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 30000
REMOVE_BLIP frankie_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
SETUP_ZONE_PED_INFO FISHFAC DAY   ( 0) 0 0 0 (0 0 0 0) 0 //Fish factory  
SETUP_ZONE_PED_INFO FISHFAC NIGHT ( 0) 0 0 0 (0 0 0 0) 0
SWITCH_CAR_GENERATOR gen_car47 0
SWITCH_CAR_GENERATOR gen_car48 0
SWITCH_CAR_GENERATOR gen_car49 0
flag_frankie_switched_off = 0
REGISTER_MISSION_PASSED TM5
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP toni_contact_blip
START_NEW_SCRIPT toni5_flames_loop
RETURN
		


// mission cleanup

mission_cleanup_toni5:

flag_player_on_mission = 0
flag_player_on_toni_mission = 0
REMOVE_BLIP blip1_tm5
REMOVE_BLIP blip2_tm5
CLEAR_ONSCREEN_TIMER countdown_tm5
CLEAR_ONSCREEN_COUNTER explosive_truck_health
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_TRASHMASTER
MARK_MODEL_AS_NO_LONGER_NEEDED fshfctry_dstryd
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1 //TEST
SET_FADING_COLOUR 1 1 1
MISSION_HAS_FINISHED
RETURN



{
triad_AI:

	IF IS_PLAYER_IN_ZONE Player PORT_W
	AND has_player_been_at_fish_before = 1
	AND clear_triads_threats = 0

		IF NOT IS_CHAR_DEAD	fish_triad1
			CLEAR_CHAR_THREAT_SEARCH fish_triad1
		ENDIF
		IF NOT IS_CHAR_DEAD	fish_triad2
			CLEAR_CHAR_THREAT_SEARCH fish_triad2
		ENDIF
		IF NOT IS_CHAR_DEAD	fish_triad3
			CLEAR_CHAR_THREAT_SEARCH fish_triad3
		ENDIF
		IF NOT IS_CHAR_DEAD	fish_triad4
			CLEAR_CHAR_THREAT_SEARCH fish_triad4
		ENDIF
		IF NOT IS_CHAR_DEAD	fish_triad5
			CLEAR_CHAR_THREAT_SEARCH fish_triad5
		ENDIF
		IF NOT IS_CHAR_DEAD	fish_triad6
			CLEAR_CHAR_THREAT_SEARCH fish_triad6
		ENDIF

		CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1

		clear_triads_threats = 1
	ENDIF

	IF IS_PLAYER_IN_ZONE player FISHFAC	
		IF triads_spot_you = 0
			IF NOT IS_PLAYER_IN_ANY_CAR Player
			
				IF NOT IS_CHAR_DEAD	fish_triad1
					SET_CHAR_THREAT_SEARCH fish_triad1 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad2
					SET_CHAR_THREAT_SEARCH fish_triad2 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad3
					SET_CHAR_THREAT_SEARCH fish_triad3 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad4
					SET_CHAR_THREAT_SEARCH fish_triad4 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad5
					SET_CHAR_THREAT_SEARCH fish_triad5 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad6
					SET_CHAR_THREAT_SEARCH fish_triad6 THREAT_PLAYER1
				ENDIF

				SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1 //TEST

				triads_spot_you = 1
			ENDIF
			
			IF IS_CHAR_DEAD	fish_triad1
			OR IS_CHAR_DEAD fish_triad2
			OR IS_CHAR_DEAD fish_triad3
			OR IS_CHAR_DEAD fish_triad4
			OR IS_CHAR_DEAD fish_triad5
			OR IS_CHAR_DEAD fish_triad6

				IF NOT IS_CHAR_DEAD	fish_triad1
					SET_CHAR_THREAT_SEARCH fish_triad1 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad2
					SET_CHAR_THREAT_SEARCH fish_triad2 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad3
					SET_CHAR_THREAT_SEARCH fish_triad3 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad4
					SET_CHAR_THREAT_SEARCH fish_triad4 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad5
					SET_CHAR_THREAT_SEARCH fish_triad5 THREAT_PLAYER1
				ENDIF
				IF NOT IS_CHAR_DEAD	fish_triad6
					SET_CHAR_THREAT_SEARCH fish_triad6 THREAT_PLAYER1
				ENDIF

				SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1 //TEST

				triads_spot_you = 1
			ENDIF
		ENDIF
	ENDIF


 RETURN
 }



Truck_health:
{

	IF NOT IS_CAR_DEAD explosive_truck 

		GET_CAR_HEALTH explosive_truck explosive_truck_health 
		explosive_truck_health2 = 1000 - explosive_truck_health
		IF explosive_truck_health2 > 100
			explosive_truck_health2 = 100
		ENDIF
		explosive_truck_health = explosive_truck_health2 

	ENDIF

RETURN
}
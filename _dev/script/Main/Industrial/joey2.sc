MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Joey mission 2****************************************
// ************************************Kill Chunky Dave***************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_joey2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey2_failed
ENDIF

GOSUB mission_cleanup_joey2

MISSION_END


// Variables for mission


VAR_INT chunkys_car chunkys_car2// mission specific ped

VAR_INT blip1_jm2 blip2_jm2 //blip3_jm2 

VAR_INT chunky_mate1 chunky_mate2 chunky_mate3 

VAR_INT mate1health mate2health mate3health chunkyhealth

VAR_INT been_in_shop_before noodle_stand gun_chunky

VAR_INT flag_gun_message_jm2 has_audio_been_activated

//VAR_INT test_car_health_counter

//VAR_INT flag_player_got_joey2_message


// ***************************************Mission Start*************************************

mission_start_joey2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
SCRIPT_NAME joey2
WAIT 0

flag_gun_message_jm2 = 0
has_audio_been_activated = 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_joey2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( JM2 ) 15000 2 //"Joey Mission 2"
*/

{

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_MODEL cut_obj1 JOEYH
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL cut_obj3 TROLL
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint

/*
WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE
*/

//LOAD_SCENE 1190.07 -869.86 13.97

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED	cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
	WAIT 0
ENDWHILE

LOAD_CUTSCENE J2_KCL
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ1 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT CUT_OBJ3 cs_troll
SET_CUTSCENE_ANIM cs_troll TROLL
									   	
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 FALSE
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 FALSE

CLEAR_AREA 1191.9 -870.4 15.0 1.0 TRUE
SET_PLAYER_COORDINATES player 1191.9 -870.4 -100.0

SET_PLAYER_HEADING player 230.0

DO_FADE 1500 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 5118
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_A ) 10000 2 // Mission brief

WHILE cs_time < 10669
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_B ) 10000 2 // Mission brief

WHILE cs_time < 13048
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_C ) 10000 2 // Mission brief

WHILE cs_time < 15427
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_D ) 10000 2 // Mission brief

WHILE cs_time < 17662
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_E ) 10000 2 // Mission brief

WHILE cs_time < 18887
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_F ) 10000 2 // Mission brief

WHILE cs_time < 22708
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_G ) 10000 2 // Mission brief

WHILE cs_time < 25159
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM2_H ) 10000 2 // Mission brief

WHILE cs_time < 28982
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 31000
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

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 TRUE
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 TRUE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

LOAD_SPECIAL_CHARACTER 2 chunky
REQUEST_MODEL PED_GANG_TRIAD_A
REQUEST_MODEL CAR_PERENNIAL

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
	OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
	OR NOT HAS_MODEL_LOADED CAR_PERENNIAL
		WAIT 0
	ENDWHILE

//ADD_BLIP_FOR_COORD 1080.0 -397.0 -100.0 blip2_jm2

CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ONCE 45 1080.5 -396.0 -100.0 gun_chunky
ADD_SPRITE_BLIP_FOR_PICKUP gun_chunky RADAR_SPRITE_WEAPON blip2_jm2

CREATE_OBJECT noodlesbox 975.0 -720.0 14.0 noodle_stand  


// START OF MISSION

CREATE_CAR CAR_PERENNIAL 1007.1 -756.4 14.5 chunkys_car
SET_CAR_HEADING chunkys_car 120.0
//LOCK_CAR_DOORS chunkys_car CARLOCK_LOCKOUT_PLAYER_ONLY

CREATE_CAR CAR_PERENNIAL 912.3 -686.1 14.5 chunkys_car2
SET_CAR_HEADING chunkys_car2 90.0
//LOCK_CAR_DOORS chunkys_car2 CARLOCK_LOCKOUT_PLAYER_ONLY

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 976.1 -715.3 14.2 chunky_mate1
SET_CHAR_HEADING chunky_mate1 346.0
GIVE_WEAPON_TO_CHAR chunky_mate1 WEAPONTYPE_BASEBALLBAT 0
SET_CHAR_OBJ_GUARD_SPOT chunky_mate1 976.1 -715.3 14.2
SET_CHAR_PERSONALITY chunky_mate1 PEDSTAT_TOUGH_GUY

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 975.7 -724.7 14.2 chunky_mate2
SET_CHAR_HEADING chunky_mate2 222.0
GIVE_WEAPON_TO_CHAR chunky_mate2 WEAPONTYPE_BASEBALLBAT 0
SET_CHAR_OBJ_GUARD_SPOT chunky_mate2 975.7 -724.7 14.2
SET_CHAR_PERSONALITY chunky_mate2 PEDSTAT_TOUGH_GUY

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 984.0 -727.7 14.2 chunky_mate3
SET_CHAR_HEADING chunky_mate3 243.0
GIVE_WEAPON_TO_CHAR chunky_mate3 WEAPONTYPE_PISTOL 100
SET_CHAR_OBJ_GUARD_SPOT chunky_mate3 984.0 -727.7 14.2
SET_CHAR_PERSONALITY chunky_mate3 PEDSTAT_TOUGH_GUY

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 975.3 -720.4 14.2 chunky
SET_CHAR_HEADING chunky 270.0
ADD_BLIP_FOR_CHAR chunky blip1_jm2
SET_CHAR_OBJ_WAIT_ON_FOOT chunky
SET_CHAR_PERSONALITY chunky PEDSTAT_GEEK_GUY
SET_CHAR_RUNNING chunky TRUE
//SET_CHAR_HEALTH chunky 100
ADD_ARMOUR_TO_CHAR chunky 100
CHANGE_BLIP_DISPLAY blip1_jm2 BLIP_ONLY
SET_ANIM_GROUP_FOR_CHAR chunky ANIM_PANIC_CHUNKYPED 

WHILE NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player chunky 25.0 26.0 4.0 FALSE
	WAIT 0
	
		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		GOSUB controller_modes

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF
		
		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF

		IF NOT IS_CHAR_DEAD chunky
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky True
			GET_CHAR_HEALTH	chunky chunkyhealth
		ENDIF
		IF NOT IS_CHAR_DEAD chunky_mate1
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate1 True
			GET_CHAR_HEALTH chunky_mate1 mate1health
		ENDIF
		IF NOT IS_CHAR_DEAD	chunky_mate2
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate2 True
			GET_CHAR_HEALTH chunky_mate2 mate2health
		ENDIF
		IF NOT IS_CHAR_DEAD	chunky_mate3
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate3 True
			GET_CHAR_HEALTH chunky_mate3 mate3health
		ENDIF
		
		IF mate1health < 99
		OR mate2health < 99
		OR mate3health < 99
		OR chunkyhealth < 99
			GOTO kill_and_run
		ENDIF
	   	
	   	IF IS_CHAR_DEAD chunky_mate1
		OR IS_CHAR_DEAD chunky_mate2
		OR IS_CHAR_DEAD chunky_mate3
			GOTO kill_and_run
		ENDIF

ENDWHILE

SET_POLICE_IGNORE_PLAYER Player ON
SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON
SET_PED_DENSITY_MULTIPLIER 0.0

//SET_FIXED_CAMERA_POSITION 977.756 -719.673 16.206 0.0 0.0 0.0
SET_FIXED_CAMERA_POSITION 984.819 -704.631 21.468 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 984.279 -705.429 21.202 JUMP_CUT

//IF NOT IS_CHAR_DEAD	chunky
//	POINT_CAMERA_AT_CHAR chunky FIXED JUMP_CUT
//ENDIF

WAIT 3000

SET_FIXED_CAMERA_POSITION 978.135 -718.497 15.642 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 977.293 -719.016 15.794 JUMP_CUT

//SET_FIXED_CAMERA_POSITION 984.1 -714.9 17.4 0.0 0.0 0.0 
//IF NOT IS_CHAR_DEAD	chunky
//	POINT_CAMERA_AT_CHAR chunky FIXED INTERPOLATION
//ENDIF

WAIT 3000

SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER Player OFF
SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
//REMOVE_BLIP blip3_jm2

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player chunky 20.0 18.0 4.0 FALSE

	WAIT 0
	
		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		GOSUB controller_modes

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF

		IF NOT IS_CHAR_DEAD chunky
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky True
			GET_CHAR_HEALTH	chunky chunkyhealth
		ENDIF
		IF NOT IS_CHAR_DEAD chunky_mate1
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate1 True
			GET_CHAR_HEALTH chunky_mate1 mate1health
		ENDIF
		IF NOT IS_CHAR_DEAD	chunky_mate2
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate2 True
			GET_CHAR_HEALTH chunky_mate2 mate2health
		ENDIF
		IF NOT IS_CHAR_DEAD	chunky_mate3
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate3 True
			GET_CHAR_HEALTH chunky_mate3 mate3health
		ENDIF
		
		IF mate1health < 99
		OR mate2health < 99
		OR mate3health < 99
		OR chunkyhealth < 99
			GOTO kill_and_run
		ENDIF
 
		IF IS_CHAR_DEAD chunky_mate1
		OR IS_CHAR_DEAD chunky_mate2
		OR IS_CHAR_DEAD chunky_mate3
			GOTO kill_and_run
		ENDIF

ENDWHILE

kill_and_run:

//REMOVE_BLIP blip3_jm2

CHANGE_BLIP_DISPLAY blip1_jm2 BOTH

	IF NOT IS_CHAR_DEAD chunky_mate1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chunky_mate1 Player
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate1 false
		SET_CHAR_THREAT_SEARCH chunky_mate1 THREAT_PLAYER1	
	ENDIF

	IF NOT IS_CHAR_DEAD chunky_mate2
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chunky_mate2 Player
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate2 false
		SET_CHAR_THREAT_SEARCH chunky_mate2 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD chunky_mate3
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chunky_mate3 Player
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky_mate3 false
		SET_CHAR_THREAT_SEARCH chunky_mate3 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD chunky	
		SET_CHAR_HEED_THREATS chunky False
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER chunky false
	ENDIF

SET_CHAR_OBJ_RUN_TO_COORD chunky 975.5 -722.9

TIMERB = 0

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		GOSUB pickup_and_audio

ENDWHILE


IF IS_PLAYER_IN_AREA_2D	player 974.2 -727.5	1003.4 -748.8 FALSE
	GOTO run_the_other_way
ENDIF


SET_CHAR_OBJ_RUN_TO_COORD chunky 985.1 -733.9

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		GOSUB pickup_and_audio

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD chunky 1004.2 -736.9

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		GOSUB pickup_and_audio

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD chunky 1006.3 -753.2

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		GOSUB pickup_and_audio

ENDWHILE

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	IF IS_CAR_DEAD chunkys_car
		GOTO fuckin_run_for_it
	ELSE
		IF NOT IS_CAR_IN_AREA_2D chunkys_car 1004.0 -738.0 1012.0 -763.0 FALSE
		OR NOT IS_CAR_HEALTH_GREATER chunkys_car 300
			GOTO fuckin_run_for_it
		ENDIF
	ENDIF
			
SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER chunky chunkys_car

WHILE NOT IS_CHAR_IN_CAR chunky chunkys_car
	WAIT 0

		IF IS_CAR_DEAD chunkys_car
			GOTO fuckin_run_for_it
		ELSE

			IF NOT IS_CAR_IN_AREA_2D chunkys_car 1004.0 -738.0 1012.0 -763.0 FALSE
			OR NOT IS_CAR_HEALTH_GREATER chunkys_car 300
				GOTO fuckin_run_for_it
			ENDIF
		ENDIF
			
		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF

ENDWHILE

	IF NOT IS_CAR_DEAD chunkys_car
		CAR_WANDER_RANDOMLY chunkys_car
		SET_CAR_DRIVING_STYLE chunkys_car 2
		SET_CAR_CRUISE_SPEED chunkys_car 20.0
		//LOCK_CAR_DOORS chunkys_car CARLOCK_UNLOCKED
	ENDIF

//DISPLAY_ONSCREEN_COUNTER test_car_health_counter //TEST STUFF!!!!!!!!!!!!!

WHILE IS_CAR_HEALTH_GREATER chunkys_car 300
	WAIT 0 

		GOSUB controller_modes

		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		IF IS_CAR_DEAD chunkys_car
			GOTO mission_joey2_passed
		ENDIF

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player chunky 160.0 160.0 FALSE
			PRINT_NOW ( AWAY ) 5000 2 // Mission brief
			GOTO mission_joey2_failed
		ENDIF

		IF NOT IS_CHAR_IN_CAR chunky chunkys_car
			GOTO fuckin_run_for_it	
		ENDIF 

		IF IS_CAR_UPSIDEDOWN chunkys_car
		AND IS_CAR_STOPPED chunkys_car
			SET_CHAR_OBJ_LEAVE_CAR chunky chunkys_car
			GOTO fuckin_run_for_it
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF

ENDWHILE


	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

SET_CHAR_OBJ_LEAVE_CAR chunky chunkys_car

WHILE IS_CHAR_IN_CAR chunky chunkys_car
	WAIT 0

		GOSUB controller_modes

		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player chunky 160.0 160.0 FALSE
			PRINT_NOW ( AWAY ) 5000 2 // Mission brief
			GOTO mission_joey2_failed
		ENDIF

		IF IS_CAR_DEAD chunkys_car
			GOTO mission_joey2_passed
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF
		
ENDWHILE

GOTO fuckin_run_for_it


run_the_other_way:

SET_CHAR_OBJ_RUN_TO_COORD chunky 979.1 -720.8

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	GOSUB pickup_and_audio

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD chunky 976.7 -687.0

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	GOSUB pickup_and_audio

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD chunky 943.5 -679.2

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	GOSUB pickup_and_audio

ENDWHILE

SET_CHAR_OBJ_RUN_TO_COORD chunky 920.3 -681.5

WHILE NOT IS_CHAR_OBJECTIVE_PASSED chunky
	WAIT 0

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	GOSUB pickup_and_audio

ENDWHILE

	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

	IF IS_CAR_DEAD chunkys_car2
		GOTO fuckin_run_for_it
	ELSE
		IF NOT IS_CAR_IN_AREA_2D chunkys_car2 922.7 -673.9 906.6 -698.0 FALSE
		OR NOT IS_CAR_HEALTH_GREATER chunkys_car2 300
			GOTO fuckin_run_for_it
		ENDIF
	ENDIF
 		
SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER chunky chunkys_car2

	WHILE NOT IS_CHAR_IN_CAR chunky chunkys_car2
		WAIT 0

		IF IS_CAR_DEAD chunkys_car2
			GOTO fuckin_run_for_it
		ELSE
			IF NOT IS_CAR_IN_AREA_2D chunkys_car2 922.7 -673.9 906.6 -698.0 FALSE
			OR NOT IS_CAR_HEALTH_GREATER chunkys_car2 300
				GOTO fuckin_run_for_it
			ENDIF
		ENDIF
		
		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF
				
		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

	ENDWHILE

	IF NOT IS_CAR_DEAD chunkys_car2
		CAR_WANDER_RANDOMLY chunkys_car2
		SET_CAR_DRIVING_STYLE chunkys_car2 2
		SET_CAR_CRUISE_SPEED chunkys_car2 20.0
		//LOCK_CAR_DOORS chunkys_car2 CARLOCK_UNLOCKED
	ENDIF

//DISPLAY_ONSCREEN_COUNTER test_car_health_counter //TEST STUFF!!!!!!!!!!!!!

	WHILE IS_CAR_HEALTH_GREATER chunkys_car2 300
		WAIT 0 

		GOSUB controller_modes

		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		IF IS_CAR_DEAD chunkys_car2
			GOTO mission_joey2_passed
		ENDIF

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player chunky 160.0 160.0 FALSE
			PRINT_NOW ( AWAY ) 5000 2 // Mission brief
			GOTO mission_joey2_failed
		ENDIF

		IF NOT IS_CHAR_IN_CAR chunky chunkys_car2
			GOTO fuckin_run_for_it	
		ENDIF 

		IF IS_CAR_UPSIDEDOWN chunkys_car2
		AND IS_CAR_STOPPED chunkys_car2
			SET_CHAR_OBJ_LEAVE_CAR chunky chunkys_car2
			GOTO fuckin_run_for_it
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF

		
	ENDWHILE


	IF IS_CHAR_DEAD chunky
		GOTO mission_joey2_passed
	ENDIF

SET_CHAR_OBJ_LEAVE_CAR chunky chunkys_car2

WHILE IS_CHAR_IN_CAR chunky chunkys_car2
	WAIT 0

		GOSUB controller_modes

		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player chunky 160.0 160.0 FALSE
			PRINT_NOW ( AWAY ) 5000 2 // Mission brief
			GOTO mission_joey2_failed
		ENDIF

		IF IS_CAR_DEAD chunkys_car2
			GOTO mission_joey2_passed
		ENDIF

		IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
		AND been_in_shop_before = 0 
			REMOVE_BLIP blip2_jm2
			been_in_shop_before = 1	
		ENDIF
		
ENDWHILE


fuckin_run_for_it:

IF NOT IS_CHAR_DEAD chunky
	SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS chunky Player
ENDIF

//CHANGE_BLIP_DISPLAY blip1_jm2 BOTH

WHILE NOT IS_CHAR_DEAD chunky
	WAIT 0

		IF IS_CHAR_DEAD chunky
			GOTO mission_joey2_passed
		ENDIF

		GOSUB controller_modes

		GOSUB pickup_and_audio

		IF NOT HAS_PICKUP_BEEN_COLLECTED gun_chunky
			GOSUB Ammu_bloke_audio
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player chunky 160.0 160.0 FALSE
			PRINT_NOW ( AWAY ) 5000 2 // Mission brief
			GOTO mission_joey2_failed
		ENDIF

ENDWHILE
   
}
GOTO mission_joey2_passed


 // Mission joey2 failed

mission_joey2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission joey2 passed

mission_joey2_passed:

flag_joey_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED	JM2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT joey_mission3_loop
IF out_of_stock_pistol = 0
   	START_NEW_SCRIPT pistol_message
ENDIF
RETURN
		
// mission cleanup

mission_cleanup_joey2:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
special_ammu_audio = 0		 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PERENNIAL
UNLOAD_SPECIAL_CHARACTER 2
REMOVE_BLIP blip1_jm2
REMOVE_BLIP blip2_jm2
REMOVE_PICKUP gun_chunky
IF NOT IS_CHAR_DEAD	chunky
	REMOVE_CHAR_ELEGANTLY chunky
ENDIF
MISSION_HAS_FINISHED
RETURN




controller_modes:
{
	IF flag_player_had_gun_message = 0

		IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 1075.2 -384.8 14.0 1086.2 -403.3 17.0 FALSE
		
			GET_CONTROLLER_MODE controlmode

// Control Mode 0

			IF controlmode = 0
							
				IF flag_gun_message_jm2 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_jm2 = 1
				ENDIF

				IF flag_gun_message_jm2 = 1
					IF timerb > 10000
						PRINT_HELP ( GUN_2A ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_jm2 = 2
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 2
					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_jm2 = 3
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 3
					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_jm2 = 4
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 4
					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_jm2 = 5
						flag_player_had_gun_message = 1
					ENDIF
				ENDIF

			ENDIF

// Control Mode 1

			IF controlmode = 1
			
				IF flag_gun_message_jm2 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_jm2 = 1
				ENDIF

				IF flag_gun_message_jm2 = 1
					IF timerb > 10000
						PRINT_HELP ( GUN_2A ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_jm2 = 2
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 2
					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_jm2 = 3
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 3
					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_jm2 = 4
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 4
					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_jm2 = 5
						flag_player_had_gun_message = 1
					ENDIF
				ENDIF

							
			ENDIF

// Control Mode 2

			IF controlmode = 2
			
				IF flag_gun_message_jm2 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_jm2 = 1
				ENDIF

				IF flag_gun_message_jm2 = 1
					IF timerb > 10000
						PRINT_HELP ( GUN_2C ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_jm2 = 2
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 2
					IF timerb > 10000
						PRINT_HELP ( GUN_3A ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_jm2 = 3
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 3
					IF timerb > 10000
						PRINT_HELP ( GUN_4A ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_jm2 = 4
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 4
					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_jm2 = 5
						flag_player_had_gun_message = 1
					ENDIF
				ENDIF
								
			ENDIF

// Control Mode 3

			IF controlmode = 3
			
				IF flag_gun_message_jm2 = 0 
					PRINT_HELP ( GUN_1A ) //"Use R2 and L2 to cycle through your weapons."
					timerb = 0
					flag_gun_message_jm2 = 1
				ENDIF

				IF flag_gun_message_jm2 = 1
					IF timerb > 10000
						PRINT_HELP ( GUN_2D ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_jm2 = 2
					   //	flag_player_had_gun_message = 1
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 1
					IF timerb > 10000
						PRINT_HELP ( GUN_2C ) //"Hold R1 to auto-target, press circle to fire!"
						timerb = 0
						flag_gun_message_jm2 = 2
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 2
					IF timerb > 10000
						PRINT_HELP ( GUN_3B ) //"While holding the ~h~R1 button,~w~ press the ~h~L2 button~w~ or the ~h~R2 button to switch target."
						timerb = 0
						flag_gun_message_jm2 = 3
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 3
					IF timerb > 10000
						PRINT_HELP ( GUN_4B ) //"While holding the ~h~R1 button~w~ you can walk or run while remaining locked onto a target."
						timerb = 0
						flag_gun_message_jm2 = 4
					ENDIF
				ENDIF

				IF flag_gun_message_jm2 = 4
					IF timerb > 10000
						PRINT_HELP ( GUN_5 ) //"You can practice targeting and shooting on these paper targets, when you are finished resume the mission."
						flag_gun_message_jm2 = 5
						flag_player_had_gun_message = 1
					ENDIF
				ENDIF
								
			ENDIF
				
		ENDIF

	ENDIF


RETURN
}



Ammu_bloke_audio:
{

	IF has_audio_been_activated = 0

		IF IS_PLAYER_IN_AREA_3D player 1066.6 -403.5 14.0 1072.8 -394.0 18.0 FALSE 

		 	special_ammu_audio = 1

			LOAD_MISSION_AUDIO AMMU_B //AMMU_B

			IF camera_ammu1 = 1

				IF NOT IS_CHAR_DEAD ammu_shop_bloke1
					
					WHILE NOT HAS_MISSION_AUDIO_LOADED
						WAIT 0

						IF IS_CHAR_DEAD ammu_shop_bloke1
						OR IS_PLAYER_SHOOTING player
							GOTO clear_audio   
						ENDIF

					ENDWHILE

					PLAY_MISSION_AUDIO
					PRINT_NOW ( AMMU_B ) 5000 2 // Mission brief
					
					WHILE NOT HAS_MISSION_AUDIO_FINISHED
						WAIT 0

						IF IS_CHAR_DEAD ammu_shop_bloke1
						OR IS_PLAYER_SHOOTING player
							GOTO clear_audio   
						ENDIF

					ENDWHILE
					
					LOAD_MISSION_AUDIO AMMU_C //AMMU_C
		
					WHILE NOT HAS_MISSION_AUDIO_LOADED
						WAIT 0

						IF IS_CHAR_DEAD ammu_shop_bloke1
						OR IS_PLAYER_SHOOTING player
							GOTO clear_audio   
						ENDIF

					ENDWHILE

					PLAY_MISSION_AUDIO
					PRINT_NOW ( AMMU_C ) 5000 2 // Mission brief

					clear_audio:
					has_audio_been_activated = 1
					//CLEAR_MISSION_AUDIO 
					special_ammu_audio = 0
				ELSE
					special_ammu_audio = 0
					CLEAR_MISSION_AUDIO	
				ENDIF

			ENDIF

		ELSE
			special_ammu_audio = 0
			CLEAR_MISSION_AUDIO
		ENDIF

	ENDIF
		

RETURN
}


pickup_and_audio:

{
	IF HAS_PICKUP_BEEN_COLLECTED gun_chunky  
	AND been_in_shop_before = 0 
		REMOVE_BLIP blip2_jm2
		been_in_shop_before = 1	
	ENDIF

	IF NOT IS_CHAR_DEAD chunky
		IF TIMERB > 2500
			TIMERB = 0
			SET_CHAR_SAY chunky	SOUND_CHUNKY_RUN_SHOUT
		ENDIF
	ENDIF

RETURN
}
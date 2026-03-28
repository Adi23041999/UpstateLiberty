MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 2****************************************
// **************************************Triad Ambush*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_toni2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_toni2_failed
ENDIF

GOSUB mission_cleanup_toni2

MISSION_END


// Variables for mission

VAR_INT thong1 thong1B thong2 thong2B thong3 thong3B thong_car	// gang members for mission

VAR_INT blip1_t2 blip2_t2 thong_blip1 thong_blip1B thong_blip2 thong_blip2B thong_blip3 thong_blip3B

VAR_INT thong1_dead thong1B_dead thong2_dead thong2B_dead thong3_dead thong3B_dead thongs_killed thongs_killed_message

VAR_INT briefcase_tm2 traid_threat_cleared_T2 

// ***************************************Mission Start*************************************

mission_start_toni2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_toni_mission = 1
SCRIPT_NAME toni2
WAIT 0

thong1_dead = 0
thong1B_dead = 0
thong2_dead = 0
thong2B_dead = 0
thong3_dead = 0
thong3B_dead = 0
thongs_killed = 0
thongs_killed_message = 0
traid_threat_cleared_T2 = 0

{

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH			
LOAD_SPECIAL_MODEL cut_obj2	NOTE
REQUEST_MODEL ind_newrizzos


LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED ind_newrizzos
	WAIT 0

ENDWHILE

LOAD_CUTSCENE T2_TPU
SET_CUTSCENE_OFFSET 1218.42 -314.5 28.9
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj2 cs_note
SET_CUTSCENE_ANIM cs_note NOTE

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


WHILE cs_time < 151 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM2_A ) 10000 1 

WHILE cs_time < 3879
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM2_AA ) 10000 1 

WHILE cs_time < 7522
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( TM2_B ) 10000 1 

WHILE cs_time < 10947
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM2_C ) 10000 1 

WHILE cs_time < 14507
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM2_D ) 10000 1 

WHILE cs_time < 18705
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM2_E ) 10000 1 

WHILE cs_time < 22114
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 23333
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

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED ind_newrizzos


// START OF MISSION

IF IS_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
	CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
	traid_threat_cleared_T2 = 1
ENDIF

SWITCH_CAR_GENERATOR gen_car31 0

CREATE_PICKUP briefcase PICKUP_ONCE 865.7 -663.6 14.8 briefcase_tm2

ADD_BLIP_FOR_PICKUP	briefcase_tm2 blip1_t2

REQUEST_MODEL CAR_BELLYUP
REQUEST_MODEL PED_GANG_TRIAD_A
REQUEST_MODEL PED_GANG_TRIAD_B

WHILE NOT HAS_MODEL_LOADED CAR_BELLYUP
OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_B
	WAIT 0
ENDWHILE


main_toni2:

	WAIT 0
		
WHILE NOT HAS_PICKUP_BEEN_COLLECTED briefcase_tm2
	WAIT 0

ENDWHILE

REMOVE_BLIP blip1_t2

SET_POLICE_IGNORE_PLAYER Player On
SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON			

				CLEAR_AREA 869.4 -639.0 15.0 1.0 TRUE
				CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 869.4 -639.0 -100.0 thong1
				GIVE_WEAPON_TO_CHAR thong1 WEAPONTYPE_BASEBALLBAT 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT thong1 869.4 -656.0

				CLEAR_AREA 868.5 -637.0 15.0 1.0 TRUE
				CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 868.5 -637.0 -100.0 thong1B
				SET_CHAR_HEADING thong1B 180.0
				GIVE_WEAPON_TO_CHAR thong1B WEAPONTYPE_PISTOL 200
				//SET_CHAR_OBJ_GOTO_COORD_ON_FOOT thong1B 869.4 -656.0

			SET_FIXED_CAMERA_POSITION 869.7 -666.0 16.0 0.0 0.0 0.0

			POINT_CAMERA_AT_CHAR thong1 FIXED INTERPOLATION

			WAIT 2500

				CLEAR_AREA 869.4 -688.0 15.0 1.0 TRUE
				CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 869.4 -688.0 -100.0 thong2
				GIVE_WEAPON_TO_CHAR thong2 WEAPONTYPE_BASEBALLBAT 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT thong2 869.4 -678.0

				CLEAR_AREA 868.5 -690.0 15.0 1.0 TRUE
				CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 868.5 -690.0 -100.0 thong2B
				GIVE_WEAPON_TO_CHAR thong2B WEAPONTYPE_PISTOL 100
				//SET_CHAR_OBJ_GOTO_COORD_ON_FOOT thong2B 869.4 -678.0

			POINT_CAMERA_AT_CHAR thong2 FIXED INTERPOLATION
			
			WAIT 2500

				CLEAR_AREA 892.6 -666.0 15.0 4.0 TRUE
				CREATE_CAR CAR_BELLYUP 892.5 -666.0 -100.0 thong_car
				SET_CAR_HEADING thong_car 180.0
				CREATE_CHAR_INSIDE_CAR thong_car PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A thong3
				CREATE_CHAR_AS_PASSENGER thong_car PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 0 thong3B
				GIVE_WEAPON_TO_CHAR thong3 WEAPONTYPE_PISTOL 27
				GIVE_WEAPON_TO_CHAR thong3B WEAPONTYPE_BASEBALLBAT 1
				CAR_SET_IDLE thong_car

				POINT_CAMERA_AT_CAR thong_car FIXED INTERPOLATION

				SET_CHAR_OBJ_LEAVE_CAR thong3B thong_car

				WHILE IS_CHAR_IN_CAR thong3B thong_car
				   WAIT 0	
					IF IS_CHAR_DEAD thong3B
					OR IS_CAR_DEAD thong_car
						GOTO next_bit_tm2
					ENDIF

				ENDWHILE

				IF NOT IS_CHAR_DEAD thong3B
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT thong3B 886.2 -665.8
				ENDIF

			WAIT 2500

			next_bit_tm2:


	SET_PLAYER_CONTROL Player On
	SET_POLICE_IGNORE_PLAYER Player OFF
	SWITCH_WIDESCREEN OFF
	RESTORE_CAMERA

			WAIT 0

			IF NOT IS_CHAR_DEAD thong1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong1 player
				SET_CHAR_THREAT_SEARCH thong1 THREAT_PLAYER1  
			ENDIF

			IF NOT IS_CHAR_DEAD thong1B
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong1B player
				SET_CHAR_THREAT_SEARCH thong1B THREAT_PLAYER1  
			ENDIF

			IF NOT IS_CHAR_DEAD thong2
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong2 player
				SET_CHAR_THREAT_SEARCH thong2 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD thong2B
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong2B player
				SET_CHAR_THREAT_SEARCH thong2B THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD thong3B
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong3B player
				SET_CHAR_THREAT_SEARCH thong3B THREAT_PLAYER1
			ENDIF

PRINT_NOW ( TM2_3 ) 5000 1	// " Get back to Toni's!"

IF NOT IS_CHAR_DEAD thong1
	ADD_BLIP_FOR_CHAR thong1 thong_blip1
ENDIF
IF NOT IS_CHAR_DEAD thong1B
	ADD_BLIP_FOR_CHAR thong1B thong_blip1B
ENDIF
IF NOT IS_CHAR_DEAD thong2
	ADD_BLIP_FOR_CHAR thong2 thong_blip2
ENDIF
IF NOT IS_CHAR_DEAD thong2B
	ADD_BLIP_FOR_CHAR thong2B thong_blip2B
ENDIF
IF NOT IS_CHAR_DEAD thong3
	ADD_BLIP_FOR_CHAR thong3 thong_blip3
ENDIF
IF NOT IS_CHAR_DEAD thong3B
	ADD_BLIP_FOR_CHAR thong3B thong_blip3B
ENDIF
			
WHILE NOT thongs_killed = 6
	WAIT 0

		IF IS_CHAR_DEAD thong1
		AND thong1_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip1
			thong1_dead = 1
		ENDIF
		
		IF IS_CHAR_DEAD thong1B
		AND thong1B_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip1B
			thong1B_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thong2
		AND thong2_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip2
			thong2_dead = 1
		ENDIF
		
		IF IS_CHAR_DEAD thong2B
		AND thong2B_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip2B
			thong2B_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thong3
		AND thong3_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip3
			thong3_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thong3B
		AND thong3B_dead = 0
			thongs_killed ++
			//ADD_SCORE player 500
			REMOVE_BLIP	thong_blip3B
			thong3B_dead = 1
		ENDIF

		IF NOT IS_PLAYER_IN_AREA_2D player 890.0 -639.3 846.6 -688.0 FALSE

			IF NOT IS_CHAR_DEAD thong1B
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong1B player
				//SET_CHAR_THREAT_SEARCH thong1B THREAT_PLAYER1  
			ENDIF

			IF NOT IS_CHAR_DEAD thong2B
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong2B player
				//SET_CHAR_THREAT_SEARCH thong1B THREAT_PLAYER1  
			ENDIF

			IF NOT IS_CHAR_DEAD thong3
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS thong3 player
				SET_CHAR_THREAT_SEARCH thong3 THREAT_PLAYER1
			ENDIF

		ENDIF

ENDWHILE


	PRINT_NOW ( TM2_1 ) 5000 1	// " Get back to Toni's!"

	ADD_BLIP_FOR_COORD 1223.0 -327.0 -100.0 blip2_t2
	//CHANGE_BLIP_DISPLAY blip2_t2 BLIP_ONLY

	  
WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 1219.6 -320.7 27.4 1.0 1.0 2.0 TRUE
	WAIT 0

		/*	 
		IF thongs_killed = 6
		AND thongs_killed_message = 0
			PRINT_NOW ( TM2_2 ) 6000 1
			ADD_SCORE player 500
			thongs_killed_message = 1 
		ENDIF 
		*/ 		
ENDWHILE

	SET_PLAYER_CONTROL Player OFF
	SET_POLICE_IGNORE_PLAYER Player ON
	SWITCH_WIDESCREEN ON

GET_PLAYER_CHAR Player script_controlled_player
SET_CHAR_RUNNING script_controlled_player TRUE
	 
SET_FIXED_CAMERA_POSITION 1214.4 -323.9 29.8 0.0 0.0 0.
POINT_CAMERA_AT_POINT 1215.2 -323.4 29.4 JUMP_CUT


CLEAR_AREA 1219.6 -314.0 29.7 2.0 TRUE
SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 1219.6 -314.0

PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000

TIMERB = 0

WHILE NOT IS_CHAR_OBJECTIVE_PASSED script_controlled_player
	WAIT 0

	IF TIMERB > 7000
		IF NOT IS_CHAR_DEAD	script_controlled_player
			SET_CHAR_COORDINATES script_controlled_player 1219.6 -314.0 -100.0
		ENDIF
	ENDIF

ENDWHILE

CLEAR_AREA 1219.6 -323.8 26.8 2.0 TRUE
SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 1219.6 -323.8

TIMERB = 0

WHILE NOT IS_CHAR_OBJECTIVE_PASSED script_controlled_player
	WAIT 0

	IF TIMERB > 7000
		IF NOT IS_CHAR_DEAD	script_controlled_player
			SET_CHAR_COORDINATES script_controlled_player 1219.6 -323.8 -100.0
		ENDIF
	ENDIF

ENDWHILE

	SET_PLAYER_CONTROL Player ON
	SET_POLICE_IGNORE_PLAYER Player OFF
	SWITCH_WIDESCREEN OFF
	RESTORE_CAMERA_JUMPCUT
	SET_CHAR_RUNNING script_controlled_player FALSE
}
		 
GOTO mission_toni2_passed 


 // Mission toni2 failed

mission_toni2_failed:
RETURN

   

// mission toni2 passed

mission_toni2_passed:

flag_toni_mission2_passed = 1
//PLAY_MISSION_PASSED_TUNE 1
//PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
//CLEAR_WANTED_LEVEL player
//ADD_SCORE player 10000
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
REGISTER_MISSION_PASSED	TM2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT toni_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_toni2:

flag_player_on_mission = 0
flag_player_on_toni_mission = 0
SWITCH_CAR_GENERATOR gen_car31 101	
REMOVE_BLIP blip1_t2
REMOVE_BLIP blip2_t2
REMOVE_BLIP	thong_blip1
REMOVE_BLIP	thong_blip1B
REMOVE_BLIP	thong_blip2
REMOVE_BLIP	thong_blip2B
REMOVE_BLIP	thong_blip3
REMOVE_BLIP	thong_blip3B
REMOVE_PICKUP briefcase_tm2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BELLYUP
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
IF traid_threat_cleared_T2 = 1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1
ENDIF	
MISSION_HAS_FINISHED
RETURN


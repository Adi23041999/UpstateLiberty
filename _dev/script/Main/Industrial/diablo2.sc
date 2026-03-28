MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Deablo mission 2**************************************
// ***********************************Destroy Icream Vans*************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_diablo2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_diablo2_failed
ENDIF

GOSUB mission_cleanup_diablo2

MISSION_END

// Variables for mission

VAR_INT icecream_van1  flag_car_blip_displayed_dm2 // Vehicle for mission

VAR_INT blip1_icecream1 blip1_diablo2 blip2_diablo2	creamers_spotted_you

VAR_INT briefcase_diablo2 removed_ice_cream_blip// Counts up number of mission vans destroyed

VAR_INT ojective_creamed_guys_passed //ice_creamvan_stored_before

VAR_INT icecream_man1 icecreamvan_any creamed_guy1 creamed_guy2 creamed_guy3 creamed_guy4	
 
VAR_INT ojective_creamed_guy1_done_before ojective_creamed_guy2_done_before ojective_creamed_guy3_done_before ojective_creamed_guy4_done_before

VAR_FLOAT icecreamx icecreamy icecreamz 

VAR_INT creamed_guy1_health creamed_guy2_health creamed_guy3_health creamed_guy4_health

// ***************************************Mission Start*************************************

mission_start_diablo2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_diablo_mission = 1
SCRIPT_NAME diablo2
WAIT 0

{

SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA_OF_CHARS 890.3 -309.1 0.0 1038.1 -132.9 10.0

LOAD_CUTSCENE EL_PH2
SET_CUTSCENE_OFFSET 938.27 -229.561 4.023
				
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player


DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( DIAB2_A ) 10000 1 

WHILE cs_time < 9115
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_B ) 10000 1 

WHILE cs_time < 15149
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_C ) 10000 1 

WHILE cs_time < 18028
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_D ) 10000 1 

WHILE cs_time < 20605
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_E ) 10000 1 

WHILE cs_time < 22985
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_F ) 10000 1 

WHILE cs_time < 26130
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_G ) 10000 1 

WHILE cs_time < 30784
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_H ) 10000 1 

WHILE cs_time < 33726
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 34000
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

WAIT 500

DO_FADE 1500 FADE_IN


SET_PED_DENSITY_MULTIPLIER 1.0

ojective_creamed_guy1_done_before = 0
ojective_creamed_guy2_done_before = 0
ojective_creamed_guy3_done_before = 0
ojective_creamed_guy4_done_before = 0
ojective_creamed_guys_passed = 0
creamers_spotted_you = 0
removed_ice_cream_blip = 0

REQUEST_MODEL CAR_MRWHOOPEE
REQUEST_MODEL PED_GANG_MAFIA_A
REQUEST_MODEL PED_LI_MAN1
						  

	WHILE NOT HAS_MODEL_LOADED CAR_MRWHOOPEE
	OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_A
	OR NOT HAS_MODEL_LOADED PED_LI_MAN1
		WAIT 0
	ENDWHILE

WAIT 2000

CREATE_PICKUP briefcase PICKUP_ONCE	934.9 -69.8 8.1 briefcase_diablo2
ADD_BLIP_FOR_PICKUP	briefcase_diablo2 blip1_diablo2

PRINT ( DIAB2_1 ) 5000 1 // Pick up briefcase

WHILE NOT HAS_PICKUP_BEEN_COLLECTED briefcase_diablo2 
	WAIT 0

ENDWHILE

REMOVE_BLIP blip1_diablo2


CREATE_CAR CAR_MRWHOOPEE 1381.0 -382.0 -100.0 icecream_van1  
CREATE_CHAR_INSIDE_CAR icecream_van1 PEDTYPE_CIVMALE PED_LI_MAN1 icecream_man1
SET_CAR_DRIVING_STYLE icecream_van1 DRIVINGMODE_STOPFORCARS
ADD_BLIP_FOR_CAR icecream_van1 blip1_icecream1

PRINT_NOW ( DIAB2_2 ) 5000 1 // Find an icecream van


WHILE NOT IS_PLAYER_IN_MODEL Player CAR_MRWHOOPEE
	WAIT 0

	IF IS_CAR_DEAD icecream_van1 
		GOTO mission_diablo2_failed	
	ENDIF

ENDWHILE

REMOVE_BLIP blip1_icecream1
STORE_CAR_PLAYER_IS_IN player icecreamvan_any

	IF NOT IS_CAR_DEAD icecreamvan_any 
		ARM_CAR_WITH_BOMB icecreamvan_any CARBOMB_REMOTE
		GIVE_PLAYER_DETONATOR
		SET_CURRENT_PLAYER_WEAPON Player WEAPONTYPE_DETONATOR
	ENDIF

 PRINT_NOW ( DIAB2_3 ) 5000 1 // Park the icecream van down at atlantic quays

flag_car_blip_displayed_dm2 = TRUE
blob_flag = 1
 
WHILE NOT IS_CAR_STOPPED_IN_AREA_3D icecreamvan_any 1215.9 -1128.7 11.2 1210.4 -1123.3 14.2 blob_flag
OR NOT IS_PLAYER_IN_CAR player icecreamvan_any
OR NOT IS_ICECREAM_JINGLE_ON icecreamvan_any

	WAIT 0

		IF IS_CAR_DEAD icecreamvan_any 
			GOTO mission_diablo2_failed	
		ENDIF

		IF IS_CAR_STOPPED_IN_AREA_3D icecreamvan_any 1215.9 -1128.7 11.2 1210.4 -1123.3 14.2 FALSE
		AND IS_PLAYER_IN_CAR player icecreamvan_any
			GET_CONTROLLER_MODE controlmode
			IF controlmode = 0
				PRINT_NOW ( DIAB2_6 ) 1000 1 // Tap L3 quickly to set the Icecream jingle
			ENDIF
			IF controlmode = 1
				PRINT_NOW ( DIAB2_4 ) 1000 1 // Tap L1 quickly to set the Icecream jingle
			ENDIF
			IF controlmode = 2
				PRINT_NOW ( DIAB2_7 ) 1000 1 // Tap R1 quickly to set the Icecream jingle
			ENDIF
			IF controlmode = 3
				PRINT_NOW ( DIAB2_6 ) 1000 1 // Tap L3 quickly to set the Icecream jingle
			ENDIF
		ENDIF
		
		IF IS_PLAYER_IN_CAR player icecreamvan_any
			IF flag_car_blip_displayed_dm2 = TRUE
				ADD_BLIP_FOR_COORD 1219.7 -1137.2 -100.0 blip2_diablo2
				blob_flag = 1
				REMOVE_BLIP blip1_icecream1
				flag_car_blip_displayed_dm2 = FALSE
			ENDIF
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player icecreamvan_any
			IF flag_car_blip_displayed_dm2 = FALSE
				ADD_BLIP_FOR_CAR icecreamvan_any blip1_icecream1
				blob_flag = 0
				REMOVE_BLIP blip2_diablo2
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
				flag_car_blip_displayed_dm2 = TRUE
			ENDIF
		ENDIF
			
ENDWHILE	

CLEAR_AREA 1190.5 -1141.2 11.6 2.0 TRUE		
CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1190.5 -1141.2 11.6 creamed_guy1

CLEAR_AREA 1192.5 -1141.2 11.6 2.0 TRUE		
CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1192.5 -1141.2 11.6 creamed_guy2

CLEAR_AREA 1194.5 -1141.2 11.6 2.0 TRUE		
CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1194.5 -1141.2 11.6 creamed_guy3

CLEAR_AREA 1196.5 -1141.2 11.6 2.0 TRUE		
CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1196.5 -1141.2 11.6 creamed_guy4

GIVE_WEAPON_TO_CHAR creamed_guy1 WEAPONTYPE_UZI 160
GIVE_WEAPON_TO_CHAR creamed_guy2 WEAPONTYPE_UZI 160
GIVE_WEAPON_TO_CHAR creamed_guy3 WEAPONTYPE_UZI 160
GIVE_WEAPON_TO_CHAR creamed_guy4 WEAPONTYPE_UZI 160
SET_CHAR_PERSONALITY creamed_guy1 PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY creamed_guy2 PEDSTAT_TOUGH_GUY								   								   								   								   
SET_CHAR_PERSONALITY creamed_guy3 PEDSTAT_TOUGH_GUY								   								   								   								   
SET_CHAR_PERSONALITY creamed_guy4 PEDSTAT_TOUGH_GUY								   								   								   								   								   								   								   								   

PRINT_NOW ( DIAB2_5 ) 5000 1 // Use the remote to detonate the icecream van

WAIT 2000

CLEAR_AREA 1205.6 -1141.1 11.6 10.0 TRUE		

IF NOT IS_CHAR_DEAD	creamed_guy1
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy1 1205.6 -1141.1
ENDIF

IF NOT IS_CHAR_DEAD	creamed_guy2
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy2 1205.6 -1141.1
ENDIF

IF NOT IS_CHAR_DEAD	creamed_guy3
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy3 1205.6 -1141.1
ENDIF

IF NOT IS_CHAR_DEAD	creamed_guy4
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy4 1205.6 -1141.1
ENDIF


WHILE NOT ojective_creamed_guys_passed = 4
	WAIT 0

	IF IS_CAR_DEAD icecreamvan_any
	AND removed_ice_cream_blip = 0 
		REMOVE_BLIP blip1_icecream1
		removed_ice_cream_blip = 1		
	ENDIF

	IF IS_CHAR_DEAD creamed_guy1
	AND IS_CHAR_DEAD creamed_guy2
	AND IS_CHAR_DEAD creamed_guy3
	AND IS_CHAR_DEAD creamed_guy4
		GOTO mission_diablo2_passed
	ENDIF	

	IF IS_CHAR_DEAD creamed_guy1
	AND ojective_creamed_guy1_done_before = 0
		ojective_creamed_guys_passed ++
		ojective_creamed_guy1_done_before = 1
	ENDIF

	IF IS_CHAR_DEAD creamed_guy2
	AND ojective_creamed_guy2_done_before = 0
		ojective_creamed_guys_passed ++
		ojective_creamed_guy2_done_before = 1
	ENDIF

	IF IS_CHAR_DEAD creamed_guy3
	AND ojective_creamed_guy3_done_before = 0
		ojective_creamed_guys_passed ++
		ojective_creamed_guy3_done_before = 1
	ENDIF

	IF IS_CHAR_DEAD creamed_guy4
	AND ojective_creamed_guy4_done_before = 0
		ojective_creamed_guys_passed ++
		ojective_creamed_guy4_done_before = 1
	ENDIF

	GET_CAR_COORDINATES icecreamvan_any icecreamx icecreamy icecreamz
	
	IF IS_CHAR_OBJECTIVE_PASSED creamed_guy1
	AND ojective_creamed_guy1_done_before = 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy1 icecreamx icecreamy
		ojective_creamed_guys_passed ++
		ojective_creamed_guy1_done_before = 1
	ENDIF

	IF IS_CHAR_OBJECTIVE_PASSED creamed_guy2
	AND ojective_creamed_guy2_done_before = 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy2 icecreamx icecreamy
		ojective_creamed_guys_passed ++
		ojective_creamed_guy2_done_before = 1
	ENDIF

	IF IS_CHAR_OBJECTIVE_PASSED creamed_guy3
	AND ojective_creamed_guy3_done_before = 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy3 icecreamx icecreamy
		ojective_creamed_guys_passed ++
		ojective_creamed_guy3_done_before = 1
	ENDIF

	IF IS_CHAR_OBJECTIVE_PASSED creamed_guy4
	AND ojective_creamed_guy4_done_before = 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT creamed_guy4 icecreamx icecreamy
		ojective_creamed_guys_passed ++
		ojective_creamed_guy4_done_before = 1
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy1 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy1 Player
			SET_CHAR_THREAT_SEARCH creamed_guy1 THREAT_PLAYER1 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy2 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy2 Player
			SET_CHAR_THREAT_SEARCH creamed_guy2 THREAT_PLAYER1 
		ENDIF
	ENDIF
	   
	IF NOT IS_CHAR_DEAD creamed_guy3
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy3 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy3 Player
			SET_CHAR_THREAT_SEARCH creamed_guy3 THREAT_PLAYER1 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy4
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy4 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy4 Player 
			SET_CHAR_THREAT_SEARCH creamed_guy4 THREAT_PLAYER1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy1
		GET_CHAR_HEALTH creamed_guy1 creamed_guy1_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy2
		GET_CHAR_HEALTH creamed_guy2 creamed_guy2_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy3
		GET_CHAR_HEALTH creamed_guy3 creamed_guy3_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy4
		GET_CHAR_HEALTH creamed_guy4 creamed_guy4_health
	ENDIF

	IF creamed_guy1_health < 100
	OR creamed_guy2_health < 100
	OR creamed_guy3_health < 100
	OR creamed_guy4_health < 100
		
		IF creamers_spotted_you = 0

			IF NOT IS_CHAR_DEAD creamed_guy1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy1 Player
				SET_CHAR_THREAT_SEARCH creamed_guy1 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy2 Player
				SET_CHAR_THREAT_SEARCH creamed_guy2 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy3
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy3 Player
				SET_CHAR_THREAT_SEARCH creamed_guy3 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy4
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy4 Player
				SET_CHAR_THREAT_SEARCH creamed_guy4 THREAT_PLAYER1
			ENDIF
		
			creamers_spotted_you = 1
		ENDIF

	ENDIF

ENDWHILE


WHILE NOT IS_CHAR_DEAD creamed_guy1
OR NOT IS_CHAR_DEAD creamed_guy2
OR NOT IS_CHAR_DEAD creamed_guy3
OR NOT IS_CHAR_DEAD creamed_guy4
	WAIT 0
	
	IF IS_CAR_DEAD icecreamvan_any
	AND removed_ice_cream_blip = 0 
		REMOVE_BLIP blip1_icecream1
		removed_ice_cream_blip = 1		
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy1
		GET_CHAR_HEALTH creamed_guy1 creamed_guy1_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy2
		GET_CHAR_HEALTH creamed_guy2 creamed_guy2_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy3
		GET_CHAR_HEALTH creamed_guy3 creamed_guy3_health
	ENDIF
	IF NOT IS_CHAR_DEAD	creamed_guy4
		GET_CHAR_HEALTH creamed_guy4 creamed_guy4_health
	ENDIF

	IF creamed_guy1_health < 100
	OR creamed_guy2_health < 100
	OR creamed_guy3_health < 100
	OR creamed_guy4_health < 100
		
		IF creamers_spotted_you = 0

			IF NOT IS_CHAR_DEAD creamed_guy1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy1 Player
				SET_CHAR_THREAT_SEARCH creamed_guy1 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy2 Player
				SET_CHAR_THREAT_SEARCH creamed_guy2 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy3
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy3 Player
				SET_CHAR_THREAT_SEARCH creamed_guy3 THREAT_PLAYER1
			ENDIF

			IF NOT IS_CHAR_DEAD creamed_guy4
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy4 Player
				SET_CHAR_THREAT_SEARCH creamed_guy4 THREAT_PLAYER1
			ENDIF
		
			creamers_spotted_you = 1
		ENDIF

	ENDIF
			
	IF NOT IS_CHAR_DEAD creamed_guy1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy1 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy1 Player
			SET_CHAR_THREAT_SEARCH creamed_guy1 THREAT_PLAYER1 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy2 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy2 Player
			SET_CHAR_THREAT_SEARCH creamed_guy2 THREAT_PLAYER1 
		ENDIF
	ENDIF
	   
	IF NOT IS_CHAR_DEAD creamed_guy3
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy3 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy3 Player
			SET_CHAR_THREAT_SEARCH creamed_guy3 THREAT_PLAYER1 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD creamed_guy4
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player creamed_guy4 8.0 8.0 2.0 FALSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT creamed_guy4 Player 
			SET_CHAR_THREAT_SEARCH creamed_guy4 THREAT_PLAYER1
		ENDIF
	ENDIF

ENDWHILE

GOTO mission_diablo2_passed
}

 // Mission Diablo2 failed

mission_diablo2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission Diablo2 passed

mission_diablo2_passed:

flag_diablo_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 6000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 8000
REGISTER_MISSION_PASSED	DIAB2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT diablo_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_diablo2:

flag_player_on_mission = 0
flag_player_on_diablo_mission = 0
REMOVE_BLIP blip1_icecream1
REMOVE_BLIP blip1_diablo2
REMOVE_BLIP blip2_diablo2
REMOVE_PICKUP briefcase_diablo2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MRWHOOPEE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_LI_MAN1
SET_PLAYER_AMMO Player WEAPONTYPE_DETONATOR 0
MISSION_HAS_FINISHED
RETURN

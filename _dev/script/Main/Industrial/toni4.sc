MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 4****************************************
// ********************************Kill the Triad Warlords************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_toni4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_toni4_failed
ENDIF

GOSUB mission_cleanup_toni4

MISSION_END

// Variables for mission

VAR_INT blip1_tm4 blip2_tm4 blip3_tm4 triad1_can_leg_it triad2_can_leg_it triad3_can_leg_it
 
VAR_INT	triad_head1 triad_head2 triad_head3 warlords_dead 

VAR_INT triad_grunt1 triad_grunt1B triad_grunt2 triad_grunt2B triad_grunt3 triad_grunt3B

VAR_INT grunts1_been_created_before grunts2_been_created_before grunts3_been_created_before 

VAR_INT mafia_goon1 mafia_goon2	been_in_fish_factory clear_triads_threats

VAR_INT grabbed_peds_before	Fishbastards audio_played_tm4

VAR_INT char_already_dead1 char_already_dead2 char_already_dead3

VAR_INT pay_back_for_traids1 pay_back_for_traids2 pay_back_for_traids3

// ***************************************Mission Start*************************************

mission_start_toni4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_toni_mission = 1
SCRIPT_NAME toni4
WAIT 0

grunts1_been_created_before = 0
grunts2_been_created_before = 0
grunts3_been_created_before = 0
grabbed_peds_before = 0
been_in_fish_factory = 0 
audio_played_tm4 = 0
triad1_can_leg_it = 0
triad1_can_leg_it = 0
triad1_can_leg_it = 0
pay_back_for_traids1 = 0
pay_back_for_traids2 = 0
pay_back_for_traids3 = 0

{

REQUEST_MODEL PED_GANG_MAFIA_A
REQUEST_MODEL PED_GANG_MAFIA_B
REQUEST_MODEL ind_newrizzos
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2	NOTE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_A
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
OR NOT HAS_MODEL_LOADED ind_newrizzos
	WAIT 0

ENDWHILE

CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B 1216.4 -309.9 -100.0 mafia_goon1
CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1215.9 -311.2 29.0 mafia_goon2

	IF NOT IS_CHAR_DEAD mafia_goon1
	AND NOT IS_CHAR_DEAD mafia_goon2

		GIVE_WEAPON_TO_CHAR mafia_goon1 WEAPONTYPE_UZI 300
		SET_CHAR_THREAT_SEARCH mafia_goon1 THREAT_COP
		SET_CHAR_THREAT_SEARCH mafia_goon1 THREAT_GANG_TRIAD
		SET_CHAR_RUNNING mafia_goon1 TRUE
		TURN_CHAR_TO_FACE_CHAR mafia_goon1 mafia_goon2
		SET_CHARS_CHATTING mafia_goon1 mafia_goon2 24000

		GIVE_WEAPON_TO_CHAR mafia_goon2 WEAPONTYPE_UZI 300
		SET_CHAR_THREAT_SEARCH mafia_goon2 THREAT_COP
		SET_CHAR_THREAT_SEARCH mafia_goon2 THREAT_GANG_TRIAD
		SET_CHAR_RUNNING mafia_goon2 TRUE
		TURN_CHAR_TO_FACE_CHAR mafia_goon2 mafia_goon1

	ENDIF


LOAD_CUTSCENE T4_TAT
SET_CUTSCENE_OFFSET 1218.42 -314.5 28.9

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj2 cs_note
SET_CUTSCENE_ANIM cs_note NOTE

CLEAR_AREA 1219.6 -323.0 25.6 1.0 TRUE
SET_PLAYER_COORDINATES player 1219.6 -323.0 25.6

SET_PLAYER_HEADING player 180.0

CLEAR_AREA 1216.1 -313.0 29.9 10.0 TRUE	//TONIS RESTAURANT

DO_FADE 1500 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 82
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_A ) 10000 1 // Mission brief

WHILE cs_time < 2415
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_A2 ) 10000 1 // Mission brief

WHILE cs_time < 4420
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_B ) 10000 1 // Mission brief

WHILE cs_time < 7629
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_C ) 10000 1 // Mission brief

WHILE cs_time < 11110
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_D ) 10000 1 // Mission brief

WHILE cs_time < 13283
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_E ) 10000 1 // Mission brief

WHILE cs_time < 18058
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_F ) 10000 1 // Mission brief

WHILE cs_time < 21248
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM4_G ) 10000 1 // Mission brief

WHILE cs_time < 24000
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
SET_CAMERA_IN_FRONT_OF_PLAYER

IF NOT IS_CHAR_DEAD	mafia_goon1
AND NOT IS_CHAR_DEAD mafia_goon2
	SET_CHARS_CHATTING mafia_goon1 mafia_goon2 0
ENDIF

GIVE_WEAPON_TO_PLAYER Player WEAPONTYPE_SHOTGUN 20
SET_CURRENT_PLAYER_WEAPON Player WEAPONTYPE_SHOTGUN

IF NOT IS_CHAR_DEAD	mafia_goon1
AND NOT IS_CHAR_DEAD mafia_goon2
	SET_CHAR_COORDINATES mafia_goon1 1220.2 -321.8 26.4
	SET_CHAR_COORDINATES mafia_goon2 1219.0 -321.3 26.4
ENDIF

WAIT 500

DO_FADE 1500 FADE_IN

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED ind_newrizzos

REQUEST_MODEL PED_GANG_TRIAD_A
REQUEST_MODEL PED_GANG_TRIAD_B

	WHILE NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
	OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_B
		WAIT 0
	ENDWHILE

SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1 //TEST

warlords_dead = 0
triads_spot_you = 0
clear_triads_threats = 0

IF NOT IS_CHAR_DEAD mafia_goon1
	SET_PLAYER_AS_LEADER mafia_goon1 player
ENDIF

IF NOT IS_CHAR_DEAD mafia_goon2  
	SET_PLAYER_AS_LEADER mafia_goon2 player
ENDIF
 

    SETUP_ZONE_PED_INFO LITTLEI DAY	  (15) 500 250 0 (0 0 0 0) 0
    SETUP_ZONE_PED_INFO	LITTLEI	NIGHT ( 8) 500 250 0 (0 0 0 0) 0

    SETUP_ZONE_PED_INFO CHINA DAY   (30) 350 600 0 (0 0 0 0) 0  
    SETUP_ZONE_PED_INFO CHINA NIGHT (30) 350 600 0 (0 0 0 0) 0


// START MISSION

//RESET_NUM_OF_MODELS_KILLED_BY_PLAYER

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 906.4 -541.4 14.4 triad_head1 //Fish warhouse (Chinatown)
GIVE_WEAPON_TO_CHAR triad_head1 WEAPONTYPE_UZI 80
SET_CHAR_HEADING triad_head1 109.0
ADD_BLIP_FOR_CHAR triad_head1 blip1_tm4
ADD_ARMOUR_TO_CHAR triad_head1 100
//SET_CHAR_THREAT_SEARCH triad_head1 THREAT_GANG_MAFIA
SET_CHAR_THREAT_SEARCH triad_head1 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE triad_head1 TRUE

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 968.6 -682.2 14.3 triad_head2 //Market place
GIVE_WEAPON_TO_CHAR triad_head2 WEAPONTYPE_UZI 80
ADD_BLIP_FOR_CHAR triad_head2 blip2_tm4
ADD_ARMOUR_TO_CHAR triad_head2 100
//SET_CHAR_THREAT_SEARCH triad_head2 THREAT_GANG_MAFIA
SET_CHAR_THREAT_SEARCH triad_head2 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head2 TRUE
SET_CHAR_STAY_IN_SAME_PLACE triad_head2 TRUE

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 968.3 -1136.8 15.0 triad_head3 //Fish factory
GIVE_WEAPON_TO_CHAR triad_head3 WEAPONTYPE_UZI 80
SET_CHAR_HEADING triad_head3 38.0
ADD_BLIP_FOR_CHAR triad_head3 blip3_tm4
ADD_ARMOUR_TO_CHAR triad_head3 100
//SET_CHAR_THREAT_SEARCH triad_head3 THREAT_GANG_MAFIA
SET_CHAR_THREAT_SEARCH triad_head3 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head3 TRUE
SET_CHAR_STAY_IN_SAME_PLACE triad_head3 TRUE

char_already_dead1 = 0
char_already_dead2 = 0
char_already_dead3 = 0
	
	LOAD_MISSION_AUDIO T4_A

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE
	
WHILE NOT warlords_dead = 3
	WAIT 0

		IF IS_CHAR_DEAD triad_head1 
		AND char_already_dead1 = 0
			REMOVE_BLIP blip1_tm4 
			warlords_dead ++
			char_already_dead1 = 1
		ENDIF  	   		   	 		 

		IF IS_CHAR_DEAD triad_head2 
		AND char_already_dead2 = 0 
			REMOVE_BLIP blip2_tm4
			warlords_dead ++
			char_already_dead2 = 1
		ENDIF

		IF IS_CHAR_DEAD triad_head3 
		AND char_already_dead3 = 0
			REMOVE_BLIP blip3_tm4 
			warlords_dead ++
			char_already_dead3 = 1
		ENDIF

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

					triads_spot_you = 1
				ENDIF
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_ZONE player CHINA
		AND audio_played_tm4 = 0
			PLAY_MISSION_AUDIO
			audio_played_tm4 = 1
   	 	ENDIF

		IF grunts1_been_created_before = 0
			IF NOT IS_CHAR_DEAD triad_head1
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head1 80.0 80.0 FALSE 

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 907.4 -542.4 14.4 triad_grunt1
					SET_CHAR_HEADING triad_grunt1 180.0 
					GIVE_WEAPON_TO_CHAR triad_grunt1 WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt1 triad_head1
					SET_CHAR_THREAT_SEARCH triad_grunt1 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 907.4 -542.4 14.4 triad_grunt1B
					SET_CHAR_HEADING triad_grunt1B 160.0 
					GIVE_WEAPON_TO_CHAR triad_grunt1B WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt1B triad_head1
					SET_CHAR_THREAT_SEARCH triad_grunt1B THREAT_PLAYER1

					SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head1 FALSE
					grunts1_been_created_before = 1
					
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	triad_head1
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head1 30.0 30.0 FALSE
			AND triad1_can_leg_it = 0
				SET_CHAR_STAY_IN_SAME_PLACE triad_head1 FALSE
				triad1_can_leg_it = 1
			ENDIF
		ENDIF

		IF grunts2_been_created_before = 0
			IF NOT IS_CHAR_DEAD triad_head2
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head2 80.0 80.0 FALSE
			
					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 965.6 -680.2 14.3 triad_grunt2 
					GIVE_WEAPON_TO_CHAR triad_grunt2 WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt2 triad_head2
					SET_CHAR_THREAT_SEARCH triad_grunt2 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 965.5 -683.0 14.3 triad_grunt2B 
					GIVE_WEAPON_TO_CHAR triad_grunt2B WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt2B triad_head2
					SET_CHAR_THREAT_SEARCH triad_grunt2B THREAT_PLAYER1

					SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head2 FALSE
					grunts2_been_created_before	= 1

				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	triad_head2
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head2 30.0 30.0 FALSE
			AND triad2_can_leg_it = 0
				SET_CHAR_STAY_IN_SAME_PLACE triad_head2 FALSE
				triad2_can_leg_it = 1
			ENDIF
		ENDIF

		IF grunts3_been_created_before = 0
			IF NOT IS_CHAR_DEAD triad_head3
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head3 80.0 80.0 FALSE
				
 					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 967.1 -1134.0 15.0 triad_grunt3 
					GIVE_WEAPON_TO_CHAR triad_grunt3 WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt3 triad_head3
					SET_CHAR_THREAT_SEARCH triad_grunt3 THREAT_PLAYER1
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head3 FALSE

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 966.1 -1129.0 15.0 triad_grunt3B 
					GIVE_WEAPON_TO_CHAR triad_grunt3B WEAPONTYPE_UZI 80
					SET_CHAR_AS_LEADER triad_grunt3B triad_head3
					SET_CHAR_THREAT_SEARCH triad_grunt3B THREAT_PLAYER1

					SET_CHAR_ONLY_DAMAGED_BY_PLAYER triad_head3 FALSE
					grunts3_been_created_before = 1

				ENDIF
			ENDIF
		ENDIF
						
		IF grunts1_been_created_before = 1
		AND pay_back_for_traids1 = 0
			IF IS_CHAR_DEAD	triad_grunt1
			OR IS_CHAR_DEAD triad_grunt1B
			OR IS_CHAR_DEAD triad_head1

				IF NOT IS_CHAR_DEAD triad_grunt1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt1 Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_grunt1B
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt1B Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_head1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_head1 Player		
				ENDIF

				pay_back_for_traids1 = 1
			ENDIF
		ENDIF
		 
		IF grunts2_been_created_before = 1
		AND pay_back_for_traids2 = 0
			IF IS_CHAR_DEAD	triad_grunt2
			OR IS_CHAR_DEAD triad_grunt2B
			OR IS_CHAR_DEAD triad_head2

				IF NOT IS_CHAR_DEAD triad_grunt2
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt2 Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_grunt2B
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt2B Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_head2
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_head2 Player		
				ENDIF

				pay_back_for_traids2 = 1
			ENDIF
		ENDIF

		IF grunts3_been_created_before = 1
		AND pay_back_for_traids3 = 0
			IF IS_CHAR_DEAD	triad_grunt3
			OR IS_CHAR_DEAD triad_grunt3B
			OR IS_CHAR_DEAD triad_head3

				IF NOT IS_CHAR_DEAD triad_grunt3
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt3 Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_grunt3B
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_grunt3B Player		
				ENDIF
				IF NOT IS_CHAR_DEAD triad_head3
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad_head3 Player		
				ENDIF

				pay_back_for_traids3 = 1
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	triad_head3
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player triad_head3 30.0 30.0 FALSE
			AND triad3_can_leg_it = 0
				SET_CHAR_STAY_IN_SAME_PLACE triad_head3 FALSE
				triad3_can_leg_it = 1
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD mafia_goon1
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player mafia_goon1 120.0 120.0 FALSE
		   		DELETE_CHAR mafia_goon1
		   	ELSE
		   		IF NOT IS_CHAR_IN_PLAYERS_GROUP mafia_goon1 Player
					SET_PLAYER_AS_LEADER mafia_goon1 player
				ENDIF
		   	ENDIF	
		ENDIF

		IF NOT IS_CHAR_DEAD mafia_goon2
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player mafia_goon2 120.0 120.0 FALSE
		   		DELETE_CHAR mafia_goon2
		   	ELSE
		   		IF NOT IS_CHAR_IN_PLAYERS_GROUP mafia_goon2 Player
					SET_PLAYER_AS_LEADER mafia_goon2 player
				ENDIF
		   	ENDIF	
		ENDIF
	
		IF IS_PLAYER_IN_AREA_3D player 1025.2 -1108.4 12.0 1009.2 -1098.4 16.0 FALSE
			IF NOT IS_PLAYER_IN_MODEL player CAR_BELLYUP
			AND NOT IS_PLAYER_IN_MODEL player CAR_TRASHMASTER
				IF IS_PLAYER_IN_AREA_3D player 1015.6 -1100.5 12.0 1009.2 -1108.1 16.0 FALSE
				AND been_in_fish_factory = 0
					been_in_fish_factory = 1
				ENDIF

				IF been_in_fish_factory = 0	
					PRINT_NOW ( TM4_GAT ) 5000 1 // Need Belly-up
				ENDIF	
			ENDIF 
		ENDIF

ENDWHILE

}

GOTO mission_toni4_passed
 

 // Mission toni4 failed

mission_toni4_failed:

    SETUP_ZONE_PED_INFO CHINA DAY   (20) 0 300 0 (0 0 0 0) 20 //China town 
    SETUP_ZONE_PED_INFO CHINA NIGHT (10) 0 400 0 (0 0 0 0) 10 

RETURN

   

// mission toni4 passed

mission_toni4_passed:

flag_toni_mission4_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 30000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 30000
REGISTER_MISSION_PASSED TM4
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT toni_mission5_loop
 	SETUP_ZONE_PED_INFO CHINA DAY   (20) 0 200 0 (0 0 0 0) 20 //China town 
    SETUP_ZONE_PED_INFO CHINA NIGHT (10) 0 300 0 (0 0 0 0) 10
RETURN
		


// mission cleanup

mission_cleanup_toni4:

flag_player_on_mission = 0
flag_player_on_toni_mission = 0
REMOVE_BLIP blip1_tm4
REMOVE_BLIP blip2_tm4
REMOVE_BLIP blip3_tm4
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
//UNLOAD_SPECIAL_CHARACTER 1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_TRIAD THREAT_PLAYER1 //TEST
SETUP_ZONE_PED_INFO LITTLEI DAY	  (17) 300 0 0 (0 0 0 0) 20	//St Marks
SETUP_ZONE_PED_INFO	LITTLEI	NIGHT (11) 400 0 0 (0 0 0 0) 10
MISSION_HAS_FINISHED
RETURN



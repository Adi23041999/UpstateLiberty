MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// *************************************Hood Mission 5****************************************
// ***********************************Baseball Bat Fight**************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME hood5

// Mission start stuff

GOSUB mission_start_hood5

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_hood5_failed
	ENDIF

GOSUB mission_cleanup_hood5

MISSION_END


// Variables for mission

VAR_INT baddie1_hm5

VAR_INT baddie2_hm5

VAR_INT baddie3_hm5

VAR_INT baddie4_hm5

VAR_INT baddie5_hm5

VAR_INT baddie6_hm5

VAR_INT baddie7_hm5

VAR_INT baddie8_hm5

VAR_INT baddie9_hm5

VAR_INT radar_blip_ped1_hm5  // Radar blip for baddie 1

VAR_INT radar_blip_ped2_hm5  // Radar blip for baddie 2

VAR_INT radar_blip_ped3_hm5  // Radar blip for baddie 3

VAR_INT radar_blip_ped4_hm5  // Radar blip for baddie 4

VAR_INT radar_blip_ped5_hm5  // Radar blip for baddie 5

VAR_INT radar_blip_ped6_hm5  // Radar blip for baddie 6

VAR_INT radar_blip_ped7_hm5  // Radar blip for baddie 7

VAR_INT radar_blip_ped8_hm5  // Radar blip for baddie 8

VAR_INT radar_blip_ped9_hm5  // Radar blip for baddie 9

VAR_INT flag_baddie1_dead_hm5

VAR_INT flag_baddie2_dead_hm5

VAR_INT flag_baddie3_dead_hm5

VAR_INT flag_baddie4_dead_hm5

VAR_INT flag_baddie5_dead_hm5

VAR_INT flag_baddie6_dead_hm5

VAR_INT flag_baddie7_dead_hm5

VAR_INT flag_baddie8_dead_hm5

VAR_INT flag_baddie9_dead_hm5

VAR_INT counter_no_of_baddies_dead_hm5

VAR_INT radar_blip_goodie_hm5

VAR_INT goodie_hm5

VAR_INT bat_hm5

VAR_INT flag_players_buddy_normal

VAR_INT flag_goodie_hm5_dead_hm5

VAR_INT car_hm5

VAR_INT flag_goodie_message_hm5

VAR_INT flag_bat_created_hm5

VAR_INT flag_bat_collected_hm5

VAR_INT flag_player_in_area_hm5

VAR_INT flag_baddie1_mad_hm5

VAR_INT flag_baddie2_mad_hm5

VAR_INT flag_baddie3_mad_hm5

VAR_INT flag_baddie4_mad_hm5

VAR_INT flag_baddie5_mad_hm5

VAR_INT flag_baddie6_mad_hm5

VAR_INT flag_baddie7_mad_hm5

VAR_INT flag_baddie8_mad_hm5

VAR_INT flag_baddie9_mad_hm5

	
// ***************************************Mission Start*************************************


mission_start_hood5:

flag_player_on_mission = 1

flag_player_on_hood_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

flag_baddie1_dead_hm5 = 0

flag_baddie2_dead_hm5 = 0

flag_baddie3_dead_hm5 = 0

flag_baddie4_dead_hm5 = 0

flag_baddie5_dead_hm5 = 0

flag_baddie6_dead_hm5 = 0

flag_baddie7_dead_hm5 = 0

flag_baddie8_dead_hm5 = 0

flag_baddie9_dead_hm5 = 0

counter_no_of_baddies_dead_hm5 = 0

flag_players_buddy_normal = 0

flag_goodie_hm5_dead_hm5 = 0

flag_goodie_message_hm5 = 0

flag_bat_created_hm5 = 0

flag_bat_collected_hm5 = 0

flag_player_in_area_hm5 = 0

flag_baddie1_mad_hm5 = 0

flag_baddie2_mad_hm5 = 0

flag_baddie3_mad_hm5 = 0

flag_baddie4_mad_hm5 = 0

flag_baddie5_mad_hm5 = 0

flag_baddie6_mad_hm5 = 0

flag_baddie7_mad_hm5 = 0

flag_baddie8_mad_hm5 = 0

flag_baddie9_mad_hm5 = 0

{

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_hood5_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( HM_5 ) 15000 2 //"RUMBLE BLUES"

SWITCH_STREAMING OFF

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH			

WHILE GET_FADING_STATUS
					  
	WAIT 0

ENDWHILE
*/

SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA_OF_CHARS -414.57 97.73 1.0 -589.29 -101.77 20.0

//LOAD_ALL_MODELS_NOW

//WHILE NOT HAS_MODEL_LOADED cut_obj1

//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE hd_ph5 
SET_CUTSCENE_OFFSET -444.714 -6.321 2.9
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player


DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2190
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( HM5_A ) 10000 1  //"Them Nines..." 

WHILE cs_time < 4403
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_B ) 10000 1  //"But they still..." 

WHILE cs_time < 6287
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_C ) 10000 1  //"They agreed to..." 

WHILE cs_time < 7888
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_D ) 10000 1 //"A gang of them..." 

WHILE cs_time < 9678
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_E ) 10000 1 //"Two of yaw" 

WHILE cs_time < 11491
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_F ) 10000 1  //"I'd join you..." 

WHILE cs_time < 12974
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_G ) 10000 1  //"I ain't due my..."

WHILE cs_time < 14952
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_H ) 10000 1 //"Y'kmow what..."

WHILE cs_time < 16068
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_I ) 10000 1 //"Go and meet..."

WHILE cs_time < 17531
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM5_J ) 10000 1 //"He'll show..."

WHILE cs_time < 19234
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( HM5_J )

WHILE cs_time < 20166
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

//SWITCH_STREAMING ON

WAIT 500

DO_FADE 1500 FADE_IN

//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

SET_PED_DENSITY_MULTIPLIER 1.0

// *****************************************END OF CUTSCENE**********************************


REQUEST_MODEL PED_GANG_HOOD_A

REQUEST_MODEL PED_GANG_HOOD_B

WHILE NOT HAS_MODEL_LOADED PED_GANG_HOOD_A
OR NOT HAS_MODEL_LOADED PED_GANG_HOOD_B
	
	WAIT 0

ENDWHILE

SWITCH_ROADS_OFF -414.997 77.799 2.5 -267.467 103.23 10.0

SWITCH_ROADS_OFF -286.387 77.799 2.5 -215.814 272.287 10.0

CREATE_PICKUP WEAPON_BAT pickup_once -637.0 -28.5 -100.0 bat_hm5

flag_bat_created_hm5 = 1

// Creates players helper ped

CREATE_CHAR PEDTYPE_CIVMALE PED_GANG_HOOD_A -640.9 -28.8 18.8 goodie_hm5

SET_CHAR_HEADING goodie_hm5 180.0

GIVE_WEAPON_TO_CHAR goodie_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR goodie_hm5 radar_blip_goodie_hm5

CLEAR_CHAR_THREAT_SEARCH goodie_hm5

WHILE NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player goodie_hm5 8.0 8.0 FALSE

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF
	
ENDWHILE

TURN_CHAR_TO_FACE_PLAYER goodie_hm5 player
SET_PLAYER_AS_LEADER goodie_hm5 player
REMOVE_BLIP radar_blip_goodie_hm5

LOAD_MISSION_AUDIO H5_A

WHILE NOT HAS_MISSION_AUDIO_LOADED
	
	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF 
		
	IF NOT IS_CHAR_IN_PLAYERS_GROUP goodie_hm5 player
	AND flag_goodie_message_hm5 = 0
		PRINT_NOW ( HEY9 ) 5000 1 //"You have not got the information from the contact go back and get it."
		ADD_BLIP_FOR_CHAR goodie_hm5 radar_blip_goodie_hm5
		flag_goodie_message_hm5 = 1
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player goodie_hm5 8.0 8.0 FALSE
	AND flag_goodie_message_hm5 = 1
		SET_PLAYER_AS_LEADER goodie_hm5 player
		REMOVE_BLIP radar_blip_goodie_hm5
		flag_goodie_message_hm5 = 0
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_goodie_hm5

PLAY_MISSION_AUDIO

PRINT_NOW ( HM5_1 ) 7000 1 //"Yo, Ice setyou was comin'. There are rules, bats only, no guns, no cars

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( HM5_1 )

LOAD_MISSION_AUDIO H5_B

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO

PRINT ( HM5_5 ) 7000 1 //"This is a battle for respect, you cool?"  //Change to print now when audio is there

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( HM5_5 )

LOAD_MISSION_AUDIO H5_C

WHILE NOT HAS_MISSION_AUDIO_LOADED

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO

PRINT ( HM5_6 ) 7000 1 //"Lets go crack some blue skulls ( should be purple )"  //Change to print now when audio is there

WHILE NOT HAS_MISSION_AUDIO_FINISHED

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		PRINT_NOW ( HM5_4 ) 5000 1 //"Your contact is dead!"
		GOTO mission_hood5_failed
		flag_goodie_hm5_dead_hm5 = 1	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( HM5_6 )

// Creates baddie1

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -237.0 315.5 -100.0 baddie1_hm5

SET_CHAR_HEALTH baddie1_hm5 250

SET_CHAR_PERSONALITY baddie1_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie1_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie1_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie1_hm5 radar_blip_ped1_hm5

SET_CHAR_HEED_THREATS baddie1_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie1_hm5 -232.0 253.0 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie1_hm5 TRUE

// Creates baddie2

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -234.1 315.5 -100.0 baddie2_hm5

SET_CHAR_HEALTH baddie2_hm5 250

SET_CHAR_PERSONALITY baddie2_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie2_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie2_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie2_hm5 radar_blip_ped2_hm5

SET_CHAR_HEED_THREATS baddie2_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie2_hm5 -232.0 253.0 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie2_hm5 TRUE

// Creates baddie3

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -229.3 315.5 -100.0 baddie3_hm5

SET_CHAR_HEALTH baddie3_hm5 250

SET_CHAR_PERSONALITY baddie3_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie3_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie3_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie3_hm5 radar_blip_ped3_hm5

SET_CHAR_HEED_THREATS baddie3_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie3_hm5 -232.0 253.0 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie3_hm5 TRUE

// Creates baddie4

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -222.5 298.4 -100.0 baddie4_hm5  //281.5

SET_CHAR_HEALTH baddie4_hm5 250

SET_CHAR_PERSONALITY baddie4_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie4_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie4_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie4_hm5 radar_blip_ped4_hm5

SET_CHAR_HEED_THREATS baddie4_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie4_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie4_hm5 TRUE

// Creates baddie5

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -222.5 287.6 -100.0 baddie5_hm5

SET_CHAR_HEALTH baddie5_hm5 250

SET_CHAR_PERSONALITY baddie5_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie5_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie5_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie5_hm5 radar_blip_ped5_hm5

SET_CHAR_HEED_THREATS baddie5_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie5_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie5_hm5 TRUE

// Creates baddie6

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -222.5 275.9 -100.0 baddie6_hm5

SET_CHAR_HEALTH baddie6_hm5 250

SET_CHAR_PERSONALITY baddie6_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie6_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie6_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie6_hm5 radar_blip_ped6_hm5

SET_CHAR_HEED_THREATS baddie6_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie6_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie6_hm5 TRUE

// Creates baddie7

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -239.8 287.6 -100.0 baddie7_hm5

SET_CHAR_HEALTH baddie7_hm5 250

SET_CHAR_PERSONALITY baddie7_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie7_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie7_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie7_hm5 radar_blip_ped7_hm5

SET_CHAR_HEED_THREATS baddie7_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie7_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie7_hm5 TRUE

// Creates baddie8

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -239.8 298.4 -100.0 baddie8_hm5

SET_CHAR_HEALTH baddie8_hm5 250

SET_CHAR_PERSONALITY baddie8_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie8_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie8_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie8_hm5 radar_blip_ped8_hm5

SET_CHAR_HEED_THREATS baddie8_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie8_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie8_hm5 TRUE

// Creates baddie9

CREATE_CHAR PEDTYPE_GANG_HOOD PED_GANG_HOOD_B -239.8 275.9 -100.0 baddie9_hm5

SET_CHAR_HEALTH baddie9_hm5 250

SET_CHAR_PERSONALITY baddie9_hm5 PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH baddie9_hm5 THREAT_PLAYER1

GIVE_WEAPON_TO_CHAR baddie9_hm5 WEAPONTYPE_BASEBALLBAT 1

ADD_BLIP_FOR_CHAR baddie9_hm5 radar_blip_ped9_hm5

SET_CHAR_HEED_THREATS baddie9_hm5 TRUE

TURN_CHAR_TO_FACE_COORD baddie9_hm5 -226.1 280.8 -100.0

SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie9_hm5 TRUE

// waiting for all the guys to be dead

WHILE NOT counter_no_of_baddies_dead_hm5 = 9

	WAIT 0

	IF IS_CHAR_DEAD goodie_hm5
		flag_goodie_hm5_dead_hm5 = 1
	ENDIF

IF IS_PLAYER_IN_AREA_3D player -247.3 333.9 2.0 -209.5 250.2 15.0 FALSE

	flag_player_in_area_hm5 = 1
   
	IF flag_goodie_hm5_dead_hm5 = 0
	
		IF NOT IS_CHAR_IN_ANY_CAR goodie_hm5  

 			IF flag_players_buddy_normal = 0
				LEAVE_GROUP goodie_hm5
				SET_CHAR_THREAT_SEARCH goodie_hm5 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY goodie_hm5 PEDSTAT_TOUGH_GUY
				flag_players_buddy_normal = 1
			ENDIF

		ENDIF

	ENDIF
	
ENDIF

IF flag_player_in_area_hm5 = 1

	IF flag_baddie1_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie1_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie1_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie1_hm5 player
			flag_baddie1_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie2_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie2_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie2_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie2_hm5 player
			flag_baddie2_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie3_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie3_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie3_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie3_hm5 player
			flag_baddie3_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie4_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie4_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie4_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie4_hm5 player
			flag_baddie4_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie5_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie5_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie5_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie5_hm5 player
			flag_baddie5_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie6_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie6_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie6_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie6_hm5 player
			flag_baddie6_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie7_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie7_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie7_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie7_hm5 player
			flag_baddie7_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie8_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie8_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie8_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie8_hm5 player
			flag_baddie8_mad_hm5 = 1
		ENDIF

	ENDIF

	IF flag_baddie9_mad_hm5 = 0

		IF NOT IS_CHAR_DEAD baddie9_hm5
			TURN_CHAR_TO_FACE_PLAYER baddie9_hm5 player
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT baddie9_hm5 player
			flag_baddie9_mad_hm5 = 1
		ENDIF

	ENDIF
	
ENDIF 	

// Checks for baddie1

IF flag_baddie1_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie1_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie1_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped1_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie1_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie2

IF flag_baddie2_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie2_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie2_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped2_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie2_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie3

IF flag_baddie3_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie3_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie3_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped3_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie3_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie4

IF flag_baddie4_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie4_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie4_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped4_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie4_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie5

IF flag_baddie5_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie5_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie5_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped5_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie5_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie6

IF flag_baddie6_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie6_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie6_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped6_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie6_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF


// Checks for baddie7

IF flag_baddie7_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie7_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie7_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped7_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie7_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie8

IF flag_baddie8_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie8_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie8_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped8_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie8_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

// Checks for baddie9

IF flag_baddie9_dead_hm5 = 0

	IF IS_CHAR_DEAD baddie9_hm5

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON baddie9_hm5 WEAPONTYPE_BASEBALLBAT
			REMOVE_BLIP radar_blip_ped9_hm5
			++ counter_no_of_baddies_dead_hm5
			flag_baddie9_dead_hm5 = 1
		ELSE
			PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
			GOTO mission_hood5_failed
		ENDIF

	ENDIF

ENDIF

	IF IS_PLAYER_SHOOTING_IN_AREA player -327.0 72.0 -134.0 350.0 FALSE
 
		IF flag_baddie1_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie1_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie2_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie2_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie3_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie3_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie4_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie4_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie5_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie5_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie6_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie6_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie7_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie7_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie8_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie8_hm5 WEAPONTYPE_UZI 30000 
		ENDIF

		IF flag_baddie9_dead_hm5 = 0
			GIVE_WEAPON_TO_CHAR baddie9_hm5 WEAPONTYPE_UZI 30000 
		ENDIF
				 
		PRINT_NOW ( HM5_3 ) 7000 1 //You were told to use a baseball bat only!"
		GOTO mission_hood5_failed
	
	ENDIF

	IF flag_bat_created_hm5 = 1

		IF flag_bat_collected_hm5 = 0
		
			IF HAS_PICKUP_BEEN_COLLECTED bat_hm5
				flag_bat_collected_hm5 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

} 

GOTO mission_hood5_passed

 

// Mission hood5 failed

mission_hood5_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_SUBURBAN 
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_SUBURBAN
ENDIF

RETURN


   

// mission hood5 passed

mission_hood5_passed:

flag_hood_mission5_passed = 1
REGISTER_MISSION_PASSED ( HM_5 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
REMOVE_BLIP hood_contact_blip
SET_GANG_PED_MODEL_PREFERENCE GANG_HOOD 0
START_NEW_SCRIPT hood_mission3_loop   
RETURN
		


// mission cleanup

mission_cleanup_hood5:

flag_player_on_mission = 0
flag_player_on_hood_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_HOOD_A
REMOVE_BLIP radar_blip_goodie_hm5
REMOVE_BLIP radar_blip_ped1_hm5
REMOVE_BLIP radar_blip_ped2_hm5
REMOVE_BLIP radar_blip_ped3_hm5
REMOVE_BLIP radar_blip_ped4_hm5
REMOVE_BLIP radar_blip_ped5_hm5
REMOVE_BLIP radar_blip_ped6_hm5
REMOVE_BLIP radar_blip_ped7_hm5
REMOVE_BLIP radar_blip_ped8_hm5
REMOVE_BLIP radar_blip_ped9_hm5

IF flag_bat_created_hm5 = 1

	IF flag_bat_collected_hm5 = 0
		REMOVE_PICKUP bat_hm5
	ENDIF

ENDIF

IF flag_baddie1_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie1_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie1_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie2_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie2_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie2_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie3_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie3_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie3_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie4_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie4_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie4_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie5_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie5_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie5_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie6_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie6_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie6_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie7_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie7_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie7_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie8_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie8_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie8_hm5 FALSE
	ENDIF

ENDIF

IF flag_baddie9_dead_hm5 = 0

	IF NOT IS_CHAR_DEAD baddie9_hm5
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER baddie9_hm5 FALSE
	ENDIF

ENDIF

MISSION_HAS_FINISHED
RETURN
		

  
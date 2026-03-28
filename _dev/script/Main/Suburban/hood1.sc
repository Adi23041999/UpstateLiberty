MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// *************************************Hood Mission 1****************************************
// ****************************************Drive By*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME hood1

// Mission start stuff

GOSUB mission_start_hood1
      
GOSUB mission_cleanup_hood1

MISSION_END


// Variables for mission

VAR_INT frenzy_state

VAR_INT radar_blip_coord_hm1

VAR_INT flag_blip_on_hm1
	
// ***************************************Mission Start*************************************


mission_start_hood1:

flag_player_on_mission = 1

flag_player_on_hood_mission = 1

flag_blip_on_hm1 = 0

REGISTER_MISSION_GIVEN

WAIT 0

{

SET_DEATHARREST_STATE OFF

SETUP_ZONE_PED_INFO PROJECT DAY   (30) (0 0 0 0) 0 0 800 0 //WICHITA GARDENS 
SETUP_ZONE_PED_INFO PROJECT NIGHT (30) (0 0 0 0) 0 0 800 0

// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_hood1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

PRINT_BIG ( HM_1 ) 15000 2 //"Uzi Driver"

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

LOAD_CUTSCENE hd_ph1 
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

WHILE cs_time < 2096
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( HM1_A ) 10000 1 //"Yo this is D-ice of the Red Jacks!" 

WHILE cs_time < 4887
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_B ) 10000 1  //"I got a problem that's messin' my rep." 

WHILE cs_time < 7511
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_C ) 10000 1  //"These yound punks..." 

WHILE cs_time < 12668
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_D ) 10000 1 //"Nine is their tag...." 

WHILE cs_time < 16765
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_G ) 10000 1 //"is another day the Jacks..." 

WHILE cs_time < 19026
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_E ) 10000 1  //I want you to show..." 

WHILE cs_time < 23017
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_H ) 10000 1  //"Mow those nines down." 

WHILE cs_time < 25018
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HM1_F ) 10000 1  ///"Watch your back..."

WHILE cs_time < 28865
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_THIS_PRINT ( HM1_F ) 

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

CLEAR_CUTSCENE

//SWITCH_STREAMING ON

WAIT 500

DO_FADE 1500 FADE_IN

//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1

SET_PED_DENSITY_MULTIPLIER 1.0


// ****************************************END OF CUTSCENE**********************************

IF NOT IS_PLAYER_PLAYING player
	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
	GOTO mission_hood1_failed
ENDIF

WHILE GET_FADING_STATUS

	WAIT 0

	IF NOT IS_PLAYER_PLAYING player
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_hood1_failed
	ENDIF

ENDWHILE

// waiting for the player to get to the zone

PRINT_NOW ( HM1_2 ) 5000 1 //"Get a vehicle!"

IF flag_done_drive_by_help = 0

	GET_CONTROLLER_MODE	controlmode

	IF controlmode = 0
		PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
		flag_done_drive_by_help = 1
	ENDIF

	IF controlmode = 1
		PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
		flag_done_drive_by_help = 1
	ENDIF

	IF controlmode = 2
		PRINT_HELP ( DRIVE_A ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~| button~w~ to fire."
		flag_done_drive_by_help = 1
	ENDIF

	IF controlmode = 3
		PRINT_HELP ( DRIVE_B ) //"Have an Uzi selected when entering a vehicle then look left or right and press the ~h~R1 button~w~ to fire."
		flag_done_drive_by_help = 1
	ENDIF

ENDIF


WHILE NOT IS_PLAYER_IN_ANY_CAR player

	WAIT 0

	IF NOT IS_PLAYER_PLAYING player
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_hood1_failed
	ENDIF

ENDWHILE

PRINT_NOW ( HM1_3 ) 5000 1 //"Get to the correct zone!"
ADD_BLIP_FOR_COORD -442.3 -6.8 -100.0 radar_blip_coord_hm1
flag_blip_on_hm1 = 1

WHILE NOT IS_PLAYER_IN_ZONE	player PROJECT
AND NOT IS_PLAYER_IN_ANY_CAR player

	WAIT 0

	IF NOT IS_PLAYER_PLAYING player
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_hood1_failed
	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_coord_hm1
flag_blip_on_hm1 = 0

START_KILL_FRENZY ( HM1_1 ) WEAPONTYPE_UZI_DRIVEBY 150000 20 PED_GANG_HOOD_B -1 -1 -1 FALSE

READ_KILL_FRENZY_STATUS frenzy_state

WHILE frenzy_state = 1

	WAIT 0

	READ_KILL_FRENZY_STATUS frenzy_state

	IF NOT IS_PLAYER_PLAYING player
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		GOTO mission_hood1_failed
	ELSE

		IF NOT IS_PLAYER_IN_ZONE player PROJECT

			IF flag_blip_on_hm1 = 0
				ADD_BLIP_FOR_COORD -442.3 -6.8 -100.0 radar_blip_coord_hm1
				PRINT_NOW ( HM1_3 ) 5000 1 //"Get to the correct zone!"
				flag_blip_on_hm1 = 1
			ENDIF

		ELSE
			
			IF flag_blip_on_hm1 = 1
				REMOVE_BLIP radar_blip_coord_hm1
				flag_blip_on_hm1 = 0
			ENDIF

		ENDIF

	ENDIF
			
ENDWHILE

READ_KILL_FRENZY_STATUS frenzy_state



IF frenzy_state = 2
	GOTO mission_hood1_passed
ENDIF

IF frenzy_state = 3
	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
	GOTO mission_hood1_failed
ENDIF

} 

// Mission hood1 failed

mission_hood1_failed:

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_SUBURBAN 
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_SUBURBAN
ENDIF

RETURN


   

// mission hood1 passed

mission_hood1_passed:

flag_hood_mission1_passed = 1
REGISTER_MISSION_PASSED ( HM_1 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
START_NEW_SCRIPT hood_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_hood1:

flag_player_on_mission = 0
flag_player_on_hood_mission = 0
REMOVE_BLIP radar_blip_coord_hm1
SETUP_ZONE_PED_INFO PROJECT DAY   (13) (0 0 0 0) 0 0 300 20 //WICHITA GARDENS 
SETUP_ZONE_PED_INFO PROJECT NIGHT ( 9) (0 0 0 0) 0 0 400 10
MISSION_HAS_FINISHED
RETURN
		

  
MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// **************************************Joey Mission 4***************************************
// ***************************************pick up Toni****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

GOSUB mission_start_joey4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey4_failed
ENDIF

GOSUB mission_cleanup_joey4

MISSION_END


// Variables for mission

VAR_INT blip1_jm4 blip2_jm4 blip3_jm4 flag_car_blip_displayed_jm4 triads_ojective_passed 	

VAR_INT ojective_triad1_done_before ojective_triad2_done_before

VAR_INT Toni_abuse1_done_before	tonis_car_created_before played_tune_before

VAR_INT flag_displayed_wanted_message_jm4 flag_displayed_horn_message_jm4

VAR_INT tonis_ride is_char1_dead_jm4 is_char2_dead_jm4 is_char3_dead_jm4 is_char4_dead_jm4

VAR_INT triad1_jm4 triad2_jm4 triad3_jm4 triad4_jm4 tonis_audio_all_finished

VAR_FLOAT door1_position_jm4 door2_position_jm4 

// ***************************************Mission Start*************************************


mission_start_joey4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
SCRIPT_NAME joey4
WAIT 0

IF tonis_car_created_before = 1
	GOSUB delete_tonis_car
ENDIF

flag_displayed_wanted_message_jm4 = 0
flag_displayed_horn_message_jm4 = 0
Toni_abuse1_done_before = 0
ojective_triad1_done_before	= 0
ojective_triad2_done_before	= 0
triads_ojective_passed = 0
tonis_audio_all_finished = 0
played_tune_before = 0

SET_CAR_DENSITY_MULTIPLIER 0.0 //TURN ALL THE CARS OFF

{

LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_CHARACTER 2 tony
LOAD_SPECIAL_MODEL cut_obj1 JOEDOOR
LOAD_SPECIAL_MODEL cut_obj2 JOEYH
LOAD_SPECIAL_MODEL cut_obj3 PLAYERH
LOAD_SPECIAL_MODEL cut_obj4 TONYH
REQUEST_MODEL CAR_MAFIA
REQUEST_MODEL CAR_IDAHO
REQUEST_MODEL CAR_STALLION
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_MAFIA 
OR NOT HAS_MODEL_LOADED CAR_IDAHO
OR NOT HAS_MODEL_LOADED CAR_STALLION
	WAIT 0
ENDWHILE

CREATE_CAR CAR_MAFIA 1189.72 -864.28 14.1 tonis_ride
tonis_car_created_before = 1
SET_CAR_HEADING tonis_ride -142.0
SET_RADIO_CHANNEL 1 -1

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2	
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
	WAIT 0
ENDWHILE

//LOAD_SCENE 1190.07 -869.86 13.97

LOAD_CUTSCENE J4_ETH
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CAR CAR_IDAHO 1182.5 -857.0 14.1 cut_car2_lm3
SET_CAR_HEADING cut_car2_lm3 291.2

CREATE_CAR CAR_STALLION 1192.9 -860.8 14.0 cut_car3_lm3
SET_CAR_HEADING cut_car3_lm3 150.0

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_tony
SET_CUTSCENE_ANIM cs_tony tony

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ2 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_tony CUT_OBJ4 cs_tonyhead
SET_CUTSCENE_HEAD_ANIM cs_tonyhead tony

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ3 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj1 cs_joedoor
SET_CUTSCENE_ANIM cs_joedoor JOEDOOR

CLEAR_AREA 1195.0 -870.3 15.0 10.0 TRUE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 FALSE

//MOVE GARAGE UP
GET_OBJECT_COORDINATES joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z
GET_OBJECT_COORDINATES joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z

joeydoor2_Z = joeydoor2_Z + 3.0
joeydoor3_Z = joeydoor3_Z + 3.0

	WHILE NOT SLIDE_OBJECT joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z 0.1 0.1 100.0 FALSE
	OR NOT SLIDE_OBJECT joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z 0.1 0.1 100.0 FALSE
		WAIT 0								  

			IF IS_CAR_DEAD tonis_ride
				PRINT_NOW ( JM4_8 ) 5000 1
				GOTO mission_joey4_failed	
			ENDIF

			IF IS_CAR_UPSIDEDOWN tonis_ride
			AND IS_CAR_STOPPED tonis_ride
				PRINT_NOW ( WRECKED ) 5000 1
				GOTO mission_joey4_failed
			ENDIF

	ENDWHILE

DO_FADE 1800 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 1
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_A ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 4000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_B ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 6180
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_C ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 10230
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_D ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 13040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_E ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 15110
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_F ) 10000 1 //"Go to X, wait for Toni"

WHILE cs_time < 18080
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM4_G ) 10000 1 //"Go to X, wait for Toni"
				
WHILE cs_time < 23511
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 23833
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//DO_FADE 1000 FADE_OUT

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_PRINTS
CLEAR_CUTSCENE

IF NOT IS_CAR_DEAD tonis_ride
	CREATE_CHAR_AS_PASSENGER tonis_ride PEDTYPE_SPECIAL PED_SPECIAL2 0 toni
	CLEAR_CHAR_THREAT_SEARCH toni
	SET_CHAR_CANT_BE_DRAGGED_OUT toni TRUE
	ADD_ARMOUR_TO_CHAR toni 100
	WARP_PLAYER_INTO_CAR Player tonis_ride
ENDIF

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door1 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1192.23 -867.252 14.124 6.0 joey_door2 TRUE

CLEAR_AREA 1198.5 -871.4 15.0 10.0 TRUE
//SET_FIXED_CAMERA_POSITION 1206.0 -864.6 15.4 0.0 0.0 0.0
//POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
SET_FIXED_CAMERA_POSITION 1200.831 -869.373 15.001 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1199.887 -869.701 15.025 JUMP_CUT

WAIT 0
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player ON
SET_PLAYER_CONTROL Player OFF

//WAIT 500

//DO_FADE 1000 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_IDAHO
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

DELETE_CAR cut_car2_lm3
DELETE_CAR cut_car3_lm3
	
	LOAD_MISSION_AUDIO J4T_1
	
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

	PLAY_MISSION_AUDIO
	PRINT_NOW ( JM4_10 ) 5000 1 //"Go to X, wait for Toni"
	
//CAR DRIVING OUT OF GARAGE CUT SCENE

IF NOT IS_CAR_DEAD tonis_ride						 
	CAR_GOTO_COORDINATES_ACCURATE tonis_ride 1198.5 -871.4 -100.0
	SET_CAR_CRUISE_SPEED tonis_ride 2.0
	SET_CAR_DRIVING_STYLE tonis_ride 3
ENDIF

IF NOT IS_CHAR_DEAD toni
	CHAR_LOOK_AT_PLAYER_ALWAYS toni player
	PLAYER_LOOK_AT_CHAR_ALWAYS player toni
	//SET_ANIM_GROUP_FOR_CHAR toni ANIM_OLDFAT_PED
ENDIF

WHILE NOT LOCATE_CAR_2D tonis_ride 1198.5 -871.4 2.0 2.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD tonis_ride
		GOTO mission_joey4_failed
	ENDIF
	
	IF tonis_audio_all_finished = 0

		WHILE NOT HAS_MISSION_AUDIO_FINISHED
			WAIT 0

			IF IS_CAR_DEAD tonis_ride
			OR IS_CHAR_DEAD toni
				PRINT_NOW ( JM4_8 ) 5000 1 
				GOTO mission_joey4_failed	
			ENDIF

		ENDWHILE
		
		LOAD_MISSION_AUDIO J4T_2

		WHILE NOT HAS_MISSION_AUDIO_LOADED
			WAIT 0

			IF IS_CAR_DEAD tonis_ride
			OR IS_CHAR_DEAD toni
				PRINT_NOW ( JM4_8 ) 5000 1 
				GOTO mission_joey4_failed	
			ENDIF

		ENDWHILE

		PLAY_MISSION_AUDIO
		PRINT_NOW ( JM4_11 ) 5000 1 //"Go to X, wait for Toni"

		WHILE NOT HAS_MISSION_AUDIO_FINISHED
			WAIT 0

			IF IS_CAR_DEAD tonis_ride
			OR IS_CHAR_DEAD toni
				PRINT_NOW ( JM4_8 ) 5000 1 
				GOTO mission_joey4_failed	
			ENDIF

		ENDWHILE
	
		LOAD_MISSION_AUDIO J4T_3

		tonis_audio_all_finished = 1
	ENDIF
	

ENDWHILE

CLEAR_PRINTS

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

	ENDWHILE

	PLAY_MISSION_AUDIO
	PRINT_NOW ( JM4_12 ) 5000 1 //"Go to X, wait for Toni"

GET_OBJECT_COORDINATES joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z
GET_OBJECT_COORDINATES joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z

joeydoor2_Z = joeydoor2_Z - 3.0
joeydoor3_Z = joeydoor3_Z - 3.0

WHILE NOT SLIDE_OBJECT joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z 0.1 0.1 0.1 FALSE
OR NOT SLIDE_OBJECT joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z 0.1 0.1 0.1 FALSE
	WAIT 0
		
		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni 
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed	
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

ENDWHILE 

	WHILE NOT HAS_MISSION_AUDIO_FINISHED
		WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

	ENDWHILE

	LOAD_MISSION_AUDIO J4T_4

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

	ENDWHILE

	PLAY_MISSION_AUDIO
	PRINT_NOW ( JM4_13 ) 5000 1 //"Go to X, wait for Toni"
		
	WHILE NOT HAS_MISSION_AUDIO_FINISHED
		WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

	ENDWHILE

IF NOT IS_CHAR_DEAD toni
	STOP_CHAR_LOOKING toni
	STOP_PLAYER_LOOKING Player
ENDIF
	
CLEAR_PRINTS

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL Player On
SET_CAR_STATUS tonis_ride STATUS_PLAYER
SET_POLICE_IGNORE_PLAYER Player Off
RESTORE_CAMERA
SET_CAR_DENSITY_MULTIPLIER 1.0 // TURN ALL THE CARS BACK ON
SWITCH_CAR_GENERATOR gen_car12 0

	REQUEST_MODEL PED_GANG_TRIAD_A
	REQUEST_MODEL PED_GANG_TRIAD_B
	LOAD_MISSION_AUDIO J4_A

	WHILE NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
	OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_B
	OR NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE


SWITCH_PED_ROADS_OFF 824.9 -633.8 13.0 845.3 -693.8 18.0 
SWITCH_ROADS_OFF 824.9 -633.8 13.0 845.3 -693.8 18.0
CLEAR_AREA 843.4 -663.8 15.0 10.0 TRUE

ADD_BLIP_FOR_COORD 843.0 -660.0 -100.0 blip1_jm4
CHANGE_BLIP_DISPLAY blip1_jm4 BLIP_ONLY


	CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 850.0 -663.0 14.7 triad1_jm4
	CLEAR_CHAR_THREAT_SEARCH triad1_jm4
	SET_CHAR_PROOFS triad1_jm4 TRUE TRUE TRUE TRUE TRUE

	CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 850.0 -664.7 14.7 triad2_jm4
	CLEAR_CHAR_THREAT_SEARCH triad2_jm4
	SET_CHAR_PROOFS triad2_jm4 TRUE TRUE TRUE TRUE TRUE

	TURN_CHAR_TO_FACE_CHAR triad1_jm4 triad2_jm4
	TURN_CHAR_TO_FACE_CHAR triad2_jm4 triad1_jm4

REMOVE_BLIP blip1_jm4
flag_car_blip_displayed_jm4 = TRUE
blob_flag = 1

	IF IS_CAR_DEAD tonis_ride
		PRINT_NOW ( JM4_8 ) 5000 1
		GOTO mission_joey4_failed
	ENDIF

	WHILE NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 839.2 -667.4 14.0 842.1 -673.9 17.0 blob_flag
	OR IS_WANTED_LEVEL_GREATER Player 0
	OR NOT IS_PLAYER_IN_CAR Player tonis_ride    	

		WAIT 0

		IF IS_CAR_DEAD tonis_ride
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF
		
		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player tonis_ride
			IF flag_car_blip_displayed_jm4 = FALSE
			ADD_BLIP_FOR_CAR tonis_ride blip2_jm4
			blob_flag = 0
			REMOVE_BLIP blip1_jm4
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
			flag_car_blip_displayed_jm4 = TRUE
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_CAR player tonis_ride
			IF flag_car_blip_displayed_jm4 = TRUE
				ADD_BLIP_FOR_COORD 843.0 -660.0 -100.0 blip1_jm4
				blob_flag = 1
				REMOVE_BLIP blip2_jm4
			flag_car_blip_displayed_jm4 = FALSE
			ENDIF
		ENDIF

		IF NOT IS_CAR_HEALTH_GREATER tonis_ride 900
		AND	Toni_abuse1_done_before = 0
			PRINT_NOW ( JM4_6 ) 5000 1 //"Watch the fuckin CAR!"
			PLAY_MISSION_AUDIO
			Toni_abuse1_done_before = 1
		ENDIF	

		IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 839.2 -667.4 14.0 842.1 -673.9 17.0 FALSE

			IF IS_WANTED_LEVEL_GREATER player 0
				IF flag_displayed_wanted_message_jm4 = 0
					PRINT_NOW ( WANTED1 ) 3000 1
					flag_displayed_wanted_message_jm4 = 1
				ENDIF
			
			ENDIF
		ELSE
			IF NOT IS_PLAYER_IN_AREA_3D player 839.2 -667.4 14.0 842.1 -673.9 17.0 FALSE
				flag_displayed_wanted_message_jm4 = 0
			ENDIF
		ENDIF

	ENDWHILE

REMOVE_BLIP blip1_jm4
SET_POLICE_IGNORE_PLAYER Player ON
SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON
SET_FIXED_CAMERA_POSITION 825.604 -680.602 16.567 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 826.336 -679.921 16.539 JUMP_CUT

	LOAD_MISSION_AUDIO J4_B

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE


//TONI LANDRETTE CUT_SCENE
IF NOT IS_CHAR_DEAD	triad1_jm4
AND NOT IS_CHAR_DEAD triad2_jm4
	SET_CHARS_CHATTING triad1_jm4 triad2_jm4 999999
ENDIF

IF NOT IS_CHAR_DEAD	toni
	SET_CHAR_PROOFS toni TRUE TRUE TRUE TRUE TRUE
ENDIF

PLAY_MISSION_AUDIO
PRINT_NOW ( JM4_2 ) 5000 1 //wait here
 
CLEAR_AREA 843.4 -663.8 15.0 10.0 TRUE

WAIT 4000

	IF IS_CAR_DEAD tonis_ride
	OR IS_CHAR_DEAD toni
		PRINT_NOW ( JM4_8 ) 5000 1 
		GOTO mission_joey4_failed	
	ENDIF

GIVE_WEAPON_TO_CHAR toni WEAPONTYPE_BASEBALLBAT 0
SET_CHAR_OBJ_LEAVE_CAR toni tonis_ride

	WHILE IS_CHAR_IN_CAR toni tonis_ride
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

	ENDWHILE

//SET_FIXED_CAMERA_POSITION 840.0 -672.4 17.0 0.0 0.0 0.0
//SET_FIXED_CAMERA_POSITION 836.632 -670.922 17.843 0.0 0.0 0.0
//POINT_CAMERA_AT_CHAR toni FIXED INTERPOLATION

SET_FIXED_CAMERA_POSITION 841.312 -669.063 16.536 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 842.117 -668.501 16.343 JUMP_CUT

//TONI WALKS TO DOORS

	IF IS_CAR_DEAD tonis_ride
	OR IS_CHAR_DEAD toni
		PRINT_NOW ( JM4_8 ) 5000 1 
		GOTO mission_joey4_failed	
	ENDIF

TURN_CHAR_TO_FACE_COORD toni 843.9 -663.7 15.1

TIMERB = 0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 843.9 -663.7

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF TIMERB > 10000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 843.9 -663.7 13.9
			ENDIF
		ENDIF

	ENDWHILE


//OPEN DOORS

	WHILE NOT ROTATE_OBJECT laundrete_door1 90.0 10.0 FALSE
	OR NOT ROTATE_OBJECT laundrete_door2 90.0 10.0 FALSE
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

	ENDWHILE

//TONI WALKS IN

	IF IS_CAR_DEAD tonis_ride
	OR IS_CHAR_DEAD toni 
		PRINT_NOW ( JM4_8 ) 5000 1
		GOTO mission_joey4_failed	
	ENDIF

TIMERB = 0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 848.1 -663.4

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF TIMERB > 10000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 848.1 -663.4 13.9
			ENDIF
		ENDIF

	ENDWHILE

SET_CHAR_OBJ_WAIT_ON_FOOT toni

IF NOT IS_CHAR_DEAD triad1_jm4
AND NOT IS_CHAR_DEAD triad2_jm4
	SET_CHARS_CHATTING triad1_jm4 triad2_jm4 0
ENDIF

WAIT 0

	IF NOT IS_CHAR_DEAD triad1_jm4
	AND NOT IS_CHAR_DEAD triad2_jm4
	AND NOT IS_CHAR_DEAD toni
		TURN_CHAR_TO_FACE_CHAR triad1_jm4 toni
		TURN_CHAR_TO_FACE_CHAR triad2_jm4 toni
		CHAR_LOOK_AT_CHAR_ALWAYS triad1_jm4 toni
		CHAR_LOOK_AT_CHAR_ALWAYS triad2_jm4	toni
	ENDIF

WAIT 5000

ADD_ONE_OFF_SOUND 845.0 -663.0 14.0 sound_test_1 //Need Sound event

GET_OBJECT_HEADING laundrete_door1 door1_position_jm4
GET_OBJECT_HEADING laundrete_door2 door2_position_jm4


	IF IS_CHAR_DEAD toni 
		PRINT_NOW ( JM4_8 ) 5000 1
		GOTO mission_joey4_failed	
	ENDIF

TURN_CHAR_TO_FACE_COORD toni 843.9 -663.7 15.1

	IF NOT IS_CHAR_DEAD triad1_jm4
	OR NOT IS_CHAR_DEAD triad2_jm4
		GIVE_WEAPON_TO_CHAR triad1_jm4 WEAPONTYPE_PISTOL 100
		GIVE_WEAPON_TO_CHAR triad2_jm4 WEAPONTYPE_PISTOL 100
	ENDIF

SET_CHAR_RUNNING toni TRUE

	IF NOT IS_CHAR_DEAD triad1_jm4
	OR NOT IS_CHAR_DEAD triad2_jm4
		SET_CHAR_STAY_IN_SAME_PLACE triad1_jm4 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE triad2_jm4 TRUE
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT triad1_jm4 toni
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT triad2_jm4 toni
	ENDIF

//TONI RUNS OUT

CLEAR_AREA 843.4 -663.8 15.0 10.0 TRUE

TIMERB = 0

IF NOT IS_CHAR_DEAD triad1_jm4
AND NOT IS_CHAR_DEAD triad2_jm4
	STOP_CHAR_LOOKING triad1_jm4
	STOP_CHAR_LOOKING triad2_jm4 
ENDIF

SET_CHAR_OBJ_RUN_TO_COORD toni 843.9 -663.7

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF TIMERB > 10000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 843.9 -663.7 13.9
			ENDIF
		ENDIF

	ENDWHILE

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER toni tonis_ride
SET_FIXED_CAMERA_POSITION 836.029 -677.868 15.840 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 836.713 -677.156 15.680 JUMP_CUT

WAIT 1500

	IF NOT IS_CHAR_DEAD triad1_jm4
	AND NOT IS_CHAR_DEAD triad2_jm4
		SET_CHAR_STAY_IN_SAME_PLACE triad1_jm4 FALSE
		SET_CHAR_STAY_IN_SAME_PLACE triad2_jm4 FALSE
		SET_CHAR_OBJ_RUN_TO_COORD triad1_jm4 842.0 -663.8
		SET_CHAR_OBJ_RUN_TO_COORD triad2_jm4 843.5 -663.8
	ENDIF

//TRIADS RUN OUT

	WHILE NOT triads_ojective_passed = 2
		WAIT 0

			IF IS_CHAR_DEAD toni
				PRINT_NOW ( JM4_8 ) 5000 1
				GOTO mission_joey4_failed
			ENDIF

			IF IS_CAR_DEAD tonis_ride
				GOTO mission_joey4_failed
			ENDIF

			IF IS_CHAR_DEAD triad1_jm4
			AND ojective_triad1_done_before = 0
				triads_ojective_passed ++
				ojective_triad1_done_before = 1
			ENDIF

			IF IS_CHAR_DEAD triad2_jm4
			AND ojective_triad2_done_before = 0
				triads_ojective_passed ++
				ojective_triad2_done_before = 1
			ENDIF

			IF IS_CHAR_OBJECTIVE_PASSED triad1_jm4
			AND ojective_triad1_done_before = 0
				SET_CHAR_OBJ_DESTROY_CAR triad1_jm4 tonis_ride
				triads_ojective_passed ++
				ojective_triad1_done_before = 1
			ENDIF

			IF IS_CHAR_OBJECTIVE_PASSED triad2_jm4
			AND ojective_triad2_done_before = 0
				SET_CHAR_OBJ_DESTROY_CAR triad2_jm4 tonis_ride	
				triads_ojective_passed ++
				ojective_triad2_done_before = 1
			ENDIF

	ENDWHILE


	WHILE NOT IS_CHAR_IN_CAR toni tonis_ride
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

	ENDWHILE

	CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 843.1 -689.0 13.9 triad3_jm4
	GIVE_WEAPON_TO_CHAR triad3_jm4 WEAPONTYPE_PISTOL 100
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad3_jm4 Player
	SET_CHAR_THREAT_SEARCH triad3_jm4 THREAT_PLAYER1

	CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 844.3 -634.8 13.9 triad4_jm4
	GIVE_WEAPON_TO_CHAR triad4_jm4 WEAPONTYPE_PISTOL 100
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triad4_jm4 Player
	SET_CHAR_THREAT_SEARCH triad4_jm4 THREAT_PLAYER1

	IF NOT IS_CHAR_DEAD	toni
		SET_CHAR_PROOFS toni FALSE FALSE FALSE FALSE FALSE
	ENDIF

	IF NOT IS_CHAR_DEAD triad1_jm4
	AND NOT IS_CHAR_DEAD triad2_jm4
		SET_CHAR_PROOFS triad1_jm4 FALSE FALSE FALSE FALSE FALSE
		SET_CHAR_PROOFS triad2_jm4 FALSE FALSE FALSE FALSE FALSE
	ENDIF

SET_PLAYER_CONTROL Player On
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA

	LOAD_MISSION_AUDIO J4_C

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW ( JM4_3 ) 4000 1 //"GO GO GO!"
SET_POLICE_IGNORE_PLAYER Player OFF

ADD_BLIP_FOR_COORD 1216.8 -327.6 -100.0 blip3_jm4
CHANGE_BLIP_DISPLAY blip3_jm4 BLIP_ONLY

	// CLOSE DOORS
	WHILE NOT ROTATE_OBJECT laundrete_door1 0.0 10.0 FALSE
	OR NOT ROTATE_OBJECT laundrete_door2 180.0 10.0	FALSE
		WAIT 0
			  
		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF
	
	ENDWHILE

is_char1_dead_jm4 = 0
is_char2_dead_jm4 = 0
is_char3_dead_jm4 = 0
is_char4_dead_jm4 = 0
flag_car_blip_displayed_jm4 = TRUE

REMOVE_BLIP blip3_jm4

// waiting for the player to get to Toni's

IF NOT IS_CHAR_DEAD	triad1_jm4
	SET_CHAR_THREAT_SEARCH triad1_jm4 THREAT_PLAYER1
ENDIF

IF NOT IS_CHAR_DEAD	triad2_jm4
	SET_CHAR_THREAT_SEARCH triad2_jm4 THREAT_PLAYER1
ENDIF

CLEAR_AREA 1216.7 -328.1 26.0 6.0 TRUE

flag_displayed_wanted_message_jm4 = 0

blob_flag = 1

	WHILE NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 1215.0 -326.9 25.0 1220.2 -330.5 27.0 blob_flag
	OR IS_WANTED_LEVEL_GREATER Player 0
	OR NOT IS_PLAYER_IN_CAR	player tonis_ride
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CAR_DEAD tonis_ride
			GOTO mission_joey4_failed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player tonis_ride
			IF flag_car_blip_displayed_jm4 = FALSE
				ADD_BLIP_FOR_CAR tonis_ride blip2_jm4
				REMOVE_BLIP blip3_jm4
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the car!"
				blob_flag = 0
				flag_car_blip_displayed_jm4 = TRUE
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_CAR player tonis_ride
			IF flag_car_blip_displayed_jm4 = TRUE
				ADD_BLIP_FOR_COORD 1216.8 -327.6 -100.0 blip3_jm4
				REMOVE_BLIP blip2_jm4
				blob_flag = 1
			flag_car_blip_displayed_jm4 = FALSE
			ENDIF
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

		IF IS_CHAR_DEAD triad1_jm4
		AND is_char1_dead_jm4 = 0
			is_char1_dead_jm4 = 1
		ENDIF

		IF IS_CHAR_DEAD triad2_jm4
		AND is_char2_dead_jm4 = 0
			is_char2_dead_jm4 = 1		
		ENDIF

		IF IS_CHAR_DEAD triad3_jm4
		AND is_char3_dead_jm4 = 0
			is_char3_dead_jm4 = 1
		ENDIF

		IF IS_CHAR_DEAD triad4_jm4
		AND is_char4_dead_jm4 = 0
			is_char4_dead_jm4 = 1		
		ENDIF

		IF is_char1_dead_jm4 = 1
		AND is_char2_dead_jm4 = 1
		AND is_char3_dead_jm4 = 1
		AND is_char4_dead_jm4 = 1
		AND played_tune_before = 0
			ADD_SCORE player 2000
			GET_PLAYER_COORDINATES Player player_X player_Y player_Z
			ADD_ONE_OFF_SOUND player_X player_Y player_Z SOUND_PART_MISSION_COMPLETE
			played_tune_before = 1
		ENDIF

		IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 1215.0 -326.9 25.0 1220.2 -330.5 27.0 FALSE

			IF IS_WANTED_LEVEL_GREATER player 0
				IF flag_displayed_wanted_message_jm4 = 0
					PRINT_NOW ( WANTED1 ) 3000 1
					flag_displayed_wanted_message_jm4 = 1
				ENDIF
			ELSE
			
			ENDIF
		ELSE
			IF NOT IS_PLAYER_IN_AREA_3D player 1215.0 -326.9 25.0 1220.2 -330.5 27.0 FALSE
				flag_displayed_wanted_message_jm4 = 0
			ENDIF
		ENDIF

	ENDWHILE

REMOVE_BLIP blip3_jm4

CLEAR_AREA 1216.5 -326.8 26.0 6.0 TRUE
CLEAR_AREA 1219.6 -319.2 27.7 2.0 TRUE
SET_PLAYER_CONTROL Player Off
SET_POLICE_IGNORE_PLAYER Player ON
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 1224.119 -333.413 26.529 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1223.382 -332.738 26.568 JUMP_CUT

IF NOT IS_CHAR_DEAD	toni
	SET_CURRENT_CHAR_WEAPON toni WEAPONTYPE_UNARMED
	CHAR_LOOK_AT_PLAYER_ALWAYS toni player
	PLAYER_LOOK_AT_CHAR_ALWAYS player toni
ENDIF

REMOVE_BLIP blip2_jm4

//SAMPLE 1***************************************************
LOAD_MISSION_AUDIO J4_D

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW ( JM4_4 ) 4000 1 //"come back for job"

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

ENDWHILE

//SAMPLE 2***************************************************
LOAD_MISSION_AUDIO J4_E

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW ( JM4_5 ) 5000 1 //"come back for job"

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

ENDWHILE

//SAMPLE 3***************************************************
LOAD_MISSION_AUDIO J4_F

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

ENDWHILE


	IF IS_CAR_DEAD tonis_ride
	OR IS_CHAR_DEAD toni
		PRINT_NOW ( JM4_8 ) 5000 1 
		GOTO mission_joey4_failed	
	ENDIF

	IF NOT IS_CHAR_DEAD toni
		SET_CHAR_RUNNING toni FALSE
		SET_CHAR_OBJ_LEAVE_CAR toni tonis_ride
		STOP_CHAR_LOOKING toni
		STOP_PLAYER_LOOKING Player
	ENDIF

	WHILE IS_CHAR_IN_CAR toni tonis_ride
		WAIT 0

		IF IS_CAR_DEAD tonis_ride
		OR IS_CHAR_DEAD toni 
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed	
		ENDIF

		IF IS_CAR_UPSIDEDOWN tonis_ride
		AND IS_CAR_STOPPED tonis_ride
			PRINT_NOW ( WRECKED ) 5000 1
			GOTO mission_joey4_failed
		ENDIF

	ENDWHILE

	IF IS_CHAR_DEAD toni 
		PRINT_NOW ( JM4_8 ) 5000 1
		GOTO mission_joey4_failed	
	ENDIF

TIMERB = 0
CLEAR_AREA 1219.4 -324.4 26.1 2.0 TRUE
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 1219.4 -324.4

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			PRINT_NOW ( JM4_8 ) 5000 1 
			GOTO mission_joey4_failed	
		ENDIF

		IF TIMERB > 10000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 1219.4 -324.4 -100.0
			ENDIF
		ENDIF

	ENDWHILE

	IF IS_CHAR_DEAD toni
		PRINT_NOW ( JM4_8 ) 5000 1 
		GOTO mission_joey4_failed	
	ENDIF

TIMERB = 0
CLEAR_AREA 1219.5 -315.4 29.9 2.0 TRUE
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 1219.5 -318.6

PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 3000 7000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 3000

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni 
			PRINT_NOW ( JM4_8 ) 5000 1
			GOTO mission_joey4_failed	
		ENDIF

		IF TIMERB > 10000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 1219.5 -318.6 28.4
			ENDIF
		ENDIF

	ENDWHILE

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL Player On
SET_POLICE_IGNORE_PLAYER Player OFF
RESTORE_CAMERA_JUMPCUT
DELETE_CHAR toni
}

GOTO mission_joey4_passed



// Mission Joey4 failed

mission_joey4_failed:
//SWITCH_WIDESCREEN OFF
//SET_PLAYER_CONTROL Player On
//RESTORE_CAMERA_JUMPCUT
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission Joey4 passed

mission_joey4_passed:

flag_joey_mission4_passed = 1
//PLAY_MISSION_PASSED_TUNE 1
//PRINT_WITH_NUMBER_BIG ( M_PASS ) 3000 5000 1 //"Mission Passed!"
//CLEAR_WANTED_LEVEL player
//ADD_SCORE player 3000
REGISTER_MISSION_PASSED JM4
PLAYER_MADE_PROGRESS 1
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1219.6 -321.0 26.4 RADAR_SPRITE_TONY toni_contact_blip
REMOVE_PICKUP SHOP_UZI 
CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP 1070.5 -400.8 15.2 SHOP_UZI2
START_NEW_SCRIPT toni_mission1_loop
START_NEW_SCRIPT joey_mission5_loop 
START_NEW_SCRIPT uzi_message
RETURN
		


// mission cleanup

mission_cleanup_joey4:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
REMOVE_BLIP blip1_jm4
REMOVE_BLIP blip2_jm4
REMOVE_BLIP blip3_jm4
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MAFIA
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
SWITCH_PED_ROADS_ON 824.9 -633.8 13.0 845.3 -693.8 18.0 
SWITCH_ROADS_ON 824.9 -633.8 13.0 845.3 -693.8 18.0 
UNLOAD_SPECIAL_CHARACTER 2
SWITCH_CAR_GENERATOR gen_car12 101
REMOVE_CHAR_ELEGANTLY toni
MISSION_HAS_FINISHED
RETURN


{
delete_tonis_car:

	DELETE_CAR tonis_ride

RETURN
}
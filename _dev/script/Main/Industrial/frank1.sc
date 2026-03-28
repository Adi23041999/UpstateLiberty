MISSION_START
// *****************************************************************************************
// ********************************* Frankie Mission 1 *************************************
// *********************************   Pulp Friction   *************************************
// *****************************************************************************************
// *** Frankie wants to discuss war with his lieutenants. He needs Maria out of the house***
// *** for the evening so Claude has to chaperone her. Drive Maria to a dealer to get her***
// *** party gear. Then on to an illegal warehouse party and wait for her outside. While ***
// *** waiting for Maria the police will decide to 'raid the joint'. The player must get ***
// *** Maria out and back to Frankie's safely.											 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_frankie1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_frankie1_failed
ENDIF

GOSUB mission_cleanup_frankie1

MISSION_END
 
// Variables for mission

VAR_INT frankies_limo chico	chico_message_flag fm1_blip	flag_blip_on_limo doorman1 doorman2	parked_car1	parked_car2	parked_car3	timera_reset timerb_reset
VAR_INT swatvan_fm1	swatvan2_fm1 cop1_fm1 cop2_fm1 cop3_fm1	cop4_fm1 cop5_fm1 cop6_fm1 cop7_fm1	cop8_fm1 clubbers_flee_flag 
VAR_INT R G R1 G1 R2 G2 R3 G3 R4 G4 R5 G5 shadow_counter add_sound_flag camera_mode chico_audio_flag
VAR_INT clubber1_fm1 clubber2_fm1 clubber3_fm1 clubber4_fm1	clubber5_fm1 clubber6_fm1 clubber7_fm1 clubber8_fm1 maria_blip warehouse_rave_loop
VAR_INT clubber3_car1 clubber5_car2 clubber8_car3 flag_blip_on_maria create_more_swat1 create_more_swat2 swat1_exit_car swat2_exit_car
VAR_INT	timerc_reset_flag_f1a timerc_current_f1a timerc_started_f1a	timerc_f1a fuckup_flag fuckup_timer_start fuckup_timer_current fuckup_timer
VAR_INT	timerc_reset_flag_f1b timerc_current_f1b timerc_started_f1b	timerc_f1b locate_dome_flag	swat_cam_needs_restoring skip_cutscene_flag

VAR_FLOAT swat1_stuck_x swat1_stuck_y swat1_stuck_z
VAR_FLOAT swat2_stuck_x swat2_stuck_y swat2_stuck_z
VAR_FLOAT chico_x chico_y chico_z inside_warehouse_x inside_warehouse_y inside_warehouse_z outside_warehouse_x outside_warehouse_y

// ****************************************Mission Start************************************

mission_start_frankie1:

flag_player_on_mission = 1
flag_player_on_frankie_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME frank1

chico_message_flag 	= 0
flag_blip_on_limo  	= 0
timera_reset  		= 0
timerb_reset  		= 0
clubbers_flee_flag 	= 0
clubber3_car1  		= 0
clubber5_car2  		= 0
clubber8_car3  		= 0
flag_blip_on_maria  = 0
create_more_swat1  	= 0
create_more_swat2  	= 0
swat1_exit_car  	= 0
swat2_exit_car 		= 0
maria_blip			= 0
add_sound_flag		= 0
locate_dome_flag	= 0
chico_audio_flag	= 0
swat_cam_needs_restoring = 0
skip_cutscene_flag  = 0

timerc_reset_flag_f1a = 0
timerc_current_f1a = 0
timerc_started_f1a = 0
timerc_f1a = 0
timerc_reset_flag_f1b = 0
timerc_current_f1b = 0
timerc_started_f1b = 0	
timerc_f1b = 0
fuckup_flag = 0
fuckup_timer_start = 0
fuckup_timer_current = 0
fuckup_timer = 0

shadow_counter = 0

inside_warehouse_x = 1273.0
inside_warehouse_y = -1107.4
inside_warehouse_z = 11.5

outside_warehouse_x = 1261.0
outside_warehouse_y	= -1108.0

swat1_stuck_x = 0.0
swat1_stuck_y = 0.0
swat1_stuck_z = 0.0

swat2_stuck_x = 0.0
swat2_stuck_y = 0.0
swat2_stuck_z = 0.0

R = 0
G = 0
R1 = 0
G1 = 0
R2 = 0
G2 = 0
R3 = 0
G3 = 0
R4 = 0
G4 = 0
R5 = 0
G5 = 0

{
LOAD_SPECIAL_CHARACTER 1 frankie
LOAD_SPECIAL_CHARACTER 2 maria
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 FRANKH
LOAD_SPECIAL_MODEL cut_obj3 MARIAH
REQUEST_MODEL PED_GANG_MAFIA_B
REQUEST_MODEL salvsdetail
REQUEST_MODEL swank_inside
REQUEST_MODEL franksclb02

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED salvsdetail
OR NOT HAS_MODEL_LOADED	swank_inside
OR NOT HAS_MODEL_LOADED	franksclb02
	WAIT 0
ENDWHILE

IF maria_exists = 1
	GOSUB delete_char_maria 
ENDIF
maria_exists = 0

CHANGE_GARAGE_TYPE frankie_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
CLOSE_GARAGE frankie_garage

SWITCH_RUBBISH OFF
CLEAR_AREA 1444.99 -186.9 56.0 35.0 TRUE

LOAD_CUTSCENE S1_PF

SET_CUTSCENE_OFFSET 1457.776 -185.348 54.925

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_frankie

SET_CUTSCENE_ANIM cs_frankie frankie

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_maria

SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_OBJECT PED_GANG_MAFIA_B cs_mafia

SET_CUTSCENE_ANIM cs_mafia gang02

CREATE_CUTSCENE_HEAD cs_player cut_obj1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_frankie cut_obj2 cs_frankiehead
SET_CUTSCENE_HEAD_ANIM cs_frankiehead frank

CREATE_CUTSCENE_HEAD cs_maria cut_obj3 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead maria

SET_PLAYER_COORDINATES player 1418.0 -186.0 -100.0

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

//SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time
WHILE cs_time < 219 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_A 15000 1
WHILE cs_time < 1849
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_B 15000 1
WHILE cs_time < 4493
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_C 15000 1
WHILE cs_time < 7519
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_D	15000 1
WHILE cs_time < 10505
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_E	15000 1
WHILE cs_time < 14239
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_F	15000 1
WHILE cs_time < 15964
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_G	15000 1
WHILE cs_time < 18485
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_H	15000 1
WHILE cs_time < 21608
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_I	15000 1
WHILE cs_time < 24863
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_J	15000 1
WHILE cs_time < 28287
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_K	15000 1
WHILE cs_time < 31451
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_L	15000 1
WHILE cs_time < 34679
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_M	15000 1
WHILE cs_time < 36802
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_N	15000 1
WHILE cs_time < 39747
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW FM1_O	15000 1
WHILE cs_time < 43500
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

SET_PLAYER_COORDINATES player 1418.0 -186.0 -100.0

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3
MARK_MODEL_AS_NO_LONGER_NEEDED salvsdetail
MARK_MODEL_AS_NO_LONGER_NEEDED swank_inside
MARK_MODEL_AS_NO_LONGER_NEEDED franksclb02

REQUEST_MODEL CAR_STRETCH
REQUEST_MODEL PED_CRIMINAL1

CLEAR_AREA 1444.99 -186.9 56.0 35.0 TRUE

SWITCH_RUBBISH ON

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_STRETCH
OR NOT HAS_MODEL_LOADED	PED_CRIMINAL1
	WAIT 0
ENDWHILE

CREATE_CAR CAR_STRETCH 1436.0 -183.0 50.0 frankies_limo
SET_RADIO_CHANNEL 3 -1
SET_CAR_HEADING frankies_limo 90.0
CHANGE_CAR_COLOUR frankies_limo 0 0 // FRANKIES LIMO NEEDS A UNIQUE COLOUR
SET_CAR_STRONG frankies_limo TRUE
SET_CAN_RESPRAY_CAR frankies_limo FALSE

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON

maria_exists = 1
CREATE_CHAR_AS_PASSENGER frankies_limo PEDTYPE_SPECIAL PED_SPECIAL2 1 maria
CLEAR_CHAR_THREAT_SEARCH maria
ADD_ARMOUR_TO_CHAR maria 100
SET_CHAR_CANT_BE_DRAGGED_OUT maria TRUE
SET_ANIM_GROUP_FOR_CHAR	maria ANIM_SEXY_WOMANPED

IF NOT IS_CHAR_IN_CAR maria	frankies_limo
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	maria frankies_limo
ENDIF

CREATE_CHAR PEDTYPE_CIVMALE PED_CRIMINAL1 770.2257 -565.9869 13.8 chico 
SET_CHAR_HEADING chico 265.2053
CLEAR_CHAR_THREAT_SEARCH chico
CHAR_SET_IDLE chico
SET_CHAR_STAY_IN_SAME_PLACE chico TRUE

SWITCH_PED_ROADS_OFF 759.0 -616.0 11.0 782.0 -536.0 26.0

GENERATE_RANDOM_INT_IN_RANGE 0 4 camera_mode

IF camera_mode < 1
	SET_FIXED_CAMERA_POSITION 1405.736 -190.179 62.455 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 1427.2837 -183.5375 49.4573 JUMP_CUT
ENDIF

IF camera_mode = 1
	SET_FIXED_CAMERA_POSITION 1425.685 -178.463 50.184 0.0 0.0 0.0
	POINT_CAMERA_AT_CAR frankies_limo FIXED JUMP_CUT
ENDIF

IF camera_mode = 2
	SET_FIXED_CAMERA_POSITION 1432.161 -179.705 50.643 0.0 0.0 0.0
	POINT_CAMERA_AT_CAR frankies_limo FIXED JUMP_CUT
ENDIF

IF camera_mode > 2
	SET_FIXED_CAMERA_POSITION 1421.134 -193.771 63.916 0.0 0.0 0.0
	POINT_CAMERA_AT_CAR frankies_limo FIXED JUMP_CUT
ENDIF

WARP_PLAYER_INTO_CAR player frankies_limo

DO_FADE 0 FADE_OUT

GET_CHAR_COORDINATES chico chico_x chico_y chico_z

ADD_BLIP_FOR_COORD 775.5 -557.3 14.0 fm1_blip

REQUEST_MODEL PED_GANG_MAFIA_A
REQUEST_MODEL CAR_SENTINEL
REQUEST_MODEL CAR_CHEETAH
REQUEST_MODEL CAR_MANANA

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED PED_GANG_MAFIA_A
OR NOT HAS_MODEL_LOADED CAR_SENTINEL
OR NOT HAS_MODEL_LOADED CAR_CHEETAH
OR NOT HAS_MODEL_LOADED CAR_MANANA
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON

IF IS_CHAR_DEAD maria
	PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
	GOTO mission_frankie1_failed
ENDIF

IF IS_CAR_DEAD frankies_limo
	GOTO mission_frankie1_failed
ENDIF

IF NOT IS_CHAR_IN_CAR maria	frankies_limo
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	maria frankies_limo
ENDIF

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF IS_CHAR_DEAD maria
	PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
	GOTO mission_frankie1_failed
ENDIF

IF IS_CAR_DEAD frankies_limo
	GOTO mission_frankie1_failed
ENDIF

IF NOT IS_CHAR_IN_CAR maria	frankies_limo
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	maria frankies_limo
ENDIF

CHANGE_GARAGE_TYPE frankie_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
OPEN_GARAGE frankie_garage
CAR_GOTO_COORDINATES_ACCURATE frankies_limo 1416.1118 -189.4448 49.5264

WHILE NOT LOCATE_CAR_2D frankies_limo 1420.5 -189.1 3.0 3.0 0
	
	WAIT 0
	
	IF IS_CAR_DEAD frankies_limo
		GOTO mission_frankie1_failed
	ENDIF

ENDWHILE

CLOSE_GARAGE frankie_garage
APPLY_BRAKES_TO_PLAYERS_CAR player ON

IF IS_CHAR_DEAD maria
	PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
	GOTO mission_frankie1_failed
ENDIF

SET_CAMERA_IN_FRONT_OF_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player ON
SET_CAR_STATUS frankies_limo STATUS_PLAYER
SWITCH_WIDESCREEN OFF

locate_dome_flag = 1

REQUEST_MODEL CAR_ENFORCER
REQUEST_MODEL PED_SWAT
REQUEST_MODEL PED_P_MAN1
REQUEST_MODEL PED_FEMALE1
REQUEST_MODEL PED_FEMALE2

//WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_2D maria chico_x chico_y 10.0 10.0 0
WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_3D maria 775.5 -557.3 14.0 3.0 3.0 2.0 locate_dome_flag

	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CHAR_DEAD chico
		PRINT_NOW FM1_8 5000 1 // "You killed Chico!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 0
		locate_dome_flag = 0
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_CAR frankies_limo fm1_blip
		PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
		flag_blip_on_limo = 1
	ENDIF
	
	IF IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 1
		locate_dome_flag = 1
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_CHAR chico fm1_blip
		flag_blip_on_limo = 0
	ENDIF

	GET_CHAR_COORDINATES chico chico_x chico_y chico_z

	IF LOCATE_PLAYER_IN_CAR_2D player chico_x chico_y 30.0 30.0 0
	AND chico_message_flag = 0
		PRINT_NOW FM1_P 5000 1 //THATS CHICO OVER THERE, STOP NEXT TO HIM AND I'LL GET OUT
		chico_message_flag = 1
	ENDIF

	IF chico_message_flag = 1
	AND NOT LOCATE_PLAYER_IN_CAR_2D player chico_x chico_y 30.0 30.0 0
		PRINT_NOW FM1_6 5000 1 //WHERE ARE YOU GOING, I WANT TO SEE CHICO
		chico_message_flag = 0
	ENDIF

ENDWHILE

SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player TRUE
SWITCH_WIDESCREEN ON
//MAKE_PLAYER_SAFE player
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

//SET_FIXED_CAMERA_POSITION 769.86 -569.95 14.462 0.0 0.0 0.0
//POINT_CAMERA_AT_CHAR maria FIXED JUMP_CUT
SET_FIXED_CAMERA_POSITION 770.7659 -569.9462 14.3248 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 770.7453 -568.9474 14.4 JUMP_CUT

REMOVE_BLIP	fm1_blip

CLOSE_GARAGE frankie_garage

SET_CHAR_OBJ_LEAVE_CAR maria frankies_limo

WHILE IS_CHAR_IN_ANY_CAR maria

	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CHAR_DEAD chico
		PRINT_NOW FM1_8 5000 1 // "You killed Chico!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 0
		ADD_BLIP_FOR_CAR frankies_limo fm1_blip
		PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
		flag_blip_on_limo = 1
	ENDIF
	
	IF IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 1
		REMOVE_BLIP fm1_blip
		flag_blip_on_limo = 0
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 20.0 20.0 0
		PRINT_NOW FM1_3 5000 1 //COMEBACK
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT maria chico

GET_CHAR_COORDINATES chico chico_x chico_y chico_z

WHILE NOT LOCATE_STOPPED_CHAR_ON_FOOT_2D maria chico_x chico_y 3.0 3.0 0

	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CHAR_DEAD chico
		PRINT_NOW FM1_8 5000 1 // "You killed Chico!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	GET_CHAR_COORDINATES chico chico_x chico_y chico_z

	IF NOT IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 0
		ADD_BLIP_FOR_CAR frankies_limo fm1_blip
		PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
		flag_blip_on_limo = 1
	ENDIF
	
	IF IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 1
		REMOVE_BLIP fm1_blip
		flag_blip_on_limo = 0
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 20.0 20.0 0
		PRINT_NOW FM1_3 5000 1 //COMEBACK
	ENDIF

ENDWHILE

CLEAR_SMALL_PRINTS

WHILE NOT chico_audio_flag = 15

	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		CLEAR_MISSION_AUDIO
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		CLEAR_MISSION_AUDIO
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CHAR_DEAD chico
		PRINT_NOW FM1_8 5000 1 // "You killed Chico!"
		CLEAR_MISSION_AUDIO
		GOTO mission_frankie1_failed
	ENDIF

	IF skip_cutscene_flag = 0
		IF NOT IS_BUTTON_PRESSED PAD1 CROSS
			skip_cutscene_flag = 1
		ENDIF
	ENDIF

	IF skip_cutscene_flag = 1
		IF IS_BUTTON_PRESSED PAD1 CROSS
			skip_cutscene_flag = 2
		ENDIF
	ENDIF
	
	IF skip_cutscene_flag = 2
		IF NOT IS_BUTTON_PRESSED PAD1 CROSS
			CLEAR_MISSION_AUDIO
			LOAD_MISSION_AUDIO S1_F
			SET_CHAR_WAIT_STATE chico WAITSTATE_FALSE 100
			SET_CHAR_WAIT_STATE maria WAITSTATE_FALSE 100
			chico_audio_flag = 15
			skip_cutscene_flag = 3
		ENDIF
	ENDIF

	IF chico_audio_flag = 0
		TURN_CHAR_TO_FACE_CHAR chico maria
		TURN_CHAR_TO_FACE_CHAR maria chico
		LOAD_MISSION_AUDIO S1_A
		chico_audio_flag = 1
	ENDIF 

	IF chico_audio_flag = 14
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_F
			SET_CHAR_WAIT_STATE chico WAITSTATE_FALSE 100
			chico_audio_flag = 15
		ENDIF
	ENDIF

	IF chico_audio_flag = 13
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES chico chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_U 2000 1//"Ciao baby."
			SET_CHAR_WAIT_STATE chico WAITSTATE_PLAYANIM_CHAT 10000
			chico_audio_flag = 14
		ENDIF
	ENDIF

	IF chico_audio_flag = 12
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_E
			SET_CHAR_WAIT_STATE maria WAITSTATE_FALSE 100
			chico_audio_flag = 13
		ENDIF
	ENDIF

	IF chico_audio_flag = 11
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES maria chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_T 4000 2 //"Thanks for the tip. C'mon, let's go party. See you around Chico."
			SET_CHAR_WAIT_STATE maria WAITSTATE_PLAYANIM_CHAT 10000
			chico_audio_flag = 12
		ENDIF
	ENDIF

	IF chico_audio_flag = 10
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_D
			SET_CHAR_WAIT_STATE chico WAITSTATE_FALSE 100
			chico_audio_flag = 11
		ENDIF
	ENDIF

	IF chico_audio_flag = 9
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES chico chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_S1 15000 2 //"You should check out the warehouse party going down at the North end of Portland Harbour."
			chico_audio_flag = 10
		ENDIF
	ENDIF

	IF chico_audio_flag = 8
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_C1
			chico_audio_flag = 9
		ENDIF
	ENDIF

	IF chico_audio_flag = 7
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES chico chico_x chico_y chico_z
			SET_CHAR_WAIT_STATE chico WAITSTATE_PLAYANIM_CHAT 10000
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_S 5000 2 //"Here you go lady"
			chico_audio_flag = 8
		ENDIF
	ENDIF

	IF chico_audio_flag = 6
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_C
			SET_CHAR_WAIT_STATE maria WAITSTATE_FALSE 100
			chico_audio_flag = 7
		ENDIF
	ENDIF

	IF chico_audio_flag = 5
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES maria chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_R 6000 2 //"Hi Chico. Yeah just the usual."
			SET_CHAR_WAIT_STATE maria WAITSTATE_PLAYANIM_CHAT 10000
			chico_audio_flag = 6
		ENDIF
	ENDIF

	IF chico_audio_flag = 4
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_B
			SET_CHAR_WAIT_STATE chico WAITSTATE_FALSE 100
			chico_audio_flag = 5
		ENDIF
	ENDIF

	IF chico_audio_flag = 3
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES chico chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_Q1 6000 2 //"You looking for some spank?"
			chico_audio_flag = 4
		ENDIF
	ENDIF

	IF chico_audio_flag = 2
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR chico maria
			TURN_CHAR_TO_FACE_CHAR maria chico
			LOAD_MISSION_AUDIO S1_A1
			chico_audio_flag = 3
		ENDIF
	ENDIF 

	IF chico_audio_flag = 1
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES chico chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_Q 6000 2 //"Hey it's my favourite lady!"
			SET_CHAR_WAIT_STATE chico WAITSTATE_PLAYANIM_CHAT 10000
			chico_audio_flag = 2
		ENDIF
	ENDIF

ENDWHILE

maria_getting_into_car:

IF IS_CHAR_DEAD maria
	PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
	GOTO mission_frankie1_failed
ENDIF

IF IS_CAR_DEAD frankies_limo
	PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
	GOTO mission_frankie1_failed
ENDIF

CLEAR_SMALL_PRINTS
SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER maria frankies_limo
SET_CHAR_RUNNING maria TRUE

MARK_CHAR_AS_NO_LONGER_NEEDED chico

SWITCH_PED_ROADS_ON 759.0 -616.0 11.0 782.0 -536.0 26.0

WHILE NOT IS_CHAR_IN_CAR maria frankies_limo
	
	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

ENDWHILE

IF flag_player_on_mission = 0
	ADD_BLIP_FOR_CAR frankies_limo fm1_blip
	ADD_BLIP_FOR_CHAR maria maria_blip
ENDIF

SET_PLAYER_CONTROL player ON
SET_EVERYONE_IGNORE_PLAYER player FALSE
SWITCH_WIDESCREEN OFF
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
SET_CHAR_RUNNING maria FALSE

RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO

PRINT_NOW FM1_V 5000 1 //"C'mon Fido, let's go check out this party!"

REMOVE_BLIP fm1_blip
REMOVE_BLIP maria_blip
ADD_BLIP_FOR_COORD 1256.6 -1099.3 -11.7 fm1_blip

CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1267.73 -1109.24 11.0 doorman1
SET_CHAR_HEADING doorman1 90.0
SET_CHAR_THREAT_SEARCH doorman1 THREAT_GANG_HOOD
SET_CHAR_PERSONALITY doorman1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR doorman1 WEAPONTYPE_PISTOL 99
SET_CHAR_OBJ_WAIT_ON_FOOT doorman1
SET_CHAR_HEED_THREATS doorman1 TRUE

CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1267.73 -1105.62 11.0 doorman2
SET_CHAR_HEADING doorman2 90.0
SET_CHAR_THREAT_SEARCH doorman2 THREAT_GANG_HOOD
SET_CHAR_PERSONALITY doorman2 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR doorman2 WEAPONTYPE_PISTOL 99
SET_CHAR_OBJ_WAIT_ON_FOOT doorman2
SET_CHAR_HEED_THREATS doorman2 TRUE

CREATE_CAR CAR_SENTINEL 1243.0 -1112.0 11.0 parked_car1
CREATE_CAR CAR_CHEETAH 1247.0 -1112.0 11.0 parked_car2
CREATE_CAR CAR_MANANA 1251.0 -1112.0 11.0 parked_car3

/////////////CLUB STUFF////

DRAW_SHADOW SHADOW_EXPLOSION 1270.8430 -1107.7288 11.1079 0.0 1.0 0 255 0 0// ShadowType X Y Z Rotation Scale Transparency Red Green Blue
DRAW_LIGHT 1273.1917 -1107.3098 11.1079 255 0 0
ADD_CONTINUOUS_SOUND 1269.7494 -1100.4137 14.0 SOUND_RAVE_LOOP_INDUSTRIAL_L warehouse_rave_loop
ADD_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION 1273.0 -1107.2 10.7 0
ADD_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION 1273.0522 -1107.2312 10.7 0
ADD_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION 1273.1 -1107.1 10.7 0
ADD_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION 1273.2 -1107.0 10.7 0
ADD_PARTICLE_EFFECT POBJECT_WALL_STEAM_SLOWMOTION 1270.0 -1107.35 10.8 0
ADD_PARTICLE_EFFECT POBJECT_PAVEMENT_STEAM_SLOWMOTION 1271.5223 -1107.5471 10.6 0
add_sound_flag = 1
locate_dome_flag = 1
chico_message_flag = 0
flag_blip_on_limo = 0

///////////////////////////

WHILE NOT LOCATE_STOPPED_CHAR_IN_CAR_2D maria 1259.0410 -1107.7825 3.0 3.0 locate_dome_flag

	WAIT 0
	
	GOSUB draw_disco_lights

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF chico_message_flag = 0
		IF LOCATE_CHAR_ANY_MEANS_2D	maria 1258.0 -1100.0 50.0 50.0 0
			PRINT_NOW FM1_9 5000 1 //"Thats the club up ahead"
			chico_message_flag = 1
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 0
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_CAR frankies_limo fm1_blip
		PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
		locate_dome_flag = 0
		flag_blip_on_limo = 1
	ENDIF
	
	IF IS_PLAYER_IN_CAR player frankies_limo
	AND flag_blip_on_limo = 1
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_COORD 1262.1 -1099.4 -100.0 fm1_blip
		locate_dome_flag = 1
		flag_blip_on_limo = 0
	ENDIF

	IF chico_audio_flag = 16
		IF HAS_MISSION_AUDIO_LOADED
			chico_audio_flag = 17
		ENDIF
	ENDIF

	IF chico_audio_flag = 15
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_G
			chico_audio_flag = 16
		ENDIF
	ENDIF

ENDWHILE

IF NOT chico_audio_flag = 17
	WAIT 0
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
		
		IF IS_CHAR_DEAD maria
			PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
			GOTO mission_frankie1_failed
		ENDIF

		IF IS_CAR_DEAD frankies_limo
			PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
			GOTO mission_frankie1_failed
		ENDIF

	ENDWHILE
	chico_audio_flag = 17
ENDIF

GET_CHAR_COORDINATES maria chico_x chico_y chico_z
PLAY_MISSION_AUDIO

SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

PRINT_NOW FM1_W 5000 1 //"OK Fido, you wait here and look after the car while I go and shake my butt."

WAIT 0

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

ENDWHILE

SET_PLAYER_CONTROL player ON
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE

SET_CHAR_OBJ_LEAVE_CAR maria frankies_limo

WHILE IS_CHAR_IN_CAR maria frankies_limo

	WAIT 0

	GOSUB draw_disco_lights
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF chico_audio_flag = 17
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_H
			chico_audio_flag = 18
		ENDIF
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT maria 1266.85 -1107.65
TIMERA = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_2D maria 1266.85 -1107.65 1.0 1.0 0
	
	WAIT 0

	GOSUB draw_disco_lights

	IF TIMERA > 20000
		CLEAR_AREA 1267.665 -1107.569 11.38 3.0 FALSE
	ENDIF
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF chico_audio_flag = 17
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_H
			chico_audio_flag = 18
		ENDIF
	ENDIF

ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT maria inside_warehouse_x inside_warehouse_y

WHILE NOT LOCATE_CHAR_ON_FOOT_2D maria inside_warehouse_x inside_warehouse_y 1.0 1.0 0
	
	WAIT 0

	GOSUB draw_disco_lights
	
	IF TIMERA > 20000
		CLEAR_AREA 1267.665 -1107.569 11.38 4.0 FALSE
	ENDIF
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF chico_audio_flag = 17
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_H
			chico_audio_flag = 18
		ENDIF
	ENDIF

ENDWHILE

maria_exists = 0
DELETE_CHAR	maria

wait_for_maria:////////////////////////////////////////////////////////////////////////

WAIT 0

GOSUB draw_disco_lights

IF IS_CAR_DEAD frankies_limo
	PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
	GOTO mission_frankie1_failed
ENDIF

TIMERA = 0

WHILE LOCATE_PLAYER_ANY_MEANS_2D player	1262.1 -1099.4 22.0 22.0 0

	WAIT 0

	GOSUB draw_disco_lights
	
	IF TIMERA > 10000
		GOTO club_busted
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF chico_audio_flag = 17
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_H
			chico_audio_flag = 18
		ENDIF
	ENDIF

ENDWHILE
	
PRINT_NOW (FM1_4) 500 2 //You're supposed to be waiting for Maria! Get back to the warehouse!

GOTO wait_for_maria///////////////////////////////////////////////////////////////////

club_busted://////////////////////////////////////////////////////////////////////////

WHILE NOT HAS_MODEL_LOADED CAR_ENFORCER
OR NOT HAS_MODEL_LOADED PED_SWAT
OR NOT HAS_MODEL_LOADED PED_P_MAN1
OR NOT HAS_MODEL_LOADED	PED_FEMALE1
OR NOT HAS_MODEL_LOADED	PED_FEMALE2
	WAIT 0
ENDWHILE

swat_car_one:

CREATE_CAR CAR_ENFORCER 1293.0 -925.0 -100.0 swatvan_fm1
SET_CAR_HEADING swatvan_fm1 225.0
SET_CAR_CRUISE_SPEED swatvan_fm1 40.0
SET_CAR_DRIVING_STYLE swatvan_fm1 2
SWITCH_CAR_SIREN swatvan_fm1 ON
LOCK_CAR_DOORS swatvan_fm1 CARLOCK_LOCKOUT_PLAYER_ONLY

CREATE_CHAR_INSIDE_CAR swatvan_fm1 PEDTYPE_GANG_HOOD PED_SWAT cop1_fm1
SET_CHAR_THREAT_SEARCH cop1_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop1_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop1_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan_fm1 PEDTYPE_GANG_HOOD PED_SWAT 0 cop2_fm1
SET_CHAR_THREAT_SEARCH cop2_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop2_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop2_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan_fm1 PEDTYPE_GANG_HOOD PED_SWAT 1 cop3_fm1
SET_CHAR_THREAT_SEARCH cop3_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop3_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop3_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan_fm1 PEDTYPE_GANG_HOOD PED_SWAT 2 cop4_fm1
SET_CHAR_THREAT_SEARCH cop4_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop4_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop4_fm1 WEAPONTYPE_PISTOL 99

CAR_GOTO_COORDINATES swatvan_fm1 1252.0 -1086.0 -100.0

IF create_more_swat1 = 1
	create_more_swat1 = 0
	RETURN
ENDIF

swat_car_two:

CREATE_CAR CAR_ENFORCER 1084.0 -1012.0 -100.0 swatvan2_fm1
SET_CAR_HEADING swatvan2_fm1 180.0
SET_CAR_CRUISE_SPEED swatvan2_fm1 40.0
SET_CAR_DRIVING_STYLE swatvan2_fm1 2
SWITCH_CAR_SIREN swatvan2_fm1 ON
LOCK_CAR_DOORS swatvan2_fm1 CARLOCK_LOCKOUT_PLAYER_ONLY

CREATE_CHAR_INSIDE_CAR swatvan2_fm1 PEDTYPE_GANG_HOOD PED_SWAT cop5_fm1
SET_CHAR_THREAT_SEARCH cop5_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop5_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop5_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan2_fm1 PEDTYPE_GANG_HOOD PED_SWAT 0 cop6_fm1
SET_CHAR_THREAT_SEARCH cop6_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop6_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop6_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan2_fm1 PEDTYPE_GANG_HOOD PED_SWAT 1 cop7_fm1
SET_CHAR_THREAT_SEARCH cop7_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop7_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop7_fm1 WEAPONTYPE_PISTOL 99

CREATE_CHAR_AS_PASSENGER swatvan2_fm1 PEDTYPE_GANG_HOOD PED_SWAT 2 cop8_fm1
SET_CHAR_THREAT_SEARCH cop8_fm1 THREAT_GANG_MAFIA
SET_CHAR_PERSONALITY cop8_fm1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR cop8_fm1 WEAPONTYPE_PISTOL 99

CAR_GOTO_COORDINATES swatvan2_fm1 1235.0 -1099.0 -100.0

SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player TRUE
SWITCH_WIDESCREEN ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SET_FIXED_CAMERA_POSITION 1309.913 -1061.354 15.691 0.0 0.0 0.0
POINT_CAMERA_AT_CAR swatvan_fm1 FIXED JUMP_CUT
SET_GENERATE_CARS_AROUND_CAMERA TRUE
swat_cam_needs_restoring = 1

IF create_more_swat2 = 1
	create_more_swat2 = 0
	RETURN
ENDIF

IF NOT chico_audio_flag = 18
	WHILE NOT HAS_MISSION_AUDIO_FINISHED
		WAIT 0
		
		IF IS_CAR_DEAD frankies_limo
			PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
			GOTO mission_frankie1_failed
		ENDIF

	ENDWHILE
	LOAD_MISSION_AUDIO S1_H
	chico_audio_flag = 18
ENDIF

WAIT 0

IF chico_audio_flag = 18
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
		
		IF IS_CAR_DEAD frankies_limo
			PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
			GOTO mission_frankie1_failed
		ENDIF

	ENDWHILE
	chico_audio_flag = 19
ENDIF

PLAY_MISSION_AUDIO
PRINT_NOW (FM1_SS) 4000 2 //"Calling all cars, request back-up for narcotics raid. Warehouse party Portland Harbour East."

WHILE swat1_exit_car = 0
OR swat2_exit_car = 0

	WAIT 0

	IF fuckup_flag = 0
		GET_GAME_TIMER fuckup_timer_start
		fuckup_flag = 1
	ENDIF

	IF fuckup_flag = 1
		GET_GAME_TIMER fuckup_timer_current
		fuckup_timer = fuckup_timer_current - fuckup_timer_start
		IF fuckup_timer > 180000
			swat1_exit_car = 1
			swat2_exit_car = 1
			IF swat_cam_needs_restoring = 1
				SET_CAMERA_BEHIND_PLAYER
				RESTORE_CAMERA_JUMPCUT
				SET_PLAYER_CONTROL player ON
				SET_EVERYONE_IGNORE_PLAYER player FALSE
				SWITCH_WIDESCREEN OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SET_GENERATE_CARS_AROUND_CAMERA FALSE
				swat_cam_needs_restoring = 0
			ENDIF
			fuckup_flag = 2
		ENDIF
	ENDIF
	
	GOSUB draw_disco_lights

	IF chico_audio_flag = 20
		IF HAS_MISSION_AUDIO_LOADED
			chico_audio_flag = 21
		ENDIF
	ENDIF
	
	IF chico_audio_flag = 19
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_I
			chico_audio_flag = 20
		ENDIF
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD swatvan_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
		create_more_swat1 = 1
		GOSUB swat_car_one
	ENDIF

	IF IS_CAR_UPSIDEDOWN swatvan_fm1
	AND IS_CAR_STOPPED swatvan_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
		create_more_swat1 = 1
		GOSUB swat_car_one
	ENDIF

	IF IS_CAR_IN_WATER swatvan_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
		create_more_swat1 = 1
		GOSUB swat_car_one
	ENDIF

	IF timera_reset = 1
		IF NOT IS_CAR_STOPPED swatvan_fm1
			timera_reset = 0
		ENDIF
	ENDIF
			
	IF IS_CAR_STOPPED swatvan_fm1
		IF timera_reset = 0
			TIMERA = 0
			timera_reset = 1
		ENDIF

		IF TIMERA > 5000
		AND timera_reset = 1
			MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
			create_more_swat1 = 1
			GOSUB swat_car_one
		ENDIF
	ENDIF
	
	IF LOCATE_CAR_3D swatvan_fm1 swat1_stuck_x swat1_stuck_y swat1_stuck_z 2.0 2.0 2.0 0
		IF timerc_reset_flag_f1a = 0
			GET_GAME_TIMER timerc_started_f1a
			timerc_reset_flag_f1a = 1
		ENDIF

		IF timerc_reset_flag_f1a = 1
			GET_GAME_TIMER timerc_current_f1a
			timerc_f1a = timerc_current_f1a - timerc_started_f1a
			IF timerc_f1a > 8000
				MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
				create_more_swat1 = 1
				GOSUB swat_car_one
			ENDIF
		ENDIF
	ENDIF

	IF NOT LOCATE_CAR_3D swatvan_fm1 swat1_stuck_x swat1_stuck_y swat1_stuck_z 2.0 2.0 2.0 0
		GET_CAR_COORDINATES swatvan_fm1 swat1_stuck_x swat1_stuck_y swat1_stuck_z
		timerc_reset_flag_f1a = 0
	ENDIF
	
	IF IS_CAR_DEAD swatvan2_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
		create_more_swat2 = 1
		GOSUB swat_car_two
	ENDIF

	IF IS_CAR_UPSIDEDOWN swatvan2_fm1
	AND IS_CAR_STOPPED swatvan2_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
		create_more_swat2 = 1
		GOSUB swat_car_two
	ENDIF

	IF IS_CAR_IN_WATER swatvan2_fm1
		MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
		create_more_swat2 = 1
		GOSUB swat_car_two
	ENDIF

	IF timerb_reset = 1
		IF NOT IS_CAR_STOPPED swatvan2_fm1
			timerb_reset = 0
		ENDIF
	ENDIF
			
	IF IS_CAR_STOPPED swatvan2_fm1
		IF timerb_reset = 0
			TIMERB = 0
			timerb_reset = 1
		ENDIF

		IF TIMERB > 5000
		AND timerb_reset = 1
			MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
			create_more_swat2 = 1
			GOSUB swat_car_two
		ENDIF
	ENDIF

	IF LOCATE_CAR_3D swatvan2_fm1 swat2_stuck_x swat2_stuck_y swat2_stuck_z 2.0 2.0 2.0 0
		IF timerc_reset_flag_f1b = 0
			GET_GAME_TIMER timerc_started_f1b
			timerc_reset_flag_f1b = 1
		ENDIF

		IF timerc_reset_flag_f1b = 1
			GET_GAME_TIMER timerc_current_f1b
			timerc_f1b = timerc_current_f1b - timerc_started_f1b
			IF timerc_f1b > 8000
				MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
				create_more_swat2 = 1
				GOSUB swat_car_two
			ENDIF
		ENDIF
	ENDIF

	IF NOT LOCATE_CAR_3D swatvan2_fm1 swat2_stuck_x swat2_stuck_y swat2_stuck_z 2.0 2.0 2.0 0
		GET_CAR_COORDINATES swatvan2_fm1 swat2_stuck_x swat2_stuck_y swat2_stuck_z
		timerc_reset_flag_f1b = 0
	ENDIF
	
	IF LOCATE_CAR_2D swatvan_fm1 1252.0 -1086.0 8.0 8.0 0
	AND swat1_exit_car = 0
		
		IF swat_cam_needs_restoring = 1
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CAMERA_JUMPCUT
			SET_PLAYER_CONTROL player ON
			SET_EVERYONE_IGNORE_PLAYER player FALSE
			SWITCH_WIDESCREEN OFF
			SET_ALL_CARS_CAN_BE_DAMAGED TRUE
			SET_GENERATE_CARS_AROUND_CAMERA FALSE
			swat_cam_needs_restoring = 0
		ENDIF

		IF chico_audio_flag = 21
			IF NOT IS_CHAR_DEAD	doorman1
				GET_CHAR_COORDINATES doorman1 chico_x chico_y chico_z
				SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED doorman1
				IF NOT IS_CHAR_DEAD	doorman2 
					GET_CHAR_COORDINATES doorman2 chico_x chico_y chico_z
					SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED doorman2
				ENDIF
			ENDIF
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_TT 5000 1//"IT'S A POLICE RAID! EVERYBODY FOR THEMSELVES!!"
			chico_audio_flag = 22
		ENDIF

		SET_CAR_CRUISE_SPEED swatvan_fm1 0.0

		IF NOT IS_CHAR_DEAD	cop1_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop1_fm1	swatvan_fm1
			SET_CHAR_HEED_THREATS cop1_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop2_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop2_fm1	swatvan_fm1
			SET_CHAR_HEED_THREATS cop2_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop3_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop3_fm1	swatvan_fm1
			SET_CHAR_HEED_THREATS cop3_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop4_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop4_fm1	swatvan_fm1
			SET_CHAR_HEED_THREATS cop4_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
		ENDIF
		
		IF NOT IS_CHAR_DEAD doorman2
		AND NOT IS_CHAR_DEAD cop1_fm1
			SET_CHAR_OBJ_KILL_CHAR_ON_FOOT doorman2 cop1_fm1
		ENDIF
		swat1_exit_car = 1
	ENDIF

	IF LOCATE_CAR_2D swatvan2_fm1 1235.0 -1099.0 8.0 8.0 0
	AND swat2_exit_car = 0
		
		IF swat_cam_needs_restoring = 1
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			SET_PLAYER_CONTROL player ON
			SET_EVERYONE_IGNORE_PLAYER player FALSE
			SWITCH_WIDESCREEN OFF
			SET_ALL_CARS_CAN_BE_DAMAGED TRUE
			SET_GENERATE_CARS_AROUND_CAMERA FALSE
			swat_cam_needs_restoring = 0
		ENDIF

		IF chico_audio_flag = 21
			IF NOT IS_CHAR_DEAD	doorman1
				GET_CHAR_COORDINATES doorman1 chico_x chico_y chico_z
				SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
			ELSE
				IF NOT IS_CHAR_DEAD	doorman2 
					GET_CHAR_COORDINATES doorman2 chico_x chico_y chico_z
					SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
				ENDIF
			ENDIF
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_TT 5000 1//"IT'S A POLICE RAID! EVERYBODY FOR THEMSELVES!!"
			chico_audio_flag = 22
		ENDIF

		SET_CAR_CRUISE_SPEED swatvan2_fm1 0.0

		IF NOT IS_CHAR_DEAD	cop5_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop5_fm1	swatvan2_fm1
			SET_CHAR_HEED_THREATS cop5_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop6_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop6_fm1	swatvan2_fm1
			SET_CHAR_HEED_THREATS cop6_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop7_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop7_fm1	swatvan2_fm1
			SET_CHAR_HEED_THREATS cop7_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
		ENDIF

		IF NOT IS_CHAR_DEAD	cop8_fm1
			SET_CHAR_OBJ_LEAVE_CAR cop8_fm1	swatvan2_fm1
			SET_CHAR_HEED_THREATS cop8_fm1 TRUE
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
		ENDIF
		
		IF NOT IS_CHAR_DEAD doorman1
		AND NOT IS_CHAR_DEAD cop5_fm1
			SET_CHAR_OBJ_KILL_CHAR_ON_FOOT doorman1 cop5_fm1
		ENDIF
		swat2_exit_car = 1
	ENDIF

ENDWHILE

IF swat_cam_needs_restoring = 1
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	SET_PLAYER_CONTROL player ON
	SET_EVERYONE_IGNORE_PLAYER player FALSE
	SWITCH_WIDESCREEN OFF
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SET_GENERATE_CARS_AROUND_CAMERA FALSE
	swat_cam_needs_restoring = 0
ENDIF

WHILE clubbers_flee_flag < 10

	WAIT 0

	GOSUB draw_disco_lights

	IF chico_audio_flag = 23
		IF HAS_MISSION_AUDIO_LOADED
			chico_audio_flag = 24
		ENDIF
	ENDIF
	
	IF chico_audio_flag = 22
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_J
			chico_audio_flag = 23
		ENDIF
	ENDIF
	
	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF clubbers_flee_flag = 0
		CREATE_CHAR PEDTYPE_GANG_MAFIA PED_P_MAN1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber1_fm1
		SET_CHAR_THREAT_SEARCH clubber1_fm1 THREAT_GANG_HOOD
		GIVE_WEAPON_TO_CHAR clubber1_fm1 WEAPONTYPE_UZI 99
		SET_CHAR_PERSONALITY clubber1_fm1 PEDSTAT_TOUGH_GUY
		SET_CHAR_RUNNING clubber1_fm1 TRUE
		SET_CHAR_OBJ_RUN_TO_COORD clubber1_fm1 outside_warehouse_x outside_warehouse_y
		clubbers_flee_flag = 1
	ENDIF	

	IF clubbers_flee_flag = 1	
		IF IS_CHAR_DEAD clubber1_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber1_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber2_fm1
			SET_CHAR_THREAT_SEARCH clubber2_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber2_fm1 PEDSTAT_TOUGH_GUY
			GIVE_WEAPON_TO_CHAR clubber2_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_RUNNING clubber2_fm1 TRUE
			SET_CHAR_OBJ_RUN_TO_COORD clubber2_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 2
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber1_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber2_fm1
				GIVE_WEAPON_TO_CHAR clubber2_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_THREAT_SEARCH clubber2_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber2_fm1 PEDSTAT_TOUGH_GUY
				SET_CHAR_RUNNING clubber2_fm1 TRUE
				SET_CHAR_OBJ_RUN_TO_COORD clubber2_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF clubbers_flee_flag = 2	
		IF IS_CHAR_DEAD clubber2_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber2_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_CRIMINAL1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber3_fm1
			SET_CHAR_THREAT_SEARCH clubber3_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber3_fm1 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING clubber3_fm1 TRUE
			GIVE_WEAPON_TO_CHAR	clubber3_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_OBJ_RUN_TO_COORD clubber3_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 3
			clubber3_car1 = 1
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber2_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_CRIMINAL1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber3_fm1
				SET_CHAR_THREAT_SEARCH clubber3_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber3_fm1 PEDSTAT_TOUGH_GUY
				SET_CHAR_RUNNING clubber3_fm1 TRUE
				GIVE_WEAPON_TO_CHAR	clubber3_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_OBJ_RUN_TO_COORD clubber3_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 3
				clubber3_car1 = 1
			ENDIF
		ENDIF
	ENDIF
		
	IF clubbers_flee_flag = 3
		IF IS_CHAR_DEAD clubber3_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE2 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber4_fm1
			SET_CHAR_THREAT_SEARCH clubber4_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber4_fm1 PEDSTAT_TOUGH_GUY
			GIVE_WEAPON_TO_CHAR	clubber4_fm1 WEAPONTYPE_UZI 99
			SET_CHAR_RUNNING clubber4_fm1 TRUE
			SET_CHAR_OBJ_RUN_TO_COORD clubber4_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 4
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber3_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE2 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber4_fm1
				SET_CHAR_THREAT_SEARCH clubber4_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber4_fm1 PEDSTAT_TOUGH_GUY
				GIVE_WEAPON_TO_CHAR	clubber4_fm1 WEAPONTYPE_UZI 99
				SET_CHAR_RUNNING clubber4_fm1 TRUE
				SET_CHAR_OBJ_RUN_TO_COORD clubber4_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF clubbers_flee_flag = 4	
		IF IS_CHAR_DEAD clubber4_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber4_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber5_fm1
			SET_CHAR_THREAT_SEARCH clubber5_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber5_fm1 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING clubber5_fm1 TRUE
			GIVE_WEAPON_TO_CHAR	clubber5_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_OBJ_RUN_TO_COORD clubber5_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 5
			clubber5_car2 = 1
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber4_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber5_fm1
				SET_CHAR_THREAT_SEARCH clubber5_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber5_fm1 PEDSTAT_TOUGH_GUY
				SET_CHAR_RUNNING clubber5_fm1 TRUE
				GIVE_WEAPON_TO_CHAR	clubber5_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_OBJ_RUN_TO_COORD clubber5_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 5
				clubber5_car2 = 1
			ENDIF
		ENDIF
	ENDIF

	IF clubbers_flee_flag = 5	
		IF IS_CHAR_DEAD clubber5_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_CRIMINAL1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber6_fm1
			SET_CHAR_THREAT_SEARCH clubber6_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber6_fm1 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING clubber6_fm1 TRUE
			GIVE_WEAPON_TO_CHAR	clubber6_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_OBJ_RUN_TO_COORD clubber6_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 6
		ELSE 
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber5_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_CRIMINAL1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber6_fm1
				SET_CHAR_THREAT_SEARCH clubber6_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber6_fm1 PEDSTAT_TOUGH_GUY
				SET_CHAR_RUNNING clubber6_fm1 TRUE
				GIVE_WEAPON_TO_CHAR	clubber6_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_OBJ_RUN_TO_COORD clubber6_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 6
			ENDIF
		ENDIF
	ENDIF
		
	IF clubbers_flee_flag = 6
		IF IS_CHAR_DEAD clubber6_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber6_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber7_fm1
			SET_CHAR_THREAT_SEARCH clubber7_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber7_fm1 PEDSTAT_TOUGH_GUY
			GIVE_WEAPON_TO_CHAR	clubber7_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_RUNNING clubber7_fm1 TRUE
			SET_CHAR_OBJ_RUN_TO_COORD clubber7_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 7
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber6_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_FEMALE1 inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber7_fm1
				SET_CHAR_THREAT_SEARCH clubber7_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber7_fm1 PEDSTAT_TOUGH_GUY
				GIVE_WEAPON_TO_CHAR	clubber7_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_RUNNING clubber7_fm1 TRUE
				SET_CHAR_OBJ_RUN_TO_COORD clubber7_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 7
			ENDIF
		ENDIF
	ENDIF

	IF clubbers_flee_flag = 7	
		IF IS_CHAR_DEAD clubber7_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber7_fm1
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber8_fm1
			SET_CHAR_THREAT_SEARCH clubber8_fm1 THREAT_GANG_HOOD
			SET_CHAR_PERSONALITY clubber8_fm1 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING clubber8_fm1 TRUE
			GIVE_WEAPON_TO_CHAR	clubber8_fm1 WEAPONTYPE_PISTOL 50
			SET_CHAR_OBJ_RUN_TO_COORD clubber8_fm1 outside_warehouse_x outside_warehouse_y
			clubbers_flee_flag = 8
			clubber8_car3 = 1
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber7_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A inside_warehouse_x inside_warehouse_y inside_warehouse_z clubber8_fm1
				SET_CHAR_THREAT_SEARCH clubber8_fm1 THREAT_GANG_HOOD
				SET_CHAR_PERSONALITY clubber8_fm1 PEDSTAT_TOUGH_GUY
				SET_CHAR_RUNNING clubber8_fm1 TRUE
				GIVE_WEAPON_TO_CHAR	clubber8_fm1 WEAPONTYPE_PISTOL 50
				SET_CHAR_OBJ_RUN_TO_COORD clubber8_fm1 outside_warehouse_x outside_warehouse_y
				clubbers_flee_flag = 8
				clubber8_car3 = 1
			ENDIF
		ENDIF	
	ENDIF

	IF clubbers_flee_flag = 8	
		IF IS_CHAR_DEAD clubber8_fm1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
			IF swat_cam_needs_restoring = 1
				RESTORE_CAMERA_JUMPCUT
				SET_CAMERA_BEHIND_PLAYER
				SET_PLAYER_CONTROL player ON
				SET_EVERYONE_IGNORE_PLAYER player FALSE
				SWITCH_WIDESCREEN OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SET_GENERATE_CARS_AROUND_CAMERA FALSE
				swat_cam_needs_restoring = 0
			ENDIF
			maria_exists = 1
			CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 inside_warehouse_x inside_warehouse_y inside_warehouse_z maria
			SET_ANIM_GROUP_FOR_CHAR	maria ANIM_SEXY_WOMANPED
			ADD_ARMOUR_TO_CHAR maria 100
			CLEAR_CHAR_THREAT_SEARCH maria
			REMOVE_BLIP	fm1_blip
			ADD_BLIP_FOR_CHAR maria fm1_blip
			PRINT_NOW FM1_5 4000 2 //"Get Maria out of there and back to Frankie's"
			ALTER_WANTED_LEVEL_NO_DROP player 2
			SET_CHAR_RUNNING maria TRUE
			GET_PLAYER_COORDINATES player chico_x chico_y chico_z
			SET_CHAR_OBJ_RUN_TO_COORD maria chico_x chico_y
			clubbers_flee_flag = 9
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_2D	clubber8_fm1 inside_warehouse_x inside_warehouse_y 2.0 2.0 0
				IF swat_cam_needs_restoring = 1
					RESTORE_CAMERA_JUMPCUT
					SET_CAMERA_BEHIND_PLAYER
					SET_PLAYER_CONTROL player ON
					SET_EVERYONE_IGNORE_PLAYER player FALSE
					SWITCH_WIDESCREEN OFF
					SET_ALL_CARS_CAN_BE_DAMAGED TRUE
					SET_GENERATE_CARS_AROUND_CAMERA FALSE
					swat_cam_needs_restoring = 0
				ENDIF
				maria_exists = 1
				CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 inside_warehouse_x inside_warehouse_y inside_warehouse_z maria
				SET_ANIM_GROUP_FOR_CHAR	maria ANIM_SEXY_WOMANPED
				ADD_ARMOUR_TO_CHAR maria 100
				CLEAR_CHAR_THREAT_SEARCH maria
				REMOVE_BLIP	fm1_blip
				ADD_BLIP_FOR_CHAR maria fm1_blip
				PRINT_NOW FM1_5 4000 2 //"Get Maria out of there and back to Frankie's"
				ALTER_WANTED_LEVEL_NO_DROP player 2
				SET_CHAR_RUNNING maria TRUE
				GET_PLAYER_COORDINATES player chico_x chico_y chico_z
				SET_CHAR_OBJ_RUN_TO_COORD maria chico_x chico_y
				clubbers_flee_flag = 9
			ENDIF
		ENDIF
	ENDIF

	IF clubbers_flee_flag = 9
		IF IS_CHAR_DEAD maria
			GOTO mission_frankie1_failed
		ELSE
			SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT maria player
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 4.0 4.0 0
				SET_PLAYER_AS_LEADER maria player
				REMOVE_BLIP fm1_blip
				clubbers_flee_flag = 10
			ENDIF
		ENDIF
	ENDIF

	IF NOT clubber3_car1 = 3
	OR NOT clubber5_car2 = 3
	OR NOT clubber8_car3 = 3
		GOSUB clubbers_into_cars 
	ENDIF
	
	GOSUB police_idle_checks 

	GOSUB clubber_idle_checks 

	IF fuckup_flag = 2
		swat1_exit_car = 0
		swat2_exit_car = 0
		fuckup_flag = 3
	ENDIF

	IF swat1_exit_car = 0
		IF LOCATE_STOPPED_CAR_2D swatvan_fm1 1252.0 -1086.0 18.0 18.0 0
		
			IF chico_audio_flag = 21
				IF NOT IS_CHAR_DEAD	doorman1
					GET_CHAR_COORDINATES doorman1 chico_x chico_y chico_z
					SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED doorman1
					IF NOT IS_CHAR_DEAD	doorman2 
						GET_CHAR_COORDINATES doorman2 chico_x chico_y chico_z
						SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
					ELSE
						MARK_CHAR_AS_NO_LONGER_NEEDED doorman2
					ENDIF
				ENDIF
				PLAY_MISSION_AUDIO
				PRINT_NOW FM1_TT 5000 1//"IT'S A POLICE RAID! EVERYBODY FOR THEMSELVES!!"
				chico_audio_flag = 22
			ENDIF

			IF NOT IS_CHAR_DEAD	cop1_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop1_fm1	swatvan_fm1
				SET_CHAR_HEED_THREATS cop1_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop2_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop2_fm1	swatvan_fm1
				SET_CHAR_HEED_THREATS cop2_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop3_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop3_fm1	swatvan_fm1
				SET_CHAR_HEED_THREATS cop3_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop4_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop4_fm1	swatvan_fm1
				SET_CHAR_HEED_THREATS cop4_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
			ENDIF
			
			IF NOT IS_CHAR_DEAD doorman2
			AND NOT IS_CHAR_DEAD cop1_fm1
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT doorman2 cop1_fm1
			ENDIF
			swat1_exit_car = 1
		ENDIF
	ENDIF

	IF swat2_exit_car = 0
		IF LOCATE_STOPPED_CAR_2D swatvan2_fm1 1235.0 -1099.0 18.0 18.0 0
		
			IF chico_audio_flag = 21
				IF NOT IS_CHAR_DEAD	doorman1
					GET_CHAR_COORDINATES doorman1 chico_x chico_y chico_z
					SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED doorman1
					IF NOT IS_CHAR_DEAD	doorman2 
						GET_CHAR_COORDINATES doorman2 chico_x chico_y chico_z
						SET_MISSION_AUDIO_POSITION chico_x chico_y chico_z
					ELSE
						MARK_CHAR_AS_NO_LONGER_NEEDED doorman2
					ENDIF
				ENDIF
				PLAY_MISSION_AUDIO
				PRINT_NOW FM1_TT 5000 1//"IT'S A POLICE RAID! EVERYBODY FOR THEMSELVES!!"
				chico_audio_flag = 22
			ENDIF

			IF NOT IS_CHAR_DEAD	cop5_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop5_fm1	swatvan2_fm1
				SET_CHAR_HEED_THREATS cop5_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop6_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop6_fm1	swatvan2_fm1
				SET_CHAR_HEED_THREATS cop6_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop7_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop7_fm1	swatvan2_fm1
				SET_CHAR_HEED_THREATS cop7_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
			ENDIF

			IF NOT IS_CHAR_DEAD	cop8_fm1
				SET_CHAR_OBJ_LEAVE_CAR cop8_fm1	swatvan2_fm1
				SET_CHAR_HEED_THREATS cop8_fm1 TRUE
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
			ENDIF
			
			IF NOT IS_CHAR_DEAD doorman1
			AND NOT IS_CHAR_DEAD cop5_fm1
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT doorman1 cop5_fm1
			ENDIF
			swat2_exit_car = 1
		ENDIF
	ENDIF

ENDWHILE

MARK_CAR_AS_NO_LONGER_NEEDED swatvan_fm1
MARK_CAR_AS_NO_LONGER_NEEDED swatvan2_fm1

WHILE NOT IS_CHAR_IN_ANY_CAR maria //frankies_limo
	
	WAIT 0
	
	GOSUB draw_disco_lights
	
	IF chico_audio_flag = 23
		IF HAS_MISSION_AUDIO_LOADED
			chico_audio_flag = 24
		ENDIF
	ENDIF
	
	IF chico_audio_flag = 22
		IF HAS_MISSION_AUDIO_FINISHED
			LOAD_MISSION_AUDIO S1_J
			chico_audio_flag = 23
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP maria player
	AND flag_blip_on_maria = 0
		PRINT_NOW FM1_10 5000 1 //"Hey wait for me!"
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_CHAR maria fm1_blip
		flag_blip_on_maria = 1
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 8.0 8.0 FALSE
	AND flag_blip_on_maria = 1
		SET_PLAYER_AS_LEADER maria player
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip
		flag_blip_on_maria = 0
	ENDIF

	IF flag_blip_on_maria = 0
		IF NOT IS_PLAYER_IN_CAR player frankies_limo
		AND flag_blip_on_limo = 0
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_CAR frankies_limo fm1_blip
			PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
			flag_blip_on_limo = 1
		ENDIF
		
		IF IS_PLAYER_IN_CAR player frankies_limo
		AND flag_blip_on_limo = 1
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_CHAR maria fm1_blip
			flag_blip_on_limo = 0
		ENDIF
	ENDIF

//	IF NOT IS_PLAYER_IN_CAR player frankies_limo
//	AND flag_blip_on_limo = 0
//		REMOVE_BLIP fm1_blip
//		ADD_BLIP_FOR_CAR frankies_limo fm1_blip
//		PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
//		flag_blip_on_limo = 1
//	ENDIF
//	
//	IF IS_PLAYER_IN_CAR player frankies_limo
//	AND flag_blip_on_limo = 1
//		REMOVE_BLIP fm1_blip
//		ADD_BLIP_FOR_CHAR maria fm1_blip//COORD 1424.0 -183.5 50.0 fm1_blip
//		flag_blip_on_limo = 0
//	ENDIF

	IF NOT clubber3_car1 = 3
	OR NOT clubber5_car2 = 3
	OR NOT clubber8_car3 = 3
		GOSUB clubbers_into_cars 
	ENDIF

	GOSUB police_idle_checks 
	
	GOSUB clubber_idle_checks 

ENDWHILE

REMOVE_BLIP	fm1_blip
flag_blip_on_maria = 0
flag_blip_on_limo = 0
ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip

WAIT 0

IF NOT chico_audio_flag = 24
	WHILE NOT HAS_MISSION_AUDIO_LOADED
		
		WAIT 0
		
		GOSUB draw_disco_lights
		
		IF NOT clubber3_car1 = 3
		OR NOT clubber5_car2 = 3
		OR NOT clubber8_car3 = 3
			GOSUB clubbers_into_cars 
		ENDIF

		GOSUB police_idle_checks 
		
		GOSUB clubber_idle_checks 

		IF IS_CHAR_DEAD maria
			PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
			GOTO mission_frankie1_failed
		ENDIF

		IF IS_CAR_DEAD frankies_limo
			PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
			GOTO mission_frankie1_failed
		ENDIF

		IF NOT IS_CHAR_IN_PLAYERS_GROUP maria player
		AND flag_blip_on_maria = 0
			PRINT_NOW FM1_10 5000 1 //"Hey wait for me!"
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_CHAR maria fm1_blip
			flag_blip_on_maria = 1
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 8.0 8.0 FALSE
		AND flag_blip_on_maria = 1
			SET_PLAYER_AS_LEADER maria player
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip
			flag_blip_on_maria = 0
		ENDIF

		IF flag_blip_on_maria = 0
			IF NOT IS_PLAYER_IN_CAR player frankies_limo
			AND flag_blip_on_limo = 0
				REMOVE_BLIP fm1_blip
				ADD_BLIP_FOR_CAR frankies_limo fm1_blip
				PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
				flag_blip_on_limo = 1
			ENDIF
			
			IF IS_PLAYER_IN_CAR player frankies_limo
			AND flag_blip_on_limo = 1
				REMOVE_BLIP fm1_blip
				ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip
				flag_blip_on_limo = 0
			ENDIF
		ENDIF

		GOSUB police_idle_checks 

		GOSUB clubber_idle_checks 

	ENDWHILE
	chico_audio_flag = 24
ENDIF

PLAY_MISSION_AUDIO
PRINT_NOW FM1_X 5000 1 //"OK Fido, let's get out of here. YeeEEHAAA"

CHANGE_GARAGE_TYPE frankie_garage GARAGE_MISSION_KEEPCAR_REMAINCLOSED

IF NOT IS_CAR_DEAD frankies_limo
	SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage frankies_limo
ENDIF

//WHILE NOT LOCATE_PLAYER_IN_CAR_2D player 1424.0 -183.5 10.0 10.0 0
//WHILE NOT IS_PLAYER_STOPPED_IN_AREA_3D player 1428.8 -187.0 50.0 1442.5 -179.9 53.0 0
WHILE NOT IS_CAR_IN_MISSION_GARAGE frankie_garage

	WAIT 0

	GOSUB draw_disco_lights
	
	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF IS_CAR_DEAD frankies_limo
		PRINT_NOW WRECKED 5000 1 // "The vehicle is wrecked!"
		GOTO mission_frankie1_failed
	ENDIF

	IF LOCATE_CAR_2D frankies_limo 1424.8 -183.0 20.0 20.0 0
		CLEAR_WANTED_LEVEL player
	ENDIF

	IF NOT IS_CHAR_IN_PLAYERS_GROUP maria player
	AND flag_blip_on_maria = 0
		PRINT_NOW FM1_10 5000 1 //"Hey wait for me!"
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_CHAR maria fm1_blip
		flag_blip_on_maria = 1
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player maria 8.0 8.0 FALSE
	AND flag_blip_on_maria = 1
		SET_PLAYER_AS_LEADER maria player
		REMOVE_BLIP fm1_blip
		ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip
		flag_blip_on_limo = 0
		flag_blip_on_maria = 0
	ENDIF

	IF flag_blip_on_maria = 0
		IF NOT IS_PLAYER_IN_CAR player frankies_limo
		AND flag_blip_on_limo = 0
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_CAR frankies_limo fm1_blip
			PRINT_NOW (FM1_1) 5000 1 //"Get back into the limo!"
			flag_blip_on_limo = 1
		ENDIF
		
		IF IS_PLAYER_IN_CAR player frankies_limo
		AND flag_blip_on_limo = 1
			REMOVE_BLIP fm1_blip
			ADD_BLIP_FOR_COORD 1424.0 -183.5 50.0 fm1_blip
			flag_blip_on_limo = 0
		ENDIF
	ENDIF

	IF NOT clubber3_car1 = 3
	OR NOT clubber5_car2 = 3
	OR NOT clubber8_car3 = 3 
		GOSUB clubbers_into_cars 
	ENDIF

	GOSUB police_idle_checks 

	GOSUB clubber_idle_checks 

ENDWHILE

CLEAR_WANTED_LEVEL player 

DO_FADE 500	FADE_OUT

WAIT 500

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

IF IS_CHAR_DEAD maria
	PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
	GOTO mission_frankie1_failed
ENDIF

LEAVE_GROUP maria

CLEAR_WANTED_LEVEL player

WARP_PLAYER_FROM_CAR_TO_COORD player 1435.7676 -176.4341 52.2953
SET_PLAYER_HEADING player 184.9588
maria_exists = 0
DELETE_CHAR maria
CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1435.9358 -178.4347 54.0279 maria
maria_exists = 1
SET_CHAR_HEADING maria 184.9134

GET_PLAYER_CHAR player script_controlled_player

CLEAR_CHAR_THREAT_SEARCH maria
CLEAR_CHAR_THREAT_SEARCH script_controlled_player

SET_FIXED_CAMERA_POSITION 1433.4507 -173.6104 55.66595 0.0 0.0 0.0
POINT_CAMERA_AT_CHAR maria FIXED JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT maria 1436.2628 -180.6451
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT script_controlled_player 1436.2628 -180.6451

DELETE_CAR frankies_limo

CLEAR_AREA 1423.9675 -189.2235 49.2032 5.0 FALSE

DO_FADE 500 FADE_IN

LOAD_MISSION_AUDIO S1_K

//camera 1433.4507 -173.6104 56.66595
//point at maria maybe 1433.9979 -174.4381 56.542


//chat
//maria goto 1453.5276 -179.3224
//player goto 1443.6184 -188.2894

flag_blip_on_maria = 0
skip_cutscene_flag = 0
WHILE NOT flag_blip_on_maria = 8
	
	WAIT 0

	IF IS_CHAR_DEAD maria
		PRINT_NOW FM1_7 5000 1 // "You failed to protect Maria!"
		GOTO mission_frankie1_failed
	ENDIF

	IF skip_cutscene_flag = 0
		IF NOT IS_BUTTON_PRESSED PAD1 CROSS
			skip_cutscene_flag = 1
		ENDIF
	ENDIF

	IF skip_cutscene_flag = 1
		IF IS_BUTTON_PRESSED PAD1 CROSS
			skip_cutscene_flag = 2
		ENDIF
	ENDIF
	
	IF skip_cutscene_flag = 2
		IF NOT IS_BUTTON_PRESSED PAD1 CROSS
			DO_FADE 0 FADE_OUT
			WAIT 0
			CLEAR_MISSION_AUDIO
			CLEAR_SMALL_PRINTS
			SWITCH_WIDESCREEN OFF
			SET_PLAYER_CONTROL player ON
			SET_EVERYONE_IGNORE_PLAYER player FALSE
			SET_ALL_CARS_CAN_BE_DAMAGED TRUE
			DELETE_CHAR maria
			SET_PLAYER_COORDINATES player 1443.6184 -188.2894 55.0
			SET_PLAYER_HEADING player 180.0
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CAMERA_JUMPCUT
			DO_FADE 500 FADE_IN
			skip_cutscene_flag = 3
			GOTO mission_frankie1_passed
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 7
		IF LOCATE_PLAYER_ANY_MEANS_2D player 1443.6184 -188.2894 1.0 1.0 0
			IF NOT IS_CHAR_ON_SCREEN maria
				maria_exists = 0
				DELETE_CHAR	maria
				flag_blip_on_maria = 8
			ENDIF
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 6
		IF HAS_MISSION_AUDIO_FINISHED
			CLEAR_SMALL_PRINTS
			SET_CHAR_WAIT_STATE maria WAITSTATE_FALSE 100
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	script_controlled_player 1443.6184 -188.2894
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	maria 1453.5276 -179.3224
			flag_blip_on_maria = 7
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 5
		IF HAS_MISSION_AUDIO_LOADED
			GET_CHAR_COORDINATES maria chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_AA 8000 1	//"I'd better go I'll see you around I hope."
			flag_blip_on_maria = 6
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 4
		IF HAS_MISSION_AUDIO_FINISHED
			TURN_CHAR_TO_FACE_CHAR script_controlled_player maria
			TURN_CHAR_TO_FACE_CHAR maria script_controlled_player
			LOAD_MISSION_AUDIO S1_L
			flag_blip_on_maria = 5
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 3
		IF HAS_MISSION_AUDIO_LOADED
			TURN_CHAR_TO_FACE_CHAR script_controlled_player maria
			TURN_CHAR_TO_FACE_CHAR maria script_controlled_player
			GET_CHAR_COORDINATES maria chico_x chico_y chico_z
			PLAY_MISSION_AUDIO
			PRINT_NOW FM1_Y 8000 1	//"I enjoyed myself for the first time in a long while,"
			SET_CHAR_WAIT_STATE maria WAITSTATE_PLAYANIM_CHAT 20000
			flag_blip_on_maria = 4
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D maria 1440.5144 -179.1538 1.0 1.0 0
			GET_CHAR_HEADING maria swat1_stuck_x
			swat1_stuck_x -= 3.0
			IF swat1_stuck_x < 0.0
				swat1_stuck_x = 359.0
			ENDIF
			IF swat1_stuck_x < 180.0
				swat1_stuck_x = 180.0
			ENDIF
			SET_CHAR_HEADING maria swat1_stuck_x
			CHAR_LOOK_AT_PLAYER_ALWAYS maria player
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_2D player 1440.6287 -181.4022 1.0 1.0 0
				STOP_CHAR_LOOKING maria
				SET_FIXED_CAMERA_POSITION 1442.1001 -173.1516 55.8166 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 1441.78 -174.0602 55.6919 JUMP_CUT
				SET_PLAYER_HEADING player 0.0
				TURN_CHAR_TO_FACE_CHAR script_controlled_player maria
				TURN_PLAYER_TO_FACE_CHAR player maria
				TURN_CHAR_TO_FACE_CHAR maria script_controlled_player
				flag_blip_on_maria = 3
			ENDIF
		ENDIF
	ENDIF			

	IF flag_blip_on_maria = 1
		IF LOCATE_PLAYER_ON_FOOT_2D player 1436.2628 -180.6451 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	script_controlled_player 1440.6287 -181.4022
			flag_blip_on_maria = 2
		ENDIF
	ENDIF

	IF flag_blip_on_maria = 0
		IF LOCATE_CHAR_ON_FOOT_2D maria 1436.2628 -180.6451 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	maria 1440.5144 -179.1538
			flag_blip_on_maria = 1
		ENDIF
	ENDIF

ENDWHILE

SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player ON
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE

GOTO mission_frankie1_passed
}	   		
	

// Mission Frankie1 failed
mission_frankie1_failed:

PRINT_BIG ( m_fail ) 5000 1
RETURN
   

// mission Frankie1 passed
mission_frankie1_passed:

flag_frankie_mission1_passed = 1
IF flag_luigi_mission4_terminated = 1
START_NEW_SCRIPT luigi_mission4_loop
	REMOVE_BLIP luigi_contact_blip
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 892.8 -425.8 13.9 RADAR_SPRITE_LUIGI luigi_contact_blip
//	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 886.2 -417.1 -100.0 RADAR_SPRITE_LUIGI luigi_contact_blip
ENDIF
IF flag_luigi_mission5_terminated = 1
	START_NEW_SCRIPT luigi_mission5_loop
	REMOVE_BLIP	luigi_contact_blip
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 886.2 -417.1 -100.0 RADAR_SPRITE_LUIGI luigi_contact_blip
ENDIF
IF flag_joey_mission5_terminated = 1
	START_NEW_SCRIPT joey_mission5_loop
	REMOVE_BLIP	joey_contact_blip
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1191.7 -870.0 -100.0 RADAR_SPRITE_JOEY joey_contact_blip
ENDIF
IF flag_joey_mission6_terminated = 1
START_NEW_SCRIPT joey_mission6_loop
	REMOVE_BLIP	joey_contact_blip
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1191.7 -870.0 -100.0 RADAR_SPRITE_JOEY joey_contact_blip
ENDIF
PRINT_WITH_NUMBER_BIG m_pass 10000 5000 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED	FM1
PLAYER_MADE_PROGRESS 1
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1219.6 -321.0 26.4 RADAR_SPRITE_TONY toni_contact_blip
START_NEW_SCRIPT toni_mission4_loop 
START_NEW_SCRIPT frankie_mission2_loop
START_NEW_SCRIPT imp_exp_pager
RETURN
		


// mission cleanup
mission_cleanup_frankie1:

flag_player_on_mission = 0
flag_player_on_frankie_mission = 0

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player ON

IF add_sound_flag = 1
	REMOVE_SOUND warehouse_rave_loop
ENDIF

REMOVE_PARTICLE_EFFECTS_IN_AREA 1264.0 -1111.0 5.0 1275.0 -1103.0 15.0

MARK_MODEL_AS_NO_LONGER_NEEDED PED_CRIMINAL1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STRETCH
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MANANA
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ENFORCER
MARK_MODEL_AS_NO_LONGER_NEEDED PED_SWAT
MARK_MODEL_AS_NO_LONGER_NEEDED PED_P_MAN1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_FEMALE1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_FEMALE2

REMOVE_BLIP fm1_blip

CHANGE_GARAGE_TYPE frankie_garage GARAGE_MISSION_KEEPCAR
SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage -1
						 
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MISSION_HAS_FINISHED
RETURN
		
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// Functions ///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

clubbers_into_cars://////////////////////////////////////////////////////////////////////////////////

IF clubbers_flee_flag > 2
	IF clubber3_car1 = 1
		IF NOT IS_CHAR_DEAD clubber3_fm1
			IF LOCATE_CHAR_ON_FOOT_2D clubber3_fm1 outside_warehouse_x outside_warehouse_y 3.0 3.0 0
				IF IS_CAR_STILL_ALIVE parked_car1
					IF LOCATE_CAR_2D parked_car1 1243.0 -1112.0 8.0 8.0 0
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER clubber3_fm1 parked_car1
						clubber3_car1 = 2
					ELSE
						SET_CHAR_HEED_THREATS clubber3_fm1 TRUE
						MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
						MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
						clubber3_car1 = 3
					ENDIF
				ELSE
					SET_CHAR_HEED_THREATS clubber3_fm1 TRUE
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
					MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
					clubber3_car1 = 3
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
			clubber3_car1 = 3
		ENDIF
	ENDIF
	
	IF clubber3_car1 = 2
		IF NOT IS_CHAR_DEAD clubber3_fm1
			IF NOT IS_CAR_DEAD parked_car1
				IF IS_CHAR_IN_CAR clubber3_fm1 parked_car1
					SET_CAR_DRIVING_STYLE parked_car1 2
					SET_CAR_CRUISE_SPEED parked_car1 100.0
					CAR_WANDER_RANDOMLY	parked_car1
					SET_CAR_AVOID_LEVEL_TRANSITIONS parked_car1 TRUE
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
//					MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
					clubber3_car1 = 3
				ENDIF
			ELSE
				SET_CHAR_HEED_THREATS clubber3_fm1 TRUE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
				MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
				clubber3_car1 = 3
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car1
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber3_fm1
			clubber3_car1 = 3
		ENDIF
	ENDIF
ENDIF

IF clubbers_flee_flag > 4
	IF clubber5_car2 = 1
		IF NOT IS_CHAR_DEAD clubber5_fm1
			IF LOCATE_CHAR_ON_FOOT_2D clubber5_fm1 outside_warehouse_x outside_warehouse_y 3.0 3.0 0
				IF IS_CAR_STILL_ALIVE parked_car2
					IF LOCATE_CAR_2D parked_car2 1243.0 -1112.0 8.0 8.0 0
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER clubber5_fm1 parked_car2
						clubber5_car2 = 2
					ELSE
						SET_CHAR_HEED_THREATS clubber5_fm1 TRUE
						MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
						MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
						clubber5_car2 = 3
					ENDIF
				ELSE
					SET_CHAR_HEED_THREATS clubber5_fm1 TRUE
					MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
					clubber5_car2 = 3
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
			clubber5_car2 = 3
		ENDIF
	ENDIF
	
	IF clubber5_car2 = 2
		IF NOT IS_CHAR_DEAD clubber5_fm1
			IF NOT IS_CAR_DEAD parked_car2
				IF IS_CHAR_IN_CAR clubber5_fm1 parked_car2
					SET_CAR_DRIVING_STYLE parked_car2 2
					SET_CAR_CRUISE_SPEED parked_car2 100.0
					CAR_WANDER_RANDOMLY	parked_car2
					SET_CAR_AVOID_LEVEL_TRANSITIONS parked_car2 TRUE
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
//					MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
					clubber5_car2 = 3
				ENDIF
			ELSE
				SET_CHAR_HEED_THREATS clubber5_fm1 TRUE
				MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
				clubber5_car2 = 3
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car2
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber5_fm1
			clubber5_car2 = 3
		ENDIF
	ENDIF
ENDIF

IF clubbers_flee_flag > 7
	IF clubber8_car3 = 1
		IF NOT IS_CHAR_DEAD clubber8_fm1
			IF LOCATE_CHAR_ON_FOOT_2D clubber8_fm1 outside_warehouse_x outside_warehouse_y 3.0 3.0 0
				IF IS_CAR_STILL_ALIVE parked_car3
					IF LOCATE_CAR_2D parked_car3 1243.0 -1112.0 8.0 8.0 0
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER clubber8_fm1 parked_car3
						clubber8_car3 = 2
					ELSE
						SET_CHAR_HEED_THREATS clubber8_fm1 TRUE
						MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
						MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
						clubber8_car3 = 3
					ENDIF
				ELSE
					SET_CHAR_HEED_THREATS clubber8_fm1 TRUE
					MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
					clubber8_car3 = 3
				ENDIF
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
			clubber8_car3 = 3
		ENDIF
	ENDIF
	
	IF clubber8_car3 = 2
		IF NOT IS_CHAR_DEAD clubber8_fm1
			IF NOT IS_CAR_DEAD parked_car3
				IF IS_CHAR_IN_CAR clubber8_fm1 parked_car3
					SET_CAR_DRIVING_STYLE parked_car3 2
					SET_CAR_CRUISE_SPEED parked_car3 100.0
					CAR_WANDER_RANDOMLY	parked_car3
					SET_CAR_AVOID_LEVEL_TRANSITIONS parked_car3 TRUE
					MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
//					MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
					clubber8_car3 = 3
				ENDIF
			ELSE
				SET_CHAR_HEED_THREATS clubber8_fm1 TRUE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
				MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
				clubber8_car3 = 3
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber8_fm1
			MARK_CAR_AS_NO_LONGER_NEEDED parked_car3
			clubber8_car3 = 3
		ENDIF
	ENDIF
ENDIF

RETURN



clubber_idle_checks://////////////////////////////////////////////////////////////////////////////////

	IF IS_CHAR_DEAD	cop1_fm1
	AND IS_CHAR_DEAD cop2_fm1
	AND IS_CHAR_DEAD cop3_fm1
	AND IS_CHAR_DEAD cop4_fm1
	AND IS_CHAR_DEAD cop5_fm1
	AND IS_CHAR_DEAD cop6_fm1
		IF IS_CHAR_DEAD cop7_fm1
		AND IS_CHAR_DEAD cop8_fm1
			IF NOT IS_CHAR_DEAD	clubber1_fm1
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber1_fm1 player
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber1_fm1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber1_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber2_fm1
				CHAR_WANDER_DIR clubber2_fm1 -1
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber2_fm1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber2_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber4_fm1
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber4_fm1 player
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber4_fm1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber4_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber6_fm1
				CHAR_WANDER_DIR clubber6_fm1 -1
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber6_fm1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber6_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber7_fm1
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber7_fm1 player
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber7_fm1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber7_fm1
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	clubber1_fm1
				IF IS_CHAR_STOPPED clubber1_fm1
					IF NOT IS_CHAR_SHOOTING clubber1_fm1
						CHAR_WANDER_DIR clubber1_fm1 -1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber1_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber2_fm1
				IF IS_CHAR_STOPPED clubber2_fm1
					IF NOT IS_CHAR_SHOOTING clubber2_fm1
						SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber2_fm1 player
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber2_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber4_fm1
				IF IS_CHAR_STOPPED clubber4_fm1
					IF NOT IS_CHAR_SHOOTING clubber4_fm1
						CHAR_WANDER_DIR clubber4_fm1 -1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber4_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber6_fm1
				IF IS_CHAR_STOPPED clubber6_fm1
					IF NOT IS_CHAR_SHOOTING clubber6_fm1
						SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber6_fm1 player
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber6_fm1
			ENDIF
			IF NOT IS_CHAR_DEAD	clubber7_fm1
				IF IS_CHAR_STOPPED clubber7_fm1
					IF NOT IS_CHAR_SHOOTING clubber7_fm1
						CHAR_WANDER_DIR clubber7_fm1 -1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED clubber7_fm1
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CHAR_DEAD	clubber1_fm1
			IF IS_CHAR_STOPPED clubber1_fm1
				IF NOT IS_CHAR_SHOOTING clubber1_fm1
					CHAR_WANDER_DIR clubber1_fm1 -1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber1_fm1
		ENDIF
		IF NOT IS_CHAR_DEAD	clubber2_fm1
			IF IS_CHAR_STOPPED clubber2_fm1
				IF NOT IS_CHAR_SHOOTING clubber2_fm1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber2_fm1 player
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber2_fm1
		ENDIF
		IF NOT IS_CHAR_DEAD	clubber4_fm1
			IF IS_CHAR_STOPPED clubber4_fm1
				IF NOT IS_CHAR_SHOOTING clubber4_fm1
					CHAR_WANDER_DIR clubber4_fm1 -1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber4_fm1
		ENDIF
		IF NOT IS_CHAR_DEAD	clubber6_fm1
			IF IS_CHAR_STOPPED clubber6_fm1
				IF NOT IS_CHAR_SHOOTING clubber6_fm1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	clubber6_fm1 player
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber6_fm1
		ENDIF
		IF NOT IS_CHAR_DEAD	clubber7_fm1
			IF IS_CHAR_STOPPED clubber7_fm1
				IF NOT IS_CHAR_SHOOTING clubber7_fm1
					CHAR_WANDER_DIR clubber7_fm1 -1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED clubber7_fm1
		ENDIF
	ENDIF

RETURN



police_idle_checks:///////////////////////////////////////////////////////////////////////////////////

	IF NOT IS_CHAR_DEAD	cop1_fm1
		SET_CHAR_SAY cop1_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop1_fm1
			IF NOT IS_CHAR_SHOOTING cop1_fm1
				IF NOT IS_CHAR_DEAD clubber1_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop1_fm1 clubber1_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber2_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop1_fm1 clubber2_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber4_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop1_fm1 clubber4_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber6_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop1_fm1 clubber6_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber7_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop1_fm1 clubber7_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop2_fm1
		SET_CHAR_SAY cop2_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop2_fm1
			IF NOT IS_CHAR_SHOOTING cop2_fm1
				IF NOT IS_CHAR_DEAD clubber7_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop2_fm1 clubber7_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber4_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop2_fm1 clubber4_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber6_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop2_fm1 clubber6_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber2_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop2_fm1 clubber2_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber1_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop2_fm1 clubber1_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop3_fm1
		SET_CHAR_SAY cop3_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop3_fm1
			IF NOT IS_CHAR_SHOOTING cop3_fm1
				IF NOT IS_CHAR_DEAD clubber7_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop3_fm1 clubber7_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber4_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop3_fm1 clubber4_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber6_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop3_fm1 clubber6_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber2_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop3_fm1 clubber2_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber1_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop3_fm1 clubber1_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop4_fm1
		SET_CHAR_SAY cop4_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop4_fm1
			IF NOT IS_CHAR_SHOOTING cop4_fm1
				IF NOT IS_CHAR_DEAD clubber4_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop4_fm1 clubber4_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber7_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop4_fm1 clubber7_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber2_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop4_fm1 clubber2_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber6_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop4_fm1 clubber6_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber1_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop4_fm1 clubber1_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop4_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop5_fm1
		SET_CHAR_SAY cop5_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop5_fm1
			IF NOT IS_CHAR_SHOOTING cop5_fm1
				IF NOT IS_CHAR_DEAD clubber4_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop5_fm1 clubber4_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber7_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop5_fm1 clubber7_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber2_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop5_fm1 clubber2_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber6_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop5_fm1 clubber6_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber1_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop5_fm1 clubber1_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop5_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop5_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop6_fm1
		SET_CHAR_SAY cop6_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop6_fm1
			IF NOT IS_CHAR_SHOOTING cop6_fm1
				IF NOT IS_CHAR_DEAD clubber4_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop6_fm1 clubber4_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber1_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop6_fm1 clubber1_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber2_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop6_fm1 clubber2_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber7_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop6_fm1 clubber7_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber6_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop6_fm1 clubber6_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop6_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop7_fm1
		SET_CHAR_SAY cop7_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop7_fm1
			IF NOT IS_CHAR_SHOOTING cop7_fm1
				IF NOT IS_CHAR_DEAD clubber4_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop7_fm1 clubber4_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber1_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop7_fm1 clubber1_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber2_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop7_fm1 clubber2_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber7_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop7_fm1 clubber7_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber6_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop7_fm1 clubber6_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop7_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop7_fm1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	cop8_fm1
		SET_CHAR_SAY cop8_fm1 SOUND_SWAT_PED_SHOUT
		IF IS_CHAR_STOPPED cop8_fm1
			IF NOT IS_CHAR_SHOOTING cop8_fm1
				IF NOT IS_CHAR_DEAD clubber6_fm1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop8_fm1 clubber6_fm1
				ELSE
					IF NOT IS_CHAR_DEAD clubber1_fm1
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop8_fm1 clubber1_fm1
					ELSE
						IF NOT IS_CHAR_DEAD clubber2_fm1
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop8_fm1 clubber2_fm1
						ELSE
							IF NOT IS_CHAR_DEAD clubber7_fm1
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop8_fm1 clubber7_fm1
							ELSE
								IF NOT IS_CHAR_DEAD clubber4_fm1
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cop8_fm1 clubber4_fm1
								ELSE
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop8_fm1 player
									MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED cop8_fm1
	ENDIF

RETURN



draw_disco_lights:///////////////////////////////////////////////////////////////////////////////////

	++ shadow_counter
	
	IF shadow_counter > 28
	AND shadow_counter < 32
		DRAW_SHADOW SHADOW_EXPLOSION 1272.5963 -1107.4248 12.0 30.0 0.8 0 R G 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.6 13.1 R G 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R
	ENDIF
	
	IF shadow_counter > 15
	AND shadow_counter < 20
		DRAW_SHADOW SHADOW_EXPLOSION 1270.9584 -1107.6783 12.0 0.0 1.2 0 R1 G1 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.18 13.1 R1 G1 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G1
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R1
	ENDIF
	
	IF shadow_counter > 20
	AND shadow_counter < 40
		DRAW_SHADOW SHADOW_EXPLOSION 1273.3 -1107.0 12.0 80.0 1.0 0 R2 G2 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.6 12.8 R2 G2 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G2
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R2
	ENDIF
	
	IF shadow_counter > 18
	AND shadow_counter < 40
		DRAW_SHADOW SHADOW_EXPLOSION 1273.3 -1107.7 12.0 140.0 0.8 0 R3 G3 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.18 12.8 R3 G3 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G3
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R3
	ENDIF
	
	IF shadow_counter > 5
	AND shadow_counter < 14
		DRAW_SHADOW SHADOW_EXPLOSION 1271.4812 -1108.0588 12.0 235.0 1.1 0 R4 G4 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.6 12.5 R4 G4 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G4
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R4
	ENDIF

	IF shadow_counter > 9
	AND shadow_counter < 26
		DRAW_SHADOW SHADOW_EXPLOSION 1271.5570 -1107.0217 12.0 325.0 1.8 0 R5 G5 0 // ShadowType X Y Z Rotation Scale Transparency Red Green Blue
		DRAW_LIGHT 1272.45 -1107.18 12.5 R5 G5 0
	ELSE
		GENERATE_RANDOM_INT_IN_RANGE 0 101 G5
		GENERATE_RANDOM_INT_IN_RANGE 0 101 R5
	ENDIF
	
	IF shadow_counter = 40
	OR shadow_counter > 40
		shadow_counter = 0
	ENDIF

RETURN


delete_char_maria:

DELETE_CHAR maria

RETURN


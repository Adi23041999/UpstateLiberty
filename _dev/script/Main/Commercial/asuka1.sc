MISSION_START
// *****************************************************************************************
// *******************************   Asuka mission 1   ************************************* 
// ******************************* Salvatore's Sendoff *************************************
// *****************************************************************************************
// *** Salvatore will be leaving Luigi's Club in 3 hours. The player will have to kill 	 ***
// *** him before he arrives at his mansion. He will come out of the club with a very 	 ***
// *** large Mafia escort. (3 cars full and 5 extra goons) If the player is spotted 	 ***
// *** before Salvatore leaves the club, they will attack. 								 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_asuka1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_asuka1_failed
ENDIF

GOSUB mission_cleanup_asuka1 

MISSION_END

// Variables for mission

VAR_INT hours_a1 mins_a1 time_left_a1 beamer1_a1 beamer2_a1	beamer3_a1 mission_blip_am1
VAR_INT mafia_1X mafia_2X mafia_3X mafia_4X mafia_5X mafia_6X mafia_7X mafia_8X mafia_9X mafia_10X mafia_11X mafia_12X mafia_13X mafia_14X mafia_15X 
VAR_INT mafia_8_flag mafia_9_flag mafia_10_flag mafia_11_flag mafia_12_flag mafia_13_flag frankie_flag
VAR_INT set_beamer_1_kill_player set_beamer_2_kill_player set_beamer_3_kill_player 
VAR_INT beamer1_health beamer2_health beamer3_health garage_door_close timera_reset_flag_a1	timerb_reset_flag_a1 timerc_reset_flag_a1 
VAR_INT timerc_started_a1 timerc_current_a1 timerc_a1 frankies_ride	fuckers_car	beamer_1_dead_flag beamer_2_dead_flag beamer_3_dead_flag
VAR_INT players_car_a1 kill_player_now_flag	spotted_print enter_car_flag frankie_exists_flag 
VAR_INT mafia_8_kill_player_flag mafia_9_kill_player_flag mafia_10_kill_player_flag mafia_11_kill_player_flag mafia_12_kill_player_flag mafia_13_kill_player_flag
VAR_INT mafia_5_kill_player_flag mafia_7_kill_player_flag mafia_15_kill_player_flag	
VAR_INT	timerx timerx_started timerx_current timerx_reset_flag
VAR_INT	timery timery_started timery_current timery_reset_flag
VAR_INT	timerz timerz_started timerz_current timerz_reset_flag

VAR_FLOAT players_car_a1_speed	beamer1_a1_speed beamer2_a1_speed beamer3_a1_speed
VAR_FLOAT create_char_in_club_x create_char_in_club_y create_char_in_club_z bottom_of_steps_x bottom_of_steps_y mafia_10_x mafia_10_y	
VAR_FLOAT mafia_11_x mafia_11_y mafia_12_x mafia_12_y mafia_13_x mafia_13_y working_x_a1 working_y_a1 working_z_a1 beamer_heading
VAR_FLOAT street_x street_y	back_of_alley_x	back_of_alley_y	a1_x a1_y a1_z diff_heading_door
VAR_FLOAT beamer1_stuck_x beamer1_stuck_y beamer1_stuck_z beamer2_stuck_x beamer2_stuck_y beamer2_stuck_z beamer3_stuck_x beamer3_stuck_y beamer3_stuck_z

// ****************************************Mission Start************************************

mission_start_asuka1:

flag_player_on_mission 		 = 1
flag_player_on_asuka_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME asuka1

hours_a1 	  = 0
mins_a1  	  = 0
time_left_a1  = 0
mafia_8_flag  = 0
mafia_9_flag  = 0
mafia_10_flag = 0
mafia_11_flag = 0
mafia_12_flag = 0
mafia_13_flag = 0
frankie_flag  = 0
set_beamer_1_kill_player = 0
set_beamer_2_kill_player = 0
set_beamer_3_kill_player = 0
beamer1_health 		 = 0
beamer2_health  	 = 0
beamer3_health  	 = 0
garage_door_close 	 = 0
timera_reset_flag_a1 = 0
timerb_reset_flag_a1 = 0
timerc_reset_flag_a1 = 0
timerc_started_a1	 = 0
timerc_current_a1    = 0
timerc_a1			 = 0
door_crash_flag		 = 0
spotted_print		 = 0
frankies_ride 		 = 0
beamer_1_dead_flag   = 0
beamer_2_dead_flag   = 0
beamer_3_dead_flag   = 0
enter_car_flag       = 0
fuckers_car          = -1
frankie_exists_flag  = 0
mafia_5_kill_player_flag  = 0
mafia_7_kill_player_flag  = 0
mafia_8_kill_player_flag  = 0
mafia_9_kill_player_flag  = 0
mafia_10_kill_player_flag = 0
mafia_11_kill_player_flag = 0
mafia_12_kill_player_flag = 0
mafia_13_kill_player_flag = 0
mafia_15_kill_player_flag = 0
timerx_reset_flag = 0
timery_reset_flag = 0
timerz_reset_flag = 0

beamer1_stuck_x = 0.0
beamer1_stuck_y = 0.0
beamer1_stuck_z = 0.0
beamer2_stuck_x = 0.0
beamer2_stuck_y = 0.0
beamer2_stuck_z = 0.0
beamer3_stuck_x = 0.0
beamer3_stuck_y = 0.0
beamer3_stuck_z = 0.0
{
// ****************************************START OF CUTSCENE********************************

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_asuka1_failed
ENDIF

SWITCH_STREAMING OFF

PRINT_BIG AM1 15000 2
*/

LOAD_SPECIAL_CHARACTER 1 asuka
LOAD_SPECIAL_CHARACTER 2 maria
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 ASUKAH
LOAD_SPECIAL_MODEL cut_obj3 MARIAH
REQUEST_MODEL condo_ivy
REQUEST_MODEL kmricndo01

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj1
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED condo_ivy
OR NOT HAS_MODEL_LOADED	kmricndo01
	WAIT 0
ENDWHILE

LOAD_CUTSCENE A1_SS0

SET_CUTSCENE_OFFSET 523.102 -636.96 15.616

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_HEAD cs_player cut_obj1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_asuka cut_obj2 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

CREATE_CUTSCENE_HEAD cs_maria cut_obj3 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead maria

CLEAR_AREA 523.6 -639.4 16.6 1.0 TRUE
SET_PLAYER_COORDINATES player 523.6 -639.4 16.0

SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

SWITCH_RUBBISH OFF
//SWITCH_STREAMING OFF
// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5353
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_A 15000 1

WHILE cs_time < 9624
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_B 15000 1

WHILE cs_time < 13409
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_C 15000 1

WHILE cs_time < 17788
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_D 15000 1

WHILE cs_time < 20113
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_E 15000 1

WHILE cs_time < 25303
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

GET_TIME_OF_DAY hours_a1 mins_a1

hours_a1 = hours_a1 + 3 // 3 HOURS UNTIL FRANKIE LEAVES THE CLUB
IF hours_a1 > 23
	hours_a1 = hours_a1 - 24
ENDIF

mins_a1 = 30

IF hours_a1 > 9
	PRINT_WITH_2_NUMBERS_NOW AM1_F hours_a1 mins_a1 15000 1// "Salvatore Leon will be leaving Luigi's at about ~1~:~1~."
ELSE
	PRINT_WITH_2_NUMBERS_NOW AM1_K hours_a1 mins_a1 15000 1// "Salvatore Leon will be leaving Luigi's at about 0~1~:~1~."
ENDIF

WHILE cs_time < 29629
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_G 15000 1

WHILE cs_time < 32657
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_H 15000 1

WHILE cs_time < 37360
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_I 15000 1

WHILE cs_time < 40118
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW AM1_J 15000 1

WHILE cs_time < 41666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON
SWITCH_RUBBISH ON

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED condo_ivy
MARK_MODEL_AS_NO_LONGER_NEEDED kmricndo01
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3

// ******************************************END OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 frankie
REQUEST_MODEL PED_GANG_MAFIA_A
REQUEST_MODEL PED_GANG_MAFIA_B
REQUEST_MODEL CAR_MAFIA

WHILE NOT HAS_MODEL_LOADED CAR_MAFIA
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_A
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

create_char_in_club_x =	894.0//894.3
create_char_in_club_y =	-417.0//-415.78
create_char_in_club_z =	15.3

ADD_BLIP_FOR_COORD create_char_in_club_x create_char_in_club_y create_char_in_club_z mission_blip_am1

bottom_of_steps_x =	885.53
bottom_of_steps_y =	-417.0

back_of_alley_x = 886.03
back_of_alley_y = -425.77

street_x = 902.72
street_y = -425.65

mafia_10_x = 902.72  - 1.0
mafia_10_y = -425.65 + 3.0

mafia_11_x = 902.72  + 1.0
mafia_11_y = -425.65 + 3.0

mafia_12_x = 902.72  + 1.0
mafia_12_y = -425.65 - 2.0

mafia_13_x = 902.72  - 1.0
mafia_13_y = -425.65 - 2.0

mafia_8_flag  =	0
mafia_9_flag  =	0
mafia_10_flag =	0
mafia_11_flag =	0
mafia_12_flag =	0
mafia_13_flag =	0
kill_player_now_flag = 0

PRINT_NOW AM1_5 5000 1//"Get to the Red Light District and wait for Salvatore to leave the club."
IF hours_a1 > 9
	PRINT_WITH_2_NUMBERS_SOON AM1_8 hours_a1 mins_a1 5000 1//"Salvatore will be leaving at about ~1~:~1~"
ELSE
	PRINT_WITH_2_NUMBERS_SOON AM1_10 hours_a1 mins_a1 5000 1//"Salvatore will be leaving at about 0~1~:~1~"
ENDIF

//IF ammu2_blip_added = 0
//	ADD_SPRITE_BLIP_FOR_COORD 345.5 -713.5 26.1 RADAR_SPRITE_WEAPON ammu_nation2
//	ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY sprayshop2_blip
//	ammu2_blip_added = 1
//ENDIF

GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1

WHILE NOT time_left_a1 < 1
	
	WAIT 0

	GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1

	IF garage_door_close = 0
		IF IS_PLAYER_IN_ZONE player REDLIGH
			PRINT_NOW AM1_6 5000 1//"Don't hang around Luigi's club, or the Mafia will spot you"
			REMOVE_BLIP mission_blip_am1
			garage_door_close = 1
		ENDIF
	ENDIF
	
ENDWHILE

IF garage_door_close = 0
	IF IS_PLAYER_IN_ZONE player REDLIGH
		PRINT_NOW AM1_6 5000 1//"Don't hang around Luigi's club, or the Mafia will spot you"
		REMOVE_BLIP mission_blip_am1
		garage_door_close = 1
	ENDIF
ENDIF
GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	WAIT 0
	
	GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1

	IF time_left_a1 < 1
		PRINT_NOW AM1_3 5000 1 //"You've missed Salvatore!"
		GOTO mission_asuka1_failed
	ENDIF

ENDWHILE

SWITCH_ROADS_OFF 905.0 -448.6 12.0 916.0 -393.0 20.0
CHANGE_GARAGE_TYPE frankie_garage GARAGE_MISSION

IF NOT LOCATE_PLAYER_ANY_MEANS_2D player 908.3 -86.0 100.0 100.0 0
	working_x_a1 = 908.3 
	working_y_a1 = -86.0
	working_z_a1 = 7.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer1_a1
	GET_CAR_HEADING	beamer1_a1 beamer_heading
	beamer_heading = beamer_heading - 180.0
	SET_CAR_HEADING beamer1_a1	beamer_heading
	LOCK_CAR_DOORS beamer1_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer1_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer1_a1 TRUE
	
	working_y_a1 = working_y_a1 + 11.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer2_a1
	SET_CAR_HEADING beamer2_a1	beamer_heading
	LOCK_CAR_DOORS beamer2_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer2_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer2_a1 TRUE

	working_y_a1 = working_y_a1 + 11.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer3_a1
	SET_CAR_HEADING beamer3_a1	beamer_heading
	LOCK_CAR_DOORS beamer3_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer3_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer3_a1 TRUE
		
ELSE
	working_x_a1 = 1123.67
	working_y_a1 = -59.3
	working_z_a1 = 7.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer3_a1
	GET_CAR_HEADING	beamer3_a1 beamer_heading
	beamer_heading = beamer_heading - 180.0
	SET_CAR_HEADING beamer3_a1	beamer_heading
	LOCK_CAR_DOORS beamer3_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer3_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer3_a1 TRUE

	working_y_a1 = working_y_a1 - 11.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer2_a1
	SET_CAR_HEADING beamer2_a1	beamer_heading
	LOCK_CAR_DOORS beamer2_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer2_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer2_a1 TRUE

	working_y_a1 = working_y_a1 - 11.0
	CREATE_CAR CAR_MAFIA working_x_a1 working_y_a1 working_z_a1 beamer1_a1
	SET_CAR_HEADING beamer1_a1	beamer_heading
	LOCK_CAR_DOORS beamer1_a1 CARLOCK_LOCKOUT_PLAYER_ONLY
	SET_CAR_ONLY_DAMAGED_BY_PLAYER beamer1_a1 TRUE
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED beamer1_a1 TRUE
ENDIF

CREATE_CHAR_INSIDE_CAR beamer1_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B mafia_1X
CREATE_CHAR_INSIDE_CAR beamer2_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A mafia_2X
CREATE_CHAR_INSIDE_CAR beamer3_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A mafia_3X
CREATE_CHAR_AS_PASSENGER beamer3_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 0 mafia_4X
CREATE_CHAR_AS_PASSENGER beamer3_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B 1 mafia_5X
CREATE_CHAR_AS_PASSENGER beamer1_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B 0 mafia_6X
CREATE_CHAR_AS_PASSENGER beamer1_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A 1 mafia_7X
CREATE_CHAR_AS_PASSENGER beamer2_a1 PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B 0 mafia_14X
SET_CHAR_THREAT_SEARCH mafia_1X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_2X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_3X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_4X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_5X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_6X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_7X THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH mafia_14X THREAT_PLAYER1
SET_CHAR_PERSONALITY mafia_1X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_2X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_3X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_4X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_5X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_6X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_7X PEDSTAT_TOUGH_GUY
SET_CHAR_PERSONALITY mafia_14X PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR mafia_1X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_2X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_3X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_4X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_5X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_6X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_7X WEAPONTYPE_UZI 999
GIVE_WEAPON_TO_CHAR mafia_14X WEAPONTYPE_UZI 999

working_x_a1 = 908.0 
working_y_a1 = -435.5
working_z_a1 = 14.56
CAR_GOTO_COORDINATES beamer1_a1 working_x_a1 working_y_a1 working_z_a1

working_y_a1 = working_y_a1 + 7.0
CAR_GOTO_COORDINATES beamer2_a1 working_x_a1 working_y_a1 working_z_a1

working_y_a1 = working_y_a1 + 7.0
CAR_GOTO_COORDINATES beamer3_a1 working_x_a1 working_y_a1 working_z_a1

SET_CAR_DRIVING_STYLE beamer1_a1 2
SET_CAR_DRIVING_STYLE beamer2_a1 2
SET_CAR_DRIVING_STYLE beamer3_a1 2
SET_CAR_CRUISE_SPEED beamer1_a1 15.0
SET_CAR_CRUISE_SPEED beamer2_a1 14.0
SET_CAR_CRUISE_SPEED beamer3_a1 13.0

IF DOES_OBJECT_EXIST backdoor
	GET_OBJECT_HEADING backdoor door_position_a1
ENDIF

LOAD_MISSION_AUDIO A1_A
 
IF NOT IS_PLAYER_IN_AREA_2D player 873.0 -443.0 927.0 -378.0 0
	SET_PLAYER_CONTROL player OFF
	SET_EVERYONE_IGNORE_PLAYER player ON
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	IF IS_PLAYER_IN_ANY_CAR player
		APPLY_BRAKES_TO_PLAYERS_CAR player ON
	ENDIF
	SET_FADING_COLOUR 0 0 0
	DO_FADE 0 FADE_OUT
	WAIT 0
//	DO_FADE 250 FADE_OUT
//	WHILE GET_FADING_STATUS
//		WAIT 0
//	ENDWHILE
	SWITCH_WIDESCREEN ON
	CLEAR_AREA 905.759 -419.944 8.0 8.0 FALSE
	REQUEST_MODEL indhibuild3
	REQUEST_MODEL luigiclubout
	REQUEST_MODEL luigiineerclub
	REQUEST_MODEL ind_customroad016
	LOAD_ALL_MODELS_NOW
	SWITCH_STREAMING OFF
	SET_FIXED_CAMERA_POSITION 881.36 -425.198 19.727 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 882.109 -424.825 19.181 JUMP_CUT
	TIMERB = 0
	beamer1_health = 1
ENDIF

TIMERA = 0
skip_flag = 0

WHILE mafia_8_flag < 3
OR mafia_9_flag < 3 
OR mafia_10_flag < 3
OR mafia_11_flag < 3
OR mafia_12_flag < 3
OR mafia_13_flag < 3

	WAIT 0

	IF beamer1_health = 1
		IF TIMERB > 30000
			SWITCH_WIDESCREEN OFF
			SET_PLAYER_CONTROL player ON
			SET_EVERYONE_IGNORE_PLAYER player OFF
			SET_ALL_CARS_CAN_BE_DAMAGED TRUE
			SWITCH_STREAMING ON
			IF IS_PLAYER_IN_ANY_CAR player
				APPLY_BRAKES_TO_PLAYERS_CAR player OFF
			ENDIF
			RESTORE_CAMERA_JUMPCUT
			MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3
			MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout
			MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub
			MARK_MODEL_AS_NO_LONGER_NEEDED ind_customroad016
			DO_FADE 250 FADE_IN
			skip_flag = 2
			beamer1_health = 0
		ENDIF

		IF skip_flag = 0
			IF NOT IS_BUTTON_PRESSED PAD1 CROSS
			AND NOT IS_BUTTON_PRESSED PAD1 START
				skip_flag = 1
			ENDIF
		ENDIF

		IF skip_flag = 1
			IF IS_BUTTON_PRESSED PAD1 CROSS
			OR IS_BUTTON_PRESSED PAD1 START
				SWITCH_WIDESCREEN OFF
				SET_PLAYER_CONTROL player ON
				SET_EVERYONE_IGNORE_PLAYER player OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SWITCH_STREAMING ON
				IF IS_PLAYER_IN_ANY_CAR player
					APPLY_BRAKES_TO_PLAYERS_CAR player OFF
				ENDIF
				RESTORE_CAMERA_JUMPCUT
				MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3
				MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout
				MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub
				MARK_MODEL_AS_NO_LONGER_NEEDED ind_customroad016
				DO_FADE 250 FADE_IN
				beamer1_health = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT time_left_a1 = 0
		GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1
	ENDIF
	
	IF garage_door_close = 0
		IF IS_PLAYER_IN_ZONE player REDLIGH
			PRINT_NOW AM1_6 5000 1//"Don't hang around Luigi's club, or the Mafia will spot you"
			REMOVE_BLIP mission_blip_am1
			garage_door_close = 1
		ENDIF
	ENDIF

//____CREATE MAFIA 8 TO GUARD THE STEPS____//

	IF NOT door_position_a1 = 90.0
		diff_heading_door = 90.0 - door_position_a1
		IF diff_heading_door < 10.0
			door_position_a1 = 90.0
		ELSE
			door_position_a1 += 10.0
		ENDIF
		SET_OBJECT_HEADING backdoor door_position_a1
		door_crash_flag = 1
	ENDIF

	IF mafia_8_flag = 0
		CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_8X	
		//SET_CHAR_THREAT_SEARCH mafia_8X THREAT_PLAYER1
		SET_CHAR_PERSONALITY mafia_8X PEDSTAT_TOUGH_GUY
		//SET_CHAR_HEED_THREATS mafia_8X TRUE
		GIVE_WEAPON_TO_CHAR mafia_8X WEAPONTYPE_UZI 999
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_8X bottom_of_steps_x bottom_of_steps_y
		mafia_8_flag = 1
	ELSE
		IF IS_CHAR_DEAD mafia_8X
			kill_player_now_flag = 1
			mafia_8_flag = 4
		ENDIF
	ENDIF
		
	IF mafia_8_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_8X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_8X 887.6 -418.5
			mafia_8_flag = 2
		ENDIF
	ENDIF

	IF mafia_8_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_8X 887.6 -418.5 0.5 0.5 0
			SET_CHAR_HEADING mafia_8X 90.0
			CHAR_SET_IDLE mafia_8X
			mafia_8_flag = 3
		ENDIF
	ENDIF

	IF mafia_8_flag > 0
	AND mafia_8_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_8X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0 // ON HIGHER ROOF ABOVE THE ALLEY
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//____CREATE MAFIA 9 TO GUARD THE STEPS____//

	IF mafia_8_flag > 0
	AND mafia_9_flag = 0
		IF IS_CHAR_DEAD	mafia_8X
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_9X	
			IF beamer1_health = 1
				DO_FADE 400 FADE_IN
			ENDIF
			//SET_CHAR_THREAT_SEARCH mafia_9X THREAT_PLAYER1
			SET_CHAR_PERSONALITY mafia_9X PEDSTAT_TOUGH_GUY
			//SET_CHAR_HEED_THREATS mafia_9X TRUE
			GIVE_WEAPON_TO_CHAR mafia_9X WEAPONTYPE_UZI 999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_9X bottom_of_steps_x bottom_of_steps_y
			mafia_9_flag = 1
		ELSE
			IF NOT LOCATE_CHAR_ON_FOOT_2D mafia_8X create_char_in_club_x create_char_in_club_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_9X	
				IF beamer1_health = 1
					DO_FADE 400 FADE_IN
				ENDIF
				//SET_CHAR_THREAT_SEARCH mafia_9X THREAT_PLAYER1
				SET_CHAR_PERSONALITY mafia_9X PEDSTAT_TOUGH_GUY
				//SET_CHAR_HEED_THREATS mafia_9X TRUE
				GIVE_WEAPON_TO_CHAR mafia_9X WEAPONTYPE_UZI 999
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_9X bottom_of_steps_x bottom_of_steps_y
				mafia_9_flag = 1
			ENDIF
		ENDIF
	ELSE
		IF mafia_9_flag > 0
			IF IS_CHAR_DEAD mafia_9X
				kill_player_now_flag = 1
				mafia_9_flag = 4
			ENDIF
		ENDIF
	ENDIF
	
		
	IF mafia_9_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_9X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_9X 887.6 -415.3
			mafia_9_flag = 2
		ENDIF
	ENDIF

	IF mafia_9_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_9X 887.6 -415.3 0.5 0.5 0
			SET_CHAR_HEADING mafia_9X 90.0
			CHAR_SET_IDLE mafia_9X
			mafia_9_flag = 3
		ENDIF
	ENDIF

	IF mafia_9_flag > 0
	AND mafia_9_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_9X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//___CREATE MAFIA 10 TO GUARD THE ALLEY____//

	IF mafia_9_flag > 0
	AND mafia_10_flag = 0
		IF IS_CHAR_DEAD mafia_9X
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_10X	
			SET_CHAR_THREAT_SEARCH mafia_10X THREAT_PLAYER1
			SET_CHAR_PERSONALITY mafia_10X PEDSTAT_TOUGH_GUY
			//SET_CHAR_HEED_THREATS mafia_10X TRUE
			GIVE_WEAPON_TO_CHAR mafia_10X WEAPONTYPE_UZI 999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_10X bottom_of_steps_x bottom_of_steps_y
			mafia_10_flag = 1
		ELSE
			IF NOT LOCATE_CHAR_ON_FOOT_2D mafia_9X create_char_in_club_x create_char_in_club_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_10X	
				SET_CHAR_THREAT_SEARCH mafia_10X THREAT_PLAYER1
				SET_CHAR_PERSONALITY mafia_10X PEDSTAT_TOUGH_GUY
				//SET_CHAR_HEED_THREATS mafia_10X TRUE
				GIVE_WEAPON_TO_CHAR mafia_10X WEAPONTYPE_SHOTGUN 999
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_10X bottom_of_steps_x bottom_of_steps_y
				mafia_10_flag = 1
			ENDIF
		ENDIF
	ELSE
		IF mafia_10_flag > 0
			IF IS_CHAR_DEAD mafia_10X
				kill_player_now_flag = 1
				mafia_10_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF mafia_10_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_10X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_10X mafia_10_x mafia_10_y
			mafia_10_flag = 2
		ENDIF
	ENDIF

	IF mafia_10_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_10X mafia_10_x mafia_10_y 0.5 0.5 0
			SET_CHAR_HEADING mafia_10X 0.0
			CHAR_SET_IDLE mafia_10X
			mafia_10_flag = 3
		ENDIF
	ENDIF

	IF mafia_10_flag > 0
	AND mafia_10_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_10X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//___CREATE MAFIA 11 TO GUARD THE ALLEY____//

	IF mafia_10_flag > 0
	AND mafia_11_flag = 0
		IF IS_CHAR_DEAD mafia_10X
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_11X	
			SET_CHAR_THREAT_SEARCH mafia_11X THREAT_PLAYER1
			SET_CHAR_PERSONALITY mafia_11X PEDSTAT_TOUGH_GUY
			//SET_CHAR_HEED_THREATS mafia_11X TRUE
			GIVE_WEAPON_TO_CHAR mafia_11X WEAPONTYPE_SHOTGUN 999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_11X bottom_of_steps_x bottom_of_steps_y
			mafia_11_flag = 1
		ELSE
			IF NOT LOCATE_CHAR_ON_FOOT_2D mafia_10X create_char_in_club_x create_char_in_club_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_11X	
				SET_CHAR_THREAT_SEARCH mafia_11X THREAT_PLAYER1
				SET_CHAR_PERSONALITY mafia_11X PEDSTAT_TOUGH_GUY
				//SET_CHAR_HEED_THREATS mafia_11X TRUE
				GIVE_WEAPON_TO_CHAR mafia_11X WEAPONTYPE_SHOTGUN 999
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_11X bottom_of_steps_x bottom_of_steps_y
				mafia_11_flag = 1
			ENDIF
		ENDIF
	ELSE
		IF mafia_11_flag > 0
			IF IS_CHAR_DEAD mafia_11X
				kill_player_now_flag = 1
				mafia_11_flag = 4
			ENDIF
		ENDIF
	ENDIF


	IF mafia_11_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_11X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_11X mafia_11_x mafia_11_y
			mafia_11_flag = 2
		ENDIF
	ENDIF

	IF mafia_11_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_11X mafia_11_x mafia_11_y 0.5 0.5 0
			SET_CHAR_HEADING mafia_11X 0.0
			CHAR_SET_IDLE mafia_11X
			mafia_11_flag = 3
		ENDIF
	ENDIF

	IF mafia_11_flag > 0
	AND mafia_11_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_11X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//___CREATE MAFIA 12 TO GUARD THE ALLEY____//

	IF mafia_11_flag > 0
	AND mafia_12_flag = 0
		IF IS_CHAR_DEAD mafia_11X
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_12X	
			SET_CHAR_THREAT_SEARCH mafia_12X THREAT_PLAYER1
			SET_CHAR_PERSONALITY mafia_12X PEDSTAT_TOUGH_GUY
			//SET_CHAR_HEED_THREATS mafia_12X TRUE
			GIVE_WEAPON_TO_CHAR mafia_12X WEAPONTYPE_UZI 999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_12X bottom_of_steps_x bottom_of_steps_y
			mafia_12_flag = 1
		ELSE
			IF NOT LOCATE_CHAR_ON_FOOT_2D mafia_11X create_char_in_club_x create_char_in_club_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_12X	
				SET_CHAR_THREAT_SEARCH mafia_12X THREAT_PLAYER1
				SET_CHAR_PERSONALITY mafia_12X PEDSTAT_TOUGH_GUY
				//SET_CHAR_HEED_THREATS mafia_12X TRUE
				GIVE_WEAPON_TO_CHAR mafia_12X WEAPONTYPE_SHOTGUN 999
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_12X bottom_of_steps_x bottom_of_steps_y
				mafia_12_flag = 1
			ENDIF
		ENDIF
	ELSE
		IF mafia_12_flag > 0
			IF IS_CHAR_DEAD mafia_12X
				kill_player_now_flag = 1
				mafia_12_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF mafia_12_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_12X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_12X mafia_12_x mafia_12_y
			mafia_12_flag = 2
		ENDIF
	ENDIF

	IF mafia_12_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_12X mafia_12_x mafia_12_y 0.5 0.5 0
			SET_CHAR_HEADING mafia_12X 180.0
			CHAR_SET_IDLE mafia_12X
			mafia_12_flag = 3
		ENDIF
	ENDIF

	IF mafia_12_flag > 0
	AND mafia_12_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_12X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//___CREATE MAFIA 13 TO GUARD THE ALLEY____//

	IF mafia_12_flag > 0
	AND mafia_13_flag = 0
		IF IS_CHAR_DEAD mafia_12X
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_13X	
			SET_CHAR_THREAT_SEARCH mafia_13X THREAT_PLAYER1
			SET_CHAR_PERSONALITY mafia_13X PEDSTAT_TOUGH_GUY
			//SET_CHAR_HEED_THREATS mafia_13X TRUE
			GIVE_WEAPON_TO_CHAR mafia_13X WEAPONTYPE_SHOTGUN 999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_13X bottom_of_steps_x bottom_of_steps_y
			mafia_13_flag = 1
		ELSE
			IF NOT LOCATE_CHAR_ON_FOOT_2D mafia_12X create_char_in_club_x create_char_in_club_y 2.0 2.0 0
				CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_A create_char_in_club_x create_char_in_club_y create_char_in_club_z mafia_13X	
			  	SET_CHAR_THREAT_SEARCH mafia_13X THREAT_PLAYER1
				SET_CHAR_PERSONALITY mafia_13X PEDSTAT_TOUGH_GUY
				//SET_CHAR_HEED_THREATS mafia_13X TRUE
				GIVE_WEAPON_TO_CHAR mafia_13X WEAPONTYPE_SHOTGUN 999
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	mafia_13X bottom_of_steps_x bottom_of_steps_y
				mafia_13_flag = 1
			ENDIF
		ENDIF
	ELSE
		IF mafia_13_flag > 0
			IF IS_CHAR_DEAD mafia_13X
				kill_player_now_flag = 1
				mafia_13_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF mafia_13_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D mafia_13X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_13X mafia_13_x mafia_13_y
			IF beamer1_health = 1
				SWITCH_WIDESCREEN OFF
				SET_PLAYER_CONTROL player ON
				SET_EVERYONE_IGNORE_PLAYER player OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SWITCH_STREAMING ON
				IF IS_PLAYER_IN_ANY_CAR player
					APPLY_BRAKES_TO_PLAYERS_CAR player OFF
				ENDIF
				RESTORE_CAMERA_JUMPCUT
				MARK_MODEL_AS_NO_LONGER_NEEDED indhibuild3
				MARK_MODEL_AS_NO_LONGER_NEEDED luigiclubout
				MARK_MODEL_AS_NO_LONGER_NEEDED luigiineerclub
				MARK_MODEL_AS_NO_LONGER_NEEDED ind_customroad016
				beamer1_health = 0
			ENDIF 
			mafia_13_flag = 2
		ENDIF
	ENDIF

	IF mafia_13_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_13X mafia_13_x mafia_13_y 0.5 0.5 0
			SET_CHAR_HEADING mafia_13X 180.0
			CHAR_SET_IDLE mafia_13X
			mafia_13_flag = 3
		ENDIF
	ENDIF

	IF mafia_13_flag > 0
	AND mafia_13_flag < 4
		IF HAS_CHAR_SPOTTED_PLAYER mafia_13X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//________CHECK IF THERE IS A CAR AT THE END OF THE ALLEY IF THERE IS ONE OF THE MAFIA WILL MOVE IT_______//

	IF fuckers_car < 1
		GET_RANDOM_CAR_OF_TYPE_IN_AREA 900.467 -431.884 905.759 -419.944 -1 fuckers_car
	ENDIF

	
	IF IS_CAR_DEAD fuckers_car
//		IF NOT fuckers_car = -1
//			IF NOT enter_car_flag = 0
				MARK_CAR_AS_NO_LONGER_NEEDED fuckers_car
				fuckers_car = -1
				enter_car_flag = 0
//			ENDIF
//		ENDIF
	ENDIF

	IF enter_car_flag < 5
		IF NOT fuckers_car = -1
			IF fuckers_car = beamer1_a1
				IF NOT IS_CAR_DEAD beamer1_a1
					CAR_GOTO_COORDINATES_ACCURATE beamer1_a1 904.9 -434.1 15.0
				ELSE
					DELETE_CAR beamer1_a1
				ENDIF
			ELSE
				IF fuckers_car = beamer2_a1
					IF NOT IS_CAR_DEAD beamer2_a1
						CAR_GOTO_COORDINATES_ACCURATE beamer2_a1 904.9 -434.1 15.0
					ELSE
						DELETE_CAR beamer2_a1
					ENDIF
				ELSE
					IF fuckers_car = beamer3_a1
						IF NOT IS_CAR_DEAD beamer3_a1
							CAR_GOTO_COORDINATES_ACCURATE beamer3_a1 904.9 -434.1 15.0
						ELSE
							DELETE_CAR beamer3_a1
						ENDIF
					ELSE
						IF mafia_10_flag < 4
							IF mafia_10_flag > 1
								IF LOCATE_CHAR_ON_FOOT_CAR_2D mafia_10X fuckers_car 4.0 4.0 0
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER mafia_10X fuckers_car
									TIMERA = 0
									enter_car_flag = 10
								ENDIF
							ENDIF
						ELSE
							IF mafia_11_flag < 4
								IF mafia_11_flag > 1
									IF LOCATE_CHAR_ON_FOOT_CAR_2D mafia_11X fuckers_car 4.0 4.0 0
										SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER mafia_11X fuckers_car
										TIMERA = 0
										enter_car_flag = 11
									ENDIF
								ENDIF
							ELSE
								IF mafia_12_flag < 4
									IF mafia_12_flag > 1
										IF LOCATE_CHAR_ON_FOOT_CAR_2D mafia_12X fuckers_car 4.0 4.0 0
											SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER mafia_12X fuckers_car
											TIMERA = 0
											enter_car_flag = 12
										ENDIF
									ENDIF
								ELSE
									IF mafia_13_flag < 4
										IF mafia_13_flag > 1
											IF LOCATE_CHAR_ON_FOOT_CAR_2D mafia_13X fuckers_car 4.0 4.0 0
												SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER mafia_13X fuckers_car
												TIMERA = 0
												enter_car_flag = 13
											ENDIF
										ENDIF
									ELSE
										IF IS_CAR_DEAD fuckers_car
											MARK_CAR_AS_NO_LONGER_NEEDED fuckers_car
											kill_player_now_flag = 1
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF enter_car_flag = 10
		IF IS_CHAR_IN_CAR mafia_10X fuckers_car
			GOSUB move_fuckers_car
			mafia_10_flag = 4
			enter_car_flag = 5
		ENDIF
	ENDIF
	
	IF enter_car_flag = 11
		IF IS_CHAR_IN_CAR mafia_11X fuckers_car
			GOSUB move_fuckers_car
			mafia_11_flag = 4
			enter_car_flag = 5
		ENDIF
	ENDIF
	
	IF enter_car_flag = 12
		IF IS_CHAR_IN_CAR mafia_12X fuckers_car
			GOSUB move_fuckers_car
			mafia_12_flag = 4
			enter_car_flag = 5
		ENDIF
	ENDIF
	
	IF enter_car_flag = 13
		IF IS_CHAR_IN_CAR mafia_13X fuckers_car
			GOSUB move_fuckers_car
			mafia_13_flag = 4
			enter_car_flag = 5
		ENDIF
	ENDIF

	IF enter_car_flag > 9
		IF TIMERA > 20000
			IF NOT IS_CAR_DEAD fuckers_car
				IF NOT IS_PLAYER_IN_CAR player fuckers_car
					MARK_CAR_AS_NO_LONGER_NEEDED fuckers_car
					enter_car_flag = 0
					fuckers_car = -1
				ELSE
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF TIMERA > 180000
		frankie_exists_flag = 1
	ENDIF
//________________________________________________________________________________________________________//

	IF kill_player_now_flag = 1
		GOSUB kill_player_now_script
	ENDIF

	IF NOT frankie_exists_flag = 0
		GOTO create_salvatore
	ENDIF

ENDWHILE

IF frankie_exists_flag = 0
	IF IS_PLAYER_IN_AREA_2D player 878.79 -427.4 890.77 -403.89 0 //BACK OF CLUB
	OR IS_PLAYER_IN_AREA_2D player 878.79 -433.86 890.77 -427.4 0 //LOWER ROOF
		frankie_exists_flag = 2
	ELSE
		frankie_exists_flag = 1
	ENDIF
ENDIF

create_salvatore:

IF frankie_exists_flag = 1
	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 create_char_in_club_x create_char_in_club_y create_char_in_club_z frankie
	IF kill_player_now_flag = 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT frankie bottom_of_steps_x bottom_of_steps_y
	ELSE
		SET_CHAR_OBJ_RUN_TO_COORD frankie bottom_of_steps_x bottom_of_steps_y
	ENDIF
ENDIF

IF frankie_exists_flag = 2
	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 900.2028 -416.9139 14.0 frankie // OUT FRONT OF CLUB
	SET_CHAR_OBJ_RUN_TO_COORD frankie street_x street_y
	frankie_flag = 5
ENDIF

IF frankie_exists_flag = 3
	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 884.6421 -422.9535 14.0 frankie //CLOSER TO END OF ALLEY
	SET_CHAR_OBJ_RUN_TO_COORD frankie street_x street_y
	frankie_flag = 5
ENDIF

SET_CHAR_THREAT_SEARCH frankie THREAT_PLAYER1
SET_CHAR_PERSONALITY frankie PEDSTAT_GEEK_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER frankie TRUE

REMOVE_BLIP mission_blip_am1
ADD_BLIP_FOR_CHAR frankie mission_blip_am1
PRINT_NOW AM1_1 5000 1//"Salvatore is now leaving Luigi's"

garage_door_close = 0

WHILE NOT IS_CHAR_IN_ANY_CAR frankie
	
	WAIT 0

	IF IS_CHAR_DEAD frankie
		GOTO mission_asuka1_passed
	ENDIF

	IF NOT time_left_a1 = 0
		GET_MINUTES_TO_TIME_OF_DAY hours_a1 mins_a1 time_left_a1
	ENDIF
	
	IF HAS_CHAR_SPOTTED_PLAYER frankie player
		kill_player_now_flag = 1
	ENDIF

//___IF MAFIA HAVE SPOTTED THE PLAYER, MAKE FRANKIE RUN____//

	IF NOT IS_CHAR_DEAD mafia_8X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_8X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_8_flag = 4
	ENDIF

	IF NOT IS_CHAR_DEAD mafia_9X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_9X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_9_flag = 4
	ENDIF

	IF NOT IS_CHAR_DEAD mafia_10X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_10X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_10_flag = 4
	ENDIF

	IF NOT IS_CHAR_DEAD mafia_11X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_11X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_11_flag = 4
	ENDIF

	IF NOT IS_CHAR_DEAD mafia_12X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_12X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_12_flag = 4
	ENDIF

	IF NOT IS_CHAR_DEAD mafia_13X
		IF HAS_CHAR_SPOTTED_PLAYER mafia_13X player
			IF NOT IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0
				IF NOT IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
					kill_player_now_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		kill_player_now_flag = 1
		mafia_13_flag = 4
	ENDIF

	IF kill_player_now_flag = 1
		GOSUB kill_player_now_script
	ENDIF


//___GET FRANKIE INTO A CAR, IF ALL CARS ARE DEAD FRANKIE RUNS BACK____//

	IF IS_CAR_DEAD beamer1_a1
		beamer_1_dead_flag = 1
	ENDIF

	IF IS_CAR_DEAD beamer2_a1
		beamer_2_dead_flag = 1
	ENDIF
	
	IF IS_CAR_DEAD beamer3_a1
		beamer_3_dead_flag = 1
	ENDIF

	IF frankie_flag = 0
		IF LOCATE_CHAR_ON_FOOT_2D frankie bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			IF kill_player_now_flag = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT frankie street_x street_y
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD frankie street_x street_y
			ENDIF
			frankie_flag = 5
		ENDIF
	ENDIF
	
	IF frankie_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D frankie street_x street_y 1.0 1.0 0
			IF beamer_2_dead_flag = 0
			AND LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer2_a1 30.0 30.0 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer2_a1
				frankie_flag = 2
			ELSE
				IF beamer_3_dead_flag = 0
				AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer3_a1 30.0 30.0 0
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer3_a1
					frankie_flag = 3
				ELSE
					IF beamer_1_dead_flag = 0
					AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer1_a1 30.0 30.0 0
						SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer1_a1
						frankie_flag = 1
					ELSE
						SET_CHAR_OBJ_RUN_TO_COORD frankie bottom_of_steps_x bottom_of_steps_y
						frankie_flag = 4
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF frankie_flag = 2
		IF beamer_2_dead_flag = 1
			IF beamer_1_dead_flag = 0
			AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer1_a1 30.0 30.0 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer1_a1
				frankie_flag = 1
			ELSE
				IF beamer_3_dead_flag = 0
				AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer3_a1 30.0 30.0 0
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer3_a1
					frankie_flag = 3
				ELSE
					SET_CHAR_OBJ_RUN_TO_COORD frankie bottom_of_steps_x bottom_of_steps_y
					frankie_flag = 4
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF frankie_flag = 3
		IF beamer_3_dead_flag = 1
			IF beamer_1_dead_flag = 0
			AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer1_a1 30.0 30.0 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer1_a1
				frankie_flag = 1
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD frankie bottom_of_steps_x bottom_of_steps_y
				frankie_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF frankie_flag = 1
		IF beamer_1_dead_flag = 1
			IF beamer_3_dead_flag = 0
			AND	LOCATE_CHAR_ON_FOOT_CAR_2D frankie beamer3_a1 30.0 30.0 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER frankie	beamer3_a1
				frankie_flag = 3
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD frankie bottom_of_steps_x bottom_of_steps_y
				frankie_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF frankie_flag = 4
		IF LOCATE_CHAR_ON_FOOT_2D frankie bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD frankie create_char_in_club_x create_char_in_club_y
			frankie_flag = 6
		ENDIF
	ENDIF

	IF frankie_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D frankie create_char_in_club_x create_char_in_club_y 1.0 1.0 0
			DELETE_CHAR frankie
			PRINT_NOW AM1_9 5000 1//"Salvatore has escaped back into Luigi's Club!"
			GOTO mission_asuka1_failed
		ENDIF
	ENDIF

ENDWHILE


IF NOT IS_CAR_DEAD beamer1_a1
	
	IF frankie_flag = 1
		CAR_GOTO_COORDINATES beamer1_a1 1438.0 -183.4 50.5
		SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage beamer1_a1
	ELSE
		CAR_GOTO_COORDINATES beamer1_a1 1423.7 -168.1 50.2
	ENDIF

	IF kill_player_now_flag = 0
		SET_CAR_CRUISE_SPEED beamer1_a1 18.0
	ELSE
		SET_CAR_CRUISE_SPEED beamer1_a1 43.0
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD beamer2_a1
	
	IF frankie_flag = 2
		CAR_GOTO_COORDINATES beamer2_a1 1438.0 -183.4 50.5
		SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage beamer2_a1
	ELSE
		CAR_GOTO_COORDINATES beamer2_a1 1418.7 -168.1 50.2
	ENDIF
	
	IF kill_player_now_flag = 0
		SET_CAR_CRUISE_SPEED beamer2_a1 17.0
	ELSE
		SET_CAR_CRUISE_SPEED beamer2_a1 42.0
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD beamer3_a1
	
	IF frankie_flag = 3
		CAR_GOTO_COORDINATES beamer3_a1 1438.0 -183.4 50.5
		SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage beamer3_a1
	ELSE
		CAR_GOTO_COORDINATES beamer3_a1 1418.7 -168.1 50.2
	ENDIF
	
	IF kill_player_now_flag = 0
		SET_CAR_CRUISE_SPEED beamer3_a1 16.0
	ELSE
		SET_CAR_CRUISE_SPEED beamer3_a1 41.0
	ENDIF

ENDIF

SWITCH_ROADS_ON 905.0 -448.6 12.0 916.0 -393.0 20.0
CHANGE_GARAGE_TYPE frankie_garage GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
IF NOT IS_CHAR_DEAD	frankie
	ADD_ARMOUR_TO_CHAR frankie 100
ENDIF
beamer1_health = 0
timerb_reset_flag_a1 = 0
TIMERA = 0
TIMERB = 0

cars_going_to_frankies:
//WHILE NOT IS_CHAR_STOPPED_IN_AREA_IN_CAR_3D frankie 1428.2 -179.2 50.0 1417.4 -186.3 53.0 0
//WHILE NOT garage_door_close = 1

	WAIT 0

	IF IS_CHAR_DEAD frankie
		GOTO mission_asuka1_passed
	ENDIF
	
//_____SEND MAFIA_8X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_8_flag = 4
		IF IS_CHAR_DEAD mafia_8X
			mafia_8_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_8_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_8X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_8X TRUE
		mafia_8_flag = 5
	ENDIF

	IF mafia_8_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_8X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_8X bottom_of_steps_x bottom_of_steps_y
			mafia_8_flag = 6
		ENDIF
	ENDIF

	IF mafia_8_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_8X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_8X create_char_in_club_x create_char_in_club_y
			mafia_8_flag = 7
		ENDIF
	ENDIF

	IF mafia_8_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_8X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_8X
			mafia_8_flag = 4
		ENDIF
	ENDIF
	
//_____SEND MAFIA_9X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_9_flag = 4
		IF IS_CHAR_DEAD mafia_9X
			mafia_9_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_9_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_9X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_9X TRUE
		mafia_9_flag = 5
	ENDIF

	IF mafia_9_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_9X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_9X bottom_of_steps_x bottom_of_steps_y
			mafia_9_flag = 6
		ENDIF
	ENDIF

	IF mafia_9_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_9X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_9X create_char_in_club_x create_char_in_club_y
			mafia_9_flag = 7
		ENDIF
	ENDIF

	IF mafia_9_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_9X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_9X
			mafia_9_flag = 4
		ENDIF
	ENDIF
	
//_____SEND MAFIA_10X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_10_flag = 4
		IF IS_CHAR_DEAD mafia_10X
			mafia_10_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_10_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_10X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_10X TRUE
		mafia_10_flag = 5
	ENDIF

	IF mafia_10_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_10X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_10X bottom_of_steps_x bottom_of_steps_y
			mafia_10_flag = 6
		ENDIF
	ENDIF

	IF mafia_10_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_10X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_10X create_char_in_club_x create_char_in_club_y
			mafia_10_flag = 7
		ENDIF
	ENDIF

	IF mafia_10_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_10X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_10X
			mafia_10_flag = 4
		ENDIF
	ENDIF
	
//_____SEND MAFIA_11X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_11_flag = 4
		IF IS_CHAR_DEAD mafia_11X
			mafia_11_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_11_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_11X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_11X TRUE
		mafia_11_flag = 5
	ENDIF

	IF mafia_11_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_11X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_11X bottom_of_steps_x bottom_of_steps_y
			mafia_11_flag = 6
		ENDIF
	ENDIF

	IF mafia_11_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_11X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_11X create_char_in_club_x create_char_in_club_y
			mafia_11_flag = 7
		ENDIF
	ENDIF

	IF mafia_11_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_11X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_11X
			mafia_11_flag = 4
		ENDIF
	ENDIF
	
//_____SEND MAFIA_12X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_12_flag = 4
		IF IS_CHAR_DEAD mafia_12X
			mafia_12_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_12_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_12X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_12X TRUE
		mafia_12_flag = 5
	ENDIF

	IF mafia_12_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_12X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_12X bottom_of_steps_x bottom_of_steps_y
			mafia_12_flag = 6
		ENDIF
	ENDIF

	IF mafia_12_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_12X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_12X create_char_in_club_x create_char_in_club_y
			mafia_12_flag = 7
		ENDIF
	ENDIF

	IF mafia_12_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_12X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_12X
			mafia_12_flag = 4
		ENDIF
	ENDIF
	
//_____SEND MAFIA_13X BACK INTO THE CLUB THEN DELETE HIM____//
	
	IF NOT mafia_13_flag = 4
		IF IS_CHAR_DEAD mafia_13X
			mafia_13_flag = 4
		ENDIF
	ENDIF
	
	IF mafia_13_flag = 3
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_13X back_of_alley_x back_of_alley_y
		SET_CHAR_HEED_THREATS mafia_13X TRUE
		mafia_13_flag = 5
	ENDIF

	IF mafia_13_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D mafia_13X back_of_alley_x	back_of_alley_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_13X bottom_of_steps_x bottom_of_steps_y
			mafia_13_flag = 6
		ENDIF
	ENDIF

	IF mafia_13_flag = 6
		IF LOCATE_CHAR_ON_FOOT_2D mafia_13X bottom_of_steps_x bottom_of_steps_y 1.0 1.0 0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_13X create_char_in_club_x create_char_in_club_y
			mafia_13_flag = 7
		ENDIF
	ENDIF

	IF mafia_13_flag = 7
		IF LOCATE_CHAR_ON_FOOT_2D mafia_13X create_char_in_club_x create_char_in_club_y 0.5 0.5 0
			DELETE_CHAR mafia_13X
			mafia_13_flag = 4
		ENDIF
	ENDIF

//_____          CARS - IF THEY'RE ATACKED THEY DRIVE FASTER                 _____//
//_____    IF FRANKIES CAR IS ATTACKED BOTH OTHER CARS ATTACK THE PLAYER     _____//
//_____IF ONE OF THE OTHER CARS IS DESTROYED THE OTHER WILL ATTACK THE PLAYER_____//

	IF IS_CHAR_DEAD frankie
		GOTO mission_asuka1_passed
	ENDIF
	
	IF frankies_ride = 0
		IF LOCATE_CHAR_IN_CAR_2D frankie 1371.0 -283.9 50.0 50.0 0
			STORE_CAR_CHAR_IS_IN frankie frankies_ride
			SET_CAR_CRUISE_SPEED frankies_ride 20.0
			//PRINT_WITH_NUMBER_NOW NUMBER 15 5000 1 
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD beamer1_a1
		GET_CAR_HEALTH beamer1_a1 beamer1_health
		IF beamer1_health < 1000
			IF NOT frankies_ride = beamer1_a1
				SET_CAR_CRUISE_SPEED beamer1_a1 51.0
			ENDIF
			IF NOT IS_CAR_DEAD beamer2_a1
				IF NOT frankies_ride = beamer2_a1
					SET_CAR_CRUISE_SPEED beamer2_a1 50.0
				ENDIF
			ENDIF
			IF NOT IS_CAR_DEAD beamer3_a1
				IF NOT frankies_ride = beamer3_a1
					SET_CAR_CRUISE_SPEED beamer3_a1 49.0
					set_beamer_3_kill_player = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CAR_DEAD beamer3_a1
			IF NOT frankie_flag = 3
				set_beamer_3_kill_player = 1
			ELSE
				IF NOT IS_CAR_DEAD beamer2_a1
					IF NOT frankie_flag = 2
						set_beamer_2_kill_player = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD beamer3_a1
		GET_CAR_HEALTH beamer3_a1 beamer3_health
		IF beamer3_health < 1000
			IF NOT frankies_ride = beamer3_a1
				SET_CAR_CRUISE_SPEED beamer3_a1 51.0
			ENDIF
			IF NOT IS_CAR_DEAD beamer1_a1
				IF NOT frankies_ride = beamer1_a1
					SET_CAR_CRUISE_SPEED beamer1_a1 50.0
					set_beamer_1_kill_player = 1
				ENDIF
			ENDIF
			IF NOT IS_CAR_DEAD beamer2_a1
				IF NOT frankies_ride = beamer2_a1
					SET_CAR_CRUISE_SPEED beamer2_a1 49.0
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CAR_DEAD beamer1_a1
			IF NOT frankie_flag = 1
				set_beamer_1_kill_player = 1
			ELSE
				IF NOT IS_CAR_DEAD beamer2_a1
					IF NOT frankie_flag = 2
						set_beamer_2_kill_player = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD beamer2_a1
		GET_CAR_HEALTH beamer2_a1 beamer2_health
		IF beamer2_health < 1000
			IF NOT frankies_ride = beamer2_a1
				SET_CAR_CRUISE_SPEED beamer2_a1 51.0
			ENDIF
			IF NOT IS_CAR_DEAD beamer1_a1
				IF NOT frankies_ride = beamer1_a1
					SET_CAR_CRUISE_SPEED beamer1_a1 50.0
					set_beamer_1_kill_player = 1
				ENDIF
			ENDIF
			IF NOT IS_CAR_DEAD beamer3_a1
				IF NOT frankies_ride = beamer3_a1
					SET_CAR_CRUISE_SPEED beamer3_a1 49.0
					set_beamer_3_kill_player = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CAR_DEAD beamer1_a1
			IF NOT frankie_flag = 1
				set_beamer_1_kill_player = 1
			ELSE
				IF NOT IS_CAR_DEAD beamer3_a1
					IF NOT frankie_flag = 3
						set_beamer_3_kill_player = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF set_beamer_1_kill_player = 1
		IF NOT IS_CAR_DEAD beamer1_a1
			IF NOT frankies_ride = beamer1_a1
				SET_CAR_CRUISE_SPEED beamer1_a1 100.0
				SET_CAR_MISSION beamer1_a1 MISSION_RAMPLAYER_FARAWAY
			ENDIF
		ENDIF
	ENDIF
		
	IF set_beamer_2_kill_player = 1
		IF NOT IS_CAR_DEAD beamer2_a1
			IF NOT frankies_ride = beamer2_a1
				SET_CAR_CRUISE_SPEED beamer2_a1 100.0
				SET_CAR_MISSION beamer2_a1 MISSION_RAMPLAYER_FARAWAY
			ENDIF
		ENDIF
	ENDIF
		
	IF set_beamer_3_kill_player = 1
		IF NOT IS_CAR_DEAD beamer3_a1
			IF NOT frankies_ride = beamer3_a1
				SET_CAR_CRUISE_SPEED beamer3_a1 100.0
				SET_CAR_MISSION beamer3_a1 MISSION_RAMPLAYER_FARAWAY
			ENDIF
		ENDIF
	ENDIF

	IF set_beamer_1_kill_player = 1
		IF NOT IS_CHAR_DEAD mafia_1X
		OR NOT IS_CAR_DEAD beamer1_a1
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_car_a1
				GET_CAR_SPEED players_car_a1 players_car_a1_speed
				GET_CAR_SPEED beamer1_a1 beamer1_a1_speed
				IF beamer1_a1_speed < 10.0
				AND players_car_a1_speed < 6.0
					IF LOCATE_CHAR_IN_CAR_CAR_2D mafia_1X players_car_a1 10.0 10.0 0
						IF NOT IS_CHAR_DEAD mafia_6X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_6X player
							SET_CHAR_RUNNING mafia_6X TRUE
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_7X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
							SET_CHAR_RUNNING mafia_7X TRUE
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF set_beamer_2_kill_player = 1
		IF NOT IS_CHAR_DEAD mafia_2X
		OR NOT IS_CAR_DEAD beamer2_a1
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_car_a1
				GET_CAR_SPEED players_car_a1 players_car_a1_speed
				GET_CAR_SPEED beamer2_a1 beamer2_a1_speed
				IF beamer2_a1_speed < 10.0
				AND players_car_a1_speed < 6.0
					IF LOCATE_CHAR_IN_CAR_CAR_2D mafia_2X players_car_a1 10.0 10.0 0
						IF NOT IS_CHAR_DEAD mafia_14X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
							SET_CHAR_RUNNING mafia_14X TRUE
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF set_beamer_3_kill_player = 1
		IF NOT IS_CHAR_DEAD mafia_3X
		OR NOT IS_CAR_DEAD beamer3_a1
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_car_a1
				GET_CAR_SPEED players_car_a1 players_car_a1_speed
				GET_CAR_SPEED beamer3_a1 beamer3_a1_speed
				IF beamer3_a1_speed < 10.0
				AND players_car_a1_speed < 6.0
					IF LOCATE_CHAR_IN_CAR_CAR_2D mafia_3X players_car_a1 10.0 10.0 0
						IF NOT IS_CHAR_DEAD mafia_4X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
							SET_CHAR_RUNNING mafia_4X TRUE
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_5X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
							SET_CHAR_RUNNING mafia_5X TRUE
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

//___________IF THE CARS GET STUCK OR UPSIDEDOWN THIS BIT WILL WARP THEM___________//

	IF NOT IS_CAR_DEAD beamer1_a1
		IF IS_CAR_UPSIDEDOWN beamer1_a1
		AND IS_CAR_STOPPED beamer1_a1
			IF NOT IS_CAR_ON_SCREEN beamer1_a1
				GET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
				GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//				IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 3.0
				IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
					SET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
					TURN_CAR_TO_FACE_COORD beamer1_a1 1438.0 -183.4
				ELSE
					IF NOT IS_CHAR_DEAD mafia_1X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_7X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
					ENDIF
					IF frankie_flag = 1
						IF NOT IS_CHAR_DEAD frankie
							GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD mafia_1X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
				ENDIF
				IF NOT IS_CHAR_DEAD mafia_7X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
				ENDIF
				IF frankie_flag = 1
					IF NOT IS_CHAR_DEAD frankie
						GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF timera_reset_flag_a1 = 1
			IF NOT IS_CAR_STOPPED beamer1_a1
				timera_reset_flag_a1 = 0
			ENDIF
		ENDIF
			
		IF IS_CAR_STOPPED beamer1_a1
			IF timera_reset_flag_a1 = 0
				TIMERA = 0
				timera_reset_flag_a1 = 1
			ENDIF

			IF TIMERA > 4000
			AND timera_reset_flag_a1 = 1
				IF NOT IS_CAR_ON_SCREEN beamer1_a1
					GET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
					GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//					IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
					IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
						SET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
						TURN_CAR_TO_FACE_COORD beamer1_a1 1438.0 -183.4
						timera_reset_flag_a1 = 0
					ELSE
						IF NOT IS_CHAR_DEAD mafia_1X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_7X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
						ENDIF
						IF frankie_flag = 1
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ELSE
					IF NOT IS_CHAR_DEAD mafia_1X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_7X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
					ENDIF
					IF frankie_flag = 1
						IF NOT IS_CHAR_DEAD frankie
							GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF LOCATE_CAR_3D beamer1_a1 beamer1_stuck_x beamer1_stuck_y beamer1_stuck_z 4.0 4.0 4.0 0
			IF timerx_reset_flag = 0
				GET_GAME_TIMER timerx_started
				timerx_reset_flag = 1
			ENDIF

			IF timerx_reset_flag = 1
				GET_GAME_TIMER timerx_current
				timerx = timerx_current - timerx_started
				IF timerx > 5000
					IF NOT IS_CAR_ON_SCREEN beamer1_a1
						GET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
						GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//						IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
						IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
							SET_CAR_COORDINATES beamer1_a1 a1_x a1_y a1_z
							TURN_CAR_TO_FACE_COORD beamer1_a1 1438.0 -183.4
							timera_reset_flag_a1 = 0
						ELSE
							IF NOT IS_CHAR_DEAD mafia_1X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_7X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
							ENDIF
							IF frankie_flag = 1
								IF NOT IS_CHAR_DEAD frankie
									GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
									SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF NOT IS_CHAR_DEAD mafia_1X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_7X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player
						ENDIF
						IF frankie_flag = 1
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT LOCATE_CAR_3D beamer1_a1 beamer1_stuck_x beamer1_stuck_y beamer1_stuck_z 4.0 4.0 4.0 0
			GET_CAR_COORDINATES beamer1_a1 beamer1_stuck_x beamer1_stuck_y beamer1_stuck_z
			timerx_reset_flag = 0
		ENDIF

	ENDIF

	IF NOT IS_CAR_DEAD beamer2_a1
		IF IS_CAR_UPSIDEDOWN beamer2_a1
		AND IS_CAR_STOPPED beamer2_a1
			IF NOT IS_CAR_ON_SCREEN beamer2_a1
				GET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
				GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//				IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 3.0
				IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
					SET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
					TURN_CAR_TO_FACE_COORD beamer2_a1 1438.0 -183.4
				ELSE
					IF NOT IS_CHAR_DEAD mafia_2X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_14X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
					ENDIF
					IF frankie_flag = 2
						IF NOT IS_CHAR_DEAD frankie
							GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD mafia_2X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
				ENDIF
				IF NOT IS_CHAR_DEAD mafia_14X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
				ENDIF
				IF frankie_flag = 2
					IF NOT IS_CHAR_DEAD frankie
						GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF timerb_reset_flag_a1 = 1
			IF NOT IS_CAR_STOPPED beamer2_a1
				timerb_reset_flag_a1 = 0
			ENDIF
		ENDIF
			
		IF IS_CAR_STOPPED beamer2_a1
			IF timerb_reset_flag_a1 = 0
				TIMERB = 0
				timerb_reset_flag_a1 = 1
			ENDIF

			IF TIMERB > 5000
			AND timerb_reset_flag_a1 = 1
				IF NOT IS_CAR_ON_SCREEN beamer2_a1
					GET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
					GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//					IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
					IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
						SET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
						TURN_CAR_TO_FACE_COORD beamer2_a1 1438.0 -183.4
						timerb_reset_flag_a1 = 0
					ELSE
						IF NOT IS_CHAR_DEAD mafia_2X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_14X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
						ENDIF
						IF frankie_flag = 2
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ELSE
					IF NOT IS_CHAR_DEAD mafia_2X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_14X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
					ENDIF
					IF frankie_flag = 2
						IF NOT IS_CHAR_DEAD frankie
							GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF LOCATE_CAR_3D beamer2_a1 beamer2_stuck_x beamer2_stuck_y beamer2_stuck_z 4.0 4.0 4.0 0
			IF timery_reset_flag = 0
				GET_GAME_TIMER timery_started
				timery_reset_flag = 1
			ENDIF

			IF timery_reset_flag = 1
				GET_GAME_TIMER timery_current
				timery = timery_current - timery_started
				IF timery > 5000
					IF NOT IS_CAR_ON_SCREEN beamer2_a1
						GET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
						GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//						IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
						IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
							SET_CAR_COORDINATES beamer2_a1 a1_x a1_y a1_z
							TURN_CAR_TO_FACE_COORD beamer2_a1 1438.0 -183.4
							timerb_reset_flag_a1 = 0
						ELSE
							IF NOT IS_CHAR_DEAD mafia_2X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_14X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
							ENDIF
							IF frankie_flag = 2
								IF NOT IS_CHAR_DEAD frankie
									GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
									SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF NOT IS_CHAR_DEAD mafia_2X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_14X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player
						ENDIF
						IF frankie_flag = 2
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT LOCATE_CAR_3D beamer2_a1 beamer2_stuck_x beamer2_stuck_y beamer2_stuck_z 4.0 4.0 4.0 0
			GET_CAR_COORDINATES beamer2_a1 beamer2_stuck_x beamer2_stuck_y beamer2_stuck_z
			timery_reset_flag = 0
		ENDIF

	ENDIF

	IF NOT IS_CAR_DEAD beamer3_a1
		IF IS_CAR_UPSIDEDOWN beamer3_a1
		AND IS_CAR_STOPPED beamer3_a1
			IF NOT IS_CAR_ON_SCREEN beamer3_a1
				GET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
				GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//				IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 3.0
				IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
					SET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
					TURN_CAR_TO_FACE_COORD beamer3_a1 1438.0 -183.4
				ELSE
					IF NOT IS_CHAR_DEAD mafia_3X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_4X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
					ENDIF
					IF NOT IS_CHAR_DEAD mafia_5X
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
					ENDIF
					IF frankie_flag = 3
						IF NOT IS_CHAR_DEAD frankie
							GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD mafia_3X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
				ENDIF
				IF NOT IS_CHAR_DEAD mafia_4X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
				ENDIF
				IF NOT IS_CHAR_DEAD mafia_5X
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
				ENDIF
				IF frankie_flag = 3
					IF NOT IS_CHAR_DEAD frankie
						GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF timerc_reset_flag_a1 = 1
			IF NOT IS_CAR_STOPPED beamer3_a1
				timerc_reset_flag_a1 = 0
			ENDIF
		ENDIF
			
		IF IS_CAR_STOPPED beamer3_a1
			IF timerc_reset_flag_a1 = 0
				GET_GAME_TIMER timerc_started_a1
				timerc_reset_flag_a1 = 1
			ENDIF

			IF timerc_reset_flag_a1 = 1
				GET_GAME_TIMER timerc_current_a1
				timerc_a1 = timerc_current_a1 - timerc_started_a1
				IF timerc_a1 > 5000
					IF NOT IS_CAR_ON_SCREEN beamer3_a1
						GET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
						GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//						IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
						IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
							SET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
							TURN_CAR_TO_FACE_COORD beamer3_a1 1438.0 -183.4
							timerc_reset_flag_a1 = 0
						ELSE
							IF NOT IS_CHAR_DEAD mafia_3X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_4X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_5X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
							ENDIF
							IF frankie_flag = 3
								IF NOT IS_CHAR_DEAD frankie
									GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
									SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF NOT IS_CHAR_DEAD mafia_3X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_4X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_5X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
						ENDIF
						IF frankie_flag = 3
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF LOCATE_CAR_3D beamer3_a1 beamer3_stuck_x beamer3_stuck_y beamer3_stuck_z 4.0 4.0 4.0 0
			IF timerz_reset_flag = 0
				GET_GAME_TIMER timerz_started
				timerz_reset_flag = 1
			ENDIF

			IF timerz_reset_flag = 1
				GET_GAME_TIMER timerz_current
				timerz = timerz_current - timerz_started
				IF timerz > 5000
					IF NOT IS_CAR_ON_SCREEN beamer3_a1
						GET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
						GET_CLOSEST_CAR_NODE a1_x a1_y a1_z a1_x a1_y a1_z
//						IF NOT IS_POINT_ON_SCREEN a1_x a1_y a1_z 4.0
						IF NOT LOCATE_PLAYER_ANY_MEANS_2D player a1_x a1_y 80.0 80.0 0
							SET_CAR_COORDINATES beamer3_a1 a1_x a1_y a1_z
							TURN_CAR_TO_FACE_COORD beamer3_a1 1438.0 -183.4
							timerc_reset_flag_a1 = 0
						ELSE
							IF NOT IS_CHAR_DEAD mafia_3X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_4X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
							ENDIF
							IF NOT IS_CHAR_DEAD mafia_5X
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
							ENDIF
							IF frankie_flag = 3
								IF NOT IS_CHAR_DEAD frankie
									GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
									SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF NOT IS_CHAR_DEAD mafia_3X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_4X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player
						ENDIF
						IF NOT IS_CHAR_DEAD mafia_5X
							SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player
						ENDIF
						IF frankie_flag = 3
							IF NOT IS_CHAR_DEAD frankie
								GIVE_WEAPON_TO_CHAR	frankie WEAPONTYPE_M16 1000
								SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS frankie player
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT LOCATE_CAR_3D beamer3_a1 beamer3_stuck_x beamer3_stuck_y beamer3_stuck_z 4.0 4.0 4.0 0
			GET_CAR_COORDINATES beamer3_a1 beamer3_stuck_x beamer3_stuck_y beamer3_stuck_z
			timerz_reset_flag = 0
		ENDIF

	ENDIF

//___________THIS BIT OPENS THE GARAGE, IF FRANKIE GETS THERE MISSION FAILED_________//

	IF garage_door_close = 0
		IF LOCATE_CHAR_ANY_MEANS_3D	frankie 1426.0 -183.4 50.5 15.0 12.0 6.0 0
			OPEN_GARAGE frankie_garage
			garage_door_close = 1
		ENDIF
	ENDIF
	
	IF garage_door_close = 1
		IF NOT IS_PLAYER_IN_AREA_3D player 1427.6 -187.3 49.5 1442.6 -179.0 53.8 0
			IF IS_CHAR_IN_AREA_3D frankie 1428.8 -187.0 50.0 1442.5 -179.9 53.0 0
				CLOSE_GARAGE frankie_garage
				garage_door_close = 2
			ENDIF
		ELSE
			OPEN_GARAGE frankie_garage
		ENDIF
	ENDIF

	IF garage_door_close = 2
		IF IS_PLAYER_IN_AREA_3D player 1427.6 -187.3 49.5 1442.6 -179.0 53.8 0
			OPEN_GARAGE frankie_garage
			garage_door_close = 1
		ENDIF
		IF IS_GARAGE_CLOSED	frankie_garage
			PRINT_NOW AM1_7 5000 1 //"Salvatore got back to his club alive!"
			GOTO mission_asuka1_failed
		ENDIF
	ENDIF

GOTO cars_going_to_frankies


// Mission Asuka1 failed

mission_asuka1_failed:

IF NOT IS_CHAR_DEAD mafia_1X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_2X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_3X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_4X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_5X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_6X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_6X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_7X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_8X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_8X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_9X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_9X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_10X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_10X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_11X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_11X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_12X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_12X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_13X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_13X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_14X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player 
ENDIF

PRINT_BIG ( m_fail ) 5000 1
RETURN

   
// mission Asuka1 passed

mission_asuka1_passed:

flag_asuka_mission1_passed = 1

IF NOT IS_CHAR_DEAD mafia_1X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_1X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_2X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_2X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_3X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_3X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_4X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_4X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_5X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_5X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_6X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_6X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_7X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_7X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_8X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_8X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_9X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_9X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_10X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_10X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_11X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_11X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_12X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_12X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_13X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_13X player 
ENDIF
IF NOT IS_CHAR_DEAD mafia_14X
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS mafia_14X player 
ENDIF

PRINT_WITH_NUMBER_BIG m_pass 25000 5000 1
ADD_SCORE player 25000
SET_THREAT_FOR_PED_TYPE	PEDTYPE_GANG_MAFIA THREAT_PLAYER1
SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_SHOTGUN //The Mafia
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	AM1
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT asuka_mission2_loop
START_NEW_SCRIPT joeys_buggy_loop
START_NEW_SCRIPT yardie_phone_start
RETURN									


// mission cleanup

mission_cleanup_asuka1:

START_NEW_SCRIPT close_asuka1_door

//IF NOT IS_CHAR_DEAD frankie
//	REMOVE_CHAR_ELEGANTLY frankie
//ENDIF

SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage -1

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_MAFIA
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_A                       
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B                       
UNLOAD_SPECIAL_CHARACTER 1
REMOVE_BLIP	mission_blip_am1
SWITCH_ROADS_ON 905.0 -448.6 12.0 916.0 -393.0 20.0
flag_player_on_mission = 0
flag_player_on_asuka_mission = 0
MISSION_HAS_FINISHED
RETURN


kill_player_now_script:

IF spotted_print = 0
	IF HAS_MISSION_AUDIO_LOADED
		PRINT_NOW AM1_2 5000 1
		PLAY_MISSION_AUDIO
		spotted_print = 1
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD	frankie
	SET_CHAR_RUNNING frankie TRUE
ENDIF

IF IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0 //HIGHER ROOF
OR IS_PLAYER_IN_AREA_2D player 878.79 -433.86 890.77 -427.4 0 //LOWER ROOF
OR IS_PLAYER_IN_AREA_3D player 890.77 -433.71 23.05 900.78 -403.76 46.0 0 //CLUB ROOF

	IF NOT mafia_13_flag = 4
		IF NOT mafia_13_flag = 0

			IF mafia_13_flag > 1
			AND mafia_13_kill_player_flag = 0
				SET_CHAR_USE_PEDNODE_SEEK mafia_13X TRUE
				SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 886.0037 -414.0266 // NEAR BOTTOM OF STEPS
				mafia_13_kill_player_flag = 1
			ENDIF

			IF mafia_13_kill_player_flag = 1
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	886.0037 -414.0266 1.0 1.0 0 //	NEAR BOTTOM OF STEPS
					SET_CHAR_USE_PEDNODE_SEEK mafia_13X FALSE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 888.8883 -409.8141 // AT BOTTOM OF STEPS
					mafia_13_kill_player_flag = 2
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	888.8883 -409.8141 1.0 1.0 0// AT BOTTOM OF STEPS
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 880.9434 -409.0293 // ON LANDING
					mafia_13_kill_player_flag = 3
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	880.9434 -409.0293 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 880.9827 -406.0733 // ON LANDING
					mafia_13_kill_player_flag = 4
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 4
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	880.9827 -406.0733 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 892.1010 -406.2053 // ON ROOF TOP OF STAIRS
					mafia_13_kill_player_flag = 5
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 5
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	892.1010 -406.2053 1.0 1.0 0 // ON ROOF TOP OF STAIRS
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 892.2498 -421.2303 // IN MIDDLE OF ROOF
					mafia_13_kill_player_flag = 6
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 6
				IF LOCATE_CHAR_ON_FOOT_2D mafia_13X	892.2498 -421.2303 1.0 1.0 0 // IN MIDDLE OF ROOF
					IF IS_PLAYER_IN_AREA_3D player 890.77 -433.71 23.05 900.78 -403.76 46.0 0 //CLUB ROOF
						SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 893.2559 -425.0609 // ABOVE SMALL ROOF BETWEEN BILLBOARDS
					ELSE
						SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 892.1462 -429.0872 // ABOVE SMALL ROOF
					ENDIF
					mafia_13_kill_player_flag = 7
				ENDIF
			ENDIF
			
			IF mafia_13_kill_player_flag = 7
				IF IS_PLAYER_IN_AREA_3D player 890.77 -433.71 23.05 900.78 -403.76 46.0 0 //CLUB ROOF
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 893.2559 -425.0609 // ABOVE SMALL ROOF BETWEEN BILLBOARDS
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_13X	893.2559 -425.0609 1.0 1.0 0 // ABOVE SMALL ROOF
						SET_CHAR_USE_PEDNODE_SEEK mafia_13X TRUE
						SET_CHAR_STAY_IN_SAME_PLACE mafia_13X TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_13X player
						mafia_13_kill_player_flag = 8
					ENDIF
				ELSE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_13X 892.1462 -429.0872 // ABOVE SMALL ROOF
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_13X	892.1462 -429.0872 1.0 1.0 0 // ABOVE SMALL ROOF
						SET_CHAR_USE_PEDNODE_SEEK mafia_13X TRUE
						SET_CHAR_STAY_IN_SAME_PLACE mafia_13X TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_13X player
						mafia_13_kill_player_flag = 8
					ENDIF
				ENDIF
			ENDIF

		ENDIF
	ENDIF

	IF NOT mafia_12_flag = 4
		IF NOT mafia_12_flag = 0
			IF IS_PLAYER_IN_AREA_3D player 890.77 -433.71 23.05 900.78 -403.76 46.0 0 //CLUB ROOF
			
				IF mafia_12_flag > 1
				AND mafia_12_kill_player_flag = 0
					SET_CHAR_USE_PEDNODE_SEEK mafia_12X TRUE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 886.0037 -414.0266 // NEAR BOTTOM OF STEPS
					mafia_12_kill_player_flag = 1
				ENDIF

				IF mafia_12_kill_player_flag = 1
					IF LOCATE_CHAR_ON_FOOT_2D mafia_12X	886.0037 -414.0266 1.0 1.0 0 //	NEAR BOTTOM OF STEPS
						SET_CHAR_USE_PEDNODE_SEEK mafia_12X FALSE
						SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 888.8883 -409.8141 // AT BOTTOM OF STEPS
						mafia_12_kill_player_flag = 2
					ENDIF
				ENDIF
				
				IF mafia_12_kill_player_flag = 2
					IF LOCATE_CHAR_ON_FOOT_2D mafia_12X	888.8883 -409.8141 1.0 1.0 0// AT BOTTOM OF STEPS
						SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 880.9434 -409.0293 // ON LANDING
						mafia_12_kill_player_flag = 3
					ENDIF
				ENDIF
				
				IF mafia_12_kill_player_flag = 3
					IF LOCATE_CHAR_ON_FOOT_2D mafia_12X	880.9434 -409.0293 1.0 1.0 0 //	ON LANDING
						SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 880.9827 -406.0733 // ON LANDING
						mafia_12_kill_player_flag = 4
					ENDIF
				ENDIF
				
				IF mafia_12_kill_player_flag = 4
					IF LOCATE_CHAR_ON_FOOT_2D mafia_12X	880.9827 -406.0733 1.0 1.0 0 //	ON LANDING
						SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 892.1010 -406.2053 // ON ROOF TOP OF STAIRS
						mafia_12_kill_player_flag = 5
					ENDIF
				ENDIF
				
				IF mafia_12_kill_player_flag = 5
					IF LOCATE_CHAR_ON_FOOT_2D mafia_12X	892.1010 -406.2053 1.0 1.0 0 // ON ROOF TOP OF STAIRS
						SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 899.3036 -408.1849 // AT FRONT OF ROOF
						GIVE_WEAPON_TO_CHAR	mafia_12X WEAPONTYPE_UZI 9999
						mafia_12_kill_player_flag = 6
					ENDIF
				ENDIF
				
				IF mafia_12_kill_player_flag = 6
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_12X	899.3036 -408.1849 1.0 1.0 0 // AT FRONT OF ROOF
						SET_CHAR_USE_PEDNODE_SEEK mafia_12X TRUE
						SET_CHAR_STAY_IN_SAME_PLACE mafia_12X TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_12X player
						mafia_12_kill_player_flag = 7
					ENDIF
				ENDIF

			ELSE
			
				IF mafia_12_flag > 1
				AND mafia_12_kill_player_flag = 0
					SET_CHAR_USE_PEDNODE_SEEK mafia_12X TRUE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_12X 882.7668 -414.3651
					mafia_12_kill_player_flag = 1
				ENDIF

				IF mafia_12_kill_player_flag = 1
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_12X	882.7668 -414.3651 1.0 1.0 0
						SET_CHAR_USE_PEDNODE_SEEK mafia_12X TRUE
						SET_CHAR_STAY_IN_SAME_PLACE mafia_12X TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_12X player
						mafia_12_kill_player_flag = 7
					ENDIF
				ENDIF

			ENDIF
		ENDIF
	ENDIF
	
	IF NOT mafia_11_flag = 4
		IF NOT mafia_11_flag = 0

			IF mafia_11_flag > 1
			AND mafia_11_kill_player_flag = 0
				SET_CHAR_USE_PEDNODE_SEEK mafia_11X TRUE
				SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 886.0037 -414.0266 // NEAR BOTTOM OF STEPS
				mafia_11_kill_player_flag = 1
			ENDIF

			IF mafia_11_kill_player_flag = 1
				IF LOCATE_CHAR_ON_FOOT_2D mafia_11X	886.0037 -414.0266 1.0 1.0 0 //	NEAR BOTTOM OF STEPS
					SET_CHAR_USE_PEDNODE_SEEK mafia_11X FALSE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 888.8883 -409.8141 // AT BOTTOM OF STEPS
					mafia_11_kill_player_flag = 2
				ENDIF
			ENDIF
			
			IF mafia_11_kill_player_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D mafia_11X	888.8883 -409.8141 1.0 1.0 0// AT BOTTOM OF STEPS
					SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 880.9434 -409.0293 // ON LANDING
					mafia_11_kill_player_flag = 3
				ENDIF
			ENDIF
			
			IF mafia_11_kill_player_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D mafia_11X	880.9434 -409.0293 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 880.9827 -406.0733 // ON LANDING
					mafia_11_kill_player_flag = 4
				ENDIF
			ENDIF
			
			IF mafia_11_kill_player_flag = 4
				IF LOCATE_CHAR_ON_FOOT_2D mafia_11X	880.9827 -406.0733 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 892.1010 -406.2053 // ON ROOF TOP OF STAIRS
					mafia_11_kill_player_flag = 5
				ENDIF
			ENDIF
			
			IF mafia_11_kill_player_flag = 5
				IF LOCATE_CHAR_ON_FOOT_2D mafia_11X	892.1010 -406.2053 1.0 1.0 0 // ON ROOF TOP OF STAIRS
					SET_CHAR_OBJ_RUN_TO_COORD mafia_11X 892.2498 -421.2303 // IN MIDDLE OF ROOF
					GIVE_WEAPON_TO_CHAR	mafia_11X WEAPONTYPE_UZI 9999
					mafia_11_kill_player_flag = 6
				ENDIF
			ENDIF
			
			IF mafia_11_kill_player_flag = 6
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_11X	892.2498 -421.2303 1.0 1.0 0 // IN MIDDLE OF ROOF
					SET_CHAR_USE_PEDNODE_SEEK mafia_11X TRUE
					SET_CHAR_STAY_IN_SAME_PLACE mafia_11X TRUE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_11X player
					mafia_11_kill_player_flag = 7
				ENDIF
			ENDIF
			
		ENDIF
	ENDIF
	
	IF NOT mafia_10_flag = 4
		IF NOT mafia_10_flag = 0
			
			IF mafia_10_flag > 1
			AND mafia_10_kill_player_flag = 0
				SET_CHAR_USE_PEDNODE_SEEK mafia_10X TRUE
				SET_CHAR_OBJ_RUN_TO_COORD mafia_10X 886.0037 -414.0266 // NEAR BOTTOM OF STEPS
				mafia_10_kill_player_flag = 1
			ENDIF

			IF mafia_10_kill_player_flag = 1
				IF LOCATE_CHAR_ON_FOOT_2D mafia_10X	886.0037 -414.0266 1.0 1.0 0 //	NEAR BOTTOM OF STEPS
					SET_CHAR_USE_PEDNODE_SEEK mafia_10X FALSE
					SET_CHAR_OBJ_RUN_TO_COORD mafia_10X 888.8883 -409.8141 // AT BOTTOM OF STEPS
					mafia_10_kill_player_flag = 2
				ENDIF
			ENDIF
			
			IF mafia_10_kill_player_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D mafia_10X	888.8883 -409.8141 1.0 1.0 0// AT BOTTOM OF STEPS
					SET_CHAR_OBJ_RUN_TO_COORD mafia_10X 880.9434 -409.0293 // ON LANDING
					mafia_10_kill_player_flag = 3
				ENDIF
			ENDIF
			
			IF mafia_10_kill_player_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D mafia_10X	880.9434 -409.0293 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_10X 880.9827 -406.0733 // ON LANDING
					mafia_10_kill_player_flag = 4
				ENDIF
			ENDIF

			IF mafia_10_kill_player_flag = 4
				IF LOCATE_CHAR_ON_FOOT_2D mafia_10X	880.9827 -406.0733 1.0 1.0 0 //	ON LANDING
					SET_CHAR_OBJ_RUN_TO_COORD mafia_10X 892.1010 -406.2053 // ON ROOF TOP OF STAIRS
					GIVE_WEAPON_TO_CHAR	mafia_10X WEAPONTYPE_UZI 9999
					mafia_10_kill_player_flag = 5
				ENDIF
			ENDIF

			IF mafia_10_kill_player_flag = 5
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mafia_10X	892.1010 -406.2053 1.0 1.0 0 // ON ROOF TOP OF STAIRS
					SET_CHAR_USE_PEDNODE_SEEK mafia_10X TRUE
					SET_CHAR_STAY_IN_SAME_PLACE mafia_10X TRUE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_10X player
					mafia_10_kill_player_flag = 6
				ENDIF
			ENDIF

		ENDIF
	ENDIF

	IF NOT mafia_9_flag = 4
		IF NOT mafia_9_flag = 0
			
			IF mafia_9_flag > 1
			AND mafia_9_kill_player_flag = 0
				SET_CHAR_STAY_IN_SAME_PLACE mafia_9X TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_9X player
				mafia_9_kill_player_flag = 1
			ENDIF

		ENDIF
	ENDIF

	IF NOT mafia_8_flag = 4
		IF NOT mafia_8_flag = 0
			
			IF mafia_8_flag > 1
			AND mafia_8_kill_player_flag = 0
				SET_CHAR_STAY_IN_SAME_PLACE mafia_8X TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_8X player
				mafia_8_kill_player_flag = 1
			ENDIF

		ENDIF
	ENDIF

	IF frankie_exists_flag = 0
		IF timerb_reset_flag_a1 = 0
			TIMERB = 0
			timerb_reset_flag_a1 = 1
		ENDIF
		IF timerb_reset_flag_a1 = 1
			IF TIMERB > 30000
				IF time_left_a1 < 1				
					frankie_exists_flag = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF mafia_10_kill_player_flag = 6
	OR mafia_10_flag = 4
		IF mafia_11_kill_player_flag = 7
		OR mafia_11_flag = 4
			IF mafia_12_kill_player_flag = 7
			OR mafia_12_flag = 4
				IF mafia_13_kill_player_flag = 8
				OR mafia_13_flag = 4
					IF time_left_a1 < 1
						IF frankie_exists_flag = 0
							frankie_exists_flag = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

RETURN
ELSE

	IF NOT mafia_8_flag = 4
		IF NOT mafia_8_flag = 0
			IF mafia_8_kill_player_flag = 1
				SET_CHAR_USE_PEDNODE_SEEK mafia_8X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_8X FALSE
				mafia_8_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_9_flag = 4
		IF NOT mafia_9_flag = 0
			IF mafia_9_kill_player_flag = 1
				SET_CHAR_USE_PEDNODE_SEEK mafia_9X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_9X FALSE
				mafia_9_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_10_flag = 4
		IF NOT mafia_10_flag = 0
			IF mafia_10_kill_player_flag = 6
				SET_CHAR_USE_PEDNODE_SEEK mafia_10X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_10X FALSE
				mafia_10_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_11_flag = 4
		IF NOT mafia_11_flag = 0
			IF mafia_11_kill_player_flag = 7
				SET_CHAR_USE_PEDNODE_SEEK mafia_11X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_11X FALSE
				mafia_11_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_12_flag = 4
		IF NOT mafia_12_flag = 0
			IF mafia_12_kill_player_flag = 7
				SET_CHAR_USE_PEDNODE_SEEK mafia_12X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_12X FALSE
				mafia_12_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_13_flag = 4
		IF NOT mafia_13_flag = 0
			IF mafia_13_kill_player_flag = 8
				SET_CHAR_USE_PEDNODE_SEEK mafia_13X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_13X FALSE
				mafia_13_kill_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

ENDIF

IF IS_PLAYER_IN_AREA_2D player 920.0792 -408.8181 931.3213 -398.101 0 //ON TOP OF SNIPER BUILDING OVER ROAD
	
	IF NOT mafia_5_kill_player_flag = -100
		IF NOT IS_CHAR_DEAD	mafia_5X
			IF mafia_5_kill_player_flag = 0
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 919.2639 -397.0023 //CORNER OF STREET
				mafia_5_kill_player_flag = 1
			ENDIF
		ELSE
			mafia_5_kill_player_flag = -100
		ENDIF

		IF mafia_5_kill_player_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 919.2639 -397.0023 1.0 1.0 0	//CORNER OF STREET
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 958.4280 -397.0979 //IN FRONT OF ALLEY
				mafia_5_kill_player_flag = 2
			ENDIF
		ENDIF

		IF mafia_5_kill_player_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 958.4280 -397.0979 1.0 1.0 0	//IN FRONT OF ALLEY
				SET_CHAR_USE_PEDNODE_SEEK mafia_5X FALSE
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 958.0251 -416.7367 //BOTTOM OF STEPS
				mafia_5_kill_player_flag = 3
			ENDIF
		ENDIF

		IF mafia_5_kill_player_flag = 3
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 958.0251 -416.7367 1.0 1.0 0	//BOTTOM OF STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 949.0732 -416.6061 //LANDING ON STEPS
				mafia_5_kill_player_flag = 4
			ENDIF
		ENDIF

		IF mafia_5_kill_player_flag = 4
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 949.0732 -416.6061 1.0 1.0 0	//LANDING ON STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 948.9913 -407.5764 //TOP OF STEPS
				mafia_5_kill_player_flag = 5
			ENDIF
		ENDIF

		IF mafia_5_kill_player_flag = 5
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 948.9913 -407.5764 1.0 1.0 0 //TOP OF STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_5X 929.8204 -404.7728 //ON THE SNIPER ROOF
				mafia_5_kill_player_flag = 6
			ENDIF
		ENDIF

		IF mafia_5_kill_player_flag = 6
			IF LOCATE_CHAR_ON_FOOT_2D mafia_5X 929.8204 -404.7728 1.0 1.0 0 //ON THE SNIPER ROOF
				SET_CHAR_STAY_IN_SAME_PLACE	mafia_5X TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_5X player
				SET_CHAR_USE_PEDNODE_SEEK mafia_5X TRUE
				mafia_5_kill_player_flag = 7
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_7_kill_player_flag = -100
		IF NOT IS_CHAR_DEAD	mafia_7X
			IF mafia_7_kill_player_flag = 0
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 919.2639 -397.0023 //CORNER OF STREET
				mafia_7_kill_player_flag = 1
			ENDIF
		ELSE
			mafia_7_kill_player_flag = -100
		ENDIF

		IF mafia_7_kill_player_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 919.2639 -397.0023 1.0 1.0 0	//CORNER OF STREET
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 958.4280 -397.0979 //IN FRONT OF ALLEY
				mafia_7_kill_player_flag = 2
			ENDIF
		ENDIF

		IF mafia_7_kill_player_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 958.4280 -397.0979 1.0 1.0 0	//IN FRONT OF ALLEY
				SET_CHAR_USE_PEDNODE_SEEK mafia_7X FALSE
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 958.0251 -416.7367 //BOTTOM OF STEPS
				mafia_7_kill_player_flag = 3
			ENDIF
		ENDIF

		IF mafia_7_kill_player_flag = 3
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 958.0251 -416.7367 1.0 1.0 0	//BOTTOM OF STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 949.0732 -416.6061 //LANDING ON STEPS
				mafia_7_kill_player_flag = 4
			ENDIF
		ENDIF

		IF mafia_7_kill_player_flag = 4
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 949.0732 -416.6061 1.0 1.0 0	//LANDING ON STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 948.9913 -407.5764 //TOP OF STEPS
				mafia_7_kill_player_flag = 5
			ENDIF
		ENDIF

		IF mafia_7_kill_player_flag = 5
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 948.9913 -407.5764 1.0 1.0 0 //TOP OF STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_7X 930.0654 -407.9679 //ON THE SNIPER ROOF
				mafia_7_kill_player_flag = 6
			ENDIF
		ENDIF

		IF mafia_7_kill_player_flag = 6
			IF LOCATE_CHAR_ON_FOOT_2D mafia_7X 930.0654 -407.9679 1.0 1.0 0 //ON THE SNIPER ROOF
				SET_CHAR_STAY_IN_SAME_PLACE	mafia_7X TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_7X player
				SET_CHAR_USE_PEDNODE_SEEK mafia_7X TRUE
				mafia_7_kill_player_flag = 7
			ENDIF
		ENDIF
	ENDIF

	IF mafia_15_kill_player_flag = 0
		IF NOT IS_POINT_ON_SCREEN 949.0732 -416.6061 19.5 2.0 
			CREATE_CHAR PEDTYPE_GANG_MAFIA PED_GANG_MAFIA_B 958.0251 -416.7367 14.2 mafia_15X //BOTTOM OF STEPS	
			SET_CHAR_PERSONALITY mafia_15X PEDSTAT_TOUGH_GUY
			GIVE_WEAPON_TO_CHAR mafia_15X WEAPONTYPE_SHOTGUN 999
			SET_CHAR_USE_PEDNODE_SEEK mafia_15X FALSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mafia_15X 949.0732 -416.6061 //LANDING ON STEPS
			mafia_15_kill_player_flag = 1
		ENDIF
	ENDIF

	IF NOT mafia_15_kill_player_flag = -100
		
		IF mafia_15_kill_player_flag > 0
			IF IS_CHAR_DEAD	mafia_15X
				mafia_15_kill_player_flag = -100
			ENDIF
		ENDIF

		IF mafia_15_kill_player_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D mafia_15X	949.0732 -416.6061 1.0 1.0 0 //LANDING ON STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_15X	948.9913 -407.5764 //TOP OF STEPS
				mafia_15_kill_player_flag = 2
			ENDIF
		ENDIF

		IF mafia_15_kill_player_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D mafia_15X	948.9913 -407.5764 1.0 1.0 0 //TOP OF STEPS
				SET_CHAR_OBJ_RUN_TO_COORD mafia_15X	929.5118 -406.6480 //ON THE SNIPER ROOF
				mafia_15_kill_player_flag = 3
			ENDIF
		ENDIF

		IF mafia_15_kill_player_flag = 3
			IF LOCATE_CHAR_ON_FOOT_2D mafia_15X	929.5118 -406.6480 1.0 1.0 0 //ON THE SNIPER ROOF
				SET_CHAR_STAY_IN_SAME_PLACE	mafia_15X TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_15X player
				SET_CHAR_USE_PEDNODE_SEEK mafia_15X TRUE
				mafia_15_kill_player_flag = 4
			ENDIF
		ENDIF
	ENDIF
			
	IF mafia_15_kill_player_flag = 4
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF mafia_5_kill_player_flag = 7
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF mafia_7_kill_player_flag = 7
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF mafia_5_kill_player_flag = -100
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF mafia_7_kill_player_flag = -100
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF mafia_15_kill_player_flag = -100
		IF NOT frankie_exists_flag = 0
			frankie_exists_flag = 3
		ENDIF
	ENDIF

	IF frankie_exists_flag = 0
		IF timerb_reset_flag_a1 = 0
			TIMERB = 0
			timerb_reset_flag_a1 = 1
		ENDIF
		IF timerb_reset_flag_a1 = 1
			IF TIMERB > 15000
				IF time_left_a1 < 1
					frankie_exists_flag = 3
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
RETURN
ELSE

	IF NOT mafia_5_kill_player_flag = -100
		IF NOT mafia_5_kill_player_flag = 0
			IF NOT IS_CHAR_DEAD	mafia_5X
				SET_CHAR_USE_PEDNODE_SEEK mafia_5X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_5X FALSE
				mafia_5_kill_player_flag = 0
			ELSE
				mafia_5_kill_player_flag = -100
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_7_kill_player_flag = -100
		IF NOT mafia_7_kill_player_flag = 0
			IF NOT IS_CHAR_DEAD	mafia_7X
				SET_CHAR_USE_PEDNODE_SEEK mafia_7X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_7X FALSE
				mafia_7_kill_player_flag = 0
			ELSE
				mafia_7_kill_player_flag = -100
			ENDIF
		ENDIF
	ENDIF

	IF NOT mafia_15_kill_player_flag = -100
		IF NOT mafia_15_kill_player_flag = 0
			IF NOT IS_CHAR_DEAD	mafia_15X
				SET_CHAR_USE_PEDNODE_SEEK mafia_15X TRUE
				SET_CHAR_STAY_IN_SAME_PLACE mafia_15X FALSE
				mafia_15_kill_player_flag = -100
			ELSE
				mafia_15_kill_player_flag = -100
			ENDIF
		ENDIF
	ENDIF

ENDIF

IF IS_PLAYER_IN_AREA_2D player 878.79 -427.4 890.77 -403.89 0 //BACK OF CLUB
OR IS_PLAYER_IN_AREA_3D player 890.77 -427.4 13.0 900.0 -423.82 18.9 0//ALLEYWAY
OR IS_PLAYER_IN_AREA_2D player 900.0 -443.0 927.0 -378.0 0 //FRONT OF CLUB
	
	IF NOT mafia_8_flag = 4
		IF NOT mafia_8_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_8X player
		ENDIF
	ENDIF

	IF NOT mafia_9_flag = 4
		IF NOT mafia_9_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_9X player
		ENDIF
	ENDIF

	IF NOT mafia_10_flag = 4
		IF NOT mafia_10_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_10X player
		ENDIF
	ENDIF

	IF NOT mafia_11_flag = 4
		IF NOT mafia_11_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_11X player
		ENDIF
	ENDIF

	IF NOT mafia_12_flag = 4
		IF NOT mafia_12_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_12X player
		ENDIF
	ENDIF

	IF NOT mafia_13_flag = 4
		IF NOT mafia_13_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_13X player
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_AREA_2D player 900.0 -443.0 927.0 -378.0 0 //FRONT OF CLUB
		IF NOT IS_CHAR_DEAD	mafia_5X
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_5X player
		ENDIF

		IF NOT IS_CHAR_DEAD	mafia_7X
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT mafia_7X player
		ENDIF
	ENDIF

	IF frankie_exists_flag = 0
		IF timerb_reset_flag_a1 = 0
			TIMERB = 0
			timerb_reset_flag_a1 = 1
		ENDIF
		IF timerb_reset_flag_a1 = 1
			IF TIMERB > 25000
				IF time_left_a1 < 1
					frankie_exists_flag = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
RETURN
ENDIF

kill_player_now_flag = 0

RETURN

move_fuckers_car:

SET_CAR_DRIVING_STYLE fuckers_car 2
SET_CAR_CRUISE_SPEED fuckers_car 20.0
IF IS_PLAYER_IN_AREA_2D player 878.79 -427.4 890.77 -403.89 0 //BACK OF CLUB
OR IS_PLAYER_IN_AREA_3D player 890.77 -427.4 13.0 900.0 -423.82 18.9 0//ALLEYWAY
OR IS_PLAYER_IN_AREA_2D player 845.75 -443.85 890.77 -433.86 0 //HIGHER ROOF
OR IS_PLAYER_IN_AREA_2D player 878.79 -433.86 890.77 -427.4 0 //LOWER ROOF
OR IS_PLAYER_IN_AREA_3D player 890.77 -433.71 23.05 900.78 -403.76 46.0 0 //CLUB ROOF
	CAR_WANDER_RANDOMLY fuckers_car
	SET_CAR_AVOID_LEVEL_TRANSITIONS fuckers_car TRUE
ELSE
	SET_CAR_MISSION fuckers_car MISSION_RAMPLAYER_FARAWAY
ENDIF

RETURN

}


MISSION_START
// *****************************************************************************************
// ************************************   Ray 6    ***************************************** 
// ************************************ Marked Man *****************************************
// *****************************************************************************************
// *** The CIA is making money from Cartel deals and is concerned that the Yakuza are 	 ***
// *** hindering the operation. They've discovered that Ray is helping them and they've  ***
// *** decided to 'rub him out'. Ray is running scared and needs a ride to the airport.  ***
// *** His contact point is empty, but the player will get a pager message. The player is*** 
// *** followed by the C.I.A Ray is dressed in a Hawaiian shirt and has two cases packed.*** 
// *** He's booked on a flight (timed mission). The CIA give chase.						 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray6

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray6_failed
ENDIF

GOSUB mission_cleanup_ray6

MISSION_END
 
// Variables for mission

VAR_INT	time_till_flight flag_blip_on_ray rays_blip	total_cia player_death_car airport_door_flag door1_closed door2_closed
VAR_INT cia_1 cia_1_flag
VAR_INT cia_2 cia_2_flag
VAR_INT cia_3 cia_3_flag
VAR_INT cia_4 cia_4_flag
VAR_INT cia_5 cia_5_flag
VAR_INT cia_6 cia_6_flag
VAR_INT cia_7 cia_7_flag
VAR_INT cia_8 cia_8_flag
VAR_INT cia_9 cia_9_flag
VAR_INT cia_10 cia_10_flag
VAR_INT cia_11 cia_11_flag
VAR_INT cia_12 cia_12_flag
VAR_INT cia_13 cia_13_flag
VAR_INT cia_14 cia_14_flag
VAR_INT cia_15 cia_15_flag
VAR_INT cia_16 cia_16_flag
VAR_INT cia_17 cia_17_flag
VAR_INT	rays_prize_car rays_prize_weapon1 rays_prize_weapon2 rays_prize_weapon3 rays_prize_weapon4 rays_cash pickups_created_rm6


// ****************************************Mission Start************************************

mission_start_ray6:

flag_player_on_mission 	   = 1
flag_player_on_ray_mission = 1
rays_cutscene_flag = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME ray6

time_till_flight = 180000
flag_blip_on_ray = 0
airport_door_flag = 0
door1_closed = 0
door2_closed = 0
total_cia = 0
pickups_created_rm6 = 0
cia_1_flag  = 0
cia_2_flag  = 0
cia_3_flag  = 0
cia_4_flag  = 0
cia_5_flag  = 0
cia_6_flag  = 0
cia_7_flag  = 0
cia_8_flag  = 0
cia_9_flag  = 0
cia_10_flag = 0
cia_11_flag = 0
cia_12_flag = 0
cia_13_flag = 0
cia_14_flag = 0
cia_15_flag = 0
cia_16_flag = 0
cia_17_flag = 0

// ****************************************START OF CUTSCENE********************************

//SET_FADING_COLOUR 0 0 0
//
//DO_FADE 1500 FADE_OUT
//
//IF CAN_PLAYER_START_MISSION player
//	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
//ELSE
//	GOTO mission_ray6_failed
//ENDIF
//
//PRINT_BIG RM6 15000 2 //"Marked Man"

LOAD_SPECIAL_CHARACTER 1 ray
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 RAYH
REQUEST_MODEL toilet

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED toilet
	WAIT 0
ENDWHILE

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0

LOAD_CUTSCENE r6_mm

SET_CUTSCENE_OFFSET 39.424 -726.677 21.692

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_ray

SET_CUTSCENE_ANIM cs_ray ray

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray

//SET_PLAYER_COORDINATES player 38.7 -725.7 22.0
//
//SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

SET_NEAR_CLIP 0.2

START_CUTSCENE

SWITCH_STREAMING OFF
SWITCH_RUBBISH OFF
// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1807
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_A 4000 1 //"You weren't followed? Good."

WHILE cs_time < 4920
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_B 4000 1 //"This is it, I'm in way over my fucking head and I'm starting to fucking drown here!"

WHILE cs_time < 8597
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_C 4000 1 //"The CIA seem to have a vested interest in SPANK"

WHILE cs_time < 11482
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_C1 4000 1 //"and they don't like us fucking with the Cartel!"

WHILE cs_time < 14220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_D	4000 1 //"I'm a marked man, so I'm getting out of here."

WHILE cs_time < 17464
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM6_E	4000 1 //"Get me to my flight at the airport and I'll make it worth your while!!"

WHILE cs_time < 21666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT
SET_NEAR_CLIP 0.9

SET_CAMERA_BEHIND_PLAYER

MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED toilet
REQUEST_MODEL PED_B_MAN3

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED PED_B_MAN3
	WAIT 0
ENDWHILE

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 38.7 -727.7 22.0 ray
ADD_ARMOUR_TO_CHAR ray 100

SET_PLAYER_AS_LEADER ray player

SWITCH_STREAMING ON
DO_FADE 1500 FADE_IN 
rays_cutscene_flag = 0

// ******************************************END OF CUTSCENE********************************

DISPLAY_ONSCREEN_TIMER time_till_flight

ADD_BLIP_FOR_COORD -739.0 -583.0 -100.0 rays_blip

IF IS_CHAR_DEAD ray
	PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
	GOTO mission_ray6_failed
ENDIF

SET_CHAR_RUNNING ray TRUE 

PRINT_NOW RM6_5 15000 1 //"The CIA have the bridge under surveillance, find another route across."

WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_2D ray -738.3010 -582.8834 8.0 8.0 1
	
	WAIT 0

	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF
	
	IF time_till_flight < 1
		PRINT_NOW RM6_7 5000 1//"~r~Ray has missed his flight."
		GOTO mission_ray6_failed
	ENDIF

	////////	

	IF total_cia < 16
		IF cia_1_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -25.8545 -612.5001 100.0 100.0 0 // Commercial End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -25.8545 -612.5001 42.1683 cia_1
				SET_CHAR_HEADING cia_1 239.6049
				GIVE_WEAPON_TO_CHAR cia_1 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_1 TRUE
				CHAR_SET_IDLE cia_1
				SET_CHAR_PERSONALITY cia_1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_1 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_1 TRUE
				ADD_ARMOUR_TO_CHAR cia_1 100
				++ total_cia
				cia_1_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_1_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -25.8545 -612.5001 100.0 100.0 0
			DELETE_CHAR cia_1
			-- total_cia
			cia_1_flag = 0
		ENDIF
	ENDIF

	IF cia_1_flag = 1
		IF IS_CHAR_DEAD cia_1
			cia_1_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_1 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_1 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_1 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_1	player
			ENDIF
		ENDIF
	ENDIF

	////////

	IF total_cia < 16
		IF cia_2_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -24.0225 -630.3363 100.0 100.0 0 // Commercial End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -24.0225 -630.3363 42.1125 cia_2
				SET_CHAR_HEADING cia_2 293.6046
				GIVE_WEAPON_TO_CHAR cia_2 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_2 TRUE
				CHAR_SET_IDLE cia_2
				SET_CHAR_PERSONALITY cia_2 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_2 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_2 TRUE
				ADD_ARMOUR_TO_CHAR cia_2 100
				++ total_cia
				cia_2_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_2_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -24.0225 -630.3363 100.0 100.0 0
			DELETE_CHAR cia_2
			-- total_cia
			cia_2_flag = 0
		ENDIF
	ENDIF

	IF cia_2_flag = 1
		IF IS_CHAR_DEAD cia_2
			cia_2_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_2 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_2 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_2 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_2	player
			ENDIF
		ENDIF
	ENDIF

	////////

	IF total_cia < 16
		IF cia_3_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -35.1159 -632.8395 100.0 100.0 0 // Commercial End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -35.1159 -632.8395 42.4257 cia_3
				SET_CHAR_HEADING cia_3 255.4109
				GIVE_WEAPON_TO_CHAR cia_3 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_3 TRUE
				CHAR_SET_IDLE cia_3
				SET_CHAR_PERSONALITY cia_3 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_3 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_3 TRUE
				ADD_ARMOUR_TO_CHAR cia_3 100
				++ total_cia
				cia_3_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_3_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -35.1159 -632.8395 100.0 100.0 0
			DELETE_CHAR cia_3
			-- total_cia
			cia_3_flag = 0
		ENDIF
	ENDIF

	IF cia_3_flag = 1
		IF IS_CHAR_DEAD cia_3
			cia_3_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_3 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_3 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_3 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_3	player
			ENDIF
		ENDIF
	ENDIF
			
	////////

	IF total_cia < 16
		IF cia_4_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -24.3022 -650.4634 100.0 100.0 0 // Commercial End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -24.3022 -650.4634 46.5876 cia_4
				SET_CHAR_HEADING cia_4 344.2893
				GIVE_WEAPON_TO_CHAR cia_4 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_4 TRUE
				CHAR_SET_IDLE cia_4
				SET_CHAR_PERSONALITY cia_4 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_4 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_4 TRUE
				ADD_ARMOUR_TO_CHAR cia_4 100
				++ total_cia
				cia_4_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_4_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -24.3022 -650.4634 100.0 100.0 0
			DELETE_CHAR cia_4
			-- total_cia
			cia_4_flag = 0
		ENDIF
	ENDIF

	IF cia_4_flag = 1
		IF IS_CHAR_DEAD cia_4
			cia_4_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_4 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_4 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_4 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_4	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_5_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -217.9545 -630.4070 100.0 100.0 0 // Commercial End of lift bridge, by lift bit
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -217.9545 -630.4070 45.9975 cia_5
				SET_CHAR_HEADING cia_5 344.2893
				GIVE_WEAPON_TO_CHAR cia_5 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_5 TRUE
				CHAR_SET_IDLE cia_5
				SET_CHAR_PERSONALITY cia_5 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_5 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_5 TRUE
				ADD_ARMOUR_TO_CHAR cia_5 100
				++ total_cia
				cia_5_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_5_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -217.9545 -630.4070 100.0 100.0 0
			DELETE_CHAR cia_5
			-- total_cia
			cia_5_flag = 0
		ENDIF
	ENDIF

	IF cia_5_flag = 1
		IF IS_CHAR_DEAD cia_5
			cia_5_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_5 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_5 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_5 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_5	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_6_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -212.4922 -632.7455 100.0 100.0 0 // Commercial End of lift bridge, by lift bit
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -212.4922 -632.7455 45.9514 cia_6
				SET_CHAR_HEADING cia_6 247.0256
				GIVE_WEAPON_TO_CHAR cia_6 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_6 TRUE
				CHAR_SET_IDLE cia_6
				SET_CHAR_PERSONALITY cia_6 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_6 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_6 TRUE
				ADD_ARMOUR_TO_CHAR cia_6 100
				++ total_cia
				cia_6_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_6_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -212.4922 -632.7455 100.0 100.0 0
			DELETE_CHAR cia_6
			-- total_cia
			cia_6_flag = 0
		ENDIF
	ENDIF

	IF cia_6_flag = 1
		IF IS_CHAR_DEAD cia_6
			cia_6_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_6 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_6 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_6 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_6	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_7_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -437.0927 -612.5157 100.0 100.0 0 // Suburban End of lift bridge, by lift bit
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -437.0927 -612.5157 44.5994 cia_7
				SET_CHAR_HEADING cia_7 247.0256
				GIVE_WEAPON_TO_CHAR cia_7 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_7 TRUE
				CHAR_SET_IDLE cia_7
				SET_CHAR_PERSONALITY cia_7 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_7 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_7 TRUE
				ADD_ARMOUR_TO_CHAR cia_7 100
				++ total_cia
				cia_7_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_7_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -437.0927 -612.5157 100.0 100.0 0
			DELETE_CHAR cia_7
			-- total_cia
			cia_7_flag = 0
		ENDIF
	ENDIF

	IF cia_7_flag = 1
		IF IS_CHAR_DEAD cia_7
			cia_7_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_7 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_7 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_7 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_7	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_8_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -534.6777 -631.2995 100.0 100.0 0 // Suburban End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -534.6777 -631.2995 42.2770 cia_8
				SET_CHAR_HEADING cia_8 247.0256
				GIVE_WEAPON_TO_CHAR cia_8 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_8 TRUE
				CHAR_SET_IDLE cia_8
				SET_CHAR_PERSONALITY cia_8 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_8 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_8 TRUE
				ADD_ARMOUR_TO_CHAR cia_8 100
				++ total_cia
				cia_8_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_8_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -534.6777 -631.2995 100.0 100.0 0
			DELETE_CHAR cia_8
			-- total_cia
			cia_8_flag = 0
		ENDIF
	ENDIF

	IF cia_8_flag = 1
		IF IS_CHAR_DEAD cia_8
			cia_8_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_8 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_8 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_8 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_8	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_9_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -523.4218 -650.3831 100.0 100.0 0 // Suburban End of lift bridge
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -523.4218 -650.3831 42.5261 cia_9
				SET_CHAR_HEADING cia_9 316.7352
				GIVE_WEAPON_TO_CHAR cia_9 WEAPONTYPE_M16 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_9 TRUE
				CHAR_SET_IDLE cia_9
				SET_CHAR_PERSONALITY cia_9 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_9 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_9 TRUE
				ADD_ARMOUR_TO_CHAR cia_9 100
				++ total_cia
				cia_9_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_9_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -523.4218 -650.3831 100.0 100.0 0
			DELETE_CHAR cia_9
			-- total_cia
			cia_9_flag = 0
		ENDIF
	ENDIF

	IF cia_9_flag = 1
		IF IS_CHAR_DEAD cia_9
			cia_9_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_9 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_9 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_9 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_9	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_10_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -628.0785 -498.4106 100.0 100.0 0 // ontop of tunnel exit out
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -628.0785 -498.4106 22.3884 cia_10
				SET_CHAR_HEADING cia_10 76.5552
				GIVE_WEAPON_TO_CHAR cia_10 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_10 TRUE
				CHAR_SET_IDLE cia_10
				SET_CHAR_PERSONALITY cia_10 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_10 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_10 TRUE
				ADD_ARMOUR_TO_CHAR cia_10 100
				++ total_cia
				cia_10_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_10_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -628.0785 -498.4106 100.0 100.0 0
			DELETE_CHAR cia_10
			-- total_cia
			cia_10_flag = 0
		ENDIF
	ENDIF

	IF cia_10_flag = 1
		IF IS_CHAR_DEAD cia_10
			cia_10_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_10 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_10 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_10 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_10	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_11_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -637.6517 -501.7922 100.0 100.0 0 // ontop of tunnel exit out
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -637.6517 -501.7922 22.3455 cia_11
				SET_CHAR_HEADING cia_11 76.5552
				GIVE_WEAPON_TO_CHAR cia_11 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_11 TRUE
				CHAR_SET_IDLE cia_11
				SET_CHAR_PERSONALITY cia_11 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_11 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_11 TRUE
				ADD_ARMOUR_TO_CHAR cia_11 100
				++ total_cia
				cia_11_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_11_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -637.6517 -501.7922 100.0 100.0 0
			DELETE_CHAR cia_11
			-- total_cia
			cia_11_flag = 0
		ENDIF
	ENDIF

	IF cia_11_flag = 1
		IF IS_CHAR_DEAD cia_11
			cia_11_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_11 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_11 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_11 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_11	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_12_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -692.3098 -563.0333 100.0 100.0 0 // ontop of tunnel exit in
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -692.3098 -563.0333 21.5110 cia_12
				SET_CHAR_HEADING cia_12 344.2857
				GIVE_WEAPON_TO_CHAR cia_12 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_12 TRUE
				CHAR_SET_IDLE cia_12
				SET_CHAR_PERSONALITY cia_12 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_12 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_12 TRUE
				ADD_ARMOUR_TO_CHAR cia_12 100
				++ total_cia
				cia_12_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_12_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -692.3098 -563.0333 100.0 100.0 0
			DELETE_CHAR cia_12
			-- total_cia
			cia_12_flag = 0
		ENDIF
	ENDIF

	IF cia_12_flag = 1
		IF IS_CHAR_DEAD cia_12
			cia_12_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_12 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_12 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_12 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_12	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_13_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -671.1359 -540.5952 100.0 100.0 0 //Suburban End of lift bridge by tunnel exit in
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -671.1359 -540.5952 22.9211 cia_13
				SET_CHAR_HEADING cia_13 281.8996
				GIVE_WEAPON_TO_CHAR cia_13 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_13 TRUE
				CHAR_SET_IDLE cia_13
				SET_CHAR_PERSONALITY cia_13 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_13 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_13 TRUE
				ADD_ARMOUR_TO_CHAR cia_13 100
				++ total_cia
				cia_13_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_13_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -671.1359 -540.5952 100.0 100.0 0
			DELETE_CHAR cia_13
			-- total_cia
			cia_13_flag = 0
		ENDIF
	ENDIF

	IF cia_13_flag = 1
		IF IS_CHAR_DEAD cia_13
			cia_13_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_13 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_13 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_13 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_13	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_14_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -638.4215 -419.2620 100.0 100.0 0 //Opposite turning into the airport
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -638.4215 -419.2620 17.8198 cia_14
				SET_CHAR_HEADING cia_14 113.6173
				GIVE_WEAPON_TO_CHAR cia_14 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_14 TRUE
				CHAR_SET_IDLE cia_14
				SET_CHAR_PERSONALITY cia_14 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_14 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_14 TRUE
				ADD_ARMOUR_TO_CHAR cia_14 100
				++ total_cia
				cia_14_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_14_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -638.4215 -419.2620 100.0 100.0 0
			DELETE_CHAR cia_14
			-- total_cia
			cia_14_flag = 0
		ENDIF
	ENDIF

	IF cia_14_flag = 1
		IF IS_CHAR_DEAD cia_14
			cia_14_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_14 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_14 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_14 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_14	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_15_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -655.3353 -404.4556 100.0 100.0 0 //On concrete island	opposite turning into the airport
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -655.3353 -404.4556 17.8198 cia_15
				SET_CHAR_HEADING cia_15 191.1247
				GIVE_WEAPON_TO_CHAR cia_15 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_15 TRUE
				CHAR_SET_IDLE cia_15
				SET_CHAR_PERSONALITY cia_15 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_15 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_15 TRUE
				ADD_ARMOUR_TO_CHAR cia_15 100
				++ total_cia
				cia_15_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_15_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -655.3353 -404.4556 100.0 100.0 0
			DELETE_CHAR cia_15
			-- total_cia
			cia_15_flag = 0
		ENDIF
	ENDIF

	IF cia_15_flag = 1
		IF IS_CHAR_DEAD cia_15
			cia_15_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_15 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_15 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_15 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_15	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_16_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -677.0261 -425.0470 100.0 100.0 0 // up on grass by airport turning
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -677.0261 -425.0470 18.5140 cia_16
				SET_CHAR_HEADING cia_16 265.4145
				GIVE_WEAPON_TO_CHAR cia_16 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_16 TRUE
				CHAR_SET_IDLE cia_16
				SET_CHAR_PERSONALITY cia_16 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_16 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_16 TRUE
				ADD_ARMOUR_TO_CHAR cia_16 100
				++ total_cia
				cia_16_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_16_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -677.0261 -425.0470 100.0 100.0 0
			DELETE_CHAR cia_16
			-- total_cia
			cia_16_flag = 0
		ENDIF
	ENDIF

	IF cia_16_flag = 1
		IF IS_CHAR_DEAD cia_16
			cia_16_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_16 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_16 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_16 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_16	player
			ENDIF
		ENDIF
	ENDIF
	
	////////

	IF total_cia < 16
		IF cia_17_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player -679.1292 -485.1575 100.0 100.0 0 //on wall by tunnel exit in
				CREATE_CHAR PEDTYPE_CIVMALE PED_B_MAN3 -679.1292 -485.1575 18.2578 cia_17
				SET_CHAR_HEADING cia_17 260.2034
				GIVE_WEAPON_TO_CHAR cia_17 WEAPONTYPE_UZI 9999
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER	cia_17 TRUE
				CHAR_SET_IDLE cia_17
				SET_CHAR_PERSONALITY cia_17 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cia_17 THREAT_PLAYER1
				SET_CHAR_STAY_IN_SAME_PLACE cia_17 TRUE
				ADD_ARMOUR_TO_CHAR cia_17 100
				++ total_cia
				cia_17_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF cia_17_flag = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player -679.1292 -485.1575 100.0 100.0 0
			DELETE_CHAR cia_17
			-- total_cia
			cia_17_flag = 0
		ENDIF
	ENDIF

	IF cia_17_flag = 1
		IF IS_CHAR_DEAD cia_17
			cia_17_flag = 2
		ELSE
			IF LOCATE_PLAYER_IN_CAR_CHAR_2D	player cia_17 40.0 40.0 0
				STORE_CAR_PLAYER_IS_IN player player_death_car
				SET_CHAR_OBJ_DESTROY_CAR cia_17 player_death_car
			ENDIF
			IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player cia_17 40.0 40.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cia_17	player
			ENDIF
		ENDIF
	ENDIF

	////////
	
	IF NOT IS_CHAR_IN_PLAYERS_GROUP ray player
	AND flag_blip_on_ray = 0
		PRINT_NOW RM6_8 5000 1 //"You have left Ray behind, go back and get him."
		REMOVE_BLIP rays_blip
		ADD_BLIP_FOR_CHAR ray rays_blip
		flag_blip_on_ray = 1
	ENDIF

	IF flag_blip_on_ray = 1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player ray 8.0 8.0 FALSE
			SET_PLAYER_AS_LEADER ray player
			REMOVE_BLIP rays_blip
			ADD_BLIP_FOR_COORD -739.0 -583.0 8.0 rays_blip
			flag_blip_on_ray = 0
		ENDIF
	ENDIF

ENDWHILE

REMOVE_BLIP	rays_blip

CLEAR_ONSCREEN_TIMER time_till_flight

SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player ON
//SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SWITCH_WIDESCREEN ON
SET_FIXED_CAMERA_POSITION -732.0104 -571.0955 14.0482 0.0 0.0 0.0
POINT_CAMERA_AT_CHAR ray FIXED JUMP_CUT

IF NOT IS_CHAR_IN_ANY_CAR ray
OR NOT IS_PLAYER_IN_ANY_CAR player
	TURN_CHAR_TO_FACE_PLAYER ray player
	GET_PLAYER_CHAR player script_controlled_player
	TURN_CHAR_TO_FACE_CHAR script_controlled_player	ray
ENDIF

LOAD_MISSION_AUDIO R6_A

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	
	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW RM6_1 5000 1	//"Here's a key to a lock-up."

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	
	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF

ENDWHILE

LOAD_MISSION_AUDIO R6_A1

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	
	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW RM6_2 5000 1	//"You'll find some cash and some 'supplies' I'd stashed in case things got tight."

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	
	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF

ENDWHILE

LOAD_MISSION_AUDIO R6_B

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	
	IF IS_CHAR_DEAD	ray
		PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
		GOTO mission_ray6_failed
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO
PRINT_NOW RM6_3 5000 1	//"See y'around."

IF IS_CHAR_IN_ANY_CAR ray
	LEAVE_GROUP ray
	STORE_CAR_CHAR_IS_IN ray player_death_car
	SET_CHAR_OBJ_LEAVE_CAR ray player_death_car
ENDIF

WHILE NOT airport_door_flag = 6
OR NOT door1_closed = 0
OR NOT door2_closed = 0

	WAIT 0

	IF NOT airport_door_flag = 6
		IF IS_CHAR_DEAD	ray
			PRINT_NOW RM6_6 5000 1//"~r~Ray is dead!"
			GOTO mission_ray6_failed
		ENDIF
	ENDIF

	IF airport_door_flag = 0
		IF NOT IS_CHAR_IN_ANY_CAR ray
			LEAVE_GROUP ray
			SET_CHAR_OBJ_RUN_TO_COORD ray -744.7192 -586.4615
			SET_FIXED_CAMERA_POSITION -751.3805 -603.0235 11.4096 0.0 0.0 0.0
			POINT_CAMERA_AT_CHAR ray FIXED JUMP_CUT
			airport_door_flag = 1
		ENDIF
	ENDIF

	IF airport_door_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D ray -744.7192 -586.4615 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD ray -757.1901 -587.2930
			airport_door_flag = 2
		ENDIF
	ENDIF

	IF airport_door_flag = 2
		IF LOCATE_CHAR_ON_FOOT_2D ray -757.1901 -587.2930 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD ray -768.0753 -599.4160
			airport_door_flag = 3
		ENDIF
	ENDIF

	IF airport_door_flag = 3
		IF LOCATE_CHAR_ON_FOOT_2D ray -768.0753 -599.4160 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD ray -772.6748 -600.3857
			airport_door_flag = 4
		ENDIF
	ENDIF

	IF airport_door_flag > 3 //open doors here
	AND door1_closed = 0
		IF SLIDE_OBJECT airportdoor1 -770.414 -597.865 11.847 0.1 0.1 0.1 0
			door1_closed = 1
		ENDIF
	ENDIF

	IF airport_door_flag > 3 //open doors here
	AND door2_closed = 0
		IF SLIDE_OBJECT airportdoor2 -770.414 -602.885 11.847 0.1 0.1 0.1 0
			door2_closed = 1
		ENDIF
	ENDIF

	IF airport_door_flag = 4
		IF LOCATE_CHAR_ON_FOOT_2D ray -772.6748 -600.3857 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD ray -772.6249 -604.7247
			airport_door_flag = 5
		ENDIF
	ENDIF

	IF airport_door_flag > 4 //CLOSE doors here
	AND	door1_closed = 1
		IF NOT IS_PLAYER_IN_AREA_2D player -773.75 -605.205 -768.76 -595.613 0 
			IF SLIDE_OBJECT airportdoor1 -770.414 -599.292 11.847 0.1 0.1 0.1 0
				door1_closed = 0
			ENDIF
		ENDIF
	ENDIF

	IF airport_door_flag > 4 //CLOSE doors here
	AND	door2_closed = 1
		IF NOT IS_PLAYER_IN_AREA_2D player -773.75 -605.205 -768.76 -595.613 0 
			IF SLIDE_OBJECT airportdoor2 -770.414 -601.369 11.846 0.1 0.1 0.1 0
				door2_closed = 0
			ENDIF
		ENDIF
	ENDIF

	IF airport_door_flag = 5
		IF LOCATE_CHAR_ON_FOOT_2D ray -772.6249 -604.7247 1.5 1.5 0
			SET_PLAYER_CONTROL player ON
			SWITCH_WIDESCREEN OFF
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CAMERA_JUMPCUT
			DELETE_CHAR ray
			airport_door_flag = 6
		ENDIF
	ENDIF

ENDWHILE

PRINT_NOW RM6_4 5000 1 //GO TO THE LOCKUP TO GET YOUR REWARD

ADD_BLIP_FOR_COORD 241.1441 -997.7660 20.9853 rays_blip

REQUEST_MODEL CAR_PATRIOT

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D PLAYER 241.1441 -997.7660 50.0 50.0 0
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CAR_PATRIOT
	WAIT 0
ENDWHILE

CREATE_CAR CAR_PATRIOT 241.1441 -997.7660 20.9853 rays_prize_car
//SET_CAR_COLOUR 256 256/WHITE
//SET_CAR_CANT_BE_RESPRAYED
//SET_CAR_DO_NOT_DELETE	maybe
SET_CAR_HEADING rays_prize_car 270.0
SET_CAR_PROOFS rays_prize_car TRUE FALSE FALSE FALSE FALSE
SET_CAR_STRONG rays_prize_car TRUE	
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ONCE 1000 244.0506 -993.9206 21.0 rays_prize_weapon1
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ONCE 1000 237.3226 -998.5697 21.0 rays_prize_weapon2  
CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ONCE 25 243.8931 -995.5624 21.0 rays_prize_weapon3  
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ONCE 50 241.2706 -993.6790 21.0 rays_prize_weapon4  
CREATE_MONEY_PICKUP 238.9743 -993.6944 21.0 20000 rays_cash

pickups_created_rm6 = 1 

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D PLAYER 230.2258 -996.4656 2.0 2.0 0
	WAIT 0
ENDWHILE

OPEN_GARAGE	rays_prize_garage

ADD_PAGER_MESSAGE RM6_666 140 666 1	//"Take care of my armoured Cheetah, I had it modified to be bullet proof. See you in Miami, Ray"

WAIT 13000

GOTO mission_ray6_passed
	   		
	
// Mission Ray 6 failed

mission_ray6_failed:

IF pickups_created_rm6 = 1
	REMOVE_PICKUP rays_prize_weapon1
	REMOVE_PICKUP rays_prize_weapon2
	REMOVE_PICKUP rays_prize_weapon3
	REMOVE_PICKUP rays_prize_weapon4
	REMOVE_PICKUP rays_cash
	DELETE_CAR rays_prize_car
	pickups_created_rm6 = 0
ENDIF
REMOVE_CHAR_ELEGANTLY ray
PRINT_BIG M_FAIL 5000 1
RETURN
   

// mission Ray 6 passed

mission_ray6_passed:

flag_ray_mission6_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 20000 2000 1
ADD_SCORE player 20000
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	RM6
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP ray_contact_blip
RETURN
		


// mission cleanup

mission_cleanup_ray6:

flag_player_on_mission = 0
flag_player_on_ray_mission = 0

IF DOES_OBJECT_EXIST airportdoor1
	SET_OBJECT_COORDINATES airportdoor1 -770.414 -599.292 11.847
ENDIF

IF DOES_OBJECT_EXIST airportdoor2
	SET_OBJECT_COORDINATES airportdoor2 -770.414 -601.369 11.846
ENDIF

IF IS_PLAYER_IN_AREA_2D player -773.75 -605.205 -768.76 -595.613 0
	SET_PLAYER_COORDINATES player -767.8299 -600.3843 11.0
	SET_PLAYER_HEADING player 270.0
ENDIF

CLEAR_ONSCREEN_TIMER time_till_flight
REMOVE_BLIP	rays_blip

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED PED_B_MAN3
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PATRIOT

MISSION_HAS_FINISHED
RETURN
		



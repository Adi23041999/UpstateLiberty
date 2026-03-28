MISSION_START
// *****************************************************************************************
// *******************************    Donald Love 6    ************************************* 
// *******************************    Swat the SWAT    *************************************
// *****************************************************************************************
// *** Ray has tipped off Love that the Liberty PD are going to mount a raid on his pad. ***
// *** Three SWAT vans are going to approach the contact point from different directions ***
// *** to trap any one escaping.  The player must take out the SWAT teams.				 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love6

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_love6_failed
ENDIF

GOSUB mission_cleanup_love6

MISSION_END
 
// Variables For Mission

VAR_INT	decoy_van swat_1 swat_2 swat_3 swat_4 swat_5 cop_1 cop_2 cop_3 	 //CARS
VAR_INT ped_swat_1 ped_swat_2 ped_swat_3 ped_swat_4 ped_swat_5 ped_swat_6 ped_swat_7 ped_swat_8 //SWAT PEDS
VAR_INT ped_cop_1 ped_cop_2 ped_cop_3 ped_cop_4 ped_cop_5 ped_cop_6 //COP PEDS
VAR_INT survival_time decoy_van_blip get_in_van decoy_van_health decoy_van_health2//TIMER BLIPS ETC
VAR_INT out_of_car_timer_present out_of_car_timer_start	out_of_car_timer out_of_car_timer_diff out_of_car_timer_secs

// ****************************************Mission Start************************************

mission_start_love6:

flag_player_on_mission = 1
flag_player_on_love_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME love6

get_in_van = 0
survival_time = 180000

// ****************************************START OF CUTSCENE********************************

//SET_FADING_COLOUR 0 0 0
//
//DO_FADE 1500 FADE_OUT
//
//IF CAN_PLAYER_START_MISSION player
//	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
//ELSE
//	GOTO mission_love6_failed
//ENDIF
//
//PRINT_BIG LOVE6	15000 2

LOAD_SPECIAL_CHARACTER 1 love2
LOAD_SPECIAL_MODEL cut_obj1 LOVEH
REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED tshrorckgrdn
OR NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED cut_obj1
	WAIT 0
ENDWHILE

LOAD_CUTSCENE D6_STS

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love
SET_CUTSCENE_ANIM cs_love love2

CREATE_CUTSCENE_HEAD cs_love CUT_OBJ1 cs_lovehead
SET_CUTSCENE_HEAD_ANIM cs_lovehead love

CLEAR_AREA 82.44 -1548.49 28.0 2.0 TRUE

SET_PLAYER_COORDINATES player 82.44 -1548.49 28.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

SWITCH_RUBBISH OFF

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1526
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_A 5000 1 //"A lesson in business, my friend;"

WHILE cs_time < 3011
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_E 5000 1 //"if you have a unique commodity, the world and his wife will try to wrestle it from your grasp."

WHILE cs_time < 7026
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_B 5000 1 //"Even if they have little understanding as to its true value."

WHILE cs_time < 10679
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_C 5000 1 //"SWAT teams have cordoned the area around my friend and the package."

WHILE cs_time < 14011
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_D 5000 1 //"Get over there, pick up the van and bust out as a decoy."

WHILE cs_time < 16741
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE6_F 5000 1 //"Keep them busy for 5 minutes and he should make good his escape!"

WHILE cs_time < 20333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON

CLEAR_PRINTS

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1

SET_SWAT_REQUIRED TRUE
REQUEST_MODEL CAR_ENFORCER
REQUEST_MODEL PED_SWAT
REQUEST_MODEL PED_COP
REQUEST_MODEL CAR_POLICE
REQUEST_MODEL CAR_SECURICAR

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_ENFORCER
OR NOT HAS_MODEL_LOADED	CAR_POLICE
OR NOT HAS_MODEL_LOADED	PED_COP
OR NOT HAS_MODEL_LOADED	PED_SWAT
OR NOT HAS_MODEL_LOADED	CAR_SECURICAR
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON
DO_FADE 1500 FADE_IN 

LOAD_MISSION_AUDIO LO6_A

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

ADD_BLIP_FOR_COORD_OLD -1026.5 -73.5 39.0 RED BLIP_ONLY decoy_van_blip
CHANGE_BLIP_SCALE decoy_van_blip 3

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	WAIT 0
ENDWHILE

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player -1026.5 -73.5 200.0 200.0 0
	WAIT 0
ENDWHILE

SET_MAX_WANTED_LEVEL 6

CREATE_CAR CAR_SECURICAR -1026.5 -73.5 39.0 decoy_van
CHANGE_CAR_COLOUR decoy_van 0 0
SET_CAR_HEADING decoy_van 270.0
CAR_SET_IDLE decoy_van
LOCK_CAR_DOORS decoy_van CARLOCK_UNLOCKED
SET_CAR_STRONG decoy_van TRUE

REMOVE_BLIP	decoy_van_blip
ADD_BLIP_FOR_CAR decoy_van decoy_van_blip

CREATE_CAR CAR_ENFORCER -1005.5 11.0 44.0 swat_1
SET_CAR_HEADING swat_1 119.0
CAR_SET_IDLE swat_1
CREATE_CHAR_INSIDE_CAR swat_1 PEDTYPE_COP PED_SWAT ped_swat_1
GIVE_WEAPON_TO_CHAR ped_swat_1 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_1
SET_CHAR_OBJ_NO_OBJ	ped_swat_1
SET_CAR_MISSION	swat_1 MISSION_NONE

CREATE_CAR CAR_ENFORCER -1112.4 -46.4 49.0 swat_2
SET_CAR_HEADING swat_2 212.0
CAR_SET_IDLE swat_2
CREATE_CHAR_INSIDE_CAR swat_2 PEDTYPE_COP PED_SWAT ped_swat_2
GIVE_WEAPON_TO_CHAR ped_swat_2 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_2
SET_CHAR_OBJ_NO_OBJ	ped_swat_2
SET_CAR_MISSION	swat_2 MISSION_NONE

CREATE_CAR CAR_ENFORCER -1118.4 -63.6 48.7 swat_3
SET_CAR_HEADING swat_3 321.0
CAR_SET_IDLE swat_3
CREATE_CHAR_INSIDE_CAR swat_3 PEDTYPE_COP PED_SWAT ped_swat_3
GIVE_WEAPON_TO_CHAR ped_swat_3 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_3
SET_CHAR_OBJ_NO_OBJ	ped_swat_3
SET_CAR_MISSION	swat_3 MISSION_NONE

CREATE_CAR CAR_ENFORCER -963.3 -108.7 34.7 swat_4
SET_CAR_HEADING swat_4 103.0
CAR_SET_IDLE swat_4
CREATE_CHAR_INSIDE_CAR swat_4 PEDTYPE_COP PED_SWAT ped_swat_4
GIVE_WEAPON_TO_CHAR ped_swat_4 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_4
SET_CHAR_OBJ_NO_OBJ	ped_swat_4
SET_CAR_MISSION	swat_4 MISSION_NONE

CREATE_CAR CAR_ENFORCER -957.0 -111.0 34.5 swat_5
SET_CAR_HEADING swat_5 108.5
CAR_SET_IDLE swat_5
CREATE_CHAR_INSIDE_CAR swat_5 PEDTYPE_COP PED_SWAT ped_swat_5
GIVE_WEAPON_TO_CHAR ped_swat_5 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_5
SET_CHAR_OBJ_NO_OBJ	ped_swat_5
SET_CAR_MISSION	swat_5 MISSION_NONE

CREATE_CAR CAR_POLICE -983.0 -120.3 33.6 cop_1
SET_CAR_HEADING cop_1 270.0
CAR_SET_IDLE cop_1
CREATE_CHAR_INSIDE_CAR cop_1 PEDTYPE_COP PED_COP ped_cop_1
GIVE_WEAPON_TO_CHAR ped_cop_1 WEAPONTYPE_PISTOL	100
CHAR_SET_IDLE ped_cop_1
SET_CHAR_OBJ_NO_OBJ	ped_cop_1
SET_CAR_MISSION	cop_1 MISSION_NONE

CREATE_CAR CAR_POLICE -1018.8 4.4 43.7 cop_2
SET_CAR_HEADING cop_2 262.0
CAR_SET_IDLE cop_2
CREATE_CHAR_INSIDE_CAR cop_2 PEDTYPE_COP PED_COP ped_cop_2
GIVE_WEAPON_TO_CHAR ped_cop_2 WEAPONTYPE_PISTOL	100
CHAR_SET_IDLE ped_cop_2
SET_CHAR_OBJ_NO_OBJ	ped_cop_2
SET_CAR_MISSION	cop_2 MISSION_NONE

CREATE_CAR CAR_POLICE -1114.4 -50.0 48.6 cop_3
SET_CAR_HEADING cop_3 202.0
CAR_SET_IDLE cop_3
CREATE_CHAR_INSIDE_CAR cop_3 PEDTYPE_COP PED_COP ped_cop_3
GIVE_WEAPON_TO_CHAR ped_cop_3 WEAPONTYPE_PISTOL	100
CHAR_SET_IDLE ped_cop_3
SET_CHAR_OBJ_NO_OBJ	ped_cop_3
SET_CAR_MISSION	cop_3 MISSION_NONE


CREATE_CHAR PEDTYPE_COP PED_SWAT -1115.7 -63.9 48.8 ped_swat_6
SET_CHAR_HEADING ped_swat_6 342.0
GIVE_WEAPON_TO_CHAR ped_swat_6 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_6
SET_CHAR_OBJ_NO_OBJ	ped_swat_6

CREATE_CHAR PEDTYPE_COP PED_SWAT -965.3 -111.2 34.0 ped_swat_7
SET_CHAR_HEADING ped_swat_7 41.0
GIVE_WEAPON_TO_CHAR ped_swat_7 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_7
SET_CHAR_OBJ_NO_OBJ	ped_swat_7

CREATE_CHAR PEDTYPE_COP PED_SWAT -960.5 -113.0 34.0 ped_swat_8
SET_CHAR_HEADING ped_swat_8 173.0
GIVE_WEAPON_TO_CHAR ped_swat_8 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_swat_8
SET_CHAR_OBJ_NO_OBJ	ped_swat_8

CREATE_CHAR PEDTYPE_COP PED_COP -1103.4 -47.8 48.8 ped_cop_4
SET_CHAR_HEADING ped_cop_4 255.0
GIVE_WEAPON_TO_CHAR ped_cop_4 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_cop_4
SET_CHAR_OBJ_NO_OBJ	ped_cop_4

CREATE_CHAR PEDTYPE_COP PED_COP -984.0 -91.2 36.0 ped_cop_5
SET_CHAR_HEADING ped_cop_5 339.0
GIVE_WEAPON_TO_CHAR ped_cop_5 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_cop_5
SET_CHAR_OBJ_NO_OBJ	ped_cop_5

CREATE_CHAR PEDTYPE_COP PED_COP -1005.0 5.5 43.8 ped_cop_6
SET_CHAR_HEADING ped_cop_6 169.0
GIVE_WEAPON_TO_CHAR ped_cop_6 WEAPONTYPE_SHOTGUN 50
CHAR_SET_IDLE ped_cop_6
SET_CHAR_OBJ_NO_OBJ	ped_cop_6

WHILE NOT IS_PLAYER_IN_CAR player decoy_van
	
	WAIT 0

	IF IS_CAR_DEAD decoy_van
		GOTO mission_love6_failed
	ENDIF

ENDWHILE

REMOVE_BLIP decoy_van_blip

//PRINT_NOW GOGO 5000 1 //GO GO GO!!

IF NOT IS_CHAR_DEAD ped_swat_6
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_swat_6 player
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_swat_6
ENDIF

IF NOT IS_CHAR_DEAD ped_swat_7
	SET_CHAR_OBJ_DESTROY_CAR ped_swat_7 decoy_van
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_swat_7
ENDIF

IF NOT IS_CHAR_DEAD ped_swat_8
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_swat_8 player
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_swat_8
ENDIF

IF NOT IS_CHAR_DEAD ped_cop_4
	SET_CHAR_OBJ_DESTROY_CAR ped_cop_4 decoy_van
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_cop_4
ENDIF

IF NOT IS_CHAR_DEAD ped_cop_5
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_cop_5 player
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_cop_5
ENDIF

IF NOT IS_CHAR_DEAD ped_cop_6
	SET_CHAR_OBJ_DESTROY_CAR ped_cop_6 decoy_van
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_cop_6
ENDIF

IF NOT IS_CAR_DEAD swat_1
	SET_CAR_CRUISE_SPEED swat_1 100.0
	SET_CAR_DRIVING_STYLE swat_1 2
	SET_CAR_RAM_CAR	swat_1 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED swat_1
ENDIF

IF NOT IS_CAR_DEAD swat_2
	SET_CAR_CRUISE_SPEED swat_2 100.0
	SET_CAR_DRIVING_STYLE swat_2 2
	SET_CAR_RAM_CAR	swat_2 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED swat_2
ENDIF

IF NOT IS_CAR_DEAD swat_3
	SET_CAR_CRUISE_SPEED swat_3 100.0
	SET_CAR_DRIVING_STYLE swat_3 2
	SET_CAR_RAM_CAR	swat_3 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED swat_3
ENDIF

IF NOT IS_CAR_DEAD swat_4
	SET_CAR_CRUISE_SPEED swat_4 100.0
	SET_CAR_DRIVING_STYLE swat_4 2
	SET_CAR_RAM_CAR	swat_4 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED swat_4
ENDIF

IF NOT IS_CAR_DEAD swat_5
	SET_CAR_CRUISE_SPEED swat_5 100.0
	SET_CAR_DRIVING_STYLE swat_5 2
	SET_CAR_RAM_CAR	swat_5 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED swat_5
ENDIF

IF NOT IS_CAR_DEAD cop_1
	SET_CAR_CRUISE_SPEED cop_1 100.0
	SET_CAR_DRIVING_STYLE cop_1 2
	SET_CAR_RAM_CAR	cop_1 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED cop_1
ENDIF

IF NOT IS_CAR_DEAD cop_2
	SET_CAR_CRUISE_SPEED cop_2 100.0
	SET_CAR_DRIVING_STYLE cop_2 2
	SET_CAR_RAM_CAR	cop_2 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED cop_2
ENDIF

IF NOT IS_CAR_DEAD cop_3
	SET_CAR_CRUISE_SPEED cop_3 100.0
	SET_CAR_DRIVING_STYLE cop_3 2
	SET_CAR_RAM_CAR	cop_3 decoy_van
	MARK_CAR_AS_NO_LONGER_NEEDED cop_3
ENDIF

ALTER_WANTED_LEVEL player 6 

DISPLAY_ONSCREEN_TIMER survival_time

PRINT_NOW LOVE6_1 5000 1//"Now lead the cops away!"

IF HAS_MISSION_AUDIO_LOADED
	PLAY_MISSION_AUDIO
ENDIF

GET_CAR_HEALTH decoy_van decoy_van_health
//escort_truck_health += dummy_health
//escort_truck_health = escort_truck_health / 2
decoy_van_health = decoy_van_health - 250
decoy_van_health = decoy_van_health * 100
decoy_van_health = decoy_van_health / 750
decoy_van_health2 = decoy_van_health
decoy_van_health = 100 - decoy_van_health2
IF decoy_van_health > 100
	decoy_van_health = 100
ENDIF

DISPLAY_ONSCREEN_COUNTER_WITH_STRING decoy_van_health COUNTER_DISPLAY_BAR DAM
	
WHILE survival_time > 0
	WAIT 0

	IF IS_CAR_DEAD decoy_van
		GOTO mission_love6_failed
	ENDIF

	ALTER_WANTED_LEVEL player 6

    GET_CAR_HEALTH decoy_van decoy_van_health
//	escort_truck_health += dummy_health
//	escort_truck_health = escort_truck_health / 2
	decoy_van_health = decoy_van_health - 250
	decoy_van_health = decoy_van_health * 100
	decoy_van_health = decoy_van_health / 750
	decoy_van_health2 = decoy_van_health
	decoy_van_health = 100 - decoy_van_health2
	IF decoy_van_health > 100
		decoy_van_health = 100
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player decoy_van
		IF get_in_van = 0
			GET_GAME_TIMER out_of_car_timer_start
			IF survival_time > 15000
				out_of_car_timer = 15000
			ELSE
				out_of_car_timer = survival_time
			ENDIF 
			ADD_BLIP_FOR_CAR decoy_van decoy_van_blip
			get_in_van = 1
		ENDIF
		GET_GAME_TIMER out_of_car_timer_present
		out_of_car_timer_diff = out_of_car_timer_present - out_of_car_timer_start
		out_of_car_timer -= out_of_car_timer_diff
		out_of_car_timer_start = out_of_car_timer_present
		out_of_car_timer_secs = out_of_car_timer / 1000
		PRINT_WITH_NUMBER_NOW LOVE6_3 out_of_car_timer_secs 200 1 //~g~You have ~1~ seconds to return to the Securicar before you fail the mission.
		IF out_of_car_timer_secs < 1 
			PRINT_NOW LOVE6_4 3000 1//~r~You ditched the Decoy Securicar!
			GOTO mission_love6_failed
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_CAR player decoy_van
	AND get_in_van = 1
		REMOVE_BLIP	decoy_van_blip
		get_in_van = 0
	ENDIF

ENDWHILE

IF LOCATE_PLAYER_ANY_MEANS_2D PLAYER -1026.5 -73.5 160.0 160.0 0
	PRINT_NOW LOVE6_2 5000 1//"You failed to lead the police far enough away."
	GOTO mission_love6_failed
ENDIF

GOTO mission_love6_passed


// Mission Love 6 failed

mission_love6_failed:
PRINT_BIG M_FAIL 5000 1
RETURN

   

// mission Love 6 passed

mission_love6_passed:

flag_love_mission6_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 35000 5000 1
ADD_SCORE player 35000 
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	LOVE6
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT love_mission7_loop
RETURN
		


// mission cleanup

mission_cleanup_love6:

flag_player_on_mission = 0
flag_player_on_love_mission = 0
		
REMOVE_BLIP	decoy_van_blip
CLEAR_ONSCREEN_TIMER survival_time
CLEAR_ONSCREEN_COUNTER decoy_van_health

SET_SWAT_REQUIRED FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SECURICAR
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_POLICE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_COP
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ENFORCER
MARK_MODEL_AS_NO_LONGER_NEEDED PED_SWAT

MISSION_HAS_FINISHED
RETURN
		



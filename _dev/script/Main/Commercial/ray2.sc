MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Ray mission 2*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray2_failed
ENDIF
GOSUB mission_cleanup_ray2
MISSION_END
 
// Variables for mission

VAR_INT blip_warehouse_rm2
VAR_FLOAT wh_x_rm2 wh_y_rm2 wh2_x_rm2 wh2_y_rm2
VAR_FLOAT phils_defcon_x phils_defcon_y phils_defcon_z
//VAR_FLOAT phils_defcon_minx phils_defcon_miny phils_defcon_maxx phils_defcon_maxy
VAR_INT flag_phil_in_area flag_phil_arrived

//VAR_INT phils_m16 phils_uzi phils_shotgun
VAR_INT phils_molotov phils_rocket phils_m16 phils_uzi phils_shotgun phils_armour
VAR_INT flag_m16_gone flag_uzi_gone flag_rocket_gone flag_shotgun_gone
VAR_INT flag_molotov_gone
VAR_FLOAT m16_x m16_y
VAR_FLOAT uzi_x uzi_y
VAR_FLOAT rocket_x rocket_y rocket_z
VAR_FLOAT molotov_x molotov_y molotov_z
VAR_FLOAT shotgun_x shotgun_y

VAR_INT player_rm2 player_car_rm2
VAR_INT phil phil_truck_1 phil_truck_2 blip_phil
//VAR_INT phil_truck_3 
VAR_INT flag_phil_dead flag_trucks

VAR_INT varmint_1 varmint_2 varmint_3
VAR_INT varmint_4 varmint_5 varmint_6
VAR_INT varmint_7 varmint_8 varmint_9
VAR_INT varmint_10 varmint_11 varmint_12

VAR_INT blip_v1 blip_v2 blip_v3 blip_v4
VAR_INT blip_v5 blip_v6 blip_v7 blip_v8
VAR_INT blip_v9 blip_v10 blip_v11 blip_v12

VAR_INT flag_v1_dead flag_v2_dead flag_v3_dead
VAR_INT flag_v4_dead flag_v5_dead flag_v6_dead
VAR_INT flag_v7_dead flag_v8_dead flag_v9_dead
VAR_INT flag_v10_dead flag_v11_dead flag_v12_dead
VAR_INT counter_dead_varmints
//VAR_INT condition_1
VAR_INT flag_cartel_arrived flag_sneaky_1 flag_sneaky_2 //flag_camera


VAR_INT sentinel1_rm2 stallion1_rm2 perenial1_rm2
VAR_INT stallion_bailout sentinel_bailout perenial_bailout
VAR_INT flag_stallion_arrived flag_sentinel_arrived flag_perenial_arrived
VAR_INT flag_stallion_created flag_sentinel_created flag_perenial_created
VAR_INT flag_launch_perenial flag_launch_stallion
//VAR_INT flag_launch_sentinel 
VAR_INT blip_stallion1 blip_perenial1 blip_sentinel1

VAR_FLOAT varmint_gen1_x varmint_gen1_y
//VAR_FLOAT varmint_gen2_x varmint_gen2_y
//VAR_FLOAT varmint_gen3_x varmint_gen3_y

VAR_FLOAT stage_1_x stage_1_y
VAR_FLOAT stage_2_x stage_2_y
VAR_FLOAT stage_3_x stage_3_y
VAR_INT	timer_dif_rm2 timer_now_rm2 timer_start_rm2
 

//VAR_FLOAT player_rm2_x player_rm2_y player_rm2_z

VAR_INT flag_audio flag_gate
// ****************************************Mission Start************************************

mission_start_ray2:
REGISTER_MISSION_GIVEN
SCRIPT_NAME ray2 
//	PRINT_BIG ( RM2 ) 15000 2


// *****************************************Set Flags************************************


flag_player_on_mission = 1

flag_player_on_ray_mission = 1

flag_player_on_phil_mission = 1

rays_cutscene_flag = 1

WAIT 0

/*
IF NOT rays_camera_1 = 0
OR NOT rays_camera_2 = 0
OR NOT rays_camera_3 = 0
	RESTORE_CAMERA_JUMPCUT
	rays_camera_1 = 0
	rays_camera_2 = 0
	rays_camera_3 = 0
ENDIF
*/
//set flags

flag_m16_gone = 0
flag_uzi_gone = 0
flag_rocket_gone = 0
flag_shotgun_gone = 0
flag_molotov_gone = 0

flag_phil_in_area = 0
flag_phil_arrived = 0
flag_phil_dead = 0

flag_trucks = 0

flag_v1_dead = 0
flag_v2_dead = 0
flag_v3_dead = 0
flag_v4_dead = 0
flag_v5_dead = 0
flag_v6_dead = 0
flag_v7_dead = 0
flag_v8_dead = 0
flag_v9_dead = 0
flag_v10_dead = 0
flag_v11_dead = 0
flag_v12_dead = 0
counter_dead_varmints = 0
//condition_1 = 0

flag_cartel_arrived = 0
//flag_camera = 0

stallion_bailout = 0
sentinel_bailout = 0
perenial_bailout = 0
flag_stallion_arrived = 0
flag_sentinel_arrived = 0
flag_perenial_arrived = 0

flag_stallion_created = 0
flag_sentinel_created = 0
flag_perenial_created = 0

flag_launch_stallion = 0
//flag_launch_sentinel = 0
flag_launch_perenial = 0

flag_sneaky_1 = 0
flag_sneaky_2 = 0

flag_audio = 0
flag_gate = 0
// *******************************************Set Coord*****************************************

wh_x_rm2 = 137.15
wh_y_rm2 = 192.43
wh2_x_rm2 = 121.5
wh2_y_rm2 = 214.6

varmint_gen1_x = 174.0
varmint_gen1_y = 170.0


stage_3_x = 153.0
stage_3_y = 220.0
stage_1_x = 172.0
stage_1_y = 207.0
stage_2_x = 152.0
stage_2_y = 204.0


phils_defcon_x = 136.5
phils_defcon_y = 176.7
phils_defcon_z = 11.6
/*
phils_defcon_minx = 119.0
phils_defcon_miny = 168.0
phils_defcon_maxx = 146.0
phils_defcon_maxy = 198.0
*/
m16_x = 145.5
m16_y = 170.0
uzi_x = 143.5
uzi_y = 170.0
shotgun_x = 141.5
shotgun_y = 170.0
rocket_x = 126.98
rocket_y = 198.24
rocket_z = 14.53
molotov_x = 126.98
molotov_y = 191.73
molotov_z = 14.53


// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_ray2_failed
ENDIF
 
SET_FADING_COLOUR 0 0 0
 
DO_FADE 250 FADE_OUT
 
PRINT_BIG RM2 15000 2 //"Arms Shortage"

SWITCH_STREAMING OFF
*/
 
LOAD_SPECIAL_CHARACTER 1 ray
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 RAYH
REQUEST_MODEL toilet 
/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW
 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED toilet
 WAIT 0
ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor FALSE 
 
LOAD_CUTSCENE r2_ap

SWITCH_STREAMING ON
 
SET_CUTSCENE_OFFSET 39.424 -726.677 21.692
 
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_ray
SET_CUTSCENE_ANIM cs_ray ray
 
CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player
 
CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray
 
//CREATE_CUTSCENE_OBJECT cut_obj1 cs_ludoor
//SET_CUTSCENE_ANIM cs_ludoor LUDOOR
 
//SET_PLAYER_COORDINATES player 38.7 -725.7 22.0
 
//SET_PLAYER_HEADING player 270.0
 

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0

DO_FADE 250 FADE_IN

SET_NEAR_CLIP 0.2
 
START_CUTSCENE
SWITCH_STREAMING OFF
SWITCH_RUBBISH OFF
 
// Displays cutscene text
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6426
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM2_A1 10000 1 //"Hey kid, over here!"
 
WHILE cs_time < 8218
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM2_A 10000 1 //"An old army buddy of mine runs a business up in Rockford."
 
WHILE cs_time < 11093
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM2_B 10000 1 //"We saw action in Nicaragua, back when this country knew what it was doing."
 
WHILE cs_time < 14634
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM2_C 10000 1 //"Some Cartel scum roughed him up yesterday and said they'd be back for some of his stock today.

WHILE cs_time < 20938
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM2_D 10000 1 //"He could do with some back-up and in return he'll give you knock-down rates on any hardware you buy."

WHILE cs_time < 26599
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM2_D1 10000 1 //"I'd go myself but the old siatica's playing up again -cough cough- so, eerr, good luck."
 
WHILE cs_time < 38333
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
DO_FADE 1000 FADE_OUT
 
 
WHILE NOT HAS_CUTSCENE_FINISHED
 WAIT 0
ENDWHILE
 
//DO_FADE 1000 FADE_IN 
 
CLEAR_PRINTS

WHILE GET_FADING_STATUS
 WAIT 0
ENDWHILE
 
CLEAR_CUTSCENE
 
DO_FADE 0 FADE_OUT
 
SET_CAMERA_BEHIND_PLAYER
SET_NEAR_CLIP 0.9
 
WAIT 500
 
DO_FADE 1000 FADE_IN 
 
//WHILE GET_FADING_STATUS
// WAIT 0
//ENDWHILE
 
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 890.9 -416.9 15.0 6.0 backdoor TRUE
 
UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED toilet

SWITCH_STREAMING ON 
SWITCH_RUBBISH ON
rays_cutscene_flag = 0
// ******************************************END OF CUTSCENE********************************

// Mission stuff goes here

ADD_BLIP_FOR_COORD wh_x_rm2 wh_y_rm2 -100.0 blip_warehouse_rm2

//------------------REQUEST_MODELS ------------------------------

REQUEST_MODEL PED_GANG_COLOMBIAN_A
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 dealer
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_GANG_COLOMBIAN_B 
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_B
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_COLUMB
WHILE NOT HAS_MODEL_LOADED CAR_COLUMB
	WAIT 0
ENDWHILE
/* 
REQUEST_MODEL CAR_STALLION
WHILE NOT HAS_MODEL_LOADED CAR_STALLION
	WAIT 0
ENDWHILE
 
REQUEST_MODEL CAR_PERENNIAL
WHILE NOT HAS_MODEL_LOADED CAR_PERENNIAL
	WAIT 0
ENDWHILE
*/ 
REQUEST_MODEL CAR_BARRACKS
WHILE NOT HAS_MODEL_LOADED CAR_BARRACKS
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_RHINO
WHILE NOT HAS_MODEL_LOADED CAR_RHINO
	WAIT 0
ENDWHILE
/*
REQUEST_MODEL CAR_PATRIOT
WHILE NOT HAS_MODEL_LOADED CAR_PATRIOT
	WAIT 0
ENDWHILE
*/






//------------------WAITING FOR PLAYER TO ARRIVE---------------------------------------

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player wh_x_rm2 wh_y_rm2 4.0 4.0 true
//AND NOT LOCATE_PLAYER_ANY_MEANS_2D player wh2_x_rm2 wh2_y_rm2 2.0 2.0 false
	WAIT 0
	
	IF IS_PLAYER_IN_ZONE player HOSPI_2
	AND flag_trucks = 0

		//--------------------CREATE PHIL'S TRUCKS---------------------------------------------

		CREATE_CAR CAR_RHINO 132.0 173.9 11.6 phil_truck_1
		SET_CAR_HEADING phil_truck_1 0.0
		CAR_SET_IDLE phil_truck_1
		SET_CAR_PROOFS phil_truck_1 TRUE FALSE FALSE FALSE FALSE
		LOCK_CAR_DOORS phil_truck_1 CARLOCK_LOCKED

		CREATE_CAR CAR_BARRACKS 133.56 208.76 11.93 phil_truck_2
		SET_CAR_HEADING phil_truck_2 180.0
		CAR_SET_IDLE phil_truck_2
		SET_CAR_PROOFS phil_truck_2 TRUE FALSE FALSE FALSE FALSE
		LOCK_CAR_DOORS phil_truck_2 CARLOCK_LOCKED
		/*
		CREATE_CAR CAR_PATRIOT 141.23 192.52 11.6 phil_truck_3
		SET_CAR_HEADING phil_truck_3 60.0 
		CAR_SET_IDLE phil_truck_3
		SET_CAR_PROOFS phil_truck_3 TRUE FALSE FALSE FALSE FALSE
		LOCK_CAR_DOORS phil_truck_3 CARLOCK_LOCKED
		*/
		flag_trucks = 1
	ENDIF
	IF flag_gate = 0
		IF gate2_sfx1 = 0
			ADD_ONE_OFF_SOUND 147.249 207.323 10.599 SOUND_GATE_START_CLUNK
			gate2_sfx1 = 1
		ENDIF

		WHILE NOT SLIDE_OBJECT phils_compnd_gate 147.249 214.823 10.599 0.0 0.1 0.0 FALSE
			WAIT 0
		ENDWHILE

		IF not_clunked_yet = 1
			gate_sfx2 = 0
			not_clunked_yet = 0
		ENDIF

		IF gate2_sfx2 = 0
			ADD_ONE_OFF_SOUND 147.249 214.823 10.599 SOUND_GATE_STOP_CLUNK
			gate2_sfx2 = 1
		ENDIF
		flag_gate = 1
	ENDIF

ENDWHILE

//--------------------PLAYER ARRIVED (CUTSCENE)------------------------------------------
//-----------------------CREATE PHIL-------------------

CLEAR_AREA phils_defcon_x phils_defcon_y 11.5 20.0 true
CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 phils_defcon_x phils_defcon_y phils_defcon_z phil
SET_CHAR_HEADING phil 360.0
GIVE_WEAPON_TO_CHAR phil WEAPONTYPE_M16 200
ADD_ARMOUR_TO_CHAR phil 100
SET_CHAR_PERSONALITY phil PEDSTAT_TOUGH_GUY
CLEAR_CHAR_THREAT_SEARCH phil
SET_CHAR_THREAT_SEARCH phil THREAT_GANG_COLOMBIAN
SET_CHAR_STAY_IN_SAME_PLACE phil true
//CHAR_SET_IDLE phil


//-----------------------CREATE PHIL'S 'SUPPLIES'-------------------------------------

CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ONCE 60 m16_x m16_y 11.5 phils_m16
CREATE_PICKUP WEAPON_UZI PICKUP_ONCE uzi_x uzi_y 11.5 phils_uzi
CREATE_PICKUP WEAPON_SHOTGUN PICKUP_ONCE shotgun_x shotgun_y 11.5 phils_shotgun
CREATE_PICKUP WEAPON_ROCKET PICKUP_ONCE rocket_x rocket_y rocket_z phils_rocket
CREATE_PICKUP WEAPON_MOLOTOV PICKUP_ONCE molotov_x molotov_y molotov_z phils_molotov
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 121.16 194.92 11.53 phils_armour


REMOVE_BLIP blip_warehouse_rm2

SET_PLAYER_CONTROL player off
GET_PLAYER_CHAR player player_rm2
SET_FIXED_CAMERA_POSITION 141.5 184.5 12.5 0.0 0.0 0.0
SWITCH_WIDESCREEN on

IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player player_car_rm2
	APPLY_BRAKES_TO_PLAYERS_CAR player on
	CAR_SET_IDLE player_car_rm2
	POINT_CAMERA_AT_CAR player_car_rm2 FIXED JUMP_CUT
	SET_CHAR_OBJ_LEAVE_CAR player_rm2 player_car_rm2
	WHILE IS_CHAR_IN_CAR player_rm2 player_car_rm2
		WAIT 0
		IF IS_CAR_DEAD player_car_rm2
			GOTO bibble
		ENDIF
	ENDWHILE
ENDIF

POINT_CAMERA_AT_CHAR player_rm2 FIXED JUMP_CUT

bibble:


WAIT 0

phils_defcon_y = phils_defcon_y + 3.0
SET_CHAR_OBJ_RUN_TO_COORD player_rm2 phils_defcon_x phils_defcon_y


WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player phils_defcon_x phils_defcon_y 2.0 2.0 false
	WAIT 0
ENDWHILE
//SET_CHAR_OBJ_NO_OBJ player_rm2


LOAD_MISSION_AUDIO R2_A
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_E) 4000 1 //"Ray phoned ahead....but I thought there'd be more of you.
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE


LOAD_MISSION_AUDIO R2_B
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_E1) 4000 1 //"I can't believe the yellow bastard's left me without proper cover again!"
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE


LOAD_MISSION_AUDIO R2_C
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_F) 4000 1 //"Well three arms are better than one, so grab whatever you need."
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE


LOAD_MISSION_AUDIO R2_D
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_F1) 4000 1 //"Those Colombians will be here any minute."
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO peedle
	ENDIF
ENDWHILE

peedle:
CLEAR_MISSION_AUDIO

CLEAR_PRINTS
SET_PLAYER_CONTROL player on
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off

GET_GAME_TIMER timer_start_rm2
GET_GAME_TIMER timer_now_rm2
timer_dif_rm2 = timer_now_rm2 - timer_start_rm2

//-------GIVE PLAYER TIME TO GET PICKUPS WITHOUT LEAVING COMPOUND-------
CLEAR_AREA varmint_gen1_x varmint_gen1_y 11.5 20.0 true
CLEAR_AREA stage_3_x stage_3_y 11.5 20.0 true
CLEAR_AREA stage_1_x stage_1_y 11.5 20.0 true
CLEAR_AREA stage_2_x stage_2_y 11.5 20.0 true

/*IF NOT IS_CAR_DEAD phil_truck_3
	LOCK_CAR_DOORS phil_truck_3 CARLOCK_UNLOCKED
ENDIF*/
IF NOT IS_CAR_DEAD phil_truck_2
	LOCK_CAR_DOORS phil_truck_2 CARLOCK_UNLOCKED
ENDIF

WHILE timer_dif_rm2 < 25000
AND IS_PLAYER_IN_AREA_2D player 119.0 167.0 147.0 246.0 false
	WAIT 0
	GOSUB pickups
	IF IS_PLAYER_IN_AREA_2D player 147.0 198.0 156.0 208.0 false
		GOTO herring
	ENDIF
	IF IS_PLAYER_IN_ANY_CAR player
		GOTO herring
	ENDIF

	GET_GAME_TIMER timer_now_rm2
	timer_dif_rm2 = timer_now_rm2 - timer_start_rm2
	IF IS_CHAR_DEAD phil
		flag_phil_dead = 1
		GOTO mission_ray2_failed
	ENDIF

ENDWHILE

herring:
//----LOAD PHIL'S SOUND BITE-----------------------------------------

LOAD_MISSION_AUDIO R2_E
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

//-----------------MAIN LOOP-----------------------------------------

GET_GAME_TIMER timer_start_rm2

WHILE counter_dead_varmints < 12
	
	WAIT 0
	
	GET_GAME_TIMER timer_now_rm2
	timer_dif_rm2 = timer_now_rm2 - timer_start_rm2

	GOSUB pickups


	//--------sentinel gen stuff--------------------------------------------
	
	IF timer_dif_rm2 > 2000
	AND flag_sentinel_created = 0
		CREATE_CAR CAR_COLUMB varmint_gen1_x varmint_gen1_y -100.0 sentinel1_rm2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER sentinel1_rm2 TRUE
		LOCK_CAR_DOORS sentinel1_rm2 CARLOCK_LOCKED
		ADD_BLIP_FOR_CAR sentinel1_rm2 blip_sentinel1
		CREATE_CHAR_INSIDE_CAR sentinel1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B varmint_1
		CREATE_CHAR_AS_PASSENGER sentinel1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 varmint_2
		CREATE_CHAR_AS_PASSENGER sentinel1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1 varmint_3
		CREATE_CHAR_AS_PASSENGER sentinel1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 varmint_4
		SET_CAR_CRUISE_SPEED sentinel1_rm2 10.0
		SET_CAR_DRIVING_STYLE sentinel1_rm2 3
		CAR_GOTO_COORDINATES_ACCURATE sentinel1_rm2 stage_1_x stage_1_y 11.6
		flag_sentinel_created = 1
	ENDIF

	IF flag_launch_stallion = 0
	AND flag_sentinel_created = 1
		IF NOT IS_CAR_DEAD sentinel1_rm2
			IF LOCATE_CAR_2D sentinel1_rm2 stage_1_x stage_1_y 4.0 4.0 false
				CAR_GOTO_COORDINATES_ACCURATE sentinel1_rm2 stage_2_x stage_2_y 11.6
				flag_launch_stallion = 1
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_launch_stallion = 1
	AND flag_sentinel_created = 1
		IF NOT IS_CAR_DEAD sentinel1_rm2
			IF LOCATE_CAR_2D sentinel1_rm2 stage_2_x stage_2_y 4.0 4.0 false
				flag_launch_stallion = 2
				flag_sentinel_arrived = 1
				SET_CAR_ONLY_DAMAGED_BY_PLAYER sentinel1_rm2 FALSE
				LOCK_CAR_DOORS sentinel1_rm2 CARLOCK_UNLOCKED
				IF flag_cartel_arrived < 2
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_sentinel_created = 1
		IF IS_CAR_DEAD sentinel1_rm2
			flag_launch_stallion = 1
			REMOVE_BLIP blip_sentinel1
		ELSE
			IF NOT IS_CAR_HEALTH_GREATER sentinel1_rm2 950
				flag_sentinel_arrived = 1
				IF flag_launch_stallion = 0
					flag_launch_stallion = 1
				ENDIF
				IF flag_cartel_arrived = 0
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	//-----stallion gen stuff------------------------------------------------
	
	IF timer_dif_rm2 > 4000
	AND flag_stallion_created = 0
	AND flag_launch_stallion > 0
		CREATE_CAR CAR_COLUMB varmint_gen1_x varmint_gen1_y -100.0 stallion1_rm2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER stallion1_rm2 TRUE
		LOCK_CAR_DOORS stallion1_rm2 CARLOCK_LOCKED
		ADD_BLIP_FOR_CAR stallion1_rm2 blip_stallion1
		CREATE_CHAR_INSIDE_CAR stallion1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A varmint_5
		CREATE_CHAR_AS_PASSENGER stallion1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 varmint_6
		SET_CAR_CRUISE_SPEED stallion1_rm2 10.0
		SET_CAR_DRIVING_STYLE  stallion1_rm2 3
		CAR_GOTO_COORDINATES_ACCURATE stallion1_rm2 stage_1_x stage_1_y 11.6
		flag_stallion_created = 1
	ENDIF

	IF flag_launch_perenial = 0
	AND flag_stallion_created = 1
		IF NOT IS_CAR_DEAD stallion1_rm2
			IF LOCATE_CAR_2D stallion1_rm2 stage_1_x stage_1_y 4.0 4.0 false
				CAR_GOTO_COORDINATES_ACCURATE stallion1_rm2 stage_3_x stage_3_y 11.6
				flag_launch_perenial = 1
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_launch_perenial = 1
	AND flag_stallion_created = 1
		IF NOT IS_CAR_DEAD stallion1_rm2
			IF LOCATE_CAR_2D stallion1_rm2 stage_3_x stage_3_y 4.0 4.0 false
				flag_launch_perenial = 2
				flag_stallion_arrived = 1
				SET_CAR_ONLY_DAMAGED_BY_PLAYER stallion1_rm2 FALSE
				LOCK_CAR_DOORS stallion1_rm2 CARLOCK_UNLOCKED
				IF flag_cartel_arrived < 2
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF flag_stallion_created = 1
		IF IS_CAR_DEAD stallion1_rm2
			flag_launch_perenial = 1
			REMOVE_BLIP blip_stallion1
		ELSE
			IF NOT IS_CAR_HEALTH_GREATER stallion1_rm2 950
				flag_stallion_arrived = 1
				IF flag_cartel_arrived = 0
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	//-----perenial gen stuff-----------------------------------------------
	
	IF timer_dif_rm2 > 6000
	AND flag_perenial_created = 0
	AND flag_launch_perenial > 0
		CREATE_CAR CAR_COLUMB varmint_gen1_x varmint_gen1_y -100.0 perenial1_rm2
		SET_CAR_ONLY_DAMAGED_BY_PLAYER perenial1_rm2 TRUE
		LOCK_CAR_DOORS perenial1_rm2 CARLOCK_LOCKED
		ADD_BLIP_FOR_CAR perenial1_rm2 blip_perenial1
		CREATE_CHAR_INSIDE_CAR perenial1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B varmint_7
		CREATE_CHAR_AS_PASSENGER perenial1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 varmint_8
		CREATE_CHAR_AS_PASSENGER perenial1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1 varmint_9
		CREATE_CHAR_AS_PASSENGER perenial1_rm2 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 2 varmint_10
		SET_CAR_CRUISE_SPEED perenial1_rm2 10.0
		SET_CAR_DRIVING_STYLE  perenial1_rm2 3
		CAR_GOTO_COORDINATES_ACCURATE perenial1_rm2 stage_1_x stage_1_y 11.6
		flag_perenial_created = 1
	ENDIF

	
	IF flag_perenial_created = 1
		IF NOT IS_CAR_DEAD perenial1_rm2
			IF LOCATE_CAR_2D perenial1_rm2 stage_1_x stage_1_y 4.0 4.0 false
				flag_perenial_arrived = 1
				SET_CAR_ONLY_DAMAGED_BY_PLAYER perenial1_rm2 FALSE
				LOCK_CAR_DOORS perenial1_rm2 CARLOCK_UNLOCKED
				IF flag_cartel_arrived < 2
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF flag_perenial_created = 1	
		IF IS_CAR_DEAD perenial1_rm2
			REMOVE_BLIP blip_perenial1
		ELSE
			IF NOT IS_CAR_HEALTH_GREATER perenial1_rm2 950
				flag_perenial_arrived = 1
				IF flag_cartel_arrived = 0
					flag_cartel_arrived = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	//----------------Sneaky backstab----------------------------------------

	IF flag_cartel_arrived > 0
	AND timer_dif_rm2 > 12000
		IF flag_sneaky_1 = 0
			IF NOT IS_POINT_ON_SCREEN 121.3 217.7 11.5 2.5
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 121.3 235.7 11.5 varmint_11
				GIVE_WEAPON_TO_CHAR varmint_11 WEAPONTYPE_CHAINGUN 80
				ADD_ARMOUR_TO_CHAR varmint_11 100
				ADD_BLIP_FOR_CHAR_OLD varmint_11 1 BLIP_ONLY blip_v11
				//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_11 player
				SET_CHAR_OBJ_RUN_TO_COORD varmint_11 phils_defcon_x phils_defcon_y
				SET_CHAR_THREAT_SEARCH varmint_11 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH varmint_11 THREAT_SPECIAL
				SET_CHAR_HEED_THREATS varmint_11 true
				flag_sneaky_1 = 1
			ENDIF
		ENDIF
		IF flag_sneaky_2 = 0
			IF NOT IS_POINT_ON_SCREEN 121.3 241.6 11.5 2.5
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 121.3 241.6 11.5 varmint_12
				GIVE_WEAPON_TO_CHAR varmint_12 WEAPONTYPE_SHOTGUN 20
				ADD_ARMOUR_TO_CHAR varmint_12 100
				ADD_BLIP_FOR_CHAR_OLD varmint_12 1 BLIP_ONLY blip_v12
				SET_CHAR_OBJ_RUN_TO_COORD varmint_12 124.15 184.7
				SET_CHAR_THREAT_SEARCH varmint_12 THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH varmint_12 THREAT_SPECIAL
				SET_CHAR_HEED_THREATS varmint_12 true
				/*IF NOT IS_CHAR_DEAD phil
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_12 phil
				ENDIF*/
				flag_sneaky_2 = 1
			ENDIF
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD phil
		flag_phil_dead = 1
		GOTO mission_ray2_failed
	ENDIF

	IF flag_cartel_arrived = 1
		SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
		PLAY_MISSION_AUDIO		
		PRINT_NOW (RM2_K) 4000 1 //"SHIT They're here! LOCK'N'LOAD!!"
		flag_cartel_arrived = 2
		/*WHILE NOT SLIDE_OBJECT phils_compnd_gate 147.249 214.323 10.599 0.0 0.1 0.0 FALSE
			WAIT 0
		ENDWHILE*/
	ENDIF

	GOSUB varmint_deaths

	GOSUB big_bailout_routine

ENDWHILE

//-------All Cartel Varmints dead-----------------------------------------------
IF NOT IS_CHAR_DEAD phil
	SET_CHAR_HEALTH phil 5
ENDIF

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_STAY_IN_SAME_PLACE phil true
	GET_CHAR_COORDINATES phil phils_defcon_x phils_defcon_y phils_defcon_z
	IF NOT LOCATE_PLAYER_ANY_MEANS_2D player phils_defcon_x phils_defcon_y 2.0 2.0 false
		PRINT_NOW (RM2_G) 2500 1 //"Go check on Phil!"
		ADD_BLIP_FOR_CHAR phil blip_phil
		WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player phils_defcon_x phils_defcon_y 2.0 2.0 false
			WAIT 0
			IF IS_CHAR_DEAD phil
				flag_phil_dead = 1
				REMOVE_BLIP blip_phil
				GOTO mission_ray2_failed
			ENDIF
		ENDWHILE
	ENDIF
ENDIF

IF IS_CHAR_DEAD phil
	flag_phil_dead = 1
	REMOVE_BLIP blip_phil
	GOTO mission_ray2_failed
ELSE
	SET_CHAR_HEALTH phil 100
ENDIF

REMOVE_BLIP blip_phil

SET_PLAYER_CONTROL player off
SWITCH_WIDESCREEN on
SET_FIXED_CAMERA_POSITION 134.6 184.7 11.16 0.0 0.0 0.0

IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player player_car_rm2
	APPLY_BRAKES_TO_PLAYERS_CAR player on
	CAR_SET_IDLE player_car_rm2
	POINT_CAMERA_AT_CAR player_car_rm2 FIXED JUMP_CUT
	SET_CHAR_OBJ_LEAVE_CAR player_rm2 player_car_rm2
	WHILE IS_CHAR_IN_CAR player_rm2 player_car_rm2
		WAIT 0
		IF IS_CAR_DEAD player_car_rm2
			GOTO boobble
		ENDIF
		IF IS_CHAR_DEAD phil
			flag_phil_dead = 1
			REMOVE_BLIP blip_phil
			GOTO mission_ray2_failed
		ENDIF
	ENDWHILE
ENDIF

boobble:

//GET_PLAYER_COORDINATES player player_rm2_x player_rm2_y player_rm2_z
GET_PLAYER_CHAR player player_rm2

IF NOT IS_CHAR_DEAD phil
	TURN_CHAR_TO_FACE_CHAR phil player_rm2 
	POINT_CAMERA_AT_CHAR phil FIXED JUMP_CUT
ENDIF

//TURN_CHAR_TO_FACE_CHAR player_rm2 phil
//TURN_CHAR_TO_FACE_CHAR phil player_rm2
//CHAR_LOOK_AT_CHAR_ALWAYS player_rm2 phil

LOAD_MISSION_AUDIO R2_F
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_L) 3000 1// Heh-hey! If I'd teamed up with you in Nicaragua maybe I'd still have my arm!
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

IF flag_m16_gone = 0
	REMOVE_PICKUP phils_m16
ENDIF
IF flag_shotgun_gone = 0
	REMOVE_PICKUP phils_shotgun
ENDIF
IF flag_uzi_gone = 0
	REMOVE_PICKUP phils_uzi
ENDIF
IF flag_molotov_gone = 0
	REMOVE_PICKUP phils_molotov
ENDIF
IF flag_rocket_gone = 0
	REMOVE_PICKUP phils_rocket
ENDIF

IF flag_ray_mission2_passed = 0
	REMOVE_PICKUP phils_armour
ENDIF

m16_x = 145.5
m16_y = 170.0
uzi_x = 143.5
uzi_y = 170.0
shotgun_x = 141.5
shotgun_y = 170.0
CREATE_PICKUP WEAPON_M16 PICKUP_IN_SHOP m16_x m16_y 11.5 phils_m16
CREATE_PICKUP WEAPON_SHOTGUN PICKUP_IN_SHOP uzi_x uzi_y 11.5 phils_uzi
CREATE_PICKUP WEAPON_ROCKET PICKUP_IN_SHOP shotgun_x shotgun_y 11.5 phils_shotgun
flag_m16_gone = 1
flag_uzi_gone = 1
flag_shotgun_gone = 1

LOAD_MISSION_AUDIO R2_G
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_M) 3000 1// If you need any firepower just drop by and take what you need from the rack
SET_FIXED_CAMERA_POSITION 143.5 179.0 11.5 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 144.0 170.7 11.5 JUMP_CUT
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE



LOAD_MISSION_AUDIO R2_H
WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE
SET_MISSION_AUDIO_POSITION phils_defcon_x phils_defcon_y phils_defcon_z
PLAY_MISSION_AUDIO
PRINT_NOW (RM2_N) 3000 1//-leave the cash under the bench. Now get out of here, I'll handle the cops
WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0
ENDWHILE

POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION
WAIT 2000

//ALTER_WANTED_LEVEL_NO_DROP player 3

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_NO_OBJ phil 
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil 144.0 174.4
ENDIF

WHILE flag_phil_arrived = 0
	WAIT 0
	IF NOT IS_CHAR_DEAD phil
		IF LOCATE_CHAR_ON_FOOT_2D phil 144.0 174.4 1.0 1.0 false
		 flag_phil_arrived = 1
		ENDIF
	ELSE
		GOTO mission_ray2_failed
	ENDIF
ENDWHILE

DELETE_CHAR phil
SWITCH_WIDESCREEN off
RESTORE_CAMERA_JUMPCUT 
SET_PLAYER_CONTROL player on

GOTO mission_ray2_passed
	   		



// Mission Ray2 failed

mission_ray2_failed:

IF flag_phil_dead = 1
	PRINT_NOW (RM2_H) 3000 1 //Phil has been killed!!
ENDIF

PRINT_BIG ( M_FAIL ) 2000 1

RETURN

   

// mission Ray2 passed

mission_ray2_passed:

IF flag_m16_gone = 0
	REMOVE_PICKUP phils_m16
	flag_m16_gone = 1
ENDIF
IF flag_shotgun_gone = 0
	REMOVE_PICKUP phils_shotgun
	flag_shotgun_gone = 1
ENDIF
IF flag_uzi_gone = 0
	REMOVE_PICKUP phils_uzi
	flag_uzi_gone = 1
ENDIF
IF flag_molotov_gone = 0
	REMOVE_PICKUP phils_molotov
	flag_molotov_gone = 1
ENDIF
IF flag_rocket_gone = 0
	REMOVE_PICKUP phils_rocket
	flag_rocket_gone = 1
ENDIF


flag_ray_mission2_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED RM2
PLAYER_MADE_PROGRESS 1 
START_NEW_SCRIPT ray_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_ray2:

flag_player_on_mission = 0
flag_player_on_ray_mission = 0
flag_player_on_phil_mission = 0

SET_PLAYER_CONTROL player on
SWITCH_WIDESCREEN off
RESTORE_CAMERA_JUMPCUT 


MARK_MODEL_AS_NO_LONGER_NEEDED PED_SPECIAL1 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_RHINO 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PATRIOT 

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BARRACKS 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
//MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PERENNIAL 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A 
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B

UNLOAD_SPECIAL_CHARACTER 1

REMOVE_BLIP blip_warehouse_rm2
REMOVE_BLIP blip_sentinel1
REMOVE_BLIP blip_stallion1
REMOVE_BLIP blip_perenial1

GOSUB blip_removal_rm2

IF flag_m16_gone = 0
	REMOVE_PICKUP phils_m16
ENDIF
IF flag_shotgun_gone = 0
	REMOVE_PICKUP phils_shotgun
ENDIF
IF flag_uzi_gone = 0
	REMOVE_PICKUP phils_uzi
ENDIF
IF flag_molotov_gone = 0
	REMOVE_PICKUP phils_molotov
ENDIF
IF flag_rocket_gone = 0
	REMOVE_PICKUP phils_rocket
ENDIF

IF flag_ray_mission2_passed = 0
	REMOVE_PICKUP phils_armour
ENDIF

MISSION_HAS_FINISHED
RETURN
		

//---------------------------GOSUBS----------------GOSUBS---------------------------actuallydon'tchaknow


//-------------------------------BAILOUT----------------------------------------------

big_bailout_routine:

	IF stallion_bailout = 0
	AND flag_stallion_arrived = 1
				
		IF NOT IS_CHAR_DEAD varmint_5
			IF NOT IS_CAR_DEAD	stallion1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_5 stallion1_rm2
				WHILE IS_CHAR_IN_CAR varmint_5 stallion1_rm2
					WAIT 0
					IF IS_CAR_DEAD stallion1_rm2
						GOTO plook2
					ENDIF
					IF IS_CHAR_DEAD varmint_5
						GOTO plook1
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_5
					ADD_BLIP_FOR_CHAR_OLD varmint_5 1 BLIP_ONLY blip_v5
					ADD_ARMOUR_TO_CHAR varmint_5 100
					GIVE_WEAPON_TO_CHAR varmint_5 WEAPONTYPE_UZI 60
					SET_CHAR_OBJ_RUN_TO_COORD varmint_5 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_5 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_5 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_5 true
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_5 player
				ENDIF
			ENDIF
		ENDIF

		plook1:

		IF NOT IS_CHAR_DEAD varmint_6
			IF NOT IS_CAR_DEAD	stallion1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_6 stallion1_rm2
				WHILE IS_CHAR_IN_CAR varmint_6 stallion1_rm2
					WAIT 0
					IF IS_CAR_DEAD stallion1_rm2
						GOTO plook2
					ENDIF
					IF IS_CHAR_DEAD varmint_6
						GOTO plook2
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_6
				//AND NOT IS_CHAR_DEAD phil
					ADD_BLIP_FOR_CHAR_OLD varmint_6 1 BLIP_ONLY blip_v6
					GIVE_WEAPON_TO_CHAR varmint_6 WEAPONTYPE_UZI 60
					SET_CHAR_OBJ_RUN_TO_COORD varmint_6 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_6 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_6 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_6 true
					//SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_6 phil
				ENDIF
			ENDIF
		ENDIF

		plook2:
		REMOVE_BLIP blip_stallion1
		stallion_bailout = 1
	
	ENDIF


	IF sentinel_bailout = 0
	AND flag_sentinel_arrived = 1
		
		IF NOT IS_CHAR_DEAD varmint_1
			IF NOT IS_CAR_DEAD	sentinel1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_1 sentinel1_rm2
				WHILE IS_CHAR_IN_CAR varmint_1 sentinel1_rm2
					WAIT 0
					IF IS_CAR_DEAD sentinel1_rm2
						GOTO plook6
					ENDIF
					IF IS_CHAR_DEAD varmint_1
						GOTO plook3
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_1
					ADD_BLIP_FOR_CHAR_OLD varmint_1 1 BLIP_ONLY blip_v1
					GIVE_WEAPON_TO_CHAR varmint_1 WEAPONTYPE_SHOTGUN 20
					SET_CHAR_OBJ_RUN_TO_COORD varmint_1 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_1 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_1 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_1 true
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_1 player
				ENDIF
			ENDIF
		ENDIF

		plook3:
		IF NOT IS_CHAR_DEAD varmint_2
			IF NOT IS_CAR_DEAD	sentinel1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_2 sentinel1_rm2
				WHILE IS_CHAR_IN_CAR varmint_2 sentinel1_rm2
					WAIT 0
					IF IS_CAR_DEAD sentinel1_rm2
						GOTO plook6
					ENDIF
					IF IS_CHAR_DEAD varmint_2
						GOTO plook4
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_2
				//AND NOT IS_CHAR_DEAD phil
					ADD_BLIP_FOR_CHAR_OLD varmint_2 1 BLIP_ONLY blip_v2
					GIVE_WEAPON_TO_CHAR varmint_2 WEAPONTYPE_SHOTGUN 20
					SET_CHAR_OBJ_RUN_TO_COORD varmint_2 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_2 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_2 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_2 true
					//SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_2 phil
				ENDIF
			ENDIF
		ENDIF

		plook4:
		IF NOT IS_CHAR_DEAD varmint_3
			IF NOT IS_CAR_DEAD	sentinel1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_3 sentinel1_rm2
				WHILE IS_CHAR_IN_CAR varmint_3 sentinel1_rm2
					WAIT 0
					IF IS_CAR_DEAD sentinel1_rm2
						GOTO plook6
					ENDIF
					IF IS_CHAR_DEAD varmint_3
						GOTO plook5
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_3
				//AND NOT IS_CHAR_DEAD phil
					ADD_BLIP_FOR_CHAR_OLD varmint_3 1 BLIP_ONLY blip_v3
					GIVE_WEAPON_TO_CHAR varmint_3 WEAPONTYPE_CHAINGUN 80
					SET_CHAR_OBJ_RUN_TO_COORD varmint_3 140.0 209.5
					SET_CHAR_THREAT_SEARCH varmint_3 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_3 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_3 true
					//SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_3 phil
				ENDIF
			ENDIF
		ENDIF

		plook5:
		IF NOT IS_CHAR_DEAD varmint_4
			IF NOT IS_CAR_DEAD	sentinel1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_4 sentinel1_rm2
				WHILE IS_CHAR_IN_CAR varmint_4 sentinel1_rm2
					WAIT 0
					IF IS_CAR_DEAD sentinel1_rm2
						GOTO plook6
					ENDIF
					IF IS_CHAR_DEAD varmint_4
						GOTO plook6
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_4
					ADD_BLIP_FOR_CHAR_OLD varmint_4 1 BLIP_ONLY blip_v4
					ADD_ARMOUR_TO_CHAR varmint_4 100
					GIVE_WEAPON_TO_CHAR varmint_4 WEAPONTYPE_MOLOTOV 5
					SET_CHAR_OBJ_RUN_TO_COORD varmint_4 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_4 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_4 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_4 true
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_4 player
				ENDIF
			ENDIF
		ENDIF

		plook6:
		REMOVE_BLIP blip_sentinel1 
		sentinel_bailout = 1
	ENDIF

	IF perenial_bailout = 0
	AND flag_perenial_arrived = 1
		
		IF NOT IS_CHAR_DEAD varmint_7
			IF NOT IS_CAR_DEAD perenial1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_7 perenial1_rm2
				WHILE IS_CHAR_IN_CAR varmint_7 perenial1_rm2
					WAIT 0
					IF IS_CAR_DEAD perenial1_rm2
						GOTO plook10
					ENDIF
					IF IS_CHAR_DEAD varmint_7
						GOTO plook7
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_7
					ADD_BLIP_FOR_CHAR_OLD varmint_7 1 BLIP_ONLY blip_v7
					GIVE_WEAPON_TO_CHAR varmint_7 WEAPONTYPE_SHOTGUN 10
					SET_CHAR_OBJ_RUN_TO_COORD varmint_7 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_7 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_7 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_7 true
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_7 player
				ENDIF
			ENDIF
		ENDIF

		plook7:
		IF NOT IS_CHAR_DEAD varmint_8
			IF NOT IS_CAR_DEAD perenial1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_8 perenial1_rm2
				WHILE IS_CHAR_IN_CAR varmint_8 perenial1_rm2
					WAIT 0
					IF IS_CAR_DEAD perenial1_rm2
						GOTO plook10
					ENDIF
					IF IS_CHAR_DEAD varmint_8
						GOTO plook8
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_8
				//AND NOT IS_CHAR_DEAD phil
					ADD_BLIP_FOR_CHAR_OLD varmint_8 1 BLIP_ONLY blip_v8
					GIVE_WEAPON_TO_CHAR varmint_8 WEAPONTYPE_CHAINGUN 45
					SET_CHAR_OBJ_RUN_TO_COORD varmint_8 129.7 199.8
					SET_CHAR_THREAT_SEARCH varmint_8 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_8 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_8 true
					//SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_8 phil
				ENDIF
			ENDIF
		ENDIF
					
		plook8:
		IF NOT IS_CHAR_DEAD varmint_9
			IF NOT IS_CAR_DEAD perenial1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_9 perenial1_rm2
				WHILE IS_CHAR_IN_CAR varmint_9 perenial1_rm2
					WAIT 0
					IF IS_CAR_DEAD perenial1_rm2
						GOTO plook10
					ENDIF
					IF IS_CHAR_DEAD varmint_9
						GOTO plook9
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_9
				//AND NOT IS_CHAR_DEAD phil
					ADD_BLIP_FOR_CHAR_OLD varmint_9 1 BLIP_ONLY blip_v9
					GIVE_WEAPON_TO_CHAR varmint_9 WEAPONTYPE_PISTOL 30
					SET_CHAR_OBJ_RUN_TO_COORD varmint_9 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_9 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_9 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_9 true
					//SET_CHAR_OBJ_KILL_CHAR_ON_FOOT varmint_9 phil
				ENDIF
			ENDIF
		ENDIF
					
		plook9:
		IF NOT IS_CHAR_DEAD varmint_10
			IF NOT IS_CAR_DEAD perenial1_rm2
				SET_CHAR_OBJ_LEAVE_CAR varmint_10 perenial1_rm2
				WHILE IS_CHAR_IN_CAR varmint_10 perenial1_rm2
					WAIT 0
					IF IS_CAR_DEAD perenial1_rm2
						GOTO plook10
					ENDIF
					IF IS_CHAR_DEAD varmint_10
						GOTO plook10
					ENDIF
				ENDWHILE
				IF NOT IS_CHAR_DEAD varmint_10
					ADD_BLIP_FOR_CHAR_OLD varmint_10 1 BLIP_ONLY blip_v10
					GIVE_WEAPON_TO_CHAR varmint_10 WEAPONTYPE_SHOTGUN 20
					ADD_ARMOUR_TO_CHAR varmint_10 100
					SET_CHAR_OBJ_RUN_TO_COORD varmint_10 wh_x_rm2 wh_y_rm2
					SET_CHAR_THREAT_SEARCH varmint_10 THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH varmint_10 THREAT_SPECIAL
					SET_CHAR_HEED_THREATS varmint_10 true
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT varmint_10 player
				ENDIF
			ENDIF
		ENDIF
					
		plook10:
		REMOVE_BLIP blip_perenial1
		perenial_bailout = 1
	ENDIF


RETURN

//-------------------VARMINT DEATHS-----------------------------------------

varmint_deaths:

	IF flag_sentinel_created = 1	
		IF flag_v1_dead = 0
			IF IS_CHAR_DEAD varmint_1
				flag_v1_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v1
			ENDIF
		ENDIF

		IF flag_v2_dead = 0
			IF IS_CHAR_DEAD varmint_2
				flag_v2_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v2
			ENDIF
		ENDIF

		IF flag_v3_dead = 0
			IF IS_CHAR_DEAD varmint_3
				flag_v3_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v3
			ENDIF
		ENDIF

		IF flag_v4_dead = 0
			IF IS_CHAR_DEAD varmint_4
				flag_v4_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v4
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_stallion_created = 1
		IF flag_v5_dead = 0
			IF IS_CHAR_DEAD varmint_5
				flag_v5_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v5
			ENDIF
		ENDIF

		IF flag_v6_dead = 0
			IF IS_CHAR_DEAD varmint_6
				flag_v6_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v6
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_perenial_created = 1
		IF flag_v7_dead = 0
			IF IS_CHAR_DEAD varmint_7
				flag_v7_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v7
			ENDIF
		ENDIF

		IF flag_v8_dead = 0
			IF IS_CHAR_DEAD varmint_8
				flag_v8_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v8
			ENDIF
		ENDIF

		IF flag_v9_dead = 0
			IF IS_CHAR_DEAD varmint_9
				flag_v9_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v9
			ENDIF
		ENDIF

		IF flag_v10_dead = 0
			IF IS_CHAR_DEAD varmint_10
				flag_v10_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v10
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_sneaky_1 = 1
		IF flag_v11_dead = 0
			IF IS_CHAR_DEAD varmint_11
				flag_v11_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v11
			ENDIF
		ENDIF
	ENDIF
	IF flag_sneaky_2 = 1
		IF flag_v12_dead = 0
			IF IS_CHAR_DEAD varmint_12
				flag_v12_dead = 1
				++ counter_dead_varmints
				REMOVE_BLIP blip_v12
			ENDIF
		ENDIF
	ENDIF


RETURN

//---------------PICKUPS------------------------

pickups:

	IF flag_m16_gone = 0
		IF HAS_PICKUP_BEEN_COLLECTED phils_m16
			//GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_M16 80
			SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_M16
			flag_m16_gone = 1
		ENDIF
	ENDIF
	
	IF flag_uzi_gone = 0
		IF HAS_PICKUP_BEEN_COLLECTED phils_uzi
			//GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_UZI 100
			SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_UZI
			flag_uzi_gone = 1
		ENDIF
	ENDIF		
	
	IF flag_rocket_gone = 0
		IF HAS_PICKUP_BEEN_COLLECTED phils_rocket
			//GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_ROCKET 3
			SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_ROCKET
			flag_rocket_gone = 1
		ENDIF
	ENDIF		
	
	IF flag_shotgun_gone = 0
		IF HAS_PICKUP_BEEN_COLLECTED phils_shotgun
			//GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_SHOTGUN 100
			SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_SHOTGUN
			flag_shotgun_gone = 1
		ENDIF
	ENDIF

	IF flag_molotov_gone = 0
		IF HAS_PICKUP_BEEN_COLLECTED phils_molotov
			//GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_SHOTGUN 100
			SET_CURRENT_PLAYER_WEAPON player WEAPONTYPE_MOLOTOV
			flag_molotov_gone = 1
		ENDIF
	ENDIF

RETURN


//------blip removal-------------------------------

blip_removal_rm2:

	REMOVE_BLIP blip_v1
	REMOVE_BLIP blip_v2
	REMOVE_BLIP blip_v3
	REMOVE_BLIP blip_v4
	REMOVE_BLIP blip_v5
	REMOVE_BLIP blip_v6
	REMOVE_BLIP blip_v7
	REMOVE_BLIP blip_v8
	REMOVE_BLIP blip_v9
	REMOVE_BLIP blip_v10
	REMOVE_BLIP blip_v11
	REMOVE_BLIP blip_v12

RETURN
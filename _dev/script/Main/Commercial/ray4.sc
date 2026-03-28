MISSION_START
// *****************************************************************************************
// *********************************** Ray Mission 4 ***************************************
// *********************************** Gone Fishing	 ***************************************
// *****************************************************************************************
// *** Ray's partner is going to turn State's Evidence. He goes night fishing on the     ***
// *** Lighthouse Rock. The player will have to use a boat to get to him.  This boat will***
// *** have guns, and that is how the player must kill Ray's partner. Ray's partner will ***
// *** also have a weapon of his own, as he flees he will be dropping barrels of 		 ***
// *** explosives into the water and the path of the player.							 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray4

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray4_failed
ENDIF

GOSUB mission_cleanup_ray4

MISSION_END
 
// Variables for mission

VAR_INT rays_partner partners_car partners_boat partners_blip players_boat_with_guns players_boat_with_guns_blip timer_reset_flag_r4
VAR_INT partners_boat_health random_int gotaway_timer gotaway_timer_current gotaway_timer_started partner_on_foot_counter
VAR_INT mine_current_timer last_mine_dropped_timer temporary_time_mine fish_target barrel2_a barrel2_b 
VAR_INT gotaway_timer_reset_flag boat_speed_flag boat_node_counter partners_car_is_dead shoot_at_player_flag partner_on_foot_flag
VAR_INT fishy_1 fishy_2 fishy_3 fishy_4 fishy_5 fishy_6 fishy_7 fishy_8 fishy_9 fishy_10 partners_boat_health2 goto_mission_ray4_failed
VAR_INT timerc_r4 timerc_current_r4 timerc_started_r4 timerc_reset_flag_r4 exit_boat_flag

VAR_FLOAT partner_x partner_y partner_z	partners_boat_speed	player_x player_y player_z fish_target_x fish_target_y fish_target_z
VAR_FLOAT vector_x vector_y temp_vector_x temp_vector_y	temp_distance distance_between_boats partners_boat_forward_x partners_boat_forward_y
VAR_FLOAT temp_dot_product_x temp_dot_product_y	dot_product	temp_x temp_y distance_resultA	distance_resultB
VAR_FLOAT sniper_object_a_x sniper_object_a_y 

VAR_FLOAT boat_node_x boat_node_y node_0_x node_0_y node_1_x node_1_y node_2_x node_2_y node_3_x node_3_y node_4_x node_4_y node_5_x node_5_y
VAR_FLOAT node_6_x node_6_y node_7_x node_7_y node_8_x node_8_y node_9_x node_9_y node_10_x node_10_y node_11_x node_11_y
VAR_FLOAT partner_stuck_x partner_stuck_y partner_stuck_z

// ****************************************Mission Start************************************

mission_start_ray4:

flag_player_on_mission = 1
flag_player_on_ray_mission = 1
rays_cutscene_flag = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME ray4

mine_current_timer = 0
last_mine_dropped_timer = 0
temporary_time_mine = 0
random_int = 0
boat_speed_flag	= 0
boat_node_counter = 2
partners_car_is_dead = 0
shoot_at_player_flag = 0
gotaway_timer_reset_flag = 0
partner_on_foot_counter = 0
partner_on_foot_flag = 0
partner_on_foot_counter = 0
goto_mission_ray4_failed = 0
timer_reset_flag_r4 = 0
timerc_r4 = 0
timerc_current_r4 = 0
timerc_started_r4 = 0
timerc_reset_flag_r4 = 0
exit_boat_flag = 0

partner_stuck_x	= 0.0
partner_stuck_y	= 0.0
partner_stuck_z	= 0.0

node_0_x = 1405.4507 
node_0_y = -598.6941

node_1_x = 1710.1085
node_1_y = -371.7377

node_2_x = 1713.1384
node_2_y = -498.4113

node_3_x = 1632.3
node_3_y = -601.5

node_4_x = 1619.8263
node_4_y = -764.9598

node_5_x = 1653.3024
node_5_y = -822.3922

node_6_x = 1681.7670
node_6_y = -775.2837

node_7_x = 1682.8789
node_7_y = -590.4975

node_8_x = 1577.6987
node_8_y = -498.9852

node_9_x = 1576.3445
node_9_y = -361.7413

node_10_x = 1568.4171
node_10_y = -249.0114

node_11_x = 1628.1332
node_11_y = -195.5839

{
// ****************************************START OF CUTSCENE********************************

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_ray4_failed
ENDIF

SWITCH_STREAMING OFF

PRINT_BIG RM4 15000 2 //"Gone Fishing"
*/

LOAD_SPECIAL_CHARACTER 1 ray
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 RAYH
LOAD_SPECIAL_MODEL cut_obj3 BOGDOOR
REQUEST_MODEL toilet

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED toilet
	WAIT 0
ENDWHILE

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 47.322 -732.055 22.846 4.0 toilet_cubicle_dr2 FALSE

LOAD_CUTSCENE r4_gf

SET_CUTSCENE_OFFSET 39.424 -726.677 21.692

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player

SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_ray

SET_CUTSCENE_ANIM cs_ray ray

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray

CREATE_CUTSCENE_OBJECT cut_obj3 cs_ludoor
SET_CUTSCENE_ANIM cs_ludoor BOGDOOR

SWITCH_RUBBISH OFF
DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON

SET_NEAR_CLIP 0.2

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4285
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM4_A 4000 1 //"I think my partner's a rat."

WHILE cs_time < 6389
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM4_B 4000 1 //"We gotta shut him up permanently."

WHILE cs_time < 8524
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM4_C 4000 1 //"He goes fishing out of his boat near the lighthouse on Portland Rock most nights."

WHILE cs_time < 13026
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM4_D	4000 1 //"Steal a police boat and make sure his back stabbing plans are sunk!"

WHILE cs_time < 17497
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM4_E	4000 1 //"I want him sleeping with the fishes not eating them."

WHILE cs_time < 21000
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

SET_NEAR_CLIP 0.9

FORCE_WEATHER_NOW WEATHER_SUNNY

SET_CAMERA_BEHIND_PLAYER

WAIT 500

rays_cutscene_flag = 0

DO_FADE 1500 FADE_IN 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 47.322 -732.055 22.846 4.0 toilet_cubicle_dr2 TRUE

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED toilet
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3

// ******************************************END OF CUTSCENE********************************

REQUEST_MODEL BOAT_PREDATOR
REQUEST_MODEL BOAT_GHOST 
REQUEST_MODEL CAR_SENTINEL 
REQUEST_MODEL CAR_RCBANDIT 

WHILE NOT HAS_MODEL_LOADED BOAT_PREDATOR
OR NOT HAS_MODEL_LOADED BOAT_GHOST
OR NOT HAS_MODEL_LOADED CAR_SENTINEL
OR NOT HAS_MODEL_LOADED CAR_RCBANDIT
	WAIT 0
ENDWHILE

CREATE_CAR BOAT_PREDATOR 837.0 -1115.6 -0.2 players_boat_with_guns

SET_CAR_HEADING players_boat_with_guns 140.0
ADD_BLIP_FOR_CAR players_boat_with_guns players_boat_with_guns_blip

PRINT_NOW RM4_1 5000 1 //"Go steal a boat."

/////////////////////////
/////////////////////////
//SET_PLAYER_COORDINATES player 833.88 -1114.9 6.0
//WAIT 1500
//
//IF NOT IS_CAR_DEAD players_boat_with_guns
//ENDIF
//
//WARP_PLAYER_INTO_CAR player	players_boat_with_guns
/////////////////////////
/////////////////////////

WHILE NOT IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	WAIT 0
ENDWHILE

REMOVE_BLIP	players_boat_with_guns_blip

//CREATE_CAR BOAT_GHOST 1695.0 -381.5 -1.3 partners_boat
CREATE_CAR BOAT_GHOST 1695.0 -381.5 -1.4 partners_boat
SET_CAR_STRONG partners_boat TRUE

CREATE_OBJECT barrel2 837.0 -1115.6 10.0 barrel2_a
CREATE_OBJECT barrel2 837.0 -1115.6 20.0 barrel2_b
//CREATE_OBJECT faketarget 837.0 -1115.6 30.0 sniper_object

SET_OBJECT_COLLISION barrel2_a OFF
SET_OBJECT_COLLISION barrel2_b OFF
//SET_OBJECT_COLLISION sniper_object OFF
SET_OBJECT_DYNAMIC barrel2_a FALSE
SET_OBJECT_DYNAMIC barrel2_b FALSE
//SET_OBJECT_DYNAMIC sniper_object FALSE

PLACE_OBJECT_RELATIVE_TO_CAR barrel2_a partners_boat -0.3 -2.5 0.2
PLACE_OBJECT_RELATIVE_TO_CAR barrel2_b partners_boat 0.3 -2.5 0.2

PRINT_NOW RM4_2 5000 1 //"Get to the lighthouse and 'rub out' Ray's partner!"

GET_CAR_HEALTH partners_boat partners_boat_health

ADD_BLIP_FOR_CAR_OLD partners_boat GREEN BOTH partners_blip
CHANGE_BLIP_SCALE partners_blip 3

/////////////////////////
/////////////////////////
//SET_PLAYER_COORDINATES PLAYER 1694.0 -589.0 0.0
/////////////////////////
/////////////////////////

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player 1700.0 -383.0 180.0 180.0 0
AND NOT partners_boat_health < 980
	
	WAIT 0
	
	IF IS_CAR_DEAD partners_boat
		GOTO mission_ray4_passed
	ENDIF

	GET_CAR_HEALTH partners_boat partners_boat_health

	GOSUB object_placement

ENDWHILE

GET_CAR_HEADING	partners_boat distance_resultB
GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
temp_dot_product_x = 0.0 * partners_boat_forward_y  //change both of these to move on the vehicles x axis
temp_dot_product_y = 0.0 * partners_boat_forward_x //

temp_x = 1.8 * partners_boat_forward_x //change both of these to move on the vehicles y axis
temp_y = 1.8 * partners_boat_forward_y //

vector_x = temp_dot_product_x - temp_x
vector_y = temp_dot_product_y - temp_y

vector_x = vector_x + partner_x 
vector_y = vector_y + partner_y

partner_z += 0.4

distance_resultB -= 90.0

IF distance_resultB < 0.0
	distance_resultB += 360.0
ENDIF

REMOVE_BLIP	partners_blip
CREATE_CHAR PEDTYPE_CIVMALE PED_MALE1 vector_x vector_y partner_z rays_partner
SET_CHAR_HEADING rays_partner distance_resultB
SET_CHAR_STAY_IN_SAME_PLACE rays_partner TRUE
CLEAR_CHAR_THREAT_SEARCH rays_partner
ADD_ARMOUR_TO_CHAR rays_partner 100
SET_CHAR_WAIT_STATE rays_partner WAITSTATE_PLAYANIM_DUCK 1700

TIMERA = 0
WHILE TIMERA < 1200
	WAIT 0
	GOSUB object_placement
ENDWHILE

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player OFF
SET_EVERYONE_IGNORE_PLAYER player ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
IF IS_PLAYER_IN_ANY_CAR player 
	IF IS_PLAYER_IN_MODEL player BOAT_PREDATOR
	OR IS_PLAYER_IN_MODEL player BOAT_REEFER
	OR IS_PLAYER_IN_MODEL player BOAT_GHOST
		MARK_CAR_AS_NO_LONGER_NEEDED players_boat_with_guns
		STORE_CAR_PLAYER_IS_IN player players_boat_with_guns
		ANCHOR_BOAT players_boat_with_guns TRUE
	ENDIF
	APPLY_BRAKES_TO_PLAYERS_CAR player ON
ENDIF

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF
IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
temp_dot_product_x = -5.0  * partners_boat_forward_y  //change both of these to move on the vehicles x axis
temp_dot_product_y = 5.0 * partners_boat_forward_x //

temp_x = 3.8 * partners_boat_forward_x //change both of these to move on the vehicles y axis
temp_y = 3.8 * partners_boat_forward_y //

vector_x = temp_dot_product_x - temp_x
vector_y = temp_dot_product_y - temp_y

vector_x = vector_x + partner_x 
vector_y = vector_y + partner_y

partner_z += 2.0

SET_FIXED_CAMERA_POSITION vector_x vector_y partner_z 0.0 0.0 0.0
POINT_CAMERA_AT_CHAR rays_partner FIXED JUMP_CUT

TIMERA = 0
WHILE TIMERA < 1500
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF
IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

SET_CHAR_WAIT_STATE rays_partner WAITSTATE_CROSS_ROAD_LOOK 1600

GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
temp_dot_product_x = 25.0  * partners_boat_forward_y  //change both of these to move on the vehicles x axis
temp_dot_product_y = -25.0 * partners_boat_forward_x //

temp_x = 1.8 * partners_boat_forward_x //change both of these to move on the vehicles y axis
temp_y = 1.8 * partners_boat_forward_y //

vector_x = temp_dot_product_x - temp_x
vector_y = temp_dot_product_y - temp_y

vector_x = vector_x + partner_x 
vector_y = vector_y + partner_y

partner_z = -2.0

TIMERA = 0
WHILE TIMERA < 1600
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

CREATE_CAR CAR_RCBANDIT vector_x vector_y partner_z fish_target
GIVE_WEAPON_TO_CHAR	rays_partner WEAPONTYPE_GRENADE 20
SET_CHAR_OBJ_NO_OBJ rays_partner
SET_CHAR_WAIT_STATE rays_partner WAITSTATE_FALSE 100
SET_CHAR_OBJ_DESTROY_CAR rays_partner fish_target
GET_CAR_COORDINATES	fish_target fish_target_x fish_target_y fish_target_z

partner_x =	fish_target_x -	2.0
partner_y =	fish_target_y -	2.0
partner_z =	fish_target_z -	2.0
temp_x += 2.0
vector_x += 2.0
vector_y += 1.0

WHILE NOT IS_PROJECTILE_IN_AREA partner_x partner_y partner_z temp_x vector_x vector_y // THE WINDOW
	WAIT 0

	GOSUB object_placement

	IF IS_CHAR_DEAD rays_partner
		GOTO mission_ray4_passed
	ENDIF

	IF IS_CAR_DEAD partners_boat
		GOTO mission_ray4_passed
	ENDIF

	IF IS_CAR_DEAD fish_target
	ENDIF

	SET_CAR_COORDINATES	fish_target	fish_target_x fish_target_y fish_target_z

ENDWHILE

SET_CHAR_OBJ_NO_OBJ rays_partner
DESTROY_PROJECTILES_IN_AREA partner_x partner_y partner_z temp_x vector_x vector_y

GET_CAR_COORDINATES	fish_target partner_x partner_y partner_z
partner_z += 1.0
fish_target_x =	partner_x
fish_target_y =	partner_y
fish_target_z =	partner_z
POINT_CAMERA_AT_POINT fish_target_x fish_target_y fish_target_z INTERPOLATION
DELETE_CAR fish_target

TIMERA = 0
WHILE TIMERA < 300
	WAIT 0
	GOSUB object_placement
ENDWHILE

partner_z = 0.0
ADD_EXPLOSION partner_x partner_y partner_z EXPLOSION_GRENADE
partner_z = 0.3
//ADD_PARTICLE_EFFECT POBJECT_CAR_WATER_SPLASH partner_x partner_y partner_z TRUE

IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
temp_dot_product_x = 30.0  * partners_boat_forward_y  //change both of these to move on the vehicles x axis
temp_dot_product_y = -30.0 * partners_boat_forward_x //

temp_x = 2.2 * partners_boat_forward_x //change both of these to move on the vehicles y axis
temp_y = 2.2 * partners_boat_forward_y //

vector_x = temp_dot_product_x - temp_x
vector_y = temp_dot_product_y - temp_y

vector_x = vector_x + partner_x 
vector_y = vector_y + partner_y

partner_z += 1.5

TIMERA = 0
WHILE TIMERA < 1000
	WAIT 0
	GOSUB object_placement
ENDWHILE

fish_target_z -= 0.2
SET_FIXED_CAMERA_POSITION vector_x vector_y partner_z 0.0 0.0 0.0
POINT_CAMERA_AT_POINT fish_target_x fish_target_y fish_target_z JUMP_CUT

TIMERA = 0
WHILE TIMERA < 1500
	WAIT 0
	GOSUB object_placement
ENDWHILE

fish_target_z = -0.5
partner_x = fish_target_x
partner_y = fish_target_y
partner_z = fish_target_z

fish_target_x = partner_x - 0.2
fish_target_y = partner_y - 0.2
fish_target_z = partner_z

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_1
SET_OBJECT_DYNAMIC fishy_1 TRUE
ADD_TO_OBJECT_VELOCITY fishy_1 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_1 temp_x

TIMERA = 0
WHILE TIMERA < 600
	WAIT 0
	GOSUB object_placement
ENDWHILE

fish_target_x += 0.9
fish_target_y += 0.3

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_2
SET_OBJECT_DYNAMIC fishy_2 TRUE
ADD_TO_OBJECT_VELOCITY fishy_2 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_2 temp_x

TIMERA = 0
WHILE TIMERA < 200
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_3
SET_OBJECT_DYNAMIC fishy_3 TRUE
ADD_TO_OBJECT_VELOCITY fishy_3 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_3 temp_x

TIMERA = 0
WHILE TIMERA < 400
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_4
SET_OBJECT_DYNAMIC fishy_4 TRUE
ADD_TO_OBJECT_VELOCITY fishy_4 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_4 temp_x

TIMERA = 0
WHILE TIMERA < 100
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_5
SET_OBJECT_DYNAMIC fishy_5 TRUE
ADD_TO_OBJECT_VELOCITY fishy_5 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_5 temp_x

TIMERA = 0
WHILE TIMERA < 300
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_6
SET_OBJECT_DYNAMIC fishy_6 TRUE
ADD_TO_OBJECT_VELOCITY fishy_6 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_6 temp_x

TIMERA = 0
WHILE TIMERA < 200
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_7
SET_OBJECT_DYNAMIC fishy_7 TRUE
ADD_TO_OBJECT_VELOCITY fishy_7 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_7 temp_x

TIMERA = 0
WHILE TIMERA < 120
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_8
SET_OBJECT_DYNAMIC fishy_8 TRUE
ADD_TO_OBJECT_VELOCITY fishy_8 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_8 temp_x

TIMERA = 0
WHILE TIMERA < 70
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_9
SET_OBJECT_DYNAMIC fishy_9 TRUE
ADD_TO_OBJECT_VELOCITY fishy_9 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_9 temp_x

TIMERA = 0
WHILE TIMERA < 35
	WAIT 0
	GOSUB object_placement
ENDWHILE

GENERATE_RANDOM_FLOAT_IN_RANGE -4.0 2.0 temp_x
fish_target_x = partner_x + temp_x
GENERATE_RANDOM_FLOAT_IN_RANGE -3.0 3.0 temp_x
fish_target_y = partner_y + temp_x

CREATE_OBJECT fish01 fish_target_x fish_target_y fish_target_z fishy_10
SET_OBJECT_DYNAMIC fishy_10 TRUE
ADD_TO_OBJECT_VELOCITY fishy_10 0.0 0.0 1.0
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 temp_x
SET_OBJECT_HEADING fishy_10 temp_x

TIMERA = 0
WHILE TIMERA < 2500
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

POINT_CAMERA_AT_CHAR rays_partner FIXED INTERPOLATION

TIMERA = 0
WHILE TIMERA < 200
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
temp_dot_product_x = 10.0  * partners_boat_forward_y  //change both of these to move on the vehicles x axis
temp_dot_product_y = -10.0 * partners_boat_forward_x //

temp_x = 2.2 * partners_boat_forward_x //change both of these to move on the vehicles y axis
temp_y = 2.2 * partners_boat_forward_y //

vector_x = temp_dot_product_x - temp_x
vector_y = temp_dot_product_y - temp_y

vector_x = vector_x + partner_x 
vector_y = vector_y + partner_y

partner_z += 2.0

fish_target_z -= 0.2
SET_FIXED_CAMERA_POSITION vector_x vector_y partner_z 0.0 0.0 0.0

TIMERA = 0
WHILE TIMERA < 800
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

CHAR_LOOK_AT_PLAYER_ALWAYS rays_partner player

TIMERA = 0
WHILE TIMERA < 600
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

STOP_CHAR_LOOKING rays_partner

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	rays_partner partner_x	partner_y

TIMERA = 0
WHILE TIMERA < 1000
	WAIT 0
	GOSUB object_placement
ENDWHILE

IF IS_CHAR_DEAD rays_partner
	GOTO mission_ray4_passed
ENDIF

IF IS_CAR_DEAD partners_boat
	GOTO mission_ray4_passed
ENDIF

DELETE_CHAR	rays_partner
CREATE_CHAR_INSIDE_CAR partners_boat PEDTYPE_CIVMALE PED_MALE1 rays_partner
SET_CHAR_THREAT_SEARCH rays_partner THREAT_PLAYER1
SET_CHAR_PERSONALITY rays_partner PEDSTAT_TOUGH_GUY
SET_CHAR_HEALTH	rays_partner 300
ADD_BLIP_FOR_CHAR rays_partner partners_blip

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player ON
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
APPLY_BRAKES_TO_PLAYERS_CAR player OFF
IF IS_CAR_STILL_ALIVE players_boat_with_guns
	ANCHOR_BOAT players_boat_with_guns FALSE
ENDIF
RESTORE_CAMERA

CREATE_CAR CAR_SENTINEL 1329.8947 -641.7307 11.1765	partners_car
SET_CAR_HEADING partners_car 180.8517

BOAT_GOTO_COORDS partners_boat node_2_x node_2_y 0.0
boat_node_x = node_2_x
boat_node_y	= node_2_y

GET_GAME_TIMER mine_current_timer
GET_GAME_TIMER last_mine_dropped_timer

GET_CAR_HEALTH partners_boat partners_boat_health
partners_boat_health = partners_boat_health - 250
partners_boat_health = partners_boat_health * 100
partners_boat_health = partners_boat_health / 750
partners_boat_health2 = partners_boat_health
partners_boat_health = 100 - partners_boat_health2
DISPLAY_ONSCREEN_COUNTER_WITH_STRING partners_boat_health COUNTER_DISPLAY_BAR DAM

boat_looop://///////////////////////////////////////////////////////////////////////////////

WAIT 0

IF IS_CHAR_DEAD rays_partner
	IF DOES_OBJECT_EXIST barrel2_a
		GET_OBJECT_COORDINATES barrel2_a fish_target_x fish_target_y fish_target_z
		ADD_EXPLOSION fish_target_x fish_target_y fish_target_z EXPLOSION_GRENADE
		DELETE_OBJECT barrel2_a
	ENDIF
	IF DOES_OBJECT_EXIST barrel2_b
		GET_OBJECT_COORDINATES barrel2_b fish_target_x fish_target_y fish_target_z
		ADD_EXPLOSION fish_target_x fish_target_y fish_target_z EXPLOSION_GRENADE
		DELETE_OBJECT barrel2_b
	ENDIF
	GOTO mission_ray4_passed
ENDIF

IF partner_on_foot_flag = -1
	IF NOT IS_CAR_DEAD partners_boat
		IF DOES_OBJECT_EXIST barrel2_a
		AND DOES_OBJECT_EXIST barrel2_b
			GOSUB object_placement
		ENDIF
	ENDIF
	IF TIMERA > 500
		TIMERA = 0
		IF IS_PLAYER_IN_ANY_CAR player
			MARK_CAR_AS_NO_LONGER_NEEDED players_boat_with_guns
			STORE_CAR_PLAYER_IS_IN player players_boat_with_guns
			SET_CHAR_ACCURACY rays_partner 100
			SET_CHAR_OBJ_DESTROY_CAR rays_partner players_boat_with_guns
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rays_partner player
		ENDIF
	ENDIF
ENDIF

IF partner_on_foot_flag = 0
	IF NOT IS_CAR_DEAD partners_boat

		IF DOES_OBJECT_EXIST barrel2_a
		AND DOES_OBJECT_EXIST barrel2_b
			GOSUB object_placement
		ENDIF

		GOSUB boat_health_counter

		IF boat_node_counter > 0
			
			GOSUB drop_mines

			IF boat_speed_flag = 1
				IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player partners_boat 100.0 100.0 0
					SET_BOAT_CRUISE_SPEED partners_boat 25.0
					boat_speed_flag = 0
				ENDIF
			ENDIF

			IF boat_speed_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player partners_boat 80.0 80.0 0
					SET_BOAT_CRUISE_SPEED partners_boat 35.0
					boat_speed_flag = 1
				ENDIF
			ENDIF
		ENDIF

		IF NOT boat_node_counter = 0
			IF LOCATE_CAR_2D partners_boat boat_node_x boat_node_y 5.0 5.0 0
				GOSUB select_boat_node
				BOAT_GOTO_COORDS partners_boat boat_node_x boat_node_y 0.0
			ENDIF
		ENDIF
		
		IF boat_node_counter = 0
			IF DOES_OBJECT_EXIST barrel2_a
				GET_OBJECT_COORDINATES barrel2_a fish_target_x fish_target_y fish_target_z
				DELETE_OBJECT barrel2_a
				DROP_NAUTICAL_MINE fish_target_x fish_target_y fish_target_z
			ENDIF
			IF DOES_OBJECT_EXIST barrel2_b
				GET_OBJECT_COORDINATES barrel2_b fish_target_x fish_target_y fish_target_z
				DELETE_OBJECT barrel2_b
				DROP_NAUTICAL_MINE fish_target_x fish_target_y fish_target_z
			ENDIF
			IF IS_CHAR_STOPPED_IN_AREA_2D rays_partner 1364.1 -614.512 1473.801 -560.223 0
				GOSUB exit_boat
				partner_on_foot_flag = 1
			ENDIF
		ENDIF
			
		IF LOCATE_CAR_3D partners_boat partner_stuck_x partner_stuck_y partner_stuck_z 4.0 4.0 4.0 0
			IF timerc_reset_flag_r4 = 0
				GET_GAME_TIMER timerc_started_r4
				timerc_reset_flag_r4 = 1
			ENDIF

			IF timerc_reset_flag_r4 = 1
				GET_GAME_TIMER timerc_current_r4
				timerc_r4 = timerc_current_r4 - timerc_started_r4
				IF timerc_r4 > 8000
					IF IS_CHAR_IN_AREA_2D rays_partner 1608.0 -536.0 1684.0 -472.0 0//ROCKY ISLAND
						GOSUB exit_boat
						SET_CHAR_STAY_IN_SAME_PLACE	rays_partner TRUE
						IF IS_PLAYER_IN_ANY_CAR player
							MARK_CAR_AS_NO_LONGER_NEEDED players_boat_with_guns
							STORE_CAR_PLAYER_IS_IN player players_boat_with_guns
							SET_CHAR_ACCURACY rays_partner 100
							SET_CHAR_OBJ_DESTROY_CAR rays_partner players_boat_with_guns
						ELSE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rays_partner player
						ENDIF
						timerc_reset_flag_r4 = 1
						partner_on_foot_flag = -1
					ELSE
						GET_CAR_COORDINATES	partners_boat fish_target_x fish_target_y fish_target_z
						GET_GROUND_Z_FOR_3D_COORD fish_target_x fish_target_y fish_target_z	fish_target_z
						IF NOT fish_target_z = 0.0000
							GOSUB exit_boat
							SET_CHAR_STAY_IN_SAME_PLACE	rays_partner TRUE
							IF IS_PLAYER_IN_ANY_CAR player
								MARK_CAR_AS_NO_LONGER_NEEDED players_boat_with_guns
								STORE_CAR_PLAYER_IS_IN player players_boat_with_guns
								SET_CHAR_ACCURACY rays_partner 100
								SET_CHAR_OBJ_DESTROY_CAR rays_partner players_boat_with_guns
							ELSE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rays_partner player
							ENDIF
							timerc_reset_flag_r4 = 1
							partner_on_foot_flag = -1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT LOCATE_CAR_3D partners_boat partner_stuck_x partner_stuck_y partner_stuck_z 4.0 4.0 4.0 0
			GET_CAR_COORDINATES partners_boat partner_stuck_x partner_stuck_y partner_stuck_z
			timerc_reset_flag_r4 = 0
		ENDIF

	ELSE
		IF DOES_OBJECT_EXIST barrel2_a
			GET_OBJECT_COORDINATES barrel2_a fish_target_x fish_target_y fish_target_z
			ADD_EXPLOSION fish_target_x fish_target_y fish_target_z EXPLOSION_GRENADE
			DELETE_OBJECT barrel2_a
		ENDIF
		IF DOES_OBJECT_EXIST barrel2_b
			GET_OBJECT_COORDINATES barrel2_b fish_target_x fish_target_y fish_target_z
			ADD_EXPLOSION fish_target_x fish_target_y fish_target_z EXPLOSION_GRENADE
			DELETE_OBJECT barrel2_b
		ENDIF
	ENDIF
ENDIF

IF partner_on_foot_flag = 1

	GOSUB partner_escape_checks
	IF goto_mission_ray4_failed = 1
		GOTO mission_ray4_failed
	ENDIF

	IF partner_on_foot_counter = 0
		IF NOT IS_PLAYER_IN_AREA_2D player 1364.1 -614.512 1473.801 -560.223 0
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1453.4 -583.39
			shoot_at_player_flag = 1
		ELSE
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1365.7308 -617.1476
		ENDIF
		partner_on_foot_counter = 1
	ENDIF
	
	IF shoot_at_player_flag > 0
		IF shoot_at_player_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1453.4 -583.39 1.0 1.0 0
				IF NOT IS_PLAYER_IN_AREA_2D player 1364.1 -614.512 1473.801 -560.223 0
					IF IS_PLAYER_IN_ANY_CAR	player
						MARK_CAR_AS_NO_LONGER_NEEDED players_boat_with_guns
						STORE_CAR_PLAYER_IS_IN player players_boat_with_guns
						SET_CHAR_ACCURACY rays_partner 100
						SET_CHAR_STAY_IN_SAME_PLACE rays_partner TRUE
						//SET_CHAR_HEED_THREATS rays_partner TRUE
						SET_CHAR_OBJ_DESTROY_CAR rays_partner players_boat_with_guns
					ENDIF
				ENDIF
				shoot_at_player_flag = 2
			ENDIF
		ENDIF

		IF shoot_at_player_flag = 2
			IF IS_PLAYER_IN_AREA_2D player 1364.1 -614.512 1473.801 -560.223 0
				SET_CHAR_STAY_IN_SAME_PLACE rays_partner FALSE
				//SET_CHAR_HEED_THREATS rays_partner FALSE
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1365.7308 -617.1476
				partner_on_foot_counter = 2
				shoot_at_player_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT partners_boat_health = -1
		GET_CHAR_HEALTH	rays_partner partners_boat_health
		IF partners_boat_health < 250
			SET_CHAR_HEED_THREATS rays_partner TRUE
			partners_boat_health = -1
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 1
		IF shoot_at_player_flag = 0
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1365.7308 -617.1476 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1344.5702 -617.2876
				partner_on_foot_counter = 2
			ENDIF
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 2
		IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1344.5702 -617.2876 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1340.5314 -614.0313
			partner_on_foot_counter = 3
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 3
		IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1340.5314 -614.0313 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1336.6632 -616.9997
			partner_on_foot_counter = 4
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 4
		IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1336.6632 -616.9997 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1333.7664 -631.9993
			partner_on_foot_counter = 5
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 5
		IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1333.7664 -631.9993 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1332.7195 -636.8160
			partner_on_foot_counter = 6
		ENDIF
	ENDIF

	IF partner_on_foot_counter = 6
		IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1332.7195 -636.8160 1.0 1.0 0
			IF IS_CAR_DEAD partners_car
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1331.7894 -678.1871
				partners_car_is_dead = 1
			ELSE
				SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER rays_partner partners_car
				partners_car_is_dead = -1
			ENDIF
			partner_on_foot_counter = 7
		ENDIF
	ENDIF

	IF partners_car_is_dead = 1
		IF partner_on_foot_counter = 7
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1331.7894 -678.1871 1.0 1.0 0  
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1331.3925 -709.0771
				partner_on_foot_counter = 8
			ENDIF
		ENDIF

		IF partner_on_foot_counter = 8
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1331.3925 -709.0771 1.0 1.0 0  
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1325.6399 -710.9251
				partner_on_foot_counter = 9
			ENDIF
		ENDIF

		IF partner_on_foot_counter = 9
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1325.6399 -710.9251 1.0 1.0 0  
				SET_CHAR_OBJ_RUN_TO_COORD rays_partner 1309.8854 -695.2979
				partner_on_foot_counter = 10
			ENDIF
		ENDIF

		IF partner_on_foot_counter = 10
			IF LOCATE_CHAR_ON_FOOT_2D rays_partner 1309.8854 -695.2979 1.0 1.0 0  
				GOSUB steal_a_car
				partner_on_foot_counter = 11
			ENDIF
		ENDIF

		IF partner_on_foot_counter = 11
			IF IS_CHAR_IN_ANY_CAR rays_partner
				MARK_CAR_AS_NO_LONGER_NEEDED partners_car
				STORE_CAR_CHAR_IS_IN rays_partner partners_car
				SET_CAR_ONLY_DAMAGED_BY_PLAYER partners_car TRUE
				SET_CAR_CRUISE_SPEED partners_car 50.0
				SET_CAR_DRIVING_STYLE partners_car 2
				CAR_WANDER_RANDOMLY	partners_car
				SET_CAR_AVOID_LEVEL_TRANSITIONS partners_car TRUE
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED partners_car TRUE
				partner_on_foot_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF partners_car_is_dead = -1
		IF partner_on_foot_counter = 7
			IF IS_CHAR_IN_ANY_CAR rays_partner
				MARK_CAR_AS_NO_LONGER_NEEDED partners_car
				STORE_CAR_CHAR_IS_IN rays_partner partners_car
				SET_CAR_ONLY_DAMAGED_BY_PLAYER partners_car TRUE
				SET_CAR_CRUISE_SPEED partners_car 30.0
				SET_CAR_DRIVING_STYLE partners_car 3
				CAR_GOTO_COORDINATES_ACCURATE partners_car 1331.2119 -662.4428 11.0086
				partner_on_foot_counter = 8
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD partners_car
			IF partner_on_foot_counter = 8
				IF LOCATE_CHAR_IN_CAR_2D rays_partner 1331.2119 -662.4428 5.0 5.0 0
					CAR_GOTO_COORDINATES_ACCURATE partners_car 1331.2119 -685.2106 11.3431
					partner_on_foot_counter = 9
				ENDIF
			ENDIF

			IF partner_on_foot_counter = 9
				IF LOCATE_CHAR_IN_CAR_2D rays_partner 1331.2119 -685.2106 5.0 5.0 0
					CAR_GOTO_COORDINATES_ACCURATE partners_car 1331.0211 -696.5710 12.2865
					partner_on_foot_counter = 10
				ENDIF
			ENDIF

			IF partner_on_foot_counter = 10
				IF LOCATE_CHAR_IN_CAR_2D rays_partner 1331.0211 -696.5710 5.0 5.0 0
					CAR_GOTO_COORDINATES_ACCURATE partners_car 1331.3907 -715.4436 14.2220
					partner_on_foot_counter = 11
				ENDIF
			ENDIF

			IF partner_on_foot_counter = 11
				IF LOCATE_CHAR_IN_CAR_2D rays_partner 1331.3907 -715.4436 5.0 5.0 0
					MARK_CAR_AS_NO_LONGER_NEEDED partners_car
					STORE_CAR_CHAR_IS_IN rays_partner partners_car
					SET_CAR_ONLY_DAMAGED_BY_PLAYER partners_car TRUE
					SET_CAR_CRUISE_SPEED partners_car 50.0
					SET_CAR_DRIVING_STYLE partners_car 2
					CAR_WANDER_RANDOMLY	partners_car
					SET_CAR_AVOID_LEVEL_TRANSITIONS partners_car TRUE
					SET_UPSIDEDOWN_CAR_NOT_DAMAGED partners_car TRUE
					partner_on_foot_flag = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF IS_CHAR_IN_ANY_CAR rays_partner
	AND partner_on_foot_flag = 3
		MARK_CAR_AS_NO_LONGER_NEEDED partners_car
		STORE_CAR_CHAR_IS_IN rays_partner partners_car
		SET_CAR_ONLY_DAMAGED_BY_PLAYER partners_car TRUE
		SET_CAR_CRUISE_SPEED partners_car 50.0
		SET_CAR_DRIVING_STYLE partners_car 2
		CAR_WANDER_RANDOMLY	partners_car
		SET_CAR_AVOID_LEVEL_TRANSITIONS partners_car TRUE
		SET_UPSIDEDOWN_CAR_NOT_DAMAGED partners_car TRUE
		partner_on_foot_flag = 2
	ENDIF
		
	IF partner_on_foot_flag = 2
		IF NOT IS_CHAR_IN_ANY_CAR rays_partner
			GOSUB steal_a_car
			//SET_CHAR_HEED_THREATS rays_partner TRUE
			partner_on_foot_flag = 3
		ENDIF
	ENDIF
	
	IF partner_on_foot_flag = 2
		IF NOT IS_CAR_DEAD partners_car
			IF TIMERB > 1000
				TIMERB = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 30.0 30.0 0
					SET_CAR_CRUISE_SPEED partners_car 50.0
				ELSE
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 80.0 80.0 0
						SET_CAR_CRUISE_SPEED partners_car 40.0
					ELSE
						SET_CAR_CRUISE_SPEED partners_car 30.0
					ENDIF
				ENDIF
			ENDIF
			
			IF IS_CAR_STOPPED partners_car
				IF timer_reset_flag_r4 = 0
					TIMERA = 0
					timer_reset_flag_r4 = 1
				ENDIF

				IF TIMERA > 8000
				AND timer_reset_flag_r4 = 1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 120.0 120.0 0
						SET_CHAR_OBJ_LEAVE_CAR rays_partner partners_car
						timer_reset_flag_r4 = 0
					ELSE
						IF NOT IS_CAR_ON_SCREEN partners_car
							GET_CAR_COORDINATES partners_car partner_x partner_y partner_z
							GET_CLOSEST_CAR_NODE_WITH_HEADING partner_x partner_y partner_z partner_x partner_y partner_z distance_between_boats
							IF NOT IS_POINT_ON_SCREEN partner_x partner_y partner_z 4.0
								SET_CAR_COORDINATES partners_car partner_x partner_y partner_z
								SET_CAR_HEADING	partners_car distance_between_boats
								timer_reset_flag_r4 = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
					
			IF IS_CAR_UPSIDEDOWN partners_car
			AND IS_CAR_STOPPED partners_car
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 120.0 120.0 0
					SET_CHAR_OBJ_LEAVE_CAR rays_partner partners_car
					SET_UPSIDEDOWN_CAR_NOT_DAMAGED partners_car FALSE
				ELSE
					IF NOT IS_CAR_ON_SCREEN partners_car
						GET_CAR_COORDINATES partners_car partner_x partner_y partner_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING partner_x partner_y partner_z partner_x partner_y partner_z distance_between_boats
						IF NOT IS_POINT_ON_SCREEN partner_x partner_y partner_z 4.0
							SET_CAR_COORDINATES partners_car partner_x partner_y partner_z
							SET_CAR_HEADING	partners_car distance_between_boats
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF LOCATE_CAR_3D partners_car partner_stuck_x partner_stuck_y partner_stuck_z 4.0 4.0 4.0 0
				IF timerc_reset_flag_r4 = 0
					GET_GAME_TIMER timerc_started_r4
					timerc_reset_flag_r4 = 1
				ENDIF

				IF timerc_reset_flag_r4 = 1
					GET_GAME_TIMER timerc_current_r4
					timerc_r4 = timerc_current_r4 - timerc_started_r4
					IF timerc_r4 > 8000
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 120.0 120.0 0
							SET_CHAR_OBJ_LEAVE_CAR rays_partner partners_car
							timerc_reset_flag_r4 = 0
						ELSE
							GET_CAR_COORDINATES partners_car partner_x partner_y partner_z
							GET_CLOSEST_CAR_NODE_WITH_HEADING partner_x partner_y partner_z partner_x partner_y partner_z distance_between_boats
							IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY partner_x partner_y partner_z 4.0 4.0 4.0
								IF NOT IS_POINT_ON_SCREEN partner_x partner_y partner_z 4.0
									SET_CAR_COORDINATES partners_car partner_x partner_y partner_z
									SET_CAR_HEADING	partners_car distance_between_boats
									timerc_reset_flag_r4 = 0
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT LOCATE_CAR_3D partners_car partner_stuck_x partner_stuck_y partner_stuck_z 4.0 4.0 4.0 0
				GET_CAR_COORDINATES partners_car partner_stuck_x partner_stuck_y partner_stuck_z
				timerc_reset_flag_r4 = 0
			ENDIF

			IF NOT IS_CAR_HEALTH_GREATER partners_car 400
				SET_CHAR_OBJ_LEAVE_CAR rays_partner partners_car
			ENDIF
		ENDIF
	ENDIF 
ENDIF 

GOTO boat_looop/////////////////////////////////////////////////////////////////////////////


// Mission Ray4 failed

mission_ray4_failed:
PRINT_BIG M_FAIL 5000 1
RETURN

   

// mission Ray4 passed

mission_ray4_passed:

flag_ray_mission4_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 15000 2000 1
ADD_SCORE player 15000
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	RM4
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT ray_mission5_loop
RETURN
		


// mission cleanup

mission_cleanup_ray4:
					 
REMOVE_BLIP partners_blip
REMOVE_BLIP players_boat_with_guns_blip
CLEAR_ONSCREEN_COUNTER partners_boat_health
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_PREDATOR
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_GHOST
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_RCBANDIT
flag_player_on_mission = 0
flag_player_on_ray_mission = 0
MISSION_HAS_FINISHED
RETURN
		

object_placement:///////////////////////////////////////////////////////////////////////

IF NOT IS_CAR_DEAD partners_boat
	PLACE_OBJECT_RELATIVE_TO_CAR barrel2_a partners_boat -0.5 -3.8 1.1
	PLACE_OBJECT_RELATIVE_TO_CAR barrel2_b partners_boat 0.5 -3.8 1.1
ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////


drop_mines://///////////////////////////////////////////////////////////////////////////

	GET_GAME_TIMER mine_current_timer
	temporary_time_mine = mine_current_timer - last_mine_dropped_timer
	IF temporary_time_mine > 2000
		GENERATE_RANDOM_INT_IN_RANGE 0 4 random_int
		GET_GAME_TIMER last_mine_dropped_timer
		IF random_int = 2
			GET_CAR_SPEED partners_boat partners_boat_speed
			
			GET_PLAYER_COORDINATES player player_x player_y player_z
			
			GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 5.0 5.0 0
				IF partners_boat_speed > 12.0
					vector_x = partner_x - player_x
					vector_y = partner_y - player_y
					temp_vector_x = vector_x * vector_x
					temp_vector_y = vector_y * vector_y
					temp_distance = temp_vector_x + temp_vector_y
					SQRT temp_distance distance_between_boats
					
					IF distance_between_boats < 60.0
						GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
						GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y
						vector_x = vector_x / distance_between_boats
						vector_y = vector_y / distance_between_boats
						temp_dot_product_x = vector_x * partners_boat_forward_x
						temp_dot_product_y = vector_y * partners_boat_forward_y
						dot_product	= temp_dot_product_x + temp_dot_product_y
						
						IF dot_product > -0.5 
							DROP_NAUTICAL_MINE partner_x partner_y partner_z
							temp_x = partner_x
							temp_y = partner_y
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////


exit_boat://////////////////////////////////////////////////////////////////////////////

	IF exit_boat_flag = 0
		BOAT_STOP partners_boat
		GET_CAR_COORDINATES	partners_boat partner_x	partner_y partner_z
		GET_CAR_FORWARD_X partners_boat partners_boat_forward_x
		GET_CAR_FORWARD_Y partners_boat partners_boat_forward_y

		temp_dot_product_x = 3.0 * partners_boat_forward_y  //change both of these to move on the vehicles x axis
		temp_dot_product_y = -3.0 * partners_boat_forward_x //

		temp_x = 0.3 * partners_boat_forward_x //change both of these to move on the vehicles y axis
		temp_y = 0.3 * partners_boat_forward_y //

		vector_x = temp_dot_product_x - temp_x
		vector_y = temp_dot_product_y - temp_y

		vector_x = vector_x + partner_x 
		vector_y = vector_y + partner_y

		temp_dot_product_x = -3.0 * partners_boat_forward_y //change both of these to move on the vehicles x axis
		temp_dot_product_y = 3.0 * partners_boat_forward_x  //

		temp_x = 0.3 * partners_boat_forward_x //change both of these to move on the vehicles y axis
		temp_y = 0.3 * partners_boat_forward_y //

		temp_vector_x = temp_dot_product_x - temp_x
		temp_vector_y = temp_dot_product_y - temp_y

		temp_vector_x = temp_vector_x + partner_x 
		temp_vector_y = temp_vector_y + partner_y

		GET_PLAYER_COORDINATES player sniper_object_a_x sniper_object_a_y dot_product

		partner_x = sniper_object_a_x - vector_x
		partner_y = sniper_object_a_y - vector_y
		partner_x = partner_x * partner_x
		partner_y = partner_y * partner_y
		dot_product = partner_x + partner_y
		SQRT dot_product distance_resultA

		partner_x = sniper_object_a_x - temp_vector_x
		partner_y = sniper_object_a_y - temp_vector_y
		partner_x = partner_x * partner_x
		partner_y = partner_y * partner_y
		dot_product = partner_x + partner_y
		SQRT dot_product distance_resultB

		IF distance_resultA	< distance_resultB
			GET_GROUND_Z_FOR_3D_COORD vector_x vector_y partner_z dot_product //temp_x
			temp_x = partner_z + 15.0
			GET_GROUND_Z_FOR_3D_COORD vector_x vector_y temp_x temp_x
			IF temp_x > dot_product
				dot_product = temp_x + 1.0
			ENDIF
			IF NOT dot_product = 0.0000
				WARP_CHAR_FROM_CAR_TO_COORD	rays_partner vector_x vector_y partner_z
				SET_CHAR_HEADING rays_partner 90.0
			ELSE
				WARP_CHAR_FROM_CAR_TO_COORD	rays_partner temp_vector_x temp_vector_y partner_z
				SET_CHAR_HEADING rays_partner 90.0
			ENDIF
		ELSE
			GET_GROUND_Z_FOR_3D_COORD temp_vector_x temp_vector_y partner_z dot_product
			IF NOT dot_product = 0.0000
				WARP_CHAR_FROM_CAR_TO_COORD	rays_partner temp_vector_x temp_vector_y partner_z
				SET_CHAR_HEADING rays_partner 90.0
			ELSE
				WARP_CHAR_FROM_CAR_TO_COORD	rays_partner vector_x vector_y partner_z
				SET_CHAR_HEADING rays_partner 90.0
			ENDIF
		ENDIF
		GIVE_WEAPON_TO_CHAR rays_partner WEAPONTYPE_CHAINGUN 9999
		SET_CHAR_RUNNING rays_partner TRUE
		CLEAR_ONSCREEN_COUNTER partners_boat_health
		exit_boat_flag = 1
	ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////


boat_health_counter:////////////////////////////////////////////////////////////////////

	GET_CAR_HEALTH partners_boat partners_boat_health
	partners_boat_health = partners_boat_health - 250
	partners_boat_health = partners_boat_health * 100
	partners_boat_health = partners_boat_health / 750
	partners_boat_health2 = partners_boat_health
	partners_boat_health = 100 - partners_boat_health2

RETURN//////////////////////////////////////////////////////////////////////////////////


steal_a_car:////////////////////////////////////////////////////////////////////////////

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 100.0 100.0 0
		SET_CHAR_OBJ_STEAL_ANY_CAR rays_partner
	ELSE
		GET_CLOSEST_CAR_NODE_WITH_HEADING 1309.8854 -695.2979 15.3830 partner_x	partner_y partner_z dot_product
		MARK_CAR_AS_NO_LONGER_NEEDED partners_car
		CREATE_CAR CAR_SENTINEL	partner_x partner_y partner_z partners_car
		SET_CAR_HEADING	partners_car dot_product
		SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER rays_partner partners_car
	ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////

select_boat_node:///////////////////////////////////////////////////////////////////////

	IF boat_node_counter = 1
		IF partners_boat_health < 50
			boat_node_x = node_11_x
			boat_node_y = node_11_y
			boat_node_counter = 11
		ELSE
			boat_node_x = node_2_x
			boat_node_y = node_2_y
			boat_node_counter = 2
		ENDIF
		RETURN
	ENDIF

	IF boat_node_counter = 2
		boat_node_x = node_3_x
		boat_node_y	= node_3_y
		boat_node_counter = 3
		RETURN
	ENDIF

	IF boat_node_counter = 3
		IF partners_boat_health < 50
			boat_node_x = node_4_x
			boat_node_y	= node_4_y
			boat_node_counter = 4
		ELSE
			boat_node_x = node_0_x
			boat_node_y	= node_0_y
			boat_node_counter = 0
			SET_BOAT_CRUISE_SPEED partners_boat 35.0
			boat_speed_flag = -100
		ENDIF
		RETURN
	ENDIF

	IF boat_node_counter = 4
		boat_node_x = node_5_x
		boat_node_y = node_5_y
		boat_node_counter = 5
		RETURN
	ENDIF

	IF boat_node_counter = 5
		boat_node_x = node_6_x
		boat_node_y = node_6_y
		boat_node_counter = 6
		RETURN
	ENDIF

	IF boat_node_counter = 6
		boat_node_x = node_7_x
		boat_node_y = node_7_y
		boat_node_counter = 7
		RETURN
	ENDIF

	IF boat_node_counter = 7
		IF partners_boat_health < 50
			boat_node_x = node_8_x
			boat_node_y = node_8_y
			boat_node_counter = 8
		ELSE
			boat_node_x = node_3_x
			boat_node_y = node_3_y
			boat_node_counter = 3
		ENDIF
		RETURN
	ENDIF

	IF boat_node_counter = 8
		IF partners_boat_health < 50
			boat_node_x = node_1_x
			boat_node_y = node_1_y
			boat_node_counter = 1
		ELSE
			boat_node_x = node_3_x
			boat_node_y = node_3_y
			boat_node_counter = 3
		ENDIF
		RETURN
	ENDIF

	IF boat_node_counter = 9
		IF partners_boat_health < 50
			boat_node_x = node_2_x
			boat_node_y = node_2_y
			boat_node_counter = 2
		ELSE
			boat_node_x = node_8_x
			boat_node_y = node_8_y
			boat_node_counter = 8
		ENDIF
		RETURN
	ENDIF

	IF boat_node_counter = 10
		boat_node_x = node_9_x
		boat_node_y = node_9_y
		boat_node_counter = 9
		RETURN
	ENDIF

	IF boat_node_counter = 11
		boat_node_x = node_10_x
		boat_node_y = node_10_y
		boat_node_counter = 10
		RETURN
	ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////


partner_escape_checks://////////////////////////////////////////////////////////////////
	
	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 160.0 160.0 0
	AND NOT IS_CHAR_ON_SCREEN rays_partner
		IF gotaway_timer_reset_flag = 0
			REMOVE_BLIP	partners_blip
			GET_GAME_TIMER gotaway_timer_started
			gotaway_timer_reset_flag = 1
		ENDIF

		IF gotaway_timer_reset_flag = 1
			GET_GAME_TIMER gotaway_timer_current
			gotaway_timer = gotaway_timer_current - gotaway_timer_started
			IF gotaway_timer > 8000
				IF NOT IS_CHAR_ON_SCREEN rays_partner
					gotaway_timer_reset_flag = 0
					DELETE_CHAR rays_partner
					PRINT_NOW RM4_3 5000 1 //"Ray's partner has escaped!"
					goto_mission_ray4_failed = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF gotaway_timer_reset_flag = 1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player rays_partner 160.0 160.0 0
		OR IS_CHAR_ON_SCREEN rays_partner
			REMOVE_BLIP	partners_blip
			ADD_BLIP_FOR_CHAR rays_partner partners_blip
			gotaway_timer_reset_flag = 0
		ENDIF
	ENDIF

RETURN//////////////////////////////////////////////////////////////////////////////////
}
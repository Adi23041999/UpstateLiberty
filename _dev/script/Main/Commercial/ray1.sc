MISSION_START
// *****************************************************************************************
// ************************************ Ray mission 1  ************************************* 
// ************************************ Silent Witness *************************************
// *****************************************************************************************
// *** There was a witness to Salvatore's murder, kill him! Go to the witness protection ***
// *** house and flush him out by throwing a grenade through the window. The witness and ***
// *** some police escorts run out and leg it in a car, chase them and kill them.		 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray1_failed
ENDIF

GOSUB mission_cleanup_ray1

MISSION_END
 
// Variables for mission

VAR_INT get_away_car police_guard1 police_guard2 the_witness ray1_blip burning_cop
VAR_INT police_guard3 fire_1 fire_2 fire_3 fire_4 wanted_lvl_flag_r1 game_timer_r1 game_timer_start_r1
VAR_INT	car_moving_stuck_flag getaway_stuck_flag get_away_car_health game_timer_current_r1
VAR_INT mfail_timer mfail_timer_current mfail_timer_started	mfail_timer_reset_flag carlock_flag

VAR_FLOAT get_away_car_x get_away_car_y get_away_car_z

// ****************************************Mission Start************************************

mission_start_ray1:

flag_player_on_mission 		= 1
flag_player_on_ray_mission 	= 1
rays_cutscene_flag = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME ray1

wanted_lvl_flag_r1 	   = 0
game_timer_r1 		   = 0
game_timer_start_r1	   = 0
car_moving_stuck_flag  = 0
getaway_stuck_flag 	   = 0
get_away_car_health    = 1000
game_timer_current_r1  = 0
get_away_car_x 		   = 0.0
get_away_car_y 		   = 0.0
get_away_car_z		   = 0.0
mfail_timer 		   = 0
mfail_timer_current    = 0
mfail_timer_started	   = 0
mfail_timer_reset_flag = 0
carlock_flag		   = 0
{
// ****************************************START OF CUTSCENE********************************

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_ray1_failed
ENDIF

SWITCH_STREAMING OFF

PRINT_BIG RM1 15000 2 //"Silence the sneak"
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
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED toilet
	WAIT 0
ENDWHILE

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0

LOAD_CUTSCENE r1_sw

SET_CUTSCENE_OFFSET 39.424 -726.677 21.692

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_ray
SET_CUTSCENE_ANIM cs_ray ray

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray

DO_FADE 1500 FADE_IN
SET_NEAR_CLIP 0.2

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2070
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM1_A 8000 1 //"That scum bag McAffrey he took more bribes than anyone, and now he's gone too far."

WHILE cs_time < 6097
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM1_B 8000 1 //"Reckons he'll get an honorable discharge if he turns states evidence."

WHILE cs_time < 9509
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM1_C 8000 1 //"He just squealed."

WHILE cs_time < 11019
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM1_D	8000 1 //"He's under armed protection in a WitSec property down Newport some apartment behind the car park."

WHILE cs_time < 16109
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM1_E	8000 1 //"Torch the place and that should flush 'em out, then make sure he never talks to no one."

WHILE cs_time < 21333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

GIVE_WEAPON_TO_PLAYER player WEAPONTYPE_GRENADE 12

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT
SET_NEAR_CLIP 0.9

SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED toilet
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2

REQUEST_MODEL PED_LI_MAN2
REQUEST_MODEL CAR_SENTINEL

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED PED_LI_MAN2
OR NOT HAS_MODEL_LOADED	CAR_SENTINEL
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON
DO_FADE 1500 FADE_IN 

rays_cutscene_flag = 0

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

REQUEST_MODEL safehouse

ADD_BLIP_FOR_COORD 378.0 -443.2 29.9 ray1_blip

PRINT_NOW RM1_1 5000 1 //"Check out the witness protection house."

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_2D player 330.35 -471.43 375.982 -431.119 0
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SET_FIXED_CAMERA_POSITION 373.29 -444.714 28.537 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 374.1447 -444.2669 28.8032 INTERPOLATION

WAIT 3000

SET_PLAYER_CONTROL player ON
SWITCH_WIDESCREEN OFF
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
RESTORE_CAMERA

LOAD_MISSION_AUDIO R1_A

get_away_car  = 0
police_guard1 = 0
police_guard2 = 0

WHILE NOT IS_PROJECTILE_IN_AREA 376.5 -445.2 28.1 380.1 -441.2 31.7 // THE WINDOW
	
	WAIT 0

	GET_AMMO_IN_PLAYER_WEAPON player WEAPONTYPE_GRENADE get_away_car
	GET_AMMO_IN_PLAYER_WEAPON player WEAPONTYPE_ROCKET police_guard1
	get_away_car +=	police_guard1

	IF police_guard2 = 0
		IF get_away_car = 0
			PRINT_NOW RM1_4 5000 1//"You have run out of grenades! Get some more from ammunation"
			REMOVE_BLIP	ray1_blip
			ADD_SPRITE_BLIP_FOR_COORD 345.5 -713.5 26.1 RADAR_SPRITE_WEAPON ray1_blip
			police_guard2 = 1
		ENDIF
	ENDIF

	IF police_guard2 = 1
		IF get_away_car > 0
			PRINT_NOW RM1_5 5000 1//"Get back to the safehouse and torch it"
			REMOVE_BLIP	ray1_blip
			ADD_BLIP_FOR_COORD 378.0 -443.2 29.9 ray1_blip
			police_guard2 = 0
		ENDIF
	ENDIF

ENDWHILE

DESTROY_PROJECTILES_IN_AREA 376.1 -445.2 28.1 380.1 -441.2 31.7

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SET_FIXED_CAMERA_POSITION 373.29 -444.714 28.537 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 374.1447 -444.2669 28.8032 INTERPOLATION

WAIT 100

ADD_EXPLOSION 378.0 -443.5 28.9 EXPLOSION_GRENADE

WAIT 500

START_SCRIPT_FIRE 377.0 -444.0 28.1 fire_1
START_SCRIPT_FIRE 377.0 -443.0 28.1 fire_2
START_SCRIPT_FIRE 379.0 -444.0 28.1 fire_3
START_SCRIPT_FIRE 379.0 -443.0 28.1 fire_4
SET_SCRIPT_FIRE_AUDIO fire_1 TRUE
SET_SCRIPT_FIRE_AUDIO fire_2 FALSE
SET_SCRIPT_FIRE_AUDIO fire_3 FALSE
SET_SCRIPT_FIRE_AUDIO fire_4 FALSE

WAIT 250

CREATE_CHAR PEDTYPE_CIVMALE	PED_COP 378.0584 -444.7376 28.3 burning_cop

WAIT 250

ADD_PARTICLE_EFFECT POBJECT_DARK_SMOKE 377.0 -441.6 28.9 0
ADD_PARTICLE_EFFECT POBJECT_DARK_SMOKE 378.0 -443.3 28.9 0

WAIT 800

ADD_PARTICLE_EFFECT POBJECT_DARK_SMOKE 376.0 -443.35 30.0 0

WAIT 500

ADD_PARTICLE_EFFECT POBJECT_DARK_SMOKE 376.0 -442.7  30.0 0
ADD_PARTICLE_EFFECT POBJECT_DARK_SMOKE 376.0 -443.8  30.0 0

WAIT 1500

SET_PLAYER_CONTROL player ON
SWITCH_WIDESCREEN OFF
SET_EVERYONE_IGNORE_PLAYER player FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

//get_away_car  = 0
//police_guard1 = 0
//police_guard2 = 0

CREATE_CAR CAR_SENTINEL 380.0 -437.5 21.1 get_away_car // IN GARAGE
SET_CAR_HEADING get_away_car 90.0
LOCK_CAR_DOORS get_away_car CARLOCK_LOCKOUT_PLAYER_ONLY
SET_CAR_STRONG get_away_car TRUE

CREATE_CHAR_INSIDE_CAR get_away_car PEDTYPE_CIVMALE PED_COP police_guard1
CREATE_CHAR_AS_PASSENGER get_away_car PEDTYPE_CIVMALE PED_LI_MAN2 1 the_witness

CREATE_CHAR PEDTYPE_CIVMALE PED_COP 376.5428 -435.1743 20.0837 police_guard2
GIVE_WEAPON_TO_CHAR police_guard2 WEAPONTYPE_CHAINGUN 5000
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	police_guard2 374.0 -435.1743

CREATE_CHAR PEDTYPE_CIVMALE PED_COP 376.5428 -439.7169 20.0837 police_guard3
GIVE_WEAPON_TO_CHAR police_guard3 WEAPONTYPE_CHAINGUN 5000
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	police_guard3 374.0 -439.7169

DEACTIVATE_GARAGE witsec_garage
ACTIVATE_GARAGE witsec_garage

REMOVE_BLIP ray1_blip

SET_CAR_CRUISE_SPEED get_away_car 20.0
SET_CAR_DRIVING_STYLE get_away_car 2
CAR_WANDER_RANDOMLY	get_away_car
SET_CAR_AVOID_LEVEL_TRANSITIONS get_away_car TRUE

PRINT_NOW RM1_2 5000 1 //"Take out the witness!"

GET_GAME_TIMER game_timer_start_r1

WHILE IS_CHAR_STILL_ALIVE the_witness

	IF NOT IS_CHAR_DEAD police_guard2
		IF NOT IS_CHAR_IN_AREA_2D police_guard2 375.0 -441.5 386.0 -434.0	0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard2 player
		ENDIF
	ENDIF
			
	IF NOT IS_CHAR_DEAD police_guard3
		IF NOT IS_CHAR_IN_AREA_2D police_guard3 375.0 -441.5 386.0 -434.0	0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard3 player
		ENDIF
	ENDIF
			
	IF wanted_lvl_flag_r1 = 0
		GET_GAME_TIMER game_timer_current_r1
		game_timer_r1 = game_timer_current_r1 - game_timer_start_r1
		IF game_timer_r1 > 3000
			ALTER_WANTED_LEVEL_NO_DROP player 2
			ADD_BLIP_FOR_CHAR the_witness ray1_blip
			IF HAS_MISSION_AUDIO_LOADED
				PLAY_MISSION_AUDIO
			ENDIF
			wanted_lvl_flag_r1 = 1
		ENDIF
	ENDIF

	IF wanted_lvl_flag_r1 = 1
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player the_witness 160.0 160.0 0
		AND NOT IS_CHAR_ON_SCREEN the_witness
			IF mfail_timer_reset_flag = 0
				REMOVE_BLIP	ray1_blip
				GET_GAME_TIMER mfail_timer_started
				mfail_timer_reset_flag = 1
			ENDIF

			IF mfail_timer_reset_flag = 1
				GET_GAME_TIMER mfail_timer_current
				mfail_timer = mfail_timer_current - mfail_timer_started
				IF mfail_timer > 4000
					IF NOT IS_CHAR_ON_SCREEN the_witness
						mfail_timer_reset_flag = 0
						DELETE_CHAR the_witness
						PRINT_NOW RM1_3 5000 1 //"McAffrey got away!"
						GOTO mission_ray1_failed
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF mfail_timer_reset_flag = 1
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player the_witness 160.0 160.0 0
			OR IS_CHAR_ON_SCREEN the_witness
				REMOVE_BLIP	ray1_blip
				ADD_BLIP_FOR_CHAR the_witness ray1_blip
				mfail_timer_reset_flag = 0
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_IN_ANY_CAR the_witness
		SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	the_witness player
	ENDIF

	IF NOT IS_CAR_DEAD get_away_car
		
		IF IS_CHAR_IN_CAR the_witness get_away_car

			IF carlock_flag = 0
				IF NOT LOCATE_CAR_2D get_away_car 380.0 -437.5 40.0 40.0 0
					LOCK_CAR_DOORS get_away_car CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED get_away_car 40.0
					SET_CAR_STRONG get_away_car FALSE
					IF IS_CAR_HEALTH_GREATER get_away_car 800
						SET_CAR_HEALTH get_away_car 800
					ENDIF
					carlock_flag = 1
				ENDIF
			ENDIF
		
			IF IS_CAR_UPSIDEDOWN get_away_car
			AND IS_CAR_STOPPED get_away_car
				SET_CHAR_OBJ_LEAVE_CAR the_witness get_away_car
				IF NOT IS_CHAR_DEAD police_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard1 player
					GIVE_WEAPON_TO_CHAR police_guard1 WEAPONTYPE_CHAINGUN 5000
				ENDIF
			ENDIF

			IF IS_PLAYER_IN_CAR player get_away_car
				SET_CHAR_OBJ_LEAVE_CAR the_witness get_away_car
				IF NOT IS_CHAR_DEAD police_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard1 player
					GIVE_WEAPON_TO_CHAR police_guard1 WEAPONTYPE_CHAINGUN 5000
				ENDIF
			ENDIF

			GET_CAR_HEALTH get_away_car get_away_car_health
			IF get_away_car_health < 200
				SET_CHAR_OBJ_LEAVE_CAR the_witness get_away_car
				IF NOT IS_CHAR_DEAD police_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard1 player
					GIVE_WEAPON_TO_CHAR police_guard1 WEAPONTYPE_CHAINGUN 5000
				ENDIF
			ENDIF

			IF IS_CAR_STOPPED get_away_car
				IF getaway_stuck_flag = 0
					TIMERA = 0
					getaway_stuck_flag = 1
				ENDIF

				IF getaway_stuck_flag = 1
					IF TIMERA > 5000
						SET_CHAR_OBJ_LEAVE_CAR the_witness get_away_car
						IF NOT IS_CHAR_DEAD police_guard1
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard1 player
							GIVE_WEAPON_TO_CHAR police_guard1 WEAPONTYPE_CHAINGUN 5000
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CAR_STOPPED get_away_car
				getaway_stuck_flag = 0
			ENDIF

			IF LOCATE_CAR_2D get_away_car get_away_car_x get_away_car_y 3.0 3.0 0
				IF car_moving_stuck_flag = 0
					TIMERB = 0
					car_moving_stuck_flag = 1
				ENDIF

				IF car_moving_stuck_flag = 1
					IF TIMERB > 8000
						SET_CHAR_OBJ_LEAVE_CAR the_witness get_away_car
						IF NOT IS_CHAR_DEAD police_guard1
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT police_guard1 player
							GIVE_WEAPON_TO_CHAR police_guard1 WEAPONTYPE_CHAINGUN 5000
						ENDIF
					ENDIF
				ENDIF			
			ELSE
				GET_CAR_COORDINATES get_away_car get_away_car_x get_away_car_y get_away_car_z
				car_moving_stuck_flag = 0
			ENDIF
		ENDIF
	ENDIF

	WAIT 0
														 
ENDWHILE

GOTO mission_ray1_passed
}	   		
	
// Mission Ray 1 failed

mission_ray1_failed:
PRINT_BIG M_FAIL 5000 1
RETURN

   

// mission Ray 1 passed

mission_ray1_passed:

flag_ray_mission1_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 30000 5000 1
ADD_SCORE player 30000
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED	RM1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT ray_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_ray1:

REMOVE_BLIP ray1_blip

REMOVE_PARTICLE_EFFECTS_IN_AREA 372.0 -449.0 25.0 383.0 -436.0 33.0

MARK_MODEL_AS_NO_LONGER_NEEDED PED_LI_MAN2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED safehouse

flag_player_on_mission = 0
flag_player_on_ray_mission = 0
REMOVE_ALL_SCRIPT_FIRES
MISSION_HAS_FINISHED
RETURN
		



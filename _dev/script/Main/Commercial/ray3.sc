MISSION_START
// *****************************************************************************************
// ************************************ Ray mission 3 **************************************
// ************************************ Evidence Dash **************************************
// *****************************************************************************************
// *** The Internal Affairs are aware of Ray's activities, but are unable to get any 	 ***
// *** evidence until now. They have just raided one of Ray's old haunts and are leaving ***
// *** with the evidence. The player must chase them down and ram them with his car, when*** 
// *** their vehicle is rammed one of the packages will roll off the back. The player 	 ***
// *** must grab that first and then go get the next package off them. There will be 8 to*** 
// *** retrieve. Once the player has the stash he must get it back to his hideout.		 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray3

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray3_failed
ENDIF

GOSUB mission_cleanup_ray3

MISSION_END
 
// Variables for mission

VAR_INT	rays_evidence_blip timera_reset_flag evidence_1	evidence_2 evidence_3 evidence_4 evidence_5 evidence_6 //evidence_7 evidence_8 evidence_9
VAR_INT	ia_car_rm3 ia_car_driver_1 wanted_level_change stored_wanted_level
VAR_INT	ia_have_evidence_flag	players_car	prosecution_car_blip timer_for_speed reset_for_timer
VAR_INT temporary_health_var ia_car_previous_health ia_car_current_health
VAR_INT red green red_increase_flag red_decrease_flag green_increase_flag green_decrease_flag
VAR_INT amount_of_evidence_player_has amount_damage_ia_drop_evidence drop_one_flag drop_evidence get_coords_flag
VAR_INT timerc_reset_flag_r3 timerc_current_r3 timerc_started_r3 timerc_r3
VAR_INT timerd_reset_flag_r3 timerd_current_r3 timerd_started_r3 timerd_r3

VAR_FLOAT ia_start_x ia_start_y ia_start_z ia_car_x ia_car_y ia_car_z warp_heading
VAR_FLOAT object_current_coords_x object_current_coords_y object_current_coords_z car_stuck_x car_stuck_y car_stuck_z

// ****************************************Mission Start************************************

mission_start_ray3:

flag_player_on_mission = 1
flag_player_on_ray_mission = 1
rays_cutscene_flag = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME ray3

ia_start_x = -53.0
ia_start_y = -1380.5
ia_start_z = 26.0

amount_damage_ia_drop_evidence = 1

wanted_level_change = 1

drop_one_flag = 0
drop_evidence = 0

green = 250
red = 0
red_increase_flag = 0
red_decrease_flag = 0
green_increase_flag = 0
green_decrease_flag	= 0

timera_reset_flag = 0
ia_have_evidence_flag = 0
temporary_health_var  = 0
ia_car_previous_health = 0
ia_car_current_health = 0
amount_of_evidence_player_has = 0
get_coords_flag = 0
timerc_reset_flag_r3 = 0
timerd_reset_flag_r3 = 0
timerd_current_r3 = 0
timerd_started_r3 = 0
timerd_r3 = 0

timer_for_speed = 0
reset_for_timer = 0

object_current_coords_x = 0.0
object_current_coords_y = 0.0
object_current_coords_z	= 0.0

LOAD_SPECIAL_CHARACTER 1 ray			   
{
// ****************************************START OF CUTSCENE********************************

/*
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

IF CAN_PLAYER_START_MISSION player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player
ELSE
	GOTO mission_ray3_failed
ENDIF

SWITCH_STREAMING OFF

PRINT_BIG RM3 15000 2 //"Evidence Dash"
*/

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

LOAD_CUTSCENE r3_ed

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
// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 10381
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_A 10000 1 //"I know a real important man in town, a soft touch

WHILE cs_time < 13529
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_H 10000 1 //"with shall we say, exotic tastes and the money to indulge them.

WHILE cs_time < 17950
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_B 10000 1 //"He's involved in a legal matter and the prosecution has some rather embarrassing photos of him..."

WHILE cs_time < 23502
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_C 10000 1 //"...at a morgue party or something."

WHILE cs_time < 26180
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_D 10000 1 //"The evidence is being driven across town."

WHILE cs_time < 29179
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_E 10000 1 //"You are going to have to ram the car and collect each bit of evidence as it falls out."

WHILE cs_time < 34865
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_F	10000 1 //"When you've got it all, leave it in the car and torch it."  

WHILE cs_time < 39290
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM3_G	10000 1 //"We're both gonna do well out of this."

WHILE cs_time < 41666 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

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
SET_NEAR_CLIP 0.9

SET_PLAYER_HEADING player 90.0
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED toilet
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2

REQUEST_MODEL files
REQUEST_MODEL CAR_BOBCAT
REQUEST_MODEL PED_B_MAN3

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_BOBCAT
OR NOT HAS_MODEL_LOADED PED_B_MAN3
OR NOT HAS_MODEL_LOADED files
	WAIT 0
ENDWHILE

DO_FADE 1500 FADE_IN 

SWITCH_STREAMING ON

rays_cutscene_flag = 0

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

CREATE_CAR CAR_BOBCAT ia_start_x ia_start_y ia_start_z ia_car_rm3
SET_CAR_AVOID_LEVEL_TRANSITIONS ia_car_rm3 TRUE
SET_CAR_WATERTIGHT ia_car_rm3 TRUE
CREATE_CHAR_INSIDE_CAR ia_car_rm3 PEDTYPE_CIVMALE PED_B_MAN3 ia_car_driver_1
//SET_CHAR_AVOID_LEVEL_TRANSITIONS ia_car_driver_1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT ia_car_driver_1 TRUE
SET_CAR_ONLY_DAMAGED_BY_PLAYER ia_car_rm3 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED ia_car_rm3 TRUE
SET_CAR_PROOFS ia_car_rm3 TRUE TRUE 	TRUE 	FALSE 	TRUE 
SET_CAR_CRUISE_SPEED ia_car_rm3 20.0
SET_CAR_DRIVING_STYLE ia_car_rm3 2
CAR_WANDER_RANDOMLY ia_car_rm3
ADD_BLIP_FOR_CAR ia_car_rm3 prosecution_car_blip
LOCK_CAR_DOORS ia_car_rm3 CARLOCK_LOCKED

IF flag_player_on_mission = 0
	ADD_BLIP_FOR_CHAR ia_car_driver_1 rays_evidence_blip
ENDIF

GET_CAR_COORDINATES ia_car_rm3 car_stuck_x car_stuck_y car_stuck_z
GET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
ia_car_z += 3.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_1
ia_car_z += 1.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_2
ia_car_z += 1.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_3
ia_car_z += 1.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_4
ia_car_z += 1.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_5
ia_car_z += 1.0
CREATE_OBJECT files ia_car_x ia_car_y ia_car_z evidence_6

SET_OBJECT_COLLISION evidence_1 FALSE
SET_OBJECT_COLLISION evidence_2 FALSE
SET_OBJECT_COLLISION evidence_3 FALSE
SET_OBJECT_COLLISION evidence_4 FALSE
SET_OBJECT_COLLISION evidence_5 FALSE
SET_OBJECT_COLLISION evidence_6 FALSE

PLACE_OBJECT_RELATIVE_TO_CAR evidence_1 ia_car_rm3  0.3 -1.7 -0.1
PLACE_OBJECT_RELATIVE_TO_CAR evidence_2 ia_car_rm3  0.3 -1.2 -0.1
PLACE_OBJECT_RELATIVE_TO_CAR evidence_3 ia_car_rm3 -0.3 -1.2 -0.1
PLACE_OBJECT_RELATIVE_TO_CAR evidence_4 ia_car_rm3  0.3 -0.7 -0.1
PLACE_OBJECT_RELATIVE_TO_CAR evidence_5 ia_car_rm3 -0.3 -0.7 -0.1
PLACE_OBJECT_RELATIVE_TO_CAR evidence_6 ia_car_rm3 -0.3 -1.7 -0.1

//SWITCH_ROADS_OFF -90.0 -791.0 24.0 -56.0 -587.0 36.0
//SWITCH_ROADS_OFF 320.0 -948.0 30.0 350.0 -913.0 40.0
//SWITCH_ROADS_OFF 251.0 -46.0 -21.0 320.0 68.0 27.0

ia_have_evidence_flag = 1

evidence_loop:///////////////////////////////////////////////////////////////////////////////////////////////////////

WAIT 0

IF IS_CAR_DEAD ia_car_rm3
	IF IS_CAR_IN_WATER ia_car_rm3
		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player ia_car_rm3 50.0 50.0 0
			IF NOT IS_CAR_ON_SCREEN ia_car_rm3
				GET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
				GET_CLOSEST_CAR_NODE_WITH_HEADING ia_car_x ia_car_y ia_car_z ia_car_x ia_car_y ia_car_z warp_heading
				IF NOT IS_POINT_ON_SCREEN ia_car_x ia_car_y ia_car_z 3.0
					SET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
					SET_CAR_HEADING	ia_car_rm3 warp_heading
				ENDIF
			ENDIF
		ELSE
			PRINT_NOW RM3_6 5000 1 //"The evidence will be washed up all over Liberty!"
			GOTO mission_ray3_failed
		ENDIF
	ELSE
		GOTO mission_ray3_passed
	ENDIF
ENDIF

IF IS_CAR_UPSIDEDOWN ia_car_rm3
AND IS_CAR_STOPPED ia_car_rm3

	IF NOT IS_CAR_ON_SCREEN ia_car_rm3
		GET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
		GET_CLOSEST_CAR_NODE_WITH_HEADING ia_car_x ia_car_y ia_car_z ia_car_x ia_car_y ia_car_z warp_heading
		IF NOT IS_POINT_ON_SCREEN ia_car_x ia_car_y ia_car_z 3.0
			SET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
			SET_CAR_HEADING	ia_car_rm3 warp_heading
		ENDIF
	ELSE
		IF NOT drop_evidence = 6
			GOSUB create_another_car
		ENDIF
	ENDIF
ENDIF

IF timera_reset_flag = 1
	IF NOT IS_CAR_STOPPED ia_car_rm3
		timera_reset_flag = 0
	ENDIF
ENDIF
		
IF IS_CAR_STOPPED ia_car_rm3
	IF timera_reset_flag = 0
		TIMERA = 0
		timera_reset_flag = 1
	ENDIF

	IF TIMERA > 5000
	AND timera_reset_flag = 1
		IF NOT IS_CAR_ON_SCREEN ia_car_rm3
			GET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
			GET_CLOSEST_CAR_NODE_WITH_HEADING ia_car_x ia_car_y ia_car_z ia_car_x ia_car_y ia_car_z warp_heading
			IF NOT IS_POINT_ON_SCREEN ia_car_x ia_car_y ia_car_z 4.0
				SET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
				SET_CAR_HEADING	ia_car_rm3 warp_heading
				timera_reset_flag = 0
			ENDIF
		ELSE
			IF NOT drop_evidence = 6
				GOSUB create_another_car
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF LOCATE_CAR_3D ia_car_rm3	car_stuck_x car_stuck_y car_stuck_z 4.0 4.0 4.0 0
	IF timerc_reset_flag_r3 = 0
		GET_GAME_TIMER timerc_started_r3
		timerc_reset_flag_r3 = 1
	ENDIF

	IF timerc_reset_flag_r3 = 1
		GET_GAME_TIMER timerc_current_r3
		timerc_r3 = timerc_current_r3 - timerc_started_r3
		IF timerc_r3 > 8000
			IF NOT IS_CAR_ON_SCREEN ia_car_rm3
				GET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
				GET_CLOSEST_CAR_NODE_WITH_HEADING ia_car_x ia_car_y ia_car_z ia_car_x ia_car_y ia_car_z warp_heading
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY ia_car_x ia_car_y ia_car_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN ia_car_x ia_car_y ia_car_z 4.0
						SET_CAR_COORDINATES ia_car_rm3 ia_car_x ia_car_y ia_car_z
						SET_CAR_HEADING	ia_car_rm3 warp_heading
						timerc_reset_flag_r3 = 0
					ENDIF
				ENDIF
			ELSE
				IF NOT drop_evidence = 6
					GOSUB create_another_car
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT LOCATE_CAR_3D ia_car_rm3	car_stuck_x car_stuck_y car_stuck_z 4.0 4.0 4.0 0
	GET_CAR_COORDINATES ia_car_rm3 car_stuck_x car_stuck_y car_stuck_z
	timerc_reset_flag_r3 = 0
ENDIF

GET_GAME_TIMER timer_for_speed
timer_for_speed -= reset_for_timer
IF timer_for_speed > 1000
	GET_GAME_TIMER reset_for_timer
	IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player ia_car_rm3 20.0 20.0 0
		SET_CAR_CRUISE_SPEED ia_car_rm3 50.0
	ELSE
		IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player ia_car_rm3 50.0 50.0 0
			SET_CAR_CRUISE_SPEED ia_car_rm3 41.0
		ELSE
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player ia_car_rm3 90.0 90.0 0
				SET_CAR_CRUISE_SPEED ia_car_rm3 34.0
			ELSE
				IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player ia_car_rm3 130.0 130.0 0
					SET_CAR_CRUISE_SPEED ia_car_rm3 28.0
				ELSE
					SET_CAR_CRUISE_SPEED ia_car_rm3 20.0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF ia_have_evidence_flag = 0
	
	IF TIMERB > 500
		IF LOCATE_PLAYER_ANY_MEANS_3D player object_current_coords_x object_current_coords_y object_current_coords_z 1.5 1.5 1.5 0
			GOSUB evidence_collected
		ENDIF
	ENDIF
	
	IF TIMERB > 10000
		IF LOCATE_PLAYER_ANY_MEANS_2D player object_current_coords_x object_current_coords_y 1.5 1.5 0
			GOSUB evidence_collected
		ENDIF
	ENDIF
	
	IF TIMERB > 120000
		IF LOCATE_PLAYER_ANY_MEANS_2D player object_current_coords_x object_current_coords_y 30.0 30.0 0
			GOSUB evidence_collected
		ENDIF
	ENDIF
ENDIF

ia_car_previous_health = ia_car_current_health
GET_CAR_HEALTH ia_car_rm3 ia_car_current_health		  
IF ia_have_evidence_flag = 1
	IF IS_CAR_UPRIGHT ia_car_rm3
		temporary_health_var = ia_car_previous_health - amount_damage_ia_drop_evidence
		IF temporary_health_var > ia_car_current_health
			PRINT_NOW ( RM3_4 ) 3000 1 //"IA HAVE DROPPED THE EVIDENCE"
			SET_CAR_HEALTH ia_car_rm3 1000
			ia_car_current_health = 1000
			ia_car_previous_health = 1000
			ia_have_evidence_flag = 0
			drop_one_flag = 0
			get_coords_flag = 1
		ENDIF
	ENDIF
ENDIF

IF ia_have_evidence_flag = 0
AND drop_one_flag = 0
	drop_evidence++
	REMOVE_BLIP rays_evidence_blip
	IF drop_evidence = 1
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_1 ia_car_rm3 0.3 -1.7 0.2
		ADD_BLIP_FOR_OBJECT evidence_1 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_1 TRUE
		SET_OBJECT_DYNAMIC evidence_1 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_1 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_1
		ALTER_WANTED_LEVEL_NO_DROP player 2
		SET_CAR_CRUISE_SPEED ia_car_rm3 100.0
		SET_CAR_DRIVING_STYLE ia_car_rm3 2
		// Play sound for police scanner here
		TIMERB = 0
	ENDIF
	IF drop_evidence = 2
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_2 ia_car_rm3 0.3 -1.2 0.2
		ADD_BLIP_FOR_OBJECT evidence_2 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_2 TRUE
		SET_OBJECT_DYNAMIC evidence_2 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_2 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_2
		TIMERB = 0
	ENDIF
	IF drop_evidence = 3
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_3 ia_car_rm3 -0.3 -1.2 0.2
		ADD_BLIP_FOR_OBJECT evidence_3 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_3 TRUE
		SET_OBJECT_DYNAMIC evidence_3 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_3 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_3
		TIMERB = 0
	ENDIF
	IF drop_evidence = 4
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_4 ia_car_rm3 0.3 -0.7 0.2
		ADD_BLIP_FOR_OBJECT evidence_4 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_4 TRUE
		SET_OBJECT_DYNAMIC evidence_4 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_4 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_4
		TIMERB = 0
	ENDIF
	IF drop_evidence = 5
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_5 ia_car_rm3 -0.3 -0.7 0.2
		ADD_BLIP_FOR_OBJECT evidence_5 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_5 TRUE
		SET_OBJECT_DYNAMIC evidence_5 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_5 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_5
		TIMERB = 0
	ENDIF
	IF drop_evidence = 6
		PLACE_OBJECT_RELATIVE_TO_CAR evidence_6 ia_car_rm3 -0.3 -1.7 0.2
		ADD_BLIP_FOR_OBJECT evidence_6 rays_evidence_blip
		SET_OBJECT_COLLISION evidence_6 TRUE
		SET_OBJECT_DYNAMIC evidence_6 TRUE
		ADD_TO_OBJECT_VELOCITY evidence_6 0.0 0.0 16.0
		MAKE_OBJECT_TARGETTABLE evidence_6
		REMOVE_BLIP	prosecution_car_blip
		TIMERB = 0
	ENDIF
	drop_one_flag = 1
ENDIF

IF get_coords_flag = 1
	IF drop_evidence = 1
		GET_OBJECT_COORDINATES evidence_1 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
	IF drop_evidence = 2
		GET_OBJECT_COORDINATES evidence_2 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
	IF drop_evidence = 3
		GET_OBJECT_COORDINATES evidence_3 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
	IF drop_evidence = 4
		GET_OBJECT_COORDINATES evidence_4 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
	IF drop_evidence = 5
		GET_OBJECT_COORDINATES evidence_5 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
	IF drop_evidence = 6
		GET_OBJECT_COORDINATES evidence_6 object_current_coords_x object_current_coords_y object_current_coords_z
	ENDIF
ENDIF

IF ia_have_evidence_flag = 0

	IF red = 0
		red_decrease_flag = 0	
		red_increase_flag = 1
	ENDIF
	
	IF red = 250
		red_decrease_flag = 1	
		red_increase_flag = 0
	ENDIF	
		
	IF red_increase_flag = 1
		red	= red + 10
	ENDIF

	IF red_decrease_flag = 1
		red = red - 10
	ENDIF

	IF green = 0
		green_decrease_flag = 0	
		green_increase_flag = 1
	ENDIF
	
	IF green = 250
		green_decrease_flag = 1	
		green_increase_flag = 0
	ENDIF	
		
	IF green_increase_flag = 1
		green = green + 10
	ENDIF

	IF green_decrease_flag = 1
		green = green - 10
	ENDIF
	
	DRAW_CORONA object_current_coords_x object_current_coords_y object_current_coords_z 0.5 CORONATYPE_CIRCLE FLARETYPE_NONE red green 0

ENDIF

IF drop_evidence < 1
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_1 ia_car_rm3 0.3 -1.7 -0.1
ENDIF

IF drop_evidence < 2
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_2 ia_car_rm3 0.3 -1.2 -0.1
ENDIF

IF drop_evidence < 3
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_3 ia_car_rm3 -0.3 -1.2 -0.1
ENDIF

IF drop_evidence < 4
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_4 ia_car_rm3 0.3 -0.7 -0.1
ENDIF

IF drop_evidence < 5
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_5 ia_car_rm3 -0.3 -0.7 -0.1
ENDIF
	
IF drop_evidence < 6
	PLACE_OBJECT_RELATIVE_TO_CAR evidence_6 ia_car_rm3 -0.3 -1.7 -0.1
ENDIF
	
IF amount_of_evidence_player_has = 6
	REMOVE_BLIP rays_evidence_blip
	
	PRINT_NOW RM3_1 5000 1
	
	WHILE NOT IS_PLAYER_IN_ANY_CAR player
		WAIT 0
	ENDWHILE
	
	STORE_CAR_PLAYER_IS_IN player players_car
	
	WHILE IS_PLAYER_IN_ANY_CAR player
		WAIT 0
	ENDWHILE
	
	IF NOT IS_CAR_DEAD players_car
		ADD_BLIP_FOR_CAR players_car rays_evidence_blip
		CLEAR_ONSCREEN_COUNTER amount_of_evidence_player_has
		PRINT_NOW RM3_7 5000 1	// "Now torch the car!"
		WHILE NOT IS_CAR_DEAD players_car
			WAIT 0
		ENDWHILE
		
		GOTO mission_ray3_passed
	ELSE
		GOTO mission_ray3_passed
	ENDIF
ENDIF

GOTO evidence_loop///////////////////////////////////////////////////////////////////////////////////////


// Mission Ray3 failed

mission_ray3_failed:
PRINT_BIG ( m_fail ) 5000 1
RETURN

   

// mission Ray3 passed

mission_ray3_passed:

flag_ray_mission3_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 10000 5000 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	RM3
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 86.1 -1548.7 28.3 RADAR_SPRITE_DON love_contact_blip
START_NEW_SCRIPT ray_mission4_loop
START_NEW_SCRIPT love_mission1_loop
RETURN
		


// mission cleanup

mission_cleanup_ray3:

//SWITCH_ROADS_ON -90.0 -791.0 24.0 -56.0 -587.0 36.0
//SWITCH_ROADS_ON 195.0 -948.0 24.0 280.0 -913.0 40.0
//SWITCH_ROADS_ON 251.0 -46.0 -21.0 320.0 68.0 27.0
REMOVE_BLIP	rays_evidence_blip
REMOVE_BLIP	prosecution_car_blip
CLEAR_ONSCREEN_COUNTER amount_of_evidence_player_has
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BOBCAT
MARK_MODEL_AS_NO_LONGER_NEEDED PED_B_MAN3
MARK_MODEL_AS_NO_LONGER_NEEDED DONKEYMAG
flag_player_on_mission = 0
flag_player_on_ray_mission = 0

MISSION_HAS_FINISHED
RETURN
		

create_another_car:
	
IF timerd_reset_flag_r3 = 0
	GET_GAME_TIMER timerd_started_r3
	timerd_reset_flag_r3 = 1
ENDIF

IF timerd_reset_flag_r3 = 1
	GET_GAME_TIMER timerd_current_r3
	timerd_r3 = timerd_current_r3 - timerd_started_r3
	IF timerd_r3 > 15000
		PRINT_NOW RM3_8 5000 1 //"That car is a decoy!!"
		REMOVE_BLIP	prosecution_car_blip
		MARK_CAR_AS_NO_LONGER_NEEDED ia_car_rm3
		MARK_CHAR_AS_NO_LONGER_NEEDED ia_car_driver_1
		IF LOCATE_PLAYER_ANY_MEANS_2D player ia_start_x ia_start_y 150.0 150.0 0
			CREATE_CAR CAR_BOBCAT 254.8355 -667.3972 25.3 ia_car_rm3
		ELSE
			CREATE_CAR CAR_BOBCAT ia_start_x ia_start_y ia_start_z ia_car_rm3
		ENDIF
		CREATE_CHAR_INSIDE_CAR ia_car_rm3 PEDTYPE_CIVMALE PED_B_MAN3 ia_car_driver_1
		SET_CAR_WATERTIGHT ia_car_rm3 TRUE
		SET_CHAR_CANT_BE_DRAGGED_OUT ia_car_driver_1 TRUE
		SET_CAR_ONLY_DAMAGED_BY_PLAYER ia_car_rm3 TRUE
		SET_UPSIDEDOWN_CAR_NOT_DAMAGED ia_car_rm3 TRUE
		SET_CAR_PROOFS ia_car_rm3 TRUE TRUE TRUE FALSE TRUE 
		SET_CAR_CRUISE_SPEED ia_car_rm3 100.0
		SET_CAR_DRIVING_STYLE ia_car_rm3 2
		CAR_WANDER_RANDOMLY ia_car_rm3
		ADD_BLIP_FOR_CAR ia_car_rm3 prosecution_car_blip
		LOCK_CAR_DOORS ia_car_rm3 CARLOCK_LOCKED
		SET_CAR_AVOID_LEVEL_TRANSITIONS ia_car_rm3 TRUE
		timerd_reset_flag_r3 = 0
	ENDIF
ENDIF

RETURN


evidence_collected:

REMOVE_BLIP rays_evidence_blip
get_coords_flag = 0
ADD_ONE_OFF_SOUND object_current_coords_x object_current_coords_y object_current_coords_z SOUND_EVIDENCE_PICKUP
IF drop_evidence = 1
	DELETE_OBJECT evidence_1
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING amount_of_evidence_player_has COUNTER_DISPLAY_NUMBER COLLECT
ENDIF
IF drop_evidence = 2
	DELETE_OBJECT evidence_2
ENDIF
IF drop_evidence = 3
	DELETE_OBJECT evidence_3
ENDIF
IF drop_evidence = 4
	DELETE_OBJECT evidence_4
ENDIF
IF drop_evidence = 5
	DELETE_OBJECT evidence_5
ENDIF
IF drop_evidence = 6
	DELETE_OBJECT evidence_6
ENDIF
++ amount_of_evidence_player_has
PRINT_WITH_NUMBER_NOW RM3_5 amount_of_evidence_player_has 5000 1 //"You have ~1~ evidence packages."
ia_have_evidence_flag = 1
TIMERB = 0

RETURN
}

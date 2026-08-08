MISSION_START

// Dirt Track trials (BF Injection & Bobcat)
GOSUB dirt_track_start
IF HAS_DEATHARREST_BEEN_EXECUTED
    GOSUB dirt_track_failed
ENDIF
GOSUB dirt_track_cleanup

MISSION_END

{
// Global state or onscreen counters, must be global variables
VAR_INT dirt_track_current_time_secs

LVAR_INT dirt_track_course_index dirt_track_car_model_id dirt_track_car dirt_track_curr_checkpoint_index dirt_track_next_checkpoint_index
LVAR_INT dirt_track_curr_checkpoint_blip dirt_track_next_checkpoint_blip dirt_track_current_lap dirt_track_lap_time dirt_track_lap_time_secs

VAR_INT dirt_track_total_time dirt_track_got_new_record

VAR_FLOAT dirt_track_car_x dirt_track_car_y dirt_track_car_z dirt_track_car_forward_x dirt_track_car_forward_y dirt_track_dot_x dirt_track_dot_y
VAR_FLOAT dirt_track_player_start_x dirt_track_player_start_y

VAR_FLOAT dirt_track_car_end_x dirt_track_car_end_y dirt_track_car_end_z dirt_track_car_end_heading

VAR_INT dirt_track_selected_course_in_menu dirt_track_target_time_secs dirt_track_course_pass_status

LVAR_INT dirt_track_temp_checkpoint_index dirt_track_num_checkpoints dirt_track_target_time
LVAR_FLOAT dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z

CONST_INT dirt_track_num_laps 3
CONST_INT dirt_track_num_bfinject_courses 1

CONST_FLOAT dirt_track_course_bounds_x1 746.6
CONST_FLOAT dirt_track_course_bounds_y1 1038.0

CONST_FLOAT dirt_track_course_bounds_x2 1187.7
CONST_FLOAT dirt_track_course_bounds_y2 594.8

dirt_track_start:
flag_player_on_mission = 1
flag_player_on_dirt_track_mission = 1

// TODO: Move
dirt_track_car_model_id = 114 // CAR_BFINJECT
dirt_track_car_end_x = 986.5441
dirt_track_car_end_y = 987.1586
dirt_track_car_end_z = 103.7962
dirt_track_car_end_heading = 78.0

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON
DO_FADE 1500 FADE_OUT
WHILE GET_FADING_STATUS
    WAIT 0
ENDWHILE

WARP_PLAYER_FROM_CAR_TO_COORD player 1049.3 871.5 93.6

dirt_track_course_select:
SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 1016.4 763.6 115.8 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 914.7 875.9 100.0 JUMP_CUT

CLEAR_PRINTS

DO_FADE 1500 FADE_IN
WHILE GET_FADING_STATUS
    WAIT 0
ENDWHILE

// TODO: Determine that proper
dirt_track_selected_course_in_menu = 1

WAIT 500

dirt_track_course_select_loop:
WAIT 0

PRINT_WITH_NUMBER_BIG TT_F1 dirt_track_selected_course_in_menu 1 4 // < COURSE ~1~ >

dirt_track_course_index = dirt_track_selected_course_in_menu - 1
GOSUB dirt_track_get_checkpoint_coords

dirt_track_target_time_secs = dirt_track_target_time / 1000
PRINT_WITH_NUMBER_NOW TT_L4 dirt_track_target_time_secs 1 1

IF IS_BUTTON_PRESSED PAD1 CROSS
    IF NOT dirt_track_course_pass_status = 0
        DO_FADE 1000 FADE_OUT
        WHILE GET_FADING_STATUS
            WAIT 0
        ENDWHILE

        GOTO dirt_track_race_start
    ENDIF
ENDIF

IF IS_BUTTON_PRESSED PAD1 TRIANGLE

    REQUEST_MODEL dirt_track_car_model_id

    DO_FADE 1000 FADE_OUT
    WHILE GET_FADING_STATUS
        WAIT 0
    ENDWHILE

    LOAD_ALL_MODELS_NOW

    CLEAR_AREA dirt_track_car_end_x dirt_track_car_end_y dirt_track_car_end_z 10.0 FALSE
    CREATE_CAR dirt_track_car_model_id dirt_track_car_end_x dirt_track_car_end_y dirt_track_car_end_z dirt_track_car
    SET_CAR_HEADING dirt_track_car dirt_track_car_end_heading

    GET_CAR_FORWARD_X dirt_track_car dirt_track_car_forward_x
    GET_CAR_FORWARD_X dirt_track_car dirt_track_car_forward_y

    dirt_track_car_forward_x *= 3.0
    dirt_track_car_forward_y *= 3.0

    dirt_track_car_forward_y += dirt_track_car_end_x
    dirt_track_car_forward_x += dirt_track_car_end_y

    WARP_PLAYER_FROM_CAR_TO_COORD player dirt_track_car_forward_x dirt_track_car_forward_y -100.0
    TURN_PLAYER_TO_FACE_COORD player dirt_track_car_end_x dirt_track_car_end_y dirt_track_car_end_z

    MARK_CAR_AS_NO_LONGER_NEEDED dirt_track_car
    MARK_MODEL_AS_NO_LONGER_NEEDED dirt_track_car_model_id
    RESTORE_CAMERA_JUMPCUT
    SWITCH_WIDESCREEN OFF

    DO_FADE 1000 FADE_IN
    WHILE GET_FADING_STATUS
        WAIT 0
    ENDWHILE

    RETURN

ENDIF

GOTO dirt_track_course_select_loop

dirt_track_race_start:

dirt_track_curr_checkpoint_blip = 0
dirt_track_next_checkpoint_blip = 0

dirt_track_temp_checkpoint_index = 0
GOSUB dirt_track_get_checkpoint_coords

IF IS_PLAYER_IN_ANY_CAR player
    STORE_CAR_PLAYER_IS_IN player dirt_track_car
    SET_CAR_COORDINATES dirt_track_car dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y -100.0
ELSE
    REQUEST_MODEL dirt_track_car_model_id

    dirt_track_player_start_x = dirt_track_temp_checkpoint_x + 1.5
    dirt_track_player_start_y = dirt_track_temp_checkpoint_y + 1.5
    SET_PLAYER_COORDINATES player dirt_track_player_start_x dirt_track_player_start_y -100.0

    WAIT 100
    LOAD_ALL_MODELS_NOW

    CREATE_CAR dirt_track_car_model_id dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y -100.0 dirt_track_car
    WARP_PLAYER_INTO_CAR player dirt_track_car

    MARK_MODEL_AS_NO_LONGER_NEEDED dirt_track_car_model_id
ENDIF

dirt_track_temp_checkpoint_index = 1
GOSUB dirt_track_get_checkpoint_coords

TURN_CAR_TO_FACE_COORD dirt_track_car dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y

dirt_track_current_lap = 1
dirt_track_curr_checkpoint_index = 1
dirt_track_next_checkpoint_index = 2

CLEAR_AREA dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 25.0 TRUE
CLEAR_AREA_OF_CARS dirt_track_course_bounds_x1 dirt_track_course_bounds_y1 0.0 dirt_track_course_bounds_x2 dirt_track_course_bounds_y2 150.0

SWITCH_WIDESCREEN ON
RESTORE_CAMERA_JUMPCUT

DO_FADE 1000 FADE_IN
WHILE GET_FADING_STATUS
    WAIT 0
ENDWHILE

PRINT_BIG ( YD1_3 ) 1100 4
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
WAIT 1000
PRINT_BIG ( YD1_2 ) 1100 4
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
WAIT 1000
PRINT_BIG ( YD1_1 ) 1100 4
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
WAIT 1000
PRINT_BIG ( YD1GO ) 800 4
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO

SWITCH_WIDESCREEN OFF

SET_PLAYER_CONTROL player ON

TIMERA = 0 // Lap time
TIMERB = 0 // Total time

DISPLAY_ONSCREEN_COUNTER_WITH_STRING dirt_track_current_time_secs COUNTER_DISPLAY_NUMBER DIAB1_5

dirt_track_course_loop:
WAIT 0

dirt_track_current_time_secs = TIMERB / 1000

IF IS_CAR_DEAD dirt_track_car
    PRINT_NOW (WRECKED) 3000 1
    // Freeze the player so they don't die during the timeout
    SET_PLAYER_CONTROL player OFF
    GOTO dirt_track_disqualified
ENDIF

IF IS_CAR_UPSIDEDOWN dirt_track_car
AND IS_CAR_STOPPED dirt_track_car
    PRINT_NOW ( UPSIDE ) 3000 1 //You've flipped your wheels!"
    // Freeze the player so they don't die during the timeout
    SET_PLAYER_CONTROL player OFF
    GOTO dirt_track_disqualified
ENDIF

IF NOT IS_PLAYER_IN_CAR player dirt_track_car
    PRINT_NOW (T4x4_F) 3000 1
    GOTO dirt_track_disqualified
ENDIF

IF NOT IS_PLAYER_IN_AREA_2D player dirt_track_course_bounds_x1 dirt_track_course_bounds_y1 dirt_track_course_bounds_x2 dirt_track_course_bounds_y2 FALSE
    PRINT_NOW ( TT_F2 ) 3000 1 // You left the course!
    SET_PLAYER_CONTROL player OFF
    GOTO dirt_track_disqualified
ENDIF

IFNOT dirt_track_current_lap = dirt_track_num_laps
AND dirt_track_curr_checkpoint_index = 0
    IF dirt_track_next_checkpoint_blip = 0
        dirt_track_temp_checkpoint_index = dirt_track_next_checkpoint_index
        GOSUB dirt_track_get_checkpoint_coords

        ADD_BLIP_FOR_COORD dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z dirt_track_next_checkpoint_blip
        DIM_BLIP dirt_track_next_checkpoint_blip ON
	    CHANGE_BLIP_SCALE dirt_track_next_checkpoint_blip 2
    ENDIF
ENDIF

dirt_track_temp_checkpoint_index = dirt_track_curr_checkpoint_index
GOSUB dirt_track_get_checkpoint_coords

IF dirt_track_current_lap = dirt_track_num_laps
AND dirt_track_curr_checkpoint_index = 0
    DRAW_CORONA dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 100 0 0
ELSE
    DRAW_CORONA dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 100
ENDIF

if dirt_track_curr_checkpoint_blip = 0
    ADD_BLIP_FOR_COORD dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z dirt_track_curr_checkpoint_blip
ENDIF

IF LOCATE_PLAYER_IN_CAR_3D player dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 6.0 6.0 6.0 FALSE

    ADD_ONE_OFF_SOUND dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z SOUND_PART_MISSION_COMPLETE

    IF dirt_track_curr_checkpoint_index = 0
        dirt_track_current_lap++

        dirt_track_lap_time = TIMERA
        dirt_track_lap_time_secs = dirt_track_lap_time / 1000
        TIMERA = 0

        IF GOSUB dirt_track_try_update_lap_record
            PRINT_WITH_2_NUMBERS_NOW TT_D2 dirt_track_current_lap dirt_track_lap_time_secs 2000 1 // Lap ~1~ of 3. Lap time: ~1~ seconds. New lap record!
        ELSE
            PRINT_WITH_2_NUMBERS_NOW TT_D1 dirt_track_current_lap dirt_track_lap_time_secs 2000 1 // Lap ~1~ of 3. Lap time: ~1~ seconds.
        ENDIF

        IF dirt_track_current_lap > dirt_track_num_laps
            dirt_track_total_time = TIMERB
            GOTO dirt_track_course_finished
        ENDIF
    ENDIF

    dirt_track_curr_checkpoint_index++
    IF dirt_track_curr_checkpoint_index >= dirt_track_num_checkpoints
        dirt_track_curr_checkpoint_index = 0
    ENDIF

    dirt_track_next_checkpoint_index++
    IF dirt_track_next_checkpoint_index >= dirt_track_num_checkpoints
        dirt_track_next_checkpoint_index = 0
    ENDIF

    GOSUB dirt_track_remove_blips
ENDIF

GOTO dirt_track_course_loop

dirt_track_course_finished:
CLEAR_ONSCREEN_COUNTER dirt_track_current_time_secs
GOSUB dirt_track_remove_blips

SET_PLAYER_CONTROL player OFF

SWITCH_WIDESCREEN ON

IF NOT IS_CAR_DEAD dirt_track_car
    GET_CAR_COORDINATES dirt_track_car dirt_track_car_x dirt_track_car_y dirt_track_car_z
    GET_CAR_FORWARD_X dirt_track_car dirt_track_car_forward_x
    GET_CAR_FORWARD_Y dirt_track_car dirt_track_car_forward_y

    // X axis
    dirt_track_dot_x = 8.0 * dirt_track_car_forward_y
    dirt_track_dot_y = 8.0 * dirt_track_car_forward_x

    // Y axis
    dirt_track_car_forward_x *= -20.0
    dirt_track_car_forward_y *= -20.0

    dirt_track_dot_x -= dirt_track_car_forward_x
    dirt_track_dot_y -= dirt_track_car_forward_y

    dirt_track_car_x += dirt_track_dot_x
    dirt_track_car_y += dirt_track_dot_y
    dirt_track_car_z += 1.5

    SET_FIXED_CAMERA_POSITION dirt_track_car_x dirt_track_car_y dirt_track_car_z 0.0 0.0 0.0
    POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
ENDIF

GOSUB dirt_track_try_pass_course

dirt_track_current_time_secs = dirt_track_total_time / 1000
IF dirt_track_got_new_record = 1
    PRINT_WITH_NUMBER_BIG TT_D7 dirt_track_current_time_secs 7000 4
ELSE
    PRINT_WITH_NUMBER_BIG TT_D8 dirt_track_current_time_secs 7000 4
ENDIF

dirt_track_return_to_course_select:
WAIT 5000
CLEAR_PRINTS

DO_FADE 1000 FADE_OUT
WHILE GET_FADING_STATUS
    WAIT 0
ENDWHILE

GOSUB dirt_track_delete_car

GOTO dirt_track_course_select

dirt_track_failed:
PRINT_BIG M_FAIL 5000 1

CLEAR_ONSCREEN_COUNTER dirt_track_current_time_secs
MARK_CAR_AS_NO_LONGER_NEEDED dirt_track_car

RETURN

dirt_track_disqualified:
PRINT_BIG M_FAIL 5000 1

CLEAR_ONSCREEN_COUNTER dirt_track_current_time_secs
GOSUB dirt_track_remove_blips

GOTO dirt_track_return_to_course_select

dirt_track_cleanup:

GOSUB dirt_track_remove_blips

flag_player_on_dirt_track_mission = 0
flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN

dirt_track_get_checkpoint_coords:
// IF...GOTO exists but isn't supported in gta3sc
IS_THING_EQUAL_TO_THING dirt_track_course_variation 0
GOTO_IF_TRUE dirt_track_bfinject_courses

RETURN

dirt_track_bfinject_courses:
IS_THING_EQUAL_TO_THING dirt_track_course_index 0
GOTO_IF_TRUE dirt_track_bfinject_course_0
RETURN

dirt_track_bfinject_course_0:
dirt_track_num_checkpoints = 7
dirt_track_target_time = 75000
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_0_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 913.8
        dirt_track_temp_checkpoint_y = 875.6
        dirt_track_temp_checkpoint_z = 94.9
        BREAK
    CASE 1
        //dirt_track_temp_checkpoint_x = 871.4
        //dirt_track_temp_checkpoint_y = 857.3
        //dirt_track_temp_checkpoint_z = 81.6
        dirt_track_temp_checkpoint_x = 870.7
        dirt_track_temp_checkpoint_y = 851.0
        dirt_track_temp_checkpoint_z = 80.6
        BREAK
    CASE 2
        dirt_track_temp_checkpoint_x = 892.8
        dirt_track_temp_checkpoint_y = 842.2
        dirt_track_temp_checkpoint_z = 78.2
        BREAK
    CASE 3
        dirt_track_temp_checkpoint_x = 916.8
        dirt_track_temp_checkpoint_y = 784.6
        dirt_track_temp_checkpoint_z = 76.4
        BREAK
    CASE 4
        dirt_track_temp_checkpoint_x = 959.9
        dirt_track_temp_checkpoint_y = 742.1
        dirt_track_temp_checkpoint_z = 63.8
        BREAK
    CASE 5
        dirt_track_temp_checkpoint_x = 921.0
        dirt_track_temp_checkpoint_y = 756.5
        dirt_track_temp_checkpoint_z = 63.7
        BREAK
    CASE 6
        dirt_track_temp_checkpoint_x = 916.5
        dirt_track_temp_checkpoint_y = 821.2
        dirt_track_temp_checkpoint_z = 77.0
        BREAK
ENDSWITCH
RETURN

dirt_track_try_pass_course:
dirt_track_got_new_record = 0
// IF...GOTO exists but isn't supported in gta3sc
IS_THING_EQUAL_TO_THING dirt_track_course_variation 0
GOTO_IF_TRUE dirt_track_try_pass_bfinject_course


PRINT_NOW TT_E2 7000 1 // ~r~You failed to beat the target time.
RETURN

dirt_track_try_pass_bfinject_course:
SWITCH dirt_track_course_index
    CASE 0
        IF flag_dirt_track_bfinject_course_0_status = 1
            IF dirt_track_total_time < dirt_track_target_time
                ADD_SCORE player 1000
                PLAYER_MADE_PROGRESS 1
                flag_dirt_track_bfinject_course_0_status = 2
                dirt_track_bfinject_course_1_best_time = dirt_track_total_time

                // TODO: Unlock the next course
            ELSE
                GOTO dirt_track_display_target_time_failed
            ENDIF
        ELSE
            IF dirt_track_total_time < dirt_track_bfinject_course_1_best_time
                dirt_track_bfinject_course_1_best_time = dirt_track_total_time
                GOTO dirt_track_display_new_record
            ENDIF
            GOTO dirt_track_display_record_failed
        ENDIF
        BREAK
ENDSWITCH

PRINT_NOW TT_E10 7000 1 // You beat the target time. Next course unlocked.
RETURN

dirt_track_display_target_time_failed:
PRINT_NOW TT_E2 7000 1 // ~r~You failed to beat the target time.
RETURN


dirt_track_display_new_record:
dirt_track_got_new_record = 1
RETURN

dirt_track_display_record_failed:
PRINT_NOW TT_E3 7000 1 // ~r~You failed to beat the Course Record.
RETURN

dirt_track_try_update_lap_record:
IS_THING_EQUAL_TO_THING dirt_track_course_variation 0
GOTO_IF_TRUE dirt_track_try_update_bfinject_lap_record
RETURN

dirt_track_try_update_bfinject_lap_record:
SWITCH dirt_track_course_index
    CASE 0
        IF dirt_track_bfinject_course_1_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_1_best_lap
            dirt_track_bfinject_course_1_best_lap = dirt_track_lap_time

            //RETURN_TRUE // Inferred
            RETURN
        ENDIF
        BREAK
ENDSWITCH
RETURN_FALSE
RETURN

dirt_track_remove_blips:
REMOVE_BLIP dirt_track_curr_checkpoint_blip
REMOVE_BLIP dirt_track_next_checkpoint_blip

dirt_track_curr_checkpoint_blip = 0
dirt_track_next_checkpoint_blip = 0
RETURN

dirt_track_delete_car:
WARP_PLAYER_FROM_CAR_TO_COORD player 1049.3 871.5 93.6

DELETE_CAR dirt_track_car
RETURN
}

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

VAR_INT dirt_track_total_time dirt_track_new_record_or_passed_all

VAR_FLOAT dirt_track_car_x dirt_track_car_y dirt_track_car_z dirt_track_car_forward_x dirt_track_car_forward_y dirt_track_dot_x dirt_track_dot_y
VAR_FLOAT dirt_track_player_start_x dirt_track_player_start_y

VAR_FLOAT dirt_track_car_end_x dirt_track_car_end_y dirt_track_car_end_z dirt_track_car_end_heading

VAR_INT dirt_track_selected_course_in_menu dirt_track_target_time_secs dirt_track_course_pass_status dirt_track_leftstick_value dirt_track_dpad_left_flag dirt_track_dpad_right_flag
VAR_INT dirt_track_dangerous_checkpoint

LVAR_INT dirt_track_temp_checkpoint_index dirt_track_num_checkpoints dirt_track_target_time
LVAR_FLOAT dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z

CONST_INT dirt_track_num_laps 3
CONST_INT dirt_track_num_courses 5

CONST_FLOAT dirt_track_course_bounds_x1 746.6
CONST_FLOAT dirt_track_course_bounds_y1 1038.0

CONST_FLOAT dirt_track_course_bounds_x2 1187.7
CONST_FLOAT dirt_track_course_bounds_y2 594.8

dirt_track_start:
SCRIPT_NAME DTRACK

flag_player_on_mission = 1
flag_player_on_dirt_track_mission = 1

IF dirt_track_course_variation = 0
    dirt_track_car_model_id = 114 // CAR_BFINJECT
    dirt_track_car_end_x = 986.5
    dirt_track_car_end_y = 987.1
    dirt_track_car_end_z = 103.7
    dirt_track_car_end_heading = 78.0
ELSE
    dirt_track_car_model_id = 112 // CAR_BOBCAT
    dirt_track_car_end_x = 1101.5
    dirt_track_car_end_y = 912.5
    dirt_track_car_end_z = 118.9
    dirt_track_car_end_heading = 177.3
ENDIF

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
    GOTO dirt_track_exit_mission
ENDIF

GET_PAD_STATE PAD1 LEFTSTICKX dirt_track_leftstick_value

IF IS_BUTTON_PRESSED PAD1 DPADLEFT
OR dirt_track_leftstick_value < -100
    IF dirt_track_dpad_left_flag = 0
        dirt_track_dpad_left_flag = 1

        dirt_track_selected_course_in_menu--
        IF dirt_track_selected_course_in_menu < 1
            dirt_track_selected_course_in_menu = dirt_track_num_courses
        ENDIF
    ENDIF
ELSE
    dirt_track_dpad_left_flag = 0
ENDIF

IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
OR dirt_track_leftstick_value > 100
    IF dirt_track_dpad_right_flag = 0
        dirt_track_dpad_right_flag = 1

        dirt_track_selected_course_in_menu++
        IF dirt_track_selected_course_in_menu > dirt_track_num_courses
            dirt_track_selected_course_in_menu = 1
        ENDIF
    ENDIF
ELSE
    dirt_track_dpad_right_flag = 0
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
    IF dirt_track_dangerous_checkpoint = 1
        IF flag_dirt_track_warning_shown = 0
            PRINT_HELP TT_WARN
            flag_dirt_track_warning_shown = 1
        ENDIF
        DRAW_CORONA dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 200 200 0
    ELSE
        DRAW_CORONA dirt_track_temp_checkpoint_x dirt_track_temp_checkpoint_y dirt_track_temp_checkpoint_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 100
    ENDIF
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
    dirt_track_dot_y = -8.0 * dirt_track_car_forward_x

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
IF dirt_track_new_record_or_passed_all = 1
    PRINT_WITH_NUMBER_BIG TT_D7 dirt_track_current_time_secs 7000 4
ELSE
    PRINT_WITH_NUMBER_BIG TT_D8 dirt_track_current_time_secs 7000 4
ENDIF

dirt_track_return_to_course_select:
WAIT 5000
CLEAR_PRINTS

IF dirt_track_new_record_or_passed_all = 2
    IF dirt_track_course_variation = 0
        IF flag_dirt_track_bfinject_passed = 0
            flag_dirt_track_bfinject_passed = 1

            REGISTER_MISSION_GIVEN
            REGISTER_MISSION_PASSED DTRK_1

            GOTO dirt_track_passed
        ENDIF
    ELSE
        IF flag_dirt_track_bobcat_passed = 0
            flag_dirt_track_bobcat_passed = 1

            REGISTER_MISSION_GIVEN
            REGISTER_MISSION_PASSED DTRK_2

            GOTO dirt_track_passed
        ENDIF
    ENDIF
ENDIF

SET_PLAYER_CONTROL player OFF

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

dirt_track_new_record_or_passed_all = 0
GOTO dirt_track_return_to_course_select

dirt_track_passed:
GOSUB dirt_track_exit_mission

PRINT_WITH_NUMBER_BIG ( M_PASS ) 25000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player 25000

RETURN

dirt_track_exit_mission:
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

RETURN

dirt_track_cleanup:

GOSUB dirt_track_remove_blips

flag_player_on_dirt_track_mission = 0
flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN

dirt_track_get_checkpoint_coords:
dirt_track_dangerous_checkpoint = 0
// IF...GOTO exists but isn't supported in gta3sc
IS_THING_EQUAL_TO_THING dirt_track_course_variation 0
GOTO_IF_TRUE dirt_track_bfinject_courses

RETURN

dirt_track_bfinject_courses:
IS_THING_EQUAL_TO_THING dirt_track_course_index 0
GOTO_IF_TRUE dirt_track_bfinject_course_0
IS_THING_EQUAL_TO_THING dirt_track_course_index 1
GOTO_IF_TRUE dirt_track_bfinject_course_1
IS_THING_EQUAL_TO_THING dirt_track_course_index 2
GOTO_IF_TRUE dirt_track_bfinject_course_2
IS_THING_EQUAL_TO_THING dirt_track_course_index 3
GOTO_IF_TRUE dirt_track_bfinject_course_3
IS_THING_EQUAL_TO_THING dirt_track_course_index 4
GOTO_IF_TRUE dirt_track_bfinject_course_4
RETURN

dirt_track_bfinject_course_0:
dirt_track_num_checkpoints = 7
dirt_track_target_time = 70000
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_0_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 911.4
        dirt_track_temp_checkpoint_y = 872.5
        dirt_track_temp_checkpoint_z = 95.1
        BREAK
    CASE 1
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

dirt_track_bfinject_course_1:
dirt_track_num_checkpoints = 17
dirt_track_target_time = 999999999
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_1_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 915.6
        dirt_track_temp_checkpoint_y = 873.8
        dirt_track_temp_checkpoint_z = 94.9
        BREAK
    CASE 1
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 917.4
        dirt_track_temp_checkpoint_y = 820.6
        dirt_track_temp_checkpoint_z = 76.9
        BREAK
    CASE 2
        dirt_track_temp_checkpoint_x = 910.1
        dirt_track_temp_checkpoint_y = 737.8
        dirt_track_temp_checkpoint_z = 62.2
        BREAK
    CASE 3
        dirt_track_temp_checkpoint_x = 881.9
        dirt_track_temp_checkpoint_y = 763.1
        dirt_track_temp_checkpoint_z = 66.1
        BREAK
    CASE 4
        dirt_track_temp_checkpoint_x = 848.0
        dirt_track_temp_checkpoint_y = 786.9
        dirt_track_temp_checkpoint_z = 68.6
        BREAK
    CASE 5
        dirt_track_temp_checkpoint_x = 824.5
        dirt_track_temp_checkpoint_y = 832.7
        dirt_track_temp_checkpoint_z = 76.5
        BREAK
    CASE 6
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 858.5
        dirt_track_temp_checkpoint_y = 854.0
        dirt_track_temp_checkpoint_z = 84.1
        BREAK
    CASE 7
        dirt_track_temp_checkpoint_x = 894.6
        dirt_track_temp_checkpoint_y = 840.4
        dirt_track_temp_checkpoint_z = 77.9
        BREAK
    CASE 8
        dirt_track_temp_checkpoint_x = 917.6
        dirt_track_temp_checkpoint_y = 784.1
        dirt_track_temp_checkpoint_z = 76.3
        BREAK
    CASE 9
        dirt_track_temp_checkpoint_x = 979.4
        dirt_track_temp_checkpoint_y = 749.2
        dirt_track_temp_checkpoint_z = 64.7
        BREAK
    CASE 10
        dirt_track_temp_checkpoint_x = 1000.9
        dirt_track_temp_checkpoint_y = 771.3
        dirt_track_temp_checkpoint_z = 69.0
        BREAK
    CASE 11
        dirt_track_temp_checkpoint_x = 957.7
        dirt_track_temp_checkpoint_y = 791.6
        dirt_track_temp_checkpoint_z = 73.3
        BREAK
    CASE 12
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 983.8
        dirt_track_temp_checkpoint_y = 804.2
        dirt_track_temp_checkpoint_z = 74.7
        BREAK
    CASE 13
        dirt_track_temp_checkpoint_x = 1057.6
        dirt_track_temp_checkpoint_y = 827.2
        dirt_track_temp_checkpoint_z = 81.8
        BREAK
    CASE 14
        dirt_track_temp_checkpoint_x = 1025.6
        dirt_track_temp_checkpoint_y = 867.3
        dirt_track_temp_checkpoint_z = 92.6
        BREAK
    CASE 15
        dirt_track_temp_checkpoint_x = 1004.5
        dirt_track_temp_checkpoint_y = 893.6
        dirt_track_temp_checkpoint_z = 91.0
        BREAK
    CASE 16
        dirt_track_temp_checkpoint_x = 917.2
        dirt_track_temp_checkpoint_y = 906.9
        dirt_track_temp_checkpoint_z = 86.2
        BREAK
ENDSWITCH
RETURN

dirt_track_bfinject_course_2:
dirt_track_num_checkpoints = 19
dirt_track_target_time = 999999999
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_2_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 916.0
        dirt_track_temp_checkpoint_y = 875.6
        dirt_track_temp_checkpoint_z = 95.1
        BREAK
    CASE 1
        dirt_track_temp_checkpoint_x = 817.5
        dirt_track_temp_checkpoint_y = 880.4
        dirt_track_temp_checkpoint_z = 81.1
        BREAK
    CASE 2
        dirt_track_temp_checkpoint_x = 819.0
        dirt_track_temp_checkpoint_y = 854.9
        dirt_track_temp_checkpoint_z = 85.2
        BREAK
    CASE 3
        dirt_track_temp_checkpoint_x = 775.4
        dirt_track_temp_checkpoint_y = 875.4
        dirt_track_temp_checkpoint_z = 78.9
        BREAK
    CASE 4
        dirt_track_temp_checkpoint_x = 786.7
        dirt_track_temp_checkpoint_y = 817.9
        dirt_track_temp_checkpoint_z = 72.0
        BREAK
    CASE 5
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 801.2
        dirt_track_temp_checkpoint_y = 788.4
        dirt_track_temp_checkpoint_z = 68.2
        BREAK
    CASE 6
        dirt_track_temp_checkpoint_x = 847.9
        dirt_track_temp_checkpoint_y = 785.6
        dirt_track_temp_checkpoint_z = 68.6
        BREAK
    CASE 7
        dirt_track_temp_checkpoint_x = 828.0
        dirt_track_temp_checkpoint_y = 840.7
        dirt_track_temp_checkpoint_z = 78.3
        BREAK
    CASE 8
        dirt_track_temp_checkpoint_x = 849.7
        dirt_track_temp_checkpoint_y = 837.0
        dirt_track_temp_checkpoint_z = 80.7
        BREAK
    CASE 9
        dirt_track_temp_checkpoint_x = 896.5
        dirt_track_temp_checkpoint_y = 821.1
        dirt_track_temp_checkpoint_z = 86.4
        BREAK
    CASE 10
        dirt_track_temp_checkpoint_x = 953.7
        dirt_track_temp_checkpoint_y = 823.3
        dirt_track_temp_checkpoint_z = 87.9
        BREAK
    CASE 11
        dirt_track_temp_checkpoint_x = 1056.9
        dirt_track_temp_checkpoint_y = 826.6
        dirt_track_temp_checkpoint_z = 81.5
        BREAK
    CASE 12
        dirt_track_temp_checkpoint_x = 1031.5
        dirt_track_temp_checkpoint_y = 892.6
        dirt_track_temp_checkpoint_z = 95.3
        BREAK
    CASE 13
        dirt_track_temp_checkpoint_x = 980.5
        dirt_track_temp_checkpoint_y = 940.7
        dirt_track_temp_checkpoint_z = 104.6
        BREAK
    CASE 14
        dirt_track_temp_checkpoint_x = 877.3
        dirt_track_temp_checkpoint_y = 934.8
        dirt_track_temp_checkpoint_z = 99.8
        BREAK
    CASE 15
        dirt_track_temp_checkpoint_x = 886.2
        dirt_track_temp_checkpoint_y = 1000.8
        dirt_track_temp_checkpoint_z = 98.2
        BREAK
    CASE 16
        dirt_track_temp_checkpoint_x = 917.7
        dirt_track_temp_checkpoint_y = 959.8
        dirt_track_temp_checkpoint_z = 90.8
        BREAK
    CASE 17
        dirt_track_temp_checkpoint_x = 929.9
        dirt_track_temp_checkpoint_y = 920.7
        dirt_track_temp_checkpoint_z = 87.4
        BREAK
    CASE 18
        dirt_track_temp_checkpoint_x = 995.6
        dirt_track_temp_checkpoint_y = 875.6
        dirt_track_temp_checkpoint_z = 92.6
        BREAK
ENDSWITCH
RETURN

dirt_track_bfinject_course_3:
dirt_track_num_checkpoints = 16
dirt_track_target_time = 999999999
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_3_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 913.6
        dirt_track_temp_checkpoint_y = 875.9
        dirt_track_temp_checkpoint_z = 94.9
        BREAK
    CASE 1
        dirt_track_temp_checkpoint_x = 917.9
        dirt_track_temp_checkpoint_y = 939.1
        dirt_track_temp_checkpoint_z = 88.4
        BREAK
    CASE 2
        dirt_track_temp_checkpoint_x = 907.4
        dirt_track_temp_checkpoint_y = 1005.8
        dirt_track_temp_checkpoint_z = 98.2
        BREAK
    CASE 3
        dirt_track_temp_checkpoint_x = 880.2
        dirt_track_temp_checkpoint_y = 967.6
        dirt_track_temp_checkpoint_z = 98.5
        BREAK
    CASE 4
        dirt_track_temp_checkpoint_x = 920.3
        dirt_track_temp_checkpoint_y = 870.9
        dirt_track_temp_checkpoint_z = 94.3
        BREAK
    CASE 5
        dirt_track_temp_checkpoint_x = 988.7
        dirt_track_temp_checkpoint_y = 828.1
        dirt_track_temp_checkpoint_z = 83.2
        BREAK
    CASE 6
        dirt_track_temp_checkpoint_x = 1053.7
        dirt_track_temp_checkpoint_y = 798.1
        dirt_track_temp_checkpoint_z = 78.2
        BREAK
    CASE 7
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 981.2
        dirt_track_temp_checkpoint_y = 805.2
        dirt_track_temp_checkpoint_z = 75.2
        BREAK
    CASE 8
        dirt_track_temp_checkpoint_x = 956.6
        dirt_track_temp_checkpoint_y = 791.8
        dirt_track_temp_checkpoint_z = 73.4
        BREAK
    CASE 9
        dirt_track_temp_checkpoint_x = 1007.8
        dirt_track_temp_checkpoint_y = 762.1
        dirt_track_temp_checkpoint_z = 68.0
        BREAK
    CASE 10
        dirt_track_temp_checkpoint_x = 911.9
        dirt_track_temp_checkpoint_y = 736.8
        dirt_track_temp_checkpoint_z = 62.4
        BREAK
    CASE 11
        dirt_track_temp_checkpoint_x = 876.8
        dirt_track_temp_checkpoint_y = 768.4
        dirt_track_temp_checkpoint_z = 66.9
        BREAK
    CASE 12
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 825.0
        dirt_track_temp_checkpoint_y = 784.8
        dirt_track_temp_checkpoint_z = 66.9
        BREAK
    CASE 13
        dirt_track_temp_checkpoint_x = 776.3
        dirt_track_temp_checkpoint_y = 801.0
        dirt_track_temp_checkpoint_z = 67.9
        BREAK
    CASE 14
        dirt_track_temp_checkpoint_x = 816.1
        dirt_track_temp_checkpoint_y = 831.1
        dirt_track_temp_checkpoint_z = 76.6
        BREAK
    CASE 15
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 858.6
        dirt_track_temp_checkpoint_y = 854.4
        dirt_track_temp_checkpoint_z = 84.2
        BREAK
ENDSWITCH
RETURN

dirt_track_bfinject_course_4:
dirt_track_num_checkpoints = 23
dirt_track_target_time = 999999999
dirt_track_course_pass_status = flag_dirt_track_bfinject_course_4_status

SWITCH dirt_track_temp_checkpoint_index
    CASE 0
        dirt_track_temp_checkpoint_x = 917.9
        dirt_track_temp_checkpoint_y = 877.5
        dirt_track_temp_checkpoint_z = 97.7
        BREAK
    CASE 1
        dirt_track_temp_checkpoint_x = 999.4
        dirt_track_temp_checkpoint_y = 913.9
        dirt_track_temp_checkpoint_z = 95.9
        BREAK
    CASE 2
        dirt_track_temp_checkpoint_x = 1041.1
        dirt_track_temp_checkpoint_y = 962.5
        dirt_track_temp_checkpoint_z = 102.9
        BREAK
    CASE 3
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 1026.9
        dirt_track_temp_checkpoint_y = 987.2
        dirt_track_temp_checkpoint_z = 104.6
        BREAK
    CASE 4
        dirt_track_temp_checkpoint_x = 993.5
        dirt_track_temp_checkpoint_y = 963.3
        dirt_track_temp_checkpoint_z = 102.3
        BREAK
    CASE 5
        dirt_track_temp_checkpoint_x = 931.5
        dirt_track_temp_checkpoint_y = 950.5
        dirt_track_temp_checkpoint_z = 105.3
        BREAK
    CASE 6
        dirt_track_temp_checkpoint_x = 871.7
        dirt_track_temp_checkpoint_y = 937.4
        dirt_track_temp_checkpoint_z = 98.9
        BREAK
    CASE 7
        dirt_track_temp_checkpoint_x = 853.5
        dirt_track_temp_checkpoint_y = 997.4
        dirt_track_temp_checkpoint_z = 99.7
        BREAK
    CASE 8
        dirt_track_temp_checkpoint_x = 825.9
        dirt_track_temp_checkpoint_y = 1001.3
        dirt_track_temp_checkpoint_z = 99.5
        BREAK
    CASE 9
        dirt_track_temp_checkpoint_x = 785.2
        dirt_track_temp_checkpoint_y = 961.7
        dirt_track_temp_checkpoint_z = 95.9
        BREAK
    CASE 10
        dirt_track_temp_checkpoint_x = 814.1
        dirt_track_temp_checkpoint_y = 912.6
        dirt_track_temp_checkpoint_z = 93.3
        BREAK
    CASE 11
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 852.4
        dirt_track_temp_checkpoint_y = 937.8
        dirt_track_temp_checkpoint_z = 94.4
        BREAK
    CASE 12
        dirt_track_temp_checkpoint_x = 821.2
        dirt_track_temp_checkpoint_y = 971.3
        dirt_track_temp_checkpoint_z = 94.1
        BREAK
    CASE 13
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 842.0
        dirt_track_temp_checkpoint_y = 878.9
        dirt_track_temp_checkpoint_z = 87.3
        BREAK
    CASE 14
        dirt_track_temp_checkpoint_x = 850.9
        dirt_track_temp_checkpoint_y = 835.1
        dirt_track_temp_checkpoint_z = 80.4
        BREAK
    CASE 15
        dirt_track_temp_checkpoint_x = 891.3
        dirt_track_temp_checkpoint_y = 820.1
        dirt_track_temp_checkpoint_z = 86.6
        BREAK
    CASE 16
        dirt_track_temp_checkpoint_x = 954.2
        dirt_track_temp_checkpoint_y = 823.5
        dirt_track_temp_checkpoint_z = 87.7
        BREAK
    CASE 17
        dirt_track_temp_checkpoint_x = 1052.6
        dirt_track_temp_checkpoint_y = 796.6
        dirt_track_temp_checkpoint_z = 78.1
        BREAK
    CASE 18
        dirt_track_dangerous_checkpoint = 1
        dirt_track_temp_checkpoint_x = 981.4
        dirt_track_temp_checkpoint_y = 805.3
        dirt_track_temp_checkpoint_z = 75.3
        BREAK
    CASE 19
        dirt_track_temp_checkpoint_x = 958.1
        dirt_track_temp_checkpoint_y = 789.2
        dirt_track_temp_checkpoint_z = 73.4
        BREAK
    CASE 20
        dirt_track_temp_checkpoint_x = 1007.0
        dirt_track_temp_checkpoint_y = 759.3
        dirt_track_temp_checkpoint_z = 67.7
        BREAK
    CASE 21
        dirt_track_temp_checkpoint_x = 921.2
        dirt_track_temp_checkpoint_y = 758.2
        dirt_track_temp_checkpoint_z = 64.0
        BREAK
    CASE 22
        dirt_track_temp_checkpoint_x = 916.9
        dirt_track_temp_checkpoint_y = 822.7
        dirt_track_temp_checkpoint_z = 76.9
        BREAK
ENDSWITCH
RETURN

dirt_track_try_pass_course:
dirt_track_new_record_or_passed_all = 0
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
                dirt_track_bfinject_course_0_best_time = dirt_track_total_time

                flag_dirt_track_bfinject_course_1_status = 1
            ELSE
                GOTO dirt_track_display_target_time_failed
            ENDIF
        ELSE
            IF dirt_track_total_time < dirt_track_bfinject_course_0_best_time
                dirt_track_bfinject_course_0_best_time = dirt_track_total_time
                GOTO dirt_track_display_new_record
            ENDIF
            GOTO dirt_track_display_record_failed
        ENDIF
        BREAK
    CASE 1
        IF flag_dirt_track_bfinject_course_1_status = 1
            IF dirt_track_total_time < dirt_track_target_time
                ADD_SCORE player 1000
                PLAYER_MADE_PROGRESS 1
                flag_dirt_track_bfinject_course_1_status = 2
                dirt_track_bfinject_course_1_best_time = dirt_track_total_time

                flag_dirt_track_bfinject_course_2_status = 1
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
    CASE 2
        IF flag_dirt_track_bfinject_course_2_status = 1
            IF dirt_track_total_time < dirt_track_target_time
                ADD_SCORE player 1000
                PLAYER_MADE_PROGRESS 1
                flag_dirt_track_bfinject_course_2_status = 2
                dirt_track_bfinject_course_2_best_time = dirt_track_total_time

                flag_dirt_track_bfinject_course_3_status = 1
            ELSE
                GOTO dirt_track_display_target_time_failed
            ENDIF
        ELSE
            IF dirt_track_total_time < dirt_track_bfinject_course_2_best_time
                dirt_track_bfinject_course_2_best_time = dirt_track_total_time
                GOTO dirt_track_display_new_record
            ENDIF
            GOTO dirt_track_display_record_failed
        ENDIF
        BREAK
    CASE 3
        IF flag_dirt_track_bfinject_course_3_status = 1
            IF dirt_track_total_time < dirt_track_target_time
                ADD_SCORE player 1000
                PLAYER_MADE_PROGRESS 1
                flag_dirt_track_bfinject_course_4_status = 2
                dirt_track_bfinject_course_3_best_time = dirt_track_total_time

                flag_dirt_track_bfinject_course_3_status = 1
            ELSE
                GOTO dirt_track_display_target_time_failed
            ENDIF
        ELSE
            IF dirt_track_total_time < dirt_track_bfinject_course_3_best_time
                dirt_track_bfinject_course_3_best_time = dirt_track_total_time
                GOTO dirt_track_display_new_record
            ENDIF
            GOTO dirt_track_display_record_failed
        ENDIF
        BREAK
    CASE 4
        IF flag_dirt_track_bfinject_course_4_status = 1
            IF dirt_track_total_time < dirt_track_target_time
                ADD_SCORE player 1000
                PLAYER_MADE_PROGRESS 1
                flag_dirt_track_bfinject_course_4_status = 2
                dirt_track_bfinject_course_4_best_time = dirt_track_total_time

                GOTO dirt_track_display_all_courses_complete
            ENDIF
            GOTO dirt_track_display_target_time_failed
        ELSE
            IF dirt_track_total_time < dirt_track_bfinject_course_4_best_time
                dirt_track_bfinject_course_4_best_time = dirt_track_total_time
                GOTO dirt_track_display_new_record
            ENDIF
            GOTO dirt_track_display_record_failed
        ENDIF
        BREAK
ENDSWITCH

PRINT_NOW TT_E10 7000 1 // You beat the target time. Next course unlocked.
RETURN

dirt_track_display_all_courses_complete:
PRINT_NOW TT_E11 7000 1 // You beat the target time. All courses complete!
dirt_track_new_record_or_passed_all = 2
RETURN

dirt_track_display_target_time_failed:
PRINT_NOW TT_E2 7000 1 // ~r~You failed to beat the target time.
RETURN


dirt_track_display_new_record:
dirt_track_new_record_or_passed_all = 1
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
        IF dirt_track_bfinject_course_0_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_0_best_lap
            dirt_track_bfinject_course_0_best_lap = dirt_track_lap_time

            //RETURN_TRUE // Inferred
            RETURN
        ENDIF
        BREAK
    CASE 1
        IF dirt_track_bfinject_course_1_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_1_best_lap
            dirt_track_bfinject_course_1_best_lap = dirt_track_lap_time

            //RETURN_TRUE // Inferred
            RETURN
        ENDIF
        BREAK
    CASE 2
        IF dirt_track_bfinject_course_2_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_2_best_lap
            dirt_track_bfinject_course_2_best_lap = dirt_track_lap_time

            //RETURN_TRUE // Inferred
            RETURN
        ENDIF
        BREAK
    CASE 3
        IF dirt_track_bfinject_course_3_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_3_best_lap
            dirt_track_bfinject_course_3_best_lap = dirt_track_lap_time

            //RETURN_TRUE // Inferred
            RETURN
        ENDIF
        BREAK
    CASE 4
        IF dirt_track_bfinject_course_4_best_lap = 0
        OR dirt_track_lap_time < dirt_track_bfinject_course_4_best_lap
            dirt_track_bfinject_course_4_best_lap = dirt_track_lap_time

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

MISSION_START
// *****************************************************************************************
// *********************************    Love mission 3   *********************************** 
// ********************************* A Drop in the Ocean ***********************************
// *****************************************************************************************
// *** The Player must pick up several packages that will be dropped from a Cessna into  ***
// *** the bay that night. The player will use a boat to collect them. It is a decoy	 ***
// *** (player does not know this at this time) so the police are aware of them. As soon ***
// *** has the player has picked up the first package the police chopper will be on him. ***
// *** Once the player has collected them all he must get them back to land and to his 	 ***
// *** hideout in a car with the ensuing police chase. 									 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love3

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_love3_failed
ENDIF

GOSUB mission_cleanup_love3

MISSION_END
 
// Variables for mission

VAR_INT players_boat /*garage_flag_l3 player_car_l3*/ players_boat_blip	police_boat_flag police_boat
VAR_INT plane_blip random_int_l3 counter_display_flag plane_timer police_boat_driver police_rating
VAR_INT float_packge_01	float_packge_02 float_packge_03 float_packge_04 float_packge_05 float_packge_06
VAR_INT drug_current_timer temporary_time_drug last_drug_dropped_timer package_numbers cs_ojg
VAR_INT packge_01 packge_02	packge_03 packge_04	packge_05 packge_06	packages_collected

VAR_FLOAT PlaneX PlaneY PlaneZ
VAR_FLOAT package_1_x package_1_y
VAR_FLOAT package_2_x package_2_y 
VAR_FLOAT package_3_x package_3_y 
VAR_FLOAT package_4_x package_4_y 
VAR_FLOAT package_5_x package_5_y 
VAR_FLOAT package_6_x package_6_y 

// ****************************************Mission Start************************************

mission_start_love3:

flag_player_on_mission = 1
flag_player_on_love_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME love3

drug_current_timer 	    = 0
temporary_time_drug     = 0
last_drug_dropped_timer = 0
package_numbers			= 0
packages_collected 		= 0
police_boat_flag		= 0
police_rating			= 0

packge_01 	= 0
packge_02	= 0
packge_03 	= 0
packge_04	= 0
packge_05 	= 0
packge_06	= 0

counter_display_flag = 0
//garage_flag_l3 = 0

PlaneX = 0.0
PlaneY = 0.0
PlaneZ = 0.0

// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 love2
LOAD_SPECIAL_CHARACTER 2 ojg2
LOAD_SPECIAL_MODEL cut_obj1 LOVEH
REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED tshrorckgrdn
	WAIT 0
ENDWHILE

LOAD_CUTSCENE D3_ADO

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love
SET_CUTSCENE_ANIM cs_love love2

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_ojg
SET_CUTSCENE_ANIM cs_ojg ojg2

CREATE_CUTSCENE_HEAD cs_love cut_obj1 cs_lovehead
SET_CUTSCENE_HEAD_ANIM cs_lovehead love

CLEAR_AREA 82.44 -1548.49 28.0 2.0 TRUE

SET_PLAYER_COORDINATES player 82.44 -1548.49 28.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
SWITCH_RUBBISH OFF

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 12262
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE3_A 5000 1//"In these days of moral hypocrisy certain valuable commodities can be hard to import."

WHILE cs_time < 16652
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE3_B 5000 1//"On it's approach to Liberty airport tonight, a light aircraft will pass over the bay."

WHILE cs_time < 20065
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE3_C 5000 1//"It will drop several packages into the water."

WHILE cs_time < 22434
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE3_D 5000 1//"Make sure you pick them up before anyone else does."

WHILE cs_time < 25333
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

REQUEST_MODEL PLANE_DEADDODO 
REQUEST_MODEL BOAT_SPEEDER
REQUEST_MODEL BOAT_PREDATOR

LOAD_ALL_MODELS_NOW

SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas

// ******************************************END OF CUTSCENE********************************


WHILE NOT HAS_MODEL_LOADED PLANE_DEADDODO 
OR NOT HAS_MODEL_LOADED BOAT_SPEEDER
OR NOT HAS_MODEL_LOADED BOAT_PREDATOR
	WAIT 0
ENDWHILE

CREATE_CAR BOAT_SPEEDER 837.0 -1115.6 -0.2 players_boat
SET_CAR_HEADING players_boat 140.0

ADD_BLIP_FOR_CAR players_boat players_boat_blip

PRINT_NOW LOVE3_1 5000 1

START_DRUG_DROP_OFF

IF flag_player_on_mission = 0  						   // IMPOSSIBLE IF STATEMENT
	ADD_BLIP_FOR_COORD PlaneX PlaneY PlaneZ plane_blip // JUST SO I CAN REMOVE THE 
ENDIF												   // BLIP BEFORE ADDING IT

WAIT 1000

plane_timer = 120000

DISPLAY_ONSCREEN_TIMER plane_timer

plane_drop_loop:

WAIT 0

IF HAS_DROP_OFF_PLANE_BEEN_SHOT_DOWN
	PRINT_NOW LOVE3_4 5000 1
	GOTO mission_love3_failed
ENDIF

IF plane_timer = 0
	CLEAR_ONSCREEN_TIMER plane_timer 
	PRINT_NOW LOVE3_5 5000 1// "The plane is now in range."
	plane_timer = -1000
ENDIF

IF IS_PLAYER_IN_MODEL player BOAT_PREDATOR
OR IS_PLAYER_IN_MODEL player BOAT_SPEEDER
OR IS_PLAYER_IN_MODEL player BOAT_REEFER
	REMOVE_BLIP players_boat_blip
ENDIF

REMOVE_BLIP plane_blip

IF package_numbers < 6
	FIND_DROP_OFF_PLANE_COORDINATES PlaneX PlaneY PlaneZ
	ADD_BLIP_FOR_COORD_OLD PlaneX PlaneY PlaneZ 4 BLIP_ONLY plane_blip
	CHANGE_BLIP_SCALE plane_blip 3
	GET_GAME_TIMER drug_current_timer
	temporary_time_drug = drug_current_timer - last_drug_dropped_timer
	IF temporary_time_drug > 7000
		GET_GAME_TIMER last_drug_dropped_timer
		IF PlaneX < 750.0
		AND PlaneX > 615.0
		AND PlaneY < 650.0
		AND PlaneY > -1213.0
			GET_GAME_TIMER last_drug_dropped_timer
			IF package_numbers = 0
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_01
				package_1_x = PlaneX
				package_1_y = PlaneY
				packge_01 = 1
			ENDIF
			IF package_numbers = 1
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_02
				package_2_x = PlaneX
				package_2_y = PlaneY
				packge_02 = 1
			ENDIF
			IF package_numbers = 2
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_03
				package_3_x = PlaneX
				package_3_y = PlaneY
				packge_03 = 1
			ENDIF
			IF package_numbers = 3
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_04
				package_4_x = PlaneX
				package_4_y = PlaneY
				packge_04 = 1
			ENDIF
			IF package_numbers = 4
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_05
				package_5_x = PlaneX
				package_5_y = PlaneY
				packge_05 = 1
			ENDIF
			IF package_numbers = 5
				CREATE_FLOATING_PACKAGE PlaneX PlaneY PlaneZ float_packge_06
				package_6_x = PlaneX
				package_6_y = PlaneY
				packge_06 = 1
			ENDIF
			package_numbers++
		ENDIF
	ENDIF
ENDIF
	
IF packge_01 > 0
AND	packages_collected < 6
	PRINT_WITH_NUMBER_NOW LOVE3_3 package_numbers 5000 1 //"The plane has dropped ~1~ of 8 packages."
ENDIF

IF packge_01 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_01
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_01 = 2
	ENDIF
ENDIF

IF packge_02 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_02
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_02 = 2
	ENDIF
ENDIF

IF packge_03 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_03
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_03 = 2
	ENDIF
ENDIF

IF packge_04 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_04
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_04 = 2
	ENDIF
ENDIF

IF packge_05 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_05
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_05 = 2
	ENDIF
ENDIF

IF packge_06 = 1
	IF HAS_PICKUP_BEEN_COLLECTED float_packge_06
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_EVIDENCE_PICKUP
		++packages_collected
		IF counter_display_flag = 0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING packages_collected COUNTER_DISPLAY_NUMBER COLLECT 
			counter_display_flag = 1
		ENDIF
		police_rating += 1
		ALTER_WANTED_LEVEL_NO_DROP player police_rating
		packge_06 = 2
	ENDIF
ENDIF

IF packge_06 > 0
	IF police_boat_flag = 0
		IF NOT IS_POINT_ON_SCREEN 560.5223 -474.0232 -0.2 5.0
			CREATE_CAR BOAT_PREDATOR 560.5223 -474.0232 -0.2 police_boat
			CREATE_CHAR_INSIDE_CAR police_boat PEDTYPE_CIVMALE PED_COP police_boat_driver
			SET_CAR_HEADING police_boat 179.7861
			BOAT_GOTO_COORDS police_boat package_6_x package_6_y 0.0
			police_boat_flag = 1
		ENDIF
	ENDIF
	IF NOT IS_CAR_DEAD police_boat
		IF police_boat_flag = 1
			IF LOCATE_CAR_2D police_boat package_6_x package_6_y 4.0 4.0 0
				IF packge_06 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat package_5_x package_5_y 0.0
					police_boat_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF police_boat_flag = 2
			IF LOCATE_CAR_2D police_boat package_5_x package_5_y 4.0 4.0 0
				IF packge_05 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat package_4_x package_4_y 0.0
					police_boat_flag = 3
				ENDIF
			ENDIF
		ENDIF
		IF police_boat_flag = 3
			IF LOCATE_CAR_2D police_boat package_4_x package_4_y 4.0 4.0 0
				IF packge_04 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat package_3_x package_3_y 0.0
					police_boat_flag = 4
				ENDIF
			ENDIF
		ENDIF
		IF police_boat_flag = 4
			IF LOCATE_CAR_2D police_boat package_3_x package_3_y 4.0 4.0 0
				IF packge_03 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat package_2_x package_2_y 0.0
					police_boat_flag = 5
				ENDIF
			ENDIF
		ENDIF
		IF police_boat_flag = 5
			IF LOCATE_CAR_2D police_boat package_2_x package_2_y 4.0 4.0 0
				IF packge_02 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat package_1_x package_1_y 0.0
					police_boat_flag = 6
				ENDIF
			ENDIF
		ENDIF
		IF police_boat_flag = 6
			IF LOCATE_CAR_2D police_boat package_1_x package_1_y 4.0 4.0 0
				IF packge_01 = 1
					REMOVE_PICKUP float_packge_01
					REMOVE_PICKUP float_packge_02
					REMOVE_PICKUP float_packge_03
					REMOVE_PICKUP float_packge_04
					REMOVE_PICKUP float_packge_05
					REMOVE_PICKUP float_packge_06
					PRINT_NOW LOVE3_6 5000 1// "~r~The Police got the the package first!"
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					SET_BOAT_CRUISE_SPEED police_boat 100.0
					GOTO mission_love3_failed
				ELSE
					BOAT_GOTO_COORDS police_boat 641.5550 594.6697 0.0
					police_boat_flag = 99
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF packages_collected = 6
	PRINT_NOW LOVE3_2 5000 1 // "You have them all.  Take the package to Donald Love"
	REMOVE_BLIP	plane_blip
	ADD_BLIP_FOR_COORD 87.3 -1548.6 27.255 plane_blip //130.0 -1585.0 26.0
	temporary_time_drug = 0
	GOTO garage_loop_l3
ENDIF

GOTO plane_drop_loop
	   		
garage_loop_l3:

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	WAIT 0
ENDWHILE

WHILE NOT LOCATE_STOPPED_PLAYER_ON_FOOT_3D Player 87.3 -1548.6 28.3 2.0 1.0 2.0 1
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player OFF

SET_EVERYONE_IGNORE_PLAYER player ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
CLEAR_WANTED_LEVEL player

SET_FIXED_CAMERA_POSITION 81.3343 -1540.0887 27.7976 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 81.8719 -1540.9318 27.8039 JUMP_CUT

SWITCH_WIDESCREEN ON

GET_PLAYER_CHAR player script_controlled_player

SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 87.4588 -1548.7035
{
TIMERA = 0

WHILE NOT LOCATE_PLAYER_ON_FOOT_2D player 87.4588 -1548.7035 1.0 1.0 0
	WAIT 0
	IF TIMERA > 3000
		GOTO get_out_of_loop_l3
	ENDIF
ENDWHILE
}
get_out_of_loop_l3:

SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 98.7615 -1548.6489

DO_FADE 1000 FADE_OUT

CLEAR_AREA 87.3 -1548.6 28.3 2.0 0

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_CHAR_OBJ_NO_OBJ	script_controlled_player
CHAR_SET_IDLE script_controlled_player
SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 81.2603 -1548.9347
SET_CHAR_OBJ_NO_OBJ	script_controlled_player
CHAR_SET_IDLE script_controlled_player

WAIT 250

SET_PLAYER_COORDINATES player 81.2603 -1548.9347 27.4
SET_PLAYER_HEADING player 90.0
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player ON
SET_CAMERA_IN_FRONT_OF_PLAYER
SET_EVERYONE_IGNORE_PLAYER player OFF
SET_ALL_CARS_CAN_BE_DAMAGED TRUE

DO_FADE 1000 FADE_IN

GOTO mission_love3_passed

// Mission love 3 failed

mission_love3_failed:
PRINT_BIG M_FAIL 5000 1
RETURN

   

// mission love 3 passed

mission_love3_passed:

flag_love_mission3_passed = 1
flag_commercial_passed = 1
COMMERCIAL_PASSED

IF DOES_OBJECT_EXIST subway_gate_suburban1
	DELETE_OBJECT subway_gate_suburban1
ENDIF
IF DOES_OBJECT_EXIST subway_gate_suburban2
	DELETE_OBJECT subway_gate_suburban2
ENDIF
IF DOES_OBJECT_EXIST tunnel_gate_suburban
	DELETE_OBJECT tunnel_gate_suburban
ENDIF

IF DOES_OBJECT_EXIST helix_barrier
	DELETE_OBJECT helix_barrier
ENDIF

SWITCH_ROADS_ON 496.7 75.5 -30.0 484.0 44.2 0.0 //tunnel to suburbia
SWITCH_ROADS_ON -46.8 -648.0 39.0 -69.1 -614.0 50.0 //Commercial to Suburbia Bridge

IF flag_ray_mission5_passed = 1
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT 38.8 -725.4 -100.0 RADAR_SPRITE_RAY ray_contact_blip
	START_NEW_SCRIPT ray_mission6_loop
ENDIF

PRINT_WITH_NUMBER_BIG M_PASS 10000 5000 1
ADD_SCORE player 10000
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	LOVE3
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT love_mission4_loop
START_NEW_SCRIPT hood_phone_start
RETURN
		


// mission cleanup

mission_cleanup_love3:

flag_player_on_mission = 0
flag_player_on_love_mission = 0

CLEAR_ONSCREEN_TIMER plane_timer
CLEAR_ONSCREEN_COUNTER packages_collected
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_SPEEDER
MARK_MODEL_AS_NO_LONGER_NEEDED PLANE_DEADDODO
//SET_TARGET_CAR_FOR_MISSION_GARAGE loves_garage -1
REMOVE_BLIP	players_boat_blip
REMOVE_BLIP	plane_blip
MISSION_HAS_FINISHED
RETURN

MISSION_START
// *****************************************************************************************
// *********************************  Love Mission 4  **************************************
// ********************************* Grand Theft Aero **************************************
// *****************************************************************************************
// *** The real packages are still in the Cessna, which is at the airport. 				 ***
// *** When the player arrives he will see a Palantic Construction vans drive away. 	 ***
// *** As he gets closer there are some Colombians inside the hangar, seeing the player  ***
// *** they will attack. After the player has killed them, he will go into the hangar to ***
// *** find out that the package is not there. The player must go to to the building 	 ***
// *** site. There the player will have to fight his way through the Colombians to 		 ***
// *** Catalina & Miguel and the packages.                                               ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_love4

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_love4_failed
ENDIF

GOSUB mission_cleanup_love4

MISSION_END
 
// Variables for mission

//VAR_INT flag_player_on_love_mission flag_love_mission4_passed// TEST VARS

VAR_INT love_4_blip	goon_in_hangar1_blip goon_in_hangar2_blip goon_in_hangar3_blip goon_in_hangar4_blip																			
VAR_INT van1_driver goon_in_hangar1 goon_in_hangar2 goon_in_hangar3 goon_in_hangar4	ducking_flag
VAR_INT car_van1_lm4 car_van2_lm4 car_van3_lm4 wingless_cessna cs_cat cs_lift lift players_vehicle
VAR_INT deadman1 hangar_route
VAR_INT flag_result_1 reset_timera_flag player_car_l4 cs_whip
VAR_INT goon_at_yard1 goon_at_yard2 goon_at_yard3 goon_at_yard4 goon_at_yard5 goon_at_yard6 goon_at_yard7 goon_at_yard8	goon_at_yard9 goon_at_yard10
VAR_INT yard_route1 yard_route2 yard_route3	game_timer_var c_site_area_flag	colombian_car
VAR_INT	yakuza_car1	yakuza_car2 yakuza_guard1 yakuza_guard2 yakuza_guard3 yakuza_guard4	yakuza_guard5 yakuza_car3
VAR_INT goon_in_hangar1_flag goon_in_hangar2_flag goon_in_hangar3_flag goon_in_hangar4_flag
VAR_INT	goon_in_hangar1_ducking goon_in_hangar2_ducking goon_in_hangar3_ducking goon_in_hangar4_ducking
VAR_INT goon_in_hangar1_waitstate goon_in_hangar2_waitstate goon_in_hangar3_waitstate goon_in_hangar4_waitstate
VAR_INT goon_in_hangar1_blip_flag goon_in_hangar2_blip_flag goon_in_hangar3_blip_flag goon_in_hangar4_blip_flag
VAR_INT goon_at_yard1_flag goon_at_yard1_duck goon_at_yard1_duck_timer
VAR_INT goon_at_yard2_flag goon_at_yard2_duck goon_at_yard2_duck_timer
VAR_INT goon_at_yard3_flag goon_at_yard3_duck goon_at_yard3_duck_timer
VAR_INT goon_at_yard4_flag goon_at_yard4_duck goon_at_yard4_duck_timer
VAR_INT goon_at_yard5_flag break_timer break_timer_start
VAR_INT goon_at_yard6_flag 
VAR_INT goon_at_yard7_duck goon_at_yard7_duck_timer
VAR_INT goon_at_yard8_flag goon_at_yard8_duck goon_at_yard8_duck_timer
VAR_INT goon_at_yard9_flag
VAR_INT goon_at_yard10_flag goon_at_yard10_duck goon_at_yard10_duck_timer

VAR_FLOAT van3_x van3_y van3_z x_component y_component differ_x differ_y distance_result1 distance_result2	sum_difference
VAR_FLOAT temp_result_x temp_result_y result1_x result1_y result2_x result2_y
VAR_FLOAT player_lo4_x player_lo4_y	player_lo4_z temp_var_x temp_var_y

// ****************************************Mission Start************************************

mission_start_love4:

flag_player_on_mission = 1
flag_player_on_love_mission = 1

REGISTER_MISSION_GIVEN

WAIT 0

SCRIPT_NAME love4

flag_result_1 = 0
reset_timera_flag = 0

goon_in_hangar1_flag = -1
goon_in_hangar2_flag = -1
goon_in_hangar3_flag = -1
goon_in_hangar4_flag = -1

goon_in_hangar1_ducking	= -1
goon_in_hangar2_ducking	= -1
goon_in_hangar3_ducking	= -1
goon_in_hangar4_ducking	= -1

goon_in_hangar1_waitstate = 0
goon_in_hangar2_waitstate = 0
goon_in_hangar3_waitstate = 0
goon_in_hangar4_waitstate = 0

goon_at_yard1_flag = 0
goon_at_yard1_duck = 0
goon_at_yard1_duck_timer = 0

goon_at_yard2_flag = 0
goon_at_yard2_duck = 0
goon_at_yard2_duck_timer = 0

goon_at_yard3_flag = 0
goon_at_yard3_duck = 0
goon_at_yard3_duck_timer = 0

goon_at_yard4_flag = 0
goon_at_yard4_duck = 0
goon_at_yard4_duck_timer = 0

goon_at_yard5_flag = 0

goon_at_yard6_flag = 0

goon_at_yard7_duck = 0
goon_at_yard7_duck_timer = 0

goon_at_yard8_flag = 0
goon_at_yard8_duck = 0
goon_at_yard8_duck_timer = 0

goon_at_yard9_flag = 0

goon_at_yard10_flag = 0
goon_at_yard10_duck = 0
goon_at_yard10_duck_timer = 0

goon_in_hangar1_blip_flag = 0
goon_in_hangar2_blip_flag = 0
goon_in_hangar3_blip_flag = 0
goon_in_hangar4_blip_flag = 0

ducking_flag = 0
c_site_area_flag = 0

hangar_route = 0
yard_route1 = 1
yard_route2 = 2
yard_route3 = 3
{
// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 love
REQUEST_MODEL tshrorckgrdn
REQUEST_MODEL tshrorckgrdn_alfas
LOAD_SPECIAL_MODEL cut_obj1 LOVEH

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED tshrorckgrdn_alfas
OR NOT HAS_MODEL_LOADED tshrorckgrdn
OR NOT HAS_MODEL_LOADED cut_obj1
	WAIT 0
ENDWHILE

LOAD_CUTSCENE D4_GTA

SET_CUTSCENE_OFFSET 85.2162 -1532.9093 243.5422

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_love
SET_CUTSCENE_ANIM cs_love love

CREATE_CUTSCENE_HEAD cs_love cut_obj1 cs_lovehead
SET_CUTSCENE_HEAD_ANIM cs_lovehead love

CLEAR_AREA 82.44 -1548.49 28.0 2.0 TRUE

SET_PLAYER_COORDINATES player 82.44 -1548.49 28.0

SET_PLAYER_HEADING player 90.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 765
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_A 10000 1//"Thank you for retrieving those packages, but they were only a decoy."

WHILE cs_time < 4000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_B 10000 1//"Sorry about that, but that's sometimes the way in business."

WHILE cs_time < 6851
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_C 10000 1//"My real objective was hidden on the plane all along."

WHILE cs_time < 9951
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_D 10000 1//"Unfortunately the port authorities seized the plane and were stripping it down"

WHILE cs_time < 13204
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_H 10000 1//"until I intervened at great personal expense."

WHILE cs_time < 16457
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_E 10000 1//"Cross the bridge to and go to Francis International Airport."

WHILE cs_time < 19710
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_F 10000 1//"I've paid off the officials."

WHILE cs_time < 21394
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW LOVE4_G 10000 1//"My property will be waiting for you at the customs hanger in the aircraft's fuselage."

WHILE cs_time < 27666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn
MARK_MODEL_AS_NO_LONGER_NEEDED tshrorckgrdn_alfas

REQUEST_MODEL CAR_PANLANT
REQUEST_MODEL PED_GANG_COLOMBIAN_A
REQUEST_MODEL PLANE_DODO
REQUEST_MODEL CAR_COLUMB

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_PANLANT
OR NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
OR NOT HAS_MODEL_LOADED PLANE_DODO
OR NOT HAS_MODEL_LOADED CAR_COLUMB
	WAIT 0
ENDWHILE

SWITCH_STREAMING ON
DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

ADD_BLIP_FOR_COORD_OLD -1268.4851 -528.6431 9.8341 RED BLIP_ONLY love_4_blip
CHANGE_BLIP_SCALE love_4_blip 3

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	WAIT 0

//	IF IS_BUTTON_PRESSED PAD1 TRIANGLE
//	AND IS_BUTTON_PRESSED PAD1 SQUARE
//	AND IS_BUTTON_PRESSED PAD1 CIRCLE
//		WAIT 500
//		SET_PLAYER_COORDINATES player 338.2069 -274.6978 15.8
//		GOTO second_cutscene
//	ENDIF

ENDWHILE

IF IS_NASTY_GAME
	CREATE_OBJECT_NO_OFFSET deadman1 -1276.834 -528.049 10.568 deadman1//-1276.983 -527.532 9.951 deadman1
ELSE
	CREATE_OBJECT_NO_OFFSET deadmanoblood -1276.834 -528.049 10.568 deadman1//-1276.983 -527.532 9.951 deadman1
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player -1268.4851 -528.6431 200.0 200.0 0
	WAIT 0

ENDWHILE

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	WAIT 0
ENDWHILE

CREATE_CAR CAR_PANLANT -1282.3678 -549.2936 10.0782 car_van1_lm4
SET_CAR_HEADING car_van1_lm4 110.3045

CREATE_CAR CAR_PANLANT -1281.3341 -561.8243 10.0766 car_van3_lm4
SET_CAR_HEADING car_van3_lm4 153.1196

CREATE_CAR PLANE_DODO -1268.2 -519.0 10.0 wingless_cessna
SET_CAR_HEADING wingless_cessna 180.0

REMOVE_BLIP	love_4_blip
ADD_BLIP_FOR_CAR wingless_cessna love_4_blip

CREATE_CHAR_INSIDE_CAR car_van1_lm4 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A van1_driver	

CAR_SET_IDLE car_van1_lm4
CAR_SET_IDLE car_van3_lm4

CAR_SET_IDLE wingless_cessna

SET_CAR_CRUISE_SPEED car_van1_lm4 25.0

SET_CAR_DRIVING_STYLE car_van1_lm4 2

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1271.8468 -511.2291 10.0 goon_in_hangar1	
CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1265.1578 -520.6526 10.0 goon_in_hangar2	
CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1263.0977 -520.3745 10.0 goon_in_hangar3	
CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A -1271.0814 -522.0176 10.0 goon_in_hangar4

SET_CHAR_HEADING goon_in_hangar4 170.5763
TURN_CHAR_TO_FACE_CHAR goon_in_hangar2 goon_in_hangar3
TURN_CHAR_TO_FACE_CHAR goon_in_hangar3 goon_in_hangar2

ADD_ROUTE_POINT hangar_route -1271.8468 -511.2291 9.7954
ADD_ROUTE_POINT hangar_route -1263.3838 -510.6700 9.7954
SET_CHAR_OBJ_FOLLOW_ROUTE goon_in_hangar1 hangar_route FOLLOW_ROUTE_BACKFORWARD

GIVE_WEAPON_TO_CHAR goon_in_hangar1 WEAPONTYPE_CHAINGUN 9999
GIVE_WEAPON_TO_CHAR goon_in_hangar2 WEAPONTYPE_UZI 9999
GIVE_WEAPON_TO_CHAR goon_in_hangar4 WEAPONTYPE_M16 9999

SET_CHAR_THREAT_SEARCH goon_in_hangar1 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH goon_in_hangar2 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH goon_in_hangar3 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH goon_in_hangar4 THREAT_FAST_CAR

IF flag_player_on_mission = 0
	ADD_BLIP_FOR_CHAR goon_in_hangar1 goon_in_hangar1_blip
	ADD_BLIP_FOR_CHAR goon_in_hangar2 goon_in_hangar2_blip
	ADD_BLIP_FOR_CHAR goon_in_hangar3 goon_in_hangar3_blip
	ADD_BLIP_FOR_CHAR goon_in_hangar4 goon_in_hangar4_blip
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player -1281.3341 -561.8243 90.0 90.0 0// CESSNA
	
	WAIT 0

	IF IS_CAR_DEAD wingless_cessna
		PRINT_NOW LOVE4_9 5000 1
		GOTO mission_love4_failed
	ENDIF

	IF IS_CAR_DEAD car_van3_lm4
		PRINT_NOW LOV4_10 5000 1
		GOTO mission_love4_failed
	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD car_van1_lm4
	CAR_GOTO_COORDINATES car_van1_lm4 439.0 -198.0 21.0
ENDIF

IF NOT IS_CHAR_DEAD	goon_in_hangar2
OR NOT IS_CHAR_DEAD	goon_in_hangar3
	SET_CHARS_CHATTING goon_in_hangar2 goon_in_hangar3 1000000
ENDIF

IF NOT IS_CHAR_DEAD	goon_in_hangar4
	SET_CHAR_WAIT_STATE goon_in_hangar4	WAITSTATE_CROSS_ROAD_LOOK 1000000
ENDIF

WHILE NOT IS_CHAR_DEAD goon_in_hangar1
OR NOT IS_CHAR_DEAD	goon_in_hangar2
OR NOT IS_CHAR_DEAD	goon_in_hangar3
OR NOT IS_CHAR_DEAD	goon_in_hangar4

	WAIT 0

	IF IS_CAR_DEAD wingless_cessna
		PRINT_NOW LOVE4_9 5000 1
		GOTO mission_love4_failed
	ENDIF

	IF IS_CAR_DEAD car_van3_lm4
		PRINT_NOW LOV4_10 5000 1
		GOTO mission_love4_failed
	ENDIF

	IF IS_CHAR_DEAD	goon_in_hangar1
		goon_in_hangar1_flag = -100
		goon_in_hangar1_ducking = -100
		REMOVE_BLIP goon_in_hangar1_blip
		GOSUB set_death_flags
	ENDIF

	IF IS_CHAR_DEAD	goon_in_hangar2
		goon_in_hangar2_flag = -100
		goon_in_hangar2_ducking = -100
		REMOVE_BLIP goon_in_hangar2_blip
		GOSUB set_death_flags
	ENDIF

	IF IS_CHAR_DEAD	goon_in_hangar3
		goon_in_hangar3_flag = -100
		goon_in_hangar3_ducking = -100
		REMOVE_BLIP goon_in_hangar3_blip
		GOSUB set_death_flags
	ENDIF

	IF IS_CHAR_DEAD	goon_in_hangar4
		goon_in_hangar4_flag = -100
		goon_in_hangar4_ducking = -100
		REMOVE_BLIP goon_in_hangar4_blip
		GOSUB set_death_flags
	ENDIF

	IF IS_PLAYER_IN_AREA_2D	player -1285.05 -586.535 -1254.959 -542.262 0 //OUT THE FRONT OF THE HANGAR (AREA1)
	AND IS_CAR_ON_SCREEN wingless_cessna
		GOSUB set_death_flags
	ENDIF

	IF IS_PLAYER_IN_AREA_2D player -1290.216 -542.262 -1244.057 -531.793 0 //INSIDE HANGAR (AREA2)
		IF NOT IS_CHAR_DEAD	goon_in_hangar2
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS goon_in_hangar2 player
		ENDIF
		goon_in_hangar2_flag = -100
		goon_in_hangar2_ducking = -100
		GOSUB set_death_flags
	ENDIF

	IF IS_PLAYER_IN_AREA_2D player -1290.216 -531.793 -1244.057 -522.926 0 //INSIDE HANGAR (AREA3)
		IF NOT IS_CHAR_DEAD	goon_in_hangar4
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS goon_in_hangar4 player
		ENDIF
		goon_in_hangar4_flag = -100
		goon_in_hangar4_ducking = -100
		GOSUB set_death_flags
	ENDIF

	IF IS_PLAYER_IN_AREA_2D player -1290.216 -522.926 -1244.057 -496.88 0 //INSIDE HANGAR (AREA4)
		IF NOT IS_CHAR_DEAD	goon_in_hangar1
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS goon_in_hangar1 player
		ENDIF
		goon_in_hangar1_flag = -100
		goon_in_hangar1_ducking = -100
		IF NOT IS_CHAR_DEAD	goon_in_hangar3
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS goon_in_hangar3 player
		ENDIF
		goon_in_hangar3_flag = -100
		goon_in_hangar3_ducking = -100
		GOSUB set_death_flags
	ENDIF

	GOSUB ducking_routine

	IF goon_in_hangar1_ducking > -1
		IF goon_in_hangar1_flag	= 0
			CHAR_SET_IDLE goon_in_hangar1
			SET_CHAR_WAIT_STATE goon_in_hangar1 WAITSTATE_FALSE	100
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar1 -1280.2 -520.1
			goon_in_hangar1_flag = 1
		ENDIF
		IF goon_in_hangar1_flag	= 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar1 -1280.2 -520.1 1.0 1.0 0
				goon_in_hangar1_flag = 2
				goon_in_hangar1_ducking = 1
			ENDIF
		ENDIF
	ENDIF

	IF goon_in_hangar2_ducking > -1
		IF goon_in_hangar2_flag	= 0
			CHAR_SET_IDLE goon_in_hangar2
			SET_CHAR_WAIT_STATE goon_in_hangar2 WAITSTATE_FALSE	100
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar2 -1256.4 -521.3//-1256.4 -520.5
			goon_in_hangar2_flag = 1
		ENDIF
		IF goon_in_hangar2_flag	= 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar2 -1256.4 -521.3 1.0 1.0 0
				goon_in_hangar2_flag = 2
				goon_in_hangar2_ducking = 1
			ENDIF
		ENDIF
	ENDIF

	IF goon_in_hangar3_ducking > -1
		IF goon_in_hangar3_flag	= 0
			CHAR_SET_IDLE goon_in_hangar3
			SET_CHAR_WAIT_STATE goon_in_hangar3 WAITSTATE_FALSE	100
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar3 -1254.4 -521.3
			GIVE_WEAPON_TO_CHAR goon_in_hangar3 WEAPONTYPE_CHAINGUN 9999
			goon_in_hangar3_flag = 1
		ENDIF
		IF goon_in_hangar3_flag	= 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar3 -1254.4 -521.3 1.0 1.0 0
				goon_in_hangar3_flag = 2
				goon_in_hangar3_ducking = 1
			ENDIF
		ENDIF
	ENDIF

	IF goon_in_hangar4_ducking > -1
		IF goon_in_hangar4_flag	= 0
			CHAR_SET_IDLE goon_in_hangar4
			SET_CHAR_WAIT_STATE goon_in_hangar4 WAITSTATE_FALSE	100
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar4 -1280.8 -529.2
			goon_in_hangar4_flag = 1
		ENDIF
		IF goon_in_hangar4_flag	= 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar4 -1280.8 -529.2 1.0 1.0 0
				goon_in_hangar4_flag = 2
				goon_in_hangar4_ducking = 1
			ENDIF
		ENDIF
	ENDIF

ENDWHILE

REMOVE_BLIP goon_in_hangar1_blip
REMOVE_BLIP goon_in_hangar2_blip
REMOVE_BLIP goon_in_hangar3_blip
REMOVE_BLIP goon_in_hangar4_blip
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar1
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar2
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar3
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar4

GET_PLAYER_CHAR player script_controlled_player

PRINT_NOW LOVE4_5 5000 1 //CHECK OUT THE CESSNA

IF IS_CAR_DEAD wingless_cessna
	PRINT_NOW LOVE4_9 5000 1
	GOTO mission_love4_failed
ENDIF

WHILE NOT IS_PLAYER_IN_CAR player wingless_cessna
	
	WAIT 0

	IF IS_CAR_DEAD wingless_cessna
		PRINT_NOW LOVE4_9 5000 1
		GOTO mission_love4_failed
	ENDIF

	IF IS_CAR_DEAD car_van3_lm4
		PRINT_NOW LOV4_10 5000 1
		GOTO mission_love4_failed
	ENDIF

ENDWHILE

WAIT 1000

PRINT_NOW LOVE4_2 3000 1 // "The package is not here"

REMOVE_BLIP love_4_blip

IF IS_CAR_DEAD car_van3_lm4
	PRINT_NOW LOV4_10 5000 1
	GOTO mission_love4_failed
ENDIF

ADD_BLIP_FOR_CAR car_van3_lm4 love_4_blip

WHILE NOT LOCATE_PLAYER_ON_FOOT_CAR_2D player car_van3_lm4 6.0 6.0 0
	
	WAIT 0

	IF IS_CAR_DEAD car_van3_lm4
		PRINT_NOW LOV4_10 5000 1
		GOTO mission_love4_failed
	ENDIF

ENDWHILE

GET_CAR_COORDINATES	car_van3_lm4 van3_x van3_y van3_z

GET_CAR_FORWARD_X car_van3_lm4 x_component
GET_CAR_FORWARD_Y car_van3_lm4 y_component

temp_result_x =	2.8 * y_component  //change both of these to move on the vehicles x axis
temp_result_y =	-2.8 * x_component //

temp_var_x = 0.3 * x_component //change both of these to move on the vehicles y axis
temp_var_y = 0.3 * y_component //

result1_x = temp_result_x - temp_var_x
result1_y = temp_result_y - temp_var_y

result1_x = result1_x + van3_x 
result1_y = result1_y + van3_y

/////////////////

temp_result_x =	-2.8 * y_component //change both of these to move on the vehicles x axis
temp_result_y =	2.8 * x_component  //

temp_var_x = 0.3 * x_component //change both of these to move on the vehicles y axis
temp_var_y = 0.3 * y_component //

result2_x = temp_result_x - temp_var_x
result2_y = temp_result_y - temp_var_y

result2_x = result2_x + van3_x 
result2_y = result2_y + van3_y

van3_z += 0.15

////////////////////////////////////////////////////////////////////////////////

SET_PLAYER_CONTROL player OFF
SWITCH_WIDESCREEN ON

SET_CHAR_OBJ_WAIT_ON_FOOT	script_controlled_player
CHAR_SET_IDLE script_controlled_player

REMOVE_BLIP love_4_blip

GET_PLAYER_COORDINATES player player_lo4_x player_lo4_y	player_lo4_z

differ_x = player_lo4_x - result1_x
differ_y = player_lo4_y - result1_y
differ_x = differ_x * differ_x
differ_y = differ_y * differ_y
sum_difference = differ_x + differ_y
SQRT sum_difference distance_result1

differ_x = player_lo4_x - result2_x
differ_y = player_lo4_y - result2_y
differ_x = differ_x * differ_x
differ_y = differ_y * differ_y
sum_difference = differ_x + differ_y
SQRT sum_difference distance_result2

IF distance_result1	< distance_result2
	flag_result_1 = 1
ELSE
	flag_result_1 = 0
ENDIF

IF flag_result_1 = 1
	SET_FIXED_CAMERA_POSITION result1_x result1_y van3_z 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT result2_x result2_y van3_z INTERPOLATION 
ELSE
	SET_FIXED_CAMERA_POSITION result2_x result2_y van3_z 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT result1_x result1_y van3_z INTERPOLATION 
ENDIF

WAIT 1000

PRINT_NOW LOVE4_3 3000 1 //Construction....yard!

WAIT 2000

RESTORE_CAMERA

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player ON

PRINT LOVE4_7 5000 1 //GET THERE

ADD_BLIP_FOR_COORD 366.939 -328.025 20.268 love_4_blip // CONSTRUCTION SITE

MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar1
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar2
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar3
MARK_CHAR_AS_NO_LONGER_NEEDED goon_in_hangar4
MARK_CHAR_AS_NO_LONGER_NEEDED van1_driver	

MARK_CAR_AS_NO_LONGER_NEEDED car_van1_lm4 
MARK_CAR_AS_NO_LONGER_NEEDED car_van3_lm4

////////////////////////////////////////////////////////////////////////////////

WHILE NOT IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	WAIT 0
ENDWHILE

second_cutscene:

CREATE_CAR CAR_PANLANT 352.8936 -308.3074 15.8 car_van1_lm4
CREATE_CAR CAR_PANLANT 359.3962 -307.2422 15.8 car_van2_lm4
SET_CAR_HEADING	car_van1_lm4 180.6
SET_CAR_HEADING	car_van2_lm4 222.9

CREATE_CAR CAR_COLUMB 346.8934 -298.4600 15.8 colombian_car
SET_CAR_HEADING colombian_car 111.7

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 343.9994 -306.3081 15.8 goon_at_yard1 // area 1 chatting
CLEAR_CHAR_THREAT_SEARCH goon_at_yard1
SET_CHAR_THREAT_SEARCH goon_at_yard1 THREAT_PLAYER1
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard1 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard1 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 341.5678 -306.8592 15.8 goon_at_yard2 // area 1 chatting
CLEAR_CHAR_THREAT_SEARCH goon_at_yard2
SET_CHAR_THREAT_SEARCH goon_at_yard2 THREAT_PLAYER1
TURN_CHAR_TO_FACE_CHAR goon_at_yard2 goon_at_yard1
TURN_CHAR_TO_FACE_CHAR goon_at_yard1 goon_at_yard2
SET_CHARS_CHATTING goon_at_yard2 goon_at_yard1 10000000
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard2 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard2 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 327.7796 -316.6461 15.9 goon_at_yard3 // by concrete area
GIVE_WEAPON_TO_CHAR goon_at_yard3 WEAPONTYPE_CHAINGUN 9999
CLEAR_CHAR_THREAT_SEARCH goon_at_yard3
SET_CHAR_THREAT_SEARCH goon_at_yard3 THREAT_PLAYER1
SET_CHAR_HEADING goon_at_yard3 315.0
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard3 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard3 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 335.0769 -338.2184 15.8 goon_at_yard4 // by pile of wood SW
GIVE_WEAPON_TO_CHAR goon_at_yard4 WEAPONTYPE_CHAINGUN 9999
CLEAR_CHAR_THREAT_SEARCH goon_at_yard4
SET_CHAR_THREAT_SEARCH goon_at_yard4 THREAT_PLAYER1
SET_CHAR_HEADING goon_at_yard4 25.0
SET_CHAR_WAIT_STATE goon_at_yard4 WAITSTATE_CROSS_ROAD_LOOK 10000000 
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard4 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard4 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 348.7184 -320.0932 15.8 goon_at_yard5 // by wooden steps
GIVE_WEAPON_TO_CHAR goon_at_yard5 WEAPONTYPE_CHAINGUN 9999
CLEAR_CHAR_THREAT_SEARCH goon_at_yard5
SET_CHAR_THREAT_SEARCH goon_at_yard5 THREAT_PLAYER1
SET_CHAR_HEADING goon_at_yard5 250.0
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard5 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard5 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 357.1986 -319.7162 15.9 goon_at_yard6 // by concrete steps
GIVE_WEAPON_TO_CHAR goon_at_yard6 WEAPONTYPE_CHAINGUN 9999
CLEAR_CHAR_THREAT_SEARCH goon_at_yard6
SET_CHAR_THREAT_SEARCH goon_at_yard6 THREAT_PLAYER1
SET_CHAR_HEADING goon_at_yard6 250.0
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard6 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard6 FALSE
		   
CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 358.6874 -340.7191 16.0 goon_at_yard7 // behind last box
GIVE_WEAPON_TO_CHAR goon_at_yard7 WEAPONTYPE_CHAINGUN 9999
CLEAR_CHAR_THREAT_SEARCH goon_at_yard7
SET_CHAR_THREAT_SEARCH goon_at_yard7 THREAT_PLAYER1
SET_CHAR_HEADING goon_at_yard7 90.0
SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard7 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard7 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 360.1730 -336.0494 16.0 goon_at_yard8 // by last box
GIVE_WEAPON_TO_CHAR goon_at_yard8 WEAPONTYPE_CHAINGUN 9999
ADD_ROUTE_POINT yard_route3 360.1730 -336.0494 16.0
ADD_ROUTE_POINT yard_route3 372.2496 -335.3521 17.0 
SET_CHAR_OBJ_FOLLOW_ROUTE goon_at_yard8 yard_route3 FOLLOW_ROUTE_BACKFORWARD
CLEAR_CHAR_THREAT_SEARCH goon_at_yard8
SET_CHAR_THREAT_SEARCH goon_at_yard8 THREAT_PLAYER1
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard8 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 374.7956 -340.4126 16.0 goon_at_yard9 // behind lift
GIVE_WEAPON_TO_CHAR goon_at_yard9 WEAPONTYPE_SHOTGUN 9999
ADD_ROUTE_POINT yard_route2 374.7956 -340.4126 16.0
ADD_ROUTE_POINT yard_route2 375.2283 -316.6560 18.3 
SET_CHAR_OBJ_FOLLOW_ROUTE goon_at_yard9 yard_route2 FOLLOW_ROUTE_BACKFORWARD
CLEAR_CHAR_THREAT_SEARCH goon_at_yard9
SET_CHAR_THREAT_SEARCH goon_at_yard9 THREAT_PLAYER1
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard9 FALSE

CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 391.0353 -298.6616 17.2 goon_at_yard10 // on building near maze
GIVE_WEAPON_TO_CHAR goon_at_yard10 WEAPONTYPE_CHAINGUN 9999
ADD_ROUTE_POINT yard_route1 391.0353 -298.6616 17.2
ADD_ROUTE_POINT yard_route1 372.7149 -298.7406 17.2 
SET_CHAR_OBJ_FOLLOW_ROUTE goon_at_yard10 yard_route1 FOLLOW_ROUTE_BACKFORWARD
CLEAR_CHAR_THREAT_SEARCH goon_at_yard10
SET_CHAR_THREAT_SEARCH goon_at_yard10 THREAT_PLAYER1
SET_CHAR_HEED_THREATS goon_at_yard10 TRUE
SET_CHAR_USE_PEDNODE_SEEK goon_at_yard10 FALSE

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player 366.939 -328.025 20.268 1.0 1.0 2.0 1//LIFT

	WAIT 0

	IF c_site_area_flag	= 0
		IF IS_CHAR_DEAD	goon_at_yard1
			c_site_area_flag = 1
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard2
			c_site_area_flag = 1
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard3
			c_site_area_flag = 2
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard4
			c_site_area_flag = 3
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard5
			c_site_area_flag = 5
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard6
			c_site_area_flag = 6
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard7
			c_site_area_flag = 4
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard8
			c_site_area_flag = 4
		ENDIF

		IF IS_CHAR_DEAD	goon_at_yard9
			c_site_area_flag = 5
		ENDIF
	ENDIF

	IF c_site_area_flag	= 0
		IF IS_PLAYER_IN_AREA_2D player 331.8 -303.2 354.5 -280.2 0 // AREA 1
			c_site_area_flag = 1
		ENDIF
	ENDIF

	IF c_site_area_flag	= 1
		IF IS_PLAYER_IN_AREA_2D player 334.4 -314.6 348.2 -303.2 0 // AREA 2
			c_site_area_flag = 2
		ENDIF
	ENDIF

	IF c_site_area_flag	= 2
		IF IS_PLAYER_IN_AREA_2D player 326.4 -327.9 334.4 -303.2 0 // AREA 3
			c_site_area_flag = 3
		ENDIF
	ENDIF

	IF c_site_area_flag	= 3
		IF IS_PLAYER_IN_AREA_2D player 326.4 -341.8 334.4 -327.9 0 // AREA 4
			c_site_area_flag = 4
		ENDIF
	ENDIF

	IF c_site_area_flag	= 4
		IF IS_PLAYER_IN_AREA_2D player 334.4 -341.8 355.9 -314.6 0 // AREA 5
			c_site_area_flag = 5
		ENDIF
	ENDIF

	IF c_site_area_flag	= 5
		IF IS_PLAYER_IN_AREA_2D player 355.9 -341.8 380.3 -314.6 0 // AREA 6
			c_site_area_flag = 6
		ENDIF
	ENDIF

	GET_GAME_TIMER game_timer_var

	GOSUB goon_at_yard1_routine
	GOSUB goon_at_yard2_routine
	GOSUB goon_at_yard3_routine
	GOSUB goon_at_yard4_routine
	GOSUB goon_at_yard5_routine
	GOSUB goon_at_yard6_routine
	GOSUB goon_at_yard7_routine
	GOSUB goon_at_yard8_routine
	GOSUB goon_at_yard9_routine
	GOSUB goon_at_yard10_routine

	IF IS_CHAR_DEAD goon_at_yard1
	AND IS_CHAR_DEAD goon_at_yard2
	AND IS_CHAR_DEAD goon_at_yard3
	AND IS_CHAR_DEAD goon_at_yard4
	AND IS_CHAR_DEAD goon_at_yard5
		IF IS_CHAR_DEAD goon_at_yard6
		AND IS_CHAR_DEAD goon_at_yard7
		AND IS_CHAR_DEAD goon_at_yard8
		AND IS_CHAR_DEAD goon_at_yard9
			
			IF reset_timera_flag = 0
				TIMERA = 0
				reset_timera_flag = 1
			ENDIF
			
			IF TIMERA > 10000
			AND reset_timera_flag = 1
				PRINT_NOW LOVE4_6 10000 1 //GET INTO THE LIFT
				reset_timera_flag = 2
			ENDIF

		ENDIF
	ENDIF

ENDWHILE

REMOVE_BLIP love_4_blip

// ****************************************START OF CUTSCENE********************************

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

GET_GAME_TIMER break_timer_start
break_timer = 0

WHILE NOT CAN_PLAYER_START_MISSION player
AND break_timer < 5000	//	If player is not in control after 5 secs do the cutscene anyway
	WAIT 0
	GET_GAME_TIMER break_timer
	break_timer = break_timer - break_timer_start
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player

LOAD_SPECIAL_CHARACTER 1 cat
LOAD_SPECIAL_CHARACTER 2 miguel
LOAD_SPECIAL_CHARACTER 3 asuka
LOAD_SPECIAL_MODEL cut_obj1 d4props//lift
LOAD_SPECIAL_MODEL cut_obj2 cath
LOAD_SPECIAL_MODEL cut_obj3	asukah
LOAD_SPECIAL_MODEL cut_obj4	miguelh
LOAD_SPECIAL_MODEL cut_obj5	lift
REQUEST_MODEL csitecutscene

SWITCH_STREAMING OFF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED cut_obj5
OR NOT HAS_MODEL_LOADED csitecutscene
	WAIT 0
ENDWHILE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 374.7956 -340.4126 16.0 16.0 scaffoldlift FALSE

LOAD_CUTSCENE D4_GTA2

SET_CUTSCENE_OFFSET 369.02 -327.5 18.46

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_catalina
SET_CUTSCENE_ANIM cs_catalina cat

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT cut_obj1 cs_whip
SET_CUTSCENE_ANIM cs_whip d4props

CREATE_CUTSCENE_OBJECT cut_obj5 cs_lift
SET_CUTSCENE_ANIM cs_lift lift

CREATE_CUTSCENE_HEAD cs_catalina cut_obj2 cs_cathead
SET_CUTSCENE_HEAD_ANIM cs_cathead cat

CREATE_CUTSCENE_HEAD cs_asuka cut_obj3 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

CREATE_CUTSCENE_HEAD cs_miguel cut_obj4 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead miguel

//CREATE_CUTSCENE_OBJECT cut_obj2 cs_loot
//SET_CUTSCENE_ANIM cs_loot cs_loot
//
//CREATE_CUTSCENE_OBJECT cut_obj3 cs_colt1
//SET_CUTSCENE_ANIM cs_colt1 colt1
//
//CREATE_CUTSCENE_OBJECT cut_obj4 cs_colt2
//SET_CUTSCENE_ANIM cs_colt2 colt2
//
//CREATE_CUTSCENE_OBJECT cut_obj5 cs_whip
//SET_CUTSCENE_ANIM cs_whip whip

SET_PLAYER_COORDINATES player 373.7523 -327.2676 17.1950

SET_PLAYER_HEADING player 270.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 15386
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_A 15000 1//Hey, let's get this out of here. God knows what it is

WHILE cs_time < 18600
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_B 15000 1//but he seems to want it badly enough so it must be worth something.

WHILE cs_time < 21318
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_C 15000 1//Who the Heck!

WHILE cs_time < 21933
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

particle_x = 369.02 - 0.0051 
particle_y = -327.5 - 1.2746 
particle_z = 18.46 + 48.3784	

particle_target_x =	369.02 - 0.0489
particle_target_y =	-327.5 - 1.4178
particle_target_z =	18.46 + 48.6197

temp_var = particle_target_x
particle_target_x =	particle_x - temp_var

temp_var = particle_target_y
particle_target_y =	particle_y - temp_var

temp_var = particle_target_z
particle_target_z =	particle_z - temp_var

ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_GUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

WHILE cs_time < 22167
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

particle_x = 369.02 + 0.2698 
particle_y = -327.5 - 1.3691 
particle_z = 18.46 + 48.2923

particle_target_x =	369.02 + 0.1917 
particle_target_y =	-327.5 - 1.5893
particle_target_z =	18.46 + 48.4539

temp_var = particle_target_x
particle_target_x =	particle_x - temp_var

temp_var = particle_target_y
particle_target_y =	particle_y - temp_var

temp_var = particle_target_z
particle_target_z =	particle_z - temp_var

ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_GUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

WHILE cs_time < 22428
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_D 15000 1//YOU!

WHILE cs_time < 23270
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_E 15000 1//Hey take it easy amigo! De nada! De nada!

WHILE cs_time < 26829
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_F 15000 1//I left you pouring your heart out into the gutter!

WHILE cs_time < 29508
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_G 15000 1//Don't shoot amigo. No problem. We all friends. Here, take this.

WHILE cs_time < 33871
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_H 15000 1//Don't be such a pussy!

WHILE cs_time < 35408
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_I 15000 1//We got no choice baby!

WHILE cs_time < 36700
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

particle_x = 369.02 + 2.467 
particle_y = -327.5 - 3.9022 
particle_z = 18.46 + 47.1884

particle_target_x =	369.02 + 2.577 
particle_target_y =	-327.5 - 3.6573
particle_target_z =	18.46 + 47.0965

temp_var = particle_target_x
particle_target_x =	particle_x - temp_var

temp_var = particle_target_y
particle_target_y =	particle_y - temp_var

temp_var = particle_target_z
particle_target_z =	particle_z - temp_var

ADD_MOVING_PARTICLE_EFFECT POBJECT_CATALINAS_GUNFLASH particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 1.0 0 0 0 0

IF IS_NASTY_GAME
	particle_x = 369.02 + 2.4406 
	particle_y = -327.5 - 3.8711 
	particle_z = 18.46 + 47.2215

	particle_target_x =	369.02 + 2.3762 
	particle_target_y =	-327.5 - 4.065
	particle_target_z =	18.46 + 47.3184

	temp_var = particle_target_x
	particle_target_x =	particle_x - temp_var

	temp_var = particle_target_y
	particle_target_y =	particle_y - temp_var

	temp_var = particle_target_z
	particle_target_z =	particle_z - temp_var

	particle_target_x -= particle_x
	particle_target_y -= particle_y
	particle_target_z -= particle_z

	particle_target_x *= 0.05
	particle_target_y *= 0.05
	particle_target_z *= 0.05

	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0
	CREATE_SINGLE_PARTICLE PARTICLE_BLOOD_SMALL particle_x particle_y particle_z particle_target_x particle_target_y particle_target_z 0.0

	CREATE_SINGLE_PARTICLE PARTICLE_TEST particle_x particle_y particle_z 0.0 0.0 0.0 0.2
ENDIF

WHILE cs_time < 37627
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_J 15000 1//We always got a choice you dumb bastard!

WHILE cs_time < 41684
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_K 15000 1//I'm sorry about that crazy bitch man, they all the same…..por favor??

WHILE cs_time < 46468
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_L 15000 1//So the whore got away.

WHILE cs_time < 48918
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_M 15000 1//But you've done me a favour,

WHILE cs_time < 50755
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_N 15000 1//you're not the only one that has a score to settle with the Cartel -

WHILE cs_time < 54352
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_O 15000 1//this worm killed my brother!

WHILE cs_time < 56266
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_P 15000 1//I never killed no Yakuza!

WHILE cs_time < 57299
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_Q 15000 1//LIAR! We all saw the Cartel assassin.

WHILE cs_time < 60721
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_R 15000 1//We are going to hunt down and kill all you Colombian dogs!

WHILE cs_time < 64778
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_S 15000 1//I'll be operating on our friend here to extract information and a little pleasure.

WHILE cs_time < 70710
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_T 15000 1//You, drop by later, I'm sure I'll require your services.

WHILE cs_time < 75150
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GTAB_U 15000 1//Please amigo, don't leave me with her, she psycho chica! Amigo? Hey AMEEEGO!!! …….Aiiieeeeaaargghh!

WHILE cs_time < 86666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE
DO_FADE 0 FADE_OUT

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj5
MARK_MODEL_AS_NO_LONGER_NEEDED csitecutscene

REQUEST_MODEL CAR_YAKUZA
REQUEST_MODEL PED_GANG_YAKUZA_A

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED CAR_YAKUZA
OR NOT HAS_MODEL_LOADED	PED_GANG_YAKUZA_A
	WAIT 0
ENDWHILE

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 374.7956 -340.4126 16.0 16.0 scaffoldlift TRUE

SET_CAMERA_BEHIND_PLAYER

IF DOES_OBJECT_EXIST inside_fence
	DELETE_OBJECT inside_fence
ENDIF

IF DOES_OBJECT_EXIST outside_fence
	DELETE_OBJECT outside_fence
ENDIF

CREATE_OBJECT_NO_OFFSET broken_inside 362.827 -341.362 17.375 inside_fence 
DONT_REMOVE_OBJECT inside_fence
CREATE_OBJECT_NO_OFFSET broken_outside 360.852 -390.891 22.622 outside_fence 
DONT_REMOVE_OBJECT outside_fence

CREATE_CAR CAR_YAKUZA 339.8449 -290.6314 16.0 yakuza_car1 // out front
CREATE_CAR CAR_YAKUZA 359.1079 -291.0880 16.0 yakuza_car2 // out front
CREATE_CAR CAR_YAKUZA 363.6012 -339.1167 16.0 yakuza_car3 // smash fence car
SET_CAR_HEADING yakuza_car1	158.2191
SET_CAR_HEADING yakuza_car2 146.8412	
SET_CAR_HEADING yakuza_car3	339.3615

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 367.3908 -334.2422 16.1 yakuza_guard1
GIVE_WEAPON_TO_CHAR yakuza_guard1 WEAPONTYPE_UZI 300
SET_CHAR_HEED_THREATS yakuza_guard1 TRUE

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 367.6573 -337.8994 16.1 yakuza_guard2
GIVE_WEAPON_TO_CHAR yakuza_guard2 WEAPONTYPE_UZI 300
TURN_CHAR_TO_FACE_CHAR yakuza_guard2 yakuza_guard1
TURN_CHAR_TO_FACE_CHAR yakuza_guard1 yakuza_guard2
SET_CHAR_HEED_THREATS yakuza_guard2 TRUE
SET_CHARS_CHATTING yakuza_guard1 yakuza_guard2 10000000

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 361.8262 -345.2548 16.0 yakuza_guard3
GIVE_WEAPON_TO_CHAR yakuza_guard3 WEAPONTYPE_SHOTGUN 300
SET_CHAR_HEADING yakuza_guard3 170.0
SET_CHAR_HEED_THREATS yakuza_guard3 TRUE

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 335.5756 -295.7485 16.0 yakuza_guard4
GIVE_WEAPON_TO_CHAR yakuza_guard4 WEAPONTYPE_SHOTGUN 300
SET_CHAR_HEADING yakuza_guard4 237.0
SET_CHAR_HEED_THREATS yakuza_guard4 TRUE

CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A 335.8966 -298.0577 16.0 yakuza_guard5
GIVE_WEAPON_TO_CHAR yakuza_guard5 WEAPONTYPE_UZI 300
SET_CHAR_HEADING yakuza_guard5 129.0
SET_CHAR_STAY_IN_SAME_PLACE	yakuza_guard5 TRUE
SET_CHAR_HEED_THREATS yakuza_guard5 TRUE

IF NOT IS_CHAR_DEAD	goon_at_yard1
	EXPLODE_CHAR_HEAD goon_at_yard1	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard2
	EXPLODE_CHAR_HEAD goon_at_yard2	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard3
	EXPLODE_CHAR_HEAD goon_at_yard3	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard4
	EXPLODE_CHAR_HEAD goon_at_yard4
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard5
	EXPLODE_CHAR_HEAD goon_at_yard5	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard6
	EXPLODE_CHAR_HEAD goon_at_yard6	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard7
	EXPLODE_CHAR_HEAD goon_at_yard7	
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard8
	EXPLODE_CHAR_HEAD goon_at_yard8
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard9
	EXPLODE_CHAR_HEAD goon_at_yard9
ENDIF
IF NOT IS_CHAR_DEAD	goon_at_yard10
	EXPLODE_CHAR_HEAD goon_at_yard10
ENDIF

SWITCH_STREAMING ON
DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// ******************************************END OF CUTSCENE********************************

PRINT_NOW LOVE4_4 5000 1 //"Take the package to Love."

IF NOT IS_CAR_DEAD colombian_car
	IF NOT IS_CHAR_DEAD	yakuza_guard5
		SET_CAR_HEALTH colombian_car 2500
		SET_CHAR_OBJ_DESTROY_CAR yakuza_guard5 colombian_car
	ENDIF
ENDIF

ADD_BLIP_FOR_COORD 87.3 -1548.6 27.255 love_4_blip // LOVES PAD

WHILE NOT LOCATE_STOPPED_PLAYER_ON_FOOT_3D player 87.3 -1548.6 28.3 2.0 1.0 2.0 1
	WAIT 0
ENDWHILE

MARK_CAR_AS_NO_LONGER_NEEDED yakuza_car1
MARK_CAR_AS_NO_LONGER_NEEDED yakuza_car2
MARK_CAR_AS_NO_LONGER_NEEDED yakuza_car3
MARK_CAR_AS_NO_LONGER_NEEDED car_van1_lm4
MARK_CAR_AS_NO_LONGER_NEEDED car_van2_lm4
MARK_CAR_AS_NO_LONGER_NEEDED colombian_car
MARK_CHAR_AS_NO_LONGER_NEEDED yakuza_guard1
MARK_CHAR_AS_NO_LONGER_NEEDED yakuza_guard2
MARK_CHAR_AS_NO_LONGER_NEEDED yakuza_guard3
MARK_CHAR_AS_NO_LONGER_NEEDED yakuza_guard4
MARK_CHAR_AS_NO_LONGER_NEEDED yakuza_guard5
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard1
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard2
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard3
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard4
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard5
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard6
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard7
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard8
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard9
MARK_CHAR_AS_NO_LONGER_NEEDED goon_at_yard10

SET_PLAYER_CONTROL player OFF

SET_EVERYONE_IGNORE_PLAYER player ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
CLEAR_WANTED_LEVEL player

SET_FIXED_CAMERA_POSITION 81.3343 -1540.0887 27.7976 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 81.8719 -1540.9318 27.8039 JUMP_CUT

SWITCH_WIDESCREEN ON

GET_PLAYER_CHAR player script_controlled_player

SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 87.4588 -1548.7035

TIMERA = 0

WHILE NOT LOCATE_PLAYER_ON_FOOT_2D player 87.4588 -1548.7035 1.0 1.0 0
	WAIT 0
	IF TIMERA > 3000
		GOTO get_out_of_loop
	ENDIF
ENDWHILE

get_out_of_loop:

SET_CHAR_OBJ_RUN_TO_COORD script_controlled_player 98.7615 -1548.6489

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_AREA 87.3 -1548.6 28.3 2.0 0
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

GOTO mission_love4_passed



// Mission Love 4 failed

mission_love4_failed:
PRINT_BIG M_FAIL 2000 1
RETURN

   

// mission Love 4 passed

mission_love4_passed:

flag_love_mission4_passed = 1

SWITCH_CAR_GENERATOR com_car37 0
SWITCH_CAR_GENERATOR com_car38 0
SWITCH_CAR_GENERATOR gen_car60 101
SWITCH_CAR_GENERATOR gen_car61 101
SWITCH_CAR_GENERATOR gen_car62 101
SWITCH_CAR_GENERATOR gen_car63 101
SWITCH_ROADS_ON -46.8 -648.0 39.0 -69.1 -614.0 50.0 //Commercial to Suburbia Bridge
REMOVE_BLIP	asuka_contact_blip
PRINT_WITH_NUMBER_BIG M_PASS 50000 2000 1
ADD_SCORE player 50000
CLEAR_WANTED_LEVEL player
REGISTER_MISSION_PASSED	LOVE4
SETUP_ZONE_PED_INFO CONSTRU DAY   (30) (0 0 0) 250 0 50 0 20  //Fort staunton
SETUP_ZONE_PED_INFO CONSTRU NIGHT (15) (0 0 0) 300 0 70 0 10
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 366.939 -328.025 20.268 RADAR_SPRITE_ASUKA asuka_contact_blip
START_NEW_SCRIPT asuka_suburban_mission1_loop
START_NEW_SCRIPT love_mission5_loop

RETURN
		


// mission cleanup

mission_cleanup_love4:

REMOVE_BLIP love_4_blip

REMOVE_BLIP goon_in_hangar1_blip
REMOVE_BLIP goon_in_hangar2_blip
REMOVE_BLIP goon_in_hangar3_blip
REMOVE_BLIP goon_in_hangar4_blip

REMOVE_ROUTE hangar_route
REMOVE_ROUTE yard_route1
REMOVE_ROUTE yard_route2
REMOVE_ROUTE yard_route3

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_PANLANT
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED PLANE_DODO
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_YAKUZA
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_OBJECT_AS_NO_LONGER_NEEDED deadman1
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB

//SET_TARGET_CAR_FOR_MISSION_GARAGE loves_garage -1

flag_player_on_mission = 0
flag_player_on_love_mission = 0
MISSION_HAS_FINISHED
RETURN



///////////////////////////////////////////////////////////////////////////////
set_death_flags:

IF goon_in_hangar1_flag = -1
	goon_in_hangar1_flag = 0
ENDIF
IF goon_in_hangar1_ducking = -1
	goon_in_hangar1_ducking = 0
ENDIF

IF goon_in_hangar2_flag = -1
	goon_in_hangar2_flag = 0
ENDIF
IF goon_in_hangar2_ducking = -1
	goon_in_hangar2_ducking = 0
ENDIF

IF goon_in_hangar3_flag = -1
	goon_in_hangar3_flag = 0
ENDIF
IF goon_in_hangar3_ducking = -1
	goon_in_hangar3_ducking = 0
ENDIF

IF goon_in_hangar4_flag = -1
	goon_in_hangar4_flag = 0
ENDIF
IF goon_in_hangar4_ducking = -1
	goon_in_hangar4_ducking = 0
ENDIF

IF goon_in_hangar1_blip_flag = 0
	IF NOT IS_CHAR_DEAD	goon_in_hangar1
		ADD_BLIP_FOR_CHAR goon_in_hangar1 goon_in_hangar1_blip
		PRINT_NOW LOVE4_1 5000 1 //"KILL them all!!"
		goon_in_hangar1_blip_flag = 1
	ENDIF
ENDIF

IF goon_in_hangar2_blip_flag = 0
	IF NOT IS_CHAR_DEAD	goon_in_hangar2
		ADD_BLIP_FOR_CHAR goon_in_hangar2 goon_in_hangar2_blip
		PRINT_NOW LOVE4_1 5000 1 //"KILL them all!!"
		goon_in_hangar2_blip_flag = 1
	ENDIF
ENDIF

IF goon_in_hangar3_blip_flag = 0
	IF NOT IS_CHAR_DEAD	goon_in_hangar3
		ADD_BLIP_FOR_CHAR goon_in_hangar3 goon_in_hangar3_blip
		PRINT_NOW LOVE4_1 5000 1 //"KILL them all!!"
		goon_in_hangar3_blip_flag = 1
	ENDIF
ENDIF

IF goon_in_hangar4_blip_flag = 0
	IF NOT IS_CHAR_DEAD	goon_in_hangar4
		ADD_BLIP_FOR_CHAR goon_in_hangar4 goon_in_hangar4_blip
		PRINT_NOW LOVE4_1 5000 1 //"KILL them all!!"
		goon_in_hangar4_blip_flag = 1
	ENDIF
ENDIF

RETURN
///////////////////////////////////////////////////////////////////////////////

		
///////////////////////////////////////////////////////////////////////////////
ducking_routine:

IF TIMERA > 3000
	IF ducking_flag = 0
		ducking_flag = 1
	ELSE
		ducking_flag = 0
	ENDIF
	TIMERA = 0
ENDIF

IF goon_in_hangar1_ducking = 1
	IF ducking_flag = 0
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar1 -1280.2 -520.1 1.5 1.5 0
			SET_CHAR_WAIT_STATE goon_in_hangar1 WAITSTATE_FALSE	100
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar1 TRUE
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_in_hangar1 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_in_hangar1 player
			ENDIF
			goon_in_hangar1_waitstate = 0
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar1 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar1 -1280.2 -520.1
		ENDIF
	ELSE
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar1 -1280.2 -520.1 1.5 1.5 0
			IF goon_in_hangar1_waitstate = 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar1 TRUE
				SET_CHAR_OBJ_WAIT_ON_FOOT	goon_in_hangar1
				SET_CHAR_WAIT_STATE goon_in_hangar1 WAITSTATE_PLAYANIM_DUCK	3000
				goon_in_hangar1_waitstate = 1
			ENDIF
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar1 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar1 -1280.2 -520.1
		ENDIF
	ENDIF
ENDIF
		
IF goon_in_hangar2_ducking = 1
	IF ducking_flag = 0
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar2 -1256.4 -521.3 1.5 1.5 0
			SET_CHAR_WAIT_STATE goon_in_hangar2 WAITSTATE_FALSE	100
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar2 TRUE
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_in_hangar2 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_in_hangar2 player
			ENDIF
			goon_in_hangar2_waitstate = 0
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar2 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar2 -1256.4 -521.3
		ENDIF
	ELSE
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar2 -1256.4 -521.3 1.5 1.5 0
			IF goon_in_hangar2_waitstate = 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar2 TRUE
				SET_CHAR_OBJ_WAIT_ON_FOOT	goon_in_hangar2
				SET_CHAR_WAIT_STATE goon_in_hangar2 WAITSTATE_PLAYANIM_DUCK	3000
				goon_in_hangar2_waitstate = 1
			ENDIF
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar2 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar2 -1256.4 -521.3
		ENDIF
	ENDIF
ENDIF
		
IF goon_in_hangar3_ducking = 1
	IF ducking_flag = 1
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar3 -1254.4 -521.3 1.5 1.5 0
			SET_CHAR_WAIT_STATE goon_in_hangar3 WAITSTATE_FALSE	100
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar3 TRUE
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_in_hangar3 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_in_hangar3 player
			ENDIF
			goon_in_hangar3_waitstate = 0
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar3 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar3 -1254.4 -521.3
		ENDIF
	ELSE
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar3 -1254.4 -521.3 1.5 1.5 0
			IF goon_in_hangar3_waitstate = 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar3 TRUE
				SET_CHAR_OBJ_WAIT_ON_FOOT	goon_in_hangar3
				SET_CHAR_WAIT_STATE goon_in_hangar3 WAITSTATE_PLAYANIM_DUCK	3000
				goon_in_hangar3_waitstate = 1
			ENDIF
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar3 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar3 -1254.4 -521.3
		ENDIF
	ENDIF
ENDIF
		
IF goon_in_hangar4_ducking = 1
	IF ducking_flag = 1
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar4 -1280.8 -529.2 1.5 1.5 0
			SET_CHAR_WAIT_STATE goon_in_hangar4 WAITSTATE_FALSE	100
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar4 TRUE
			IF IS_PLAYER_IN_ANY_CAR	player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_in_hangar4 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_in_hangar4 player
			ENDIF
			goon_in_hangar4_waitstate = 0
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar4 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar4 -1280.8 -529.2
		ENDIF
	ELSE
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_in_hangar4 -1280.8 -529.2 1.5 1.5 0
			IF goon_in_hangar4_waitstate = 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar4 TRUE
				SET_CHAR_OBJ_WAIT_ON_FOOT	goon_in_hangar4
				SET_CHAR_WAIT_STATE goon_in_hangar4 WAITSTATE_PLAYANIM_DUCK	3000
				goon_in_hangar4_waitstate = 1
			ENDIF
		ELSE
			SET_CHAR_STAY_IN_SAME_PLACE goon_in_hangar4 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_in_hangar4 -1280.8 -529.2
		ENDIF
	ENDIF
ENDIF

RETURN
///////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////
goon_at_yard1_routine:
IF c_site_area_flag > 0
	IF NOT IS_CHAR_DEAD	goon_at_yard1
		IF goon_at_yard1_flag = 0
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard1 FALSE
			SET_CHAR_WAIT_STATE goon_at_yard1 WAITSTATE_FALSE 100
			GIVE_WEAPON_TO_CHAR goon_at_yard1 WEAPONTYPE_M16 9999
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard1 345.0805 -309.6011
			goon_at_yard1_flag = 1
		ENDIF
		IF goon_at_yard1_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard1 345.0805 -309.6011 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard1	345.3315 -313.2216
				goon_at_yard1_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard1_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard1	345.3315 -313.2216 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard1 342.1783 -312.7577
				goon_at_yard1_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard1_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard1	342.1783 -312.7577 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard1 TRUE
				goon_at_yard1_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard1_flag = 4
			IF game_timer_var > goon_at_yard1_duck_timer
				goon_at_yard1_duck_timer = game_timer_var + 3000
				IF goon_at_yard1_duck = 0
					SET_CHAR_WAIT_STATE goon_at_yard1 WAITSTATE_FALSE 100
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard1 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard1 player
					ENDIF
					IF c_site_area_flag = 1
						goon_at_yard1_duck = 1
					ENDIF
				ELSE
					SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard1
					SET_CHAR_WAIT_STATE goon_at_yard1 WAITSTATE_PLAYANIM_DUCK 3000
					goon_at_yard1_duck = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF// IS_CHAR_DEAD goon_at_yard1
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////
goon_at_yard2_routine:
IF c_site_area_flag > 0
	IF NOT IS_CHAR_DEAD	goon_at_yard2
		IF goon_at_yard2_flag = 0
			SET_CHAR_WAIT_STATE goon_at_yard2 WAITSTATE_FALSE 100
			GIVE_WEAPON_TO_CHAR goon_at_yard2 WEAPONTYPE_CHAINGUN 9999
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard2 TRUE
			IF IS_PLAYER_IN_ANY_CAR player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_at_yard2 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard2 player
			ENDIF
			goon_at_yard2_flag = 1
			goon_at_yard2_duck_timer = game_timer_var + 2000
		ENDIF
		IF goon_at_yard2_flag = 1
			IF game_timer_var > goon_at_yard2_duck_timer
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard2 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard2	333.6390 -307.5708
				goon_at_yard2_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard2_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard2	333.6390 -307.5708 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard2 333.4980 -304.7924
				goon_at_yard2_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard2_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard2	333.4980 -304.7924 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard2 TRUE
				goon_at_yard2_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard2_flag = 4
			IF game_timer_var > goon_at_yard2_duck_timer
				goon_at_yard2_duck_timer = game_timer_var + 3000
				IF goon_at_yard2_duck = 0
					SET_CHAR_WAIT_STATE goon_at_yard2 WAITSTATE_FALSE 100
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard2 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard2 player
					ENDIF
					IF c_site_area_flag < 3
						goon_at_yard2_duck = 1
					ENDIF
				ELSE
					SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard2
					SET_CHAR_WAIT_STATE goon_at_yard2 WAITSTATE_PLAYANIM_DUCK 3000
					goon_at_yard2_duck = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF// IS_CHAR_DEAD goon_at_yard2
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////
goon_at_yard3_routine:
IF c_site_area_flag > 1
	IF NOT IS_CHAR_DEAD	goon_at_yard3
		IF goon_at_yard3_flag = 0
			SET_CHAR_WAIT_STATE goon_at_yard3 WAITSTATE_FALSE 100
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard3 TRUE
			IF IS_PLAYER_IN_ANY_CAR player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_at_yard3 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard3 player
			ENDIF
			goon_at_yard3_flag = 1
			goon_at_yard3_duck_timer = game_timer_var + 2000
		ENDIF
		IF goon_at_yard3_flag = 1
			IF game_timer_var > goon_at_yard3_duck_timer
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard3 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard3	331.6994 -329.1375
				goon_at_yard3_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard3_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard3	331.6994 -329.1375 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard3	327.6451 -329.1378
				goon_at_yard3_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard3_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard3	327.6451 -329.1378 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard3 TRUE
				goon_at_yard3_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard3_flag = 4
			IF game_timer_var > goon_at_yard3_duck_timer
				goon_at_yard3_duck_timer = game_timer_var + 3000
				IF goon_at_yard3_duck = 0
					SET_CHAR_WAIT_STATE goon_at_yard3 WAITSTATE_FALSE 100
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard3 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard3 player
					ENDIF
					IF c_site_area_flag < 4
						goon_at_yard3_duck = 1
					ENDIF
				ELSE
					SET_CHAR_OBJ_WAIT_ON_FOOT	goon_at_yard3
					SET_CHAR_WAIT_STATE goon_at_yard3 WAITSTATE_PLAYANIM_DUCK 3000
					goon_at_yard3_duck = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard4_routine:
IF c_site_area_flag > 2
	IF NOT IS_CHAR_DEAD	goon_at_yard4
		IF goon_at_yard4_flag = 0
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard4 TRUE
			SET_CHAR_WAIT_STATE goon_at_yard4 WAITSTATE_FALSE 100
			IF IS_PLAYER_IN_ANY_CAR player
				STORE_CAR_PLAYER_IS_IN player players_vehicle
				SET_CHAR_OBJ_DESTROY_CAR goon_at_yard4 players_vehicle
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard4 player
			ENDIF
			goon_at_yard4_flag = 1
		ENDIF
		IF goon_at_yard4_flag = 1
			IF HAS_CHAR_SPOTTED_PLAYER goon_at_yard4 player
				goon_at_yard4_duck_timer = game_timer_var + 2000
				goon_at_yard4_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard4_flag = 2
			IF game_timer_var > goon_at_yard4_duck_timer
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard4 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard4	338.6765 -329.4054
				goon_at_yard4_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard4_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard4	338.6765 -329.4054 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard4 TRUE
				goon_at_yard4_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard4_flag = 4
			IF game_timer_var > goon_at_yard4_duck_timer
				goon_at_yard4_duck_timer = game_timer_var + 3000
				IF goon_at_yard4_duck = 0
					SET_CHAR_WAIT_STATE goon_at_yard4 WAITSTATE_FALSE 100
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard4 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard4 player
					ENDIF
					IF c_site_area_flag < 5
						goon_at_yard4_duck = 1
					ENDIF
				ELSE
					SET_CHAR_OBJ_WAIT_ON_FOOT	goon_at_yard4
					SET_CHAR_WAIT_STATE goon_at_yard4 WAITSTATE_PLAYANIM_DUCK 3000
					goon_at_yard4_duck = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard5_routine:
IF c_site_area_flag > 3
	IF NOT IS_CHAR_DEAD	goon_at_yard5
		IF goon_at_yard5_flag = 0
			SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard5 FALSE
			SET_CHAR_WAIT_STATE goon_at_yard5 WAITSTATE_FALSE 100
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard5 354.6851 -325.3922
			goon_at_yard5_flag = 1
		ENDIF
		IF goon_at_yard5_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard5 354.6851 -325.3922 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard5 345.9960 -325.4795
				goon_at_yard5_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard5_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard5 345.9960 -325.4795 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard5 341.6781 -327.4943
				goon_at_yard5_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard5_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard5 341.6781 -327.4943 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard5 TRUE
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_vehicle
					SET_CHAR_OBJ_DESTROY_CAR goon_at_yard5 players_vehicle
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard5 player
					goon_at_yard5_flag = 4
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard6_routine:
IF c_site_area_flag > 2
	IF NOT IS_CHAR_DEAD	goon_at_yard6
		IF goon_at_yard6_flag = 0
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard6 FALSE
			SET_CHAR_WAIT_STATE goon_at_yard6 WAITSTATE_FALSE 100
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard6 365.8858 -317.3099
			goon_at_yard6_flag = 1
		ENDIF
		IF goon_at_yard6_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard6 365.8858 -317.3099 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard6 335.6921 -316.2758
				goon_at_yard6_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard6_flag = 2
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard6 335.6921 -316.2758 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard6 TRUE
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_vehicle
					SET_CHAR_OBJ_DESTROY_CAR goon_at_yard6 players_vehicle
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard6 player
					goon_at_yard6_flag = 3
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard7_routine:
IF c_site_area_flag	> 3
	IF NOT IS_CHAR_DEAD	goon_at_yard7
		IF game_timer_var > goon_at_yard7_duck_timer
			SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard7 TRUE
			goon_at_yard7_duck_timer = game_timer_var + 3000
			IF goon_at_yard7_duck = 0
				SET_CHAR_WAIT_STATE goon_at_yard7 WAITSTATE_FALSE 100
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_vehicle
					SET_CHAR_OBJ_DESTROY_CAR goon_at_yard7 players_vehicle
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard7 player
				ENDIF
				IF c_site_area_flag < 6
					goon_at_yard7_duck = 1
				ENDIF
			ELSE
				SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard7
				SET_CHAR_WAIT_STATE goon_at_yard7 WAITSTATE_PLAYANIM_DUCK 3000
				goon_at_yard7_duck = 0
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard8_routine:
IF c_site_area_flag > 3
	IF NOT IS_CHAR_DEAD	goon_at_yard8
		IF goon_at_yard8_flag = 0
			SET_CHAR_OBJ_WAIT_ON_FOOT	goon_at_yard8
			CHAR_SET_IDLE goon_at_yard8
			REMOVE_ROUTE yard_route3
			SET_CHAR_WAIT_STATE goon_at_yard8 WAITSTATE_FALSE 100
			SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard8 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard8 375.4750 -331.2
			goon_at_yard8_flag = 1
		ENDIF
		IF goon_at_yard8_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard8	375.4750 -331.2 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard8 363.7481 -330.9657 //363.9961 -330.8928
				goon_at_yard8_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard8_flag = 2
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard8	363.7481 -330.9657 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard8 TRUE
				goon_at_yard8_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard8_flag = 3
			IF game_timer_var > goon_at_yard8_duck_timer
				goon_at_yard8_duck_timer = game_timer_var + 3000
				IF goon_at_yard8_duck = 0
					SET_CHAR_WAIT_STATE goon_at_yard8 WAITSTATE_FALSE 100
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard8 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard8 player
					ENDIF
					IF c_site_area_flag < 6
						goon_at_yard8_duck = 1
					ENDIF
					IF goon_at_yard8_duck = 0
						GIVE_WEAPON_TO_CHAR goon_at_yard8 WEAPONTYPE_SHOTGUN 9999
					ENDIF
				ELSE
					SET_CHAR_OBJ_WAIT_ON_FOOT	goon_at_yard8
					SET_CHAR_WAIT_STATE goon_at_yard8 WAITSTATE_PLAYANIM_DUCK 3000
					goon_at_yard8_duck = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard9_routine:
IF c_site_area_flag > 3
	IF NOT IS_CHAR_DEAD	goon_at_yard9
		IF goon_at_yard9_flag = 0
			SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard9
			CHAR_SET_IDLE goon_at_yard9
			REMOVE_ROUTE yard_route2
			SET_CHAR_WAIT_STATE goon_at_yard9 WAITSTATE_FALSE 100
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9	374.9931 -311.8263
			goon_at_yard9_flag = 1
		ENDIF
		IF goon_at_yard9_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	374.9931 -311.8263 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9	348.1611 -301.9640
				goon_at_yard9_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard9_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	348.1611 -301.9640 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9 342.9392 -302.6671
				goon_at_yard9_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard9_flag = 3
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	342.9392 -302.6671 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9 327.6495 -317.2610
				goon_at_yard9_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard9_flag = 4
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	327.6495 -317.2610 1.0 1.0 0
				IF c_site_area_flag = 4
					SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 TRUE
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard9 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard9 player
					ENDIF
				ELSE
					SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9 335.2008 -334.9071
					goon_at_yard9_flag = 5
				ENDIF
			ENDIF
		ENDIF
		IF goon_at_yard9_flag = 5
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	335.2008 -334.9071 1.0 1.0 0
				IF c_site_area_flag = 5
					SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 TRUE
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard9 players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard9 player
					ENDIF
				ELSE
					SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard9 360.4199 -337.9403
					goon_at_yard9_flag = 6
				ENDIF
			ENDIF
		ENDIF
		IF goon_at_yard9_flag = 6
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard9	360.4199 -337.9403 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard9 TRUE
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_vehicle
					SET_CHAR_OBJ_DESTROY_CAR goon_at_yard9 players_vehicle
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard9 player
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////
goon_at_yard10_routine:
IF c_site_area_flag > 0
	IF NOT IS_CHAR_DEAD	goon_at_yard10
		IF goon_at_yard10_flag = 0
			SET_CHAR_HEED_THREATS goon_at_yard10 FALSE
			SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard10
			CHAR_SET_IDLE goon_at_yard10
			REMOVE_ROUTE yard_route1
			SET_CHAR_WAIT_STATE goon_at_yard10 WAITSTATE_FALSE 100
			SET_CHAR_STAY_IN_SAME_PLACE goon_at_yard10 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 372.5888 -298.4539
			goon_at_yard10_flag = 1
		ENDIF
		IF goon_at_yard10_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard10 372.5888 -298.4539 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 TRUE
				goon_at_yard10_flag = 2
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 2
			IF c_site_area_flag = 1
				IF game_timer_var > goon_at_yard10_duck_timer
					goon_at_yard10_duck_timer = game_timer_var + 3000
					IF goon_at_yard10_duck = 0
						SET_CHAR_WAIT_STATE goon_at_yard10 WAITSTATE_FALSE 100
						IF IS_PLAYER_IN_ANY_CAR player
							STORE_CAR_PLAYER_IS_IN player players_vehicle
							SET_CHAR_OBJ_DESTROY_CAR goon_at_yard10	players_vehicle
						ELSE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard10 player
						ENDIF
						goon_at_yard10_duck = 1
					ELSE
						SET_CHAR_OBJ_WAIT_ON_FOOT goon_at_yard10
						SET_CHAR_WAIT_STATE goon_at_yard10 WAITSTATE_PLAYANIM_DUCK 3000
						goon_at_yard10_duck = 0
					ENDIF
				ENDIF
			ELSE
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 FALSE
				SET_CHAR_WAIT_STATE goon_at_yard10 WAITSTATE_FALSE 100
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 372.8152 -266.8551
				goon_at_yard10_flag = 3
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 3
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard10 372.8152 -266.8551 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 363.9329 -266.5335
				goon_at_yard10_flag = 4
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 4
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard10 363.9329 -266.5335 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 361.9770 -290.5143
				goon_at_yard10_flag = 5
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 5
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard10 361.9770 -290.5143 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 341.3853 -298.2471
				goon_at_yard10_flag = 6
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 6
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard10 341.3853 -298.2471 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 342.3168 -303.6481
				goon_at_yard10_flag = 7
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 7
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard10 342.3168 -303.6481 1.0 1.0 0
				IF c_site_area_flag = 2
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 TRUE
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard10	players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard10 player
					ENDIF
				ELSE
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 338.2401 -308.2155
					goon_at_yard10_flag = 8
				ENDIF
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 8
			IF LOCATE_CHAR_ON_FOOT_2D goon_at_yard10 338.2401 -308.2155 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 330.4936 -314.1106
				goon_at_yard10_flag = 9
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 9
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard10 330.4936 -314.1106 1.0 1.0 0
				IF c_site_area_flag = 3
				OR c_site_area_flag = 4
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 TRUE
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard10	players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard10 player
					ENDIF
				ELSE
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 334.6789 -338.7348
					goon_at_yard10_flag = 10
				ENDIF
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 10
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard10 334.6789 -338.7348 1.0 1.0 0
				IF c_site_area_flag = 5
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 TRUE
					IF IS_PLAYER_IN_ANY_CAR player
						STORE_CAR_PLAYER_IS_IN player players_vehicle
						SET_CHAR_OBJ_DESTROY_CAR goon_at_yard10	players_vehicle
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard10 player
					ENDIF
				ELSE
					SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD goon_at_yard10 360.2491 -336.6913
					goon_at_yard10_flag = 11
				ENDIF
			ENDIF
		ENDIF
		IF goon_at_yard10_flag = 11
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D goon_at_yard10 360.2491 -336.6913 1.0 1.0 0
				SET_CHAR_STAY_IN_SAME_PLACE	goon_at_yard10 TRUE
				IF IS_PLAYER_IN_ANY_CAR player
					STORE_CAR_PLAYER_IS_IN player players_vehicle
					SET_CHAR_OBJ_DESTROY_CAR goon_at_yard10	players_vehicle
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT goon_at_yard10 player
				ENDIF
			ENDIF
		ENDIF
	ENDIF// IS_CHAR_DEAD goon_at_yard10
ENDIF
RETURN
///////////////////////////////////////////////////////////////////////////////
}

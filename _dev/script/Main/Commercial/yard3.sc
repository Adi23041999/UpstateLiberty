MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************YARDIE MISSION ******************************** 
// *****************************************************************************************
// ***************************************'GANG CAR ROUND_UP'*******************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_yd3
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_yd3_failed
ENDIF
GOSUB mission_cleanup_yd3

MISSION_END
 
// Variables for mission

VAR_INT gangcar_yd3

VAR_INT flag_player_in_diablocar flag_player_in_mafiacar flag_player_in_yakuzacar //flag_player_in_any_gangcar
VAR_INT flag_diablo_delivered_yd3 flag_yakuzacar_delivered_yd3 flag_mafia_delivered_yd3
VAR_INT loop_2_passport
VAR_INT counter_cars_yd3
//VAR_INT garage_yd3
VAR_INT blip_garage_yd3
VAR_INT flag_dam_message flag_garage_message flag_already_boosted_message
VAR_INT flag_messages //flag_gangcar_flipped flag_blip_garage flag_blip_spray

//VAR_FLOAT garage_min_x_yd3 garage_min_y_yd3
//VAR_FLOAT garage_max_x_yd3 garage_max_y_yd3
VAR_FLOAT blip_x_yd3 blip_y_yd3
//VAR_FLOAT gangcar_x gangcar_y gangcar_z


// ****************************************Mission Start************************************

mission_start_yd3:
REGISTER_MISSION_GIVEN
SCRIPT_NAME yard3 
flag_player_on_mission = 1
flag_player_on_yardie_mission = 1

WAIT 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_yd3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

//SWITCH_STREAMING OFF

PRINT_BIG ( YD3 ) 15000 2 //"Yardie Mission 1"	 

TIMERA = 0

WHILE TIMERA < 1500					  
	WAIT 0

ENDWHILE
*/

// ******************************************CUTSCENE***************************************



{

SET_PED_DENSITY_MULTIPLIER 0.0
SET_POLICE_IGNORE_PLAYER player on

//WHILE NOT HAS_MODEL_LOADED cut_obj1
//	WAIT 0

//ENDWHILE

LOAD_CUTSCENE YD_PH3
SET_CUTSCENE_OFFSET 121.0 -272.3 15.25
CLEAR_AREA_OF_CHARS 100.5 -250.0 0.0 130.5 -290.0 25.0
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

//CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
//SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

//SET_PLAYER_HEADING player 180.0

DO_FADE 1500 FADE_IN

START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW ( YD3_A ) 10000 1 

WHILE cs_time < 3700
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_A1 ) 10000 1 

WHILE cs_time < 6370
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_B ) 10000 1 

WHILE cs_time < 8658
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_B1 ) 10000 1 

WHILE cs_time < 10408
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_B2 ) 10000 1 

WHILE cs_time < 13950
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_C ) 10000 1 

WHILE cs_time < 16920
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( YD3_C1 ) 10000 1 
/*

WHILE cs_time < 28919
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( DIAB2_H ) 10000 1 
*/
WHILE cs_time < 20066
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE



DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

SWITCH_STREAMING ON
CLEAR_PRINTS
CLEAR_CUTSCENE
//SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN
SET_PED_DENSITY_MULTIPLIER 1.0
SET_POLICE_IGNORE_PLAYER player off

}


//PRINT_BIG ( YD3 ) 15000 2

WAIT 1000


counter_cars_yd3 = 0
/*

blip_x_yd3 = 1217.0
blip_y_yd3 = -243.5


garage_min_x_yd3 = 1213.0   
garage_min_y_yd3 = -241.0
garage_max_x_yd3 = 1221.0
garage_max_y_yd3 = -245.5

garage_min_x_yd3 = 257.0   
garage_min_y_yd3 = -803.0
garage_max_x_yd3 = 263.0
garage_max_y_yd3 = -795.0*/

blip_x_yd3 = 260.0
blip_y_yd3 = -798.0

loop_2_passport = 0

flag_player_in_diablocar = 0
flag_player_in_mafiacar = 0
flag_player_in_yakuzacar = 0
//flag_player_in_any_gangcar = 0

flag_diablo_delivered_yd3 = 0
flag_yakuzacar_delivered_yd3 = 0
flag_mafia_delivered_yd3 = 0

flag_dam_message = 0
flag_garage_message = 0
flag_already_boosted_message = 0

//flag_gangcar_flipped = 0
flag_messages = 0
//flag_blip_garage = 0
//flag_blip_spray = 0

//PRINT_NOW ( YD3_A ) 4000 1 //"We want you to boost some gang cars so we can do hits on our enemies' turf and set them at each other's throats."
//MESSAGE_WAIT 4000 1
//PRINT_NOW ( YD3_B ) 4000 1 //"We want a Mafia beamer, a Triad van and a Diablo stallion so we can hit any gang in Portland."
//MESSAGE_WAIT 4000 1
//PRINT_NOW ( YD3_C ) 4000 1 //"Drop them off at <location> and remember, they're no use to us wrecked!!"

//SET_GARAGE garage_min_x_yd3 garage_min_y_yd3 26.8 garage_max_x_yd3 garage_max_y_yd3 31.8 GARAGE_MISSION garage_yd3

ADD_BLIP_FOR_COORD blip_x_yd3 blip_y_yd3 -100.0 blip_garage_yd3
 
// Mission stuff goes here


loop_1:

//WHILE counter_cars_yd3 < 3

	WAIT 0
	GOSUB blippage

	IF IS_PLAYER_IN_ANY_CAR player

		IF IS_PLAYER_IN_MODEL player CAR_DIABLOS 
			IF flag_diablo_delivered_yd3 = 0
				STORE_CAR_PLAYER_IS_IN player gangcar_yd3
				SET_CAN_RESPRAY_CAR gangcar_yd3 False
				flag_player_in_diablocar = 1
				flag_player_in_mafiacar = 0
				flag_player_in_yakuzacar = 0
				GOSUB damage_check
			ENDIF
			IF flag_diablo_delivered_yd3 = 1
			AND flag_already_boosted_message = 0
				PRINT_NOW ( YD3_E ) 3000 1 //You've already boosted a diablo gangcar!
				flag_already_boosted_message = 1
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_MODEL player CAR_MAFIA
			IF flag_mafia_delivered_yd3 = 0
				STORE_CAR_PLAYER_IS_IN player gangcar_yd3
				SET_CAN_RESPRAY_CAR gangcar_yd3 False
				flag_player_in_diablocar = 0
				flag_player_in_mafiacar = 1
				flag_player_in_yakuzacar = 0
				GOSUB damage_check
			ENDIF
			IF flag_mafia_delivered_yd3 = 1
			AND flag_already_boosted_message = 0
				PRINT_NOW ( YD3_F ) 3000 1 //You've already boosted a mafia gangcar!
				flag_already_boosted_message = 1
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_MODEL player CAR_YAKUZA
			IF flag_yakuzacar_delivered_yd3 = 0
				STORE_CAR_PLAYER_IS_IN player gangcar_yd3
				SET_CAN_RESPRAY_CAR gangcar_yd3 False
				flag_player_in_diablocar = 0
				flag_player_in_mafiacar = 0
				flag_player_in_yakuzacar = 1
				GOSUB damage_check
			ENDIF

			IF flag_yakuzacar_delivered_yd3 = 1
			AND flag_already_boosted_message = 0
				PRINT_NOW (YD3_G) 3000 1 //You've already boosted a Triad fish van!
				flag_already_boosted_message = 1
			ENDIF
		ENDIF

	ELSE
		flag_dam_message = 0
		flag_garage_message = 0
		flag_already_boosted_message = 0
		//loop_2_passport = 0
	ENDIF

	IF loop_2_passport = 0
		GOTO loop_1
	ENDIF
	
	//flag_messages = 0

loop_2:

	GOSUB damage_check
	IF IS_CAR_IN_MISSION_GARAGE garage_yd3

	//IF IS_CAR_IN_AREA_2D gangcar_yd3 garage_min_x_yd3 garage_min_y_yd3 garage_max_x_yd3 garage_max_y_yd3 false
	//AND NOT IS_PLAYER_IN_AREA_2D player garage_min_x_yd3 garage_min_y_yd3 garage_max_x_yd3 garage_max_y_yd3 false
	//AND IS_CAR_HEALTH_GREATER gangcar_yd3 800

		//GOSUB blippage

		

		IF flag_player_in_diablocar = 1
		AND flag_diablo_delivered_yd3 = 0 
			flag_diablo_delivered_yd3 = 1
			++ counter_cars_yd3
			flag_player_in_diablocar = 0
			//flag_player_in_any_gangcar = 0

			loop_2_passport = 0
			PRINT_NOW (YD3_H) 3000 1 //Diablo gangcar boosted!
			ADD_ONE_OFF_SOUND 260.0 -790.0 28.0 SOUND_PART_MISSION_COMPLETE
		ENDIF

		IF flag_player_in_mafiacar = 1
		AND flag_mafia_delivered_yd3 = 0 
			flag_mafia_delivered_yd3 = 1
			++ counter_cars_yd3
			flag_player_in_mafiacar = 0
			//flag_player_in_any_gangcar = 0
			
			loop_2_passport = 0
			PRINT_NOW (YD3_I) 3000 1 //Mafia gangcar boosted!
			ADD_ONE_OFF_SOUND 260.0 -790.0 28.0 SOUND_PART_MISSION_COMPLETE
		ENDIF

	   	IF flag_player_in_yakuzacar = 1
		AND flag_yakuzacar_delivered_yd3 = 0 
			++ counter_cars_yd3
			flag_yakuzacar_delivered_yd3 = 1
			flag_player_in_yakuzacar = 0
			//flag_player_in_any_gangcar = 0

			loop_2_passport = 0
			PRINT_NOW (YD3_J) 3000 1 //Triad gangcar boosted!
			ADD_ONE_OFF_SOUND 260.0 -790.0 28.0 SOUND_PART_MISSION_COMPLETE
		ENDIF

	ENDIF
	
	IF NOT IS_CAR_DEAD gangcar_yd3
		IF IS_CAR_IN_AREA_2D gangcar_yd3 garage_min_x_yd3 garage_min_y_yd3 garage_max_x_yd3 garage_max_y_yd3 false
		AND NOT IS_PLAYER_IN_AREA_2D player garage_min_x_yd3 garage_min_y_yd3 garage_max_x_yd3 garage_max_y_yd3 false
		AND NOT IS_CAR_HEALTH_GREATER gangcar_yd3 800
			MARK_CAR_AS_NO_LONGER_NEEDED gangcar_yd3
		ENDIF
	ENDIF

	IF counter_cars_yd3 < 3
		GOTO loop_1
	ENDIF

	   		
	GOTO mission_yd3_passed


// Mission Yardie3 failed

mission_yd3_failed:

PRINT_BIG ( M_FAIL ) 2000 1
RETURN

   

// mission yd3 passed

mission_yd3_passed:

flag_yardie_mission3_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED YD3
PLAYER_MADE_PROGRESS 1 
START_NEW_SCRIPT yardie_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_yd3:
REMOVE_BLIP blip_garage_yd3
SET_TARGET_CAR_FOR_MISSION_GARAGE garage_yd3 -1

flag_player_on_mission = 0
flag_player_on_yardie_mission = 0
MISSION_HAS_FINISHED
RETURN
		
// ******************GOSUBS***********************************

blippage:

	IF flag_dam_message = 1

			IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
				REMOVE_BLIP blip_garage_yd3
				ADD_SPRITE_BLIP_FOR_COORD 925.3 -359.2 11.0 RADAR_SPRITE_SPRAY blip_garage_yd3
				//flag_blip_spray = 1
			ENDIF
			IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
				REMOVE_BLIP blip_garage_yd3
				ADD_SPRITE_BLIP_FOR_COORD 380.4 -493.8 26.2 RADAR_SPRITE_SPRAY blip_garage_yd3
				//flag_blip_spray = 1
			ENDIF
			IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
				REMOVE_BLIP blip_garage_yd3
				ADD_SPRITE_BLIP_FOR_COORD -1142.1 34.0 59.0 RADAR_SPRITE_SPRAY blip_garage_yd3
				//flag_blip_spray = 1
			ENDIF

	ELSE
		REMOVE_BLIP blip_garage_yd3
		ADD_BLIP_FOR_COORD blip_x_yd3 blip_y_yd3 -100.0 blip_garage_yd3
	ENDIF

RETURN



damage_check:

	IF IS_PLAYER_IN_ANY_CAR player
		IF NOT IS_CAR_DEAD gangcar_yd3
			IF IS_PLAYER_IN_CAR player gangcar_yd3
				IF IS_CAR_HEALTH_GREATER gangcar_yd3 900
				OR NOT IS_CAR_VISIBLY_DAMAGED gangcar_yd3
					IF flag_garage_message = 0
						PRINT_NOW (YD3_L) 3000 1 //Now take it to the garage!
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_yd3 gangcar_yd3
						flag_garage_message = 1
						flag_dam_message = 0
						loop_2_passport = 1
					ENDIF
				ELSE
					IF flag_dam_message = 0
						PRINT_NOW (YD3_K) 3000 1 //The car's nearly wrecked! Get it repaired!
						SET_TARGET_CAR_FOR_MISSION_GARAGE garage_yd3 -1
						flag_dam_message = 1
						flag_garage_message = 0
						loop_2_passport = 0
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

RETURN

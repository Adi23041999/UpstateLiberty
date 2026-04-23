MISSION_START

{

VAR_FLOAT x_float_m y_float_m z_float_m text_x text_y text_z text_h	player_heading_debug debug_car_heading
VAR_INT magic_car button_press_flag car_colour car_colour2 intro_explosion_flag
VAR_INT flag_create_car initial_create_car initial_car_selected
VAR_INT counter_create_car colour_counter cheat_mode_on_flag cheat_mode_on
VAR_INT button_pressed_warp button_pressed_ind button_pressed_com button_pressed_sub    
VAR_INT repeat_button_press slow_motion	text_button_pressed	players_car_debug
VAR_INT debug_crap_on crap_press_flag no_cars repeat_butt_press
VAR_INT weather_crap add_just_the_once_though invulnerability_on
// VAR_INT debug_cutscene_cars_spawned, debug_cs_bank_car1 debug_cs_bank_car2 debug_cs_bank_car3 debug_cs_bank_car4

// UPSTATE
LVAR_INT ul_cheat_mode_on ul_teleport_no

initial_create_car = 0
counter_create_car = 105 //CAR_CHEETAH
button_pressed_warp = 0 
button_pressed_ind = 0 
button_pressed_com = 0 
button_pressed_sub = 0
cheat_mode_on_flag = 0
cheat_mode_on = 0
weather_crap = 0
add_just_the_once_though = 0
// debug_cutscene_cars_spawned = 0

SCRIPT_NAME debug

SET_DEATHARREST_STATE OFF

mission_start_debug:

WAIT 0

// Upstate debug
IF IS_BUTTON_PRESSED PAD1 SELECT
AND IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
	if ul_cheat_mode_on = 0
		PRINT_NOW CHEATON 2000 1 //CHEAT MODE ON
		ul_cheat_mode_on = 2
	ELSE
		IF ul_cheat_mode_on = 1
			PRINT_NOW CHEATOF 2000 1 //CHEAT MODE OFF
			ul_cheat_mode_on = 3
		ENDIF
	ENDIF
ELSE
	IF ul_cheat_mode_on = 2
		ul_cheat_mode_on = 1
	ELSE
		IF ul_cheat_mode_on = 3
			ul_cheat_mode_on = 0
		ENDIF
	ENDIF
ENDIF

IF ul_cheat_mode_on = 1
	IF IS_PLAYER_PLAYING player
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			IF IS_BUTTON_PRESSED PAD1 DPADLEFT
				ul_teleport_no--
				if ul_teleport_no < 0
					ul_teleport_no = 6
				ENDIF
				GOSUB upstate_debug_teleport
			ENDIF
			IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
				ul_teleport_no++
				if ul_teleport_no > 6
					ul_teleport_no = 0
				ENDIF
				GOSUB upstate_debug_teleport
			ENDIF
		ENDIF
	ENDIF
ENDIF

// IF debug_cutscene_cars_spawned = 0
// 	REQUEST_MODEL CAR_ESPERANTO
// 	REQUEST_MODEL CAR_SECURICAR
// 	REQUEST_MODEL CAR_MRWONGS
// 	LOAD_ALL_MODELS_NOW
// 	debug_cutscene_cars_spawned = 1
// ENDIF
// IF debug_cutscene_cars_spawned = 1
// AND HAS_MODEL_LOADED CAR_ESPERANTO
// AND HAS_MODEL_LOADED CAR_SECURICAR
// AND HAS_MODEL_LOADED CAR_MRWONGS
// 	CREATE_CAR CAR_ESPERANTO 1483.821 1377.729 125.471 debug_cs_bank_car1
// 	SET_CAR_HEADING debug_cs_bank_car1 5.0
// 	CHANGE_CAR_COLOUR debug_cs_bank_car1 52 1
// 	CREATE_CAR CAR_SECURICAR 1483.716 1394.312 125.471 debug_cs_bank_car2
// 	CREATE_CAR CAR_SECURICAR 1483.586 1403.408 125.471 debug_cs_bank_car3
// 	SET_CAR_HEADING debug_cs_bank_car3 -5.0
// 	CREATE_CAR CAR_MRWONGS 1483.613 1476.948 125.471 debug_cs_bank_car4
// 	SET_CAR_HEADING debug_cs_bank_car4 180.0
// 	CHANGE_CAR_COLOUR debug_cs_bank_car4 8 74
// 	debug_cutscene_cars_spawned = 2	
// ENDIF

IF IS_BUTTON_PRESSED PAD2 SQUARE
AND	IS_BUTTON_PRESSED PAD2 TRIANGLE
AND cheat_mode_on_flag = 0
	IF NOT IS_BUTTON_PRESSED PAD2 CROSS
	OR NOT IS_BUTTON_PRESSED PAD2 CIRCLE
	OR NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
	OR NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
	OR NOT IS_BUTTON_PRESSED PAD2 START
	OR NOT IS_BUTTON_PRESSED PAD2 SELECT
		PRINT_NOW CHEATON 2000 1//CHEAT MODE ON
		cheat_mode_on = 1
		cheat_mode_on_flag = 1
	ENDIF
ENDIF

IF NOT IS_BUTTON_PRESSED PAD2 SQUARE
OR NOT IS_BUTTON_PRESSED PAD2 TRIANGLE
	IF cheat_mode_on_flag = 1
		cheat_mode_on_flag = 2
	ENDIF
	IF cheat_mode_on_flag = 3
		cheat_mode_on_flag = 0
	ENDIF
ENDIF

IF IS_BUTTON_PRESSED PAD2 SQUARE
AND	IS_BUTTON_PRESSED PAD2 TRIANGLE
AND cheat_mode_on_flag = 2
	PRINT_NOW CHEATOF 2000 1//CHEAT MODE OFF
	cheat_mode_on = 0
	cheat_mode_on_flag = 3
ENDIF

IF IS_PLAYER_PLAYING player
	IF IS_BUTTON_PRESSED PAD2 START
	AND invulnerability_on = 0
		GET_PLAYER_CHAR player script_controlled_player
		SET_CHAR_PROOFS script_controlled_player TRUE TRUE TRUE TRUE TRUE
		invulnerability_on = 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 START
	AND invulnerability_on = 2
		GET_PLAYER_CHAR player script_controlled_player
		SET_CHAR_PROOFS script_controlled_player FALSE FALSE FALSE FALSE FALSE
		invulnerability_on = 3
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 START
		IF invulnerability_on = 1
			invulnerability_on = 2
		ENDIF
		IF invulnerability_on = 3
			invulnerability_on = 0
		ENDIF
	ENDIF
ENDIF

	IF IS_BUTTON_PRESSED PAD2 TRIANGLE
	AND debug_crap_on = FALSE
	AND crap_press_flag = 0
		DEBUG_ON
		debug_crap_on = TRUE
		crap_press_flag = 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 TRIANGLE
	AND debug_crap_on = TRUE
	AND crap_press_flag = 0
		DEBUG_OFF
		debug_crap_on = FALSE
		crap_press_flag = 1
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 TRIANGLE
	AND crap_press_flag = 1
		crap_press_flag = 0
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 CROSS
	AND IS_BUTTON_PRESSED PAD2 SQUARE
		IF IS_PLAYER_PLAYING Player
			IF NOT IS_PLAYER_IN_ANY_CAR player
				EXPLODE_PLAYER_HEAD Player
			ELSE
				GET_PLAYER_COORDINATES player text_x text_y text_z
				ADD_EXPLOSION text_x text_y text_z EXPLOSION_CAR
				ADD_EXPLOSION text_x text_y text_z EXPLOSION_CAR
				ADD_EXPLOSION text_x text_y text_z EXPLOSION_CAR
			ENDIF
			WAIT 1000
		ENDIF
	ENDIF

	IF cheat_mode_on = 0
	AND IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		IF IS_PLAYER_PLAYING player
			weather_crap ++
			IF weather_crap > 5
				weather_crap = 1	   
			ENDIF

			IF weather_crap = 1
				FORCE_WEATHER_NOW WEATHER_SUNNY
				PRINT_NOW ( WEATHER ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 2
				FORCE_WEATHER_NOW WEATHER_CLOUDY
				PRINT_NOW ( WEATHER ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 3
				FORCE_WEATHER_NOW WEATHER_RAINY
				PRINT_NOW ( WEATHER ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 4
				FORCE_WEATHER_NOW WEATHER_FOGGY
				PRINT_NOW ( WEATHER ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 5
				RELEASE_WEATHER 
				PRINT_NOW ( WEATHE2 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF
			
		ENDIF
	ENDIF


IF cheat_mode_on = 1
AND cheat_mode_on_flag = 2

	IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
	AND repeat_button_press = 0
	AND slow_motion = 0
//		IF IS_PLAYER_IN_ANY_CAR player
//			STORE_CAR_PLAYER_IS_IN_NO_SAVE player players_car_debug
//			SET_CAR_BIG_WHEELS players_car_debug TRUE
			SET_TIME_SCALE 0.0
			slow_motion = 1
			repeat_button_press = 1
//		ENDIF
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
	AND repeat_button_press = 0
	AND slow_motion = 1
//		IF IS_PLAYER_IN_ANY_CAR player
//			STORE_CAR_PLAYER_IS_IN_NO_SAVE player players_car_debug
//			SET_CAR_BIG_WHEELS players_car_debug FALSE
			SET_TIME_SCALE 1.0
			slow_motion = 0
			repeat_button_press = 1
//		ENDIF
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
		IF repeat_button_press = 1
			repeat_button_press = 0
		ENDIF
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 SELECT
	AND repeat_butt_press = 0
	AND no_cars = 0
		SET_CAR_DENSITY_MULTIPLIER 0.0
		PRINT_NOW CARSOFF 2000 1
		no_cars = 1
		repeat_butt_press = 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 SELECT
	AND repeat_butt_press = 0
	AND no_cars = 1
		SET_CAR_DENSITY_MULTIPLIER 1.0
		PRINT_NOW CARS_ON 2000 1
		no_cars = 0
		repeat_butt_press = 1
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 SELECT
		IF repeat_butt_press = 1
			repeat_butt_press = 0
		ENDIF
	ENDIF
ENDIF

IF IS_PLAYER_PLAYING player	//ENDIF AT THE BOTTOM OF THE SCRIPT

	IF cheat_mode_on = 1
	AND cheat_mode_on_flag = 2
		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		AND text_button_pressed = 0
			GET_PLAYER_COORDINATES player text_x text_y text_z
			GET_GROUND_Z_FOR_3D_COORD text_x text_y text_z text_z
			GET_PLAYER_HEADING player text_h
			SAVE_FLOAT_TO_DEBUG_FILE text_x
			SAVE_FLOAT_TO_DEBUG_FILE text_y
			SAVE_FLOAT_TO_DEBUG_FILE text_z
			SAVE_FLOAT_TO_DEBUG_FILE text_h
			SAVE_NEWLINE_TO_DEBUG_FILE
			PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
			text_button_pressed = 1
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		AND text_button_pressed = 1
			text_button_pressed = 0
		ENDIF

		IF IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND flag_create_car = 0
		AND button_press_flag = 0
			GET_PLAYER_COORDINATES player x_float_m y_float_m z_float_m
			GET_PLAYER_HEADING player player_heading_debug
			IF player_heading_debug < 45.0
			AND player_heading_debug > 0.0
				y_float_m += 5.0
				debug_car_heading = 90.0
			ENDIF
			IF player_heading_debug < 360.0
			AND player_heading_debug > 315.0
				y_float_m += 5.0
				debug_car_heading = 90.0
			ENDIF
			IF player_heading_debug < 135.0
			AND player_heading_debug > 45.0
				x_float_m -= 5.0
				debug_car_heading = 180.0
			ENDIF
			IF player_heading_debug < 225.0
			AND player_heading_debug > 135.0
				y_float_m -= 5.0
				debug_car_heading = 270.0
			ENDIF
			IF player_heading_debug < 315.0
			AND player_heading_debug > 225.0
				x_float_m += 5.0
				debug_car_heading = 0.0
			ENDIF
			z_float_m = z_float_m + 0.6
			GET_GROUND_Z_FOR_3D_COORD x_float_m y_float_m z_float_m	z_float_m
			REQUEST_MODEL counter_create_car
			WHILE NOT HAS_MODEL_LOADED counter_create_car
				WAIT 0
				
				PRINT_NOW LOADCAR 100 1 //"Loading vehicle, press pad2 leftshoulder1 to cancel"
				
				IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
					//++ counter_create_car
					GOTO next_carzzz
				ENDIF
			
			ENDWHILE
			
			CREATE_CAR counter_create_car x_float_m y_float_m z_float_m magic_car
			SET_CAR_HEADING	magic_car debug_car_heading
			
			LOCK_CAR_DOORS magic_car CARLOCK_UNLOCKED

			MARK_MODEL_AS_NO_LONGER_NEEDED counter_create_car
			MARK_CAR_AS_NO_LONGER_NEEDED magic_car

			next_carzzz:
			IF initial_create_car = 0
				
				//IF counter_create_car = 90	
				//AND initial_car_selected = 0
					//counter_create_car = 91
					//initial_car_selected = 1
					//initial_create_car = 1
				//ENDIF
				
				IF counter_create_car = 105
				AND initial_car_selected = 0
					counter_create_car = 110 //CAR_TAXI
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 110	
				AND initial_car_selected = 0
					counter_create_car = 128 //CAR_CABBIE
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 128	
				AND initial_car_selected = 0
					counter_create_car = 116 //CAR_POLICE
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 116	
				AND initial_car_selected = 0
					counter_create_car = 97	//CAR_FIRETRUCK
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 97 
				AND initial_car_selected = 0
					counter_create_car = 106 //CAR_AMBULANCE
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 106	
				AND initial_car_selected = 0
					counter_create_car = 119 //CAR_BANSHEE
					initial_car_selected = 1
				ENDIF
			
				IF counter_create_car = 119	
				AND initial_car_selected = 0
					counter_create_car = 101 //CAR_INFERNUS
					initial_car_selected = 1
					initial_create_car = 1
				ENDIF
			
				IF counter_create_car = 101	
				AND initial_car_selected = 0
					counter_create_car = 92 //CAR_STINGER
					initial_car_selected = 1
					initial_create_car = 1
				ENDIF
						
			ELSE
				++ counter_create_car
			
				IF counter_create_car > 150
					counter_create_car = 90
					//initial_create_car = 0
				ENDIF
			
				IF counter_create_car =	140	//PLANE_AIRTRAIN
				OR counter_create_car = 141	//PLANE_DEADDODO
					counter_create_car = 142
				ENDIF
			
				IF counter_create_car =	124	//TRAIN_SUBWAY
				OR counter_create_car = 125	//HELI_POLICE
					counter_create_car = 126
				ENDIF
						
				IF counter_create_car = 131 //CAR_RCBANDIT 
					counter_create_car = 132
				ENDIF

				IF counter_create_car = 147 //HELI
					counter_create_car = 148
				ENDIF

			ENDIF
			flag_create_car = 1
			button_press_flag = 1
		ENDIF

//		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
//		AND flag_create_car = 1
//			IF NOT IS_CAR_DEAD magic_car
//				GENERATE_RANDOM_INT_IN_RANGE 0 88 car_colour2
//				CHANGE_CAR_COLOUR magic_car car_colour car_colour2 // 0 - 88
//				++car_colour
//				IF car_colour > 87
//					car_colour = 0
//				ENDIF
//			ENDIF
//		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND button_press_flag = 1
			button_press_flag = 0
		ENDIF

		IF IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND flag_create_car = 1
		AND button_press_flag = 0
			IF IS_CAR_DEAD magic_car
				DELETE_CAR magic_car
			ELSE
				IF NOT IS_PLAYER_IN_CAR player magic_car
					DELETE_CAR magic_car
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED magic_car
				ENDIF
			ENDIF 
			flag_create_car = 0
			initial_car_selected = 0
			button_press_flag = 1
		ENDIF
	ENDIF

// Industrial mission jump stuff


//WARP PLAYER
//IF flag_player_on_mission = 0
	IF IS_BUTTON_PRESSED PAD2 DPADUP
		IF IS_PLAYER_PLAYING player
			button_pressed_warp ++
			IF button_pressed_warp > 14
				button_pressed_warp = 0
				//SWAP BRIDGE FROM FIXED TO DAMAGED
				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgcabls01 nbbridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgcabls01 nbbridgfk2
				SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 nbbridgerdb damgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 nbbridgerdb damgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 nbbridgerda damgbbridgerda	
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 nbbridgerda damgbbridgerda	

				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgcabls01 lodridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgcabls01 lodridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodridgerdb lodgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodridgerdb lodgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodridgerda lodgbbridgerda	
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodridgerda lodgbbridgerda	   
			ENDIF

			IF button_pressed_warp = 1  //8ball
				SET_PLAYER_COORDINATES player 811.90 -939.95 -100.0
				//flag_industrial_passed = 0
				//flag_commercial_passed = 0
				WAIT 300 
			ENDIF

			IF button_pressed_warp = 2  //Luigi
				SET_PLAYER_COORDINATES player 905.2 -425.4 13.9
				WAIT 300  
			ENDIF
				
			IF button_pressed_warp = 3  //Joey
				SET_PLAYER_COORDINATES player 1193.0 -872.0 13.9 
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 4  //Toni
				SET_PLAYER_COORDINATES player 1203.0 -320.0 23.9 
				WAIT 300
			ENDIF
				
			IF button_pressed_warp = 5  //Frankie
				SET_PLAYER_COORDINATES player 1453.0 -193.0 54.5
				WAIT 300
			ENDIF
		   
			IF button_pressed_warp = 6  //Diablo  
				SET_PLAYER_COORDINATES player 938.6 -235.3 -100.0
				WAIT 300 
			ENDIF
				
			IF button_pressed_warp = 7  //Asuka
				SET_PLAYER_COORDINATES player 531.5 -648.7 -100.0
				//SWAP BRIDGE FROM DAMAGED TO FIXED
				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgfk2	nbbridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgfk2	nbbridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 damgbridgerdb nbbridgerdb
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 damgbridgerdb nbbridgerdb
				SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 damgbbridgerda	nbbridgerda
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 damgbbridgerda	nbbridgerda

				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgfk2	lodridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgfk2	lodridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodgbridgerdb lodridgerdb
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodgbridgerdb lodridgerdb
				SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodgbbridgerda	lodridgerda
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodgbbridgerda	lodridgerda
				IF add_just_the_once_though = 0
					ADD_HOSPITAL_RESTART 183.5 -17.8 16.2 180.0
					ADD_POLICE_RESTART 340.3 -1123.4 25.0 180.0
					ADD_HOSPITAL_RESTART -1253.0 -138.2 57.8 90.0
					ADD_POLICE_RESTART -1259.5 -44.5 57.8 90.0
					SET_MAX_WANTED_LEVEL 6
					add_just_the_once_though = 1
				ENDIF

				//flag_industrial_passed = 1
				//flag_commercial_passed = 0
				WAIT 300
			ENDIF
				
			IF button_pressed_warp = 8  //Kenji
				SET_PLAYER_COORDINATES player 458.8 -1424.6 26.1 
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 9  //Ray
				SET_PLAYER_COORDINATES player 48.6 -724.0 24.9  
				WAIT 300
			ENDIF
				
			IF button_pressed_warp = 10  //Love
				SET_PLAYER_COORDINATES player 78.9 -1548.4 28.2  
				WAIT 300
			ENDIF
				
			IF button_pressed_warp = 11  //Yardie
				SET_PLAYER_COORDINATES player 118.3 -272.6 -100.0  
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 12  //Asuka2
				SET_PLAYER_COORDINATES player 367.9 -331.2 -100.0
				//flag_industrial_passed = 1
				//flag_commercial_passed = 1
				WAIT 300
			ENDIF
				
			IF button_pressed_warp = 13  //Hoods
				SET_PLAYER_COORDINATES player -443.0 -8.9 2.8
				WAIT 300
			ENDIF
								
			IF button_pressed_warp = 14  //CAT
				SET_PLAYER_COORDINATES player -364.7 240.7 -100.0 
				button_pressed_warp = 0
				WAIT 300 
			ENDIF 
	   ENDIF
	ENDIF	  


//WARP PLAYER
//IF flag_player_on_mission = 0
	IF IS_BUTTON_PRESSED PAD2 DPADDOWN
		IF IS_PLAYER_PLAYING player
			IF button_pressed_warp = 0
				button_pressed_warp = 14
				GOTO start_mission_warp
			ENDIF

			button_pressed_warp --

start_mission_warp:

			IF button_pressed_warp = 1  //8ball
				SET_PLAYER_COORDINATES player 811.90 -939.95 -100.0
				WAIT 300 					  
			ENDIF

			IF button_pressed_warp = 2  //Luigi
				SET_PLAYER_COORDINATES player 905.2 -425.4 13.9
				WAIT 300  
			ENDIF
			
			IF button_pressed_warp = 3  //Joey
				SET_PLAYER_COORDINATES player 1193.0 -872.0 13.9 
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 4  //Toni
				SET_PLAYER_COORDINATES player 1203.0 -320.0 23.9 
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 5  //Frankie
				SET_PLAYER_COORDINATES player 1453.0 -193.0 54.5
				WAIT 300
			ENDIF
		   
			IF button_pressed_warp = 6  //Diablo  
				SET_PLAYER_COORDINATES player 938.6 -235.3 -100.0
				//SWAP BRIDGE FROM FIXED TO DAMAGED
				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgcabls01 nbbridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgcabls01 nbbridgfk2
				SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 nbbridgerdb damgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 nbbridgerdb damgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 nbbridgerda damgbbridgerda	
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 nbbridgerda damgbbridgerda	

				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgcabls01 lodridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgcabls01 lodridgfk2	
				SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodridgerdb lodgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodridgerdb lodgbridgerdb 
				SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodridgerda lodgbbridgerda	
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodridgerda lodgbbridgerda
				IF add_just_the_once_though = 0
					ADD_HOSPITAL_RESTART 183.5 -17.8 16.2 180.0
					ADD_POLICE_RESTART 340.3 -1123.4 25.0 180.0
					ADD_HOSPITAL_RESTART -1253.0 -138.2 57.8 90.0
					ADD_POLICE_RESTART -1259.5 -44.5 57.8 90.0
					SET_MAX_WANTED_LEVEL 6
					add_just_the_once_though = 1
				ENDIF

				//flag_industrial_passed = 0
				//flag_commercial_passed = 0
				WAIT 300 
			ENDIF
			
			IF button_pressed_warp = 7  //Asuka
				SET_PLAYER_COORDINATES player 531.5 -648.7 -100.0
				//flag_industrial_passed = 1
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 8  //Kenji
				SET_PLAYER_COORDINATES player 458.8 -1424.6 26.1 
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 9  //Ray
				SET_PLAYER_COORDINATES player 48.6 -724.0 24.9  
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 10  //Love
				SET_PLAYER_COORDINATES player 78.9 -1548.4 28.2  
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 11  //Yardie
				SET_PLAYER_COORDINATES player 118.3 -272.6 -100.0
				//flag_industrial_passed = 1
				//flag_commercial_passed = 0
				WAIT 300
			ENDIF
			
			IF button_pressed_warp = 12  //Asuka2
				SET_PLAYER_COORDINATES player 367.9 -331.2 -100.0
				WAIT 300
			ENDIF

			IF button_pressed_warp = 13  //Hoods
				SET_PLAYER_COORDINATES player -443.0 -6.6 2.8
				WAIT 300
			ENDIF
							
			IF button_pressed_warp = 14  //CAT
				SET_PLAYER_COORDINATES player -364.7 240.7 -100.0
				//SWAP BRIDGE FROM DAMAGED TO FIXED
				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgfk2	nbbridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgfk2	nbbridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 damgbridgerdb nbbridgerdb
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 damgbridgerdb nbbridgerdb
				SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 damgbbridgerda	nbbridgerda
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 damgbbridgerda	nbbridgerda

				SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgfk2	lodridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgfk2	lodridgcabls01
				SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodgbridgerdb lodridgerdb
				SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodgbridgerdb lodridgerdb
				SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodgbbridgerda	lodridgerda
				SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodgbbridgerda	lodridgerda
				IF add_just_the_once_though = 0
					ADD_HOSPITAL_RESTART 183.5 -17.8 16.2 180.0
					ADD_POLICE_RESTART 340.3 -1123.4 25.0 180.0
					ADD_HOSPITAL_RESTART -1253.0 -138.2 57.8 90.0
					ADD_POLICE_RESTART -1259.5 -44.5 57.8 90.0
					SET_MAX_WANTED_LEVEL 6
					add_just_the_once_though = 1
				ENDIF
				//flag_industrial_passed = 1
				//flag_commercial_passed = 1
				WAIT 300 
			ENDIF 
		ENDIF
	ENDIF


//INDUSTRIAL MISSION SKIP RIGHT
	IF flag_player_on_mission = 0
		IF IS_BUTTON_PRESSED PAD2 DPADRIGHT
			IF IS_PLAYER_PLAYING player
				IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
					flag_industrial_passed = 0 // UPSTATE: Fix debug not working due to passed islands
					button_pressed_ind ++
					IF button_pressed_ind > 29
						flag_meat_mission4_passed = 1
						WAIT 300
						//flag_eightball_mission_passed = 0
						flag_luigi_mission2_passed = 0
						flag_luigi_mission3_passed = 0
						flag_luigi_mission4_passed = 0
						flag_luigi_mission5_passed = 0
						flag_joey_mission1_passed = 0
						flag_joey_mission2_passed = 0
						flag_joey_mission3_passed = 0
						flag_joey_mission4_passed = 0
						flag_joey_mission5_passed = 0
						flag_joey_mission6_passed = 0
						flag_toni_mission1_passed = 0
						flag_toni_mission2_passed = 0
						flag_toni_mission3_passed = 0
						flag_toni_mission4_passed = 0
						flag_toni_mission5_passed = 0
						flag_frankie_mission1_passed = 0
						flag_frankie_mission2_passed = 0
						flag_frankie_mission2.1_passed = 0
						flag_frankie_mission3_passed = 0
						flag_frankie_mission4_passed = 0
						flag_diablo_mission1_passed = 0
						flag_diablo_mission2_passed = 0
						flag_diablo_mission3_passed = 0
						flag_diablo_mission4_passed = 0
						flag_meat_mission1_passed = 0
						flag_meat_mission2_passed = 0
						flag_meat_mission3_passed = 0
						flag_meat_mission4_passed = 0
						button_pressed_ind = 1	   
					ENDIF
					
		  			IF button_pressed_ind = 1
						flag_eightball_mission_passed = 1
						PRINT_BIG ( EBAL ) 1000 4 //"Eightball Mission 1"
						WAIT 300
			  			flag_eightball_mission_passed = 0
			  			START_NEW_SCRIPT eightball_mission_loop // TEST STUFF
						PRINT_NOW ( LUIGI ) 2000 1
					ENDIF
					
					IF button_pressed_ind = 2
						flag_luigi_mission2_passed = 1
						PRINT_BIG ( LM2 ) 1000 4 //"luigi Mission 2"
						WAIT 300
						flag_luigi_mission2_passed = 0
						START_NEW_SCRIPT luigi_mission2_loop // TEST STUFF
						flag_eightball_mission_passed = 1   
						REMOVE_BLIP	luigi_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 892.8 -425.8 13.9 RADAR_SPRITE_LUIGI luigi_contact_blip
					ENDIF

					IF button_pressed_ind = 3
						flag_luigi_mission3_passed = 1
						PRINT_BIG ( LM3 ) 1000 4 //"luigi Mission 3"
						WAIT 300
						flag_luigi_mission3_passed = 0
						START_NEW_SCRIPT luigi_mission3_loop // TEST STUFF
						flag_luigi_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 4
						flag_luigi_mission4_passed = 1
						PRINT_BIG ( LM4 ) 1000 4 //"luigi Mission 4"
						WAIT 300
						flag_luigi_mission4_passed = 0
						START_NEW_SCRIPT luigi_mission4_loop // TEST STUFF
						flag_luigi_mission3_passed = 1
					ENDIF

					IF button_pressed_ind = 5
						flag_luigi_mission5_passed = 1
						PRINT_BIG ( LM5 ) 1000 4 //"luigi Mission 5"
						WAIT 300
						flag_luigi_mission5_passed = 0
						START_NEW_SCRIPT luigi_mission5_loop // TEST STUFF
						flag_luigi_mission4_passed = 1
					ENDIF
		   
					IF button_pressed_ind = 6
						flag_joey_mission1_passed = 1
						PRINT_BIG ( JM1 ) 1000 4 //"joey Mission 1"
						PRINT_NOW ( JOEY ) 2000 1
						WAIT 300
						flag_joey_mission1_passed = 0
						START_NEW_SCRIPT joey_mission1_loop // TEST STUFF
						flag_luigi_mission5_passed = 1
						REMOVE_BLIP luigi_contact_blip  //REMOVE LUIGIS BLIP
						REMOVE_BLIP	joey_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1191.7 -870.0 -100.0 RADAR_SPRITE_JOEY joey_contact_blip
					ENDIF

					IF button_pressed_ind = 7
						flag_joey_mission2_passed = 1
						PRINT_BIG ( JM2 ) 1000 4 //"joey Mission 2"
						WAIT 300
						flag_joey_mission2_passed = 0
						START_NEW_SCRIPT joey_mission2_loop // TEST STUFF
						flag_joey_mission1_passed = 1
					ENDIF

					IF button_pressed_ind = 8
						flag_joey_mission3_passed = 1
						PRINT_BIG ( JM3 ) 1000 4 //"joey Mission 3"
						WAIT 300
						flag_joey_mission3_passed = 0
						START_NEW_SCRIPT joey_mission3_loop // TEST STUFF
						flag_joey_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 9
						flag_joey_mission4_passed = 1
						PRINT_BIG ( JM4 ) 1000 4 //"joey Mission 4"
						WAIT 300
						flag_joey_mission4_passed = 0
						START_NEW_SCRIPT joey_mission4_loop	// TEST STUFF
						flag_joey_mission3_passed = 1
					ENDIF

					IF button_pressed_ind = 10
						flag_joey_mission5_passed = 1
						PRINT_BIG ( JM5 ) 1000 4 //"joey Mission 5"
						WAIT 300
						flag_joey_mission5_passed = 0
						START_NEW_SCRIPT joey_mission5_loop	 // TEST STUFF
						flag_joey_mission4_passed = 1
					ENDIF

					IF button_pressed_ind = 11
						flag_joey_mission6_passed = 1
						PRINT_BIG ( JM6 ) 1000 4 //"joey Mission 6"
						WAIT 300
						flag_joey_mission6_passed = 0
						START_NEW_SCRIPT joey_mission6_loop	 // TEST STUFF
						flag_joey_mission5_passed = 1
					ENDIF
		  
					IF button_pressed_ind = 12
						flag_toni_mission1_passed = 1
						PRINT_BIG ( TM1 ) 1000 4 //"Toni Mission 1"
						PRINT_NOW ( TONI ) 2000 1
						WAIT 300
						flag_toni_mission1_passed = 0
						START_NEW_SCRIPT toni_mission1_loop // TEST STUFF
						flag_joey_mission6_passed = 1
						REMOVE_BLIP joey_contact_blip //REMOVE JOEYS BLIP
						REMOVE_BLIP toni_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1219.6 -321.0 26.4 RADAR_SPRITE_TONY toni_contact_blip
					ENDIF

					IF button_pressed_ind = 13
						flag_toni_mission2_passed = 1
						PRINT_BIG ( TM2 ) 1000 4 //"Toni Mission 2"
						WAIT 300
						flag_toni_mission2_passed = 0
						START_NEW_SCRIPT toni_mission2_loop // TEST STUFF
						flag_toni_mission1_passed = 1
					ENDIF

					IF button_pressed_ind = 14
						flag_toni_mission3_passed = 1
						PRINT_BIG ( TM3 ) 1000 4 //"Toni Mission 3"
						WAIT 300
						flag_toni_mission3_passed = 0
						START_NEW_SCRIPT toni_mission3_loop // TEST STUFF
						flag_toni_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 15
						flag_toni_mission4_passed = 1
						PRINT_BIG ( TM4 ) 1000 4 //"Toni Mission 4"
						WAIT 300
						flag_toni_mission4_passed = 0
						START_NEW_SCRIPT toni_mission4_loop // TEST STUFF
						flag_toni_mission3_passed = 1
					ENDIF

					IF button_pressed_ind = 16
						flag_toni_mission5_passed = 1
						PRINT_BIG ( TM5 ) 1000 4 //"Toni Mission 5"
						WAIT 300
						flag_toni_mission5_passed = 0
						START_NEW_SCRIPT toni_mission5_loop // TEST STUFF
						flag_toni_mission4_passed = 1
					ENDIF
	  				
					IF button_pressed_ind = 17
						flag_frankie_mission1_passed = 1
						PRINT_BIG ( FM1 ) 1000 4 //"frankie Mission 1"
						PRINT_NOW ( FRANK ) 2000 1
						WAIT 300
						flag_frankie_mission1_passed = 0
						START_NEW_SCRIPT frankie_mission1_loop // TEST STUFF
						flag_toni_mission5_passed = 1
						REMOVE_BLIP toni_contact_blip //REMOVE TONIS BLIP
  						REMOVE_BLIP	frankie_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
					ENDIF

					IF button_pressed_ind = 18
						flag_frankie_mission2_passed = 1
						PRINT_BIG ( FM2 ) 1000 4 //"frankie Mission 2"
						WAIT 300
						flag_frankie_mission2_passed = 0
						START_NEW_SCRIPT frankie_mission2_loop // TEST STUFF
						flag_frankie_mission1_passed = 1
					ENDIF

					IF button_pressed_ind = 19
						flag_frankie_mission2.1_passed = 1
						PRINT_BIG ( FM21 ) 1000 4 //"frankie Mission 2.1"
						WAIT 300
						flag_frankie_mission2.1_passed = 0
						START_NEW_SCRIPT frankie_mission2.1_loop
						flag_frankie_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 20
						flag_frankie_mission3_passed = 1
						PRINT_BIG ( FM3 ) 1000 4 //"frankie Mission 3"
						WAIT 300
						flag_frankie_mission3_passed = 0
						START_NEW_SCRIPT frankie_mission3_loop // TEST STUFF
						flag_frankie_mission2.1_passed = 1
						REMOVE_BLIP frankie_contact_blip //REMOVE FRANKIES BLIP
						REMOVE_BLIP	eightball_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1272.2 -92.9 -100.0 RADAR_SPRITE_EIGHT eightball_contact_blip
					ENDIF

					IF button_pressed_ind = 21
						flag_frankie_mission4_passed = 1
						PRINT_BIG ( FM4 ) 1000 4 //"frankie Mission 4"
						WAIT 300
						flag_frankie_mission4_passed = 0
						START_NEW_SCRIPT frankie_mission4_loop //TEST STUFF
						flag_frankie_mission3_passed = 1
						REMOVE_BLIP eightball_contact_blip //REMOVE 8_BALLS BLIP
						REMOVE_BLIP frankie_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
					ENDIF

					IF button_pressed_ind = 22
						flag_diablo_mission1_passed = 1
						PRINT_BIG ( DIAB1 ) 1000 4 //"Diablo Mission 1"
						WAIT 300
						flag_diablo_mission1_passed = 0
						START_NEW_SCRIPT diablo_mission1_loop //TEST STUFF
						flag_frankie_mission4_passed = 1
						REMOVE_BLIP frankie_contact_blip //REMOVE FRANKIES BLIP
						REMOVE_BLIP	diablo_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 938.4 -230.5 -100.0 RADAR_SPRITE_EL diablo_contact_blip
					ENDIF

					IF button_pressed_ind = 23 
						flag_diablo_mission2_passed = 1
						PRINT_BIG ( DIAB2 ) 1000 4 //"Diablo Mission 2"
						WAIT 300
						flag_diablo_mission2_passed = 0
						START_NEW_SCRIPT diablo_mission2_loop //TEST STUFF
						flag_diablo_mission1_passed = 1
					ENDIF

					IF button_pressed_ind = 24
						flag_diablo_mission3_passed = 1
						PRINT_BIG ( DIAB3 ) 1000 4 //"Diablo Mission 3"
						WAIT 300
						flag_diablo_mission3_passed = 0
						START_NEW_SCRIPT diablo_mission3_loop //TEST STUFF
						flag_diablo_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 25
						flag_diablo_mission4_passed = 1
						PRINT_BIG ( DIAB4 ) 1000 4 //"Diablo Mission 4"
						WAIT 300
						flag_diablo_mission4_passed = 0
						START_NEW_SCRIPT diablo_mission4_loop //TEST STUFF
						flag_diablo_mission3_passed = 1
					ENDIF

					IF button_pressed_ind = 26
						flag_meat_mission1_passed = 1
						PRINT_BIG ( MEA1 ) 1000 4 //"Meat Mission 1"
						WAIT 300
						flag_meat_mission1_passed = 0
						START_NEW_SCRIPT meat_mission1_loop //TEST STUFF
						flag_diablo_mission4_passed = 1
						REMOVE_BLIP	diablo_contact_blip
					ENDIF

					IF button_pressed_ind = 27
						flag_meat_mission2_passed = 1
						PRINT_BIG ( MEA2 ) 1000 4 //"Meat Mission 2"
						WAIT 300
						flag_meat_mission2_passed = 0
						START_NEW_SCRIPT meat_mission2_loop //TEST STUFF
						flag_meat_mission1_passed = 1
					ENDIF

					IF button_pressed_ind = 28
						flag_meat_mission3_passed = 1
						PRINT_BIG ( MEA3 ) 1000 4 //"Meat Mission 3"
						WAIT 300
						flag_meat_mission3_passed = 0
						START_NEW_SCRIPT meat_mission3_loop //TEST STUFF
						flag_meat_mission2_passed = 1
					ENDIF

					IF button_pressed_ind = 29
						flag_meat_mission4_passed = 1
						PRINT_BIG ( MEA4 ) 1000 4 //"Meat Mission 4"
						WAIT 300
						flag_meat_mission4_passed = 0
						START_NEW_SCRIPT meat_mission4_loop //TEST STUFF
						flag_meat_mission3_passed = 1
					ENDIF

				ENDIF
			ENDIF
		ENDIF
	ENDIF



//COMMERCIAL MISSION SKIP RIGHT

	IF flag_player_on_mission = 0	 
		IF IS_BUTTON_PRESSED PAD2 DPADRIGHT
			IF IS_PLAYER_PLAYING player
				IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
					// UPSTATE: Fix debug not working due to passed islands
					flag_industrial_passed = 1
					flag_commercial_passed = 0

					button_pressed_com ++
					IF button_pressed_com > 30
						flag_yardie_mission4_passed = 1
						WAIT 300
						flag_asuka_mission1_passed = 0
						flag_asuka_mission2_passed = 0
						flag_asuka_mission3_passed = 0
						flag_asuka_mission4_passed = 0
						flag_asuka_mission5_passed = 0
						flag_asuka_suburban_mission1_passed = 0
						flag_asuka_suburban_mission2_passed = 0
						flag_asuka_suburban_mission3_passed = 0
						flag_kenji_mission1_passed = 0
						flag_kenji_mission2_passed = 0
						flag_kenji_mission3_passed = 0
						flag_kenji_mission4_passed = 0
						flag_kenji_mission5_passed = 0
						flag_ray_mission1_passed = 0
						flag_ray_mission2_passed = 0
						flag_ray_mission3_passed = 0
						flag_ray_mission4_passed = 0
						flag_ray_mission5_passed = 0
						flag_ray_mission6_passed = 0
						flag_love_mission1_passed = 0
						flag_love_mission2_passed = 0
						flag_love_mission3_passed = 0
						flag_love_mission4_passed = 0
						flag_love_mission5_passed = 0
						flag_love_mission6_passed = 0
						flag_love_mission7_passed = 0
						flag_yardie_mission1_passed = 0
						flag_yardie_mission2_passed = 0
						flag_yardie_mission3_passed = 0
						flag_yardie_mission4_passed = 0
						button_pressed_com = 1	   
					ENDIF

		  			IF button_pressed_com = 1
			  			flag_asuka_mission1_passed = 1
						PRINT_BIG ( AM1 ) 1000 4 //"asuka Mission 1"
						PRINT_NOW ( ASUKA ) 2000 1
						WAIT 300
						flag_asuka_mission1_passed = 0
			  			START_NEW_SCRIPT asuka_mission1_loop // TEST STUFF
						REMOVE_BLIP yardie_contact_blip
						REMOVE_BLIP	asuka_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 523.7 -643.0 16.1 RADAR_SPRITE_ASUKA asuka_contact_blip
					ENDIF

					IF button_pressed_com = 2
						flag_asuka_mission2_passed = 1
						PRINT_BIG ( AM2 ) 1000 4 //"asuka Mission 2"
						WAIT 300
						flag_asuka_mission2_passed = 0
						START_NEW_SCRIPT asuka_mission2_loop // TEST STUFF
						blip_yardie_created_before = 1
						flag_asuka_mission1_passed = 1
					ENDIF

					IF button_pressed_com = 3
						flag_asuka_mission3_passed = 1
						PRINT_BIG ( AM3 ) 1000 4 //"asuka Mission 3"
						WAIT 300
						flag_asuka_mission3_passed = 0
						START_NEW_SCRIPT asuka_mission3_loop // TEST STUFF
						blip_yardie_created_before = 0
						flag_asuka_mission2_passed = 1
					ENDIF

					IF button_pressed_com = 4
						flag_asuka_mission4_passed = 1
						PRINT_BIG ( AM4 ) 1000 4 //"asuka Mission 4"
						WAIT 300
						flag_asuka_mission4_passed = 0
						START_NEW_SCRIPT asuka_mission4_loop // TEST STUFF
						flag_asuka_mission3_passed = 1
					ENDIF

					IF button_pressed_com = 5
						flag_asuka_mission5_passed = 1
						PRINT_BIG ( AM5 ) 1000 4 //"asuka Mission 5"
						WAIT 300
						flag_asuka_mission5_passed = 0
						START_NEW_SCRIPT asuka_mission5_loop // TEST STUFF
						flag_asuka_mission4_passed = 1
					ENDIF
	   
					IF button_pressed_com = 6
						flag_asuka_suburban_mission1_passed = 1
						PRINT_BIG ( AS1 ) 1000 4 //"asuka Mission 6 (SUBURBAN MISSION)"
						PRINT_NOW ( B_SITE ) 2000 1
						WAIT 300
						flag_asuka_suburban_mission1_passed = 0
						START_NEW_SCRIPT asuka_suburban_mission1_loop // TEST STUFF
						flag_asuka_mission5_passed = 1
						REMOVE_BLIP	asuka_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 366.939 -328.025 20.268 RADAR_SPRITE_ASUKA asuka_contact_blip
					ENDIF

					IF button_pressed_com = 7
						flag_asuka_suburban_mission2_passed = 1
						PRINT_BIG ( AS2 ) 1000 4 //"asuka Mission 7 (SUBURBAN MISSION)"
						WAIT 300
						flag_asuka_suburban_mission2_passed = 0
						START_NEW_SCRIPT asuka_suburban_mission2_loop // TEST STUFF
						flag_asuka_suburban_mission1_passed = 1
					ENDIF

					IF button_pressed_com = 8
						flag_asuka_suburban_mission3_passed = 1
						PRINT_BIG ( AS3 ) 1000 4 //"asuka Mission 8 (SUBURBAN MISSION)"
						WAIT 300
						flag_asuka_suburban_mission3_passed = 0
						START_NEW_SCRIPT asuka_suburban_mission3_loop // TEST STUFF
						flag_asuka_suburban_mission2_passed = 1
					ENDIF

					IF button_pressed_com = 9
						flag_kenji_mission1_passed = 1
						PRINT_BIG ( KM1 ) 1000 4 //"kenji Mission 1"
						PRINT_NOW ( KENJI ) 2000 1
						WAIT 300
						flag_kenji_mission1_passed = 0
						START_NEW_SCRIPT kenji_mission1_loop // TEST STUFF
						flag_asuka_suburban_mission3_passed = 1
						REMOVE_BLIP asuka_contact_blip
						REMOVE_BLIP	kenji_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 459.1 -1413.0 26.1 RADAR_SPRITE_KENJI kenji_contact_blip
					ENDIF

					IF button_pressed_com = 10
						flag_kenji_mission2_passed = 1
						PRINT_BIG ( KM2 ) 1000 4 //"kenji Mission 2"
						WAIT 300
						flag_kenji_mission2_passed = 0
						START_NEW_SCRIPT kenji_mission2_loop // TEST STUFF
						flag_kenji_mission1_passed = 1
					ENDIF

					IF button_pressed_com = 11
						flag_kenji_mission3_passed = 1
						PRINT_BIG ( KM3 ) 1000 4 //"kenji Mission 3"
						WAIT 300
						flag_kenji_mission3_passed = 0
						START_NEW_SCRIPT kenji_mission3_loop // TEST STUFF
						flag_kenji_mission2_passed = 1
					ENDIF

					IF button_pressed_com = 12
						flag_kenji_mission4_passed = 1
						PRINT_BIG ( KM4 ) 1000 4 //"kenji Mission 4"
						WAIT 300
						flag_kenji_mission4_passed = 0
						START_NEW_SCRIPT kenji_mission4_loop	 // TEST STUFF
						flag_kenji_mission3_passed = 1
					ENDIF

					IF button_pressed_com = 13
						flag_kenji_mission5_passed = 0
						PRINT_BIG ( KM5 ) 1000 4 //"kenji Mission 5"
						WAIT 300
						flag_kenji_mission5_passed = 0
						START_NEW_SCRIPT kenji_mission5_loop	 // TEST STUFF
						flag_kenji_mission4_passed = 1
					ENDIF
			   
					IF button_pressed_com = 14
						flag_ray_mission1_passed = 1
						PRINT_BIG ( RM1 ) 1000 4 //"ray Mission 1"
						PRINT_NOW ( RAY ) 2000 1
						WAIT 300
						flag_ray_mission1_passed = 0
						START_NEW_SCRIPT ray_mission1_loop // TEST STUFF
						flag_kenji_mission5_passed = 1
						REMOVE_BLIP kenji_contact_blip
						REMOVE_BLIP	ray_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 38.8 -725.4 -100.0 RADAR_SPRITE_RAY ray_contact_blip
					ENDIF

					IF button_pressed_com = 15
						flag_ray_mission2_passed = 1
						PRINT_BIG ( RM2 ) 1000 4 //"ray Mission 2"
						WAIT 300
						flag_ray_mission2_passed = 0
						START_NEW_SCRIPT ray_mission2_loop // TEST STUFF
						flag_ray_mission1_passed = 1
					ENDIF

					IF button_pressed_com = 16
						flag_ray_mission3_passed = 1
						PRINT_BIG ( RM3 ) 1000 4 //"ray Mission 3"
						WAIT 300
						flag_ray_mission3_passed = 0
						START_NEW_SCRIPT ray_mission3_loop // TEST STUFF
						flag_ray_mission2_passed = 1
					ENDIF

					IF button_pressed_com = 17
						flag_ray_mission4_passed = 1
						PRINT_BIG ( RM4 ) 1000 4 //"ray Mission 4"
						WAIT 300
						flag_ray_mission4_passed = 0
						START_NEW_SCRIPT ray_mission4_loop // TEST STUFF
						flag_ray_mission3_passed = 1
					ENDIF

					IF button_pressed_com = 18  
						flag_ray_mission5_passed = 1
						PRINT_BIG ( RM5 ) 1000 4 //"ray Mission 5"
						WAIT 300
						flag_ray_mission5_passed = 0
						START_NEW_SCRIPT ray_mission5_loop // TEST STUFF
						flag_ray_mission4_passed = 1
					ENDIF
	   	
					IF button_pressed_com = 19
						flag_ray_mission6_passed = 1
						PRINT_BIG ( RM6 ) 1000 4 //"ray Mission 6"
						WAIT 300
						flag_ray_mission6_passed = 0
						flag_love_mission3_passed = 1
						START_NEW_SCRIPT ray_mission6_loop // TEST STUFF
						flag_ray_mission5_passed = 1
						//flag_industrial_passed = 1
						//flag_commercial_passed = 1
					ENDIF
	   	
					IF button_pressed_com = 20
						flag_love_mission1_passed = 1
						PRINT_BIG ( love1 ) 1000 4 //"love Mission 1"
						PRINT_NOW ( LOVE ) 2000 1
						WAIT 300
						flag_love_mission1_passed = 0
						START_NEW_SCRIPT love_mission1_loop // TEST STUFF
						flag_ray_mission6_passed = 1   
						REMOVE_BLIP ray_contact_blip
						REMOVE_BLIP	love_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 86.1 -1548.7 28.3 RADAR_SPRITE_DON love_contact_blip
					ENDIF

		   			IF button_pressed_com = 21
			   			flag_love_mission2_passed = 1
						PRINT_BIG ( love2 ) 1000 4 //"love Mission 2"
						WAIT 300
						flag_love_mission2_passed = 0
			   			START_NEW_SCRIPT love_mission2_loop // TEST STUFF
			  			flag_love_mission1_passed = 1
		  			ENDIF

					IF button_pressed_com = 22
			   			flag_love_mission3_passed = 1
						PRINT_BIG ( love3 ) 1000 4 //"love Mission 3"
						WAIT 300
						flag_love_mission3_passed = 0
			   			START_NEW_SCRIPT love_mission3_loop // TEST STUFF
			  			flag_love_mission2_passed = 1
		  			ENDIF

					IF button_pressed_com = 23
			   			flag_love_mission4_passed = 1
						PRINT_BIG ( love4 ) 1000 4 //"love Mission 4"
						WAIT 300
						flag_love_mission4_passed = 0
						flag_asuka_suburban_mission1_passed = 0
			   			START_NEW_SCRIPT love_mission4_loop // TEST STUFF
						flag_blip_hood_created = 1
			  			flag_love_mission3_passed = 1
		  			ENDIF

					IF button_pressed_com = 24
			   			flag_love_mission5_passed = 1
						PRINT_BIG ( love5 ) 1000 4 //"love Mission 5"
						WAIT 300
						flag_love_mission5_passed = 0
			   			START_NEW_SCRIPT love_mission5_loop // TEST STUFF
						flag_blip_hood_created = 0
			  			flag_love_mission4_passed = 1
						//flag_industrial_passed = 1
						//flag_commercial_passed = 1
		  			ENDIF

					IF button_pressed_com = 25
						flag_love_mission6_passed = 1
						PRINT_BIG ( love6 ) 1000 4 //"love Mission 6"
						WAIT 300
						flag_love_mission6_passed = 0
						START_NEW_SCRIPT love_mission6_loop // TEST STUFF
						flag_love_mission5_passed = 1
						//flag_industrial_passed = 1
						//flag_commercial_passed = 1
					ENDIF

					IF button_pressed_com = 26
						flag_love_mission7_passed = 1
						PRINT_BIG ( love7 ) 1000 4 //"love Mission 7"
						WAIT 300
						flag_love_mission7_passed = 0
						START_NEW_SCRIPT love_mission7_loop // TEST STUFF
						flag_love_mission6_passed = 1
						//flag_industrial_passed = 1
						//flag_commercial_passed = 1
					ENDIF

					IF button_pressed_com = 27
						flag_yardie_mission1_passed = 1
						PRINT_BIG ( YD1 ) 1000 4 //"Yardie Mission 1"
						PRINT_NOW ( YARDIE ) 2000 1
						WAIT 300
						flag_yardie_mission1_passed = 0
						START_NEW_SCRIPT yardie_mission1_loop // TEST STUFF   
						flag_love_mission7_passed = 1
						REMOVE_BLIP love_contact_blip
						REMOVE_BLIP	yardie_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT 120.7 -272.1 16.1 RADAR_SPRITE_LIZ yardie_contact_blip
					ENDIF

					IF button_pressed_com = 28
			   			flag_yardie_mission2_passed = 1
						PRINT_BIG ( YD2 ) 1000 4 //"Yardie Mission 2"
						WAIT 300
						flag_yardie_mission2_passed = 0
			   			START_NEW_SCRIPT yardie_mission2_loop // TEST STUFF
			  			flag_yardie_mission1_passed = 1
		  			ENDIF

					IF button_pressed_com = 29
			   			flag_yardie_mission3_passed = 1
						PRINT_BIG ( YD3 ) 1000 4 //"Yardie Mission 3"
						WAIT 300
						flag_yardie_mission3_passed = 0
			   			START_NEW_SCRIPT yardie_mission3_loop // TEST STUFF
			  			flag_yardie_mission2_passed = 1
		  			ENDIF


					IF button_pressed_com = 30
			   			flag_yardie_mission4_passed = 1
						PRINT_BIG ( YD4 ) 1000 4 //"Yardie Mission 4"
						WAIT 300
						flag_yardie_mission4_passed = 0
			   			START_NEW_SCRIPT yardie_mission4_loop // TEST STUFF
			  			flag_yardie_mission3_passed = 1
		  			ENDIF
		
				ENDIF
			ENDIF
		ENDIF	
	ENDIF



// SUBURBAN MISSION SKIP RIGHT

	IF flag_player_on_mission = 0
		IF IS_BUTTON_PRESSED PAD2 DPADRIGHT
			IF IS_PLAYER_PLAYING player
				IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN

					// UPSTATE: Fix debug not working due to passed islands
					flag_industrial_passed = 1
					flag_commercial_passed = 1
					flag_suburban_passed = 0

					button_pressed_sub ++
					IF button_pressed_sub > 6
						flag_cat_mission1_passed = 1
						WAIT 300
						flag_cat_mission1_passed = 0
						flag_hood_mission1_passed = 0
						flag_hood_mission2_passed = 0
						flag_hood_mission3_passed = 0
						flag_hood_mission4_passed = 0
						flag_hood_mission5_passed = 0
						button_pressed_sub = 1	   
					ENDIF

		  			IF button_pressed_sub = 1
			  			flag_hood_mission1_passed = 1
						PRINT_BIG ( HM_1 ) 1000 4 //"Hood Mission 1"
						PRINT_NOW ( HOOD ) 2000 1
						WAIT 300
						flag_hood_mission1_passed = 0
			  			START_NEW_SCRIPT hood_mission1_loop // TEST STUFF
						REMOVE_BLIP	maria_contact_blip
  						REMOVE_BLIP	hood_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT -443.5 -6.1 3.8 RADAR_SPRITE_ICE hood_contact_blip
					ENDIF

					IF button_pressed_sub = 2
						flag_hood_mission2_passed = 1
						PRINT_BIG ( HM_2 ) 1000 4 //"Hood Mission 2"
						WAIT 300
						flag_hood_mission2_passed = 0
						START_NEW_SCRIPT hood_mission2_loop // TEST STUFF
						flag_hood_mission1_passed = 1
					ENDIF

					IF button_pressed_sub = 3
						flag_hood_mission3_passed = 1
						PRINT_BIG ( HM_3 ) 1000 4 //"Hood Mission 3"
						WAIT 300
						flag_hood_mission3_passed = 0
						START_NEW_SCRIPT hood_mission3_loop // TEST STUFF
						flag_hood_mission2_passed = 1
					ENDIF

					IF button_pressed_sub = 4
						flag_hood_mission4_passed = 1
						PRINT_BIG ( HM_4 ) 1000 4 //"Hood Mission 4"
						WAIT 300
						flag_hood_mission4_passed = 0
						START_NEW_SCRIPT hood_mission4_loop // TEST STUFF
						flag_hood_mission3_passed = 1
					ENDIF

					IF button_pressed_sub = 5
						flag_hood_mission5_passed = 1
						PRINT_BIG ( HM_5 ) 1000 4 //"Hood Mission 5"
						WAIT 300
						flag_hood_mission5_passed = 0
						START_NEW_SCRIPT hood_mission5_loop // TEST STUFF
						flag_hood_mission4_passed = 1
					ENDIF

					IF button_pressed_sub = 6
						flag_cat_mission1_passed = 1
						PRINT_BIG ( CAT2 ) 1000 4 //"Final mission"
						WAIT 300
						flag_cat_mission1_passed = 0
						START_NEW_SCRIPT cat_mission1_loop // TEST STUFF
						flag_hood_mission5_passed = 1
						REMOVE_BLIP	hood_contact_blip
						REMOVE_BLIP	maria_contact_blip
						ADD_SPRITE_BLIP_FOR_CONTACT_POINT -362.8 245.9 60.0 RADAR_SPRITE_CAT maria_contact_blip
					ENDIF

				ENDIF
	   		ENDIF
		ENDIF
	ENDIF


ENDIF	//	IF IS_PLAYER_PLAYING player

GOTO mission_start_debug

upstate_debug_teleport:
SWITCH ul_teleport_no
	CASE 0
		SET_PLAYER_COORDINATES player -1329.5 1590.75 72.0 // town 1
		BREAK
	CASE 1
		SET_PLAYER_COORDINATES player -131.0 1274.25 115.0 // town 2
		BREAK
	CASE 2
		SET_PLAYER_COORDINATES player 376.8125 1323.438 132.0 // town 3
		BREAK
	CASE 3
		SET_PLAYER_COORDINATES player -1176.188 1058.063 83.0 // initial spot
		BREAK
	CASE 4
		SET_PLAYER_COORDINATES player -436.2219 727.04 248.7092 // observatory
		BREAK
	CASE 5
		SET_PLAYER_COORDINATES player 1000.0 1300.0 127.0 // gt entrance
		BREAK
	CASE 6
		SET_PLAYER_COORDINATES player 1463.8851 1405.0201 126.813 // gt bank
		BREAK
ENDSWITCH

WHILE IS_BUTTON_PRESSED PAD1 DPADLEFT
OR IS_BUTTON_PRESSED PAD1 DPADRIGHT
	WAIT 0
ENDWHILE

RETURN

}

MISSION_END 

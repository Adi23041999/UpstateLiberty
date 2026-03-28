MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************CRRRRRAZY TAXI****************************************
// *******************************LETS MAKE SOME CRRRRRAZY MONEY!*****************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_taxi1

GOSUB mission_cleanup_taxi1

MISSION_END


// Variables for mission

VAR_INT blip1_ct1 blip2_ct1 spray_blip_onscreen  

VAR_INT taxi_car1 taxi_countdown_already_started

VAR_INT taxi_ped1 taxi_passed_this_shot taxi_fucked_flag

//VAR_INT special_ped1 

VAR_INT taxi_countdown taxi_score taxi_distance_int taxi_distance_int_old

VAR_INT taxi_finish_time taxi_start_time total_taxi_time_taken 

VAR_FLOAT taxi_destx1 taxi_desty1 taxi_destz1
VAR_FLOAT taxi_destx2 taxi_desty2 taxi_destz2
VAR_FLOAT taxi_blipx taxi_blipy taxi_blipz 

VAR_FLOAT taxi_ped_x taxi_ped_y taxi_ped_z
VAR_FLOAT x_diff y_diff x_diff_sq y_diff_sq taxi_distance_sq taxi_distance 
VAR_INT score_for_this_fare	speedbonus in_a_row_cash in_a_row_number

// ***************************************Mission Start*************************************

mission_start_taxi1:

SCRIPT_NAME	TAXI

SET_DEATHARREST_STATE OFF // GSW - does deatharrest have to be switched off?  YES! well maybe...

flag_player_on_mission = 1
taxi_countdown_already_started = 0
taxi_countdown = 0
taxi_passed_this_shot = 0
taxi_score = 0
taxi_ped1 = -1
spray_blip_onscreen = 0
taxi_fucked_flag = 0
in_a_row_number = 5
in_a_row_cash = 2000

WAIT 0

DISPLAY_ONSCREEN_COUNTER_WITH_STRING taxi_passed_this_shot COUNTER_DISPLAY_NUMBER (FARES) //TEST STUFF!!!!!!!!!!!!!

IF NOT IS_PLAYER_PLAYING player
	GOTO mission_taxi1_failed
ENDIF

IF IS_PLAYER_IN_ANY_CAR player
	STORE_CAR_PLAYER_IS_IN player taxi_car1
ELSE
	GOTO mission_taxi1_failed
ENDIF

//SWITCH_TAXI_TIMER ON
SET_TAXI_LIGHTS taxi_car1 On
PRINT_NOW ( TAXI1 ) 1500 1 //Pick up a fare
//WAIT 1500
WAIT 0

Start_taxi_mission:

IF done_taxi_help = 0
	PRINT_HELP ( TAXIH1 )
	done_taxi_help = 1
ENDIF

score_for_this_fare = 0

IF NOT IS_PLAYER_PLAYING player
	GOTO mission_taxi1_failed
ENDIF

IF IS_CAR_DEAD taxi_car1
	GOTO mission_taxi1_failed
ENDIF

IF NOT IS_PLAYER_IN_CAR player taxi_car1
	GOTO mission_taxi1_failed
ENDIF

/*
IF taxi_passed = 0	   				//SPECIAL MISSIONS???
AND IS_PLAYER_IN_ZONE player REDLIGH
	GOTO special_ped_mission1
ENDIF
*/

//	random_ped_grabber:

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ENDIF

	IF taxi_countdown_already_started = 1
	AND taxi_countdown = 0
		//PRINT_NOW ( TAXI2 ) 5000 2 //You SUCK!
		GOTO mission_taxi1_failed
	ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 
	GET_RANDOM_CHAR_IN_ZONE IND_ZON taxi_ped1
ENDIF
   
IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL 
	GET_RANDOM_CHAR_IN_ZONE COM_ZON taxi_ped1
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN 
	GET_RANDOM_CHAR_IN_ZONE SUB_ZON taxi_ped1
ENDIF
//IF IS_PLAYER_IN_ZONE player SUB_ZON 
//	GET_RANDOM_CHAR_IN_ZONE IND_ZON taxi_ped1
//ENDIF

IF taxi_ped1 = -1
	WAIT 0
	GOTO Start_taxi_mission		//	random_ped_grabber
ENDIF

											   
//been_in_taxi1_before = 7

// START OF TAXI MISSION
	
	CHAR_SET_IDLE taxi_ped1
	CLEAR_CHAR_THREAT_SEARCH taxi_ped1
	SET_CHAR_HEED_THREATS taxi_ped1 False
	ADD_BLIP_FOR_CHAR taxi_ped1 blip1_ct1
	SET_CHAR_OBJ_HAIL_TAXI taxi_ped1

	//PRINT_NOW ( TAXI1 ) 2000 2 //Pick up a fare

ped_get_in_taxi:

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_3D Player taxi_ped1 7.0 7.0 2.0 FALSE //IF CLOSE TO THE CHAR
OR NOT IS_CAR_STOPPED taxi_car1
//	OR NOT IS_PLAYER_IN_CAR player taxi_car1 

 WAIT 0

	IF NOT IS_PLAYER_PLAYING player	// ok to fail if player is arrested?
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CAR_DEAD taxi_car1
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CHAR_DEAD taxi_ped1
		GOTO mission_taxi1_passed
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player taxi_car1	    
		GOTO mission_taxi1_failed				
	ENDIF
	
	IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D Player taxi_ped1 90.0 90.0 20.0 FALSE
		GOTO mission_taxi1_passed
	ENDIF 

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ENDIF

	IF taxi_countdown_already_started = 1
	AND taxi_countdown = 0
		//PRINT_NOW ( TAXI2 ) 5000 2 //You SUCK!
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CAR_HEALTH_GREATER taxi_car1 500
	AND spray_blip_onscreen = 1
		REMOVE_BLIP spray_taxi
		spray_blip_onscreen = 0
		taxi_fucked_flag = 0
	ENDIF

	IF NOT IS_CHAR_DEAD taxi_ped1
		TURN_CHAR_TO_FACE_PLAYER taxi_ped1 Player
	ENDIF

ENDWHILE


IF NOT IS_CAR_HEALTH_GREATER taxi_car1 500
	PRINT_NOW ( TAXI7 ) 4000 1 //I ain't getting in that heap of shit!!
	IF spray_blip_onscreen = 0
		REMOVE_BLIP spray_taxi
		IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 
			ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY spray_taxi
		ENDIF
		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
			ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 -100.0 RADAR_SPRITE_SPRAY spray_taxi
		ENDIF
		IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
			ADD_SPRITE_BLIP_FOR_COORD -1128.0 32.5.8 -100.0 RADAR_SPRITE_SPRAY spray_taxi
		ENDIF
		spray_blip_onscreen = 1
		taxi_fucked_flag = 1
	ENDIF
	GOTO mission_taxi1_passed
ENDIF

SET_CHAR_RUNNING taxi_ped1 TRUE
SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER taxi_ped1 taxi_car1	
	

WHILE NOT IS_CHAR_IN_CAR taxi_ped1 taxi_car1 
	WAIT 0

		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_DEAD taxi_car1
			GOTO mission_taxi1_failed
		ENDIF

	 	IF IS_CHAR_DEAD taxi_ped1
			GOTO mission_taxi1_passed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player taxi_car1	    
			GOTO mission_taxi1_failed				
		ENDIF

		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D Player taxi_ped1 90.0 90.0 20.0 FALSE
			GOTO mission_taxi1_passed
		ENDIF

		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 SQUARE
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ENDIF
		
		IF taxi_countdown_already_started = 1
		AND taxi_countdown = 0
			//PRINT_NOW ( TAXI2 ) 5000 2 //You SUCK!
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_HEALTH_GREATER taxi_car1 500
		AND spray_blip_onscreen = 1
			REMOVE_BLIP spray_taxi
			spray_blip_onscreen = 0
		ENDIF

		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D Player taxi_ped1 7.0 7.0 2.0 FALSE
			GOTO ped_get_in_taxi
		ENDIF		

ENDWHILE

GET_CHAR_COORDINATES taxi_ped1 taxi_ped_x taxi_ped_y taxi_ped_z

REMOVE_BLIP blip1_ct1
SET_TAXI_LIGHTS taxi_car1 Off

//GET_GAME_TIMER taxi_start_time

passenger_destination:

WAIT 0

	IF NOT IS_PLAYER_PLAYING player
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL //INDUSTRIAL*******************************************
	//OR IS_PLAYER_IN_ZONE player SUB_ZON

		GENERATE_RANDOM_INT_IN_RANGE 1 11 been_in_taxi1_before
		
		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_taxi1_failed
		ENDIF

		IF been_in_taxi1_before = 1
				IF IS_PLAYER_IN_ZONE player REDLIGH
					GOTO passenger_destination
				ENDIF	
			PRINT_NOW ( FARE1 ) 5000 1 //Take me to Meeouch Sex Kitten Club

			taxi_destx1 = 936.3
			taxi_desty1 = -462.6
			taxi_destz1 = 14.4

			taxi_destx2 = 913.7
			taxi_desty2 = -456.0
			taxi_destz2 = 16.4
		ENDIF

		IF been_in_taxi1_before = 2
				IF IS_PLAYER_IN_ZONE player S_VIEW				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE2 ) 5000 1 //Take me to Supa Save

			taxi_destx1 = 1268.5
			taxi_desty1 = -616.4
			taxi_destz1 = 11.7

			taxi_destx2 = 1288.3
			taxi_desty2 = -627.6
			taxi_destz2 = 13.7
		ENDIF

		IF been_in_taxi1_before = 3
				IF IS_PLAYER_IN_ZONE player CHINA				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE3 ) 5000 1 //Take me to the old School hall

			taxi_destx1 = 1008.9
			taxi_desty1 = -871.9
			taxi_destz1 = 14.4

			taxi_destx2 = 995.3
			taxi_desty2 = -881.9
			taxi_destz2 = 16.4
		ENDIF

		IF been_in_taxi1_before = 4
				IF IS_PLAYER_IN_ZONE player PORT_W				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE4 ) 5000 1 //Take me to greasy Joes

			taxi_destx1 = 849.3
			taxi_desty1 = -990.1
			taxi_destz1 = 4.5

			taxi_destx2 = 869.4
			taxi_desty2 = -1002.6
			taxi_destz2 = 6.5
		ENDIF

		IF been_in_taxi1_before = 5
				IF IS_PLAYER_IN_ZONE player REDLIGH				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE5 ) 5000 1 //Take me to Ammo Nation

			taxi_destx1 = 1065.4
			taxi_desty1 = -394.1
			taxi_destz1 = 14.3

			taxi_destx2 = 1057.9
			taxi_desty2 = -408.9
			taxi_destz2 = 16.3
		ENDIF

		IF been_in_taxi1_before = 6
				IF IS_PLAYER_IN_ZONE player LITTLEI				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE6 ) 5000 1 //Take me to Easy Credit Autos

			taxi_destx1 = 1207.0
			taxi_desty1 = -122.0
			taxi_destz1 = 14.0

			taxi_destx2 = 1224.0
			taxi_desty2 = -108.0
			taxi_destz2 = 16.0
		ENDIF							   

		IF been_in_taxi1_before = 7
				IF IS_PLAYER_IN_ZONE player REDLIGH				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE7 ) 5000 1 //Take us to Woodys topless bar

			taxi_destx1 = 912.9
			taxi_desty1 = -419.0
			taxi_destz1 = 14.0

			taxi_destx2 = 919.5
			taxi_desty2 = -401.3
			taxi_destz2 = 16.0
		ENDIF

		IF been_in_taxi1_before = 8
				IF IS_PLAYER_IN_ZONE player LITTLEI				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE8 ) 5000 1 //Take me to The Bistro

			taxi_destx1 = 1345.8
			taxi_desty1 = -461.8
			taxi_destz1 = 49.4

			taxi_destx2 = 1334.7
			taxi_desty2 = -447.0
			taxi_destz2 = 51.4
		ENDIF

		IF been_in_taxi1_before = 9
				IF IS_PLAYER_IN_ZONE player PORT_E				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE9 ) 5000 1 //Take me to the Import/Export garage

			taxi_destx1 = 1475.0
			taxi_desty1 = -686.0
			taxi_destz1 = 11.3

			taxi_destx2 = 1485.3
			taxi_desty2 = -667.5
			taxi_destz2 = 13.3
		ENDIF

		IF been_in_taxi1_before = 10
				IF IS_PLAYER_IN_ZONE player CHINA				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE10 ) 5000 1 //Take me to the 'Punk Noodles'

			taxi_destx1 = 1039.1
			taxi_desty1 = -660.1
			taxi_destz1 = 14.4

			taxi_destx2 = 1043.9
			taxi_desty2 = -647.9
			taxi_destz2 = 16.4
		ENDIF
	ENDIF 


	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL //COMERCIAL*******************************************
	//OR IS_PLAYER_IN_ZONE player SUB_ZON

		GENERATE_RANDOM_INT_IN_RANGE 11 21 been_in_taxi1_before

		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_taxi1_failed
		ENDIF

		IF been_in_taxi1_before = 11
				IF IS_PLAYER_IN_ZONE player CONSTRU
					GOTO passenger_destination
				ENDIF	
			PRINT_NOW ( FARE11 ) 5000 1 //Take me to the constuction site

			taxi_destx1 = 441.86	   
			taxi_desty1 = -193.00
			taxi_destz1 = 20.36

			taxi_destx2 = 447.42 
			taxi_desty2 = -201.93 
			taxi_destz2 = 22.21
		ENDIF

		IF been_in_taxi1_before = 12
				IF IS_PLAYER_IN_ZONE player STADIUM				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE12 ) 5000 1 //Take me to the stadium 

			taxi_destx1 = -27.05   
			taxi_desty1 = -269.61 
			taxi_destz1 = 14.95

			taxi_destx2 = -11.73 
			taxi_desty2 = -278.88 
			taxi_destz2 = 16.93
		ENDIF

		IF been_in_taxi1_before = 13
				IF IS_PLAYER_IN_ZONE player SHOPING				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE13 ) 5000 1 //Take me to the Church 

			taxi_destx1 = 22.07   
			taxi_desty1 = -1136.95 
			taxi_destz1 = 25.14

			taxi_destx2 = 28.95 
			taxi_desty2 = -1125.66 
			taxi_destz2 = 27.12
		ENDIF

		IF been_in_taxi1_before = 14
				IF IS_PLAYER_IN_ZONE player YAKUSA				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE14 ) 5000 1 //Casino  

			taxi_destx1 = 421.42   
			taxi_desty1 = -1390.83 
			taxi_destz1 = 24.95

			taxi_destx2 = 415.45 
			taxi_desty2 = -1401.24 
			taxi_destz2 = 26.92
		ENDIF

		IF been_in_taxi1_before = 15
				IF IS_PLAYER_IN_ZONE player UNIVERS				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE15 ) 5000 1 //Uni 

			taxi_destx1 = 183.15   
			taxi_desty1 = -215.50 
			taxi_destz1 = 17.02

			taxi_destx2 = 167.21 
			taxi_desty2 = -221.22 
			taxi_destz2 = 19.29
		ENDIF

		IF been_in_taxi1_before = 16
				IF IS_PLAYER_IN_ZONE player PARK				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE16 ) 5000 1 //Shopping Mall 

			taxi_destx1 = 193.77   
			taxi_desty1 = -626.22 
			taxi_destz1 = 25.12

			taxi_destx2 = 180.83 
			taxi_desty2 = -616.51 
			taxi_destz2 = 27.12
		ENDIF							   

		IF been_in_taxi1_before = 17
				IF IS_PLAYER_IN_ZONE player COM_EAS				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE17 ) 5000 1 //Museum 

			taxi_destx1 = 326.1   
			taxi_desty1 = -1001.7 
			taxi_destz1 = 29.05

			taxi_destx2 = 316.3 
			taxi_desty2 = -1012.4 
			taxi_destz2 = 24.44
		ENDIF

		IF been_in_taxi1_before = 18
				IF IS_PLAYER_IN_ZONE player YAKUSA				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE18 ) 5000 1 //(AMco) 

			taxi_destx1 = 246.20 
			taxi_desty1 = -1192.75   
			taxi_destz1 = 24.71

			taxi_destx2 = 256.67 
			taxi_desty2 = -1184.17 
			taxi_destz2 = 26.71
		ENDIF

		IF been_in_taxi1_before = 19
				IF IS_PLAYER_IN_ZONE player SHOPING				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE19 ) 5000 1 //Bolt Burgers 

			taxi_destx1 = 28.69  
			taxi_desty1 = -1066.66 
			taxi_destz1 = 26.72

			taxi_destx2 = 34.07 
			taxi_desty2 = -1078.96 
			taxi_destz2 = 24.97
		ENDIF

		IF been_in_taxi1_before = 20
				IF IS_PLAYER_IN_ZONE player PARK				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE20 ) 5000 1 //Take me to the park  

			taxi_destx1 = 27.56  
			taxi_desty1 = -776.42 
			taxi_destz1 = 26.26

			taxi_destx2 = 38.79 
			taxi_desty2 = -765.06 
			taxi_destz2 = 28.57
		ENDIF
	ENDIF 


	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN //SUBURBIA*******************************************

		GENERATE_RANDOM_INT_IN_RANGE 21 27  been_in_taxi1_before

		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_taxi1_failed
		ENDIF

		IF been_in_taxi1_before = 21
				IF IS_PLAYER_IN_ZONE player AIRPORT
					GOTO passenger_destination
				ENDIF	
			PRINT_NOW ( FARE21 ) 5000 1 //Take me to the Airport

			taxi_destx1 = -744.5	   
			taxi_desty1 = -598.6
			taxi_destz1 = 8.0

			taxi_destx2 = -752.0 
			taxi_desty2 = -617.2 
			taxi_destz2 = 15.0
		ENDIF
		
		IF been_in_taxi1_before = 22
				IF IS_PLAYER_IN_ZONE player BIG_DAM				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE22 ) 5000 1 //Take me to the DAM 

			taxi_destx1 = -1111.3   
			taxi_desty1 = 522.9 
			taxi_destz1 = 65.0

			taxi_destx2 = -1101.0 
			taxi_desty2 = 516.7 
			taxi_destz2 = 70.0
		ENDIF

		IF been_in_taxi1_before = 23
				IF IS_PLAYER_IN_ZONE player SUB_IND				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE23 ) 5000 1 //Take me to the Import/Export garage 

			taxi_destx1 = -1107.9   
			taxi_desty1 = 163.5 
			taxi_destz1 = 50.0

			taxi_destx2 = -1115.4 
			taxi_desty2 = 155.6 
			taxi_destz2 = 68.0
		ENDIF
		
		IF been_in_taxi1_before = 24
				IF IS_PLAYER_IN_ZONE player SUB_IND				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE24 ) 5000 1 //Take me to the Hospital 

			taxi_destx1 = -1253.0   
			taxi_desty1 = -136.6 
			taxi_destz1 = 55.0

			taxi_destx2 = -1260.3 
			taxi_desty2 = -148.4 
			taxi_destz2 = 62.0
		ENDIF
		
		IF been_in_taxi1_before = 25
				IF IS_PLAYER_IN_ZONE player SUB_ZO2
				OR IS_PLAYER_IN_ZONE player SUB_ZO3				
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE25 ) 5000 1 //Park 

			taxi_destx1 = -230.1   
			taxi_desty1 = 311.5 
			taxi_destz1 = 0.0

			taxi_destx2 = -220.2 
			taxi_desty2 = 322.5 
			taxi_destz2 = 10.0
		ENDIF

		IF been_in_taxi1_before = 26
				IF IS_PLAYER_IN_ZONE player PROJECT
				OR IS_PLAYER_IN_ZONE player SWANKS
					GOTO passenger_destination
				ENDIF
			PRINT_NOW ( FARE26 ) 5000 1 //Projects 

			taxi_destx1 = -682.5   
			taxi_desty1 = 95.3 
			taxi_destz1 = 10.0

			taxi_destx2 = -673.0 
			taxi_desty2 = 88.4 
			taxi_destz2 = 25.0
		ENDIF


	ENDIF
	 

	taxi_blipx = taxi_destx1 + taxi_destx2
	taxi_blipx /= 2.0

	taxi_blipy = taxi_desty1 + taxi_desty2
	taxi_blipy /= 2.0

	ADD_BLIP_FOR_COORD taxi_blipx taxi_blipy -100.0 blip2_ct1
	CHANGE_BLIP_DISPLAY blip2_ct1 BLIP_ONLY


IF IS_CAR_DEAD taxi_car1
	GOTO mission_taxi1_failed
ENDIF

x_diff = taxi_ped_x - taxi_blipx
y_diff = taxi_ped_y - taxi_blipy

x_diff_sq = x_diff * x_diff
y_diff_sq = y_diff * y_diff

taxi_distance_sq = x_diff_sq + y_diff_sq
SQRT taxi_distance_sq taxi_distance
taxi_distance_int =# taxi_distance
taxi_distance_int_old = taxi_distance_int 


IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	IF taxi_passed_this_shot = 0
		taxi_distance_int = taxi_distance_int * 100
	ENDIF
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	IF taxi_passed_this_shot = 0
		taxi_distance_int = taxi_distance_int * 95
	ENDIF
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	IF taxi_passed_this_shot = 0
		taxi_distance_int = taxi_distance_int * 115
	ENDIF
ENDIF

	IF taxi_passed_this_shot = 1
		taxi_distance_int = taxi_distance_int * 90
	ENDIF

	IF taxi_passed_this_shot = 2
		taxi_distance_int = taxi_distance_int * 85
	ENDIF

	IF taxi_passed_this_shot = 3
		taxi_distance_int = taxi_distance_int * 84
	ENDIF

	IF taxi_passed_this_shot = 4
		taxi_distance_int = taxi_distance_int * 83
	ENDIF

	IF taxi_passed_this_shot = 5
		taxi_distance_int = taxi_distance_int * 82
	ENDIF

	IF taxi_passed_this_shot > 5
	AND	taxi_passed_this_shot <= 10
	   taxi_distance_int = taxi_distance_int * 80
	ENDIF

	IF taxi_passed_this_shot > 11
	AND	taxi_passed_this_shot <= 20
	   taxi_distance_int = taxi_distance_int * 75
	ENDIF

	IF taxi_passed_this_shot > 20
	AND	taxi_passed_this_shot <= 50
	   taxi_distance_int = taxi_distance_int * 70
	ENDIF

	IF taxi_passed_this_shot > 50
	   taxi_distance_int = taxi_distance_int * 60
	ENDIF

taxi_countdown = taxi_countdown + taxi_distance_int

speedbonus = taxi_distance_int
speedbonus = speedbonus / 100
speedbonus = speedbonus * 65
{ 
TIMERB = 0

IF taxi_countdown_already_started = 0
	DISPLAY_ONSCREEN_TIMER taxi_countdown
	taxi_countdown_already_started = 1
ENDIF


IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN //SUBURBIA*******************************************
	IF taxi_passed_this_shot = 0
		taxi_countdown = taxi_countdown + 15000
	ENDIF
ELSE
	IF taxi_passed_this_shot = 0
		taxi_countdown = taxi_countdown + 10000
	ENDIF
ENDIF

WHILE NOT IS_CAR_STOPPED_IN_AREA_3D taxi_car1 taxi_destx1 taxi_desty1 taxi_destz1 taxi_destx2 taxi_desty2 taxi_destz2 TRUE
	WAIT 0 

		IF NOT IS_PLAYER_PLAYING player
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_DEAD taxi_car1
			GOTO mission_taxi1_failed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player taxi_car1	    
			GOTO mission_taxi1_failed				
		ENDIF

		GET_CONTROLLER_MODE controlmode
		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 SQUARE
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ENDIF

		IF taxi_countdown = 0
			GOTO taxi_out_of_time
		ENDIF

		IF NOT IS_CAR_HEALTH_GREATER taxi_car1 500
			IF spray_blip_onscreen = 0
				REMOVE_BLIP spray_taxi
				IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL 
					ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY spray_taxi
				ENDIF
				IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
					ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 -100.0 RADAR_SPRITE_SPRAY spray_taxi
				ENDIF
				IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
					ADD_SPRITE_BLIP_FOR_COORD -1128.0 32.5.8 -100.0 RADAR_SPRITE_SPRAY spray_taxi
				ENDIF
				spray_blip_onscreen = 1
				GOSUB taxi_fucked
				GOTO mission_taxi1_passed 
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD taxi_car1
			IF IS_CAR_HEALTH_GREATER taxi_car1 500
			AND spray_blip_onscreen = 1
				REMOVE_BLIP spray_taxi
				spray_blip_onscreen = 0
				taxi_fucked_flag = 0
			ENDIF
		ENDIF

		IF IS_CAR_UPSIDEDOWN taxi_car1
		AND IS_CAR_STOPPED taxi_car1
			GOTO taxi_fucked
		ENDIF

ENDWHILE


score: 

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN //SUBURBIA*******************************************
							  
	IF TIMERB > speedbonus
		score_for_this_fare = taxi_distance_int_old 
		PRINT_BIG ( TAXI4 ) 5000 5 //Fare delivered
	ELSE
		score_for_this_fare = taxi_distance_int_old	* 2
		PRINT_BIG ( TAXI5 ) 5000 5 //Speed Bonus!!
	ENDIF

ELSE

	IF TIMERB > speedbonus
		score_for_this_fare = taxi_distance_int_old / 2
		PRINT_BIG ( TAXI4 ) 5000 5 //Fare delivered
	ELSE
		score_for_this_fare = taxi_distance_int_old
		PRINT_BIG ( TAXI5 ) 5000 5 //Speed Bonus!!
	ENDIF

ENDIF

}
//score_for_this_fare = taxi_distance_int_old

	
	ADD_SCORE player score_for_this_fare
	PRINT_WITH_NUMBER_BIG ( TSCORE2 ) score_for_this_fare 6000 6 //Your score is...
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	taxi_score = taxi_score + score_for_this_fare

	taxi_passed ++
	REGISTER_PASSENGER_DROPPED_OFF_TAXI
	taxi_passed_this_shot ++
					   
	//CREATE NEW TAXI AFTER COMPLETING 100 TAXI MISSIONS 
	IF new_taxi_created_before = 0
	AND taxi_passed = 100
		ADD_PAGER_MESSAGE ( NEW_TAX ) 140 2 0
  		SWITCH_CAR_GENERATOR swank_taxi 101
		PLAYER_MADE_PROGRESS 1
  		new_taxi_created_before = 1 							
	ENDIF

	taxi_countdown = taxi_countdown + 10000

	GOSUB mission_taxi1_failed

	IF taxi_passed_this_shot = in_a_row_number
		PRINT_WITH_2_NUMBERS_BIG ( IN_ROW ) taxi_passed_this_shot in_a_row_cash 5000 6 //Bonus!
		ADD_SCORE player in_a_row_cash
		taxi_score = taxi_score + in_a_row_cash
		in_a_row_number = in_a_row_number + 5
		in_a_row_cash = in_a_row_cash + 2000
	ENDIF

	/*
	IF taxi_passed_this_shot = 10
		PRINT_WITH_2_NUMBERS_BIG  ( IN_ROW ) taxi_passed_this_shot 2000 6000 6 //Bonus!
		taxi_score = taxi_score + 2000
		ADD_SCORE player 1000
	ENDIF

	IF taxi_passed_this_shot = 15
		PRINT_WITH_2_NUMBERS_BIG  ( IN_ROW ) taxi_passed_this_shot 4000 6000 6 //Bonus!
		taxi_score = taxi_score + 4000
		ADD_SCORE player 2000
	ENDIF

	IF taxi_passed_this_shot = 20
		PRINT_WITH_2_NUMBERS_BIG  ( IN_ROW ) taxi_passed_this_shot 8000 6000 6 //Bonus!
		taxi_score = taxi_score + 8000
		ADD_SCORE player 4000
	ENDIF

	IF taxi_passed_this_shot = 25
		PRINT_WITH_2_NUMBERS_BIG  ( IN_ROW ) taxi_passed_this_shot 16000 6000 6 //Bonus!
		taxi_score = taxi_score + 16000
		ADD_SCORE player 8000
	ENDIF

 	IF taxi_passed_this_shot = 30
		PRINT_WITH_2_NUMBERS_BIG  ( IN_ROW ) taxi_passed_this_shot 32000 6000 6 //Bonus!
		taxi_score = taxi_score + 32000
		ADD_SCORE player 16000
	ENDIF
	*/
	GOTO mission_taxi1_passed


//Taxi_fail_conditions

taxi_out_of_time:

	PRINT_NOW ( TAXI2 ) 5000 1 //Out of time

	GOTO mission_taxi1_failed

taxi_fucked:

	WAIT 0

	PRINT_NOW ( TAXI3 ) 5000 1 //Taxi is trashed

		IF NOT IS_CHAR_DEAD	taxi_ped1
			//SET_CHAR_PERSONALITY taxi_ped1 PEDSTAT_TOURIST
			SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE taxi_ped1
			//SET_CHAR_THREAT_SEARCH taxi_ped1 THREAT_PLAYER1
		ENDIF
		taxi_fucked_flag = 1

	GOTO mission_taxi1_failed


taxi_fail_button_pressed:

	GET_CONTROLLER_MODE controlmode
	IF NOT controlmode = 3
		WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			WAIT 0
			IF NOT IS_PLAYER_PLAYING player	// ok to fail if player is arrested?
				GOTO mission_taxi1_failed
			ENDIF
		ENDWHILE
	ELSE
		WHILE IS_BUTTON_PRESSED PAD1 SQUARE
			WAIT 0
			IF NOT IS_PLAYER_PLAYING player	// ok to fail if player is arrested?
				GOTO mission_taxi1_failed
			ENDIF
		ENDWHILE
	ENDIF

	GOTO mission_taxi1_failed


// Mission taxi1 failed
/*
mission_taxi1_failed: 

GOSUB taxi_ped_leave

RETURN
*/
// mission taxi1 passed

mission_taxi1_passed:

	REMOVE_BLIP blip1_ct1
	REMOVE_BLIP blip2_ct1
	MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1

	IF NOT IS_CAR_DEAD taxi_car1
		SET_TAXI_LIGHTS taxi_car1 On
	ENDIF

	//WAIT 1000
	WAIT 0
	PRINT_SOON ( TAXI1 ) 1500 1 //Pick up a fare
		
	GOTO Start_taxi_mission
RETURN
		
mission_taxi1_failed: //taxi_ped_leave:

	IF NOT IS_CHAR_DEAD taxi_ped1
		IF NOT IS_CAR_DEAD taxi_car1
			IF IS_CHAR_IN_CAR taxi_ped1 taxi_car1
				SET_CHAR_OBJ_LEAVE_CAR taxi_ped1 taxi_car1
				IF IS_PLAYER_PLAYING player
					SET_PLAYER_CONTROL Player OFF
				ENDIF

				WHILE IS_CHAR_IN_CAR taxi_ped1 taxi_car1
			 		WAIT 0

					IF IS_CHAR_DEAD taxi_ped1
					OR IS_CAR_DEAD taxi_car1
						GOTO taxi_ped_leave2
					ENDIF
						
					IF NOT IS_PLAYER_PLAYING player
						GOTO taxi_ped_leave2
					ENDIF

					IF NOT IS_PLAYER_IN_CAR player taxi_car1	    
						GOTO taxi_ped_leave2				
					ENDIF

					GET_CONTROLLER_MODE controlmode
					IF NOT controlmode = 3
						IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						AND flag_player_on_mission = 1
							GOTO taxi_ped_leave2
						ENDIF
					ELSE
						IF IS_BUTTON_PRESSED PAD1 SQUARE
						AND flag_player_on_mission = 1
							GOTO taxi_ped_leave2
						ENDIF
					ENDIF

				ENDWHILE

			ENDIF
		ENDIF
	ENDIF

IF IS_PLAYER_PLAYING player
	SET_PLAYER_CONTROL Player ON
ENDIF

IF taxi_fucked_flag = 1
	RETURN
ENDIF

taxi_ped_leave2:

	WAIT 0

	IF NOT IS_CHAR_DEAD taxi_ped1
		IF NOT IS_CAR_DEAD taxi_car1
			IF NOT IS_CHAR_IN_CAR taxi_ped1 taxi_car1
				CHAR_WANDER_DIR taxi_ped1 0
				MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1
			ENDIF
		ENDIF
	ENDIF
	
	IF IS_PLAYER_PLAYING player
		SET_PLAYER_CONTROL Player ON
	ENDIF
	
RETURN

// mission cleanup

mission_cleanup_taxi1:
CLEAR_ONSCREEN_TIMER taxi_countdown
CLEAR_ONSCREEN_COUNTER taxi_passed_this_shot //TEST STUFF!!!!!!!!
IF NOT IS_CAR_DEAD taxi_car1
	SET_TAXI_LIGHTS taxi_car1 Off
ENDIF
//SWITCH_TAXI_TIMER OFF
REMOVE_BLIP blip1_ct1
REMOVE_BLIP blip2_ct1
REMOVE_BLIP spray_taxi
MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1
PRINT_BIG ( TAXI6 ) 5000 5 //Taxi mission over
PRINT_WITH_NUMBER_BIG ( TSCORE ) taxi_score 6000 6 //Your score is...
REGISTER_MONEY_MADE_TAXI taxi_score
SET_DEATHARREST_STATE on
flag_player_on_mission = 0
flag_taxi1_mission_launched = 0
IF IS_PLAYER_PLAYING player
	SET_PLAYER_CONTROL Player ON
ENDIF
CLEAR_HELP
MISSION_HAS_FINISHED
RETURN


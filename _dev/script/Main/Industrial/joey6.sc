MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// **************************************Joey Mission 6***************************************
// ****************************************Bank Job*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************


// Mission start stuff

GOSUB mission_start_joey6

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_joey6_failed
ENDIF

GOSUB mission_cleanup_joey6

MISSION_END


// Variables for mission

VAR_INT thug1 thug2 thug3 thugs_score joey_alarm_loop  flag_not_enough_seats

VAR_INT blip1_jm6 blip2_jm6 blip3_jm6 thug1_blip thug2_blip thug3_blip	

VAR_INT any_car_jm6 maxpassengers sound_already_created_before

VAR_INT flag_displayed_horn_message_jm6	flag_displayed_wanted_message_jm6

VAR_INT thug1_is_dead thug2_is_dead thug3_is_dead blip_for_thug_added1 blip_for_thug_added2 blip_for_thug_added3

VAR_INT objective_count objective_count_done_before1 objective_count_done_before2 objective_count_done_before3

VAR_FLOAT bankdoor_X bankdoor_Y bankdoor_Z bankdoor2_X bankdoor2_Y bankdoor2_Z

// ***************************************Mission Start*************************************


mission_start_joey6:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_joey_mission = 1
SCRIPT_NAME joey6
WAIT 0

{
LOAD_SPECIAL_CHARACTER 1 joey
LOAD_SPECIAL_MODEL cut_obj1 JOEYH
LOAD_SPECIAL_MODEL cut_obj2 PLAYERH
LOAD_SPECIAL_MODEL cut_obj3 TROLL
REQUEST_MODEL CAR_STALLION
REQUEST_MODEL jogarageext
REQUEST_MODEL jogarageint

LOAD_ALL_MODELS_NOW

//LOAD_SCENE 1190.07 -869.86 13.97

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED jogarageext 
OR NOT HAS_MODEL_LOADED jogarageint
OR NOT HAS_MODEL_LOADED CAR_STALLION
	WAIT 0
ENDWHILE

LOAD_CUTSCENE J6_TBJ
SET_CUTSCENE_OFFSET 1190.079 -869.861 13.977

CREATE_CAR CAR_STALLION 1192.9 -860.8 14.0 cut_car3_lm3
SET_CAR_HEADING cut_car3_lm3 150.0

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_joey
SET_CUTSCENE_ANIM cs_joey joey

CREATE_CUTSCENE_HEAD cs_joey CUT_OBJ1 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ2 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT CUT_OBJ3 cs_troll
SET_CUTSCENE_ANIM cs_troll TROLL
									  
CLEAR_AREA 1191.9 -870.4 15.0 1.0 TRUE
SET_PLAYER_COORDINATES player 1191.9 -870.4 -100.0

SET_PLAYER_HEADING player 230.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4434
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM6_A ) 10000 2 // Mission brief

WHILE cs_time < 6704
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM6_B ) 10000 2 // Mission brief

WHILE cs_time < 12000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM6_C ) 10000 2 // Mission brief

WHILE cs_time < 14274
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM6_D ) 10000 2 // Mission brief

WHILE cs_time < 17302
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( JM6_E ) 10000 2 // Mission brief
		 
WHILE cs_time < 21000
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STALLION
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageext 
MARK_MODEL_AS_NO_LONGER_NEEDED jogarageint

DELETE_CAR cut_car3_lm3

thugs_score	= 0
sound_already_created_before = 0
flag_not_enough_seats = 0

LOAD_SPECIAL_CHARACTER 2 robber

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
		WAIT 0
	ENDWHILE



// START OF MISSION

ADD_BLIP_FOR_COORD 1086.0 -227.0 -100.0 blip1_jm6
CHANGE_BLIP_DISPLAY blip1_jm6 BLIP_ONLY

flag_displayed_horn_message_jm6 = 0
flag_displayed_wanted_message_jm6 = 0

thug1_is_dead = 0
thug2_is_dead = 0
thug3_is_dead = 0
blip_for_thug_added1 = 0
blip_for_thug_added2 = 0
blip_for_thug_added3 = 0

//PICK UP THE THUGS

pick_up_thugs:
WAIT 0

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_IN_CAR_2D player 1089.9 -223.9 1084.5 -228.5 TRUE
OR NOT IS_PLAYER_PRESSING_HORN player
OR IS_WANTED_LEVEL_GREATER Player 0    	
	WAIT 0

	IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_2D player 1089.9 -223.9 1084.5 -228.5 FALSE

		IF IS_WANTED_LEVEL_GREATER player 0
			IF flag_not_enough_seats = 0
				PRINT_NOW ( WANTED1 ) 5000 1
			ENDIF
		ELSE
			IF flag_not_enough_seats = 0
				PRINT_NOW ( HORN ) 5000 1
			ENDIF
		ENDIF
	ELSE
		flag_not_enough_seats = 0
	ENDIF

	IF NOT IS_PLAYER_IN_AREA_IN_CAR_2D player 1089.9 -223.9 1084.5 -228.5 FALSE
		CLEAR_THIS_PRINT ( WANTED1 )
		CLEAR_THIS_PRINT ( HORN )
	ENDIF

	IF IS_PLAYER_IN_AREA_ON_FOOT_2D player 1089.9 -223.9 1084.5 -228.5 FALSE
		PRINT_NOW ( JM6_5 ) 5000 1 //"We need a getaway vehicle"
	ELSE
		CLEAR_THIS_PRINT ( JM6_5 )
	ENDIF

	GET_TIME_OF_DAY hours minutes
	IF hours >= 17
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

ENDWHILE  								

	STORE_CAR_PLAYER_IS_IN player any_car_jm6

	GET_MAXIMUM_NUMBER_OF_PASSENGERS any_car_jm6 maxpassengers

	CLEAR_THIS_PRINT ( WANTED1 )
	CLEAR_THIS_PRINT ( HORN )

	IF NOT maxpassengers > 2	//	GSW - Changed this from a WHILE
		PRINT_NOW ( NODOORS ) 5000 1 //Car not big enough
		flag_not_enough_seats = 1	
		GOTO pick_up_thugs
	ENDIF

	IF IS_PLAYER_IN_MODEL Player CAR_COACH
	OR IS_PLAYER_IN_MODEL Player CAR_BUS
		PRINT_NOW ( JM6_6 ) 5000 1 //Go and get a vehicle less conspicuous
		flag_not_enough_seats = 1		
		GOTO pick_up_thugs
	ENDIF

//PICK UP THUGS CUT_SCENE**************************************************************************************
 
CLEAR_AREA 1087.7 -229.2 8.0 6.0 TRUE

IF NOT IS_CAR_DEAD any_car_jm6
	LOCK_CAR_DOORS any_car_jm6 CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

WAIT 500

SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player ON
SET_EVERYONE_IGNORE_PLAYER Player ON

IF NOT IS_CAR_DEAD any_car_jm6
	LOCK_CAR_DOORS any_car_jm6 CARLOCK_UNLOCKED
ENDIF

	REMOVE_BLIP blip1_jm6

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1086.5 -238.3 9.0 thug1
	TURN_CHAR_TO_FACE_PLAYER thug1 Player
	CHAR_SET_IDLE thug1

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1088.4 -237.9 9.0 thug2
	TURN_CHAR_TO_FACE_PLAYER thug2 Player
	CHAR_SET_IDLE thug2

	CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1090.4 -238.0 9.0 thug3
	TURN_CHAR_TO_FACE_PLAYER thug3 Player
	CHAR_SET_IDLE thug3

	GIVE_WEAPON_TO_CHAR thug1 WEAPONTYPE_PISTOL 100
	GIVE_WEAPON_TO_CHAR thug2 WEAPONTYPE_SHOTGUN 50
	GIVE_WEAPON_TO_CHAR thug3 WEAPONTYPE_UZI 100

SET_FIXED_CAMERA_POSITION 1078.773 -232.474 12.190 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1079.691 -232.132 11.990 JUMP_CUT
	
	//APPLY_BRAKES_TO_PLAYERS_CAR Player On

	SET_CHAR_PERSONALITY thug1 PEDSTAT_TOUGH_GUY
	SET_CHAR_PERSONALITY thug2 PEDSTAT_TOUGH_GUY
	SET_CHAR_PERSONALITY thug3 PEDSTAT_TOUGH_GUY

	SET_CHAR_THREAT_SEARCH thug1 THREAT_COP
	SET_CHAR_THREAT_SEARCH thug2 THREAT_COP
	SET_CHAR_THREAT_SEARCH thug3 THREAT_COP

WAIT 1000

WHILE NOT SLIDE_OBJECT Bank_job_door 1087.523 -233.801 13.5 0.0 0.0 0.07 FALSE
	WAIT 0

	GET_TIME_OF_DAY hours minutes
	IF hours >= 17
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

	IF IS_CHAR_DEAD thug1
	OR IS_CHAR_DEAD thug2
	OR IS_CHAR_DEAD thug3
		PRINT_NOW ( JM6_7 ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD thug1
	SET_PLAYER_AS_LEADER thug1 player
	SET_CHAR_RUNNING thug1 TRUE
	WAIT 800
ENDIF

IF NOT IS_CHAR_DEAD thug2
	SET_PLAYER_AS_LEADER thug2 player
	SET_CHAR_RUNNING thug2 TRUE
	WAIT 800
ENDIF

IF NOT IS_CHAR_DEAD thug3
	SET_PLAYER_AS_LEADER thug3 player
	SET_CHAR_RUNNING thug3 TRUE
	//WAIT 400
ENDIF


IF NOT IS_CAR_DEAD any_car_jm6
AND NOT IS_CHAR_DEAD thug1
AND NOT IS_CHAR_DEAD thug2
AND NOT IS_CHAR_DEAD thug3

TIMERB = 0

	WHILE NOT IS_CHAR_IN_CAR thug1 any_car_jm6 
	OR NOT IS_CHAR_IN_CAR thug2 any_car_jm6 
	OR NOT IS_CHAR_IN_CAR thug3 any_car_jm6 
		WAIT 0

			IF IS_CHAR_DEAD thug1
			OR IS_CHAR_DEAD thug2
			OR IS_CHAR_DEAD thug3
				PRINT_NOW ( JM6_7 ) 5000 1
				GOTO mission_joey6_failed
			ENDIF
			
			IF IS_CAR_DEAD any_car_jm6
				GOTO mission_joey6_failed
			ENDIF

			GET_TIME_OF_DAY hours minutes
			IF hours >= 17
				PRINT_NOW ( OUTTIME ) 5000 1
				GOTO mission_joey6_failed
			ENDIF

			IF TIMERB > 15000
				GOTO next_robber_bit
			ENDIF

	ENDWHILE

ENDIF

next_robber_bit:

//SAMPLE1*********************************************************
LOAD_MISSION_AUDIO J6_A

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO

RESTORE_CAMERA_JUMPCUT
APPLY_BRAKES_TO_PLAYERS_CAR Player OFF
SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF

//END OF PICK UP THUGS CUT_SCENE*******************************************************************************

	PRINT_NOW ( JM6_1 ) 5000 1 //"Lets go"

WHILE NOT SLIDE_OBJECT Bank_job_door 1087.523 -233.801 11.012 0.0 0.0 0.2 FALSE
	WAIT 0

	GET_TIME_OF_DAY hours minutes
	IF hours >= 17
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

	IF IS_CHAR_DEAD thug1
	OR IS_CHAR_DEAD thug2
	OR IS_CHAR_DEAD thug3
		PRINT_NOW ( JM6_7 ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

ENDWHILE
	
	ADD_BLIP_FOR_COORD 1038.0 -700.0 -100.0 blip3_jm6
	//CHANGE_BLIP_DISPLAY blip3_jm6 BLIP_ONLY
	flag_displayed_wanted_message_jm6 = 0
	
		
//GET TO THE BANK
get_to_the_bank:
WAIT 0

	IF IS_CAR_DEAD any_car_jm6
		//Do nothing
	ENDIF

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_3D player 1040.5 -691.5 14.0 1043.8 -698.5 17.0 TRUE
OR NOT IS_PLAYER_IN_ANY_CAR player
OR IS_WANTED_LEVEL_GREATER Player 0    	
	WAIT 0

	IF IS_CAR_DEAD any_car_jm6
		//GO GET ANOTHER ONE	
	ENDIF

	IF IS_PLAYER_IN_ANY_CAR Player
		STORE_CAR_PLAYER_IS_IN player any_car_jm6
	ENDIF

	IF NOT IS_CHAR_DEAD thug1
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug1 player
			IF blip_for_thug_added1 = 0
				ADD_BLIP_FOR_CHAR thug1 thug1_blip
				blip_for_thug_added1 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug1 30.0 30.0 FALSE
		   		IF blip_for_thug_added1 = 1
					SET_PLAYER_AS_LEADER thug1 player
					REMOVE_BLIP	thug1_blip
					blip_for_thug_added1 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug2 player
			IF blip_for_thug_added2 = 0
				ADD_BLIP_FOR_CHAR thug2 thug2_blip
				blip_for_thug_added2 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug2 30.0 30.0 FALSE
		   		IF blip_for_thug_added2 = 1
					SET_PLAYER_AS_LEADER thug2 player
					REMOVE_BLIP	thug2_blip
					blip_for_thug_added2 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug3 player
			IF blip_for_thug_added3 = 0
				ADD_BLIP_FOR_CHAR thug3 thug3_blip
				blip_for_thug_added3 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug3 30.0 30.0 FALSE
		   		IF blip_for_thug_added3 = 1
					SET_PLAYER_AS_LEADER thug3 player
					REMOVE_BLIP	thug3_blip
					blip_for_thug_added3 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF IS_CHAR_DEAD thug1
	OR IS_CHAR_DEAD thug2
	OR IS_CHAR_DEAD thug3
		PRINT_NOW ( JM6_7 ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

	IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 1040.5 -691.5 14.0 1043.8 -698.5 17.0 FALSE
		IF IS_WANTED_LEVEL_GREATER player 0
			IF flag_displayed_wanted_message_jm6 = 0
				PRINT_NOW ( WANTED1 ) 5000 1
				flag_displayed_wanted_message_jm6 = 1
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_PLAYER_IN_AREA_3D player 1040.5 -691.5 14.0 1043.8 -698.5 17.0 FALSE
			flag_displayed_wanted_message_jm6 = 0
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_AREA_ON_FOOT_3D player 1040.5 -691.5 14.0 1043.8 -698.5 17.0 FALSE
		PRINT_NOW ( JM6_5 ) 5000 1 //"We need a getaway vehicle"
	ELSE
		CLEAR_THIS_PRINT ( JM6_5 )
	ENDIF

	GET_TIME_OF_DAY hours minutes
	IF hours >= 17
		PRINT_NOW ( OUTTIME ) 5000 1
		GOTO mission_joey6_failed
	ENDIF

ENDWHILE

IF IS_PLAYER_IN_MODEL Player CAR_COACH
OR IS_PLAYER_IN_MODEL Player CAR_BUS
	PRINT_NOW ( JM6_6 ) 5000 1 //Go and get a vehicle less conspicuous
	//WAIT 3000	
	GOTO get_to_the_bank
ENDIF

IF IS_CHAR_DEAD thug1
OR IS_CHAR_DEAD thug2
OR IS_CHAR_DEAD thug3
	PRINT_NOW ( JM6_7 ) 5000 1
	GOTO mission_joey6_failed
ENDIF

IF NOT IS_CHAR_IN_CAR thug1 any_car_jm6
OR NOT IS_CHAR_IN_CAR thug2 any_car_jm6
OR NOT IS_CHAR_IN_CAR thug3 any_car_jm6
	PRINT_NOW ( JM6_7 ) 5000 1 //Go and get a vehicle less conspicuous
	//WAIT 3000	
	GOTO get_to_the_bank
ENDIF

// BANK ROBBERY CUT SCENE**************************************************************************************

CLEAR_AREA 1037.3 -699.6 15.0 6.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0

SET_PLAYER_CONTROL Player OFF
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player ON
SET_EVERYONE_IGNORE_PLAYER Player On
APPLY_BRAKES_TO_PLAYERS_CAR Player ON

SET_FIXED_CAMERA_POSITION 1036.448 -705.615 14.512 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1036.637 -704.639 14.624 JUMP_CUT
	
	REMOVE_BLIP blip3_jm6

//SAMPLE2*********************************************************

	LOAD_MISSION_AUDIO J6_B

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

	PLAY_MISSION_AUDIO

	PRINT_NOW ( JM6_2 ) 5000 1 //"Wait here"


	STORE_CAR_PLAYER_IS_IN player any_car_jm6

	IF NOT IS_CAR_DEAD any_car_jm6 
		IF NOT IS_CHAR_DEAD thug1
			LEAVE_GROUP thug1
			SET_CHAR_OBJ_LEAVE_CAR thug1 any_car_jm6
		ENDIF
	ENDIF

	WAIT 400	
	
	IF NOT IS_CAR_DEAD any_car_jm6 
		IF NOT IS_CHAR_DEAD thug2 
			LEAVE_GROUP thug2
			SET_CHAR_OBJ_LEAVE_CAR thug2 any_car_jm6
		ENDIF
	ENDIF

	WAIT 400	

	IF NOT IS_CAR_DEAD any_car_jm6	
		IF NOT IS_CHAR_DEAD thug3 
			LEAVE_GROUP thug3
			SET_CHAR_OBJ_LEAVE_CAR thug3 any_car_jm6
		ENDIF
	ENDIF


objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0


//WAITING FOR THUGS TO GET OUT OF CAR

WHILE NOT objective_count = 3   

		WAIT 0

		IF IS_CHAR_DEAD thug1
		AND objective_count_done_before1 = 0
			objective_count ++
			objective_count_done_before1 = 1
			thug1_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug2
		AND objective_count_done_before2 = 0
			objective_count ++
			objective_count_done_before2 = 1
			thug2_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug3
		AND objective_count_done_before3 = 0
			objective_count ++
			objective_count_done_before3 = 1
			thug3_is_dead = 1
		ENDIF

		IF thug1_is_dead = 1
		AND thug2_is_dead = 1
		AND thug3_is_dead = 1
			GOTO mission_joey6_failed
		ENDIF
			
		IF IS_CAR_DEAD any_car_jm6
			GOTO mission_joey6_failed
		ENDIF

		IF NOT IS_CAR_DEAD any_car_jm6
		AND NOT IS_CHAR_DEAD thug1
			IF thug1_is_dead = 0
				IF NOT IS_CHAR_IN_CAR thug1 any_car_jm6 
				AND objective_count_done_before1 = 0					
					SET_CHAR_OBJ_RUN_TO_COORD thug1 1037.4 -699.9
					WAIT 300
					objective_count ++
					objective_count_done_before1 = 1						
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD any_car_jm6
		AND NOT IS_CHAR_DEAD thug2
			IF thug2_is_dead = 0
				IF NOT IS_CHAR_IN_CAR thug2 any_car_jm6 
				AND objective_count_done_before2 = 0					
					SET_CHAR_OBJ_RUN_TO_COORD thug2 1037.4 -699.9
					WAIT 300
					objective_count ++
					objective_count_done_before2 = 1						
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD any_car_jm6
		AND NOT IS_CHAR_DEAD thug3
			IF thug3_is_dead = 0
				IF NOT IS_CHAR_IN_CAR thug3 any_car_jm6 
				AND objective_count_done_before3 = 0					
					SET_CHAR_OBJ_RUN_TO_COORD thug3 1037.4 -699.9
					objective_count ++
					objective_count_done_before3 = 1						
				ENDIF
			ENDIF
		ENDIF	

ENDWHILE

//THUGS GO IN THE BANK
 /*
	IF NOT IS_CHAR_DEAD thug1
		SET_CHAR_OBJ_RUN_TO_COORD thug1 1037.4 -699.9
		WAIT 400
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		SET_CHAR_OBJ_RUN_TO_COORD thug2 1037.4 -699.9 
		WAIT 400
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		SET_CHAR_OBJ_RUN_TO_COORD thug3 1037.4 -699.9 
	ENDIF
  */
objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0

GET_OBJECT_COORDINATES bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z
bankdoor_Y = bankdoor_Y - 1.0

GET_OBJECT_COORDINATES bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z
bankdoor2_Y = bankdoor2_Y + 1.0

WHILE NOT SLIDE_OBJECT bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z 0.0 0.1 0.0 FALSE
OR NOT SLIDE_OBJECT bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z 0.0 0.1 0.0 FALSE
	WAIT 0

ENDWHILE


TIMERB = 0

WHILE NOT objective_count = 3

	WAIT 0

		IF IS_CHAR_DEAD thug1
		AND objective_count_done_before1 = 0
			objective_count ++
			objective_count_done_before1 = 1
			thug1_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug2
		AND objective_count_done_before2 = 0
			objective_count ++
			objective_count_done_before2 = 1
			thug2_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug3
		AND objective_count_done_before3 = 0
			objective_count ++
			objective_count_done_before3 = 1
			thug3_is_dead = 1
		ENDIF

		IF thug1_is_dead = 1
		AND thug2_is_dead = 1
		AND thug3_is_dead = 1
			GOTO mission_joey6_failed
		ENDIF

		IF thug1_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug1
			AND objective_count_done_before1 = 0
				SET_CHAR_OBJ_RUN_TO_COORD thug1 1032.9 -700.2		
				objective_count ++
				objective_count_done_before1 = 1		
			ENDIF
		ENDIF

		IF thug2_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug2
			AND objective_count_done_before2 = 0
				SET_CHAR_OBJ_RUN_TO_COORD thug2 1032.9 -700.2		
				objective_count ++
				objective_count_done_before2 = 1		
			ENDIF
		ENDIF

		IF thug3_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug3
			AND objective_count_done_before3 = 0
				SET_CHAR_OBJ_RUN_TO_COORD thug3 1032.9 -700.2		
				objective_count ++
				objective_count_done_before3 = 1		
			ENDIF
		ENDIF

		IF TIMERB > 15000
			IF NOT IS_CHAR_DEAD	thug1
				SET_CHAR_COORDINATES thug1 1037.4 -699.9 13.9
			ENDIF
			IF NOT IS_CHAR_DEAD	thug2
				SET_CHAR_COORDINATES thug2 1037.4 -699.9 13.9
			ENDIF
			IF NOT IS_CHAR_DEAD	thug3
				SET_CHAR_COORDINATES thug3 1037.4 -699.9 13.9
			ENDIF
		ENDIF

		
ENDWHILE

objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0


TIMERB = 0

WHILE NOT objective_count = 3

	WAIT 0

		IF IS_CHAR_DEAD thug1
		AND objective_count_done_before1 = 0
			objective_count ++
			objective_count_done_before1 = 1
			thug1_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug2
		AND objective_count_done_before2 = 0
			objective_count ++
			objective_count_done_before2 = 1
			thug2_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug3
		AND objective_count_done_before3 = 0
			objective_count ++
			objective_count_done_before3 = 1
			thug3_is_dead = 1
		ENDIF

		IF thug1_is_dead = 1
		AND thug2_is_dead = 1
		AND thug3_is_dead = 1
			GOTO mission_joey6_failed
		ENDIF

		IF thug1_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug1
			AND objective_count_done_before1 = 0		
				SET_CHAR_COORDINATES thug1 1104.0 -792.0 14.0
				SET_CHAR_OBJ_WAIT_ON_FOOT thug1
				objective_count ++
				objective_count_done_before1 = 1		
			ENDIF
		ENDIF

		IF thug2_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug2
			AND objective_count_done_before2 = 0		
				SET_CHAR_COORDINATES thug2 1102.0 -792.0 14.0
				SET_CHAR_OBJ_WAIT_ON_FOOT thug2
				objective_count ++
				objective_count_done_before2 = 1		
			ENDIF
		ENDIF

		IF thug3_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug3
			AND objective_count_done_before3 = 0		
				SET_CHAR_COORDINATES thug3 1100.0 -792.0 14.0
				SET_CHAR_OBJ_WAIT_ON_FOOT thug3
				objective_count ++
				objective_count_done_before3 = 1		
			ENDIF
		ENDIF

		IF TIMERB > 15000
			IF NOT IS_CHAR_DEAD	thug1
				SET_CHAR_COORDINATES thug1 1032.9 -700.2 13.9
			ENDIF
			IF NOT IS_CHAR_DEAD	thug2
				SET_CHAR_COORDINATES thug2 1032.9 -700.2 13.9
			ENDIF
			IF NOT IS_CHAR_DEAD	thug3
				SET_CHAR_COORDINATES thug3 1032.9 -700.2 13.9
			ENDIF
		ENDIF

ENDWHILE

LOAD_MISSION_AUDIO J6_1

GET_OBJECT_COORDINATES bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z
bankdoor_Y = bankdoor_Y + 1.0

GET_OBJECT_COORDINATES bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z
bankdoor2_Y = bankdoor2_Y - 1.0

WHILE NOT SLIDE_OBJECT bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z 0.0 0.1 0.0 FALSE
OR NOT SLIDE_OBJECT bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z 0.0 0.1 0.0 FALSE
	WAIT 0

ENDWHILE


//WAIT 1000

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

	PLAY_MISSION_AUDIO

	WHILE NOT HAS_MISSION_AUDIO_FINISHED
		WAIT 0

	ENDWHILE

WAIT 1000

//THUGS COME OUT OF BANK

CLEAR_AREA 1037.3 -699.6 15.0 4.0 TRUE

GET_OBJECT_COORDINATES bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z
bankdoor_Y = bankdoor_Y - 1.0

GET_OBJECT_COORDINATES bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z
bankdoor2_Y = bankdoor2_Y + 1.0

WHILE NOT SLIDE_OBJECT bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z 0.0 0.1 0.0 FALSE
OR NOT SLIDE_OBJECT bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z 0.0 0.1 0.0 FALSE
	WAIT 0

ENDWHILE

	IF NOT IS_CHAR_DEAD thug1		   
	   SET_CHAR_COORDINATES thug1 1032.9 -700.2 15.0
	   SET_CHAR_OBJ_RUN_TO_COORD thug1 1036.9 -700.2
	   //SET_PLAYER_AS_LEADER thug1 player
	ENDIF

	WAIT 800

	IF NOT IS_CHAR_DEAD thug2
		SET_CHAR_COORDINATES thug2 1032.9 -700.2 15.0
	    SET_CHAR_OBJ_RUN_TO_COORD thug2 1036.9 -700.2
	ENDIF

	WAIT 800

	IF NOT IS_CHAR_DEAD thug3
		SET_CHAR_COORDINATES thug3 1032.9 -700.2 15.0
	    SET_CHAR_OBJ_RUN_TO_COORD thug3 1036.9 -700.2
	ENDIF

objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0


TIMERB = 0

WHILE NOT objective_count = 3
	WAIT 0

	IF IS_CHAR_DEAD thug1
	AND objective_count_done_before1 = 0
		objective_count ++
		objective_count_done_before1 = 1
		thug1_is_dead = 1
	ENDIF

	IF IS_CHAR_DEAD thug2
	AND objective_count_done_before2 = 0
		objective_count ++
		objective_count_done_before2 = 1
		thug2_is_dead = 1
	ENDIF

	IF IS_CHAR_DEAD thug3
	AND objective_count_done_before3 = 0
		objective_count ++
		objective_count_done_before3 = 1
		thug3_is_dead = 1
	ENDIF

	IF thug1_is_dead = 1
	AND thug2_is_dead = 1
	AND thug3_is_dead = 1
		GOTO mission_joey6_failed
	ENDIF

	IF thug1_is_dead = 0
		IF IS_CHAR_OBJECTIVE_PASSED thug1
		AND objective_count_done_before1 = 0		
			SET_PLAYER_AS_LEADER thug1 player
			objective_count ++
			objective_count_done_before1 = 1		
		ENDIF
	ENDIF

	IF thug2_is_dead = 0
		IF IS_CHAR_OBJECTIVE_PASSED thug2
		AND objective_count_done_before2 = 0		
			SET_PLAYER_AS_LEADER thug2 player
			objective_count ++
			objective_count_done_before2 = 1		
		ENDIF
	ENDIF

	IF thug3_is_dead = 0
		IF IS_CHAR_OBJECTIVE_PASSED thug3
		AND objective_count_done_before3 = 0		
			SET_PLAYER_AS_LEADER thug3 player
			objective_count ++
			objective_count_done_before3 = 1		
		ENDIF
	ENDIF

	IF TIMERB > 15000
		IF NOT IS_CHAR_DEAD	thug1
			SET_CHAR_COORDINATES thug1 1036.9 -700.2 13.9
		ENDIF
		IF NOT IS_CHAR_DEAD	thug2
			SET_CHAR_COORDINATES thug2 1036.9 -700.2 13.9
		ENDIF
		IF NOT IS_CHAR_DEAD	thug3
			SET_CHAR_COORDINATES thug3 1036.9 -700.2 13.9
		ENDIF
	ENDIF

ENDWHILE

ADD_CONTINUOUS_SOUND 1034.8 -700.1 15.0 SOUND_BANK_ALARM_LOOP_L joey_alarm_loop 
sound_already_created_before = 1

//SAMPLE3*********************************************************
	LOAD_MISSION_AUDIO J6_D

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

	PLAY_MISSION_AUDIO


ALTER_WANTED_LEVEL_NO_DROP Player 3

	GET_OBJECT_COORDINATES bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z
	bankdoor_Y = bankdoor_Y + 1.0

	GET_OBJECT_COORDINATES bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z
	bankdoor2_Y = bankdoor2_Y - 1.0

	WHILE NOT SLIDE_OBJECT bankdoor1 bankdoor_X bankdoor_Y bankdoor_Z 0.0 0.1 0.0 FALSE
	OR NOT SLIDE_OBJECT bankdoor2 bankdoor2_X bankdoor2_Y bankdoor2_Z 0.0 0.1 0.0 FALSE
		WAIT 0

	ENDWHILE

WHILE NOT HAS_MISSION_AUDIO_FINISHED
	WAIT 0

ENDWHILE

objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0

SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF
APPLY_BRAKES_TO_PLAYERS_CAR Player Off
SET_PED_DENSITY_MULTIPLIER 1.0


TIMERB = 0

WHILE NOT objective_count = 3 //WAITING FOR THUGS TO GET BACK INTO CAR  

	WAIT 0

	IF IS_CHAR_DEAD thug1
	AND objective_count_done_before1 = 0
		objective_count ++
		objective_count_done_before1 = 1
		thug1_is_dead = 1
	ENDIF

	IF IS_CHAR_DEAD thug2
	AND objective_count_done_before2 = 0
		objective_count ++
		objective_count_done_before2 = 1
		thug2_is_dead = 1
	ENDIF

	IF IS_CHAR_DEAD thug3
	AND objective_count_done_before3 = 0
		objective_count ++
		objective_count_done_before3 = 1
		thug3_is_dead = 1
	ENDIF


	IF thug1_is_dead = 1
	AND thug2_is_dead = 1
	AND thug3_is_dead = 1
		GOTO mission_joey6_failed
	ENDIF

//	STORE_CAR_PLAYER_IS_IN player any_car_jm6
//	maybe should stop player leaving this car while the thugs get in
	
	IF IS_CAR_DEAD any_car_jm6
		GOTO mission_joey6_failed
	ENDIF

	IF thug1_is_dead = 0
		IF IS_CHAR_IN_CAR thug1 any_car_jm6 
		AND objective_count_done_before1 = 0		
			objective_count ++
			objective_count_done_before1 = 1		
		ENDIF
	ENDIF

	IF thug2_is_dead = 0
		IF IS_CHAR_IN_CAR thug2 any_car_jm6 
		AND objective_count_done_before2 = 0		
			objective_count ++
			objective_count_done_before2 = 1		
		ENDIF
	ENDIF

	IF thug3_is_dead = 0
		IF IS_CHAR_IN_CAR thug3 any_car_jm6 
		AND objective_count_done_before3 = 0		
			objective_count ++
			objective_count_done_before3 = 1		
		ENDIF
	ENDIF
	/*
	IF TIMERB > 15000
		IF NOT IS_CAR_DEAD any_car_jm6
			IF NOT IS_CHAR_DEAD	thug1
				//WARP_CHAR_INTO_CAR thug1 any_car_jm6
				//WARP_CHAR_INTO_CAR_AS_PASSERNGER thug1 any_car_jm6
			ENDIF
			IF NOT IS_CHAR_DEAD	thug2
				//WARP_CHAR_INTO_CAR thug2 any_car_jm6
				//WARP_CHAR_INTO_CAR_AS_PASSERNGER thug1 any_car_jm6
			ENDIF
			IF NOT IS_CHAR_DEAD	thug3
				//WARP_CHAR_INTO_CAR thug3 any_car_jm6
				//WARP_CHAR_INTO_CAR_AS_PASSERNGER thug1 any_car_jm6
			ENDIF
		ENDIF
	ENDIF
	*/
ENDWHILE	

//END OF BANK ROBBERY CUT SCENE********************************************************************************

	ADD_BLIP_FOR_COORD 1086.0 -227.0 -100.0 blip2_jm6
	CHANGE_BLIP_DISPLAY blip2_jm6 BLIP_ONLY
	
//SAMPLE4*********************************************************
	LOAD_MISSION_AUDIO J6_C

	WHILE NOT HAS_MISSION_AUDIO_LOADED
		WAIT 0
	ENDWHILE

	PLAY_MISSION_AUDIO

	PRINT_NOW ( JM6_3 ) 3000 1 //"get us out of here"

	//PRINT_SOON ( JM6_4 ) 5000 1 //"get us out of here"


//Get back to warehouse

back_to_safe_house:

WAIT 0

	IF IS_CAR_DEAD any_car_jm6
		//GO GET ANOTHER ONE	
	ENDIF

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_2D player 1089.9 -223.9 1084.5 -228.5 TRUE
OR NOT IS_PLAYER_IN_ANY_CAR player 	  
OR IS_WANTED_LEVEL_GREATER Player 0    	
	WAIT 0

	IF IS_CAR_DEAD any_car_jm6
		//GO GET ANOTHER ONE	
	ENDIF

	IF IS_PLAYER_IN_ANY_CAR Player
		STORE_CAR_PLAYER_IS_IN player any_car_jm6
	ENDIF

	IF IS_CHAR_DEAD thug1
	AND IS_CHAR_DEAD thug2
	AND IS_CHAR_DEAD thug3
		PRINT_NOW ( JM6_8 )	5000 1
		GOTO mission_joey6_failed
	ENDIF

	IF NOT IS_CHAR_DEAD thug1
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug1 player
			IF blip_for_thug_added1 = 0
				ADD_BLIP_FOR_CHAR thug1 thug1_blip
				blip_for_thug_added1 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug1 30.0 30.0 FALSE
		   		IF blip_for_thug_added1 = 1
					SET_PLAYER_AS_LEADER thug1 player
					REMOVE_BLIP	thug1_blip
					blip_for_thug_added1 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug2 player
			IF blip_for_thug_added2 = 0
				ADD_BLIP_FOR_CHAR thug2 thug2_blip
				blip_for_thug_added2 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug2 30.0 30.0 FALSE
		   		IF blip_for_thug_added2 = 1
					SET_PLAYER_AS_LEADER thug2 player
					REMOVE_BLIP	thug2_blip
					blip_for_thug_added2 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		IF NOT IS_CHAR_IN_PLAYERS_GROUP	thug3 player
			IF blip_for_thug_added3 = 0
				ADD_BLIP_FOR_CHAR thug3 thug3_blip
				blip_for_thug_added3 = 1
			ENDIF
	   	
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug3 30.0 30.0 FALSE
		   		IF blip_for_thug_added3 = 1
					SET_PLAYER_AS_LEADER thug3 player
					REMOVE_BLIP	thug3_blip
					blip_for_thug_added3 = 0
				ENDIF
			ENDIF
	   	ENDIF	
	ENDIF

	IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_2D player 1089.9 -223.9 1084.5 -228.5 FALSE
		IF IS_WANTED_LEVEL_GREATER player 0
			IF flag_displayed_wanted_message_jm6 = 0
				PRINT_NOW ( WANTED1 ) 5000 1
				flag_displayed_wanted_message_jm6 = 1
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_PLAYER_IN_AREA_2D player 1089.9 -223.9 1084.5 -228.5 FALSE
			flag_displayed_wanted_message_jm6 = 0
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_AREA_ON_FOOT_2D player 1089.9 -223.9 1084.5 -228.5 TRUE
		PRINT_NOW ( EBAL_5 ) 5000 1
	ELSE
		CLEAR_THIS_PRINT EBAL_5
	ENDIF

ENDWHILE


//THUGS GO BACK INTO SAFEHOUSE CUT_SCENE***********************************************************************

IF NOT IS_CHAR_DEAD thug1
	IF NOT IS_CHAR_IN_PLAYERS_GROUP thug1 player
		PRINT_NOW ( HEY2 ) 4000 1
		GOTO back_to_safe_house
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD thug2
	IF NOT IS_CHAR_IN_PLAYERS_GROUP thug2 player
		PRINT_NOW ( HEY2 ) 4000 1
		GOTO back_to_safe_house
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD thug3
	IF NOT IS_CHAR_IN_PLAYERS_GROUP thug3 player
		PRINT_NOW ( HEY2 ) 4000 1
		GOTO back_to_safe_house
	ENDIF
ENDIF

CLEAR_AREA 1087.7 -229.2 8.0 6.0 TRUE

SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player On
SET_EVERYONE_IGNORE_PLAYER Player On

SET_FIXED_CAMERA_POSITION 1098.781 -228.929 16.723 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1098.005 -229.116 16.12 JUMP_CUT

	IF NOT IS_CAR_DEAD any_car_jm6
		APPLY_BRAKES_TO_PLAYERS_CAR Player On
		 
		IF NOT IS_CHAR_DEAD thug1
			LEAVE_GROUP thug1
			IF IS_CHAR_IN_ANY_CAR thug1
				STORE_CAR_CHAR_IS_IN thug1 any_car_jm6
				SET_CHAR_OBJ_LEAVE_CAR thug1 any_car_jm6
			ENDIF
		ENDIF

		WAIT 400

		IF NOT IS_CHAR_DEAD thug2
			LEAVE_GROUP thug2
			IF IS_CHAR_IN_ANY_CAR thug2
				STORE_CAR_CHAR_IS_IN thug2 any_car_jm6
				SET_CHAR_OBJ_LEAVE_CAR thug2 any_car_jm6
			ENDIF
		ENDIF

		WAIT 400

		IF NOT IS_CHAR_DEAD thug3
			LEAVE_GROUP thug3
			IF IS_CHAR_IN_ANY_CAR thug3
				STORE_CAR_CHAR_IS_IN thug3 any_car_jm6
				SET_CHAR_OBJ_LEAVE_CAR thug3 any_car_jm6
			ENDIF
		ENDIF

	ENDIF

	IF NOT IS_CHAR_DEAD thug1
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug1 30.0 30.0 FALSE
			IF NOT IS_CHAR_DEAD	thug1
				MARK_CHAR_AS_NO_LONGER_NEEDED thug1
			ENDIF
			//thug1_is_dead = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug2 30.0 30.0 FALSE
			IF NOT IS_CHAR_DEAD	thug2
				MARK_CHAR_AS_NO_LONGER_NEEDED thug2
			ENDIF
			//thug2_is_dead = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player thug3 30.0 30.0 FALSE
			IF NOT IS_CHAR_DEAD	thug3
				MARK_CHAR_AS_NO_LONGER_NEEDED thug3
			ENDIF
			//thug3_is_dead = 1
		ENDIF
	ENDIF

objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0

WHILE NOT SLIDE_OBJECT Bank_job_door 1087.523 -233.801 14.012 0.0 0.0 0.2 FALSE
	WAIT 0

ENDWHILE

WHILE NOT objective_count = 3 //WAITING FOR THUGS TO GET OUT OF CAR  

		WAIT 0

		IF IS_CHAR_DEAD thug1
			IF objective_count_done_before1 = 0
				objective_count ++
				objective_count_done_before1 = 1
				thug1_is_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD thug2
		AND objective_count_done_before2 = 0
			objective_count ++
			objective_count_done_before2 = 1
			thug2_is_dead = 1
		ENDIF


		IF IS_CHAR_DEAD thug3
		AND objective_count_done_before3 = 0
			objective_count ++
			objective_count_done_before3 = 1
			thug3_is_dead = 1
		ENDIF

		IF thug1_is_dead = 1
		AND thug2_is_dead = 1
		AND thug3_is_dead = 1
			GOTO mission_joey6_failed
		ENDIF
		
	IF NOT IS_CAR_DEAD any_car_jm6
			
		IF thug1_is_dead = 0
			IF NOT IS_CHAR_IN_CAR thug1	any_car_jm6	    
			AND objective_count_done_before1 = 0
				//SET_CHAR_OBJ_WAIT_ON_FOOT thug1
				SET_CHAR_OBJ_RUN_TO_COORD thug1 1087.0 -238.6		
				objective_count ++
				objective_count_done_before1 = 1		
			ENDIF
		ENDIF

		IF thug2_is_dead = 0
			IF NOT IS_CHAR_IN_CAR thug2 any_car_jm6			 
			AND objective_count_done_before2 = 0
				//SET_CHAR_OBJ_WAIT_ON_FOOT thug2
				SET_CHAR_OBJ_RUN_TO_COORD thug2 1087.5 -238.6		
				objective_count ++
				objective_count_done_before2 = 1		
			ENDIF
		ENDIF

		IF thug3_is_dead = 0
			IF NOT IS_CHAR_IN_CAR thug3	any_car_jm6		 
			AND objective_count_done_before3 = 0
				//SET_CHAR_OBJ_WAIT_ON_FOOT thug3
				SET_CHAR_OBJ_RUN_TO_COORD thug3 1088.0 -238.6		
				objective_count ++
				objective_count_done_before3 = 1		
			ENDIF
		ENDIF

	ENDIF

ENDWHILE


REMOVE_BLIP blip1_jm6

	IF NOT IS_CHAR_DEAD thug1
		SET_CHAR_OBJ_RUN_TO_COORD thug1 1087.0 -238.6	
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		SET_CHAR_OBJ_RUN_TO_COORD thug2 1087.5 -238.6
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		SET_CHAR_OBJ_RUN_TO_COORD thug3 1088.0 -238.6
	ENDIF

objective_count = 0
objective_count_done_before1 = 0
objective_count_done_before2 = 0
objective_count_done_before3 = 0

TIMERB = 0

WHILE NOT objective_count = 3

	WAIT 0

		IF IS_CHAR_DEAD thug1
		AND objective_count_done_before1 = 0
			objective_count ++
			objective_count_done_before1 = 1
			thug1_is_dead = 1
		ENDIF

		IF IS_CHAR_DEAD thug2
		AND objective_count_done_before2 = 0
			objective_count ++
			objective_count_done_before2 = 1
			thug2_is_dead = 1
		ENDIF


		IF IS_CHAR_DEAD thug3
		AND objective_count_done_before3 = 0
			objective_count ++
			objective_count_done_before3 = 1
			thug3_is_dead = 1
		ENDIF


		IF thug1_is_dead = 1
		AND thug2_is_dead = 1
		AND thug3_is_dead = 1
			GOTO mission_joey6_failed
		ENDIF

		IF thug1_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug1
			AND objective_count_done_before1 = 0		// GSW - could maybe use objective_count_done_before1 here
				objective_count ++
				objective_count_done_before1 = 1		// GSW - could maybe use objective_count_done_before1 here
			ENDIF
		ENDIF

		IF thug2_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug2
			AND objective_count_done_before2 = 0		// GSW - could maybe use objective_count_done_before2 here
				objective_count ++
				objective_count_done_before2 = 1		// GSW - could maybe use objective_count_done_before2 here
			ENDIF
		ENDIF

		IF thug3_is_dead = 0
			IF IS_CHAR_OBJECTIVE_PASSED thug3
			AND objective_count_done_before3 = 0		// GSW - could maybe use objective_count_done_before3 here
				objective_count ++
				objective_count_done_before3 = 1		// GSW - could maybe use objective_count_done_before3 here
			ENDIF
		ENDIF

		IF TIMERB > 15000
			IF NOT IS_CHAR_DEAD	thug1
				SET_CHAR_COORDINATES thug1 1087.0 -238.6 10.0
			ENDIF
			IF NOT IS_CHAR_DEAD	thug2
				SET_CHAR_COORDINATES thug2 1087.5 -238.6 10.0
			ENDIF
			IF NOT IS_CHAR_DEAD	thug3
				SET_CHAR_COORDINATES thug3 1088.0 -238.6 10.0
			ENDIF
		ENDIF

ENDWHILE

	IF NOT IS_CHAR_DEAD thug1
		SET_CHAR_OBJ_WAIT_ON_FOOT thug1
	ENDIF

	IF NOT IS_CHAR_DEAD thug2
		SET_CHAR_OBJ_WAIT_ON_FOOT thug2
	ENDIF

	IF NOT IS_CHAR_DEAD thug3
		SET_CHAR_OBJ_WAIT_ON_FOOT thug3
	ENDIF


WHILE NOT SLIDE_OBJECT Bank_job_door 1087.523 -233.801 11.012 0.0 0.0 0.1 FALSE
	WAIT 0

ENDWHILE

SET_PLAYER_CONTROL Player ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF
APPLY_BRAKES_TO_PLAYERS_CAR Player Off

//THUGS GO BACK INTO SAFEHOUSE CUT_SCENE***********************************************************************

}
GOTO mission_joey6_passed



// Mission Joey6 failed

mission_joey6_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission joey6 passed

mission_joey6_passed:

flag_joey_mission6_passed = 1
	IF NOT IS_CHAR_DEAD thug1
		thugs_score = thugs_score + 10000
	ENDIF
	DELETE_CHAR thug1

	IF NOT IS_CHAR_DEAD thug2
		thugs_score = thugs_score + 10000
	ENDIF
	DELETE_CHAR thug2

	IF NOT IS_CHAR_DEAD thug3
		thugs_score = thugs_score + 10000	
	ENDIF
	DELETE_CHAR thug3
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) thugs_score 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player thugs_score
REGISTER_MISSION_PASSED JM6
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP joey_contact_blip
RETURN
		

// mission cleanup

mission_cleanup_joey6:

flag_player_on_mission = 0
flag_player_on_joey_mission = 0
IF sound_already_created_before = 1
	REMOVE_SOUND joey_alarm_loop
ENDIF
REMOVE_BLIP blip1_jm6
REMOVE_BLIP blip3_jm6
REMOVE_BLIP blip2_jm6
REMOVE_BLIP	thug1_blip
REMOVE_BLIP	thug2_blip
REMOVE_BLIP	thug3_blip
SET_PED_DENSITY_MULTIPLIER 1.0
UNLOAD_SPECIAL_CHARACTER 2
MISSION_HAS_FINISHED
RETURN

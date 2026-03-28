MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************ASUKA SUBURBAN MISSION 2****************************** 
// *****************************************************************************************
// **************************************'Espresso-2-Go'***********************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_as2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_as2_failed
ENDIF
GOSUB mission_cleanup_as2

MISSION_END
 
// Variables for mission

VAR_INT kappa_1 kappa_3 kappa_4 //kappa_2
VAR_INT kappa_5 kappa_6 kappa_7 //kappa_8
VAR_INT kappa_9 kappa_10 kappa_12 //kappa_11

//VAR_INT varmint_1 varmint_2 
VAR_INT patriot_1 //patriot_2 
VAR_INT flag_guard1_created flag_guard2_created
 
VAR_INT kappa_1_fire kappa_2_fire kappa_3_fire kappa_4_fire
VAR_INT kappa_5_fire kappa_6_fire kappa_7_fire kappa_8_fire
VAR_INT kappa_9_fire kappa_10_fire kappa_11_fire kappa_12_fire

VAR_INT kappa_cartel1 kappa_cartel2 kappa_cartel3 kappa_cartel4
VAR_INT kappa_cartel5 kappa_cartel6 kappa_cartel7 kappa_cartel8
VAR_INT kappa_cartel9 kappa_cartel10 kappa_cartel11 kappa_cartel12

VAR_INT flag_kappa1_dead flag_kappa2_dead flag_kappa3_dead flag_kappa4_dead
VAR_INT flag_kappa5_dead flag_kappa6_dead flag_kappa7_dead flag_kappa8_dead
VAR_INT flag_kappa9_dead flag_kappa10_dead flag_kappa11_dead flag_kappa12_dead

VAR_INT flag_kappa1_created flag_kappa2_created flag_kappa3_created flag_kappa4_created
VAR_INT flag_kappa5_created flag_kappa6_created flag_kappa7_created flag_kappa8_created
VAR_INT flag_kappa9_created flag_kappa10_created flag_kappa11_created flag_kappa12_created

VAR_INT blip_kappa1_created blip_kappa2_created blip_kappa3_created blip_kappa4_created
VAR_INT blip_kappa5_created blip_kappa6_created blip_kappa7_created blip_kappa8_created
VAR_INT blip_kappa9_created blip_kappa10_created blip_kappa11_created blip_kappa12_created

VAR_INT blip_kappa1 blip_kappa2 blip_kappa3 blip_kappa4
VAR_INT blip_kappa5 blip_kappa6 blip_kappa7 blip_kappa8
VAR_INT blip_kappa9 blip_kappa10 blip_kappa11 blip_kappa12

VAR_INT kappa_time
VAR_INT flag_timer_started
//VAR_INT cs_whip
VAR_INT timer_as2_dif timer_as2_now timer_as2_start flag_particle_as2 particle_time_as2

VAR_INT counter_kappa_dead
VAR_INT counter_kappa_dead_ind
VAR_INT counter_kappa_dead_com
VAR_INT counter_kappa_dead_sub

VAR_INT flag_as2_1 flag_as2_2 flag_as2_3

VAR_FLOAT kappa1_x kappa1_y
VAR_FLOAT kappa2_x kappa2_y
VAR_FLOAT kappa3_x kappa3_y
VAR_FLOAT kappa4_x kappa4_y
VAR_FLOAT kappa5_x kappa5_y
VAR_FLOAT kappa6_x kappa6_y
VAR_FLOAT kappa7_x kappa7_y
VAR_FLOAT kappa8_x kappa8_y
VAR_FLOAT kappa9_x kappa9_y
VAR_FLOAT kappa10_x kappa10_y
VAR_FLOAT kappa11_x kappa11_y
VAR_FLOAT kappa12_x kappa12_y
VAR_FLOAT steam_x steam_y steam_z

//--test stuff-------------

VAR_FLOAT test_x test_y
VAR_INT kappa_test





//VAR_FLOAT min_x_as2 min_y_as2 min_z_as2 max_x_as2 max_y_as2 max_z_as2



// ****************************************Mission Start************************************

mission_start_as2:
REGISTER_MISSION_GIVEN
SCRIPT_NAME asusb2 
flag_player_on_mission = 1
flag_player_on_asuka_suburban_mission = 1

WAIT 0

//WAIT 1000

//---------------------------------SET FLAGS & VARIABLES-------------------------------------------


flag_kappa1_dead = 0
flag_kappa2_dead = 0
flag_kappa3_dead = 0
flag_kappa4_dead = 0
flag_kappa5_dead = 0
flag_kappa6_dead = 0
flag_kappa7_dead = 0
flag_kappa8_dead = 0
flag_kappa9_dead = 0
flag_kappa10_dead = 0
flag_kappa11_dead = 0
flag_kappa12_dead = 0

flag_kappa1_created = 0
flag_kappa2_created = 0
flag_kappa3_created = 0
flag_kappa4_created = 0
flag_kappa5_created = 0
flag_kappa6_created = 0
flag_kappa7_created = 0
flag_kappa8_created = 0
flag_kappa9_created = 0
flag_kappa10_created = 0
flag_kappa11_created = 0
flag_kappa12_created = 0

blip_kappa1_created = 0
blip_kappa2_created = 0
blip_kappa3_created = 0
blip_kappa4_created = 0
blip_kappa5_created = 0
blip_kappa6_created = 0
blip_kappa7_created = 0
blip_kappa8_created = 0
blip_kappa9_created = 0
blip_kappa10_created = 0
blip_kappa11_created = 0
blip_kappa12_created = 0


counter_kappa_dead = 0

particle_time_as2 = 0

counter_kappa_dead_ind = 0
counter_kappa_dead_com = 0
counter_kappa_dead_sub = 0

flag_as2_1 = 0
flag_as2_2 = 0
flag_as2_3 = 0
flag_particle_as2 = 0

flag_guard1_created = 0

kappa_time = 470000
flag_timer_started = 0

// ****************************************LOCATION COORDS**************************************

kappa1_x = 1342.0
kappa1_y = -821.0 //dock entrance

kappa2_x = 1024.1
kappa2_y = -465.57 //tube station

kappa3_x = 1351.22
kappa3_y = -259.56 //St Marks

kappa4_x = 286.4
kappa4_y = -667.8 //NEWPORT

kappa5_x = 28.0
kappa5_y = -850.0 //PARK

kappa6_x = 14.16
kappa6_y = -1140.0 //BED POINT

kappa7_x = 73.16
kappa7_y = -1359.8 //BED POINT

kappa8_x = -221.0
kappa8_y = -197.0 //ASPATRIA

kappa9_x = 282.8
kappa9_y = -1492.4 // TORRINGTON

kappa10_x = -644.0
kappa10_y = -721.5 // AIRPORT

kappa11_x = -212.0
kappa11_y = 310.0 //cedar grove

kappa12_x = -1255.0
kappa12_y = -113.0 //Pike Creek



//  ******************************************* START OF CUTSCENE ***************************

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_as2_failed
ENDIF

//	PRINT_BIG ( AS2 ) 15000 2

SET_FADING_COLOUR 0 0 0

DO_FADE 250 FADE_OUT

PRINT_BIG ( AS2 ) 15000 2

SWITCH_STREAMING OFF
*/

REQUEST_MODEL csitecutscene

LOAD_SPECIAL_CHARACTER 1 asuka
LOAD_SPECIAL_CHARACTER 2 miguel

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 ASUKAH
LOAD_SPECIAL_MODEL cut_obj3 WHIP

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED csitecutscene
 WAIT 0
ENDWHILE

 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
 WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0
ENDWHILE


LOAD_CUTSCENE a7_etg

SWITCH_STREAMING ON

SET_CUTSCENE_OFFSET 369.02 -327.5 18.46
  
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel
 
CREATE_CUTSCENE_OBJECT cut_obj3 cs_whip
SET_CUTSCENE_ANIM cs_whip WHIP

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player
 
CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ2 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

//CREATE_CUTSCENE_HEAD cs_miguel CUT_OBJ3 cs_miguelhead
//SET_CUTSCENE_HEAD_ANIM cs_miguelhead miguel

SET_PLAYER_COORDINATES player 373.7523 -327.2676 17.1950
 
SET_PLAYER_HEADING player 270.0
 
DO_FADE 250 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF
SWITCH_WORLD_PROCESSING OFF

START_CUTSCENE

//------CUTSCENE TEXT-----------------------------
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3445
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (AS2_A1) 10000 1

WHILE cs_time < 7961
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (AS2_A2) 10000 1

WHILE cs_time < 9836
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (AS2_A) 10000 1
 
WHILE cs_time < 13013
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS2_B) 10000 1
 
WHILE cs_time < 16802
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS2_C) 10000 1
 
WHILE cs_time < 20591
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS2_D) 10000 1

WHILE cs_time < 23499
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS2_E) 10000 1

WHILE cs_time < 27594
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS2_F) 10000 1

WHILE cs_time < 30000
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
 
WAIT 500
 
DO_FADE 1500 FADE_IN 
  
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED csitecutscene

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

SWITCH_RUBBISH ON
SWITCH_STREAMING ON
SWITCH_WORLD_PROCESSING ON
// ******************************************END OF CUTSCENE********************************



// Mission stuff goes here

DISPLAY_ONSCREEN_COUNTER_WITH_STRING counter_kappa_dead COUNTER_DISPLAY_NUMBER KILLS

GET_GAME_TIMER timer_as2_start

PRINT_NOW (AS2_12) 5000 1//Cruise Liberty's districts to find etc. etc.

PRINT_SOON (AS2_12A) 5000 1

SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_UZI //The Mafia


/*
REQUEST_MODEL PED_FEMALE1
WHILE NOT HAS_MODEL_LOADED PED_FEMALE1
	WAIT 0
ENDWHILE
*/
REQUEST_MODEL coffee
WHILE NOT HAS_MODEL_LOADED coffee
	WAIT 0
ENDWHILE

REQUEST_MODEL CAR_COLUMB
WHILE NOT HAS_MODEL_LOADED CAR_COLUMB
	WAIT 0
ENDWHILE
REQUEST_MODEL PED_GANG_COLOMBIAN_A
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_A
	WAIT 0
ENDWHILE
REQUEST_MODEL PED_GANG_COLOMBIAN_B
WHILE NOT HAS_MODEL_LOADED PED_GANG_COLOMBIAN_B
	WAIT 0
ENDWHILE

/*
PRINT_NOW (AS2_A) 4000 1 //We underestimated Catalina's plans for SPANK. It reaches far beyond the Yardies selling it on street corners.
MESSAGE_WAIT 4000 true
PRINT_NOW (AS2_B) 4000 1 //The Cartel have a front company; The Kappa Coffee House franchise.
MESSAGE_WAIT 4000 true
PRINT_NOW (AS2_C) 4000 1 //They've been selling SPANK through street stalls all over Liberty's three districts.
MESSAGE_WAIT 4000 true
PRINT_NOW (AS2_D) 4000 1 //Put all these drug barrows out of operation!!
MESSAGE_WAIT 4000 true
PRINT_NOW (AS2_E) 4000 1 //Once you've done the first hit, you'll have eight minutes before the Cartel can warn their pushers.
MESSAGE_WAIT 4000 true

//-----test stuff-----
test_x = 354.0
test_y = -327.0
CREATE_OBJECT coffee test_x test_y -100.0 kappa_test
//SET_OBJECT_HEADING kappa_test 0.0
*/

WHILE counter_kappa_dead < 9
	WAIT 0
//-------------------------------------------CREATE KAPPAS------------------------------------------------------------------------------------
	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
		IF flag_kappa1_created = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player kappa1_x kappa1_y 150.0 150.0 false
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa1_x kappa1_y -100.0 kappa_cartel1
				//SET_CHAR_HEADING kappa_cartel1 270.0
				SET_CHAR_THREAT_SEARCH kappa_cartel1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel1 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 true
				CREATE_OBJECT coffee kappa1_x kappa1_y -100.0 kappa_1
				SET_OBJECT_HEADING kappa_1 180.0
				SET_OBJECT_COLLISION kappa_1 true
				SET_OBJECT_DYNAMIC kappa_1 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE -1350.4 -259.6 49.7 false
				IF blip_kappa1_created = 0
					ADD_BLIP_FOR_OBJECT kappa_1 blip_kappa1
					blip_kappa1_created = 1
				ENDIF
				flag_Kappa1_created = 1
			ENDIF
		ENDIF
				
		/*
		IF flag_kappa2_created = 0
			IF LOCATE_PLAYER_ANY_MEANS_2D player kappa2_x kappa2_y 70.0 70.0 false
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa2_x kappa2_y -100.0 kappa_cartel2
				//SET_CHAR_HEADING kappa_cartel2 270.0
				SET_CHAR_THREAT_SEARCH kappa_cartel2 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel2 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel2 true
				CREATE_OBJECT coffee kappa2_x kappa2_y -100.0 kappa_2
				SET_OBJECT_HEADING kappa_2 270.0
				SET_OBJECT_COLLISION kappa_2 true
				SET_OBJECT_DYNAMIC kappa_2 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 1024.2 -466.5 14.9 false
				IF blip_kappa2_created = 0
					ADD_BLIP_FOR_OBJECT kappa_2 blip_kappa2
					blip_kappa2_created = 1
				ENDIF
				flag_Kappa2_created = 1
			ENDIF
		ENDIF
		*/
		
		IF flag_kappa3_created = 0
			IF IS_PLAYER_IN_ZONE player LITTLEI
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa3_x kappa3_y -100.0 kappa_cartel3
				SET_CHAR_HEADING kappa_cartel3 270.0
				SET_CHAR_THREAT_SEARCH kappa_cartel3 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel3 WEAPONTYPE_SHOTGUN 10
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel3 true
				CREATE_OBJECT coffee kappa3_x kappa3_y -100.0 kappa_3
				SET_OBJECT_HEADING kappa_3 180.0
				SET_OBJECT_COLLISION kappa_3 true
				SET_OBJECT_DYNAMIC kappa_3 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 1343.3 -845.5 15.0 false
				IF blip_kappa3_created = 0
					ADD_BLIP_FOR_OBJECT kappa_3 blip_kappa3
					blip_kappa3_created = 1
				ENDIF
				flag_Kappa3_created = 1
			ENDIF
		ENDIF
   /*	ELSE
		IF flag_kappa1_created = 1
			IF flag_kappa1_dead = 0
					DELETE_CHAR kappa_cartel1
					DELETE_OBJECT kappa_1
					flag_kappa1_created = 0
					blip_kappa1_created = 0
			ENDIF
			IF flag_kappa1_dead = 1
					DELETE_CHAR kappa_cartel1
					DELETE_OBJECT kappa_1
			ENDIF
		ENDIF
		
		IF flag_kappa2_created = 1
			IF flag_kappa2_dead = 0
					DELETE_CHAR kappa_cartel2
					DELETE_OBJECT kappa_2
					flag_kappa2_created = 0
					blip_kappa2_created = 0
			ENDIF
			IF flag_kappa2_dead = 1
					DELETE_CHAR kappa_cartel2
					DELETE_OBJECT kappa_2
			ENDIF
		ENDIF
		
		IF flag_kappa3_created = 1
			IF flag_kappa3_dead = 0
					DELETE_CHAR kappa_cartel3
					DELETE_OBJECT kappa_3
					flag_kappa3_created = 0
					blip_kappa3_created = 0
			ENDIF
			IF flag_kappa3_dead = 1
					DELETE_CHAR kappa_cartel3
					DELETE_OBJECT kappa_3
			ENDIF
		ENDIF
		*/
	ENDIF
	
	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		IF flag_kappa4_created = 0
			//IF IS_PLAYER_IN_ZONE player COM_EAS
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa4_x kappa4_y -100.0 kappa_cartel4
				SET_CHAR_HEADING kappa_cartel4 360.0
				SET_CHAR_THREAT_SEARCH kappa_cartel4 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel4 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel4 true
				ADD_ARMOUR_TO_CHAR kappa_cartel4 100
				CREATE_OBJECT coffee kappa4_x kappa4_y -100.0 kappa_4
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION 286.5 -668.5 26.2 false
				SET_OBJECT_HEADING kappa_4 270.0
				SET_OBJECT_COLLISION kappa_4 true
				SET_OBJECT_DYNAMIC kappa_4 false
				IF blip_kappa4_created = 0
					ADD_BLIP_FOR_OBJECT kappa_4 blip_kappa4
					blip_kappa4_created = 1
				ENDIF
				flag_Kappa4_created = 1
			//ENDIF
		ENDIF

		IF flag_kappa5_created = 0
			IF IS_PLAYER_IN_ZONE player PARK
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa5_x kappa5_y -100.0 kappa_cartel5
				SET_CHAR_THREAT_SEARCH kappa_cartel5 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel5 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel5 true
				CREATE_OBJECT coffee kappa5_x kappa5_y -100.0 kappa_5
				SET_OBJECT_COLLISION kappa_5 true
				SET_OBJECT_DYNAMIC kappa_5 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 28.6 -849.9 32.7 false
				IF blip_kappa5_created = 0
					ADD_BLIP_FOR_OBJECT kappa_5 blip_kappa5
					blip_kappa5_created = 1
				ENDIF
				flag_Kappa5_created = 1
			ENDIF
		ENDIF

		IF flag_kappa6_created = 0
			IF IS_PLAYER_IN_ZONE player	SHOPING
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa6_x kappa6_y -100.0 kappa_cartel6
				SET_CHAR_HEADING kappa_cartel6 190.0
				SET_CHAR_THREAT_SEARCH kappa_cartel6 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel6 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel6 true
				CREATE_OBJECT coffee kappa6_x kappa6_y -100.0 kappa_6
				SET_OBJECT_HEADING kappa_6 145.0
				SET_OBJECT_COLLISION kappa_6 true
				SET_OBJECT_DYNAMIC kappa_6 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 13.67 -1140.5 26.19 false
				IF blip_kappa6_created = 0
					ADD_BLIP_FOR_OBJECT kappa_6 blip_kappa6
					blip_kappa6_created = 1
				ENDIF
				flag_Kappa6_created = 1
			ENDIF
		ENDIF

		IF flag_kappa7_created = 0
			IF IS_PLAYER_IN_ZONE player	SHOPING
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa7_x kappa7_y -100.0 kappa_cartel7
				//SET_CHAR_HEADING kappa_cartel7 190.0
				SET_CHAR_THREAT_SEARCH kappa_cartel7 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel7 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel7 true
				CREATE_OBJECT coffee kappa7_x kappa7_y -100.0 kappa_7
				SET_OBJECT_COLLISION kappa_7 true
				SET_OBJECT_DYNAMIC kappa_7 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 74.0 -1359.6 26.2 false
				IF blip_kappa7_created = 0
					ADD_BLIP_FOR_OBJECT kappa_7 blip_kappa7
					blip_kappa7_created = 1
				ENDIF
				flag_Kappa7_created = 1
			ENDIF
		ENDIF
		/*
		IF flag_kappa8_created = 0
			IF IS_PLAYER_IN_ZONE player	STADIUM
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa8_x kappa8_y -100.0 kappa_cartel8
				SET_CHAR_HEADING kappa_cartel8 350.0
				SET_CHAR_THREAT_SEARCH kappa_cartel8 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel8 WEAPONTYPE_SHOTGUN 10
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel8 true
				CREATE_OBJECT coffee kappa8_x kappa8_y -100.0 kappa_8
				SET_OBJECT_HEADING kappa_8 270.0
				SET_OBJECT_COLLISION kappa_8 true
				SET_OBJECT_DYNAMIC kappa_8 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE -220.8 -197.5 12.1 false
				IF blip_kappa8_created = 0
					ADD_BLIP_FOR_OBJECT kappa_8 blip_kappa8
					blip_kappa8_created = 1
				ENDIF
				flag_Kappa8_created = 1
			ENDIF
		ENDIF
		*/
		IF flag_kappa9_created = 0
			IF IS_PLAYER_IN_ZONE player	YAKUSA
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa9_x kappa9_y 23.7 kappa_cartel9
				SET_CHAR_THREAT_SEARCH kappa_cartel9 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel9 WEAPONTYPE_SHOTGUN 10
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel9 true
				CREATE_OBJECT coffee kappa9_x kappa9_y -100.0 kappa_9
				SET_OBJECT_HEADING kappa_9 270.0
				SET_OBJECT_COLLISION kappa_9 true
				SET_OBJECT_DYNAMIC kappa_9 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE 282.9 -1493.1 23.7 false
				IF blip_kappa9_created = 0
					ADD_BLIP_FOR_OBJECT kappa_9 blip_kappa9
					blip_kappa9_created = 1
				ENDIF
				flag_Kappa9_created = 1
			ENDIF
		ENDIF
  /*	ELSE
		IF flag_kappa10_created = 1
			IF flag_kappa4_dead = 0
					DELETE_CHAR kappa_cartel4
					DELETE_OBJECT kappa_4
					flag_kappa4_created = 0
					blip_kappa4_created = 0
			ENDIF
			IF flag_kappa4_dead = 1
					DELETE_CHAR kappa_cartel4
					DELETE_OBJECT kappa_4
			ENDIF
		ENDIF
		IF flag_kappa5_created = 1
			IF flag_kappa5_dead = 0
					DELETE_CHAR kappa_cartel5
					DELETE_OBJECT kappa_5
					flag_kappa5_created = 0
					blip_kappa5_created = 0
			ENDIF
			IF flag_kappa5_dead = 1
					DELETE_CHAR kappa_cartel5
					DELETE_OBJECT kappa_5
			ENDIF
		ENDIF
		IF flag_kappa6_created = 1
			IF flag_kappa6_dead = 0
					DELETE_CHAR kappa_cartel6
					DELETE_OBJECT kappa_6
					flag_kappa6_created = 0
					blip_kappa6_created = 0
			ENDIF
			IF flag_kappa6_dead = 1
					DELETE_CHAR kappa_cartel6
					DELETE_OBJECT kappa_6
			ENDIF
		ENDIF
		IF flag_kappa7_created = 1
			IF flag_kappa7_dead = 0
					DELETE_CHAR kappa_cartel7
					DELETE_OBJECT kappa_7
					flag_kappa7_created = 0
					blip_kappa7_created = 0
			ENDIF
			IF flag_kappa7_dead = 1
					DELETE_CHAR kappa_cartel7
					DELETE_OBJECT kappa_7
			ENDIF
		ENDIF
		
		IF flag_kappa8_created = 1
			IF flag_kappa8_dead = 0
					DELETE_CHAR kappa_cartel8
					DELETE_OBJECT kappa_8
					flag_kappa8_created = 0
					blip_kappa8_created = 0
			ENDIF
			IF flag_kappa8_dead = 1
					DELETE_CHAR kappa_cartel8
					DELETE_OBJECT kappa_8
			ENDIF
		ENDIF
		
		IF flag_kappa9_created = 1
			IF flag_kappa9_dead = 0
					DELETE_CHAR kappa_cartel9
					DELETE_OBJECT kappa_9
					flag_kappa9_created = 0
					blip_kappa9_created = 0
			ENDIF
			IF flag_kappa9_dead = 1
					DELETE_CHAR kappa_cartel9
					DELETE_OBJECT kappa_9
			ENDIF
		ENDIF
		*/
	ENDIF
	
	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
		IF flag_kappa10_created = 0
			IF IS_PLAYER_IN_ZONE player AIRPORT
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa10_x kappa10_y 18.9 kappa_cartel10
				SET_CHAR_HEADING kappa_cartel10 50.0
				SET_CHAR_THREAT_SEARCH kappa_cartel10 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel10 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel10 true
				CREATE_OBJECT coffee kappa10_x kappa10_y -100.0 kappa_10
				SET_OBJECT_COLLISION kappa_10 true
				SET_OBJECT_DYNAMIC kappa_10 false
				//ADD_PARTICLE_EFFECT POBJECT_DRY_ICE -724.3 -548.8 9.1 false
				IF blip_kappa10_created = 0
					ADD_BLIP_FOR_OBJECT kappa_10 blip_kappa10
					blip_kappa10_created = 1
				ENDIF
				flag_Kappa10_created = 1
			ENDIF
		ENDIF
		/*
		IF flag_kappa11_created = 0
			IF IS_PLAYER_IN_ZONE player SWANKS
			OR IS_PLAYER_IN_ZONE player PROJECT
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A kappa11_x kappa11_y -100.0 kappa_cartel11
				SET_CHAR_HEADING kappa_cartel11 90.0
				SET_CHAR_THREAT_SEARCH kappa_cartel11 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel11 WEAPONTYPE_UZI 60
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel11 true
				CREATE_OBJECT coffee kappa11_x kappa11_y -100.0 kappa_11
				SET_OBJECT_HEADING kappa_11 0.0
				SET_OBJECT_COLLISION kappa_11 true
				SET_OBJECT_DYNAMIC kappa_11 false
				IF blip_kappa11_created = 0
					ADD_BLIP_FOR_OBJECT kappa_11 blip_kappa11
					blip_kappa11_created = 1
				ENDIF
				flag_Kappa11_created = 1
			ENDIF
		ENDIF
		*/
		IF flag_kappa12_created = 0
			IF IS_PLAYER_IN_ZONE player SUB_IND
				CREATE_CHAR PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B kappa12_x kappa12_y -100.0 kappa_cartel12
				SET_CHAR_THREAT_SEARCH kappa_cartel12 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR kappa_cartel12 WEAPONTYPE_UZI 60
				CREATE_OBJECT coffee kappa12_x kappa12_y -100.0 kappa_12
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel12 true
				SET_OBJECT_COLLISION kappa_12 true
				SET_OBJECT_DYNAMIC kappa_12 false
				IF blip_kappa12_created = 0
					ADD_BLIP_FOR_OBJECT kappa_12 blip_kappa12
					blip_kappa12_created = 1
				ENDIF
				flag_Kappa12_created = 1
			ENDIF
		ENDIF

		IF flag_kappa10_created = 1
		OR flag_kappa12_created = 1
			IF flag_guard1_created = 0
				CREATE_CAR CAR_COLUMB -706.3 -285.7 18.3 patriot_1
				CREATE_CHAR_INSIDE_CAR patriot_1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A varmint_1
				GIVE_WEAPON_TO_CHAR varmint_1 WEAPONTYPE_UZI 60
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS varmint_1 player
				flag_guard1_created = 1
			ENDIF
		ENDIF
   /*	ELSE
		IF flag_kappa10_created = 1
			IF flag_kappa10_dead = 0
					DELETE_CHAR kappa_cartel10
					DELETE_OBJECT kappa_10
					flag_kappa10_created = 0
					blip_kappa10_created = 0
			ENDIF
			IF flag_kappa10_dead = 1
					DELETE_CHAR kappa_cartel10
					DELETE_OBJECT kappa_10
			ENDIF
		ENDIF
		
		IF flag_kappa11_created = 1
			IF flag_kappa11_dead = 0
					DELETE_CHAR kappa_cartel11
					DELETE_OBJECT kappa_11
					flag_kappa11_created = 0
					blip_kappa11_created = 0
			ENDIF
			IF flag_kappa11_dead = 1
					DELETE_CHAR kappa_cartel11
					DELETE_OBJECT kappa_11
			ENDIF
		ENDIF
		
		IF flag_kappa12_created = 1
			IF flag_kappa12_dead = 0
					DELETE_CHAR kappa_cartel12
					DELETE_OBJECT kappa_12
					flag_kappa12_created = 0
					blip_kappa12_created = 0
			ENDIF
			IF flag_kappa12_dead = 1
					DELETE_CHAR kappa_cartel12
					DELETE_OBJECT kappa_12
			ENDIF
		ENDIF
		*/
	ENDIF
//---------------------------------------KAPPA DEATH CHECK---------------------------------------------------------------------------------------
	IF flag_kappa1_dead = 0
	AND flag_kappa1_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_1
			flag_kappa1_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_ind
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa1
			IF NOT IS_CHAR_DEAD	kappa_cartel1
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel1
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel1 1335.5 -820.5
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel1
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel1 player
		ENDIF
	ENDIF
	IF flag_kappa1_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel1
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel1
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel1 player
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel1 false
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel1
				SET_CHAR_THREAT_SEARCH kappa_cartel1 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel1 player
			ENDIF
		ENDIF
	ENDIF

	/*
	IF flag_kappa2_dead = 0
	AND flag_kappa2_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_2
			flag_kappa2_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_ind
			kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa2
			MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel2
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel2
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel2 player
		ENDIF
	ENDIF
	*/
	IF flag_kappa3_dead = 0
	AND flag_kappa3_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_3
			flag_kappa3_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_ind
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa3
			IF NOT IS_CHAR_DEAD	kappa_cartel3
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel3
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel3 1342.7 -259.0
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel3
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel3 player
		ENDIF
	ENDIF
	IF flag_kappa3_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel3
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel3
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel3 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel3
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel3 false
				SET_CHAR_THREAT_SEARCH kappa_cartel3 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel3 player
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_kappa4_dead = 0
	AND flag_kappa4_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_4
			flag_kappa4_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa4
			IF NOT IS_CHAR_DEAD	kappa_cartel4
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel4
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel4 280.0 -676.5
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel4
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel4 player
		ENDIF
	ENDIF
	IF flag_kappa4_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel4
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel4
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel4 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel4
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel4 false
				SET_CHAR_THREAT_SEARCH kappa_cartel4 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel4 player
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_kappa5_dead = 0
	AND flag_kappa5_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_5
			flag_kappa5_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa5
			IF NOT IS_CHAR_DEAD	kappa_cartel5
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel5
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel5 34.5 -850.0
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel5
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel5 player
		ENDIF
	ENDIF
	IF flag_kappa5_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel5
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel5
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel5 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel5
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel5 false
				SET_CHAR_THREAT_SEARCH kappa_cartel5 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel5 player
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_kappa6_dead = 0
	AND flag_kappa6_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_6
			flag_kappa6_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa6
			IF NOT IS_CHAR_DEAD	kappa_cartel6
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel6
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel6 13.7 -1135.3
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel6
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel6 player
		ENDIF
	ENDIF
	IF flag_kappa6_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel6
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel6
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel6 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel6
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel6 false
				SET_CHAR_THREAT_SEARCH kappa_cartel6 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel6 player
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_kappa7_dead = 0
	AND flag_kappa7_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_7
			flag_kappa7_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa7
			IF NOT IS_CHAR_DEAD	kappa_cartel7
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel7
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel7 79.0 -1361.0
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel7
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel7 player
		ENDIF
	ENDIF
	IF flag_kappa7_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel7
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel7
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel7 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel7
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel7 false
				SET_CHAR_THREAT_SEARCH kappa_cartel7 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel7 player
			ENDIF
		ENDIF
	ENDIF
	/*
	IF flag_kappa8_dead = 0
	AND flag_kappa8_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_8
			flag_kappa8_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa8
			MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel8
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel8
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel8 player
		ENDIF
	ENDIF
	*/
	IF flag_kappa9_dead = 0
	AND flag_kappa9_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_9
			flag_kappa9_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_com
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
		   	REMOVE_BLIP blip_kappa9
			IF NOT IS_CHAR_DEAD	kappa_cartel9
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel9
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel9 282.5 -1501.0
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel9
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel9 player
		ENDIF
	ENDIF
	IF flag_kappa9_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel9
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel9
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel9 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel9
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel9 false
				SET_CHAR_THREAT_SEARCH kappa_cartel9 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel9 player
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_kappa10_dead = 0
	AND flag_kappa10_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_10
			flag_kappa10_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_sub
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa10
			IF NOT IS_CHAR_DEAD	kappa_cartel10
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel10
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel10 -638.8 -721.6
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel10
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel10 player
		ENDIF
	ENDIF
	IF flag_kappa10_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel10
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel10
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel10 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel10
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel10 false
				SET_CHAR_THREAT_SEARCH kappa_cartel10 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel10 player
			ENDIF
		ENDIF
	ENDIF
	
	/*
	IF flag_kappa11_dead = 0
	AND flag_kappa11_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_11
			flag_kappa11_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_sub
			kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa11
			MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel11
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel11
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel11 player
		ENDIF
	ENDIF
	*/
	IF flag_kappa12_dead = 0
	AND flag_kappa12_created = 1
		IF HAS_OBJECT_BEEN_DAMAGED kappa_12
			flag_kappa12_dead = 1
			++ counter_kappa_dead
			++ counter_kappa_dead_sub
			//kappa_time = kappa_time + 10000
			PRINT_WITH_NUMBER_BIG (AS2_11) counter_kappa_dead 2000 1
			REMOVE_BLIP blip_kappa12
			IF NOT IS_CHAR_DEAD	kappa_cartel12
				CLEAR_CHAR_THREAT_SEARCH kappa_cartel12
				SET_CHAR_OBJ_RUN_TO_COORD kappa_cartel12 -1251.0 -114.5
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	kappa_cartel12
			TURN_CHAR_TO_FACE_PLAYER kappa_cartel12 player
		ENDIF
	ENDIF
	IF flag_kappa12_dead > 0
		IF NOT IS_CHAR_DEAD	kappa_cartel12
			IF IS_CHAR_OBJECTIVE_PASSED kappa_cartel12
				TURN_CHAR_TO_FACE_PLAYER kappa_cartel12 player
				//MARK_CHAR_AS_NO_LONGER_NEEDED kappa_cartel12
				SET_CHAR_STAY_IN_SAME_PLACE kappa_cartel12 false
				SET_CHAR_THREAT_SEARCH kappa_cartel12 THREAT_PLAYER1
				//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kappa_cartel12 player
			ENDIF
		ENDIF
	ENDIF
//---------------------STEAM--------------------------

	GET_GAME_TIMER timer_as2_now
	timer_as2_dif = timer_as2_now - timer_as2_start
	IF timer_as2_dif > particle_time_as2
			particle_time_as2 = particle_time_as2 + 50
			flag_particle_as2 = 1
	ENDIF

	IF flag_particle_as2 = 1
		IF flag_kappa1_dead = 0
		AND flag_kappa1_created = 1
			GET_OBJECT_COORDINATES kappa_1 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa1_dead = 1
		AND flag_kappa1_created = 1
			GET_OBJECT_COORDINATES kappa_1 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_1_fire
			flag_kappa1_dead = 2
		ENDIF
		/*
		IF flag_kappa2_dead = 0
		AND flag_kappa2_created = 1
			GET_OBJECT_COORDINATES kappa_2 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa2_dead = 1
		AND flag_kappa2_created = 1
			GET_OBJECT_COORDINATES kappa_2 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_2_fire
			flag_kappa2_dead = 2
		ENDIF
		*/
		IF flag_kappa3_dead = 0
		AND flag_kappa3_created = 1
			GET_OBJECT_COORDINATES kappa_3 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa3_dead = 1
		AND flag_kappa3_created = 1
			GET_OBJECT_COORDINATES kappa_3 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_3_fire
			flag_kappa3_dead = 2
		ENDIF
		
		IF flag_kappa4_dead = 0
		AND flag_kappa4_created = 1
			GET_OBJECT_COORDINATES kappa_4 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa4_dead = 1
		AND flag_kappa4_created = 1
			GET_OBJECT_COORDINATES kappa_4 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_4_fire
			flag_kappa4_dead = 2
		ENDIF
		
		IF flag_kappa5_dead = 0
		AND flag_kappa5_created = 1
			GET_OBJECT_COORDINATES kappa_5 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa5_dead = 1
		AND flag_kappa5_created = 1
			GET_OBJECT_COORDINATES kappa_5 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_5_fire
			flag_kappa5_dead = 2
		ENDIF
		
		IF flag_kappa6_dead = 0
		AND flag_kappa6_created = 1
			GET_OBJECT_COORDINATES kappa_6 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa6_dead = 1
		AND flag_kappa6_created = 1
			GET_OBJECT_COORDINATES kappa_6 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			steam_x = steam_x - 1.0
			steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_6_fire
			flag_kappa6_dead = 2
		ENDIF
		
		IF flag_kappa7_dead = 0
		AND flag_kappa7_created = 1
			GET_OBJECT_COORDINATES kappa_7 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa7_dead = 1
		AND flag_kappa7_created = 1
			GET_OBJECT_COORDINATES kappa_7 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_7_fire
			flag_kappa7_dead = 2
		ENDIF
		/*
		IF flag_kappa8_dead = 0
		AND flag_kappa8_created = 1
			GET_OBJECT_COORDINATES kappa_8 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa8_dead = 1
		AND flag_kappa8_created = 1
			GET_OBJECT_COORDINATES kappa_8 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_8_fire
			flag_kappa8_dead = 2
		ENDIF
		*/
		IF flag_kappa9_dead = 0
		AND flag_kappa9_created = 1
			GET_OBJECT_COORDINATES kappa_9 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa9_dead = 1
		AND flag_kappa9_created = 1
			GET_OBJECT_COORDINATES kappa_9 steam_x steam_y steam_z
			steam_x = steam_x + 1.0
			//steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_9_fire
			flag_kappa9_dead = 2
		ENDIF
		
		IF flag_kappa10_dead = 0
		AND flag_kappa10_created = 1
			GET_OBJECT_COORDINATES kappa_10 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa10_dead = 1
		AND flag_kappa10_created = 1
			GET_OBJECT_COORDINATES kappa_10 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_10_fire
			flag_kappa10_dead = 2
		ENDIF
		/*
		IF flag_kappa11_dead = 0
		AND flag_kappa11_created = 1
			GET_OBJECT_COORDINATES kappa_11 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa11_dead = 1
		AND flag_kappa11_created = 1
			GET_OBJECT_COORDINATES kappa_11 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_11_fire
			flag_kappa11_dead = 2
		ENDIF
		*/
		IF flag_kappa12_dead = 0
		AND flag_kappa12_created = 1
			GET_OBJECT_COORDINATES kappa_12 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE_SLOWMOTION steam_x steam_y steam_z 0.0 0.0 0.0 0.3 0 0 0 50
		ENDIF
		IF flag_kappa12_dead = 1
		AND flag_kappa12_created = 1
			GET_OBJECT_COORDINATES kappa_12 steam_x steam_y steam_z
			//steam_x = steam_x + 1.0
			steam_y = steam_y + 1.0
			//steam_x = steam_x - 1.0
			//steam_y = steam_y - 1.0 
			START_SCRIPT_FIRE steam_x steam_y steam_z kappa_12_fire
			flag_kappa12_dead = 2
		ENDIF

		flag_particle_as2 = 0
	ENDIF


//-------------------------------------------TIMER-------TIMER----TIMER----------------------------------------

	IF kappa_time < 1
		PRINT_NOW (AS2_4) 3000 1 //The Cartel have warned their pushers!!
		//WAIT 3000
		GOTO mission_as2_failed
	ENDIF

	IF counter_kappa_dead = 1
	AND flag_timer_started = 0
		DISPLAY_ONSCREEN_TIMER kappa_time
		flag_timer_started = 1
	ENDIF

//----------------------------------------PLAYER INFO----------------------------------------------------------

	IF counter_kappa_dead_ind = 2
	AND flag_as2_1 = 0
		PRINT_NOW (AS2_1) 3000 1 //All Espresso Carts in Portland wrecked!
		WAIT 3000
		flag_as2_1 = 1
		IF flag_as2_2 = 0
		AND flag_as2_3 = 0
			PRINT_NOW (AS2_5) 4000 1 //There are still coffee carts in Staunton Island and Shoreside Vale!
			WAIT 3000
		ENDIF
		IF flag_as2_2 = 1
		AND flag_as2_3 = 0
			PRINT_NOW (AS2_6) 4000 1 //There are still coffee carts in Shoreside Vale!
			WAIT 3000
		ENDIF
		IF flag_as2_2 = 0
		AND flag_as2_3 = 1
			PRINT_NOW (AS2_7) 4000 1 //There are still coffee carts on Staunton Island!
			WAIT 3000
		ENDIF

	ENDIF

	IF counter_kappa_dead_com = 5
	AND flag_as2_2 = 0
		PRINT_NOW (AS2_2) 3000 1 //All Espresso Carts in Downtown wrecked!
		WAIT 3000
		flag_as2_2 = 1
		IF flag_as2_1 = 0
		AND flag_as2_3 = 0
			PRINT_NOW (AS2_9) 4000 1 //There are still coffee carts in Portland and Shoreside Vale!
			WAIT 3000
		ENDIF
		IF flag_as2_1 = 1
		AND flag_as2_3 = 0
			PRINT_NOW (AS2_6) 4000 1 //There are still coffee carts in Shoreside Vale!
			WAIT 3000
		ENDIF
		IF flag_as2_1 = 0
		AND flag_as2_3 = 1
			PRINT_NOW (AS2_8) 4000 1 //There are still coffee carts in Portland!
			WAIT 3000
		ENDIF

	ENDIF

	IF counter_kappa_dead_sub = 2
	AND flag_as2_3 = 0
		PRINT_NOW (AS2_3) 3000 1 //All Espresso Carts in Shoreside Vale wrecked!
		WAIT 3000
		flag_as2_3 = 1
		IF flag_as2_1 = 0
		AND flag_as2_2 = 0
			PRINT_NOW (AS2_10) 4000 1 //There are still coffee carts in Portland and Staunton Island!
			WAIT 3000
		ENDIF
		IF flag_as2_1 = 1
		AND flag_as2_2 = 0
			PRINT_NOW (AS2_7) 4000 1 //There are still coffee carts on Staunton Island!
			WAIT 3000
		ENDIF
		IF flag_as2_1 = 0
		AND flag_as2_2 = 1
			PRINT_NOW (AS2_8) 4000 1 //There are still coffee carts in Portland!
			WAIT 3000
		ENDIF

	ENDIF


	
ENDWHILE



GOTO mission_as2_passed
	   		


// Mission Asuka Sub2 failed

mission_as2_failed:
PRINT_BIG ( M_FAIL ) 2000 1

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_COMMERCIAL
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_COMMERCIAL
ENDIF

RETURN

   

// mission Asuka Sub2 passed

mission_as2_passed:

flag_asuka_suburban_mission2_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 40000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 40000
REGISTER_MISSION_PASSED AS2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT asuka_suburban_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_as2:

flag_player_on_mission = 0
flag_player_on_asuka_suburban_mission = 0

CLEAR_ONSCREEN_TIMER kappa_time
CLEAR_ONSCREEN_COUNTER counter_kappa_dead

SET_GANG_WEAPONS GANG_MAFIA WEAPONTYPE_PISTOL WEAPONTYPE_SHOTGUN //The Mafia

IF flag_kappa1_dead = 0
AND flag_kappa1_created = 1
   REMOVE_BLIP blip_kappa1
ENDIF
/*IF flag_kappa2_dead = 0
AND flag_kappa2_created = 1
   REMOVE_BLIP blip_kappa2
ENDIF*/	
IF flag_kappa3_dead = 0
AND flag_kappa3_created = 1
   REMOVE_BLIP blip_kappa3
ENDIF	
IF flag_kappa4_dead = 0
AND flag_kappa4_created = 1
   REMOVE_BLIP blip_kappa4
ENDIF	
IF flag_kappa5_dead = 0
AND flag_kappa5_created = 1
   REMOVE_BLIP blip_kappa5
ENDIF	
IF flag_kappa6_dead = 0
AND flag_kappa6_created = 1
   REMOVE_BLIP blip_kappa6
ENDIF	
IF flag_kappa7_dead = 0
AND flag_kappa7_created = 1
   REMOVE_BLIP blip_kappa7
ENDIF	
/*IF flag_kappa8_dead = 0
AND flag_kappa8_created = 1
   REMOVE_BLIP blip_kappa8
ENDIF*/	
IF flag_kappa9_dead = 0
AND flag_kappa9_created = 1
   REMOVE_BLIP blip_kappa9
ENDIF	
IF flag_kappa10_dead = 0
AND flag_kappa10_created = 1
   REMOVE_BLIP blip_kappa10
ENDIF	
/*IF flag_kappa11_dead = 0
AND flag_kappa11_created = 1
   REMOVE_BLIP blip_kappa11
ENDIF*/	
IF flag_kappa12_dead = 0
AND flag_kappa12_created = 1
   REMOVE_BLIP blip_kappa12
ENDIF	
	
REMOVE_ALL_SCRIPT_FIRES

MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_1
//MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_2
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_3
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_4
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_5
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_6
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_7
//MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_8
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_9
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_10
//MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_11
MARK_OBJECT_AS_NO_LONGER_NEEDED kappa_12

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_COLUMB
MARK_MODEL_AS_NO_LONGER_NEEDED coffee

MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B



MISSION_HAS_FINISHED
RETURN
		

///________________________________GOSUBS_______GOSUBS________________________________BYTHEWAY


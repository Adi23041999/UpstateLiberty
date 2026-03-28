MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************ASUKA SUBURBAN MISSION 1****************************** 
// *****************************************************************************************
// ******************************************'BAIT'*****************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_as1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_as1_failed
ENDIF
GOSUB mission_cleanup_as1

MISSION_END
 
// Variables for mission

VAR_INT cartel_car_a_as1 cartel_car_b_as1 cartel_car_d_as1 //cartel_car_c_as1
VAR_INT cartel1_as1 cartel2_as1 cartel3_as1 cartel4_as1
VAR_INT cartel5_as1 cartel6_as1 cartel7_as1 cartel8_as1
//VAR_INT cartel9_as1 cartel10_as1 cartel11_as1 cartel12_as1
VAR_INT cartel13_as1 cartel14_as1 cartel15_as1 cartel16_as1


VAR_INT blip_cartel1 blip_cartel2 blip_cartel3 blip_cartel4
VAR_INT blip_cartel5 blip_cartel6 blip_cartel7 blip_cartel8
//VAR_INT blip_cartel9 blip_cartel10 blip_cartel11 blip_cartel12
VAR_INT blip_cartel13 blip_cartel14 blip_cartel15 blip_cartel16

VAR_INT blip_cartelcar_a blip_cartelcar_b blip_cartelcar_d //blip_cartelcar_c

VAR_INT cartel1_as1_dead cartel2_as1_dead cartel3_as1_dead cartel4_as1_dead
VAR_INT cartel5_as1_dead cartel6_as1_dead cartel7_as1_dead cartel8_as1_dead
//VAR_INT cartel9_as1_dead cartel10_as1_dead cartel11_as1_dead cartel12_as1_dead
VAR_INT cartel13_as1_dead cartel14_as1_dead cartel15_as1_dead cartel16_as1_dead


VAR_INT yakuza1_as1 yakuza2_as1 yakuza3_as1 yakuza4_as1
VAR_INT yakuza5_as1 yakuza6_as1 yakuza7_as1 yakuza8_as1

VAR_INT flag_yak1_dead flag_yak2_dead flag_yak3_dead flag_yak4_dead
VAR_INT flag_yak5_dead flag_yak6_dead //flag_yak7_dead flag_yak8_dead

VAR_INT yak1_mission //yak4_mission

VAR_INT flag_yakuza_created_as1
VAR_INT counter_yakuza_killed_as1
VAR_INT flag_wellybob //flag_all_yak_dead

VAR_INT yaks_a_killed_by_player yaks_b_killed_by_player yaks_killed_by_player
VAR_INT flag_a_attack flag_b_attack flag_d_attack //flag_c_attack

VAR_INT blip_cartel_a_as1 blip_cartel_b_as1 blip_cartel_d_as1 //blip_cartel_c_as1
VAR_INT blip_killzone

VAR_INT flag_cartel_a_created
VAR_INT flag_cartel_b_created
//VAR_INT flag_cartel_c_created
VAR_INT flag_cartel_d_created
VAR_INT counter_cartels_killed_as1 counter_asukas_revenge counter_bailouts //counter_yak_ammo
//VAR_INT flag_cartelcar_a_dead flag_cartelcar_b_dead flag_cartelcar_c_dead flag_cartelcar_d_dead

//VAR_INT flag_blip_removed_a flag_blip_removed_b flag_blip_removed_c flag_blip_removed_d
//VAR_INT flag_car_a_blip flag_car_b_blip flag_car_c_blip flag_car_d_blip

VAR_INT flag_bailout_a flag_bailout_b flag_bailout_d //flag_bailout_c

VAR_FLOAT cartel_heading

VAR_FLOAT killzone_cent_x killzone_cent_y
VAR_FLOAT killzone_min_x killzone_min_y killzone_max_x killzone_max_y
VAR_FLOAT cartel_a_x cartel_a_y
VAR_FLOAT cartel_b_x cartel_b_y
//VAR_FLOAT cartel_c_x cartel_c_y
VAR_FLOAT cartel_d_x cartel_d_y
VAR_FLOAT yak1_x yak1_y
VAR_FLOAT yak2_x yak2_y
VAR_FLOAT yak3_x yak3_y
VAR_FLOAT yak4_x yak4_y
VAR_FLOAT yak5_x yak5_y
VAR_FLOAT yak6_x yak6_y
/*
VAR_INT timer_reset_car_a timer_reset_car_b timer_reset_car_c timer_reset_car_d
VAR_INT timer_start_car_a timer_start_car_b timer_start_car_c timer_start_car_d
VAR_INT timer_current_car_a timer_current_car_b timer_current_car_c timer_current_car_d
VAR_INT car_a_time_dif car_b_time_dif car_c_time_dif car_d_time_dif
*/
VAR_FLOAT car_a_x_old car_a_y_old car_a_z_old car_a_as1_x car_a_as1_y car_a_as1_z
VAR_FLOAT car_b_x_old car_b_y_old car_b_z_old car_b_as1_x car_b_as1_y car_b_as1_z
//VAR_FLOAT car_c_x_old car_c_y_old car_c_z_old car_c_as1_x car_c_as1_y car_c_as1_z
VAR_FLOAT car_d_x_old car_d_y_old car_d_z_old car_d_as1_x car_d_as1_y car_d_as1_z


VAR_FLOAT cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
VAR_FLOAT cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
//VAR_FLOAT cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
VAR_FLOAT cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z

//VAR_FLOAT player_x player_y player_z



// ****************************************Mission Start************************************

mission_start_as1:
REGISTER_MISSION_GIVEN
SCRIPT_NAME asusb1 
flag_player_on_mission = 1
flag_player_on_asuka_suburban_mission = 1

WAIT 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_as1_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( AS1 ) 15000 2
*/

//  ******************************************* START OF CUTSCENE ***************************

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

LOAD_CUTSCENE a6_bait

SWITCH_STREAMING ON

SET_CUTSCENE_OFFSET 369.02 -327.5 18.46
  
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_miguel
SET_CUTSCENE_ANIM cs_miguel miguel
 
CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player
 
CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ2 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

CREATE_CUTSCENE_OBJECT cut_obj3 cs_whip
SET_CUTSCENE_ANIM cs_whip WHIP

//CREATE_CUTSCENE_HEAD cs_miguel CUT_OBJ3 cs_miguelhead
//SET_CUTSCENE_HEAD_ANIM cs_miguelhead miguel

SET_PLAYER_COORDINATES player 373.7523 -327.2676 17.1950
 
SET_PLAYER_HEADING player 270.0
 
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF

START_CUTSCENE

//------CUTSCENE TEXT-----------------------------
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3598
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (AS1_A) 10000 1
 
WHILE cs_time < 6277
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS1_B) 10000 1
 
WHILE cs_time < 12209
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS1_C) 10000 1
 
WHILE cs_time < 17758
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS1_D) 10000 1

WHILE cs_time < 22581
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW (AS1_E) 10000 1

WHILE cs_time < 29000
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

//---------------------------------SET FLAGS & VARIABLES-------------------------------------------



flag_yak1_dead = 0
flag_yak2_dead = 0
flag_yak3_dead = 0
flag_yak4_dead = 0
flag_yak5_dead = 0
flag_yak6_dead = 0
//flag_all_yak_dead = 0

counter_yakuza_killed_as1 = 0
/*
flag_blip_removed_a = 0
flag_blip_removed_b = 0
flag_blip_removed_c = 0
flag_blip_removed_d = 0

flag_car_a_blip = 0
flag_car_b_blip = 0
flag_car_c_blip = 0
flag_car_d_blip = 0
*/

yak1_mission = 0
//yak4_mission = 0

flag_cartel_a_created = 0
flag_cartel_b_created = 0
//flag_cartel_c_created = 0
flag_cartel_d_created = 0
flag_yakuza_created_as1 = 0

//flag_cartelcar_a_dead = 0
//flag_cartelcar_b_dead = 0
//flag_cartelcar_c_dead = 0
//flag_cartelcar_d_dead = 0

cartel1_as1_dead = 0
cartel2_as1_dead = 0
cartel3_as1_dead = 0
cartel4_as1_dead = 0
cartel5_as1_dead = 0
cartel6_as1_dead = 0
cartel7_as1_dead = 0
cartel8_as1_dead = 0
/*
cartel9_as1_dead = 0
cartel10_as1_dead = 0
cartel11_as1_dead = 0
cartel12_as1_dead = 0
*/
cartel13_as1_dead = 0
cartel14_as1_dead = 0
cartel15_as1_dead = 0
cartel16_as1_dead = 0

counter_cartels_killed_as1 = 0
counter_asukas_revenge = 0
counter_bailouts = 0
//counter_yak_ammo = 0

flag_bailout_a = 0
flag_bailout_b = 0
//flag_bailout_c = 0
flag_bailout_d = 0

yaks_a_killed_by_player = 0
yaks_b_killed_by_player = 0
yaks_killed_by_player = 0

//timer_as3_start = 0
timer_as3_now = 0
//timer_as3_dif = 0
particle_time = 0
flag_particle = 0

flag_a_attack = 0
flag_b_attack = 0
flag_d_attack = 0
//flag_c_attack = 0

flag_wellybob = 0
// ****************************************LOCATION COORDS**************************************

killzone_cent_x = -1185.0
killzone_cent_y = 105.0
killzone_min_x = -1254.0
killzone_min_y = 85.0
killzone_max_x = -1178.0
killzone_max_y = 160.0

cartel_a_x = -996.85// Punk Noodles
cartel_a_y = -247.5

cartel_b_x = -877.0// Dam (east end)
cartel_b_y = 562.0

//cartel_c_x = -714.0// AIRPORT
//cartel_c_y = -722.0

cartel_d_x = -459.0// Cedar Grove
cartel_d_y = 251.5

yak1_x = -1168.0 
yak1_y = 110.26
yak2_x = -1185.0
yak2_y = 90.4
yak3_x = -1205.24
yak3_y = 94.11
yak4_x = -1160.0
yak4_y = 119.57
yak5_x = -1173.3
yak5_y = 95.5
yak6_x = -1184.5
yak6_y = 122.6

car_a_as1_x = 0.0
car_a_as1_y = 0.0
car_a_as1_z	= 0.0
car_b_as1_x = 0.0
car_b_as1_y = 0.0
car_b_as1_z	= 0.0
//car_c_as1_x = 0.0
//car_c_as1_y = 0.0
//car_c_as1_z = 0.0
car_d_as1_x = 0.0
car_d_as1_y = 0.0
car_d_as1_z	= 0.0

ADD_BLIP_FOR_COORD cartel_a_x cartel_a_y -100.0 blip_cartel_a_as1
ADD_BLIP_FOR_COORD cartel_b_x cartel_b_y -100.0 blip_cartel_b_as1
//ADD_BLIP_FOR_COORD cartel_c_x cartel_c_y -100.0 blip_cartel_c_as1
ADD_BLIP_FOR_COORD cartel_d_x cartel_d_y -100.0 blip_cartel_d_as1
ADD_BLIP_FOR_COORD killzone_cent_x killzone_cent_y -100.0 blip_killzone
CHANGE_BLIP_COLOUR blip_killzone 4

DISPLAY_ONSCREEN_COUNTER_WITH_STRING counter_cartels_killed_as1 COUNTER_DISPLAY_NUMBER KILLS

SWITCH_ROADS_OFF killzone_min_x killzone_min_y 65.0 -1170.0 killzone_max_y 85.0 


// Mission stuff goes here
/*
REQUEST_MODEL PED_FEMALE1
WHILE NOT HAS_MODEL_LOADED PED_FEMALE1
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_FEMALE2
WHILE NOT HAS_MODEL_LOADED PED_FEMALE2
	WAIT 0
ENDWHILE
*/
REQUEST_MODEL PED_GANG_YAKUZA_A
WHILE NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_A
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_GANG_YAKUZA_B
WHILE NOT HAS_MODEL_LOADED PED_GANG_YAKUZA_B
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

REQUEST_MODEL CAR_SENTINEL
WHILE NOT HAS_MODEL_LOADED CAR_SENTINEL
	WAIT 0
ENDWHILE

/*
REQUEST_MODEL PED_MALE3
WHILE NOT HAS_MODEL_LOADED PED_MALE3
	WAIT 0
ENDWHILE

REQUEST_MODEL PED_MALE4
WHILE NOT HAS_MODEL_LOADED PED_MALE4
	WAIT 0
ENDWHILE



PRINT_NOW ( AS1_A ) 4000 1 //"Go and find the Colombian death squads and lead them to the Kill Zone."
WAIT 4000
PRINT_NOW ( AS1_B ) 4000 1 //"But be careful! They are professionals and they're being paid to kill you!"
WAIT 4000
*/

RESET_NUM_OF_MODELS_KILLED_BY_PLAYER


WHILE counter_cartels_killed_as1 < 12

WAIT 0

	GET_PLAYER_COORDINATES player player_x player_y player_z
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player killzone_min_x killzone_min_y 65.0 killzone_max_x killzone_max_y 75.0 false
		flag_wellybob = 1
	ELSE
		flag_wellybob = 0
	ENDIF 
	
	GOSUB yak_deaths

	IF counter_bailouts > counter_asukas_revenge
		PRINT_NOW (AS1_H) 3000 1 //you failed to lead the Deathsquad into the Yakuza trap!!
		GOTO mission_as1_failed
	ENDIF


	IF counter_yakuza_killed_as1 > 5
		PRINT_NOW ( AS1_G ) 3000 1 //Too many Yakuza are dead!!
		GOTO mission_as1_failed
	ENDIF
	
	GOSUB cartel_deaths

	GOSUB vegetables

  	GOSUB unhappy_car_check

//---------------------------------YAKUZA KILLZONE GENERATION-----------------------------------------------------------

	IF flag_yakuza_created_as1 = 0
		IF IS_PLAYER_IN_ZONE player SUB_IND
		OR IS_PLAYER_IN_ZONE player BIG_DAM
			IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN				
				
				IF flag_yak1_dead = 0
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A yak1_x yak1_y 70.0 yakuza1_as1
					SET_CHAR_HEADING yakuza1_as1 130.0
					CLEAR_CHAR_THREAT_SEARCH yakuza1_as1
					SET_CHAR_THREAT_SEARCH yakuza1_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza1_as1 THREAT_COP
					ADD_ARMOUR_TO_CHAR yakuza1_as1 100
					GIVE_WEAPON_TO_CHAR yakuza1_as1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza1_as1 true
				ENDIF

				IF flag_yak2_dead = 0	
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B yak2_x yak2_y 72.06 yakuza2_as1
					SET_CHAR_HEADING yakuza2_as1 45.0
					CLEAR_CHAR_THREAT_SEARCH yakuza2_as1
					SET_CHAR_THREAT_SEARCH yakuza2_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza2_as1 THREAT_COP
					ADD_ARMOUR_TO_CHAR yakuza2_as1 100
					GIVE_WEAPON_TO_CHAR yakuza2_as1 WEAPONTYPE_SHOTGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza2_as1 true
				ENDIF

				IF flag_yak3_dead = 0	
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B yak3_x yak3_y 72.06 yakuza3_as1
					SET_CHAR_HEADING yakuza3_as1 295.0
					CLEAR_CHAR_THREAT_SEARCH yakuza3_as1
					SET_CHAR_THREAT_SEARCH yakuza3_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza3_as1 THREAT_COP
					ADD_ARMOUR_TO_CHAR yakuza3_as1 100
					GIVE_WEAPON_TO_CHAR yakuza3_as1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza3_as1 true
				ENDIF

				IF flag_yak4_dead = 0	
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A yak4_x yak4_y 72.06 yakuza4_as1
					SET_CHAR_HEADING yakuza4_as1 130.0
					CLEAR_CHAR_THREAT_SEARCH yakuza4_as1
					SET_CHAR_THREAT_SEARCH yakuza4_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza4_as1 THREAT_COP
					ADD_ARMOUR_TO_CHAR yakuza4_as1 100
					GIVE_WEAPON_TO_CHAR yakuza4_as1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza4_as1 true
				ENDIF

				IF flag_yak5_dead = 0	
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_A yak5_x yak5_y 72.44 yakuza5_as1
					SET_CHAR_HEADING yakuza5_as1 60.0
					CLEAR_CHAR_THREAT_SEARCH yakuza5_as1
					SET_CHAR_THREAT_SEARCH yakuza5_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza5_as1 THREAT_COP_CAR
					ADD_ARMOUR_TO_CHAR yakuza5_as1 100
					GIVE_WEAPON_TO_CHAR yakuza5_as1 WEAPONTYPE_CHAINGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza5_as1 true
				ENDIF

				IF flag_yak6_dead = 0	
					CREATE_CHAR PEDTYPE_GANG_YAKUZA PED_GANG_YAKUZA_B yak6_x yak6_y 68.76 yakuza6_as1
					SET_CHAR_HEADING yakuza6_as1 180.0
					CLEAR_CHAR_THREAT_SEARCH yakuza6_as1
					SET_CHAR_THREAT_SEARCH yakuza6_as1 THREAT_GANG_COLOMBIAN
					SET_CHAR_THREAT_SEARCH yakuza6_as1 THREAT_COP_CAR
					ADD_ARMOUR_TO_CHAR yakuza6_as1 100
					GIVE_WEAPON_TO_CHAR yakuza6_as1 WEAPONTYPE_SHOTGUN 999
					SET_CHAR_STAY_IN_SAME_PLACE yakuza6_as1 true
				ENDIF


				flag_yakuza_created_as1 = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_yakuza_created_as1 = 1
		IF NOT IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
			DELETE_CHAR yakuza1_as1
			DELETE_CHAR yakuza2_as1
			DELETE_CHAR yakuza3_as1
			DELETE_CHAR yakuza4_as1
			DELETE_CHAR yakuza5_as1
			DELETE_CHAR yakuza6_as1
			flag_yakuza_created_as1 = 0
		ENDIF
		/*
		IF counter_yak_ammo = 0
			IF counter_asukas_revenge = 1
				IF NOT IS_CHAR_DEAD	yakuza1_as1
					ADD_AMMO_TO_CHAR yakuza1_as1 WEAPONTYPE_CHAINGUN 30
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza2_as1
					ADD_AMMO_TO_CHAR yakuza2_as1 WEAPONTYPE_SHOTGUN 7
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza3_as1
					ADD_AMMO_TO_CHAR yakuza3_as1 WEAPONTYPE_CHAINGUN 30
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza4_as1
					ADD_AMMO_TO_CHAR yakuza4_as1 WEAPONTYPE_M16 60
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza5_as1
					ADD_AMMO_TO_CHAR yakuza5_as1 WEAPONTYPE_M16 60
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza6_as1
					ADD_AMMO_TO_CHAR yakuza6_as1 WEAPONTYPE_SHOTGUN 7
				ENDIF
				++ counter_yak_ammo
			ENDIF
		ENDIF
		IF counter_yak_ammo = 1
			IF counter_asukas_revenge = 2
				IF NOT IS_CHAR_DEAD	yakuza1_as1
					ADD_AMMO_TO_CHAR yakuza1_as1 WEAPONTYPE_CHAINGUN 30
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza2_as1
					ADD_AMMO_TO_CHAR yakuza2_as1 WEAPONTYPE_SHOTGUN 7
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza3_as1
					ADD_AMMO_TO_CHAR yakuza3_as1 WEAPONTYPE_CHAINGUN 30
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza4_as1
					ADD_AMMO_TO_CHAR yakuza4_as1 WEAPONTYPE_M16 60
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza5_as1
					ADD_AMMO_TO_CHAR yakuza5_as1 WEAPONTYPE_M16 60
				ENDIF
				IF NOT IS_CHAR_DEAD	yakuza6_as1
					ADD_AMMO_TO_CHAR yakuza6_as1 WEAPONTYPE_SHOTGUN 7
				ENDIF
				++ counter_yak_ammo
			ENDIF
		ENDIF
		*/
  ENDIF



//--------------------------------CARTEL DEATH SQUAD 1 GENERATOR----------------------------------------


   
	IF flag_cartel_a_created = 0
			IF IS_PLAYER_IN_ZONE player SUB_IND
			OR IS_PLAYER_IN_ZONE player AIRPORT
				CREATE_CAR CAR_SENTINEL cartel_a_x cartel_a_y 34.0 cartel_car_a_as1
				SET_CAR_HEADING cartel_car_a_as1 270.0
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED cartel_car_a_as1 true
				CREATE_CHAR_INSIDE_CAR cartel_car_a_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B cartel1_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_a_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 cartel2_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_a_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 1 cartel3_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_a_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 2 cartel4_as1
				CAR_SET_IDLE cartel_car_a_as1

				flag_cartel_a_created = 1
			ENDIF
	ENDIF


//-----------------------------------CARTEL DEATH SQUAD 1 ATTACK-----------------------------------------
		
		
		IF flag_cartel_a_created = 1

			IF flag_a_attack = 0
				IF LOCATE_PLAYER_ANY_MEANS_2D player cartel_a_x cartel_a_y 30.0 30.0 false
					IF NOT IS_CAR_DEAD cartel_car_a_as1
						SET_CAR_STRONG cartel_car_a_as1 TRUE
						LOCK_CAR_DOORS cartel_car_a_as1 CARLOCK_LOCKED
						SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_a_as1 True
						REMOVE_BLIP blip_cartel_a_as1
						SET_CAR_CRUISE_SPEED cartel_car_a_as1 50.0
						SET_CAR_MISSION cartel_car_a_as1 MISSION_RAMPLAYER_FARAWAY
						SET_CAR_DRIVING_STYLE cartel_car_a_as1 2
						ADD_BLIP_FOR_CAR cartel_car_a_as1 blip_cartelcar_a
						SET_CAR_STAYS_IN_CURRENT_LEVEL cartel_car_a_as1 FALSE
						//SET_CAR_WATERTIGHT cartel_car_a_as1 TRUE
						flag_a_attack = 1
					ENDIF
				ELSE
					IF IS_CAR_DEAD cartel_car_a_as1
						REMOVE_BLIP	blip_cartel_a_as1
					ENDIF
				ENDIF
			ENDIF
			
			IF IS_CAR_DEAD cartel_car_a_as1
			AND flag_a_attack = 0
				PRINT_NOW (AS1_H) 3000 1 //you failed to lead the Deathsquad into the Yakuza trap!!
				GOTO mission_as1_failed
			ENDIF

			
			IF NOT IS_CAR_DEAD cartel_car_a_as1
				IF flag_bailout_a = 0
				AND flag_a_attack = 1	
					IF NOT LOCATE_CAR_2D cartel_car_a_as1 player_x player_y 40.0 40.0 false
						SET_CAR_CRUISE_SPEED cartel_car_a_as1 30.0
						//CAR_WANDER_RANDOMLY cartel_car_a_as1
						//SET_CAR_MISSION cartel_car_a_as1 MISSION_NONE
						//CAR_GOTO_COORDINATES cartel_car_a_as1 player_x player_y player_z
						//SET_CAR_DRIVING_STYLE cartel_car_a_as1 2
					ELSE
						SET_CAR_CRUISE_SPEED cartel_car_a_as1 60.0
						//SET_CAR_MISSION cartel_car_a_as1 MISSION_RAMPLAYER_FARAWAY
						//SET_CAR_DRIVING_STYLE cartel_car_a_as1 2
					ENDIF

					IF NOT IS_CAR_HEALTH_GREATER cartel_car_a_as1 250
						GOSUB bailout_a
					ENDIF
						
					IF NOT IS_PLAYER_IN_ANY_CAR player
					AND flag_bailout_a = 0
					AND NOT IS_CAR_DEAD cartel_car_a_as1
						IF flag_wellybob = 0
							GET_PLAYER_COORDINATES player player_x player_y player_z
							IF LOCATE_CAR_3D cartel_car_a_as1 player_x player_y player_z 10.0 10.0 5.0 false
								GOSUB bailout_a
							ENDIF
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD cartel_car_a_as1
						IF LOCATE_CAR_3D cartel_car_a_as1 killzone_cent_x killzone_cent_y 70.0 17.0 30.0 3.0 false
						AND flag_bailout_a = 0
							SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_a_as1 false
							++ counter_asukas_revenge
							GOSUB bailout_a
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF flag_bailout_a = 1
				IF NOT IS_CHAR_DEAD cartel1_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel1_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel2_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel2_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel3_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel3_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel4_as1
					IF LOCATE_CHAR_ON_FOOT_2D cartel4_as1 killzone_cent_x killzone_cent_y 15.0 15.0 false
					AND NOT IS_CHAR_DEAD yakuza1_as1
						SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS cartel4_as1 yakuza1_as1
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel4_as1 player
					ENDIF
				ENDIF
			ENDIF

	
		ENDIF


//--------------------------------CARTEL DEATH SQUAD 2 GENERATOR-----------------------------------


   
	IF flag_cartel_b_created = 0
			IF IS_PLAYER_IN_ZONE player BIG_DAM
				CREATE_CAR CAR_SENTINEL cartel_b_x cartel_b_y 74.2 cartel_car_b_as1
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED cartel_car_b_as1 true
				SET_CAR_HEADING cartel_car_b_as1 180.0
				CREATE_CHAR_INSIDE_CAR cartel_car_b_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A cartel5_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_b_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 cartel6_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_b_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 cartel7_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_b_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 2 cartel8_as1
				CAR_SET_IDLE cartel_car_b_as1

				flag_cartel_b_created = 1
			ENDIF
	ENDIF


//-----------------------------------CARTEL DEATH SQUAD 2 ATTACK----------------------------------
		
		
		IF flag_cartel_b_created = 1

			IF flag_b_attack = 0
				IF LOCATE_PLAYER_ANY_MEANS_2D player cartel_b_x cartel_b_y 40.0 40.0 false
					IF NOT IS_CAR_DEAD cartel_car_b_as1
						SET_CAR_STRONG cartel_car_b_as1 TRUE
						LOCK_CAR_DOORS cartel_car_b_as1 CARLOCK_LOCKED
						SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_b_as1 True
						REMOVE_BLIP blip_cartel_b_as1
						SET_CAR_CRUISE_SPEED cartel_car_b_as1 50.0
						SET_CAR_MISSION cartel_car_b_as1 MISSION_RAMPLAYER_FARAWAY
						SET_CAR_DRIVING_STYLE cartel_car_b_as1 2
						ADD_BLIP_FOR_CAR cartel_car_b_as1 blip_cartelcar_b
						SET_CAR_STAYS_IN_CURRENT_LEVEL cartel_car_b_as1 FALSE
						//SET_CAR_WATERTIGHT cartel_car_b_as1 TRUE
						flag_b_attack = 1
					ENDIF
				ELSE
					IF IS_CAR_DEAD cartel_car_b_as1
						REMOVE_BLIP	blip_cartel_b_as1
					ENDIF
				ENDIF
			ENDIF

			IF IS_CAR_DEAD cartel_car_b_as1
			AND flag_b_attack = 0
				PRINT_NOW (AS1_H) 3000 1 //you failed to lead the Deathsquad into the Yakuza trap!!
				GOTO mission_as1_failed
			ENDIF
			
			IF NOT IS_CAR_DEAD cartel_car_b_as1
				IF flag_bailout_b = 0
				AND flag_b_attack = 1
					IF NOT LOCATE_CAR_2D cartel_car_b_as1 player_x player_y 40.0 40.0 false
						SET_CAR_CRUISE_SPEED cartel_car_b_as1 30.0
						//CAR_WANDER_RANDOMLY cartel_car_b_as1
						//SET_CAR_MISSION cartel_car_b_as1 MISSION_NONE
						//CAR_GOTO_COORDINATES cartel_car_b_as1 player_x player_y player_z
						//SET_CAR_DRIVING_STYLE cartel_car_b_as1 2
					ELSE
						SET_CAR_CRUISE_SPEED cartel_car_b_as1 60.0
						//SET_CAR_MISSION cartel_car_b_as1 MISSION_RAMPLAYER_FARAWAY
						//SET_CAR_DRIVING_STYLE cartel_car_b_as1 2
					ENDIF
					/*
					IF IS_CAR_IN_AREA_2D cartel_car_b_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
						CAR_GOTO_COORDINATES cartel_car_b_as1 killzone_cent_x killzone_cent_y 70.0
					ENDIF
					*/
					IF NOT IS_CAR_HEALTH_GREATER cartel_car_b_as1 250
						GOSUB bailout_b
					ENDIF
					
					
					IF NOT IS_PLAYER_IN_ANY_CAR player
					AND flag_bailout_b = 0
					AND NOT IS_CAR_DEAD	cartel_car_b_as1
						IF flag_wellybob = 0
							GET_PLAYER_COORDINATES player player_x player_y player_z
							IF LOCATE_CAR_3D cartel_car_b_as1 player_x player_y player_z 10.0 10.0 5.0 false
								GOSUB bailout_b
							ENDIF
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD cartel_car_b_as1
						IF LOCATE_CAR_3D cartel_car_b_as1 killzone_cent_x killzone_cent_y 70.0 17.0 30.0 3.0 false
						AND flag_bailout_b = 0												
							SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_b_as1 false
							++ counter_asukas_revenge
							GOSUB bailout_b
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF flag_bailout_b = 1
				IF NOT IS_CHAR_DEAD cartel5_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel5_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel6_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel6_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel7_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel7_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel8_as1
					IF LOCATE_CHAR_ON_FOOT_2D cartel8_as1 killzone_cent_x killzone_cent_y 15.0 15.0 false
					AND NOT IS_CHAR_DEAD yakuza4_as1
						SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS cartel8_as1 yakuza4_as1
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel8_as1 player
					ENDIF
				ENDIF
			ENDIF

	
		ENDIF

/*
//--------------------------------CARTEL DEATH SQUAD 3 GENERATOR-----------------------------------


   
	IF flag_cartel_c_created = 0
			IF IS_PLAYER_IN_ZONE player AIRPORT
				CREATE_CAR CAR_SENTINEL cartel_c_x cartel_c_y 9.0 cartel_car_c_as1
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED cartel_car_c_as1 true
				SET_CAR_HEADING cartel_car_c_as1 55.0
				CREATE_CHAR_INSIDE_CAR cartel_car_c_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A cartel9_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_c_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 cartel10_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_c_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 cartel11_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_c_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 2 cartel12_as1
				CAR_SET_IDLE cartel_car_c_as1

				flag_cartel_c_created = 1
			ENDIF
	ENDIF


//-----------------------------------CARTEL DEATH SQUAD 3 ATTACK----------------------------------
		
		
		IF flag_cartel_c_created = 1

			IF flag_c_attack = 0
				IF LOCATE_PLAYER_ANY_MEANS_2D player cartel_c_x cartel_c_y 30.0 30.0 false
					IF NOT IS_CAR_DEAD cartel_car_c_as1
						SET_CAR_STRONG cartel_car_c_as1 TRUE
						LOCK_CAR_DOORS cartel_car_c_as1 CARLOCK_LOCKED
						SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_c_as1 True
						REMOVE_BLIP blip_cartel_c_as1
						SET_CAR_CRUISE_SPEED cartel_car_c_as1 50.0
						SET_CAR_MISSION cartel_car_c_as1 MISSION_RAMPLAYER_FARAWAY
						SET_CAR_DRIVING_STYLE cartel_car_c_as1 2
						ADD_BLIP_FOR_CAR cartel_car_c_as1 blip_cartelcar_c
						SET_CAR_STAYS_IN_CURRENT_LEVEL cartel_car_c_as1 FALSE
						flag_c_attack = 1
					ENDIF
				ELSE
					IF IS_CAR_DEAD cartel_car_c_as1
						REMOVE_BLIP	blip_cartel_c_as1
					ENDIF
				ENDIF
			ENDIF

			
			IF NOT IS_CAR_DEAD cartel_car_c_as1
				IF flag_bailout_c = 0
				AND flag_c_attack = 1	
					IF NOT LOCATE_CAR_2D cartel_car_c_as1 player_x player_y 40.0 40.0 false
						SET_CAR_CRUISE_SPEED cartel_car_c_as1 30.0
						//SET_CAR_MISSION cartel_car_c_as1 MISSION_NONE
						//CAR_GOTO_COORDINATES cartel_car_c_as1 player_x player_y player_z
						//SET_CAR_DRIVING_STYLE cartel_car_c_as1 2
					ELSE
						SET_CAR_CRUISE_SPEED cartel_car_c_as1 50.0
						//SET_CAR_MISSION cartel_car_c_as1 MISSION_RAMPLAYER_FARAWAY
						//SET_CAR_DRIVING_STYLE cartel_car_c_as1 2
					ENDIF
					
					IF NOT IS_CAR_HEALTH_GREATER cartel_car_c_as1 250
						GOSUB bailout_c
					ENDIF
					
					
					IF NOT IS_PLAYER_IN_ANY_CAR player
					AND flag_bailout_c = 0
					AND NOT IS_CAR_DEAD cartel_car_c_as1
						IF flag_wellybob = 0
							GET_PLAYER_COORDINATES player player_x player_y player_z
							IF LOCATE_CAR_3D cartel_car_c_as1 player_x player_y player_z 10.0 10.0 5.0 false
								GOSUB bailout_c
							ENDIF
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD cartel_car_c_as1
						IF LOCATE_CAR_2D cartel_car_c_as1 killzone_cent_x killzone_cent_y 15.0 15.0 false
						AND flag_bailout_c = 0
							SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_c_as1 false
							++ counter_asukas_revenge
							GOSUB bailout_c
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF flag_bailout_c = 1
				IF NOT IS_CHAR_DEAD cartel9_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel9_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel10_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel10_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel11_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel11_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel12_as1
					IF LOCATE_CHAR_ON_FOOT_2D cartel12_as1 killzone_cent_x killzone_cent_y 15.0 15.0 false
					AND NOT IS_CHAR_DEAD yakuza1_as1
						SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS cartel12_as1 yakuza1_as1
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel12_as1 player
					ENDIF
				ENDIF
			ENDIF

	
		ENDIF

*/
//--------------------------------CARTEL DEATH SQUAD 4 GENERATOR-----------------------------------


   
	IF flag_cartel_d_created = 0
			IF LOCATE_PLAYER_ANY_MEANS_3D player cartel_d_x cartel_d_y 70.0 70.0 70.0 20.0 false
				CREATE_CAR CAR_SENTINEL cartel_d_x cartel_d_y 70.0 cartel_car_d_as1
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED cartel_car_d_as1 true
				SET_CAR_HEADING cartel_car_d_as1 180.0
				CAR_SET_IDLE cartel_car_d_as1
				CREATE_CHAR_INSIDE_CAR cartel_car_d_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A cartel13_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_d_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 0 cartel14_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_d_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_A 1 cartel15_as1
				CREATE_CHAR_AS_PASSENGER cartel_car_d_as1 PEDTYPE_GANG_COLOMBIAN PED_GANG_COLOMBIAN_B 2 cartel16_as1
				CAR_SET_IDLE cartel_car_d_as1
				
				flag_cartel_d_created = 1
			ENDIF
	ENDIF


//-----------------------------------CARTEL DEATH SQUAD 4 ATTACK----------------------------------
		
		
		IF flag_cartel_d_created = 1

			IF flag_d_attack = 0
				IF LOCATE_PLAYER_ANY_MEANS_3D player cartel_d_x cartel_d_y 70.0 30.0 30.0 20.0 false
					IF NOT IS_CAR_DEAD cartel_car_d_as1
						SET_CAR_STRONG cartel_car_d_as1 TRUE
						LOCK_CAR_DOORS cartel_car_d_as1 CARLOCK_LOCKED
						SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_d_as1 True
						REMOVE_BLIP blip_cartel_d_as1
						SET_CAR_CRUISE_SPEED cartel_car_d_as1 50.0
						SET_CAR_MISSION cartel_car_d_as1 MISSION_RAMPLAYER_FARAWAY
						SET_CAR_DRIVING_STYLE cartel_car_d_as1 2
						ADD_BLIP_FOR_CAR cartel_car_d_as1 blip_cartelcar_d
						SET_CAR_STAYS_IN_CURRENT_LEVEL cartel_car_d_as1 FALSE
						//SET_CAR_WATERTIGHT cartel_car_d_as1 TRUE
						flag_d_attack = 1
					ENDIF
				ELSE
					IF IS_CAR_DEAD cartel_car_d_as1
						REMOVE_BLIP	blip_cartel_d_as1
					ENDIF
				ENDIF
			ENDIF

			IF IS_CAR_DEAD cartel_car_d_as1
			AND flag_d_attack = 0
				PRINT_NOW (AS1_H) 3000 1 //you failed to lead the Deathsquad into the Yakuza trap!!
				GOTO mission_as1_failed
			ENDIF
			
			IF NOT IS_CAR_DEAD cartel_car_d_as1
				IF flag_bailout_d = 0
				AND flag_d_attack = 1	
					IF NOT LOCATE_CAR_2D cartel_car_d_as1 player_x player_y 40.0 40.0 false
						SET_CAR_CRUISE_SPEED cartel_car_d_as1 30.0
						//CAR_WANDER_RANDOMLY cartel_car_d_as1
						//SET_CAR_MISSION cartel_car_d_as1 MISSION_NONE
						//CAR_GOTO_COORDINATES cartel_car_d_as1 player_x player_y player_z
						//SET_CAR_DRIVING_STYLE cartel_car_d_as1 2
					ELSE
						SET_CAR_CRUISE_SPEED cartel_car_d_as1 60.0
						//SET_CAR_MISSION cartel_car_d_as1 MISSION_RAMPLAYER_FARAWAY
						//SET_CAR_DRIVING_STYLE cartel_car_d_as1 2
					ENDIF
					/*
					IF IS_CAR_IN_AREA_2D cartel_car_d_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
						CAR_GOTO_COORDINATES cartel_car_d_as1 killzone_cent_x killzone_cent_y 70.0
					ENDIF
					*/
					IF NOT IS_CAR_HEALTH_GREATER cartel_car_d_as1 250
					//OR IS_CAR_UPSIDEDOWN cartel_car_d_as1
						GOSUB bailout_d
					ENDIF
					
					
					IF NOT IS_PLAYER_IN_ANY_CAR player
					AND flag_bailout_d = 0
					AND NOT IS_CAR_DEAD cartel_car_d_as1
						IF flag_wellybob = 0
							GET_PLAYER_COORDINATES player player_x player_y player_z
							IF LOCATE_CAR_3D cartel_car_d_as1 player_x player_y player_z 10.0 10.0 5.0 false
								GOSUB bailout_d
							ENDIF
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD cartel_car_d_as1
						IF LOCATE_CAR_3D cartel_car_d_as1 killzone_cent_x killzone_cent_y 70.0 17.0 30.0 3.0 false
						AND flag_bailout_d = 0
							SET_CAR_ONLY_DAMAGED_BY_PLAYER cartel_car_d_as1 false
							++ counter_asukas_revenge
							GOSUB bailout_d
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF flag_bailout_d = 1
				IF NOT IS_CHAR_DEAD cartel13_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel13_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel14_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel14_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel15_as1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel15_as1 player
				ENDIF
				IF NOT IS_CHAR_DEAD cartel16_as1
					IF LOCATE_CHAR_ON_FOOT_2D cartel16_as1 killzone_cent_x killzone_cent_y 15.0 15.0 false
					AND NOT IS_CHAR_DEAD yakuza4_as1
						SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS cartel16_as1 yakuza4_as1
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS cartel16_as1 player
					ENDIF
				ENDIF
			ENDIF

	
		ENDIF


//----------------------------------------------YAK1 MISSIONS------------------------------------------------------

		/*
		IF flag_yakuza_created_as1 = 1
			IF NOT IS_CHAR_DEAD yakuza1_as1
				IF flag_cartel_a_created = 1
					IF NOT IS_CHAR_DEAD cartel3_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel3_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel3_as1
							yak1_mission = 1
						ENDIF
					ENDIF
				ENDIF

				IF flag_cartel_b_created = 1
					IF NOT IS_CHAR_DEAD cartel8_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel8_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel8_as1
							yak1_mission = 2
						ENDIF
					ENDIF
				ENDIF
				
				IF flag_cartel_c_created = 1
					IF NOT IS_CHAR_DEAD cartel9_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel9_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel9_as1
							yak1_mission = 3
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD cartel10_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel10_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel10_as1
							yak1_mission = 4
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD cartel11_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel11_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel11_as1
							yak1_mission = 5
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD cartel12_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel12_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel12_as1
							yak1_mission = 6
						ENDIF
					ENDIF
				ENDIF

				IF flag_cartel_d_created = 1
					IF NOT IS_CHAR_DEAD cartel16_as1
					AND yak1_mission = 0
						IF IS_CHAR_IN_AREA_2D cartel16_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT yakuza1_as1 cartel16_as1
							yak1_mission = 7
						ENDIF
					ENDIF
				ENDIF
				
			ENDIF
		ENDIF
		*/
//------------------------------------------YAK4 MISSIONS---------------------------------------------
		/*
		IF flag_yakuza_created_as1 = 1
			IF NOT IS_CHAR_DEAD yakuza4_as1
				IF flag_cartel_a_created = 1
					IF NOT IS_CAR_DEAD cartel_car_a_as1
					AND yak4_mission = 0
						IF IS_CAR_IN_AREA_2D cartel_car_a_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_DESTROY_CAR yakuza4_as1 cartel_car_a_as1
							yak4_mission = 1
						ENDIF
					ENDIF
				ENDIF
				IF flag_cartel_b_created = 1
					IF NOT IS_CAR_DEAD cartel_car_b_as1
					AND yak4_mission = 0
						IF IS_CAR_IN_AREA_2D cartel_car_b_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_DESTROY_CAR yakuza4_as1 cartel_car_b_as1
							yak4_mission = 2
						ENDIF
					ENDIF
				ENDIF
				
				IF flag_cartel_c_created = 1
					IF NOT IS_CAR_DEAD cartel_car_c_as1
					AND yak4_mission = 0
						IF IS_CAR_IN_AREA_2D cartel_car_c_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_DESTROY_CAR yakuza4_as1 cartel_car_c_as1
							yak4_mission = 3
						ENDIF
					ENDIF
				ENDIF
				
				IF flag_cartel_d_created = 1
					IF NOT IS_CAR_DEAD cartel_car_d_as1
					AND yak4_mission = 0
						IF IS_CAR_IN_AREA_2D cartel_car_d_as1 killzone_min_x killzone_min_y killzone_max_x killzone_max_y false
							SET_CHAR_OBJ_DESTROY_CAR yakuza4_as1 cartel_car_d_as1
							yak4_mission = 4
						ENDIF
					ENDIF
				ENDIF
				
			ENDIF
		ENDIF
		*/


ENDWHILE    	


IF counter_asukas_revenge > 2
	GOTO mission_as1_passed
ELSE
	PRINT_NOW (AS1_H) 3000 1
ENDIF
	   		


// Mission Asuka Sub1 failed

mission_as1_failed:
PRINT_BIG ( M_FAIL ) 2000 1

IF HAS_PLAYER_BEEN_ARRESTED player
	OVERRIDE_POLICE_STATION_LEVEL LEVEL_COMMERCIAL
ENDIF

IF IS_PLAYER_DEAD player
	OVERRIDE_HOSPITAL_LEVEL LEVEL_COMMERCIAL
ENDIF

RETURN

   

// mission Asuka Sub1 passed

mission_as1_passed:

flag_asuka_suburban_mission1_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 35000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 35000
REGISTER_MISSION_PASSED AS1 
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT asuka_suburban_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_as1:

flag_player_on_mission = 0
flag_player_on_asuka_suburban_mission = 0

CLEAR_ONSCREEN_COUNTER counter_cartels_killed_as1

GOSUB blip_removal

REMOVE_BLIP blip_cartel_a_as1
REMOVE_BLIP blip_cartel_b_as1
//REMOVE_BLIP blip_cartel_c_as1
REMOVE_BLIP blip_cartel_d_as1
REMOVE_BLIP blip_killzone
REMOVE_BLIP blip_cartelcar_a
REMOVE_BLIP blip_cartelcar_b
//REMOVE_BLIP blip_cartelcar_c
REMOVE_BLIP blip_cartelcar_d

MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_a_as1
MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_b_as1
//MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_c_as1
MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_d_as1

MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_YAKUZA_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_COLOMBIAN_B
//MARK_MODEL_AS_NO_LONGER_NEEDED PED_FEMALE1
//MARK_MODEL_AS_NO_LONGER_NEEDED PED_FEMALE2
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_SENTINEL

//SWITCH_ROADS_ON killzone_min_x killzone_min_y 65.0 -1170.0 killzone_max_y 85.0 


MISSION_HAS_FINISHED
RETURN
		

///________________________________GOSUBS_______GOSUBS________________________________BYTHEWAY


//-----------------------------------------CHECK FOR YAK DEATHS-------------------------------

yak_deaths:


	IF flag_yakuza_created_as1 = 1
		IF IS_CHAR_DEAD yakuza1_as1
			IF flag_yak1_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak1_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD yakuza2_as1
			IF flag_yak2_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak2_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD yakuza3_as1
			IF flag_yak3_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak3_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD yakuza4_as1
			IF flag_yak4_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak4_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD yakuza5_as1
			IF flag_yak5_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak5_dead = 1
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD yakuza6_as1
			IF flag_yak6_dead = 0	
				++ counter_yakuza_killed_as1
				flag_yak6_dead = 1
			ENDIF
		ENDIF
		
		GET_NUM_OF_MODELS_KILLED_BY_PLAYER PED_GANG_YAKUZA_A yaks_a_killed_by_player
		GET_NUM_OF_MODELS_KILLED_BY_PLAYER PED_GANG_YAKUZA_B yaks_b_killed_by_player
		yaks_killed_by_player = yaks_a_killed_by_player + yaks_b_killed_by_player

		IF yaks_killed_by_player > 2
			IF NOT IS_CHAR_DEAD yakuza1_as1
				SET_CHAR_THREAT_SEARCH yakuza1_as1 THREAT_PLAYER1
			ENDIF
			IF NOT IS_CHAR_DEAD yakuza2_as1
				SET_CHAR_THREAT_SEARCH yakuza2_as1 THREAT_PLAYER1
			ENDIF
			IF NOT IS_CHAR_DEAD yakuza3_as1
				SET_CHAR_THREAT_SEARCH yakuza3_as1 THREAT_PLAYER1
			ENDIF
			IF NOT IS_CHAR_DEAD yakuza4_as1
				SET_CHAR_THREAT_SEARCH yakuza4_as1 THREAT_PLAYER1
			ENDIF
			IF NOT IS_CHAR_DEAD yakuza5_as1
				SET_CHAR_THREAT_SEARCH yakuza5_as1 THREAT_PLAYER1
			ENDIF
			IF NOT IS_CHAR_DEAD yakuza6_as1
				SET_CHAR_THREAT_SEARCH yakuza6_as1 THREAT_PLAYER1
			ENDIF
	   ENDIF
	ENDIF
RETURN


//-----------------------------------------------------'BAILOUTS'----------------

bailout_a:
	
IF flag_bailout_a = 0
	//flag_cartelcar_a_dead = 1
	flag_bailout_a = 1
	++ counter_bailouts
	
	REMOVE_BLIP blip_cartelcar_a
	LOCK_CAR_DOORS cartel_car_a_as1 CARLOCK_UNLOCKED 
	IF NOT IS_CHAR_DEAD cartel1_as1
	AND NOT IS_CAR_DEAD	cartel_car_a_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel1_as1 cartel_car_a_as1
		WHILE IS_CHAR_IN_CAR cartel1_as1 cartel_car_a_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel1_as1
				GOTO c_a_2
			ENDIF
			IF IS_CAR_DEAD cartel_car_a_as1
				GOTO c_a_2
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel1_as1
		SET_CHAR_THREAT_SEARCH cartel1_as1 THREAT_PLAYER1 
		GIVE_WEAPON_TO_CHAR cartel1_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel1_as1 blip_cartel1
	ENDIF

	c_a_2:
	IF NOT IS_CHAR_DEAD cartel2_as1
	AND NOT IS_CAR_DEAD	cartel_car_a_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel2_as1 cartel_car_a_as1
		WHILE IS_CHAR_IN_CAR cartel2_as1 cartel_car_a_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel2_as1
				GOTO c_a_3
			ENDIF
			IF IS_CAR_DEAD cartel_car_a_as1
				GOTO c_a_3
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel2_as1
		SET_CHAR_THREAT_SEARCH cartel2_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel2_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel2_as1 blip_cartel2
	ENDIF

	c_a_3:
	IF NOT IS_CHAR_DEAD cartel3_as1
	AND NOT IS_CAR_DEAD	cartel_car_a_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel3_as1 cartel_car_a_as1
		WHILE IS_CHAR_IN_CAR cartel3_as1 cartel_car_a_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel3_as1
				GOTO c_a_4
			ENDIF
			IF IS_CAR_DEAD cartel_car_a_as1
				GOTO c_a_4
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel3_as1
		SET_CHAR_THREAT_SEARCH cartel3_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel3_as1 WEAPONTYPE_SHOTGUN 15
		ADD_BLIP_FOR_CHAR cartel3_as1 blip_cartel3
	ENDIF

	c_a_4:
	IF NOT IS_CHAR_DEAD cartel4_as1
	AND NOT IS_CAR_DEAD	cartel_car_a_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel4_as1 cartel_car_a_as1
		WHILE IS_CHAR_IN_CAR cartel4_as1 cartel_car_a_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel4_as1
				GOTO c_a_5
			ENDIF
			IF IS_CAR_DEAD cartel_car_a_as1
				GOTO c_a_5
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel4_as1
		SET_CHAR_THREAT_SEARCH cartel4_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel4_as1 WEAPONTYPE_SHOTGUN 15
		ADD_BLIP_FOR_CHAR cartel4_as1 blip_cartel4
	ENDIF

	c_a_5:
	//MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_a_as1
ENDIF
RETURN


bailout_b:
IF flag_bailout_b = 0
	//flag_cartelcar_b_dead = 1
	flag_bailout_b = 1
	++ counter_bailouts
	
	REMOVE_BLIP blip_cartelcar_b
	LOCK_CAR_DOORS cartel_car_b_as1 CARLOCK_UNLOCKED
	IF NOT IS_CHAR_DEAD cartel5_as1
	AND NOT IS_CAR_DEAD	cartel_car_b_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel5_as1 cartel_car_b_as1
		WHILE IS_CHAR_IN_CAR cartel5_as1 cartel_car_b_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel5_as1
				GOTO c_b_2
			ENDIF
			IF IS_CAR_DEAD cartel_car_b_as1
				GOTO c_b_2
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel5_as1
		SET_CHAR_THREAT_SEARCH cartel5_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel5_as1 WEAPONTYPE_UZI 90
		ADD_BLIP_FOR_CHAR cartel5_as1 blip_cartel5
	ENDIF

	c_b_2:
	IF NOT IS_CHAR_DEAD cartel6_as1
	AND NOT IS_CAR_DEAD	cartel_car_b_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel6_as1 cartel_car_b_as1
		WHILE IS_CHAR_IN_CAR cartel6_as1 cartel_car_b_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel6_as1
				GOTO c_b_3
			ENDIF
			IF IS_CAR_DEAD cartel_car_b_as1
				GOTO c_b_3
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel6_as1
		SET_CHAR_THREAT_SEARCH cartel6_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel6_as1 WEAPONTYPE_UZI 90
		ADD_BLIP_FOR_CHAR cartel6_as1 blip_cartel6
	ENDIF

	c_b_3:
	IF NOT IS_CHAR_DEAD cartel7_as1
	AND NOT IS_CAR_DEAD	cartel_car_b_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel7_as1 cartel_car_b_as1
		WHILE IS_CHAR_IN_CAR cartel7_as1 cartel_car_b_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel7_as1
				GOTO c_b_4
			ENDIF
			IF IS_CAR_DEAD cartel_car_b_as1
				GOTO c_b_4
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel7_as1
		SET_CHAR_THREAT_SEARCH cartel7_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel7_as1 WEAPONTYPE_UZI 90
		ADD_BLIP_FOR_CHAR cartel7_as1 blip_cartel7
	ENDIF

	c_b_4:
	IF NOT IS_CHAR_DEAD cartel8_as1
	AND NOT IS_CAR_DEAD	cartel_car_b_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel8_as1 cartel_car_b_as1
		WHILE IS_CHAR_IN_CAR cartel8_as1 cartel_car_b_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel8_as1
				GOTO c_b_5
			ENDIF
			IF IS_CAR_DEAD cartel_car_b_as1
				GOTO c_b_5
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel8_as1
		SET_CHAR_THREAT_SEARCH cartel8_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel8_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel8_as1 blip_cartel8
	ENDIF

	c_b_5:
	//MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_b_as1
ENDIF
RETURN
/*
bailout_c:
IF flag_bailout_c = 0
	REMOVE_BLIP blip_cartelcar_c
	LOCK_CAR_DOORS cartel_car_c_as1 CARLOCK_UNLOCKED
	IF NOT IS_CHAR_DEAD cartel9_as1
	AND NOT IS_CAR_DEAD	cartel_car_c_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel9_as1 cartel_car_c_as1
		WHILE IS_CHAR_IN_CAR cartel9_as1 cartel_car_c_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel9_as1
				GOTO c_c_2
			ENDIF
			IF IS_CAR_DEAD cartel_car_c_as1
				GOTO c_c_2
			ENDIF
		ENDWHILE
		SET_CHAR_THREAT_SEARCH cartel9_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel9_as1 WEAPONTYPE_SHOTGUN 10
		ADD_BLIP_FOR_CHAR cartel9_as1 blip_cartel9
	ENDIF

	c_c_2:
	IF NOT IS_CHAR_DEAD cartel10_as1
	AND NOT IS_CAR_DEAD	cartel_car_c_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel10_as1 cartel_car_c_as1
		WHILE IS_CHAR_IN_CAR cartel10_as1 cartel_car_c_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel10_as1
				GOTO c_c_3
			ENDIF
			IF IS_CAR_DEAD cartel_car_c_as1
				GOTO c_c_3
			ENDIF
		ENDWHILE
		SET_CHAR_THREAT_SEARCH cartel10_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel10_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel10_as1 blip_cartel10
	ENDIF

	c_c_3:
	IF NOT IS_CHAR_DEAD cartel11_as1
	AND NOT IS_CAR_DEAD	cartel_car_c_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel11_as1 cartel_car_c_as1
		WHILE IS_CHAR_IN_CAR cartel11_as1 cartel_car_c_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel11_as1
				GOTO c_c_4
			ENDIF
			IF IS_CAR_DEAD cartel_car_c_as1
				GOTO c_c_4
			ENDIF
		ENDWHILE
		SET_CHAR_THREAT_SEARCH cartel11_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel11_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel11_as1 blip_cartel11
	ENDIF

	c_c_4:
	IF NOT IS_CHAR_DEAD cartel12_as1
	AND NOT IS_CAR_DEAD	cartel_car_c_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel12_as1 cartel_car_c_as1
		WHILE IS_CHAR_IN_CAR cartel12_as1 cartel_car_c_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel12_as1
				GOTO c_c_5
			ENDIF
			IF IS_CAR_DEAD cartel_car_c_as1
				GOTO c_c_5
			ENDIF
		ENDWHILE
		SET_CHAR_THREAT_SEARCH cartel12_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel12_as1 WEAPONTYPE_SHOTGUN 15
		ADD_BLIP_FOR_CHAR cartel12_as1 blip_cartel12
	ENDIF

	c_c_5:
	flag_cartelcar_c_dead = 1
	flag_bailout_c = 1
	++ counter_bailouts
	//MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_c_as1
ENDIF
RETURN
*/
bailout_d:
IF flag_bailout_d = 0
	//flag_cartelcar_d_dead = 1
	flag_bailout_d = 1
	++ counter_bailouts
	
	REMOVE_BLIP blip_cartelcar_d
	LOCK_CAR_DOORS cartel_car_d_as1 CARLOCK_UNLOCKED
	IF NOT IS_CHAR_DEAD cartel13_as1
	AND NOT IS_CAR_DEAD	cartel_car_d_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel13_as1 cartel_car_d_as1
		WHILE IS_CHAR_IN_CAR cartel13_as1 cartel_car_d_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel13_as1
				GOTO c_d_2
			ENDIF
			IF IS_CAR_DEAD cartel_car_d_as1
				GOTO c_d_2
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel13_as1
		SET_CHAR_THREAT_SEARCH cartel13_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel13_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel13_as1 blip_cartel13
	ENDIF

	c_d_2:
	IF NOT IS_CHAR_DEAD cartel14_as1
	AND NOT IS_CAR_DEAD	cartel_car_d_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel14_as1 cartel_car_d_as1
		WHILE IS_CHAR_IN_CAR cartel14_as1 cartel_car_d_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel14_as1
				GOTO c_d_3
			ENDIF
			IF IS_CAR_DEAD cartel_car_d_as1
				GOTO c_d_3
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel14_as1
		SET_CHAR_THREAT_SEARCH cartel14_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel14_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel14_as1 blip_cartel14
	ENDIF

	c_d_3:
	IF NOT IS_CHAR_DEAD cartel15_as1
	AND NOT IS_CAR_DEAD	cartel_car_d_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel15_as1 cartel_car_d_as1
		WHILE IS_CHAR_IN_CAR cartel15_as1 cartel_car_d_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel15_as1
				GOTO c_d_4
			ENDIF
			IF IS_CAR_DEAD cartel_car_d_as1
				GOTO c_d_4
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel15_as1
		SET_CHAR_THREAT_SEARCH cartel15_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel15_as1 WEAPONTYPE_SHOTGUN 15
		ADD_BLIP_FOR_CHAR cartel15_as1 blip_cartel15
	ENDIF

	c_d_4:
	IF NOT IS_CHAR_DEAD cartel16_as1
	AND NOT IS_CAR_DEAD	cartel_car_d_as1
		SET_CHAR_OBJ_LEAVE_CAR cartel16_as1 cartel_car_d_as1
		WHILE IS_CHAR_IN_CAR cartel16_as1 cartel_car_d_as1
			WAIT 0
			IF IS_CHAR_DEAD cartel16_as1
				GOTO c_d_5
			ENDIF
			IF IS_CAR_DEAD cartel_car_d_as1
				GOTO c_d_5
			ENDIF
		ENDWHILE
		//CLEAR_CHAR_THREAT_SEARCH cartel16_as1
		SET_CHAR_THREAT_SEARCH cartel16_as1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR cartel16_as1 WEAPONTYPE_M16 100
		ADD_BLIP_FOR_CHAR cartel16_as1 blip_cartel16
	ENDIF

	c_d_5:
	//MARK_CAR_AS_NO_LONGER_NEEDED cartel_car_d_as1
ENDIF
RETURN

//-----------------------------------------------CARTEL DEATHS-----------------------------
cartel_deaths:

IF flag_cartel_a_created = 1
	
	IF cartel1_as1_dead = 0
		IF IS_CHAR_DEAD cartel1_as1
			IF cartel1_as1_dead = 0
				cartel1_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel1
			ENDIF
		ENDIF 
	ENDIF


	IF cartel2_as1_dead = 0
		IF IS_CHAR_DEAD cartel2_as1
			IF cartel2_as1_dead = 0
				cartel2_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel2
			ENDIF
		ENDIF 
	ENDIF


	IF cartel3_as1_dead = 0
		IF IS_CHAR_DEAD cartel3_as1
			IF cartel3_as1_dead = 0
				cartel3_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel3
				IF yak1_mission = 1
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF 
	ENDIF


	IF cartel4_as1_dead = 0
		IF IS_CHAR_DEAD cartel4_as1
			IF cartel4_as1_dead = 0
				cartel4_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel4
			ENDIF
		ENDIF
	ENDIF
	
	IF cartel4_as1_dead = 1
		IF cartel3_as1_dead = 1
			IF cartel2_as1_dead = 1
				IF cartel1_as1_dead = 1
					IF flag_bailout_a =0
						++ counter_bailouts
						flag_bailout_a = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
ENDIF

IF flag_cartel_b_created = 1
	IF cartel5_as1_dead = 0
		IF IS_CHAR_DEAD cartel5_as1
			IF cartel5_as1_dead = 0
				cartel5_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel5
			ENDIF
		ENDIF
	ENDIF 



	IF cartel6_as1_dead = 0
		IF IS_CHAR_DEAD cartel6_as1
			IF cartel6_as1_dead = 0
				cartel6_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel6
			ENDIF
		ENDIF
	ENDIF 



	IF cartel7_as1_dead = 0
		IF IS_CHAR_DEAD cartel7_as1
			IF cartel7_as1_dead = 0
				cartel7_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel7
			ENDIF
		ENDIF
	ENDIF 



	IF cartel8_as1_dead = 0
		IF IS_CHAR_DEAD cartel8_as1
			IF cartel8_as1_dead = 0
				cartel8_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel8
				IF yak1_mission = 2
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF cartel8_as1_dead = 1
		IF cartel7_as1_dead = 1
			IF cartel6_as1_dead = 1
				IF cartel5_as1_dead = 1
					IF flag_bailout_b =0
						++ counter_bailouts
						flag_bailout_b = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	 
ENDIF
/*
IF flag_cartel_c_created = 1
	IF cartel9_as1_dead = 0
		IF IS_CHAR_DEAD cartel9_as1
			IF cartel9_as1_dead = 0
				cartel9_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel9
				IF yak1_mission = 3
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF 
	ENDIF


	IF cartel10_as1_dead = 0
		IF IS_CHAR_DEAD cartel10_as1
			IF cartel10_as1_dead = 0
				cartel10_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel10
				IF yak1_mission = 4
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF 


	IF cartel11_as1_dead = 0
		IF IS_CHAR_DEAD cartel11_as1
			IF cartel11_as1_dead = 0
				cartel11_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel11
				IF yak1_mission = 5
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF 


	IF cartel12_as1_dead = 0
		IF IS_CHAR_DEAD cartel12_as1
			IF cartel12_as1_dead = 0
				cartel12_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel12
				IF yak1_mission = 6
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	
	
	IF cartel12_as1_dead = 1
		IF cartel11_as1_dead = 1
			IF cartel10_as1_dead = 1
				IF cartel9_as1_dead = 1
					flag_cartel_c_created = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
ENDIF
*/
IF flag_cartel_d_created = 1
	IF cartel13_as1_dead = 0
		IF IS_CHAR_DEAD cartel13_as1
			IF cartel13_as1_dead = 0
				cartel13_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel13
			ENDIF
		ENDIF
	ENDIF 


	IF cartel14_as1_dead = 0
		IF IS_CHAR_DEAD cartel14_as1
			IF cartel14_as1_dead = 0
				cartel14_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel14
			ENDIF
		ENDIF
	ENDIF 


	IF cartel15_as1_dead = 0
		IF IS_CHAR_DEAD cartel15_as1
			IF cartel15_as1_dead = 0
				cartel15_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel15
			ENDIF
		ENDIF 
	ENDIF


	IF cartel16_as1_dead = 0
		IF IS_CHAR_DEAD cartel16_as1
			IF cartel16_as1_dead = 0
				cartel16_as1_dead = 1
				++ counter_cartels_killed_as1
				REMOVE_BLIP blip_cartel16
				IF yak1_mission = 7
					yak1_mission = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF cartel16_as1_dead = 1
		IF cartel15_as1_dead = 1
			IF cartel14_as1_dead = 1
				IF cartel13_as1_dead = 1
					IF flag_bailout_d =0
						++ counter_bailouts
						flag_bailout_d = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
ENDIF


RETURN

//------------------------------------STUCK CAR ROUTINES-------------------------------------

cartel_car_a_stuck:

		IF NOT IS_CAR_DEAD cartel_car_a_as1

			IF IS_CAR_UPSIDEDOWN cartel_car_a_as1
			AND IS_CAR_STOPPED cartel_car_a_as1
				IF NOT IS_CAR_ON_SCREEN cartel_car_a_as1
					GET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
						SET_CAR_HEADING	cartel_car_a_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_a_as1
					ENDIF
				ELSE
					GOSUB bailout_a
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER cartel_car_a_as1
				//PRINT_BIG (Y1_TEST) 2000 1//CAR IN WATER!! ---test stuff
				IF NOT IS_CAR_ON_SCREEN cartel_car_a_as1
					GET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
						SET_CAR_HEADING	cartel_car_a_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_a_as1
					ENDIF
				ELSE
					flag_bailout_a = 1
					++ counter_bailouts
					REMOVE_BLIP	blip_cartelcar_a
					SET_CAR_WATERTIGHT cartel_car_a_as1 FALSE
					GOSUB cartel_deaths
					RETURN
				ENDIF
			ENDIF
			/*
			IF timer_reset_car_a = 1
				IF NOT IS_CAR_STOPPED cartel_car_a_as1
					timer_reset_car_a = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED cartel_car_a_as1
				IF timer_reset_car_a = 0
					GET_GAME_TIMER timer_start_car_a
					timer_reset_car_a = 1
				ENDIF

				IF timer_reset_car_a = 1
					GET_GAME_TIMER timer_current_car_a
					car_a_time_dif = timer_current_car_a - timer_start_car_a
				ENDIF

				IF car_a_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN cartel_car_a_as1
						GET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_heading
						IF NOT IS_POINT_ON_SCREEN cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z 3.0
							SET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
							SET_CAR_HEADING	cartel_car_a_as1 cartel_heading
							timer_reset_car_a = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF*/
		ELSE
			REMOVE_BLIP	blip_cartelcar_a
		ENDIF

RETURN

cartel_car_b_stuck:

		IF NOT IS_CAR_DEAD cartel_car_b_as1
			IF IS_CAR_UPSIDEDOWN cartel_car_b_as1
			AND IS_CAR_STOPPED cartel_car_b_as1
				IF NOT IS_CAR_ON_SCREEN cartel_car_b_as1
					GET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
						SET_CAR_HEADING cartel_car_b_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_b_as1
					ENDIF
				ELSE
					GOSUB bailout_b
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER cartel_car_b_as1
				//PRINT_BIG (Y1_TEST) 2000 1//CAR IN WATER!!----test stuff
				IF NOT IS_CAR_ON_SCREEN cartel_car_b_as1
					GET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
						SET_CAR_HEADING cartel_car_b_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_b_as1
					ENDIF
				ELSE
					flag_bailout_b = 1
					SET_CAR_WATERTIGHT cartel_car_b_as1 FALSE
					++ counter_bailouts
					REMOVE_BLIP	blip_cartelcar_b
					GOSUB cartel_deaths
					RETURN
				ENDIF
			ENDIF
			/*
			IF timer_reset_car_b = 1
				IF NOT IS_CAR_STOPPED cartel_car_b_as1
					timer_reset_car_b = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED cartel_car_b_as1
				IF timer_reset_car_b = 0
					GET_GAME_TIMER timer_start_car_b
					timer_reset_car_b = 1
				ENDIF

				IF timer_reset_car_b = 1
					GET_GAME_TIMER timer_current_car_b
					car_b_time_dif = timer_current_car_b - timer_start_car_b
				ENDIF

				IF car_b_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN cartel_car_b_as1
						GET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_heading
						IF NOT IS_POINT_ON_SCREEN cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z 3.0
							SET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
							SET_CAR_HEADING cartel_car_b_as1 cartel_heading
							timer_reset_car_b = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF*/
		ELSE
			REMOVE_BLIP	blip_cartelcar_b
		ENDIF

RETURN
/*
cartel_car_c_stuck:

		IF NOT IS_CAR_DEAD cartel_car_c_as1
			IF IS_CAR_UPSIDEDOWN cartel_car_c_as1
			AND IS_CAR_STOPPED cartel_car_c_as1
				IF NOT IS_CAR_ON_SCREEN cartel_car_c_as1
					GET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
						SET_CAR_HEADING	cartel_car_c_as1 cartel_heading
					ENDIF
				ELSE
					GOSUB bailout_c
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER cartel_car_c_as1
				//PRINT_BIG (Y1_TEST) 2000 1//CAR IN WATER!!----test stuff!!
				IF NOT IS_CAR_ON_SCREEN cartel_car_c_as1
					GET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
						SET_CAR_HEADING	cartel_car_c_as1 cartel_heading
					ENDIF
				ELSE
					flag_bailout_c = 1
					REMOVE_BLIP	blip_cartelcar_c
					GOSUB cartel_deaths
					RETURN
				ENDIF
			ENDIF

			IF timer_reset_car_c = 1
				IF NOT IS_CAR_STOPPED cartel_car_c_as1
					timer_reset_car_c = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED cartel_car_c_as1
				IF timer_reset_car_c = 0
					GET_GAME_TIMER timer_start_car_c
					timer_reset_car_c = 1
				ENDIF

				IF timer_reset_car_c = 1
					GET_GAME_TIMER timer_current_car_c
					car_c_time_dif = timer_current_car_c - timer_start_car_c
				ENDIF

				IF car_c_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN cartel_car_c_as1
						GET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z cartel_heading
						IF NOT IS_POINT_ON_SCREEN cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z 3.0
							SET_CAR_COORDINATES cartel_car_c_as1 cartel_car_c_as1_x cartel_car_c_as1_y cartel_car_c_as1_z
							SET_CAR_HEADING	cartel_car_c_as1 cartel_heading
							timer_reset_car_c = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			REMOVE_BLIP	blip_cartelcar_c
		ENDIF

RETURN
*/
cartel_car_d_stuck:

		IF NOT IS_CAR_DEAD cartel_car_d_as1
			IF IS_CAR_UPSIDEDOWN cartel_car_d_as1
			AND IS_CAR_STOPPED cartel_car_d_as1
				IF NOT IS_CAR_ON_SCREEN cartel_car_d_as1
					GET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
						SET_CAR_HEADING	cartel_car_d_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_d_as1
					ENDIF
				ELSE
					GOSUB bailout_d
				ENDIF
			ENDIF

			IF IS_CAR_IN_WATER cartel_car_d_as1
				//PRINT_BIG (Y1_TEST) 2000 1//CAR IN WATER!! ---etst stuff!!
				IF NOT IS_CAR_ON_SCREEN cartel_car_d_as1
					GET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
						SET_CAR_HEADING	cartel_car_d_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_d_as1
					ENDIF
				ELSE
					flag_bailout_d = 1
					SET_CAR_WATERTIGHT cartel_car_d_as1 FALSE
					++ counter_bailouts
					REMOVE_BLIP	blip_cartelcar_d
					GOSUB cartel_deaths
					RETURN
				ENDIF
			ENDIF
			/*
			IF timer_reset_car_d = 1
				IF NOT IS_CAR_STOPPED cartel_car_d_as1
					timer_reset_car_d = 0
				ENDIF
			ENDIF
					
			IF IS_CAR_STOPPED cartel_car_d_as1
				IF timer_reset_car_d = 0
					GET_GAME_TIMER timer_start_car_d
					timer_reset_car_d = 1
				ENDIF

				IF timer_reset_car_d = 1
					GET_GAME_TIMER timer_current_car_d
					car_d_time_dif = timer_current_car_d - timer_start_car_d
				ENDIF

				IF car_d_time_dif > 4000
					IF NOT IS_CAR_ON_SCREEN cartel_car_d_as1
						GET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
						GET_CLOSEST_CAR_NODE_WITH_HEADING cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_heading
						IF NOT IS_POINT_ON_SCREEN cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z 3.0
							SET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
							SET_CAR_HEADING	cartel_car_d_as1 cartel_heading
							timer_reset_car_d = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF*/
		ELSE
			REMOVE_BLIP	blip_cartelcar_d
		ENDIF

RETURN


vegetables:

	IF flag_cartel_a_created = 1
		IF NOT IS_CAR_DEAD cartel_car_a_as1
			IF flag_bailout_a = 0
			AND flag_a_attack = 1
				GOSUB cartel_car_a_stuck
			ENDIF
		ELSE
			REMOVE_BLIP	blip_cartelcar_a
			//yak4_mission = 0
		ENDIF
	ENDIF

	IF flag_cartel_b_created = 1
		IF NOT IS_CAR_DEAD cartel_car_b_as1
			IF flag_bailout_b = 0
			AND flag_b_attack = 1
				GOSUB cartel_car_b_stuck
			ENDIF
		ELSE
			REMOVE_BLIP	blip_cartelcar_b
			//yak4_mission = 0
		ENDIF
	ENDIF
	/*
	IF flag_cartel_c_created = 1
		IF NOT IS_CAR_DEAD cartel_car_c_as1
			IF flag_bailout_c = 0
			AND flag_c_attack = 1
				GOSUB cartel_car_c_stuck
			ENDIF
		ELSE
			REMOVE_BLIP	blip_cartelcar_c
			yak4_mission = 0
		ENDIF
	ENDIF
	*/
	IF flag_cartel_d_created = 1
		IF NOT IS_CAR_DEAD cartel_car_d_as1
			IF flag_bailout_d = 0
			AND flag_d_attack = 1
				GOSUB cartel_car_d_stuck
			ENDIF
		ELSE
			REMOVE_BLIP	blip_cartelcar_d
			//yak4_mission = 0
		ENDIF
	ENDIF

RETURN

//------------------------------------CLEAN-UP GOSUBS-----------------------------------------
blip_removal:
	REMOVE_BLIP blip_cartel1
	REMOVE_BLIP blip_cartel2
	REMOVE_BLIP blip_cartel3
	REMOVE_BLIP blip_cartel4
	REMOVE_BLIP blip_cartel5
	REMOVE_BLIP blip_cartel6
	REMOVE_BLIP blip_cartel7
	REMOVE_BLIP blip_cartel8
	/*
	REMOVE_BLIP blip_cartel9
	REMOVE_BLIP blip_cartel10
	REMOVE_BLIP blip_cartel11
	REMOVE_BLIP blip_cartel12
	*/
	REMOVE_BLIP blip_cartel13
	REMOVE_BLIP blip_cartel14
	REMOVE_BLIP blip_cartel15
	REMOVE_BLIP blip_cartel16

	IF flag_yak1_dead = 0
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza1_as1	
	ENDIF
	IF flag_yak2_dead = 0	
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza2_as1	
	ENDIF
	IF flag_yak3_dead = 0	
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza3_as1	
	ENDIF
	IF flag_yak4_dead = 0	
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza4_as1	
	ENDIF
	IF flag_yak5_dead = 0	
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza5_as1	
	ENDIF
	IF flag_yak6_dead = 0	
		MARK_CHAR_AS_NO_LONGER_NEEDED yakuza6_as1	
	ENDIF

RETURN

// ***********extrat stuck car gosub*********************

unhappy_car_check:

	GET_GAME_TIMER timer_as3_now
   //	timer_as3_dif = timer_as3_now - timer_as3_start
	IF timer_as3_now > particle_time
		particle_time = timer_as3_now + 6000
		flag_particle = 1
	ENDIF

	IF flag_particle = 1
		IF NOT IS_CAR_DEAD cartel_car_a_as1
		AND flag_a_attack = 1
		AND flag_bailout_a = 0
			car_a_x_old = car_a_as1_x
			car_a_y_old = car_a_as1_y
			car_a_z_old = car_a_as1_z

			GET_CAR_COORDINATES cartel_car_a_as1 car_a_as1_x car_a_as1_y car_a_as1_z
			IF LOCATE_CAR_2D cartel_car_a_as1 car_a_x_old car_a_y_old 3.0 3.0 false
				IF NOT IS_CAR_ON_SCREEN cartel_car_a_as1
					//GET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING car_a_as1_x car_a_as1_y car_a_as1_z cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_a_as1 cartel_car_a_as1_x cartel_car_a_as1_y cartel_car_a_as1_z
						SET_CAR_HEADING	cartel_car_a_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_a_as1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF NOT IS_CAR_DEAD cartel_car_b_as1
		AND flag_b_attack = 1
		AND flag_bailout_b = 0
			car_b_x_old = car_b_as1_x
			car_b_y_old = car_b_as1_y
			car_b_z_old = car_b_as1_z

			GET_CAR_COORDINATES cartel_car_b_as1 car_b_as1_x car_b_as1_y car_b_as1_z
			IF LOCATE_CAR_2D cartel_car_b_as1 car_b_x_old car_b_y_old 3.0 3.0 false
				IF NOT IS_CAR_ON_SCREEN cartel_car_b_as1
					//GET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING car_b_as1_x car_b_as1_y car_b_as1_z cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_b_as1 cartel_car_b_as1_x cartel_car_b_as1_y cartel_car_b_as1_z
						SET_CAR_HEADING	cartel_car_b_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_b_as1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF NOT IS_CAR_DEAD cartel_car_d_as1
		AND flag_d_attack = 1
		AND flag_bailout_d = 0
			car_d_x_old = car_d_as1_x
			car_d_y_old = car_d_as1_y
			car_d_z_old = car_d_as1_z

			GET_CAR_COORDINATES cartel_car_d_as1 car_d_as1_x car_d_as1_y car_d_as1_z
			IF LOCATE_CAR_2D cartel_car_d_as1 car_d_x_old car_d_y_old 3.0 3.0 false
				IF NOT IS_CAR_ON_SCREEN cartel_car_d_as1
					//GET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING car_d_as1_x car_d_as1_y car_d_as1_z cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z cartel_heading
					IF NOT IS_POINT_ON_SCREEN cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z 3.0
						SET_CAR_COORDINATES cartel_car_d_as1 cartel_car_d_as1_x cartel_car_d_as1_y cartel_car_d_as1_z
						SET_CAR_HEADING	cartel_car_d_as1 cartel_heading
						SET_JAMES_CAR_ON_PATH_TO_PLAYER cartel_car_d_as1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		flag_particle = 0
	ENDIF

RETURN

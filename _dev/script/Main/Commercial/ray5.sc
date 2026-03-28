MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Ray mission 5******************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ray5
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ray5_failed
ENDIF
GOSUB mission_cleanup_ray5
MISSION_END
 
// Variables for mission

VAR_INT ambulance_rc5 ambulance_health flag_redalert

VAR_INT injured_cop_rc5 cop_driver bodycast_health
VAR_INT swat1_rc5 swat2_rc5 swat3_rc5 swat4_rc5
VAR_INT swatvan1 swatvan2
VAR_INT blip_ambulance_rc5 flag_bodycast_clear flag_police_trigger

VAR_INT blip_injured_cop_rc5 zed_value random_ray5 flag_random_ray5

VAR_FLOAT amb_rc5_x amb_rc5_y amb_rc5_z
VAR_FLOAT ic_x ic_y ic_z

// ****************************************Mission Start************************************

mission_start_ray5:
REGISTER_MISSION_GIVEN
SCRIPT_NAME ray5 
flag_player_on_mission = 1
flag_player_on_ray_mission = 1

rays_cutscene_flag = 1

WAIT 0

//PRINT_BIG ( RM5 ) 15000 2


flag_bodycast_clear = 0
flag_redalert = 0
flag_random_ray5 = 0
flag_police_trigger = 0

flag_audio = 0

ambulance_health = 0


// ****************************************START OF CUTSCENE********************************
//SET_PLAYER_CONTROL player OFF
//SWITCH_WIDESCREEN ON

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_ray5_failed
ENDIF
 
SET_FADING_COLOUR 0 0 0
 
DO_FADE 250 FADE_OUT
 
PRINT_BIG RM5 15000 2 //"Plaster Blaster"

SWITCH_STREAMING OFF
*/
 
LOAD_SPECIAL_CHARACTER 1 ray
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 RAYH
REQUEST_MODEL toilet

/*
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
*/

LOAD_ALL_MODELS_NOW
 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED toilet
 WAIT 0
ENDWHILE

//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 47.322 -732.055 22.846 4.0 toilet_cubicle_dr2 FALSE
 
LOAD_CUTSCENE r5_pb

SWITCH_STREAMING ON
 
SET_CUTSCENE_OFFSET 39.424 -726.677 21.692
 
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player
 
CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_ray
SET_CUTSCENE_ANIM cs_ray ray
 
CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player
 
CREATE_CUTSCENE_HEAD cs_ray CUT_OBJ2 cs_rayhead
SET_CUTSCENE_HEAD_ANIM cs_rayhead ray
 
//CREATE_CUTSCENE_OBJECT cut_obj3 cs_ludoor
//SET_CUTSCENE_ANIM cs_ludoor LUDOOR
 
//SET_PLAYER_COORDINATES player 38.7 -725.7 22.0
 
//SET_PLAYER_HEADING player 270.0

CLEAR_AREA 39.0 -723.5 22.0 1.0 TRUE

SET_PLAYER_COORDINATES player 39.0 -723.5 22.0

SET_PLAYER_HEADING player 90.0
 
DO_FADE 1500 FADE_IN
//SET_NEAR_CLIP 0.2

 
START_CUTSCENE
SWITCH_RUBBISH OFF
 
// Displays cutscene text
 
GET_CUTSCENE_TIME cs_time
 
WHILE cs_time < 919
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM5_A 2000 1 //"You useless bastard!"

 
WHILE cs_time < 3082
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM5_A1 4500 1 //"You messed up! My ass is on the line and you can't hurt a god damned fly."
 
WHILE cs_time < 7840
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM5_B 3000 1 //"I paid you good money to kill that witness and he ain't dead!"

WHILE cs_time < 10868
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM5_B1 2000 1 //"And today he's gonna make a Federal Deposition!"
 
WHILE cs_time < 13138
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW RM5_C 4000 1 //"He's being moved any second now from the Carson General Hospital up in Rockford.

WHILE cs_time < 17626
 WAIT 0
 GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW RM5_D 2500 1 //"so go do the job you were paid for!"
 
WHILE cs_time < 24333
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
//SET_NEAR_CLIP 0.9
 
//WHILE GET_FADING_STATUS
// WAIT 0
//ENDWHILE
 
//SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 47.322 -732.055 22.846 4.0 toilet_cubicle_dr2 TRUE
 
UNLOAD_SPECIAL_CHARACTER 1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED toilet

//SET_PLAYER_CONTROL player ON
//SWITCH_WIDESCREEN OFF
SWITCH_STREAMING ON
SWITCH_RUBBISH ON
 
rays_cutscene_flag = 0
// ******************************************END OF CUTSCENE********************************


REQUEST_MODEL CAR_AMBULANCE
REQUEST_MODEL CAR_ENFORCER
REQUEST_MODEL PED_COP
REQUEST_MODEL PED_SWAT
WHILE NOT HAS_MODEL_LOADED  CAR_AMBULANCE
OR NOT HAS_MODEL_LOADED PED_COP
OR NOT HAS_MODEL_LOADED PED_SWAT
OR NOT HAS_MODEL_LOADED CAR_ENFORCER
	WAIT 0
ENDWHILE


// Mission stuff goes here
CREATE_CAR CAR_ENFORCER 417.8 -1064.0 26.4 swatvan1
SET_CAR_HEADING	swatvan1 50.0
CAR_SET_IDLE swatvan1
SWITCH_CAR_SIREN swatvan1 ON

CREATE_CAR CAR_ENFORCER 335.4 -1185.2 26.4 swatvan2
SET_CAR_HEADING	swatvan2 150.0
CAR_SET_IDLE swatvan2
SWITCH_CAR_SIREN swatvan2 ON

CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 414.6 -1060.3 26.2 swat1_rc5
SET_CHAR_HEADING swat1_rc5 0.0
CLEAR_CHAR_THREAT_SEARCH swat1_rc5
SET_CHAR_THREAT_SEARCH swat1_rc5 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR swat1_rc5 WEAPONTYPE_M16 100
SET_CURRENT_CHAR_WEAPON swat1_rc5 WEAPONTYPE_M16
SET_CHAR_STAY_IN_SAME_PLACE swat1_rc5 true
ADD_ARMOUR_TO_CHAR swat1_rc5 100

CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 365.0 -1146.7 23.0 swat2_rc5
SET_CHAR_HEADING swat2_rc5 270.0
CLEAR_CHAR_THREAT_SEARCH swat2_rc5
SET_CHAR_THREAT_SEARCH swat2_rc5 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR swat2_rc5 WEAPONTYPE_M16 100
SET_CURRENT_CHAR_WEAPON swat2_rc5 WEAPONTYPE_M16
SET_CHAR_STAY_IN_SAME_PLACE swat2_rc5 true
ADD_ARMOUR_TO_CHAR swat2_rc5 100

CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 331.5 -1184.1 26.2 swat3_rc5
SET_CHAR_HEADING swat3_rc5 100.0
CLEAR_CHAR_THREAT_SEARCH swat3_rc5
SET_CHAR_THREAT_SEARCH swat3_rc5 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR swat3_rc5 WEAPONTYPE_M16 100
SET_CURRENT_CHAR_WEAPON swat3_rc5 WEAPONTYPE_M16
SET_CHAR_STAY_IN_SAME_PLACE swat3_rc5 true
ADD_ARMOUR_TO_CHAR swat3_rc5 100

CREATE_CHAR PEDTYPE_CIVMALE PED_SWAT 336.0 -1122.0 26.0 swat4_rc5
SET_CHAR_HEADING swat4_rc5 230.0
CLEAR_CHAR_THREAT_SEARCH swat4_rc5
SET_CHAR_THREAT_SEARCH swat4_rc5 THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR swat4_rc5 WEAPONTYPE_M16 100
SET_CURRENT_CHAR_WEAPON swat4_rc5 WEAPONTYPE_M16
SET_CHAR_STAY_IN_SAME_PLACE swat4_rc5 true
ADD_ARMOUR_TO_CHAR swat4_rc5 100

LOAD_MISSION_AUDIO R5_A

amb_generator:

ambulance_health = 0
DISPLAY_ONSCREEN_COUNTER_WITH_STRING ambulance_health COUNTER_DISPLAY_BAR DAM

CREATE_CAR CAR_AMBULANCE 387.3 4.5 11.4 ambulance_rc5
ADD_BLIP_FOR_CAR ambulance_rc5 blip_ambulance_rc5
CREATE_CHAR_INSIDE_CAR ambulance_rc5 PEDTYPE_COP PED_COP cop_driver
LOCK_CAR_DOORS ambulance_rc5 CARLOCK_LOCKED
SET_CAR_HEADING ambulance_rc5 166.0
SET_CAR_CRUISE_SPEED ambulance_rc5 20.0
SET_CAR_DRIVING_STYLE ambulance_rc5 0
SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 true
//SWITCH_CAR_SIREN ambulance_rc5 ON
GET_CAR_HEALTH ambulance_rc5 ambulance_health
GENERATE_RANDOM_INT random_ray5

IF random_ray5 < 21846
	CAR_GOTO_COORDINATES ambulance_rc5 -148.93 18.04 26.5
ENDIF

IF random_ray5 > 21845
AND random_ray5 < 43691
	CAR_GOTO_COORDINATES ambulance_rc5 402.88 -404.88 26.5
	flag_random_ray5 = 1
ENDIF

IF random_ray5 > 43690
	CAR_GOTO_COORDINATES ambulance_rc5 -13.2 -804.7 26.5
	flag_random_ray5 = 2
ENDIF


//-----ambulance travels to one of three way points


WHILE flag_redalert = 0
	WAIT 0
	IF NOT IS_CAR_DEAD ambulance_rc5
		GET_CAR_COORDINATES ambulance_rc5 amb_rc5_x amb_rc5_y amb_rc5_z
		GET_CAR_HEALTH ambulance_rc5 ambulance_health
		ambulance_health = ambulance_health * -1
		ambulance_health = ambulance_health + 1000
		//ambulance_health = ambulance_health / 10
		//ambulance_health = ambulance_health * 5

		IF flag_random_ray5 = 0
			IF LOCATE_CAR_2D ambulance_rc5 -148.93 18.04 15.0 15.0 false
				CAR_GOTO_COORDINATES ambulance_rc5 405.2 -1137.7 26.0 //---amb goto penultimate waypoint
				flag_random_ray5 = 3
			ENDIF
		ENDIF
		
		IF flag_random_ray5 = 1
			IF LOCATE_CAR_2D ambulance_rc5 402.88 -404.88 15.0 15.0 false
				CAR_GOTO_COORDINATES ambulance_rc5 405.2 -1137.7 26.0 //---amb goto penultimate waypoint
				flag_random_ray5 = 3
			ENDIF
		ENDIF
		
		IF flag_random_ray5 = 2
			IF LOCATE_CAR_2D ambulance_rc5 -13.2 -804.7 15.0 15.0 false
				CAR_GOTO_COORDINATES ambulance_rc5 405.2 -1137.7 26.0 //---amb goto penultimate waypoint
				flag_random_ray5 = 3
			ENDIF
		ENDIF
		
		IF flag_random_ray5 = 3
			IF LOCATE_CAR_2D ambulance_rc5 405.2 -1137.7 15.0 15.0 false
				flag_redalert = 1
				CAR_GOTO_COORDINATES ambulance_rc5 362.0 -1138.0 23.0 //----amb goto final destination
				SET_CAR_CRUISE_SPEED ambulance_rc5 15.0
				SET_CAR_DRIVING_STYLE ambulance_rc5 0
			ENDIF
		ENDIF

		IF IS_CAR_ON_SCREEN ambulance_rc5
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 false
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 true
		ENDIF
	
	ELSE
		PRINT_NOW (RM5_3) 2500 1 //---ambulance was decoy!!
		MARK_CAR_AS_NO_LONGER_NEEDED ambulance_rc5
		MARK_CHAR_AS_NO_LONGER_NEEDED cop_driver
		REMOVE_BLIP blip_ambulance_rc5
		CLEAR_ONSCREEN_COUNTER ambulance_health
		flag_random_ray5 = 0
		flag_police_trigger = 0
		GOTO amb_generator
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player amb_rc5_x amb_rc5_y 25.0 25.0 false //---player taken the bait ---police close in
		IF NOT IS_CAR_DEAD ambulance_rc5
			PRINT_NOW (RM5_2) 3000 1
			SET_CAR_CRUISE_SPEED ambulance_rc5 28.0
			SET_CAR_DRIVING_STYLE ambulance_rc5 3
			CAR_GOTO_COORDINATES ambulance_rc5 405.2 -1137.7 26.0
			PLAY_MISSION_AUDIO
			SWITCH_CAR_SIREN ambulance_rc5 ON
			ALTER_WANTED_LEVEL_NO_DROP player 2 
			flag_redalert = 1
			flag_police_trigger = 1
		ENDIF
	ENDIF
	
	GOSUB swat_team

ENDWHILE

//------either; player has 'been spotted'-police despatched
//------OR; ambulance has reached penultimate way point

WHILE flag_redalert = 1
	WAIT 0
	
	IF NOT IS_CAR_DEAD ambulance_rc5
		GET_CAR_HEALTH ambulance_rc5 ambulance_health
		ambulance_health = ambulance_health * -1
		ambulance_health = ambulance_health + 1000
		//ambulance_health = ambulance_health / 10
		//ambulance_health = ambulance_health * 5

		IF NOT IS_CAR_HEALTH_GREATER ambulance_rc5 900 //---ambulance damaged enough to force bailout
		//OR IS_CAR_STUCK_ON_ROOF ambulance_rc5
			GOTO injured_cop_bailout
		ENDIF
		
		IF LOCATE_CAR_2D ambulance_rc5 405.2 -1137.7 15.0 15.0 false
			SET_CAR_CRUISE_SPEED ambulance_rc5 10.0
			flag_redalert = 2
			CAR_GOTO_COORDINATES ambulance_rc5 362.0 -1138.0 23.0 //----amb goto final destination
			SET_CAR_CRUISE_SPEED ambulance_rc5 15.0
			SET_CAR_DRIVING_STYLE ambulance_rc5 0
		ENDIF
		
		IF IS_CAR_ON_SCREEN ambulance_rc5
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 false
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 true
		ENDIF
	
	ELSE
		PRINT_NOW (RM5_3) 2500 1 //---ambulance was decoy!!
		MARK_CAR_AS_NO_LONGER_NEEDED ambulance_rc5
		MARK_CHAR_AS_NO_LONGER_NEEDED cop_driver
		REMOVE_BLIP blip_ambulance_rc5
		CLEAR_ONSCREEN_COUNTER ambulance_health
		flag_random_ray5 = 0
		flag_police_trigger = 0
		GOTO amb_generator
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player amb_rc5_x amb_rc5_y 25.0 25.0 false //---player taken the bait ---police close in
	AND flag_police_trigger = 0
		IF NOT IS_CAR_DEAD ambulance_rc5
			PRINT_NOW (RM5_2) 3000 1
			SET_CAR_CRUISE_SPEED ambulance_rc5 28.0
			SET_CAR_DRIVING_STYLE ambulance_rc5 3
			CAR_GOTO_COORDINATES ambulance_rc5 405.2 -1137.7 26.0
			PLAY_MISSION_AUDIO
			SWITCH_CAR_SIREN ambulance_rc5 ON
			ALTER_WANTED_LEVEL_NO_DROP player 2 
			flag_redalert = 1
			flag_police_trigger = 1
		ENDIF
	ENDIF

	GOSUB swat_team

ENDWHILE


//----ambulance has reached penultimate waypoint

WHILE flag_redalert = 2
	WAIT 0
	IF NOT IS_CAR_DEAD ambulance_rc5
		GET_CAR_HEALTH ambulance_rc5 ambulance_health
		ambulance_health = ambulance_health * -1
		ambulance_health = ambulance_health + 1000
		//ambulance_health = ambulance_health / 10
		//ambulance_health = ambulance_health * 5

		IF LOCATE_CAR_2D ambulance_rc5 362.0 -1138.0 5.0 5.0 true 
			flag_redalert = 3
			SET_CAR_CRUISE_SPEED ambulance_rc5 0.0
			SET_CAR_DRIVING_STYLE ambulance_rc5 0
			SWITCH_CAR_SIREN ambulance_rc5 OFF
			CAR_SET_IDLE ambulance_rc5 //---ambulance has reached destination without bailout -mission failed
		ENDIF
		
		IF NOT IS_CAR_HEALTH_GREATER ambulance_rc5 900
		//OR IS_CAR_STUCK_ON_ROOF ambulance_rc5
			GOTO injured_cop_bailout
		ENDIF
		
		IF IS_CAR_ON_SCREEN ambulance_rc5
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 false
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER ambulance_rc5 true
		ENDIF

	ELSE
		PRINT_NOW (RM5_3) 2500 1 //---ambulance was decoy!!
		MARK_CAR_AS_NO_LONGER_NEEDED ambulance_rc5
		MARK_CHAR_AS_NO_LONGER_NEEDED cop_driver
		REMOVE_BLIP blip_ambulance_rc5
		CLEAR_ONSCREEN_COUNTER ambulance_health
		flag_random_ray5 = 0
		flag_redalert = 0
		GOTO amb_generator
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_2D player amb_rc5_x amb_rc5_y 25.0 25.0 false //---player taken the bait ---police close in
	AND flag_police_trigger = 0
		PRINT_NOW (RM5_2) 3000 1
		ALTER_WANTED_LEVEL_NO_DROP player 2 
		flag_police_trigger = 1
	ENDIF
	
	GOSUB swat_team

ENDWHILE


GOTO mission_ray5_failed


injured_cop_bailout:
REMOVE_BLIP blip_ambulance_rc5
GET_CAR_COORDINATES ambulance_rc5 amb_rc5_x amb_rc5_y amb_rc5_z
amb_rc5_z = amb_rc5_z + 2.5
CREATE_OBJECT bodycast amb_rc5_x amb_rc5_y amb_rc5_z injured_cop_rc5
SET_OBJECT_COLLISION injured_cop_rc5 TRUE
SET_OBJECT_DYNAMIC injured_cop_rc5 true
MAKE_OBJECT_TARGETTABLE injured_cop_rc5
ADD_TO_OBJECT_VELOCITY injured_cop_rc5 0.0 0.0 5.0
ADD_BLIP_FOR_OBJECT injured_cop_rc5 blip_injured_cop_rc5
ALTER_WANTED_LEVEL_NO_DROP player 3
CLEAR_ONSCREEN_COUNTER ambulance_health

 
/*
WHILE flag_bodycast_clear = 0
	WAIT 0
	GET_OBJECT_COORDINATES injured_cop_rc5 ic_x ic_y ic_z
	IF NOT IS_CAR_DEAD ambulance_rc5
		IF NOT LOCATE_CAR_3D  ambulance_rc5 ic_x ic_y ic_z 5.0 5.0 5.0 false
			SET_OBJECT_COLLISION injured_cop_rc5 TRUE
			flag_bodycast_clear = 1
		ENDIF
	ELSE
		SET_OBJECT_COLLISION injured_cop_rc5 TRUE
		flag_bodycast_clear = 1		
	ENDIF
ENDWHILE
*/
DISPLAY_ONSCREEN_COUNTER_WITH_STRING bodycast_health COUNTER_DISPLAY_BAR DAM
			
PRINT_NOW (RM5_6) 3000 1


WHILE NOT HAS_OBJECT_BEEN_DAMAGED injured_cop_rc5

	WAIT 0

	GET_OBJECT_COORDINATES injured_cop_rc5 ic_x ic_y ic_z
	SET_MISSION_AUDIO_POSITION ic_x ic_y ic_z
	GET_BODY_CAST_HEALTH bodycast_health
	bodycast_health = bodycast_health * -1
	bodycast_health = bodycast_health + 1000
	bodycast_health = bodycast_health / 10
	
	
	IF flag_audio = 0
		PLAY_MISSION_AUDIO
	ENDIF
	
	IF HAS_MISSION_AUDIO_FINISHED
		flag_audio = 1
	ENDIF

	//zed_value =# ic_z
	//PRINT_WITH_NUMBER_NOW ( Z ) zed_value 1000 1

	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_PISTOL
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_4) 500 1//bullets won't get through that armoured plaster!!
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_UZI
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_4) 500 1
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_SHOTGUN
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_4) 500 1
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_M16
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_4) 500 1
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_CHAINGUN
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_4) 500 1
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_FLAMETHROWER
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_5) 500 1//That Plaster's flame retardent!!
	ENDIF
	IF IS_CURRENT_PLAYER_WEAPON player WEAPONTYPE_MOLOTOV
	AND NOT IS_PLAYER_IN_ANY_CAR player
		PRINT (RM5_5) 500 1
	ENDIF
	IF ic_z < 1.0
		PRINT_NOW (RM5_8) 3000 1//witness has drowned!!
		GOTO quentin
	ENDIF 

	GOSUB swat_team

ENDWHILE

quentin:

REMOVE_BLIP blip_injured_cop_rc5

GOTO mission_ray5_passed
	   		



// Mission Ray5 failed

mission_ray5_failed:

PRINT_NOW RM5_7 3000 1 //Witness has been delivered!!

PRINT_BIG ( M_FAIL ) 2000 1

RETURN

   

// mission Ray5 passed

mission_ray5_passed:

flag_ray_mission5_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player
ADD_SCORE player 10000
REGISTER_MISSION_PASSED RM5
PLAYER_MADE_PROGRESS 1 

IF NOT flag_love_mission3_passed = 1
    REMOVE_BLIP ray_contact_blip
ELSE
	START_NEW_SCRIPT ray_mission6_loop
ENDIF

RETURN
		


// mission cleanup

mission_cleanup_ray5:
CLEAR_ONSCREEN_COUNTER ambulance_health
CLEAR_ONSCREEN_COUNTER bodycast_health

flag_player_on_mission = 0
flag_player_on_ray_mission = 0

MARK_OBJECT_AS_NO_LONGER_NEEDED injured_cop_rc5

MARK_CHAR_AS_NO_LONGER_NEEDED swat1_rc5
MARK_CHAR_AS_NO_LONGER_NEEDED swat2_rc5
MARK_CHAR_AS_NO_LONGER_NEEDED swat3_rc5
MARK_CHAR_AS_NO_LONGER_NEEDED swat4_rc5
MARK_CHAR_AS_NO_LONGER_NEEDED cop_driver

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_AMBULANCE
MARK_MODEL_AS_NO_LONGER_NEEDED PED_SWAT
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_ENFORCER
REMOVE_BLIP blip_ambulance_rc5

MISSION_HAS_FINISHED
RETURN
		

//------GOSUBS------------------------------

swat_team:

	IF IS_PLAYER_IN_AREA_3D player 366.0 -1146.0 21.0 396.0 -1134.0 28.0 false
		IF NOT IS_CHAR_DEAD swat1_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat1_rc5 player
		ENDIF
		IF NOT IS_CHAR_DEAD swat2_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat2_rc5 player
		ENDIF
	ENDIF
	IF IS_PLAYER_IN_AREA_3D player 318.0 -1170.0 22.0 366.0 -1120.0 25.0 false
		IF NOT IS_CHAR_DEAD swat1_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat1_rc5 player
		ENDIF
		IF NOT IS_CHAR_DEAD swat2_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat2_rc5 player
		ENDIF
		IF NOT IS_CHAR_DEAD swat3_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat3_rc5 player
		ENDIF
		IF NOT IS_CHAR_DEAD swat4_rc5
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS swat4_rc5 player
		ENDIF
	ENDIF

RETURN

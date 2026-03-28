MISSION_START

VAR_INT tramp1 tramp2 tramp3 tramp4 tramp_is_dead tramps_been_created
VAR_INT	tramp1_dead tramp2_dead tramp3_dead tramp4_dead
VAR_INT has_player_been_in_tramp_tunnel_before 
VAR_INT flag_sounds_added_redlight
VAR_INT	camera_ammu1 camera_ammu2 ammu_sample 
VAR_INT has_player_been_at_fish_before
VAR_INT flag_need_wall_change_km1 ammu_bloke_kill_player
VAR_INT flag_failed_love1 special_ammu_audio 
VAR_INT need_to_clear_area_flag	// VARIABLE FOR PARKED CARS GENERATOR FOR THE MULTISTORY CARPARK IN NEWPORT
VAR_INT fish_triad1 fish_triad2 fish_triad3 fish_triad4 fish_triad5 fish_triad6
VAR_INT flag_sounds_added_dog // Sound effects for the dog food factory
VAR_INT second_floor_cars_exist third_floor_cars_exist fourth_floor_cars_exist fifth_floor_cars_exist

second_floor_cars_exist	= 0
third_floor_cars_exist	= 0
fourth_floor_cars_exist	= 0
fifth_floor_cars_exist	= 0

need_to_clear_area_flag = 0	// VARIABLE FOR PARKED CARS GENERATOR FOR THE MULTISTORY CARPARK IN NEWPORT
has_player_been_at_fish_before = 0 
has_player_been_in_tramp_tunnel_before = 0
flag_sounds_added_redlight = 0
tramps_been_created = 0
tramp_is_dead = 0
camera_ammu1 = 0
camera_ammu2 = 0
flag_sounds_added_dog = 0 // Sound effects for the dog food factory	

//loaded_all_industrial_models_before = 0
//loaded_all_commercial_models_before = 0
//loaded_all_suburban_models_before = 0
flag_failed_love1 = 0
flag_need_wall_change_km1 = 0
flag_player_on_phil_mission = 0
tramp1 = -1
tramp2 = -1
tramp3 = -1
tramp4 = -1
tramp1_dead = 0
tramp2_dead	= 0
tramp4_dead	= 0
tramp3_dead	= 0
ammu_sample = 0
special_ammu_audio = 0
ammu_bloke_kill_player = 0

SCRIPT_NAME	genstuf

SET_DEATHARREST_STATE OFF


mission_start_genstuf:

{
	START_NEW_SCRIPT ind_ammu
	START_NEW_SCRIPT fish_factory_gen
	START_NEW_SCRIPT tramp_tunnel
	START_NEW_SCRIPT ind_sound

	START_NEW_SCRIPT com_ammu
	START_NEW_SCRIPT com_car_park
	START_NEW_SCRIPT dog_sound
	START_NEW_SCRIPT cobblers

	MISSION_END
}

cobblers:
{
WAIT 1000
IF flag_industrial_passed = 1
	REMOVE_PICKUP info_pickup7a
	REMOVE_PICKUP info_pickup8
	REMOVE_PICKUP info_pickup9
	REMOVE_PICKUP info_pickup3
	REMOVE_PICKUP info_pickup4
	REMOVE_PICKUP info_pickup5
	REMOVE_PICKUP info_pickup1
	TERMINATE_THIS_SCRIPT
ENDIF

GOTO cobblers
}

check_info_pickup:
{

LVAR_INT pickup message_num

start_pickup_script:

WHILE NOT HAS_PICKUP_BEEN_COLLECTED pickup
	WAIT 500
ENDWHILE

IF message_num = 1
	PRINT_HELP ( SPRAY )
ENDIF

IF message_num = 2
	PRINT_HELP ( BOMB )
ENDIF

IF message_num = 3
	PRINT_HELP ( AMMU ) 
ENDIF

IF message_num = 4
	PRINT_HELP ( SAVE2 ) 
ENDIF

IF message_num = 5
	PRINT_HELP ( SAVE1 ) 
ENDIF

IF message_num = 6
	PRINT_HELP ( CRUSH )
ENDIF
/*
IF message_num = 7
	PRINT_HELP ( BRIDGE1 )
ENDIF

IF message_num = 8
	PRINT_HELP ( TUNNEL ) 
ENDIF

IF message_num = 9
	PRINT_HELP ( TUBE )
ENDIF

IF message_num = 10
	PRINT_HELP ( A_TRAIN )
ENDIF

WHILE HAS_PICKUP_BEEN_COLLECTED pickup
	WAIT 500
ENDWHILE
*/
GOTO start_pickup_script
}



check_info_pickup_2:
{

LVAR_INT pickup message_num

start_pickup_script_2:

WHILE NOT HAS_PICKUP_BEEN_COLLECTED pickup
	WAIT 500
ENDWHILE

GET_CONTROLLER_MODE controlmode

/*
IF message_num = 1
	PRINT_HELP ( SPRAY )
ENDIF

IF message_num = 2
	PRINT_HELP ( BOMB )
ENDIF

IF message_num = 3
	PRINT_HELP ( AMMU ) 
ENDIF

IF message_num = 4
	PRINT_HELP ( SAVE2 ) 
ENDIF

IF message_num = 5
	PRINT_HELP ( SAVE1 ) 
ENDIF

IF message_num = 6
	PRINT_HELP ( CRUSH )
ENDIF
*/
IF message_num = 7
	PRINT_HELP ( BRIDGE1 )
ENDIF

IF message_num = 8
	PRINT_HELP ( TUNNEL ) 
ENDIF

IF message_num = 9
	PRINT_HELP ( TUBE1 )
ENDIF

IF message_num = 10
	IF controlmode = 0
	OR controlmode = 1
	OR controlmode = 3
		PRINT_HELP ( L_TRN_1 ) //"Press the~h~ \ button~w~ to ~h~enter ~w~or ~h~exit~w~ a vehicle." 
	ENDIF

	IF controlmode = 2
		PRINT_HELP ( L_TRN_2 ) //"Press the~h~ L1 button~w~ to ~h~enter ~w~or ~h~exit~w~ a vehicle."
	ENDIF
	
ENDIF

IF message_num = 11
	IF controlmode = 0
	OR controlmode = 1
	OR controlmode = 3
		PRINT_HELP ( S_TRN_1 ) //"Press the~h~ \ button~w~ to ~h~enter ~w~or ~h~exit~w~ a vehicle." 
	ENDIF

	IF controlmode = 2
		PRINT_HELP ( S_TRN_2 ) //"Press the~h~ L1 button~w~ to ~h~enter ~w~or ~h~exit~w~ a vehicle."
	ENDIF
ENDIF

/*
WHILE HAS_PICKUP_BEEN_COLLECTED pickup
	WAIT 500
ENDWHILE
*/
GOTO start_pickup_script_2
}

ind_ammu:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME I_AMMU

ind_ammu_inner:
	
	WAIT 70

	IF IS_PLAYER_PLAYING Player

		IF IS_PLAYER_IN_ZONE player LITTLEI

			IF IS_PLAYER_IN_AREA_3D player 1066.6 -403.5 14.0 1072.8 -394.0 18.0 FALSE

				IF camera_ammu1 = 0
					SET_PLAYER_CONTROL Player Off
					SET_FADING_COLOUR 1 1 1
					SWITCH_STREAMING OFF
					LOAD_SPECIAL_CHARACTER 4 sam
					SET_MUSIC_DOES_FADE FALSE
					DO_FADE 500 FADE_OUT
					WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
						WAIT 0
					ENDWHILE
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					SWITCH_STREAMING ON
					GET_GAME_TIMER current_time
					time_difference = current_time - time_since_murdering_shopkeeper1

					IF time_difference > 60000 
						CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL4 1070.81 -396.97 14.2 ammu_shop_bloke1
						SET_CHAR_PERSONALITY ammu_shop_bloke1 PEDSTAT_TOUGH_GUY 
						SET_CHAR_HEADING ammu_shop_bloke1 170.0
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_SHOTGUN 999
						IF IS_PLAYER_PLAYING player
							CHAR_LOOK_AT_PLAYER_ALWAYS ammu_shop_bloke1 Player
						ENDIF
					ENDIF

					UNLOAD_SPECIAL_CHARACTER 4
					SET_FIXED_CAMERA_POSITION 1071.95 -402.8 17.0 0.0 0.0 0.0
					ENABLE_PLAYER_CONTROL_CAMERA
					IF IS_PLAYER_PLAYING player
						POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
						CLEAR_AREA 1067.9 -397.3 14.2 1.0 TRUE
			 		   	SET_PLAYER_COORDINATES player 1067.9 -397.3 14.2
						SET_PLAYER_HEADING player 200.0
					ENDIF
					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_PLAYER_PLAYING player
						SET_PLAYER_CONTROL Player on
					ENDIF

					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						IF special_ammu_audio = 0 
							IF ammu_sample = 0
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_1
							ENDIF
							IF ammu_sample = 1
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_2
							ENDIF
							IF ammu_sample = 2
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_3
							ENDIF
						ENDIF
					ENDIF

					camera_ammu1 = 1
				ELSE	//	camera_ammu1 = 1

					IF IS_PLAYER_SHOOTING player
						IF NOT IS_CHAR_DEAD ammu_shop_bloke1
							IF ammu_bloke_kill_player = 0
								IF IS_PLAYER_PLAYING player
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
								ENDIF
								ammu_bloke_kill_player = 1
							ENDIF
						ENDIF
					ENDIF

				ENDIF
			ELSE	//	player not in area (1066.6 -403.5 14.0 1072.8 -394.0 18.0)
				IF camera_ammu1 = 1
					SET_PLAYER_CONTROL Player Off
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_CHAR_DEAD	ammu_shop_bloke1
					AND	time_difference > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
						GET_GAME_TIMER time_since_murdering_shopkeeper1 
					ENDIF
					DELETE_CHAR	ammu_shop_bloke1
					CLEAR_AREA 1063.3 -395.3 14.2 1.0 TRUE
					IF IS_PLAYER_PLAYING player
		 		   		SET_PLAYER_COORDINATES player 1063.3 -395.3 14.2
						SET_PLAYER_HEADING player 90.0
						RESTORE_CAMERA_JUMPCUT
						SET_CAMERA_IN_FRONT_OF_PLAYER
					ENDIF
					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					SET_MUSIC_DOES_FADE TRUE
					IF IS_PLAYER_PLAYING player
						SET_PLAYER_CONTROL Player on
					ENDIF
					
					ammu_sample ++

					IF ammu_sample > 2
						ammu_sample = 0
					ENDIF
					
					ammu_bloke_kill_player = 0	
					camera_ammu1 = 0
				ENDIF

			ENDIF //IS_PLAYER_IN_AREA_3D
		ELSE	//	not in LITTLEI

			IF camera_ammu1 = 1
				IF IS_CHAR_DEAD	ammu_shop_bloke1
				AND	time_difference > 60000 //time_difference is greater than 30,000 means shopkeeper has been created
					GET_GAME_TIMER time_since_murdering_shopkeeper1 
				ENDIF
				RESTORE_CAMERA_JUMPCUT
				SET_CAMERA_IN_FRONT_OF_PLAYER
				DELETE_CHAR	ammu_shop_bloke1
				SET_MUSIC_DOES_FADE TRUE
				camera_ammu1 = 0
			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player LITTLEI

	ENDIF //IS_PLAYER_PLAYING

	GOTO ind_ammu_inner
}


fish_factory_gen:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME FISHGEN

fish_factory_gen_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

//FISH FACTORY SET UP
		IF fish_factory_destroyed = 0

			IF IS_PLAYER_IN_ZONE Player PORT_W

			//CREATES A GANG OF TRIADS DOWN AT THE FISH FACTORY
			
				IF has_player_been_at_fish_before = 0
					REQUEST_MODEL PED_GANG_TRIAD_A
					REQUEST_MODEL PED_GANG_TRIAD_B
						WHILE NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
						OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_B
							WAIT 0
						ENDWHILE
					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 997.0 -1112.0 -100.0 fish_triad1
					GIVE_WEAPON_TO_CHAR fish_triad1 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad1 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad1 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 964.0 -1095.0 -100.0 fish_triad2
					GIVE_WEAPON_TO_CHAR fish_triad2 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad2 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad2 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 982.0 -1085.0 -100.0 fish_triad3
					GIVE_WEAPON_TO_CHAR fish_triad3 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad3 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad3 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 953.0 -1122.0 -100.0 fish_triad4
					GIVE_WEAPON_TO_CHAR fish_triad4 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad4 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad4 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 1008.0 -1126.0 -100.0 fish_triad5
					GIVE_WEAPON_TO_CHAR fish_triad5 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad5 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad5 THREAT_PLAYER1

					CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 974.0 -1142.0 -100.0 fish_triad6
					GIVE_WEAPON_TO_CHAR fish_triad6 WEAPONTYPE_PISTOL 100
					//SET_CHAR_THREAT_SEARCH fish_triad6 THREAT_GANG_MAFIA
					SET_CHAR_THREAT_SEARCH fish_triad6 THREAT_PLAYER1

					CHAR_WANDER_DIR fish_triad1 0
					CHAR_WANDER_DIR fish_triad2 0
					CHAR_WANDER_DIR fish_triad3 0
					CHAR_WANDER_DIR fish_triad4 0
					CHAR_WANDER_DIR fish_triad5 0
					CHAR_WANDER_DIR fish_triad6 0
					has_player_been_at_fish_before = 1
				ENDIF

			ELSE	//	Player not in PORT_W

				IF has_player_been_at_fish_before = 1
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad1
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad2
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad3
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad4
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad5
					MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad6

					IF flag_player_on_mission = 0
						MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
						MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
						has_player_been_at_fish_before = 0
					ENDIF
				ENDIF

			ENDIF //IS PLAYER IN ZONE

		ELSE

			IF has_player_been_at_fish_before = 1
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad1
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad2
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad3
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad4
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad5
				MARK_CHAR_AS_NO_LONGER_NEEDED fish_triad6

				IF flag_player_on_mission = 0
					MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
					MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
					has_player_been_at_fish_before = 0
				ENDIF
			ENDIF

		ENDIF  //fish_factory_destroyed

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF //IS_PLAYER_PLAYING

	GOTO fish_factory_gen_inner
}


tramp_tunnel:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME TRAMPS

tramp_tunnel_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player
		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

//CREATES TRAMPS IN ABANDONED TUNNEL
		IF IS_PLAYER_IN_ZONE Player LITTLEI

			IF IS_PLAYER_IN_AREA_3D Player 1325.0 -512.0 14.0 1315.0 -165.8 17.0 FALSE	
				IF has_player_been_in_tramp_tunnel_before = 0

					REQUEST_MODEL PED_SCUM_MAN
					REQUEST_MODEL PED_SCUM_WOMAN

					WHILE NOT HAS_MODEL_LOADED PED_SCUM_MAN
					OR NOT HAS_MODEL_LOADED PED_SCUM_WOMAN
						WAIT 0
					ENDWHILE

					CREATE_CHAR PEDTYPE_BUM PED_SCUM_MAN 1320.4 -370.0 15.0 tramp1
					GIVE_WEAPON_TO_CHAR tramp1 WEAPONTYPE_MOLOTOV 1
					SET_CHAR_PERSONALITY tramp1 PEDSTAT_GEEK_GUY
					SET_CHAR_THREAT_SEARCH tramp1 THREAT_GUN
					SET_CHAR_THREAT_SEARCH tramp1 THREAT_DEADPEDS

					CREATE_CHAR PEDTYPE_BUM PED_SCUM_WOMAN 1317.0 -365.0 15.0 tramp2
					GIVE_WEAPON_TO_CHAR tramp2 WEAPONTYPE_MOLOTOV 1
					SET_CHAR_HEADING tramp2 290.0
					SET_CHAR_PERSONALITY tramp2 PEDSTAT_GEEK_GUY
					SET_CHAR_THREAT_SEARCH tramp2 THREAT_GUN
					SET_CHAR_THREAT_SEARCH tramp2 THREAT_DEADPEDS

					CREATE_CHAR PEDTYPE_BUM PED_SCUM_WOMAN 1322.4 -367.0 15.0 tramp3
					GIVE_WEAPON_TO_CHAR tramp3 WEAPONTYPE_MOLOTOV 1
					SET_CHAR_HEADING tramp3 57.0
					SET_CHAR_PERSONALITY tramp3 PEDSTAT_GEEK_GUY
					SET_CHAR_THREAT_SEARCH tramp3 THREAT_GUN
					SET_CHAR_THREAT_SEARCH tramp3 THREAT_DEADPEDS

					CREATE_CHAR PEDTYPE_BUM PED_SCUM_MAN 1320.0 -362.0 15.0 tramp4
					GIVE_WEAPON_TO_CHAR tramp4 WEAPONTYPE_MOLOTOV 1
					SET_CHAR_HEADING tramp4 180.0
					SET_CHAR_PERSONALITY tramp4 PEDSTAT_GEEK_GUY
					SET_CHAR_THREAT_SEARCH tramp4 THREAT_GUN
					SET_CHAR_THREAT_SEARCH tramp4 THREAT_DEADPEDS

					MARK_MODEL_AS_NO_LONGER_NEEDED PED_SCUM_MAN
					MARK_MODEL_AS_NO_LONGER_NEEDED PED_SCUM_WOMAN
					
					tramps_been_created = 1
					has_player_been_in_tramp_tunnel_before = 1
				ELSE
					IF tramps_been_created = 1
						IF tramp_is_dead = 0
							IF IS_CHAR_DEAD	tramp1
							OR IS_CHAR_DEAD	tramp2
							OR IS_CHAR_DEAD	tramp3
							OR IS_CHAR_DEAD	tramp4
								timerA = 0
								tramp_is_dead = 1
							ENDIF
						ENDIF
					ENDIF

				ENDIF
			ELSE
				IF has_player_been_in_tramp_tunnel_before = 1
					IF tramps_been_created = 1	
						MARK_CHAR_AS_NO_LONGER_NEEDED tramp1
						MARK_CHAR_AS_NO_LONGER_NEEDED tramp2
						MARK_CHAR_AS_NO_LONGER_NEEDED tramp3
						MARK_CHAR_AS_NO_LONGER_NEEDED tramp4
						tramps_been_created = 0
					ENDIF

					IF tramp_is_dead = 1
						IF timerA > 1440000
							tramp_is_dead = 0
							has_player_been_in_tramp_tunnel_before = 0
						ENDIF
					ELSE
						has_player_been_in_tramp_tunnel_before = 0
					ENDIF
				ENDIF
			ENDIF	//	IF IS_PLAYER_IN_AREA_3D Player 1325.0 -512.0 14.0 1315.0 -165.8 17.0 FALSE

		ELSE	//	IF IS_PLAYER_IN_ZONE Player LITTLEI
			IF has_player_been_in_tramp_tunnel_before = 1
				IF tramps_been_created = 1	
					MARK_CHAR_AS_NO_LONGER_NEEDED tramp1
					MARK_CHAR_AS_NO_LONGER_NEEDED tramp2
					MARK_CHAR_AS_NO_LONGER_NEEDED tramp3
					MARK_CHAR_AS_NO_LONGER_NEEDED tramp4
					tramps_been_created = 0
				ENDIF

				IF tramp_is_dead = 1
					IF timerA > 1440000
						tramp_is_dead = 0
						has_player_been_in_tramp_tunnel_before = 0
					ENDIF
				ELSE
					has_player_been_in_tramp_tunnel_before = 0
				ENDIF
			ENDIF
		ENDIF

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF //IS_PLAYER_PLAYING

	GOTO tramp_tunnel_inner
}

ind_sound:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME I_SOUND

ind_sound_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
//TIME OF DAY SOUND EFFECTS	(REDLIGHT)

		IF IS_PLAYER_IN_ZONE Player REDLIGH
			GET_TIME_OF_DAY hours minutes

			IF hours >= 20
			OR hours <= 5
				IF flag_sounds_added_redlight = 0
					ADD_CONTINUOUS_SOUND 891.9 -416.9 16.1 SOUND_STRIP_CLUB_LOOP_2_S sound_loop8 //Luigi's club
					ADD_CONTINUOUS_SOUND 924.2 -464.3 16.0 SOUND_STRIP_CLUB_LOOP_1_S sound_loop9 //Sex Kitten Club
					ADD_CONTINUOUS_SOUND 901.1 -392.0 15.0 SOUND_PORN_CINEMA_1_S sound_loop10 //XXX Cinema1
					ADD_CONTINUOUS_SOUND 901.2 -339.0 10.0 SOUND_PORN_CINEMA_2_S sound_loop11 //XXX Cinema2
					ADD_CONTINUOUS_SOUND 960.1 -379.0 15.0 SOUND_PORN_CINEMA_3_S sound_loop12 //XXX Cinema
					flag_sounds_added_redlight = 1
			    ENDIF
		  	ELSE
			  	IF flag_sounds_added_redlight = 1
		  	  		REMOVE_SOUND sound_loop8
			  		REMOVE_SOUND sound_loop9
			  		REMOVE_SOUND sound_loop10
					REMOVE_SOUND sound_loop11
					REMOVE_SOUND sound_loop12
					flag_sounds_added_redlight = 0
				ENDIF
			ENDIF
		ENDIF	//	IF IS_PLAYER_IN_ZONE Player REDLIGH

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO ind_sound_inner
}


dog_sound:  // Sound effects for the dog food factory
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME D_SOUND

dog_sound_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING player

		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
			
		IF IS_PLAYER_IN_ZONE player PORT_I
			GET_TIME_OF_DAY hours minutes

			IF hours >= 9
			AND hours <= 17
				IF flag_sounds_added_dog = 0
					//Portland Industrial
					ADD_CONTINUOUS_SOUND 1210.9 -802.2 15.0 SOUND_SAWMILL_LOOP_L sound_loop7 //Dog food factory
					flag_sounds_added_dog = 1
			    ENDIF
		  	ELSE
			  	IF flag_sounds_added_dog = 1
		  	  		REMOVE_SOUND sound_loop7
			  		flag_sounds_added_dog = 0
				ENDIF
			ENDIF
		ENDIF	//	IF IS_PLAYER_IN_ZONE Player REDLIGH

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO dog_sound_inner
}

com_ammu:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME C_AMMU

com_ammu_inner:

	WAIT 70

	IF IS_PLAYER_PLAYING Player

// AMMU NATION COMMERCIAL

		IF IS_PLAYER_IN_ZONE player COM_EAS

			IF IS_PLAYER_IN_AREA_3D player 353.3 -711.7 24.0 339.8 -722.4 28.0 FALSE
				
				IF camera_ammu2 = 0		
					SET_PLAYER_CONTROL Player Off
					SET_FADING_COLOUR 1 1 1
					SWITCH_STREAMING OFF
					LOAD_SPECIAL_CHARACTER 4 sam
					SET_MUSIC_DOES_FADE FALSE
					DO_FADE 500 FADE_OUT
					WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
						WAIT 0
					ENDWHILE
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					SWITCH_STREAMING ON
					GET_GAME_TIMER current_time
					time_difference = current_time - time_since_murdering_shopkeeper1

					IF time_difference > 60000 
						CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL4 350.2 -719.9 25.4 ammu_shop_bloke1
						SET_CHAR_PERSONALITY ammu_shop_bloke1 PEDSTAT_TOUGH_GUY
						SET_CHAR_HEADING ammu_shop_bloke1 70.0
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_SHOTGUN 999
						IF IS_PLAYER_PLAYING player
							CHAR_LOOK_AT_PLAYER_ALWAYS ammu_shop_bloke1 Player
						ENDIF
					ENDIF

					UNLOAD_SPECIAL_CHARACTER 4
					SET_FIXED_CAMERA_POSITION 341.74 -720.676 28.019 0.0 0.0 0.0
					ENABLE_PLAYER_CONTROL_CAMERA
					IF IS_PLAYER_PLAYING player
						POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
						CLEAR_AREA 350.7 -713.1 26.4 1.0 TRUE
		 		   		SET_PLAYER_COORDINATES player 350.7 -713.1 25.4
						SET_PLAYER_HEADING player 108.0
					ENDIF
					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_PLAYER_PLAYING player
						SET_PLAYER_CONTROL Player on
					ENDIF
					
					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						IF special_ammu_audio = 0 
							IF ammu_sample = 0
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_1
							ENDIF
							IF ammu_sample = 1
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_2
							ENDIF
							IF ammu_sample = 2
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_3
							ENDIF
						ENDIF
					ENDIF
					
					camera_ammu2 = 1
				ELSE	//	camera_ammu2 = 1

					IF IS_PLAYER_SHOOTING player
						IF NOT IS_CHAR_DEAD ammu_shop_bloke1
							IF ammu_bloke_kill_player = 0
								IF IS_PLAYER_PLAYING player
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
								ENDIF
								ammu_bloke_kill_player = 1
							ENDIF
						ENDIF
					ENDIF

				ENDIF

			ELSE	//	player not in area (353.3 -711.7 24.0 340.3 -718.0 28.0)

				IF camera_ammu2 = 1
					SET_PLAYER_CONTROL Player Off
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_CHAR_DEAD	ammu_shop_bloke1
					AND	time_difference > 60000 //time_difference is greater than 60,000 means shopkeeper has been created 
						GET_GAME_TIMER time_since_murdering_shopkeeper1 
					ENDIF
					DELETE_CHAR	ammu_shop_bloke1

					CLEAR_AREA 352.0 -708.8 25.4 1.0 TRUE

					IF IS_PLAYER_PLAYING player
		 		   		SET_PLAYER_COORDINATES player 352.0 -708.8 25.4
						SET_PLAYER_HEADING player 0.0
						RESTORE_CAMERA_JUMPCUT
						SET_CAMERA_IN_FRONT_OF_PLAYER
					ENDIF

					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					SET_MUSIC_DOES_FADE TRUE

					IF IS_PLAYER_PLAYING player
						SET_PLAYER_CONTROL Player on
					ENDIF
					
					ammu_sample ++

					IF ammu_sample > 2
						ammu_sample = 0
					ENDIF
					
					ammu_bloke_kill_player = 0
					camera_ammu2 = 0
				ENDIF 
			ENDIF //IS_PLAYER_IN_AREA_3D

		ELSE	//	player not in COM_EAS

			IF camera_ammu2 = 1
				IF IS_CHAR_DEAD	ammu_shop_bloke1
				AND	time_difference > 60000 //time_difference is greater than 30,000 means shopkeeper has been created
					GET_GAME_TIMER time_since_murdering_shopkeeper1 
				ENDIF
				RESTORE_CAMERA_JUMPCUT
				SET_CAMERA_IN_FRONT_OF_PLAYER
				DELETE_CHAR	ammu_shop_bloke1
				SET_MUSIC_DOES_FADE TRUE
				camera_ammu2 = 0
			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player COM_EAS

	ENDIF //IS_PLAYER_PLAYING

	GOTO com_ammu_inner
}




com_car_park:
{
//	Should be called in mission_start_genstuf

	SCRIPT_NAME C_CARP

com_car_park_inner:

	WAIT 250

	IF IS_PLAYER_PLAYING Player

		IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

		// PARKED CARS GENERATOR FOR THE MULTISTORY CARPARK IN NEWPORT
			IF IS_PLAYER_IN_ZONE player COM_EAS

				IF IS_PLAYER_IN_AREA_3D	player 266.83 -610.93 25.0 306.31 -479.92 30.0 0 // 1ST FLOOR LOCATE
					SET_CAR_DENSITY_MULTIPLIER 0.0
					IF second_floor_cars_exist = 0
						GOSUB second_floor_of_cars
						second_floor_cars_exist = 1
					ENDIF
					IF third_floor_cars_exist = 1
						CLEAR_AREA_OF_CARS 266.83 -610.93 30.4 306.31 -479.92 34.84 // 3RD FLOOR CLEAR
						third_floor_cars_exist = 0
					ENDIF
					IF fourth_floor_cars_exist = 1
						CLEAR_AREA_OF_CARS 306.31 -610.93 32.84 346.81 -479.92 40.0 // 4TH FLOOR CLEAR
						fourth_floor_cars_exist = 0
					ENDIF
					IF fifth_floor_cars_exist = 1
						CLEAR_AREA_OF_CARS 266.83 -610.93 35.23 306.31 -479.92 40.0	// 5TH FLOOR CLEAR
						fifth_floor_cars_exist = 0
					ENDIF
					need_to_clear_area_flag = 1 
				ENDIF

				IF need_to_clear_area_flag > 0
					IF IS_PLAYER_IN_AREA_3D player 306.31 -610.93 28.0 346.81 -479.92 32.42 0 // 2ND FLOOR LOCATE
						IF second_floor_cars_exist = 0
							GOSUB second_floor_of_cars
							second_floor_cars_exist = 1
						ENDIF
						IF third_floor_cars_exist = 0
							GOSUB third_floor_of_cars
							third_floor_cars_exist = 1
						ENDIF
						IF fourth_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 306.31 -610.93 32.84 346.81 -479.92 40.0 // 4TH FLOOR CLEAR
							fourth_floor_cars_exist = 0
						ENDIF
						IF fifth_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 266.83 -610.93 35.23 306.31 -479.92 40.0	// 5TH FLOOR CLEAR
							fifth_floor_cars_exist = 0
						ENDIF
						need_to_clear_area_flag = 2
					ENDIF
				ENDIF

				IF need_to_clear_area_flag > 1
					IF IS_PLAYER_IN_AREA_3D player 266.83 -610.93 30.4 306.31 -479.92 34.84 0 // 3RD FLOOR LOCATE
						IF second_floor_cars_exist = 0
							GOSUB second_floor_of_cars
							second_floor_cars_exist = 1
						ENDIF
						IF third_floor_cars_exist = 0
							GOSUB third_floor_of_cars
							third_floor_cars_exist = 1
						ENDIF
						IF fourth_floor_cars_exist = 0
							GOSUB fourth_floor_of_cars
							fourth_floor_cars_exist = 1
						ENDIF
						IF fifth_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 266.83 -610.93 35.23 306.31 -479.92 40.0	// 5TH FLOOR CLEAR
							fifth_floor_cars_exist = 0
						ENDIF
						need_to_clear_area_flag = 3
					ENDIF
				ENDIF

				IF need_to_clear_area_flag > 2
					IF IS_PLAYER_IN_AREA_3D player 306.31 -610.93 32.84 346.81 -479.92 40.0 0 // 4TH FLOOR LOCATE
						IF second_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 306.31 -610.93 28.0 346.81 -479.92 32.42 // 2ND FLOOR CLEAR
							second_floor_cars_exist = 0
						ENDIF
						IF third_floor_cars_exist = 0
							GOSUB third_floor_of_cars
							third_floor_cars_exist = 1
						ENDIF
						IF fourth_floor_cars_exist = 0
							GOSUB fourth_floor_of_cars
							fourth_floor_cars_exist = 1
						ENDIF
						IF fifth_floor_cars_exist = 0
							GOSUB fifth_floor_of_cars
							fifth_floor_cars_exist = 1
						ENDIF
						need_to_clear_area_flag = 4
					ENDIF
				ENDIF

				IF need_to_clear_area_flag > 3
					IF IS_PLAYER_IN_AREA_3D player 266.83 -610.93 35.23 306.31 -479.92 40.0 0 // 5TH FLOOR LOCATE
						IF second_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 306.31 -610.93 28.0 346.81 -479.92 32.42 // 2ND FLOOR CLEAR
							second_floor_cars_exist = 0
						ENDIF
						IF third_floor_cars_exist = 1
							CLEAR_AREA_OF_CARS 266.83 -610.93 30.4 306.31 -479.92 34.84 // 3RD FLOOR CLEAR
							third_floor_cars_exist = 0
						ENDIF
						IF fourth_floor_cars_exist = 0
							GOSUB fourth_floor_of_cars
							fourth_floor_cars_exist = 1
						ENDIF
						IF fifth_floor_cars_exist = 0
							GOSUB fifth_floor_of_cars
							fifth_floor_cars_exist = 1
						ENDIF
						need_to_clear_area_flag = 5
					ENDIF
				ENDIF

				IF need_to_clear_area_flag > 0
					IF NOT IS_PLAYER_IN_AREA_3D player 266.83 -610.93 25.0 346.81 -479.92 40.0 0 // ENTIRE CARPARK LOCATE
						SET_CAR_DENSITY_MULTIPLIER 1.0
						CLEAR_AREA_OF_CARS 306.31 -610.93 28.0 346.81 -479.92 32.42 // 2ND FLOOR CLEAR
						CLEAR_AREA_OF_CARS 266.83 -610.93 30.4 306.31 -479.92 34.84 // 3RD FLOOR CLEAR
						CLEAR_AREA_OF_CARS 306.31 -610.93 32.84 346.81 -479.92 40.0 // 4TH FLOOR CLEAR
						CLEAR_AREA_OF_CARS 266.83 -610.93 35.23 306.31 -479.92 40.0	// 5TH FLOOR CLEAR
						second_floor_cars_exist = 0
						third_floor_cars_exist  = 0
						fourth_floor_cars_exist = 0
						fifth_floor_cars_exist	= 0
						need_to_clear_area_flag = 0
					ENDIF
				ENDIF
			ENDIF //IS_PLAYER_IN_ZONE player COM_EAS // CARPARK STUFF

		ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		IF need_to_clear_area_flag > 0
			IF NOT IS_PLAYER_IN_AREA_3D player 266.83 -610.93 25.0 346.81 -479.92 40.0 0 // ENTIRE CARPARK LOCATE
				SET_CAR_DENSITY_MULTIPLIER 1.0
				CLEAR_AREA_OF_CARS 306.31 -610.93 28.0 346.81 -479.92 32.42 // 2ND FLOOR CLEAR
				CLEAR_AREA_OF_CARS 266.83 -610.93 30.4 306.31 -479.92 34.84 // 3RD FLOOR CLEAR
				CLEAR_AREA_OF_CARS 306.31 -610.93 32.84 346.81 -479.92 40.0 // 4TH FLOOR CLEAR
				CLEAR_AREA_OF_CARS 266.83 -610.93 35.23 306.31 -479.92 40.0	// 5TH FLOOR CLEAR
				second_floor_cars_exist = 0
				third_floor_cars_exist  = 0
				fourth_floor_cars_exist = 0
				fifth_floor_cars_exist	= 0
				need_to_clear_area_flag = 0
			ENDIF
		ENDIF
	ENDIF //IS_PLAYER_PLAYING

	GOTO com_car_park_inner
}

second_floor_of_cars://////////////////////////////////////////////
	CREATE_RANDOM_CAR_FOR_CAR_PARK 311.5469 -510.2604 28.1100 91.0159 	  // 2ND FLOOR CARS
	CREATE_RANDOM_CAR_FOR_CAR_PARK 323.5103 -526.5427 28.1100 270.3409 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 342.6624 -542.3556 28.1100 268.3777 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 311.4912 -554.4299 28.1100 91.0689 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 310.4685 -574.6492 28.1100 269.4606 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 342.7477 -590.4939 28.1100 268.4776
RETURN/////////////////////////////////////////////////////////////

third_floor_of_cars:///////////////////////////////////////////////
	CREATE_RANDOM_CAR_FOR_CAR_PARK 302.2802 -580.5526 30.5114  270.3723   // 3RD FLOOR CARS
	CREATE_RANDOM_CAR_FOR_CAR_PARK 289.5574 -564.5915 30.5114 88.0410 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 283.8795 -548.4308 30.5114 92.5479 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 270.6312 -528.4613 30.5114 88.6249 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 301.5385 -484.7673 30.3863 271.6668 
RETURN/////////////////////////////////////////////////////////////

fourth_floor_of_cars://////////////////////////////////////////////
	CREATE_RANDOM_CAR_FOR_CAR_PARK 311.0863 -512.6859 32.8451 91.1545 	  // 4TH FLOOR CARS
	CREATE_RANDOM_CAR_FOR_CAR_PARK 342.6769 -536.3028 32.8375 266.6709 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 311.4744 -564.1841 32.8375 267.5539 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 330.5274 -584.3387 32.8375 267.7581 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 342.9128 -600.6630 32.8375 87.2900 
RETURN/////////////////////////////////////////////////////////////

fifth_floor_of_cars:///////////////////////////////////////////////
	CREATE_RANDOM_CAR_FOR_CAR_PARK 282.3572 -582.5417 35.2389 267.0331 	 // 5TH FLOOR CARS
	CREATE_RANDOM_CAR_FOR_CAR_PARK 302.7462 -574.5422 35.2465 271.0973 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 270.9382 -530.4745 35.2389 88.3213 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 303.2198 -510.6057 35.2389 88.6673 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 283.2274 -502.7662 35.2389 89.4868 
	CREATE_RANDOM_CAR_FOR_CAR_PARK 302.4006 -485.5503 35.2389 266.0503
RETURN/////////////////////////////////////////////////////////////


/*
check_for_dead_peds_in_genstuf:

IF IS_CHAR_DEAD tramp1
	tramp1_dead = 1
ELSE
	tramp1_dead = 0
ENDIF

IF IS_CHAR_DEAD tramp2
	tramp2_dead = 1
ELSE
	tramp2_dead = 0
ENDIF

IF IS_CHAR_DEAD tramp3
	tramp3_dead = 1
ELSE
	tramp3_dead = 0
ENDIF

IF IS_CHAR_DEAD tramp4
	tramp4_dead = 1
ELSE
	tramp4_dead = 0
ENDIF
RETURN
*/

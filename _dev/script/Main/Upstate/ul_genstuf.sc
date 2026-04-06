// *************************************UPSTATE LIBERTY GENSTUFF***************************
// Authors:
// Adi

MISSION_START

VAR_INT	ul_camera_ammu1 ul_camera_ammu2 ul_ammu_sample 
VAR_INT ul_ammu_bloke_kill_player
VAR_INT ul_special_ammu_audio 
VAR_INT ul_in_ammu_int, ul_ammu_bloke_speech_timer, ul_ammu_bloke_respawn_time
ul_ammu_bloke_respawn_time = 60000
// ul_ammu_bloke_respawn_time = 3000

VAR_INT bolt_burger_bloke, bolt_burger_type, bolt_burger_bloke_respawn_time, bolt_burger_bloke_spawned
VAR_INT bolt_time_difference, bolt_current_time, last_bolt_burger_type, bolt_time_since_murdering_shopkeeper
bolt_burger_bloke_respawn_time = 60000
// bolt_burger_bloke_respawn_time = 3000

SCRIPT_NAME	ul_gens

SET_DEATHARREST_STATE OFF

mission_start_ul_genstuf:

{
    START_NEW_SCRIPT t1_ammu
	START_NEW_SCRIPT ul_ammu
	START_NEW_SCRIPT ul_burg

	MISSION_END
}

t1_ammu:
{
//	Should be called in mission_start_ul_genstuf

	SCRIPT_NAME UL_AMT1

t1_ammu_inner:
	
	WAIT 70

	IF IS_PLAYER_PLAYING Player
		IF IS_PLAYER_IN_ZONE player BAXTER
        AND NOT IS_PLAYER_IN_ZONE player T1HOSP
			IF IS_PLAYER_IN_AREA_3D player -1377.797 1525.731 60.535 -1368.052 1535.31 85.535 FALSE
				IF ul_camera_ammu1 = 0
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

					IF time_difference > ul_ammu_bloke_respawn_time 
						CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL4 -1369.658 1530.674 71.24 ammu_shop_bloke1
						SET_CHAR_PERSONALITY ammu_shop_bloke1 PEDSTAT_TOUGH_GUY 
						SET_CHAR_HEADING ammu_shop_bloke1 90.0
						SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
						GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_SHOTGUN 999
						IF IS_PLAYER_PLAYING player
							CHAR_LOOK_AT_PLAYER_ALWAYS ammu_shop_bloke1 Player
						ENDIF
					ENDIF

					UNLOAD_SPECIAL_CHARACTER 4
					SET_FIXED_CAMERA_POSITION -1374.022 1527.195 74.261 0.0 0.0 0.0
					ENABLE_PLAYER_CONTROL_CAMERA
					IF IS_PLAYER_PLAYING player
						POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT
						CLEAR_AREA -1376.428 1528.704 71.24 1.0 TRUE
			 		   	SET_PLAYER_COORDINATES player -1376.428 1528.704 71.24
						SET_PLAYER_HEADING player -60.0
					ENDIF
					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_PLAYER_PLAYING player
						SET_PLAYER_CONTROL Player on
					ENDIF

					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						IF ul_special_ammu_audio = 0 
							IF ul_ammu_sample = 0
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_1
							ENDIF
							IF ul_ammu_sample = 1
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_2
							ENDIF
							IF ul_ammu_sample = 2
								SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_3
							ENDIF
						ENDIF
					ENDIF

					ul_camera_ammu1 = 1
				ELSE	//	ul_camera_ammu1 = 1

					IF IS_PLAYER_SHOOTING player
						IF NOT IS_CHAR_DEAD ammu_shop_bloke1
							IF ul_ammu_bloke_kill_player = 0
								IF IS_PLAYER_PLAYING player
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
								ENDIF
								ul_ammu_bloke_kill_player = 1
							ENDIF
						ENDIF
					ENDIF

				ENDIF
			ELSE	//	player not in area (-1377.797 1525.731 70.535 -1368.052 1535.31 75.535)
				IF ul_camera_ammu1 = 1
					SET_PLAYER_CONTROL Player Off
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					IF IS_CHAR_DEAD	ammu_shop_bloke1
					AND	time_difference > ul_ammu_bloke_respawn_time //time_difference is greater than 60,000 means shopkeeper has been created 
						GET_GAME_TIMER time_since_murdering_shopkeeper1 
					ENDIF
					DELETE_CHAR	ammu_shop_bloke1
					CLEAR_AREA -1380.601 1528.704 71.24 1.0 TRUE
					IF IS_PLAYER_PLAYING player
		 		   		SET_PLAYER_COORDINATES player -1380.601 1528.704 71.24
						SET_PLAYER_HEADING player -90.0
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
					
					ul_ammu_sample ++

					IF ul_ammu_sample > 2
						ul_ammu_sample = 0
					ENDIF
					
					ul_ammu_bloke_kill_player = 0	
					ul_camera_ammu1 = 0
				ENDIF

			ENDIF //IS_PLAYER_IN_AREA_3D
		ELSE	//	not in BAXTER

			IF ul_camera_ammu1 = 1
				IF IS_CHAR_DEAD	ammu_shop_bloke1
				AND	time_difference > ul_ammu_bloke_respawn_time //time_difference is greater than 30,000 means shopkeeper has been created
					GET_GAME_TIMER time_since_murdering_shopkeeper1 
				ENDIF
				RESTORE_CAMERA_JUMPCUT
				SET_CAMERA_IN_FRONT_OF_PLAYER
				DELETE_CHAR	ammu_shop_bloke1
				SET_MUSIC_DOES_FADE TRUE
				ul_camera_ammu1 = 0
			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player BAXTER

	ENDIF //IS_PLAYER_PLAYING

	GOTO t1_ammu_inner
}

ul_ammu:
{
//	Should be called in mission_start_ul_genstuf
	LVAR_FLOAT ammu_bloke_x, ammu_bloke_y, ammu_bloke_z, ammu_bloke_heading
	LVAR_FLOAT ammu_int_lbx, ammu_int_lby, ammu_int_lbz, ammu_int_rtx, ammu_int_rty, ammu_int_rtz
	LVAR_FLOAT ammu_hostile_lbx, ammu_hostile_lby, ammu_hostile_rtx, ammu_hostile_rty
	LVAR_INT ammu_id, ammu_prev_id

	SCRIPT_NAME UL_AMMU

ul_ammu_inner:
	
	WAIT 70

ul_ammu_workaround:
	ammu_prev_id = ammu_id
	ammu_id = 0
	IF IS_PLAYER_PLAYING Player
		IF IS_PLAYER_IN_ZONE player GTMALL
			ammu_id = 1
			ammu_bloke_x = 1580.657
			ammu_bloke_y = 1371.308
			ammu_bloke_z = 133.773
			ammu_bloke_heading = 180.0
			ammu_int_lbx = 1577.206
			ammu_int_lby = 1361.535
			ammu_int_lbz = 133.113
			ammu_int_rtx = 1589.036
			ammu_int_rty = 1372.818
			ammu_int_rtz = 137.235
			ammu_hostile_lbx = 1576.366
			ammu_hostile_lby = 1353.202
			ammu_hostile_rtx = 1594.756
			ammu_hostile_rty = 1372.818
		ENDIF
		IF IS_PLAYER_IN_ZONE player CARRIN
			ammu_id = 2
			ammu_bloke_x = 560.551
			ammu_bloke_y = 1324.228
			ammu_bloke_z = 130.978
			ammu_bloke_heading = 73.0
			ammu_int_lbx = 550.484
			ammu_int_lby = 1318.353
			ammu_int_lbz = 130.084
			ammu_int_rtx = 563.719
			ammu_int_rty = 1329.675
			ammu_int_rtz = 139.436
			ammu_hostile_lbx = 532.716
			ammu_hostile_lby = 1288.394
			ammu_hostile_rtx = 590.566
			ammu_hostile_rty = 1339.71
		ENDIF
	ENDIF

	IF ammu_id = 0
	OR ammu_id > ammu_prev_id
	OR ammu_id < ammu_prev_id
		IF ul_camera_ammu2 = 1
			IF IS_CHAR_DEAD	ammu_shop_bloke1
			AND	time_difference > ul_ammu_bloke_respawn_time //time_difference is greater than 60,000 means shopkeeper has been created 
				GET_GAME_TIMER time_since_murdering_shopkeeper1 
			ENDIF
			DELETE_CHAR	ammu_shop_bloke1
			
			ul_ammu_bloke_kill_player = 0	
			ul_camera_ammu2 = 0
			ul_in_ammu_int = 0
			ul_ammu_bloke_speech_timer = 0
		ENDIF
	ENDIF

	IF ammu_id > 0
		IF ul_camera_ammu2 = 0
			LOAD_SPECIAL_CHARACTER 4 sam
			WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
				WAIT 0
			ENDWHILE
			GET_GAME_TIMER current_time
			time_difference = current_time - time_since_murdering_shopkeeper1

			IF time_difference > ul_ammu_bloke_respawn_time 
				CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL4 ammu_bloke_x ammu_bloke_y ammu_bloke_z ammu_shop_bloke1
				SET_CHAR_PERSONALITY ammu_shop_bloke1 PEDSTAT_TOUGH_GUY 
				SET_CHAR_HEADING ammu_shop_bloke1 ammu_bloke_heading
				SET_CHAR_STAY_IN_SAME_PLACE ammu_shop_bloke1 TRUE
				GIVE_WEAPON_TO_CHAR ammu_shop_bloke1 WEAPONTYPE_SHOTGUN 999
			ENDIF

			UNLOAD_SPECIAL_CHARACTER 4

			ul_camera_ammu2 = 1

		ELSE
			IF IS_PLAYER_IN_AREA_3D player ammu_int_lbx ammu_int_lby ammu_int_lbz ammu_int_rtx ammu_int_rty ammu_int_rtz FALSE
				IF ul_in_ammu_int = 0
					ul_in_ammu_int = 1
					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						IF IS_PLAYER_PLAYING player
							CHAR_LOOK_AT_PLAYER_ALWAYS ammu_shop_bloke1 Player
						ENDIF

						IF ul_ammu_bloke_kill_player = 1
							IF IS_PLAYER_PLAYING player
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
							ENDIF
						ELSE
							IF ul_special_ammu_audio = 0
							AND ul_ammu_bloke_speech_timer <= 0
								ul_ammu_bloke_speech_timer = 5000
								IF ul_ammu_sample = 0
									SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_1
								ENDIF
								IF ul_ammu_sample = 1
									SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_2
								ENDIF
								IF ul_ammu_sample = 2
									SET_CHAR_SAY ammu_shop_bloke1 SOUND_AMMUNATION_CHAT_3
								ENDIF

								ul_ammu_sample ++
								IF ul_ammu_sample > 2
									ul_ammu_sample = 0
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				IF IS_PLAYER_SHOOTING player
					IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						IF ul_ammu_bloke_kill_player = 0
							IF IS_PLAYER_PLAYING player
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
							ENDIF
							ul_ammu_bloke_kill_player = 1
						ENDIF
					ENDIF
				ENDIF
				ul_ammu_bloke_speech_timer -= 70

			ELSE // not in ammu interior

				IF ul_in_ammu_int = 1
					ul_in_ammu_int = 0

					// IF IS_PLAYER_PLAYING player
					// 	STOP_CHAR_LOOKING ammu_shop_bloke1
					// ENDIF

					// Workaround for broken chat and look at: recreate the guy every time player enters the interior
					IF IS_CHAR_DEAD	ammu_shop_bloke1
						IF	time_difference > ul_ammu_bloke_respawn_time //time_difference is greater than 60,000 means shopkeeper has been created 
							GET_GAME_TIMER time_since_murdering_shopkeeper1 
						ENDIF
					ELSE
						DELETE_CHAR	ammu_shop_bloke1
						//ul_ammu_bloke_kill_player = 0	
						ul_camera_ammu2 = 0
						ul_in_ammu_int = 0
						GOTO ul_ammu_workaround
					ENDIF
					
				ELSE
					IF ul_ammu_bloke_kill_player = 1
						IF NOT IS_CHAR_DEAD ammu_shop_bloke1
						AND IS_PLAYER_PLAYING player
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
						ENDIF
					ENDIF
				ENDIF

				IF NOT IS_CHAR_DEAD ammu_shop_bloke1
				AND IS_PLAYER_SHOOTING_IN_AREA player ammu_hostile_lbx ammu_hostile_lby ammu_hostile_rtx ammu_hostile_rty FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ammu_shop_bloke1 Player
				ENDIF
			ENDIF
		ENDIF
    ENDIF

	GOTO ul_ammu_inner
}

ul_burg:
{
//	Should be called in mission_start_ul_genstuf
	LVAR_FLOAT burg_bloke_x, burg_bloke_y, burg_bloke_z, burg_bloke_heading
	LVAR_INT remove_bloke
	LVAR_FLOAT pX, pY, pZ

	SCRIPT_NAME UL_BURG

ul_burg_inner:
	
	WAIT 70

	last_bolt_burger_type = bolt_burger_type
	bolt_burger_type = 0
	IF IS_PLAYER_PLAYING Player
		IF IS_PLAYER_IN_ZONE player BAXTER
			bolt_burger_type = 1
		ENDIF
		IF IS_PLAYER_IN_ZONE player WARSAW
			bolt_burger_type = 2
		ENDIF
		IF IS_PLAYER_IN_ZONE player CARRIN
			bolt_burger_type = 3
		ENDIF
		IF IS_PLAYER_IN_ZONE player SUMMER
			bolt_burger_type = 4
			GET_PLAYER_COORDINATES player pX, pY, pZ
			IF pY > 1326.0
			OR pZ > 133.2
				bolt_burger_type = 5
			ENDIF
		ENDIF
	ENDIF

	IF bolt_burger_type > 0
		LOAD_SPECIAL_CHARACTER 3 keeper
	ENDIF

	IF NOT HAS_SPECIAL_CHARACTER_LOADED 3
		bolt_burger_type = last_bolt_burger_type
		GOTO ul_burg_inner
	ENDIF

	IF bolt_burger_bloke_spawned = TRUE
		IF last_bolt_burger_type > 0
			IF bolt_burger_type > last_bolt_burger_type
			OR bolt_burger_type < last_bolt_burger_type
				remove_bloke = TRUE
			ENDIF
		ENDIF

		IF bolt_burger_type = 0
			remove_bloke = TRUE
		ENDIF
	ENDIF

	IF remove_bloke = FALSE
	AND bolt_burger_bloke_spawned = FALSE
	AND bolt_burger_type > 0
		IF bolt_burger_type = 1
			burg_bloke_x = -1352.661
			burg_bloke_y = 1562.736
			burg_bloke_z = 71.49
			burg_bloke_heading = -90.0
		ENDIF
		IF bolt_burger_type = 2
			burg_bloke_x = -221.542
			burg_bloke_y = 1315.899
			burg_bloke_z = 111.336
			burg_bloke_heading = 180.0
		ENDIF
		IF bolt_burger_type = 3
			burg_bloke_x = 517.479
			burg_bloke_y = 1300.353
			burg_bloke_z = 130.728
			burg_bloke_heading = -17.0
		ENDIF
		IF bolt_burger_type = 4
			burg_bloke_x = 1574.339
			burg_bloke_y = 1320.607
			burg_bloke_z = 129.774
			burg_bloke_heading = -90.0
		ENDIF
		IF bolt_burger_type = 5
			burg_bloke_x = 1582.777
			burg_bloke_y = 1366.966
			burg_bloke_z = 137.773
			burg_bloke_heading = 180.0
		ENDIF

		// GET_GAME_TIMER bolt_current_time
		// bolt_time_difference = bolt_current_time - bolt_time_since_murdering_shopkeeper

		// IF bolt_time_difference > bolt_burger_bloke_respawn_time 
			// PRINT_STRING "spawn bloke" 2000
			CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL3 burg_bloke_x burg_bloke_y burg_bloke_z bolt_burger_bloke
			SET_CHAR_PERSONALITY bolt_burger_bloke PEDSTAT_SHOPPER
			SET_CHAR_HEADING bolt_burger_bloke burg_bloke_heading
			SET_CHAR_STAY_IN_SAME_PLACE bolt_burger_bloke TRUE
			bolt_burger_bloke_spawned = TRUE
		// ENDIF

		UNLOAD_SPECIAL_CHARACTER 3
	ENDIF

	IF bolt_burger_bloke_spawned = TRUE
		// IF IS_CHAR_DEAD	bolt_burger_bloke
		// AND	bolt_time_difference > bolt_burger_bloke_respawn_time //time_difference is greater than 60,000 means shopkeeper has been created 
		// 	GET_GAME_TIMER bolt_time_since_murdering_shopkeeper
		// ENDIF
		IF remove_bloke = TRUE
			DELETE_CHAR	bolt_burger_bloke
			bolt_burger_bloke_spawned = FALSE
			remove_bloke = FALSE
			// PRINT_STRING "remove bloke" 2000
		ENDIF
	ENDIF

	GOTO ul_burg_inner
}
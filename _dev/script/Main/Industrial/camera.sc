MISSION_START

VAR_INT rays_cutscene_flag rays_camera_1 rays_camera_2 rays_camera_3
//VAR_INT camera_stuff1 camera_stuff2	camera_stuff3 camera_stuff4
/*
camera_stuff1 = 0
camera_stuff2 = 0
camera_stuff3 = 0
camera_stuff4 = 0
*/
rays_camera_1 = 0
rays_camera_2 = 0
rays_camera_3 = 0
rays_cutscene_flag = 0


SCRIPT_NAME	camera

SET_DEATHARREST_STATE OFF


mission_start_camera:
{
WAIT 70


//INDUSTRIAL******************************************************************************************************
/*
IF IS_PLAYER_PLAYING Player

	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

		IF IS_PLAYER_IN_ZONE player CHINA
			// Fuzz ball camera zoom
			IF IS_PLAYER_IN_AREA_3D player 1004.0 -892.0 14.0 996.9 -885.6 17.0 FALSE
				IF camera_stuff1 = 0
					SET_FIXED_CAMERA_POSITION 1000.120 -880.396 16.6 0.0 0.0 0.0
					POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION
					//POINT_CAMERA_AT_POINT 1000.1 -881.3 16.5 INTERPOLATION
					//SET_CAMERA_ZOOM CAM_ZOOM_TWO
					camera_stuff1 = 1
				ENDIF
			ELSE
				IF camera_stuff1 = 1
					RESTORE_CAMERA
					SET_CAMERA_IN_FRONT_OF_PLAYER
					camera_stuff1 = 0
				ENDIF
			ENDIF
		ENDIF

	ENDIF //IS_PLAYER_IN_ZONE

ENDIF //IS_PLAYER_PLAYING
*/


//COMMERCIAL*****************************************************************************************************

IF IS_PLAYER_PLAYING Player

	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL


	//RAYS TOILETS FIXED CAM STUFF //rays_camera_1
		IF rays_cutscene_flag = 0
			IF IS_PLAYER_PLAYING player
				IF IS_PLAYER_IN_ZONE player PARK
					IF IS_PLAYER_IN_AREA_3D player 36.5302 -734.5862 21.67 47.4772 -726.9442 24.457 0
						IF IS_PLAYER_IN_AREA_2D player 36.5302 -729.3754 47.4772 -726.9442 0
							IF rays_camera_1 = 0
								SET_PLAYER_CONTROL player OFF
								SET_FADING_COLOUR 1 1 1
								DO_FADE 200 FADE_OUT
								rays_camera_1 = 1
							ENDIF
							IF rays_camera_1 = 1
								IF NOT GET_FADING_STATUS
									IF rays_camera_2 = 0
										SET_PLAYER_COORDINATES player 38.9775 -727.8468 21.6
										SET_PLAYER_HEADING player 225.0
									ENDIF
									SET_FIXED_CAMERA_POSITION 36.0301 -728.3186 24.2803 0.0 0.0 0.0
									ENABLE_PLAYER_CONTROL_CAMERA
									POINT_CAMERA_AT_POINT 36.9545 -728.3175 23.8989 JUMP_CUT
									DO_FADE 200 FADE_IN
									rays_camera_1 = 2
								ENDIF
							ENDIF
							IF rays_camera_1 = 2
								IF NOT GET_FADING_STATUS
									SET_PLAYER_CONTROL player ON
									rays_camera_1 = 3
									rays_camera_2 = 0
									rays_camera_3 = 0
								ENDIF
							ENDIF
						ENDIF
						IF IS_PLAYER_IN_AREA_2D player 44.2774 -734.5862 47.4772 -729.3754 0
							IF rays_camera_2 = 0
								SET_PLAYER_CONTROL player OFF
								DO_FADE 200 FADE_OUT
								rays_camera_2 = 1
							ENDIF
							IF rays_camera_2 = 1
								IF NOT GET_FADING_STATUS
									SET_FIXED_CAMERA_POSITION 46.7275 -727.1589 22.5274 0.0 0.0 0.0
									ENABLE_PLAYER_CONTROL_CAMERA
									POINT_CAMERA_AT_POINT 46.4612 -728.1208 22.5895 JUMP_CUT
									DO_FADE 200 FADE_IN
									rays_camera_2 = 2
								ENDIF
							ENDIF
							IF rays_camera_2 = 2
								IF NOT GET_FADING_STATUS
									SET_PLAYER_CONTROL player ON
									rays_camera_1 = 0
									rays_camera_2 = 3
									rays_camera_3 = 0
								ENDIF
							ENDIF
						ENDIF
						IF IS_PLAYER_IN_AREA_2D player 36.5302 -734.5862 44.2774 -729.3754 0
							IF rays_camera_3 = 0
								SET_PLAYER_CONTROL player OFF
								DO_FADE 200 FADE_OUT
								rays_camera_3 = 1
							ENDIF
							IF rays_camera_3 = 1
								IF NOT GET_FADING_STATUS
									SET_FIXED_CAMERA_POSITION 46.5875 -733.8959 23.9757 0.0 0.0 0.0
									ENABLE_PLAYER_CONTROL_CAMERA
									POINT_CAMERA_AT_POINT 45.6562 -733.6129 23.7464 JUMP_CUT
									DO_FADE 200 FADE_IN
									rays_camera_3 = 2
								ENDIF
							ENDIF
							IF rays_camera_3 = 2
								IF NOT GET_FADING_STATUS
									SET_PLAYER_CONTROL player ON
									rays_camera_1 = 0
									rays_camera_2 = 0
									rays_camera_3 = 3
								ENDIF
							ENDIF
						ENDIF
					ELSE
						IF rays_camera_1 = 3
							SET_PLAYER_CONTROL player OFF
							DO_FADE 200 FADE_OUT
							rays_camera_1 = 4
						ENDIF
						IF rays_camera_1 = 4
							IF NOT GET_FADING_STATUS
								CLEAR_AREA 38.9115 -726.0132 22.2 2.0 TRUE
								SET_PLAYER_COORDINATES player 38.9115 -726.0132 21.6
								SET_PLAYER_HEADING player 0.0
								RESTORE_CAMERA_JUMPCUT
								SET_CAMERA_IN_FRONT_OF_PLAYER
								DO_FADE 200 FADE_IN
								rays_camera_1 = 5
							ENDIF
						ENDIF
						IF rays_camera_1 = 5
							IF NOT GET_FADING_STATUS
								SET_PLAYER_CONTROL player ON
								rays_camera_1 = 0
								rays_camera_2 = 0
								rays_camera_3 = 0
							ENDIF
						ENDIF
					ENDIF
				ELSE
					IF NOT rays_camera_1 = 0
					OR NOT rays_camera_2 = 0
					OR NOT rays_camera_3 = 0
						SET_CAMERA_IN_FRONT_OF_PLAYER
						RESTORE_CAMERA_JUMPCUT
						rays_camera_1 = 0
						rays_camera_2 = 0
						rays_camera_3 = 0
					ENDIF
				ENDIF		
			ENDIF
		ENDIF
		//END OF RAYS TOILETS FIXED CAM STUFF
		/*
		IF IS_PLAYER_PLAYING Player
			// Police cell wall camera zoom	
			IF IS_PLAYER_IN_AREA_3D player 332.1 -1093.3 24.0 323.3 -1089.1 30.0 FALSE
				IF camera_stuff4 = 0
					SET_FIXED_CAMERA_POSITION 328.2  -1086.4  28.2 0.0 0.0 0.0
					POINT_CAMERA_AT_PLAYER player FIXED INTERPOLATION
					camera_stuff4 = 1
				ENDIF
			ELSE
				IF camera_stuff4 = 1
					RESTORE_CAMERA
					SET_CAMERA_IN_FRONT_OF_PLAYER
					camera_stuff4 = 0
				ENDIF
			ENDIF
		ENDIF
		*/
		/*
		
		IF IS_PLAYER_PLAYING player
			IF IS_PLAYER_IN_ZONE player SHOPING

				// Dojo building camera zoom
				IF IS_PLAYER_IN_AREA_3D player 106.1 -1277.7 24.0 96.3 -1273.0 29.0 FALSE
					IF camera_stuff2 = 0
						SET_FIXED_CAMERA_POSITION 110.634 -1275.475 28.018 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT 109.649 -1275.441 27.842 INTERPOLATION
						camera_stuff2 = 1
					ENDIF
				ELSE
					IF camera_stuff2 = 1
						RESTORE_CAMERA
						SET_CAMERA_IN_FRONT_OF_PLAYER
						camera_stuff2 = 0
					ENDIF
				ENDIF
			
				// Love building door camera zoom
				IF IS_PLAYER_IN_AREA_3D player 87.8 -1545.7 27.0 94.9 -1551.7 30.0 FALSE
					IF camera_stuff3 = 0
						SET_FIXED_CAMERA_POSITION 84.303 -1548.550 30.503 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT 85.271 -1548.602 30.257 INTERPOLATION
						camera_stuff3 = 1
					ENDIF
				ELSE
					IF camera_stuff3 = 1
						RESTORE_CAMERA
						SET_CAMERA_IN_FRONT_OF_PLAYER
						camera_stuff3 = 0
					ENDIF
				ENDIF

			ENDIF //IS_PLAYER_IN_ZONE
		ENDIF //IS_PLAYER_PLAYING
		*/

	ENDIF //IS_PLAYER_IN_ZONE

ENDIF //IS_PLAYER_PLAYING



GOTO mission_start_camera

MISSION_END
}
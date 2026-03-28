MISSION_START

VAR_FLOAT ul_objectx, ul_objecty, ul_objectz // Checks for the sliding doors to tell them to close if an object is in the way
VAR_INT ul_not_clunked_yet
VAR_INT	ul_gate_sfx1 ul_gate_sfx2

ul_gate_sfx1 = 0
ul_gate_sfx2 = 0

ul_not_clunked_yet = 0

SCRIPT_NAME	UL_GATE

SET_DEATHARREST_STATE OFF


mission_start_ul_gates:
{
	START_NEW_SCRIPT gt_police_gate

	MISSION_END
}



gt_police_gate:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME UL_GTPG

gt_police_gate_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		IF IS_PLAYER_IN_ZONE player GTWCENT
		// Gostburg Police Gate
			IF IS_PLAYER_IN_AREA_3D player 1429.562 1648.609 124.773 1439.562 1662.609 129.774 FALSE
				IF IS_PLAYER_IN_MODEL player CAR_POLICE
				OR IS_PLAYER_IN_AREA_3D player 1429.562 1656.444 124.773 1439.562 1662.609 129.774 FALSE
					IF ul_gate_sfx1 = 0
						ADD_ONE_OFF_SOUND 1438.894 1656.444 125.939 SOUND_GATE_START_CLUNK
						ul_gate_sfx1 = 1
					ENDIF
					WHILE NOT SLIDE_OBJECT ul_gt_police_door 1447.806 1656.444 125.939 0.1 0.0 0.0 FALSE
						WAIT 0
					ENDWHILE
					IF ul_not_clunked_yet = 1
						ul_gate_sfx2 = 0
						ul_not_clunked_yet = 0
					ENDIF
					IF ul_gate_sfx2 = 0
						ADD_ONE_OFF_SOUND 1447.806 1656.444 125.939 SOUND_GATE_STOP_CLUNK
						ul_gate_sfx2 = 1
					ENDIF						

				ENDIF							 			
			ELSE	

				IF ul_gate_sfx1 = 1
					ADD_ONE_OFF_SOUND 1447.806 1656.444 125.939 SOUND_GATE_START_CLUNK
				ENDIF

				WHILE NOT SLIDE_OBJECT ul_gt_police_door 1438.894 1656.444 125.939 0.1 0.0 0.0 TRUE
					WAIT 0
				ENDWHILE

				GET_OBJECT_COORDINATES ul_gt_police_door ul_objectx ul_objecty ul_objectz

				IF ul_gate_sfx2 = 1
					ul_not_clunked_yet = 1
					IF ul_objectx = 1438.894  
					AND ul_objecty = 1656.444
					AND ul_objectz	= 125.939
						ADD_ONE_OFF_SOUND 1438.894 1656.444 125.939 SOUND_GATE_STOP_CLUNK
						ul_gate_sfx2 = 0
						ul_not_clunked_yet = 0
					ENDIF
				ENDIF
				ul_gate_sfx1 = 0
			ENDIF	//	IF IS_PLAYER_IN_AREA_3D

		ENDIF	//	IF IS_PLAYER_IN_ZONE
		
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO gt_police_gate_inner
}
					
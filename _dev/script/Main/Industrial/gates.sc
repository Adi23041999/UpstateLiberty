MISSION_START

VAR_FLOAT objectx, objecty, objectz // Checks for the sliding doors to tell them to close if an object is in the way
VAR_INT gate_sfx1_fish gate_sfx2_fish  not_clunked_yet
VAR_INT	gate_sfx1_meat gate_sfx2_meat  
VAR_INT	gate_sfx1 gate_sfx2 gate2_sfx1 gate2_sfx2
VAR_INT open_phils_gate

gate_sfx1 = 0
gate_sfx2 = 0
gate2_sfx1 = 0
gate2_sfx2 = 0

gate_sfx1_fish = 0
gate_sfx2_fish = 0

gate_sfx1_meat = 0
gate_sfx2_meat = 0

not_clunked_yet = 0

SCRIPT_NAME	gates

SET_DEATHARREST_STATE OFF


mission_start_gates:
{
	START_NEW_SCRIPT fish_factory_gate
	START_NEW_SCRIPT dog_food_factory_gate

	START_NEW_SCRIPT police_gate1
	START_NEW_SCRIPT police_gate2
	START_NEW_SCRIPT colombian_gate
	START_NEW_SCRIPT phils_gate

	START_NEW_SCRIPT colombian_gate2

	MISSION_END
}


// INDUSTRIAL GATES ***********************************************************************************************

fish_factory_gate:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME FSH_GTE

fish_factory_gate_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

			IF IS_PLAYER_IN_ZONE Player PORT_W
			
				// Fish Factory Gate
				IF IS_PLAYER_IN_AREA_3D player 1025.2 -1108.4 12.0 1008.2 -1098.4 16.0 FALSE
					IF IS_PLAYER_IN_MODEL player CAR_BELLYUP
					OR IS_PLAYER_IN_MODEL player CAR_TRASHMASTER
					OR IS_PLAYER_IN_AREA_3D player 1015.6 -1100.5 12.0 1009.2 -1108.1 16.0 FALSE
						IF gate_sfx1_fish = 0
							ADD_ONE_OFF_SOUND 1016.0 -1107.955 12.294 SOUND_GATE_START_CLUNK
							gate_sfx1_fish = 1
						ENDIF
						WHILE NOT SLIDE_OBJECT fish_factory_gate 1016.0 -1099.455 12.294 0.0 0.1 0.0 FALSE
							WAIT 0								 
						ENDWHILE
						IF not_clunked_yet = 1
							gate_sfx2_fish = 0
							not_clunked_yet = 0
						ENDIF
						IF gate_sfx2_fish = 0
							ADD_ONE_OFF_SOUND 1016.0 -1099.455 12.294 SOUND_GATE_STOP_CLUNK
							gate_sfx2_fish = 1	  
						ENDIF
					ENDIF
													
				ELSE
					
					IF gate_sfx1_fish = 1
						ADD_ONE_OFF_SOUND 1016.0 -1099.455 12.294 SOUND_GATE_START_CLUNK
					ENDIF
															 
					WHILE NOT SLIDE_OBJECT fish_factory_gate 1016.0 -1107.955 12.294 0.0 0.1 0.0 TRUE
	//					GET_OBJECT_COORDINATES fish_factory_gate objectx objecty objectz
						WAIT 0
					ENDWHILE

					GET_OBJECT_COORDINATES fish_factory_gate objectx objecty objectz

					IF gate_sfx2_fish = 1
						not_clunked_yet = 1
						IF objectx = 1016.0  
						AND objecty = -1107.955
						AND objectz	= 12.294
							ADD_ONE_OFF_SOUND 1016.0 -1107.955 12.294 SOUND_GATE_STOP_CLUNK
							gate_sfx2_fish = 0	  
							not_clunked_yet = 0
						ENDIF
					ENDIF
							
					gate_sfx1_fish = 0
				ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 1025.2 -1108.4 12.0 1008.2 -1098.4 16.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE Player PORT_W

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO fish_factory_gate_inner
}


dog_food_factory_gate:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME DOG_GTE

dog_food_factory_gate_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

			IF IS_PLAYER_IN_ZONE Player PORT_I

				// Dog Food Factory Gate
				IF IS_PLAYER_IN_ANGLED_AREA_3D player 1247.58 -822.0 12.0 1253.94 -815.0 18.0 14.0 FALSE
					IF gate_sfx1_meat = 0
						ADD_ONE_OFF_SOUND 1250.4 -812.0 13.97 SOUND_GATE_START_CLUNK
						gate_sfx1_meat = 1
					ENDIF

					WHILE NOT SLIDE_OBJECT dogfood_factory_gate 1244.4 -818.0 13.97 0.1 0.1 0.0 FALSE
						WAIT 0
					ENDWHILE
					IF not_clunked_yet = 1
						gate_sfx2_meat = 0
						not_clunked_yet = 0
					ENDIF
					IF gate_sfx2_meat = 0
						ADD_ONE_OFF_SOUND 1244.4 -818.0 13.97 SOUND_GATE_STOP_CLUNK
						gate_sfx2_meat = 1
					ENDIF
				ELSE
					IF gate_sfx1_meat = 1
						ADD_ONE_OFF_SOUND 1244.4 -818.0 13.97 SOUND_GATE_START_CLUNK
					ENDIF

					WHILE NOT SLIDE_OBJECT dogfood_factory_gate 1250.4 -812.0 13.97 0.1 0.1 0.0 TRUE
					//GET_OBJECT_COORDINATES dogfood_factory_gate objectx objecty objectz
						WAIT 0
					ENDWHILE
					
					GET_OBJECT_COORDINATES dogfood_factory_gate objectx objecty objectz

					IF gate_sfx2_meat = 1
						not_clunked_yet = 1
						IF objectx = 1250.4  
						AND objecty = -812.0
						AND objectz	= 13.97
							ADD_ONE_OFF_SOUND 1250.4 -812.0 13.97 SOUND_GATE_STOP_CLUNK
							gate_sfx2_meat = 0
							not_clunked_yet = 0
						ENDIF
					ENDIF
					gate_sfx1_meat = 0
				ENDIF	//	IF IS_PLAYER_IN_ANGLED_AREA_3D player 1247.58 -822.0 12.0 1253.94 -815.0 18.0 14.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE Player PORT_I

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO dog_food_factory_gate_inner
}

// END OF INDUSTRIAL GATES ****************************************************************************************


// COMMERCIAL GATES ***********************************************************************************************

police_gate1:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME POL_GT1

police_gate1_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

		 	IF IS_PLAYER_IN_ZONE player YAKUSA
		 			  								 
			// Commercial Police Gate one
				IF IS_PLAYER_IN_AREA_3D player 358.0 -1138.0 18.0 366.0 -1121.0 30.0 FALSE
					IF IS_PLAYER_IN_MODEL player CAR_POLICE
					OR IS_PLAYER_IN_AREA_3D player 365.9 -1128.2 21.9 358.5 -1119.5 26.0 FALSE
						IF gate_sfx1 = 0
							ADD_ONE_OFF_SOUND 366.158 -1128.522 21.941 SOUND_GATE_START_CLUNK
							gate_sfx1 = 1
						ENDIF
						WHILE NOT SLIDE_OBJECT police_door_one 358.158 -1128.522 21.941 0.1 0.0 0.0 FALSE
							WAIT 0
						ENDWHILE
						IF not_clunked_yet = 1
							gate_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
						IF gate_sfx2 = 0
							ADD_ONE_OFF_SOUND 358.158 -1128.522 21.941 SOUND_GATE_STOP_CLUNK
							gate_sfx2 = 1
						ENDIF									
					ENDIF							 
				ELSE	

					IF gate_sfx1 = 1
						ADD_ONE_OFF_SOUND 358.158 -1128.522 21.941 SOUND_GATE_START_CLUNK
					ENDIF
												
					WHILE NOT SLIDE_OBJECT police_door_one 366.158 -1128.522 21.941 0.1 0.0 0.0 TRUE
	//					GET_OBJECT_COORDINATES police_door_one objectx objecty objectz
						WAIT 0
					ENDWHILE

					GET_OBJECT_COORDINATES police_door_one objectx objecty objectz

					IF gate_sfx2 = 1
						not_clunked_yet = 1
						IF objectx = 366.158  
						AND objecty = -1128.522
						AND objectz	= 21.941
							ADD_ONE_OFF_SOUND 366.158 -1128.522 21.941 SOUND_GATE_STOP_CLUNK
							gate_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
					ENDIF
					gate_sfx1 = 0
				ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 358.0 -1138.0 18.0 366.0 -1121.0 30.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE player YAKUSA

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO police_gate1_inner
}
					

police_gate2:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME POL_GT2

police_gate2_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

		 	IF IS_PLAYER_IN_ZONE player YAKUSA

				// commercial police gate two
				IF IS_PLAYER_IN_AREA_3D player 317.87 -1136.0 18.0 322.84 -1119.82 30.0 FALSE
					IF IS_PLAYER_IN_MODEL player CAR_POLICE
					OR IS_PLAYER_IN_AREA_3D player 322.7 -1128.1 21.9 318.0 -1119.3 26.0 FALSE
						IF gate2_sfx1 = 0
							ADD_ONE_OFF_SOUND 326.3 -1128.522 21.941 SOUND_GATE_START_CLUNK
							gate2_sfx1 = 1
						ENDIF
								   				
						WHILE NOT SLIDE_OBJECT police_door_two 332.0 -1128.522 21.941 0.1 0.0 0.0 FALSE
							WAIT 0
						ENDWHILE
						IF not_clunked_yet = 1
							gate2_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
						IF gate2_sfx2 = 0
							ADD_ONE_OFF_SOUND 332.0 -1128.522 21.941 SOUND_GATE_STOP_CLUNK
							gate2_sfx2 = 1
						ENDIF	
									
					ENDIF						
				ELSE	

					IF gate2_sfx1 = 1
						ADD_ONE_OFF_SOUND 332.0 -1128.522 21.941 SOUND_GATE_START_CLUNK							
					ENDIF

					WHILE NOT SLIDE_OBJECT police_door_two 326.3 -1128.522 21.941 0.1 0.0 0.0 TRUE
	//					GET_OBJECT_COORDINATES police_door_two objectx objecty objectz
						WAIT 0
					ENDWHILE

					GET_OBJECT_COORDINATES police_door_two objectx objecty objectz

					IF gate2_sfx2 = 1
						not_clunked_yet = 1
						IF objectx = 326.3  
						AND objecty = -1128.522
						AND objectz	= 21.941
							ADD_ONE_OFF_SOUND 326.3 -1128.522 21.941 SOUND_GATE_STOP_CLUNK
							gate2_sfx2 = 0
							not_clunked_yet = 0										
						ENDIF
					ENDIF
					gate2_sfx1 = 0
				ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 317.87 -1136.0 18.0 322.84 -1119.82 30.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE player YAKUSA

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
			   
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO police_gate2_inner
}


colombian_gate:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME COL_GTE

colombian_gate_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

			IF IS_PLAYER_IN_ZONE player STADIUM

				// Colombian Compound Gate
				IF IS_PLAYER_IN_AREA_3D player 98.6 -337.53 14.0 81.9 -317.56 20.0 FALSE
					IF IS_PLAYER_IN_MODEL player CAR_COLUMB
					OR IS_PLAYER_IN_AREA_3D player 31.0 -317.0 14.0 91.0 -394.0 25.0 FALSE
						IF gate2_sfx1 = 0
							ADD_ONE_OFF_SOUND 91.589 -318.592 15.296 SOUND_GATE_START_CLUNK
							gate2_sfx1 = 1
						ENDIF

						WHILE NOT SLIDE_OBJECT colombian_gate 91.589 -327.365 15.296 0.0 0.1 0.0 FALSE
							WAIT 0
						ENDWHILE
						IF not_clunked_yet = 1
							gate_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
						IF gate2_sfx2 = 0
							ADD_ONE_OFF_SOUND 91.589 -327.365 15.296 SOUND_GATE_STOP_CLUNK
							gate2_sfx2 = 1
						ENDIF
					ENDIF				
				ELSE

					IF gate2_sfx1 = 1
						ADD_ONE_OFF_SOUND 91.589 -327.365 15.296 SOUND_GATE_START_CLUNK
					ENDIF

					WHILE NOT SLIDE_OBJECT colombian_gate 91.589 -318.592 15.296 0.0 0.1 0.0 TRUE
	//					GET_OBJECT_COORDINATES colombian_gate objectx objecty objectz
						WAIT 0
					ENDWHILE

					GET_OBJECT_COORDINATES colombian_gate objectx objecty objectz

					IF gate2_sfx2 = 1
						not_clunked_yet = 1
						IF objectx = 91.589  
						AND objecty = -318.592
						AND objectz	= 15.296
							ADD_ONE_OFF_SOUND 91.589 -318.592 15.296 SOUND_GATE_STOP_CLUNK
							gate2_sfx2 = 0
							not_clunked_yet = 0		
						ENDIF
					ENDIF
					gate2_sfx1 = 0
				ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 98.6 -337.53 14.0 81.9 -317.56 20.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE player STADIUM

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO colombian_gate_inner
}


phils_gate:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME PHL_GTE

phils_gate_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

			IF IS_PLAYER_IN_ZONE player HOSPI_2

			//PHIL'S GATE

				open_phils_gate = FALSE

				IF flag_ray_mission2_passed = 1
					IF IS_PLAYER_IN_AREA_2D player 134.0 198.0 156.0 207.0 FALSE
						open_phils_gate = TRUE
					ENDIF
				ELSE
					IF flag_player_on_phil_mission = 1	//	If player is doing phil mission 
						GOTO phils_gate_inner			//	then this script doesn't move the gate at all.
					ENDIF								//	The phil script should do all gate moving.

					IF IS_PLAYER_IN_AREA_2D player 138.0 198.0 146.0 207.0 FALSE
						open_phils_gate = TRUE
					ENDIF
				ENDIF

				IF open_phils_gate = TRUE

					IF gate2_sfx1 = 0
						ADD_ONE_OFF_SOUND 147.249 207.323 10.599 SOUND_GATE_START_CLUNK
						gate2_sfx1 = 1
					ENDIF

					WHILE NOT SLIDE_OBJECT phils_compnd_gate 147.249 214.523 10.599 0.0 0.1 0.0 FALSE
						WAIT 0
					ENDWHILE

					IF not_clunked_yet = 1
						gate_sfx2 = 0
						not_clunked_yet = 0
					ENDIF

					IF gate2_sfx2 = 0
						ADD_ONE_OFF_SOUND 147.249 214.523 10.599 SOUND_GATE_STOP_CLUNK
						gate2_sfx2 = 1
					ENDIF
				ELSE
					IF gate2_sfx1 = 1
						ADD_ONE_OFF_SOUND 147.249 214.523 10.599 SOUND_GATE_START_CLUNK
					ENDIF

					WHILE NOT SLIDE_OBJECT phils_compnd_gate 147.249 207.323 10.599 0.0 0.1 0.0 TRUE
	//					GET_OBJECT_COORDINATES phils_compnd_gate objectx objecty objectz
						WAIT 0
					ENDWHILE
		
					GET_OBJECT_COORDINATES phils_compnd_gate objectx objecty objectz

					IF gate2_sfx2 = 1
						not_clunked_yet = 1
						IF objectx = 147.249  
						AND objecty = 207.323
						AND objectz	= 10.599
							ADD_ONE_OFF_SOUND 147.249 207.323 10.599 SOUND_GATE_STOP_CLUNK		
							gate2_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
					ENDIF
					gate2_sfx1 = 0

				ENDIF	//	IF open_phils_gate = TRUE

			ENDIF	//	IF IS_PLAYER_IN_ZONE player HOSPI_2

		//ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO phils_gate_inner
}

// END OF COMMERCIAL GATES ****************************************************************************************


// SUBURBAN GATES *************************************************************************************************


colombian_gate2:
{
//	Should be called in mission_start_gates

	SCRIPT_NAME COL2GTE

colombian_gate2_inner:

	WAIT 1000

	IF IS_PLAYER_PLAYING Player

		//IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN	
	 
			IF IS_PLAYER_IN_ZONE player SWANKS
				  								 
				// Columbian gate
				IF IS_PLAYER_IN_AREA_3D player -367.3 241.0 59.0 -358.8 259.6 65.0 FALSE
					IF IS_PLAYER_IN_MODEL player CAR_COLUMB
					OR IS_PLAYER_IN_AREA_3D player -367.3 251.0 59.0 -358.8 259.6 65.0 FALSE
						IF gate_sfx1 = 0
							ADD_ONE_OFF_SOUND -363.05 250.455 61.355 SOUND_GATE_START_CLUNK
							gate_sfx1 = 1
						ENDIF			   						  					
						WHILE NOT SLIDE_OBJECT Columbian_gate2 -370.05 250.455 61.355 0.1 0.0 0.0 FALSE
							WAIT 0
						ENDWHILE
						IF not_clunked_yet = 1
							gate_sfx2 = 0
							not_clunked_yet = 0
						ENDIF
						IF gate_sfx2 = 0
							ADD_ONE_OFF_SOUND -370.05 250.455 61.355 SOUND_GATE_STOP_CLUNK
							gate_sfx2 = 1
						ENDIF									
					ENDIF							 
				ELSE		

					IF gate_sfx1 = 1
						ADD_ONE_OFF_SOUND -370.05 250.455 61.355 SOUND_GATE_START_CLUNK
					ENDIF
						
					WHILE NOT SLIDE_OBJECT Columbian_gate2 -363.05 250.455 61.355 0.1 0.0 0.0 TRUE
	//					GET_OBJECT_COORDINATES Columbian_gate2 objectx objecty objectz
						WAIT 0
					ENDWHILE

					GET_OBJECT_COORDINATES Columbian_gate2 objectx objecty objectz

					IF gate_sfx2 = 1
						not_clunked_yet = 1
						IF objectx = -363.05  
						AND objecty = 250.455
						AND objectz	= 61.355
							ADD_ONE_OFF_SOUND -363.05 250.455 61.355 SOUND_GATE_STOP_CLUNK
							gate_sfx2 = 0
							not_clunked_yet = 0		
						ENDIF
					ENDIF
					gate_sfx1 = 0
				ENDIF	//	IF IS_PLAYER_IN_AREA_3D player -367.3 241.0 59.0 -358.8 259.6 65.0 FALSE

			ENDIF	//	IF IS_PLAYER_IN_ZONE player SWANKS

	   //ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO colombian_gate2_inner
}

// END OF SUBURBAN GATES ******************************************************************************************


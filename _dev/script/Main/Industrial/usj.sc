MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** Unique Stunt Jumps *********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

 
// Variables for mission

VAR_INT	players_car_usj cash_reward_usj total_completed_usj
VAR_INT flag_1st_locate_usj flag_2nd_locate_usj	usj_number collision_counter_usj
VAR_INT flag_usj1_passed flag_usj2_passed flag_usj3_passed flag_usj4_passed	flag_usj5_passed flag_usj6_passed flag_usj7_passed
VAR_INT flag_usj8_passed flag_usj9_passed flag_usj10_passed flag_usj11_passed flag_usj12_passed	flag_usj13_passed flag_usj14_passed
VAR_INT flag_usj15_passed flag_usj16_passed	flag_usj17_passed flag_usj18_passed	flag_usj19_passed flag_usj20_passed
VAR_FLOAT car_speed_usj camera_x camera_y camera_z

// ****************************************Mission Start************************************

flag_usj1_passed = 0
flag_usj2_passed = 0
flag_usj3_passed = 0
flag_usj4_passed = 0
flag_usj5_passed = 0
flag_usj6_passed = 0
flag_usj7_passed = 0
flag_usj8_passed = 0
flag_usj9_passed = 0
flag_usj10_passed = 0
flag_usj11_passed = 0
flag_usj12_passed = 0
flag_usj13_passed = 0
flag_usj14_passed = 0
flag_usj15_passed = 0
flag_usj16_passed = 0
flag_usj17_passed = 0
flag_usj18_passed = 0
flag_usj19_passed = 0
flag_usj20_passed = 0

cash_reward_usj = 5000
usj_number = 0
total_completed_usj = 0

SET_DEATHARREST_STATE OFF
SET_UNIQUE_JUMPS_TOTAL 20

SCRIPT_NAME usj


mission_start_usj:

WAIT 0

IF NOT IS_PLAYER_PLAYING player
	GOTO mission_start_usj
ENDIF

IF NOT IS_PLAYER_IN_ANY_CAR player
	GOTO mission_start_usj
ENDIF
	
STORE_CAR_PLAYER_IS_IN_NO_SAVE player players_car_usj

IF IS_BOAT players_car_usj
	GOTO mission_start_usj
ENDIF

GET_CAR_SPEED players_car_usj car_speed_usj

IF NOT car_speed_usj > 25.0
	GOTO mission_start_usj
ENDIF

IF NOT IS_CAR_IN_AIR_PROPER players_car_usj
	GOTO mission_start_usj
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL
	
	IF IS_PLAYER_IN_ZONE player	ROADBR1
		IF LOCATE_PLAYER_IN_CAR_2D player 940.4 -933.7 4.0 4.0 0 //BETWEEN CALLAHAN BRIDGE
			usj_number = 1
			camera_x = 998.0
			camera_y = -938.5
			camera_z = 19.3
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player 793.17 -929.963 42.166 4.0 2.0 3.0 0 //OVER CALLAHAN BRIDGE
			usj_number = 11
			camera_x = 841.8475//853.8542
			camera_y = -930.1524//-927.6523
			camera_z = 34.3645//34.0808
			GOTO the_jump
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_ZONE player	PORT_S
		IF LOCATE_PLAYER_IN_CAR_2D player 1168.983 -1156.913 10.0 7.0 0//1156.0 -1154.0 4.0 8.0 0 //OVER DOCKS
			usj_number = 2
			camera_x = 1217.2
			camera_y = -1162.4
			camera_z = 15.0
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player 1231.858 -1129.855 4.0 2.5 0 //OVER WAREHOUSE NEAR RAVE
			usj_number = 5
			camera_x = 1201.384
			camera_y = -1135.662
			camera_z = 19.64
			GOTO the_jump
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_ZONE player	CHINA
		IF LOCATE_PLAYER_IN_CAR_2D player 789.697 -572.312 2.7 5.0 0 // OVER FOOTBRIDGE
			usj_number = 3
			camera_x = 779.957
			camera_y = -561.1698
			camera_z = 25.1615
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player 991.727 -470.397 19.785 2.0 4.0 3.0 0	//ONTO LTRAIN TRACKS BY SUBWAY
			usj_number = 10
			camera_x = 987.5289
			camera_y = -462.6134
			camera_z = 21.8678
			GOTO the_jump
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_ZONE player	PORT_I
		IF LOCATE_PLAYER_IN_CAR_2D player 1136.621 -976.864 4.0 2.5 0 //OVER FREIGHT BACKS
			usj_number = 6
			camera_x = 1107.076 
			camera_y = -964.015
			camera_z =  22.981
			GOTO the_jump
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_ZONE player	PORT_E
		IF LOCATE_PLAYER_IN_CAR_2D player 1375.758 -952.149 5.0 5.0 0 //OVER WAREHOUSE BY SAWMILLS
			usj_number = 7
			camera_x = 1369.274 
			camera_y = -981.598
			camera_z = 18.734
			GOTO the_jump
		ENDIF
	ENDIF

	GOTO mission_start_usj
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
	IF IS_PLAYER_IN_ZONE player	COM_EAS
		IF LOCATE_PLAYER_IN_CAR_3D player 470.728 -918.38 19.828 6.0 3.0 3.0 0 //UNDER CALLAHAN BRIDGE
			usj_number = 4
			camera_x = 460.954
			camera_y = -947.844
			camera_z = 17.934
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player 271.152 -607.027 4.0 5.0 0 //OUT OF CARPARK
			usj_number = 13
			camera_x = 281.8645
			camera_y = -626.5409
			camera_z = 26.9559
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player 320.223 -896.357 6.0 5.0 0 //ONTO CALLAHAN BRIDGE
			usj_number = 14
			camera_x = 332.8589
			camera_y = -906.3721
			camera_z = 39.7656
			GOTO the_jump
		ENDIF
	ENDIF
	IF IS_PLAYER_IN_ZONE player	PARK
		IF LOCATE_PLAYER_IN_CAR_3D player 157.584 -998.192 30.39 2.5 2.8 2.0 0//159.987 -998.158 30.379 0.5 2.8 2.0 0 //TWAT CAFE
			usj_number = 12
			camera_x = 141.5205
			camera_y = -1006.8531
			camera_z = 26.177
			GOTO the_jump
		ENDIF
	ENDIF
	GOTO mission_start_usj
ENDIF

IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN
	
	IF IS_PLAYER_IN_ZONE player SUB_IND
		IF LOCATE_PLAYER_IN_CAR_3D player -1182.442 22.213 74.03 3.0 4.0 3.0 0 //BAIT WAREHOUSE GOING EAST
			usj_number = 8
			camera_x = -1204.47
			camera_y = -14.721
			camera_z = 62.1738
			GOTO the_jump
		ENDIF
	ENDIF
	
	IF IS_PLAYER_IN_ZONE player BIG_DAM
		IF LOCATE_PLAYER_IN_CAR_3D player -1160.622 105.944 73.531 4.0 3.5 3.0 0 //BAIT WAREHOUSE GOING SOUTH
			usj_number = 9
			camera_x = -1137.7355
			camera_y = 115.1705
			camera_z = 64.4229
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player -994.754 253.616 10.0 15.0 0 //BY COCHRANE BRIDGE
			usj_number = 15
			camera_x = -1014.4852//-1039.1022
			camera_y = 268.1786//265.3116
			camera_z = 38.8862//3.4568
			GOTO the_jump
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_ZONE player PROJECT
		IF LOCATE_PLAYER_IN_CAR_2D player -699.058 -172.26 6.0 7.0 0 //	JAMES BOND BRIDGE
			usj_number = 16
			camera_x = -738.03
			camera_y = -132.5792
			camera_z = 12.501
			GOTO the_jump
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_ZONE player AIRPORT
		IF LOCATE_PLAYER_IN_CAR_2D player -1100.542 -847.44 4.0 12.0 0 // AIRPORT HANGAR SE
			usj_number = 17
			camera_x = -1068.0343
			camera_y = -863.0062
			camera_z = 18.4249
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player -1375.772 -848.662 4.0 12.0 0 // AIRPORT HANGAR SW
			usj_number = 18
			camera_x = -1337.7358
			camera_y = -862.9677
			camera_z = 18.0594
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player -1379.849 -625.095 12.0 4.0 0 // AIRPORT HANGAR NW
			usj_number = 19
			camera_x = -1397.5281
			camera_y = -572.0431
			camera_z = 18.8811
			GOTO the_jump
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player -1177.38 -569.913 3.3 2.0 0 // AIRPORT PLANE
			usj_number = 20
			camera_x = -1195.1605//-1192.1388
			camera_y = -560.7097//-556.9338
			camera_z = 18.9029//11.134
			GOTO the_jump
		ENDIF
	ENDIF

	GOTO mission_start_usj
ENDIF

GOTO mission_start_usj

the_jump:

flag_1st_locate_usj = 0 
flag_2nd_locate_usj = 0
collision_counter_usj = 0

SET_TIME_SCALE 0.3
SET_FIXED_CAMERA_POSITION camera_x camera_y camera_z 0.0 0.0 0.0
POINT_CAMERA_AT_CAR players_car_usj FIXED JUMP_CUT

WHILE IS_CAR_IN_AIR_PROPER players_car_usj
OR collision_counter_usj < 10

	++ collision_counter_usj
	
	WAIT 0

	IF IS_CAR_DEAD players_car_usj
		GOTO camera_restore_if_fail
	ENDIF
	
	IF IS_CAR_IN_WATER players_car_usj
		GOTO camera_restore_if_fail
	ENDIF
	
	IF NOT IS_PLAYER_PLAYING player
		GOTO camera_restore_if_fail
	ENDIF

	IF NOT IS_PLAYER_IN_ANY_CAR player
		GOTO camera_restore_if_fail
	ENDIF
	
	IF usj_number = 1
		IF LOCATE_PLAYER_IN_CAR_3D player 946.5 -934.1 26.8 1.0	4.0 6.0	0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 993.5 -933.8 21.8 1.0	4.0 6.0	0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF
													 	 	
	IF usj_number = 2
		IF LOCATE_PLAYER_IN_CAR_3D player 1190.0 -1154.0 25.0 1.0 10.0 10.0	0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 1243.6 -1154.0 13.5 20.0 15.0 3.0	0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF
	
	IF usj_number = 3
		IF LOCATE_PLAYER_IN_CAR_3D player 789.316 -563.296 29.202 10.0 0.5 5.0 0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 789.316 -558.888 29.202 10.0 0.5 5.0 0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF
	
	IF usj_number = 4
		IF LOCATE_PLAYER_IN_CAR_3D player 470.728 -931.7 24.828 9.0 0.5 8.0 0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 470.532 -962.841 16.589 6.5 14.5 2.0 0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF
		
	IF usj_number = 5
		IF LOCATE_PLAYER_IN_CAR_3D player 1205.573 -1124.826 25.819 1.0 15.0 10.0 0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 1182.763 -1124.826 25.819 1.0 15.0 10.0 0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 6
		IF LOCATE_PLAYER_IN_CAR_3D player 1127.485 -978.877 29.145 1.0 15.0 10.0 0
			flag_1st_locate_usj = 1
		ENDIF

		IF LOCATE_PLAYER_IN_CAR_3D player 1104.808 -978.877 29.145 1.0 15.0 10.0 0
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 7
		IF LOCATE_PLAYER_IN_CAR_3D player 1376.953 -984.634 23.53 8.0 0.5 7.5 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 8
		IF LOCATE_PLAYER_IN_CAR_3D player -1197.722 -41.855 63.732 30.0 5.5 8.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 9
		IF LOCATE_PLAYER_IN_CAR_3D player -1095.672 116.771 60.304 16.5 4.0 2.5 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 10
		IF LOCATE_PLAYER_IN_CAR_3D player 995.212 -440.228 26.456 4.3 0.5 5.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 11
		IF LOCATE_PLAYER_IN_CAR_3D player 879.708 -933.811 26.845 30.0 5.5 0.5 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 12
		IF LOCATE_PLAYER_IN_CAR_3D player 130.308 -999.861 32.406 0.5 6.0 7.5 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 13
		IF LOCATE_PLAYER_IN_CAR_2D player 271.836 -656.396 5.0 5.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 14
		IF LOCATE_PLAYER_IN_CAR_2D player 308.231 -942.208 23.0 5.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 15
		IF LOCATE_PLAYER_IN_CAR_2D player -1073.749 246.756 38.0 22.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 16
		IF LOCATE_PLAYER_IN_CAR_2D player -706.363 -91.074 18.0 30.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 17
		IF LOCATE_PLAYER_IN_CAR_3D player -1067.966 -847.738 27.527 0.5 14.5 10.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 18
		IF LOCATE_PLAYER_IN_CAR_3D player -1342.627 -847.864 26.928 0.5 14.5 10.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 19
		IF LOCATE_PLAYER_IN_CAR_3D player -1380.287 -573.483 22.686 14.3 0.5 10.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF usj_number = 20
		IF LOCATE_PLAYER_IN_CAR_3D player -1184.052 -569.913 24.278 0.5 6.0 8.0 0
			flag_1st_locate_usj = 1
			flag_2nd_locate_usj = 1
		ENDIF
	ENDIF 
	
	IF flag_1st_locate_usj = 1
	AND flag_2nd_locate_usj = 1
		GOTO mission_usj_passed
	ENDIF

ENDWHILE

WHILE IS_CAR_IN_AIR_PROPER players_car_usj
	WAIT 0

	IF IS_CAR_DEAD players_car_usj
		GOTO camera_restore_if_fail
	ENDIF

	IF IS_CAR_IN_WATER players_car_usj
		GOTO camera_restore_if_fail
	ENDIF

	IF NOT IS_PLAYER_PLAYING player
		GOTO camera_restore_if_fail
	ENDIF

	IF NOT IS_PLAYER_IN_ANY_CAR player
		GOTO camera_restore_if_fail
	ENDIF

ENDWHILE

WAIT 600
camera_restore_if_fail:
SET_TIME_SCALE 1.0
RESTORE_CAMERA_JUMPCUT

GOTO mission_start_usj
   
// mission usj1 passed

mission_usj_passed:

WHILE IS_CAR_IN_AIR_PROPER players_car_usj
	WAIT 0

	IF IS_CAR_DEAD players_car_usj
		GOTO camera_restore_if_fail
	ENDIF

	IF IS_CAR_IN_WATER players_car_usj
		GOTO camera_restore_if_fail
	ENDIF

	IF NOT IS_PLAYER_PLAYING player
		GOTO camera_restore_if_fail
	ENDIF

	IF NOT IS_PLAYER_IN_ANY_CAR player
		GOTO camera_restore_if_fail
	ENDIF

ENDWHILE

WAIT 600
camera_restore_if_passed:
SET_TIME_SCALE 1.0
RESTORE_CAMERA_JUMPCUT

IF usj_number = 1
AND	flag_usj1_passed = 0
	flag_usj1_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 2
AND	flag_usj2_passed = 0
	flag_usj2_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 3
AND	flag_usj3_passed = 0
	flag_usj3_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 4
AND	flag_usj4_passed = 0
	flag_usj4_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 5
AND	flag_usj5_passed = 0
	flag_usj5_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 6
AND	flag_usj6_passed = 0
	flag_usj6_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 7
AND	flag_usj7_passed = 0
	flag_usj7_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 8
AND	flag_usj8_passed = 0
	flag_usj8_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 9
AND	flag_usj9_passed = 0
	flag_usj9_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 10
AND	flag_usj10_passed = 0
	flag_usj10_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 11
AND	flag_usj11_passed = 0
	flag_usj11_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 12
AND	flag_usj12_passed = 0
	flag_usj12_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 13
AND	flag_usj13_passed = 0
	flag_usj13_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 14
AND	flag_usj14_passed = 0
	flag_usj14_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 15
AND	flag_usj15_passed = 0
	flag_usj15_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 16
AND	flag_usj16_passed = 0
	flag_usj16_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 17
AND	flag_usj17_passed = 0
	flag_usj17_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 18
AND	flag_usj18_passed = 0
	flag_usj18_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 19
AND	flag_usj19_passed = 0
	flag_usj19_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

IF usj_number = 20
AND	flag_usj20_passed = 0
	flag_usj20_passed = 1
	++ total_completed_usj
	PLAYER_MADE_PROGRESS 1
	GOTO reward_usj
ENDIF

GOTO mission_start_usj

reward_usj:
IF total_completed_usj < 20 
	PRINT_BIG_Q USJ 5000 5 //UNIQUE STUNT BONUS!
	PRINT_WITH_NUMBER_BIG REWARD cash_reward_usj 6000 6
	ADD_SCORE player cash_reward_usj
ELSE
	PRINT_BIG_Q USJ_ALL 5000 5 //ALL UNIQUE STUNTS COMPLETED!
	PRINT_WITH_NUMBER_BIG REWARD 1000000 6000 6
	ADD_SCORE player 1000000
ENDIF

ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

REGISTER_UNIQUE_JUMP_FOUND
cash_reward_usj += 5000
GOTO mission_start_usj

MISSION_END

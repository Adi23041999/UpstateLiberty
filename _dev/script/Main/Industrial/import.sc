MISSION_START

//IMPORT EXPORT VARIABLES
VAR_INT imported_car import_car_been_created_before	import_car_type
VAR_INT imported_car2 import_car_been_created_before2 import_car_type2

VAR_INT	industrial_garage_slots_filled create_car_pickups_industrial changed_industrial_garage_before
VAR_INT industrial_slot1 industrial_slot2 industrial_slot3 industrial_slot4 industrial_slot5 industrial_slot6 industrial_slot7 industrial_slot8
VAR_INT industrial_slot9 industrial_slot10 industrial_slot11 industrial_slot12 industrial_slot13 industrial_slot14 industrial_slot15 industrial_slot16
VAR_INT securicar_pickup moonbeam_pickup coach_pickup flatbed_pickup linerunner_pickup trashmaster_pickup patriot_pickup whoopee_pickup
VAR_INT	blista_pickup mule_pickup yankee_pickup	bobcat_pickup dodo_pickup bus_pickup rumpo_pickup pony_pickup
VAR_INT securicar_score_off moonbeam_score_off coach_score_off flatbed_score_off linerunner_score_off trashmaster_score_off patriot_score_off whoopee_score_off
VAR_INT	blista_score_off mule_score_off yankee_score_off bobcat_score_off dodo_score_off bus_score_off rumpo_score_off pony_score_off


VAR_INT	suburban_garage_slots_filled create_car_pickups_suburban changed_suburban_garage_before
VAR_INT suburban_slot1 suburban_slot2 suburban_slot3 suburban_slot4 suburban_slot5 suburban_slot6 suburban_slot7 suburban_slot8
VAR_INT suburban_slot9 suburban_slot10 suburban_slot11 suburban_slot12 suburban_slot13 suburban_slot14 suburban_slot15 suburban_slot16
VAR_INT	sentinet_pickup cheetah_pickup banshee_pickup idaho_pickup infernus_pickup taxi_pickup kuruma_pickup stretch_pickup	 
VAR_INT	perennial_pickup stinger_pickup manana_pickup landstalker_pickup stallion_pickup injection_pickup cabbie_pickup esperanto_pickup	 
VAR_INT	sentinet_score_off cheetah_score_off banshee_score_off idaho_score_off infernus_score_off taxi_score_off kuruma_score_off stretch_score_off	 
VAR_INT	perennial_score_off stinger_score_off manana_score_off landstalker_score_off stallion_score_off injection_score_off cabbie_score_off esperanto_score_off


VAR_INT military_car military_car_been_created_before military_car_type3  
VAR_INT	military_slots_filled create_military_pickups cran_activated_before

VAR_INT	copcar_pickup swatvan_pickup fbi_pickup tank_pickup firetruck_pickup ambulance_pickup barracks_pickup  
	   
VAR_INT number_of_packages_collected bonus_weapons_created

VAR_INT earned_free_pistol earned_free_uzi earned_free_armour earned_free_shotgun earned_free_grenades 
VAR_INT earned_free_molotovs earned_free_ak47 earned_free_sniper earned_free_m16 earned_free_launcher earned_free_flamethrower

VAR_INT bonus_gun1 bonus_gun2 bonus_gun3 bonus_gun4 bonus_gun5 bonus_gun6 bonus_gun7 bonus_gun8 bonus_gun9 bonus_gun10 bonus_gunflame
VAR_INT bonus_bribe1 bonus_bribe2 bonus_bribe3 bonus_bribe4 bonus_bribe5 bonus_bribe6 bonus_health bonus_adrenaline
VAR_INT ind_copcar_kills com_copcar_kills sub_copcar_kills total_saved_peds ambulance_pager_flag play_pager_message1 play_pager_message2 play_pager_message3
VAR_INT ind_fires_exting com_fires_exting sub_fires_exting

earned_free_pistol = 0
earned_free_uzi = 0
earned_free_armour = 0
earned_free_shotgun = 0
earned_free_grenades = 0
earned_free_molotovs = 0
earned_free_ak47 = 0
earned_free_sniper = 0
earned_free_m16 = 0
earned_free_launcher = 0
earned_free_flamethrower = 0
ind_copcar_kills = 0
com_copcar_kills = 0
sub_copcar_kills = 0
ind_fires_exting = 0
com_fires_exting = 0
sub_fires_exting = 0
total_saved_peds = 0

play_pager_message1 = 0
play_pager_message2 = 0
play_pager_message3	= 0
ambulance_pager_flag = 0

bonus_weapons_created = 0

import_car_been_created_before = 0
import_car_been_created_before2 = 0
military_car_been_created_before = 0

industrial_garage_slots_filled = 0
suburban_garage_slots_filled = 0
military_slots_filled = 0

create_car_pickups_industrial = 0
create_car_pickups_suburban = 0
create_military_pickups = 0

changed_suburban_garage_before = 0
changed_industrial_garage_before = 0
cran_activated_before = 0

SCRIPT_NAME	import

SET_DEATHARREST_STATE OFF

//IMPORT EXPORT GARAGE1***************************************************************************************

mission_import_start:

{
	WAIT 100

	START_NEW_SCRIPT import1_loop
	START_NEW_SCRIPT military_crane_loop
	START_NEW_SCRIPT import2_loop
	START_NEW_SCRIPT check_packages

mission_import_start_inner:

	WAIT 500

IF IS_PLAYER_PLAYING player

	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL

		IF IS_PLAYER_IN_ZONE player REDLIGH

			IF IS_PLAYER_IN_AREA_3D player 828.9 -283.8 0.0 894.2 -323.5 26.0 FALSE
				IF bonus_weapons_created = 0

					IF earned_free_pistol = 1
						CREATE_PICKUP_WITH_AMMO  WEAPON_COLT45 PICKUP_ON_STREET_SLOW 90 876.8 -317.1 10.0 bonus_gun1
					ENDIF
					IF earned_free_uzi = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 250 874.8 -317.1 10.0 bonus_gun2
					ENDIF
					IF earned_free_grenades = 1										 
						CREATE_PICKUP_WITH_AMMO WEAPON_GRENADE PICKUP_ON_STREET_SLOW 10 872.8 -317.1 10.0 bonus_gun3
					ENDIF
					IF earned_free_shotgun = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 50 870.8 -317.1 10.0 bonus_gun4
					ENDIF
					IF earned_free_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 868.8 -317.1 10.0 bonus_gun5
					ENDIF 
					IF earned_free_molotovs = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 866.8 -317.1 10.0 bonus_gun6
					ENDIF
					IF earned_free_ak47 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 300 864.8 -317.1 10.0 bonus_gun7
					ENDIF
					IF earned_free_sniper = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 50 862.8 -317.1 10.0 bonus_gun8
					ENDIF
					IF earned_free_m16 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 600 860.8 -317.1 10.0 bonus_gun9
					ENDIF
					IF earned_free_flamethrower = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 2000 858.8 -317.1 10.0 bonus_gunflame
					ENDIF
					IF earned_free_launcher = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 50 856.8 -317.1 10.0 bonus_gun10
					ENDIF

					IF ind_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 877.6 -313.8 8.5 bonus_bribe1
					ENDIF
					
					IF ind_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 875.6 -313.8 8.5 bonus_bribe2
					ENDIF
					
					IF com_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 873.6 -313.8 8.5 bonus_bribe3
					ENDIF
					
					IF com_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 871.6 -313.8 8.5 bonus_bribe4
					ENDIF
					
					IF sub_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 869.6 -313.8 8.5 bonus_bribe5
					ENDIF
					
					IF sub_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 867.6 -313.8 8.5 bonus_bribe6
					ENDIF
					
					IF total_saved_peds > 34
						CREATE_PICKUP HEALTH PICKUP_ON_STREET_SLOW 878.9 -299.0 8.2 bonus_health
					ENDIF
					
					IF total_saved_peds > 69
						CREATE_PICKUP ADRENALINE PICKUP_ON_STREET_SLOW 876.9 -299.0 8.2 bonus_adrenaline
					ENDIF
					
					bonus_weapons_created = 1
				ENDIF
					
			ELSE	//	player is not in area (828.9 -283.8 0.0 894.2 -323.5 26.0)
										 
				IF bonus_weapons_created = 1
					GOSUB remove_bonus_pickups
					bonus_weapons_created = 0
				ENDIF

			ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 828.9 -283.8 0.0 894.2 -323.5 26.0 FALSE

		ELSE	//	player is not in REDLIGH

			IF bonus_weapons_created = 1
				GOSUB remove_bonus_pickups
				bonus_weapons_created = 0
			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player REDLIGH

	ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_INDUSTRIAL


	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL
		
		IF IS_PLAYER_IN_ZONE player PARK

			IF IS_PLAYER_IN_AREA_3D player 39.5 -443.8 53.0 167.5 -484.6 15.0 FALSE
				IF bonus_weapons_created = 0

					IF earned_free_pistol = 1
						CREATE_PICKUP_WITH_AMMO  WEAPON_COLT45 PICKUP_ON_STREET_SLOW 90 132.7 -477.9 15.9 bonus_gun1
					ENDIF
					IF earned_free_uzi = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 250 132.7 -479.9 15.9 bonus_gun2
					ENDIF
					IF earned_free_grenades = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_GRENADE PICKUP_ON_STREET_SLOW 10 129.1 -477.9 15.9 bonus_gun3
					ENDIF
					IF earned_free_shotgun = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 50 129.1 -479.9 15.9 bonus_gun4
					ENDIF
					IF earned_free_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 125.6 -477.9 15.9 bonus_gun5
					ENDIF
					IF earned_free_molotovs = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 125.6 -479.9 15.9 bonus_gun6
					ENDIF
					IF earned_free_ak47 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 300 122.1 -477.9 15.9 bonus_gun7
					ENDIF
					IF earned_free_sniper = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 50 122.1 -479.9 15.9 bonus_gun8
					ENDIF
					IF earned_free_m16 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 600 118.7 -477.9 15.9 bonus_gun9
					ENDIF
					IF earned_free_flamethrower = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 2000 118.7 -479.9 15.9 bonus_gunflame
					ENDIF
					IF earned_free_launcher = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 50 125.6 -475.9 15.9 bonus_gun10
					ENDIF
					
					IF ind_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 114.5 -458.0 15.5 bonus_bribe1
					ENDIF
					
					IF ind_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 112.5 -458.0 15.5 bonus_bribe2
					ENDIF
					
					IF com_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 110.5 -458.0 15.5 bonus_bribe3
					ENDIF
					
					IF com_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 108.5 -458.0 15.5 bonus_bribe4
					ENDIF
					
					IF sub_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 106.5 -458.0 15.5 bonus_bribe5
					ENDIF
					
					IF sub_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW 104.5 -458.0 15.5 bonus_bribe6
					ENDIF

					IF total_saved_peds > 34
						CREATE_PICKUP HEALTH PICKUP_ON_STREET_SLOW 94.6 -472.5 15.5 bonus_health
					ENDIF
					
					IF total_saved_peds > 69
						CREATE_PICKUP ADRENALINE PICKUP_ON_STREET_SLOW 92.6 -472.5 15.5 bonus_adrenaline
					ENDIF

					bonus_weapons_created = 1
				ENDIF

			ELSE	//	player is not in area (39.5 -443.8 53.0 167.5 -484.6 15.0)
			
				IF bonus_weapons_created = 1
					GOSUB remove_bonus_pickups
					bonus_weapons_created = 0
				ENDIF

			ENDIF	//	IF IS_PLAYER_IN_AREA_3D player 39.5 -443.8 53.0 167.5 -484.6 15.0 FALSE

		ELSE	//	player is not in PARK

			IF bonus_weapons_created = 1
				GOSUB remove_bonus_pickups
				bonus_weapons_created = 0
			ENDIF
												 
		ENDIF	//	IF IS_PLAYER_IN_ZONE player PARK

	ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_COMMERCIAL

	
	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN

		IF IS_PLAYER_IN_ZONE player PROJECT

			IF IS_PLAYER_IN_AREA_3D player -595.8 -68.2 10.0 -700.7 3.1 30.0 FALSE
				IF bonus_weapons_created = 0

					IF earned_free_pistol = 1
						CREATE_PICKUP_WITH_AMMO  WEAPON_COLT45 PICKUP_ON_STREET_SLOW 90 -650.5 -24.8 18.8 bonus_gun1
					ENDIF
					IF earned_free_uzi = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 250 -648.5 -24.8 18.8 bonus_gun2
					ENDIF
					IF earned_free_grenades = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_GRENADE PICKUP_ON_STREET_SLOW 10 -646.5 -24.8 18.8 bonus_gun3
					ENDIF
					IF earned_free_shotgun = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 50 -644.5 -24.8 18.8 bonus_gun4
					ENDIF
					IF earned_free_armour = 1
						CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -642.5 -24.8 18.8 bonus_gun5
					ENDIF
					IF earned_free_molotovs = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 -640.5 -24.8 18.8 bonus_gun6
					ENDIF
					IF earned_free_ak47 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 300 -638.5 -24.8 18.8 bonus_gun7
					ENDIF
					IF earned_free_sniper = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 50 -636.5 -24.8 18.8 bonus_gun8
					ENDIF
					IF earned_free_m16 = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 600 -634.5 -24.8 18.8 bonus_gun9
					ENDIF
					IF earned_free_flamethrower = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 2000 -632.5 -24.8 18.8 bonus_gunflame
					ENDIF
					IF earned_free_launcher = 1
						CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 20 -630.5 -24.8 18.8 bonus_gun10
					ENDIF

					IF ind_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -663.0 -28.0 18.3 bonus_bribe1
					ENDIF
					
					IF ind_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -665.0 -28.0 18.3 bonus_bribe2
					ENDIF
					
					IF com_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -667.0 -28.0 18.3 bonus_bribe3
					ENDIF
					
					IF com_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -669.0 -28.0 18.3 bonus_bribe4
					ENDIF
					
					IF sub_copcar_kills	> 9
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -671.0 -28.0 18.3 bonus_bribe5
					ENDIF
					
					IF sub_copcar_kills	> 19
						CREATE_PICKUP BRIBE PICKUP_ON_STREET_SLOW -673.0 -28.0 18.3 bonus_bribe6
					ENDIF

					IF total_saved_peds > 34
						CREATE_PICKUP HEALTH PICKUP_ON_STREET_SLOW -654.3 -21.7 18.3 bonus_health
					ENDIF
					
					IF total_saved_peds > 69
						CREATE_PICKUP ADRENALINE PICKUP_ON_STREET_SLOW -654.3 -19.7 18.3 bonus_adrenaline
					ENDIF

					bonus_weapons_created = 1
				ENDIF
			ELSE	//	player is not in area (-595.8 -68.2 10.0 -700.7 3.1 30.0)
															 
				IF bonus_weapons_created = 1
					GOSUB remove_bonus_pickups
					bonus_weapons_created = 0
				ENDIF

			ENDIF	//	IF IS_PLAYER_IN_AREA_3D player -595.8 -68.2 10.0 -700.7 3.1 30.0 FALSE

		ELSE	//	player is not in PROJECT

			IF bonus_weapons_created = 1
				GOSUB remove_bonus_pickups
				bonus_weapons_created = 0
			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player PROJECT

	ENDIF	//	IF IS_COLLISION_IN_MEMORY LEVEL_SUBURBAN

ENDIF //IS_PLAYER_PLAYING		

GOTO mission_import_start_inner

}

MISSION_END



import1_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT1

import1_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING Player

		IF IS_PLAYER_IN_ZONE player PORT_E

			IF NOT industrial_garage_slots_filled = 16

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 1
				AND industrial_slot1 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 13.582 securicar_score_off
					DONT_REMOVE_OBJECT securicar_score_off
					SET_OBJECT_HEADING securicar_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot1 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 2
				AND industrial_slot2 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 13.385 moonbeam_score_off
					DONT_REMOVE_OBJECT moonbeam_score_off
					SET_OBJECT_HEADING moonbeam_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot2 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 3
				AND industrial_slot3 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 13.18 coach_score_off
					DONT_REMOVE_OBJECT coach_score_off
					SET_OBJECT_HEADING coach_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot3 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 4
				AND industrial_slot4 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 12.972 flatbed_score_off
					DONT_REMOVE_OBJECT flatbed_score_off
					SET_OBJECT_HEADING flatbed_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot4 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 5
				AND industrial_slot5 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 12.75 linerunner_score_off
					DONT_REMOVE_OBJECT linerunner_score_off
					SET_OBJECT_HEADING linerunner_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot5 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 6
				AND industrial_slot6 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 12.549 trashmaster_score_off
					DONT_REMOVE_OBJECT trashmaster_score_off
					SET_OBJECT_HEADING trashmaster_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot6 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 7
				AND industrial_slot7 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 12.35 patriot_score_off
					DONT_REMOVE_OBJECT patriot_score_off
					SET_OBJECT_HEADING patriot_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot7 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 8
				AND industrial_slot8 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -674.578 12.131 whoopee_score_off
					DONT_REMOVE_OBJECT whoopee_score_off
					SET_OBJECT_HEADING whoopee_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot8 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 9
				AND industrial_slot9 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.459 13.582 blista_score_off
					DONT_REMOVE_OBJECT blista_score_off
					SET_OBJECT_HEADING blista_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot9 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 10
				AND industrial_slot10 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 13.361 mule_score_off
					DONT_REMOVE_OBJECT mule_score_off
					SET_OBJECT_HEADING mule_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot10 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 11
				AND industrial_slot11 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 13.151 yankee_score_off
					DONT_REMOVE_OBJECT yankee_score_off
					SET_OBJECT_HEADING yankee_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot11 = 1
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 12
				AND industrial_slot12 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 12.966 bobcat_score_off
					DONT_REMOVE_OBJECT bobcat_score_off
					SET_OBJECT_HEADING bobcat_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot12 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 13
				AND industrial_slot13 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 12.757 dodo_score_off
					DONT_REMOVE_OBJECT dodo_score_off
					SET_OBJECT_HEADING dodo_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot13 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 14
				AND industrial_slot14 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 12.52 bus_score_off
					DONT_REMOVE_OBJECT bus_score_off
					SET_OBJECT_HEADING bus_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot14 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 15
				AND industrial_slot15 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 12.322 rumpo_score_off
					DONT_REMOVE_OBJECT rumpo_score_off
					SET_OBJECT_HEADING rumpo_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot15 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars1 16
				AND industrial_slot16 = 0
					industrial_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line 1496.036 -675.474 12.131 pony_score_off
					DONT_REMOVE_OBJECT pony_score_off
					SET_OBJECT_HEADING pony_score_off 270.0
					PLAYER_MADE_PROGRESS 1
					industrial_slot16 = 1 
				ENDIF

			ELSE

		//IF industrial_garage_slots_filled = 16

				IF changed_industrial_garage_before = 0
					CHANGE_GARAGE_TYPE collect_all_cars1 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
					changed_industrial_garage_before = 1
				ENDIF

		pick_up_pick_ups:
				WAIT 0

				IF IS_PLAYER_PLAYING player

					IF IS_PLAYER_IN_AREA_2D player 1486.9 -686.2 1524.1 -666.8 FALSE
					
						IF create_car_pickups_industrial = 0
							
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 1 1501.0 -683.0 12.1 securicar_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 2 1505.0 -683.0 12.1 moonbeam_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 3 1509.0 -683.0 12.1 coach_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 4 1513.0 -683.0 12.1 flatbed_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 5 1517.0 -683.0 12.1 linerunner_pickup

							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 6 1521.0 -683.0 12.1 trashmaster_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 7 1521.0 -680.0 12.1 patriot_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 8 1521.0 -677.0 12.1 whoopee_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 9 1521.0 -674.0 12.1 blista_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 10 1521.0 -671.0 12.1 mule_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 11 1521.0 -668.0 12.1 yankee_pickup

							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 12 1517.0 -668.0 12.1 bobcat_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 13 1513.0 -668.0 12.1 dodo_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 14 1509.0 -668.0 12.1 bus_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 15 1505.0 -668.0 12.1 rumpo_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 16 1501.0 -668.0 12.1 pony_pickup
						
							WAIT 1000
							OPEN_GARAGE collect_all_cars1
							create_car_pickups_industrial = 1
						
						ENDIF
					
										
						IF import_car_been_created_before = 0

							IF HAS_PICKUP_BEEN_COLLECTED securicar_pickup
								import_car_type = 118
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED moonbeam_pickup
								import_car_type = 108
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED coach_pickup
								import_car_type = 127
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED flatbed_pickup
								import_car_type = 145
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED linerunner_pickup
								import_car_type = 93
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED trashmaster_pickup
								import_car_type = 98
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED patriot_pickup
								import_car_type = 96
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED whoopee_pickup
								import_car_type = 113 
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED blista_pickup
								import_car_type = 102
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED mule_pickup
								import_car_type = 104
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED yankee_pickup
								import_car_type = 146
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED bobcat_pickup
								import_car_type = 112
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED dodo_pickup
								import_car_type = 126
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED bus_pickup
								import_car_type = 121
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED rumpo_pickup
								import_car_type = 130
								GOTO load_vehicle
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED pony_pickup
								import_car_type = 103
								GOTO load_vehicle
							ENDIF
					
							GOTO pick_up_pick_ups

				load_vehicle:

							PRINT_NOW (IMPORT1) 5000 2
							GOSUB mission_remove_pickups_ind

							IF IS_PLAYER_PLAYING player
								WHILE NOT IS_PLAYER_IN_AREA_2D player 1486.9 -686.2 1495.5 -674.1 FALSE
									WAIT 0
 									IF IS_PLAYER_PLAYING player

									ENDIF
								ENDWHILE
							ENDIF

							IF IS_PLAYER_PLAYING player
								SET_PLAYER_CONTROL Player Off
							ENDIF

							CLOSE_GARAGE collect_all_cars1

							WHILE NOT IS_GARAGE_CLOSED collect_all_cars1
								WAIT 0

							ENDWHILE

							REQUEST_MODEL import_car_type

							WHILE NOT HAS_MODEL_LOADED import_car_type
								WAIT 0

							ENDWHILE 

							CREATE_CAR import_car_type 1504.1 -680.1 12.1 imported_car
							MARK_MODEL_AS_NO_LONGER_NEEDED import_car_type
							SET_CAR_HEADING imported_car 90.0
							LOCK_CAR_DOORS imported_car CARLOCK_UNLOCKED
							WAIT 1000
							OPEN_GARAGE collect_all_cars1
							IF IS_PLAYER_PLAYING Player
								SET_PLAYER_CONTROL Player On
							ENDIF
							import_car_been_created_before = 1

						 ENDIF	//	IF import_car_been_created_before = 0

					ELSE	//	player not in area (1486.9 -686.2 1524.1 -666.8)

						IF create_car_pickups_industrial = 1
							CLOSE_GARAGE collect_all_cars1
								WHILE NOT IS_GARAGE_CLOSED collect_all_cars1
									WAIT 0

								ENDWHILE

							GOSUB mission_remove_pickups_ind

							IF import_car_been_created_before = 1
								IF NOT IS_CAR_DEAD imported_car
									IF IS_CAR_IN_AREA_2D imported_car 1496.8 -686.2 1523.3 -666.8 FALSE
										DELETE_CAR imported_car
		 							ELSE
										MARK_CAR_AS_NO_LONGER_NEEDED imported_car
									ENDIF
								ENDIF
							ENDIF

							import_car_been_created_before = 0
							create_car_pickups_industrial = 0
						ENDIF

					ENDIF //IS_PLAYER_IN_AREA_2D 

				ENDIF //IS_PLAYER_PLAYING

			ENDIF //IF industrial_garage_slots = 16

		ENDIF	//	IF IS_PLAYER_IN_ZONE player PORT_E

	ENDIF	//	IF IS_PLAYER_PLAYING Player

	GOTO import1_loop_inner
}


military_crane_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME M_CRANE

military_crane_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING Player

		IF IS_PLAYER_IN_AREA_2D player 1548.1 -745.5 1583.0 -675.1 FALSE 

			IF HAS_MILITARY_CRANE_COLLECTED_ALL_CARS
					
				IF cran_activated_before = 0
					DEACTIVATE_CRANE 1570.3 -675.4
					ACTIVATE_CRANE 1570.3 -675.4 1638.7 -687.1 1647.9 -700.1 1571.1 -696.5 16.0 0.0
					ADD_SCORE player 200000
					PLAYER_MADE_PROGRESS 7
					cran_activated_before = 1
				ENDIF

				IF NOT IS_AREA_OCCUPIED 1565.9 -706.7 9.0 1577.2 -686.3 20.0 FALSE TRUE FALSE FALSE FALSE
					IF create_military_pickups = 0
					AND military_car_been_created_before = 0
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 39 1571.0 -687.0 11.8 copcar_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 35 1571.0 -691.0 11.8 swatvan_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 36 1571.0 -694.0 11.8 fbi_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 37 1571.0 -697.0 11.8 tank_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 38 1571.0 -700.0 11.8 barracks_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 34 1571.0 -703.0 11.8 ambulance_pickup
						CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 33 1571.0 -706.0 11.8 firetruck_pickup
						create_military_pickups = 1
					ENDIF
				ENDIF
					
					//IF IS_PLAYER_IN_AREA_2D player 1558.1 -716.4 1583.0 -675.1 FALSE

				IF military_car_been_created_before = 0
			
					IF HAS_PICKUP_BEEN_COLLECTED copcar_pickup
						military_car_type3 = 116
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED swatvan_pickup
						military_car_type3 = 117
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED fbi_pickup
						military_car_type3 = 107
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED barracks_pickup
						military_car_type3 = 123
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED tank_pickup
						military_car_type3 = 122
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED ambulance_pickup
						military_car_type3 = 106
						GOTO load_vehicle3
					ENDIF

					IF HAS_PICKUP_BEEN_COLLECTED firetruck_pickup 
						military_car_type3 = 97
						GOTO load_vehicle3
					ENDIF

					GOTO military_crane_loop_inner //pick_up_pick_ups3

				load_vehicle3:

					GOSUB mission_remove_pickups_military

					REQUEST_MODEL military_car_type3

					WHILE NOT HAS_MODEL_LOADED military_car_type3
						WAIT 0

					ENDWHILE 

					CREATE_CAR military_car_type3 1643.2 -693.2 -100.0 military_car
					MARK_MODEL_AS_NO_LONGER_NEEDED military_car_type3
					SET_CAR_HEADING military_car 0.0
					LOCK_CAR_DOORS military_car CARLOCK_UNLOCKED

					military_car_been_created_before = 1

				ENDIF

			ENDIF	//	IF HAS_MILITARY_CRANE_COLLECTED_ALL_CARS
			
		ELSE	

			IF create_military_pickups = 1
				GOSUB mission_remove_pickups_military
				create_military_pickups = 0
			ENDIF

			IF IS_PLAYER_PLAYING player

				IF military_car_been_created_before = 1

					IF IS_CAR_DEAD military_car
						military_car_been_created_before = 0
					ELSE
						IF NOT IS_CAR_IN_AREA_2D military_car 1668.6 -685.7 1548.1 -745.5 FALSE
							MARK_CAR_AS_NO_LONGER_NEEDED military_car
							military_car_been_created_before = 0
						ENDIF

						IF NOT IS_PLAYER_IN_ZONE player PORT_E
							MARK_CAR_AS_NO_LONGER_NEEDED military_car
							military_car_been_created_before = 0
						ENDIF
					ENDIF
	
				ENDIF

			ENDIF

		ENDIF	//	IF IS_PLAYER_IN_ZONE player PORT_E

	ENDIF //IS_PLAYER_PLAYING

	GOTO military_crane_loop_inner
}


import2_loop:
{
//	Should be called in mission_import_start

	SCRIPT_NAME IMPORT2

import2_loop_inner:

	WAIT 500

	IF IS_PLAYER_PLAYING Player

//IMPORT EXPORT GARAGE2***************************************************************************************

		IF IS_PLAYER_IN_ZONE player BIG_DAM

			IF NOT suburban_garage_slots_filled = 16

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 1
				AND suburban_slot1 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 60.529 sentinet_score_off
					DONT_REMOVE_OBJECT sentinet_score_off
					SET_OBJECT_HEADING sentinet_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot1 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 2
				AND suburban_slot2 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 60.332 cheetah_score_off
					DONT_REMOVE_OBJECT cheetah_score_off
					SET_OBJECT_HEADING cheetah_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot2 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 3
				AND suburban_slot3 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 60.127 banshee_score_off
					DONT_REMOVE_OBJECT banshee_score_off
					SET_OBJECT_HEADING banshee_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot3 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 4
				AND suburban_slot4 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 59.919 idaho_score_off
					DONT_REMOVE_OBJECT idaho_score_off
					SET_OBJECT_HEADING idaho_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot4 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 5
				AND suburban_slot5 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 59.697 infernus_score_off
					DONT_REMOVE_OBJECT infernus_score_off
					SET_OBJECT_HEADING infernus_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot5 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 6
				AND suburban_slot6 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 59.497 taxi_score_off
					DONT_REMOVE_OBJECT taxi_score_off
					SET_OBJECT_HEADING taxi_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot6 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 7
				AND suburban_slot7 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 59.298 kuruma_score_off
					DONT_REMOVE_OBJECT kuruma_score_off
					SET_OBJECT_HEADING kuruma_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot7 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 8
				AND suburban_slot8 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1106.161 151.191 59.079 stretch_score_off
					DONT_REMOVE_OBJECT stretch_score_off
					SET_OBJECT_HEADING stretch_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot8 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 9
				AND suburban_slot9 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 60.529 perennial_score_off
					DONT_REMOVE_OBJECT perennial_score_off
					SET_OBJECT_HEADING perennial_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot9 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 10
				AND suburban_slot10 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 60.309 stinger_score_off
					DONT_REMOVE_OBJECT stinger_score_off
					SET_OBJECT_HEADING stinger_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot10 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 11
				AND suburban_slot11 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 60.098 manana_score_off
					DONT_REMOVE_OBJECT manana_score_off
					SET_OBJECT_HEADING manana_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot11 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 12
				AND suburban_slot12 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 59.919 landstalker_score_off
					DONT_REMOVE_OBJECT landstalker_score_off
					SET_OBJECT_HEADING landstalker_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot12 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 13
				AND suburban_slot13 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 59.697 stallion_score_off
					DONT_REMOVE_OBJECT stallion_score_off
					SET_OBJECT_HEADING stallion_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot13 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 14
				AND suburban_slot14 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 59.497 injection_score_off
					DONT_REMOVE_OBJECT injection_score_off
					SET_OBJECT_HEADING injection_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot14 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 15
				AND suburban_slot15 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 59.298 cabbie_score_off
					DONT_REMOVE_OBJECT cabbie_score_off
					SET_OBJECT_HEADING cabbie_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot15 = 1 
				ENDIF

				IF HAS_IMPORT_GARAGE_SLOT_BEEN_FILLED collect_all_cars2 16
				AND suburban_slot16 = 0
					suburban_garage_slots_filled ++
					CREATE_OBJECT_NO_OFFSET line -1107.042 151.191 59.079 esperanto_score_off
					DONT_REMOVE_OBJECT esperanto_score_off
					SET_OBJECT_HEADING esperanto_score_off 180.0
					PLAYER_MADE_PROGRESS 1
					suburban_slot16 = 1 
				ENDIF
			ELSE
		//IF suburban_garage_slots_filled = 16

				IF changed_suburban_garage_before = 0
					CHANGE_GARAGE_TYPE collect_all_cars2 GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE
					changed_suburban_garage_before = 1
				ENDIF

		pick_up_pick_ups2:
				WAIT 0

				IF IS_PLAYER_PLAYING player

					IF IS_PLAYER_IN_AREA_2D player -1117.4 158.1 -1098.0 121.5 FALSE
					
						IF create_car_pickups_suburban = 0
							
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 17 -1115.0 145.5 59.0 sentinet_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 18 -1115.0 142.0 59.0 cheetah_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 19 -1115.0 138.5 59.0 banshee_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 20 -1115.0 135.0 59.0 idaho_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 21 -1115.0 131.5 59.0 infernus_pickup
							 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 22 -1115.0 128.0 59.0 taxi_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 23 -1112.0 128.0 59.0 kuruma_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 24 -1109.0 128.0 59.0 stretch_pickup	 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 25 -1106.0 128.0 59.0 perennial_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 26 -1103.0 128.0 59.0 stinger_pickup
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 27 -1100.0 128.0 59.0 manana_pickup
						 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 28 -1100.0 131.5 59.0 landstalker_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 29 -1100.0 135.0 59.0 stallion_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 30 -1100.0 138.5 59.0 injection_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 31 -1100.0 142.0 59.0 cabbie_pickup 
							CREATE_PICKUP_WITH_AMMO bonus PICKUP_ONCE 32 -1100.0 145.5 59.0 esperanto_pickup

							WAIT 1000
							OPEN_GARAGE collect_all_cars2
							create_car_pickups_suburban = 1
							
						ENDIF
					
								
						IF import_car_been_created_before2 = 0

							IF HAS_PICKUP_BEEN_COLLECTED sentinet_pickup
								import_car_type2 = 95
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED cheetah_pickup
								import_car_type2 = 105
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED banshee_pickup
								import_car_type2 = 119
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED idaho_pickup
								import_car_type2 = 91
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED infernus_pickup
								import_car_type2 = 101
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED taxi_pickup
								import_car_type2 = 110
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED kuruma_pickup
								import_car_type2 = 111 
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED stretch_pickup
								import_car_type2 = 99 
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED perennial_pickup
								import_car_type2 = 94
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED stinger_pickup
								import_car_type2 = 92
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED manana_pickup
								import_car_type2 = 100
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED landstalker_pickup
								import_car_type2 = 90
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED stallion_pickup
								import_car_type2 = 129
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED injection_pickup
								import_car_type2 = 114
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED cabbie_pickup
								import_car_type2 = 128
								GOTO load_vehicle2
							ENDIF

							IF HAS_PICKUP_BEEN_COLLECTED esperanto_pickup
								import_car_type2 = 109
								GOTO load_vehicle2
							ENDIF

							GOTO pick_up_pick_ups2

				load_vehicle2:

							PRINT_NOW (IMPORT1) 5000 2
							GOSUB mission_remove_pickups_sub

							IF IS_PLAYER_PLAYING player
								WHILE NOT IS_PLAYER_IN_AREA_2D player -1117.4 158.1 -1105.0 150.9 FALSE
									WAIT 0
	 								IF IS_PLAYER_PLAYING player

									ENDIF
								ENDWHILE
							ENDIF

							IF IS_PLAYER_PLAYING player
								SET_PLAYER_CONTROL Player Off
							ENDIF

							CLOSE_GARAGE collect_all_cars2

							WHILE NOT IS_GARAGE_CLOSED collect_all_cars2
								WAIT 0

							ENDWHILE

							REQUEST_MODEL import_car_type2

							WHILE NOT HAS_MODEL_LOADED import_car_type2
								WAIT 0

							ENDWHILE 

							CREATE_CAR import_car_type2 -1112.0 143.2 59.0 imported_car2
							MARK_MODEL_AS_NO_LONGER_NEEDED import_car_type2
							SET_CAR_HEADING imported_car2 0.0
							LOCK_CAR_DOORS imported_car2 CARLOCK_UNLOCKED
							WAIT 1000
							OPEN_GARAGE collect_all_cars2
							IF IS_PLAYER_PLAYING Player
								SET_PLAYER_CONTROL Player On
							ENDIF
							import_car_been_created_before2 = 1

						ENDIF	//	IF import_car_been_created_before2 = 0

					ELSE	//	player not in area (-1117.4 158.1 -1098.0 121.5)

						IF create_car_pickups_suburban = 1
							CLOSE_GARAGE collect_all_cars2
								WHILE NOT IS_GARAGE_CLOSED collect_all_cars2
									WAIT 0

								ENDWHILE

							GOSUB mission_remove_pickups_sub

							IF import_car_been_created_before2 = 1
								IF NOT IS_CAR_DEAD imported_car2
									IF IS_CAR_IN_AREA_2D imported_car2 -1117.4 149.8 -1098.0 121.5 FALSE
										DELETE_CAR imported_car2
		 							ELSE
										MARK_CAR_AS_NO_LONGER_NEEDED imported_car2
									ENDIF
								ENDIF
							ENDIF

							import_car_been_created_before2 = 0
							create_car_pickups_suburban = 0
						ENDIF

					ENDIF //IS_PLAYER_IN_AREA_2D 

				ENDIF //IS_PLAYER_PLAYING

			ENDIF	//	IF NOT suburban_garage_slots_filled = 16

		ENDIF	//	IF IS_PLAYER_IN_ZONE player BIG_DAM

	ENDIF //IS_PLAYER_PLAYING

	GOTO import2_loop_inner
}


check_packages:
{
//	Should be called in mission_import_start

	SCRIPT_NAME PACKAGE

	WAIT 300

	GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected

	WHILE number_of_packages_collected < 10
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB1 ) 140 2 0
	earned_free_pistol = 1

	WHILE number_of_packages_collected < 20
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB2 ) 140 2 0
	earned_free_uzi = 1

	WHILE number_of_packages_collected < 30
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB5 ) 140 2 0
	earned_free_grenades = 1

	WHILE number_of_packages_collected < 40
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB4 ) 140 2 0
	earned_free_shotgun = 1

	WHILE number_of_packages_collected < 50
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB3 ) 140 2 0
	earned_free_armour = 1
	
	WHILE number_of_packages_collected < 60
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB6 ) 140 2 0
	earned_free_molotovs = 1

	WHILE number_of_packages_collected < 70
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB7 ) 140 2 0
	earned_free_ak47 = 1

	WHILE number_of_packages_collected < 80
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB8 ) 140 2 0
	earned_free_sniper = 1

	WHILE number_of_packages_collected < 90
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB9 ) 140 2 0
	earned_free_m16 = 1

	WHILE number_of_packages_collected < 100
		WAIT 500
		GET_COLLECTABLE1S_COLLECTED	number_of_packages_collected
	ENDWHILE

	PLAYER_MADE_PROGRESS 1
	ADD_PAGER_MESSAGE ( PAGEB10 ) 140 2 0
	earned_free_launcher = 1

	TERMINATE_THIS_SCRIPT
}

mission_remove_pickups_ind:
{

	REMOVE_PICKUP securicar_pickup
	REMOVE_PICKUP moonbeam_pickup
	REMOVE_PICKUP coach_pickup
	REMOVE_PICKUP flatbed_pickup 
	REMOVE_PICKUP linerunner_pickup
	REMOVE_PICKUP trashmaster_pickup
	REMOVE_PICKUP patriot_pickup
	REMOVE_PICKUP whoopee_pickup
	REMOVE_PICKUP blista_pickup
	REMOVE_PICKUP mule_pickup
	REMOVE_PICKUP yankee_pickup
	REMOVE_PICKUP bobcat_pickup
	REMOVE_PICKUP dodo_pickup
	REMOVE_PICKUP bus_pickup
	REMOVE_PICKUP rumpo_pickup
	REMOVE_PICKUP pony_pickup

}

RETURN

mission_remove_pickups_sub:
{

	REMOVE_PICKUP sentinet_pickup
	REMOVE_PICKUP cheetah_pickup
	REMOVE_PICKUP banshee_pickup
	REMOVE_PICKUP idaho_pickup
	REMOVE_PICKUP infernus_pickup
	REMOVE_PICKUP taxi_pickup
	REMOVE_PICKUP kuruma_pickup
	REMOVE_PICKUP stretch_pickup
	REMOVE_PICKUP perennial_pickup
	REMOVE_PICKUP stinger_pickup
	REMOVE_PICKUP manana_pickup
	REMOVE_PICKUP landstalker_pickup
	REMOVE_PICKUP stallion_pickup
	REMOVE_PICKUP injection_pickup
	REMOVE_PICKUP cabbie_pickup
	REMOVE_PICKUP esperanto_pickup
}

RETURN


mission_remove_pickups_military:
{

	REMOVE_PICKUP copcar_pickup 
	REMOVE_PICKUP swatvan_pickup 
	REMOVE_PICKUP fbi_pickup
	REMOVE_PICKUP tank_pickup
	REMOVE_PICKUP barracks_pickup
	REMOVE_PICKUP ambulance_pickup
	REMOVE_PICKUP firetruck_pickup
}

RETURN

remove_bonus_pickups:
{

	REMOVE_PICKUP bonus_gun1		
	REMOVE_PICKUP bonus_gun2		
	REMOVE_PICKUP bonus_gun3		
	REMOVE_PICKUP bonus_gun4		
	REMOVE_PICKUP bonus_gun5		
	REMOVE_PICKUP bonus_gun6		
	REMOVE_PICKUP bonus_gun7		
	REMOVE_PICKUP bonus_gun8		
	REMOVE_PICKUP bonus_gun9
	REMOVE_PICKUP bonus_gunflame	
	REMOVE_PICKUP bonus_gun10
	REMOVE_PICKUP bonus_bribe1
	REMOVE_PICKUP bonus_bribe2
	REMOVE_PICKUP bonus_bribe3
	REMOVE_PICKUP bonus_bribe4
	REMOVE_PICKUP bonus_bribe5
	REMOVE_PICKUP bonus_bribe6
	REMOVE_PICKUP bonus_health
	REMOVE_PICKUP bonus_adrenaline
}

RETURN


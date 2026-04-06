// *************************************UPSTATE LIBERTY PICKUPS***************************
// Authors:
// .HAYA
// Adi

ul_pickups:

VAR_INT lcc_t1_weapon1, lcc_t1_weapon2, lcc_t1_weapon3, lcc_t1_pickup1, lcc_t1_pickup2, lcc_t1_pickup3, lcc_t1_pickup4
VAR_INT lcc_t2_weapon1, lcc_t2_pickup1, lcc_t2_pickup2, lcc_t2_pickup3, lcc_t2_pickup4, lcc_t2_pickup5, lcc_t2_pickup6
VAR_INT lcc_t3_weapon1, lcc_t3_weapon2, lcc_t3_pickup1, lcc_t3_pickup2, lcc_t3_pickup3, lcc_t3_pickup4
VAR_INT lcc_weapon1, lcc_weapon2, lcc_weapon3, lcc_weapon4, lcc_weapon5
VAR_INT lcc_pickup1, lcc_pickup2, lcc_pickup3, lcc_pickup4, lcc_pickup5, lcc_pickup6, lcc_pickup7, lcc_pickup8, lcc_pickup9, lcc_pickup10, lcc_pickup11, lcc_pickup12, lcc_pickup13, lcc_pickup14
VAR_INT gtw_weapon1, gtw_weapon2, gtw_weapon3, gtw_weapon4, gtw_weapon5, gtw_weapon6, gtw_weapon7, gtw_weapon8, gtw_weapon9, gtw_weapon10, gtw_weapon11
VAR_INT gtw_pickup1, gtw_pickup2, gtw_pickup3, gtw_pickup4, gtw_pickup5, gtw_pickup6, gtw_pickup7, gtw_pickup8, gtw_pickup9, gtw_pickup10, gtw_pickup11, gtw_pickup12
VAR_INT SHOP_UL_T1_UZI, SHOP_UL_T1_AK47, SHOP_UL_T1_MOLOTOV
VAR_INT SHOP_UL_T3_UZI, SHOP_UL_T3_AK47, SHOP_UL_T3_SHOTGUN, SHOP_UL_T3_SNIPER, SHOP_UL_T3_GRENADE, SHOP_UL_T3_M16, SHOP_UL_T3_ARMOUR
VAR_INT SHOP_UL_GT_UZI, SHOP_UL_GT_SHOTGUN, SHOP_UL_GT_ARMOUR, SHOP_UL_GT_SNIPER, SHOP_UL_GT_GRENADE, SHOP_UL_GT_AK47

// AMMUNATION

CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP -1376.0829 1532.6038 72.2802 SHOP_UL_T1_UZI
CREATE_PICKUP WEAPON_AK47 PICKUP_IN_SHOP -1373.1376 1532.9557 72.2802 SHOP_UL_T1_AK47
CREATE_PICKUP WEAPON_MOLOTOV PICKUP_IN_SHOP -1372.7124 1529.1749 72.2802 SHOP_UL_T1_MOLOTOV

CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP 557.8594 1329.1218 132.0183 SHOP_UL_T3_UZI
CREATE_PICKUP WEAPON_AK47 PICKUP_IN_SHOP 552.405 1326.2581 132.0183 SHOP_UL_T3_AK47
CREATE_PICKUP WEAPON_SHOTGUN PICKUP_IN_SHOP 561.3328 1327.9377 136.0183 SHOP_UL_T3_SHOTGUN
CREATE_PICKUP WEAPON_SNIPER PICKUP_IN_SHOP 558.9524 1328.5754 136.0183 SHOP_UL_T3_SNIPER
CREATE_PICKUP WEAPON_GRENADE PICKUP_IN_SHOP 552.9682 1327.464 136.0183 SHOP_UL_T3_GRENADE
CREATE_PICKUP WEAPON_M16 PICKUP_IN_SHOP 551.9947 1324.5756 136.0183 SHOP_UL_T3_M16
CREATE_PICKUP bodyarmour PICKUP_IN_SHOP 554.8279 1323.0676 136.0183 SHOP_UL_T3_ARMOUR

CREATE_PICKUP WEAPON_UZI PICKUP_IN_SHOP 1579.6013 1364.1223 134.8131 SHOP_UL_GT_UZI
CREATE_PICKUP WEAPON_SHOTGUN PICKUP_IN_SHOP 1579.7145 1366.5048 134.8131 SHOP_UL_GT_SHOTGUN
CREATE_PICKUP bodyarmour PICKUP_IN_SHOP 1588.7385 1363.8788 134.8131 SHOP_UL_GT_ARMOUR
CREATE_PICKUP WEAPON_SNIPER PICKUP_IN_SHOP 1585.8866 1367.5844 134.8131 SHOP_UL_GT_SNIPER
CREATE_PICKUP WEAPON_GRENADE PICKUP_IN_SHOP 1589.1194 1367.5863 134.8131 SHOP_UL_GT_GRENADE
CREATE_PICKUP WEAPON_AK47 PICKUP_IN_SHOP 1582.1691 1368.1613 134.8131 SHOP_UL_GT_AK47

// UL PICKUPS - SORTED BY AREAS - PLACED BY .HAYA


// Baxter

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 5 -1441.1790 1712.7620 80.2928 lcc_t1_weapon1 //Sniper Rifle - On the rooftops of one of the buildings at the cul-de-sac, requires on foot parkour to get there
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 -1831.5110 1647.7930 97.0645 lcc_t1_weapon2 //Shotgun - In front of a hidden barn next to the tunnel, northwest from Town 1
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 -1301.6040 1553.1790 71.0529 lcc_t1_weapon3 //Uzi - In front of small garage at the back of Police Staion
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1349.1960 1556.9650 72.5302 lcc_t1_pickup1 //Inside Happy Blimp, southern part of the town
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1492.2520 1734.9680 73.2802 lcc_t1_pickup2 //At the cul-de-sac, in front of pink house, north-west part of the town
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1825.7080 1645.5520 78.3561 lcc_t1_pickup3 //In the corner on rubbish of tunnel west from Town 1
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -1214.3500 1501.4170 71.9238 lcc_t1_pickup4 //In the trailer park located in south-east part of the town


// Warsaw

//Weapons
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET -191.4619 1513.5410 112.4055 lcc_t2_weapon1 //Baseball Bat - In the trailer park at north-east corner of the town
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -267.8557 1353.3440 112.3761 lcc_t2_pickup1 //On the doorstep of Wyckoff Hosptial
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -531.5046 1395.9990 114.1257 lcc_t2_pickup2 //On the house patio, west-center part of the town
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -23.9286 1459.7140 140.6608 lcc_t2_pickup3 //Inside a barn, north-east edge of the town
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -578.6509 1179.7390 112.6230 lcc_t2_pickup4 //Southwest from the Town 2 under small bridge
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -443.6569 1424.3010 111.7122 lcc_t2_pickup5 //In the middle of long suburbs alleyway, north-west part of the town
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -308.4047 1335.7400 112.3761 lcc_t2_pickup6 //Behind Wyckoff Hospital


// Carrington

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 387.2297 1488.2222 146.998 lcc_t3_weapon1 //Uzi - At northern border of Town 3, inside a orange barn upstairs, in between hay
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 473.2342 1190.7930 144.0179 lcc_t3_weapon2 //AK47 - On the tallest roof at the motel complex (requires tricky on foot parkour to obtain it, not too difficult but well hidden) 
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 531.5450 1236.3750 132.2681 lcc_t3_pickup1 //In front of the Hospital door
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 438.2643 988.0662 127.7142 lcc_t3_pickup2 //In the south, next to the wooden cabin, in small park surrounded by water
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 590.5299 1477.9210 144.7233 lcc_t3_pickup3 //On rooftop of red barn northern from Town 3
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 555.1644 1182.3420 136.2681 lcc_t3_pickup4 //One block south from the police station, behind the building on the edge of balcony


// Countryside (Countryside + Love Estate)

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 -1516.9050 927.5119 122.6803 lcc_weapon1 //Colt 45 - On small rooftop of Love Estate Golf Course
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 300 -53.6648 1827.9560 145.2748 lcc_weapon2 //Flamethrower - Hidden deep inside the abandoned mines
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 -314.2549 832.2250 167.1317 lcc_weapon3 //Molotov Cocktails - On the eastern part of the mountain right behind the lonely cabin
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 300 -439.5469 723.5470 245.2319 lcc_weapon4 //Flamethrower - On top of the mountain/observatory area, right below the wooden outlook post, requires a bit of hassle to walk through steep cliff collision
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 90 -1422.5000 712.6121 88.8691 lcc_weapon5 //M16 - Love Estate, the hardest pickup to obtain in entire UL, one the rooftop of mansion right below the Golf Course, the one where police bribe stunt jump points at. Very challenging to obtain, requires well timed sprint jump from the cliff at Golf Course border, right on the corner of the rooftop.

//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -500.0966 887.8223 251.2389 lcc_pickup1 //On top of the mountain, right in front of MSX FM station hut
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1536.4400 932.7610 115.7678 lcc_pickup2 //Under the staircase of Love Estate Golf Course
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1643.2010 1071.1190 120.7586 lcc_pickup3 //In front of two garages in Love Estate, located one block north from northwest corner of Golf Course
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1690.2820 625.9310 109.1501 lcc_pickup4 // In southern part of Love Estate, in one of the empty pools behind the house
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1264.1080 1345.3000 72.1951 lcc_pickup5 //South from the Town 1, behind gas station
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1272.4340 903.6516 66.6860 lcc_pickup6 //South from Love Estate at the jetty, behind the small ledge
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -11.0114 907.3554 140.8428 lcc_pickup7 //In the sawmill area, in between logs
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -735.2781 1809.2446 147.6188 lcc_pickup8 //Inside the haunted house
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 584.6691 1549.5520 152.2641 lcc_pickup9 //North from the Town 3, at the jump on the edge of scrapyard
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 213.7393 930.9748 123.8425 lcc_pickup10 //Below the road in underground tunnel, south-west from Town 3
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -973.8750 995.0899 112.6876 lcc_pickup11 //On the arch of a bridge, bridge in question is located right from exiting the tunnel closest to Chocolate Dam
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1458.6800 783.4966 105.8130 lcc_pickup12 //On the grass jump at Love Estate Golf Course
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -781.7514 1696.4580 145.5832 lcc_pickup13 //In between Town 1 and Town 2, on the broken wooden bridge
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1005.0990 921.1160 97.0819 lcc_pickup14 //At the northeastern part of the dirt track, requires a jump


// Gostburg

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 1325.5890 793.7258 28.5045 gtw_weapon1 //Shotgun - Inside the cave from the hidden scary cabin
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 90 1008.5310 1451.8170 156.8130 gtw_weapon2 //M16 - On the tallest building accessible through rooftop parkour, requires one of 3 fastest cars to obtain it
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 1176.8210 1583.5770 142.1532 gtw_weapon3 //AK47 - In the hanging semi open container from crane next to construction site
CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 4 1333.8530 1784.6890 126.5630 gtw_weapon4 //Rocket Launcher - North from the Ghostburg inside the unfinished tunnel, drop down onto a metal beam from top of the tunnel
CREATE_PICKUP_WITH_AMMO GRENADE PICKUP_ON_STREET_SLOW 10 1502.2840 1372.6880 117.7010 gtw_weapon5 //Grenades - Inside the sewers underground, in the bank safe (Fun Fact: Grenades do not appear anywhere on the map in freemode of vanilla GTA3)
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 1727.6350 1838.9190 141.7285 gtw_weapon6 //Colt 45 - At the Fire Department station in airport
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 5  1663.9550 1295.0190 157.7634 gtw_weapon7 //Sniper Rifle - On the accesible rooftops, right in the same area as Adrenaline pill ($GTW_PICKUP12)
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 1330.6110 1678.9430 121.8135 gtw_weapon8 //Molotov Cocktails - Right behind Wang Cars in corner of garage doors
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 1178.3800 1208.7370 129.1588 gtw_weapon9 //Uzi - One the rooftop of Pay 'n Spray
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET 1361.5320 1082.3460 122.5276 gtw_weapon10 //Baseball Bat - In the german buildings section, easy to spot
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 1465.4710 1094.5430 122.5273 gtw_weapon11 //Colt 45 - In the german buildings section, in between small alley
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1524.5830 1442.5410 126.6207 gtw_pickup1 //In the iconic alley from GTA3 intro cutscene
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1349.1710 1462.4180 127.0634 gtw_pickup2 //In front of the Ghostburg Hospital
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1298.5620 964.2830 119.5409 gtw_pickup3 //On top of the ramp in the skatepark
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1722.4580 1318.6980 124.7959 gtw_pickup4 //In small grass pool in the middle or two tall buildings, a bit east from centre of the city
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1232.3420 1638.5060 118.3614 gtw_pickup5 //Inside the closed of pipe at construction site
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1689.8460 1612.5830 131.7101 gtw_pickup6 //Right behind the funny plane eating burger, south from the airport terminal
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1810.1120 1343.8420 123.1932 gtw_pickup7 //In front of closed garage behind the two smaller hexagonal buildings, in east part of the city
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1588.4530 1368.9580 123.9967 gtw_pickup8 //On the staircase in underground of white mall
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1054.5010 1342.0210 150.5407 gtw_pickup9 //At the rooftop parkour section, high above the road
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1214.8240 1598.5450 125.9514 gtw_pickup10 //Inside a big pipe at construction site
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1632.3630 1273.6420 151.7632 gtw_pickup11 //On the building you can climb on top of by series of staircases (offices)
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1276.2980 1161.0170 127.5273 gtw_pickup12 //On top of the staircase in some neighbourhood (blocks) 

RETURN
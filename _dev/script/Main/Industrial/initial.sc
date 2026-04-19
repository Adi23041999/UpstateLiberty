MISSION_START

SCRIPT_NAME initial
{

// *****************************************PICK_UPS**************************************************

VAR_INT ind_pickup1	ind_pickup2 ind_pickup3 ind_pickup4	ind_pickup5 ind_pickup6 ind_pickup7 ind_pickup8 ind_pickup9 ind_pickup10
VAR_INT ind_pickup11 ind_pickup12 ind_pickup13 ind_pickup14	ind_pickup15 ind_pickup16 ind_pickup17 ind_pickup18 ind_pickup19 ind_pickup20
VAR_INT ind_pickup21 ind_pickup22 ind_pickup23 ind_pickup24	ind_pickup25 ind_pickup26 ind_pickup27 ind_pickup28	ind_pickup29 ind_pickup30
VAR_INT ind_pickup31 ind_pickup32 ind_pickup33 ind_pickup34	ind_pickup35 ind_pickup36 ind_pickup37 ind_pickup38 ind_pickup39 ind_pickup40
VAR_INT	info_pickup1 info_pickup2 info_pickup3 info_pickup4 info_pickup5 info_pickup6 ind_pickup41 //ind_pickup42 ind_pickup43 ind_pickup44
//VAR_INT ind_pickup45 ind_pickup46 ind_pickup47 ind_pickup48 ind_pickup49
VAR_INT	info_pickup7a info_pickup7b info_pickup8 info_pickup9 info_pickup10a info_pickup10b info_pickup10c
VAR_INT FREE_BASEBALLBAT1, FREE_BASEBALLBAT2, FREE_BASEBALLBAT3

current_time = 0
time_since_murdering_shopkeeper1 = -60000

out_of_stock_uzi = 0
out_of_stock_pistol = 0

//INDUSTRIAL********************************************************************************

//WEAPONS
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET 883.5 -302.1 8.0 FREE_BASEBALLBAT1	//PLAYERS SAVE HOUSE INDUSTRIAL
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 1249.0 -858.5 20.6 ind_pickup1 //Liberty Pharmaceuticals (roof)
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 150 1018.3 -30.8 22.5 ind_pickup2 //Radio station (roof)
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 10 1217.3 -255.2 33.1 ind_pickup3 //Little Italy behind park (rooftop)
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 10 939.0 -113.3 3.7 ind_pickup4 //Behind Hepburn heights (far North)
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 1138.7 -1035.5 20.2 ind_pickup5	//Saw mill roof
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 1309.5 -380.9 40.2 ind_pickup6 //Little Italy (back alley
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 1224.8 141.9 9.3 ind_pickup7 //Far North (south of little rocky island)
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 1017.6 -960.9 21.2 ind_pickup39 //On ledge at the bottom of Callahan bridge
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 120 1253.6578 -314.1173 34.1 ind_pickup40 //Behind Toni's

//HEALTH
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1147.8 -597.1 14.9 ind_pickup8 //Hospital industial
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1147.8 -585.3 14.9 ind_pickup9 //Hospital industial
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1252.8 -854.7 20.6 ind_pickup10 //Liberty Pharmaceuticals (roof)
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 822.5 -1048.7 14.3 ind_pickup11 //Far south (west of fish factory)
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 918.0 -735.9 14.6 ind_pickup12 //Alleyway at market place
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1391.1 -1023.5 11.9 ind_pickup13 //Behind lorry jump in the docks
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1282.8 -815.4 15.0 ind_pickup14 //Near Meat factory
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1267.6 -296.6 39.9 ind_pickup32 //Behind Tonis
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1141.8 -63.0 7.4 ind_pickup33 //Petrol station
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 938.5 -181.9 4.9 ind_pickup34 //Hepburn Heights
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 972.9 -413.2 15.1 ind_pickup35 //Donkey porn alleyway
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1387.7 -456.5 49.6 ind_pickup36 //Opposite Marcos Bistro

//ARMOUR
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1116.4 -1237.4 11.9 ind_pickup15 //Far south industrail jetty
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1250.2 -852.0 20.6 ind_pickup16 //Liberty Pharmaceuticals (roof)
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1588.9 -624.0 11.8 ind_pickup17 //Docks (old smack ma bitch up area)
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1236.0 -920.6 15.1 ind_pickup18 //Behind buildings by Joeys garage
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1138.7 -1033.5 20.2 ind_pickup38 //Saw mill roof
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1253.6578 -317.9105 34.1 ind_pickup41 //Behind Toni's

//ADRENALINE
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1394.6 -865.4 11.8 ind_pickup19 //Docks (behind cabins)
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1087.5 -156.5 9.8 ind_pickup20 //Garages near petrol station
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1247.1 -855.1 20.6 ind_pickup21 //Liberty Pharmaceuticals (roof)
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 878.3 -521.3 16.5 ind_pickup22 //Fish place north chinatown
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1161.1 -546.9 21.5 ind_pickup37 //Hospital industial

//POLICE BRIBES
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 790.0 -560.7 27.0 ind_pickup23 //Over water front jump
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1283.7 -388.7 34.6 ind_pickup24 //Long back alleyway (St Marks)
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1440.2 -891.1 11.8 ind_pickup25 //Under large crane next to columbian boat
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1078.9 -912.5 15.2 ind_pickup27 //Alley way between Trenton and Chinatown
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 995.8 -438.8 22.7 ind_pickup28 //Railway line (redlight)
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1061.9 -567.7 16.6 ind_pickup29 //Alley way between redlight and Chinatown
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 859.6 -981.9 10.5 ind_pickup30 //On Greasy Joes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 922.2 -848.1 14.9 ind_pickup31 //Basketball courts

//CAMERA
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 881.3 60.4 9.7 ind_pickup42 //North Harwood waste ground
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1024.0 -477.3 14.9 ind_pickup43 //Near subway
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1159.4 -755.4 14.7 ind_pickup44	//Behind Joeys garage
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1402.3 -804.9 11.6 ind_pickup45 //Docks
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 839.8 -1029.1 15.6 ind_pickup46	//South opposite Greasy Joes
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1427.7 -4.6 9.4 ind_pickup47 //Far north
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1459.6 -363.5 14.7 ind_pickup48	//Beach
//CREATE_PICKUP camerapickup PICKUP_ON_STREET 1114.9 -113.2 10.1 ind_pickup49 //Near fire station



//COMMERCIAL********************************************************************************

//VAR_INT phils_m16 phils_uzi phils_shotgun
VAR_INT	com_pickup1 com_pickup2 com_pickup3 com_pickup4 com_pickup5 com_pickup6 com_pickup7 com_pickup8 com_pickup9 com_pickup10
VAR_INT	com_pickup11 com_pickup12 com_pickup13 com_pickup14 com_pickup15 com_pickup16 com_pickup17 com_pickup18	com_pickup19 com_pickup20
VAR_INT	com_pickup21 com_pickup22 com_pickup23 com_pickup24 com_pickup25 com_pickup26 com_pickup27 com_pickup28 com_pickup29 com_pickup30
VAR_INT com_pickup31 com_pickup32 com_pickup33 com_pickup34 com_pickup35 com_pickup36 com_pickup37 com_pickup38 com_pickup40 com_pickup41

//WEAPONS
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET 99.1 -478.7 15.9 FREE_BASEBALLBAT2 //PLAYERS SAVE HOUSE COMMERCIAL -OK
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 15 -77.5 -482.7 28.8 com_pickup1 //Roof jump from Suburban bridge -OK
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 18.9 -1240.9 27.8 com_pickup2	//Columned walkway near church -OK
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 10 93.1 -724.2 31.5 com_pickup3 //Park behind monument -OK
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 202.8 -108.3 20.1 com_pickup4 //Liberty Campus -OK
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 422.4 -92.0 16.14 com_pickup5 // NE construction site under ruins -OK
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 60 -31.45 -1456.38 26.13 com_pickup6 // South Comm behind wall nr carpark -OK
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 10 -253.0 -1340.34 5.85 com_pickup7 //Far South West Quay -OK

//HEALTH
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 182.9 -16.3 16.2 com_pickup8 //Hospital commercial -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 222.6 16.0 16.2 com_pickup9 //Hospital commercial -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 513.6 -680.6 16.6 com_pickup10 //Place opposite Asukas -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -25.3 -1142.3 26.1 com_pickup11 //Church -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -48.56 -579.0 26.2 com_pickup12 //Grassy bank start of ramp for lift bridge -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -26.35 -767.63 26.17	com_pickup13 //Entry old office block left of OrBit facing park -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -24.67 -1275.76 25.71 com_pickup14 //In shrubs North side glass 20thC building -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -178.34 -1409.0 26.1	com_pickup15 //Annex off South West circle road -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 228.46 -1516.33 27.42 com_pickup16 //Stepped entry to second of twin tower block nr subway -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 200.0 -1219.14 26.92	com_pickup17 //Raised pavement AmCo building -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 371.25 -1028.1 26.03	com_pickup18 // Grassy ledge above police HQ -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 189.7 -602.2 28.1 com_pickup19 //Shopping promenade nr park -OK
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 398.4569 -289.0348 23.2 com_pickup40 //Building site

//ARMOUR
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 410.1 -935.2 16.1 com_pickup20 //Far south industrail jetty between trailers -OK
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -80.5 -482.7 28.8 com_pickup21 //Roof jump from Suburban bridge -OK
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 22.1 -1241.1 27.8 com_pickup22 //Columned walkway near church -OK
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 151.75 -106.4 20.16 com_pickup23	//Liberty Campus -OK
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -44.7 -1456.38 26.13	com_pickup24 // South Comm behind wall nr carpark -OK
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 398.4569 -285.3912 23.2 com_pickup41 //Building site

//ADRENALINE
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 169.3 -990.5 29.5 com_pickup25 //TW@T CAFE -OK
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 231.8 -338.7 31.7 com_pickup26 //Opposite consturction yard, raised walkway -OK
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 89.0 -931.8 27.1 com_pickup27 // -main intersection Callahan Bridge -OK
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 212.4 -896.6 23.15 com_pickup28 // Entrance to tower, right of Callahan Bridge -OK

//POLICE BRIBES
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 320.7 -782.13 28.8 com_pickup29 //Maze of paths behind AmmuNation -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 351.0 -1176.6 16.7 com_pickup30 //Police HQ tunnel -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 108.3 -1398.7 21.8 com_pickup31 //tight alleyway south central behind town hall -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 419.7 -1439.6 25.6 com_pickup32 //Casino -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 283.6 -809.7 28.9 com_pickup33 //little grassy path from flyover towards park -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 181.3 -262.4 15.9 com_pickup34 //University -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -16.4 -458.6 18.6 com_pickup35 //Behind fire station -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -150.5 -112.8 16.16 com_pickup36 //Behind stadium -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 357.58 -898.55 23.53 com_pickup37	// Grassy path Callahan Bridge -OK
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 412.2 -1564.6 24.5 com_pickup38  //Over Jump (South by Casino) -OK

//SUBURBIA**************************************************************************************

VAR_INT sub_pickup1 sub_pickup2 sub_pickup3 sub_pickup4 sub_pickup6 sub_pickup7	sub_pickup8	sub_pickup9	sub_pickup10
VAR_INT sub_pickup11 sub_pickup12 sub_pickup13 sub_pickup14 sub_pickup15 sub_pickup16 sub_pickup17 sub_pickup18	sub_pickup19 sub_pickup20
VAR_INT sub_pickup21 sub_pickup22 sub_pickup23 sub_pickup24 sub_pickup25 sub_pickup26 sub_pickup27 sub_pickup28 sub_pickup29 sub_pickup30
VAR_INT sub_pickup31

//WEAPONS
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET -661.1 -3.8 18.8 FREE_BASEBALLBAT3 //PLAYERS SAVE HOUSE SUBURBAN
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 -1065.2 -153.7 33.7 sub_pickup1 // south Industrail area
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 60 -555.0 311.2 70.8 sub_pickup2 //back of second mansion to the east of the Columbian mansion
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 60 -1153.6 440.3 35.5 sub_pickup3 //Dam 2nd tower (suburban)
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 -1141.9 333.0 3.4 sub_pickup4  //To west of Dam on the lower ground
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 5 -973.8 455.7 23.5 sub_pickup6 //On lower half of Dam
CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 3 -855.4 304.6 49.1 sub_pickup7 //On furthest west mansion roof
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 300 -632.7 -589.3 18.8 sub_pickup31 //Under the suburban bridge

//HEALTH
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1247.5 -79.5 58.8 sub_pickup8 //Hospital suburban
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1247.5 -82.5 58.8 sub_pickup9 //Hospital suburban
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1120.7 586.4 68.6 sub_pickup10 //East Dam dome
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1072.5 449.0 23.6 sub_pickup11 //lower Dam opposite side of the first crates
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1142.0 330.6 3.4 sub_pickup12 //To west of Dam on the lower ground
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1198.6 -39.7 53.2 sub_pickup13 //Garages behind police station
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1384.6 -747.4 10.9 sub_pickup14 //airport between ramps
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -466.6 30.4 3.9 sub_pickup15 //Projects

//ARMOUR
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -426.9 290.2 62.9 sub_pickup16 //Columbian mansion (in garage)
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -698.0 -560.7 22.4 sub_pickup17 //On tunnel entrance roof
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1066.7 47.0 48.9 sub_pickup18 //North industrial next to bridge
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1186.9 -40.1 53.2 sub_pickup19 //Garages behind police station

//ADRENALINE
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -710.1 180.3 28.7 sub_pickup20 //Car park in between mansions and projects
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -501.1 62.9 3.8 sub_pickup21 //Projects
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -963.0 -113.4 34.2 sub_pickup22 //Behind billboard east central
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -1374.6 -747.4 10.9 sub_pickup23 //airport between ramps
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -1092.0 -24.2 48.9 sub_pickup24 //Liberty Pharmaceuticals

//POLICE BRIBES
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1247.8 136.0 68.5 sub_pickup25 //North west industrial
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -468.6 -62.0 3.8 sub_pickup26 //Projects between garage
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1107.5 -77.2 46.1 sub_pickup27 //central Industrial on stairs
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -618.7 -722.6 18.9 sub_pickup28 //At airport statue next to subway
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1252.4 -641.6 11.1 sub_pickup29 //Airport in the middle of the planes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -853.4 -255.6 32.9 sub_pickup30 //Grassy verge between airport ad Pike Creek


// *************************************UPSTATE LIBERTY PICKUPS***************************
// Authors:
// .HAYA
// Adi

VAR_INT lcc_t1_weapon1, lcc_t1_weapon2, lcc_t1_weapon3
VAR_INT lcc_t1_pickup1, lcc_t1_pickup2, lcc_t1_pickup3, lcc_t1_pickup4, lcc_t1_pickup5, lcc_t1_pickup6
VAR_INT lcc_t2_weapon1
VAR_INT lcc_t2_pickup1, lcc_t2_pickup2, lcc_t2_pickup3, lcc_t2_pickup4, lcc_t2_pickup5, lcc_t2_pickup6, lcc_t2_pickup7
VAR_INT lcc_t3_weapon1, lcc_t3_weapon2
VAR_INT lcc_t3_pickup1, lcc_t3_pickup2, lcc_t3_pickup3, lcc_t3_pickup4, lcc_t3_pickup5, lcc_t3_pickup6
VAR_INT lcc_weapon1, lcc_weapon2, lcc_weapon3, lcc_weapon4, lcc_weapon5, lcc_weapon6, lcc_weapon7
VAR_INT lcc_pickup1, lcc_pickup2, lcc_pickup3, lcc_pickup4, lcc_pickup5, lcc_pickup6, lcc_pickup7, lcc_pickup8, lcc_pickup9, lcc_pickup10
VAR_INT lcc_pickup11, lcc_pickup12, lcc_pickup13, lcc_pickup14, lcc_pickup15, lcc_pickup16, lcc_pickup17
VAR_INT gtw_weapon1, gtw_weapon2, gtw_weapon3, gtw_weapon4, gtw_weapon5, gtw_weapon6, gtw_weapon7, gtw_weapon8, gtw_weapon9, gtw_weapon10
VAR_INT gtw_weapon11, gtw_weapon12, gtw_weapon13, gtw_weapon14, gtw_weapon15, gtw_weapon16, gtw_weapon17, gtw_weapon18
VAR_INT gtw_pickup1, gtw_pickup2, gtw_pickup3, gtw_pickup4, gtw_pickup5, gtw_pickup6, gtw_pickup7, gtw_pickup8, gtw_pickup9, gtw_pickup10
VAR_INT gtw_pickup11, gtw_pickup12, gtw_pickup13, gtw_pickup14, gtw_pickup15, gtw_pickup16, gtw_pickup17, gtw_pickup18, gtw_pickup19, gtw_pickup20
VAR_INT gtw_pickup21
VAR_INT info_pickup11a, info_pickup11b
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


// Baxter

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 5 -1441.1790 1712.7620 80.2928 lcc_t1_weapon1 //Sniper Rifle - On the rooftops of one of the buildings at the cul-de-sac, requires on foot parkour to get there
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 -1831.5110 1647.7930 97.0645 lcc_t1_weapon2 //Shotgun - In front of a hidden barn next to the tunnel, northwest from Town 1
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 -1301.6040 1553.1790 71.0529 lcc_t1_weapon3 //Uzi - In front of small garage at the back of Police Staion
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1349.1960 1556.9650 72.5302 lcc_t1_pickup1 //Inside Happy Blimp, southern part of the town
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1492.2520 1734.9680 73.2802 lcc_t1_pickup2 //At the cul-de-sac, in front of pink house, north-west part of the town
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1269.7262 1574.1406 72.2802 lcc_t1_pickup3 //In front of the hospital door
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1825.7080 1645.5520 78.3561 lcc_t1_pickup4 //In the corner on rubbish of tunnel west from Town 1
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1289.1893 1538.1089 76.9028 lcc_t1_pickup5 //At police station jump
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -1214.3500 1501.4170 71.9238 lcc_t1_pickup6 //In the trailer park located in south-east part of the town


// Warsaw

//Weapons
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET -191.4619 1513.5410 112.4055 lcc_t2_weapon1 //Baseball Bat - In the trailer park at north-east corner of the town
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -267.8557 1353.3440 112.3761 lcc_t2_pickup1 //On the doorstep of Wyckoff Hosptial
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -531.5046 1395.9990 114.1257 lcc_t2_pickup2 //On the house patio, west-center part of the town
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -217.8766 1312.2137 112.6268 lcc_t2_pickup3 //Happy Blimp
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -23.9286 1459.7140 140.6608 lcc_t2_pickup4 //Inside a barn, north-east edge of the town
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -578.6509 1179.7390 112.6230 lcc_t2_pickup5 //Southwest from the Town 2 under small bridge
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -443.6569 1424.3010 111.7122 lcc_t2_pickup6 //In the middle of long suburbs alleyway, north-west part of the town
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW -308.4047 1335.7400 112.3761 lcc_t2_pickup7 //Behind Wyckoff Hospital


// Carrington

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 387.2297 1488.2222 146.998 lcc_t3_weapon1 //Uzi - At northern border of Town 3, inside a orange barn upstairs, in between hay
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 473.2342 1190.7930 144.0179 lcc_t3_weapon2 //AK47 - On the tallest roof at the motel complex (requires tricky on foot parkour to obtain it, not too difficult but well hidden)
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 541.442 1233.1902 132.2681 lcc_t3_pickup1 //In front of the Hospital door
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 438.2643 988.0662 127.7142 lcc_t3_pickup2 //In the south, next to the wooden cabin, in small park surrounded by water
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 519.6503 1303.4149 131.7673 lcc_t3_pickup3 //Happy Blimp
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 590.5299 1477.9210 144.7233 lcc_t3_pickup4 //On rooftop of red barn northern from Town 3
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 375.6707 1345.5358 131.0699 lcc_t3_pickup5 //On a dirt road between houses near a big tree
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 555.1644 1182.3420 136.2681 lcc_t3_pickup6 //One block south from the police station, behind the building on the edge of balcony


// Countryside (Countryside + Love Estate)

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 -1516.9050 927.5119 122.6803 lcc_weapon1 //Colt 45 - On small rooftop of Love Estate Golf Course
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 300 -53.6648 1827.9560 145.2748 lcc_weapon2 //Flamethrower - Hidden deep inside the abandoned mines
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 -314.2549 832.2250 167.1317 lcc_weapon3 //Molotov Cocktails - On the eastern part of the mountain right behind the lonely cabin
CREATE_PICKUP_WITH_AMMO WEAPON_FLAME PICKUP_ON_STREET_SLOW 300 -439.5469 723.5470 245.2319 lcc_weapon4 //Flamethrower - On top of the mountain/observatory area, right below the wooden outlook post, requires a bit of hassle to walk through steep cliff collision
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 90 -1422.5000 712.6121 88.8691 lcc_weapon5 //M16 - Love Estate, the hardest pickup to obtain in entire UL, one the rooftop of mansion right below the Golf Course, the one where police bribe stunt jump points at. Very challenging to obtain, requires well timed sprint jump from the cliff at Golf Course border, right on the corner of the rooftop.
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 100 333.1871 1696.8147 168.9491 lcc_weapon6 //Uzi - On top of one of the fuel tanks in fuel depot
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 101.2103 1092.603 150.7578 lcc_weapon7 //Shotgun - Inside barn by the highway
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -499.8909 888.5577 251.2389 lcc_pickup1 //On top of the mountain, right in front of MSX FM station hut
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1536.4400 932.7610 115.7678 lcc_pickup2 //Under the staircase of Love Estate Golf Course
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1643.2010 1071.1190 120.7586 lcc_pickup3 //In front of two garages in Love Estate, located one block north from northwest corner of Golf Course
CREATE_PICKUP health PICKUP_ON_STREET_SLOW -1690.2820 625.9310 109.1501 lcc_pickup4 // In southern part of Love Estate, in one of the empty pools behind the house
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1264.1080 1345.3000 72.1951 lcc_pickup5 //South from the Town 1, behind gas station
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -1272.4340 903.6516 66.6860 lcc_pickup6 //South from Love Estate at the jetty, behind the small ledge
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -11.0114 907.3554 140.8428 lcc_pickup7 //In the sawmill area, in between logs
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW -735.2781 1809.2446 147.6188 lcc_pickup8 //Inside the haunted house
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 341.0052 1651.2444 157.2209 lcc_pickup9 //On top of the red pipes in fuel depot
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 584.6691 1549.5520 152.2641 lcc_pickup10 //North from the Town 3, at the jump on the edge of scrapyard
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 213.7393 930.9748 123.8425 lcc_pickup11 //Below the road in underground tunnel, south-west from Town 3
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -973.8750 995.0899 112.6876 lcc_pickup12 //On the arch of a bridge, bridge in question is located right from exiting the tunnel closest to Chocolate Dam
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -1458.6800 783.4966 105.8130 lcc_pickup13 //On the grass jump at Love Estate Golf Course
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW -781.7514 1696.4580 145.5832 lcc_pickup14 //In between Town 1 and Town 2, on the broken wooden bridge
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1001.5283 917.7895 97.1452 lcc_pickup15 //At the northeastern part of the dirt track, requires a jump
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 104.0971 1094.088 147.1942 lcc_pickup16 //Inside barn by the highway
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 237.5898 1540.6149 147.4532 lcc_pickup17 //Inside barn south west to fuel depot


// Gostburg

//Weapons
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 15 1290.975 788.0938 29.8453 gtw_weapon1 //Shotgun - Inside the cave from the hidden scary cabin
CREATE_PICKUP_WITH_AMMO WEAPON_M16 PICKUP_ON_STREET_SLOW 90 1008.5310 1451.8170 156.8130 gtw_weapon2 //M16 - On the tallest building accessible through rooftop parkour, requires one of 3 fastest cars to obtain it
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 60 1176.8210 1583.5770 142.1532 gtw_weapon3 //AK47 - In the hanging semi open container from crane next to construction site
CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 4 1333.8530 1784.6890 126.5630 gtw_weapon4 //Rocket Launcher - North from the Ghostburg inside the unfinished tunnel, drop down onto a metal beam from top of the tunnel
CREATE_PICKUP_WITH_AMMO WEAPON_GRENADE PICKUP_ON_STREET_SLOW 10 1502.2840 1372.6880 117.7010 gtw_weapon5 //Grenades - Inside the sewers underground, in the bank safe (Fun Fact: Grenades do not appear anywhere on the map in freemode of vanilla GTA3)
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 1727.6350 1838.9190 141.7285 gtw_weapon6 //Colt 45 - At the Fire Department station in airport
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 5  1663.9550 1295.0190 157.7634 gtw_weapon7 //Sniper Rifle - On the accesible rooftops, right in the same area as Adrenaline pill in office
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 1330.6110 1678.9430 121.8135 gtw_weapon8 //Molotov Cocktails - Right behind Wang Cars in corner of garage doors
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 50 1178.3800 1208.7370 129.1588 gtw_weapon9 //Uzi - One the rooftop of Pay 'n Spray
CREATE_PICKUP WEAPON_BAT PICKUP_ON_STREET 1361.5320 1082.3460 122.5276 gtw_weapon10 //Baseball Bat - In the german buildings section, easy to spot
CREATE_PICKUP_WITH_AMMO WEAPON_COLT45 PICKUP_ON_STREET_SLOW 24 1465.4710 1094.5430 122.5273 gtw_weapon11 //Colt 45 - In the german buildings section, in between small alley
CREATE_PICKUP_WITH_AMMO WEAPON_ROCKET PICKUP_ON_STREET_SLOW 10 1662.5585 1725.3684 153.4786 gtw_weapon12 //Rocket Launcher - On top of the airport terminal
CREATE_PICKUP_WITH_AMMO WEAPON_UZI PICKUP_ON_STREET_SLOW 300 1664.3776 1725.3453 153.4786 gtw_weapon13 //Uzi - On top of the airport terminal
CREATE_PICKUP_WITH_AMMO WEAPON_AK47 PICKUP_ON_STREET_SLOW 240 1664.4176 1727.522 153.4786 gtw_weapon14 //AK47 - On top of the airport terminal
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 25 1017.2897 1563.4589 153.0629 gtw_weapon15 //Sniper - On top of the big factory
CREATE_PICKUP_WITH_AMMO WEAPON_SHOTGUN PICKUP_ON_STREET_SLOW 35 1006.1495 1614.3621 135.0867 gtw_weapon16 //Shotgun - On top of a warehouse; need to jump down from the spot near above sniper pickup
CREATE_PICKUP_WITH_AMMO WEAPON_SNIPER PICKUP_ON_STREET_SLOW 10 1170.4038 1344.5265 134.9139 gtw_weapon17 //Sniper - On top of the petrol station canopy
CREATE_PICKUP_WITH_AMMO WEAPON_MOLOTOV PICKUP_ON_STREET_SLOW 10 1530.2551 1479.8263 126.8138 gtw_weapon18 //Molotov - Behind bank alleyway in a tight spot with staircases
//Health
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1524.6553 1441.4261 126.6207 gtw_pickup1 //In the iconic alley from GTA3 intro cutscene
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1349.1710 1462.4180 127.0634 gtw_pickup2 //In front of the Ghostburg Hospital
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1298.5620 964.2830 119.5409 gtw_pickup3 //On top of the ramp in the skatepark
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1722.4580 1318.6980 124.7959 gtw_pickup4 //In small grass pool in the middle or two tall buildings, a bit east from centre of the city
CREATE_PICKUP health PICKUP_ON_STREET_SLOW 1577.7299 1314.9514 130.8139 gtw_pickup5 //Happy Blimp
//Armor
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1232.3420 1638.5060 118.3614 gtw_pickup6 //Inside the closed of pipe at construction site
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1689.8460 1612.5830 131.7101 gtw_pickup7 //Right behind the funny plane eating burger, south from the airport terminal
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1810.1120 1343.8420 123.1932 gtw_pickup8 //In front of closed garage behind the two smaller hexagonal buildings, in east part of the city
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1662.6307 1727.5527 153.4786 gtw_pickup9 //On top of the airport terminal
CREATE_PICKUP bodyarmour PICKUP_ON_STREET_SLOW 1061.3582 1515.5455 148.0627 gtw_pickup10 //On top of the big factory; have to walk on the pipe
//Bribes
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1588.4530 1368.9580 123.9967 gtw_pickup11 //On the staircase in underground of white mall
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1054.5010 1342.0210 150.5407 gtw_pickup12 //At the rooftop parkour section, high above the road
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1214.8240 1598.5450 125.9514 gtw_pickup13 //Inside a big pipe at construction site
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1327.3617 1069.5896 122.5338 gtw_pickup14 //Alleyway in Old Town
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1123.7958 1360.1757 129.0837 gtw_pickup15 //Hole in the wall between indust and blocks areas
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1657.4794 1431.0341 126.7161 gtw_pickup16 //Alleyway by Bolt Burgers
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1284.7506 1478.0626 131.8132 gtw_pickup17 //On top of the MKNKY warehouse
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1308.6 1159.2052 128.077 gtw_pickup17 //Jump onto highway from blocks
CREATE_PICKUP bribe PICKUP_ON_STREET_SLOW 1798.1515 1128.3035 125.2036 gtw_pickup19 //Behind bush on highway exit
//Adrenaline
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1632.3630 1273.6420 151.7632 gtw_pickup20 //On the building you can climb on top of by series of staircases (offices)
CREATE_PICKUP adrenaline PICKUP_ON_STREET_SLOW 1276.2980 1161.0170 127.5273 gtw_pickup21 //On top of the staircase in some neighbourhood (blocks)


// **************************************GLOBAL ZONES*****************************************

 	SETUP_ZONE_PED_INFO CITYZON DAY   (12) 0 0 0 0 0 0 0 20
    SETUP_ZONE_PED_INFO CITYZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO CITYZON DAY   (10) 0 0 0 0 0 0 0 20 240 240 240 240 0 0
    SETUP_ZONE_CAR_INFO CITYZON NIGHT ( 8) 0 0 0 0 0 0 0 10 240 240 240 240 0 0
	SET_ZONE_GROUP CITYZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP CITYZON NIGHT DEFAULT_PEDGRP

    SETUP_ZONE_PED_INFO IND_ZON DAY   (12) 0 0 0 0 0 0 0 20
    SETUP_ZONE_PED_INFO IND_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO IND_ZON DAY   (10) 0 0 0 0 0 0 0 20 500 0 0 450 0 0
    SETUP_ZONE_CAR_INFO IND_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 500 0 0 450 0 0
	SET_ZONE_GROUP IND_ZON DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP IND_ZON NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO COM_ZON DAY   (12) 0 0 0 0 0 0 0 20
    SETUP_ZONE_PED_INFO COM_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO COM_ZON DAY   (10) 0 0 0 0 0 0 0 20 0 300 450 150 0 0
    SETUP_ZONE_CAR_INFO COM_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 0 300 450 150 0	0
	SET_ZONE_GROUP COM_ZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP COM_ZON NIGHT DEFAULT_PEDGRP

    SETUP_ZONE_PED_INFO SUB_ZON DAY   (12) 0 0 0 0 0 0 0 20
    SETUP_ZONE_PED_INFO SUB_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZON DAY   (10) 0 0 0 0 0 0 0 20 0 500 450 0 0 0
    SETUP_ZONE_CAR_INFO SUB_ZON NIGHT ( 8) 0 0 0 0 0 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZON DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZON NIGHT DEFAULT_PEDGRP

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big

//GANG ZONES

    SETUP_ZONE_PED_INFO LITTLEI DAY	  (17) 300 0 0 (0 0 0 0) 20	//St Marks
    SETUP_ZONE_PED_INFO	LITTLEI	NIGHT (11) 400 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO LITTLEI DAY	  (10) 100 0 0 (0 0 0 0) 20 400 0 0 350 20 0
    SETUP_ZONE_CAR_INFO LITTLEI NIGHT ( 8) 150 0 0 (0 0 0 0) 10 550 0 0 150 0  0
	SET_ZONE_GROUP LITTLEI DAY LITTLEITALY_PEDGRP
	SET_ZONE_GROUP LITTLEI NIGHT LITTLEITALY_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO CHINA DAY   (20) 0 300 0 (0 0 0 0) 20 //China town
    SETUP_ZONE_PED_INFO CHINA NIGHT (12) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO CHINA DAY   (10) 0 100 0 (0 0 0 0) 10 400 0 0 350 0 0
    SETUP_ZONE_CAR_INFO CHINA NIGHT ( 8) 0 150 0 (0 0 0 0) 20 550 0 0 200 0	0
	SET_ZONE_GROUP CHINA DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP CHINA NIGHT CHINATOWN_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	TOWERS DAY   (15) 0 0 300 (0 0 0 0) 0 //Hepburn heoghts
    SETUP_ZONE_PED_INFO TOWERS NIGHT (10) 0 0 400 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO TOWERS DAY   ( 8) 0 0 100 (0 0 0 0) 20 400 0 0 350 0 0
    SETUP_ZONE_CAR_INFO TOWERS NIGHT ( 6) 0 0 150 (0 0 0 0) 10 550 0 0 200 0 0
	SET_ZONE_GROUP TOWERS DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP TOWERS NIGHT PROJECTS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO REDLIGH DAY   ( 6) 0 0 0 (0 0 0 0) 20 //Redlight district
    SETUP_ZONE_PED_INFO REDLIGH NIGHT (13) 0 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO REDLIGH DAY   ( 5) 0 0 0 (0 0 0 0) 10 550 0 0 350 0	0
    SETUP_ZONE_CAR_INFO REDLIGH NIGHT ( 7) 0 0 0 (0 0 0 0) 20 600 0 0 200 0	0
	SET_ZONE_GROUP REDLIGH DAY REDLIGHT_PEDGRP
	SET_ZONE_GROUP REDLIGH NIGHT REDLIGHT_NIGHT_PEDGRP


//NAVIGATION ZONES

    SETUP_ZONE_PED_INFO PORT_I DAY   (10) 0 0 0 (0 0 0 0) 0 //Trenton
    SETUP_ZONE_PED_INFO PORT_I NIGHT ( 7) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_I DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 20 0
    SETUP_ZONE_CAR_INFO PORT_I NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_I DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_I NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_E DAY   (10) 0 0 0 (0 0 0 0) 0 //Portland Harbour
    SETUP_ZONE_PED_INFO PORT_E NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_E DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 20 0
    SETUP_ZONE_CAR_INFO PORT_E NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_E DAY DOCKS_PEDGRP
	SET_ZONE_GROUP PORT_E NIGHT DOCKS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_S DAY   (10) 0 0 0 (0 0 0 0) 0 //Atlantic Quays
    SETUP_ZONE_PED_INFO PORT_S NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_S DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 500 20 0
    SETUP_ZONE_CAR_INFO PORT_S NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0	0
	SET_ZONE_GROUP PORT_S DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_S NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PORT_W DAY   (10) 0 10 0 (0 0 0 0) 0 //Callahan Point
    SETUP_ZONE_PED_INFO PORT_W NIGHT ( 5) 0 10 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO PORT_W DAY   ( 8) 0 0 0 (0 0 0 0) 20 300 0 0 400 0 0
    SETUP_ZONE_CAR_INFO PORT_W NIGHT ( 6) 0 0 0 (0 0 0 0) 10 500 0 0 400 0 0
	SET_ZONE_GROUP PORT_W DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP PORT_W NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	HARWOOD	DAY   (10) 0 0 0 (0 0 0 0) 0 //Harwood
    SETUP_ZONE_PED_INFO HARWOOD NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO HARWOOD DAY   ( 8) 0 0 0 (0 0 0 0) 20 400 0 0 300 0	0
    SETUP_ZONE_CAR_INFO HARWOOD NIGHT ( 6) 0 0 0 (0 0 0 0) 10 600 0 0 200 0	0
	SET_ZONE_GROUP HARWOOD DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP HARWOOD NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	EASTBAY	DAY   (10) 0 0 0 (0 0 0 0) 0 //Portland Beach
    SETUP_ZONE_PED_INFO EASTBAY NIGHT ( 5) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO EASTBAY DAY   ( 5) 0 0 0 (0 0 0 0) 20 500 0 0 480 0 0
    SETUP_ZONE_CAR_INFO EASTBAY NIGHT ( 4) 0 0 0 (0 0 0 0) 10 500 0 0 490 0 0
	SET_ZONE_GROUP EASTBAY DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP EASTBAY NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	S_VIEW DAY   (10) 0 0 0 (0 0 0 0) 30 //Portland View
    SETUP_ZONE_PED_INFO S_VIEW NIGHT ( 8) 0 0 0 (0 0 0 0) 20
    SETUP_ZONE_CAR_INFO S_VIEW DAY   (10) 0 0 0 (0 0 0 0) 30 400 0 0 300 100 0
    SETUP_ZONE_CAR_INFO S_VIEW NIGHT ( 8) 0 0 0 (0 0 0 0) 20 500 0 0 200 100 0
	SET_ZONE_GROUP S_VIEW DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP S_VIEW NIGHT INDUSTRIAL_NIGHT_PEDGRP


//OTHER ZONES

	SETUP_ZONE_PED_INFO	COPS_1 DAY   (10) 0 0 0 (0 0 0 0) 60 //Police station in Portland View
    SETUP_ZONE_PED_INFO COPS_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 60
    SETUP_ZONE_CAR_INFO COPS_1 DAY   (10) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
    SETUP_ZONE_CAR_INFO COPS_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 90 400 0 0 400 0	0
	SET_ZONE_GROUP COPS_1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP COPS_1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	HOSPI_1	DAY   (10) 0 0 0 (0 0 0 0) 60 //Hospital in Portland View
    SETUP_ZONE_PED_INFO HOSPI_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 60
    SETUP_ZONE_CAR_INFO HOSPI_1 DAY   (10) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
    SETUP_ZONE_CAR_INFO HOSPI_1 NIGHT ( 8) 0 0 0 (0 0 0 0) 90 400 0 0 400 0 0
	SET_ZONE_GROUP HOSPI_1 DAY HOSPITAL_PEDGRP
	SET_ZONE_GROUP HOSPI_1 NIGHT HOSPITAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO ROADBR1 DAY   (30) 0 0 0 (0 0 0 0) 0 //com/ind bridge east side
    SETUP_ZONE_PED_INFO ROADBR1 NIGHT (20) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO ROADBR1 DAY   (12) 0 0 0 (0 0 0 0) 20 400 0 0 400 0 100
    SETUP_ZONE_CAR_INFO ROADBR1 NIGHT (10) 0 0 0 (0 0 0 0) 10 400 0 0 400 0	100
	SET_ZONE_GROUP ROADBR1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP ROADBR1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

   	SETUP_ZONE_PED_INFO FISHFAC DAY   ( 2) 0 1000 0 (0 0 0 0) 0 //Fish factory
    SETUP_ZONE_PED_INFO FISHFAC NIGHT ( 2) 0 1000 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO FISHFAC DAY   ( 6) 0 0 0 (0 0 0 0) 20 200 0 0 600 0	0
    SETUP_ZONE_CAR_INFO FISHFAC NIGHT ( 4) 0 0 0 (0 0 0 0) 10 200 0 0 600 0	0
	SET_ZONE_GROUP FISHFAC DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP FISHFAC NIGHT INDUSTRIAL_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO	FILLIN1 DAY   (10) 0 0 0 (0 0 0 0) 0 //Fills a gap in the zones
    SETUP_ZONE_PED_INFO FILLIN1 NIGHT ( 8) 0 0 0 (0 0 0 0) 0
    SETUP_ZONE_CAR_INFO FILLIN1 DAY   ( 8) 0 0 0 (0 0 0 0) 20 500 0 0 400 0	0
    SETUP_ZONE_CAR_INFO FILLIN1 NIGHT ( 6) 0 0 0 (0 0 0 0) 10 400 0 0 400 0	0
	SET_ZONE_GROUP FILLIN1 DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP FILLIN1 NIGHT INDUSTRIAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D1 DAY   (15) 0 300 0 (0 0 0 0) 20	//SOUTH CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D1 NIGHT (10) 0 500 0 (0 0 0 0) 10 //P R X  W   S	B
    SETUP_ZONE_CAR_INFO MAIN_D1 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20	100
    SETUP_ZONE_CAR_INFO MAIN_D1 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20	100
	SET_ZONE_GROUP MAIN_D1 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D1 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D2 DAY   (15) 0 300 0 (0 0 0 0) 20	//CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D2 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D2 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D2 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D2 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D2 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D3 DAY   (15) 0 300 0 (0 0 0 0) 20	//CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D3 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D3 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D3 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D3 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D3 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D4 DAY   (15) 0 300 0 (0 0 0 0) 20	//NORTH CHINATOWN
    SETUP_ZONE_PED_INFO MAIN_D4 NIGHT (10) 0 400 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D4 DAY   (24) 0 100 0 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D4 NIGHT (18) 0 150 0 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D4 DAY CHINATOWN_PEDGRP
	SET_ZONE_GROUP MAIN_D4 NIGHT CHINATOWN_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D5 DAY   (15) 0 0 0 (0 0 0 0) 20 //REDLIGHT
    SETUP_ZONE_PED_INFO MAIN_D5 NIGHT (10) 0 0 0 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D5 DAY   (24) 0 0 0 (0 0 0 0) 20 400 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D5 NIGHT (18) 0 0 0 (0 0 0 0) 10 300 0 0 400 20 100
	SET_ZONE_GROUP MAIN_D5 DAY REDLIGHT_PEDGRP
	SET_ZONE_GROUP MAIN_D5 NIGHT REDLIGHT_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO MAIN_D6 DAY   (15) 0 0 300 (0 0 0 0) 20	//TOWERS
    SETUP_ZONE_PED_INFO MAIN_D6 NIGHT (10) 0 0 400 (0 0 0 0) 10
    SETUP_ZONE_CAR_INFO MAIN_D6 DAY   (24) 0 0 100 (0 0 0 0) 20 300 0 0 300 20 100
    SETUP_ZONE_CAR_INFO MAIN_D6 NIGHT (18) 0 0 150 (0 0 0 0) 10 300 0 0 300 20 100
	SET_ZONE_GROUP MAIN_D6 DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP MAIN_D6 NIGHT PROJECTS_NIGHT_PEDGRP

// ****************************Industrial switched off Road and Ped Nodes*******************

SWITCH_ROADS_OFF 619.6 -911.5 45.0 834.3 -954.5 32.0 //Industrial to commercial Bridge
MARK_ROADS_BETWEEN_LEVELS 619.6 -911.5 45.0 834.3 -954.5 32.0

SWITCH_ROADS_OFF 1381.0 -293.7 48.0 1435.8 -140.1 58.0 //Frankies Driveway
SWITCH_ROADS_OFF 1358.9 -901.9 10.0 1609.6 -615.1 16.0 //Docks

SWITCH_ROADS_OFF 659.6 200.0 -20.0 945.8 147.5 5.0 //Tunnel
MARK_ROADS_BETWEEN_LEVELS 659.6 200.0 -20.0 945.8 147.5 5.0

SWITCH_PED_ROADS_OFF 659.6 200.0 -25.0 945.8 147.5 5.0	//Tunnel
MARK_ROADS_BETWEEN_LEVELS 659.6 200.0 -25.0 945.8 147.5 5.0

SWITCH_PED_ROADS_OFF 773.6 191.8 -25.0 819.7 182.8 5.0	//Tunnel
MARK_ROADS_BETWEEN_LEVELS 773.6 191.8 -25.0 819.7 182.8 5.0

SWITCH_PED_ROADS_OFF 1609.0 -896.0 8.0 1393.7 -967.4 30.0 //Colubian Boat

SWITCH_PED_ROADS_OFF 1048.3 -1103.4 5.0 1040.0 -1074.4 30.0 //Fish Factory

SWITCH_PED_ROADS_OFF 900.09 -297.05 6.0 842.83 -325.58 15.0	//Players hideout

SWITCH_PED_ROADS_OFF  900.5 -427.1 14.0 879.1 -404.2 17.0 //Luigis alleyway

SWITCH_PED_ROADS_OFF 847.9 -640.6 10.0 887.9 -685.8 20.0 //Toni2 alleyway

SWITCH_PED_ROADS_OFF_ANGLED 1222.9 -838.4 13.5 1256.3 -804.9 16.0 58.0 //Bitch'n Dog Food Factory

SWITCH_PED_ROADS_OFF 1005.59 -880.96 12.0 995.9 -893.34 20.0 //Fuzz Ball

SWITCH_PED_ROADS_OFF 1070.6 -401.6 10.0 1067.8 -397.2 25.0 //AMMUNATION

// ***************************************Commercial City Zones*****************************

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big

//NAVIGATION ZONES

    SETUP_ZONE_PED_INFO STADIUM DAY   (30) (0 0 0) 0 0 0 0 0 //Aspatria
    SETUP_ZONE_PED_INFO STADIUM NIGHT (16) (0 0 0) 0 0 0 0 0
    SETUP_ZONE_CAR_INFO STADIUM DAY   (20) (0 0 0) 0 0 0 0 20 300 150 0 250 0 200
    SETUP_ZONE_CAR_INFO STADIUM NIGHT (17) (0 0 0) 0 0 0 0 10 300 150 0 250 0 200
	SET_ZONE_GROUP STADIUM DAY STADIUM_PEDGRP
	SET_ZONE_GROUP STADIUM NIGHT STADIUM_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO HOSPI_2 DAY   (30) (0 0 0) 0 0 0 0 0  //Rockford
    SETUP_ZONE_PED_INFO HOSPI_2 NIGHT (16) (0 0 0) 0 0 0 0 0
    SETUP_ZONE_CAR_INFO HOSPI_2 DAY   (20) (0 0 0) 0 0 0 0 20 300 150 0 250 0 200
    SETUP_ZONE_CAR_INFO HOSPI_2 NIGHT (17) (0 0 0) 0 0 0 0 10 300 150 0 250 0 200
	SET_ZONE_GROUP HOSPI_2 DAY HOSPITAL_PEDGRP
	SET_ZONE_GROUP HOSPI_2 NIGHT HOSPITAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO UNIVERS DAY   (30) (0 0 0) 0 0 0 0 20 //Liberty Campus
    SETUP_ZONE_PED_INFO UNIVERS NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO UNIVERS DAY   (20) (0 0 0) 0 0 0 0 20 300 300 300 0 20 0
    SETUP_ZONE_CAR_INFO UNIVERS NIGHT (17) (0 0 0) 0 0 0 0 10 300 300 300 0 20 0
	SET_ZONE_GROUP UNIVERS DAY UNIVERSITY_PEDGRP
	SET_ZONE_GROUP UNIVERS NIGHT UNIVERSITY_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO CONSTRU DAY   (30) (0 0 0) 0 0 300 0 20  //Fort staunton
    SETUP_ZONE_PED_INFO CONSTRU NIGHT (16) (0 0 0) 0 0 400 0 10
    SETUP_ZONE_CAR_INFO CONSTRU DAY   (20) (0 0 0) 0 0 100 0 20 300 100 0 250 0 150
    SETUP_ZONE_CAR_INFO CONSTRU NIGHT (17) (0 0 0) 0 0 150 0 10 300 100 0 250 0 150
	SET_ZONE_GROUP CONSTRU DAY CONSTRUCTION_PEDGRP
	SET_ZONE_GROUP CONSTRU NIGHT CONSTRUCTION_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PARK DAY   (30) (0 0 0) 0 0 0 0 20 //Belleville Park
    SETUP_ZONE_PED_INFO PARK NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO PARK DAY   (20) (0 0 0) 0 0 0 0 20 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO PARK NIGHT (17) (0 0 0) 0 0 0 0 10 300 300 300 0 0 0
	SET_ZONE_GROUP PARK DAY PARK_PEDGRP
	SET_ZONE_GROUP PARK NIGHT PARK_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO COM_EAS DAY   (30) (0 0 0) 0 300 0 0 20 // Newport
    SETUP_ZONE_PED_INFO COM_EAS NIGHT (16) (0 0 0) 0 400 0 0 10
    SETUP_ZONE_CAR_INFO COM_EAS DAY   (20) (0 0 0) 0 100 0 0 20 400 250 0 0 0 150
    SETUP_ZONE_CAR_INFO COM_EAS NIGHT (17) (0 0 0) 0 150 0 0 10 400 250 0 0 0 100
	SET_ZONE_GROUP COM_EAS DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP COM_EAS NIGHT SHOPPING_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO SHOPING DAY   (30) (0 0 0) 0 0 0 0 20  //Bedford Point
    SETUP_ZONE_PED_INFO SHOPING NIGHT (16) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO SHOPING DAY   (20) (0 0 0) 0 0 0 0 30 300 250 250 0 0 100
    SETUP_ZONE_CAR_INFO SHOPING NIGHT (17) (0 0 0) 0 0 0 0 20 300 250 250 0 0 100
	SET_ZONE_GROUP SHOPING DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP SHOPING NIGHT SHOPPING_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO YAKUSA DAY   (30) (0 0 0) 300 0 0 0 20  //Torrington
    SETUP_ZONE_PED_INFO YAKUSA NIGHT (16) (0 0 0) 400 0 0 0 10
    SETUP_ZONE_CAR_INFO YAKUSA DAY   (20) (0 0 0) 100 0 0 0 40 350 200 250 0 0 0
    SETUP_ZONE_CAR_INFO YAKUSA NIGHT (17) (0 0 0) 150 0 0 0 20 350 200 200 0 0 0
	SET_ZONE_GROUP YAKUSA DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP YAKUSA NIGHT SHOPPING_NIGHT_PEDGRP

//OTHER ZONES

    SETUP_ZONE_PED_INFO ROADBR2 DAY   (30) (0 0 0) 0 0 0 0 20
    SETUP_ZONE_PED_INFO ROADBR2 NIGHT (20) (0 0 0) 0 0 0 0 10
    SETUP_ZONE_CAR_INFO ROADBR2 DAY   (20) (0 0 0) 0 0 0 0 30 300 250 250 0 0 100
    SETUP_ZONE_CAR_INFO ROADBR2 NIGHT (17) (0 0 0) 0 0 0 0 20 300 250 250 0 0 100
	SET_ZONE_GROUP ROADBR2 DAY SHOPPING_PEDGRP
	SET_ZONE_GROUP ROADBR2 NIGHT SHOPPING_NIGHT_PEDGRP


// ****************************Commercial switched off Road and Ped Nodes*******************

SWITCH_PED_ROADS_OFF 106.1 -1278.3 24.0 96.3 -1273.5 27.0 //Hyaku Dojo for Kenji one
SWITCH_PED_ROADS_OFF 120.0 170.0 10.0 190.0 246.0 25.0 //Phil's place
SWITCH_PED_ROADS_OFF 31.0 -317.0 14.0 91.0 -394.0 25.0 // Colombian compound

SWITCH_ROADS_OFF 120.0 170.0 10.0 190.0 246.0 25.0 //Phil's place

SWITCH_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0 //Ambulance
SWITCH_PED_ROADS_OFF 121.814 -46.429 14.0 363.858 54.312 20.0 //Ambulance

SWITCH_ROADS_OFF 353.5 -459.0 18.0 397.5 -431.6 30.0 // Witness protection house

SWITCH_ROADS_OFF 465.7 -634.3 10.0 429.9 -610.1 25.0 // By Asukas condo

SWITCH_ROADS_OFF -46.8 -648.0 39.0 -69.1 -614.0 50.0 //Commercial to Suburbia Bridge
MARK_ROADS_BETWEEN_LEVELS -46.8 -648.0 39.0 -69.1 -614.0 50.0

SWITCH_PED_ROADS_OFF 56.5 -1544.2 10.0 87.9 -1556.0 30.0 // Loves building

SWITCH_PED_ROADS_OFF 413.5 -480.2 20.0 420.9 -499.0 36.0 //ped island
SWITCH_PED_ROADS_OFF 419.5 -708.1 20.0 412.5 -717.9 36.0 //ped island
SWITCH_PED_ROADS_OFF -76.9 -985.4 20.0 -68.8 -992.6 36.0 //ped island
SWITCH_PED_ROADS_OFF -76.5 -934.4 20.0 -70.4 -928.4 36.0 //ped island
SWITCH_PED_ROADS_OFF -55.9 -934.6 20.0 -46.4 -927.2 36.0 //ped island

SWITCH_PED_ROADS_OFF -76.4 -999.6 20.0 -68.8 -628.5 36.0 //ped island

SWITCH_PED_ROADS_OFF 199.3 -935.9 20.0 134.8 -927.4 40.0 //ped island

SWITCH_ROADS_OFF 529.6 106.5 -30.0 581.4 65.7 0.0 //tunnel from commercial to intersection for sub and ind

// ****************************************Suburban City Zones******************************

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big



//NAVIGATION ZONES

    SETUP_ZONE_PED_INFO AIRPORT DAY   (20) (0 0 0 0 0) 0 0 20 //FRANCIS INTI. AIRPORT
    SETUP_ZONE_PED_INFO AIRPORT NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO AIRPORT DAY   (15) (0 0 0 0 0) 0 0 40 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO AIRPORT NIGHT (13) (0 0 0 0 0) 0 0 20 300 300 300 0 0 0
	SET_ZONE_GROUP AIRPORT DAY AIRPORT_PEDGRP
	SET_ZONE_GROUP AIRPORT NIGHT AIRPORT_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO PROJECT DAY   (20) (0 0 0 0 0) 0 300 0 //WICHITA GARDENS
    SETUP_ZONE_PED_INFO PROJECT NIGHT (10) (0 0 0 0 0) 0 400 0
    SETUP_ZONE_CAR_INFO PROJECT DAY   (15) (0 0 0 0 0) 0 100 20 500 150 0 150 0 0
    SETUP_ZONE_CAR_INFO PROJECT NIGHT (13) (0 0 0 0 0) 0 150 10 500 100 0 150 0 0
	SET_ZONE_GROUP PROJECT DAY PROJECTS_PEDGRP
	SET_ZONE_GROUP PROJECT NIGHT PROJECTS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO SUB_IND DAY   (20) (0 0 0 0 0) 0 0 20 //PIKE CREEK
    SETUP_ZONE_PED_INFO SUB_IND NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_IND DAY   (15) (0 0 0 0 0) 0 0 20 300 300 300 0 0 0
    SETUP_ZONE_CAR_INFO SUB_IND NIGHT (13) (0 0 0 0 0) 0 0 10 300 300 300 0 0 0
	SET_ZONE_GROUP SUB_IND DAY DOCKS_PEDGRP
	SET_ZONE_GROUP SUB_IND NIGHT DOCKS_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO SWANKS DAY   (20) (0 0 0 0 0) 70 0 30 //CEDAR CROVE
    SETUP_ZONE_PED_INFO SWANKS NIGHT (10) (0 0 0 0 0) 90 0 20
    SETUP_ZONE_CAR_INFO SWANKS DAY   (15) (0 0 0 0 0) 70 0 30 0 400 400 0 20 0
    SETUP_ZONE_CAR_INFO SWANKS NIGHT (13) (0 0 0 0 0) 90 0 20 0 400 400 0 20 0
	SET_ZONE_GROUP SWANKS DAY SWANKSVILLE_PEDGRP
	SET_ZONE_GROUP SWANKS NIGHT SWANKSVILLE_NIGHT_PEDGRP

    SETUP_ZONE_PED_INFO BIG_DAM DAY   ( 8) (0 0 0 0 0) 0 0 0  //COCHRANE DAM
    SETUP_ZONE_PED_INFO BIG_DAM NIGHT ( 6) (0 0 0 0 0) 0 0 0
    SETUP_ZONE_CAR_INFO BIG_DAM DAY   ( 8) (0 0 0 0 0) 0 0 20 300 300 0 300 0 0
    SETUP_ZONE_CAR_INFO BIG_DAM NIGHT ( 6) (0 0 0 0 0) 0 0 10 300 300 0 300 0 0
	SET_ZONE_GROUP BIG_DAM DAY INDUSTRIAL_PEDGRP
	SET_ZONE_GROUP BIG_DAM NIGHT INDUSTRIAL_NIGHT_PEDGRP

	SETUP_ZONE_PED_INFO SUB_ZO2 DAY   (20) (0 0 0 0 0) 0 0 20 //SHORESIDE VALE
    SETUP_ZONE_PED_INFO SUB_ZO2 NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZO2 DAY   (15) (0 0 0 0 0) 0 0 20 0 500 450 0 0 0
    SETUP_ZONE_CAR_INFO SUB_ZO2 NIGHT (13) (0 0 0 0 0) 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZO2 DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZO2 NIGHT DEFAULT_PEDGRP

	SETUP_ZONE_PED_INFO SUB_ZO3 DAY   (20) (0 0 0 0 0) 0 0 20 //SHORESIDE VALE
    SETUP_ZONE_PED_INFO SUB_ZO3 NIGHT (10) (0 0 0 0 0) 0 0 10
    SETUP_ZONE_CAR_INFO SUB_ZO3 DAY   (15) (0 0 0 0 0) 0 0 20 0 500 450 0 0 0
    SETUP_ZONE_CAR_INFO SUB_ZO3 NIGHT (13) (0 0 0 0 0) 0 0 10 0 500 450 0 0 0
	SET_ZONE_GROUP SUB_ZO3 DAY DEFAULT_PEDGRP
	SET_ZONE_GROUP SUB_ZO3 NIGHT DEFAULT_PEDGRP

	SETUP_ZONE_PED_INFO WEE_DAM DAY   ( 8) (0 0 0 0 0) 100 0 0
	SETUP_ZONE_PED_INFO WEE_DAM NIGHT ( 5) (0 0 0 0 0) 100 0 0
	SETUP_ZONE_CAR_INFO WEE_DAM DAY   ( 0) (0 0 0 0 0) 0 0 0 0 0 0 0 0 0
	SETUP_ZONE_CAR_INFO WEE_DAM NIGHT ( 0) (0 0 0 0 0) 0 0 0 0 0 0 0 0 0
	SET_ZONE_GROUP WEE_DAM DAY DOCKS_PEDGRP
	SET_ZONE_GROUP WEE_DAM NIGHT DOCKS_NIGHT_PEDGRP

// ****************************Suburban switched off Road and Ped Nodes*********************

SWITCH_ROADS_OFF -1052.6693 -78.0430 50.0 -988.0153 -67.1608 30.0 // warehouse in Suburbia
SWITCH_PED_ROADS_OFF -1052.6693 -78.0430 50.0 -988.0153 -67.1608 30.0 // warehouse in Suburbia

SWITCH_ROADS_OFF -952.5 361.4 10.0 -939.3 374.0 30.0 // DAM

SWITCH_ROADS_OFF -241.7 251.8 0.0 -256.2 241.4 20.0 // park area (north east)

SWITCH_ROADS_OFF -1367.7690 -731.4872 20.0 -743.1906 -410.1961 5.0 // Airport
SWITCH_ROADS_OFF -1591.4 -931.5 10.0 -1572.9 -914.6 25.0 // Airport

SWITCH_PED_ROADS_OFF -1310.8053 -568.7556 5.0 -1224.9248 -483.4936 20.0 // Airport

SWITCH_ROADS_OFF 496.7 75.5 -30.0 484.0 44.2 0.0 //tunnel to suburbia
MARK_ROADS_BETWEEN_LEVELS 496.7 75.5 -30.0 484.0 44.2 0.0

//SWITCH_ROADS_OFF -287.8 396.5 70.0 -269.0 418.0 100.0 //tunnel to Miami	(EAST)
//SWITCH_ROADS_OFF -877.1 545.9 60.0 -901.3 575.0 100.0 //tunnel to Miami	(WEST)

SWITCH_ROADS_OFF -690.4 101.2 10.0 -704.4 78.9 30.0  // players savehouse

SWITCH_ROADS_OFF -1194.1 98.6 50.0 -1234.0 119.2 80.0  //

// *************************************UPSTATE LIBERTY ZONES***************************
// Authors:
// Adi

/**************************** No traffic zones ****************************/

// airport
SWITCH_ROADS_OFF 1661.438 1600.888 85.571 1757.618 1850.281 185.571
SWITCH_ROADS_OFF 1138.213 1804.202 85.571 1661.438 1850.281 185.571

/**************************** Zone info ****************************/

// Gang1 in industrial = MAFIA
// Gang2 in industrial = TRIADS
// Gang3 in industrial = DIABLOS
// Gang4 in commercial = YAKUZA
// Gang5 in commercial = YARDDIES
// Gang6 in commercial = COLUMBIANS
// Gang7 in commercial = HOODS
// PedDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police
// CarDensity Gang1 Gang2 Gang3 Gang4 Gang5 Gang6 Gang7 Police PoorFamily RichFamily Executive Worker Special Big
// SETUP_ZONE_PED_INFO Zone Day PedDensity Gang1-Gang7 Police
// SETUP_ZONE_CAR_INFO Zone Day CarDensity Gang1-Gang7 Police

//SETUP_ZONE_PED_INFO LITTLEI DAY	  (17) 300 0 0 (0 0 0 0) 20	//St Marks
//SETUP_ZONE_CAR_INFO LITTLEI DAY	  (10) 100 0 0 (0 0 0 0) 20 400 0 0 350 20 0

// Global
SETUP_ZONE_PED_INFO UL_ZON0 DAY   (10) 0 0 0 0 0 0 0 10 // Upstate
SETUP_ZONE_PED_INFO UL_ZON0 NIGHT ( 7) 0 0 0 0 0 0 0 5
SETUP_ZONE_CAR_INFO UL_ZON0 DAY   ( 8) 0 0 0 0 0 0 0 10 400 200 0 250 0 100
SETUP_ZONE_CAR_INFO UL_ZON0 NIGHT ( 6) 0 0 0 0 0 0 0  5 550 200 0 100 0 0
SET_ZONE_GROUP UL_ZON0 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_ZON0 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GT_ZON0 DAY   (12) 0 0 0 0 0 0 0 20  // Ghost Town
SETUP_ZONE_PED_INFO GT_ZON0 NIGHT ( 8) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GT_ZON0 DAY   (10) 0 0 0 0 0 0 0 20 250 350 200 150 0 0
SETUP_ZONE_CAR_INFO GT_ZON0 NIGHT ( 8) 0 0 0 0 0 0 0 10 250 350 200 150 0 0
SET_ZONE_GROUP GT_ZON0 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP GT_ZON0 NIGHT DEFAULT_PEDGRP

// Countryside

SETUP_ZONE_PED_INFO LOVEEI1 DAY   (12) 0 0 0 0 0 0 0 30 // Love Estates
SETUP_ZONE_PED_INFO LOVEEI1 NIGHT ( 8) 0 0 0 0 0 0 0 20
SETUP_ZONE_CAR_INFO LOVEEI1 DAY   (10) 0 0 0 0 0 0 0 30 0 350 600 0 0 0
SETUP_ZONE_CAR_INFO LOVEEI1 NIGHT ( 8) 0 0 0 0 0 0 0 20 0 250 700 0 0 0
SET_ZONE_GROUP LOVEEI1 DAY SWANKSVILLE_PEDGRP
SET_ZONE_GROUP LOVEEI1 NIGHT SWANKSVILLE_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO LOVEEI2 DAY   (12) 0 0 0 0 0 0 0 30 // Love Estates
SETUP_ZONE_PED_INFO LOVEEI2 NIGHT ( 8) 0 0 0 0 0 0 0 20
SETUP_ZONE_CAR_INFO LOVEEI2 DAY   (10) 0 0 0 0 0 0 0 30 0 350 600 0 0 0
SETUP_ZONE_CAR_INFO LOVEEI2 NIGHT ( 8) 0 0 0 0 0 0 0 20 0 250 700 0 0 0
SET_ZONE_GROUP LOVEEI2 DAY SWANKSVILLE_PEDGRP
SET_ZONE_GROUP LOVEEI2 NIGHT SWANKSVILLE_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO LOVEEI3 DAY   (12) 0 0 0 0 0 0 0 30 // Love Estates
SETUP_ZONE_PED_INFO LOVEEI3 NIGHT ( 8) 0 0 0 0 0 0 0 20
SETUP_ZONE_CAR_INFO LOVEEI3 DAY   (10) 0 0 0 0 0 0 0 30 0 350 600 0 0 0
SETUP_ZONE_CAR_INFO LOVEEI3 NIGHT ( 8) 0 0 0 0 0 0 0 20 0 250 700 0 0 0
SET_ZONE_GROUP LOVEEI3 DAY SWANKSVILLE_PEDGRP
SET_ZONE_GROUP LOVEEI3 NIGHT SWANKSVILLE_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO RIDGE DAY   (20) 0 0 0 0 0 0 0 20 // Cedar Ridge
SETUP_ZONE_PED_INFO RIDGE NIGHT (10) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO RIDGE DAY   (16) 0 0 0 0 0 0 0 10 375 375 200 0 0 0
SETUP_ZONE_CAR_INFO RIDGE NIGHT (10) 0 0 0 0 0 0 0  5 450 350 150 0 0 0
SET_ZONE_GROUP RIDGE DAY SWANKSVILLE_PEDGRP
SET_ZONE_GROUP RIDGE NIGHT SWANKSVILLE_NIGHT_PEDGRP

// Countryside Towns

SETUP_ZONE_PED_INFO BAXTER DAY   (18) 0 0 0 0 0 0 0 15 // Baxter
SETUP_ZONE_PED_INFO BAXTER NIGHT (10) 0 0 0 0 0 0 0  7
SETUP_ZONE_CAR_INFO BAXTER DAY   (14) 0 0 0 0 0 0 0 10 400 300 0 200 0 50
SETUP_ZONE_CAR_INFO BAXTER NIGHT (10) 0 0 0 0 0 0 0  5 650 300 0 0   0 0
SET_ZONE_GROUP BAXTER DAY PARK_PEDGRP
SET_ZONE_GROUP BAXTER NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO WARSAW DAY   (20) 0 0 0 0 0 0 0 15 // Warsaw
SETUP_ZONE_PED_INFO WARSAW NIGHT (10) 0 0 0 0 0 0 0  7
SETUP_ZONE_CAR_INFO WARSAW DAY   (16) 0 0 0 0 0 0 0 10 300 300 0 200 100 50
SETUP_ZONE_CAR_INFO WARSAW NIGHT (10) 0 0 0 0 0 0 0  5 650 300 0 0   0   0
SET_ZONE_GROUP WARSAW DAY PARK_PEDGRP
SET_ZONE_GROUP WARSAW NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO CARRIN DAY   (22) 0 0 0 0 0 0 0 17 // Carrington
SETUP_ZONE_PED_INFO CARRIN NIGHT (12) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO CARRIN DAY   (18) 0 0 0 0 0 0 0 12 250 600 0 100 0 0
SETUP_ZONE_CAR_INFO CARRIN NIGHT (12) 0 0 0 0 0 0 0  6 300 550 0 0   0 0
SET_ZONE_GROUP CARRIN DAY PARK_PEDGRP
SET_ZONE_GROUP CARRIN NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO WARSIND DAY   (20) 0 0 0 0 0 0 0 15 // Warsaw Industrial
SETUP_ZONE_PED_INFO WARSIND NIGHT (10) 0 0 0 0 0 0 0  7
SETUP_ZONE_CAR_INFO WARSIND DAY   (16) 0 0 0 0 0 0 0 10 300 125 0 275 50 200
SETUP_ZONE_CAR_INFO WARSIND NIGHT (10) 0 0 0 0 0 0 0  5 550 100 0 200  0 100
SET_ZONE_GROUP WARSIND DAY INDUSTRIAL_PEDGRP
SET_ZONE_GROUP WARSIND NIGHT INDUSTRIAL_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO T1HOSP DAY   (18) 0 0 0 0 0 0 0 15  // Baxter Hospital
SETUP_ZONE_PED_INFO T1HOSP NIGHT (10) 0 0 0 0 0 0 0  7
SETUP_ZONE_CAR_INFO T1HOSP DAY   (14) 0 0 0 0 0 0 0 10 400 300 0 200 0 50
SETUP_ZONE_CAR_INFO T1HOSP NIGHT (10) 0 0 0 0 0 0 0  5 650 300 0 0   0 0
SET_ZONE_GROUP T1HOSP DAY HOSPITAL_PEDGRP
SET_ZONE_GROUP T1HOSP NIGHT HOSPITAL_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO T2HOSP DAY   (20) 0 0 0 0 0 0 0 15  // Warsaw Hospital
SETUP_ZONE_PED_INFO T2HOSP NIGHT (10) 0 0 0 0 0 0 0  7
SETUP_ZONE_CAR_INFO T2HOSP DAY   (16) 0 0 0 0 0 0 0 10 300 300 0 200 100 50
SETUP_ZONE_CAR_INFO T2HOSP NIGHT (10) 0 0 0 0 0 0 0  5 650 300 0 0   0   0
SET_ZONE_GROUP T2HOSP DAY HOSPITAL_PEDGRP
SET_ZONE_GROUP T2HOSP NIGHT HOSPITAL_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO T3HOSP DAY   (22) 0 0 0 0 0 0 0 17  // Carrington Hospital
SETUP_ZONE_PED_INFO T3HOSP NIGHT (12) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO T3HOSP DAY   (18) 0 0 0 0 0 0 0 12 250 600 0 100 0 0
SETUP_ZONE_CAR_INFO T3HOSP NIGHT (12) 0 0 0 0 0 0 0  6 300 550 0 0   0 0
SET_ZONE_GROUP T3HOSP DAY HOSPITAL_PEDGRP
SET_ZONE_GROUP T3HOSP NIGHT HOSPITAL_NIGHT_PEDGRP

// Ghost Town

SETUP_ZONE_PED_INFO GTWAIR DAY   (20) 0 0 0 0 0 0 0 20 // Airport
SETUP_ZONE_PED_INFO GTWAIR NIGHT (10) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTWAIR DAY   (15) 0 0 0 0 0 0 0 40 300 350 300 0 0 0
SETUP_ZONE_CAR_INFO GTWAIR NIGHT (13) 0 0 0 0 0 0 0 20 300 350 300 0 0 0
SET_ZONE_GROUP GTWAIR DAY AIRPORT_PEDGRP
SET_ZONE_GROUP GTWAIR NIGHT AIRPORT_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO INDPARK DAY   (30) 0 0 0 0 0 0 0 20 // Industrial Park
SETUP_ZONE_PED_INFO INDPARK NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO INDPARK DAY   (20) 0 0 0 0 0 0 0 20 350 0 0 400 0 200
SETUP_ZONE_CAR_INFO INDPARK NIGHT (17) 0 0 0 0 0 0 0 10 550 0 0 300 0 100
SET_ZONE_GROUP INDPARK DAY INDUSTRIAL_PEDGRP
SET_ZONE_GROUP INDPARK NIGHT INDUSTRIAL_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO CEDARW DAY   (20) 0 0 0 0 0 0 0 20 // Cedarwood Hills
SETUP_ZONE_PED_INFO CEDARW NIGHT (10) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO CEDARW DAY   (16) 0 0 0 0 0 0 0 20 350 400 100 100 0 0
SETUP_ZONE_CAR_INFO CEDARW NIGHT (10) 0 0 0 0 0 0 0 10 400 450 100   0 0 0
SET_ZONE_GROUP CEDARW DAY PARK_PEDGRP
SET_ZONE_GROUP CEDARW NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO OLDTOWN DAY   (30) 0 0 0 0 0 0 0 20 // Old Town
SETUP_ZONE_PED_INFO OLDTOWN NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO OLDTOWN DAY   (20) 0 0 0 0 0 0 0 20 400 400 0 150 0 0
SETUP_ZONE_CAR_INFO OLDTOWN NIGHT (17) 0 0 0 0 0 0 0 10 550 400 0   0 0 0
SET_ZONE_GROUP OLDTOWN DAY PROJECTS_PEDGRP
SET_ZONE_GROUP OLDTOWN NIGHT PROJECTS_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO LEONARD DAY   (16) 0 0 0 0 0 0 0 20 // Leonard Heights
SETUP_ZONE_PED_INFO LEONARD NIGHT (20) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO LEONARD DAY   (16) 0 0 0 0 0 0 0 20 550 0 0 400 0 0
SETUP_ZONE_CAR_INFO LEONARD NIGHT (20) 0 0 0 0 0 0 0 10 650 0 0 300 0 0
SET_ZONE_GROUP LEONARD DAY REDLIGHT_PEDGRP
SET_ZONE_GROUP LEONARD NIGHT REDLIGHT_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO SUMMER DAY   (30) 0 0 0 0 0 0 0 20  // Summerton
SETUP_ZONE_PED_INFO SUMMER NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO SUMMER DAY   (20) 0 0 0 0 0 0 0 30 300 250 250 0 0 100
SETUP_ZONE_CAR_INFO SUMMER NIGHT (17) 0 0 0 0 0 0 0 20 300 250 250 0 0 100
SET_ZONE_GROUP SUMMER DAY CITY_PEDGRP
SET_ZONE_GROUP SUMMER NIGHT CITY_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTWCENT DAY   (30) 0 0 0 0 0 0 0 20  // Central
SETUP_ZONE_PED_INFO GTWCENT NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTWCENT DAY   (20) 0 0 0 0 0 0 0 30 300 250 200 50 50 100
SETUP_ZONE_CAR_INFO GTWCENT NIGHT (17) 0 0 0 0 0 0 0 20 350 300 200  0  0 100
SET_ZONE_GROUP GTWCENT DAY CITY_PEDGRP
SET_ZONE_GROUP GTWCENT NIGHT CITY_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO LILCHIN DAY   (30) 0 0 0 0 0 0 0 20  // Little China
SETUP_ZONE_PED_INFO LILCHIN NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO LILCHIN DAY   (20) 0 0 0 0 0 0 0 30 500 250 0 200 0 0
SETUP_ZONE_CAR_INFO LILCHIN NIGHT (17) 0 0 0 0 0 0 0 20 600 350 0 0   0 0
SET_ZONE_GROUP LILCHIN DAY CHINATOWN_PEDGRP
SET_ZONE_GROUP LILCHIN NIGHT CHINATOWN_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTCONST DAY   (30) 0 0 0 0 0 0 0 20  // Construction site
SETUP_ZONE_PED_INFO GTCONST NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTCONST DAY   (20) 0 0 0 0 0 0 0 20 300 100 0 250 0 150
SETUP_ZONE_CAR_INFO GTCONST NIGHT (17) 0 0 0 0 0 0 0 10 300 100 0 250 0 150
SET_ZONE_GROUP GTCONST DAY CONSTRUCTION_PEDGRP
SET_ZONE_GROUP GTCONST NIGHT CONSTRUCTION_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTSUPAS DAY   (35) 0 0 0 0 0 0 0 20 // Supa Save
SETUP_ZONE_PED_INFO GTSUPAS NIGHT (25) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTSUPAS DAY   (25) 0 0 0 0 0 0 0 30 250 200 0 300 0 200
SETUP_ZONE_CAR_INFO GTSUPAS NIGHT (20) 0 0 0 0 0 0 0 20 450 200 0 200 0 100
SET_ZONE_GROUP GTSUPAS DAY SHOPPING_PEDGRP
SET_ZONE_GROUP GTSUPAS NIGHT SHOPPING_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTMALL DAY   (35) 0 0 0 0 0 0 0 20 // Mall
SETUP_ZONE_PED_INFO GTMALL NIGHT (25) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTMALL DAY   (25) 0 0 0 0 0 0 0 30 300 250 250 0 0 100
SETUP_ZONE_CAR_INFO GTMALL NIGHT (20) 0 0 0 0 0 0 0 20 300 250 250 0 0 100
SET_ZONE_GROUP GTMALL DAY SHOPPING_PEDGRP
SET_ZONE_GROUP GTMALL NIGHT SHOPPING_PEDGRP // intentional

SETUP_ZONE_PED_INFO GTHOSP DAY   (30) 0 0 0 0 0 0 0 20  // GT Hospital
SETUP_ZONE_PED_INFO GTHOSP NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTHOSP DAY   (20) 0 0 0 0 0 0 0 30 300 250 200 50 50 100
SETUP_ZONE_CAR_INFO GTHOSP NIGHT (17) 0 0 0 0 0 0 0 20 350 300 200  0  0 100
SET_ZONE_GROUP GTHOSP DAY HOSPITAL_PEDGRP
SET_ZONE_GROUP GTHOSP NIGHT HOSPITAL_NIGHT_PEDGRP

// Highway info zones

VAR_INT hw_dens_day_ped, hw_dens_nit_ped, hw_dens_day_car, hw_dens_nit_car
LVAR_INT hw_poli_day_ped, hw_poli_nit_ped, hw_poli_day_car, hw_poli_nit_car
LVAR_INT hw_poor_day, hw_poor_nit, hw_rich_day, hw_rich_nit, hw_exec_day, hw_exec_nit, hw_work_day, hw_work_nit, hw_spec_day, hw_spec_nit, hw_big_day, hw_big_nit

hw_dens_day_ped = 30
hw_dens_nit_ped = 16
hw_dens_day_car = 16
hw_dens_nit_car = 10

hw_poli_day_ped = 20
hw_poli_nit_ped = 10
hw_poli_day_car = 30
hw_poli_nit_car = 20

hw_poor_day = 200
hw_rich_day = 200
hw_exec_day = 100
hw_work_day = 150
hw_spec_day = 150
hw_big_day = 150
hw_poor_nit = 250
hw_rich_nit = 250
hw_exec_nit = 100
hw_work_nit = 150
hw_spec_nit = 100
hw_big_nit = 100

// West Highway

SETUP_ZONE_PED_INFO UL_HWW1 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW1 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW1 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW1 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW1 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW1 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW2 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW2 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW2 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW2 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW2 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW2 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW3 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW3 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW3 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW3 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW3 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW3 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW4 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW4 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW4 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW4 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW4 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW4 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW5 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW5 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW5 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW5 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW5 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW5 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW6 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW6 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW6 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW6 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW6 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW6 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW7 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW7 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW7 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW7 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW7 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW7 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWW8 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWW8 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWW8 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWW8 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWW8 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWW8 NIGHT PARK_NIGHT_PEDGRP

// East Highway

SETUP_ZONE_PED_INFO UL_HWE1 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE1 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE1 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE1 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE1 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE1 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE2 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE2 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE2 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE2 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE2 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE2 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE3 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE3 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE3 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE3 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE3 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE3 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE4 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE4 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE4 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE4 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE4 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE4 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE5 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE5 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE5 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE5 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE5 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE5 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE6 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE6 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE6 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE6 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE6 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE6 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE7 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE7 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE7 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE7 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE7 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE7 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE8 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE8 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE8 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE8 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE8 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE8 NIGHT PARK_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO UL_HWE9 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HWE9 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HWE9 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HWE9 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HWE9 DAY PARK_PEDGRP
SET_ZONE_GROUP UL_HWE9 NIGHT PARK_NIGHT_PEDGRP

// East highway (Ghost Town)

SETUP_ZONE_PED_INFO UL_HGT1 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT1 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT1 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT1 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT1 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT1 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT2 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT2 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT2 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT2 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT2 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT2 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT3 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT3 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT3 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT3 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT3 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT3 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT4 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT4 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT4 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT4 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT4 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT4 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT5 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT5 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT5 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT5 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT5 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT5 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT6 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT6 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT6 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT6 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT6 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT6 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_HGT7 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_HGT7 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_HGT7 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_HGT7 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_HGT7 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_HGT7 NIGHT DEFAULT_PEDGRP

// SSV-Upstate Tunnels

SETUP_ZONE_PED_INFO UL_TUN1 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_TUN1 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_TUN1 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_TUN1 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_TUN1 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_TUN1 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_TUN2 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_TUN2 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_TUN2 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_TUN2 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_TUN2 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_TUN2 NIGHT DEFAULT_PEDGRP

SETUP_ZONE_PED_INFO UL_TUN3 DAY   (hw_dens_day_ped) 0 0 0 0 0 0 0 hw_poli_day_ped
SETUP_ZONE_PED_INFO UL_TUN3 NIGHT (hw_dens_nit_ped) 0 0 0 0 0 0 0 hw_poli_nit_ped
SETUP_ZONE_CAR_INFO UL_TUN3 DAY   (hw_dens_day_car) 0 0 0 0 0 0 0 hw_poli_day_car hw_poor_day hw_rich_day hw_exec_day hw_work_day hw_spec_day hw_big_day
SETUP_ZONE_CAR_INFO UL_TUN3 NIGHT (hw_dens_nit_car) 0 0 0 0 0 0 0 hw_poli_nit_car hw_poor_nit hw_rich_nit hw_exec_nit hw_work_nit hw_spec_nit hw_big_nit
SET_ZONE_GROUP UL_TUN3 DAY DEFAULT_PEDGRP
SET_ZONE_GROUP UL_TUN3 NIGHT DEFAULT_PEDGRP


// *************************************INDUSTRIAL CAR GENERATORS***************************
VAR_INT gen_car1  gen_car2  gen_car3  gen_car4  gen_car5  gen_car6  gen_car8  gen_car9  gen_car10
VAR_INT gen_car11 gen_car12 gen_car13 gen_car14 gen_car15 gen_car16 gen_car17 gen_car18 gen_car19 gen_car20
VAR_INT gen_car21 gen_car22 gen_car23 gen_car24 gen_car25 gen_car26 gen_car28 gen_car29 gen_car30
VAR_INT gen_car31 gen_car32 gen_car33 gen_car34 gen_car35 gen_car36 gen_car37 gen_car38 gen_car39 gen_car40
VAR_INT gen_car41 gen_car42 gen_car43 gen_car44 gen_car45 gen_car46 gen_car47 gen_car48 gen_car49 gen_car50
VAR_INT gen_car51 gen_car52 gen_car53 gen_car54 gen_car55 gen_car56 gen_car57 gen_car58 gen_car59 gen_car60
VAR_INT gen_car61 gen_car62 gen_car63 gen_car64

//CREATE_CAR_GENERATOR Remap1 Remap2 ParkedFlag ChanceOfCarAlarm ChanceOfLocked MinDelay MaxDelay CarGenID

//PORTLAND VIEW
CREATE_CAR_GENERATOR 1140.7 -630.2 -100.0 0.0 CAR_AMBULANCE -1 -1 0 0 30 0 10000 gen_car1 //At hospital
SWITCH_CAR_GENERATOR gen_car1 101

CREATE_CAR_GENERATOR 1139.0 -646.0 -100.0 90.0 CAR_POLICE -1 -1 0 0 60 0 10000 gen_car2 //At police station
SWITCH_CAR_GENERATOR gen_car2 101

CREATE_CAR_GENERATOR 1139.7 -684.7 -100.0 270.0 CAR_POLICE -1 -1 0 0 70 0 10000 gen_car3 //At police station
SWITCH_CAR_GENERATOR gen_car3 101

CREATE_CAR_GENERATOR 1284.3 -620.5 11.7 0.0 CAR_IDAHO -1 -1 0 40 0 0 10000 gen_car4 //Supa save car park
SWITCH_CAR_GENERATOR gen_car4 101

CREATE_CAR_GENERATOR 1299.0 -641.8 11.7 0.0 CAR_PATRIOT -1 -1 0 40 0 0 10000 gen_car5 //Supa save car park
SWITCH_CAR_GENERATOR gen_car5 101

CREATE_CAR_GENERATOR 1265.9 -620.8 11.7 180.0 CAR_BOBCAT -1 -1 0 40 0 0 10000 gen_car6 //Supa save car park
SWITCH_CAR_GENERATOR gen_car6 101

// SCFIX: Was gen_car6
CREATE_CAR_GENERATOR 1378.4 -607.2 -100.0 180.0 CAR_PONY -1 -1 0 0 0 0 10000 gen_car14 //Behind Supa save car park
SWITCH_CAR_GENERATOR gen_car14 101

//SAINT MARKS
CREATE_CAR_GENERATOR 1208.67 -258.26 24.5 270.0	CAR_MOONBEAM -1 -1 0 90 0 0 10000 gen_car9 //Little Italy garages up from Tonis
SWITCH_CAR_GENERATOR gen_car9 101

CREATE_CAR_GENERATOR 1347.04 -448.44 49.5 0.0 CAR_BOBCAT -1 -1 0 60 0 0 10000 gen_car10	//Bistro car park
SWITCH_CAR_GENERATOR gen_car10 101

CREATE_CAR_GENERATOR 1336.0 -452.19 49.3 270.0 CAR_SENTINEL -1 -1 0 90 0 0 10000 gen_car11 //Bistro car park
SWITCH_CAR_GENERATOR gen_car11 101

CREATE_CAR_GENERATOR 1223.13 -325.3 25.6 180.0 CAR_KURUMA  -1 -1 0 10 0 0 10000 gen_car12 //Tonis car park
SWITCH_CAR_GENERATOR gen_car12 101

CREATE_CAR_GENERATOR 1285.4  -306.18 39.4 270.0	CAR_MAFIA -1 -1 0 90 0 0 10000 gen_car13	//Behind tonis retaurant
SWITCH_CAR_GENERATOR gen_car13 101

//CREATE_CAR_GENERATOR 1285.38 -318.56 39.4 90.0 CAR_IDAHO -1 -1 0 40 0 0 10000 gen_car14 //Behind tonis retaurant
//SWITCH_CAR_GENERATOR gen_car14 101

CREATE_CAR_GENERATOR 1142.14 -95.59 7.0 180.0 CAR_BOBCAT -1 -1 0 50 0 0 10000 gen_car15	 //Petrol station car park
SWITCH_CAR_GENERATOR gen_car15 101

CREATE_CAR_GENERATOR 1147.35 -95.49 7.0 0.0 CAR_ESPERANTO -1 -1 0 50 0 0 10000 gen_car16 //Petrol station car park
SWITCH_CAR_GENERATOR gen_car16 101

CREATE_CAR_GENERATOR 1233.1 -127.2 15.0 38.0 CAR_BANSHEE -1 -1 0 0 0 0 10000 gen_car17 //Swank car in showroom
SWITCH_CAR_GENERATOR gen_car17 101

CREATE_CAR_GENERATOR 1338.13 -257.11 49.3 270.0	CAR_TAXI -1 -1 0 0 0 0 10000 gen_car18	//Park north east little italy
SWITCH_CAR_GENERATOR gen_car18 101

CREATE_CAR_GENERATOR 1407.6 -176.1 -100.0 140.0	CAR_MAFIA -1 -1 0 0 0 0 10000 gen_car57	//Park north east little italy
SWITCH_CAR_GENERATOR gen_car57 101

CREATE_CAR_GENERATOR 1405.0 -163.4 -100.0 280.0	CAR_MAFIA -1 -1 0 0 0 0 10000 gen_car58	//Park north east little italy
SWITCH_CAR_GENERATOR gen_car58 101

//HARWOOD
CREATE_CAR_GENERATOR 1217.0 -70.0 -100.0 0.0 CAR_BOBCAT -1 -1 0 60 0 0 10000 gen_car19 //Used car lot
SWITCH_CAR_GENERATOR gen_car19 101

CREATE_CAR_GENERATOR 1234.0 -97.0 -100.0 0.0 CAR_PERENNIAL -1 -1 0 60 0 0 10000 gen_car20 //Used car lot
SWITCH_CAR_GENERATOR gen_car20 101

CREATE_CAR_GENERATOR 1107.5 -58.0 -100.0 270.0 CAR_FIRETRUCK -1 -1 0 0 0 0 10000 gen_car21 //AT fire station
SWITCH_CAR_GENERATOR gen_car21 101

CREATE_CAR_GENERATOR 1226.7 -68.0 -100.0 0.0 CAR_KURUMA -1 -1 0 0 0 0 10000 gen_car22 //Used car lot
SWITCH_CAR_GENERATOR gen_car22 101

CREATE_CAR_GENERATOR 973.3 -55.1 -100.0 270.0 CAR_MOONBEAM -1 -1 0 40 0 0 10000 gen_car24 //Car park near radio station
SWITCH_CAR_GENERATOR gen_car24 101

CREATE_CAR_GENERATOR 982.15 -36.61 -100.0 90.0 CAR_KURUMA -1 -1 0 90 0 0 10000 gen_car25 //Car park near radio station
SWITCH_CAR_GENERATOR gen_car25 101

CREATE_CAR_GENERATOR 1263.5 -69.5 -100.0 270.0 CAR_RUMPO -1 -1 0 0 0 0 10000 gen_car59 //By 8Balls garage
SWITCH_CAR_GENERATOR gen_car59 101

//HEPBURN HEIGHTS
CREATE_CAR_GENERATOR 986.2 -146.3 4.5 270.0 CAR_STALLION -1 -1 0 10 0 0 10000 gen_car23 //Tower block carpark North east
SWITCH_CAR_GENERATOR gen_car23 101

//CHINATOWN

CREATE_CAR_GENERATOR 1027.5 -873.1 14.5 270.0 CAR_IDAHO -1 -1 0 40 0 0 10000 gen_car28 //Fuzzball car park
#ifdef _DEBUG
SWITCH_CAR_GENERATOR gen_car28 101
#else
SWITCH_CAR_GENERATOR gen_car28 0
#endif

CREATE_CAR_GENERATOR 1006.18 -838.49 14.5 90.0 CAR_ESPERANTO -1 -1 0 50 0 0 10000 gen_car29 //Fuzzball car park
#ifdef _DEBUG
SWITCH_CAR_GENERATOR gen_car29 101
#else
SWITCH_CAR_GENERATOR gen_car29 0
#endif

CREATE_CAR_GENERATOR 857.1 -790.19 14.5 0.0 CAR_PONY -1 -1 0 90 0 0 10000 gen_car30 //South west Chinatown (down alleyway that leads to roof)
SWITCH_CAR_GENERATOR gen_car30 101

CREATE_CAR_GENERATOR 866.9 -663.7 -100.0 270.0 CAR_MRWONGS -1 -1 0 100 0 0 10000 gen_car31 //Back of laundrette
SWITCH_CAR_GENERATOR gen_car31 101

CREATE_CAR_GENERATOR 861.9 -546.0 -100.0 177.0 CAR_BELLYUP -1 -1 0 0 0 0 10000 gen_car53 //Fish warehouses
SWITCH_CAR_GENERATOR gen_car53 101

//TRENTON
//CREATE_CAR_GENERATOR 1119.0 -763.0 -100.0 0.0 CAR_MANANA -1 -1 0 10 0 0 10000 gen_car7 //Just south of the police station
//SWITCH_CAR_GENERATOR gen_car7 101

CREATE_CAR_GENERATOR 1119.04 -770.45 14.3 180.0 CAR_PERENNIAL -1 -1 0 10 0 0 10000 gen_car8 //Just south of the police station
SWITCH_CAR_GENERATOR gen_car8 101

CREATE_CAR_GENERATOR 1102.84 -983.51 14.6 270.0 CAR_RUMPO -1 -1 0 90 0 0 10000 gen_car32 // South west trenton (nect to the sawmill)
SWITCH_CAR_GENERATOR gen_car32 101

//CREATE_CAR_GENERATOR 1103.05 -976.43 14.6 270.0 CAR_MULE -1 -1 0 0 0 0 10000 gen_car33	// South west trenton (nect to the sawmill)
//SWITCH_CAR_GENERATOR gen_car33 101

CREATE_CAR_GENERATOR 1242.9 -730.5 14.8 311.0 CAR_CABBIE -1 -1 0 0 0 0 10000 gen_car34 //At Taxi depot
SWITCH_CAR_GENERATOR gen_car34 101

//CREATE_CAR_GENERATOR 1244.4 -732.2 14.8 135.0 CAR_TAXI -1 -1 0 0 0 0 10000 gen_car35 //At Taxi depot
//SWITCH_CAR_GENERATOR gen_car35 101

CREATE_CAR_GENERATOR 1220.9 -899.0 -100.0 177.4 CAR_STALLION -1 -1 0 80 0 0 10000 gen_car36 //Next to Joeys (AMco car park)
SWITCH_CAR_GENERATOR gen_car36 101

CREATE_CAR_GENERATOR 1226.4 -882.1 -100.0 314.9 CAR_PONY -1 -1 0 10 0 0 10000 gen_car37 //Next to Joeys (AMco car park)
SWITCH_CAR_GENERATOR gen_car37 101

CREATE_CAR_GENERATOR 1277.5 -990.0 14.2 225.0 CAR_COACH -1 -1 0 100 0 0 10000 gen_car38 //At bus Depot
SWITCH_CAR_GENERATOR gen_car38 101

//CREATE_CAR_GENERATOR 1256.6 -992.3 14.2 45.0 CAR_COACH -1 -1 0 100 0 0 10000 gen_car39 //At bus Depot
//SWITCH_CAR_GENERATOR gen_car39 101

CREATE_CAR_GENERATOR 1278.0 -973.3 14.2 45.0 CAR_COACH -1 -1 0 100 0 0 10000 gen_car40 //At bus Depot
SWITCH_CAR_GENERATOR gen_car40 101


//PORTLAND HARBOUR (DOCKS)
CREATE_CAR_GENERATOR 1427.01 -786.75 -100.0 90.0 CAR_PERENNIAL -1 -1 0 0 0 0 10000 gen_car41 //Docks car park
SWITCH_CAR_GENERATOR gen_car41 101

CREATE_CAR_GENERATOR 1407.59 -791.2 -100.0 270.0 CAR_MULE -1 -1 0 20 0 0 10000 gen_car42 //Docks car park
SWITCH_CAR_GENERATOR gen_car42 101

CREATE_CAR_GENERATOR 1427.43 -799.69 -100.0 270.0 CAR_KURUMA -1 -1 0 90 0 0 10000 gen_car43 //Docks car park
SWITCH_CAR_GENERATOR gen_car43 101

CREATE_CAR_GENERATOR 1545.1 -845.6 -100.0 269.9 CAR_YANKEE -1 -1 0 0 0 0 10000 gen_car54 //Docks
SWITCH_CAR_GENERATOR gen_car54 101

CREATE_CAR_GENERATOR 1495.1 -810.9 11.9 182.4 CAR_MULE -1 -1 0 0 0 0 10000 gen_car55 //Docks
SWITCH_CAR_GENERATOR gen_car55 101

CREATE_CAR_GENERATOR 1576.8 -715.1 -100.0 93.0 CAR_YANKEE -1 -1 0 0 0 0 10000 gen_car56 //Docks
SWITCH_CAR_GENERATOR gen_car56 101

CREATE_CAR_GENERATOR 1368.1 -1026.0 -100.0 0.0 CAR_LINERUNNER -1 -1 0 0 0 0 10000 gen_car33 //Docks by unique jump
SWITCH_CAR_GENERATOR gen_car33 101


//CALLAHAN POINT
CREATE_CAR_GENERATOR 856.38 -993.76 4.6 0.0 CAR_KURUMA -1 -1 0 0 0 0 10000 gen_car44 //Greasy joes car park
SWITCH_CAR_GENERATOR gen_car44 101

CREATE_CAR_GENERATOR 898.21 -996.86 4.6 90.0 CAR_LINERUNNER -1 -1 0 0 0 0 10000 gen_car45 //Greasy joes car park
SWITCH_CAR_GENERATOR gen_car45 101

CREATE_CAR_GENERATOR 874.3 -983.74 4.6 90.0 CAR_MOONBEAM -1 -1 0 0 0 0 10000 gen_car46 //Greasy joes car park
SWITCH_CAR_GENERATOR gen_car46 101

CREATE_CAR_GENERATOR 978.6 -1093.0 13.3 0.0 CAR_BELLYUP -1 -1 0 0 0 0 10000 gen_car47 //Fish Factory
SWITCH_CAR_GENERATOR gen_car47 101

CREATE_CAR_GENERATOR 996.3 -1127.5 13.3 270.0 CAR_BELLYUP -1 -1 0 100 0 0 10000 gen_car48 //Fish Factory
SWITCH_CAR_GENERATOR gen_car48 101

CREATE_CAR_GENERATOR 1012.5 -1141.0 13.3 180.0 CAR_BELLYUP -1 -1 0 0 0 0 10000 gen_car49 //Fish Factory
SWITCH_CAR_GENERATOR gen_car49 101


//REDLIGHT DISTRICT
CREATE_CAR_GENERATOR 973.0 -420.0 14.5 0.0 CAR_PERENNIAL -1 -1 0 0 0 0 10000 gen_car51 //Back alleyway in Redlight district
SWITCH_CAR_GENERATOR gen_car51 101

//CRUSHER
CREATE_CAR_GENERATOR 1111.8  45.0 -100.0 266.0 CAR_PONY -1 -1 0 0 0 0 10000 gen_car52 //By crusher
SWITCH_CAR_GENERATOR gen_car52 101

//BEACH
CREATE_CAR_GENERATOR 1460.5 -345.0 -100.0 270.0 CAR_BOBCAT -1 -1 0 0 0 0 10000 gen_car64 //Fish Factory
SWITCH_CAR_GENERATOR gen_car64 101

// *************************************COMMERCIAL CAR GENERATORS*****************************
VAR_INT com_car1 com_car2 com_car3 com_car4 com_car5 com_car6 com_car7 com_car8 com_car9 com_car10 phil_car
VAR_INT	com_car11 com_car12 com_car13 com_car14 com_car15 com_car16 com_car17 com_car18 com_car19 com_car20
VAR_INT com_car21 com_car22 com_car23 com_car24	com_car25 com_car26 com_car27 com_car28 com_car29 com_car30
VAR_INT com_car31 com_car32 com_car33 com_car34	com_car35 com_car36 com_car37 com_car38 com_car39 com_car40
VAR_INT com_car41 com_car42 com_car43 com_car44	com_car45 com_car46 com_car47 com_car48 com_car49 special_tank

//CREATE_CAR_GENERATOR CarModel Remap1 Remap2 ParkedFlag ChanceOfCarAlarm ChanceOfLocked MinDelay MaxDelay CarGenID

CREATE_CAR_GENERATOR 354.2 -1055.9 -100.0 0.0 CAR_POLICE -1 -1 0 0 0 0 10000 com_car1 //At police station
SWITCH_CAR_GENERATOR com_car1 101

CREATE_CAR_GENERATOR 340.1 -1055.9 -100.0 90.0 CAR_ENFORCER -1 -1 0 0 0 0 10000 com_car2 //At police station
SWITCH_CAR_GENERATOR com_car2 101

CREATE_CAR_GENERATOR 356.5 -1170.3 22.0 0.0 CAR_POLICE -1 -1 0 0 0 0 10000 com_car25 //At police station
SWITCH_CAR_GENERATOR com_car25 101

CREATE_CAR_GENERATOR 334.4 -1151.0 22.0 90.0 CAR_SENTINEL -1 -1 0 70 0 0 10000 com_car26 //At police station
SWITCH_CAR_GENERATOR com_car26 101

//HOSPITAL
CREATE_CAR_GENERATOR 194.7 -41.1 -100.0 0.0 CAR_AMBULANCE -1 -1 0 0 0 0 10000 com_car3 //At Hospital
SWITCH_CAR_GENERATOR com_car3 101

CREATE_CAR_GENERATOR 216.5 -40.8 -100.0 180.0 CAR_AMBULANCE -1 -1 0 0 0 0 10000 com_car4 //At Hospital
SWITCH_CAR_GENERATOR com_car4 101

CREATE_CAR_GENERATOR 315.9 -7.0 -100.0 212.1 CAR_MOONBEAM -1 -1 0 50 0 0 10000 com_car5 //At Hospital car park
SWITCH_CAR_GENERATOR com_car5 101

CREATE_CAR_GENERATOR 216.5 -40.8 -100.0 180.0 CAR_ESPERANTO -1 -1 0 50 0 0 10000 com_car6 //At Hospital car park
SWITCH_CAR_GENERATOR com_car6 101

CREATE_CAR_GENERATOR 315.9 -7.0 -100.0 212.1 CAR_KURUMA -1 -1 0 50 0 0 10000 com_car7 //At Hospital car park
SWITCH_CAR_GENERATOR com_car7 101

CREATE_CAR_GENERATOR 299.3 10.8 -100.0 35.5 CAR_BOBCAT -1 -1 0 50 0 0 10000 com_car8 //At Hospital car park
SWITCH_CAR_GENERATOR com_car8 101

CREATE_CAR_GENERATOR 338.7 -4.6 -100.0 267.7 CAR_STALLION -1 -1 0 50 0 0 10000 com_car9 //At Hospital car park
SWITCH_CAR_GENERATOR com_car9 101

CREATE_CAR_GENERATOR 358.7 11.7 -100.0 272.7 CAR_RUMPO -1 -1 0 50 0 0 10000 com_car10 //At Hospital car park
SWITCH_CAR_GENERATOR com_car10 101

//ASUKAS
CREATE_CAR_GENERATOR 500.0 -659.4 -100.0 0.0 CAR_YAKUZA -1 -1 0 0 0 0 10000 com_car11 //By Asukas place
SWITCH_CAR_GENERATOR com_car11 101

CREATE_CAR_GENERATOR 486.5 -643.6 -100.0 180.0 CAR_BLISTA -1 -1 0 40 0 0 10000 com_car12 //By Asukas place
SWITCH_CAR_GENERATOR com_car12 101

CREATE_CAR_GENERATOR 475.5 -617.4 15.2 0.0 CAR_YAKUZA -1 -1 0 0 0 0 10000 com_car20 //By Asukas place
SWITCH_CAR_GENERATOR com_car20 101

CREATE_CAR_GENERATOR 485.0 -710.0 -100.0 270.0 CAR_LANDSTALKER -1 -1 0 60 0 0 10000 com_car21 //By Asukas place
SWITCH_CAR_GENERATOR com_car21 101

CREATE_CAR_GENERATOR 477.6 -731.4 -100.0 90.0 CAR_BANSHEE -1 -1 0 80 0 0 10000 com_car27 //By Asukas place
SWITCH_CAR_GENERATOR com_car27 101

//BELLEVILLE PARK
CREATE_CAR_GENERATOR 63.4 -591.3 25.9 90.0 CAR_LANDSTALKER -1 -1 0 0 0 0 10000 com_car28 //By cottage
SWITCH_CAR_GENERATOR com_car28 101

//TORRINGTON
CREATE_CAR_GENERATOR 233.5 -1236.7 20.5 0.0 CAR_MANANA -1 -1 0 20 0 0 10000 com_car29 //Underground car park
SWITCH_CAR_GENERATOR com_car29 101

CREATE_CAR_GENERATOR 259.2 -1196.7 20.5 90.0 CAR_YAKUZA -1 -1 0 60 40 0 10000 com_car30 //Underground car park
SWITCH_CAR_GENERATOR com_car30 101

CREATE_CAR_GENERATOR 228.8 -1205.7 20.5 180.0 CAR_BLISTA -1 -1 0 30 40 0 10000 com_car31 //Underground car park
SWITCH_CAR_GENERATOR com_car31 101

CREATE_CAR_GENERATOR 211.5 -1213.5 20.5 90.0 CAR_KURUMA -1 -1 0 20 70 0 10000 com_car32 //Underground car park
SWITCH_CAR_GENERATOR com_car32 101

CREATE_CAR_GENERATOR 458.9 -1503.4 -100.0 0.0 CAR_SENTINEL -1 -1 0 20 70 0 10000 com_car33 //Casino car park
SWITCH_CAR_GENERATOR com_car33 101

CREATE_CAR_GENERATOR 442.7 -1465.7 18.4 180.0 CAR_YAKUZA -1 -1 0 50 50 0 10000 com_car34 //Casino car park
SWITCH_CAR_GENERATOR com_car34 101

CREATE_CAR_GENERATOR 424.4 -1501.0 -100.0 90.0 CAR_IDAHO -1 -1 0 30 30 0 10000 com_car35 //Casino car park
SWITCH_CAR_GENERATOR com_car35 101

CREATE_CAR_GENERATOR 476.1 -1496.4 -100.0 220.0 CAR_BANSHEE -1 -1 0 80 0 0 10000 com_car36 //Casino car park
SWITCH_CAR_GENERATOR com_car36 101


//FORT STAUNTON
CREATE_CAR_GENERATOR 352.4 -345.5 -100.0 180.0 CAR_COLUMB -1 -1 0 0 30 0 10000 com_car37 //Construction site
SWITCH_CAR_GENERATOR com_car37 101

CREATE_CAR_GENERATOR 394.7 -171.4 -100.0 295.0 CAR_COLUMB -1 -1 0 20 30 0 10000 com_car38 //Construction site
SWITCH_CAR_GENERATOR com_car38 101

CREATE_CAR_GENERATOR 388.0 -95.0 -100.0 65.0 CAR_PANLANT -1 -1 0 0 0 0 10000 com_car39 //Construction site
SWITCH_CAR_GENERATOR com_car39 101

CREATE_CAR_GENERATOR 302.9 -245.2 -100.0 270.0 CAR_PANLANT -1 -1 0 0 0 0 10000 com_car40 //Construction site
SWITCH_CAR_GENERATOR com_car40 101

CREATE_CAR_GENERATOR 339.8449 -290.6314 16.0 158.2191 CAR_YAKUZA -1 -1 0 0 0 0 10000 gen_car60 //Construction site
SWITCH_CAR_GENERATOR gen_car60 0

CREATE_CAR_GENERATOR 359.1079 -291.0880 16.0 146.8412 CAR_YAKUZA -1 -1 0 0 0 0 10000 gen_car61 //Construction site
SWITCH_CAR_GENERATOR gen_car61 0

CREATE_CAR_GENERATOR 361.9012 -339.1167 16.0 339.3615 CAR_YAKUZA -1 -1 0 0 0 0 10000 gen_car62 //Construction site
SWITCH_CAR_GENERATOR gen_car62 0



//ASPATRIA
CREATE_CAR_GENERATOR -51.6 -324.0 -100.0 90.0 CAR_BOBCAT -1 -1 0 30 30 0 10000 com_car41 //Stadium Parking Lot
SWITCH_CAR_GENERATOR com_car41 101

CREATE_CAR_GENERATOR -40.5 -346.8 -100.0 270.0 CAR_IDAHO -1 -1 0 30 30 0 10000 com_car42 //Stadium Parking Lot
SWITCH_CAR_GENERATOR com_car42 101

CREATE_CAR_GENERATOR -30.0 -366.9 -100.0 270.0 CAR_MULE -1 -1 0 30 30 0 10000 com_car43 //Stadium Parking Lot
SWITCH_CAR_GENERATOR com_car43 101

CREATE_CAR_GENERATOR -62.3 -344.1 -100.0 90.0 CAR_BLISTA -1 -1 0 30 30 0 10000 com_car44 //Stadium Parking Lot
SWITCH_CAR_GENERATOR com_car44 101

CREATE_CAR_GENERATOR -72.2 -332.5 -100.0 270.0 CAR_STALLION -1 -1 0 30 30 0 10000 com_car45 //Stadium Parking Lot
SWITCH_CAR_GENERATOR com_car45 101

CREATE_CAR_GENERATOR -83.9 -443.6 -100.0 90.0 CAR_FIRETRUCK -1 -1 0 0 0 0 10000 gen_car35 //AT fire station
SWITCH_CAR_GENERATOR gen_car35 101

//NEWPORT
CREATE_CAR_GENERATOR 301.71 -582.55 25.9 270.72 CAR_ESPERANTO -1 -1 0 70 0 0 10000 com_car15 //Multi story car park
SWITCH_CAR_GENERATOR com_car15 101

CREATE_CAR_GENERATOR 302.42 -562.54 25.9 88.21 CAR_RUMPO -1 -1 0 70 0 0 10000 com_car16 //Multi story car park
SWITCH_CAR_GENERATOR com_car16 101

CREATE_CAR_GENERATOR 283.21 -566.47 25.9 91.84 CAR_STALLION -1 -1 0 70 0 0 10000 com_car17 //Multi story car park
SWITCH_CAR_GENERATOR com_car17 101

CREATE_CAR_GENERATOR 302.2400 -510.4034 25.9 269.54 CAR_BLISTA -1 -1 0 70 0 0 10000 com_car19 //Multi story car park
SWITCH_CAR_GENERATOR com_car19 101

CREATE_CAR_GENERATOR 324.5 -455.9 22.5 90.0 CAR_BLISTA -1 -1 0 50 0 0 10000 com_car24 //Behind Multi story
SWITCH_CAR_GENERATOR com_car24 101


//BOATS
CREATE_CAR_GENERATOR 593.3 -664.0 0.0 0.0 BOAT_SPEEDER -1 -1 0 0 0 0 10000 com_car13 //At Asukas Jetty
SWITCH_CAR_GENERATOR com_car13 101

CREATE_CAR_GENERATOR 568.0 -686.0 0.0 180.0 BOAT_REEFER -1 -1 0 0 0 0 10000 com_car23 //At Asukas Jetty
SWITCH_CAR_GENERATOR com_car23 0

CREATE_CAR_GENERATOR 592.4 -766.7 0.0 0.0 BOAT_REEFER -1 -1 0 0 0 0 10000 com_car14 //Jetty south of Asukas
SWITCH_CAR_GENERATOR com_car14 101

CREATE_CAR_GENERATOR 554.8 -767.6 0.0 0.0 BOAT_PREDATOR	-1 -1 0 0 0 0 10000 com_car22 //Jetty south of Asukas
SWITCH_CAR_GENERATOR com_car22 101

CREATE_CAR_GENERATOR 133.56 208.76 11.93 180.0 CAR_BARRACKS -1 -1 0 0 0 10000 40000 phil_car //PHIL'S TRUCK--------
SWITCH_CAR_GENERATOR phil_car 101

//Kingdom Come carpark
CREATE_CAR_GENERATOR -52.28 -1458.3 26.15 90.0 CAR_MOONBEAM -1 -1 0 20 20 0 10000 com_car46
SWITCH_CAR_GENERATOR com_car46 101

CREATE_CAR_GENERATOR -77.5 -1485.0 26.0 90.0 CAR_KURUMA -1 -1 0 20 20 0 10000 com_car47
SWITCH_CAR_GENERATOR com_car47 101

CREATE_CAR_GENERATOR -70.9 -1443.6 25.8 180.0 CAR_STINGER -1 -1 0 40 40 0 10000 com_car48
SWITCH_CAR_GENERATOR com_car48 101

//Underground Bedford Point

CREATE_CAR_GENERATOR 9.5 -1475.7 19.7 0.0 CAR_RUMPO -1 -1 0 40 40 0 10000 com_car49
SWITCH_CAR_GENERATOR com_car49 101

CREATE_CAR_GENERATOR 132.0 173.9 11.6 0.0 CAR_RHINO -1 -1 0 0 0 0 10000 special_tank
SWITCH_CAR_GENERATOR special_tank 0

// *************************************SUBURBAN CAR GENERATORS******************************
VAR_INT sub_car1 sub_car2 sub_car3 sub_car4 sub_car5 sub_car6 sub_car7 sub_car8 sub_car9
VAR_INT sub_car10 sub_car11 sub_car12 sub_car13 sub_car14 sub_car15 sub_car16 sub_car17 sub_car18 sub_car19
VAR_INT sub_car20 sub_car21 sub_car22 sub_car23 sub_car24 sub_car25 sub_car26 sub_car27 sub_car28 sub_car29
VAR_INT sub_car30 sub_car31 sub_car32 sub_car33 sub_car34 sub_car35 sub_car36 sub_car37 sub_car38 sub_car39
VAR_INT sub_car40 sub_car41 sub_car42 sub_car43 sub_car44 sub_car45 sub_car46

//CREATE_CAR_GENERATOR X Y Z Rot CarModel Remap1 Remap2 ParkedFlag ChanceOfCarAlarm ChanceOfLocked MinDelay MaxDelay CarGenID

CREATE_CAR_GENERATOR -458.4 268.0 -100.0 180.0 CAR_CHEETAH -1 -1 0 100 0 0 10000 sub_car1 //Swankville carpark
SWITCH_CAR_GENERATOR sub_car1 101

CREATE_CAR_GENERATOR -585.1 265.0 -100.0 0.0 CAR_LANDSTALKER -1 -1 0 100 0 0 10000 sub_car2 //Swankville carpark
SWITCH_CAR_GENERATOR sub_car2 101

CREATE_CAR_GENERATOR -712.1 263.6 -100.0 180.0 CAR_STINGER -1 -1 0 100 0 0 10000 sub_car3 //Swankville carpark
SWITCH_CAR_GENERATOR sub_car3 101

CREATE_CAR_GENERATOR -1249.1 -92.5 -100.0 90.0 CAR_AMBULANCE -1 -1 0 0 0 0 10000 sub_car4 //At Hospital
SWITCH_CAR_GENERATOR sub_car4 101

CREATE_CAR_GENERATOR -1266.0 -37.7 -100.0 160.0 CAR_POLICE -1 -1 0 0 50 0 10000 sub_car5 //At police station
SWITCH_CAR_GENERATOR sub_car5 101

CREATE_CAR_GENERATOR -402.0 291.6 -100.0 252.0 CAR_COLUMB -1 -1 0 0 0 0 10000 sub_car6 //Swankville carpark
SWITCH_CAR_GENERATOR sub_car6 101

CREATE_CAR_GENERATOR -218.5 263.7 3.5 90.0 CAR_PATRIOT -1 -1 0 0 0 0 10000 sub_car7 //Picnic area
SWITCH_CAR_GENERATOR sub_car7 101

CREATE_CAR_GENERATOR -839.4 -463.8 -100.0 90.0 CAR_FIRETRUCK -1 -1 0 0 0 0 10000 sub_car25 //AT airport
SWITCH_CAR_GENERATOR sub_car25 101

CREATE_CAR_GENERATOR -1268.4851 -528.6431 10.2 180.0 PLANE_DODO -1 -1 0 0 0 0 10000 gen_car63 //At airport
SWITCH_CAR_GENERATOR gen_car63 0

CREATE_CAR_GENERATOR -755.0409 204.3065 27.7 179.8454 CAR_BANSHEE -1 -1 0 80 0 0 10000 sub_car40//projects
SWITCH_CAR_GENERATOR sub_car40 101

CREATE_CAR_GENERATOR -724.7776 180.2350 27.7 182.0509 CAR_STALLION -1 -1 0 70 5 0 10000 sub_car41//projects
SWITCH_CAR_GENERATOR sub_car41 101

CREATE_CAR_GENERATOR -668.2543 99.3071 17.8 359.5899 CAR_BLISTA -1 -1 0 70 5 0 10000 sub_car42//projects
SWITCH_CAR_GENERATOR sub_car42 101

CREATE_CAR_GENERATOR -449.9598 -13.2082 2.9 0.6847 CAR_COLUMB -1 -1 0 70 5 0 10000 sub_car43//projects
SWITCH_CAR_GENERATOR sub_car43 101

CREATE_CAR_GENERATOR -510.8174 74.5390 2.9 0.2808 CAR_LANDSTALKER -1 -1 0 70 5 0 10000 sub_car44//projects
SWITCH_CAR_GENERATOR sub_car44 101

CREATE_CAR_GENERATOR -217.6635 318.7584 2.5 358.8526 CAR_BOBCAT -1 -1 0 70 2 0 10000 sub_car45//projects
SWITCH_CAR_GENERATOR sub_car45 101

CREATE_CAR_GENERATOR -561.3663 -6.3410 2.9 91.0259 CAR_KURUMA -1 -1 0 70 1 0 10000 sub_car46//projects
SWITCH_CAR_GENERATOR sub_car46 101

// ********************AIRPORT CARPARK********************************************************

CREATE_CAR_GENERATOR -896.68 -414.2 11.25 90.0 CAR_LANDSTALKER -1 -1 0 20 20 0 10000 sub_car8 //AT airport
SWITCH_CAR_GENERATOR sub_car8 101

CREATE_CAR_GENERATOR -896.68 -395.2 11.25 270.0 CAR_BLISTA -1 -1 0 20 40 0 10000 sub_car9 //AT airport
SWITCH_CAR_GENERATOR sub_car9 101

CREATE_CAR_GENERATOR -882.1 -391.7 11.0 0.0 CAR_STALLION -1 -1 0 30 20 0 10000 sub_car10 //AT airport
SWITCH_CAR_GENERATOR sub_car10 101

CREATE_CAR_GENERATOR -862.9 -404.4 11.0 180.0 CAR_INFERNUS -1 -1 0 60 20 0 10000 sub_car11 //AT airport
SWITCH_CAR_GENERATOR sub_car11 101

CREATE_CAR_GENERATOR -846.65 -413.6 11.0 180.0 CAR_SENTINEL -1 -1 0 30 40 0 10000 sub_car12 //AT airport
SWITCH_CAR_GENERATOR sub_car12 101

CREATE_CAR_GENERATOR -814.85 -372.4 11.0 180.0 CAR_MANANA -1 -1 0 10 20 0 10000 sub_car13 //AT airport
SWITCH_CAR_GENERATOR sub_car13 101

CREATE_CAR_GENERATOR -821.2 -404.7 11.0 180.0 CAR_RUMPO -1 -1 0 10 10 0 10000 sub_car14 //AT airport
SWITCH_CAR_GENERATOR sub_car14 101

CREATE_CAR_GENERATOR -767.9 -404.65 11.0 0.0 CAR_TAXI -1 -1 0 10 20 0 10000 sub_car15 //AT airport
SWITCH_CAR_GENERATOR sub_car15 101

CREATE_CAR_GENERATOR -773.4 -373.13 11.0 180.0 CAR_ESPERANTO -1 -1 0 20 20 0 10000 sub_car16 //AT airport
SWITCH_CAR_GENERATOR sub_car16 101

// *****************************OUT FRONT OF AIRPORT**************************************

CREATE_CAR_GENERATOR -750.4 -603.13 11.0 270.0 CAR_TAXI -1 -1 0 20 20 0 10000 sub_car19 //AT airport
SWITCH_CAR_GENERATOR sub_car19 101

CREATE_CAR_GENERATOR -750.4 -567.13 11.0 270.0 CAR_TAXI -1 -1 0 20 20 0 10000 sub_car20 //AT airport
SWITCH_CAR_GENERATOR sub_car20 101

//  **************************AIRSTRIP*************************************************
CREATE_CAR_GENERATOR -856.4 -1228.13 1.0 250.0 BOAT_SPEEDER -1 -1 0 0 0 0 10000 sub_car17 //Runway
SWITCH_CAR_GENERATOR sub_car17 101

CREATE_CAR_GENERATOR -1126.4 -1034.13 1.0 270.0 BOAT_PREDATOR -1 -1 0 0 0 0 10000 sub_car18 //Runway
SWITCH_CAR_GENERATOR sub_car18 101

CREATE_CAR_GENERATOR -1574.0 -873.0 11.0 90.0 CAR_POLICE -1 -1 0 0 0 0 10000 sub_car21 //POLICE HELIPAD
SWITCH_CAR_GENERATOR sub_car21 101

CREATE_CAR_GENERATOR -1073.0 -753.0 11.0 360.0 CAR_RUMPO -1 -1 0 20 10 0 10000 sub_car22 //FREIGHT TERMINAL
SWITCH_CAR_GENERATOR sub_car22 101

CREATE_CAR_GENERATOR -1088.0 -753.0 11.0 360.0 CAR_RUMPO -1 -1 0 20 10 0 10000 sub_car23 //FREIGHT TERMINAL
SWITCH_CAR_GENERATOR sub_car23 101

CREATE_CAR_GENERATOR -848.0 -657.0 11.0 90.0 CAR_RUMPO -1 -1 0 20 10 0 10000 sub_car24 //FREIGHT TERMINAL
SWITCH_CAR_GENERATOR sub_car24 101

CREATE_CAR_GENERATOR -847.5811 -753.2242 10.2 143.6972 PLANE_DODO -1 -1 0 0 0 0 10000 sub_car30 //IN HANGAR
SWITCH_CAR_GENERATOR sub_car30 101

CREATE_CAR_GENERATOR -1525.3434 -924.3124 10.2 246.7710 PLANE_DODO -1 -1 0 0 0 0 10000 sub_car31 //WEST AIRPORT BY CHOPPERS
SWITCH_CAR_GENERATOR sub_car31 101

}

MISSION_END

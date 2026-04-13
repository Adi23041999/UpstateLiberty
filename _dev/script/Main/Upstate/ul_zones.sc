// *************************************UPSTATE LIBERTY ZONES***************************
// Authors:
// Adi

ul_zones:

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
SET_ZONE_GROUP SUMMER DAY SHOPPING_PEDGRP
SET_ZONE_GROUP SUMMER NIGHT SHOPPING_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTWCENT DAY   (30) 0 0 0 0 0 0 0 20  // Central
SETUP_ZONE_PED_INFO GTWCENT NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTWCENT DAY   (20) 0 0 0 0 0 0 0 30 300 250 200 50 50 100
SETUP_ZONE_CAR_INFO GTWCENT NIGHT (17) 0 0 0 0 0 0 0 20 350 300 200  0  0 100
SET_ZONE_GROUP GTWCENT DAY SHOPPING_PEDGRP
SET_ZONE_GROUP GTWCENT NIGHT SHOPPING_NIGHT_PEDGRP

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
SET_ZONE_GROUP GTMALL NIGHT SHOPPING_NIGHT_PEDGRP

SETUP_ZONE_PED_INFO GTHOSP DAY   (30) 0 0 0 0 0 0 0 20  // GT Hospital
SETUP_ZONE_PED_INFO GTHOSP NIGHT (16) 0 0 0 0 0 0 0 10
SETUP_ZONE_CAR_INFO GTHOSP DAY   (20) 0 0 0 0 0 0 0 30 300 250 200 50 50 100
SETUP_ZONE_CAR_INFO GTHOSP NIGHT (17) 0 0 0 0 0 0 0 20 350 300 200  0  0 100
SET_ZONE_GROUP GTHOSP DAY HOSPITAL_PEDGRP
SET_ZONE_GROUP GTHOSP NIGHT HOSPITAL_NIGHT_PEDGRP

// Highway info zones

VAR_INT hw_dens_day_ped, hw_dens_nit_ped, hw_dens_day_car, hw_dens_nit_car
VAR_INT hw_poli_day_ped, hw_poli_nit_ped, hw_poli_day_car, hw_poli_nit_car
VAR_INT hw_poor_day, hw_poor_nit, hw_rich_day, hw_rich_nit, hw_exec_day, hw_exec_nit, hw_work_day, hw_work_nit, hw_spec_day, hw_spec_nit, hw_big_day, hw_big_nit

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

RETURN
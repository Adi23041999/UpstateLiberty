// *************************************UPSTATE LIBERTY OBJECTS***************************
// Authors:
// Adi

ul_objects:

VAR_INT ul_gt_police_door
VAR_INT ul_lcc_mansion_door ul_t2_safehouse_door ul_gt_safehouse_door

CREATE_OBJECT_NO_OFFSET electricgate 1438.894 1656.444 125.939 ul_gt_police_door
DONT_REMOVE_OBJECT ul_gt_police_door
SET_OBJECT_HEADING ul_gt_police_door 180.0

CREATE_OBJECT_NO_OFFSET lcc_wmandoor01 -1551.993 696.911 109.75 ul_lcc_mansion_door
DONT_REMOVE_OBJECT ul_lcc_mansion_door
SET_OBJECT_HEADING ul_lcc_mansion_door -20.0

CREATE_OBJECT_NO_OFFSET gtw_subhdoor01 -370.364 1319.592 113.086 ul_t2_safehouse_door
DONT_REMOVE_OBJECT ul_t2_safehouse_door
SET_OBJECT_HEADING ul_t2_safehouse_door 90.0

CREATE_OBJECT_NO_OFFSET gtw_residdoor02 1387.097 1019.57 124.001 ul_gt_safehouse_door
DONT_REMOVE_OBJECT ul_gt_safehouse_door
SET_OBJECT_HEADING ul_gt_safehouse_door 0.0

RETURN
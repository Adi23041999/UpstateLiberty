
info_pickups:

// UPSTATE: The remaining pickups moved to initial.sc

//INFO PICKUPS***********************************************************************************

//health info/wanted info
VAR_INT heal_info wanted_info flag_health_info flag_wanted_info
VAR_INT heal_info_trip wanted_info_trip
 
flag_health_info = 0
flag_wanted_info = 0
heal_info_trip = 0
wanted_info_trip = 0

CREATE_PICKUP info PICKUP_ON_STREET 921.3 -352.8 10.9 info_pickup1 //Spray shop
START_NEW_SCRIPT check_info_pickup info_pickup1 1 1 // SCFIX: Extra parameter added

CREATE_PICKUP info PICKUP_ON_STREET 1279.5 -98.3 15.0 info_pickup2 //Bomb shop
START_NEW_SCRIPT check_info_pickup info_pickup2	2
CREATE_PICKUP info PICKUP_ON_STREET 1065.0 -392.8 14.9 info_pickup3	//Ammu nation
START_NEW_SCRIPT check_info_pickup info_pickup3	3 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 889.5 -316.1 8.7 info_pickup4 //Save garage 
START_NEW_SCRIPT check_info_pickup info_pickup4	4 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 889.5 -305.8 8.7 info_pickup5 //Save house
START_NEW_SCRIPT check_info_pickup info_pickup5 5 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 1130.4 52.8 0.4 info_pickup6 //Crusher
START_NEW_SCRIPT check_info_pickup info_pickup6 6
CREATE_PICKUP info PICKUP_ON_STREET 1028.8 -927.4 15.0 info_pickup7a //Callahan Bridge
START_NEW_SCRIPT check_info_pickup info_pickup7a 7 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 916.5 -472.0 -18.8 info_pickup7b //SUBWAY
START_NEW_SCRIPT check_info_pickup info_pickup7b 11
CREATE_PICKUP info PICKUP_ON_STREET 758.7 164.2 -19.9 info_pickup8 //Porter Tunnel 
START_NEW_SCRIPT check_info_pickup info_pickup8	8 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 991.9 -471.3 3.7 info_pickup9 //Tube -industrial
START_NEW_SCRIPT check_info_pickup info_pickup9 9 1 // SCFIX: Extra parameter added
CREATE_PICKUP info PICKUP_ON_STREET 1318.7 -524.9 43.3 info_pickup10a //A-trains
START_NEW_SCRIPT check_info_pickup info_pickup10a 10
CREATE_PICKUP info PICKUP_ON_STREET 772.0 -588.4 23.9 info_pickup10b //A-trains
START_NEW_SCRIPT check_info_pickup info_pickup10b 10
CREATE_PICKUP info PICKUP_ON_STREET 1039.0 -149.8 23.9 info_pickup10c //A-trains
START_NEW_SCRIPT check_info_pickup info_pickup10c 10

// UPSTATE: Tunnel opening info pickups
CREATE_PICKUP info PICKUP_ON_STREET -269.0 430.7 88.3 info_pickup11a // Upstate Tunnel
START_NEW_SCRIPT check_info_pickup info_pickup11a 12
CREATE_PICKUP info PICKUP_ON_STREET -878.6 579.6 77.7 info_pickup11b  // Upstate Tunnel
START_NEW_SCRIPT check_info_pickup info_pickup11b 12

RETURN
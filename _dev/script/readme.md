# SCFIX-Liberty

SCFIX-Liberty aims to provide bugfixes to the original scripts. Based off of [UndefinifiedLiberty](https://github.com/Sergeanur/UndefinifiedLiberty).

All changes to the scripts were marked with `SCFIX` comment.

Currently in beta status.

## Download SCM

Get latest release here: https://github.com/Sergeanur/SCFIX-Liberty/releases

## Installation

Replace main.scm inside data directory, but read save files compatibility note below first.

## List of changes

- Removed inability to start a mission if you jump onto a marker
- Fixed an extra reward not being given to the player in a mission "Smack Down"
- Fixed bums inside Portland tunnel spawning endlessly by standing on a tall vehicle
- Fixed destination blip position in a mission "I Scream, You Scream"
- Fixed Claude being seen as a boat driver during the cutscene in a mission "Last Requests"
- Fixed Securicar scratching the wall when driving into the garage in a mission "Escort Service"
- Fixed starting marker for the mission "The Fuzz Ball" changing its position after beating "Chaperone" mission
- Restored cut subtitles in "Bomb Da Base: Act I" cutscene
- Disabled Unique Stunt Jumps camera activating when driving Dodo
- Mafia shotguns are now being replaced with Uzis when activating Paramedic, Vigilante, Firefighter or Taxi Driver side activities (similarly to missions "Big'n'Veiny" and "Espresso-2-Go!")
- Fixed starting position for "Multistorey Mayhem" - now it triggers as soon as you enter the parked Stallion
- Fixed blip for Diablo missions staying after beating "Last Requests"
- Fixed taxi driver being able to become your passenger in a Taxi Driver side activity
- Fixed multiple markers showing at the hospital in Paramedic
- Restricted peds from spawning at covered areas of Staunton in Paramedic
- Changed patients behavior to only run towards stopped ambulance instead of while it's still moving in Paramedic
- Finishing 12 levels of Paramedic now prints "Ambulance missions complete!" instead of "Paramedic mission ended." as originally designed
- Removed 3.5 second wait before playing "Luigi's Girls" cutscene
- Bridge model swap by the intro cutscene made seamless
- LCPD wall model swap in "Kanbu Bust-out" made seamless
- Panlantic fence model swap in "Grand Theft Aero" made seamless
- Fixed Quadruple Insane Stunt
- Reimplement "Bling-Bling Scramble" random selection of a checkpoint pattern to fix the third pattern being unreachable
- Reimplement "Plaster Blaster" random selection of an ambulance path to fix the third path being unreachable
- Implemented fixes for potential SSU in the intro cutscene script
- Removed duplicate models loads during the jailbreak cutscene
- Fixed some models not being marked as no longer needed after being loaded by the jailbreak cutscene
- Fixed On Mission flag (flag_player_on_mission) sets to prevent any abuse of this flag
- Removed On Mission flag checks in some mission that were meant to bypass compiler errors

## Save files compatibility

At this point it's incompatible with old save files made with original scm. In future it's possible to come up with a save file converter once a stable release will be decided upon.

## How to compile

You need to get miss2.exe from 3master and then patch the 3master plague out of it.
To patch miss2.exe, put it in `patch` directory and launch **xdelta3.bat**. Now you can use miss2.exe that would produce correct compiled binaries.


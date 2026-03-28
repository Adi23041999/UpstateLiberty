@echo off
set gta3sc=%cd%\gta3sc\gta3sc.exe

rem Compile gta3sc main
del main.sc
copy main_liberty.sc main.sc
"%gta3sc%" compile main.sc --config=gta3 --datadir=..\..\data\ -O -fcleo -fswitch --guesser
move /y main.scm ..\..\data

rem Compile gta3sc stripped main
del main.sc
copy main_liberty_d.sc main.sc
"%gta3sc%" compile main.sc --config=gta3 --datadir=..\..\data\ -O -fcleo -fswitch --guesser
ren main.scm main_d.scm
move /y main_d.scm ..\..\data

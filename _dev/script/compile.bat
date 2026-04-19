@echo off
set gta3sc=%cd%\gta3sc\gta3sc.exe

rem Compile gta3sc debug main
"%gta3sc%" compile main.sc --config=gta3 --datadir=..\..\data\ -O --guesser -D_DEBUG
move /y main.scm ..\..\data\main_d.scm

rem Compile gta3sc retail main
"%gta3sc%" compile main.sc --config=gta3 --datadir=..\..\data\ -O --guesser -DNDEBUG
move /y main.scm ..\..\data

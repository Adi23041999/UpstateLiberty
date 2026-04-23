@echo off
set gta3sc=%cd%\gta3sc\gta3sc.exe
set gta3dir=%cd%\..\..

set sc_common=--config=gta3 --datadir="%gta3dir%\data" -O -fconst -fswitch --guesser

rem Compile gta3sc debug main
"%gta3sc%" compile main.sc %sc_common% -D_DEBUG
move /y main.scm ..\..\data\main_d.scm

rem Compile gta3sc retail main
"%gta3sc%" compile main.sc %sc_common% -DNDEBUG
move /y main.scm ..\..\data

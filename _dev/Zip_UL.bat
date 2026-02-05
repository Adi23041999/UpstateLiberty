del UL.7z
cd ..\
7z a -t7z _dev/UL.7z -xr@_dev/zipexc.txt -ir@_dev/zipinc.txt
7z rn _dev/UL.7z _dev/ul_readme.txt ul_readme.txt
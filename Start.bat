@ECHO OFF
:start
Color 1
echo Mode On
cmd.exe ## log ##

gradlew.bat jar 
cmd.exe 
pause

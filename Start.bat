@ECHO OFF
:start
Color 1
echo Mode On
cmd.exe || gradlew.bat jar
pause

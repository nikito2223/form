@ECHO OFF
Color 1
echo. -#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#
echo.
echo.	gradlew jar --- buildPc
echo.	gradlew delopy --- buildAndroid
echo.	
echo.	'error': b8 - buildAndroidStudio!
echo.
echo.
echo. 	\/	Java-Android Local	\/
echo.
echo.   	Java_Home Local: %JAVA_HOME%
echo.   	Android_HOME Local: %ANDROID_HOME%
echo. -#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#
cmd.exe
gradlew deploy 
cmd.exe
PAUSE

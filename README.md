# TestSele
This created for Test Android app , Selendroid test app
-to run this project just clone it on you machine then import it in Eclipse as Maven project 
-tools should be installed :
--Node JS
--appium 
--JDK 
--eclips 
--Simulator ex. Genymotion 
-I created Maven project  for this assignment 
-We can add the following capabilities and the same  Test cases will run on IOS in case the accessbilityid OR id are same :
  -udid=for device / simulator you will run the test on it , you can find it  in xcode 
  -platformName=iOS
  - automationName=XCUITest 
  -xcodeConfigFile: /Users/hmcconnell/Resign/appium.xcconfig 

-to run this test without error with you please make sure to place both of the excel file && APK file  in correct directory and specified it in code where i added the comment 

-Open CMD and run "adb devices" command to get the device name this step should do it after start simulater 

-this code is simple , all what i did is only in one class to make it simple 

-the application apk file o used for this assignment is vey slow so some cases you need to run it again to pass  

-for each test case i used assert to verify if the app is  on the correct page  or not 

- i used Junit 4 as test runner 

-Each Test annotation has a comment to explain what this test case tests 


import org.junit.Before;
import org.junit.Test;
import java.net.URL;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Testclass {
 

  public static final String url = "http://0.0.0.0:4723/wd/hub";
  public static AppiumDriver<MobileElement> driver;

  @Before
  public  void  props() throws Exception {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("url", url);
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "192.168.45.101:5555");
    capabilities.setCapability( "appPackage", "io.selendroid.testapp");
    capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
    capabilities.setCapability("platformVersion", "6.0");
    capabilities.setCapability("app","C:/Users/Tofail/Desktop/selendroid-test-app-0.17.0.apk");
    //put the correct application in your machine
    driver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
    }
  @After 
  public  void Close(){
	  driver.quit();
  }
  
  @Test
  //Test "Display Text view" button functionality  
  public  void Display_Text() {
		 driver.findElementByAccessibilityId("visibleButtonTestCD").click();
		 assertEquals(driver.findElementById("io.selendroid.testapp:id/visibleTextView").getText(),"Text is sometimes displayed" );
		 
	}
  @Test	
//Test Touch action  functionality  
	  public  void Touch_action() {
		 driver.findElementById("io.selendroid.testapp:id/touchTest").click();
		 driver.findElementById("io.selendroid.testapp:id/scale_factor_text_view").click();
		 assertEquals(driver.findElementById("io.selendroid.testapp:id/gesture_type_text_view").getText(),"SINGLE TAP CONFIRMED");
	 
	}
  
  @Test	
//Test EN Button  functionality  
	  public  void EN() {
	  driver.findElementByAccessibilityId("buttonTestCD").click();
	  assertTrue(driver.findElementById("android:id/message").isDisplayed());
		 
	 
	}

  @Test
  //Test Registration using excel data
  public  void Registration() throws IOException {
		 driver.findElementByAccessibilityId("startUserRegistrationCD").click();
		
		 driver.findElementById("io.selendroid.testapp:id/inputUsername").sendKeys(readData("username"));
		 driver.findElementById("io.selendroid.testapp:id/inputEmail").sendKeys(readData("email"));
		 driver.findElementById("io.selendroid.testapp:id/inputPassword").sendKeys(readData("password"));
		 driver.findElementById("io.selendroid.testapp:id/btnRegisterUser").click();
		 assertTrue(driver.findElementById("io.selendroid.testapp:id/buttonRegisterUser").isDisplayed());
		 
			
	}
  //this function to read and get data from excel file called "tofailtest"
  public  String readData(String data) throws IOException{
	  
		String param="";
		 FileInputStream fis = new FileInputStream("C:/Users/Tofail/Desktop/test.xlsx");
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet = wb.getSheetAt(0); 
		
		 if (data.equals("username")){
			 XSSFCell username = sheet.getRow(1).getCell(1);
			  param=username.getStringCellValue();
			
		 }else if (data.equals("email")){
			 XSSFCell EM = sheet.getRow(1).getCell(2);
			  param=EM.getStringCellValue();
			
		 }else if (data.equals("password")){
			 
			 XSSFCell pas = sheet.getRow(1).getCell(3);
			 param=pas.getStringCellValue();
			 
		
		 }
		return param;
  }
  

 
}

import org.junit.Before;
import org.junit.Test;
import java.net.URL;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import static org.junit.Assert.*;



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
    capabilities.setCapability("app", "/Users/apple/Desktop/GoldenScent.app");
  
    driver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
    Thread.sleep(5000);


    }
  @Test
  // to check share and like action in case user is logged out 
  public  void ShareandLike() {
		 driver.findElementByAccessibilityId("product1").click();
		 driver.findElementByAccessibilityId("share").click();
		 assertTrue(driver.findElementByAccessibilityId("sharePopUp").isDisplayed());
		 driver.findElementByAccessibilityId("cancel").click();
		 driver.findElementByAccessibilityId("Like").click();
		 assertTrue(driver.findElementByAccessibilityId("login").isDisplayed() && driver.findElementByAccessibilityId("signup").isDisplayed());
		 driver.findElementByAccessibilityId("xbutton").click();
		 assertTrue(driver.findElementByAccessibilityId("share").isDisplayed());
		 
	}
  
  @Test
  //to check add to cart action with different sizes 
  public  void addtoCartandSize() {
	  MobileElement product = driver.findElementByAccessibilityId("product1");
	  MobileElement addtocart = driver.findElementByXPath("Set your xpath here");
	  MobileElement continueshopping = driver.findElementByXPath("Set your xpath here");
	  MobileElement radioSizeButton = driver.findElementByXPath("Set your xpath here");
	  MobileElement awesomChoise = driver.findElementByXPath("Set your xpath here");
	  product.click();
	  addtocart.click();
	  assertTrue(continueshopping.isDisplayed());
	  continueshopping.click();
	  radioSizeButton.click();
	  addtocart.click();
	  assertTrue(continueshopping.isDisplayed());
	  assertEquals(awesomChoise.getText().toString(), "Awesome choice!");
	}
  
  @Test
  //to check currency is match the selected country 
  public  void Currency() {
	  MobileElement product = driver.findElementByAccessibilityId("product1");
	  MobileElement profile = driver.findElementByAccessibilityId("profile");
	  MobileElement countryandlanguage = driver.findElementByAccessibilityId("country and language");
	  MobileElement UAE = driver.findElementByAccessibilityId("united arab emirates");
	  MobileElement apply = driver.findElementByAccessibilityId("apply");
	  MobileElement Currency = driver.findElementByAccessibilityId("Currency");
	  profile.click();
	  countryandlanguage.click();
	  UAE.click();
	  apply.click();
	  product.click();
	  String CurrencyUAE=Currency.getText().toString();
	  assertEquals(CurrencyUAE, "AED");
	  
	}
  @After 
  public  void Close(){
	  driver.quit();
  }
}

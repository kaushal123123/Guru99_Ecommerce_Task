package ecomm_TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ecomm_TestUtility.configReader;

public class BaseClass {
	
configReader reader=new configReader();

public String appurl=reader.getBaseURL();

public String emailid = reader.getEmailId();

public String password = reader.getPassword();
	
public static WebDriver driver;	
	
@BeforeTest

public void setup(){
	
System.setProperty("webdriver.chrome.driver", reader.getChromePath());

driver = new ChromeDriver();

driver.get(appurl);

driver.manage().timeouts().implicitlyWait(reader.timeDuration(), TimeUnit.SECONDS);
	
}


/*@AfterTest

public void teardown() {

driver.quit();	
	
}*/

}

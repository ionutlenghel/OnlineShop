package onlineShop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class driverClass {
   
		WebDriver driver;
	
	    @BeforeClass
	    public void beforeMethod() {
	        System.setProperty("webdriver.gecko.driver","C:\\Users\\gecko\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    
	    @AfterClass
	    public void afterMethod() {
	        //driver.quit();
	    }
}

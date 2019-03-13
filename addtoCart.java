package onlineShop;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class addtoCart extends driverClass {

	@Test(priority=1)
	public void addtocart() throws InterruptedException {
		
		driver.get("http://twotapstore.com/slim-cotton-chinos/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("li.swatchOneColour span.swatchColour_1[style*='ca45ff']")).click();
        driver.findElement(By.xpath("//span[text()='Large']")).click();
        Select qty = new Select(driver.findElement(By.id("qty_")));
        qty.selectByVisibleText("2");
        driver.findElement(By.cssSelector("input.AddCartButton")).click();
        String addtocartText = driver.findElement(By.cssSelector("div.fastCartItemBox strong")).getText();
        String expectedaddtocartText = "OK, 2 items were added to your cart. What next?";
        if (addtocartText.equals(expectedaddtocartText)) {
        	driver.findElement(By.cssSelector("div#ModalContainer a.modalClose")).click();
        } else {
        		driver.findElement(By.className("FAIL"));
        		}
        
	}
	
	@Test(priority=2, dataProviderClass=dataChk.class, dataProvider="dataCheckout")
	public void checkout   (String email,
				            String bfirstname,
				            String blastname,
				            String bphone,
				            String baddress1,
				            String baddress2,
				            String bcity,
				            String bcountry,
				            String bstate,
				            String bzipcode
				          	) throws InterruptedException {
		
		driver.findElement(By.cssSelector("a[title='View Cart']")).click();
		driver.findElement(By.cssSelector("a[title='Click here to proceed to checkout']")).click();
        driver.findElement(By.cssSelector("input#CreateAccountButton")).click();
        Thread.sleep(300);
        driver.findElement(By.id("FormField_1")).sendKeys(email);
        driver.findElement(By.id("FormField_4")).sendKeys(bfirstname);
        driver.findElement(By.id("FormField_5")).sendKeys(blastname);
        driver.findElement(By.id("FormField_7")).sendKeys(bphone);
        driver.findElement(By.id("FormField_8")).sendKeys(baddress1);
        driver.findElement(By.id("FormField_9")).sendKeys(baddress2);
        driver.findElement(By.id("FormField_10")).sendKeys(bcity);
        Select country = new Select(driver.findElement(By.id("FormField_11")));
        country.selectByVisibleText(bcountry);
        Thread.sleep(2000);
        Select state = new Select(driver.findElement(By.id("FormField_12")));
        state.selectByVisibleText(bstate);
        driver.findElement(By.id("FormField_13")).sendKeys(bzipcode);
        driver.findElement(By.id("ship_to_billing_new")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.billingButton")).click();
        
        
	}

	
}

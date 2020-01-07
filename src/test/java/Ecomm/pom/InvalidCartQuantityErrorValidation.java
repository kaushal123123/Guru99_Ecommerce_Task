package Ecomm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvalidCartQuantityErrorValidation {
	
	WebDriver ldriver;
	
	static String errmsg;
	
	public InvalidCartQuantityErrorValidation(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="(//span[contains(text(),'Add to Cart')])[1]")
	@CacheLookup
	WebElement AddtoCart;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(xpath="//td//button[@title='Update']")
	@CacheLookup
	WebElement Updatebtn;
	
	@FindBy(xpath="//li[@class='error-msg']/ul/li")
	@CacheLookup
	WebElement errormsg;
	
	
	public void ClickOnAddToCart() {
		
		comparePrice cm = new comparePrice(ldriver);
		
		cm.ClickOnMObileMenu();
		
		AddtoCart.click();
		
		
	}

	public void ClickOnQuantityInput() {
		
		quantity.click();
		
		quantity.clear();
		
		quantity.sendKeys("1000");
	}
	
	public void ClickOnUpdatebtn() {
		
		Updatebtn.click();
		
	}
	
	public void CapturerrorMsg() {
		
		errmsg=errormsg.getText();
		
		if(errmsg.contains("Some of the products cannot be ordered in requested quantity.")) {
			
			System.out.println(errmsg);
			
			Assert.assertTrue(true);
			
		}
		
		else {
			
			System.out.println("Validation fail");
			
			Assert.assertFalse(false);
		}
	}
}

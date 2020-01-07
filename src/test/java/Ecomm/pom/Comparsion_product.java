package Ecomm.pom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Comparsion_product {
	
	WebDriver ldriver;
	
	public Comparsion_product(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	@CacheLookup
	WebElement addtocompare_pro1;
	
	@FindBy(xpath="//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	@CacheLookup
	WebElement addtocompare_pro2;
	
	@FindBy(xpath="//li[@class='success-msg']//ul//li")
	@CacheLookup
	WebElement success_msg;
	
	@FindBy(xpath="//small[contains(text(),'(2)')]")
	@CacheLookup
	WebElement procount;
	
	@FindBy(xpath="(//button[@class='button'])[1]")
	@CacheLookup
	WebElement comparebtn;
	
	public void clickOnAddtoComLink_Pro1() {
		
		comparePrice cp=new comparePrice(ldriver);
		
		cp.ClickOnMObileMenu();
		
		addtocompare_pro1.click();
		
		String post_msg1 = success_msg.getText();
		
		if(post_msg1.contains("has been added to comparison list.")) {
			
			System.out.println("Validation Pass==Message is :"+post_msg1);
			
			Assert.assertTrue(true);
			
		}
		
		else {
			
			System.out.println("Validation Fail==Message is :"+post_msg1);
			
			Assert.assertFalse(false);

			
		}
		
		
	}
	
	public void clickOnAddtoComLink_pro2() {
		
		addtocompare_pro2.click();
		
		try {
		
		String msg_2 = success_msg.getText();
		
		System.out.println(msg_2);
		
		}
		
		catch(StaleElementReferenceException e) {
			
			String successMsg = "//li[@class='success-msg']//ul//li";
			
			String msg = ldriver.findElement(By.xpath(successMsg)).getText();
			
			System.out.println(msg);
			
		}
		
	}
	
	public void getProductCountInCom_List() {
		
		String count = procount.getText();
		
		try {
		
		Assert.assertEquals(count, "(2)");
		
		System.out.println("Product count Matches");
		
		}
		
		catch(Exception e) {
			
			System.out.println("product count is not matched with expected");
			
		}
	}
  
	public void ClickOnComparebtn() {
		
		comparebtn.click();
		
	}
	
	public void SwitchToChildWindow() {
		
		Set<String> winstring = ldriver.getWindowHandles();
		
		System.out.println(winstring);
		
		for(String str:winstring) 
			
			ldriver.switchTo().window(str);
			
			ldriver.manage().window().maximize();
		
	}
}

package Ecomm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareWishListData {
	
	WebDriver ldriver;
	
	public ShareWishListData(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	//xpath of finding element on webpage for "Add to wishlist link"
	@FindBy(xpath="(//li//a[@class='link-wishlist'])[1]")
	@CacheLookup
	WebElement addtowishlist;
	
	//xpath of finding email field on webpage 
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	//xpath of finding password field on webpage
	@FindBy(id="pass")
	@CacheLookup
	WebElement pass;
	
	//xpath of Login button
	@FindBy(id="send2")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="//span[contains(text(),'Share Wishlist')]")
	@CacheLookup
	WebElement Wishlistshare;
	
	@FindBy(id="email_address")
	@CacheLookup
	WebElement sharewishlistbtn;
	
	@FindBy(id="message")
	@CacheLookup
	WebElement message;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	@CacheLookup
	WebElement submit;
	//This an action method to click on wislist link
	
	public void clickonWishList() {
		
		comparePrice cp = new comparePrice(ldriver);
		
		cp.ClickOnMObileMenu();
		
		addtowishlist.click();
		
	}
	
	//This an action method to Enter emailid and password
	
   public void userauthencation(String userid,String secode) {
	   
	   email.sendKeys(userid);
	   
	   pass.sendKeys(secode);
   }
   
   //This is an action method to click on "Login" button
   public void clickOnLoginbtn() {
	   
	   login.click();
   }
   
   public void SharewishListData() {
	   
	   try {
	   
	   if(Wishlistshare.isDisplayed()) {
		   
		   Wishlistshare.click();
		   
		   sharewishlistbtn.sendKeys("kgkaushal000@gmail.com");
		   
		   message.sendKeys("This is an my wishlist added item");
		   
		   submit.click();
		   
	   }
	   
}
	   
	   catch(NoSuchElementException e) {
		   
		   comparePrice cp = new comparePrice(ldriver);
		   
		   cp.ClickOnMObileMenu();
		   
		   try {
			   
		   addtowishlist.click();
		   
		   }
		   
		   catch(StaleElementReferenceException e1) {
			   
			   ldriver.findElement(By.xpath("(//li//a[@class='link-wishlist'])[1]")).click();
			   
		   }
		   Wishlistshare.click();
		   
		   sharewishlistbtn.sendKeys("kgkaushal000@gmail.com");
		   
		   message.sendKeys("This is an my wishlist added item");
		   
		   submit.click();
	   
	   }
   }

}

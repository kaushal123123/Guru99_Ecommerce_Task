package Ecomm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm_TestCase.BaseClass;

/**@author Kaushal
 * @since 31 Dec 2019
 * @category Verify that you will be able to save previously placed order as a pdf file
 */

public class SavePlacedOrder extends BaseClass{
	
	WebDriver ldriver;
	
	public SavePlacedOrder(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="(//span[contains(text(),'Account')])[1]")
	@CacheLookup
	WebElement acclink;
	
	@FindBy(xpath="//*[contains(text(),'Log In')]")
	@CacheLookup
	WebElement login;
	
	@FindBy(xpath="(//*[contains(text(),'View Order')])[1]")
	@CacheLookup
	WebElement vieworder_1;
	
	@FindBy(xpath="//a[@class='link-print']")
	@CacheLookup
	WebElement printorder;
	
	public  void clickonAcc() {
		
		acclink.click();
	}
	
	public void clickonLoglnk() {
		
		login.click();
	}
	
	public void userlogin() {
		
		ShareWishListData swl = new ShareWishListData(ldriver);
		
		swl.userauthencation(emailid, password);
		
		swl.clickOnLoginbtn();
	}
	
	public void clickonViewOrder() {
		
		vieworder_1.click();
	}
	
	public void clickonPrintOrder() {
		
		printorder.click();
	}

}

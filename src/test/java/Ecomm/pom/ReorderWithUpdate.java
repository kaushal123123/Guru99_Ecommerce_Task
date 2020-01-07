package Ecomm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReorderWithUpdate {
	
	WebDriver ldriver;
	
	public ReorderWithUpdate(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="(//*[contains(text(),'Reorder')])[2]")
	@CacheLookup
	WebElement reorderlnk;
	
	@FindBy(xpath="(//*[contains(text(),'Edit')])[3]")
	@CacheLookup
	WebElement editlnk;
	
	@FindBy(id="qty")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(xpath="//span[contains(text(),'Update Cart')]")
	@CacheLookup
	WebElement updatebnt;
	
	/**This method is a compostion of different action method of OrderPDFSave clas 
	 * By Creating Object of OrderPDFSave ,we can access the method of the same class.
	 * This method provid us navigation step till My Account Dashboard.
	 */
	public void userAccountPage() {
		
		SavePlacedOrder save = new SavePlacedOrder(ldriver);
		
		save.clickonAcc();
		
		save.clickonLoglnk();
		
		save.userlogin();
	}
	
	/**This is an action method to perform click action on reorder.
	 * Reorder link navigate user to cart page.
	 * And also add same product again into cart.
	 */
	
	public void clickOnReorder() {
		
		reorderlnk.click();
	}
	
	/**This is an action method to perform click action on edit link
	 * After click on edit link we can change the Quantity of product on cart
	 */
	public void clickOnEdit() {
		
		editlnk.click();
	}
	
	public void ClearQuantity() {
		
		quantity.clear();
		
		quantity.sendKeys("2");
	}
	
	public void clickonUpdatebtn() {
		
		updatebnt.click();
	}
	
	public void reorderfromPrtochkout() {
		
		userflow user = new userflow(ldriver);
		
		user.ClickOnCheckout();
		
	}
	

}

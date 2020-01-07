package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.InvalidCartQuantityErrorValidation;

public class CartUpdate extends BaseClass{
	
	@Test
	
	public void cartupdate_invalidQty() throws Throwable {
		
	   InvalidCartQuantityErrorValidation invalQty = new InvalidCartQuantityErrorValidation(driver);
	   
	   invalQty.ClickOnAddToCart();
	   
	   invalQty.ClickOnQuantityInput();
	   
	   Thread.sleep(2000);
	   
	   invalQty.ClickOnUpdatebtn();
	   
	   Thread.sleep(2000);
	   
	   invalQty.CapturerrorMsg();
	}

}

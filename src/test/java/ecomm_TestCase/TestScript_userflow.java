package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.ShareWishListData;
import Ecomm.pom.userflow;

public class TestScript_userflow extends BaseClass{
	
	@Test(priority=0)
	
	public void fullUserFlow_TS1() {
		
		ShareWishListData swl = new ShareWishListData(driver);
		
		swl.clickonWishList();
		
		swl.userauthencation(emailid, password);
		
		swl.clickOnLoginbtn();
		
		swl.SharewishListData();
		
	}
	
	@Test(priority=1)
	
	public void fullUserFlow_TS2() throws Exception {
		
		userflow uf=new userflow(driver);
		
		uf.ClickOnAddtoCart();
		
		uf.ClickOnCheckout();
		
		uf.CheckCustomerField();
		
		uf.clickOnShippingContinueBtn();
		
		uf.selectPaymentMethod();
		
		uf.clickoncontbtn_payinfo();
		
		uf.clickonplaceOrder();
		
	}

}

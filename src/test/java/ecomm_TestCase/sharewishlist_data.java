package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.ShareWishListData;

public class sharewishlist_data extends BaseClass{
	
	@Test
	
	public void sharedate() {
		
		ShareWishListData sd = new ShareWishListData(driver);
		
		sd.clickonWishList();
		
		sd.userauthencation(emailid, password);
		
		sd.clickOnLoginbtn();
		
		sd.SharewishListData();
	}

}

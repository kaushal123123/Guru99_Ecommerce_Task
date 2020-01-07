package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.Comparsion_product;

public class comparsion extends BaseClass {
	
	@Test
	

	public void product_comparsion() {
		
		Comparsion_product cp = new Comparsion_product(driver);
		
		cp.clickOnAddtoComLink_Pro1();
		
		cp.clickOnAddtoComLink_pro2();
		
		cp.getProductCountInCom_List();
		
		cp.ClickOnComparebtn();
		
		cp.SwitchToChildWindow();
	}

}

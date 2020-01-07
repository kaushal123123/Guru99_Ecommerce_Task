package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.SavePlacedOrder;

public class OrderPDFSave extends BaseClass{
	
	@Test
	
	public void OrderSave() {
		
		SavePlacedOrder save = new SavePlacedOrder(driver);
		
		save.clickonAcc();
		
		save.clickonLoglnk();
		
		save.userlogin();
		
		save.clickonViewOrder();
		
		save.clickonPrintOrder();
		
	}
	
	

}

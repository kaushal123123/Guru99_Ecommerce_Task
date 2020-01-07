package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.comparePrice;

public class priceComparsion extends BaseClass{
	
	@Test
	public void run002() {
		
	comparePrice cp=new comparePrice(driver);
	
	cp.ClickOnMObileMenu();
	
	cp.GetProdcuctPricefromList();
	
	cp.proceedToProductpage();
	

}
}
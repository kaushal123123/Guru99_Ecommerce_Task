package ecomm_TestCase;

import org.testng.annotations.Test;

import Ecomm.pom.sortByName;

public class TC001_sortby_Name extends BaseClass {
	
@Test

public void runTC001() throws Exception {
	
sortByName tc001 = new sortByName(driver);

tc001.clickonMobileCategory();

tc001.defaultProductList();

tc001.sortedProductList();

tc001.validation();
	
	
}

}    

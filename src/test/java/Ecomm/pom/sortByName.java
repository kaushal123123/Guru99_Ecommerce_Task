//Verify that Sorting feature is working or not.
//Open the URL
//Click on Mobile Menu
//Verify that default sorting feature and sort the listed product into list.(named as 'orglist')
//Select the sorting feature as "Name" and store the listed product into list.(named as 'sortedlist')

package Ecomm.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sortByName {
	
WebDriver ldriver;

String path ="(//h2[@class='product-name'])";
String temp ="";
static List<String> orglist;
static List<String> sortedlist;

public sortByName(WebDriver rdriver) {
ldriver = rdriver;
PageFactory.initElements(ldriver, this);
}

@FindBy(xpath = "//a[contains(text(),'Mobile')]")
@CacheLookup
WebElement mobilemenu;

@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
@CacheLookup
WebElement sortby;

public void clickonMobileCategory() {
	mobilemenu.click();
}

public List<String> defaultProductList(){
	orglist=new ArrayList<String>();
	
	String defaultSort=sortby.getText();
	
	if(defaultSort.contains("Position")) {
		for(int i=1;i<=3;i++) {
			temp = path+"["+i+"]";
			String productText = ldriver.findElement(By.xpath(temp)).getText();
			orglist.add(productText);	
		}
		System.out.println(orglist);
	}
	else {
		System.out.println("Selected Sorting feature is other then :"+defaultSort);
	}
	return orglist;

}

public List<String> sortedProductList() throws Exception{
	 sortedlist=new ArrayList<String>();
	sortby.click();
	
	Select select = new Select(sortby);
	select.selectByVisibleText("Name");
	try {
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		wait.until(ExpectedConditions.visibilityOf(sortby));
	}
	catch(StaleElementReferenceException e) {
		Thread.sleep(3000);	
		WebElement refreshText = ldriver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
		String sortedName=refreshText.getText();
		
		if(sortedName.contains("Name")) {
		for(int i=1;i<=3;i++) {
			temp = path+"["+i+"]";
			String productText = ldriver.findElement(By.xpath(temp)).getText();
			sortedlist.add(productText);	
		}
		System.out.println(sortedlist);
		}
		
		else {
			System.out.println("Selected Sorting feature is other then :"+sortedName);
		}
	}
	return sortedlist;	
}

public void validation() throws Exception {
	
	    if(orglist.equals(sortedlist)) {
	    	
	    	System.out.println("Sorting feature is not working.");
	    }
	    else {
	    	
	    	System.out.println("Sorting feature is working perfectly.");
	    	
	    }
}
}
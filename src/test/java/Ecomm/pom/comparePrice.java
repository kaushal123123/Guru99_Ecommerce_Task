/*step 1:go to url =======>(coming from BaseClass)
  step 2:click on Mobile Menu
  step 3:In the all the list,read the cost of sony Xperia Mobile.Note this Value
  step 4:click on sony xperia Mobile
  step 5:Read the price of sony Xperia mobile of Detail page
  step 6:Compare value of step 3 & step 6
*/
package Ecomm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class comparePrice {
	
	WebDriver ldriver;
	
	public static String path="(//h2[@class='product-name']//a)";
	
    public static String temp = "";
    
    public static String price = "(//span[@class='price'])";
    
    public static String varprice ="";
	
    public static String productText;
	
    public static String productPriceList;
    
    public static String proprice1;
	
	public comparePrice(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	@CacheLookup
	WebElement clickMenu;
	
	@FindBy(xpath="//span[@id='product-price-1']")
	@CacheLookup
	WebElement PriceOnProductPage;
	
	
	public void ClickOnMObileMenu() {
		
		clickMenu.click();
	}
	
	public void GetProdcuctPricefromList() {
		
		for(int i =1;i<=1;i++) {
			
			temp = path+"["+i+"]";
			
			productText=ldriver.findElement(By.xpath(temp)).getText();
			
			if(productText.contains("SONY XPERIA")) {
				
				varprice=price+"["+i+"]";
				
				proprice1=ldriver.findElement(By.xpath(varprice)).getText();
			}
			
			else {
				
				System.out.println("Sony Xperia is not at first postion :"+ productText);
			}
			
		}
		
	 }
	public void proceedToProductpage() {
			
		 ldriver.findElement(By.xpath(temp)).click();
		 
		 String proprice = PriceOnProductPage.getText();
		
		 Assert.assertEquals(proprice, proprice1);
		 
		 System.out.println("Product price same on both Product List page and Product Detail page is same.");
		
	}
 }
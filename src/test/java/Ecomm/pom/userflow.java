package Ecomm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ecomm_TestUtility.configReader;

public class userflow {
	
	WebDriver ldriver;
	
	public userflow(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	/**xpath of Add to cart button 
	*Item add to wishlist page
	*/
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	@CacheLookup
	WebElement addtocart;
	
	//xpath of proceed to checkout button
	@FindBy(xpath="(//button[@title=\"Proceed to Checkout\"])[1]")
	@CacheLookup
	WebElement proceedtocheckoutbnt;
	
	//xpath
	
    @FindBy(xpath="//input[@id='billing:street1']")
    @CacheLookup
    WebElement Address;
    
    @FindBy(id="billing:city")
    @CacheLookup
    WebElement city;
    
    @FindBy(id="billing:region")
    @CacheLookup
    WebElement state;
    
    @FindBy(id="billing:postcode")
    @CacheLookup
    WebElement zipcode;
    
    @FindBy(id="billing:country_id")
    @CacheLookup
    WebElement choosecountry;
    
    @FindBy(id="billing:telephone")
    @CacheLookup
    WebElement phonenumber;
    
    @FindBy(xpath="(//button[@title=\"Continue\"])[1]")
    @CacheLookup
    WebElement continuebtn;
    
    @FindBy(xpath="//button[@onclick='shippingMethod.save()']")
    @CacheLookup
    WebElement shipping_continue;
    
    @FindBy(xpath="//label[contains(text(),'Check / Money order')]")
    @CacheLookup
    WebElement paymentMethod;
    
    @FindBy(xpath="//*[@onclick='payment.save()']")
    @CacheLookup
    WebElement clickonPaymentinfoContbtn;
    
    @FindBy(xpath="//button[@class='button btn-checkout']")
    @CacheLookup
    WebElement checkout;
	
	public void ClickOnAddtoCart() {
		
		addtocart.click();
	}
	
	public void ClickOnCheckout() {
		
		proceedtocheckoutbnt.click();
		
	}
	
	public void EnterAddress_street(String address) {
		
		Address.sendKeys(address);
	}
	
	public void EnterAddress_city(String cty) {
		
		city.sendKeys(cty);
		
	}
	
	public void EnterState(String stte) {
		
		state.sendKeys(stte);
		
	}
	
	public void EnterZipCode(String zip) {
		
		zipcode.sendKeys(zip);
		
		
	}
	
	public void SelectCountry(String country) {
		
		Select select = new Select(choosecountry);
		
		select.selectByVisibleText(country);
	}
	
    public void EnterPhoneNumber(String number) {
    	
    	phonenumber.sendKeys(number);
    }
    
    public void ClickOnContinue() {
    	
    	continuebtn.click();
    }
    
    public void CheckCustomerField() throws Exception {
    	
    	Thread.sleep(2000);
    	
    	String temp = ldriver.findElement(By.xpath("(//input[@name='billing[street][]'])[1]")).getText();
    	
    	 int flag = temp.length();
    	
    	if(flag>0) {
    	
    	userflow ufl = new userflow(ldriver);
    	
    	configReader conf = new configReader();
    	
    	ufl.EnterAddress_street(conf.Address());
    	
    	ufl.EnterAddress_city(conf.City());
    	
    	ufl.EnterZipCode(conf.zipcode());
    	
    	ufl.SelectCountry(conf.country());
    	
    	ufl.EnterState(conf.State());
    	
    	ufl.EnterPhoneNumber(conf.ContactNumber());
    	
    	ufl.ClickOnContinue();
    	
    	}
    	
    	else {
    		
    		try {
    		
    		continuebtn.click();
    		}
    		
    		catch(ElementClickInterceptedException e) {
    			
    			ldriver.findElement(By.xpath("//div[@id='closeBtn']")).click();
    			
    			continuebtn.click();
    			
    		}
    	}
    }
    
    public void clickOnShippingContinueBtn() {
    	
    	shipping_continue.click();
    	
    }
    
    public void selectPaymentMethod() {
    	
    	paymentMethod.click();
    	
    }
    
    public void clickoncontbtn_payinfo() {
    	
    	clickonPaymentinfoContbtn.click();
    }
    
    public void clickonplaceOrder() {
    	
    	checkout.click();
    }
}

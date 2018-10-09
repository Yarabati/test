package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class AddressPage extends TestBase
{
	public boolean bResult;
	
    @FindBy(className="navigation_page")	
    WebElement  addressPageVerify;
    
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button")
	WebElement proceed2;

	public AddressPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyPageText()
	{ 
		bResult = false;
		if (addressPageVerify.getText().equalsIgnoreCase("Addresses"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;
	}
	
	
	public ShippingPage AddressPayment() 
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", proceed2);
		proceed2.click();
		System.out.println("Almost there in Shipping Page");
		
		return new ShippingPage();
	}
}

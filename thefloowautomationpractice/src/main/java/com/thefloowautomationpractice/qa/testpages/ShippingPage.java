package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class ShippingPage extends TestBase
{
	public boolean bResult;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	WebElement bShipping;
	
	@FindBy(id="cgv")
	WebElement checkBoxSelected;
	
	@FindBy(className="navigation_page")
	WebElement shippingPageVerify;
	
	public ShippingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyPageText()
	{ 
		bResult = false;
		
 		if (shippingPageVerify.getText().equalsIgnoreCase("Shipping"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;
	}
	
	public PaymentPage ShippingPayment() 
	{
		checkBoxSelected.click();
				
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bShipping);
		
		bShipping.click();
		
			
		return new PaymentPage();
	}


}

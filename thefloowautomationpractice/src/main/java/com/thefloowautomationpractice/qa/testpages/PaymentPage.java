package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class PaymentPage extends TestBase
{
	public boolean bResult;
	
	@FindBy(className="navigation_page")
	WebElement paymentPageVerify;
	
	public boolean verifyPageText()
	{ 
		bResult = false;
		
		if (paymentPageVerify.getText().equalsIgnoreCase("Your payment method"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;
	}
}


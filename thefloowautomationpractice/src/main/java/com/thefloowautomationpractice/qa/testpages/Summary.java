package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.thefloowautomationpractice.qa.testbase.TestBase;

public class Summary extends TestBase
{
	
	public boolean bResult;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed1;
	
	
	 
	
	public Summary()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public boolean verifyPageText() 
	{
		bResult = false;
		String bTitle = driver.getTitle();	
		
		if(bTitle.equals("Order - My Store"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;

	}	
	
	public AddressPage CompletePayment() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", proceed1);
		proceed1.click();
		
		
		return new AddressPage();
	}

	
}

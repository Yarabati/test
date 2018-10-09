package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class AddToCart extends TestBase 
{
	public String  purchasePageTitle;
	
	@FindBy(name="Submit")
	WebElement addToCart;

	public AddToCart(){
		PageFactory.initElements(driver,this);
		
	}
	public String verifyPurchasePageTitle()
	{
		purchasePageTitle = driver.getTitle();		
		return purchasePageTitle;
		
	}
	
	public ProceedToCheckOut proceedToCheckOut()
	{
		
		driver.switchTo().frame(0);
		addToCart.click();
		return new ProceedToCheckOut();
	}
}

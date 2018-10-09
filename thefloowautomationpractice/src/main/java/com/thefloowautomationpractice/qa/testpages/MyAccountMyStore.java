package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testpages.Purchase;
import com.thefloowautomationpractice.qa.testbase.TestBase;

public class MyAccountMyStore extends TestBase
{
	public boolean bResult;
		
	@FindBy(name="submit_search")
	WebElement btnSubmitSearch;
	
	@FindBy(id="search_query_top")
	WebElement searchQueryTop;
	
	@FindBy(className="page-heading")
	WebElement verifyUser;
	
	 
	
	public MyAccountMyStore()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public boolean verifyLoggedInUser() 
	{
		bResult = false;
		
		if(verifyUser.getText().equalsIgnoreCase("MY ACCOUNT"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;

	}	
	
	public Purchase SearchForAProduct() {
		verifyLoggedInUser();
		searchQueryTop.sendKeys("printed");
		btnSubmitSearch.click();
		return new Purchase();
	}
}


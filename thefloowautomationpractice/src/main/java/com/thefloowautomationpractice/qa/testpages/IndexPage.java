package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thefloowautomationpractice.qa.testbase.TestBase;

public class IndexPage extends TestBase{
	
	public boolean bResult;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement btnIndexPageSignIn;
	
	@FindBy(className="header_user_info")
	WebElement indexPageHeaderUserInfo;

	public IndexPage(){
		PageFactory.initElements(driver,this);
    }

	
	
	public boolean verifyIndexPageOpen() 
	{
		bResult = false;
       	if(indexPageHeaderUserInfo.getText().equalsIgnoreCase("Sign in"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;

	}	
	
	public LogInMyStorePage indexPageSignin() 
	{
		btnIndexPageSignIn.click();
		return new LogInMyStorePage();
	}
}
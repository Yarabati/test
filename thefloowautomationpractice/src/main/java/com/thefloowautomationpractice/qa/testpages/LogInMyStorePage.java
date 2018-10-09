package com.thefloowautomationpractice.qa.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class LogInMyStorePage extends TestBase
{

	public boolean bResult;
	
    @FindBy(className="page-heading")
    WebElement logInPageAuthenticationInfo;
    
	@FindBy(id="email_create")
	WebElement emailCreate;
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreate;
	
	@FindBy(id="email")
	WebElement emailRegistered;
	
	@FindBy(id="passwd")
	WebElement passwordRegistered;
	
	@FindBy(id="SubmitLogin")
	WebElement submitLogin;

	public LogInMyStorePage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLoginMyStoreOpen() 
	{
        bResult = false;	
		if(logInPageAuthenticationInfo.getText().equalsIgnoreCase("AUTHENTICATION"))
		{
			bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;

	}	
	public LogInMyStoreCreateAccountPage createAnAccount(String userName) 
	{
		
		emailCreate.clear();
		emailCreate.sendKeys(userName);
		submitCreate.click();
		return new LogInMyStoreCreateAccountPage();
	}
	
	public MyAccountMyStore registerdAccount(String regUserName, String regUserPassword) 
	{
		
		emailRegistered.clear();
		passwordRegistered.clear();
		
		emailRegistered.sendKeys(regUserName);
		passwordRegistered.sendKeys(regUserPassword);
		submitLogin.click();
		
		return new MyAccountMyStore();
	}

}

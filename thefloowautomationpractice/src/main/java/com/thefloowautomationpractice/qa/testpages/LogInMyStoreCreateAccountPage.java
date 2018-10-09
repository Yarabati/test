package com.thefloowautomationpractice.qa.testpages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class LogInMyStoreCreateAccountPage extends TestBase
{
	public boolean bResult;
	
	@FindBy(className = "page-heading")
	WebElement verifyCreateLogIn;
	
	@FindBy(id="id_gender1")
	WebElement title;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement passwd;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="firstname")
	WebElement addressFirstName;
	
	@FindBy(id="lastname")
	WebElement addressLastName;
	
	@FindBy(id="company")
	WebElement addressCompany;
	
	
	@FindBy(id="address1")
	WebElement addressAddress1;
	
	@FindBy(id="address2")
	WebElement addressAddress2;

	@FindBy(id="city")
	WebElement addressCity;
	
	@FindBy(id="id_state")
	WebElement addressState;
	
	@FindBy(id="postcode")
	WebElement addressPostcode;
	
	@FindBy(id="id_country")
	WebElement addressCountry;
	
	@FindBy(id="other")
	WebElement addressOther;
	
	@FindBy(id="phone")
	WebElement addressPhone;
	
	@FindBy(id="phone_mobile")
	WebElement addressPhoneMobile;
	
	@FindBy(id="alias")
	WebElement addressAlias;
	
	@FindBy(id="submitAccount")
	WebElement btnsubmitAccount;
	
	public LogInMyStoreCreateAccountPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyCreateLogInPageOpen() 
	{
		bResult = false;
		
       	if(verifyCreateLogIn.getText().equalsIgnoreCase("AUTHENTICATION"))
		{
       		bResult=true;
		}
		else
		{
			bResult=false;
		}	
		return bResult;

	}	
    
    
    
	public MyAccountMyStore RegisterAnAccount() {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand=new Random();
		char[] text=new char[10];
		String randString=null;
	 for (int i=0;i<text.length;i++)
	 {	text[i]=upper.charAt(rand.nextInt(upper.length()));
		 
	 }
	 for (int i=1;i<text.length;i++)
	 {	randString+=text[i];		 
	 }
	  
		title.click();
		firstName.sendKeys(randString);
		lastName.sendKeys(randString);
		emailId.clear();
		emailId.sendKeys(randString+"@testmail.com");
		passwd.sendKeys(randString);
		
		
		
		Select daysDropDown = new Select(days);
		daysDropDown.selectByIndex(rand.nextInt(27));

		Select monthsDropdown = new Select(months);
		monthsDropdown.selectByIndex(rand.nextInt(12));

		Select yearsDropdown = new Select(years);
		yearsDropdown.selectByIndex(rand.nextInt(118));

		int randInt = rand.nextInt(1000000);
		String randIntString = Integer.toString(randInt);
		
		addressFirstName.sendKeys(randString);
		addressLastName.sendKeys(randString);
		addressCompany.sendKeys(randString);
		addressAddress1.sendKeys(randString);
		addressAddress2.sendKeys(randString);
		addressCity.sendKeys(randString);
		
		Select addressStateDropDown = new Select(addressState);
		addressStateDropDown.selectByIndex(rand.nextInt(40));
		addressState.sendKeys("New Jersey");
		addressPostcode.sendKeys("07302");
		addressCountry.sendKeys("addressCountry");
		addressOther.sendKeys(randString);
		addressPhone.sendKeys(randIntString);
		addressPhoneMobile.sendKeys(randIntString);
		addressAlias.sendKeys(randString);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnsubmitAccount.click();
		
		return new MyAccountMyStore();
	}

	
	
}

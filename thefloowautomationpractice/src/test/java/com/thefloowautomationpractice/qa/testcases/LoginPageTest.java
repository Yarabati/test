package com.thefloowautomationpractice.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thefloowautomationpractice.qa.testbase.TestBase;
import com.thefloowautomationpractice.qa.testpages.IndexPage;
import com.thefloowautomationpractice.qa.testpages.LogInMyStoreCreateAccountPage;
import com.thefloowautomationpractice.qa.testpages.LogInMyStorePage;

import com.thefloowautomationpractice.qa.testpages.MyAccountMyStore;

public class LoginPageTest extends TestBase
{
	public boolean bResult;
	
	Logger                        objLog;
	IndexPage                     objIndexPage;
	LogInMyStorePage              objLogInMyStorePage;
	LogInMyStoreCreateAccountPage objLogInMyStoreCreateAccountPage;
	MyAccountMyStore              objMyAccountMyStore;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		objLog              = Logger.getLogger(LoginPageTest.class);
		objLog.info(" ");
	    objLog.info(" ");
		initialization();				
		objLog.info("   Test Preparation:    Driver Launched Successfully");
		
		urlOpen();
		objLog.info("   Test Preparation:    URL Opened Successfully"); 
		
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("   Test Case:    Existing User Login");        
		objLog.info("               ");
		
		objIndexPage                     = new IndexPage();
		objLogInMyStorePage              = new LogInMyStorePage();
   }
	
	@AfterMethod
   	public void tearDown() 
    {
	   driver.quit();
    }
	
	@Test
  	public void TestCase2_LoginToSite() {

	   bResult =   objIndexPage.verifyIndexPageOpen(); 
        
       if(bResult == true)
       {
        	objLog.info("   Test Step: Application Opened Successfully");	
       }
       else
       {
        	objLog.info("   Unable to Launch application");
        	Assert.fail();
       }
        
	   objLogInMyStorePage       = objIndexPage.indexPageSignin();
	   bResult = objLogInMyStorePage.verifyLoginMyStoreOpen();
	   
	   if (bResult == true)
	   {
		   objLog.info("   Test Step: Login Page Opened Successfully");
	   }
	   else
	   {
		   objLog.info("   Unable to open Application");
	   } 
	 
	   
	   String regUserName = prop.getProperty("username");
	   String regUserPassword = prop.getProperty("password");
	   
	       
       objMyAccountMyStore =  objLogInMyStorePage.registerdAccount(regUserName, regUserPassword);
       objLog.info("   Test Step: Email ID and Password entered Successfully.");
       
       bResult  =  objMyAccountMyStore.verifyLoggedInUser();
       
    
       if (bResult == true)
          {
              	 objLog.info("   Test Step: User Logged in Successfully");	   
          }
       else
          {
            	 objLog.info("   Unable To Login to Application");
              	 Assert.fail();	                	 
          }
  	}	
}
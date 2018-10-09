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


public class RegisterAnAccount extends TestBase
{
    public boolean bResult;
    
	IndexPage                     objIndexPage;
	LogInMyStorePage              objLogInMyStorePage;
	LogInMyStoreCreateAccountPage objLogInMyStoreCreateAccountPage;
	MyAccountMyStore              objMyAccountMyStore;
	Logger                        objLog;
 
	
	public RegisterAnAccount()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		objLog              = Logger.getLogger(RegisterAnAccount.class);
		
		initialization();			
		objLog.info(" ");
	    objLog.info(" ");
		objLog.info("   Test Preparation:    Driver Launched Successfully");
		
		urlOpen();
		objLog.info("   Test Preparation:    URL Opened Successfully"); 
		
		objIndexPage                     = new IndexPage();
		objLogInMyStorePage              = new LogInMyStorePage();
	    objLogInMyStoreCreateAccountPage = new LogInMyStoreCreateAccountPage();
		objMyAccountMyStore              = new MyAccountMyStore();   
		
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("   Test Case:    New User creation");        
		objLog.info("               ");
	}

    @AfterMethod
   	public void tearDown() 
    {
	    driver.quit();
    } 
	
   @Test
	public void TestCase1_RegisterAnAccount() {
	       bResult =   objIndexPage.verifyIndexPageOpen(); 
	            
	       if(bResult == true)
	       {
	            	objLog.info("   Test Step: Index Page Opened Successfully");	
	       }
	       else
	       {
	            	objLog.info("   Some Problem with the Application Code while openning Index Page");
	            	Assert.fail();
	       }
	            
	       objLogInMyStorePage = objIndexPage.indexPageSignin();
	            
	       bResult = objLogInMyStorePage.verifyLoginMyStoreOpen();
	     	   
	       if (bResult == true)
	       {
	     		   objLog.info("   Test Step: Login Page Opened Successfully");
	       }
	       else
	       {
	     		   objLog.info("   Some Problem with the Application Code while openning Login Page");
	       } 
	        	     	
		 	  objLogInMyStoreCreateAccountPage = objLogInMyStorePage.createAnAccount("yarabati.prashanth@gmail.com");
	     	
		     bResult=objLogInMyStoreCreateAccountPage.verifyCreateLogInPageOpen();
		     if(bResult == true)
	         {
	           	 objLog.info("   Test Step: Entering the data for creating the New User");	                	 
	         }
	         else
	         {
	          	 objLog.info("   Some Problem with the Application Code while Creating the new User");
	           	 Assert.fail();	                	 
	         }   
	         
	         objMyAccountMyStore = objLogInMyStoreCreateAccountPage.RegisterAnAccount();   
	         
	         bResult  =  objMyAccountMyStore.verifyLoggedInUser();
	     	

	         if (bResult == true)
	         {
	           	 objLog.info("   Test Step: New User created Successfully");	     
	         }
	         else
	         {
	          	 objLog.info("Unable To Register a User");
	           	 Assert.fail();	                	 
	         }   
	}
  }

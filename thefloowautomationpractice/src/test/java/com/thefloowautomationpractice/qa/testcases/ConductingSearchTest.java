package com.thefloowautomationpractice.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thefloowautomationpractice.qa.testbase.TestBase;
import com.thefloowautomationpractice.qa.testpages.AddToCart;
import com.thefloowautomationpractice.qa.testpages.IndexPage;
import com.thefloowautomationpractice.qa.testpages.LogInMyStorePage;

import com.thefloowautomationpractice.qa.testpages.MyAccountMyStore;
import com.thefloowautomationpractice.qa.testpages.Purchase;

public class ConductingSearchTest extends TestBase
{
	public boolean bResult;
	Logger                        objLog;
	IndexPage                     objIndexPage;
	LogInMyStorePage              objLogInMyStorePage;
	MyAccountMyStore              objMyAccountMyStore;	
	Purchase                      objPurchase;
	AddToCart                     objAddToCart;
	
	
	public ConductingSearchTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		objLog              = Logger.getLogger(ConductingSearchTest.class);
		
		initialization();			
	    objLog.info(" ");
	    objLog.info(" ");
		objLog.info("   Test Preparation:    Driver Launched Successfully");
		
		urlOpen();
		objLog.info("   Test Preparation:    URL Opened Successfully"); 
		
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("   Test Case:    Conducting Search");        
		objLog.info("               ");
		
		objIndexPage            = new IndexPage();
		objLogInMyStorePage     = new LogInMyStorePage();
		objMyAccountMyStore     = new MyAccountMyStore();
		objPurchase             = new Purchase();
   }
	
	@AfterMethod
   	public void tearDown() 
    {
	   driver.quit();
    }
	
	@Test
  	public void TestCase3_SearchAProudct() {

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
        
	   objLogInMyStorePage       = objIndexPage.indexPageSignin();
	   bResult = objLogInMyStorePage.verifyLoginMyStoreOpen();
	   
	   if (bResult == true)
	   {
		   objLog.info("   Test Step: Login Page Opened Successfully");
	   }
	   else
	   {
		   objLog.info("   Some Problem with the Application Code while openning Login Page");
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
                	        
       objPurchase = objMyAccountMyStore.SearchForAProduct();
       bResult=objPurchase.verifySearchPage();
           
       if (bResult == true)
       {
           	 objLog.info("   Test Step: Searched for an Item Successfully");
       }
       else
       {
    	   objLog.info("   Unable To Search for an Item");
           	 Assert.fail();	                	 
       }
  	}
}
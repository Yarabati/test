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
import com.thefloowautomationpractice.qa.testpages.ProceedToCheckOut;
import com.thefloowautomationpractice.qa.testpages.Purchase;
import com.thefloowautomationpractice.qa.testpages.Summary;

public class NavigationTest extends TestBase
{
	public boolean bResult;
	public String  purchasePageTitle;
	
	
	Logger                        objLog;
	IndexPage                     objIndexPage;
	LogInMyStorePage              objLogInMyStorePage;
	MyAccountMyStore              objMyAccountMyStore;	
	Purchase                      objPurchase;
	AddToCart                     objAddToCart;
	ProceedToCheckOut			  objProceedToCheckOut;
	Summary objSummary;
	
	
	public NavigationTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		objLog              = Logger.getLogger(NavigationTest.class);
		
		initialization();			
		objLog.info(" ");
	    objLog.info(" ");
		objLog.info("   Test Preparation:    Driver Launched Successfully");
		
		urlOpen();
		objLog.info("   Test Preparation:    URL Opened Successfully"); 
		
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("   Test Case:    Conducting some navigation and checking some values exist");        
		objLog.info("               ");
		
		objIndexPage            = new IndexPage();
		objLogInMyStorePage     = new LogInMyStorePage();
		objMyAccountMyStore     = new MyAccountMyStore();
		objPurchase             = new Purchase();
		objAddToCart            = new AddToCart();
		objProceedToCheckOut    = new ProceedToCheckOut();
		objSummary              = new Summary();
   }
	
	@AfterMethod
   	public void tearDown() 
    {
	   driver.quit();
    }
	
	@Test
  	public void TestCase4_Navigations() {

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
		   objLog.info("   Unable To Login to Application");
		   Assert.fail();
	   } 
	 
	   String regUserName = prop.getProperty("username");
	   String regUserPassword = prop.getProperty("password");
       
       objMyAccountMyStore =  objLogInMyStorePage.registerdAccount(regUserName, regUserPassword);
       objLog.info("   Test Step: Email ID and Password entered Successfully.");
       
       bResult  =  objMyAccountMyStore.verifyLoggedInUser();
       objMyAccountMyStore.verifyLoggedInUser();

       if (bResult == true)
          {
              	 objLog.info("   Test Step: User Logged in Successfully");	                	 
          }
       else
          {
    	   objLog.info("   Unable to Login to Application");
              	 Assert.fail();	                	 
          }
                	        
       objPurchase = objMyAccountMyStore.SearchForAProduct();
       objPurchase.verifySearchPage();
       
       if (bResult == true)
       {
           	 objLog.info("   Test Step: Searched for an Item Successfully");	                	 
       }
       else
       {
    	   objLog.info("   Unable To Search for an Item");
           	 Assert.fail();	                	 
       }
       objAddToCart = objPurchase.addToCart();
       
       purchasePageTitle = objAddToCart.verifyPurchasePageTitle();
       
       if (purchasePageTitle.equalsIgnoreCase("Search - My Store"))
       {
    	   objLog.info("   Test Step: Item Selected Successfully");
       }
       else
       {
         	 objLog.info("   Unable to select an Item to Cart");
           	 Assert.fail();	                	 
       }
       
              
    }
}
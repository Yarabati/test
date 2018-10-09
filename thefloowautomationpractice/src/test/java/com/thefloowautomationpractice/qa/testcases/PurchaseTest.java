package com.thefloowautomationpractice.qa.testcases;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thefloowautomationpractice.qa.testbase.TestBase;
import com.thefloowautomationpractice.qa.testpages.AddToCart;
import com.thefloowautomationpractice.qa.testpages.AddressPage;
import com.thefloowautomationpractice.qa.testpages.IndexPage;
import com.thefloowautomationpractice.qa.testpages.LogInMyStorePage;

import com.thefloowautomationpractice.qa.testpages.MyAccountMyStore;
import com.thefloowautomationpractice.qa.testpages.PaymentPage;
import com.thefloowautomationpractice.qa.testpages.ProceedToCheckOut;
import com.thefloowautomationpractice.qa.testpages.Purchase;
import com.thefloowautomationpractice.qa.testpages.ShippingPage;
import com.thefloowautomationpractice.qa.testpages.Summary;

public class PurchaseTest extends TestBase
{
	public boolean bResult;
	public String  purchasePageTitle;
	
	Logger                        objLog;
	IndexPage                     objIndexPage;
	LogInMyStorePage              objLogInMyStorePage;
	MyAccountMyStore              objMyAccountMyStore;	
	Purchase                      objPurchase;
	AddToCart                     objAddToCart;
	ProceedToCheckOut 			  objProceedToCheckOut;
	Summary                       objSummary;
	AddressPage                   objAddressPage;
	ShippingPage                  objShippingPage;
	PaymentPage                   objPaymentPage;
	
	
	public PurchaseTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		objLog              = Logger.getLogger(PurchaseTest.class);
		
		initialization();				
		objLog.info(" ");
	    objLog.info(" ");
		objLog.info("   Test Preparation:    Driver Launched Successfully");
		
		urlOpen();
		objLog.info("   Test Preparation:    URL Opened Successfully"); 
		
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("               ");
		objLog.info("   Test Case:    Making a purchase");        
		objLog.info("               ");
		
		objIndexPage            = new IndexPage();
		objLogInMyStorePage     = new LogInMyStorePage();
		objMyAccountMyStore     = new MyAccountMyStore();
		objPurchase             = new Purchase();
		objProceedToCheckOut    = new ProceedToCheckOut();
		objSummary              = new Summary();
		objAddressPage          = new AddressPage();
		objShippingPage         = new ShippingPage();
		objPaymentPage          = new PaymentPage();
   }
	
	@AfterMethod
   	public void tearDown() 
    {
	    driver.quit();
    }
	
	@Test
  	public void TestCase5_Purchase() {

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
		   objLog.info("   Unable to open Application");
		   Assert.fail();	    
	   } 
	 
	   String regUserName = prop.getProperty("username");
	   String regUserPassword = prop.getProperty("password");
       
       objMyAccountMyStore =  objLogInMyStorePage.registerdAccount(regUserName, regUserPassword);
       objLog.info("Test Step: Email ID and Password entered Successfully.");
       
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
       objProceedToCheckOut=objAddToCart.proceedToCheckOut();
       
       objSummary= objProceedToCheckOut.clickOnProceedToCheckOut();
       
       bResult=objSummary.verifyPageText();
       
       if (bResult)
       {
    	   objLog.info("   Test Step: Clicked On Proceed to Check");
       }
       else
       {
         	 objLog.info("   Unable to Proceed to Checkout");
           	 Assert.fail();	                	 
       }
       objAddressPage  = objSummary.CompletePayment();
       bResult         = objAddressPage.verifyPageText();
       
       if (bResult)
       {
    	   objLog.info("   Test Step: Clicked On Proceed to Check in Address Tab");
       }
       else
       {
         	 objLog.info("  Unable to Proceed to Checkout in Address Tab");
           	 Assert.fail();	                	 
       }
       
       objShippingPage  = objAddressPage.AddressPayment();
       bResult          = objShippingPage.verifyPageText();
       
       if (bResult)
       {
    	   objLog.info("   Test Step: Clicked On Proceed to Check in Shipping Tab");
       }
       else
       {
         	 objLog.info("  Unable to Proceed to Checkout in Shipping Tab");
           	 Assert.fail();	                	 
       }
       
       objPaymentPage   = objShippingPage.ShippingPayment();
      
       objLog.info("   Test Step: Now it is into the Payment Tab");
       objLog.info("   Test Case Completed Successfully");

  	}
}
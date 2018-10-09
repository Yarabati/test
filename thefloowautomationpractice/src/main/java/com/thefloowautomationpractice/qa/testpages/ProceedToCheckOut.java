package com.thefloowautomationpractice.qa.testpages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testbase.TestBase;

public class ProceedToCheckOut extends TestBase
{
	public boolean bResult;
	

	@FindBy(linkText = "Proceed to checkout")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/text()")
	WebElement verifyText;

	public ProceedToCheckOut(){
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyText() 
	{
		Set<String> prevWindowHandles = driver.getWindowHandles();
		while(true){
		      Set<String> currWindowHandles = driver.getWindowHandles();
		      
		      for(String prevHandle : prevWindowHandles){
		          int noEqualNum = 0;
		          for(String currHandle : currWindowHandles){
		              if(!currHandle.equals(prevHandle))
		                  noEqualNum = noEqualNum + 1;
		          }
		         
		          }
		      bResult = false;
				
				if(verifyText.getText().trim().equalsIgnoreCase("Product successfully added to your shopping cart"))
				{
					bResult=true;
				}
				else
				{
					bResult=false;
				}	
				return bResult;

		}
		
	}	
	
	public Summary clickOnProceedToCheckOut()
	{
		Set<String> prevWindowHandles = driver.getWindowHandles();
		while(true){
		      Set<String> currWindowHandles = driver.getWindowHandles();
		      
		      for(String prevHandle : prevWindowHandles)
		      {
		          int noEqualNum = 0;
		          for(String currHandle : currWindowHandles)
		          {
		              if(!currHandle.equals(prevHandle))
		                  noEqualNum = noEqualNum + 1;
		          }
		         
		        }		      	      
		        proceedToCheckOut.click();
                return new Summary();
	      }
		
		}
}

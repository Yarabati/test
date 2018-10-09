package com.thefloowautomationpractice.qa.testpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thefloowautomationpractice.qa.testpages.AddToCart;
import com.thefloowautomationpractice.qa.testbase.TestBase;

public class Purchase extends TestBase
{
	
	public boolean bResult;
	
	
	@FindBy(className="product_img_link")
	List<WebElement> list ;
	
	@FindBy(className="display-title")
    WebElement puchasePageSearchInfo;
    
    	
	public Purchase()
	{
		PageFactory.initElements(driver,this);
	}	
	
	public AddToCart addToCart()
	{
			
		list.get(1).click();
		return new AddToCart();
   }

	public boolean verifySearchPage() 
	{
		bResult = false;
       	if(puchasePageSearchInfo.getText().equalsIgnoreCase("View"))
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

package com.thefloowautomationpractice.qa.testbase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

		public static WebDriver  driver;
		public static Properties prop;     
		
			
		public TestBase() {
			try {
				
				prop = new Properties();
				FileInputStream fis = new FileInputStream("G:\\Hybridframework\\Maven\\The Floow\\thefloowautomationpractice\\src\\main\\java\\com\\thefloowautomationpractice\\qa\\config\\config.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void initialization() 
		{
			
			String browserName = prop.getProperty("browser");	
					 
			if (browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","g:///software///chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver","g:///software///geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("ie")) 
			{
				System.setProperty("webdriver.ie.driver","g:///software//IEDriverServer.exe");
				driver = new InternetExplorerDriver();	
							
			}
		}		
		
		public static void urlOpen()
		{
						
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}

		
	
}

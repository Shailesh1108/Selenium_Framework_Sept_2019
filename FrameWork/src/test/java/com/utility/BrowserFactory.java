package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory
{
	public static WebDriver startApplication( WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{  
			//Valid Scenario
			System.setProperty("webDriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://freecrm.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		
		else if(browserName.equals("fireFox") )
		{
			System.setProperty("webDriver.chrome.driver", "C://");
			driver.get("https://freecrm.com");;
		}
		

		else if(browserName.equals("IE") )
		{
			System.setProperty("webDriver.chrome.driver", "C://");
			driver.get("https://freecrm.com");;
		}
		

		else
		{
			System.out.println("Not supported browser");
		}

		
		
		return driver;

	}

	
	public  static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}

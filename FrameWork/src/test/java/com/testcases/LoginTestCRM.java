package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.ExcelDataProvider;
import com.utility.Helper;


public class LoginTestCRM extends BaseClass
{
	WebDriver driver;
	
	
	
	@Test
	public void loginApp()
	{
		logger = report.createTest("Login To CRM");
		 //Below details are used for Abstraction-- we are hiding details and just using the functionality 
		 //Go to login page, check all locator and initialize and return the object of same class
		 LoginPage loginPage=  PageFactory.initElements(driver, LoginPage.class);
		 logger.info("Starting Application");
		 loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		 logger.pass("Login Success");
		 Helper.captureScreenShot(driver);
		
		 
		
	}

}

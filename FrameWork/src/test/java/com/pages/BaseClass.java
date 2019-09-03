package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass
{
	
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 
	 
	 
	//  Before Suite uses  to  initialize 
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log(" Setting up before Suite ", true);
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/FreeCRM_ "+ Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log(" Befoer Suite Done ", true);
		//below file is deleted
		
	}
	
	
	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startApplication( driver, config.getBrowser(), config.getStagingUrl());
		 System.out.println(driver.getTitle());
	}
	
	
	@AfterMethod
	public void tearDoenMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot( driver)).build());
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot( driver)).build());
		}
		
		report.flush();
	}
	
	
	
	@AfterClass
	public void quitBrowser()
	{
		BrowserFactory.quitBrowser(driver);
	}
	

}

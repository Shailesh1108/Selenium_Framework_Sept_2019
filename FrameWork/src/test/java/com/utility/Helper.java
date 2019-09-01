package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper
{
	public static String captureScreenShot(WebDriver driver)
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath= System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		try 
		{
			FileHandler.copy(src, new File(screenshotPath));
		} 
		catch (Exception  e) {
			
			System.out.println("Unable to CpatureScreenshots"+ e.getMessage());
		}
		return screenshotPath;
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat CustomFormat= new SimpleDateFormat("MM__dd__yyyy__HH__MM__ss");
		Date CurrentDate= new Date();
		return CustomFormat.format(CustomFormat);
		
		
	}

}

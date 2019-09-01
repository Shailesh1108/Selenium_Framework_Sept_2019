package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	
	// Below constructor help us to initialize the webdriver 
	// To  identify driver we are passing WebDriver driver inside  constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	   @FindBy(name="username")
	   private WebElement uname;
	
	   @FindBy(name="password")
	   private WebElement pass;
	
	   @FindBy(xpath="//input[@value='Login']")
	   private WebElement loginButton;
	   
	   //unameApp and passApp are parameterized
	   public void loginToCRM(String unameApp, String passApp)
	   {
		   
		   uname.sendKeys(unameApp);
		   pass.sendKeys(passApp);
		   loginButton.click();
		   
		   
	   }

}

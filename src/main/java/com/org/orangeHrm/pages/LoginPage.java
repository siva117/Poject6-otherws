package com.org.orangeHrm.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.utilities.UtilityLibrary;



public class LoginPage extends UtilityLibrary{

	WebDriver driver;
	ExtentTest logger;
	UtilityLibrary utilLib;
	
	public LoginPage(WebDriver driver,ExtentTest logger) {
		super(driver, logger);
		this.driver=driver;
		this.logger=logger;
		utilLib=new UtilityLibrary(driver, logger);
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(id="txtUsername")
	private WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	private WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	private WebElement lnkForgotPassword;
	
	public HomePage loginToApp(String username, String password ) throws InterruptedException  {
		
		utilLib.enterText(txtUserName, username, "Enter User Name")
			   .enterText(txtPassword, password, "Enter Password")
			   .click(btnLogin, "Click on login button");
		
		return new HomePage(driver,logger);
		
	}

	
	
	public boolean verifyForgotPassworLnk() {
	 
		return isElementPresent(lnkForgotPassword, "forgot password link");
	}
	
}




package com.org.orangeHrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.org.utilities.UtilityLibrary;

public class CommonPage extends UtilityLibrary {

	WebDriver driver;
	ExtentTest logger;
	UtilityLibrary utilLib;
	public CommonPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver=driver;
		this.logger=logger;
		utilLib=new UtilityLibrary(driver, logger);
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(id="welcome")
	private WebElement lableWelcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement btnLogout;
	
	
	
	public LoginPage logOutFromApp() throws InterruptedException  {
		
		utilLib.click(lableWelcome, "Click on welcome dropdown")
			   .click(btnLogout, "Click on logout button");
		
	return new LoginPage(driver, logger);
		
		
		
	}

}

package com.org.orangeHrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.mongodb.diagnostics.logging.Logger;
import com.org.utilities.UtilityLibrary;

public class HomePage extends UtilityLibrary{

	WebDriver driver;
	ExtentTest logger;
	UtilityLibrary utilLib;
	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver=driver;
		this.logger=logger;
		utilLib=new UtilityLibrary(driver, logger);
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(id="welcome")
	private WebElement lableWelcome;
	
	
	public boolean verifyHomePage() throws InterruptedException  {
		boolean flag=false;
		
		flag=utilLib.isElementPresent(lableWelcome, "Welcome message on home page ");

		
		return flag;
		
		
		
	}

}

package com.org.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UtilityLibrary {
	
	static WebDriver driver;
	static ExtentTest logger;
	
	public UtilityLibrary(WebDriver driver, ExtentTest logger) {
		
		this.driver=driver;
		this.logger=logger;
	}
	
	public UtilityLibrary waitTillElementPresent(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return new UtilityLibrary(driver, logger);
		
	}
	public UtilityLibrary waitTillElementToBeClickable(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return new UtilityLibrary(driver, logger);
		
		
	}
	
	
	public UtilityLibrary click(WebElement element, String description) {
		
		logger.log(Status.INFO, description);
		waitTillElementPresent(element);
		waitTillElementToBeClickable(element);
		
		element.click();
		return new UtilityLibrary(driver, logger);
	}
	
	public UtilityLibrary enterTextAndClickEnterWithOuWait(WebElement element , String text) throws InterruptedException {
			element.sendKeys(text+Keys.ENTER);
			Thread.sleep(5000);
			
			return new UtilityLibrary(driver, logger);
			
		}
	
	public boolean verifyText(WebElement element, String aText) {
		boolean flag=false;
		waitTillElementPresent(element);
		waitTillElementToBeClickable(element);
		String eText=element.getText();
		
		if (eText.equals(aText))
			flag=true;
			
		return flag;
	}
	
	
	public UtilityLibrary enterText(WebElement element , String text, String description ) throws InterruptedException {
		logger.log(Status.INFO, description+": "+text);
		waitTillElementPresent(element);
		waitTillElementToBeClickable(element);
		element.clear();
		element.sendKeys(text);
		
		return new UtilityLibrary(driver, logger);
		
	}
	
	public boolean isElementPresent(WebElement element, String description) {
		
		boolean flag=false;
		
		try {
			waitTillElementPresent(element);
			waitTillElementToBeClickable(element);
			if (element.isDisplayed())
			{
				flag=true;
				logger.log(Status.PASS, description+" is displayed");
			}else {
				logger.log(Status.FAIL, description+" is not displayed");
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, description+" is not displayed");
			logger.fail(e.getMessage());
			e.printStackTrace();
		}
		
		return flag;
	}
	

	
}

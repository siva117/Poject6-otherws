package com.org.utilities;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBaseClass {
	GenericLibrary genLib;
	WebDriver driver;
	public void launchBrowser(String browser) throws Exception {
		genLib=new GenericLibrary();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+genLib.readProperties("chromeDriver"));
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Exection Started Successfully");			
		} else {

		}
	}
	public WebDriver getDriverInstance() {
		return driver;
		
	}

}

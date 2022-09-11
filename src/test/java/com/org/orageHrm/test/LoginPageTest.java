package com.org.orageHrm.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.bson.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.org.orangeHrm.pages.CommonPage;
import com.org.orangeHrm.pages.HomePage;
import com.org.orangeHrm.pages.LoginPage;
import com.org.utilities.GenericLibrary;
import com.org.utilities.TestBaseClass;

public class LoginPageTest extends TestBaseClass {
	

	public  WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CommonPage commonPage;
	Properties properties;
	ExtentReports extent;
	SoftAssert assertion;
	ExtentTest logger;
	HashMap<String, String> testDataa;
	
	


	@BeforeClass
	@Parameters("browser")
	public void initialSetup(String browser) throws Exception{
		launchBrowser(browser);
		driver=getDriverInstance();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/ExecutionReport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
	}@BeforeMethod
	public void launchApplication(){
		driver.get("https://opensource-demo.orangehrmlive.com/" /*utils.readProperties("baseURL")*/);
	}
	@Test(groups={"Smoke", "Regression"}, description="Verify user able to login into appllication", dependsOnMethods= {"checkForgotPasswordLink"})
	public void checkLogin() throws Exception{
		
	
			logger=extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());			
			HashMap<String, String> testData=new GenericLibrary().readJson(getClass().getName().substring(getClass().getName().lastIndexOf(".")+1) , new Object(){}.getClass().getEnclosingMethod().getName());
			assertion=new SoftAssert();
			
			loginPage=new LoginPage(driver, logger);
			boolean flag=loginPage.loginToApp(testData.get("username"), testData.get("password"))
					 			  .verifyHomePage();
			
//
			homePage=new HomePage(driver, logger);
			boolean flag=homePage.verifyHomePage();
			assertion.assertEquals(true,flag );
			
			commonPage=new CommonPage(driver, logger);
			loginPage=commonPage.logOutFromApp();
			
			assertion.assertEquals(true, loginPage.verifyForgotPassworLnk());
			
			
			assertion.assertAll();

	}
	
	@Test(groups={"Smoke", "Regression"}, description="Verify user able to login into appllication" )
	public void checkForgotPasswordLink() throws Exception{

			logger=extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		
			//HashMap<String, String> testData=new Utilities().readJson(getClass().getName().substring(getClass().getName().lastIndexOf(".")+1) , new Object(){}.getClass().getEnclosingMethod().getName());
	
			assertion=new SoftAssert();
			//Assertion as=new Assertion();
			loginPage=new LoginPage(driver, logger);
			
			boolean flag=loginPage.verifyForgotPassworLnk();
			
			assertion.assertEquals(true, flag);
			
		
			assertion.assertAll();


	}
	
	@AfterMethod
	public void getStatus(ITestResult result) throws IOException {
		
		if (result.isSuccess()==false) {
			logger.fail(result.getThrowable());
			logger.addScreenCaptureFromPath(new GenericLibrary().getScreenshot(driver,result.getName()));
		}
	}
	
	@AfterClass
	public void tearDown(){
		extent.flush();
		driver.quit();
	}
	

}
 
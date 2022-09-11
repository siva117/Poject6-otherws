package com.org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.aspectj.weaver.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GenericLibrary {
	


	/**
	 * Method to read json file
	 * @param testCalss
	 * @param testcase
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> readJson(String testCalss, String testcase) throws Exception{
		
		JSONParser jp=new JSONParser();	
		String sysPath=System.getProperty("user.dir");
		String path="\\resource\\com\\org\\orangeHrm\\testdata\\";	
		FileReader file=new FileReader(sysPath+path+testCalss+".json");	
		Object parentOBJ=jp.parse(file);
		
		JSONObject parentJO=(JSONObject)parentOBJ;
		Object childObj=parentJO.get(testcase);
		JSONObject childJO=(JSONObject)childObj;
		
		Set keys=childJO.keySet();
		HashMap<String, String> map=new HashMap<String, String>();
		for (Object key : keys) {			
			map.put((String)key, (String)childJO.get(key));	
		}		
		return map;
	}
	
	/**
	 * Method to read property file
	 * @param propety
	 * @return
	 * @throws Exception
	 */
	public String readProperties(String propety) throws Exception {
		
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/resource/properties/Config.properties");
		Properties prop=new Properties();
		prop.load(fis);		
		
		return prop.getProperty(propety);
	}

	/**
	 * Method to take screenshot
	 * @param driver
	 * @param testName
	 * @return
	 * @throws IOException
	 */
	public String getScreenshot(WebDriver driver, String testName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+testName+ new Random().nextInt()+".png";
		
		FileUtils.copyFile(file, new File(path));
		return path;
		
	}

}

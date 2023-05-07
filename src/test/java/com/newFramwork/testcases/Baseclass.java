package com.newFramwork.testcases;


import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.newFramwork.utilities.ReadConfig;

public class Baseclass 
{
	ReadConfig ReadCnf = new ReadConfig();
	String url =ReadCnf.getBaseURL();
	String browser =ReadCnf.getbeowser();
	
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void SetUp()
	{
		//String browser ="chrome";
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver","F:\\SOFTWARE_SETUP\\chromedriver_win32\\Chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver","F:\\SOFTWARE_SETUP\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.manage().window().maximize();

		    break;
			
		    default:
		    	driver= null;
		    	break;
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//for logging
		logger= LogManager.getLogger("newFramwork");
		
		driver.get(url);
		logger.info("url open");
		
	}
	@AfterClass
	public void teardown()
	{
		//driver.close();
		driver.quit();
	}
	
	
	//to capture screenshot
	public void captureScreenshot(WebDriver driver,String testName)throws IOException
	{
	    //step1= convert web driver object to takeScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2= call getScrnshotAs method to create imgae file
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest= new File(System.getProperty("user.dir")+ "//screenshots//" + testName + ".png");
		//step3= copy image file to destination
		FileUtils.copyFile(src, dest);
	}
}



package com.newFramwork.utilities;
import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//com.newFramwork.utilities.ExtentListnerReport
public class ExtentListnerReport implements ITestListener
{
	//object create of variable
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest Test;

 

	@BeforeTest
	public void ConfigureReport()

	{
		ReadConfig ReadConfig = new ReadConfig();
		//initialize objects
		String timestamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName= "NewFramworkReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//Reports//"+ reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add environment details
		reports.setSystemInfo("machine","testpc1");
		reports.setSystemInfo("OS","windows 11");
		reports.setSystemInfo("user","damini");
		reports.setSystemInfo("Browser",ReadConfig.getbeowser());

		//configuration to change look and feel

		htmlReporter.config().setDocumentTitle("Extent Listner report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		//htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy, hh:mm a '('zzz')'");


	}
	
	public void onStart(ITestContext Result)
	{
		 ConfigureReport();
		System.out.println("onStart method invoke..");
	}
	public void onFinish(ITestContext Result)
	{
		System.out.println("onFinish method invoke..");
		//it is mandatory to  call the flush method to ensure the information written to the started reporter
		reports.flush();
	}
	
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("name of test method failed:"+Result.getName());
		Test= reports.createTest(Result.getName());// create entry in html report
		Test.log(Status.FAIL,MarkupHelper.createLabel("name of the faild test case is :" + Result.getName(),ExtentColor.RED));
	    
		// store  in screenshot in screenshot folder capture screenshot and add info extent report
		String Screenshotpath =System.getProperty("user.dir") + "\\screenshots\\" +Result.getName()+ ".png";
		File ScreenshotFile = new File(Screenshotpath);
		if(ScreenshotFile.exists())
		{
			Test.fail("captured screenshot is bellow:" +Test.addScreenCaptureFromPath(Screenshotpath));
		}
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("name of test method skipped:"+Result.getName());
		Test= reports.createTest(Result.getName());
		Test.log(Status.SKIP,MarkupHelper.createLabel("name of the skipped test case is :" + Result.getName(),ExtentColor.YELLOW));
	}
	
	public void onTestStart(ITestResult  Result)
	{
		System.out.println("name of test method started: "+Result.getName());
	}
	
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("neme of test method successfully executed:"+Result.getName());
		Test= reports.createTest(Result.getName());
		Test.log(Status.PASS,MarkupHelper.createLabel("name of the Passed test case is :" + Result.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) 
	{
		
	}

	

	
}

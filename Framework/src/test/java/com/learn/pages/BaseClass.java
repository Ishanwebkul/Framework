package com.learn.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learn.utility.BrowserFactory;
import com.learn.utility.ConfigDataProvider;
import com.learn.utility.ExcelDataProvider;
import com.learn.utility.Helper;


public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider confg;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void ObjectCreation()
	{
		excel = new ExcelDataProvider();
		confg = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/Report"+Helper.getCurrentDateTime()+".html"));
		reports = new ExtentReports();
		reports.attachReporter(extent);
	}

	@BeforeClass
	public void setup()
	{
		//this is used to check whether this method is running or not just like Sysout
		Reporter.log("Brower Sarted", true);
		driver=BrowserFactory.startapplication(driver, confg.getBrowser(), confg.getURL());
	}
	
	@AfterClass
	public void close()
	{
		BrowserFactory.QuitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.capturescreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Helper.capturescreenshot(driver);
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		reports.flush();
	}
	
}

package com.learn.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String capturescreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/learn_"+ getCurrentDateTime() +".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screenshot Captured");
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to Capture Screenshot >>" + e.getMessage());
		}
		return screenshotpath;
	}

	public static String getCurrentDateTime()
	{
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date date = new Date();
		return dateformat.format(date);
	}
	
}

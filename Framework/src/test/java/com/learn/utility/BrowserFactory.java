package com.learn.utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startapplication(WebDriver driver, String BrowserName, String AppURL) 
	{
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			
		}
		else if(BrowserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("Browser doesn't support");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}

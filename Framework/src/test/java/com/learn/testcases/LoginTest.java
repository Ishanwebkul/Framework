package com.learn.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learn.pages.BaseClass;
import com.learn.pages.LoginPage;
import com.learn.utility.Helper;


public class LoginTest extends BaseClass {
	

	@Test
	public void login()
	{
		logger = reports.createTest("Login to Website");	
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
//		loginpage.login("ishan.malhotra855@webkul.com", "admin");
		loginpage.login(excel.getString("login", 0, 0), excel.getString("login", 0, 1));
		logger.pass("Login Done Successfully");
		//Helper.capturescreenshot(driver);
	}

}

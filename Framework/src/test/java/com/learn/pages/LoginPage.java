package com.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(xpath="//input[@id='username']") WebElement username;
	
	@FindBy(xpath="//input[@id='password']") WebElement password;
	
	@FindBy(xpath="//input[@name='dispatch[auth.login]']") WebElement submitbutton;
	
	public void login(String usrnme, String psswrd)
	{
		username.sendKeys(usrnme);
		password.sendKeys(psswrd);
		submitbutton.click();
	}
}

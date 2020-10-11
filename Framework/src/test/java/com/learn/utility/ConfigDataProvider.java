package com.learn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	 Properties pro;

	public ConfigDataProvider()
	{
		File src = new File("./Config/Configuration.properties");
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} 
		catch (Exception e)
		{
			System.out.println("Not able to load Configuration File. " + e.getMessage());
		}
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getURL()
	{
		return pro.getProperty("URL");
	}
}

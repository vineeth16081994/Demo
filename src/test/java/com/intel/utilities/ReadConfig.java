package com.intel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}	
	public String getUsername()
	{
	String username=pro.getProperty("Username");
	return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("Password");
		return password;
	}
	public String getURL()
	{
		String Url=pro.getProperty("Url");
		return Url;
	}
	public String geChromepath()
	{
		String path=pro.getProperty("Chromepath");
		return path;
	}
   public String getFirefoxpath()
   {
	   String path=pro.getProperty("Firefoxpath");
		return path;
   }
}

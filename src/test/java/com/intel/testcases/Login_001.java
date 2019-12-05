package com.intel.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.intel.pageobjects.LoginPage;

import junit.framework.Assert;

public class Login_001 extends BaseClass {

	@Test
	public  void loginTest() throws IOException
	{
		driver.get(Url);
		log.info("url opened");
		LoginPage Lp=new LoginPage(driver);
		Lp.setUserName(Username);
		log.info("Username entered");
		Lp.setUserPassword(Password);
		log.info("password entered");
		Lp.loginButton();
		log.info("Button clicked");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
		}
	
		else
		{
			captureScreen(driver, "Login_001");
			Assert.assertTrue(false);
			log.info("Fail");
		}
	}

}

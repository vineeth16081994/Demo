package com.intel.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.intel.utilities.ReadConfig;

public class BaseClass {
ReadConfig r=new ReadConfig();


	public   String Username=r.getUsername();
	public  String Password=r.getPassword();
	public   String Url=r.getURL();
	public static WebDriver driver;
	public static Logger log;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		 log=Logger.getLogger("IntelBanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		
			{
			System.setProperty("webdriver.chrome.driver", r.geChromepath());
			driver=new ChromeDriver();
			
			}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", r.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
public void captureScreen(WebDriver driver,String tname) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
}

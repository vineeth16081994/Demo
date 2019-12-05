package com.intel.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
	public LoginPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
@FindBy(name="uid")
WebElement Username;

@FindBy(name="password")
WebElement Password;

@FindBy(name="btnLogin")
WebElement Button;
@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
WebElement lnkLogout;

public void setUserName(String Uname)
{
Username.sendKeys(Uname);
}
public void setUserPassword(String Pword)
{
Password.sendKeys(Pword);
}
public void loginButton()
{
Button.click();
}
public void logOutButton()
{
	lnkLogout.click();
}

}
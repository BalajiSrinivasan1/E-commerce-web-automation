package com.opencart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	public HomePage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath="(//a[@data-bs-toggle='dropdown'])[2]")
	WebElement lnkMyaccount;
	
	public @FindBy(linkText="Register")
	WebElement lnkRegister;
	
	public @FindBy(linkText="Login")
	WebElement linkLogin;
	
	//Action Methods
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
		
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
}

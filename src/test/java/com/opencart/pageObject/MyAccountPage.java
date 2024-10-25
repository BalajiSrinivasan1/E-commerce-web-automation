package com.opencart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{
   WebDriver driver;
   
   public MyAccountPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy(linkText="Logout")
	WebElement lnkLogout;
   
   @FindBy(linkText="Continue")
  	WebElement linkContinue;
   
   
   public void clickLogout()
   {
	   lnkLogout.click();
	 
   }
   
   public void clickOnContinue() {
	   linkContinue.click();
   }
   
}

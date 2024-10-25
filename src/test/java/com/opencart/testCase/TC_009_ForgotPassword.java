package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.pageObject.ForgotPassword;
import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.LoginPage;



public class TC_009_ForgotPassword extends BaseClass
{
@Test
public void test_forgotpassword() throws InterruptedException
{
	logger.info("Starting TC_009_ForgotPassword");
	
	driver.get(url);
	  
	   logger.info("Home Page Displayed ");
	
	   driver.manage().window().maximize();
	   
	  
	   HomePage hp=new HomePage(driver);
	     
	    VisibleOfElement(hp.lnkMyaccount);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
	    VisibleOfElement(hp.linkLogin);
	    hp.clickLogin();
		logger.info("Clicked on Login ");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(username);
		logger.info("Provided Email ");
				  
	   ForgotPassword fp=new ForgotPassword(driver);
	  	fp.setEmail(username);
		logger.info("Provided Email ");
		
	   
	   fp.forgotpwd();
	   fp.femail(username);
	   logger.info("Provided confirmation email");
	   
	   
	   fp.continuebutton();
	   
	   if(fp.successMss.isDisplayed()) {
		   logger.info("forget password is successfull");
		   
		   Assert.assertTrue(true);
	   }else {
		   logger.error("forget password is faild");
		   captureScreen(driver, "test_forgotpassword");
		   SoftAssert sassert=new SoftAssert();
		   sassert.assertTrue(false);
		  
	   }
	   
	   logger.info("Finished TC_009_ForgotPassword");
	  
	   
}
}

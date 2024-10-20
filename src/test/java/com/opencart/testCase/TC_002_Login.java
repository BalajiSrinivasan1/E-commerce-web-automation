package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.homePage;
import com.opencart.pageObject.loginPage;

public class TC_002_Login extends baseClass
{
	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info(" Starting TC_002_Login ");
		
		try
		{
			System.out.println(url);
			driver.get(url);
			
			
			logger.info("Home Page Displayed ");
			
		
			
			HomePage hp=new HomePage(driver);
             
            VisibleOfElement(hp.lnkMyaccount);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
            VisibleOfElement(hp.linkLogin);
            hp.clickLogin();
			logger.info("Clicked on Login ");
			
			loginPage lp=new loginPage(driver);
			
			lp.setEmail(username);
			logger.info("Provided Email ");
			
			lp.setPassword(password);
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			System.out.println(targetpage);
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login is Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Login is Failed: "+e.getMessage());
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
		
	}
}
	
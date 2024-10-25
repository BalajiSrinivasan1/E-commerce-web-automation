package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.LoginPage;
import com.opencart.pageObject.MyAccountPage;

public class TC_002_Login extends BaseClass
{
	@Test(groups= {"sanity","regerssion"})
	public void test_Login()
	{
		logger.info(" Starting TC_002_Login ");
		
		try
		{
		
			driver.get(url);
			
			
			logger.info("Home Page Displayed ");
			
		
			
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
			
			lp.setPassword(password);
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			System.out.println(targetpage);
			if(targetpage)
			{
				logger.info("Login Success ");
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				myaccpage.clickOnContinue();
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
	
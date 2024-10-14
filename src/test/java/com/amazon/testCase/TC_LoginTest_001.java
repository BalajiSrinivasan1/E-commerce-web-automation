package com.amazon.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pageObject.homePage;
import com.amazon.pageObject.loginPage;

public class TC_LoginTest_001 extends baseClass {
	
	@Test
	public void loginTest() {
		driver.get(url);
		logger.info("URL is opened....");
		loginPage lp=new loginPage(driver);
		homePage hm=new homePage(driver);
		elementToClickableAndHover(hm.accountList);
		lp.clickOnSiginBtn();
		lp.setUserName(username);
		lp.clickOnContinue();
		lp.setPassword(password);
	    lp.clickOnSiginSubmit();;
	    logger.info("signin button is clicked");
	    elementToClickableAndHover(hm.accountList);
        System.out.println(lp.signoutBtn.getText());
		if(lp.signoutBtn.getText().equals("Sign Out")) {
			Assert.assertTrue(true);
			logger.info("Login is successfull");
			lp.clickSignoutBtn();
			logger.info("sinout is successfull");
			
		}else {
			captureScreen(driver, "loginTest");
			logger.error("login test is failed");
			Assert.assertTrue(false);
			
		}
	}

}

package com.opencart.testCase;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.ProductCompare;



@Test
public class TC_006_ProductCompare extends BaseClass
{
	
public void testProductCompare () throws InterruptedException 
{
	logger.info("Strating TC_006_ProductCompare");
	
	 driver.get(url);
	 HomePage hp=  new HomePage(driver);
	 logger.info("Home Page Displayed ");
	 
	 driver.manage().window().maximize();
	 
	 ProductCompare pc = new ProductCompare(driver);
	 pc.search_txt("iMac"+Keys.ENTER);
	 

		logger.info("Enter any Product"); 
		

		logger.info("product displayed on HomePage");
		
		
		pc. ClickOnCompareProduct();
	
		logger.info(" add to products comparing");
		
		pc.ClickOnproductCompare();
		logger.info("click on product comparing");
		boolean res=pc.isPresent();
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("product comparing is success");
		}else {
			
			logger.error("product comparing is faild");
			captureScreen(driver, "testProductCompare");
			Assert.assertTrue(false);
		}
		logger.info("Finesg TC_006_ProductCompare");
		
	
}
}


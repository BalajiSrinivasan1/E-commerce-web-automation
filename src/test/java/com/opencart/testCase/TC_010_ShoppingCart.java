package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.ShoppingCart;


public class TC_010_ShoppingCart  extends BaseClass
{
@Test
   public void test_ShoppingCart() throws InterruptedException
    {
	   logger.info("Starting TC_010_ShoppingCart");
	   driver.get(url);
	  
	   logger.info("Home Page Displayed ");
	
	   driver.manage().window().maximize();
	   login();
          
	   ShoppingCart sc=new ShoppingCart(driver);
	   sc.searchtxt("iMac");
	   logger.info("Search iMac is  Displayed ");
	   
	   sc.searchbutton();
	   logger.info("Search Button clicked ");
	 
	 
	   sc.addtocart();
	   logger.info("Add to Cart clicked ");
	   
	 
		
	  sc.shop_cart();
	  logger.info("Shopping Cart clicked ");
	  
		 
	  sc.clickOnCheckOut();
	  logger.info("check out is clicked");
	  sc. shippingAddressdDropDown.click();
	  logger.info("Address drop down is clicked");
	  selectByValue(sc.shippingAddressdDropDown,"989");
	 
	  sc.clickOnShippingMethod();
	  logger.info("shipping methode choose is clicked");
         sc.clickOnPaymentMethode();
	 logger.info("payment methode is choose is clicked");

        sc.addComment.sendKeys("I order some electronic product");
         logger.info("commend is added");

	  sc.confirmOrder.click();
	  logger.info("confirm order is clicked");
	
	  if(sc.orderMessage.isDisplayed()) {
           logger.info("order is successfull");
		  Assert.assertTrue(true);
		  
		  
	  }else {
           logger.fatal("check out is faild");
		  captureScreen(driver, "test_ShoppingCart");
		  Assert.assertTrue(false);
		 
	  }
   
          logout();
	    

	  
}
}

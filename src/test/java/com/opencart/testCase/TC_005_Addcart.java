package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.AddCart;
import com.opencart.pageObject.HomePage;



@Test
public class TC_005_Addcart extends BaseClass

{
	public void  test_addcart() throws InterruptedException
	{
	 logger.info("Starting TC_005_Addcart");
	 try
	 {
	 driver.get(url);
	 HomePage hp=  new HomePage(driver);
	 logger.info("Home Page Displayed ");
	 
	 driver.manage().window().maximize();
		
	 AddCart ac=new AddCart(driver);
	  ac.search_txt("iMac");
	  
		logger.info("Enter any Product"); 
		
		ac.search_button();
		//Thread.sleep(3000);
		logger.info("product displayed on HomePage");
		
		ac.addcart();
		logger.info("product added to cart");
		//Thread.sleep(2000);//
		
		
		
		
		 String confmg=ac.getConfirmationMsg();//
		   
		    if(confmg.equals("Success: You have added iMac to your shopping cart!"))
	        	
	 		{
	        	 logger.info("Add to cart is succussfull");
	 			  Assert.assertTrue(true);
	 		}
	 		else
	 		{
	 			logger.error("Add cart is Failed ");
	 			captureScreen(driver, "test_addcart");
				captureScreen(driver, "TC_005_Addcart"); 
				
				Assert.assertTrue(false);
	 			
	 		}
	    	}
	    	catch(Exception e)
	    	{
	    	logger.fatal("Add cart  Failed: "+e.getMessage());
	    	Assert.fail();
	    	
	    	}
	    	logger.info("Finished TC_005_Addcart");
	}
}
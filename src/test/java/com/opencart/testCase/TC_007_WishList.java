package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.WishList;



public class TC_007_WishList extends BaseClass
{
	
@Test
  public void test_wishlist() throws InterruptedException
  {
	  logger.info("Starting TC_007_WishList");
	try
	{
		
	
	  driver.get(url);
	  HomePage hp=new HomePage(driver);
	   logger.info("Home Page Displayed ");
	
	   driver.manage().window().maximize();
	   
	   WishList wl=new WishList(driver);
	   
	   wl.search_txt("iMac");
	     logger.info("Enter any Product"); 
	
	    wl.search_button();
	   
	   elementIsVisible_Or_Not(wl.wlist);
	    wl.wlist_button();
	    
	   login();
	    wl.wlist_icon();
	    
	    
//	    LoginPage lp=new LoginPage(driver);
//		
//		lp.setEmail(rb.getString("email"));
//		logger.info("Provided Email ");
//		
//		lp.setPassword(rb.getString("password"));
//		logger.info("Provided Password ");
//		
//		lp.clickLogin();
//		logger.info("Clicked on Login");

		

	    boolean tarpage=wl.isPageExists();
	    
	    if(tarpage)
	    {
	    	logger.error("wishList is Success ");
			Assert.assertTrue(true);
	    	
	    }
	    
	    else
		{
	    	logger.info("WishList is Failed ");
	    	captureScreen(driver, "test_wishlist");
			Assert.assertTrue(false);
		}
	}	
	catch(Exception e)
	{
		logger.fatal("WishList Failed: "+e.getMessage());
		Assert.fail();
	}
	
	logger.info(" Finished TC_007_WishList ");
	
}
     }
  
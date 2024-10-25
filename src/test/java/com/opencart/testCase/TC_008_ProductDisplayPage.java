package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.ProductDisplayPage;



public class TC_008_ProductDisplayPage extends BaseClass
{
	
@Test
   public void test_productdisplay() throws InterruptedException 
   {
	  logger.info("Starting TC_008_ProductDisplayPage");
	  try
	 {
		  driver.get(url);
		  HomePage hp=new HomePage(driver);
		   logger.info("Home Page Displayed ");
		
		   driver.manage().window().maximize();
		   
		  ProductDisplayPage pd=new ProductDisplayPage(driver);
		  
		  pd.search_txt("iMac");
		   
		     logger.info("Enter any Product"); 
		
		    pd.search_button();
		  
		    logger.info("click the search button");
		    
		    pd.pro_img();
		   
		    logger.info("click the image");
		    
            pd.pro_duct();
            
            logger.info("click the Product"); 
            
            pd.produreview();
            logger.info("click the Product Review"); 
         
            
         /*  pd.productspec();
           logger.info("click the Product Specificartion");  */
           
            

    	    boolean tarpage=pd.isPageExists();
    	    
    	    if(tarpage)
    	    {
    	    	logger.info("ProductDisplayPage  success ");
       			Assert.assertTrue(true);
    	    }
    	    
    	    else
    		{
    			logger.error("ProductDisplayPage failed ");
    			captureScreen(driver, "test_productdisplay"); //Capturing screenshot
    			Assert.assertTrue(false);
    		}
    	}	
    	catch(Exception e)
    	{
    		logger.fatal("ProductDisplayPage  Failed ");
    		Assert.fail();
    	}
    	
    	logger.info(" Finished TC_008_ProductDisplayPage");
    	 
	  
}
   }


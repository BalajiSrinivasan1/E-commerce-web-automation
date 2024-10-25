package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.SearchPage;


@Test
public class TC_004Search extends BaseClass
{
	 
	public void  test_search() throws InterruptedException
		{
		logger.info(" Starting TC_004_Search ");
		
		try
		{
			
 		   driver.get(url);
		   HomePage hp=new HomePage(driver);
		   logger.info("Home Page Displayed ");
		
		   driver.manage().window().maximize();
		
		    SearchPage sp=new SearchPage(driver);
		
		 //  sp.searchtxt("iPhoness");
		   sp.searchtxt("iMac");
		  
		     logger.info("Enter any Product"); 
		
		    sp.searchbutton();

		    
		   
		    boolean tarpage=sp.isPageExists();
		    
		    if(tarpage)
		    {
		    	logger.info("Search Failed");
		    	captureScreen(driver, "test_search");
				Assert.assertTrue(false);
		    }
		    
		    else
			{
				logger.error("Search Success ");
				
				Assert.assertTrue(true);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Search Failed: "+e.getMessage());
			Assert.fail();
		}
		
		logger.info(" Finished TC_004Search ");
		
	}
	     }
		    

		
	     
	 
	    
	


	   	


	


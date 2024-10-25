package com.opencart.testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageObject.AccountRegistrationPage;
import com.opencart.pageObject.HomePage;
import com.opencart.utilities.ExcelUtils;


public class TC_001_AccountRegistration extends BaseClass

{
    
	 @Test(dataProvider="RegisterData",groups={"regression","sanity"})
		
     public void test_account_Registration(String FName,String LName,String Email,String password) throws InterruptedException
     {
    	logger.info("Strating TC_001_AccountRegistration");
    	try
    	{
    		driver.get(url);//dynamacially get data from the properties file
    		logger.info("Home Page Displayed ");
    	 
    		driver.manage().window().maximize();
 		
 		 
    		HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			elementIsVisible_Or_Not(hp.lnkRegister);
			hp.clickRegister();
			logger.info("Clicked on Register ");
			
			AccountRegistrationPage regpage =new AccountRegistrationPage(driver);
			
			regpage.setFirstName(FName);
	    	logger.info("Provided First Name ");
	    	 
	    	regpage.setLastName(LName);
	    	logger.info("Provided Last Name ");
	    	 
	    	regpage.setEmail(Email);//randomly generated the email
	    	logger.info("Provided Email ");
	    	 
	 		regpage.setPassword(password);
	 		logger.info("Provided Password ");
	 		
	    	regpage.setPrivacyPolicy();
	    	logger.info("Set Privacy Policy ");
	    	 
	       regpage.clickContinue();
	    	logger.info("Clicked on Continue ");
    	 

    	 
    	    String confmsg=regpage.getConfirmationMsg();
    	    
    	    if(confmsg.equals("Your Account Has Been Created!"))
        	// if(confmsg.equals("Your Account Has Been Created!"))//Intensely failing
    	    	
    	    {
    	    	logger.info("Account Registration Success ");
    	    	Assert.assertTrue(true);
    	    }
    	    else
    	    {
    	    	logger.error("Account Registration Failed ");
    	    	captureScreen(driver, "test_account_Registration"); //Capturing screenshot in the screenshot folder==>we mentioned capturescreen method in the base class
    	    	Assert.assertTrue(false);
 			}
    	    
    	}
    	catch(Exception e)
    	{
    		logger.fatal("Account Registration Failed: "+e.getMessage());//Fatal means blocker
    		Assert.fail();
    	}
  
    	logger.info("Finished TC_001_AccountRegistration");
    	
     } 
	 
	 @DataProvider(name="RegisterData")
		String[][] getData()
		{
			String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\opencart\\testdata\\test data.xlsx";
			
			ExcelUtils.addExcelFilePathAndSheetIndexValue(path, 1);
			int rowCount=ExcelUtils.getRowCount();
			int columnCount = ExcelUtils.getColumnCount();
			
			return ExcelUtils.TestData(rowCount, columnCount);
		}
}

	
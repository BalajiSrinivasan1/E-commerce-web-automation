package com.opencart.testCase;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.LoginPage;
import com.opencart.pageObject.MyAccountPage;
import com.opencart.utilities.ExcelUtils;




	public class TC_003_LoginDDT extends BaseClass{
		
		
		@Test(dataProvider="LoginData")
		public void test_LoginDDT(String email,String pwd,String exp)
		{
			logger.info(" Starting TC_003_LoginDDT ");
			
			try
			{
				driver.get(url);
				logger.info("Home Page Displayed ");
				
				driver.manage().window().maximize();
				
				HomePage hp=new HomePage(driver);
			     
			    VisibleOfElement(hp.lnkMyaccount);
				hp.clickMyAccount();
				logger.info("Clicked on My Account ");
			    VisibleOfElement(hp.linkLogin);
			    hp.clickLogin();
				logger.info("Clicked on Login ");
				
				LoginPage lp=new LoginPage(driver);
				
				lp.setEmail(email);
				logger.info("Provided Email ");
				
				lp.setPassword(pwd);
				logger.info("Provided Password ");
				
				lp.clickLogin();
				logger.info("Clicked on Login");
				
				
				boolean targetpage=lp.isMyAccountPageExists();//this method is created in LoginPage
				
				if(exp.equals("Valid"))
				{
					if(targetpage==true)
					{
						logger.info("Login Success ");
						
						
						MyAccountPage myaccpage=new MyAccountPage(driver);
						myaccpage.clickLogout();
						myaccpage.clickOnContinue();
						
						Assert.assertTrue(true);
					}
					else
					{
						logger.error("Login Failed ");
						captureScreen(driver, "test_LoginDDT");
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equals("Invalid"))
				{
					if(targetpage==true)
					{
						MyAccountPage myaccpage=new MyAccountPage(driver);
						myaccpage.clickLogout();
						logger.fatal("Login pass but test case faild because wrong credential");
						captureScreen(driver, "test_LoginDDT");
						Assert.assertTrue(false);
					}
					else
					{		
						logger.info("Login Failed wrong credential but test case is passed");
						Assert.assertTrue(true);
					}
				}
				
				
			}catch(Exception e)
			{
				logger.fatal("Login Failed: "+e.getMessage());
				Assert.fail();
			}
			
			logger.info(" Finished TC_003_LoginDDT ");
			
		}
		
		
		
		@DataProvider(name="LoginData")
		String[][] getData()
		{
			String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\opencart\\testdata\\test data.xlsx";
			
		   ExcelUtils.addExcelFilePathAndSheetIndexValue(path, 2);
			int rowCount=ExcelUtils.getRowCount();
			int columnCount = ExcelUtils.getColumnCount();
			
			return ExcelUtils.TestData(rowCount, columnCount);
		}
		
		
	
	

}

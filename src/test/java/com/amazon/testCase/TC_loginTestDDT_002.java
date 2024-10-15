package com.amazon.testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pageObject.homePage;
import com.amazon.pageObject.loginPage;
import com.amazon.utilities.ExcelUtils;

public class TC_loginTestDDT_002 extends baseClass {
	
    @Test(dataProvider="LoginData")
	public void loginDDT(String username,String pass) {

		 driver.get(url);
		 homePage hm=new homePage(driver);
	      loginPage lp=new loginPage(driver);
               logger.info("account is hoverd");
	      elementToVisibleAndHover(hm.accountList);
			lp.clickOnSiginBtn();
			logger.info("sigin button is clicked");
			try {
               
				lp.setUserName(username);
                 logger.info("user name is entered");
				lp.clickOnContinue();
				lp.setPassword(password);
                 logger.info("password is entered");
			    lp.clickOnSiginSubmit();
                 logger.info("sigin submit button is clicked");
			     elementToClickableAndHover(hm.accountList);
			     
				if(driver.getTitle().contains("Amazon.com. Spend less. Smile more.")) {
					Assert.assertTrue(true);
					logger.info("Login is successfull");
					lp.clickSignoutBtn();
					logger.info("sinout is successfull");
					
				}else {
					captureScreen(driver, "loginDDT");
					logger.error("some think wrong in login");
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				boolean uname = elementIsVisible_Or_Not(lp.usenameInCorrect);
				boolean password=elementIsVisible_Or_Not(lp.passwordInCorrect);
				if(uname) {
					logger.warn("login is faild for wrong user name");
					Assert.assertTrue(false);
				}else if(password) {
					logger.warn("login is faild for wrong password");
					Assert.assertTrue(false);
				}
			}
				
				
			
		}
			
    
	@DataProvider(name="LoginData")
	String[][] getData()
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\amazon\\testData\\test data.xlsx";
		
		ExcelUtils.addExcelFilePathAndSheetIndexValue(path, 0);
		int rowCount=ExcelUtils.getRowCount();
		int columnCount = ExcelUtils.getColumnCount();
		
		return ExcelUtils.TestData(rowCount, columnCount);
	}
	
	
}

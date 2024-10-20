package com.opencart.testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.utilities.ExcelUtils;

public class TC_loginTestDDT_002  {
	
    @Test(dataProvider="LoginData")
	public void loginDDT(String fnam,String lname,String email,String pass) {

		System.out.println(fnam+" "+lname+" "+email+" "+pass);
		 
				
			
		}
			
    
	@DataProvider(name="LoginData")
	String[][] getData()
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\opencart\\testdata\\test data.xlsx";
		
		ExcelUtils.addExcelFilePathAndSheetIndexValue(path, 1);
		int rowCount=ExcelUtils.getRowCount();
		int columnCount = ExcelUtils.getColumnCount();
		
		return ExcelUtils.TestData(rowCount, columnCount);
	}
	
	
}

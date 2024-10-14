package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class a1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\bala\\Desktop\\selenium project\\E-CommerceAutomationProject\\src\\test\\java\\com\\amazon\\testData\\test data.xlsx");
	     Workbook workbook=WorkbookFactory.create(fis);
	     
	     System.out.println(workbook.getSheetAt(0).getLastRowNum());

	}

}

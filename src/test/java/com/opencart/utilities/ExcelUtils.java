package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtils {
	
    static FileInputStream fis;
    static  Workbook workbook;
    static Sheet sheet;
    public static void addExcelFilePathAndSheetIndexValue(String path,int index) {
    	try {
			fis=new FileInputStream(path);
			
				workbook=WorkbookFactory.create(fis);
				sheet = workbook.getSheetAt(index);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("file is not thire in this path "+e.getMessage());
			}
		}
   
    public static int getRowCount() {
    	
    	
    	return sheet.getLastRowNum();
    	
    }
    
    public static int getColumnCount() {
    	
    	return sheet.getRow(0).getLastCellNum();
    }
    
    public static String getValue(int i,int j) {
    	Row row = sheet.getRow(i);
    	Cell cell = row.getCell(j);
    	DataFormatter dft=new DataFormatter();
    	String value = dft.formatCellValue(cell);
    	return value;
    	
    }
 
 
 public static String [][] TestData(int rowCount,int columnCount) {
 	
     String logindata[][]=new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++) {
			
			for(int j=0;j<columnCount;j++) {
     logindata[i-1][j] =  getValue(i, j);
			}
		}
		  FileClose();
		return logindata;
    }
    public static void FileClose() {
    	try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }

	
    
}

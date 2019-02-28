package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

public class ExcelReader {
	
	
	public static void main(String[] args) throws Throwable {
//		
		getTestData("Sheet1");
//		readExcel("C:\\Users\\shiva\\Desktop\\TestData1.xlsx","Contacts");
	}

	
	/* public static Object[][] readExcel(String filePath, String sheetName) throws InvalidFormatException, IOException {
         FileInputStream file= new FileInputStream(filePath);
         XSSFWorkbook wb = new XSSFWorkbook(file);
         XSSFSheet sheet = wb.getSheet(sheetName);
         int rowCount = sheet.getLastRowNum();
         int column = sheet.getRow(0).getLastCellNum();
         Object[][] data = new Object[rowCount][column];
         for (int i = 1; i <= rowCount; i++) {
             XSSFRow row = sheet.getRow(i);
             for (int j = 0; j < column; j++) {
                 XSSFCell cell = row.getCell(j);
                 DataFormatter formatter = new DataFormatter();
                 String val = formatter.formatCellValue(cell);
                 data[i-1 ][j] = val;
                 System.out.println(data[i - 1][j]);
             }
         }

         return data;
     }
*/
	static Workbook book;
	static Sheet sheet;
	//static JavascriptExecutor js;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\duplicate workspace\\SasikalaFramework\\AmazonTest.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
}

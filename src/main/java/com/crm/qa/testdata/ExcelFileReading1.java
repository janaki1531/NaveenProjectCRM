package com.crm.qa.testdata;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	 
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading1 {
 
	//How to read excel files using Apache POI

		public static void main(String[] args) throws Exception {
			excelReading();
		}
	
		
		public static Object[][] excelReading() {
	                        //I have placed an excel file 'Test.xlsx' in my D Driver 
	 FileInputStream fis = null;
	try {
		fis = new FileInputStream("C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\SE Java work space\\SeleniumAutomation\\src\\ExcelFileAndFileIO\\ExcelGuruSheetDemo.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 XSSFWorkbook workbook = null;
	try {
		workbook = new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 XSSFSheet sheet = workbook.getSheetAt(0);
	                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
	 int row = sheet.getLastRowNum();
	 int cell = sheet.getRow(0).getLastCellNum();
	 
	 Object [][] data= new Object[row][cell];
	 for(int i=0;i<row;i++) {
		 for(int j=0;j<cell;j++) {
		 data[i][j]=sheet.getRow(i).getCell(j);
		
			System.out.println(data[i][j]); 
			
		 }
	 }
	    return   data;       
	
	 
	 } 
	}




package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass {
	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait_Timeout = 20;
	public static Actions action;
	public static WebDriverWait wait;
	public static String Test_Path="C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\SE Java work space\\SeleniumAutomation\\src\\ExcelFileAndFileIO\\ExcelGuruSheetDemo.xlsx";
	public static void SwitchFrames(int index) {
		driver.switchTo().frame(index);
	}
	public static void SwitchFrames(String framename) {
		driver.switchTo().frame(framename);
	}
	public static void SwitchFrames(WebElement  webelement) {
		driver.switchTo().frame(webelement);
	}

	public static void MouseHoverElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void javascriptexecutor(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public static void explicitWait(WebDriver driver,long timeout,WebElement element){
		 wait = new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 element.click();
		
	}
	public static void JavaScriptForMousehover(WebElement Element) {
		
		String strJavaScript = "var element = arguments[0];"
	            + "var mouseEventObj = document.createEvent('MouseEvents');"
	            + "mouseEventObj.initEvent( 'mouseover', true, true );"
	            + "element.dispatchEvent(mouseEventObj);";
	     JavascriptExecutor js =  (JavascriptExecutor)driver;
	     js.executeScript(strJavaScript, Element);
		
		}
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Test_Path);
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
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
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
     }*/
	public static Object[][] excelReading(String sheetName) {
		    
		FileInputStream fis = null;
		try {
	//	fis = new FileInputStream(filePath);
		fis = new FileInputStream("C:\\Users\\shiva\\Desktop\\TestData1.xlsx");
		} catch (FileNotFoundException e) {
		
		e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		
		try {
		workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		       
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		
		
		Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		
		System.out.println(data[i][j]); 
		
		
		
		}
		}
		return   data;       
		} 
	
	
	
		}

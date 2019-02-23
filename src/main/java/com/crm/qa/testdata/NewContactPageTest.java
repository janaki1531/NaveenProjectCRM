package com.crm.qa.testdata;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage2;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.ExcelReader;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends BaseClass  {
	
	LoginPage loginpage;
	HomePage2 homepage2;
	ContactsPage contactspage;
	NewContactPage newcontactpage;
	//String sheetName="Contacts";
	
//	public String filePath = "C:\\Users\\shiva\\Desktop\\TestData1.xlsx";
//	public String filePath ="C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\QA SELENIUM BY MADHAVI\\NaveenProject-master\\NaveenProject-master\\NaveenPOMFreeCrm\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData1.xlsx";
//	public String filePath ="C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\QA SELENIUM BY MADHAVI\\NaveenProject-master\\NaveenProject-master\\NaveenPOMFreeCrm\\TestData1.xlsx";
	public String sheetName = "Contacts";
	
	public NewContactPageTest() {
		super();
	}
	
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage2 = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage2.contactsLinkClick();
		newcontactpage=new NewContactPage();
		
}
	@DataProvider
	    public Object[][] readExcel() throws InvalidFormatException, IOException {
	        return TestUtil.excelReading(sheetName);
	    }
	    @Test(dataProvider="readExcel")
	    
		 public void read(String title, String FtName,String LtName,String CmnyName) {
		  	 System.out.println(title);
		  	homepage2.NewContactclickValidate();
			newcontactpage.CreateNewContact(title, FtName, LtName, CmnyName);
			
		    
		    }

	
	
	/*@DataProvider
	public Object[][] GetCrmTestData() throws Exception {
		Object data[][] =TestUtil.readExcel(filePath, sheetName);
		return data;
	}*/
		
	/*@Test(dataProvider="readExcel")
	public void CreateNewContactTest(String title,String FtName,String LtName,String CmnyName) {
		homepage2.NewContactclickValidate();
		newcontactpage.CreateNewContact(title, FtName, LtName, CmnyName);
		
	}*/

@AfterMethod()
public void TearDown() {
	driver.quit();
}
}
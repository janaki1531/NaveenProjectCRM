package com.crm.qa.testdata;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage2;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TimeLinePage;
import com.crm.qa.util.TestUtil;

public class HomePageTest2 extends BaseClass {

	LoginPage loginpage;
	HomePage2 homepage2;
	ContactsPage contactspage; 
	TimeLinePage timelinePage;
	
	
	public HomePageTest2() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage2 = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test(priority=3)
	
	public void HomePageTitleTest(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String  Flag =homepage2.HomePageTitle();
		Assert.assertEquals(Flag, "CRMPRO");
	}

//	@Test(priority=4)
	public void userLabelTest() throws Throwable {
		Thread.sleep(3000);
		TestUtil.SwitchFrames(1);
	boolean Flag=homepage2.conatctslinkValidation();
	Assert.assertTrue(Flag);
	}
	
	public void conatctslinkValidationTest() {
		boolean Flag=homepage2.conatctslinkValidation();
		Assert.assertTrue(Flag);
	
	}
	@Test(priority=1)
	public void contactsLinkClickTest() throws Throwable{
		homepage2.contactsLinkClick();
	}
		//TestUtil.MouseHoverElement(homepage2.ContactsLink);
		//homepage2.NewContactclickValidate();
	//	homepage2.contactsLinkClick();
		
		//	    driver.switchTo().frame(1);
//	    
	   /* String strJavaScript = "var element = arguments[0];"
	            + "var mouseEventObj = document.createEvent('MouseEvents');"
	            + "mouseEventObj.initEvent( 'mouseover', true, true );"
	            + "element.dispatchEvent(mouseEventObj);";
	     JavascriptExecutor js =  (JavascriptExecutor)driver;
	     js.executeScript(strJavaScript, homepage2.ContactsLink);
	     homepage2.NewContactclickValidate();*/

//	@Test(priority=2)

	public void CalanderLinkvalidationTest() throws Throwable {
		Thread.sleep(3000);
		TestUtil.SwitchFrames(1);
		homepage2.CalanderLinkvalidation();
	}

	public void NewContactclickTest() {
		TestUtil.MouseHoverElement(homepage2.ContactsLink);
		homepage2.NewContactclickValidate();
		
	}
	
	
	@AfterMethod()
	public void TearDown() {
		driver.quit();
	}
	
	
	
}

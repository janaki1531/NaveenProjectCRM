package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage2;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseClass {
	

	LoginPage loginpage;
	HomePage2 homepage2;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage2 = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactspage=homepage2.contactsLinkClick();
	}
//@Test	(Priority=1)
	public void verifyContactLabelTest() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(contactspage.verifyContactLabel(),"Contacts label is missing on the page");
	}
	@Test
	public void newcontactclickTest() throws Exception {
	//	TestUtil.SwitchFrames(1);
	  //  Thread.sleep(5000);
	//	TestUtil.javascriptexecutor(contactspage.newcontact);
	//	Thread.sleep(3000);
		contactspage.FirstnameValidate();
		contactspage.LastNamevalidate();
		contactspage.Submit();
		//Assert.assertEquals(actual, expected);
	}

	
	
	@AfterMethod()
	public void TearDown() {
		driver.quit();
	}
	
	
}

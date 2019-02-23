/*package com.crm.qa.testdata;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
//	ContactsPage contactPage;
	
	public HomePageTest(){
		super();
	}

	@BeforeClass()
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void validateContactslinkTest(){
		boolean Flag =homepage.validateContactslink();
		Assert.assertTrue(Flag);
	}
	
	@Test
	public void clickcontacttest() throws Throwable{
		Thread.sleep(3000);
		TestUtil.SwitchFrames(1);
	    homepage.clickcontact();
	    
//	    Assert.assertEquals(arg0, arg1);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
*/
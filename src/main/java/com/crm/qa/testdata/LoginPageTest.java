package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.HomePage2;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage2 homepage2;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void Validatelogintitletest() {
		String CRMtitle = loginpage.validateLogInPageTitle();
		Assert.assertEquals(CRMtitle,
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void ValidateCrmlogotest() {
		boolean flag = loginpage.ValidateCRMlogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void logintest() {
		homepage2= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        String Title = homepage2.HomePageTitle();
        Assert.assertEquals(Title, "CRMPRO");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

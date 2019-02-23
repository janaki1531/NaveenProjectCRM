package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.util.TestUtil;

public class LoginPage extends BaseClass {

	// Page Factory or Object repository OR

	@FindBy(name = "username")
	WebElement Username;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement LoginButton;
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement Signup;
	@FindBy(xpath = "//a[contains(@href,'https://classic.crmpro.com/index.html')]/img")
	WebElement Logo;

	// Initializing The pageobjects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLogInPageTitle() {
		return driver.getTitle();
	}

	public boolean ValidateCRMlogo() {
		return Logo.isDisplayed();
	}

	public HomePage2 login(String usn, String pwd) {
		Username.sendKeys(usn);
		Password.sendKeys(pwd);
		TestUtil.javascriptexecutor(LoginButton);
		return new HomePage2();
	}
}

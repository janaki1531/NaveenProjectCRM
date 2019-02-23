package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.util.TestUtil;

public class HomePage extends BaseClass {
//	ContactsPage contactpage;

//WebElement HomapgeTitle;
	
	@FindBy(xpath = "//td[contains(text(),'User: sas kal ')]")
	WebElement UserNameLabel;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement HomeLink;
	@FindBy(xpath = "//a[contains(text(),'Calendar')]")
	WebElement CalendarLink;
	@FindBy(xpath = "//a[contains(text(),'Companies')]")
	WebElement CompaniesLink;
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement ContactsLink;
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement ContactsLinkNewContact;
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String HomepageTitle(){
		return driver.getTitle();
		
	}
	// 1.Validate username label
	public boolean validatedusernamelabel() {
		return UserNameLabel.isDisplayed();
	}

	// 2.homelink element isDisplayed
	public boolean validateHomelink() {
		return HomeLink.isDisplayed();
	}
	 public boolean validateContactslink(){
	 return ContactsLink.isDisplayed();
	 }

	public ContactsPage clickcontact() {
		ContactsLink.click();
//		TestUtil.javascriptexecutor(ContactsLink);
		return new ContactsPage();
	}

	public ContactsPage clicknewcontact() {
		ContactsLinkNewContact.click();
		return new ContactsPage();
	}
	
}

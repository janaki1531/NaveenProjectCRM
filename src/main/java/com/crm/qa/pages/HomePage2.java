package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.util.TestUtil;

public class HomePage2 extends BaseClass {
	//public static final String Assert = null;

	@FindBy(xpath="//td[contains(text(),'User: janaki kunapareddy')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
public 	WebElement ContactsLink;

	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactclick;
	
	@FindBy(xpath="//div[contains(@id,'handle_CALENDAR')]")
	WebElement CalanderLink;
	
	@FindBy(xpath="//a[contains(text(),'Timeline')]")
	WebElement TimeineLink;
	
	@FindBy(xpath="//a[contains(text(),'Messages')]")
	WebElement MessagesLink;
	

	
	public  HomePage2() {
		PageFactory.initElements(driver, this);
	}
	public String  HomePageTitle() {
		return driver.getTitle();
	}
	
	// 1.Validate username label
	public boolean userLabel() {
		return usernameLabel.isDisplayed();
		
	}
	
	public  boolean conatctslinkValidation() {
		return ContactsLink.isDisplayed();
	}
	public ContactsPage contactsLinkClick() {
		driver.switchTo().frame(1);
		TestUtil.JavaScriptForMousehover(ContactsLink);
		NewContactclick.click();
	
//		TestUtil.javascriptexecutor(ContactsLink);
		return new ContactsPage();
		
	}
	public boolean CalanderLinkvalidation() {
		return CalanderLink.isDisplayed();
	}
	
	public TimeLinePage  TimeineLinkvalidation() {
		 TimeineLink.click();
		 return new TimeLinePage();
	}
	
	public boolean  Messagesvalidation() {
		return  MessagesLink.isDisplayed();
		 
	}
	public NewContactPage NewContactclickValidate() {
		//TestUtil.MouseHoverElement(ContactsLink);
		TestUtil.JavaScriptForMousehover(ContactsLink);
		NewContactclick.click();
		return new NewContactPage();
		//return new  ContactsPage();
		
	}
	//homepage2.ContactsLink
	
	
	
	
	
}

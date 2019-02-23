package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends BaseClass{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsDispaly;
	
	@FindBy(xpath="//input[@value='New Contact']")
public	WebElement newcontact;
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement LastName;
	
	@FindBy(xpath=" //input[@value='Save']")
	WebElement sumbit;
	
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		public boolean verifyContactLabel() {
			return	ContactsDispaly.isDisplayed();
		}
		public void newcontactclick() {
			  newcontact.click();
		}
		public void FirstnameValidate() {
				FirstName.sendKeys("Moksha");
		}
		public void LastNamevalidate() {
			LastName.sendKeys("Chityala");
		}
		public void Submit() {
		//	sumbit.click();
			TestUtil.javascriptexecutor(sumbit);
		}
		
	}
	

/*//input[@name='cs_name']

body > table:nth-child(5) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > form > table.datacard > tbody > tr:nth-child(1) > td:nth-child(1)*/
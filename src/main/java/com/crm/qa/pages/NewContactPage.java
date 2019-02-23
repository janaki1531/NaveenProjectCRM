package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;
import com.crm.qa.util.TestUtil;

public class NewContactPage extends BaseClass {
	
	/*@FindBy(xpath="//select[@name='title']")
	WebElement TitleValue;*/
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	@FindBy(xpath="//input[@name='surname']")
	WebElement LastName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement CompanyLookup;
	@FindBy(xpath="//input[@value='Save']")
	WebElement sumbit;
	
	
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void CreateNewContact(String title,String FtName,String LtName,String CmnyName) {
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(FtName);
		LastName.sendKeys(LtName);
		CompanyLookup.sendKeys(CmnyName);
		TestUtil.javascriptexecutor(sumbit);
		
	}

}

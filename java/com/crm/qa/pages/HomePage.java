package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Iswarya Sivaramulu')]")
	WebElement userNameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="mainpanel")
	WebElement fName;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserLabelName() {
		TestUtil.switchToFrame(fName);
		return userNameLabel.isDisplayed();
	}
	
	public boolean verifyContactsLabel() {
		TestUtil.switchToFrame(fName);
		return contactsLabel.isDisplayed();
	}
	
	public ContactsPage clickOnNewContactLink() throws InterruptedException {
		TestUtil.switchToFrame(fName);
		TestUtil.mouseOverActions(contactsLabel, newContactLink);
		return new ContactsPage();
	}
}

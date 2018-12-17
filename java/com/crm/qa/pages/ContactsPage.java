package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(name="title")
	WebElement dropDwm;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(id="company_position")
	WebElement position;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this); 
	}
	
	public void verifyCreateNewContact(String title, String fname, String lname, String post) {
		Select se = new Select(dropDwm);
		se.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		position.sendKeys(post);
		saveBtn.click();
	}

}

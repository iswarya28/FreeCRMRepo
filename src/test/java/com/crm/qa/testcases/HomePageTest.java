package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		homepage = loginpage.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTitleTest() {
		String title = homepage.verifyTitle();
		Assert.assertEquals(title, "CRMPRO","Title is not matched");
	}
	
	@Test
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homepage.verifyUserLabelName());
	}	
	

	@Test
	public void verifyContactsLabelTest() {
		Assert.assertTrue(homepage.verifyContactsLabel());
	}
	
	@Test
	public void verifyNewContactLink() throws InterruptedException {
		contactspage = homepage.clickOnNewContactLink();
	}
}

package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactspage;
	HomePage homepage;
	LoginPage loginpage;
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
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
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException{
		
		Object excelData[][] = TestUtil.getTestData(sheetName);
		return excelData;	
	}
	
	@Test(dataProvider="getCRMTestData")
	public void verifyCreateNewContactTest(String tit, String firstn, String lastn, String designation) throws InterruptedException {
		contactspage = homepage.clickOnNewContactLink();
		contactspage.verifyCreateNewContact(tit, firstn, lastn, designation);
	}

}

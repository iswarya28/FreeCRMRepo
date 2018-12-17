package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("********** Starting Execution ***************");
//		log.warn("warning");
//		log.debug("debugging");
//		log.fatal("fatal error");
		initialization();
		loginpage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("************** Closing Browser*****************");
	}
	
	@Test
	public void verifyTitleTest() {
		
		String title = loginpage.verifyTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service", "Title is not matched");
	}
	
	@Test
	public void verifyCRMLogoTest() {
		
		Assert.assertTrue(loginpage.verifyCRMLogo());
	}
	
	@Test
	public void verifyLoginPageTest() throws InterruptedException {
		homepage = loginpage.verifyLoginPage(prop.getProperty("username"),prop.getProperty("password"));
	}
}

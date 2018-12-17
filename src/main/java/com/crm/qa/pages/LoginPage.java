package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Objects or OR (Object Repository)
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		WebElement crmLogo;
		
		//initializing the objects
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//page methods
		
		public String verifyTitle() {
			
			return driver.getTitle();	
		}
		
		public boolean verifyCRMLogo() {
			
			return crmLogo.isDisplayed();
		}
		
		public HomePage verifyLoginPage(String uname, String pword) throws InterruptedException {
			
			Thread.sleep(2000);
			username.sendKeys(uname);
			Thread.sleep(2000);
			password.sendKeys(pword);
			loginBtn.click();
			return new HomePage();
		}
		
		
}

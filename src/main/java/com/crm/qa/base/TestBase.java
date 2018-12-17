package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	static WebEventListener eventListener;
	static EventFiringWebDriver e_driver;
	
	public TestBase() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\Selenium_Handson\\FreeCRMTest\\src\\main\\"
					+ "java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Browse\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Browse\\geckodriver.exe");
			driver=new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}

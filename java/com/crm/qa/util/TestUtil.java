package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIMEOUT = 20;
	public static String TESTDATA_PATH = "D:\\Selenium_Handson\\FreeCRMTest\\src\\main\\java"
			+ "\\com\\crm\\qa\\testdata\\crm.xlsx";
	private static XSSFWorkbook workBookObj; 
	private static XSSFSheet workSheetObj;
	public static String currentDir = System.getProperty("user.dir"); 
//switch to frame	
	public static void switchToFrame(WebElement frameName) {
		driver.switchTo().frame(frameName);
	}

// mouse over actions	
	public static void mouseOverActions(WebElement element, WebElement subElement) throws InterruptedException {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		action.moveToElement(subElement).click().build().perform();
		Thread.sleep(2000);
	}
	
//excel access
	public static Object[][] getTestData(String sheetName) throws IOException {
		FileInputStream inputFile = new FileInputStream(TESTDATA_PATH);
		workBookObj = new XSSFWorkbook(inputFile);
		workSheetObj = 	workBookObj.getSheet(sheetName);
		Object[][] data = new Object[workSheetObj.getLastRowNum()][workSheetObj.getRow(0).getLastCellNum()];
		//System.out.println(workSheetObj.getLastRowNum());
		//System.out.println(workSheetObj.getRow(0).getLastCellNum());
		for(int i=0;i<workSheetObj.getLastRowNum();i++) {
			for(int j=0;j<workSheetObj.getRow(0).getLastCellNum();j++) {
				data[i][j] = workSheetObj.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}
		return data;
	}

//take screen shot	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(currentDir +"/ScreenShots/"+ System.currentTimeMillis() +".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
//Explicit Wait
	
	public static void waitForElementToClick(WebElement element,long timeouts) {
		WebDriverWait wait = new WebDriverWait(driver,timeouts);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
}

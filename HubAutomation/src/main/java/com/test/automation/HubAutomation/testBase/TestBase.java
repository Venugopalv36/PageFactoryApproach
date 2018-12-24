package com.test.automation.HubAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.HubAutomation.excelReader.Excel_Reader;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	Excel_Reader excel;
	String url="http://10.2.108.234:6460/";
	String browser="chrome";
	
	
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jConfigPath = "log4j.Properties";
		PropertyConfigurator.configure(log4jConfigPath);
		
	}
	
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome") ){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Object created for browser "+browser);
			
		}else if(browser.equalsIgnoreCase("firefox") ){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Object created for browser "+browser);
		}
		
	}
	
	public void getUrl(String url){
		driver.get(url);
		log.info("Navigating to "+url);
		driver.manage().window().maximize();	
	}
	
	public String[][] getdata(String excelName, String sheetName){
		
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/HubAutomation/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(excelName, sheetName);
		return data;		
	}
	
	public void getScreenshot(String name){
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File scrFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshots/";
			File destFile = new File((String)  reportDirectory + name + "_" + formatter.format(calender.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			
			// To print screenshot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src = '" + destFile.getAbsolutePath() + "' height='100' weight='100' /> </a>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}

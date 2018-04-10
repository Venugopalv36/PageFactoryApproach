package com.test.automation.HubAutomation.testBase;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
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
		}else if(browser.equalsIgnoreCase("firefox") ){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		
	}
	
	public void getUrl(String url){
		driver.get(url);
		driver.manage().window().maximize();
		
	}

}

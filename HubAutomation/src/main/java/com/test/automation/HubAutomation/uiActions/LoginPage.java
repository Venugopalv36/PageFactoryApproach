package com.test.automation.HubAutomation.uiActions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.HubAutomation.testBase.TestBase;

public class LoginPage extends TestBase {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	
	WebDriver driver;
	
	@FindBy(id="txtUserName")
	WebElement loginUsername;
	
	@FindBy(id="txtPassword")
	WebElement loginPassword;
	
	@FindBy(id="ddlSite")
	WebElement selectSiteId;
	
	@FindBy(id="btnLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='msg']")
	WebElement loginErrorMsg;
	
	@FindBy(xpath=".//a/i[@class='Logout']")
	WebElement logoutbutton;
		
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyLoginWithValidCredentials(String userName,String password, String siteId){
		
		loginUsername.sendKeys(userName);
		log.info(userName+" is specified and object is "+loginUsername.toString());
		
		loginPassword.sendKeys(password);
		log.info(password+" is specified and object is "+loginPassword.toString());
		
		loginPassword.sendKeys(Keys.TAB);
		log.info("Tab key Pressed");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Select site_Id = new Select(selectSiteId);
		site_Id.selectByVisibleText(siteId);
		log.info(siteId+" is specified and object is "+selectSiteId.toString());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		submitButton.click();
		log.info("Login Submit button clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	
	public void verifyLoginWithInvalidCredentials(String userName,String password){
		loginUsername.sendKeys(userName);
		log.info(userName+" is specified and object is "+loginUsername.toString());
		
		loginPassword.sendKeys(password);
		log.info(password+" is specified and object is "+loginPassword.toString());
		
		loginPassword.sendKeys(Keys.TAB);
		log.info("Tab key Pressed");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	
		
	public boolean checkLogoutButtonVisible(){
		
		if(logoutbutton.isDisplayed())
		return true;
		else 
		return false;
	}
	
	public String getInvalidLoginText(){
		return loginErrorMsg.getText();
		
	}

}

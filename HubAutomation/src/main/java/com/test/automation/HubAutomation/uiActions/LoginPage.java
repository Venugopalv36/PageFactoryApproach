package com.test.automation.HubAutomation.uiActions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(id="txtUserName")
	WebElement loginUsername;
	
	@FindBy(id="txtPassword")
	WebElement loginPassword;
	
	@FindBy(id="btnLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='msg']")
	WebElement loginErrorMsg;
	
	@FindBy(id="ddlSite")
	WebElement selectSiteID;
		
	@FindBy(xpath="//a/i[@class='Logout']")
	WebElement logoutOption;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyLoginWithInvalidCredentials(String userName,String password){
		
		loginUsername.sendKeys(userName);
		log.info("Specified user name in "+loginUsername.toString());
		
		loginPassword.sendKeys(password);
		log.info("Specified password in "+loginPassword.toString());
		
		loginPassword.sendKeys(Keys.TAB);
		log.info("Pressed Tab key");
			
	}
	
public void verifyLoginWithValidCredentials(String userName,String password, String siteId){
		
		loginUsername.sendKeys(userName);
		log.info("Specified "+userName+" and object is "+loginUsername.toString());
		
		loginPassword.sendKeys(password);
		log.info("Specified "+password+" and object is "+loginPassword.toString());
		
		loginPassword.sendKeys(Keys.TAB);
		log.info("Pressed Tab key");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		Select site_id = new Select(selectSiteID);
    	site_id.selectByVisibleText(siteId);
		log.info("selected "+siteId+"and object is "+selectSiteID.toString());
				
		submitButton.click();
		log.info("Clicked on Submit button and object is "+submitButton.toString());
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
	}
	
	public String getInvalidLoginText(){		
		return loginErrorMsg.getText();
		
	}
	
	public boolean checkLogoutButtonVisible(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if(logoutOption.isDisplayed() == true)
			return true;
		
		else
			return false;
	}



}

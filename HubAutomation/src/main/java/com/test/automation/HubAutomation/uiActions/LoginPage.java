package com.test.automation.HubAutomation.uiActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="txtUserName")
	WebElement loginUsername;
	
	@FindBy(id="txtPassword")
	WebElement loginPassword;
	
	@FindBy(id="btnLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='msg']")
	WebElement loginErrorMsg;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyLoginWithValidCredentials(String userName,String password){
		loginUsername.sendKeys(userName);
		loginPassword.sendKeys(password);
		loginPassword.sendKeys(Keys.TAB);		
			
	}
	
	public void verifyLoginWithInvalidCredentials(String userName,String password){
		loginUsername.sendKeys(userName);
		loginPassword.sendKeys(password);
		loginPassword.sendKeys(Keys.TAB);		
			
	}
	
	public String getInvalidLoginText(){
		return loginErrorMsg.getText();
		
	}

}

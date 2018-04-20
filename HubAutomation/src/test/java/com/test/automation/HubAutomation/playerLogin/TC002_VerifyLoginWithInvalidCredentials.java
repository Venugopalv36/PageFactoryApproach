package com.test.automation.HubAutomation.playerLogin;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.HubAutomation.testBase.TestBase;
import com.test.automation.HubAutomation.uiActions.LoginPage;

public class TC002_VerifyLoginWithInvalidCredentials extends TestBase {
	
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
	 init();
		
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials(){
		loginPage = new LoginPage(driver);
		loginPage.verifyLoginWithValidCredentials("ballytest3", "321212");
		Assert.assertEquals(loginPage.getInvalidLoginText(), "Employee login name not found or Inactive.");
						
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
		
	}

}

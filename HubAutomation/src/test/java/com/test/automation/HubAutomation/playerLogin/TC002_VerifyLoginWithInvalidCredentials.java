package com.test.automation.HubAutomation.playerLogin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.HubAutomation.testBase.TestBase;
import com.test.automation.HubAutomation.uiActions.LoginPage;

public class TC002_VerifyLoginWithInvalidCredentials extends TestBase {
	
public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithInvalidCredentials.class.getName());
	
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
	 init();
		
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials(){
		loginPage = new LoginPage(driver);
		loginPage.verifyLoginWithInvalidCredentials("ballytest", "121212");
		Assert.assertEquals(loginPage.getInvalidLoginText(), "Employee login name not found or Inactive.");
						
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
		log.info("browser closed");
	}

}

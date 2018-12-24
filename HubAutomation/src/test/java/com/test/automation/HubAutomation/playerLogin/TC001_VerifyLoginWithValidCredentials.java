package com.test.automation.HubAutomation.playerLogin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.HubAutomation.testBase.TestBase;
import com.test.automation.HubAutomation.uiActions.LoginPage;

public class TC001_VerifyLoginWithValidCredentials extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithValidCredentials.class.getName());
	
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
	 init();
		
	}
	
	@Test
	public void verifyLoginWithValidCredentials() {
		try {
			log.info("================= VerifyLoginWithValidCredentials test Started ================");
			loginPage = new LoginPage(driver);
			loginPage.verifyLoginWithValidCredentials("ballytest", "121212","BFIVE PROP");
			Assert.assertEquals(loginPage.checkLogoutButtonVisible(), true);
			getScreenshot("verifyLoginWithValidCredentials");
			log.info("================= VerifyLoginWithValidCredentials test Completed ================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			getScreenshot("verifyLoginWithValidCredentials");
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
		
	}
}

package com.banking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.pageObjects.BankLoginPage;


public class TC01_Login extends BankingBaseClass {

	@Test
	public void verifyLogin() throws IOException {
		
		BankLoginPage blpObj = new BankLoginPage(driver); //Initializing constructor
		
		blpObj.setUserName(username);
		blpObj.setPassword(password);
		blpObj.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("Login is successful");
			logger.info(username);
			captureScreen(driver, "verifyLogin-Pass");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "verifyLogin-Fail");		
			logger.info("Login is unsuccessful");
			Assert.assertTrue(false);
		}		
	}
	
}

package com.banking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.BankHomePage;
import com.banking.pageObjects.BankLoginPage;
import com.banking.utilities.XLUtils;


//problem in capturing ss for failed step

public class TC02_LoginDDT extends BankingBaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws IOException, InterruptedException {
		
		BankLoginPage blpObj = new BankLoginPage(driver);
		BankHomePage bhpObj = new BankHomePage(driver);
		
		System.out.println(username);
		System.out.println(password);
		
		blpObj.setUserName(username);
		blpObj.setPassword(password);
		blpObj.clickSubmit();
		
		Thread.sleep(2000);	
		
		if (isAlertPreset() == true) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			System.out.println("Login failed");
			logger.warn("Login failed");
			Assert.assertTrue(false);			
		}
		else {
			Thread.sleep(2000);
			logger.info("Login success");
			Assert.assertTrue(true);
			bhpObj.clickLogout();
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/banking/testData/BankingDemoV1_TD.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String[][] logindata = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}			
		}		
	return logindata;		
	}
	
	
	public boolean isAlertPreset() {		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}		
	}
	
	
}




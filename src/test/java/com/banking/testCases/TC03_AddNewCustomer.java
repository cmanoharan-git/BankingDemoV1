package com.banking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.pageObjects.AddNewCustomer;
import com.banking.pageObjects.BankLoginPage;

@Test
public class TC03_AddNewCustomer extends BankingBaseClass {
		
	public void addNewCustomer() throws InterruptedException, IOException {
		
		BankLoginPage lp = new BankLoginPage(driver);
		lp.setUserName(username);
		logger.info(username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info(password);
		logger.info("Password provided");
		lp.clickSubmit();		
		Thread.sleep(3000);
		
		AddNewCustomer addcustObj = new AddNewCustomer(driver);
		
		System.out.println("Add New Customer Link");
		logger.info("Providing customer info");
		
		addcustObj.clickAddNewCustomer();
		addcustObj.custName("Manoharan");
		addcustObj.custGender("male");
			
		//addcustObj.custDob("05","04","1984");
		addcustObj.custDob("10");
		Thread.sleep(3000);
		
		/*addcustObj.custAddress("1122 Ashford Parkway");
		addcustObj.custCity("Atlanta");
		addcustObj.custState("Georgia");
		addcustObj.custPin("303381");
		addcustObj.custMobileNo("4243739115");
		//generating random email address
		String emailid = genRandomEmailId()+"@gmail.com";
		System.out.println(emailid);
		addcustObj.custEmailAdd(emailid);
		addcustObj.custPassword("Dell1Dell*");
		addcustObj.newCustSubmitButton();
		
		Thread.sleep(5000);
		
		logger.info("Validation started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res == true)
		{
			captureScreen(driver, "addNewCustomer-Pass");
			logger.info("Test case passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCustomer-Fail");
			logger.info("Test case failed");			
			Assert.assertTrue(false);
		}
		
		*/
	} 
	

	
}

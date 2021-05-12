package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankHomePage {
	
	WebDriver ldriver;
	
	public BankHomePage(WebDriver rdriver) {		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public void clickLogout() {
		lnkLogout.click();		
	}
	
}

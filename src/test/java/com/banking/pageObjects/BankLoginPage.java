package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginPage {
	
	WebDriver ldriver;
	
	public BankLoginPage(WebDriver rdriver) {		
		ldriver = rdriver;		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")	
	WebElement txtUserName;
		
	@FindBy(name="password")
	WebElement txtPassword;	
	
	@FindBy(name="btnLogin")	
	WebElement btnLogin;
	
	public void setUserName(String uname) {		
		txtUserName.sendKeys(uname);
	}
		
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit( ) {
		btnLogin.click();		
	}
	
	

}

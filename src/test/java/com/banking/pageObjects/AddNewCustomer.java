package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;	
	
	public AddNewCustomer(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement linkAddNewCustomer;
		
	@FindBy(name="name")
	WebElement custName;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")	
	WebElement txtDob;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPinno;
	
	@FindBy(name="telephoneno")
	WebElement txtTelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtEmailid;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void custName(String cname) {		
		custName.sendKeys(cname);	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	/* public void custDob(String cmonth, String cday, String cyear) {
		System.out.println(cmonth);
		txtDob.sendKeys(cmonth);
		txtDob.sendKeys(cday);
		txtDob.sendKeys(cyear);
	} */
	
	public void custDob(String cmonth) {
		System.out.println(cmonth);
		txtDob.sendKeys(cmonth);	
	} 
	
	
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);		
	}
	
	public void custCity(String ccity) {		
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custPin(String cpinno) {
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custMobileNo(String cmobileno) {
		txtTelephoneno.sendKeys(cmobileno);
	}
	
	public void custEmailAdd(String cemailid) {
		txtEmailid.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void newCustSubmitButton() {
		btnSubmit.click();
	}
}



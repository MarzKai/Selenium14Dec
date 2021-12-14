package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummary {
	
	@FindBy(linkText = "Transfer Funds")
	private WebElement transferFunds;
	
	public AccountSummary(WebDriver driver) { // This is the Constructor. Constructor Name should be same as the Class Name (i.e. Login)
		PageFactory.initElements(driver, this);	// All the Page Classes should have this which is sent from the Test Script. (See Notes)
	}
	
	public void clickTransferFunds() {
		transferFunds.click();
	}
	
	public boolean isTransferFundsPresent() { // This method is added in case for checking "verifyValidLoginTest" It will return True or False depending on whether the Transfer Fund Link is present or not.
		boolean transferFundsPresent = transferFunds.isDisplayed();	// Boolean is used a it used for true or false
		return transferFundsPresent; // Since i am returning the value void is replaced by boolean i.e. (public void becomes public boolean)
		
	}
	

}

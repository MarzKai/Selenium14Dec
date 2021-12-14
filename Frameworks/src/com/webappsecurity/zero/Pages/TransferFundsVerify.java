package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsVerify {
	
	@FindBy(id="btn_submit")
	private WebElement submitBttn;
	
	public TransferFundsVerify(WebDriver driver) { // This is the Constructor. Constructor Name should be same as the Class Name (i.e. Login)
		PageFactory.initElements(driver, this);	// All the Page Classes should have this which is sent from the Test Script. (See Notes)
	}
	
	public void clickSubmit() {
	  submitBttn.click();
	}  

}

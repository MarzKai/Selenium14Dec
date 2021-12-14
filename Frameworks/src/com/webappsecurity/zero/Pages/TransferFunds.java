package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {
	
	@FindBy(id="tf_fromAccountId")
	private WebElement fromAcc;
	
	@FindBy(id="tf_toAccountId")
	private WebElement toAcc;
	
	@FindBy(id="tf_amount")
	private WebElement amnt;
	
	@FindBy(id="tf_description")
	private WebElement descp;
	
	@FindBy(id="btn_submit")
	private WebElement submitBttn;
	
	public TransferFunds(WebDriver driver) { // This is the Constructor. Constructor Name should be same as the Class Name (i.e. Login)
		PageFactory.initElements(driver, this);	// All the Page Classes should have this which is sent from the Test Script. (See Notes)
	}
	
	public void doFundTransfer(String amount, String description) {
		Select fromAccDD = new Select(fromAcc); // Select is used because of the drop down(DD) box 
		fromAccDD.selectByIndex(2); // Text is too long so Index is used. Click on the From Account drop down box and check index i.e. 0,1 & 2 i.e.
		                            // select the Index 2 [Savings (Avail. Balance = $1548)]
		
		Select toAccDD = new Select(toAcc); // Same procedure as above
		toAccDD.selectByIndex(3);
		
		amnt.sendKeys(amount);
		
		descp.sendKeys(description);
		
		submitBttn.click();
		

	}
	

}

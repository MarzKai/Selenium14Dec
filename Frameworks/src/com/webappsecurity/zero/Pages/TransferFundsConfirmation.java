package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement confTextBox;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a") // This is done because there are 3 Iterations which have to be done one after another
	private WebElement username;
	
	@FindBy (id="logout_link") // This is done because there are 3 Iterations which have to be done one after another
	private WebElement logout;
	
	@FindBy(id="signin_button") // This is done because there are 3 Iterations which have to be done one after another
	private WebElement signIn;
			
	public TransferFundsConfirmation(WebDriver driver) { // This is the Constructor. Constructor Name should be same as the Class Name (i.e. Login)
		PageFactory.initElements(driver, this);	// All the Page Classes should have this which is sent from the Test Script. (See Notes)
	}
	
	public String getConfText() { // When method is returning something you cannot us "void"; "Void will be replaced by the data type
		                          // of what is being returned i.e. "String"
		String confText = confTextBox.getText(); //To capture the Text of the Web element
		return confText;
	}
	
	public void logOutFromApp() { // This method is done because there are 3 Iterations which have to be done one after another; Thus this will take us to the 2nd iteration and Login can continue and same for the 3rd Iteration 
		username.click();
		logout.click();
		signIn.click();
	}
	
}	



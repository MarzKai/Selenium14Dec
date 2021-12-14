package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id="user_login")
	private WebElement uName;
	
	@FindBy(id="user_password")
	private WebElement pass;
	
	@FindBy(css="#login_form > div.alert.alert-error") // This is for Verify Invalid Login
	private WebElement errorMsgBox;
	
	@FindBy(name="submit")
	private WebElement signIn;
	
	public Login(WebDriver driver) { // This is the Constructor. Constructor Name should be same as the Class Name (i.e. Login)
		PageFactory.initElements(driver, this);	// All the Page Classes should have this which is sent from the Test Script. (See Notes)
	}
	
	public void applicationlogin(String loginName, String loginPassword) {
		uName.sendKeys(loginName);
		pass.sendKeys(loginPassword);
		signIn.click();
	}
	
	public String getErrorMsgText() { // This method is for Verify Invalid Login / Because it is return, void is replaced with String
		String errorMsg = errorMsgBox.getText();
		return errorMsg;
	}
	

}

package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsConfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base { // 'extends Base' is used so it can use whatever needed from Base Class
	
	@Test
	public void verifyFundTransfer() throws IOException { // write the method
		Login lp = new Login(driver); // Creating Objects of All the Page Classes, then using these Objects Call the methods
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver); // when red lines show press "Control+Shift+O" to import and all red lines disappear
		
		String[][] data = GenericMethods.getData("C:\\SeleniumOct13\\Frameworks.xlsx", "Sheet1"); //This is a Static Method, so i don't have to create Object of the Class
		// Thus call it by Directly using the class name; Pass the complete Path of the Excel Sheet and Sheet Name (Both to be given in the Brackets.
		// Give any variable name, in this case give the name "data", then when error shows place cursor on it and select first fix, then it automatically shows as a 2 Dimensional Array
		
		for(int i = 1; i<data.length;i++) { // "for loop" is used for the 3 Iterations to be done one after the other
		
		lp.applicationlogin(data[i][0], data[i][1]); // now Call All the Methods to do Fund Transfer; Earlier we gave the User name and Password in the Brackets,
		                             // but now we will give it in an "Excel Sheet - Frameworks", so we can take Test Data as required
		acc.clickTransferFunds();
		tf.doFundTransfer(data[i][2], data[i][3]); // same as above i.e take Test Date from Excel Sheet "Frameworks"
		tfv.clickSubmit();
		String actualText = tfc.getConfText();
		String expectedText = data[i][4]; // same as above i.e take Test Date from Excel Sheet "Frameworks"
		
		Assert.assertEquals(actualText, expectedText); 
		
		tfc.logOutFromApp(); //This is for calling this method (public void logOutFromApp())from TransferFundsConfirmation Page 
		
		}
	}
		
		

}

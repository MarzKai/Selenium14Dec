package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application { // This is the main class which we will execute. It contains Steps to connect to Excel Sheet, Pick the Key Words from Excel and then Based on the Key Words perform the Action.
	
	@Test // All the Steps are in Excel Sheet "Frameworks Sheet 2", therefore just write @Test, give Method (public void verifyInvalidLogin()
	public void verifyInvalidLogin() throws IOException { // Inside this method we First connect to the Excel Sheet so that we can pick the Key Words. As seen before we can Connect to the Excel Sheet and Read Data by using the Apachepoi Jar Files
	
		String[][] data = GenericMethods.getData("C:\\SeleniumOct13\\Frameworks.xlsx", "Sheet2");// GenericMethods Class has the Code to Connect to the Excell Sheet.
		// So call the method "getData", and since it is a Static Method there is no need to create an object, but just call it by Directly using the Class Name.
		// @ Things are passed here i.e. The Complete Path of Excel with File Name and the Sheet Name.
		// This gets connected to the Excel Sheet and gets Transfered to a Two Dimensional Array to Store it. The Variable Name is "data".
		
		Methods mtd = new Methods(); //Object for Methods Class is created.
		
		// Making changes to Project after R1.1(Release 1.1)
		for(int i = 1; i<data.length;i++) { // "data.length" will give the Number of Rows in the Excel Sheet
			switch(data[i][3]) {// Pick the Key Words. The Key Words are in the 3rd column and i th Rows.
			case "openBrowser": // eg. Key Word is "openBrowser", then i have to write the Line to Open Chrome Browser(this is added in the "Methods" Class) so that these Methods can be used in Multiple Scripts. 
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox": // As the Password has same Key Word "enterInTextBox" we do not write for it again
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickbutton(data[i][4], data[i][5]); // i.e. loc and locValue
				break;
			case"verifyMsg":
				String actualMsg = mtd.getMessage(data[i][4], data[i][5]); // i.e. loc and locValue
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case"closeApp":
				mtd.closeApplication();
				break;
						
			}
		
	   }
		
	}	

}

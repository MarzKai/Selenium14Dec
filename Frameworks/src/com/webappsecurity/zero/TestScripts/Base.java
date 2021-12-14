package com.webappsecurity.zero.TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
        //System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");// This code is applied only if url is HTTP. These 5 Lines are the code.
		ChromeOptions capability = new ChromeOptions();//This code is applied only if url is HTTP. These 5 Lines are the code
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//This code is applied only if url is HTTP. These 5 Lines are the code
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);//This code is applied only if url is HTTP. These 5 Lines are the code

		driver = new ChromeDriver(capability);//This code is applied only if url is HTTP. These 5 Lines are the code. Else the Above 2 Lines are used.
		
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@AfterClass
	public void closeApplicatio() {
		driver.quit();
	}


}

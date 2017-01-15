package com.zohotesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{

	public LaunchPage (WebDriver driver, ExtentTest test){
		super(driver, test);
			
	}
	public HomePage togoZohoHomePage() {
		driver.get("http://zoho.com");
		//HomePage hp = new HomePage();
		test.log(LogStatus.INFO, "On Home Page");
		HomePage hp = new HomePage(driver,test);
		PageFactory.initElements(driver, hp);
		return hp;
		
		
	}
	
}

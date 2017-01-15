package com.zohotesting;

import java.util.concurrent.TimeUnit;

import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;

public class LandingPage extends BasePage {


	@FindBy(xpath = Constants.crm_icon_xpath)
	public WebElement crmIcon;
	
	public LandingPage(WebDriver driver, ExtentTest test) {
	
		super(driver, test);
		
	}
	
	
	public  Object testLandingPage(boolean testName) throws InterruptedException {
		
		crmIcon.click();
		test.log(LogStatus.INFO, "Clicked on CRM successfully");
	
	    if(testName) {

			CRMPage crmPage = new CRMPage(driver, test);
			PageFactory.initElements(driver, crmPage);
			return crmPage;	
	    }
		else{
			
			LeadPage leadPage = new LeadPage(driver, test);
			PageFactory.initElements(driver, leadPage);
			return leadPage;
		}
		

		
	}

}

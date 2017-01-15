package com.zohotesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import temp.Xls_Reader;

import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.LandingPage;
import com.zohotesting.LeadPage;
import com.zohotesting.util.Constants;
import com.zohotesting.util.DataUtil;

public class DeleteLead extends BaseTest {
		
	
	public static boolean testName = false;


	@BeforeMethod
	public void before(){
		rep = com.zohotesting.reports.ExtentManager.getInstance();
		test = rep.startTest("Delete Lead Testing");
		
	}
	
	@AfterMethod
	public void after(){
		rep.endTest(test);
		rep.flush();
	}
	
	@Test(dataProvider = "getData")
	public void TestLeadDelete(String runmode, String browser, String leadCompany, String leadLastName) throws InterruptedException{	
		
		if(runmode.equals("N")){
			test.log(LogStatus.INFO, "Skipping the test.");
			throw new SkipException("Skipping the test with has No runmode");
		}
		
		openBrowser(browser);
		defaultLogin();
	    LandingPage lp = new LandingPage(driver, test);
	    PageFactory.initElements(driver, lp);  
	    lp.testLandingPage(testName);	    
	    driver.findElement(By.id("tab_Leads")).click();
	    LeadPage leadPage = new LeadPage(driver, test);
	    leadPage.deleteLead(leadLastName);
	    			
		}
		
			
		@DataProvider
		public Object[][] getData(){
			String testName = "DeleteLeadAccountTest";
			Xls_Reader xls = new Xls_Reader(Constants.DataFile_Location);
			return DataUtil.getData(testName, xls);
			
		}
		


}

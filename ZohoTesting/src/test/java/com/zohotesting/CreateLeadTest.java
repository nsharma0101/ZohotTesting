package com.zohotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import temp.Xls_Reader;

import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.CRMPage;
import com.zohotesting.LandingPage;
import com.zohotesting.util.Constants;
import com.zohotesting.util.DataUtil;

public class CreateLeadTest extends BaseTest {
	
	

	
	@BeforeMethod
	public void before(){
		rep = com.zohotesting.reports.ExtentManager.getInstance();
		test = rep.startTest("Create Lead Testing");
		
	}
	
	@AfterMethod
	public void after(){
		rep.endTest(test);
		rep.flush();
	}
	
	public static boolean testName = true;
	
	@Test (dataProvider="getData")
	public void doCreateLead( String runmode, String browser, String company, String email, String firstname, String lastname) throws InterruptedException{
		if(runmode.equals("N")){
			test.log(LogStatus.INFO, "Skipping the test.");
			throw new SkipException("Skipping the test with has No runmode");
		}
		
		openBrowser(browser);
		defaultLogin();
				
		test.log(LogStatus.INFO, "Strarting CreateLeadTest");
		test.log(LogStatus.INFO, "Test Data -- "+runmode+" "+browser+" "+ company+" "+email+"  "+ firstname+" "+ lastname);
		
		LandingPage landingPage = new LandingPage(driver, test);
		PageFactory.initElements(driver, landingPage);  
		test.log(LogStatus.INFO,"Going to CRMPage Class");
		CRMPage crmPage = (CRMPage) landingPage.testLandingPage(testName);
		String name = crmPage.gotoCreateLeadTest(company,email,firstname,lastname);
		
		test.log(LogStatus.INFO, "Name added "+name);
		if(name.equals(firstname+" "+lastname))
			test.log(LogStatus.INFO, "Lead added Successfully");
			else  {
				test.log(LogStatus.INFO, "Lead added Successfully");			
			crmPage.reportFailure("Lead Did not Add Successfully");
		}
		
		driver.close();
	
	}
	
	@DataProvider
	public Object[][] getData(){
		String testName = "CreateLeadTest";
		Xls_Reader xls = new Xls_Reader(Constants.DataFile_Location);
		return DataUtil.getData(testName, xls);
		
	}
	

}

package com.zohotesting;

import java.util.concurrent.TimeUnit;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import temp.Xls_Reader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.HomePage;
import com.zohotesting.LandingPage;
import com.zohotesting.LaunchPage;
import com.zohotesting.LoginPage;
import com.zohotesting.util.Constants;
import com.zohotesting.util.DataUtil;

//Sharing Driver - PageFactory design Pattern 
//one action - give objects of different pages
//common function / Common areasa of pages


public class TestLogin extends BaseTest {
	

	
	@BeforeMethod
	public void before(){
		rep = com.zohotesting.reports.ExtentManager.getInstance();
		test = rep.startTest("Test Login Page");
		
	}
	
	@AfterMethod
	public void after(){
		rep.endTest(test);
		rep.flush();
	}
	
	
	@Test(dataProvider="getData")
	public void dologin(String runmode, String browser, String username, String password, String expectedResult) throws InterruptedException{
		
		test.log(LogStatus.INFO, "Starting Login Test");	
		test.log(LogStatus.INFO, runmode+"----"+browser+"----"+username+"------"+password);
		if(runmode.equals("N")){
			test.log(LogStatus.INFO, "Skipping the test.");
			throw new SkipException("Skipping the test with has No runmode");		
		}	
		
		test.log(LogStatus.INFO, "Opened the browser");	
		
		
		//String expectedTitle = "Sign in to your Zoho Account";
		//loginPage.verifyTitle(expectedTitle);
		openBrowser(browser);
		defaultLogin();
		LaunchPage lp = new LaunchPage(driver, test);		
		PageFactory.initElements(driver, lp);   			//It automatically create the objects of LaunchPage and call the constructor of LaunchPage
		HomePage hp = lp.togoZohoHomePage();
	
		//hp.verifyTitle(String );
		//hp.isElementPresent("xxx");
		
		LoginPage loginPage = hp.gotoLoginPage();
		
		test.log(LogStatus.INFO,"Trying to Login");
		//loginPage.verifyTitle(null);	
		
		Object landingPage =loginPage.goToLandingPage(username, password);

		String actualResult = null;
        
		if(landingPage instanceof LoginPage){
			test.log(LogStatus.INFO, "Not able to login");
		 actualResult ="N";
		}
		else if(landingPage instanceof LandingPage){
			test.log(LogStatus.INFO, "Logged in successfully");		
			actualResult="Y";
		
		
		}
		 if(!actualResult.equals(expectedResult)){
			 loginPage.reportFailure("Login test error" + actualResult);
			 
		 }
		 
		//LandingPage logout = new LandingPage(driver, test);
		//logout.testLandingPage();
		  
   
	}  

	@DataProvider
	public Object[][] getData(){
		String testName = "LoginTest";
		Xls_Reader xls = new Xls_Reader(Constants.DataFile_Location);
		return DataUtil.getData(testName, xls);
		
	}
	
}

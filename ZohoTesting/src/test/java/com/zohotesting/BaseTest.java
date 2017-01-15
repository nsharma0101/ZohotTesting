package com.zohotesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.HomePage;
import com.zohotesting.LaunchPage;
import com.zohotesting.LoginPage;
import com.zohotesting.util.Constants;

public class BaseTest {
	
	ExtentReports rep;
	ExtentTest test;
	WebDriver driver = null; 

	public void openBrowser(String browser){
		
		
		if (browser.equals("Iexplorer")){
			System.setProperty("webdriver.ie.driver", Constants.IEDRIVER_PATH);
			driver = new InternetExplorerDriver();	
		} else if(browser.equals("Chrome")) {  
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver = new ChromeDriver();
		} else if(browser.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_PATH);
			driver = new FirefoxDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
		
		public Object defaultLogin() throws InterruptedException{
			
			
			LaunchPage lp = new LaunchPage(driver, test);		
			PageFactory.initElements(driver, lp);   			//It automatically create the objects of LaunchPage and call the constructor of LaunchPage
			
			HomePage hp = lp.togoZohoHomePage();
		
			//hp.verifyTitle(String );
			//hp.isElementPresent("xxx");
			
			LoginPage loginPage = hp.gotoLoginPage();
			
			test.log(LogStatus.INFO,"Trying to Login");
			//loginPage.verifyTitle(null);	
			
			Object landingPage = loginPage.goToLandingPage(Constants.USERNAME, Constants.PASSWORD);
			
			return landingPage;
			
		}
	}



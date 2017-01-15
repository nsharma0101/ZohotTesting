package com.zohotesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;

public class LoginPage extends BasePage {
	
	
	@FindBy(xpath = Constants.username_field_xpath)
	public WebElement usernameField;
	
	@FindBy(xpath= Constants.password_field_xpath)
	public WebElement passwordField;
	
		   
	 public LoginPage(WebDriver driver, ExtentTest test){
      super(driver,test);	    
	}
	
	public Object goToLandingPage(String username, String password) throws InterruptedException {
	    driver.switchTo().frame(0);
	    
	    String title = driver.getTitle();
	    test.log(LogStatus.INFO, title);
	    test.log(LogStatus.INFO, "UserName is"+ username);
		usernameField.sendKeys(username);
		test.log(LogStatus.INFO, "Password is"+ password);
		passwordField.sendKeys(password);
		passwordField.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		
		test.log(LogStatus.INFO, "Entered UserName and Password");
		
		Thread.sleep(5000);
	
	    title = driver.getTitle();
		test.log(LogStatus.INFO, title);
		boolean login;
		
		if (title.equals("Sign in to your Zoho Account"))
			login = false;
		else 
			login = true;
		
		
		if (!login){	
			LoginPage loginPage = new LoginPage(driver, test);
			PageFactory.initElements(driver, loginPage);
			test.log(LogStatus.INFO, "Login is not successfull");
			return loginPage;
		} else {
			LandingPage landingPage = new LandingPage(driver, test); 
			PageFactory.initElements(driver, landingPage);
			test.log(LogStatus.INFO,"Login is Successfull" );
			return landingPage;
		}
		
		
		}
		
	}



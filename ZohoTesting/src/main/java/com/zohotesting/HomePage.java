package com.zohotesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;

public class HomePage extends BasePage {
	

	@FindBy(xpath = Constants.login_link_xpath)
	public WebElement loginLink;
	
	public HomePage(WebDriver driver, ExtentTest test){
		super(driver, test);
	}
	

	public LoginPage gotoLoginPage() {
		
		loginLink.click();
		//driver.findElement(By.xpath("//a[@Class='signin']")).click();
		test.log(LogStatus.INFO, "Clicked SignIn successfully");
		LoginPage loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
			
		
	}

	
	

}

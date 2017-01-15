package com.zohotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;

public class CRMPage extends BasePage {
	
	@FindBy(id = Constants.Create_New_id)
	public WebElement createNew;
	
	@FindBy(id = Constants.Submenu_New_id)
	public WebElement subMenu;
	
	@FindBy(id = Constants.Company_id)
	public WebElement companyId;
	
	@FindBy(id = Constants.Email_id)
	public WebElement emailId;
	
	@FindBy(id = Constants.FirstName_id)
	public WebElement firstName;
	
	@FindBy(id = Constants.LastName_id)
	public WebElement lastName;
	
	@FindBy(id = Constants.SaveButton_id)
	public WebElement saveButton;
	

	public CRMPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}


	String gotoCreateLeadTest(String company, String email, String firstname, String lastname) {
		
		test.log(LogStatus.INFO,"Start Lead Creation");
		createNew.click();
		subMenu.click();	
		companyId.sendKeys(company);
		emailId.sendKeys(email);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		saveButton.click();
		test.log(LogStatus.INFO,"End Lead Creation");

		String name = driver.findElement(By.id("subvalue_LASTNAME")).getText();

		
		return name;
		
	}

}


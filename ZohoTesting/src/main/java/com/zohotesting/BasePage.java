package com.zohotesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;


public class BasePage {
	
	public WebDriver driver;
	public ExtentTest test;
	
	public BasePage(WebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test = test;

		
	}
	
	public void isElementPresent(String xpath){
		
	}

	public void verifyTitle(String expectedTitle){
		
		String actualTitle = driver.getTitle();
		test.log(LogStatus.INFO, "Verifying title");
		//Assert.assertEquals(actualTitle, expectedTitle);
		if(!actualTitle.equals(expectedTitle))
			reportFailure("Title does not Match");
		
	}

	void reportFailure(String failMessage) {

		// Genearate Logs for Failed
		test.log(LogStatus.FAIL,failMessage);	
		
		//take screen shots
		takeScreenShot();
		
		//fail the test
		Assert.fail(failMessage);
	}

	//only be responsible to take the screen shot
	private void takeScreenShot() {
		// filename of the screenshot
		Date d = new Date();
		String screenShotFile = d.toString().replace(":", "_").replace(" ", "_");
		
		//Store Screen Shot in the file
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(Constants.screenShots_Location + screenShotFile));
		} catch (IOException e){
			e.printStackTrace();
			
		}
			test.log(LogStatus.INFO, "ScreenShots -> " + test.addScreenCapture("C:\\Neeraj Sharma\\Java Selenium Pratice\\zohotesting\\reports\\screenshots"+screenShotFile));
		}
		
		
		
	}


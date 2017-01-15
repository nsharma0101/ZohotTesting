package com.zohotesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.zohotesting.util.Constants;

public class OpenBrowser {
	
	public void openBrowser(String browser){
	
	WebDriver driver = null;
	
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
}

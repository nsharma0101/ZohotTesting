package com.zohotesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohotesting.util.Constants;

public class LeadPage extends BasePage {
	

	public LeadPage(WebDriver driver, ExtentTest test) {
		
		super(driver, test);
		
	}
	
	
public void deleteLead(String leadLastName) {

driver.findElement(By.id("tab_Leads")).click();

List<WebElement> leadName = driver.findElements(By.xpath("html/body/div[11]/div[13]/div/div[6]/div/div[1]/div[2]/div[1]/table/tbody/tr/td[4]/a"));
List<WebElement> company = driver.findElements(By.xpath("html/body/div[11]/div[13]/div/div[6]/div/div[1]/div[2]/div[1]/table/tbody/tr/td[5]"));
List<WebElement> email = driver.findElements(By.xpath("html/body/div[11]/div[13]/div/div[6]/div/div[1]/div[2]/div[1]/table/tbody/tr/td[6]/a"));
List<WebElement> leadOwner = driver.findElements(By.xpath("html/body/div[11]/div[13]/div/div[6]/div/div[1]/div[2]/div[1]/table/tbody/tr/td[9]"));

System.out.println(leadName.size());
		
int i= 0;
while (i < leadName.size()){

	String name = leadName.get(i).getText();
	String companyname =  company.get(i).getText();
	String email_id = email.get(i).getText();
	String  ownername = leadOwner.get(i).getText();
	
	test.log(LogStatus.INFO, name+"  "+companyname+"  "+email_id+"  "+ownername);
	test.log(LogStatus.INFO, leadLastName);
							
	i = i+1;
	if(name.contains(leadLastName)){
		
		
	    driver.findElement(By.xpath("html/body/div[11]/div[13]/div/div[6]/div/div[1]/div[2]/div[1]/table/tbody/tr["+i+"]/td[2]/label/span")).click();
		driver.findElement(By.xpath(".//*[@id='moreAct']")).click();
		driver.findElement(By.xpath(".//*[@id='actionMenu']/ul/li[6]/a")).click();
		driver.findElement(By.id("deleteButton")).click();
	
	}  else
		test.log(LogStatus.INFO, "Do not delete this lead");
	}


}
	
}

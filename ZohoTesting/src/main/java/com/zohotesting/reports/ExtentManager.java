package com.zohotesting.reports;

import java.io.File;


import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.zohotesting.util.Constants;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(Constants.report_location+fileName, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			
			//Optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo("Environment", "QA");
			
		}
		
		return extent;
		
		
	}
	
	

}

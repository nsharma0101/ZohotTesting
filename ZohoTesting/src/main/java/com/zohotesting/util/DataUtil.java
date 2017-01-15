package com.zohotesting.util;

import temp.Xls_Reader;

public class DataUtil {

public static Object[][] getData(String testName,Xls_Reader xls){
		
		//first find where testcases - line number
				int testStartRowNum = 1;
				
				while(!xls.getCellData("Data", 0, testStartRowNum).equals(testName)){
					testStartRowNum++;
				}
			
				System.out.println("Location of test -" +testStartRowNum);
				
				int colStartRowNum = testStartRowNum+1;
				int dataStartRowNum = testStartRowNum+2;
				
				int rows =0;
				while(!xls.getCellData("Data", 0, dataStartRowNum+rows).equals("")){
					
					rows++;
					
				}
				System.out.println("Total number of Rows are " + rows);
				
				int cols = 0;
				while(!xls.getCellData("Data", cols, colStartRowNum).equals("")){
					cols++;
				}
				System.out.println("Total number of Columns are " + cols);
				//Count total rows and cols for that test
				Object[][] data = new Object[rows][cols];
				
				int r = 0;
				for (int rNum=dataStartRowNum; rNum<dataStartRowNum+rows; rNum++){
					
					for (int cNum=0; cNum<cols; cNum++){
						String d = xls.getCellData("Data", cNum, rNum);
						System.out.println(d);
						data[r][cNum] = d;
						
					}
					r++;
					System.out.println("-------------");
					
				}
				return data;
		
		}
		


	
}

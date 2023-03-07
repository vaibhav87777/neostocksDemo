package com.neo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.neo.qa.base.TestbaseClass;

public class TestutilityClass extends TestbaseClass{

	static Sheet sh;
	static Workbook book;
	

	
	//fetch data from excel Sheet using data provider (sheetname "logincredentials")
 public  static Object[][] getMultiTestDataCredentials(String sheetname)    
 { FileInputStream file=null;
	try {
	file=new FileInputStream(testData_PATH);
	}catch(FileNotFoundException e) {e.printStackTrace();}
	try {
     book = WorkbookFactory.create(file);
	}catch(IOException e1) {e1.printStackTrace();}
	 sh = book.getSheet(sheetname);
	//create multi diamentional array object for storing data
	Object  data[][]=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0;i<sh.getLastRowNum();i++)
	{
		for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).toString();//use i+1 because data available in sheet from 2nd row
		}	
	}
	return data;
	
 }
 
	//capture screenshot
	public static void captureSreenshot(WebDriver driver,int testID) 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\user\\eclipse-workspace\\neoStocks\\screenshots_neoStocks\\TCID"+testID+System.currentTimeMillis()+".jpeg");
	try {
	FileHandler.copy(src, dest);
	}catch(IOException e)
	{
	e.printStackTrace();	
	}
	}
	
	
	
	//fetch data from Excel sheet
	public static String getID(int rowindex,int cellindex )
	{ FileInputStream file=null;
	       try {
		file=new FileInputStream(testData_PATH);
	    sh = WorkbookFactory.create(file).getSheet("Sheet1");
	       }catch (IOException e) {e.printStackTrace();}
		 String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
	}
 
	
}

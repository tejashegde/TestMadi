package com.testmadi.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.testmadi.data.ProjectConstants;
import com.testmadi.driver.WebDriverFactory;

public class ExcelRead extends WebDriverFactory {

	
	@Test
	public void geckoDriver() throws Exception {
	
		XSSFWorkbook excelWorkBook;
		XSSFSheet excelSheet;
		XSSFCell excelCell;
		
		FileInputStream file = new FileInputStream(ProjectConstants.testDataFilePath+"ExcelRead.xlsx");
		
		excelWorkBook = new XSSFWorkbook(file);
		excelSheet = excelWorkBook.createSheet();
		ProjectConstants.print(excelSheet.getSheetName().toUpperCase());
		
		WebDriver driver = WebDriverFactory.getDriver();
	//	driver.get("http://compendiumdev.co.uk/selenium/testpages/index.html");
		
		Thread.sleep(5000);
		
	
	}

}

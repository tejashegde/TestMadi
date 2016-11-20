package com.testmadi.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.testmadi.data.ProjectConstants;

public class ExcelRead {

	
	@Test
	public void geckoDriver() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				ProjectConstants.GECKO_DRIVER_PATH);
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		
		driver.quit();
		//XSSFWorkbook
	
	}

}

package com.testmadi.driver;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.testmadi.data.ProjectConstants;
import com.testmadi.reports.TestReport;
import com.testmadi.utils.ScreenshotListener;

import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class WebDriverFactory {

	private static List<WebDriverThread> webDriverThreadPool = Collections
			.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
	
	ProjectConstants pr = new ProjectConstants();

	@BeforeSuite
	public static void instantiateDriverObject() {
	
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}

	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}

	@BeforeMethod
	public void beforeMethod(Method caller) throws Exception {
		TestReport.getTest(caller.getName(),
				"This is the  :" + caller.getName()
						+ ":test, below are the steps!");
		
	}

	@AfterMethod
	public static void quitDriver(Method caller) throws Exception {
		TestReport.closeTest(caller.getName());
		driverThread.get().quitDriver();
	}

	@AfterSuite
	public static void closeDriverObjects() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}

		TestReport.closeReport();
	}
}
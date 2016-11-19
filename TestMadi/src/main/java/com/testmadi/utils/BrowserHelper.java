package com.testmadi.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testmadi.driver.WebDriverFactory;
import com.testmadi.reports.TestReport;

public class BrowserHelper {
	public static String navigateToUrl(String url) throws Exception {
		ExtentTest testReporter = TestReport.getTest();
		try {
			WebDriver driver = WebDriverFactory.getDriver();
			driver.navigate().to(url);
			testReporter.log(LogStatus.INFO, "Navigating to the Url: " + url);
			return driver.getCurrentUrl();
		} catch (UnreachableBrowserException e) {

		}
		return null;

	}
}

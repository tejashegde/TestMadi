package com.testmadi.htmlelements;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testmadi.reports.TestReport;

public class HtmlLink {
	/***
	 * This Method is a Wrapper for Clicking on a Link
	 */
	public static void clickLink(WebElement element) {
		ExtentTest testReporter = TestReport.getTest();
		try {
			testReporter.log(LogStatus.INFO, "Clicked on the Link @: "
					+ element);
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, "Clicked on the Link @: "
					+ element);
		}
	}

}

package com.testmadi.htmlelements;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testmadi.reports.TestReport;
import com.testmadi.utils.ElementWait;

public class HtmlEditBox {
	/***
	 * This Method is a Wrapper for Entering text in a Edit Box
	 *
	 * @param element
	 *            : The HTML EditBox WebElement
	 * @return :boolean true or false
	 * @throws Throwable
	 */
	public static boolean enterText(WebElement element, String textToBeEntered)
			throws Throwable {
		ExtentTest testReporter = TestReport.getTest();
		try {
			ElementWait.waitForElement(element).sendKeys(textToBeEntered);
			testReporter.log(LogStatus.INFO,
					"Entered text into the Edit box @ " + element
							+ " and the entered text is: " + element.getText());
			return true;
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		} catch (ElementNotVisibleException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to find the EditBox @: "
				+ element);
		return false;
	}

	/***
	 * This Method is a Wrapper for Entering text in a Edit Box
	 *
	 * @param element
	 *            : The HTML EditBox WebElement
	 * @return :boolean true or false
	 * @throws Throwable
	 */
	public static boolean enterText(WebElement element, String textToBeEntered,
			String stepInfo) throws Throwable {
		ExtentTest testReporter = TestReport.getTest();
		try {
			ElementWait.waitForElement(element).sendKeys(textToBeEntered);
			testReporter.log(LogStatus.INFO,stepInfo);
			return true;
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		} catch (ElementNotVisibleException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to find the EditBox @: "
				+ element);
		return false;
	}
}

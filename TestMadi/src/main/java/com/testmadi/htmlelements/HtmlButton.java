package com.testmadi.htmlelements;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testmadi.reports.TestReport;
import com.testmadi.utils.ElementWait;

public class HtmlButton {
	/***
	 * This Method is a Wrapper for Clicking on Button
	 *
	 * @param element
	 *            : The HTML Button WebElement
	 * @return :boolean true or false
	 * @throws Throwable
	 */
	public static boolean clickButton(WebElement element) throws Throwable {
		ExtentTest testReporter = TestReport.getTest();
		try {

			ElementWait.waitForElement(element).click();
			testReporter.log(LogStatus.INFO, "Clicked on the button @: "
					+ element);
			return true;
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		} catch (ElementNotVisibleException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to click on the Button@: "
				+ element);
		return false;
	}

	/***
	 * This Method is a Wrapper for Clicking on Button
	 *
	 * @param element
	 *            : The HTML Button WebElement
	 * @return :boolean true or false
	 * @throws Throwable
	 */
	public static boolean clickButton(WebElement element, String stepInfo)
			throws Throwable {
		ExtentTest testReporter = TestReport.getTest();
		try {

			ElementWait.waitForElement(element).click();
			testReporter.log(LogStatus.INFO, stepInfo);
			return true;
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		} catch (ElementNotVisibleException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to click on the Button@: "
				+ element);
		return false;
	}

	/***
	 * This method is a wrapper class that return the text of a button
	 * 
	 * @param element
	 *            :
	 * @return String value: Return the button Text
	 * @throws Throwable
	 */
	public static String getButtonText(WebElement element) throws Throwable {
		ExtentTest testReporter = TestReport.getTest();
		try {

			testReporter.log(LogStatus.INFO, "The Button Text is:"
					+ ElementWait.waitForElement(element).getText());
			return ElementWait.waitForElement(element).getText();
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to Obtain the ButtonText@: "
				+ element);
		return null;
	}

	/***
	 * This method is a wrapper class that verify's if a button is Enabled
	 * 
	 * @param element
	 *            :
	 * @return boolean value: Returns true or false
	 * @throws Throwable
	 */
	public static boolean isButtonEnabled(WebElement element) throws Throwable {
		ExtentTest testReporter = TestReport.getTest();

		try {
			if (ElementWait.waitForElement(element).isEnabled()) {
				testReporter.log(LogStatus.INFO, "The Button is Enabled:"
						+ ElementWait.waitForElement(element).isEnabled());
				return true;
			}
		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to Obtain the ButtonText@: "
				+ element);
		return false;
	}

	/***
	 * This method is a wrapper class that verify's if a button is Displayed
	 * 
	 * @param element
	 *            :
	 * @return boolean value: Returns true or false
	 * @throws Throwable
	 */
	public static boolean isButtonDisplayed(WebElement element)
			throws Throwable {
		ExtentTest testReporter = TestReport.getTest();

		try {
			if (ElementWait.waitForElement(element).isDisplayed()) {
				testReporter.log(LogStatus.INFO, "The Button is Enabled:"
						+ element.isDisplayed());
				return true;
			}

		} catch (NoSuchElementException e) {
			testReporter.log(LogStatus.ERROR, e.getStackTrace().toString());
		}
		testReporter.log(LogStatus.ERROR, "Unable to Obtain the ButtonText@: "
				+ element);
		return false;
	}

}

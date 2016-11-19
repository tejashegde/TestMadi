package com.testmadi.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import test.junit.testsetup.Data;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testmadi.reports.TestReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static com.testmadi.driver.WebDriverFactory.getDriver;

public class ScreenshotListener extends TestListenerAdapter {

	/***
	 * This method will create a File
	 * 
	 * @param screenshot
	 *            : This is
	 * @return This returns a variable of type boolean
	 * @throws IOException
	 */
	private boolean createFile(File screenshot) throws IOException {

		// Let the filecreated be false initially
		boolean fileCreated = false;

		if (screenshot.exists()) {
			fileCreated = true;
		} else {
			// Create a Parent Directory of type File for the screenshot
			File parentDirectory = new File(screenshot.getParent());
			// If the parentDiretory exists OR create a new Parent Directory
			// and create a file
			if (parentDirectory.exists() || parentDirectory.mkdirs()) {
				fileCreated = screenshot.createNewFile();
			}
		}
		// Return the created file
		return fileCreated;
	}

	/***
	 * This method is used to write the screenshot to a File
	 * 
	 * @param driver
	 *            : This is the WebDriver driver(i.e the Browser)
	 * @param screenshot
	 *            : This is a variable of type File
	 * @throws IOException
	 */
	private void writeScreenshotToFile(WebDriver driver, File screenshot)
			throws IOException {
		// Create a FileOutPutStream object
		FileOutputStream screenshotStream = new FileOutputStream(screenshot);
		// Take a screenshot and write it to the File
		screenshotStream.write(((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES));
		// Close FileOutputStream Object
		screenshotStream.close();
	}

	@Override
	/***
	 * This method overrides the ontestFailure
	 * On Failure the method does 2 things
	 * 1)The Method will take a screenshot on failure and then write it to a file
	 * 2)The screenshot is written into the Extent Reports File
	 */
	public void onTestFailure(ITestResult failingTest) {
		try {
			ExtentTest testReporter = TestReport.getTest();

			WebDriver driver = getDriver();
			// Get the screenshot directory from POM.xml
			String screenshotDirectory = System.getProperty("user.dir")+ File.separator+"screenshot";  //System.getProperty("screenshotDirectory");
			Date date = new Date();
			String currentDate = date.toString();
			// Path of the screenshot with failing test name and timestamp
			String screenshotAbsolutePath = screenshotDirectory
					+ File.separator + System.currentTimeMillis() + "_"
					+ failingTest.getName() + ".png";
			// Create a screenshot variable of type File an pass it to
			// the createFile(screenshot)
			File screenshot = new File(screenshotAbsolutePath);
			// if true,then write the screenshot to the file
			if (createFile(screenshot)) {
				try {
					writeScreenshotToFile(driver, screenshot);
				} catch (ClassCastException weNeedToAugmentOurDriverObject) {
					writeScreenshotToFile(new Augmenter().augment(driver),
							screenshot);
				}
				System.out.println("Written screenshot to "
						+ screenshotAbsolutePath);
				// Append the ScreenShot to the Failure
				testReporter
						.log(LogStatus.FAIL,
								"SnapShot of the Failure is:"
										+ testReporter
												.addScreenCapture(screenshotAbsolutePath));
			} else {
				System.err
						.println("Unable to create " + screenshotAbsolutePath);
			}
		} catch (Exception ex) {
			System.err.println("Unable to capture screenshot...");
			ex.printStackTrace();
		}
	}
}

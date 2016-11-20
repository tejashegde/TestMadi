package com.testmadi.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


import java.util.concurrent.TimeUnit;

import static com.testmadi.driver.BrowserCapabilities.FIREFOX;
import static com.testmadi.driver.BrowserCapabilities.CHROME;
import static com.testmadi.driver.BrowserCapabilities.valueOf;

public class WebDriverThread {
	private WebDriver webdriver;
	private BrowserCapabilities browserType;

	private final BrowserCapabilities defaultBrowserType = FIREFOX;
	//private final String browser = System.getProperty("browser").toUpperCase();
	private final String browser ="FIREFOX";
	 private final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");

	// System.getProperty("browser").toUpperCase();
	private final String operatingSystem = System.getProperty("os.name")
			.toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");

	/***
	 * This Method will return an instance of WebDriver if the WebDriver is
	 * null, else it returns a new instance of the driver
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebDriver getDriver() throws Exception {
		if (null == webdriver) {
			browserType = determineEffectiveBrowserType();
			DesiredCapabilities desiredCapabilities = browserType
					.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		}
	//	webdriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return webdriver;
	}

	/***
	 * This methods will quit all the WebDriver instances
	 */
	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	/***
	 * This method will Determine the type of Driver Returned
	 * 
	 * @return FIREFOX,CHROME,IE,OPERA from the BrowserCapabilities Enum
	 */
	private BrowserCapabilities determineEffectiveBrowserType() {
		BrowserCapabilities browserType = defaultBrowserType;
		try {
			browserType = valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '"
					+ browserType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '"
					+ browserType + "'...");
		}
		return browserType;
	}

	/***
	 * Method used initialize the WebDriverObject
	 * 
	 * @param desiredCapabilities
	 * @throws MalformedURLException
	 */
	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities)
			throws MalformedURLException {
		System.out.println(" ");
		System.out.println("Current Operating System: " + operatingSystem);
		System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println("Current Browser Selection: " + browserType);
		System.out.println(" ");

		if (useRemoteWebDriver) {
			URL seleniumGridURL = new URL(System.getProperty("gridURL"));
			String desiredBrowserVersion = System
					.getProperty("desiredBrowserVersion");
			String desiredPlatform = System.getProperty("desiredPlatform");

			if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
				desiredCapabilities.setPlatform(Platform
						.valueOf(desiredPlatform.toUpperCase()));
			}

			if (null != desiredBrowserVersion
					&& !desiredBrowserVersion.isEmpty()) {
				desiredCapabilities.setVersion(desiredBrowserVersion);
			}

			webdriver = new RemoteWebDriver(seleniumGridURL,
					desiredCapabilities);
		} else {
			webdriver = browserType
					.getWebDriverObject(desiredCapabilities);
		}
	}
}

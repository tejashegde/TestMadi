package com.testmadi.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testmadi.driver.WebDriverFactory;

public class ElementWait {
	/***
	 * 
	 * @param element
	 *            : This is the element on which the wait has to occur
	 * @return : Returns the WebElement
	 * @throws Throwable
	 */
	public static WebElement waitForElement(final WebElement element)
			throws Throwable {
		WebDriver driver =WebDriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return element;
	}
}

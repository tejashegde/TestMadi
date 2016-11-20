package com.testmadi.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
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
		WebDriver driver = WebDriverFactory.getDriver();
	
		try {
			driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
			return element;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	private static ExpectedCondition<WebElement> visibilityOfElementLocated(
			final WebElement element) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element.isDisplayed() ? element : null;
			}
		};
	}
}

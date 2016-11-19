package com.testmadi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testmadi.data.ProjectConstants;
import com.testmadi.driver.WebDriverFactory;
import com.testmadi.htmlelements.*;
import com.testmadi.utils.BrowserHelper;

public class LoginPage extends WebDriverFactory {
	// private static WebDriver driver;
	private WebDriver driver = WebDriverFactory.getDriver();

	// define the constructor
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="log")
	public WebElement userName;

	@FindBy(id ="pwd")
	public WebElement passWord;

	@FindBy(id ="login")
	public WebElement loginButton;

	/***
	 * 
	 * @param myUserName
	 *            : This is the UserName for Login
	 * @param myPassWord
	 *            : This is the password for login
	 * @return After login, this method returns a new object of type
	 *         DashBoardPage()
	 * @throws Throwable
	 */
	public DashBoardPage doLogin(String myUserName, String myPassWord)
			throws Throwable {
		BrowserHelper.navigateToUrl(ProjectConstants.appURL);
		
		HtmlEditBox.enterText(userName, myUserName, "Entering the userName "
				+ myUserName + " Into the UserName Box");
		
		HtmlEditBox.enterText(passWord, myPassWord,"Entering the PassWord "
				+ myPassWord + " Into the UserName Box");
		
		HtmlButton.clickButton(loginButton,"Clicking the LoginButton");
		
		return new DashBoardPage();
	}
}

package com.testmadi.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.testmadi.driver.WebDriverFactory;
import com.testmadi.htmlelements.HtmlButton;
import com.testmadi.pages.LoginPage;

public class LoginTest extends WebDriverFactory {
public static String userName = "tejasn1";
public static String password ="8JzGfa#hCvXFwK%1";
	
	@Test
	public void loginToApp() throws Throwable {
		LoginPage lp = new LoginPage();
		lp.doLogin(userName,password);		
		
	//	Assert.assertTrue(false);
		Thread.sleep(2000);
	}
	
	@Test
	public void loginToApp2() throws Throwable {
		LoginPage lp = new LoginPage();
		lp.doLogin(userName,password);		
		
	//	Assert.assertTrue(false);
		Thread.sleep(2000);
	}
	
	@Test
	public void loginToApp3() throws Throwable {
		LoginPage lp = new LoginPage();
		lp.doLogin(userName,password);		
		
	//	Assert.assertTrue(false);
		Thread.sleep(2000);
	}
	
}
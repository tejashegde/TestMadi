This contains explanations on how the driver object is instantiated.


public interface WebDriverSetup {

    WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);

    DesiredCapabilities getDesiredCapabilities();
}

This interface is used to define the type of Driver Object, This will be used in the BrowserCapabilities Enum


1. DesiredCapabilities getDesiredCapabilities();

	In this method, I will set all the capabilities for the WebDriver and then I will return the
	DesiredCapabilities


2. WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
	I will pass the DesiredCapabilities into the method, and with this capabilities
	I will return a WebDriver Object  Based on the Enum Value



------------------------------------------------------------------------------------------------------------------------------------------------
public enum BrowserCapabilities implements WebDriverSetup

This Enum Implements the WebDriverSetUp Interface, The reason is

1)First I will define this Enum Class with values of the types of browser
Eg: FIREFOX{},CHROME{},IE{},SAFARI{}


2)Now I will Implement the methods defined by the Interface WebDriverSetup inside the Enum Values


FIREFOX {
		public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		return capabilities;
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
		return new FirefoxDriver(capabilities);
		}
	},
	
CHROME {
	public DesiredCapabilities getDesiredCapabilities() {
	System.setProperty("webdriver.chrome.driver",
	System.getProperty("user.dir") + File.separator + "drivers"
	+ File.separator + "chromedriver");
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
	capabilities.setCapability("chrome.switches",
	Arrays.asList("--no-default-browser-check"));
	HashMap<String, String> chromePreferences = new HashMap<String, String>();
	chromePreferences.put("profile.password_manager_enabled", "false");
	capabilities.setCapability("chrome.prefs", chromePreferences);
	return capabilities;
	}
	


1. DesiredCapabilities getDesiredCapabilities();

	In this method, I will set all the capabilities for the WebDriver and then I will return the
	DesiredCapabilities


2. WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
	I will pass the DesiredCapabilities into the method, and with this capabilities
	I will return a WebDriver Object  Based on the Enum Value

Analogy
Statement: Build an Indian car with v10 engine, auto navigation.

Using getDesiredCapabilities, I will set the capabilities object with v8 and auto navigation feature

Using  getWebDriverObject(DesiredCapabilities capabilities)  I will pass the capabilities to the 
Newly instantiated Indian Car and then I will return this Car
------------------------------------------------------------------------------------------------------------------------------------------------


This class is used to instantiate the WebDriver Object Based on the BrowserType(FIREFOX,CHROME,IE,SAFARI)
And the capabilities



public class WebDriverThread{

private WebDriver webdriver;
private final String browser = System.getProperty("browser").toUpperCase();;
private BrowserCapabilities browserType;
private final BrowserCapabilities defaultBrowserType = CHROME;
 private final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");


}


Methods in this class
	1. private BrowserCapabilities determineEffectiveBrowserType()

	-This method will determine what type of browser is used
	BrowserCapabilities browserType = defaultBrowserType	• The browserType is set to the defaultBrowserType(either,FIREFOX,CHROME,IE)
		• This is needed, incase the user does not set the 
		private final String browser = System.getProperty("browser"); browser property in the pom.xml, via command line
		
	browserType = valueOf(browser);	Based on the command line variable, browser, the value is set(FIREFOX,CHROME OR IE)
	- This method will now return FIREFOX,CHROME,IE based on what the "browser" property or the defaultBrowserType

2.private void instantiateWebDriver(DesiredCapabilities desiredCapabilities)
	This method is called inside the  public WebDriver getDriver() method in the same class
	
	-webdriver = browserType.getWebDriverObject(desiredCapabilities);
	webdriver 	Based on the browserType value(FIREFOX ,CHROME etc.),  The WebDriverObject     
		 is returned,
		
	useRemoteWebDriver	If true, then initialize the Selenium Remote Webdriver Object

	3. public void quitDriver()
		-This method is used to Quit the WebDriver (This will be used in the WebDriverFactory class)
		
		
	4. public WebDriver getDriver() throws Exception
	-This method is used to get An instance of the webdriver from the WebDriver Pool created in the Driver Factory class
	-
	browserType = determineEffectiveBrowserType();	This will provide  the effective browser type (FIREFOX,CHROME,IE,SAFARI)
	DesiredCapabilities desired Capabilities = browserType	Set the desired Capabilities (browserType is the ENUM value)
	.getDesiredCapabilities();
	instantiateWebDriver(desiredCapabilities);	This call will instantiate the WebDriver by getting the WebDriverObject with the     desired capabilites

------------------------------------------------------------------------------------------------------------------------------------------------


@Listeners(ScreenshotListener.class)
public class WebDriverFactory{

}

This is the WebDriverFactory class

private static List<WebDriverThread> webDriverThreadPool = Collections
.synchronizedList(new ArrayList<WebDriverThread>());

-This is a pool of WebDriverThread Objects

private static ThreadLocal<WebDriverThread> driverThread;
-This is the driverThread which is used to retrieve the Driver Object




1.Before the TestSuite, Initialize the WebDriverThread and add the webdriverthread objects into a List<WebDriverThread>

I am creating new WebDriverThread objects and then adding them to the webDriverPool

	@BeforeSuite
public static void instantiateDriverObject() {
	driverThread = new ThreadLocal<WebDriverThread>() {
				@Override
				protected WebDriverThread initialValue() {
	
				WebDriverThread webDriverThread = new WebDriverThread();'
	
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
				}
			};
		}


2.
public static WebDriver getDriver() throws Exception {
return driverThread.get().getDriver();
}

-This method is used to get the webDriver from the driverThread which is a Threadlocal variable
	driverThread.get().getDriver();
	
NOTE: All the PageObjects and tests must extend the WebDriverFactory class
	The webdriver for the page can be obtained by the below call
	private WebDriver driver = WebDriverFactory.getDriver();
	



	3. After the Suite is completed executing, Close all the webDriverThread objects in the pool using quit.Driver()

@AfterSuite
public static void closeDriverObjects() {
for (WebDriverThread webDriverThread : webDriverThreadPool) {
webDriverThread.quitDriver();
}

TestReport.closeReport();
}



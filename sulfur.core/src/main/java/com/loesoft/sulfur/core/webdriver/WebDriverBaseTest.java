package com.loesoft.sulfur.core.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 * Base test class for WebDriver based tests
 * 
 * @author AaronLoes
 */
public class WebDriverBaseTest {

	protected static WebDriver driver;

	/**
	 * executed before all tests in the class to create a driver based on
	 * current execution configuration
	 */
	@BeforeClass
	public static void initializeDriver() {
		// create the WebDriver
		WebDriverBaseTest.driver = WebDriverFactory.getDriver(WebDriverBrowserProperties.getWebDriverClassName());

		// maximize window of browser
		WebDriverBaseTest.driver.manage().window().maximize();

		// set the WebDriver on PageObject class for page object use
		WebDriverPageObject.setWebDriver(WebDriverBaseTest.driver);
	}

	/**
	 * executed after all tests in the class to stop the created driver and
	 * remove it from memory
	 */
	@AfterClass
	public static void destroyDriver() {
		// stop the driver
		WebDriverBaseTest.driver.quit();

		// cleanup
		WebDriverBaseTest.driver = null;
	}
}

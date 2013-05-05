package com.loesoft.sulfur.core.selenium;

/**
 * Base class for all Selenium based unit tests
 * @author AaronLoes
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.loesoft.sulfur.core.properties.ExecutionProperties;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumBaseTest {
	
	protected static Selenium selenium;
	
	/**
	 * Run before all tests to startup a Selenium server
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {
		selenium = new DefaultSelenium(
				ExecutionProperties.getSeleniumServerHost(),
				ExecutionProperties.getSeleniumServerPort(),
				SeleniumBrowserProperties.getSeleniumBrowserName(),
				ExecutionProperties.getApplicationBaseUrl());
		selenium.start();
	}
	
	/**
	 * Run after all tests to stop the Selenium server
	 */
	@AfterClass
	public static void destroyDriver() {
		selenium.stop();
		selenium = null;
	}
}

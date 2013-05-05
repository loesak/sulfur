package com.loesoft.sulfur.core.selenium;

import java.io.IOException;
import java.util.Properties;

/**
 * Properties class for retrieving properties specific to Selenium test execution
 * @author AaronLoes
 */
public class SeleniumExecutionProperties {
	private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfor/core/selenium/execution-selenium.properties";

	private static final String PROPERTY_KEY_SELENIUM_BROWSER_NAME = "selenium.browser.name";
	
	private static Properties properties = new Properties();
	static {
		try {
			// load from specified file
			properties.load(SeleniumExecutionProperties.class.getClassLoader().getResourceAsStream(BASE_PROPERTY_FILE_PATH));
			
			// overwrite with system properties
			properties.putAll(System.getProperties());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file '" + BASE_PROPERTY_FILE_PATH + "'", e);
		}
	}
	
	/**
	 * retrieves property values for given key
	 * @param key the property name to lookup
	 * @return the property value
	 */
	public static String get(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * retrieves the value for the Selenium browser name
	 * @return the Selenium browser name
	 */
	public static String getWebDriverName() {
		return SeleniumExecutionProperties.get(PROPERTY_KEY_SELENIUM_BROWSER_NAME);
	}
}

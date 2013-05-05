package com.loesoft.sulfur.core.selenium;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Properties class for properties specific to Selenium browsers
 * @author AaronLoes
 */
public class SeleniumBrowserProperties {
	private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfor/core/webdriver/selenium-{0}.properties";

	private static final String PROPERTY_KEY_SELENIUM_BROWSER_NAME = "selenium.browser.name";
	
	private static Properties properties = new Properties();
	static {
		String propertyFileName = null;
		
		try {
			propertyFileName = MessageFormat.format(BASE_PROPERTY_FILE_PATH, SeleniumExecutionProperties.getWebDriverName());
			
			// load from specified file
			properties.load(SeleniumExecutionProperties.class.getClassLoader().getResourceAsStream(propertyFileName));
			
			// overwrite with system properties
			properties.putAll(System.getProperties());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file '" + propertyFileName + "'", e);
		}
	}
	
	/**
	 * retrieves property value for given key
	 * @param key property name
	 * @return the property value
	 */
	public static String get(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * retrieves value of the selenium browser name
	 * equivalent to SeleniumBrowserProperties.get("selenium.browser.name");
	 * @return the selenium browser name
	 */
	public static String getSeleniumBrowserName() {
		return SeleniumExecutionProperties.get(PROPERTY_KEY_SELENIUM_BROWSER_NAME);
	}
}

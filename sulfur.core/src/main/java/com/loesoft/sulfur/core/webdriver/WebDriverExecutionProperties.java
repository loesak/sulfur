package com.loesoft.sulfur.core.webdriver;

import java.io.IOException;
import java.util.Properties;

/**
 * Properties class for retrieving properties specific to execution of WebDriver
 * based tests
 * 
 * @author Aaron Loes
 */
public class WebDriverExecutionProperties {
	private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfur/core/webdriver/execution-webdriver.properties";

	private static final String PROPERTY_KEY_WEBDRIVER_BROWSER_NAME = "webdriver.browser.name";
	private static final String PROEPRTY_KEY_WEBDRIVER_PAGE_LOAD_TIMEOUT = "webdriver.page.load.timeout";

	private static Properties properties = new Properties();
	static {
		try {
			// load from specified file
			properties.load(WebDriverExecutionProperties.class.getClassLoader().getResourceAsStream(BASE_PROPERTY_FILE_PATH));

			// overwrite with system properties
			properties.putAll(System.getProperties());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file '" + BASE_PROPERTY_FILE_PATH + "'", e);
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	public static String getWebDriverName() {
		return WebDriverExecutionProperties.get(PROPERTY_KEY_WEBDRIVER_BROWSER_NAME);
	}

	public static int getPageLoadTimeout() {
		return Integer.parseInt(WebDriverExecutionProperties.get(PROEPRTY_KEY_WEBDRIVER_PAGE_LOAD_TIMEOUT));
	}
}

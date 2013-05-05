package com.loesoft.sulfur.core.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * Properties class that contains general execution properties for Selenese, Selenium, 
 * and WebDriver based tests.
 * 
 * @author AaronLoes
 */
public class ExecutionProperties {
	private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfor/core/execution.properties";

	private static final String PROPERTY_KEY_APPLICATION_BASE_URL = "application.base.url";
	private static final String PROPERTY_KEY_SELENIUM_SERVER_HOST = "selenium.server.host";
	private static final String PROPERTY_KEY_SELENIUM_SERVER_PORT = "selenium.server.port";
	
	private static Properties properties = new Properties();
	static {
		try {
			// load from specified file
			properties.load(ExecutionProperties.class.getClassLoader().getResourceAsStream(BASE_PROPERTY_FILE_PATH));
			
			// overwrite with system properties
			properties.putAll(System.getProperties());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file '" + BASE_PROPERTY_FILE_PATH + "'", e);
		}
	}
	
	/**
	 * retrieves the value of a property with the given key
	 * @param key the lookup key
	 * @return the property value
	 */
	public static String get(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * retrieves the value of the application base url
	 * equivalent to ExecutionProperties.get("application.base.url");
	 * 
	 * @return the value of the application base url
	 */
	public static String getApplicationBaseUrl() {
		return ExecutionProperties.get(PROPERTY_KEY_APPLICATION_BASE_URL);
	}
	
	/**
	 * retrieves the value of the selenium server host
	 * equivalent to ExecutionProperties.get("selenium.server.host");
	 * 
	 * @return the value of the selenium server host
	 */
	public static String getSeleniumServerHost() {
		return ExecutionProperties.get(PROPERTY_KEY_SELENIUM_SERVER_HOST);
	}
	
	/**
	 * retrieves the value of the selenium server port
	 * equivalent to ExecutionProperties.get("selenium.server.port");
	 * 
	 * @return the value of the selenium server port
	 */
	public static int getSeleniumServerPort() {
		return Integer.parseInt(ExecutionProperties.get(PROPERTY_KEY_SELENIUM_SERVER_PORT));
	}
}

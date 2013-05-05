package com.loesoft.sulfur.core.webdriver;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Properties class for looking up browser specific properties
 * 
 * @author Aaron Loes
 */
public class WebDriverBrowserProperties {
	private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfur/core/webdriver/webdriver-{0}.properties";

	private static final String PROPERTY_KEY_WEBDRIVER_CLASS_NAME = "webdriver.class.name";
	private static final String PROPERTY_KEY_WEBDRIVER_REMOTE_URL = "webdriver.remote.url";
	private static final String PROPERTY_PARTIAL_KEY_WEBDRIVER_CAPABILITY = "webdriver.capability.";

	private static Properties properties = new Properties();
	static {
		String propertyFileName = null;

		try {
			propertyFileName = MessageFormat.format(BASE_PROPERTY_FILE_PATH, WebDriverExecutionProperties.getWebDriverName());

			// load from specified file
			properties.load(WebDriverBrowserProperties.class.getClassLoader().getResourceAsStream(propertyFileName));

			// overwrite with system properties
			properties.putAll(System.getProperties());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file '" + propertyFileName + "'", e);
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	public static String getWebDriverClassName() {
		return WebDriverBrowserProperties.get(PROPERTY_KEY_WEBDRIVER_CLASS_NAME);
	}

	public static String getWebDriverRemoteUrl() {
		return WebDriverBrowserProperties.get(PROPERTY_KEY_WEBDRIVER_REMOTE_URL);
	}

	public static Map<String, String> getWebDriverCapabilities() {
		Map<String, String> capabilities = new HashMap<String, String>();

		for (Entry<Object, Object> entry : properties.entrySet()) {
			String key = (String) entry.getKey();

			if (key.startsWith(PROPERTY_PARTIAL_KEY_WEBDRIVER_CAPABILITY)) {
				capabilities.put(key.replace(PROPERTY_PARTIAL_KEY_WEBDRIVER_CAPABILITY, ""), (String) entry.getValue());
			}
		}

		return capabilities;
	}
}

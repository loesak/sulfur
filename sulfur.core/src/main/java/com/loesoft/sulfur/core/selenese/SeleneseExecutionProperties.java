package com.loesoft.sulfur.core.selenese;

import java.io.IOException;
import java.util.Properties;

/**
 * Class for reading in Selenese specific properties
 * @author AaronLoes
 */
public class SeleneseExecutionProperties {
  private static final String BASE_PROPERTY_FILE_PATH = "com/loesoft/sulfor/core/selenese/execution-selenese.properties";

  private static final String PROPERTY_KEY_SELENESE_TIMEOUT_IN_SECONDS = "selenese.timeoutInSeconds";
  
  private static Properties properties = new Properties();
  static {
    try {
      // load from specified file
      properties.load(SeleneseExecutionProperties.class.getClassLoader().getResourceAsStream(BASE_PROPERTY_FILE_PATH));
      
      // overwrite with system properties
      properties.putAll(System.getProperties());
    } catch (IOException e) {
      throw new RuntimeException("Failed to load properties file '" + BASE_PROPERTY_FILE_PATH + "'", e);
    }
  }
  
  public static String get(String key) {
    return properties.getProperty(key);
  }
  
  public static int getTimeoutInSeconds() {
    return Integer.parseInt(SeleneseExecutionProperties.get(PROPERTY_KEY_SELENESE_TIMEOUT_IN_SECONDS));
  }
}

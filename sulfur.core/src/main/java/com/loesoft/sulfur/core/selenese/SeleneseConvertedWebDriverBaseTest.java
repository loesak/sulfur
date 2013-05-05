package com.loesoft.sulfur.core.selenese;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.loesoft.sulfur.core.properties.ExecutionProperties;
import com.loesoft.sulfur.core.webdriver.WebDriverBrowserProperties;
import com.loesoft.sulfur.core.webdriver.WebDriverFactory;

public class SeleneseConvertedWebDriverBaseTest {

  protected static WebDriver driver;
  protected static String baseUrl;

  @BeforeClass
  public static void initDriver() {
    final int waitTimeoutInSeconds = SeleneseExecutionProperties.getTimeoutInSeconds();

    // create an event firing web driver to force a pause after each pause-worthy event (e.g. after click & after navigate to)
    EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(WebDriverFactory.getDriver(WebDriverBrowserProperties.getWebDriverClassName()));
    eventFiringWebDriver.register(new WebDriverEventListener() {

      @Override
      public void onException(Throwable throwable, WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeScript(String script, WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeNavigateTo(String url, WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeNavigateForward(WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeNavigateBack(WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeFindBy(By by, WebElement element, WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void beforeClickOn(WebElement element, WebDriver driver1) {
    	  // help webdriver find the element before clicking
    	  // this sometimes alleviates the issue of webdriver clicking on something but not firing the click event
    	  element.getLocation();
	  }
      @Override
      public void beforeChangeValueOf(WebElement element, WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void afterScript(String script, WebDriver driver1) { /* intentionally left blank */ }

      @Override
      public void afterNavigateTo(String url, WebDriver driver1) {
        try {
            Thread.sleep(waitTimeoutInSeconds);
          } catch (InterruptedException e) {
            // intentionally left blank
          }
      }

      @Override
      public void afterNavigateForward(WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void afterNavigateBack(WebDriver driver1) { /* intentionally left blank */ }
      @Override
      public void afterFindBy(By by, WebElement element, WebDriver driver1) { /* intentionally left blank */ }

      @Override
      public void afterClickOn(WebElement element, WebDriver driver1) {
        try {
            Thread.sleep(waitTimeoutInSeconds);
          } catch (InterruptedException e) {
            // intentionally left blank
          }
      }

      @Override
      public void afterChangeValueOf(WebElement element, WebDriver driver1) { /* intentionally left blank */ }
    });

    SeleneseConvertedWebDriverBaseTest.driver = eventFiringWebDriver;

    // KLUGE: maximize window to get around bad styling
    driver.manage().window().maximize();

    // set base URL for selenese converted web driver based tests
    SeleneseConvertedWebDriverBaseTest.baseUrl = ExecutionProperties.getApplicationBaseUrl();
  }

  @AfterClass
  public static void destroyDriver() {
    SeleneseConvertedWebDriverBaseTest.driver.quit();
    SeleneseConvertedWebDriverBaseTest.driver = null;
  }
}

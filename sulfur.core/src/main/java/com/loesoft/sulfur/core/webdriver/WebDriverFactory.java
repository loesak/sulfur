package com.loesoft.sulfur.core.webdriver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Factory class for creating a WebDriver instance based on a specific WebDriver
 * class
 * 
 * @author Aaron Loes
 */
public class WebDriverFactory {

	private WebDriverFactory() {
		// factory class
	}

	/**
	 * retrieves an instance of a WebDriver for the given class name
	 * 
	 * @param driverClassName
	 * @return
	 */
	public static WebDriver getDriver(String driverClassName) {
		WebDriver driver = null;

		try {
			if (driverClassName.equals(HtmlUnitDriver.class.getName())) {
				driver = new HtmlUnitDriver(WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(InternetExplorerDriver.class.getName())) {
				driver = new InternetExplorerDriver(WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(FirefoxDriver.class.getName())) {
				driver = new FirefoxDriver(WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(ChromeDriver.class.getName())) {
				// ChromeDriver uses something else but this still works for now
				driver = new ChromeDriver(WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(IPhoneDriver.class.getName())) {
				// IPhoneDriver ignores capabilities sent to it
				driver = new IPhoneDriver(new URL(WebDriverBrowserProperties.getWebDriverRemoteUrl()));
			} else if (driverClassName.equals(AndroidDriver.class.getName())) {
				driver = new AndroidDriver(new URL(WebDriverBrowserProperties.getWebDriverRemoteUrl()), WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(RemoteWebDriver.class.getName())) {
				driver = new RemoteWebDriver(new URL(WebDriverBrowserProperties.getWebDriverRemoteUrl()), WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else if (driverClassName.equals(PhantomJSDriver.class.getName())) {
				driver = new PhantomJSDriver(WebDriverFactory.getDriverDesiredCapabilities(driverClassName));
			} else {
				throw new IllegalArgumentException("Unsupported WebDriver class name '" + driverClassName + "'");
			}
		} catch (Exception e) {
			throw new IllegalStateException("Failed to load driver '" + driverClassName + "'", e);
		}

		return driver;
	}

	private static DesiredCapabilities getDriverDesiredCapabilities(String driverClassName) {
		DesiredCapabilities desiredCapabilities = null;

		// get driver base capabilities
		if (driverClassName.equals(InternetExplorerDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.internetExplorer();
		} else if (driverClassName.equals(FirefoxDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.firefox();
		} else if (driverClassName.equals(ChromeDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.chrome();
		} else if (driverClassName.equals(IPhoneDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.iphone();
		} else if (driverClassName.equals(AndroidDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.android();
		} else if (driverClassName.equals(HtmlUnitDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.htmlUnit();
		} else if (driverClassName.equals(PhantomJSDriver.class.getName())) {
			desiredCapabilities = DesiredCapabilities.phantomjs();
		} else {
			desiredCapabilities = new DesiredCapabilities();
		}

		// overwrite with property specified capabilities
		desiredCapabilities.merge(new DesiredCapabilities(WebDriverBrowserProperties.getWebDriverCapabilities()));

		return desiredCapabilities;
	}
}

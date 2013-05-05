package com.loesoft.sulfur.core.webdriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fico.tests.web.webdriver.webobject.WebObjectInitializer;
import com.fico.tests.web.webdriver.webobject.bootstrap.BootstrapDatePickerObject;
import com.fico.tests.web.webdriver.webobject.bootstrap.BootstrapDatePickerObjectInitializer;
import com.fico.tests.web.webdriver.webobject.bootstrap.CalendarObject;
import com.fico.tests.web.webdriver.webobject.bootstrap.CalendarObjectInitializer;
import com.fico.tests.web.webdriver.webobject.bootstrap.DropdownButtonObject;
import com.fico.tests.web.webdriver.webobject.bootstrap.DropdownButtonObjectInitializer;
import com.fico.tests.web.webdriver.webobject.bootstrap.TabbedNavObject;
import com.fico.tests.web.webdriver.webobject.bootstrap.TabbedNavObjectInitializer;
import com.fico.tests.web.webdriver.webobject.core.PageObject;
import com.fico.tests.web.webdriver.webobject.core.PageObjectInitializer;
import com.fico.tests.web.webdriver.webobject.html.TableObject;
import com.fico.tests.web.webdriver.webobject.html.TableObjectInitializer;
import com.fico.tests.web.webdriver.webobject.jquery.DatePickerObject;
import com.fico.tests.web.webdriver.webobject.jquery.DatePickerObjectInitializer;

/**
 * base class for all WebDriver based PageObjects
 * 
 * all PageObjects share the same lifecycle. When a page object is initialized,
 * the following methods are called in order:
 * 
 * preInit() <- by default does nothing but can be overridden by individual page
 * objects. init() <- initializes the page object (initializes class member
 * variables marked with
 * 
 * @FindBy, @PageObject, @TableObject, @TaskNav, etc.). postInit() <- by default
 *          does nothing but can be overridden by individual page objects.
 *          verify() <- by default returns true. used to verify the page object
 *          is able to represent the page it is currently on in the browser. If
 *          this returns false, an exception is thrown.
 * 
 * @author AaronLoes
 */
public class WebDriverPageObject {

	protected static WebDriver driver;

	/**
	 * called before the page object is created
	 */
	protected void preInit() {
		// intentionally left blank
	}

	/**
	 * initializes the page object's annotated web elements
	 */
	void init() {

		PageFactory.initElements(driver, this);

		try {
			
			/*
			 * TODO
			 * iterate through fields annotated and see if they are loaded
			 */
			
		} catch (Exception e) {
			throw new IllegalStateException("Failed to initialize object '" + this.getClass().getName() + "'.", e);
		}
	}

	/**
	 * called after the page object is created
	 */
	protected void postInit() {
		// intentionally left blank
	}

	/**
	 * verifies the page object at the page expected
	 * 
	 * @return true if the page is the one we expect
	 */
	protected boolean isLoaded(WebDriver driver1) {

		for (Field field : this.getClass().getDeclaredFields()) {
			// wait for class properties marked with @FindBy to be present
			if (field.isAnnotationPresent(FindBy.class)) {
				FindBy findBy = field.getAnnotation(FindBy.class);
				if (findBy != null) {
					By by = null;

					if (!StringUtils.isEmpty(findBy.className())) {
						by = By.className(findBy.className());
					} else if (!StringUtils.isEmpty(findBy.css())) {
						by = By.cssSelector(findBy.css());
					} else if (!StringUtils.isEmpty(findBy.id())) {
						by = By.id(findBy.id());
					} else if (!StringUtils.isEmpty(findBy.linkText())) {
						by = By.linkText(findBy.linkText());
					} else if (!StringUtils.isEmpty(findBy.name())) {
						by = By.name(findBy.name());
					} else if (!StringUtils.isEmpty(findBy.partialLinkText())) {
						by = By.partialLinkText(findBy.partialLinkText());
					} else if (!StringUtils.isEmpty(findBy.tagName())) {
						by = By.tagName(findBy.tagName());
					} else if (!StringUtils.isEmpty(findBy.xpath())) {
						by = By.xpath(findBy.xpath());
					} else {
						throw new RuntimeException("Invalid arguments given for FindBy for field '" + field.getName() + "' in class '" + this.getClass().getName() + "'");
					}

					(new WebDriverWait(driver1, WebDriverExecutionProperties.getPageLoadTimeout())).until(ExpectedConditions.visibilityOfElementLocated(by));
				}
			} else {
				for (Annotation annotation : field.getAnnotations()) {
					// TODO iterate through annotations ... looking up
				}
			}
		}

		return true;
	}

	/**
	 * attempt to cast this page object to the specified class
	 * 
	 * @param clazz
	 * @return
	 */
	public <T extends WebDriverPageObject> T expect(Class<T> clazz) {
		return (T) this;
	}

	/**
	 * sets the WebDriver to use for all page objects
	 * 
	 * @param driver the WebDriver to use
	 */
	public static void setWebDriver(WebDriver driver) {
		WebDriverPageObject.driver = driver;
	}

	/**
	 * gets the page object and runs through its initialization life cycle
	 * 
	 * isPageObjectLoaded() <- by default returns true. used to verify the 
	 * page object is able to represent the page it is currently on in the 
	 * browser. If this returns false, an exception is thrown. 
	 * 
	 * preInit() <- by default does nothing but can be overridden by individual 
	 * page objects. 
	 * 
	 * init() <- initializes the page object (initializes class member variables 
	 * marked with @FindBy, @PageObject, @TableObject, @TaskNav, etc.). 
	 * 
	 * postInit() <- by default does nothing but can be overridden by individual 
	 * page objects.
	 * 
	 * @param clazz the class to initialize
	 * @return the page object representing the current web page
	 */
	public static <T extends WebDriverPageObject> T get(Class<T> clazz) {
		T page = null;

		try {
			page = clazz.newInstance();

			if (page.isLoaded(driver)) {
				page.preInit();
				page.init();
				page.postInit();
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to load page object of type '" + clazz.getName() + "'", e);
		}

		return page;
	}
}

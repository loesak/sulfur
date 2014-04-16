package com.loesoft.sulfur.core.webdriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.ElementAnnotation;

/**
 * base class for all WebDriver based PageObjects
 * 
 * @author Aaron Loes
 */
public abstract class WebDriverPageObject {
	
	private static final Log LOGGER = LogFactory.getLog(WebDriverPageObject.class);
	
	protected static WebDriver driver;

	/**
	 * loads the page object's annotated web elements
	 */
	protected void load() {
		LOGGER.debug("Attempting to load page object [" + this.getClass().getName() + "]");
		
		// load FindBy elements
		PageFactory.initElements(driver, this);

		// load Annotated elements
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				for (Annotation annotation : field.getAnnotations()) {
					if (annotation.annotationType().isAnnotationPresent(ElementAnnotation.class)) {
						LOGGER.debug("Attempting to initialize page object element [" + field.getName() + "] for page object [" + this.getClass().getName() + "]");
						
						try {
							@SuppressWarnings("unchecked")
							Class<? extends Element> fieldTypeClass = (Class<? extends Element>) field.getType();
							AnnotatableElement instance = (AnnotatableElement) fieldTypeClass.newInstance();
							instance.initialize(driver, annotation);
							field.set(this, instance);
						} catch (Exception e) {
							throw new IllegalStateException("Failed to initialize element '" + field.getName() + "' of type '" + field.getType().getName() + "'", e);
						}
					}
				}
			}
			
			// wait for all elements to load
			this.waitForElementsToLoad();
		} catch (Exception e) {
			throw new IllegalStateException("Failed to initialize object '" + this.getClass().getName() + "'.", e);
		}
	}

	/**
	 * waits for individual custom elements to be loaded as defined by them
	 * 
	 * @return true if the page is the one we expect
	 */
	private void waitForElementsToLoad() {
		for (Field field : this.getClass().getDeclaredFields()) {
			for (Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().isAnnotationPresent(ElementAnnotation.class)) {
					this.waitForElementAnnotatedFieldToBeLoaded(field, annotation);
					break;
				}
			}
		}
	}
	
	/**
	 * waits for each element to be visible
	 */
	private void waitForVisibilityOfElements() throws Exception {
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(FindBy.class)) {
				this.waitForFindByAnnotatedFieldVisibility(field, field.getAnnotation(FindBy.class));
			} else {
				/*
				 * FIXME: this should really fail if there are more than one element annotations
				 */
				for (Annotation annotation : field.getAnnotations()) {
					if (annotation.annotationType().isAnnotationPresent(ElementAnnotation.class)) {
						this.waitForElementAnnotatedFieldToBeVisibility(field, annotation);
						continue;
					}
				}
			}
		}
	}
	
	/**
	 * waits for field annotated with @FindBy to be visible
	 * 
	 * @param field
	 * @param findBy
	 */
	private void waitForFindByAnnotatedFieldVisibility(Field field, FindBy findBy) {
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
				throw new IllegalArgumentException("Invalid arguments given for FindBy for field '" + field.getName() + "' in class '" + this.getClass().getName() + "'");
			}

			(new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout())).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	}
	
	/**
	 * waits for field annotated with custom @ElementAnnotation to be visible
	 * 
	 * @param field
	 * @param annotation
	 */
	private void waitForElementAnnotatedFieldToBeVisibility(Field field, Annotation annotation) throws Exception {
		By by = null;
		
		Class<? extends By> byClass = (Class<? extends By>) annotation.annotationType().getMethod("by").invoke(annotation);
		String using = (String) annotation.annotationType().getMethod("using").invoke(annotation);
		
		if (By.ById.class.equals(byClass)) {
			by = By.id(using);
		} else if (By.ByClassName.class.equals(byClass)) {
			by = By.className(using);
		} else if (By.ByCssSelector.class.equals(byClass)) {
			by = By.cssSelector(using);
		} else if (By.ByLinkText.class.equals(byClass)) {
			by = By.linkText(using);
		} else if (By.ByName.class.equals(byClass)) {
			by = By.name(using);
		} else if (By.ByPartialLinkText.class.equals(byClass)) {
			by = By.partialLinkText(using);
		} else if (By.ByTagName.class.equals(byClass)) {
			by = By.tagName(using);
		} else if (By.ByXPath.class.equals(byClass)) {
			by = By.xpath(using);
		} else {
			throw new IllegalArgumentException("The [by] parameter must be a valid By class");
		}
		
		(new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout())).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	private void waitForElementAnnotatedFieldToBeLoaded(final Field field, Annotation annotation) {
		(new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout())).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					AnnotatableElement element = (AnnotatableElement) field.get(WebDriverPageObject.this);
					return element.isLoaded();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		});
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
	 * 
	 * 
	 * @param clazz the class to initialize
	 * @return the page object representing the current web page
	 */
	public static <T extends WebDriverPageObject> T get(Class<T> clazz) {
		T page = null;

		try {
			page = clazz.newInstance();
			
			page.waitForVisibilityOfElements();
			
			page.load();
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to load page object of type '" + clazz.getName() + "'.", e);
		}

		return page;
	}
}

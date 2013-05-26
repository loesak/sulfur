package com.loesoft.sulfur.core.webdriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
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
public class WebDriverPageObject {

	protected static WebDriver driver;

	/**
	 * loads the page object's annotated web elements
	 */
	void load() {
		// load FindBy elements
		PageFactory.initElements(driver, this);

		// load Annotated elements
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				for (Annotation annotation : field.getAnnotations()) {
					if (annotation.annotationType().isAnnotationPresent(ElementAnnotation.class)) {
						@SuppressWarnings("unchecked")
						Class<? extends Element> fieldTypeClass = (Class<? extends Element>) field.getType();
						AnnotatableElement instance = (AnnotatableElement) fieldTypeClass.newInstance();
						instance.initialize(driver, annotation);
						field.set(this, instance);
					}
				}
			}
			
			// wait for all elements to load
			this.waitToLoad();
		} catch (Exception e) {
			throw new IllegalStateException("Failed to initialize object '" + this.getClass().getName() + "'.", e);
		}
	}

	/**
	 * verifies the page object at the page expected
	 * 
	 * @return true if the page is the one we expect
	 */
	private void waitToLoad() {
		/*
		 * FIXME: should find a way to parallelize this method
		 */
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(FindBy.class)) {
				this.waitForFindByAnnotatedFieldToBeLoaded(field, field.getAnnotation(FindBy.class));
			} else {
				/*
				 * FIXME: this should really fail if there are more than one element annotations
				 */
				for (Annotation annotation : field.getAnnotations()) {
					if (annotation.annotationType().isAnnotationPresent(ElementAnnotation.class)) {
						this.waitForElementAnnotatedFieldToBeLoaded(field, annotation);
						continue;
					}
				}
			}
		}
	}
	
	private void waitForFindByAnnotatedFieldToBeLoaded(Field field, FindBy findBy) {
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

			(new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout())).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
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

			page.load();
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to load page object of type '" + clazz.getName() + "'.", e);
		}

		return page;
	}
}

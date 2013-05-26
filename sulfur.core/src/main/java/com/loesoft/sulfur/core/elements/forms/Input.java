package com.loesoft.sulfur.core.elements.forms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.InputElement;

public class Input extends Element implements AnnotatableElement {

	public static final String ATTRIBUTE_FORM = "form";
	public static final String ATTRIBUTE_TYPE = "type";
	public static final String ATTRIBUTE_VALUE = "value";
	public static final String ATTRIBUTE_NAME = "name";

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		InputElement inputElement = (InputElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) inputElement.by().getConstructor(String.class)).newInstance(inputElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled();
	}
	
	/*
	 * FIXME this should really return a Form object representing
	 * the form for this input.
	 */
//	public String form() {
//		return this.element.getAttribute(ATTRIBUTE_FORM);
//	}
	
	public String type() {
		return this.element.getAttribute(ATTRIBUTE_TYPE);
	}
	
	public String value() {
		return this.element.getAttribute(ATTRIBUTE_VALUE);
	}
	
	public String name() {
		return this.element.getAttribute(ATTRIBUTE_NAME);
	}
}

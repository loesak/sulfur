package com.loesoft.sulfur.core.elements.forms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.TextAreaElement;


public class TextArea extends Element implements AnnotatableElement {

	public static final String ATTRIBTE_COLS = "cols";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBTE_READONLY = "readonly";
	public static final String ATTRIBTE_ROWS = "rows";
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		TextAreaElement textAreaElement = (TextAreaElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) textAreaElement.by().getConstructor(String.class)).newInstance(textAreaElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public Integer cols() {
		return Integer.valueOf(this.element.getAttribute(ATTRIBTE_COLS));
	}
	
	public String name() {
		return this.element.getAttribute(ATTRIBUTE_NAME);
	}
	
	public Boolean readonly() {
		return Boolean.valueOf(this.element.getAttribute(ATTRIBTE_READONLY));
	}
	
	public Integer rows() {
		return Integer.valueOf(this.element.getAttribute(ATTRIBTE_ROWS));
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled();
	}
	
	public String value() {
		return this.element.getAttribute("value");
	}
	
	public void type(String text) {
		this.element.clear();
		this.element.sendKeys(text);
	}
}

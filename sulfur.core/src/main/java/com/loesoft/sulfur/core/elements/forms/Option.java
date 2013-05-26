package com.loesoft.sulfur.core.elements.forms;

import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;


public class Option extends Element {

	public static final String ATTRIBUTE_LABEL = "label";
	public static final String ATTRIBUTE_VALUE = "value";
	
	public Select select;
	public OptGroup optGroup;
	
	public Option(WebElement element) {
		this.element = element;
	}
	
	public Option(WebElement element, Select select) {
		this(element);
		this.select = select;
	}
	
	public Option(WebElement element, Select select, OptGroup optGroup) {
		this(element, select);
		this.optGroup = optGroup;
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled();
	}
	
	public String label() {
		return this.element.getAttribute(ATTRIBUTE_LABEL);
	}
	
	public Boolean selected() {
		return this.element.isSelected();
	}
	
	public String value() {
		return this.element.getAttribute(ATTRIBUTE_VALUE);
	}
	
	public Option select() {
		this.select.select(this);
		return this;
	}
}

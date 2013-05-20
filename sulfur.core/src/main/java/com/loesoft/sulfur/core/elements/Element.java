package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public abstract class Element {
	protected WebElement element;
	
	public Element(WebElement element) {
		this.element = element;
	}
	
	public static void initialize() {
		// TODO implement
	}
	
	public Boolean visible() {
		// TODO implement
		return false;
	}
}

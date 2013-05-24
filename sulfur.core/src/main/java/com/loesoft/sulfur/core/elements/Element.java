package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public abstract class Element {
	protected WebElement element;
	
	public Boolean visible() {
		return this.element.isDisplayed();
	}
	
	public Element click() {
		this.element.click();
		return this;
	}
}

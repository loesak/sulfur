package com.loesoft.sulfur.elements.bootstrap2.button;

import org.openqa.selenium.WebElement;



public class ButtonToggle extends Button {
	
	public ButtonToggle() {
		super();
	}
	
	public ButtonToggle(WebElement element) {
		super(element);
	}
	
	public Boolean on() {
		return this.element.getAttribute("class").contains("active");
	}
	
}

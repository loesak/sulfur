package com.loesoft.sulfur.core.elements.forms;

public class TextInput extends Input {
	
	public TextInput type(String text) {
		this.element.clear();
		this.element.sendKeys(text);
		return this;
	}
	
}

package com.loesoft.sulfur.core.elements.forms.input;

import com.loesoft.sulfur.core.elements.forms.Input;

public class TextInput extends Input {
	
	public static final String ATTRIBUTE_MAXLENGTH = "maxLength";
	public static final String ATTRIBUTE_READONLY = "readOnly";
	public static final String ATTRIBUTE_SIZE = "size";
	public static final String ATTRIBUTE_DEFAULTVALUE = "defaultValue";
	
	public TextInput type(String text) {
		this.element.clear();
		this.element.sendKeys(text);
		return this;
	}
	
	public Integer maxLength() {
		if (this.element.getAttribute(ATTRIBUTE_MAXLENGTH) != null) {
			return Integer.valueOf(this.element.getAttribute(ATTRIBUTE_MAXLENGTH));
		} else {
			return null;
		}
	}
	
	public Boolean readOnly() {
		return Boolean.valueOf(this.element.getAttribute(ATTRIBUTE_READONLY));
	}
	
	public Integer size() {
		return Integer.valueOf(this.element.getAttribute(ATTRIBUTE_SIZE));
	}
	
	public String defaultValue() {
		return this.element.getAttribute(ATTRIBUTE_DEFAULTVALUE);
	}
}

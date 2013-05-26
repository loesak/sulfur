package com.loesoft.sulfur.core.elements.forms.input;

import com.loesoft.sulfur.core.elements.forms.Input;

public class CheckboxInput extends Input {
	
	public static final String ATTRIBUTE_DEFAULTCHECKED = "defaultChecked";

	public Boolean checked() {
		return this.element.isSelected();
	}
	
	public Boolean defaultChecked() {
		return Boolean.valueOf(this.element.getAttribute(ATTRIBUTE_DEFAULTCHECKED));
	}
}
package com.loesoft.sulfur.core.elements.forms;

public class CheckboxInput extends Input {

	public Boolean checked() {
		return this.element.isSelected();
	}
	
}
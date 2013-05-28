package com.loesoft.sulfur.elements.bootstrap.button;

import com.loesoft.sulfur.elements.bootstrap.Button;


public class ButtonToggle extends Button {
	
	public Boolean on() {
		return this.element.getAttribute("class").contains("active");
	}
	
}

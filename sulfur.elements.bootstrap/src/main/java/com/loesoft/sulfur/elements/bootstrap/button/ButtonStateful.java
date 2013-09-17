package com.loesoft.sulfur.elements.bootstrap.button;


public class ButtonStateful extends Button {
	
	public Boolean isState(String state) {
		Boolean isState = false;
		
		if (this.element.getAttribute("data-" + state.toLowerCase() + "-text") != null) {
			isState = this.element.getAttribute("data-" + state.toLowerCase() + "-text").equals(this.element.getText());
		}
		
		return isState;
	}
	
}

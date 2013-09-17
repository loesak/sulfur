package com.loesoft.sulfur.elements.bootstrap.buttonGroup;

import org.openqa.selenium.By;

import com.loesoft.sulfur.elements.bootstrap.dropdown.Dropdown;

public class ButtonDropdown extends ButtonGroup {
	public Dropdown dropdown() {
		this.element.findElement(By.cssSelector(".dropdown-toggle")).click();
		return new Dropdown(this.element.findElement(By.cssSelector(".dropdown-menu")));
	}
}

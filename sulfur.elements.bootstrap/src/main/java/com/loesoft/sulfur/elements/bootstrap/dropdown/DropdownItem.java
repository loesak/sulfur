package com.loesoft.sulfur.elements.bootstrap.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.loesoft.sulfur.core.elements.Element;

public class DropdownItem extends Element {
	public DropdownItem(WebElement element) {
		super(element);
	}
	
	@Override
	public DropdownItem click() {
		if (!this.divider() && !this.disabled()) {
			this.element.findElement(By.cssSelector("a")).click();
		}
		
		return this;
	}
	
	public Boolean divider() {
		return this.element.getAttribute("class").contains("divider");
	}
	
	public Boolean disabled() {
		return this.element.getAttribute("class").contains("disabled");
	}
	
	public Boolean subMenu() {
		return this.element.getAttribute("class").contains("dropdown-submenu");
	}
	
	public Dropdown dropdown() {
		if (this.subMenu()) {
			// TODO this is not working
			new Actions(driver).moveToElement(this.element.findElement(By.cssSelector("a")))
							   .build()
							   .perform();
			
			return new Dropdown(this.element.findElement(By.cssSelector(".dropdown-menu")));
		}
		
		return null;
	}
}

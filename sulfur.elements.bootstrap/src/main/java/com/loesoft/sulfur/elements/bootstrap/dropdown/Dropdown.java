package com.loesoft.sulfur.elements.bootstrap.dropdown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;

public class Dropdown extends Element {

	public Dropdown(WebElement element) {
		super(element);
	}
	
	public List<DropdownItem> items() {
		List<DropdownItem> items = new ArrayList<DropdownItem>();
		
		List<WebElement> elements = this.element.findElements(By.cssSelector("li"));
		for (WebElement element : elements) {
			items.add(new DropdownItem(element));
		}
		
		return items;
	}
	
	public DropdownItem item(int index) {
		return this.items().get(index);
	}
	
	public DropdownItem item(String text) {
		for (DropdownItem item : this.items()) {
			if (item.text().equals(text)) {
				return item;
			}
		}
		
		return null;
	}

}

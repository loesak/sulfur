package com.loesoft.sulfur.core.elements.tables;

import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;


public abstract class TableCell extends Element {
	
	public TableCell(WebElement element) {
		this.element = element;
	}

}

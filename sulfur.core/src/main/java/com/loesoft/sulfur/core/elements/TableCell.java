package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public abstract class TableCell extends Element {
	private WebElement cell;

	public TableCell(WebElement cell) {
		this.cell = cell;
	}
}

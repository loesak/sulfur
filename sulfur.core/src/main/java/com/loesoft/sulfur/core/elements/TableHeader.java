package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public class TableHeader extends TableSection {

	public TableHeader(WebElement element, Class<? extends TableRow> rowClass) {
		super(element, rowClass);
	}

}

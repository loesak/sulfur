package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public class TableBody extends TableSection {

	public TableBody(WebElement section, Class<? extends TableRow> rowClass) {
		super(section, rowClass);
	}

}

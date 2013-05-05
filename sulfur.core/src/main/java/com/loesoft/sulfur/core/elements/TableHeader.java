package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

public class TableHeader extends TableSection {

	public TableHeader(WebElement section, Class<? extends TableRow> rowClass) {
		super(section, rowClass);
	}

}

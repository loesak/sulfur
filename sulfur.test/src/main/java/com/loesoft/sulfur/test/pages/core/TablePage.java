package com.loesoft.sulfur.test.pages.core;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.Button;
import com.loesoft.sulfur.core.elements.Table;
import com.loesoft.sulfur.core.elements.annotation.ButtonElement;
import com.loesoft.sulfur.core.elements.annotation.TableElement;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;

public class TablePage extends WebDriverPageObject {

	@TableElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=table]")
	public Table table;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=addRow]")
	public Button addRowButton;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=deleteRow]")
	public Button deleteRowButton;
	
	public TablePage clickAddRowButton() {
		this.addRowButton.click();
		return this;
	}
	
	public TablePage clickDeleteRowButtion() {
		this.deleteRowButton.click();
		return this;
	}
}

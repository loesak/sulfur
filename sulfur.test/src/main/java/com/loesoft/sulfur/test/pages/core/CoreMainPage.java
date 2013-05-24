package com.loesoft.sulfur.test.pages.core;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.Anchor;
import com.loesoft.sulfur.core.elements.annotation.AnchorElement;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;

public class CoreMainPage extends WebDriverPageObject {
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=table]")
	public Anchor tableLink;

	public TablePage clickOnTableLink() {
		this.tableLink.click();
		return WebDriverPageObject.get(TablePage.class);
	}
}

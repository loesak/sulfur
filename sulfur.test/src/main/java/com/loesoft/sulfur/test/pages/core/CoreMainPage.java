package com.loesoft.sulfur.test.pages.core;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.AnchorElement;
import com.loesoft.sulfur.core.elements.links.Anchor;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;

public class CoreMainPage extends WebDriverPageObject {
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=forms]")
	public Anchor formsLink;
	
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=links]")
	public Anchor linksLink;
	
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=tables]")
	public Anchor tablesLink;

	public FormsPage clickOnFormsLink() {
		this.formsLink.click();
		return WebDriverPageObject.get(FormsPage.class);
	}

	public LinksPage clickOnLinksLink() {
		this.linksLink.click();
		return WebDriverPageObject.get(LinksPage.class);
	}

	public TablesPage clickOnTablesLink() {
		this.tablesLink.click();
		return WebDriverPageObject.get(TablesPage.class);
	}
}

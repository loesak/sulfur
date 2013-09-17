package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.AnchorElement;
import com.loesoft.sulfur.core.elements.links.Anchor;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;

public class BootstrapMainPage extends WebDriverPageObject {

	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alert]")
	public Anchor alertLink;
	
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumb]")
	public Anchor breadcrumbLink;
	
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=button]")
	public Anchor buttonLink;
	
	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonGroup]")
	public Anchor buttonGroupLink;
	
	public AlertPage clickOnAlertLink() {
		this.alertLink.click();
		return WebDriverPageObject.get(AlertPage.class);
	}
	
	public BreadcrumbPage clickOnBreadcrumbLink() {
		this.breadcrumbLink.click();
		return WebDriverPageObject.get(BreadcrumbPage.class);
	}
	
	public ButtonPage clickOnButtonLink() {
		this.buttonLink.click();
		return WebDriverPageObject.get(ButtonPage.class);
	}
	
	public ButtonGroupPage clickOnButtonGroupLink() {
		this.buttonGroupLink.click();
		return WebDriverPageObject.get(ButtonGroupPage.class);
	}
}

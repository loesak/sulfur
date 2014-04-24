package com.loesoft.sulfur.test.pages;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.AnchorElement;
import com.loesoft.sulfur.core.elements.links.Anchor;
import com.loesoft.sulfur.core.properties.ExecutionProperties;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.test.pages.bootstrap2.BootstrapMainPage;
import com.loesoft.sulfur.test.pages.core.CoreMainPage;
import com.loesoft.sulfur.test.pages.jqueryui.JqueryUiMainPage;

public class TestMainPage extends WebDriverPageObject {

	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=core]")
	public Anchor coreLink;

	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=bootstrap]")
	public Anchor bootstrapLink;

	@AnchorElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=jqueryui]")
	public Anchor jqueryuiLink;

	public CoreMainPage clickOnCoreLink() {
		this.coreLink.click();
		return WebDriverPageObject.get(CoreMainPage.class);
	}

	public BootstrapMainPage clickOnBootstrapLink() {
		this.bootstrapLink.click();
		return WebDriverPageObject.get(BootstrapMainPage.class);
	}

	public JqueryUiMainPage clickOnJqueryLink() {
		this.jqueryuiLink.click();
		return WebDriverPageObject.get(JqueryUiMainPage.class);
	}

	public static TestMainPage go() {
		driver.get(ExecutionProperties.getApplicationBaseUrl() + "/sulfur.test");
		return WebDriverPageObject.get(TestMainPage.class);
	}
}

package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.Breadcrumb;
import com.loesoft.sulfur.elements.bootstrap.annotation.BreadcrumbElement;
import com.loesoft.sulfur.elements.bootstrap.annotation.ButtonElement;
import com.loesoft.sulfur.elements.bootstrap.button.Button;

public class BreadcrumbPage extends WebDriverPageObject {

	@BreadcrumbElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumb]")
	public Breadcrumb breadcrumb;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbAdd]")
	public Button breadcrumbAdd;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbDelete]")
	public Button breadcrumbDelete;
	
}

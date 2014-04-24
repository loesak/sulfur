package com.loesoft.sulfur.test.pages.bootstrap2;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.breadcrumb.Breadcrumb;
import com.loesoft.sulfur.elements.bootstrap.breadcrumb.annotation.BreadcrumbElement;
import com.loesoft.sulfur.elements.bootstrap.button.Button;
import com.loesoft.sulfur.elements.bootstrap.button.annotation.ButtonElement;

public class BreadcrumbPage extends WebDriverPageObject {

	@BreadcrumbElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumb]")
	public Breadcrumb breadcrumb;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbAdd]")
	public Button breadcrumbAdd;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbDelete]")
	public Button breadcrumbDelete;
	
}

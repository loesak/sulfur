package com.loesoft.sulfur.test.pages.bootstrap2;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.alert.Alert;
import com.loesoft.sulfur.elements.bootstrap.alert.annotation.AlertElement;
import com.loesoft.sulfur.elements.bootstrap.button.Button;
import com.loesoft.sulfur.elements.bootstrap.button.annotation.ButtonElement;

public class AlertPage extends WebDriverPageObject {

	@AlertElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertConnotation]")
	public Alert alertConnotation;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertDefault]")
	public Button alertDefault;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertError]")
	public Button alertError;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertSuccess]")
	public Button alertSuccess;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertInfo]")
	public Button alertInfo;
	
	@AlertElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertDismiss]")
	public Alert alertDismiss;
	
	@AlertElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertNoDismiss]")
	public Alert alertNoDismiss;
	
	@AlertElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertBlock]")
	public Alert alertBlock;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertBlockEnable]")
	public Button alertBlockEnable;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=alertBlockDisable]")
	public Button alertBlockDisable;
	
}

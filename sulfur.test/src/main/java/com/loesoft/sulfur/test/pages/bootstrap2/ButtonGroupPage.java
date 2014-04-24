package com.loesoft.sulfur.test.pages.bootstrap2;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.ButtonDropdown;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.ButtonGroup;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.CheckboxButtonGroup;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.RadioButtonGroup;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.annotation.ButtonGroupElement;

public class ButtonGroupPage extends WebDriverPageObject {

	@ButtonGroupElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonGroupDefault]")
	public ButtonGroup buttonGroupDefault;
	
	@ButtonGroupElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonGroupCheckbox]")
	public CheckboxButtonGroup buttonGroupCheckbox;
	
	@ButtonGroupElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonGroupRadio]")
	public RadioButtonGroup buttonGroupRadio;
	
	@ButtonGroupElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=combinedButtonDropdown]")
	public ButtonDropdown combinedButtonDropdown;
	
	@ButtonGroupElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=splitButtonDropdown]")
	public ButtonDropdown splitButtonDropdown;
	
}

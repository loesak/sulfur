package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.Button;
import com.loesoft.sulfur.elements.bootstrap.annotation.ButtonElement;

public class BootstrapMainPage extends WebDriverPageObject {

	// alert
	
	// breadcrumb
	
	// button
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasic]")
	public Button buttonBasic; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicDefault]")
	public Button buttonBasicDefault; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicPrimary]")
	public Button buttonBasicPrimary; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicInfo]")
	public Button buttonBasicInfo; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicSuccess]")
	public Button buttonBasicSuccess; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicWarning]")
	public Button buttonBasicWarning; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicDanger]")
	public Button buttonBasicDanger; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicInverse]")
	public Button buttonBasicInverse; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonBasicLink]")
	public Button buttonBasicLink; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonSize]")
	public Button buttonSize;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonSizeLarge]")
	public Button buttonSizeLarge; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonSizeDefault]")
	public Button buttonSizeDefault; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonSizeSmall]")
	public Button buttonSizeSmall; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonSizeMini]")
	public Button buttonSizeMini; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonDisabledButton]")
	public Button buttonDisabledButton; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonDisabledAnchor]")
	public Button buttonDisabledAnchor; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonDisabledInput]")
	public Button buttonDisabledInput; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonDisableButtonDisable]")
	public Button buttonDisableButtonDisable; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonDisableButtonEnable]")
	public Button buttonDisableButtonEnable; 
	
	// button dropdown
	
	// button group
	
	// carousel
	
	// collapse
	
	// dropdown
	
	// modal
	
	// nav
	
	// nav bar
	
	// pagination
	
	// progress bar
	
	// typeahead
}

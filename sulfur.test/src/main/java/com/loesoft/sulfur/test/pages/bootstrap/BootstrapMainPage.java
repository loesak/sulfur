package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.Alert;
import com.loesoft.sulfur.elements.bootstrap.Breadcrumb;
import com.loesoft.sulfur.elements.bootstrap.Button;
import com.loesoft.sulfur.elements.bootstrap.annotation.AlertElement;
import com.loesoft.sulfur.elements.bootstrap.annotation.BreadcrumbElement;
import com.loesoft.sulfur.elements.bootstrap.annotation.ButtonElement;
import com.loesoft.sulfur.elements.bootstrap.button.ButtonStateful;
import com.loesoft.sulfur.elements.bootstrap.button.ButtonToggle;

public class BootstrapMainPage extends WebDriverPageObject {

	// alert
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
	
	// breadcrumb
	
	@BreadcrumbElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumb]")
	public Breadcrumb breadcrumb;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbAdd]")
	public Button breadcrumbAdd;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=breadcrumbDelete]")
	public Button breadcrumbDelete;
	
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
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonLoadingStateButton]")
	public ButtonStateful buttonLoadingStateButton; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonLoadingStateButtonReset]")
	public Button buttonLoadingStateButtonReset; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonLoadingStateButtonComplete]")
	public Button buttonLoadingStateButtonComplete; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonLoadingStateButtonFailed]")
	public Button buttonLoadingStateButtonFailed; 
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonToggle]")
	public ButtonToggle buttonToggle;
	
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

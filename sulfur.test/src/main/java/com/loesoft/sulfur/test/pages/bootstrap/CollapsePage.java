package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.collapse.Accordion;
import com.loesoft.sulfur.elements.bootstrap.collapse.Collapse;
import com.loesoft.sulfur.elements.bootstrap.collapse.annotation.AccordionElement;
import com.loesoft.sulfur.elements.bootstrap.collapse.annotation.CollapseElement;

public class CollapsePage extends WebDriverPageObject {
	
	@AccordionElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=accordion]")
	public Accordion accordion;
	
	@CollapseElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=collapse]")
	public Collapse collapse;
	
}

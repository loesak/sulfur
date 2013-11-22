package com.loesoft.sulfur.elements.bootstrap.collapse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.basic.Basic;

public class AccordionGroupBody extends Element {

	public AccordionGroupBody(WebElement element) {
		super(element);
	}
	
	public Basic inner() {
		WebElement element = this.element.findElement(By.className("accordion-inner"));
		return new Basic(element);
	}

}

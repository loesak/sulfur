package com.loesoft.sulfur.elements.bootstrap2.collapse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.basic.Basic;

public class AccordionGroupHeading extends Element {

	public AccordionGroupHeading(WebElement element) {
		super(element);
	}
	
	public Basic toggle() {
		WebElement element = this.element.findElement(By.className("accordion-toggle"));
		return new Basic(element);
	}

}

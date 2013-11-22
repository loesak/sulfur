package com.loesoft.sulfur.elements.bootstrap.collapse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.elements.bootstrap.collapse.annotation.AccordionElement;

public class Accordion extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		AccordionElement accordionElement = (AccordionElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) accordionElement.by().getConstructor(String.class)).newInstance(accordionElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public List<AccordionGroup> accordionGroups() {
		List<AccordionGroup> accordionGroups = new ArrayList<AccordionGroup>();
		
		List<WebElement> elements = this.element.findElements(By.className("accordion-group"));
		for (WebElement element : elements) {
			accordionGroups.add(new AccordionGroup(element));
		}
		
		return accordionGroups;
	}
	
	public AccordionGroup accordionGroup(int index) {
		return this.accordionGroups().get(index);
	}

}

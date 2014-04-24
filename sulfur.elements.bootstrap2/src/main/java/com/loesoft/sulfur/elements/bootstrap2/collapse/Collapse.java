package com.loesoft.sulfur.elements.bootstrap2.collapse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.basic.Basic;
import com.loesoft.sulfur.elements.bootstrap2.collapse.annotation.CollapseElement;

public class Collapse extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		CollapseElement collapseElement = (CollapseElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) collapseElement.by().getConstructor(String.class)).newInstance(collapseElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}

	public Collapse collaspe() {
		if (!this.isCollapsed()) {
			this.toggle();
		}
		return this;
	}

	public Collapse expand() {
		if (this.isCollapsed()) {
			this.toggle();
		}
		return this;
	}

	public Collapse toggle() {
		// find associated control
		String id = this.attribute(ATTRIBUTE_ID);
		Basic trigger = new Basic(driver.findElement(By.cssSelector("*[data-target='#" + id + "']")));
		trigger.click();

		// FIXME ... should wait smarter but have no indicators to do so from DOM
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		return this;
	}

	public Boolean isCollapsed() {
		return !this.attribute(ATTRIBUTE_CLASS).contains("in");
	}

}

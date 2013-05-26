package com.loesoft.sulfur.core.elements.forms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.ButtonElement;

public class Button extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		ButtonElement buttonElement = (ButtonElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) buttonElement.by().getConstructor(String.class)).newInstance(buttonElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
}

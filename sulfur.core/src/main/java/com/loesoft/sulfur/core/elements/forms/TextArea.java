package com.loesoft.sulfur.core.elements.forms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.TextAreaElement;


public class TextArea extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		TextAreaElement textAreaElement = (TextAreaElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) textAreaElement.by().getConstructor(String.class)).newInstance(textAreaElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}

}

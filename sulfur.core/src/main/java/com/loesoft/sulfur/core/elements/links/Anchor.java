package com.loesoft.sulfur.core.elements.links;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnchorElement;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;

public class Anchor extends Element implements AnnotatableElement {
	public static final String ATTRIBUTE_HREF = "href";
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		AnchorElement anchorElement = (AnchorElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) anchorElement.by().getConstructor(String.class)).newInstance(anchorElement.using()));
	}
	
	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public String href() {
		return this.attribute(ATTRIBUTE_HREF);
	}
}

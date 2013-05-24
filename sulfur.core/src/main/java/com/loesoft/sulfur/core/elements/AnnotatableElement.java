package com.loesoft.sulfur.core.elements;

import java.lang.annotation.Annotation;

import org.openqa.selenium.WebDriver;

public interface AnnotatableElement {
	public void initialize(WebDriver driver, Annotation annotation) throws Exception;
	public Boolean isLoaded();
}

package com.loesoft.sulfur.core.elements.basic;

import java.lang.annotation.Annotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;

// FIXME I do not like the name of this class
public class Basic extends Element implements AnnotatableElement {

	public Basic(WebElement element) {
		super(element);
	}
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isLoaded() {
		// TODO Auto-generated method stub
		return null;
	}

}

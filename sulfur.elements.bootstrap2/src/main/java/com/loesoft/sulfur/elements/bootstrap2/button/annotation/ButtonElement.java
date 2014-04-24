package com.loesoft.sulfur.elements.bootstrap2.button.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.ElementAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation
public @interface ButtonElement {
	public Class<? extends By> by();
	public String using();
}

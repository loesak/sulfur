package com.loesoft.sulfur.core.elements.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.basic.Basic;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation(Basic.class)
public @interface BasicElement {
	public Class<? extends By> by();
	public String using();
}

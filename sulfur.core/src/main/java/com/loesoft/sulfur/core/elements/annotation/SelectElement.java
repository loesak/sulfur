package com.loesoft.sulfur.core.elements.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation
public @interface SelectElement {
	public Class<? extends By> by();
	public String using();
	public boolean multiple() default false;
}

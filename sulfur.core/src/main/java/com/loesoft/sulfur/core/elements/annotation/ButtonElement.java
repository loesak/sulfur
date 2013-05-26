package com.loesoft.sulfur.core.elements.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.forms.Button;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation(Button.class)
public @interface ButtonElement {
	public Class<? extends By> by();
	public String using();
}

package com.loesoft.sulfur.elements.bootstrap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.ElementAnnotation;
import com.loesoft.sulfur.core.elements.links.Anchor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation(Anchor.class)
public @interface CarouselElement {
	public Class<? extends By> by();
	public String using();
}

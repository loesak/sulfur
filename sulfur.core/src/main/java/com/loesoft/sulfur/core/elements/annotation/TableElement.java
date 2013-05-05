package com.loesoft.sulfur.core.elements.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.TableRow;

/**
 * Annotation for marking an object as a TableObject
 * 
 * @author Aaron Loes
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableElement {
	public Class<? extends By> by();

	public String using();

	public Class<? extends TableRow> headerRowClass() default TableRow.class;

	public Class<? extends TableRow> bodyRowClass() default TableRow.class;

	public Class<? extends TableRow> footerRowClass() default TableRow.class;
}
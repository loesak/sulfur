package com.loesoft.sulfur.core.elements.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.Table;
import com.loesoft.sulfur.core.elements.TableBody;
import com.loesoft.sulfur.core.elements.TableFooter;
import com.loesoft.sulfur.core.elements.TableHeader;

/**
 * Annotation for marking an object as a TableObject
 * 
 * @author Aaron Loes
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ElementAnnotation(Table.class)
public @interface TableElement {
	public Class<? extends By> by();

	public String using();

	public Class<? extends TableHeader> tableHeaderClass() default TableHeader.class;

	public Class<? extends TableBody> tableBodyClass() default TableBody.class;

	public Class<? extends TableFooter> tableFooterClass() default TableFooter.class;
}
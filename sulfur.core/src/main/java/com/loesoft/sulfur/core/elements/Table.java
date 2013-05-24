package com.loesoft.sulfur.core.elements;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loesoft.sulfur.core.elements.annotation.TableElement;

/**
 * Represents a table on a webpage providing helper methods for accessing table
 * contents. Assumes the table is using the appropriate segments for table
 * sections (e.g. thead, tbody, tfoot).
 * 
 * @author Aaron Loes
 */
public class Table extends Element implements AnnotatableElement {
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		TableElement tableElement = (TableElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) tableElement.by().getConstructor(String.class)).newInstance(tableElement.using()));
	}
	
	public Boolean isLoaded() {
		return this.visible();
	}

	public TableSection header() {
		return new TableHeader(this.element.findElement(By.tagName("thead")));
	}

	public TableSection body() {
		return new TableBody(this.element.findElement(By.tagName("tbody")));
	}

	public TableSection footer() {
		return new TableFooter(this.element.findElement(By.tagName("tfoot")));
	}
}

package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents a table on a webpage providing helper methods for accessing table
 * contents. Assumes the table is using the appropriate segments for table
 * sections (e.g. thead, tbody, tfoot).
 * 
 * @author AaronLoes
 */
public class Table extends Element {
	private WebDriver driver;
	private By by;

	private Class<? extends TableRow> headerRowClass;
	private Class<? extends TableRow> bodyRowClass;
	private Class<? extends TableRow> footerRowClass;

	protected WebElement table;

	public Table(WebDriver driver, By by, Class<? extends TableRow> headerRowClass, Class<? extends TableRow> bodyRowClass, Class<? extends TableRow> footerRowClass) {

		this.driver = driver;
		this.by = by;

		this.headerRowClass = headerRowClass;
		this.bodyRowClass = bodyRowClass;
		this.footerRowClass = footerRowClass;
	}

	public TableSection header() {
		return new TableSection(this.driver.findElement(this.by).findElement(By.tagName("thead")), this.headerRowClass);
	}

	public TableSection body() {
		return new TableSection(this.driver.findElement(this.by).findElement(By.tagName("tbody")), this.bodyRowClass);
	}

	public TableSection footer() {
		return new TableSection(this.driver.findElement(this.by).findElement(By.tagName("tfoot")), this.footerRowClass);
	}

}

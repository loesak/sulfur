package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents a table on a webpage providing helper methods for accessing table
 * contents. Assumes the table is using the appropriate segments for table
 * sections (e.g. thead, tbody, tfoot).
 * 
 * @author Aaron Loes
 */
public class Table extends Element {
	private WebElement table;

	private Class<? extends TableRow> headerRowClass;
	private Class<? extends TableRow> bodyRowClass;
	private Class<? extends TableRow> footerRowClass;

	public Table(WebElement table) {
		this(table, TableRow.class, TableRow.class, TableRow.class);
	}
	
	public Table(WebElement table, Class<? extends TableRow> headerRowClass, Class<? extends TableRow> bodyRowClass, Class<? extends TableRow> footerRowClass) {
		this.table = table;
		this.headerRowClass = headerRowClass;
		this.bodyRowClass = bodyRowClass;
		this.footerRowClass = footerRowClass;
	}

	public TableSection header() {
		return new TableHeader(this.table.findElement(By.tagName("thead")), this.headerRowClass);
	}

	public TableSection body() {
		return new TableBody(this.table.findElement(By.tagName("tbody")), this.bodyRowClass);
	}

	public TableSection footer() {
		return new TableFooter(this.table.findElement(By.tagName("tfoot")), this.footerRowClass);
	}
}

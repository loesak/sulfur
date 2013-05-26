package com.loesoft.sulfur.core.elements.tables;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;

/**
 * Represents a section of a table (e.g. thead, tbody, tfoot).
 * 
 * @author Aaron Loes
 */
public abstract class TableSection extends Element {

	public TableSection(WebElement element) {
		this.element = element;
	}

	/**
	 * retrieves all rows for the given section
	 * 
	 * @return list of TableRow objects
	 */
	public List<TableRow> rows() {
		return this.findRows(new TableRowPredicate<TableRow>() {
			@Override
			public boolean evaluate(TableRow row) {
				return true;
			}
		});
	}

	/**
	 * retrieves a row within the section at a given index
	 * 
	 * @param index
	 *            the index
	 * @return the row found
	 */
	public TableRow row(int index) {
		List<WebElement> trs = this.element.findElements(By.tagName("tr"));

		try {
			return this.createRow(trs.get(index));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * retrieves the first row within the section that matches the given
	 * predicate
	 * 
	 * @param predicate
	 *            the predicate to use for matching a row
	 * @return the first found row or null if none found
	 */
	public TableRow findRow(TableRowPredicate predicate) {
		List<WebElement> trs = this.element.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			TableRow row = this.createRow(tr);
			// TODO wrap with StaleObjectException try/catch and see if that
			// resolves table issue
			if (predicate.evaluate(row)) {
				return row;
			}
		}

		return null;
	}

	/**
	 * retrieves all rows within the section that match the given predicate
	 * 
	 * @param predicate
	 *            the predicate to use for matching a row
	 * @return the found rows or an empty list if one found
	 */
	public List<TableRow> findRows(TableRowPredicate predicate) {
		List<TableRow> rows = new ArrayList<TableRow>();

		List<WebElement> trs = this.element.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			TableRow row = this.createRow(tr);
			// TODO wrap with StaleObjectException try/catch and see if that
			// resolves table issue
			if (predicate.evaluate(row)) {
				rows.add(row);
			}
		}

		return rows;
	}

	private TableRow createRow(WebElement tr) {
		try {
			Constructor<? extends TableRow> constructor = TableRow.class.getConstructor(WebElement.class);
			return constructor.newInstance(tr);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Class used for matching finding a particular row in a given table section
	 */
	public static interface TableRowPredicate<T extends TableRow> {
		public boolean evaluate(T row);
	}
}

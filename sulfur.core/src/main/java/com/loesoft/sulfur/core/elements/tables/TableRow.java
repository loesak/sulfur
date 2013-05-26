package com.loesoft.sulfur.core.elements.tables;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;

/**
 * Represents a row within a table.
 * 
 * @author Aaron Loes
 */
public class TableRow extends Element {
	
	public TableRow(WebElement element) {
		this.element = element;
	}

	/**
	 * retrieves the cell for the row at the given index
	 * 
	 * @param index
	 * @return the cell for the row at the given index
	 */
	public TableCell cell(int index) {
		return this.cells().get(index);
	}

	/**
	 * retrieves the list of cells for the row
	 * 
	 * NOTE: this currently makes the assumption that all cells are of the same
	 * type, either TD or TH, not mixed
	 * 
	 * @return the list of cells for the row
	 */
	public List<TableCell> cells() {
		// TODO: need to modify because cells can be both 'th' and 'td'
		List<WebElement> cells = this.element.findElements(By.tagName("td"));

		if (cells.size() == 0) {
			cells = this.element.findElements(By.tagName("th"));
		}

		List<TableCell> tableCells = new ArrayList<TableCell>();
		for (WebElement cell : cells) {
			TableCell tableCell = null;
			
			if (cell.getTagName().equals("td")) {
				tableCell = new TableRowCell(cell);
			} else {
				tableCell = new TableHeaderCell(cell);
			}
			
			tableCells.add(tableCell);
		}

		return tableCells;
	}
}

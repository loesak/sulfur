package com.loesoft.sulfur.core.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents a row within a table.
 * @author AaronLoes
 */
public class TableRow {
  private WebElement row;
  private boolean headerRow;

  public TableRow(WebElement row, Boolean headerRow) {
    this.row = row;
    this.headerRow = headerRow;
  }

  /**
   * retrieves the cell for the row at the given index
   * @param index
   * @return the cell for the row at the given index
   */
  public WebElement cell(int index) {
    return this.cells().get(index);
  }

  /**
   * retrieves the list of cells for the row
   * @return the list of cells for the row
   */
  public List<WebElement> cells() {
    // TODO: need to modify because cells can be both 'th' and 'td'
    List<WebElement> cells = row.findElements(By.tagName("td"));
    if (this.headerRow) {
      cells = row.findElements(By.tagName("th"));
    }
    return cells;
  }

  /**
   * returns the web element for this row
   * @return
   */
  public WebElement originalRow() {
    return this.row;
  }
}

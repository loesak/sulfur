package com.loesoft.sulfur.test.core;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.core.TablesPage;

public class TablesWT extends WebDriverBaseTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private TablesPage page;
	
	private int headerRowCount = 1;
	private int bodyRowCount = 5;
	private int footerRowCount = 1;
	private int columCount = 5;
	
	@Before
	public void setup() {
		page = TestMainPage.go().clickOnCoreLink().clickOnTablesLink();
	}
	
	@Test
	public void verifyTableHeader() {
		for (int r = 0; r < headerRowCount; r++) {
			for (int c = 0; c < columCount; c++) {
				this.collector.checkThat(page.table.header().row(r).cell(c).text(), is("header row " + r + " cell " + c));
			}
		}
	}
	
	@Test
	public void verifyTableBody() {
		for (int r = 0; r < bodyRowCount; r++) {
			for (int c = 0; c < columCount; c++) {
				this.collector.checkThat(page.table.body().row(r).cell(c).text(), is("body row " + r + " cell " + c));
			}
		}
	}
	
	@Test
	public void verifyTableFooter() {
		for (int r = 0; r < footerRowCount; r++) {
			for (int c = 0; c < columCount; c++) {
				this.collector.checkThat(page.table.footer().row(r).cell(c).text(), is("footer row " + r + " cell " + c));
			}
		}
	}
	
	@Test
	public void verifyDynamism() {
		this.collector.checkThat(page.table.body().rows().size(), is(5));
		
		page.clickOnDeleteRowButtion()
			.clickOnDeleteRowButtion()
			.clickOnDeleteRowButtion();
		
		this.collector.checkThat(page.table.body().rows().size(), is(2));
		
		page.clickOnAddRowButton()
			.clickOnAddRowButton()
			.clickOnAddRowButton()
			.clickOnAddRowButton();
		
		this.collector.checkThat(page.table.body().rows().size(), is(6));
	}
}

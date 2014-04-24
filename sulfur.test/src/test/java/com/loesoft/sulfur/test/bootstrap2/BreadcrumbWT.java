package com.loesoft.sulfur.test.bootstrap2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap2.BreadcrumbPage;

public class BreadcrumbWT extends WebDriverBaseTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private BreadcrumbPage page;
	
	@Before
	public void setup() {
		this.page = TestMainPage.go().clickOnBootstrapLink().clickOnBreadcrumbLink();
	}
	
	@Test
	public void verifyBreadcrumb() {
		this.collector.checkThat(this.page.breadcrumb.crumbs().size(), is(1));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).text(), is("Home"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).divider(), is(nullValue()));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).active(), is(true));
		
		this.page.breadcrumbAdd.click();
		this.collector.checkThat(this.page.breadcrumb.crumbs().size(), is(2));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).text(), is("Home"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).divider(), is(not(nullValue())));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).active(), is(false));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).text(), is("crumb 1"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).divider(), is(nullValue()));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).active(), is(true));
		
		this.page.breadcrumbAdd.click();
		this.collector.checkThat(this.page.breadcrumb.crumbs().size(), is(3));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).text(), is("Home"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).divider(), is(not(nullValue())));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).active(), is(false));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).text(), is("crumb 1"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).divider(), is(not(nullValue())));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).active(), is(false));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(2).text(), is("crumb 2"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(2).divider(), is(nullValue()));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(2).active(), is(true));
		
		this.page.breadcrumbDelete.click();
		this.collector.checkThat(this.page.breadcrumb.crumbs().size(), is(2));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).text(), is("Home"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).divider(), is(not(nullValue())));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).active(), is(false));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).text(), is("crumb 1"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).divider(), is(nullValue()));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(1).active(), is(true));
		
		this.page.breadcrumbDelete.click();
		this.collector.checkThat(this.page.breadcrumb.crumbs().size(), is(1));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).text(), is("Home"));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).divider(), is(nullValue()));
		this.collector.checkThat(this.page.breadcrumb.crumbs().get(0).active(), is(true));
	}
}

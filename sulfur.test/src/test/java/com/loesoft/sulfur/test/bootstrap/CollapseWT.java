package com.loesoft.sulfur.test.bootstrap;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap.CollapsePage;

public class CollapseWT extends WebDriverBaseTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private CollapsePage page;
	
	@Before
	public void setup() {
		this.page = TestMainPage.go().clickOnBootstrapLink().clickOnCollapseLink();
	}
	
	@Test
	public void verifyAccordion() {
		this.collector.checkThat(this.page.accordion.accordionGroups().size(), is(3));
		
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(false));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
		
		this.page.accordion.accordionGroup(0).collapse();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
		
		this.page.accordion.accordionGroup(0).expand();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(false));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
		
		this.page.accordion.accordionGroup(1).expand();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(false));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
		
		this.page.accordion.accordionGroup(2).expand();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(false));
		
		this.page.accordion.accordionGroup(0).expand();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(false));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
		
		this.page.accordion.accordionGroup(0).toggle();
		this.collector.checkThat(this.page.accordion.accordionGroup(0).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(1).isCollapsed(), is(true));
		this.collector.checkThat(this.page.accordion.accordionGroup(2).isCollapsed(), is(true));
	}
	
	@Test
	public void verifyCollapse() {
		this.collector.checkThat(this.page.collapse.isCollapsed(), is(false));
		
		this.page.collapse.collaspe();
		this.collector.checkThat(this.page.collapse.isCollapsed(), is(true));
		
		this.page.collapse.expand();
		this.collector.checkThat(this.page.collapse.isCollapsed(), is(false));
		
		this.page.collapse.toggle();
		this.collector.checkThat(this.page.collapse.isCollapsed(), is(true));
		
		this.page.collapse.toggle();
		this.collector.checkThat(this.page.collapse.isCollapsed(), is(false));
	}
}

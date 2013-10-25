package com.loesoft.sulfur.test.bootstrap;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.elements.bootstrap.dropdown.Dropdown;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap.ButtonGroupPage;

public class ButtonGroupWT extends WebDriverBaseTest {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private ButtonGroupPage page;
	
	@Before
	public void setup() {
		this.page = TestMainPage.go().clickOnBootstrapLink().clickOnButtonGroupLink();
	}
	
	@Test
	public void verifyButtonGroupDefault() {
		this.collector.checkThat(this.page.buttonGroupDefault.buttons().size(), is(3));
		this.collector.checkThat(this.page.buttonGroupDefault.button(0).text(), is("Left"));
		this.collector.checkThat(this.page.buttonGroupDefault.button(1).text(), is("Middle"));
		this.collector.checkThat(this.page.buttonGroupDefault.button(2).text(), is("Right"));
	}
	
	@Test
	public void verifyButtonGroupCheckbox() {
		this.collector.checkThat(this.page.buttonGroupCheckbox.buttons().size(), is(3));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(0).text(), is("Left"));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(1).text(), is("Middle"));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(2).text(), is("Right"));
		
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(0).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(1).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(2).on(), is(false));
		
		this.page.buttonGroupCheckbox.button(0).click();
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(0).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(1).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(2).on(), is(false));
		
		this.page.buttonGroupCheckbox.button(1).click();
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(0).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(1).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(2).on(), is(false));
		
		this.page.buttonGroupCheckbox.button(2).click();
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(0).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(1).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupCheckbox.button(2).on(), is(true));
	}
	
	@Test
	public void verifyButtonGroupRadio() {
		this.collector.checkThat(this.page.buttonGroupRadio.buttons().size(), is(3));
		this.collector.checkThat(this.page.buttonGroupRadio.button(0).text(), is("Left"));
		this.collector.checkThat(this.page.buttonGroupRadio.button(1).text(), is("Middle"));
		this.collector.checkThat(this.page.buttonGroupRadio.button(2).text(), is("Right"));
		
		this.collector.checkThat(this.page.buttonGroupRadio.button(0).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(1).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(2).on(), is(false));
		
		this.page.buttonGroupRadio.button(0).click();
		this.collector.checkThat(this.page.buttonGroupRadio.button(0).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupRadio.button(1).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(2).on(), is(false));
		
		this.page.buttonGroupRadio.button(1).click();
		this.collector.checkThat(this.page.buttonGroupRadio.button(0).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(1).on(), is(true));
		this.collector.checkThat(this.page.buttonGroupRadio.button(2).on(), is(false));
		
		this.page.buttonGroupRadio.button(2).click();
		this.collector.checkThat(this.page.buttonGroupRadio.button(0).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(1).on(), is(false));
		this.collector.checkThat(this.page.buttonGroupRadio.button(2).on(), is(true));
	}
	
	@Test
	public void verifyButtonDropdown_Combined() {
		this.collector.checkThat(this.page.combinedButtonDropdown.button(0).text(), is("Combined"));
		
		Dropdown dropdown = this.page.combinedButtonDropdown.dropdown();
		this.collector.checkThat(dropdown.item(0).text(), is("Action"));
		this.collector.checkThat(dropdown.item(0).divider(), is(false));
		this.collector.checkThat(dropdown.item(0).disabled(), is(false));
		this.collector.checkThat(dropdown.item(0).subMenu(), is(false));
		
		this.collector.checkThat(dropdown.item(1).text(), is("Another action"));
		this.collector.checkThat(dropdown.item(1).divider(), is(false));
		this.collector.checkThat(dropdown.item(1).disabled(), is(true));
		this.collector.checkThat(dropdown.item(1).subMenu(), is(false));
		
		this.collector.checkThat(dropdown.item(2).text(), is("Something else here"));
		this.collector.checkThat(dropdown.item(2).divider(), is(false));
		this.collector.checkThat(dropdown.item(2).disabled(), is(false));
		this.collector.checkThat(dropdown.item(2).subMenu(), is(false));

		this.collector.checkThat(dropdown.item(3).divider(), is(true));
		this.collector.checkThat(dropdown.item(3).disabled(), is(false));
		this.collector.checkThat(dropdown.item(3).subMenu(), is(false));
		
		this.collector.checkThat(dropdown.item(4).text(), is("Separated link"));
		this.collector.checkThat(dropdown.item(4).divider(), is(false));
		this.collector.checkThat(dropdown.item(4).disabled(), is(false));
		this.collector.checkThat(dropdown.item(4).subMenu(), is(false));
		
		this.collector.checkThat(dropdown.item(5).text(), is("Submenu"));
		this.collector.checkThat(dropdown.item(5).divider(), is(false));
		this.collector.checkThat(dropdown.item(5).disabled(), is(false));
		this.collector.checkThat(dropdown.item(5).subMenu(), is(true));
		
		Dropdown subDropdown = dropdown.item(5).dropdown();
		this.collector.checkThat(subDropdown.item(0).text(), is("Submenu #1"));
		this.collector.checkThat(subDropdown.item(1).text(), is("Submenu #2"));
		this.collector.checkThat(subDropdown.item(2).text(), is("Submenu #3"));
		this.collector.checkThat(subDropdown.item(3).text(), is("Submenu #4"));
		this.collector.checkThat(subDropdown.item(4).text(), is("Submenu #5"));
	}
	
	@Test
	public void verifyButtonDropdown_Split() {
		this.collector.checkThat(this.page.splitButtonDropdown.button(0).text(), is("Split"));
		Dropdown dropdown = this.page.combinedButtonDropdown.dropdown();
	}
}

package com.loesoft.sulfur.test.core;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.core.FormsPage;

public class FormsWT extends WebDriverBaseTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private FormsPage page;
	
	@Before
	public void setup() {
		page = TestMainPage.go().clickOnCoreLink().clickOnFormsLink();
	}
	
	@Test
	public void verifyInput_Button() {
		// disabled
		collector.checkThat(this.page.buttonInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.buttonInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.buttonInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.buttonInput.value(), is("button"));
	}
	
	@Test
	public void verifyInput_Checkbox() {
		// disabled
		collector.checkThat(this.page.checkboxInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.checkboxInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.checkboxInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.checkboxInput.value(), is("checkbox"));
		
		// checked
		collector.checkThat(this.page.checkboxInput.checked(), is(false));
		this.page.checkboxInput.click();
		collector.checkThat(this.page.checkboxInput.checked(), is(true));
		this.page.checkboxInput.click();
		collector.checkThat(this.page.checkboxInput.checked(), is(false));
	}
	
	@Test
	public void verifyInput_File() {
		// TODO
	}
	
	@Test
	public void verifyInput_Image() {
		
	}
	
	@Test
	public void verifyInput_Password() {
		// disabled
		collector.checkThat(this.page.passwordInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.passwordInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.passwordInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.passwordInput.value(), is(""));
		
		// type
		this.page.passwordInput.type("password input");
		collector.checkThat(this.page.passwordInput.value(), is("password input"));
	}
	
	@Test
	public void verifyInput_Radio() {
		
	}
	
	@Test
	public void verifyInput_Reset() {
		// disabled
		collector.checkThat(this.page.resetInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.resetInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.resetInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.resetInput.value(), is("reset"));
	}
	
	@Test
	public void verifyInput_Submit() {
		// disabled
		collector.checkThat(this.page.submitInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.submitInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.submitInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.submitInput.value(), is("submit"));
	}
	
	@Test
	public void verifyInput_Text() {
		// disabled
		collector.checkThat(this.page.textInput.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.textInput.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.textInput.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.textInput.value(), is(""));
		
		// type
		this.page.textInput.type("text input");
		collector.checkThat(this.page.textInput.value(), is("text input"));
	}
	
	@Test
	public void verifyInput_TextArea() {
		
	}
	
	@Test
	public void verifyButton() {
		
	}
	
	@Test
	public void verifySelect_Single() {
		
	}
	
	@Test
	public void verifySelect_Multi() {
		
	}
}

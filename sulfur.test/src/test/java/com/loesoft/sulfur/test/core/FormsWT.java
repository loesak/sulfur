package com.loesoft.sulfur.test.core;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.elements.forms.Option;
import com.loesoft.sulfur.core.elements.forms.Select.SelectOptionPredicate;
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
		// disabled
		collector.checkThat(this.page.radioInput1.disabled(), is(false));
		collector.checkThat(this.page.radioInput2.disabled(), is(false));
		collector.checkThat(this.page.radioInput3.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.passwordInput.disabled(), is(true));
		collector.checkThat(this.page.radioInput2.disabled(), is(true));
		collector.checkThat(this.page.radioInput3.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.passwordInput.disabled(), is(false));
		collector.checkThat(this.page.radioInput2.disabled(), is(false));
		collector.checkThat(this.page.radioInput3.disabled(), is(false));
		
		// checked
		collector.checkThat(this.page.radioInput1.checked(), is(false));
		collector.checkThat(this.page.radioInput2.checked(), is(false));
		collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput1.click();
		collector.checkThat(this.page.radioInput1.checked(), is(true));
		collector.checkThat(this.page.radioInput2.checked(), is(false));
		collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput2.click();
		collector.checkThat(this.page.radioInput1.checked(), is(false));
		collector.checkThat(this.page.radioInput2.checked(), is(true));
		collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput3.click();
		collector.checkThat(this.page.radioInput1.checked(), is(false));
		collector.checkThat(this.page.radioInput2.checked(), is(false));
		collector.checkThat(this.page.radioInput3.checked(), is(true));
		this.page.radioInput1.click();
		collector.checkThat(this.page.radioInput1.checked(), is(true));
		collector.checkThat(this.page.radioInput2.checked(), is(false));
		collector.checkThat(this.page.radioInput3.checked(), is(false));
		
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
		// disabled
		collector.checkThat(this.page.textarea.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.textarea.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.textarea.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.textarea.value(), is(""));
		
		// type
		this.page.textarea.type("textarea");
		collector.checkThat(this.page.textarea.value(), is("textarea"));
		
		// cols
		collector.checkThat(this.page.textarea.cols(), is(20));
		
		// name
		collector.checkThat(this.page.textarea.name(), is("textarea"));
		
		// rows
		collector.checkThat(this.page.textarea.rows(), is(2));
	}
	
	@Test
	public void verifyButton() {
		// disabled
		collector.checkThat(this.page.button.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.button.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.button.disabled(), is(false));
		
		// value
		collector.checkThat(this.page.button.value(), is("button"));
		
		// type
		collector.checkThat(this.page.button.type(), is("submit"));
		
		// name
		collector.checkThat(this.page.button.name(), is("button"));
	}
	
	@Test
	public void verifySelect_Single() {
		// disabled
		collector.checkThat(this.page.singleSelect.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.singleSelect.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.singleSelect.disabled(), is(false));
		
		// name
		collector.checkThat(this.page.singleSelect.name(), is("single-select"));
		
		// multiple
		collector.checkThat(this.page.singleSelect.multiple(), is(false));
		
		// size
		collector.checkThat(this.page.singleSelect.size(), is(0)); // should be 1 according to w3schools
		
		// opt group
		collector.checkThat(this.page.singleSelect.optGroups().size(), is(3));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).label(), is("optgroup 1"));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).options().size(), is(4));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(0).label(), is("option 11"));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(1).label(), is("option 12"));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(2).label(), is("option 13"));
		collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(3).label(), is("option 14"));
		
		collector.checkThat(this.page.singleSelect.optGroups().get(1).label(), is("optgroup 2"));
		collector.checkThat(this.page.singleSelect.optGroups().get(1).options().size(), is(3));
		collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(0).label(), is("option 21"));
		collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(1).label(), is("option 22"));
		collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(2).label(), is("option 23"));

		collector.checkThat(this.page.singleSelect.optGroups().get(2).label(), is("optgroup 3"));
		collector.checkThat(this.page.singleSelect.optGroups().get(2).options().size(), is(2));
		collector.checkThat(this.page.singleSelect.optGroups().get(2).options().get(0).label(), is("option 31"));
		collector.checkThat(this.page.singleSelect.optGroups().get(2).options().get(1).label(), is("option 32"));
		
		// options
		collector.checkThat(this.page.singleSelect.options().size(), is(9));
		collector.checkThat(this.page.singleSelect.options().get(0).label(), is("option 11"));
		collector.checkThat(this.page.singleSelect.options().get(1).label(), is("option 12"));
		collector.checkThat(this.page.singleSelect.options().get(2).label(), is("option 13"));
		collector.checkThat(this.page.singleSelect.options().get(3).label(), is("option 14"));
		collector.checkThat(this.page.singleSelect.options().get(4).label(), is("option 21"));
		collector.checkThat(this.page.singleSelect.options().get(5).label(), is("option 22"));
		collector.checkThat(this.page.singleSelect.options().get(6).label(), is("option 23"));
		collector.checkThat(this.page.singleSelect.options().get(7).label(), is("option 31"));
		collector.checkThat(this.page.singleSelect.options().get(8).label(), is("option 32"));
		
		// select
		collector.checkThat(this.page.singleSelect.selectedOptions().size(), is(1));
		collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 11"));
		this.page.singleSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 22");
			}
		}).select();
		collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 22"));
		this.page.singleSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 31");
			}
		}).select();
		collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 31"));
	}
	
	@Test
	public void verifySelect_Multi() {
		// disabled
		collector.checkThat(this.page.multiSelect.disabled(), is(false));
		this.page.disableButton.click();
		collector.checkThat(this.page.multiSelect.disabled(), is(true));
		this.page.enableButton.click();
		collector.checkThat(this.page.multiSelect.disabled(), is(false));
		
		// name
		collector.checkThat(this.page.multiSelect.name(), is("multi-select"));
		
		// multiple
		collector.checkThat(this.page.multiSelect.multiple(), is(true));
		
		// size
		collector.checkThat(this.page.multiSelect.size(), is(0)); // should be 4 according to w3schools
		
		// opt group
		collector.checkThat(this.page.multiSelect.optGroups().size(), is(3));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).label(), is("optgroup 1"));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).options().size(), is(4));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(0).label(), is("option 11"));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(1).label(), is("option 12"));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(2).label(), is("option 13"));
		collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(3).label(), is("option 14"));
		
		collector.checkThat(this.page.multiSelect.optGroups().get(1).label(), is("optgroup 2"));
		collector.checkThat(this.page.multiSelect.optGroups().get(1).options().size(), is(3));
		collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(0).label(), is("option 21"));
		collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(1).label(), is("option 22"));
		collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(2).label(), is("option 23"));

		collector.checkThat(this.page.multiSelect.optGroups().get(2).label(), is("optgroup 3"));
		collector.checkThat(this.page.multiSelect.optGroups().get(2).options().size(), is(2));
		collector.checkThat(this.page.multiSelect.optGroups().get(2).options().get(0).label(), is("option 31"));
		collector.checkThat(this.page.multiSelect.optGroups().get(2).options().get(1).label(), is("option 32"));
		
		// options
		collector.checkThat(this.page.multiSelect.options().size(), is(9));
		collector.checkThat(this.page.multiSelect.options().get(0).label(), is("option 11"));
		collector.checkThat(this.page.multiSelect.options().get(1).label(), is("option 12"));
		collector.checkThat(this.page.multiSelect.options().get(2).label(), is("option 13"));
		collector.checkThat(this.page.multiSelect.options().get(3).label(), is("option 14"));
		collector.checkThat(this.page.multiSelect.options().get(4).label(), is("option 21"));
		collector.checkThat(this.page.multiSelect.options().get(5).label(), is("option 22"));
		collector.checkThat(this.page.multiSelect.options().get(6).label(), is("option 23"));
		collector.checkThat(this.page.multiSelect.options().get(7).label(), is("option 31"));
		collector.checkThat(this.page.multiSelect.options().get(8).label(), is("option 32"));
		
		// single select
		collector.checkThat(this.page.multiSelect.selectedOptions().size(), is(0));
		this.page.multiSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 22");
			}
		}).select();
		collector.checkThat(this.page.multiSelect.selectedOption().label(), is("option 22"));
		
		// multi select
		for (Option option : this.page.multiSelect.optGroups().get(1).options()) {
			option.select();
		}
		collector.checkThat(this.page.multiSelect.selectedOptions().size(), is(3));
		collector.checkThat(this.page.multiSelect.selectedOptions().get(0).label(), is("option 21"));
		collector.checkThat(this.page.multiSelect.selectedOptions().get(1).label(), is("option 22"));
		collector.checkThat(this.page.multiSelect.selectedOptions().get(2).label(), is("option 23"));
	}
}

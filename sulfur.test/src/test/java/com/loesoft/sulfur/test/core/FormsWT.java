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
		this.collector.checkThat(this.page.buttonInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.buttonInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.buttonInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.buttonInput.value(), is("button"));
	}
	
	@Test
	public void verifyInput_Checkbox() {
		// disabled
		this.collector.checkThat(this.page.checkboxInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.checkboxInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.checkboxInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.checkboxInput.value(), is("checkbox"));
		
		// checked
		this.collector.checkThat(this.page.checkboxInput.checked(), is(false));
		this.page.checkboxInput.click();
		this.collector.checkThat(this.page.checkboxInput.checked(), is(true));
		this.page.checkboxInput.click();
		this.collector.checkThat(this.page.checkboxInput.checked(), is(false));
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
		this.collector.checkThat(this.page.passwordInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.passwordInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.passwordInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.passwordInput.value(), is(""));
		
		// type
		this.page.passwordInput.type("password input");
		this.collector.checkThat(this.page.passwordInput.value(), is("password input"));
	}
	
	@Test
	public void verifyInput_Radio() {
		// disabled
		this.collector.checkThat(this.page.radioInput1.disabled(), is(false));
		this.collector.checkThat(this.page.radioInput2.disabled(), is(false));
		this.collector.checkThat(this.page.radioInput3.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.passwordInput.disabled(), is(true));
		this.collector.checkThat(this.page.radioInput2.disabled(), is(true));
		this.collector.checkThat(this.page.radioInput3.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.passwordInput.disabled(), is(false));
		this.collector.checkThat(this.page.radioInput2.disabled(), is(false));
		this.collector.checkThat(this.page.radioInput3.disabled(), is(false));
		
		// checked
		this.collector.checkThat(this.page.radioInput1.checked(), is(false));
		this.collector.checkThat(this.page.radioInput2.checked(), is(false));
		this.collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput1.click();
		this.collector.checkThat(this.page.radioInput1.checked(), is(true));
		this.collector.checkThat(this.page.radioInput2.checked(), is(false));
		this.collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput2.click();
		this.collector.checkThat(this.page.radioInput1.checked(), is(false));
		this.collector.checkThat(this.page.radioInput2.checked(), is(true));
		this.collector.checkThat(this.page.radioInput3.checked(), is(false));
		this.page.radioInput3.click();
		this.collector.checkThat(this.page.radioInput1.checked(), is(false));
		this.collector.checkThat(this.page.radioInput2.checked(), is(false));
		this.collector.checkThat(this.page.radioInput3.checked(), is(true));
		this.page.radioInput1.click();
		this.collector.checkThat(this.page.radioInput1.checked(), is(true));
		this.collector.checkThat(this.page.radioInput2.checked(), is(false));
		this.collector.checkThat(this.page.radioInput3.checked(), is(false));
		
	}
	
	@Test
	public void verifyInput_Reset() {
		// disabled
		this.collector.checkThat(this.page.resetInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.resetInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.resetInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.resetInput.value(), is("reset"));
	}
	
	@Test
	public void verifyInput_Submit() {
		// disabled
		this.collector.checkThat(this.page.submitInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.submitInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.submitInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.submitInput.value(), is("submit"));
	}
	
	@Test
	public void verifyInput_Text() {
		// disabled
		this.collector.checkThat(this.page.textInput.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.textInput.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.textInput.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.textInput.value(), is(""));
		
		// type
		this.page.textInput.type("text input");
		this.collector.checkThat(this.page.textInput.value(), is("text input"));
	}
	
	@Test
	public void verifyInput_TextArea() {
		// disabled
		this.collector.checkThat(this.page.textarea.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.textarea.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.textarea.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.textarea.value(), is(""));
		
		// type
		this.page.textarea.type("textarea");
		this.collector.checkThat(this.page.textarea.value(), is("textarea"));
		
		// cols
		this.collector.checkThat(this.page.textarea.cols(), is(20));
		
		// name
		this.collector.checkThat(this.page.textarea.name(), is("textarea"));
		
		// rows
		this.collector.checkThat(this.page.textarea.rows(), is(2));
	}
	
	@Test
	public void verifyButton() {
		// disabled
		this.collector.checkThat(this.page.button.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.button.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.button.disabled(), is(false));
		
		// value
		this.collector.checkThat(this.page.button.value(), is("button"));
		
		// type
		this.collector.checkThat(this.page.button.type(), is("submit"));
		
		// name
		this.collector.checkThat(this.page.button.name(), is("button"));
	}
	
	@Test
	public void verifySelect_Single() {
		// disabled
		this.collector.checkThat(this.page.singleSelect.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.singleSelect.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.singleSelect.disabled(), is(false));
		
		// name
		this.collector.checkThat(this.page.singleSelect.name(), is("single-select"));
		
		// multiple
		this.collector.checkThat(this.page.singleSelect.multiple(), is(false));
		
		// size
		this.collector.checkThat(this.page.singleSelect.size(), is(0)); // should be 1 according to w3schools
		
		// opt group
		this.collector.checkThat(this.page.singleSelect.optGroups().size(), is(3));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).label(), is("optgroup 1"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).options().size(), is(4));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(0).label(), is("option 11"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(1).label(), is("option 12"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(2).label(), is("option 13"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(0).options().get(3).label(), is("option 14"));
		
		this.collector.checkThat(this.page.singleSelect.optGroups().get(1).label(), is("optgroup 2"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(1).options().size(), is(3));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(0).label(), is("option 21"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(1).label(), is("option 22"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(1).options().get(2).label(), is("option 23"));

		this.collector.checkThat(this.page.singleSelect.optGroups().get(2).label(), is("optgroup 3"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(2).options().size(), is(2));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(2).options().get(0).label(), is("option 31"));
		this.collector.checkThat(this.page.singleSelect.optGroups().get(2).options().get(1).label(), is("option 32"));
		
		// options
		this.collector.checkThat(this.page.singleSelect.options().size(), is(9));
		this.collector.checkThat(this.page.singleSelect.options().get(0).label(), is("option 11"));
		this.collector.checkThat(this.page.singleSelect.options().get(1).label(), is("option 12"));
		this.collector.checkThat(this.page.singleSelect.options().get(2).label(), is("option 13"));
		this.collector.checkThat(this.page.singleSelect.options().get(3).label(), is("option 14"));
		this.collector.checkThat(this.page.singleSelect.options().get(4).label(), is("option 21"));
		this.collector.checkThat(this.page.singleSelect.options().get(5).label(), is("option 22"));
		this.collector.checkThat(this.page.singleSelect.options().get(6).label(), is("option 23"));
		this.collector.checkThat(this.page.singleSelect.options().get(7).label(), is("option 31"));
		this.collector.checkThat(this.page.singleSelect.options().get(8).label(), is("option 32"));
		
		// select
		this.collector.checkThat(this.page.singleSelect.selectedOptions().size(), is(1));
		this.collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 11"));
		this.page.singleSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 22");
			}
		}).select();
		this.collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 22"));
		this.page.singleSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 31");
			}
		}).select();
		this.collector.checkThat(this.page.singleSelect.selectedOption().label(), is("option 31"));
	}
	
	@Test
	public void verifySelect_Multi() {
		// disabled
		this.collector.checkThat(this.page.multiSelect.disabled(), is(false));
		this.page.disableButton.click();
		this.collector.checkThat(this.page.multiSelect.disabled(), is(true));
		this.page.enableButton.click();
		this.collector.checkThat(this.page.multiSelect.disabled(), is(false));
		
		// name
		this.collector.checkThat(this.page.multiSelect.name(), is("multi-select"));
		
		// multiple
		this.collector.checkThat(this.page.multiSelect.multiple(), is(true));
		
		// size
		this.collector.checkThat(this.page.multiSelect.size(), is(0)); // should be 4 according to w3schools
		
		// opt group
		this.collector.checkThat(this.page.multiSelect.optGroups().size(), is(3));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).label(), is("optgroup 1"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).options().size(), is(4));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(0).label(), is("option 11"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(1).label(), is("option 12"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(2).label(), is("option 13"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(0).options().get(3).label(), is("option 14"));
		
		this.collector.checkThat(this.page.multiSelect.optGroups().get(1).label(), is("optgroup 2"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(1).options().size(), is(3));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(0).label(), is("option 21"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(1).label(), is("option 22"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(1).options().get(2).label(), is("option 23"));

		this.collector.checkThat(this.page.multiSelect.optGroups().get(2).label(), is("optgroup 3"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(2).options().size(), is(2));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(2).options().get(0).label(), is("option 31"));
		this.collector.checkThat(this.page.multiSelect.optGroups().get(2).options().get(1).label(), is("option 32"));
		
		// options
		this.collector.checkThat(this.page.multiSelect.options().size(), is(9));
		this.collector.checkThat(this.page.multiSelect.options().get(0).label(), is("option 11"));
		this.collector.checkThat(this.page.multiSelect.options().get(1).label(), is("option 12"));
		this.collector.checkThat(this.page.multiSelect.options().get(2).label(), is("option 13"));
		this.collector.checkThat(this.page.multiSelect.options().get(3).label(), is("option 14"));
		this.collector.checkThat(this.page.multiSelect.options().get(4).label(), is("option 21"));
		this.collector.checkThat(this.page.multiSelect.options().get(5).label(), is("option 22"));
		this.collector.checkThat(this.page.multiSelect.options().get(6).label(), is("option 23"));
		this.collector.checkThat(this.page.multiSelect.options().get(7).label(), is("option 31"));
		this.collector.checkThat(this.page.multiSelect.options().get(8).label(), is("option 32"));
		
		// single select
		this.collector.checkThat(this.page.multiSelect.selectedOptions().size(), is(0));
		this.page.multiSelect.findOption(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return option.label().equals("option 22");
			}
		}).select();
		this.collector.checkThat(this.page.multiSelect.selectedOption().label(), is("option 22"));
		
		// multi select
		for (Option option : this.page.multiSelect.optGroups().get(1).options()) {
			option.select();
		}
		this.collector.checkThat(this.page.multiSelect.selectedOptions().size(), is(3));
		this.collector.checkThat(this.page.multiSelect.selectedOptions().get(0).label(), is("option 21"));
		this.collector.checkThat(this.page.multiSelect.selectedOptions().get(1).label(), is("option 22"));
		this.collector.checkThat(this.page.multiSelect.selectedOptions().get(2).label(), is("option 23"));
	}
}

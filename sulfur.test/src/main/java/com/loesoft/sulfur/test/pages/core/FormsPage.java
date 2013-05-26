package com.loesoft.sulfur.test.pages.core;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.elements.annotation.ButtonElement;
import com.loesoft.sulfur.core.elements.annotation.InputElement;
import com.loesoft.sulfur.core.elements.annotation.SelectElement;
import com.loesoft.sulfur.core.elements.annotation.TextAreaElement;
import com.loesoft.sulfur.core.elements.forms.Button;
import com.loesoft.sulfur.core.elements.forms.Select;
import com.loesoft.sulfur.core.elements.forms.TextArea;
import com.loesoft.sulfur.core.elements.forms.input.ButtonInput;
import com.loesoft.sulfur.core.elements.forms.input.CheckboxInput;
import com.loesoft.sulfur.core.elements.forms.input.PasswordInput;
import com.loesoft.sulfur.core.elements.forms.input.RadioInput;
import com.loesoft.sulfur.core.elements.forms.input.ResetInput;
import com.loesoft.sulfur.core.elements.forms.input.SubmitInput;
import com.loesoft.sulfur.core.elements.forms.input.TextInput;
import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;

public class FormsPage extends WebDriverPageObject {

	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=buttonInput]", type = "button")
	public ButtonInput buttonInput;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=checkboxInput]", type = "checkbox")
	public CheckboxInput checkboxInput;
	
//	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=fileInput]", type = "file")
//	public Input fileInput;
	
//	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=imageInput]", type = "image")
//	public Input imageInput;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=passwordInput]", type = "password")
	public PasswordInput passwordInput;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=radio1Input]", type = "radio")
	public RadioInput radioInput1;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=radio2Input]", type = "radio")
	public RadioInput radioInput2;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=radio3Input]", type = "radio")
	public RadioInput radioInput3;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=resetInput]", type = "reset")
	public ResetInput resetInput;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=submitInput]", type = "submit")
	public SubmitInput submitInput;
	
	@InputElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=textInput]", type = "text")
	public TextInput textInput;
	
	@TextAreaElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=textarea]")
	public TextArea textarea;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=button]")
	public Button button;
	
	@SelectElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=single-select]", multiple = false)
	public Select singleSelect;
	
	@SelectElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=multi-select]", multiple = true)
	public Select multiSelect;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=disableButton]")
	public Button disableButton;
	
	@ButtonElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=enableButton]")
	public Button enableButton;
	
	
}

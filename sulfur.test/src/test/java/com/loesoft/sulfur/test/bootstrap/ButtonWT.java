package com.loesoft.sulfur.test.bootstrap;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.elements.bootstrap.Button;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap.BootstrapMainPage;

public class ButtonWT extends WebDriverBaseTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private BootstrapMainPage page;
	
	@Before
	public void setup() {
		page = TestMainPage.go().clickOnBootstrapLink();
	}
	
	@Test
	public void verifyStyle() {
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_DEFAULT));
		
		this.page.buttonBasicPrimary.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_PRIMARY));
		
		this.page.buttonBasicInfo.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_INFO));
		
		this.page.buttonBasicSuccess.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_SUCCESS));
		
		this.page.buttonBasicWarning.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_WARNING));
		
		this.page.buttonBasicDanger.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_DANGER));
		
		this.page.buttonBasicInverse.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_INVERSE));
		
		this.page.buttonBasicLink.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_LINK));
		
		this.page.buttonBasicDefault.click();
		this.collector.checkThat(this.page.buttonBasic.style(), is(Button.BOOTSTRAP_BUTTON_STYLE_DEFAULT));
		
	}
	
	@Test
	public void verifySize() {
		this.collector.checkThat(this.page.buttonSize.size(), is(Button.BOOTSTRAP_BUTTON_SIZE_DEFAULT));
		
		this.page.buttonSizeLarge.click();
		this.collector.checkThat(this.page.buttonSize.size(), is(Button.BOOTSTRAP_BUTTON_SIZE_LARGE));
		
		this.page.buttonSizeSmall.click();
		this.collector.checkThat(this.page.buttonSize.size(), is(Button.BOOTSTRAP_BUTTON_SIZE_SMALL));
		
		this.page.buttonSizeMini.click();
		this.collector.checkThat(this.page.buttonSize.size(), is(Button.BOOTSTRAP_BUTTON_SIZE_MINI));
		
		this.page.buttonSizeDefault.click();
		this.collector.checkThat(this.page.buttonSize.size(), is(Button.BOOTSTRAP_BUTTON_SIZE_DEFAULT));
	}
	
	@Test
	public void verifyState() {
		this.collector.checkThat(this.page.buttonDisabledButton.disabled(), is(false));
		this.collector.checkThat(this.page.buttonDisabledAnchor.disabled(), is(false));
		this.collector.checkThat(this.page.buttonDisabledInput.disabled(), is(false));
		
		this.page.buttonDisableButtonDisable.click();
		this.collector.checkThat(this.page.buttonDisabledButton.disabled(), is(true));
		this.collector.checkThat(this.page.buttonDisabledAnchor.disabled(), is(true));
		this.collector.checkThat(this.page.buttonDisabledInput.disabled(), is(true));
		
		this.page.buttonDisableButtonEnable.click();
		this.collector.checkThat(this.page.buttonDisabledButton.disabled(), is(false));
		this.collector.checkThat(this.page.buttonDisabledAnchor.disabled(), is(false));
		this.collector.checkThat(this.page.buttonDisabledInput.disabled(), is(false));
	}
	
	@Test
	public void verifyLoadingState() {
		
	}
	
	@Test
	public void verifyToggle() {
		
	}
}

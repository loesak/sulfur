package com.loesoft.sulfur.test.bootstrap;

import static org.hamcrest.CoreMatchers.is;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.elements.bootstrap.alert.Alert;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap.AlertPage;

public class AlertWT extends WebDriverBaseTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private AlertPage page;
	
	@Before
	public void setup() {
		this.page = TestMainPage.go().clickOnBootstrapLink().clickOnAlertLink();
	}
	
	@Test
	public void verifyConnotation() {
		this.collector.checkThat(this.page.alertConnotation.connotation(), is(Alert.BOOTSTAP_ALERT_CONNOTATION_DEFAULT));
		
		this.page.alertError.click();
		this.collector.checkThat(this.page.alertConnotation.connotation(), is(Alert.BOOTSTAP_ALERT_CONNOTATION_ERROR));
		
		this.page.alertInfo.click();
		this.collector.checkThat(this.page.alertConnotation.connotation(), is(Alert.BOOTSTAP_ALERT_CONNOTATION_INFO));
		
		this.page.alertSuccess.click();
		this.collector.checkThat(this.page.alertConnotation.connotation(), is(Alert.BOOTSTAP_ALERT_CONNOTATION_SUCCESS));
		
		this.page.alertDefault.click();
		this.collector.checkThat(this.page.alertConnotation.connotation(), is(Alert.BOOTSTAP_ALERT_CONNOTATION_DEFAULT));
	}
	
	@Test
	public void verifyDismiss() {
		this.collector.checkThat(this.page.alertDismiss.visible(), is(true));
		this.page.alertDismiss.dismiss();
		
		try {
			this.page.alertDismiss.dismiss();
			Assert.fail("cannot call dismiss on an alert that is already dismissed");
		} catch(StaleElementReferenceException e) {}
		
		try {
			this.page.alertNoDismiss.dismiss();
			Assert.fail("cannot call dismiss on an alert that doesnt have a dismiss button");
		} catch(NoSuchElementException e) {}
	}
	
	@Test
	public void verifyBlock() {
		this.collector.checkThat(this.page.alertBlock.block(), is(false));
		
		this.page.alertBlockEnable.click();
		this.collector.checkThat(this.page.alertBlock.block(), is(true));
		
		this.page.alertBlockDisable.click();
		this.collector.checkThat(this.page.alertBlock.block(), is(false));
	}
}

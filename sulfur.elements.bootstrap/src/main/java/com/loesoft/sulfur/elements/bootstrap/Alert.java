package com.loesoft.sulfur.elements.bootstrap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.elements.bootstrap.annotation.AlertElement;

public class Alert extends Element implements AnnotatableElement {

	public static final String BOOTSTAP_ALERT_CONNOTATION_DEFAULT = "default";
	public static final String BOOTSTAP_ALERT_CONNOTATION_ERROR = "error";
	public static final String BOOTSTAP_ALERT_CONNOTATION_SUCCESS = "success";
	public static final String BOOTSTAP_ALERT_CONNOTATION_INFO = "info";
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		AlertElement AlertElement = (AlertElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) AlertElement.by().getConstructor(String.class)).newInstance(AlertElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public void dismiss() {
		this.element.findElement(new By.ByCssSelector("*[data-dismiss=alert]")).click();
	}
	
	public Boolean block() {
		return this.element.getAttribute("class").contains("alert-block");
	}
	
	public String connotation() {
		String connotation = BOOTSTAP_ALERT_CONNOTATION_DEFAULT;
		
		String btnClass = this.element.getAttribute("class");
		
		if(btnClass.contains("alert-" + BOOTSTAP_ALERT_CONNOTATION_ERROR)) {
			connotation = BOOTSTAP_ALERT_CONNOTATION_ERROR;
		} else if(btnClass.contains("alert-" + BOOTSTAP_ALERT_CONNOTATION_SUCCESS)) {
			connotation = BOOTSTAP_ALERT_CONNOTATION_SUCCESS;
		} else if(btnClass.contains("alert-" + BOOTSTAP_ALERT_CONNOTATION_INFO)) {
			connotation = BOOTSTAP_ALERT_CONNOTATION_INFO;
		}
		
		return connotation;
	}

}

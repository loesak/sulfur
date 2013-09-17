package com.loesoft.sulfur.elements.bootstrap.button;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.elements.bootstrap.annotation.ButtonElement;

public class Button extends Element implements AnnotatableElement {
	
	public static final String BOOTSTRAP_BUTTON_STYLE_DEFAULT = "default";
	public static final String BOOTSTRAP_BUTTON_STYLE_PRIMARY = "primary";
	public static final String BOOTSTRAP_BUTTON_STYLE_INFO = "info";
	public static final String BOOTSTRAP_BUTTON_STYLE_SUCCESS = "success";
	public static final String BOOTSTRAP_BUTTON_STYLE_WARNING = "warning";
	public static final String BOOTSTRAP_BUTTON_STYLE_DANGER = "danger";
	public static final String BOOTSTRAP_BUTTON_STYLE_INVERSE = "inverse";
	public static final String BOOTSTRAP_BUTTON_STYLE_LINK = "link";

	public static final String BOOTSTRAP_BUTTON_SIZE_DEFAULT = "default";
	public static final String BOOTSTRAP_BUTTON_SIZE_LARGE = "large";
	public static final String BOOTSTRAP_BUTTON_SIZE_SMALL = "small";
	public static final String BOOTSTRAP_BUTTON_SIZE_MINI = "mini";
	
	public static final String BOOTSTRAP_BUTTON_BLOCK = "block";
	
	public static final String BOOTSTRAP_BUTTON_DISABLED = "disabled";
	
	public Button() {
		super();
	}
	
	public Button(WebElement element) {
		super(element);
	}
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		ButtonElement buttonElement = (ButtonElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) buttonElement.by().getConstructor(String.class)).newInstance(buttonElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public String style() {
		String style = BOOTSTRAP_BUTTON_STYLE_DEFAULT;
		
		String btnClass = this.element.getAttribute("class");
		
		if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_PRIMARY)) {
			style = BOOTSTRAP_BUTTON_STYLE_PRIMARY;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_INFO)) {
			style = BOOTSTRAP_BUTTON_STYLE_INFO;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_SUCCESS)) {
			style = BOOTSTRAP_BUTTON_STYLE_SUCCESS;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_WARNING)) {
			style = BOOTSTRAP_BUTTON_STYLE_WARNING;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_DANGER)) {
			style = BOOTSTRAP_BUTTON_STYLE_DANGER;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_INVERSE)) {
			style = BOOTSTRAP_BUTTON_STYLE_INVERSE;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_STYLE_LINK)) {
			style = BOOTSTRAP_BUTTON_STYLE_LINK;
		}
		
		return style;
	}
	
	public String size() {
		String size = BOOTSTRAP_BUTTON_STYLE_DEFAULT;
	
		String btnClass = this.element.getAttribute("class");
		
		if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_SIZE_LARGE)) {
			size = BOOTSTRAP_BUTTON_SIZE_LARGE;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_SIZE_SMALL)) {
			size = BOOTSTRAP_BUTTON_SIZE_SMALL;
		} else if(btnClass.contains("btn-" + BOOTSTRAP_BUTTON_SIZE_MINI)) {
			size = BOOTSTRAP_BUTTON_SIZE_MINI;
		}
		
		return size;
	}
	
	public Boolean block() {
		Boolean isBlock = false;
		
		String btnClass = this.element.getAttribute("class");
		
		if (btnClass.contains("btn-" + BOOTSTRAP_BUTTON_BLOCK)) {
			isBlock = true;
		}
		
		return isBlock;
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled() || this.element.getAttribute("class").contains(BOOTSTRAP_BUTTON_DISABLED);
	}

}

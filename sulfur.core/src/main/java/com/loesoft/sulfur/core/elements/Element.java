package com.loesoft.sulfur.core.elements;

import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.forms.Option;

public abstract class Element {
	public static final String ATTRIBUTE_ACCESSKEY = "accesskey";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_CONTENTEDITABLE= "contenteditable";
	public static final String ATTRIBUTE_CONTEXTMENU = "contextmenu";
	public static final String ATTRIBUTE_DIR = "dir";
	public static final String ATTRIBUTE_DRAGGABLE = "draggable";
	public static final String ATTRIBUTE_DROPZONE = "dropzone";
	public static final String ATTRIBUTE_HIDDEN = "hidden";
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_LANG = "lang";
	public static final String ATTRIBUTE_SPELLCHECK = "spellcheck";
	public static final String ATTRIBUTE_STYLE = "style";
	public static final String ATTRIBUTE_TABINDEX = "tabindex";
	public static final String ATTRIBUTE_TITLE = "title";
	public static final String ATTRIBUTE_TRANSLATE = "translate";
	
	protected WebElement element;
	
	public Element click() {
		this.element.click();
		return this;
	}
	
	public Boolean visible() {
		return this.element.isDisplayed();
	}
	
	public String text() {
		return this.element.getText();
	}
	
	public String attribute(String name) {
		return this.element.getAttribute(name);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (other == this) {
			return true;
		}
		
		if (!(this.getClass().isInstance(other))) {
			return false;
		}
		
		Element element = (Element) other;
		return element.element.equals(this.element);
	}
}

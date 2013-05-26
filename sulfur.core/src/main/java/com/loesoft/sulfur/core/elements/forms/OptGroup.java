package com.loesoft.sulfur.core.elements.forms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.forms.Select.SelectOptionPredicate;


public class OptGroup extends Element {
	
	public static final String ATTRIBUTE_LABEL = "label";
	
	public Select select;

	public OptGroup(WebElement element) {
		this.element = element;
	}
	
	public OptGroup(WebElement element, Select select) {
		this(element);
		this.select = select;
	}
	
	public List<Option> options() {
		return this.findOptions(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return true;
			}
		});
	}
	
	public List<Option> findOptions(SelectOptionPredicate<? extends Option> predicate) {
		List<Option> options = new ArrayList<Option>();
		
		List<WebElement> elements = this.element.findElements(By.tagName("option"));
		for (WebElement element : elements) {
			Option option = new Option(element, this.select, this);
			options.add(option);
		}
		
		return options;
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled();
	}
	
	public String label() {
		return this.element.getAttribute(ATTRIBUTE_LABEL);
	}
}

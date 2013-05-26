package com.loesoft.sulfur.core.elements.forms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.annotation.SelectElement;


public class Select extends Element implements AnnotatableElement {
	
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_MULTIPLE = "multiple";
	public static final String ATTRIBUTE_SIZE = "size";
	
	private org.openqa.selenium.support.ui.Select select;
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		SelectElement element = (SelectElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) element.by().getConstructor(String.class)).newInstance(element.using()));
		
		this.select = new org.openqa.selenium.support.ui.Select(this.element);
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public Boolean disabled() {
		return !this.element.isEnabled();
	}
	
	public String name() {
		return this.element.getAttribute(ATTRIBUTE_NAME);
	}
	
	public Boolean multiple() {
		Boolean multiple = false;
		if (this.element.getAttribute(ATTRIBUTE_MULTIPLE) != null) {
			multiple = this.element.getAttribute(ATTRIBUTE_MULTIPLE).equals("multiple") 
					|| this.element.getAttribute(ATTRIBUTE_MULTIPLE).equals("true");
		}
		
		return multiple;
	}
	
	public Integer size() {
		return Integer.parseInt(this.element.getAttribute(ATTRIBUTE_SIZE));
	}
	
	public List<OptGroup> optGroups() {
		return this.findOptGroups(new SelectOptGroupPredicate<OptGroup>() {
			@Override
			public boolean evaluate(OptGroup option) {
				return true;
			}
		});
	}
	
	public List<Option> options() {
		return this.findOptions(new SelectOptionPredicate<Option>() {
			@Override
			public boolean evaluate(Option option) {
				return true;
			}
		});
	}
	
	public Select select(Option option) {
		this.select.selectByIndex(this.indexOf(option));
		return this;
	}
	
	public Select select(List<Option> options) {
		for (Option option : options) {
			this.select.selectByIndex(this.indexOf(option));
		}
		
		return this;
	}
	
	public Integer indexOf(Option option) {
		return this.options().indexOf(option);
	}
	
	public Integer indexOf(OptGroup optGroup) {
		return this.optGroups().indexOf(optGroup);
	}
	
	public Option selectedOption() {
		return new Option(this.select.getFirstSelectedOption(), this);
	}
	
	public List<Option> selectedOptions() {
		List<Option> options = new ArrayList<Option>();
		
		List<WebElement> elements = this.select.getAllSelectedOptions();
		for(WebElement element : elements) {
			options.add(new Option(element, this));
		}
		
		return options;
	}
	
	public Option findOption(SelectOptionPredicate<Option> predicate) {
		Option option = null;
		List<Option> options = this.findOptions(predicate);
		if (options.size() > 0) {
			option = options.get(0);
		}
		
		return option;
	}
	
	public List<Option> findOptions(SelectOptionPredicate<Option> predicate) {
		List<Option> options = new ArrayList<Option>();
		
		List<WebElement> elements = this.select.getOptions();
		for (WebElement element : elements) {
			Option option = new Option(element, this);
			
			if (predicate.evaluate(option)) {
				options.add(option);
			}
		}
		
		return options;
	}
	
	public OptGroup findOptGroup(SelectOptGroupPredicate<OptGroup> predicate) {
		OptGroup optGroup = null;
		List<OptGroup> optGroups = this.findOptGroups(predicate);
		if (optGroups.size() > 0) {
			optGroup = optGroups.get(0);
		}
		
		return optGroup;
	}
	
	public List<OptGroup> findOptGroups(SelectOptGroupPredicate<OptGroup> predicate) {
		List<OptGroup> optGroups = new ArrayList<OptGroup>();
		
		List<WebElement> elements = this.element.findElements(By.tagName("optgroup"));
		for (WebElement element : elements) {
			OptGroup optGroup = new OptGroup(element, this);
			
			if (predicate.evaluate(optGroup)) {
				optGroups.add(optGroup);
			}
		}
		
		return optGroups;
	}
	
	public static interface SelectOptionPredicate<T extends Option> {
		public boolean evaluate(T option);
	}
	
	public static interface SelectOptGroupPredicate<T extends OptGroup> {
		public boolean evaluate(T optGroup);
	}
}

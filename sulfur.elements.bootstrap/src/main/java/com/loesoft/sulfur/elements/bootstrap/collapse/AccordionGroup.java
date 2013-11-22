package com.loesoft.sulfur.elements.bootstrap.collapse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.webdriver.WebDriverExecutionProperties;

public class AccordionGroup extends Element {

	public AccordionGroup(WebElement element) {
		super(element);
	}
	
	public AccordionGroupHeading header() {
		WebElement element = this.element.findElement(By.className("accordion-heading"));
		return new AccordionGroupHeading(element);
	}
	
	public AccordionGroupBody body() {
		WebElement element = this.element.findElement(By.className("accordion-body"));
		return new AccordionGroupBody(element);
	}
	
	public AccordionGroup collapse() {
		if (!this.isCollapsed()) {
			this.toggle();
		}
		return this;
	}
	
	public AccordionGroup expand() {
		if (this.isCollapsed()) {
			this.toggle();
		}
		return this;
	}
	
	public AccordionGroup toggle() {
//		ExpectedCondition<Boolean> condition;
//		
//		if (this.isCollapsed()) {
//			// wait for body to have style "height: auto"
//			System.out.println("collpased");
//			condition = new ExpectedCondition<Boolean>() {
//				@Override
//				public Boolean apply(WebDriver arg0) {
//					System.out.println("waiting to expand > " + AccordionGroup.this.body().attribute(ATTRIBUTE_STYLE));
//					return AccordionGroup.this.body().attribute(ATTRIBUTE_STYLE).contains("height: auto");
//				}
//			};
//		} else {
//			// wait for body to have style "height: 0px"
//			System.out.println("expanded");
//			condition = new ExpectedCondition<Boolean>() {
//				@Override
//				public Boolean apply(WebDriver arg0) {
//					System.out.println("waiting to collpase > " + AccordionGroup.this.body().attribute(ATTRIBUTE_STYLE));
//					return AccordionGroup.this.body().attribute(ATTRIBUTE_STYLE).contains("height: 0px");
//				}
//			};
//		}
		
		this.header().toggle().click();
		
//		new WebDriverWait(driver,  WebDriverExecutionProperties.getPageLoadTimeout()).until(condition);
		
		// FIXME ... should wait smarter but have no indicators to do so from DOM
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
		return this;
	}
	
	public Boolean isCollapsed() {
		return !this.body().attribute(ATTRIBUTE_CLASS).contains("in");
	}

}

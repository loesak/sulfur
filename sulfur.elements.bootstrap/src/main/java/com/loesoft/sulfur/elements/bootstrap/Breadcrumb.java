package com.loesoft.sulfur.elements.bootstrap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.basic.Basic;
import com.loesoft.sulfur.elements.bootstrap.annotation.BreadcrumbElement;

public class Breadcrumb extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		BreadcrumbElement breadcrumbElement = (BreadcrumbElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) breadcrumbElement.by().getConstructor(String.class)).newInstance(breadcrumbElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public List<Crumb> crumbs() {
		List<Crumb> crumbs = new ArrayList<Crumb>();
		
		List<WebElement> elements = this.element.findElements(new By.ByCssSelector("li"));
		for(WebElement element : elements) {
			crumbs.add(new Crumb(element));
		}
		
		return crumbs;
	}
	
	public class Crumb extends Element {
		public Crumb(WebElement element) {
			this.element = element;
		}
		
		public Boolean active() {
			return this.element.getAttribute("class").contains("active");
		}
		
		public Basic divider() {
			Basic basic = null;
			
			try {
				basic = new Basic(this.element.findElement(new By.ByCssSelector("span.divider")));
			} catch(Exception e) {
				// expected exception if no divider is present
			}
			
			return basic;
		}
		
		public String text() {
			if (!this.active()) {
				return this.element.findElement(new By.ByCssSelector("a")).getText();
			} else {
				return super.text();
			}
		}
		
		public Element click() {
			if (this.active()) {
				this.element.findElement(new By.ByCssSelector("a")).click();
			} else {
				this.click();
			}
			
			return this;
		}
	}
}

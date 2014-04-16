package com.loesoft.sulfur.elements.bootstrap.buttonGroup;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.elements.bootstrap.button.ButtonToggle;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.annotation.ButtonGroupElement;

public class CheckboxButtonGroup extends Element implements AnnotatableElement {
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		ButtonGroupElement element = (ButtonGroupElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) element.by().getConstructor(String.class)).newInstance(element.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public List<ButtonToggle> buttons() {
		List<ButtonToggle> buttons = new ArrayList<ButtonToggle>();
		
		List<WebElement> elements = this.element.findElements(new By.ByCssSelector(".btn"));
		for (WebElement element : elements) {
			buttons.add(new ButtonToggle(element));
		}
		
		return buttons;
	}
	
	public ButtonToggle button(int index) {
		return this.buttons().get(index);
	}
}

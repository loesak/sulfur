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
import com.loesoft.sulfur.elements.bootstrap.button.Button;
import com.loesoft.sulfur.elements.bootstrap.buttonGroup.annotation.ButtonGroupElement;

/**
 * buttons-checkbox
 * buttons-radio
 * 
 * @author Aaron Loes
 *
 */
public class ButtonGroup extends Element implements AnnotatableElement {

	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		ButtonGroupElement element = (ButtonGroupElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) element.by().getConstructor(String.class)).newInstance(element.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public List<Button> buttons() {
		List<Button> buttons = new ArrayList<Button>();
		
		List<WebElement> elements = this.element.findElements(new By.ByCssSelector(".btn"));
		for (WebElement element : elements) {
			buttons.add(new Button(element));
		}
		
		return buttons;
	}
	
	public Button button(int index) {
		return this.buttons().get(index);
	}

}

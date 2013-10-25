package com.loesoft.sulfur.test.pages.bootstrap;

import org.openqa.selenium.By;

import com.loesoft.sulfur.core.webdriver.WebDriverPageObject;
import com.loesoft.sulfur.elements.bootstrap.carousel.Carousel;
import com.loesoft.sulfur.elements.bootstrap.carousel.annotation.CarouselElement;

public class CarouselPage extends WebDriverPageObject {
	
	@CarouselElement(by = By.ByCssSelector.class, using = "*[data-sulfur-hook=carousel]")
	public Carousel carousel;
}

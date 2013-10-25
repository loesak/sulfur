package com.loesoft.sulfur.elements.bootstrap.carousel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.loesoft.sulfur.core.elements.Element;
import com.loesoft.sulfur.core.elements.annotation.AnnotatableElement;
import com.loesoft.sulfur.core.elements.basic.Basic;
import com.loesoft.sulfur.core.webdriver.WebDriverExecutionProperties;
import com.loesoft.sulfur.elements.bootstrap.carousel.annotation.CarouselElement;

/*
 * TODO:
 * need a way to set the interval and pause
 * need to determine interval and pause from data attributes
 */
public class Carousel extends Element implements AnnotatableElement {
	
	public Carousel() {
		super();
	}
	
	public Carousel(WebElement element) {
		super(element);
	}
	
	@Override
	public void initialize(WebDriver driver, Annotation annotation) throws Exception {
		CarouselElement carouselElement = (CarouselElement) annotation;
		this.element = driver.findElement(((Constructor<? extends By>) carouselElement.by().getConstructor(String.class)).newInstance(carouselElement.using()));
	}

	@Override
	public Boolean isLoaded() {
		return this.visible();
	}
	
	public void previous() {
		final Integer previous = (((this.index() - 1) % this.indicators().size()) + this.indicators().size()) % this.indicators().size();

		System.out.println("current = " + this.index());
		System.out.println("previous = " + previous);
		
		this.element.findElement(By.cssSelector("*[data-slide=prev]")).click();
		
		// wait for shift
		new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout()).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				System.out.println(Carousel.this.indicators().get(previous).attribute("class"));
				return Carousel.this.indicators().get(previous).attribute("class").contains("active");
			}
		});
	}
	
	public void next() {
		final Integer next = (((this.index() + 1) % this.indicators().size()) + this.indicators().size()) % this.indicators().size();
		
		this.element.findElement(By.cssSelector("*[data-slide=next]")).click();
		
		// wait for shift
		new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout()).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				return Carousel.this.indicators().get(next).attribute("class").contains("active");
			}
		});
	}
	
	public List<Basic> indicators() {
		List<Basic> indicators = new ArrayList<Basic>();
		
		List<WebElement> elements = this.element.findElement(By.className("carousel-indicators")).findElements(By.tagName("li"));
		for (WebElement element : elements) {
			indicators.add(new Basic(element));
		}
		
		return indicators;
	}
	
	/*
	 * TODO i dont like the name of this ... name implies it should return the indicator at this position, not go to it
	 */
	public Carousel indicator(Integer i) {
		final Basic indicator = this.indicators().get(i);
		
		indicator.click();
		
		new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout()).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				return indicator.attribute("class").contains("active");
			}
		});
		
		return this;
	}
	
	public Integer index() {
		// wait for active indicator in case carousel is currently shifting content
		new WebDriverWait(driver, WebDriverExecutionProperties.getPageLoadTimeout()).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				Boolean result = false;
				
				try {
					result = Carousel.this.element.findElement(By.className("carousel-indicators")).findElement(By.className("active")) != null;
				} catch (NoSuchElementException e) {
					// do nothing
				}
				
				return result;
			}
		});
		
		return Integer.valueOf(this.element.findElement(By.className("carousel-indicators")).findElement(By.className("active")).getAttribute("data-slide-to"));
	}
	
	public Carousel pause() {
		// TODO: hover over content
		return this;
	}
	
	public Carousel resume() {
		// TODO: mouse off content
		return this;
	}
	
	public Content content() {
		return new Content(this.element.findElement(By.className("carousel-inner")).findElement(By.className("active")));
	}
	
	public <T extends Element> T content (Class<T> clazz) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<T> constructor = clazz.getConstructor(WebElement.class);
		return constructor.newInstance(this.element.findElement(By.className("carousel-inner")).findElement(By.className("active")));
	}
	
	public class Content extends Element {
		public Content() {
			super();
		}
		
		public Content(WebElement element) {
			super(element);
		}
		
		public Basic caption() {
			return new Basic(this.element.findElement(By.className("carousel-caption")));
		}
	}
}

package com.loesoft.sulfur.test.bootstrap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static com.loesoft.sulfur.core.matchers.StringMatchers.StartsWith.startsWith;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.loesoft.sulfur.core.webdriver.WebDriverBaseTest;
import com.loesoft.sulfur.test.pages.TestMainPage;
import com.loesoft.sulfur.test.pages.bootstrap.CarouselPage;

public class CarouselWT extends WebDriverBaseTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private CarouselPage page;
	
	@Before
	public void setup() {
		this.page = TestMainPage.go().clickOnBootstrapLink().clickOnCarouselLink();
	}
	
	@Test
	public void verifyIndicators() {
		this.collector.checkThat(this.page.carousel.indicators().size(), is(equalTo(3)));
		this.collector.checkThat(this.page.carousel.indicator(2).content().caption().text(), startsWith("Third Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(0).content().caption().text(), startsWith("First Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(1).content().caption().text(), startsWith("Second Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(0).content().caption().text(), startsWith("First Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(1).content().caption().text(), startsWith("Second Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(1).content().caption().text(), startsWith("Second Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(0).content().caption().text(), startsWith("First Thumbnail label"));
		this.collector.checkThat(this.page.carousel.indicator(2).content().caption().text(), startsWith("Third Thumbnail label"));
	}
	
	@Test
	public void verifyPrevious() {
		this.page.carousel.indicator(0);
		
		this.page.carousel.previous();
		this.collector.checkThat(this.page.carousel.index(), is(2));
		
		this.page.carousel.previous();
		this.collector.checkThat(this.page.carousel.index(), is(1));
		
		this.page.carousel.previous();
		this.collector.checkThat(this.page.carousel.index(), is(0));
		
		this.page.carousel.previous();
		this.collector.checkThat(this.page.carousel.index(), is(2));
	}
	
	@Test
	public void verifyNext() {
		this.page.carousel.indicator(0);
		
		this.page.carousel.next();
		this.collector.checkThat(this.page.carousel.index(), is(1));
		
		this.page.carousel.next();
		this.collector.checkThat(this.page.carousel.index(), is(2));
		
		this.page.carousel.next();
		this.collector.checkThat(this.page.carousel.index(), is(0));
		
		this.page.carousel.next();
		this.collector.checkThat(this.page.carousel.index(), is(1));
	}
	
	@Test
	public void verifyPause() {
		// wait for timeout
		// verify content has changed
		// hover over
		// wait timeout
		// verify content hasnt changed
		
	}
	
	@Test
	public void verifyResume() {
		// hover over
		// wait for timeout
		// verify content hasnt changed
		// mouse off
		// wait for timeout
		// verify content has changed
	}
	
	@Test
	public void verifyContent() {
		// get content and verify stuff
		// create custome content and get it ... verify stuff
	}
}

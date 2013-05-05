package com.loesoft.sulfur.core.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import com.loesoft.sulfur.core.elements.Element;

public class WebDriverMatchers {
	private WebDriverMatchers() {}
	
	public static class Visible extends TypeSafeMatcher<Element> {

		@Override
		public void describeTo(Description description) {
			description.appendText("is not visible");
		}

		@Override
		public boolean matchesSafely(Element element) {
			return element.visible();
		}
		
		@Factory
		public static <T> Matcher<Element> visible() {
			return new Visible();
		}
	}
}

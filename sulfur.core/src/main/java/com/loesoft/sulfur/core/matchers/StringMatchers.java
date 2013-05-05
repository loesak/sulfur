package com.loesoft.sulfur.core.matchers;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

/**
 * Class for Hamcrest style matchers for verifying strings in unit tests
 * @author AaronLoes
 */
public class StringMatchers {
  private StringMatchers() {}
  
  /**
   * Matcher to determine if a string starts with the provided string
   * Example: assertThat("Aaron Loes", startsWith("Aaron"));
   */
  public static class StartsWith extends TypeSafeMatcher<String> {

    private String argument;
    
    public StartsWith(String argument) {
      this.argument = argument;
    }
    
    @Override
    public boolean matchesSafely(String item) {
      return StringUtils.startsWith(item, this.argument);
    }
    
    @Factory
    public static <T> Matcher<String> startsWith(String argument) {
      return new StartsWith(argument);
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("does not start with '" + this.argument + "'");
    }
  }
  
  /**
   * Matcher to determine if a string contains the provided string
   * Example: assertThat("Aaron Loes", contains("on"));
   */
  public static class Contains extends TypeSafeMatcher<String> {

    private String argument;
    
    public Contains(String argument) {
      this.argument = argument;
    }
    
    @Override
    public boolean matchesSafely(String item) {
      return StringUtils.contains(item, this.argument);
    }
    
    @Factory
    public static <T> Matcher<String> contains(String argument) {
      return new Contains(argument);
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("does not contain '" + this.argument + "'");
    }
  }
  
  /**
   * Matcher to determine if a string ends with the provided string
   * Example: assertThat("Aaron Loes", endsWith("Loes"));
   */
  public static class EndsWith extends TypeSafeMatcher<String> {

    private String argument;
    
    public EndsWith(String argument) {
      this.argument = argument;
    }

    @Override
    public boolean matchesSafely(String item) {
      return StringUtils.endsWith(item, this.argument);
    }
    
    @Factory
    public static <T> Matcher<String> endsWith(String argument) {
      return new EndsWith(argument);
    }
    
    @Override
    public void describeTo(Description description) {
      description.appendText("does not end with '" + this.argument + "'");
    }
  }
}

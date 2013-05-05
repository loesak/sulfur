package com.loesoft.sulfur.core.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	private static int DEFAULT_LENGTH = 5;

	public static String string() {
		return RandomDataGenerator.string(DEFAULT_LENGTH);
	}

	public static String string(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static Integer number() {
		return RandomDataGenerator.number(DEFAULT_LENGTH);
	}

	public static Integer number(int length) {
		return null;
	}
	
	public static String name() {
		return null;
	}
}
package com.loesoft.sulfur.core.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	public static final int DEFAULT_LENGTH = 10;

	/**
	 * @return a random string of default length {@value DEFAULT_LENGTH}
	 */
	public static String string() {
		return RandomDataGenerator.string(DEFAULT_LENGTH);
	}

	/**
	 * @param length
	 * @return a random string of specified length
	 */
	public static String string(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * @return a random number of default length {@value DEFAULT_LENGTH}
	 */
	public static Integer number() {
		return RandomDataGenerator.number(DEFAULT_LENGTH);
	}
	
	/**
	 * @param length
	 * @return a random number for specified length
	 */
	public static Integer number(int length) {
		// TODO implement
		return null;
	}
	
	/**
	 * @return a random first name
	 */
	public static String firstName() {
		// TODO implement
		return null;
	}
	
	/**
	 * @return a random last name
	 */
	public static String lastName() {
		// TODO implement
		return null;
	}
	
	/**
	 * @return a random state
	 */
	public static String state() {
		// TODO implement
		return null;
	}
	
	private static final String[] FIRST_NAMES = {
			"Alicia","Tiana","Kathline","Felton","Zoe","Evita","Zoila","Sasha","Sherilyn","Crysta",
			"Ka","Gretchen","Grover","Chara","Craig","Johanna","Quyen","Sherika","Kristie","Terrance",
			"Kyra","Kristopher","Youlanda","Arlyne","Glenna","Bella","Chantay","Marya","Bridgette","Lai",
			"Lavada","Colette","Royal","Dot","Ellyn","Burt","Elna","Bebe","Peggie","Philip",
			"Omega","Rebekah","Lilliam","Elayne","Elias","Marjory","Carolann","Jacquetta","Debora","Lynn"
		};
	
	private static final String[] LAST_NAMES = {
			"Alvardo","Tillery","Kyllonen","Forgione","Zamora","Engler","Zemke","Swyers","Seger","Cicero",
			"Kupiec","Godines","Gough","Chapple","Cordoba","Jaime","Querry","Sebastian","Klopp","Taitt",
			"Krahn","Kenton","Yeager","Alber","Gentle","Backhaus","Criger","Malchow","Bellah","Leonetti",
			"Laney","Cothern","Romito","Dambrosia","Eatman","Binns","Empey","Bolles","Parmley","Pasha",
			"Ohagan","Rife","Lett","Eves","Eno","Muraoka","Clasen","Jacques","Drysdale","Liang"
		};
}
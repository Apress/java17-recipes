package org.java17recipes.chapter04.recipe04_02;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatDouble {

	public static void main(String[] args) {
		formatDouble(Double.valueOf("345.9372")); 
	}

	public static void formatDouble(double myDouble) {
		NumberFormat numberFormatter = new DecimalFormat("##.000");
		String result = numberFormatter.format(myDouble);

		System.out.println(result);

		// Obtains an instance of NumberFormat class
		NumberFormat format = NumberFormat.getInstance();

		// Format a double value for the current locale
		String result2 = format.format(83.404);
		System.out.println("Current Locale: " + result2);

		// Format a double value for an Italian locale
		result = NumberFormat.getInstance(Locale.ITALIAN).format(83.404);
		System.out.println("Italian Locale: " + result);

		// Parse a String into a Number
		try {
			Number num = format.parse("75.736");
			System.out.println("Now a number: " + num);
		} catch (java.text.ParseException ex) {
			System.out.println(ex);
		}

	}
}

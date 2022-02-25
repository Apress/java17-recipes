package org.java17recipes.chapter04.recipe04_03;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumberEx {
	public static void main (String[] args) {
		NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
		String resultNumberFormat = numberFormat.format(1000);
		System.out.println(resultNumberFormat);
	}
}

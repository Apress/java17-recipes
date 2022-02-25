package org.java17recipes.chapter04.recipe04_08;

import java.time.LocalDate;
import java.time.Month;

public class DateExamples {

	public static void main(String[] args) {
		newSpecifiedDate();

	}

	public static void newSpecifiedDate() {
		LocalDate date = LocalDate.of(2021, Month.NOVEMBER, 12);
		System.out.println("Date from specified date: " + date);
	}


}


package org.java17recipes.chapter04.recipe04_16;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateParsingExamples {

	public static void parseDateTime(){
		// Parse a string to form a Date-Time object
		LocalDate ld = LocalDate.parse("2019-12-28");
		LocalDateTime ldt = LocalDateTime.parse("2019-12-28T08:44:00");
		System.out.println("Parsed Date: " + ld);
		System.out.println("Parsed Date-Time: " + ldt);

		// Using a different Parser
		LocalDate ld2 = LocalDate.parse("2019-12-28", DateTimeFormatter.ISO_DATE);
		System.out.println("Different Parser: " + ld2);

		// Custom Parser
		String input = "12/28/2019";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate ld3 = LocalDate.parse(input, formatter);
			System.out.println("Custom Parsed Date: " + ld3);
		} catch (DateTimeParseException ex){
			System.out.println("Not parsable: " + ex);
		}

	}



	public static void main(String[] args) {
		parseDateTime();
	}
}

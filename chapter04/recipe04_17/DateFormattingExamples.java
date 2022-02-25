package org.java17recipes.chapter04.recipe04_17;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateFormattingExamples {

    public static void formatting() {
        System.out.println("----java.time Formatting ----");
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");

            LocalDateTime now = LocalDateTime.now();
            String output = now.format(dateFormatter);
            System.out.println(output);

            DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm:ss");
            String output2 = now.format(dateFormatter2);
            System.out.println(output2);

            DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("hh 'o''clock' a, zzzz");
            ZonedDateTime zdt = ZonedDateTime.now();
            String output3 = zdt.format(dateFormatter3);
            System.out.println(output3);
            
        } catch (DateTimeException ex) {
            System.out.println("Cannot be formatted: " + ex);
        }
    }

    public static void formatExamplesCalendar() {
        System.out.println("----java.util.Calendar Formatting ----");
        // Create new calendar
        Calendar cal = Calendar.getInstance();

        // Create instance of SimpleDateFormat class using pattern
        SimpleDateFormat dateFormatter1 = new SimpleDateFormat("MMMMM dd yyyy");
        String result = null;

        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);

        dateFormatter1.applyPattern("MM/dd/YY hh:mm:ss");
        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);

        dateFormatter1.applyPattern("hh 'o''clock' a, zzzz");
        result = dateFormatter1.format(cal.getTime());
        System.out.println(result);
    }

    public static void main(String[] args) {
        formatting();
        formatExamplesCalendar();
    }
}

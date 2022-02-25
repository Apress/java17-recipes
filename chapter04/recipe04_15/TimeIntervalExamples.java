package org.java17recipes.chapter04.recipe04_15;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TimeIntervalExamples {

	public static void intervals(){
		LocalDate anniversary = LocalDate.of(2015, Month.NOVEMBER, 11);
		LocalDate today = LocalDate.now();
		Period period = Period.between(anniversary, today);
		System.out.println("Number of Days Difference: " +  period.getDays());
		System.out.println("Number of Months Difference: " + period.getMonths());
		System.out.println("Number of Years Difference: " + period.getYears());

	}

	public static void compareDatesCalendar() {
		// Obtain two instances of the Calendar class
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		// Set the date to 01/01/2010:12:00
		cal2.set(2010, 0, 1, 12, 0, 0);
		Date date1 = cal2.getTime();
		System.out.println(date1);
		System.out.println(cal1.getTime());
		long mill = Math.abs(cal1.getTimeInMillis() - date1.getTime());
		// Convert to hours
		long hours = TimeUnit.MILLISECONDS.toHours(mill);
		// Convert to days
		Long days = TimeUnit.HOURS.toDays(hours);
		String diff = String.format("%d hour(s) %d min(s)", hours,
				TimeUnit.MILLISECONDS.toMinutes(mill) - TimeUnit.HOURS.toMinutes(hours));
		System.out.println(diff);

		diff = String.format("%d days", days);
		System.out.println(diff);

		// Divide the number of days by seven for the weeks
		int weeks = days.intValue() / 7;
		diff = String.format("%d weeks", weeks);
		System.out.println(diff);

	}

	public static void totalsBetween(){
		LocalDate anniversary = LocalDate.of(2015, Month.NOVEMBER, 12);
		LocalDate today = LocalDate.now();
		long yearsBetween = ChronoUnit.YEARS.between(anniversary, today);
		System.out.println("Years between dates: " + yearsBetween);

		long daysBetween = ChronoUnit.DAYS.between(anniversary, today);
		System.out.println("Days between dates:" + daysBetween);

	}



	public static void main(String[] args){
		intervals();
		compareDatesCalendar();
		totalsBetween();

	}

}

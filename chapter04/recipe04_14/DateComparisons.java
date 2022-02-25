package org.java17recipes.chapter04.recipe04_14;


import java.time.LocalDate;
import java.time.Month;

public class DateComparisons {

	public static void compareDates(LocalDate ldt1,
			LocalDate ldt2) {
		int comparison = ldt1.compareTo(ldt2);
		if (comparison > 0) {
			System.out.println(ldt1 + " is after " + ldt2);
		} else if (comparison < 0) {
			System.out.println(ldt1 + " is before " + ldt2);
		} else {
			System.out.println(ldt1 + " is equal to " + ldt2);
		}

	}

	public static void compareDates2(LocalDate ldt1, LocalDate ldt2){
		if(ldt1.isAfter(ldt2)){
			System.out.println(ldt1 + " is after " + ldt2);
		} else if (ldt1.isBefore(ldt2)){
			System.out.println(ldt1 + " is before " + ldt2);
		} else if (ldt1.isEqual(ldt2)){
			System.out.println(ldt1 + " is equal to " + ldt2);
		}
	}



	public static void main(String[] args) {
		LocalDate anniversary = LocalDate.of(2000, Month.NOVEMBER, 11);
		LocalDate today = LocalDate.now();
		compareDates(anniversary, today);
		compareDates2(anniversary, anniversary);

	}
}


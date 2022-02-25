package org.java17recipes.chapter04.recipe04_13;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;


public class TimeZoneExamples {

	public static void scheduleReport(LocalDateTime checkOut, ZoneId checkOutZone,
			LocalDateTime checkIn, ZoneId checkInZone){

		ZonedDateTime beginTrip = ZonedDateTime.of(checkOut, checkOutZone);
		System.out.println("Trip Begins: " + beginTrip);

		// Get the rules of the check out time zone
		ZoneRules checkOutZoneRules = checkOutZone.getRules();
		System.out.println("Checkout Time Zone Rules: " + checkOutZoneRules);

		//If the trip took 4 days
		ZonedDateTime beginPlus = beginTrip.plusDays(4);
		System.out.println("Four Days Later: " + beginPlus);

		// End of trip in starting time zone
		ZonedDateTime endTripOriginalZone = ZonedDateTime.of(checkIn, checkOutZone);
		ZonedDateTime endTrip = ZonedDateTime.of(checkIn, checkInZone);
		int diff = endTripOriginalZone.compareTo(endTrip);
		String diffStr = (diff >= 0) ? "NO":"YES";
		System.out.println("End trip date/time in original zone: " + endTripOriginalZone);
		System.out.println("End trip date/time in check-in zone: " + endTrip );
		System.out.println("Original Zone Time is less than new zone time? " + 
				diffStr );

		ZoneId checkOutZoneId = beginTrip.getZone();
		ZoneOffset checkOutOffset = beginTrip.getOffset();
		ZoneId checkInZoneId = endTrip.getZone();
		ZoneOffset checkInOffset = endTrip.getOffset();

		System.out.println("Check out zone and offset: " + checkOutZoneId + checkOutOffset);
		System.out.println("Check in zone and offset: " + checkInZoneId +  checkInOffset); 

	}

	public static void main(String[] args){
		LocalDateTime startRental = LocalDateTime.of(2021, Month.DECEMBER, 13, 13, 00);
		ZoneId startZone = ZoneId.of("US/Eastern");

		LocalDateTime endRental = LocalDateTime.of(2021, Month.DECEMBER, 18, 10, 00);
		ZoneId endZone = ZoneId.of("US/Mountain");
		scheduleReport(startRental, startZone, endRental, endZone);

	}
}

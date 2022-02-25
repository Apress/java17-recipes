package org.java17recipes.chapter04.recipe04_10;
 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
 
public class DateExamples {
    
    public static void main(String[] args){
        currentTime();
    }
    
    public static void currentTime(){
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);
        
        // atDate(LocalDate): obtain the local date and time
        LocalDateTime ldt = time.atDate(LocalDate.of(2021,Month.NOVEMBER,12));
        System.out.println("Local Date Time object: " + ldt);
        
        // of(int hours, int min): obtain a specific time 
        LocalTime pastTime = LocalTime.of(1, 10);
        
        // compareTo(LocalTime): compare two times.  Positive
        // return value returned if greater
        System.out.println("Comparing times: " + time.compareTo(pastTime));
        
        // getHour(): return hour in int value (24-hour format)
        int hour = time.getHour();
        int min  = time.getMinute();
        int nano = time.getNano();
        int sec  = time.getSecond();
        System.out.println("Hour: " + hour);
        
        // isAfter(LocalTime): return Boolean comparison
        System.out.println("Is local time after pastTime? " + time.isAfter(pastTime));
        
        // minusHours(int): Subtract Hours from LocalTime
        LocalTime minusHrs = time.minusHours(5);
        System.out.println("Time minus 5 hours: " + minusHrs);
        
        // plusMinutes(int): Add minutes to LocalTime
        LocalTime plusMins = time.plusMinutes(30);
        System.out.println("Time plus 30 mins: " + plusMins);
         
    }
    
}

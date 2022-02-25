package org.java17recipes.chapter03.recipe03_15;

public class StringFormatter {
    
    
    public static void main(String[] args){
        double temperature = 37.1;
        String temperatureString = "The current temperature is %.1f degrees Celsius.";

        String newString = String.format(temperatureString, temperature);
        System.out.println(newString);

        temperature = 38.4;
        
        System.out.println(String.format(temperatureString, temperature));
        
    }
}
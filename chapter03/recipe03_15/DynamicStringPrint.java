package org.java17recipes.chapter03.recipe03_15;

public class DynamicStringPrint {

    public static void main(String[] args){
        double temperature = 37.1;
        System.out.printf("The current temperature is %.1f degrees Celsius.\n", temperature);

        temperature = 38.4;
        
        System.out.printf("The current temperature is %.1f degrees Celsius.", temperature);
        
    }
}

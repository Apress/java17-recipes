package org.java17recipes.chapter01.recipe01_09;

public class StringConversion {
    
    public static void main (String[] args) {
        double pi;
       String strval;

        pi = Double.parseDouble("3.14");
        System.out.println(strval = String.valueOf(pi));
        System.out.println(Double.toString(pi));
    }
    
}

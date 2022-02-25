package org.java17recipes.chapter01.recipe01_11;

import java.io.*;

public class AcceptingInput {
    public static void main(String[] args){
        BufferedReader readIn = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String numberAsString = "";
        long numberAsLong = 0; 
        
        boolean numberIsValid = false;
        do {
            /* Ask the user for a number. */
            System.out.println("Please enter a number: ");
            try {
                numberAsString = readIn.readLine();
                System.out.println("You entered " + numberAsString);
            } catch (IOException ex){
                System.out.println(ex);
            }

            /* Convert the number into binary form. */
            try {
                numberAsLong = Long.parseLong(numberAsString);
                numberIsValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println ("Not a number!");
            }
        } while (numberIsValid == false);  
    }
}

package org.java17recipes.chapter03.recipe03_05;

public class StripClassExample {
    public static void main(String[] args) 
    {
        String nameString = "  Ciao Sara!   "; 
        System.out.println( nameString.strip() );          
        System.out.println( nameString.stripLeading() );   
        System.out.println( nameString.stripTrailing() );  
    }
}


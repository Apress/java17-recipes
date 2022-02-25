package org.java17recipes.chapter03.recipe03_03;

public class StringExamples {
    public static void main(String[] args){

        trimString();
        
     }
    
     public static void trimString(){
         String myString = " This is a String that contains whitespace.   ";
         
         System.out.println(myString);
         System.out.println(myString.trim());
     }
}

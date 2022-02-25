package org.java17recipes.chapter01.recipe01_05;

public class HelloWorld {
    /* The main method begins in this class */

    public static void main(String[] args) {
        
        HelloMessage hm;     
        hm = new HelloMessage();
        
        System.out.println(hm.getMessage());
        
        hm.setMessage("Hello, World");
        
        System.out.println(hm.getMessage());    
    }
}

package org.java17recipes.chapter06.recipe06_07;

import java.util.function.Consumer;

public class VariableAccess {
    public String CLASSA = "Class-level A";  
    
    void lambdaInMethod(String passedIn){
        String METHODA = "Method-level A";
        Consumer<String> l1 = x -> {
            System.out.println(x);
            System.out.println("CLASSA Value: " + CLASSA);
        };
        l1.accept(METHODA);
        l1.accept(CLASSA);
        l1.accept(passedIn);
     
    } 
    
   
}
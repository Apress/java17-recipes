package org.java17recipes.chapter06.recipe06_01;

public class HelloLambda {


    /**
     * Functional Interface
     */
	@FunctionalInterface
    public interface HelloType {
        /**
         * Function that will be implemented within the lambda
         * @param text 
         */
        void hello(String text);
    }
    
    public static void main(String[] args){
        // Invoke the lambda, passing a parameter named "text" to the
        // hello() method, returning the string
        HelloType helloLambda = 
                (String text) -> {System.out.println("Hello " + text);};
        // Invoke the method call
        helloLambda.hello("Lambda");
    }
}


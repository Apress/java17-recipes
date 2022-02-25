package org.java17recipes.chapter06.recipe06_07;
import java.util.function.Consumer;
public class VariableAccessInner {

    public String CLASSA = "Class-level A";

    class InnerClass {
 
        public String CLASSA = "Class-level B";
        
        void lambdaInMethod(String passedIn) {
            String METHODA = "Method-level A";
            //passedIn = "test";
            Consumer<String> l1 = x -> {
                System.out.println(x);
                System.out.println("CLASSA Value: " + CLASSA);
                System.out.println("METHODA Value: " + METHODA);
                // Cannot access passedIn directly if the variable is altered
                // inside of the enclosing method
                // System.out.println(passedIn);
            };

            l1.accept(CLASSA);
            l1.accept(passedIn);

        }
    }
}

package org.java17recipes.chapter06.recipe06_01;

public class LambdaExamples {


    /**
     * Functional interface returning a string
     */
    interface StringReturn {
        String returnMessage();
    }
    
    /**
     * Functional interface returning an int
     */
    interface ActionCode{
        int returnCode(String codestr);
    }
    
    /**
     * An example of a lambda containing no arguments
     */
    public static void noArguments(){
        StringReturn msg = () ->  "This is a test";
        System.out.println(msg.returnMessage());
    }
    
    public static void returnCode(){
        ActionCode code = (codestr) -> {
            switch(codestr){
                case "ACTIVE": return 0;
                case "INACTIVE": return 1;
                default:
                    return -1;
            }
        };
        System.out.println("Returns: " + code.returnCode("ACTIVE"));
        
    }
    
    public static void main(String[] args){
        noArguments();
        returnCode();
    }
}


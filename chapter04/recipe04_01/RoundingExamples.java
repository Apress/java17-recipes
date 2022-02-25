package org.java17recipes.chapter04.recipe04_01;

public class RoundingExamples {
    
    public static void main(String[] args){
        // Round a float value to an int
    	Float floatValue =  7.82f;
    	Double doubleValue = 9.9d;
        System.out.println(roundFloatToInt(floatValue));
        System.out.println(roundDoubleToLong(doubleValue));
        Float floatValue1 =  1.0f;
        Float floatValue1n =  -1.0f;
        Float floatValue0 =  0.0f;
        System.out.println(floatValue1/floatValue0);
        System.out.println(floatValue0/floatValue0);
        System.out.println(floatValue1n/floatValue0);
        Double doubleValue1 =  1.0d;
        Double doubleValue1n =  -1.0d;
        Double doubleValue0 =  0.0d;
        System.out.println(doubleValue1/doubleValue0);
        System.out.println(doubleValue0/doubleValue0);
        System.out.println(doubleValue1n/doubleValue0); 
    }
    
    /**
     * Rounds a floating-point number to an int and returns the result
     * @param myFloat
     * @return 
     */
    public static int roundFloatToInt(float myFloat){
        return Math.round(myFloat);
    }

    /**
     * Rounds a Double value to an int and returns the result
     * @param myDouble
     * @return 
     */
    public static long roundDoubleToLong(double myDouble){
        return Math.round(myDouble);
    }
    
}

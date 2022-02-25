package org.java17recipes.chapter03.recipe03_09;

public class StringExamples { 
    
    public static void main(String[] args){

       concatExample();
       concatOperatorExample();
       stringBufferExample();
       stringConcatExample();
    }
   
    
    public static void concatExample(){
        String one = "Hello";
        String two = "Java17";
        String result = one.concat(" ".concat(two));
        
        System.out.println(result);
    }
    
    public static void concatOperatorExample(){
        String one = "Hello";
        String two = "Java17";
        String result = one + " " + two;
        
        System.out.println(result);
    }
    
    public static void stringBufferExample(){
        String one = "Hello";
        String two = "Java17";
        StringBuffer buffer = new StringBuffer();
        buffer.append(one).append(" ").append(two);

        String result = buffer.toString();

        System.out.println(result);
    }
    
    public static void stringConcatExample(){
    String one = "Hello";
    String two = "Java17";
    String result = one.concat(" ".concat(two.substring(0, two.length()-2)));
    System.out.println(result);
    }
}

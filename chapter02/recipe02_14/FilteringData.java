package org.java17recipes.chapter02.recipe02_14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilteringData {
    
    public static void main(String[] args){
        List<String> myLangs = Arrays.asList("Jython is great","Groovy is awesome","Scala is functional",
                "JRuby is productive","Java is streamlined","","Kotlin is interesting");
        System.out.println("Collection Data: " + myLangs);
        
        takeWhileExample();
        dropWhileExample();
    }
    
    
    
    public static void takeWhileExample(){
        Stream.of("Jython is great","Groovy is awesome","Scala is functional",
                "JRuby is productive","Java is streamlined","","Kotlin is interesting")
                .takeWhile(s -> !s.contains("Java"))
                .forEach(System.out::println);
       
    }
    
    public static void dropWhileExample(){
        Stream.of("Jython is great","Groovy is awesome","Scala is functional",
                "JRuby is productive","Java is streamlined","","Kotlin is interesting")
                .dropWhile(s -> !s.contains("Java"))
                .forEach(System.out::println);
       
    }
}

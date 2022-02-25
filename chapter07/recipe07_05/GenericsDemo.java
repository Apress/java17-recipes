package org.java17recipes.chapter07.recipe07_05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
 

public class GenericsDemo {

    public static List<String> getEmptyList() {
        // Diamond type inference (Java 7 only!)
        //
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        
        // NOTE: The code here is simply demonstrating the concepts described in
        // the recipe, and doesn't produce any useful output. Lines with compiler 
        // warnings and errors are left intact to allow you to study and understand 
        // the code and the error given. It would be a good exercise to both 
        // compile this code on the command line and within an IDE to see the 
        // various ways compiler errors and warnings are presented.
        
        // Uncomment the lines that are indicated as "won't compile" to see
        // the IDE or the code compilation fail.

        // Concrete parameterized type
        //
        List<Integer> aList = new LinkedList<Integer>();
        aList.add(new Integer(121));
        aList.add(42);   // 42 is the same as new Integer(42), due to autoboxing.
        // aList.add("Java7");  // won't compile, wrong type

        Number aNum = new Integer("7");
        // aList.add(aNum);  // won't compile, wrong type

        aList.add((Integer) aNum);  // compiles, but don't do this.

        List rawList = new LinkedList(); // compiler warning; raw type
        aList = rawList;  // compiler warning; unchecked conversion

        // List<Number> bList = new LinkedList<Integer>();  // won't compile; incompatible types

        // Wildcard bounded parameterized types
        //
        List<? extends Number> cList;
        cList = new LinkedList<Number>();
        cList = new LinkedList<Integer>();
        cList = new LinkedList<Double>();

        // we can get(), but we can't add() with "? extends"
        // cList.add(new Integer(5));  // add() not allowed; cList could be LinkedList<Double>
        // Number cNum = cList.get(0);

        List<? super Integer> dList;
        dList = new LinkedList<Integer>();
        dList = new LinkedList<Number>();
        dList = new LinkedList<Object>();

        // we can do limited add()'s, but we can't get() with "? super"
        // Integer dInt = dList.get(0);  // get() not allowed; dList.get(0) could be a Number or Object
        dList.add(new Integer(5));  // OK
        Number dNum = new Double(7);
        // dList.add(dNum);  // won't compile; dList could be LinkedList<Integer>

        // Diamond type inference (Java 7 only!)
        //
        List<Integer> eList = new ArrayList<>(); // most common diamond usage
        Map<Integer, List<String>> aMap = new HashMap<>();  // Nice!
        
        List<String> fList = getEmptyList(); // diamond in return statement; see getEmptyList()
        
        List<List<String>> gList = new ArrayList<>();
        gList.add(0, new ArrayList<>(Arrays.asList("a", "b")));  // diamond in method arg
        
        // new HashMap<>() != new HashMap()
        Map<Integer, List<String>> bMap = new HashMap();   // compiler warnings; avoid raw types
        
        System.out.println("Finally, you fixed me!");
        
    }
}

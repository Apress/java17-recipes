package org.java17recipes.chapter01.recipe01_08;

class TestClass {
    private long visibleOnlyInThisClass;
    double visibleFromEntirePackage; 
    
    void setLong (long val) {
        visibleOnlyInThisClass = val;
    }
    
    long getLong () {
       return visibleOnlyInThisClass;
    }  
}

public class VisibilityExample {            
    public static void main(String[] args) {
        TestClass tc = new TestClass();  
        tc.setLong(32768);
        tc.visibleFromEntirePackage = 3.1415926535;
        System.out.println(tc.getLong());
        System.out.println(tc.visibleFromEntirePackage);
    }
}


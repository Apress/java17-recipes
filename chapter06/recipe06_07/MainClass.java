package org.java17recipes.chapter06.recipe06_07;

public class MainClass {
    public static void main(String[] args){
        System.out.println("==VariableAccess==");
        VariableAccess va = new VariableAccess();
        va.lambdaInMethod("Hello");
        
        System.out.println("==VariableAccessInner==");
        VariableAccessInner vai = new VariableAccessInner();
        VariableAccessInner.InnerClass inner = vai.new InnerClass();
        inner.lambdaInMethod("Hello");
        
    }
}

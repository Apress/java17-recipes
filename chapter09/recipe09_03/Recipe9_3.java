package org.java17recipes.chapter09.recipe09_03;

public class Recipe9_3 {
   public static void main(String[] args) {
       Recipe9_3 recipe = new Recipe9_3();
       recipe.start();
   }

   private void start() { 
       try {
           callSomeFunctionThatMightThrow(null);
       } catch (NullPointerException e) {
           System.err.println("There was an illegal argument exception!");
       }

   }

   private void callSomeFunctionThatMightThrow(Object o) {
       if (o == null) throw new NullPointerException("The object is null");

   }
}

package org.java17recipes.chapter09.recipe09_05;


import java.util.Random;

public class Recipe9_5 {
   public static void main(String[] args) {
       Recipe9_5 recipe = new Recipe9_5();
       recipe.start();
       recipe.startForCurrentThread();
   }

   private void start() {
       Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
           System.out.println("Woa! there was an exception thrown somewhere! "+t.getName()+": "+e);
       });

       final Random random = new Random();
       for (int j = 0; j < 10; j++) {
           int divisor = random.nextInt(4);
           System.out.println("200 / " + divisor + " Is " + (200 / divisor));
       }
   }

   private void startForCurrentThread() {
       Thread.currentThread().setUncaughtExceptionHandler((Thread t, Throwable e) -> {
           System.out.println("In this thread "+t.getName()+" an exception was thrown "+e);
       });

       Thread someThread = new Thread(() -> {
           System.out.println(200/0);
       });
       someThread.setName("Some Unlucky Thread");
       someThread.start();

       System.out.println("In the main thread "+ (200/0));
   }
}

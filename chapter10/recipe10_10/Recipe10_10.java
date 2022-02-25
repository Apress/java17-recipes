package org.java17recipes.chapter10.recipe10_10;


import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class Recipe10_10 {

   DoubleAdder da = new DoubleAdder();
   LongAdder la = new LongAdder();

   public static void main(String[] args) {
       Recipe10_10 recipe10_10 = new Recipe10_10();
       recipe10_10.start();
   }

   private void start() {

       Thread thread1 = new Thread(() -> {
           for (int i1 = 0; i1 < 10; i1++) {
               da.add(i1);
               la.add(i1);
               System.out.println("Adding " + i1);
           }
       });

       Thread thread2 = new Thread(() -> {
           for (int i1 = 0; i1 < 10; i1++) {
               da.add(i1);
               la.add(i1);
               
               System.out.println("Adding " + i1);
           }
       });

       thread1.start();
       thread2.start();

       try {
           // Sleep while summing
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       System.out.println("The sum is: " + da.doubleValue());
       System.out.println("The sum is: " + la.doubleValue());
   }
}


package org.java17recipes.chapter10.recipe10_04;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Recipe10_4 {
   public static void main(String[] args) {
       Recipe10_4 recipe = new Recipe10_4();
       recipe.start();
   }

   private void start() {
       System.out.println("Using CopyOnWrite");
       copyOnWriteSolution();
       System.out.println("Using SynchronizedList");
       synchronizedListSolution();
   }

   private void synchronizedListSolution() {
       final List<String> list = Collections.synchronizedList(new ArrayList<String>());
       startUpdatingThread(list);
       synchronized (list) {
           list.stream().forEach((element) -> {
               System.out.println("Element :" + element);
           });
       }
       stopUpdatingThread();

   }

   private void copyOnWriteSolution() {
       CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
       startUpdatingThread(list);
       list.stream().forEach((element) -> {
           System.out.println("Element :" + element);
       });
       stopUpdatingThread();

   }

   private void stopUpdatingThread() {
       updatingThread.interrupt();

   }

   Random random = new Random();

   Thread updatingThread ;
   private void startUpdatingThread(final List<String> list) {
       updatingThread = new Thread(() -> {
           long counter =0;
           while (!Thread.interrupted()) {
               int size = list.size();
               if (random.nextBoolean()) {
                   if (size > 1) {
                       list.remove(random.nextInt(size - 1));
                   }
               } else {
                   if (size < 20) {
                       list.add("Random string "+counter);
                   }
               }
               counter ++;
           }
       });
       updatingThread.start();

       // let it warm up for a second
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }
}


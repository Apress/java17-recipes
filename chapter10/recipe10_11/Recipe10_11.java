package org.java17recipes.chapter10.recipe10_11;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class Recipe10_11 {

   public static void main(String[] args) {
       try {
           CompletableFuture tasks = performWork()
                   .thenApply(work -> {
                       String newTask = work + " Second task complete!";
                       System.out.println(newTask);
                       return newTask;
                   }).thenApply(finalTask -> finalTask + " Final Task Complete!");
           
           CompletableFuture future = performSecondWork("Java 9 is Great! ");
           while(!tasks.isDone()){
              System.out.println(future.get());
           }
           System.out.println(tasks.get());
           
           
       } catch (ExecutionException | InterruptedException ex) {

       }
   }

   /**
    * Returns a CompleableFuture object.
    * @return 
    */
   public static CompletableFuture performWork() {
       CompletableFuture resultingWork = CompletableFuture.supplyAsync(
               () -> {
                   String taskMessage = "First task complete!";
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       System.out.println(ex);
                   }
                   System.out.println(taskMessage);
                   return taskMessage;
               });
       return resultingWork;

   }

   /**
    * Accepts a String and returns a CompletableFuture.
    * @param message
    * @return 
    */
   public static CompletableFuture performSecondWork(String message) {
       CompletableFuture resultingWork = CompletableFuture.supplyAsync(
               () -> {
                   String taskMessage = message + " Another task complete!";
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       System.out.println(ex);
                   }

                   return taskMessage;
               });
       return resultingWork;

   }
}


package org.java17recipes.chapter10.recipe10_01;


public class Recipe10_1 {
    public static void main(String[] args) {
        Recipe10_1 recipe = new Recipe10_1();
        recipe.startProcess();
    }

    private void startProcess() {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                doSomethingInBackground();
            }
        }, "Background Thread");

        // Using a lambda expression:
        //Thread backgroundThread = 
        //new Thread(this::doSomethingInBackground, "Background Thread");
        System.out.println("Start");
        backgroundThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": is counting " + i);
        }

        System.out.println("Done");
    }

    private void doSomethingInBackground() {
        System.out.println(Thread.currentThread().getName() + ": is Running in the background");
    }
}


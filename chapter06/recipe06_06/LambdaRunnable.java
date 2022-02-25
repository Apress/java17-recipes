package org.java17recipes.chapter06.recipe06_06;

public class LambdaRunnable {

    public static void main(String[] args) {

        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                int x = 5 * 3;
                System.out.println("The variable using the old way equals: " + x);
            }
        };

        Runnable lambdaRunnable = () -> {
            int x = 5 * 3;
            System.out.println("The variable using the lambda equals: " + x);
        };

        oldRunnable.run();
        lambdaRunnable.run();
    }
}

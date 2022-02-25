package org.java17recipes.chapter04.recipe04_18;

public class NumericLiteralExample {

    public static void main(String[] args) {
        int million = 1_000_000;
        int billion = 1_000_000_000;
        float ten_pct = 1_0f;
        double exp = 1_234_56.78_9e2;
        System.out.println(million);
        System.out.println(billion);
        System.out.println(ten_pct);
        System.out.println(exp);
    }
}


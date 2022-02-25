package org.java17recipes.chapter07.recipe07_06;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

public class StockScreener {
    
    public enum Screen { PE, YIELD, BETA };
    
    public static boolean screen(String stock, Screen screen, double threshold) {
        double screenVal = 0;
        boolean pass = false;
        switch (screen) {
            case PE:
                screenVal = Math.random() * 25;
                pass = screenVal <= threshold;
                break;
            case YIELD:
                screenVal = Math.random() * 8;
                pass = screenVal >= threshold;
                break;
            case BETA:
                screenVal = Math.random() * 2;
                pass = screenVal <= threshold;
                break;
        }
        System.out.println(stock + ": " + screen.toString() + " = " + screenVal);

        return pass;
    }
    
    public static void screen(List<String> stocks, Screen screen, double threshold) {
        Iterator<String> iter = stocks.iterator();
        while (iter.hasNext()) {
            String stock = iter.next();
            if (!screen(stock, screen, threshold)) {
                iter.remove();
            }
        }
    }
    
    public static void main(String[] args) {
        
        List<String> stocks = new ArrayList<>();
        stocks.add("ORCL");
        stocks.add("AAPL");
        stocks.add("GOOG");
        stocks.add("IBM");
        stocks.add("MCD"); 
        System.out.println("Screening stocks: " + stocks);
        
        if (stocks.contains("GOOG") &&
            !screen("GOOG", Screen.BETA, 1.0)) {
            stocks.remove("GOOG");
        }
        System.out.println("First screen: " + stocks);
        
        StockScreener.screen(stocks, Screen.YIELD, 3.5);
        System.out.println("Second screen: " + stocks);
        StockScreener.screen(stocks, Screen.PE, 18);
        System.out.println("Third screen: " + stocks);
        
        System.out.println("Buy List: " + stocks);   
    }
}


package org.java17recipes.chapter07.recipe07_08;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

 
public class StreamExample {
    static List<Stock> myStocks = new ArrayList();
    
    private static void createStocks(){
        myStocks.add(new Stock("ORCL", "Oracle", 500.0));
        myStocks.add(new Stock("AAPL", "Apple", 200.0));
        myStocks.add(new Stock("GOOG", "Google", 100.0));
        myStocks.add(new Stock("IBM", "IBM", 50.0));
        myStocks.add(new Stock("MCD", "McDonalds", 300.0));
    }
    
    public static void main(String[] args){
        createStocks();
        // Iterate over each element and print the stock names
        myStocks.stream()
                .forEach(s->System.out.println(s.getName()));
        
        boolean allGt = myStocks.stream()
                .allMatch(s->s.getShares() > 100.0);
        System.out.println("All Stocks Greater Than 100.0 Shares? " + allGt);
        
        // Print out all stocks that have more than 100 shares
        System.out.println("== We have more than 100 shares of the following:");
        myStocks.stream()
                .filter(s -> s.getShares() > 100.0)
                .forEach(s->System.out.println(s.getName()));
        
        System.out.println("== The following stocks are sorted by shares:");
        Comparator<Stock> byShares = Comparator.comparing(Stock::getShares);
        Stream<Stock> sortedByShares = myStocks.stream()
                .sorted(byShares);
        sortedByShares.forEach(s -> System.out.println("Stock: " + s.getName() + " - Shares: " + s.getShares()));
        
        // May or may not return a value
        Optional<Stock> maybe = myStocks.stream()
                .findFirst();
        System.out.println("First Stock: " + maybe.get().getName());
        
        List newStocks = new ArrayList();
        Optional<Stock> maybeNot = newStocks.stream()
                .findFirst();
        Consumer<Stock> myConsumer = (s) ->
        {
          System.out.println("First Stock (Optional): " + s.getName());
        };
        maybeNot.ifPresent(myConsumer);
        
        if(maybeNot.isPresent()){
            System.out.println(maybeNot.get().getName());
        }
        
        newStocks.add(new Stock("MCD", "McDonalds", 300.0));
        Optional<Stock> maybeNow = newStocks.stream()
                .findFirst();
        maybeNow.ifPresent(myConsumer);
        
    }
                
}


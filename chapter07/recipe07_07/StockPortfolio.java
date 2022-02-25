package org.java17recipes.chapter07.recipe07_07;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 
public class StockPortfolio implements Iterable<Stock> {
    
    Map<String, Stock> portfolio = new HashMap<>();
    
    public void add(Stock stock) {
        portfolio.put(stock.getSymbol(), stock);
    }
    
    public void add(List<Stock> stocks) {
        for (Stock s : stocks) {
            portfolio.put(s.getSymbol(), s);
        }
    }

    @Override
    public Iterator<Stock> iterator() {
        return portfolio.values().iterator();
    }

    public static void main(String[] args) {
        
        StockPortfolio myPortfolio = new StockPortfolio();
        myPortfolio.add(new Stock("ORCL", "Oracle", 500.0));
        myPortfolio.add(new Stock("AAPL", "Apple", 200.0));
        myPortfolio.add(new Stock("GOOG", "Google", 100.0));
        myPortfolio.add(new Stock("IBM", "IBM", 50.0));
        myPortfolio.add(new Stock("MCD", "McDonalds", 300.0));

        // foreach loop (uses Iterator returned from iterator() method) 
        System.out.println("====Print using legacy for-each loop====");
        for (Stock stock : myPortfolio) {
            System.out.println(stock);
        }
        
        System.out.println("====Print using Java 8 foreach implementation====");
        myPortfolio.forEach(s->System.out.println(s));
    }
}

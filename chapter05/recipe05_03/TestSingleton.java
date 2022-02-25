package org.java17recipes.chapter05.recipe05_03;

 
import java.util.List;
 
public class TestSingleton {
    public static void main(String[] args){
        StatisticsSingleton stats = StatisticsSingleton.INSTANCE;
        
        System.out.println("Adding objects to the list using stats object");
                
        List<String> mylist = stats.getTeams();
        mylist.add("One");
        mylist.add("Two");
        
        System.out.println("Reading objects from the list using stats2 object");
        StatisticsSingleton stats2 = StatisticsSingleton.INSTANCE;
        List<String> mylist2 = stats2.getTeams();
        for(Object name : mylist2){
            System.out.println(name.toString());
        }
            
    }
}


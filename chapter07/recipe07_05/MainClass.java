package org.java17recipes.chapter07.recipe07_05;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class MainClass {

    static List<Player> team;

    private static void loadTeam() {
        System.out.println("Loading team...");

        // Use of the diamond operator
        team = new ArrayList<>();
        Player player1 = new Player("Josh", "Juneau", 5);       
        Player player2 = new Player("Duke", "Java", 15);
        Player player3 = new Player("Jonathan", "Gennick", 1);
        Player player4 = new Player("Bob", "Smith", 18);
        Player player5 = new Player("Steve", "Adams", 7);

        team.add(player1);
        team.add(player2);
        team.add(player3);
        team.add(player4);
        team.add(player5);

    }

    public static void main(String[] args) {
        loadTeam();

        // Create a list without specifying a type
        List objectList = new ArrayList();
        Object obj1 = "none";
        objectList.add(obj1);

        // Create a List that can be of type that is any superclass of Player
        List<? super Player> myTeam = objectList;
        for (Object p : myTeam) {
            System.out.println("Printing the objects...");
            System.out.println(p.toString());
        }

        Map<String, String> strMap = new HashMap<>();
        strMap.put("first", "Josh");
        strMap.put("last", "Juneau");
        System.out.println(strMap.values());
    }
}


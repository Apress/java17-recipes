package org.java17recipes.chapter06.recipe06_05;

import java.util.ArrayList;
import java.util.List;
 
public class Filter {
    static List<Player> team;

    private static void loadTeam() {
        System.out.println("Loading team...");
        team = new ArrayList();
        Player player1 = new Player();
        player1.setFirstName("Josh");
        player1.setLastName("Juneau");
        player1.setGoals(5);
        player1.setStatus(0);
        Player player2 = new Player();
        player2.setFirstName("Duke");
        player2.setLastName("Java");
        player2.setGoals(15);
        player2.setStatus(0);
        Player player3 = new Player();
        player3.setFirstName("Jonathan");
        player3.setLastName("Gennick");
        player3.setGoals(1);
        player3.setStatus(0);
        Player player4 = new Player();
        player4.setFirstName("Bob");
        player4.setLastName("Smith");
        player4.setGoals(18);
        player4.setStatus(0);
        Player player5 = new Player();
        player5.setFirstName("Steve");
        player5.setLastName("Adams");
        player5.setGoals(7);
        player5.setStatus(1);

        team.add(player1);
        team.add(player2);
        team.add(player3);
        team.add(player4);
        team.add(player5);

    }
    
    public static void main(String[] args){
        // Load team list
        loadTeam();
        
        // Create Array to store the matching reaults
        List<Player> gteTenGoals = new ArrayList<Player>();
        
        // Create a stream from the team List, then call the filter
        // method on the stream and apply the desired filtering criterla
        // to each object in the stream.  For each matching object, add
        // to the gteTenGoals array.
        team.stream().filter(
                p -> p.getGoals() >= 10
                && p.getStatus() == 0)
                .forEach(element -> gteTenGoals.add(element));
        System.out.println("Number of Players Matching Criteria: " + gteTenGoals.size());
    }
}


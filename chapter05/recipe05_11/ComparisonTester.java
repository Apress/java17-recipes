package org.java17recipes.chapter05.recipe05_11;
 
import java.util.ArrayList;
import java.util.List;

 
public class ComparisonTester {
    public static void main(String[] args){
        
        // Compare if two objects contain the same values
        Team team1 = new Team();
        Team team2 = new Team();
        List<Player> playerList = new ArrayList();
        team1.setName("Jokers");
        team1.setCity("Crazyville");
        
       
        Player newPlayer = new Player("Josh", "Juneau");
        playerList.add(0, newPlayer);
        
        newPlayer = new Player("Carl", "Dea");
        playerList.add(1, newPlayer);
        
        newPlayer = new Player("Freddy", "Guime");
        playerList.add(1, newPlayer);
        
        newPlayer = new Player("John", "OConner");
        playerList.add(1, newPlayer);
        
        newPlayer = new Player("Mark", "Beaty");
        playerList.add(1, newPlayer);
        
        team1.setPlayers(playerList);
        

        team2.setName("Jokers");
        team2.setCity("Crazyville");
        team2.setPlayers(playerList);

        if (team1 == team2){
            System.out.println("These object references refer to the same object.");
        } else {
            System.out.println("These object references do NOT refer to the same object.");
        }

        if (team1.equals(team2)){
            System.out.println("These object references contain the same values.");
        } else {
            System.out.println("These object references do NOT contain the same values.");
        }


        // Compare two objects to see if they refer to the same object
        Team team3 = team1;
        Team team4 = team1;

        if (team3 == team4){
            System.out.println("These object references refer to the same object.");
        } else {
            System.out.println("These object references do NOT refer to the same object.");
        }
        
    }
}

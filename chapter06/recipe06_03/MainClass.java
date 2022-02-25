package org.java17recipes.chapter06.recipe06_03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
   static List<Player> team;

   private static void loadTeam() {
       System.out.println("Loading team...");
       team = new ArrayList();
       Player player1 = new Player();
       player1.setFirstName("Josh");
       player1.setLastName("Juneau");
       player1.setGoals(5);
       Player player2 = new Player();
       player2.setFirstName("Duke");
       player2.setLastName("Java");
       player2.setGoals(15);
       Player player3 = new Player();
       player3.setFirstName("Jonathan");
       player3.setLastName("Gennick");
       player3.setGoals(1);
       Player player4 = new Player();
       player4.setFirstName("Bob");
       player4.setLastName("Smith");
       player4.setGoals(18);
       Player player5 = new Player();
       player5.setFirstName("Steve");
       player5.setLastName("Adams");
       player5.setGoals(7);

       team.add(player1);
       team.add(player2);
       team.add(player3);
       team.add(player4);
       team.add(player5);

   }
   
   public static void printList(Player[] teamArray){
       for(Player player:teamArray){
           System.out.println(player.getLastName() + " - " + player.getGoals());
       }
   }
   
   public static void main(String[] args){
       loadTeam();
       Player[] teamArray = team.toArray(new Player[team.size()]);
       
       // Written as lambda
       // Arrays.sort(teamArray, (p1, p2) -> Player.compareByGoal(p1,p2));
       
       // Written as method reference
       Arrays.sort(teamArray, Player::compareByGoal);
       printList(teamArray);
       
       System.out.println("Loading second method reference demo...");
       // Second method reference demo
       Player[] teamArray2 = team.toArray(new Player[team.size()]);
       PlayerUtility utility = new PlayerUtility();
       Arrays.sort(teamArray2, utility::compareByGoal);
       printList(teamArray);
       
       // Method Refernce - Arbitrary Type
       Integer[] ints = {3,5,7,8,51,33,1};
       Arrays.sort(ints, Integer::compare);
       for(int i:ints){
           System.out.println(i);
       }
       
       PlayerFactory player1 = Player::new;
       Player newPlayer = player1.createPlayer("CENTER", 0, "Constructor", "Referenceson");
       System.out.println(newPlayer.getLastName());
   }
   
}


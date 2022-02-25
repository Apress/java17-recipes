package org.java17recipes.chapter05.recipe05_10;
 
public class CloneTester {
    
    public static void main(String[] args){
        Team team1 = new Team();
        Team team2 = new Team();

        team1.setCity("Boston");
        team1.setName("Bandits");

        team2.setCity("Chicago");
        team2.setName("Wildcats");


        Team team3 = team1;
        Team team4 = team2.clone();

        Team team5 = team1.shallowCopyClone();

        System.out.println("Team 3:");
        System.out.println(team3.getCity());
        System.out.println(team3.getName());

        System.out.println("Team 4:");
        System.out.println(team4.getCity());
        System.out.println(team4.getName());

        // Teams move to different cities
        team1.setCity("St. Louis");
        team2.setCity("Orlando");

        System.out.println("Team 3:");
        System.out.println(team3.getCity());
        System.out.println(team3.getName());

        System.out.println("Team 4:");
        System.out.println(team4.getCity());
        System.out.println(team4.getName());

        System.out.println("Team 5:");
        System.out.println(team5.getCity());
        System.out.println(team5.getName());


        if (team1 == team3){
            System.out.println("team1 and team3 are equal");
        } else {
            System.out.println("team1 and team3 are NOT equal");
        }

        if (team1 == team5){
            System.out.println("team1 and team5 are equal");
        } else {
            System.out.println("team1 and team5 are NOT equal");
        }
        
        
        
    }
    
}


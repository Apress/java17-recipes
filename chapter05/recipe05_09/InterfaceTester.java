package org.java17recipes.chapter05.recipe05_09;
 
public class InterfaceTester {
    
    static TeamType team = new Team();
    
    public static void main(String[] args){
        team.setCity("SomeCity");
        team.setName("SomeName");
        team.setPlayers(null);
        System.out.println(team.getFullName());
    }
    
}

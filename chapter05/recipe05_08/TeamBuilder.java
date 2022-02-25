package org.java17recipes.chapter05.recipe05_08;
 
public interface TeamBuilder {
    public void buildPlayerList();
    public void buildNewTeam(String teamName);
    public void designateTeamCity(String city);
    public Team getTeam();

}
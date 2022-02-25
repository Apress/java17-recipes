package org.java17recipes.chapter05.recipe05_08; 
public class Roster {

    public static void main(String[] args) {

        TeamType myTeam = createTeam("Juneau Royals", "Chicago");
        System.out.println(myTeam.getFullName());
    }

    public static Team createTeam(String teamName, String city) {
        TeamBuilder builder = new HockeyTeamBuilder();
        builder.buildNewTeam(teamName);
        builder.designateTeamCity(city);
        builder.buildPlayerList();
        return builder.getTeam();
    }
}


package org.java17recipes.chapter05.recipe05_09;
 
import java.util.List;
import org.java17recipes.chapter05.recipe05_04.Player;
 
public class Team implements TeamType {

    private List<Player> players;
    private String name;
    private String city;

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return this.name + " - " + this.city;
    }

    
}


package org.java17recipes.chapter05.recipe05_13;
 
import java.util.List;
 
public class Team implements TeamType, Cloneable {

    private List<Player> players;
    private String name;
    private String city;
    private volatile int cachedHashCode = 0;

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

    /**
     * Overrides Object's clone method
     * 
     * @return 
     */
    public Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Team) {
            Team other = (Team) obj;
            return other.getName().equals(this.getName())
                    && other.getCity().equals(this.getCity())
                    && other.getPlayers().equals(this.getPlayers());
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hashCode = cachedHashCode;
        if (hashCode == 0) {
            String concatStrings = name + city;
            if (players.size() > 0) {
                for (Player player : players) {
                    concatStrings = concatStrings
                            + player.getFirstName()
                            + player.getLastName()
                            + player.getPosition()
                            + String.valueOf(player.getStatus());

                }
            }
            hashCode = concatStrings.hashCode();
        }
        return hashCode;
    }
}

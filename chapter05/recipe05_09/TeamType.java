package org.java17recipes.chapter05.recipe05_09;
 
import java.util.List;
import org.java17recipes.chapter05.recipe05_04.Player;
 
public interface TeamType {
    
    void setPlayers(List<Player> players);
    void setName(String name);
    void setCity(String city);
    String getFullName();

}


package org.java17recipes.chapter05.recipe05_03;
 

import java.util.ArrayList;
import java.util.List;
 
public enum StatisticsSingleton {
    INSTANCE;
    
    private final List<String> teams = new ArrayList<String>();
    
    /**
     * @return the teams
     */
    public List<String> getTeams() {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(List<String> teams) {
        teams = teams;
    }
    
}


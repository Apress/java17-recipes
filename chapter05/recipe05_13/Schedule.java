package org.java17recipes.chapter05.recipe05_13;

 
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
 
public abstract class Schedule {
    
    public String scheduleYear;
    public String teamName;
    
    public List<Team> teams;
    
    public Map<Team, LocalDate> gameMap;
    
    public Schedule(){}
    
    public Schedule(String teamName){
        this.teamName = teamName;
    }
    
    abstract void calculateDaysPlayed(int month);
    
}


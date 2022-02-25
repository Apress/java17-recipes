package org.java17recipes.chapter05.recipe05_13;
 
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
 
public class TeamSchedule extends Schedule {

    public TeamSchedule(String teamName) {
        super(teamName);
    }

    @Override
    void calculateDaysPlayed(int month) {
        int totalGamesPlayedInMonth = 0;
        for (Map.Entry<Team, LocalDate> entry : gameMap.entrySet()) {
            if (entry.getKey().equals(teamName)
                    && entry.getValue().getMonth().equals(month)) {
                totalGamesPlayedInMonth++;
            }
        }
        System.out.println("Games played in specified month: " + totalGamesPlayedInMonth);
    }

}


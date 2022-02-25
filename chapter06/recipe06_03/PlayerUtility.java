package org.java17recipes.chapter06.recipe06_03;

import java.util.ArrayList;
import java.util.List;
 
public class PlayerUtility {

    public int compareByGoal(Player a, Player b){
        int eval;
        if(a.getGoals() > b.getGoals()){
            eval = 1;
        } else if (a.getGoals() < b.getGoals()){
            eval = -1;
        } else {
            eval = 0;
        }
        return eval;
    }
}

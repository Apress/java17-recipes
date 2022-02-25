package org.java17recipes.chapter05.recipe05_04;
 
public class Center extends Player implements PlayerType {
    
    private int totalShots;
    private int shotsOnGoal;
    private int steals;

    public Center(){
        super.setPosition("CENTER");
    }
    
    /**
     * @return the totalShots
     */
    public int getTotalShots() {
        return totalShots;
    }

    /**
     * @param totalShots the totalShots to set
     */
    public void setTotalShots(int totalShots) {
        this.totalShots = totalShots;
    }

    /**
     * @return the shotsOnGoal
     */
    public int getShotsOnGoal() {
        return shotsOnGoal;
    }

    /**
     * @param shotsOnGoal the shotsOnGoal to set
     */
    public void setShotsOnGoal(int shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    /**
     * @return the steals
     */
    public int getSteals() {
        return steals;
    }

    /**
     * @param steals the steals to set
     */
    public void setSteals(int steals) {
        this.steals = steals;
    }
    
    
}


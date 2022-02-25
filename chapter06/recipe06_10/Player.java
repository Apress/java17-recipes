package org.java17recipes.chapter06.recipe06_10;

public class Player {
    private String firstName = null;
    private String lastName = null;
    private String position = null;
    private int status = -1;
    private int goals;
    
    public Player(){
        
    }
    
    public Player(String position, int status){
        this.position = position;
        this.status = status;
    }
    
    public String findPlayerStatus(int status){
        String returnValue = null;
        
        returnValue =switch(status){
                case 0  -> "ACTIVE";
                case 1  -> "INACTIVE";
                case 2  -> "INJURY";
                default -> "ON_BENCH";
        };
        
        return returnValue;
    }
    
    public String playerString(){
        return getFirstName() + " " + getLastName() + " - " + getPosition();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }
}



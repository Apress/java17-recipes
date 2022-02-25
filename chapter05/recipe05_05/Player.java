package org.java17recipes.chapter05.recipe05_05;
 
public abstract class Player {
    
    private String firstName;
    private String lastName;
    private String position;
    private int status = -1;
    
    public Player(){
        
    }
    
    public Player(String position, int status){
        this.position = position;
        this.status = status;
    }
    
    protected String playerStatus(){
        String returnValue = null;
        
        switch(getStatus()){
                case 0:
                        returnValue = "ACTIVE";
                case 1:
                        returnValue = "INACTIVE";
                case 2:
                        returnValue = "INJURY";
                default:
                        returnValue = "ON_BENCH";
        }
        
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
        if (firstName.length() > 30){
            this.firstName = firstName.substring(0, 29);
        } else {
            this.firstName = firstName;
        }
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
}


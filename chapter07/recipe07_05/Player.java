package org.java17recipes.chapter07.recipe07_05;


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

	public Player(String first, String last, int goals){
		this.firstName = first;
		this.lastName = last;
		this.goals = goals;
	}

	public Player(String position, int status, String first, String last){
		this.position = position;
		this.status = status;
		this.firstName = first;
		this.lastName = last;
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

	/**
	 * Returns a positive integer if Player A has more goals than Player B
	 * Returns a negative integer if Player A has less goals than Player B
	 * Returns a zero if both Player A and Player B have the same number of goals
	 * @param a
	 * @param b
	 * @return 
	 */
	public static int compareByGoal(Player a, Player b){
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



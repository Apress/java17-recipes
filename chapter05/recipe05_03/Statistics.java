package org.java17recipes.chapter05.recipe05_03;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class Statistics implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Definition for the class instance
    private static Statistics INSTANCE = new Statistics();

    private List teams = new ArrayList();

    /**
     * Constructor has been made private so that outside classes do not have 
     * access to instantiate more instances of Statistics.
     */
    private Statistics(){ 
    }

    /**
     * Accessor for the statistics class.  Only allows for one instance of the
     * class to be created.
     * @return 
     */
    public static Statistics getInstance(){

        return INSTANCE;
    }

    /**
     * @return the teams
     */
    public List getTeams() {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(List teams) {
        this.teams = teams;
    }
 
    
}


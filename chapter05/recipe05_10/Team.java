package org.java17recipes.chapter05.recipe05_10;
 

import java.io.*;

/**
 * Recipe 5-10
 * 
 * Making a Class Cloneable
 *
 * @author juneau
 */
public class Team implements TeamType, Cloneable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String city;


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return this.name + " - " + this.city;
    }

    /**
     * Overrides Object's clone method to create a deep copy
     * 
     * @return 
     */
    @Override
    public Team clone() {

        Team obj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = (Team) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }

    /**
     * Overrides Object's clone method to create a shallow copy
     * 
     * @return 
     */
    public Team shallowCopyClone() {

        try {
            return (Team) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Team) {
            Team other = (Team) obj;
            return other.getName().equals(this.getName())
                    && other.getCity().equals(this.getCity());
        } else {
            return false;
        }

    }
}

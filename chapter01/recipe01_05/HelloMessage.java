package org.java17recipes.chapter01.recipe01_05;

public class HelloMessage {
    private String message = "";
   
    public HelloMessage() {
        this.message = "Default Message";
    }
        
    public void setMessage (String m) {
        this.message = m;
    }
   
    public String getMessage () {
        return this.message.toUpperCase();
    }   
}

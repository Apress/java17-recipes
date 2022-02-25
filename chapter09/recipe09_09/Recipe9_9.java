package org.java17recipes.chapter09.recipe09_09;
 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;


public class Recipe9_9 {
   public static void main (String[] args) throws IOException {
       Recipe9_9 recipe = new Recipe9_9();
       recipe.start();
   }

   private void start() {
       loadLoggingConfiguration();

       Logger logger = Logger.getLogger("");
       logger.info("Logging for the first Time!");
       logger.warning("A warning to be had");
       logger.severe("This is an error!");
 
       Logger rollingLogger = Logger.getLogger("rollingLogger");
       for (int i =0;i < 50;i++) {
           rollingLogger.info("Logging for an event with :"+i);
       }
   }

   private void loadLoggingConfiguration() {
       FileInputStream ins = null;
       try {
           ins = new FileInputStream(new File("logging.properties"));
           LogManager.getLogManager().readConfiguration(ins);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}


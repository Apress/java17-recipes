package org.java17recipes.chapter09.recipe09_10;

import java.io.*;
import java.util.logging.*;

public class Recipe9_10 {
   public static void main (String [] args) {
       Recipe9_10 recipe = new Recipe9_10();
       recipe.start();
   }

   static Logger rootLogger = Logger.getLogger("");
   private void start() {
       loadLoggingConfiguration();
       Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
           rootLogger.severe("Error in thread "+t+" caused by "+e);
       });

       int c = 20/0;
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


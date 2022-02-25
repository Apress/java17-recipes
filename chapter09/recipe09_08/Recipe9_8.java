package org.java17recipes.chapter09.recipe09_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;
 
public class Recipe9_8 {
    public static void main (String[] args) {
        Recipe9_8 recipe = new Recipe9_8();
        recipe.start();
    }

    private void start() {
        loadLoggingConfiguration();
        Logger logger = Logger.getLogger("recipeLogger");
        logger.info("Logging for the first Time!");
        logger.warning("A warning to be had");
        logger.severe("This is an error!");
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

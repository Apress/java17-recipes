package org.java17recipes.chapter08.recipe08_01;


import java.awt.*;
import java.io.*;

public class Ch_8_1_SerializeExample {
   public static void main(String[] args) {
       Ch_8_1_SerializeExample example = new Ch_8_1_SerializeExample();
       example.start();
   }

   private void start() {
       ProgramSettings settings = new ProgramSettings(new Point(10,10),new Dimension(300,200), Color.blue, "The title of the application" );
       saveSettings(settings,"settings.bin");
       ProgramSettings loadedSettings = loadSettings("settings.bin");
       if(loadedSettings != null)
           System.out.println("Are settings are equal? :"+loadedSettings.equals(settings));

   }

   private void saveSettings(ProgramSettings settings, String filename) {
       try {
           FileOutputStream fos = new FileOutputStream(filename);
           try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
               oos.writeObject(settings);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   private ProgramSettings loadSettings(String filename) {
       try {
           FileInputStream fis = new FileInputStream(filename);
           ObjectInputStream ois = new ObjectInputStream(fis);
           return (ProgramSettings) ois.readObject();
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return null;
   }

}


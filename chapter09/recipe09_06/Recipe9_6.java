package org.java17recipes.chapter09.recipe09_06;


import java.io.*;

public class Recipe9_6 {
   public static void main(String []args) {
       Recipe9_6 recipe = new Recipe9_6();
       recipe.start();
   }

   private void start() {
       try (
               FileOutputStream fos = new FileOutputStream("out.log");
               BufferedOutputStream bos = new BufferedOutputStream(fos);
               DataOutputStream dos = new DataOutputStream(bos)
       ) {
           dos.writeUTF("This is being written");
           // If an exception occurs here, resources will be handled correctly
           dos.close();
       } catch (Exception e) {
           System.out.println("Some bad exception happened ");
       }
   }
}


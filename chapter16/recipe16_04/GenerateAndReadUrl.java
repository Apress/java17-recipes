package org.java17recipes.chapter16.recipe16_04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GenerateAndReadUrl {

   public static void main(String[] args) {
       try {
           // Generate absolute URL
           URL url1 = new URL("https://openjdk.java.net");
           System.out.println(url1.toString());

           // Generate URL for pages with a common base
           URL url2 = new URL(url1, "projects/jdk/17");

           // Generate URL from different pieces of data
           URL url3 = new URL("http", "openjdk.java.net", "projects/jdk/17");

           readFromUrl(url1);
           
       } catch (MalformedURLException ex) {
           ex.printStackTrace();
       }
   }

   /**
    * Open URL stream as an input stream and print contents to command line.
    * 
    * @param url 
    */
   public static void readFromUrl(URL url) {
       try {
           BufferedReader in = new BufferedReader(
                   new InputStreamReader(
                   url.openStream()));

           String inputLine;

           while ((inputLine = in.readLine()) != null) {
               System.out.println(inputLine);
           }

           in.close();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }
}

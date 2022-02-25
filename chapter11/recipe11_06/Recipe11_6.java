package org.java17recipes.chapter11.recipe11_06;


import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;


public class Recipe11_6 {
   
   public void run() {
       byte[] legacySJIS = {(byte)0x82,(byte)0xB1,(byte)0x82,(byte)0xF1,(byte)0x82,(byte)0xC9,(byte)0x82,(byte)0xBF,(byte)0x82,(byte)0xCD,(byte)0x81,(byte)0x41,(byte)0x90,(byte)0xA2,(byte)0x8A,(byte)0x45,(byte)0x81,(byte)0x49};
       
       // Convert a byte[] to a String
       Charset cs =Charset.forName("SJIS");
       String greeting = new String(legacySJIS, cs);
       System.out.printf("Greeting: %s\n", greeting);

       // Convert a String to a byte[]
       byte[] toSJIS = greeting.getBytes(cs);
       
       // Confirm that the original array and newly converted array are same
       Boolean same = false;
       if (legacySJIS.length == toSJIS.length) {
           for (int x=0; x< legacySJIS.length; x++) {
               if(legacySJIS[x] != toSJIS[x]) break;
           }
           same = true;
       }
       System.out.printf("Same: %s\n", same.toString());
       
       SortedMap<String,Charset> charsets = Charset.availableCharsets();
       Iterator<Charset> cc = charsets.values().iterator();
       int size = charsets.size();
       while(cc.hasNext()) {
           System.out.printf("Charset: %s\n", cc.next().displayName());
       }
       System.out.printf("Count: %d\n", size);
   }
   
   public static void main(String[] args) {
       Recipe11_6 app = new Recipe11_6();
       app.run();
   }
   
}


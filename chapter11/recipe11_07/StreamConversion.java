package org.java17recipes.chapter11.recipe11_07;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StreamConversion {

   public void run() {
       try {
           String input = readStream();
           System.out.printf("Input stream: %s\n", input);
           writeStream(input);
       } catch (IOException ex) {
           Logger.getLogger(StreamConversion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

   public String readStream() throws IOException {
       InputStream is = getClass().getResourceAsStream("/resources/helloworld.sjis.txt");
       if (is == null) {
    	    throw new FileNotFoundException("Resource helloworld not found!");
    	  }
       StringBuilder sb = new StringBuilder();
       if (is != null) {
           try (InputStreamReader reader
                   = new InputStreamReader(is, Charset.forName("SJIS"))) {
               int ch = reader.read();
               while (ch != -1) {
                   sb.append((char) ch);
                   ch = reader.read();
               }
           }
       }
       return sb.toString();
   }

   public void writeStream(String text) throws IOException {
       FileOutputStream fos = new FileOutputStream("helloworld.utf8.txt");
       try (OutputStreamWriter writer
               = new OutputStreamWriter(fos, Charset.forName("UTF-8"))) {
           writer.write(text);
       }
   }

   public static void main(String[] args) {
       StreamConversion app = new StreamConversion();
       app.run();

   }

}

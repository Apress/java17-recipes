package org.java17recipes.chapter11.recipe11_07;


import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BufferConversion {
   private String unicodeString = "こんにちは、世界！";
   
   public void run() {
       try {
           System.out.printf("Original string: %s\n", unicodeString);
           CharBuffer srcBuffer = CharBuffer.wrap(unicodeString);
           ByteBuffer targetBytes = encodeBuffer("UTF8", srcBuffer);
           printBytes(targetBytes);
           CharBuffer roundtripBuffer = decodeBuffer("UTF8", targetBytes);
           printCharBuffer(roundtripBuffer);
           
       } catch (CharacterCodingException ex) {
           Logger.getLogger(BufferConversion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public ByteBuffer encodeBuffer(String charsetName, CharBuffer charBuffer) 
           throws CharacterCodingException {
       Charset charset = Charset.forName(charsetName);
       CharsetEncoder encoder = charset.newEncoder();
       ByteBuffer targetBuffer = encoder.encode(charBuffer);
       return targetBuffer;
       
   }
   
   public CharBuffer decodeBuffer(String charsetName, ByteBuffer srcBuffer) 
           throws CharacterCodingException {
       Charset charset = Charset.forName(charsetName);
       CharsetDecoder decoder = charset.newDecoder();
       CharBuffer charBuffer = decoder.decode(srcBuffer);
       return charBuffer;
   }
   
   private void printCharBuffer(CharBuffer buff) {
       String str = buff.toString();
       System.out.printf("Roundtrip string: %s\n", str);
   }
   
   private void printBytes(ByteBuffer bytes) {        
       System.out.print("Bytes: ");
       byte[] byteArray = bytes.array();
       for (byte b: byteArray) {
           if (b==0) break;
           System.out.printf("%2x ", b);
       }
       System.out.printf("\n");
   }
   
   public static void main(String[] args) {
       BufferConversion app = new BufferConversion();
       app.run();        
   }
}


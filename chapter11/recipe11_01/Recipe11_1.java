package org.java17recipes.chapter11.recipe11_01;


public class Recipe11_1 {

   public static void main(String[] args) {
       Recipe11_1 example = new Recipe11_1();
       example.run();
   }
   
   
   public void run() {
       int x = 0;
       for (int c=0; c <= 0x10FFFF; c++) {
           if (Character.isDigit(c)) {
               ++x;
               System.out.printf("Codepoint: 0x%04X\tCharacter: %c\tDigit: %d\tName: %s\n", c, c, Character.digit(c, 10), Character.getName(c));              
           }        }
       System.out.printf("Total digits: %d\n", x);
   }    
}


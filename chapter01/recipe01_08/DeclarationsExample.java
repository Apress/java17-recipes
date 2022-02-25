/**
 * 
 */
package org.java17recipes.chapter01.recipe01_08;

/**
 * @author lucky
 *
 */
public class DeclarationsExample {
    public static void main (String[] args) {
        boolean BooleanVal = true;  /* Default is false */
        
        char charval = 'G';     /* Unicode UTF-16 */
        charval = '\u0490';     /* Ukrainian letter Ghe(Ґ) */
        System.out.println(charval);
        byte byteval;       /*  8 bits, -127 to 127 */
        short shortval;     /* 16 bits, -32,768 to 32,768 */
        int intval;         /* 32 bits, -2147483648 to 2147483647 */
        long longval;       /* 64 bits, -(2^64) to 2^64 - 1 */

        float   floatval = 10.123456F; 
        double doubleval = 10.12345678987654; /* 64-bit IEEE 754 */

        String message = "Darken the corner where you are!"; 
        message = message.replace("Darken", "Brighten");
        System.out.println(message);
    }
}

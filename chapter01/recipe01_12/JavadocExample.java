package org.java17recipes.chapter01.recipe01_12;

import java.math.BigInteger;
public class JavadocExample {
    /**
     * Accepts an unlimited number of values and
     * returns the sum.
     *
     * @param nums Must be an array of BigInteger values.
     * @return Sum of all numbers in the array.
     */
     public static BigInteger addNumbers(BigInteger[] nums) {
         BigInteger result = new BigInteger("0");
         for (BigInteger num:nums){
             result = result.add(num);
         }
         return result;
     }
    /**
     * Test the addNumbers method.
     * @param args not used
     */
     public static void main (String[] args) {
         BigInteger[] someValues = {BigInteger.TEN, BigInteger.ONE};
         System.out.println(addNumbers(someValues));
     }
}

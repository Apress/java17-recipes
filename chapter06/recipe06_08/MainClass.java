package org.java17recipes.chapter06.recipe06_08;


import java.util.List;
import java.util.function.Function;

public class MainClass {
   public static void main(String[] args){
       
       double x = 16.0;
       double y = 30.0;
       double z = 4.0;
       
       // Create volume calculation function using a lambda
       Function<List<Double>, Double> volumeCalc = list -> {
           if(list.size() == 3){
               return list.get(0) * list.get(1) * list.get(2);
           } else {
               return Double.valueOf("-1");
           }
       };
       Double[] argList = new Double[3];
       argList[0] = x;
       argList[1] = y;
       argList[2] = z;
       
       // Create area calculation function using a lambda.  This particular
       // calculator ignores a third argument in the list, if it exists.
       Function<List<Double>, Double> areaCalc = list -> {
           if(list.size() == 2){
               return list.get(0) * list.get(1);
           } else {
               return Double.valueOf("-1");
           }
       };
       Double[] argList2 = new Double[2];
       argList2[0] = x;
       argList2[1] = y;
       
       PassingLambdaFunctions p1 = new PassingLambdaFunctions();
       System.out.println("The volume is: " + p1.calculate(volumeCalc, argList));
       System.out.println("The area is: " + p1.calculate(areaCalc, argList2));
   }
}

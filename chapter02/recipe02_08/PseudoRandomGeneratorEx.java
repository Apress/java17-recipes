package org.java17recipes.chapter02.recipe02_08;

import java.util.Random; 
import java.util.SplittableRandom; 

public class PseudoRandomGeneratorEx {
	 	
	public static void main(String[] args){
		Random randomNumber = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(randomNumber.nextInt());
		}
		SplittableRandom spltRandomNumber = new SplittableRandom();
		for (int i = 0; i < 5; i++) {
			System.out.println(spltRandomNumber.nextInt());
		} 
		
	}
}

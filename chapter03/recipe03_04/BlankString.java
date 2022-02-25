package org.java17recipes.chapter03.recipe03_04;

public class BlankString {   
	public static void main (String[] args) {
		System.out.println("".isEmpty()); 
		System.out.println(" ".isEmpty()); 
		System.out.println("".isBlank()); 
		System.out.println(" ".isBlank()); 
		System.out.println("Luciano Manelli".isBlank()); 
		}
}

package org.java17recipes.chapter03.recipe03_01;

public class StringExamples {
	public static void main(String[] args){


		substringExample();

	}

	public static void substringExample(){
		String originalString = "This is the original String";
		System.out.println(originalString.substring(0, originalString.length()));
		System.out.println(originalString.substring(5, 20));
		System.out.println(originalString.substring(12));
	}
}

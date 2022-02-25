package org.java17recipes.chapter04.recipe04_01;

public class InfinityExample { 

	public static void main(String[] args){

		Float floatValue1 =  1.0f;
		Float floatValue1n =  -1.0f;
		Float floatValue0 =  0.0f;
		System.out.println(floatValue1/floatValue0);
		System.out.println(floatValue0/floatValue0);
		System.out.println(floatValue1n/floatValue0);
		Double doubleValue1 =  1.0d;
		Double doubleValue1n =  -1.0d;
		Double doubleValue0 =  0.0d;
		System.out.println(doubleValue1/doubleValue0);
		System.out.println(doubleValue0/doubleValue0);
		System.out.println(doubleValue1n/doubleValue0); 
	}

}


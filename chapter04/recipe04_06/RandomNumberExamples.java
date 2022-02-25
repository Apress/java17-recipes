package org.java17recipes.chapter04.recipe04_06;


import java.util.Random;

public class RandomNumberExamples {

	public static void main(String[] args){
		randomExamples();
	}

	public static void randomExamples() {
		System.out.println("Each time you run, the results will be different!");
		// Create a new instance of the Random class
		Random random = new Random();
		System.out.println("Random: " + random);

		// Generates a random Integer
		int myInt = random.nextInt();
		System.out.println("Random int: " + myInt);
		// Generates a random Double value
		double myDouble = random.nextDouble();
		System.out.println("Random double: " + myDouble);

		// Generates a random float
		float myFloat = random.nextFloat();
		System.out.println("Random float: " + myFloat);

		// Generates a random Gaussian double
		// mean 0.0 and standard deviation 1.0 
		// from this random number generator's sequence.
		double gausDouble = random.nextGaussian();
		System.out.println("Random Gaussian double: " + gausDouble);
		// Generates a random Long
		long myLong = random.nextLong();
		System.out.println("Random long: " + myLong);
		// Generates a random boolean
		boolean myBoolean = random.nextBoolean();
		System.out.println("Random boolean: " + myBoolean);
		
		// Generates a random double in Math
		double rand = Math.random();
		System.out.println("Random double Math: " + rand);


	}
}

package org.java17recipes.chapter02.recipe02_08;
 
import java.util.random.RandomGenerator;
import java.util.Random;

public class UseNewPRNGs implements RandomGenerator {
	static UseNewPRNGs testGen = new UseNewPRNGs();
	public static void main(String[] args){ 
		 
		 for (int i = 0; i < 5; i++) {
			System.out.println(testGen.nextBoolean());
			System.out.println(testGen.nextDouble());
			System.out.println(testGen.nextInt());
			System.out.println(testGen.nextLong());
		}
 
	}
	/** Returns the next pseudo-random, uniformly distributed {@code long} value from this random number generator's sequence.
	 * <p>
	 * Subclasses should override this, as this is used by all other methods. */
	@Override
	public long nextLong() {  
		//Returns a pseudorandomly chosen long value.
		Random r= new Random();
		return r.nextLong();
		//return 0;
	}
}

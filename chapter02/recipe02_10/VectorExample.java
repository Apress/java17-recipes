import jdk.incubator.vector.*;

public class VectorExample { 

	public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4};
        int[] b = {5, 6, 7, 8};
        int[] c = {0, 0, 0, 0};
        VectorExample.nonVectorSumInt(a, b, c);
		System.out.println("nonVectorSumInt");
        for (int i = 0; i < c.length; i++) {			
        	System.out.println(c[i]);
        } 
         
        VectorExample.vectorSumInt(a, b, c);
		System.out.println("vectorSumInt");
        for (int i = 0; i < c.length; i++) {        	
			System.out.println(c[i]);
        } 
        
    }
	
	static void nonVectorSumInt(int[] arrayOne, int[] arrayTwo, int[] s) {
		for (int i = 0; i < arrayOne.length; i++) {
			s[i] = (arrayOne[i]  +  arrayTwo[i]) ;
		}
	}
	//A preferred species is a species of maximal bit-size for the platform
	static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED; 

	static void vectorSumInt(int[] arrayOne, int[] arrayTwo, int[] s) {
		int i = 0;
		int upperBound = SPECIES.loopBound(arrayOne.length);
		for (; i < upperBound; i += SPECIES.length()) {

			var vIntaOne = IntVector.fromArray(SPECIES, arrayOne, i);
			var vIntaTwo = IntVector.fromArray(SPECIES, arrayTwo, i);
			var vs = vIntaOne.add(vIntaTwo);
			vs.intoArray(s, i);
		}
	}

}
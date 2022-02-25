package org.java17recipes.chapter03.recipe03_02;

public class StringExamples {


	public static void main(String[] args){

		compareStrings();

	}

	public static void compareStrings(){
		String one = "one";
		String two = "two";

		String var1 = "one";
		String var2 = "Two";

		String pieceone = "o";
		String piecetwo = "ne";

		if (one.equals(var1)){
			System.out.println ("String one equals var1 using equals");
		}

		if (one.equals(two)){
			System.out.println ("String one equals two using equals");
		}

		if (two.equals(var2)){
			System.out.println ("String two equals var2 using equals");
		}

		if (one == var1){
			System.out.println ("String one equals var1 using ==");
		}

		if (two.equalsIgnoreCase(var2)){
			System.out.println ("String two equals var2 using equalsIgnoreCase");
		}

		String piecedTogether = pieceone + piecetwo;

		if (one.equals(piecedTogether)){
			System.out.println("The strings contain the same value using equals");
		}

		if (one == piecedTogether) {
			System.out.println("The string contain the same value using == ");
		}

		if (one.compareTo(var1) == 0){
			System.out.println("One is equal to var1 using compareTo()");
		}

		if (one.compareToIgnoreCase(var1) == 0){
			System.out.println("One is equal to var1 using compareToIgnoreCase()");
		}

		System.out.println("Comparision Using regionMatches");

		String sentence = "Java 8 is great!";
		String matchStr = "great";
		for(int i=0; i <= sentence.length()-1; i++){
			if (sentence.regionMatches(i, matchStr, 0, matchStr.length())){
				System.out.println("The sentence: '" + sentence + "' matches: '" +
						matchStr + "' beginning at index: " + i);
			}
		}


	}


}

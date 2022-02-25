package org.java17recipes.chapter03.recipe03_13;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplace {

	public static void main(String[] args) {
		findAndReplaceWithPatterns();
	}


	public static void findAndReplaceWithPatterns() {

		String str = "I love Java 8!  It is my favorite language.  Java 8 is the "
				+ "8th version of this great programming language.";

		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(str);

		System.out.println("Original: " + str);
		System.out.println(matcher.matches());
		System.out.println("Replacement: " + matcher.replaceAll("17"));



	}
	
}

	

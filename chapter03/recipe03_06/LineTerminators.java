package org.java17recipes.chapter03.recipe03_06;

import java.util.stream.Stream;

public class LineTerminators {
	public static void main(String[] args) {
		String nameString = "Luciano \nManelli \nTaranto"; 
		Stream<String> stringStream = nameString.lines(); 
		stringStream.forEach(System.out::println);
	}

}

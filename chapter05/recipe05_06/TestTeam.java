package org.java17recipes.chapter05.recipe05_06;

public class TestTeam {

	public static void main(String[] args){
		TeamType team1 = new Team();
		// Since an object of TeamType has been created, we are only able
		// to call upon the methods that were made available via the
		// TeamType interface

		team1.getFullName();
	}
}


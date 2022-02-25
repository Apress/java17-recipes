package org.java17recipes.chapter05.recipe05_07;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTester {
	public static void main(String[] args){
		Player player1 = new HockeyPlayer();
		player1.setFirstName("Jonathan" );
		player1.setFirstName("Gennick");
		Player player2 = new HockeyPlayer();
		player2.setFirstName("Josh");
		player2.setLastName("Juneau");
		List<Player> playerList = new ArrayList();
		playerList.add(player1);
		playerList.add(player2);

		Team team = new Team();
		team.setPlayers(playerList);
		// Call the default method
		team.listPlayers();

	}
}


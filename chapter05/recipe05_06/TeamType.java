package org.java17recipes.chapter05.recipe05_06;

import java.util.List;

public interface TeamType {

	void setPlayers(List<Player> players);
	void setName(String name);
	void setCity(String city);
	String getFullName();

}


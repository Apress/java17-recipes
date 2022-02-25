package org.java17recipes.chapter06.recipe06_03;

@FunctionalInterface
public interface PlayerFactory {
    Player createPlayer(String position,
                        int status,
                        String firstName,
                        String lastName);
}

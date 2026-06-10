package com.example.game;

import java.util.HashSet;

public class Scoreboard {

    private final HashSet<Game> activeGames = new HashSet<>();

    public Game startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam, 0, 0, true);
        activeGames.add(game);
        return game;
    }

    HashSet<Game> getActiveGames() {
        return activeGames;
    }
}

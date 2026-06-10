package com.example.game;

public class GameHandler {

    public Game startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam, 0, 0, true);

        return game;
    }
}

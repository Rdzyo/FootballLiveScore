package com.example.game;

import java.util.HashSet;

import static com.example.game.Game.validateTeamNames;

public class Scoreboard {

    private final HashSet<Game> activeGames = new HashSet<>();

    Game startGame(String homeTeam, String awayTeam) {
        validateTeamNames(homeTeam, awayTeam);
        Game game = new Game(homeTeam, awayTeam, 0, 0);
        if(activeGames.contains(game)) {
            throw new IllegalStateException("Game with given teams is already live and tracked");
        }
        activeGames.add(game);
        return game;
    }

    HashSet<Game> getActiveGames() {
        return activeGames;
    }

    void finishGame(Game activeGame) {
        activeGames.remove(activeGame);
    }
}

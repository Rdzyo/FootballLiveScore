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

    void updateGame(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        validateTeamNames(homeTeam, awayTeam);
        activeGames.stream()
                .filter(game ->  game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(game -> game.updateScore(homeScore, awayScore));
    }

    HashSet<Game> getActiveGames() {
        return activeGames;
    }

    void finishGame(Game activeGame) {
        activeGames.remove(activeGame);
    }
}

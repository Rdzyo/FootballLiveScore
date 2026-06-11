package com.example.game;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.game.Game.isHomeTeamIsEqualToAwayTeam;
import static com.example.game.Game.validateTeamNames;

public class Scoreboard {

    private final ArrayList<Game> activeGames = new ArrayList<>();

    Game startGame(String homeTeam, String awayTeam) {
        validateTeamNames(homeTeam, awayTeam);
        if(isTeamCurrentlyPlaying(homeTeam, awayTeam)) {
            throw new IllegalStateException("Game with given teams is already live and tracked");
        }
        Game game = new Game(homeTeam, awayTeam, 0, 0, Instant.now());
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

    List<Game> getSummary() {
        return activeGames.stream()
                .sorted(Comparator.comparingInt(Game::sumHomeAndAwayTeamScore)
                        .thenComparing(Game::getStartTime).reversed())
                .toList();
    }

    void finishGame(Game activeGame) {
        activeGames.remove(activeGame);
    }

    private boolean isTeamCurrentlyPlaying(String homeTeam, String awayTeam) {
        if(activeGames.isEmpty()) {
            return false;
        } else {
            return activeGames.stream().anyMatch(game ->
                    isHomeTeamIsEqualToAwayTeam(game.getHomeTeam(), homeTeam) || isHomeTeamIsEqualToAwayTeam(game.getAwayTeam(), homeTeam)
                            || isHomeTeamIsEqualToAwayTeam(game.getAwayTeam(), awayTeam) || isHomeTeamIsEqualToAwayTeam(game.getHomeTeam(), awayTeam));
        }
    }
}

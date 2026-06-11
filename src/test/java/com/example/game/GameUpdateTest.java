package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameUpdateTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void updateGame_shouldUpdateScoreWhenReceivedGameData() {
        Game game = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        int updatedHomeScore = 1;
        int updatedAwayScore = 2;

        scoreboard.updateGame(TEST_HOME_TEAM, TEST_AWAY_TEAM, updatedHomeScore, updatedAwayScore);

        Assertions.assertEquals(updatedHomeScore, game.getHomeScore());
        Assertions.assertEquals(updatedAwayScore, game.getAwayScore());
    }

    @Test
    void updateGame_multipleGames_shouldUpdateCorrectGameFromActiveGames() {
        Game game1 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game game2 = scoreboard.startGame("Poland", "Malta");
        int updatedHomeScore = 1;
        int updatedAwayScore = 2;

        scoreboard.updateGame(TEST_HOME_TEAM, TEST_AWAY_TEAM, updatedHomeScore, updatedAwayScore);

        Assertions.assertEquals(updatedHomeScore, game1.getHomeScore());
        Assertions.assertEquals(updatedAwayScore, game1.getAwayScore());
        Assertions.assertEquals(0, game2.getHomeScore());
        Assertions.assertEquals(0, game2.getAwayScore());
    }

    @Test
    void updateGame_multipleGames_shouldUpdateCorrectGameWithSpaceInBetweenFromActiveGames() {
        Game game1 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game game2 = scoreboard.startGame("United States", "Malta");
        int updatedHomeScore = 1;
        int updatedAwayScore = 2;

        scoreboard.updateGame("United States", "Malta", updatedHomeScore, updatedAwayScore);

        Assertions.assertEquals(0, game1.getHomeScore());
        Assertions.assertEquals(0, game1.getAwayScore());
        Assertions.assertEquals(updatedHomeScore, game2.getHomeScore());
        Assertions.assertEquals(updatedAwayScore, game2.getAwayScore());
    }
}

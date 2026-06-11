package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameFinishTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void finishGame_shouldRemoveGameFromTheActiveGames() {
        var initSize = scoreboard.getActiveGames().size();

        Game activeGame = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        scoreboard.finishGame(activeGame);

        Assertions.assertEquals(initSize, scoreboard.getActiveGames().size());
    }

    @Test
    void finishGame_multipleGames_shouldRemoveCorrectGameFromActiveGames() {
        var initSize = scoreboard.getActiveGames().size();

        Game game1 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game game2 = scoreboard.startGame("Poland", "Malta");
        scoreboard.finishGame(game1);

        Assertions.assertEquals(initSize+1, scoreboard.getActiveGames().size());
        Assertions.assertTrue(scoreboard.getActiveGames().contains(game2));
        Assertions.assertFalse(scoreboard.getActiveGames().contains(game1));
    }
}

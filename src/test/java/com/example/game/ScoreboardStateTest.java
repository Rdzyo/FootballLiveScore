package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class ScoreboardStateTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void startGame_shouldAddGameToActiveGames() {
        int baseSize = scoreboard.getActiveGames().size();

        scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(baseSize+1, scoreboard.getActiveGames().size());
    }

    @Test
    void startGame_multipleGames_shouldTrackAllIndependently() {
        Game g1 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game g2 = scoreboard.startGame("Spain", "Brazil");

        Assertions.assertEquals(2, scoreboard.getActiveGames().size());
        Assertions.assertNotEquals(g1, g2);
        Assertions.assertEquals(0, g1.getHomeScore());
        Assertions.assertEquals(0, g2.getHomeScore());
    }

    @Test
    void startGame_shouldBeRetrievableFromScoreboard() {
        Game started = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertTrue(scoreboard.getActiveGames().contains(started));
    }
}

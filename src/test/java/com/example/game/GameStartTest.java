package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameStartTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void startGame_shouldCreateGameWithZeroZeroScore() {
        Game game = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(0, game.getHomeScore());
        Assertions.assertEquals(0, game.getAwayScore());
    }

    @Test
    void startGame_shouldCaptureHomeAndAwayTeamNames() {
        Game game = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(TEST_HOME_TEAM, game.getHomeTeam());
        Assertions.assertEquals(TEST_AWAY_TEAM, game.getAwayTeam());
    }

    @Test
    void startGame_shouldReturnNonNullGame() {
        Game game = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertNotNull(game);
    }
}

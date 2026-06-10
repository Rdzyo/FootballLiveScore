package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameStartTest {

    GameHandler gameHandler = new GameHandler();

    @Test
    void startGame_shouldCreateGameWithZeroZeroScore() {
        Game game = gameHandler.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(0, game.getHomeScore());
        Assertions.assertEquals(0, game.getAwayScore());
    }

    @Test
    void startGame_shouldCaptureHomeAndAwayTeamNames() {
        Game game = gameHandler.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(TEST_HOME_TEAM, game.getHomeTeam());
        Assertions.assertEquals(TEST_AWAY_TEAM, game.getAwayTeam());
    }

    @Test
    void startGame_shouldReturnNonNullGame() {
        Game game = gameHandler.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertNotNull(game);
    }

    @Test
    void startGame_shouldSetGameInProgressToTrue() {
        Game game = gameHandler.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertTrue(game.isInProgress());
    }
}

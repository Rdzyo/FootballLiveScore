package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameFinishValidationTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void finishGame_shouldNotThrowExceptionIfGameIsNotInActiveGames() {
        var nonExistentGame = new Game(TEST_HOME_TEAM, TEST_AWAY_TEAM, 1, 2, Instant.now());

        Assertions.assertDoesNotThrow(() -> scoreboard.finishGame(nonExistentGame));
    }
}

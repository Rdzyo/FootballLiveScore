package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class GameUpdateValidationTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void gameUpdate_nullHomeTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.updateGame(null, TEST_HOME_TEAM, 2, 3));
    }

    @Test
    void gameUpdate_nullAwayTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.updateGame(TEST_HOME_TEAM, null, 2, 3));
    }

    @Test
    void gameUpdate_emptyHomeTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("", TEST_AWAY_TEAM));
    }

    @Test
    void gameUpdate_emptyAwayTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, ""));
    }

}

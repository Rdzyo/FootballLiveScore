package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;


public class GameStartValidationTest {
    Scoreboard scoreboard = new Scoreboard();

    @Test
    void startGame_nullHomeTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(null, TEST_AWAY_TEAM));
    }

    @Test
    void startGame_nullAwayTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, null));
    }

    @Test
    void startGame_emptyHomeTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("", TEST_AWAY_TEAM));
    }

    @Test
    void startGame_emptyAwayTeam_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, ""));
    }

    @Test
    void startGame_sameTeamNames_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, TEST_HOME_TEAM));
    }

    @Test
    void startGame_sameTeamName_shouldThrowException() {
        scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM));
    }
}
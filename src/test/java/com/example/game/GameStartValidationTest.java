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
    void startGame_sameTeamNameWithSpaceBetween_shouldThrowException() {
        var teamWithSpaceBetween = "United States";
        var sameTeamNameWithoutSpace = "UnitedStates";
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(teamWithSpaceBetween, sameTeamNameWithoutSpace));
    }

    @Test
    void startGame_sameTeamNameWithMultipleSpacesBetween_shouldThrowException() {
        var teamWithSpacesBetween = "Republic of South Africa";
        var sameTeamNameWithoutSpaces = "RepublicofSouthAfrica";
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(teamWithSpacesBetween, sameTeamNameWithoutSpaces));
    }

    @Test
    void startGame_gameAlreadyActive_shouldThrowException() {
        scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM));
    }

    @Test
    void startGame_teamNameWithLeadingSpace_shouldThrowException() {
        var teamNameWithLeadingSpace = "    " + "United States";
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(teamNameWithLeadingSpace, TEST_AWAY_TEAM));
    }

    @Test
    void startGame_teamNameWithTrailingSpace_shouldThrowException() {
        var teamNameWithTrailingSpace = "United States" + "    ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(teamNameWithTrailingSpace, TEST_AWAY_TEAM));
    }
}
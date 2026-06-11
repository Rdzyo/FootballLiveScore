package com.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.game.GameTestUtils.TEST_AWAY_TEAM;
import static com.example.game.GameTestUtils.TEST_HOME_TEAM;

public class ScoreboardStateTest {

    Scoreboard scoreboard = new Scoreboard();

    @Test
    void startGame_shouldAddGameToActiveGames() {
        int baseSize = scoreboard.getSummary().size();

        scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertEquals(baseSize+1, scoreboard.getSummary().size());
    }

    @Test
    void startGame_multipleGames_shouldTrackAllIndependently() {
        Game g1 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game g2 = scoreboard.startGame("Spain", "Brazil");

        Assertions.assertEquals(2, scoreboard.getSummary().size());
        Assertions.assertNotEquals(g1, g2);
        Assertions.assertEquals(0, g1.getHomeScore());
        Assertions.assertEquals(0, g2.getHomeScore());
    }

    @Test
    void startGame_shouldBeRetrievableFromScoreboard() {
        Game started = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);

        Assertions.assertTrue(scoreboard.getSummary().contains(started));
    }

    @Test
    void showSummary_shouldReturnOrderedMatchesFromActiveGames() {
        Game game1 = scoreboard.startGame("Argentina", "Australia");
        Game game2 = scoreboard.startGame(TEST_HOME_TEAM, TEST_AWAY_TEAM);
        Game game3 = scoreboard.startGame("Germany", "France");
        Game game4 = scoreboard.startGame("Spain", "Brazil");
        Game game5 = scoreboard.startGame("Mexico", "Canada");

        scoreboard.updateGame(game1.getHomeTeam(), game1.getAwayTeam(), 3, 1);
        scoreboard.updateGame(game2.getHomeTeam(), game2.getAwayTeam(), 6, 6);
        scoreboard.updateGame(game3.getHomeTeam(), game3.getAwayTeam(), 2, 2);
        scoreboard.updateGame(game4.getHomeTeam(), game4.getAwayTeam(), 10, 2);
        scoreboard.updateGame(game5.getHomeTeam(), game5.getAwayTeam(), 0, 5);

        var expectedSortedSummary = List.of(game2, game4, game5, game1, game3);

        Assertions.assertEquals(expectedSortedSummary.size(), scoreboard.getSummary().size());
        for (int i = 0; i < expectedSortedSummary.size(); i++) {
            Assertions.assertEquals(expectedSortedSummary.get(i), scoreboard.getSummary().get(i));
        }
    }
}

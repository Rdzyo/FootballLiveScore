package com.example.game;

import java.time.Instant;
import java.util.Objects;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore, awayScore;
    private final Instant startTime;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore, Instant startTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.startTime = startTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }
    public Instant getStartTime() { return startTime; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    static void validateTeamNames(String homeTeam, String awayTeam) {
        if(isTeamNameIsNullOrBlank(homeTeam) || isTeamNameIsNullOrBlank(awayTeam)) {
            throw new IllegalArgumentException("Team names cannot be null or blank");
        }
        if(isTeamHasSpecialCharactersOrDigits(homeTeam) || isTeamHasSpecialCharactersOrDigits(awayTeam)) {
            throw new IllegalArgumentException("Team names cannot have special characters or digits");
        }
        if(isTeamNameHasLeadingOrTrailingSpace(homeTeam) || isTeamNameHasLeadingOrTrailingSpace(awayTeam)) {
            throw new IllegalArgumentException("Team names cannot have leading or trailing space");
        }
        if(isHomeTeamIsEqualToAwayTeam(homeTeam, awayTeam)) {
            throw new IllegalArgumentException("Team names cannot be equal in the same match");
        }
    }

    private static boolean isTeamNameIsNullOrBlank(String teamName) {
        return teamName == null || teamName.isBlank();
    }

    private static boolean isHomeTeamIsEqualToAwayTeam(String homeTeam, String awayTeam) {
        return homeTeam.replace(" ", "").equalsIgnoreCase(awayTeam.replace(" ", ""));
    }

    private static boolean isTeamNameHasLeadingOrTrailingSpace(String teamName) {
        return (teamName.length() > 1 && teamName.charAt(0) == ' ') || (teamName.length() > 1 && teamName.charAt(teamName.length() - 1) == ' ');
    }

    private static boolean isTeamHasSpecialCharactersOrDigits(String teamName) {
        return !teamName.chars().allMatch(ch -> ch == ' ' || Character.isLetter(ch));
    }

    int sumHomeAndAwayTeamScore() {
        return this.homeScore + this.awayScore;
    }
}

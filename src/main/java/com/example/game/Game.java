package com.example.game;

import java.util.Objects;

public class Game {
    private String homeTeam, awayTeam;
    private int homeScore, awayScore;
    private boolean inProgress;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

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

    static void validateTeamNames(String homeTeam, String awayTeam) {
        if(isTeamNameIsNullOrBlank(homeTeam) || isTeamNameIsNullOrBlank(awayTeam)) {
            throw new IllegalArgumentException("Team names cannot be null or blank");
        }
        if(isHomeTeamIsEqualToAwayTeam(homeTeam, awayTeam)) {
            throw new IllegalArgumentException("Team names cannot be equal in the same match");
        }
    }

    private static boolean isTeamNameIsNullOrBlank(String teamName) {
        return teamName == null || teamName.isBlank();
    }

    private static boolean isHomeTeamIsEqualToAwayTeam(String homeTeam, String awayTeam) {
        return homeTeam.equals(awayTeam);
    }


}

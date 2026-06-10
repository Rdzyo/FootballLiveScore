package com.example.game;

public class Game {
    private String homeTeam, awayTeam;
    private int homeScore, awayScore;
    private boolean inProgress;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore, boolean inProgress) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.inProgress = inProgress;
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

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

// Class for creating a fantasy team
public class FantasyTeam {
    private String user;
    private List<Player> fantasyTeam;
    private int totalPoints;
    private int totalRebounds;
    private int totalAssists;
    private int totalSteals;
    private int totalBlocks;
//    private int totalWins;
//    private int totalLosses;
//    private int totalDraws;
    private int teamMatchScore;
    private int teamTotalScore;

    // EFFECTS: Creates a fantasy team for the user
    public FantasyTeam(String user) {
        this.user = user;
        this.fantasyTeam = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Drafts player onto users fantasy team
    public void draftPlayer(Player player) {
        this.fantasyTeam.add(player);
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalRebounds(int totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public void setTotalSteals(int totalSteals) {
        this.totalSteals = totalSteals;
    }

    public void setTotalBlocks(int totalBlocks) {
        this.totalBlocks = totalBlocks;
    }

    // this is the team score for right after a match ends,
    // used to determine which team had a higher score
    public void setTeamMatchScore() {
        this.teamMatchScore = this.totalPoints + this.totalRebounds + this.totalAssists + this.totalSteals
                + this.totalBlocks;
        setTeamTotalScore();
    }

    // this should be += instead of = because I want to accumulate what a team's total team score is after
    // many matches
    public void setTeamTotalScore() {
        this.teamTotalScore += this.teamMatchScore;
    }

//    // EFFECTS: increments total number of wins the team has
//    public void incrementTotalWins() {
//        ++this.totalWins;
//    }
//
//    // EFFECTS: increments total amount of losses the team has
//    public void incrementTotalLosses() {
//        ++this.totalLosses;
//    }
//
//    // EFFECTS: increments the total amount of draws (ties) the team has
//    public void incrementTotalDraws() {
//        ++this.totalDraws;
//    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public int getTotalRebounds() {
        return this.totalRebounds;
    }

    public int getTotalAssists() {
        return this.totalAssists;
    }

    public int getTotalSteals() {
        return this.totalSteals;
    }

    public int getTotalBlocks() {
        return this.totalBlocks;
    }

//    public int getTotalWins() {
//        return this.totalWins;
//    }
//
//    public int getTotalLosses() {
//        return this.totalLosses;
//    }
//
//    public int getTotalDraws() {
//        return this.totalDraws;
//    }

    public int getTeamMatchScore() {
        return this.teamMatchScore;
    }

    public int getTeamTotalScore() {
        return this.teamTotalScore;
    }

    public String getUser() {
        return this.user;
    }

    public List<Player> getFantasyTeam() {
        return this.fantasyTeam;
    }
}

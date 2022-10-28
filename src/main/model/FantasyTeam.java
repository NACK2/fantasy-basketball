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

    /*
    // REQUIRES: the player is in the users fantasy team
    // MODIFIES: this
    // EFFECTS: Kicks player from the users fantasy team
    public void removePlayer(Player player) {
        this.fantasyTeam.remove(player);
    }
    */

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

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalRebounds() {
        return totalRebounds;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalSteals() {
        return totalSteals;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public String getUser() {
        return this.user;
    }

    public List<Player> getFantasyTeam() {
        return this.fantasyTeam;
    }
}

package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;
import java.util.List;

// Class for creating a fantasy team
public class FantasyTeam implements Writeable {
    private String user;
    private List<Player> fantasyTeam;
    private int totalPoints;
    private int totalRebounds;
    private int totalAssists;
    private int totalSteals;
    private int totalBlocks;
    private int teamMatchScore;
    private int teamTotalScore;

    // EFFECTS: Creates a fantasy team for the user
    public FantasyTeam(String user) {
        this.user = user;
        EventLog.getInstance().logEvent(new Event("A fantasy team was created, a user "
                + "was set as owner of the fantasy team."));
        this.fantasyTeam = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Drafts player onto users fantasy team
    public void draftPlayer(Player player) {
        this.fantasyTeam.add(player);
        EventLog.getInstance().logEvent(new Event("A player was drafted to a fantasy team"));
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Username", this.user);
        json.put("Players", playersToJson());
        json.put("Total points", this.totalPoints);
        json.put("Total rebounds", this.totalRebounds);
        json.put("Total assists", this.totalAssists);
        json.put("Total steals", this.totalSteals);
        json.put("Total blocks", this.totalBlocks);
        json.put("Team match score", this.teamMatchScore);
        json.put("Team total score", this.teamTotalScore);
        return json;
    }

    // EFFECTS: returns things in players as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : fantasyTeam) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}

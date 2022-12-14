package model;

import org.json.JSONObject;
import persistence.Writeable;

// Class for creating one player
public class Player implements Writeable {
    private String name;
    private String team;
    private String position;
    private String height;
    private String weight;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;

    // EFFECTS: Creates an empty player
    public Player() {

    }

    // EFFECTS: Checks if player has already been drafted by another user
    public boolean checkPlayerExists(String playerName, AllPlayers allPlayers) {
        for (Player p : allPlayers.getPlayers()) {
            if (p.getName().equalsIgnoreCase(playerName)) {
                return true;
            }
        }

        return false;
    }

    // MODIFIES: this
    // EFFECTS: Creates player
    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // REQUIRES: Height > 0 in centimetres
    public void setHeight(String height) {
        this.height = height;
    }

    // REQUIRES: Weight > 0 in kilograms
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPoints() {
        return this.points;
    }

    public int getRebounds() {
        return this.rebounds;
    }

    public int getAssists() {
        return this.assists;
    }

    public int getSteals() {
        return this.steals;
    }

    public int getBlocks() {
        return this.blocks;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public String getPosition() {
        return this.position;
    }

    public String getHeight() {
        return this.height;
    }

    public String getWeight() {
        return this.weight;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Player name", this.name);
        return json;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

// Class for creating a fantasy team
public class FantasyTeam {
    private String user;
    private List<Player> fantasyTeam;

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

    // REQUIRES: the player is in the users fantasy team
    // MODIFIES: this
    // EFFECTS: Kicks player from the users fantasy team
    public void removePlayer(Player player) {
        this.fantasyTeam.remove(player);
    }

    public String getUser() {
        return this.user;
    }

    public List<Player> getFantasyTeam() {
        return this.fantasyTeam;
    }
}

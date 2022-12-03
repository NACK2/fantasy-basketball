package model;

import java.util.ArrayList;
import java.util.List;

// Class for creating a list of all players created by every user
public class AllPlayers {
    private List<Player> players;

    // EFFECTS: Creates list for all players, list is empty
    public AllPlayers() {
        players = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Adds player onto the list of all players
    public void addPlayer(Player player) {
        players.add(player);
        // EventLog.getInstance().logEvent(new Event("A player was added to a list containing all the players."));
    }

    // MODIFIES: this
    // EFFECTS: returns list of all players
    public List<Player> getPlayers() {
        return this.players;
    }
}

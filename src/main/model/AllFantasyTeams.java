package model;

import java.util.ArrayList;
import java.util.List;

// Class for storing every fantasy team created by the users
public class AllFantasyTeams {
    private List<FantasyTeam> allFantasyTeams;

    // EFFECTS: Creates list for everyones fantasy team
    public AllFantasyTeams() {
        allFantasyTeams = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds fantasy team to list of all fantasy teams
    public void addTeam(FantasyTeam team) {
        allFantasyTeams.add(team);
    }

    public List<FantasyTeam> getTeams() {
        return this.allFantasyTeams;
    }

    // EFFECTS: Returns the fantasy team that the user owns
    public FantasyTeam getUsersFantasyTeam(String user) {
        for (FantasyTeam f : allFantasyTeams) {
            if (f.getUser().equalsIgnoreCase(user)) {
                return f;
            }
        }

        return null;
    }

    // EFFECTS: If user with the correct username owns a fantasy team, return true, else return false
    public boolean userExists(String user) {
        for (FantasyTeam f : allFantasyTeams) {
            if (f.getUser().equalsIgnoreCase(user)) {
                return true;
            }
        }

        return false;
    }
}

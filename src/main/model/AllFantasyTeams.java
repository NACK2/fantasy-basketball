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

    // EFFECTS: Displays all the players in every fantasy team
    public void printAllTeams() {
        int i = 1;
        for (FantasyTeam f : allFantasyTeams) {
            System.out.println("User " + i + "'s team: ");
            for (Player p : f.getFantasyTeam()) {
                System.out.println(p.getName());
            }
            System.out.println("-=-=-=-=-=-=-=-=-");
            ++i;
        }
    }

    // EFFECTS: Displays every users name
    public void printUsers() {
        for (FantasyTeam f : allFantasyTeams) {
            System.out.println(f.getUser());
        }
    }

    public List<FantasyTeam> getTeams() {
        return this.allFantasyTeams;
    }
}

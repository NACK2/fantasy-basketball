package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;
import java.util.List;

// Class for storing every fantasy team created by the users
public class AllFantasyTeams implements Writeable {
    private List<FantasyTeam> allFantasyTeams;

    // EFFECTS: Creates list for everyones fantasy team
    public AllFantasyTeams() {
        allFantasyTeams = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds fantasy team to list of all fantasy teams
    public void addTeam(FantasyTeam team) {
        allFantasyTeams.add(team);
//        EventLog.getInstance().logEvent(new Event("A fantasy team was added to a list containing "
//                + "all the fantasy teams."));
    }

    public List<FantasyTeam> getTeams() {
        return this.allFantasyTeams;
    }

    // EFFECTS: Returns the fantasy team that the user owns, it user doesn't own a team, returns null
    public FantasyTeam getUsersFantasyTeam(String user) {
        for (FantasyTeam f : allFantasyTeams) {
            if (f.getUser().equalsIgnoreCase(user)) {
                return f;
            }
        }

        return null;
    }

    // EFFECTS: If a person with the username of user owns a fantasy team, return true, else return false
    public boolean userExists(String user) {
        for (FantasyTeam f : allFantasyTeams) {
            if (f.getUser().equalsIgnoreCase(user)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("All Fantasy Teams", fantasyTeamsToJson());
        return json;
    }

    // EFFECTS: returns things in AllFantasyTeams as a JSON array
    private JSONArray fantasyTeamsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (FantasyTeam f : allFantasyTeams) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }
}

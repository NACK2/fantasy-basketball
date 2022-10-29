package persistence;

import model.AllFantasyTeams;
import model.FantasyTeam;
import model.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads allFantasyTeams from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AllFantasyTeams read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAllFantasyTeams(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses allFantasyTeams from JSON object and returns it
    private AllFantasyTeams parseAllFantasyTeams(JSONObject jsonObject) {
        AllFantasyTeams allFantasyTeams = new AllFantasyTeams();
        addFantasyTeams(allFantasyTeams, jsonObject);
        return allFantasyTeams;
    }

    // MODIFIES: allFantasyTeams
    // EFFECTS: parses fantasyTeams from JSON object and adds them to allFantasyTeams
    private void addFantasyTeams(AllFantasyTeams allFantasyTeams, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("All Fantasy Teams");
        for (Object json : jsonArray) {
            JSONObject nextFantasyTeam = (JSONObject) json;
            addFantasyTeam(allFantasyTeams, nextFantasyTeam);
        }
    }

    // MODIFIES: allFantasyTeams
    // EFFECTS: parses fantasyTeam from JSON object and adds it to allFantasyTeams
    private void addFantasyTeam(AllFantasyTeams allFantasyTeams, JSONObject jsonObject) {
        String name = jsonObject.getString("Username");
        int points = jsonObject.getInt("Total points");
        int rebounds = jsonObject.getInt("Total rebounds");
        int assists = jsonObject.getInt("Total assists");
        int steals = jsonObject.getInt("Total steals");
        int blocks = jsonObject.getInt("Total blocks");
        int teamMatchScore = jsonObject.getInt("Team match score");
        FantasyTeam fantasyTeam = new FantasyTeam(name);
        addPlayers(fantasyTeam, jsonObject);
        fantasyTeam.setTotalPoints(points);
        fantasyTeam.setTotalRebounds(rebounds);
        fantasyTeam.setTotalAssists(assists);
        fantasyTeam.setTotalSteals(steals);
        fantasyTeam.setTotalBlocks(blocks);
        fantasyTeam.setTeamMatchScore();
        allFantasyTeams.addTeam(fantasyTeam);
    }

    // MODIFIES: fantasyTeam
    // EFFECTS: parses players from JSON object and adds them to fantasyTeam
    private void addPlayers(FantasyTeam fantasyTeam, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(fantasyTeam, nextPlayer);
        }
    }

    // MODIFIES: fantasyTeam
    // EFFECTS: parses player from JSON object and adds it to fantasyTeam
    private void addPlayer(FantasyTeam fantasyTeam, JSONObject jsonObject) {
        String name = jsonObject.getString("Player name");
        Player player = new Player();
        player.setName(name);
        fantasyTeam.draftPlayer(player);
    }
}
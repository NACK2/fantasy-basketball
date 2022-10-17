package model;

// class for creating one player
public class Player {
    private String name;
    private String team;
    private String position;
    private double height;
    private double weight;

    // EFFECTS: Creates an empty player
    public Player() {

    }

    // EFFECTS: Checks if player has already been drafted by another user
    public boolean checkPlayer(String playerName, AllPlayers allPlayers) {
        for (Player p : allPlayers.getPlayers()) {
            if (p.getName().equalsIgnoreCase(playerName)) {
                return true;
            }
        }

        return false;
    }

    // EFFECTS: displays the players name, team, position, height, and weight
    public void printAllStats() {
        System.out.println("Player's Name: " + getName());
        System.out.println("Player's NBA team: " + getTeam());
        System.out.println("Player's Position: " + getPosition());
        System.out.println("Player's Height: " + getHeight() + " cm");
        System.out.println("Player's Weight: " + getWeight() + " kg");
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

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }
}

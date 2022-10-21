package ui;

import model.AllFantasyTeams;
import model.AllPlayers;
import model.FantasyTeam;
import model.Player;

import java.util.Scanner;

// Fantasy Basketball Application
public class FantasyBasketballApp {
    private Scanner input;
    private String userInput;
    private int numOfUsers;
    private Player tmpPlayer; // temporary player holder
    private AllFantasyTeams allFantasyTeams;
    private AllPlayers allPlayers;

    // EFFECTS: Runs the Fantasy Basketball Application
    public FantasyBasketballApp() {
        runFantasyBasketballApp();
    }

    // MODIFIES: this
    // EFFECTS: allows user input to happen
    public void initialize() {
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Processes user input
    public void runFantasyBasketballApp() {
        boolean keepGoing = true;

        initialize();

        while (keepGoing) {
            displayMenu();
            this.userInput = input.next();
            this.userInput = this.userInput.toLowerCase();

            if (this.userInput.equals("q")) {
                System.out.println("Goodbye!");
                keepGoing = false;
            } else if (this.userInput.equals("p")) {
                createUsers();
            } else {
                System.out.println("Error: Invalid input, please try again.");
                displayMenu();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates user profiles
    public void createUsers() {
        this.numOfUsers = 0;
        allFantasyTeams = new AllFantasyTeams();

        System.out.println("\nHow many users will be participating?");
        this.userInput = input.next();
        System.out.println();
        this.numOfUsers = Integer.parseInt(this.userInput); // converting numOfUsers from a string to an integer

        // Getting every user's name, then creating a fantasy team for them
        int i = 1;
        while (i <= this.numOfUsers) {
            System.out.println("What is user " + i + "'s username?");
            this.userInput = input.next();
            System.out.println("Welcome " + this.userInput + "!\n");

            this.allFantasyTeams.addTeam(new FantasyTeam(this.userInput));
            ++i;
        }

        System.out.println("The users are: ");
        printUsers();
        System.out.println();
        playerCreation();
    }

    // MODIFIES: this
    // EFFECTS: creates player
    public void playerCreation() {
        this.allPlayers = new AllPlayers();
        String playerName = "";
        boolean playerExists = false;
        int numOfUsersIndex = 0;
        int numOfPlayersDrafted = 1;
        System.out.println("Each user gets to draft 5 NBA players, starting with user 1!");

        while (numOfPlayersDrafted <= 5) { // loops 5 times for each user
            numOfUsersIndex = 1;
            while (numOfUsersIndex <= this.numOfUsers) {
                System.out.println("User " + numOfUsersIndex
                        + "! Please enter the " + "name of the NBA player you would like to draft: ");
                this.userInput = input.next();
                playerName = this.userInput;
                System.out.println();

                this.tmpPlayer = new Player();
                playerExists = this.tmpPlayer.checkPlayerExists(playerName, this.allPlayers);
                draftPlayers(playerExists, playerName, numOfUsersIndex);
                ++numOfUsersIndex;
            }
            ++numOfPlayersDrafted;
        }
        printAllTeams();
    }

    // MODIFIES: this
    // EFFECTS: Drafts players to users fantasy team
    public void draftPlayers(boolean playerExists, String playerName, int index) {
        while (playerExists) {
            System.out.println("Sorry, " + playerName + " has already been drafted! Please choose another player: ");
            this.userInput = input.next();
            playerName = this.userInput;
            System.out.println();
            playerExists = this.tmpPlayer.checkPlayerExists(playerName, this.allPlayers);
        }

        this.tmpPlayer.setName(playerName);
        assignTeam(this.tmpPlayer);
        assignPosition(this.tmpPlayer);
        assignHeight(this.tmpPlayer);
        assignWeight(this.tmpPlayer);

        System.out.println("\nSuccessfully drafted " + playerName + " to your fantasy team!");
        printAllStats(tmpPlayer);
        System.out.println();
        this.allPlayers.addPlayer(this.tmpPlayer);
        this.allFantasyTeams.getTeams().get(index - 1).draftPlayer(this.tmpPlayer);
    }

    public void assignTeam(Player player) {
        System.out.println("Please enter the players current team: ");
        this.userInput = input.next();
        player.setTeam(this.userInput);
    }

    public void assignPosition(Player player) {
        System.out.println("Please enter the players current position: ");
        this.userInput = input.next();
        player.setPosition(this.userInput);
    }

    public void assignHeight(Player player) {
        System.out.println("Please enter the players current height in centimetres: ");
        this.userInput = input.next();
        player.setHeight(Double.parseDouble(this.userInput));
    }

    public void assignWeight(Player player) {
        System.out.println("Please enter the players current weight in kilograms: ");
        this.userInput = input.next();
        player.setWeight(Double.parseDouble(this.userInput));
    }

    // EFFECTS: Displays all the players in every fantasy team
    public void printAllTeams() {
        int i = 1;
        for (FantasyTeam f : allFantasyTeams.getTeams()) {
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
        for (FantasyTeam f : allFantasyTeams.getTeams()) {
            System.out.println(f.getUser());
        }
    }

    // EFFECTS: displays the players name, team, position, height, and weight
    public void printAllStats(Player player) {
        System.out.println("Player's Name: " + player.getName());
        System.out.println("Player's NBA team: " + player.getTeam());
        System.out.println("Player's Position: " + player.getPosition());
        System.out.println("Player's Height: " + player.getHeight() + " cm");
        System.out.println("Player's Weight: " + player.getWeight() + " kg");
    }

    // EFFECTS: Display main menu
    public void displayMenu() {
        System.out.println("Welcome to Fantasy Basketball! Select one of the following:");
        System.out.println("\tp -> play");
        System.out.println("\tq -> quit");
    }
}

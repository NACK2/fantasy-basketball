package ui;

import model.AllFantasyTeams;
import model.AllPlayers;
import model.FantasyTeam;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Fantasy Basketball Application
public class FantasyBasketballApp {
    private static final String JSON_STORE = "./data/allFantasyTeamsFile.json";
    private Scanner input;
    private String userInput;
    private int numOfUsers;
    private Player tmpPlayer; // temporary player holder
    private AllFantasyTeams allFantasyTeams;
    private AllPlayers allPlayers;
    private String userOne;
    private String userTwo;
    private FantasyTeam userOneTeam;
    private FantasyTeam userTwoTeam;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: Runs the Fantasy Basketball Application
    public FantasyBasketballApp() {
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\n");
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);
        this.allFantasyTeams = new AllFantasyTeams();
        runFantasyBasketballApp();
    }

    // MODIFIES: this
    // EFFECTS: Processes user input
    public void runFantasyBasketballApp() {
        boolean keepGoing = true;

        while (keepGoing) {
            displayMainMenu();
            this.userInput = input.next().toLowerCase();

            if (this.userInput.equals("q")) {
                goodbyeMessage();
                keepGoing = false;
            } else if (this.userInput.equals("p")) {
                createUsers();
            } else if (this.userInput.equals("l")) {
                loadAllFantasyTeams();
            } else if (this.userInput.equals("f")) {
                printAllTeams();
            } else {
                System.out.println("Error: Invalid input, please try again.\n");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: loads all fantasy teams (and other stats) from file
    public void loadAllFantasyTeams() {
        try {
            this.allFantasyTeams = this.jsonReader.read();
            System.out.println("Loaded file from " + JSON_STORE + "\n");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE + "\n");
        }
    }

    // EFFECTS: saves all fantasy teams (and other stats) into file
    public void saveAllFantasyTeams() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.allFantasyTeams);
            this.jsonWriter.close();
            System.out.println("Saved file to " + JSON_STORE + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE + "\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates user profiles
    public void createUsers() {
        this.numOfUsers = 0;
        allFantasyTeams = new AllFantasyTeams();

        System.out.println("\nHow many users will be participating? (minimum 2)");
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
    // EFFECTS: starts the player creation
    public void playerCreation() {
        this.allPlayers = new AllPlayers();
        int numOfPlayersDrafted = 1;
        System.out.println("Each user gets to draft 5 NBA players, starting with user 1!");

        while (numOfPlayersDrafted <= 5) { // asks each user who they want to draft 5 times
            askUsersForPlayer();
            ++numOfPlayersDrafted;
        }
        printAllTeams();
        setUpGame();
    }

    // MODIFIES: this
    // EFFECTS: Asks the user to draft a player
    public void askUsersForPlayer() {
        int numOfUsersIndex = 1;
        String playerName = "";
        boolean playerExists = false;

        // while loop loops through the number of total users, so each user gets to draft one player
        // numOfUsersIndex = 1;
        while (numOfUsersIndex <= this.numOfUsers) {
            System.out.println("User " + numOfUsersIndex
                    + "! Please enter the name of the NBA player you would like to draft: ");
            this.userInput = input.next();
            playerName = this.userInput;
            System.out.println();

            this.tmpPlayer = new Player();
            playerExists = this.tmpPlayer.checkPlayerExists(playerName, this.allPlayers);
            draftPlayersToTeam(playerExists, playerName, numOfUsersIndex);
            ++numOfUsersIndex;
        }
    }

    // MODIFIES: this
    // EFFECTS: Drafts players to users fantasy team
    // if player has already been drafted, ask user to draft someone until they choose a player who hasn't been drafted
    public void draftPlayersToTeam(boolean playerExists, String playerName, int index) {
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
        printAllInfo(tmpPlayer);
        System.out.println();
        this.allPlayers.addPlayer(this.tmpPlayer);
        this.allFantasyTeams.getTeams().get(index - 1).draftPlayer(this.tmpPlayer);
    }

    // MODIFIES: this
    // EFFECTS: Displays rules of the game and asks for inputs
    public void setUpGame() {
        displayGameRules();
        setUpMatch();
    }

    // MODIFIES: this
    // EFFECTS: Asks two users to input their username, their respective teams will face off in a match
    public void setUpMatch() {
        while (true) {
            displayBeforeGame();
            System.out.println("Enter the usernames of two users who would like to face off!");
            System.out.println("First user: ");
            this.userOne = input.next().toLowerCase();
            if (!allFantasyTeams.userExists(this.userOne)) {
                System.out.println("ERROR: " + this.userOne + " is an invalid username\n");
                setUpMatch();
            }

            System.out.println("Second user: ");
            this.userTwo = input.next().toLowerCase();
            if (!allFantasyTeams.userExists(this.userTwo)) {
                System.out.println("ERROR: " + this.userTwo + " is an invalid username\n");
                setUpMatch();
            }
            this.userOneTeam = allFantasyTeams.getUsersFantasyTeam(this.userOne);
            this.userTwoTeam = allFantasyTeams.getUsersFantasyTeam(this.userTwo);
            playGame();
        }
    }

    // MODIFIES: this
    // EFFECTS: Starts match between two fantasy teams, calculates all stats for each player
    public void playGame() {
        System.out.println("\nOkay, here are the results of the match!");
        GameCalculations gameCalculations = new GameCalculations();
        gameCalculations.calculatePlayerPoints(this.userOneTeam);
        gameCalculations.calculatePlayerPoints(this.userTwoTeam);

        gameCalculations.calculatePlayerRebounds(this.userOneTeam);
        gameCalculations.calculatePlayerRebounds(this.userTwoTeam);

        gameCalculations.calculatePlayerAssists(this.userOneTeam);
        gameCalculations.calculatePlayerAssists(this.userTwoTeam);

        gameCalculations.calculatePlayerSteals(this.userOneTeam);
        gameCalculations.calculatePlayerSteals(this.userTwoTeam);

        gameCalculations.calculatePlayerBlocks(this.userOneTeam);
        gameCalculations.calculatePlayerBlocks(this.userTwoTeam);

        printGameStats(this.userOneTeam);
        printGameStats(this.userTwoTeam);
        printGameWinner();
    }

    // EFFECTS: Prints every players stats (points, rebounds, assists, etc.) and prints team score
    public void printGameStats(FantasyTeam fantasyTeam) {
        System.out.println("\n" + fantasyTeam.getUser() + "'s team: ");

        for (Player p : fantasyTeam.getFantasyTeam()) {
            System.out.println(p.getName() + ": " + p.getPoints() + " points, " + p.getRebounds() + " rebounds, "
                    + p.getAssists() + " assists, " + p.getSteals() + " steals, " + p.getBlocks() + " blocks");
        }

        fantasyTeam.setTeamMatchScore();
        System.out.println("Total team score: " + fantasyTeam.getTeamMatchScore() + " score");
    }

    // MODIFIES: fantasyTeamOne or fantasyTeamTwo depending on who wins/loses/draws
    // EFFECTS: Prints out the winning team (the team that accumulated more points)
    public void printGameWinner() {
        System.out.println();
        if (this.userOneTeam.getTeamMatchScore() > this.userTwoTeam.getTeamMatchScore()) {
            System.out.println("-=-=- " + this.userOneTeam.getUser() + "'s team has won! -=-=-");
//            this.userOneTeam.incrementTotalWins();
//            this.userTwoTeam.incrementTotalLosses();
        } else if (this.userTwoTeam.getTeamMatchScore() > this.userOneTeam.getTeamMatchScore()) {
            System.out.println("-=-=- " + this.userTwoTeam.getUser() + "'s team has won! -=-=-\n");
//            this.userTwoTeam.incrementTotalWins();
//            this.userOneTeam.incrementTotalLosses();
        } else {
            System.out.println("It's a draw! No winner or loser today!\n");
//            this.userOneTeam.incrementTotalDraws();
//            this.userTwoTeam.incrementTotalDraws();
        }
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
        player.setHeight(this.userInput);
    }

    public void assignWeight(Player player) {
        System.out.println("Please enter the players current weight in kilograms: ");
        this.userInput = input.next();
        player.setWeight(this.userInput);
    }

    // EFFECTS: Displays all the players in every fantasy team
    public void printAllTeams() {
        int i = 1;
        for (FantasyTeam f : allFantasyTeams.getTeams()) {
            System.out.println(f.getUser() + "'s team: ");
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
    public void printAllInfo(Player player) {
        System.out.println("Player's Name: " + player.getName());
        System.out.println("Player's NBA team: " + player.getTeam());
        System.out.println("Player's Position: " + player.getPosition());
        System.out.println("Player's Height: " + player.getHeight() + " cm");
        System.out.println("Player's Weight: " + player.getWeight() + " kg");
    }

    // EFFECTS: Display main menu
    public void displayMainMenu() {
        System.out.println("Welcome to Fantasy Basketball! Select one of the following:");
        System.out.println("\tp -> play");
        System.out.println("\tl -> load all fantasy teams from file");
        System.out.println("\tf -> print all fantasy teams");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: Displays the rules of the game
    public void displayGameRules() {
        System.out.println("Here are the rules of the fantasy basketball league!");
        System.out.println("Two users who wish to have a match may do so, and a team score is assigned to both "
                + "of these teams after the match ends.");
        System.out.println("A team score is calculated by the sum of the points, rebounds, assists, steals, and"
                + " blocks made by every player in a team.");
        System.out.println("The team with the higher team score will win the match!");
        System.out.println("At the end, the team which accumulated the highest team score will win the season! "
                + "Good luck and have fun!");
        System.out.println("\n-=-=-=-=-=-=-=-=-=-");
    }

    // EFFECTS: Displays before game menu, consists of save game and quit game
    public void displayBeforeGame() {
        System.out.println("Before moving on: ");
        System.out.println("Hit s to save!");
        System.out.println("Hit q to quit!");
        System.out.println("To go continue without saving, enter any key");

        this.userInput = input.next();
        this.userInput = this.userInput.toLowerCase();

        if (this.userInput.equals("s")) {
            saveAllFantasyTeams();
        } else if (this.userInput.equals("q")) {
            goodbyeMessage();
        } else {
            return;
        }
    }

    // EFFECTS: Dispalys a goodbye message and ends the program
    public void goodbyeMessage() {
        System.out.println("Thank you for playing the Fantasy Basketball App made by Nicholas Kang!");

        System.exit(0);
    }
}

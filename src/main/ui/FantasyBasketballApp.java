package ui;

import model.AllFantasyTeams;
import model.AllPlayers;
import model.FantasyTeam;
import model.Player;

import java.util.Random;
import java.util.Scanner;

// Fantasy Basketball Application
public class FantasyBasketballApp {
    private Scanner input;
    private String userInput;
    private int numOfUsers;
    private Player tmpPlayer; // temporary player holder
    private AllFantasyTeams allFantasyTeams;
    private AllPlayers allPlayers;
    private Random rand;
    private int randomNum;

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

        displayMainMenu();
        while (keepGoing) {
            this.userInput = input.next().toLowerCase();

            if (this.userInput.equals("q")) {
                System.out.println("Goodbye!");
                keepGoing = false;
            } else if (this.userInput.equals("p")) {
                createUsers();
            } else {
                System.out.println("Error: Invalid input, please try again.");
                displayMainMenu();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates user profiles
    public void createUsers() {
        this.numOfUsers = 0;
        allFantasyTeams = new AllFantasyTeams();

        System.out.println("\nHow many users will be participating (minimum 2)?");
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
        getUsersForGame();
    }

    // MODIFIES: this
    // EFFECTS: Asks the user to draft a player
    public void askUsersForPlayer() {
        int numOfUsersIndex = 0;
        String playerName = "";
        boolean playerExists = false;

        // while loop loops through the number of total users, so each user gets to draft one player
        numOfUsersIndex = 1;
        while (numOfUsersIndex <= this.numOfUsers) {
            System.out.println("User " + numOfUsersIndex
                    + "! Please enter the " + "name of the NBA player you would like to draft: ");
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
        printAllStats(tmpPlayer);
        System.out.println();
        this.allPlayers.addPlayer(this.tmpPlayer);
        this.allFantasyTeams.getTeams().get(index - 1).draftPlayer(this.tmpPlayer);
    }

    // MODIFIES: this
    // EFFECTS: Gets two users who will have their teams face off against each other
    public void getUsersForGame() {
        boolean keepGoing = true;

        while (keepGoing) {
            displayGameMenu();
            System.out.println("First user: ");
            String userOne = input.next().toLowerCase();
            if (userOne.equals("q")) {
                keepGoing = false;
            }

            System.out.println("Second user: ");
            String userTwo = input.next().toLowerCase();
            if (userTwo.equals("q")) {
                keepGoing = false;
            }

            System.out.println("Okay, good luck user " + userOne + " and user " + userTwo + "!");

            // Gets the user's fantasy team, Integer.parseInt(userOne) - 1 converts userOne from string to int,
            // then gets the user's associated fantasy team in list of all fantasy team  by doing - 1 to get the index
            FantasyTeam fantasyTeamOne = allFantasyTeams.getTeams().get(Integer.parseInt(userOne) - 1);
            FantasyTeam fantasyTeamTwo = allFantasyTeams.getTeams().get(Integer.parseInt(userTwo) - 1);
            playGame(fantasyTeamOne, fantasyTeamTwo);
        }
    }

    // MODIFIES: this
    // EFFECTS: Starts match between two fantasy teams, calculates all stats for each player
    public void playGame(FantasyTeam fantasyTeamOne, FantasyTeam fantasyTeamTwo) {
        this.rand = new Random();
        calculatePlayerPoints(fantasyTeamOne);
        calculatePlayerPoints(fantasyTeamTwo);
        calculateTeamPoints(fantasyTeamOne);
        calculateTeamPoints(fantasyTeamTwo);

        // DO THIS FOR REBOUNDS, ASSISTS, STEALS, BLOCKS, THEN DETERMINE WHICH TEAM WON
    }

    /*
   For calculatePoints():
   Random number generated will determine the range of numbers the points are generated from
   0-4 = 0 - 10 pts
   5-8 = 10 - 20 pts
   9-11 = 20 - 30 pts
   12-13 = 30 - 40 pts
   14 = 40 - 50 pts
    */

    // MODIFIES: this
    // EFFECTS: calculates the number of points a player had in a game, higher points are rarer to get
    public void calculatePlayerPoints(FantasyTeam fantasyTeam) {
        this.randomNum = this.rand.nextInt(15); // gets random int between 0 and 14 inclusive

        for (Player p : fantasyTeam.getFantasyTeam()) {
            if (this.randomNum <= 4) {
                p.setPoints(this.rand.nextInt(11));
            } else if (this.randomNum <= 8) {
                p.setPoints(this.rand.nextInt(21 - 10) + 10);
                // nextInt(21 - 10) means upper bound 21, lower bound 10
                // if I did nextInt(21) instead, then it would get random num between 0-20 instead of 10-20
            } else if (this.randomNum <= 11) {
                p.setPoints(this.rand.nextInt(31 - 20) + 10);
            } else if (this.randomNum <= 13) {
                p.setPoints(this.rand.nextInt(41 - 30) + 30);
            } else {
                p.setPoints(this.rand.nextInt(51 - 40) + 40);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Calculates total points scored by entire fantasy team
    public void calculateTeamPoints(FantasyTeam fantasyTeam) {
        int totalPoints = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalPoints += p.getPoints();
        }

        fantasyTeam.setTotalPoints(totalPoints);
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
    public void displayMainMenu() {
        System.out.println("Welcome to Fantasy Basketball! Select one of the following:");
        System.out.println("\tp -> play");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: Displays game menu
    public void displayGameMenu() {
        System.out.println();
        System.out.println("Enter the user numbers of two users who would like to face off!");
        System.out.println("Hit q to quit!");
    }
}

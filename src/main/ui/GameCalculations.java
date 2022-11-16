package ui;

import model.FantasyTeam;
import model.Player;

import java.util.Random;

// Class for storing all the calculations made for calculating a players game stats such as points, rebounds, etc.
public class GameCalculations {
    private int randomNum;
    private Random rand;

    public GameCalculations() {
        this.rand = new Random();
    }

    /*
   For calculatePlayerPoints():
   randomNum random number will be generated, that will determine the range of numbers the points are generated from
   0-4 = 0 - 10 pts
   5-8 = 10 - 20 pts
   9-11 = 20 - 30 pts
   12-13 = 30 - 40 pts
   14 = 40 - 50 pts
    */
    // MODIFIES: this
    // EFFECTS: calculates the number of points a player had in a game, higher points are rarer to get
    public void calculatePlayerPoints(FantasyTeam fantasyTeam) {
        // for each player in fantasy team, generates random number of points using the
        // diagram in the comments above this method
        for (Player p : fantasyTeam.getFantasyTeam()) {
            this.randomNum = this.rand.nextInt(15); // gets random int between 0 and 14 inclusive

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

        calculateTeamPoints(fantasyTeam);
    }

    // MODIFIES: this
    // EFFECTS: Calculates total sum of points scored by every player in fantasy team
    public void calculateTeamPoints(FantasyTeam fantasyTeam) {
        int totalPoints = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalPoints += p.getPoints();
        }

        fantasyTeam.setTotalPoints(totalPoints);
    }

    /*
   0-4 = 0 - 6 rebounds
   5-8 = 6 - 10 rebounds
   9-12 = 10 - 12 rebounds
   13-14 = 12 - 14 rebounds
   15 = 15 rebounds
    */
    // MODIFIES: this
    // EFFECTS: calculates the number of rebounds a player had in a game, higher amount of rebounds are rarer to get
    public void calculatePlayerRebounds(FantasyTeam fantasyTeam) {
        for (Player p : fantasyTeam.getFantasyTeam()) {
            this.randomNum = this.rand.nextInt(16);

            if (this.randomNum <= 4) {
                p.setRebounds(this.rand.nextInt(7));
            } else if (this.randomNum <= 8) {
                p.setRebounds(this.rand.nextInt(11 - 6) + 6);
            } else if (this.randomNum <= 12) {
                p.setRebounds(this.rand.nextInt(13 - 10) + 10);
            } else if (this.randomNum <= 14) {
                p.setRebounds(this.rand.nextInt(15 - 12) + 12);
            } else {
                p.setRebounds(15);
            }
        }

        calculateTeamRebounds(fantasyTeam);
    }

    // MODIFIES: this
    // EFFECTS: Calculates total sum of rebounds achieved by every player in fantasy team
    public void calculateTeamRebounds(FantasyTeam fantasyTeam) {
        int totalRebounds = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalRebounds += p.getRebounds();
        }

        fantasyTeam.setTotalRebounds(totalRebounds);
    }

    /*
   0-5 = 0 - 6 assists
   6-10 = 6 - 8 assists
   11-13 = 9 - 11 assists
   14-15 = 12 - 13 assists
    */
    // MODIFIES: this
    // EFFECTS: calculates the number of assists a player had in a game, higher amount of assists are rarer to get
    public void calculatePlayerAssists(FantasyTeam fantasyTeam) {
        for (Player p : fantasyTeam.getFantasyTeam()) {
            this.randomNum = this.rand.nextInt(16);

            if (this.randomNum <= 5) {
                p.setAssists(this.rand.nextInt(6));
            } else if (this.randomNum <= 10) {
                p.setAssists(this.rand.nextInt(9 - 6) + 6);
            } else if (this.randomNum <= 13) {
                p.setAssists(this.rand.nextInt(12 - 9) + 9);
            } else {
                p.setAssists(this.rand.nextInt(14 - 12) + 12);
            }
        }

        calculateTeamAssists(fantasyTeam);
    }

    // MODIFIES: this
    // EFFECTS: Calculates total sum of assists achieved by every player in fantasy team
    public void calculateTeamAssists(FantasyTeam fantasyTeam) {
        int totalAssists = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalAssists += p.getAssists();
        }

        fantasyTeam.setTotalAssists(totalAssists);
    }

    /*
     0-5 = 0 - 1 steals
     6-7 = 2 - 3 steals
     8 = 4 steals
     9 = 5 steals
    */
    // MODIFIES: this
    // EFFECTS: calculates the number of steals a player had in a game, higher amount of assists are rarer to get
    public void calculatePlayerSteals(FantasyTeam fantasyTeam) {
        for (Player p : fantasyTeam.getFantasyTeam()) {
            this.randomNum = this.rand.nextInt(10);

            if (this.randomNum <= 5) {
                p.setSteals(this.rand.nextInt(2));
            } else if (this.randomNum <= 7) {
                p.setSteals(this.rand.nextInt(4 - 2) + 2);
            } else if (this.randomNum == 8) {
                p.setSteals(4);
            } else {
                p.setSteals(5);
            }
        }

        calculateTeamSteals(fantasyTeam);
    }

    // MODIFIES: this
    // EFFECTS: Calculates total sum of steals achieved by every player in fantasy team
    public void calculateTeamSteals(FantasyTeam fantasyTeam) {
        int totalSteals = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalSteals += p.getSteals();
        }

        fantasyTeam.setTotalSteals(totalSteals);
    }

    /*
     0-5 = 0 - 1 blocks
     6-7 = 2 - 3 blocks
     8 = 4 blocks
     9 = 5 blocks
    */
    // MODIFIES: this
    // EFFECTS: calculates the number of blocks a player had in a game, higher amount of assists are rarer to get
    public void calculatePlayerBlocks(FantasyTeam fantasyTeam) {
        for (Player p : fantasyTeam.getFantasyTeam()) {
            this.randomNum = this.rand.nextInt(10);

            if (this.randomNum <= 5) {
                p.setBlocks(this.rand.nextInt(2));
            } else if (this.randomNum <= 7) {
                p.setBlocks(this.rand.nextInt(4 - 2) + 2);
            } else if (this.randomNum == 8) {
                p.setBlocks(4);
            } else {
                p.setBlocks(5);
            }
        }

        calculateTeamBlocks(fantasyTeam);
    }

    // MODIFIES: this
    // EFFECTS: Calculates total sum of steals achieved by every player in fantasy team
    public void calculateTeamBlocks(FantasyTeam fantasyTeam) {
        int totalBlocks = 0;
        for (Player p : fantasyTeam.getFantasyTeam()) {
            totalBlocks += p.getBlocks();
        }

        fantasyTeam.setTotalBlocks(totalBlocks);
    }
}

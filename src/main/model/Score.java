package model;

import java.util.Random;

// Class for calculated score awarded to player (based off points, rebounds, steals, etc.)
// Note: rand.nextInt(upperbound) gets a random integer from the range 0 to upperbound-1 inclusive
public class Score {
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private Random rand;
    private int randomNum;
    //private int totalScore;

    public Score() {
        this.rand = new Random();
        //calculatePoints();
    }

    /*
    Random number generated will determine the range of numbers the points are generated from
    0-4 = 0 - 10 pts
    5-8 = 10 - 20 pts
    9-11 = 20 - 30 pts
    12-13 = 30 - 40 pts
    14 = 40 - 50 pts
     */
    // MODIFIES: this
    // EFFECTS: calculates the number of points a player had in a game, higher points are rarer to get
    /*public void calculatePoints() {
        this.randomNum = this.rand.nextInt(15); // gets random int between 0 and 14 inclusive

        if (this.randomNum <= 4) {
            this.points = this.rand.nextInt(11);
        } else if (this.randomNum <= 8) {
            this.points = this.rand.nextInt(21 - 10) + 10;
            // nextInt(21 - 10) means upper bound 21, lower bound 10
            // if I did nextInt(21) instead, then it would get random num between 0-20 instead of 10-20
        } else if (this.randomNum <= 11) {
            this.points = this.rand.nextInt(31 - 20) + 10;
        } else if (this.randomNum <= 13) {
            this.points = this.rand.nextInt(41 - 30) + 30;
        } else {
            this.points = this.rand.nextInt(51 - 40) + 40;
        }
    }*/

    /*
    0-4 = 0 - 6 rebounds
    5-8 = 6 - 10 rebounds
    9-12 = 10 - 12 rebounds
    13-14 = 12 - 14 rebounds
    15 = 15 rebounds
     */
    // MODIFIES: this
    // EFFECTS: calculates the number of rebounds a player had in a game, higher amount of rebounds are rarer to get
    public void calculateRebounds() {
        this.randomNum = this.rand.nextInt(16);

        if (this.randomNum <= 4) {
            this.rebounds = this.rand.nextInt(7);
        } else if (this.randomNum <= 8) {
            this.rebounds = this.rand.nextInt(11 - 6) + 6;
        } else if (this.randomNum <= 12) {
            this.rebounds = this.rand.nextInt(13 - 10) + 10;
        } else if (this.randomNum <= 14) {
            this.rebounds = this.rand.nextInt(15 - 12) + 12;
        } else {
            this.rebounds = 15;
        }
    }

    public int getScore() {
        // this.totalScore = this.points + this.rebounds + this.assists + this.steals + this.blocks;
        return this.points + this.rebounds + this.assists + this.steals + this.blocks;
    }
}

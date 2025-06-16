package models;

//This class is responsible for creating players for the board game
// and houses information specific to each player.
public class Player {
    private final String name;
    private int score; //individual score

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

package ui;

//This class is responsible for the actual game pieces put on our game board.
//Examples include Xs, Os, Pawns, etc.

public class GamePiece {
    //Name will be used to signify what it is (Ex. X, O, Pawn)
    private final String name;
    private final String colorCode;

    public GamePiece(String name) {
        this.name = name;
        this.colorCode = "\u001B[37m";
    }

    public GamePiece(String name, String colorCode) {
        this.name = name;
        this.colorCode = colorCode;
    }

    public String getName() {
        return this.name;
    }

    public String getColorCode() {
        return colorCode;
    }

}

package models;

import java.util.*;
import ui.GamePiece;

//This class is responsible for adding players to teams and stores relevant information about each team.
// This class is also responsible for allowing chosen players from each team
// to be different during new rounds of a game.
public class Team {

    private final String TeamName;
    private List<GamePiece> symbols;
    private int teamScore = 0;
    private final List<Player> players = new ArrayList<>();

    public Team(String teamName, List<GamePiece> symbols) {
        this.TeamName = teamName;
        this.symbols = symbols;
    }

    public void setSymbols(List<GamePiece> symbols) {
        this.symbols = symbols;
    }

    public void addTeamMate(Player player) {
        players.add(player);
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int score) {
        this.teamScore = score;
    }

    public String getTeamName() {
        return TeamName;
    }

    public GamePiece getOnlySymbol() {
        return symbols.get(0);
    }

    public String getTeamSymbols() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < symbols.size(); i++) {
            result.append(symbols.get(i).getName());

            // Add a comma and space after each name except the last one
            if (i < symbols.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    public String printGroupAndIndividualScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHere is the score summary of team ").append(this.TeamName).append(".\n");
        sb.append("Team Score: ").append(this.teamScore).append("\n");

        for (Player player : this.players) {
            sb.append("Player ").append(player.getName()).append(" : ").append(player.getScore()).append(" Points!").append("\n");
        }

        return sb.append("\n").toString();
    }

    public void wipeGroupAndIndividualScores() {
        this.teamScore = 0;
        for (Player player : this.players) {
            player.setScore(0);
        }
    }

    //Though teams have multiple players, only one may be playing during a game.
    public Player getCurrentPlayer() {
        return this.players.get(0);
    }

    //This is used every time a new round of a game starts to allow us to shuffle the team and get a new player.
    public void assignNewPlayer() {
        Player currentPlayer = players.remove(0);
        players.add(currentPlayer);
    }

    //This gets a valid symbol for a player on a team that they can use on the board (Ex. X, O, Pawn)
    public String getValidSymbol(Scanner scanner) {
        String boxState;

        //Clear Scanner Buffer
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (true) {
            boxState = scanner.next();

            if (boxState.equalsIgnoreCase("quit")) {
                System.out.println("The program has quit. Thank you for playing!");
                System.exit(0);
            } else if (!checkIfSymbolExists(boxState)) {
                System.out.println("You submitted a symbol that is not yours! Make sure to be case-sensitive!");
                System.out.println("Please enter a correct symbol belonging to you!: ");
            } else {
                //We have found a box state that is valid and belongs to the user to place!
                break;
            }
        }
        return boxState;
    }

    //Helper to getValidSymbol to check if a given userString represents an actual gamePiece.
    private boolean checkIfSymbolExists(String boxState) {
        for (GamePiece symbol : symbols) {
            if (symbol.getName().equals(boxState)) {
                return true;
            }
        }
        return false;
    }

}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//This class allows user data collection (Ex. Names) and allows users to choose and start a specific game (TicTacToe)
//This class contains functions that can be used by any game.
// For example, this class takes care of creating teams and asking the user if they want to play the same game again.
// This class also ensures different members of a team play new rounds.
public class GameController {
    private Scanner scanner;
    private List<Player> players;
    private BoardGame[] GAME_LIST;
    private boolean endAllGames = false;

    public GameController() {
        this.scanner = ScannerSingleton.getInstance();
    }

    //Starts a game and loops till the player is finished with all games.
    public void startGameController() {

        //Get user information for all games!
        int numberOfPlayers = getPlayerCount(scanner);
        List<Player> players = getPlayerNames(numberOfPlayers, scanner);
        this.players = players;
        this.GAME_LIST = new BoardGame[]{new MonstersAndHeroes(players), new LegendsOfValor(players)};

        while (!endAllGames) {
            BoardGame currentGame = chooseGame();
            currentGame.startGame();

            //Ask user if they want to play any other games:
            System.out.println("\nWould you like to play another game? (y/n)");

            //Collect user input
            endAllGames = !(currentGame.userYesOrNoResponse());

        }

        System.out.println("Thank you for playing our games!");
    }

    //Asks the user to choose a game to play
    public BoardGame chooseGame() {
        BoardGame currentGame;
        int gameIndex;

        //Create Game List to show to the user
        StringBuilder sb = new StringBuilder();
        sb.append("\nHere is a list of playable games: \n");

        for (int i = 0; i < GAME_LIST.length; i++) {
            sb.append(i).append(" : ").append(GAME_LIST[i].getGameName()).append("\n");
        }

        sb.append("Please type the integer associated with the game you would like to play!");
        System.out.println(sb);

        //Collect a valid game request from the user
        while (true) {
            try {
                gameIndex = scanner.nextInt();
                currentGame = GAME_LIST[gameIndex];
                if (gameIndex == 0) {
                    validateSinglePlayerGame();
                    currentGame = new MonstersAndHeroes(players);
                } else if (gameIndex == 1) {
                    validateSinglePlayerGame();
                    currentGame = new LegendsOfValor(players);
                }
                break;

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter an integer associated with a game.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("You have the wrong amount of players for this game!");
                scanner.nextLine();
            }
        }

        return currentGame;
    }

    private void validateSinglePlayerGame() {
        if (players.size() != 1) {
            throw new IllegalArgumentException();
        }
    }

    //Find how many people are playing the game
    public static int getPlayerCount(Scanner scanner) {

        System.out.println("Welcome to our digital arcade! If at any time you would like to quit" +
                ", please type and enter \"quit\" when prompted to enter a string. \nPlease enter the number of players playing: ");

        int numberOfPlayers;
        //Validate player count
        while (true) {

            try {
                numberOfPlayers = scanner.nextInt();

                if (numberOfPlayers < 1) {
                    System.out.println("At least 1 player is required to start any of our games.");
                    System.out.println("Please enter the new number of players playing: ");
                } else if (numberOfPlayers > 50) {
                    System.out.println("At the moment, only 50 players total can play. Please try again with less players.");
                    System.out.println("Please enter the new number of players playing: ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        return numberOfPlayers;
    }

    //Capture the names of all people playing
    public static List<Player> getPlayerNames(int numberOfPlayers, Scanner scanner) {

        List<Player> players = new ArrayList<>();

        //Clear Scanner Buffer
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine().trim();

            //Validate that each input is a possible name
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
                i--;
            } else if (name.equalsIgnoreCase("quit")) {
                System.out.println("The program has quit. Thank you for playing!");
                System.exit(0);
            } else {
                Player currentPlayer = new Player(name);
                players.add(currentPlayer);
            }
        }

        return players;
    }
}

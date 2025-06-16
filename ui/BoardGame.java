package ui;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

import models.Player;
import utils.ScannerSingleton;

//This class serves as a superclass to more specific types of games,
// like Monster and Chaos, and holds the state of a board game like the actual board, players, and other state.
public abstract class BoardGame {
    private BoardPiece[][] board;
    private Map<Integer, BoardPiece> IDToPieceMap; // Hashmap to store board piece IDs to actual board pieces
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset the color of a printed string to default
    public static final String ANSI_CYAN = "\u001B[36m"; // Used to set the color of a printed string to cyan
    private final String name;
    private final List<Player> players;
    protected Scanner scanner;

    public BoardGame(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.scanner = ScannerSingleton.getInstance();
    }

    // Responsible for getting the board size of the game.
    public static int getNumberResponse(int min, int max, String intro, String tooLow, String tooHigh,
            String tryAgain) {
        Scanner scanner = ScannerSingleton.getInstance();
        System.out.println("\nPlease type the " + intro + " from [" + min + "," + max + "] inclusive (Ex. 3): ");

        // Clear Scanner Buffer
        clearBuffer();

        // Validate boardSize
        int boardSize;
        while (true) {

            try {
                boardSize = scanner.nextInt();

                if (boardSize < min) {
                    System.out.println(tooLow + ">=" + min);
                    System.out.println(tryAgain);
                } else if (boardSize > max) {
                    System.out.println(tooHigh + "<=" + max);
                    System.out.println(tryAgain);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return boardSize;
    }

    // Responsible for setting the board size of a board game
    public void setBoardSize(int boardSize) {
        this.board = new BoardPiece[boardSize][boardSize];
        this.IDToPieceMap = new HashMap<>();
        initBoardIDs();
    }

    // Gives each BoardPiece an ID number that maps to a BoardPiece to help the user
    // pick it.
    public void initBoardIDs() {

        int counter = 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                BoardPiece piece = new BoardPiece();
                piece.setID(counter);
                IDToPieceMap.put(counter, piece);
                board[i][j] = piece;
                counter++;
            }
        }
    }

    // Checks to see if a user-inputted ID for a board piece is taken!
    public BoardPiece getValidBoxID() {

        BoardPiece answer;

        // Clear Scanner Buffer
        clearBuffer();

        while (true) {

            try {
                int boxID = scanner.nextInt();

                if (!IDToPieceMap.containsKey(boxID)) {
                    System.out.println("You submitted an ID that does not exist!");
                    System.out.println("Please enter a correct ID: ");
                    continue;
                }

                BoardPiece tempPiece = IDToPieceMap.get(boxID);

                if (tempPiece.getFirstGamePiece() != null) {
                    System.out.println("You have selected a ID that has already been chosen!");
                    System.out.println("Please enter a correct ID: ");
                } else {
                    // We have found a box id that is valid!
                    answer = tempPiece;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return answer;
    }

    // Used for overridden print statements.
    public BoardPiece[][] getBoard() {
        return board;
    }

    public Map<Integer, BoardPiece> getIDtoMap() {
        return IDToPieceMap;
    }

    public String getGameName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    // Get a Yes/No response from the user and return
    public static boolean userYesOrNoResponse() {
        boolean answer;
        Scanner scanner = ScannerSingleton.getInstance();
        System.out.println("Please type (y/n)\n");

        // clearBuffer();

        while (true) {
            String userResponse = scanner.next();
            if (userResponse.equalsIgnoreCase("n")) {
                answer = false;
                break;
            } else if (userResponse.equalsIgnoreCase("quit")) {
                System.out.println("The program has quit. Thank you for playing!");
                System.exit(0);
            } else if (!userResponse.equalsIgnoreCase("y")) {
                System.out.println("Please enter a valid response (y/n)");
            } else {
                answer = true;
                break;
            }
        }
        return answer;
    }

    // Clears buffer size to allow for clean user input whenever needed.
    public static void clearBuffer() {
        Scanner scanner = ScannerSingleton.getInstance();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
        }
    }

    public void putGamePieceOnBoardPiece(GamePiece gamePiece, int boxID) {
        IDToPieceMap.get(boxID).addGamePiece(gamePiece);
    }

    public void removeGamePieceOnBoardPiece(int boxID) {
        IDToPieceMap.get(boxID).removeGamePieces();
    }

    public static void removeSpecificGamePieceOnBoardPiece(GamePiece piece, BoardPiece currentBoardPiece) {
        List<GamePiece> pieces = currentBoardPiece.getGamePieces();
        List<GamePiece> finalPieces = new ArrayList<>();
        for (GamePiece gamePiece : pieces) {
            if (gamePiece != piece) {
                finalPieces.add(gamePiece);
            }
        }
        currentBoardPiece.setGamePieces(finalPieces);
    }

    public void swapBoardPieces(int piece1ID, BoardPiece piece2) {
        IDToPieceMap.put(piece1ID, piece2);
    }

    public BoardPiece getBoardPieceFromID(int id) {
        return IDToPieceMap.get(id);
    }

    // Abstract Methods that all Games must have
    public abstract void startGame();

    public abstract void startNewRoundOfGame();

}

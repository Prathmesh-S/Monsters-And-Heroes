import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//The main class that starts a Legends of Valor Game, managing gameplay elements and interactions between Heroes and Monsters within the game.
public class LegendsOfValor extends MonstersAndHeroes {

    private MonstersAndHeroesPlayer monstersAndHeroesPlayer;
    private int boardLength = 8;
    private int rounds = 0;
    private List<Hero> chosenHeroList = new ArrayList<>();
    private List<Monster> chosenMonsterList = new ArrayList<>();

    public LegendsOfValor(List<Player> players) {
        super("Legends Of Valor (Single-Player)", players);

    }

    @Override
    public void startGame() {

        // Explain the Game
        System.out.println(gameExplained());

        // Set up board
        this.setBoardSize(this.boardLength);
        setUpBoard();

        // Allow the user to choose their heroes they want!
        System.out.println(
                "\nIt is time to choose 3 heroes! Your i-th chosen hero will live in the i-th column of the game.");
        List<Hero> randomGeneratedHeroes = new HeroFactoryManager(5).getHeroes();
        chosenHeroList = chooseHeroes(randomGeneratedHeroes, 3);

        // Create our Player and Init our heroes with positions on the map.
        Player generalPlayer = getPlayers().get(0);
        monstersAndHeroesPlayer = new MonstersAndHeroesPlayer(generalPlayer.getName(), chosenHeroList);
        GamePiece monstersAndHeroesPlayerGamePiece1 = new GamePiece("H1", "\u001B[1m\u001B[92m");
        GamePiece monstersAndHeroesPlayerGamePiece2 = new GamePiece("H2", "\u001B[1m\u001B[92m");
        GamePiece monstersAndHeroesPlayerGamePiece3 = new GamePiece("H3", "\u001B[1m\u001B[92m");
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece1, 57);
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece2, 60);
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece3, 63);
        // Set initial positions for heroes correctly
        chosenHeroList.get(0).setCurrentX(7); // Row 7 (heroes' Nexus)
        chosenHeroList.get(0).setNexusX(7);
        chosenHeroList.get(0).setCurrentY(0); // Column 0 (first lane)
        chosenHeroList.get(0).setNexusY(0);

        chosenHeroList.get(1).setCurrentX(7); // Row 7 (heroes' Nexus)
        chosenHeroList.get(1).setNexusX(7);
        chosenHeroList.get(1).setCurrentY(3); // Column 3 (middle lane)
        chosenHeroList.get(1).setNexusY(3);

        chosenHeroList.get(2).setCurrentX(7); // Row 7 (heroes' Nexus)
        chosenHeroList.get(2).setNexusX(7);
        chosenHeroList.get(2).setCurrentY(6); // Column 6 (third lane)
        chosenHeroList.get(2).setNexusY(6);

        // Create Our Monsters
        setUpMonsters();

        // Start our Game
        startNewRoundOfGame();

    }

    private String getPlayerInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void startNewRoundOfGame() {
        while (true) {
            rounds++;
            System.out.println("\n--- Round " + rounds + " ---");

            // Hero Rounds
            for (Hero hero : chosenHeroList) {
                if (!hero.isAlive()) {
                    System.out.println(hero.getName() + " is dead and will respawn next round.");
                    continue;
                }

                // Do an option
                System.out.println(printBoard());
                outOfBattleChoices(hero);

                // Check to see if the hero has won!
                if (hero.getCurrentX() == 0) {
                    System.out.println(printBoard());
                    System.out.println("\n" + hero.getName() + " has reached the monsters' Nexus! Heroes win!");
                    System.exit(0);
                }
            }

            // Monster Rounds
            for (Monster monster : chosenMonsterList) {

                // Attack a hero if possible.

                // Move the monster.
                moveMonster(monster);

                // Check if monster has reached the heroes' Nexus
                if (monster.getCurrentX() == 7) {
                    System.out.println(printBoard());
                    System.out.println("\n" + monster.getName()
                            + " has reached the heroes' Nexus! Game Over as monsters have won!.");
                    System.exit(0);
                }
            }

            // End-of-round recovery and respawn
            for (Hero hero : chosenHeroList) {
                if (hero.isAlive()) {
                    hero.endOfRoundRecovery();
                } else {
                    hero.respawn(7, hero.getCurrentY());
                }
            }

            System.out.println("--- End of Round " + rounds + " ---");

            // Spawn new monsters if we have surpassed a number of rounds.
            if (rounds % 7 == 0) {
                setUpMonsters();
            }
        }
    }

    public void outOfBattleChoices(Hero hero) {
        System.out.println("\nHero " + hero.getName() + ", it is your turn!");
        displayMenu();

        while (true) {
            String userResponse = scanner.next();
            // Move the player
            if (userResponse.equalsIgnoreCase("w") || userResponse.equalsIgnoreCase("a") ||
                    userResponse.equalsIgnoreCase("s") || userResponse.equalsIgnoreCase("d")) {
                int newPlayerBoxID = getNewTileID(userResponse, getBoxIDOfHero(hero));
                if (newPlayerBoxID != -1) {
                    moveHero(hero, newPlayerBoxID);
                    break;
                } else {
                    System.out.println("Please enter a valid response.");
                }
                // Quit the Game
            } else if (userResponse.equalsIgnoreCase("q")) {
                System.out.println("The program has quit. Thank you for playing!");
                System.exit(0);
                // Show Game Information
            } else if (userResponse.equalsIgnoreCase("i")) {
                System.out.println("Hero Information: ");
                monstersAndHeroesPlayer.displayHeroesInTableFormat();
                break;
                // Enter the Market!
            } else if (userResponse.equalsIgnoreCase("m")) {
                System.out.println("Attempting to enter a market.\n");
                int currentTile = monstersAndHeroesPlayer.getCurrentBoxID();
                BoardPiece currentPiece = getBoardPieceFromID(currentTile);
                if (currentPiece instanceof MarketBoardTile) {
                    ((MarketBoardTile) currentPiece).enterMarket((MarketBoardTile) currentPiece,
                            monstersAndHeroesPlayer);
                    break;
                } else {
                    System.out.println("You are not in a Market Right Now! Select another option.");
                }
            } else if (userResponse.equalsIgnoreCase("r")) {
                GamePiece heroPiece = LegendsOfValor.getHeroGamePiece(getBoardPieceFromID(getBoxIDOfHero(hero)));
                BoardGame.removeSpecificGamePieceOnBoardPiece(heroPiece, getBoardPieceFromID(getBoxIDOfHero(hero)));
                hero.recall();
                putGamePieceOnBoardPiece(heroPiece, getBoxIDOfHero(hero));
                break;
            } else if (userResponse.equalsIgnoreCase("t")) {
                // hero.teleport(hero, null);
                break;
            } else if (userResponse.equalsIgnoreCase("map")) {
                System.out.println(printBoard());
                displayMenu();
                // Potentially consume potions
            } else if (userResponse.equalsIgnoreCase("p")) {
                potentiallyConsumePotions();
                break;
            } else if (userResponse.equalsIgnoreCase("e")) {
                equipWeaponAndArmour(monstersAndHeroesPlayer);
                break;
            } else {
                System.out.println("Please enter a valid response.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nPlease select an action by entering the corresponding letter:");
        System.out.println("(W,A,S,D): Move Up, Left, Down, Right");
        System.out.println("Q: Quit the Game");
        System.out.println("I: Show Hero Information");
        System.out.println("M: Enter the Market");
        System.out.println("P: Consume a Potion");
        System.out.println("E: Equip Weapons or Armor");
        System.out.println("R: Recall to Nexus");
        System.out.println("T: Teleport to Another Hero");
        System.out.println("MAP: Display the Game Map Again");
        System.out.println("\nEnter your choice: ");
    }

    public int getBoxIDOfHero(Hero hero) {
        return (hero.getCurrentX() * boardLength + hero.getCurrentY() + 1);
    }

    // Gets new tile location for W/A/S/D commands
    public Integer getNewTileID(String direction, int currentTileID) {
        int numRows = boardLength, numCols = boardLength;
        int row = (currentTileID - 1) / numCols, col = (currentTileID - 1) % numCols;
        BoardPiece[][] board = getBoard();

        switch (direction.toLowerCase()) {
            case "w":

                // Check to ensure a Hero is not advancing ahead of a monster
                List<GamePiece> pieces = new ArrayList<>(board[row][col].getGamePieces());
                if (col + 1 < boardLength) {
                    pieces.addAll(board[row][col + 1].getGamePieces());
                }
                if (col - 1 >= 0) {
                    pieces.addAll(board[row][col - 1].getGamePieces());
                }
                for (GamePiece piece : pieces) {
                    if (piece.getName().equals("M")) {
                        return -1;
                    }
                }

                // If we pass this, a hero can move up.
                row--;
                break;
            case "a":
                col--;
                break;
            case "s":
                row++;
                break;
            case "d":
                col++;
                break;
        }

        int newID = row * numCols + col + 1;
        BoardPiece newBoardPiece = getBoardPieceFromID(newID);
        if ((newBoardPiece == null) || !newBoardPiece.isAccessible()
                || (newBoardPiece.getType() == BoardPieceType.OBSTACLE) ||
                ((newBoardPiece.getFirstGamePiece() != null)
                        && ((newBoardPiece.getFirstGamePiece().getName().equals("H1")) ||
                                (newBoardPiece.getFirstGamePiece().getName().equals("H2"))
                                || (newBoardPiece.getFirstGamePiece().getName().equals("H3"))))) {
            return -1;
        }

        return (row >= 0 && row < numRows && col >= 0 && col < numCols)
                ? row * numCols + col + 1
                : -1;
    }

    public void moveMonster(Monster monster) {
        int row = monster.getCurrentX();
        int column = monster.getCurrentY();
        BoardPiece[][] board = getBoard();

        int currentBoxID = row * boardLength + column + 1;
        BoardPiece currentBoardPiece = getBoardPieceFromID(currentBoxID);
        int newBoxID = currentBoxID + 8;
        BoardPiece newBoardPiece = getBoardPieceFromID(newBoxID);
        // If we enter this, we know we can not move the monster at the moment (Ex. We
        // have an obstacle or another Monster)
        if ((newBoardPiece.getType() == BoardPieceType.OBSTACLE) || ((newBoardPiece.getFirstGamePiece() != null)
                && (newBoardPiece.getFirstGamePiece().getName().equals("M")))) {
            return;
        }

        // Check to ensure a Monster is not advancing ahead of a Hero
        List<GamePiece> pieces = new ArrayList<>(board[row][column].getGamePieces());
        if (column + 1 < boardLength) {
            pieces.addAll(board[row][column + 1].getGamePieces());
        }
        if (column - 1 >= 0) {
            pieces.addAll(board[row][column - 1].getGamePieces());
        }
        for (GamePiece piece : pieces) {
            if ((piece.getName().equals("H1")) || (piece.getName().equals("H2")) || (piece.getName().equals("H3"))) {
                return;
            }
        }

        // If we pass this, we can move the monster down
        removeSpecificGamePieceOnBoardPiece(getMonsterGamePiece(currentBoardPiece), currentBoardPiece);
        putGamePieceOnBoardPiece(new GamePiece("M", "\u001B[1m\u001B[31m"), newBoxID);
        int newRow = (newBoxID - 1) / boardLength;
        int newColumn = (newBoxID - 1) % boardLength;
        monster.setCurrentX(newRow);
        monster.setCurrentY(newColumn);
    }

    // Moves the player into a correct boxID
    public void moveHero(Hero hero, int newPlayerBoxID) {
        int currentBoxID = getBoxIDOfHero(hero);
        BoardPiece currentBoardPiece = getBoardPieceFromID(currentBoxID);
        putGamePieceOnBoardPiece(getHeroGamePiece(currentBoardPiece), newPlayerBoxID);
        removeSpecificGamePieceOnBoardPiece(getHeroGamePiece(currentBoardPiece), currentBoardPiece);
        int newRow = (newPlayerBoxID - 1) / boardLength;
        int newColumn = (newPlayerBoxID - 1) % boardLength;
        hero.setCurrentX(newRow);
        hero.setCurrentY(newColumn);
    }

    public static GamePiece getHeroGamePiece(BoardPiece currentBoardPiece) {
        List<GamePiece> pieces = currentBoardPiece.getGamePieces();
        for (GamePiece piece : pieces) {
            if ((piece.getName().equals("H1")) || (piece.getName().equals("H2")) || (piece.getName().equals("H3"))) {
                return piece;
            }
        }
        return null;
    }

    public static GamePiece getMonsterGamePiece(BoardPiece currentBoardPiece) {
        List<GamePiece> pieces = currentBoardPiece.getGamePieces();
        for (GamePiece piece : pieces) {
            if ((piece.getName().equals("M"))) {
                return piece;
            }
        }
        return null;
    }

    // Create Inaccessible, Market, and Common Space Tiles
    @Override
    public void setUpBoard() {
        BoardPiece[][] board = getBoard();
        Random random = new Random();
        double randomProb;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // Inaccessible Columns/Walls
                if (j == 2 || j == 5) {
                    board[i][j].setAccessible(false);
                    board[i][j].setType(BoardPieceType.INACCESSIBLE);
                    continue;
                }

                // First and last row is Monster Nexus
                if (i == 0 || i == 7) {
                    board[i][j] = new MarketBoardTile();
                    swapBoardPieces(i * boardLength + j + 1, board[i][j]);
                    board[i][j].setType(BoardPieceType.NEXUS);
                    continue;
                }

                // Else, generate random Board Cells:
                randomProb = random.nextDouble();

                if (randomProb <= 0.05) { // "Inaccessible" Piece
                    board[i][j].setAccessible(false);
                    board[i][j].setType(BoardPieceType.OBSTACLE);
                } else if (randomProb <= 0.15) {
                    board[i][j].setType(BoardPieceType.BUSH);
                } else if (randomProb <= 0.25) {
                    board[i][j].setType(BoardPieceType.CAVE);
                } else if (randomProb <= 0.35) {
                    board[i][j].setType(BoardPieceType.KOULOU);
                } else {
                    board[i][j].setType(BoardPieceType.PLAIN);
                }
            }
        }
    }


    @Override
    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLegend:\n");
        sb.append("\u001B[1m\u001B[30mXXXX\u001B[0m - Inaccessible\n"); // Black
        sb.append("\u001B[1m\u001B[92mH1\u001B[0m - Your hero : " + chosenHeroList.get(0).getName() + "\n");
        sb.append("\u001B[1m\u001B[92mH2\u001B[0m - Your hero : " + chosenHeroList.get(1).getName() + "\n");
        sb.append("\u001B[1m\u001B[92mH3\u001B[0m - Your hero : " + chosenHeroList.get(2).getName() + "\n");
        sb.append("\u001B[1m\u001B[31mM\u001B[0m - The monsters!\n");
        sb.append("\u001B[34mN\u001B[0m - Nexus/Market\n"); // Blue
        sb.append("\u001B[32mB\u001B[0m - Bush (Dexterity Boost)\n"); // Green
        sb.append("\u001B[90mC\u001B[0m - Cave (Agility Boost)\n"); // Dark Gray
        sb.append("\u001B[33mK\u001B[0m - Koulou (Strength Boost)\n"); // Yellow
        sb.append("\u001B[35mO\u001B[0m - Obstacle\n");
        sb.append("\n");
        sb.append("                 Monster Nexus");
        sb.append(super.printBoard());
        sb.append("\n");
        sb.append("                 Hero Nexus");
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String gameExplained() {
        return "\nWelcome to Legends of Valor! The game board is an 8x8 grid, divided into three lanes with various types of spaces: Nexus, Inaccessible, Plain, Bush, Cave, and Koulou.\n"
                +
                "Each lane spans two columns, with impassable columns separating them. Heroes aim to reach the monsters' Nexus at the top, while monsters attempt to invade the heroes' Nexus at the bottom.\n\n"
                +
                "Spaces have different effects: Nexus spaces are spawning points and markets for heroes; Bush spaces boost hero dexterity; Cave spaces increase agility; and Koulou spaces enhance strength. \n"
                +
                "Monsters receive no terrain bonuses.\n\n" +
                "Heroes control a team of three, with each hero occupying a lane. Heroes can perform actions such as moving, attacking, casting spells, using items, or teleporting to other lanes. \n"
                +
                "They battle invading monsters, gathering gold and experience along the way.\n\n" +
                "Heroes and monsters act in rounds, with heroes going first. If a hero reaches the monster Nexus, they win. If a monster reaches the hero Nexus, the heroes lose.\n\n"
                +
                "The objective is to coordinate actions, use terrain to your advantage, and stop the monster invasion. Level up, strengthen your heroes, and protect the Nexus!\n";
    }

    public void setUpMonsters() {
        // Create Monsters
        MonsterFactoryManager monsterFactory = new MonsterFactoryManager(3);
        List<Monster> monsters = monsterFactory.getMonsters();
        MonsterFactoryManager.scaleLevels(monstersAndHeroesPlayer.getHeroes(), monsters);

        // Add to Monster List
        chosenMonsterList.addAll(monsters);

        // Add Monster Pieces to the Board
        GamePiece monster1 = new GamePiece("M", "\u001B[1m\u001B[31m");
        GamePiece monster2 = new GamePiece("M", "\u001B[1m\u001B[31m");
        GamePiece monster3 = new GamePiece("M", "\u001B[1m\u001B[31m");

        // Spawn new monsters in nexus if possible
        GamePiece nexus1GamePiece = getBoardPieceFromID(2).getFirstGamePiece();
        GamePiece nexus2GamePiece = getBoardPieceFromID(5).getFirstGamePiece();
        GamePiece nexus3GamePiece = getBoardPieceFromID(8).getFirstGamePiece();

        if (nexus1GamePiece == null) {
            putGamePieceOnBoardPiece(monster1, 2);
            monsters.get(0).setCurrentX(0);
            monsters.get(0).setCurrentY(1);
        }

        if (nexus2GamePiece == null) {
            putGamePieceOnBoardPiece(monster2, 5);
            monsters.get(1).setCurrentX(0);
            monsters.get(1).setCurrentY(4);
        }

        if (nexus3GamePiece == null) {
            putGamePieceOnBoardPiece(monster3, 8);
            monsters.get(2).setCurrentX(0);
            monsters.get(2).setCurrentY(7);
        }
    }

}

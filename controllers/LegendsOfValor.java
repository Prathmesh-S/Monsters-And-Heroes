package controllers;

import java.util.*;
import models.*;
import ui.*;
import utils.*;
import factories.*;
import strategies.*;

//The main class that starts a Legends of Valor Game, managing gameplay elements and interactions between Heroes and Monsters within the game.
public class LegendsOfValor extends MonstersAndHeroes {

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

        chosenHeroList.get(0).setIdentifier("H1");
        chosenHeroList.get(1).setIdentifier("H2");
        chosenHeroList.get(2).setIdentifier("H3");

        // Create Our Monsters
        setUpMonsters();

        // Start our Game
        startNewRoundOfGame();

    }

    @Override
    public void startNewRoundOfGame() {
        while (true) {
            rounds++;
            System.out.println("\n--- Round " + rounds + " ---");

            // Hero Rounds
            System.out.println("\u001B[34m------------------------Hero Turn ------------------------\u001B[0m");
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
            System.out.println("\u001B[34m-------------------------------------------------------------\u001B[0m");

            // Monster Rounds
            System.out.println("\u001B[31m------------------------Monsters Turn ------------------------\u001B[0m");
            List<Monster> tempMonsterList = new ArrayList<>();
            tempMonsterList.addAll(chosenMonsterList);

            for (Monster monster : tempMonsterList) {

                // Attack a hero if possible.
                boolean attacked = potentiallyAttackHero(monster);
                if (!attacked) {
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
            }
            System.out.println("\u001B[31m-------------------------------------------------------------\u001B[0m");


            // End-of-round recovery and respawn
            for (Hero hero : chosenHeroList) {
                if (hero.isAlive()) {
                    hero.endOfRoundRecovery();
                } else {
                    hero.respawn(hero.getNexusX(), hero.getNexusY());
                    GamePiece monstersAndHeroesPlayerGamePiece1 = new GamePiece(hero.getIdentifier(), "\u001B[1m\u001B[92m");
                    putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece1, hero.getNexusX() * boardLength + hero.getNexusY() +1);
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
            } else if (userResponse.equalsIgnoreCase("ro")) {
                removeObstacle();
                break;
            } else if (userResponse.equalsIgnoreCase("i")) {
                System.out.println("Hero Information: ");
                monstersAndHeroesPlayer.displayHeroesInTableFormat();
                displayMenu();
            } else if (userResponse.equalsIgnoreCase("attack")) {
                Monster monster = potentiallyAttackMonster(hero);
                //We have a monster
                if (monster != null) {
                    BattleStrategy attack = new AttackStrategy();
                    attack.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                    //Check if monster has died
                    if (!monster.isAlive()) {
                        GamePiece monsterPiece = LegendsOfValor.getMonsterGamePiece(getBoardPieceFromID(monster.getCurrentX() * boardLength + monster.getCurrentY() + 1));
                        BoardGame.removeSpecificGamePieceOnBoardPiece(monsterPiece, getBoardPieceFromID(monster.getCurrentX() * boardLength + monster.getCurrentY() + 1));
                        chosenMonsterList.remove(monster);
                    }
                }
                break;
            } else if (userResponse.equalsIgnoreCase("spell")) {
                Monster monster = potentiallyAttackMonster(hero);
                //We have a monster
                if (monster != null) {
                    BattleStrategy spellStrategy = new SpellStrategy();
                    spellStrategy.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                    //Check if monster has died
                    if (!monster.isAlive()) {
                        GamePiece monsterPiece = LegendsOfValor.getMonsterGamePiece(getBoardPieceFromID(monster.getCurrentX() * boardLength + monster.getCurrentY() + 1));
                        BoardGame.removeSpecificGamePieceOnBoardPiece(monsterPiece, getBoardPieceFromID(monster.getCurrentX() * boardLength + monster.getCurrentY() + 1));
                        chosenMonsterList.remove(monster);
                    }
                }
                break;
            }
            else if (userResponse.equalsIgnoreCase("m")) {
                System.out.println("Attempting to enter a market.\n");
                int currentTile = getBoxIDOfHero(hero);
                BoardPiece currentPiece = getBoardPieceFromID(currentTile);
                if (currentPiece instanceof MarketBoardTile) {
                    List<Hero> heroes = new ArrayList<>(Arrays.asList(hero));
                    ((MarketBoardTile) currentPiece).enterMarket((MarketBoardTile) currentPiece,
                            monstersAndHeroesPlayer, heroes);
                    displayMenu();
                } else {
                    System.out.println("You are not in a Market Right Now! Select another option.");
                }
                // recall
            } else if (userResponse.equalsIgnoreCase("r")) {
                GamePiece heroPiece = LegendsOfValor.getHeroGamePiece(getBoardPieceFromID(getBoxIDOfHero(hero)));
                BoardGame.removeSpecificGamePieceOnBoardPiece(heroPiece, getBoardPieceFromID(getBoxIDOfHero(hero)));
                hero.recall();
                putGamePieceOnBoardPiece(heroPiece, getBoxIDOfHero(hero));
                System.out.println(printBoard());
                break;
                // teleport
            } else if (userResponse.equalsIgnoreCase("t")) {
                System.out.println("Select a hero to teleport to:");
                for (int i = 0; i < chosenHeroList.size(); i++) {
                    Hero targetHero = chosenHeroList.get(i);
                    System.out.println((i) + ": " + targetHero.getName() + " at (" + targetHero.getCurrentX() + ", "
                            + targetHero.getCurrentY() + ")");
                }
                int choice = BoardGame.getNumberResponse(0, chosenHeroList.size() - 1, "index of the hero you would like to teleport to.",
                        "Invalid Index ", "Invalid Index ", "Please enter a valid index. ");

                if (choice >= 0 && choice < chosenHeroList.size()) {
                    Hero targetHero = chosenHeroList.get(choice);
                    if (hero.teleport(targetHero, this)) { // Pass the game object
                        System.out.println(printBoard()); // Display updated board after teleport
                    } else {
                        System.out.println("Teleportation failed.");
                    }
                } else {
                    System.out.println("Invalid choice. Turn skipped.");
                }
                break;
            } else if (userResponse.equalsIgnoreCase("map")) {
                System.out.println(printBoard());
                displayMenu();
                // Potentially consume potions
            } else if (userResponse.equalsIgnoreCase("p")) {
                List<Hero> heroes = new ArrayList<>(Arrays.asList(hero));
                potentiallyConsumePotions(heroes, monstersAndHeroesPlayer);
                break;
            } else if (userResponse.equalsIgnoreCase("e")) {
                List<Hero> heroes = new ArrayList<>(Arrays.asList(hero));
                equipWeaponAndArmour(heroes, monstersAndHeroesPlayer);
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
        System.out.println("Attack: Attack a Monster near you!");
        System.out.println("Spell: Spell a Monster near you!");
        System.out.println("RO: Remove Obstacle (The O's on the map)");
        System.out.println("T: Teleport to Another Hero");
        System.out.println("MAP: Display the Game Map Again");
        System.out.println("\nEnter your choice: ");
    }

    public void removeObstacle() {
        BoardPiece[][] board = getBoard();
        List<BoardPiece> obstaclePieces = new ArrayList<>();

        //Add all obstacle pieces
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getType() == BoardPieceType.OBSTACLE) {
                    obstaclePieces.add(board[i][j]);
                }
            }
        }

        if (obstaclePieces.isEmpty()) {
            System.out.println("\nThere are no obstacles to remove! You have wasted a turn!");
            return;
        }

        // Display options to the user
        System.out.println("\nSelect an obstacle to remove with coordinates (Row, Column), using zero-indexing:");
        for (int i = 0; i < obstaclePieces.size(); i++) {
            int boardPieceID = obstaclePieces.get(i).getID();
            int row = (boardPieceID - 1) / boardLength, col = (boardPieceID - 1) % boardLength;
            System.out.printf("%d: (%d, %d)%n", i, row, col);
        }

        //Collect User Response for obstacle they want to remove
        int obstaclePieceID = getNumberResponse(0, obstaclePieces.size() - 1, "index of the obstacle piece you would like to remove",
                "Invalid Index ", "Invalid Index ", "Please enter a valid index. ");

        BoardPiece chosenPiece = obstaclePieces.get(obstaclePieceID);

        chosenPiece.setType(BoardPieceType.PLAIN);
        System.out.println("\nThe obstacle has been removed!");

    }

    public int getBoxIDOfHero(Hero hero) {
        return (hero.getCurrentX() * boardLength + hero.getCurrentY() + 1);
    }

    public Monster potentiallyAttackMonster(Hero hero) {
        int heroX = hero.getCurrentX();
        int heroY = hero.getCurrentY();

        // Collect possible adjacent positions in the target lane
        BoardPiece[][] board = this.getBoard();
        List<int[]> validPositions = new ArrayList<>();
        int[][] directions = {{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}}; // Adjacent directions: North, South,

        for (int[] dir : directions) {
            int newX = heroX + dir[0];
            int newY = heroY + dir[1];

            // Check board boundaries
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }

            BoardPiece targetPiece = board[newX][newY];

            //Add all monster pieces
            if ((targetPiece.getGamePieces() != null) && (targetPiece.getGamePieces().stream().anyMatch(piece -> piece.getName().startsWith("M")))) {
                validPositions.add(new int[]{newX, newY});
            }
        }

        // Abort if no valid positions
        if (validPositions.isEmpty()) {
            System.out.println("\nAttack failed: No monsters to attack/spell in your area!.");
            return null;
        }

        // Display options to the user
        System.out.println("\nSelect a monster position to attack/spell (Row, Column), using zero-indexing:");
        for (int i = 0; i < validPositions.size(); i++) {
            int[] pos = validPositions.get(i);
            System.out.printf("%d: (%d, %d)%n", i, pos[0], pos[1]);
        }

        // Get user choice
        int choice = getNumberResponse(0, validPositions.size() - 1, "index of the monster you would like to attack",
                "Invalid Index ", "Invalid Index ", "Please enter a valid index. ");
        // Validate choice
        if (choice < 0 || choice >= validPositions.size()) {
            System.out.println("\nInvalid choice. Monster attack failed as you attacked no one!.");
            return null;
        }

        int[] selectedPosition = validPositions.get(choice);
        int monsterRow = selectedPosition[0];
        int monsterCol = selectedPosition[1];
        Monster chosenMonster = null;

        //Find the monster
        for (Monster monster : chosenMonsterList) {
            if ((monster.getCurrentX() == monsterRow) && (monster.getCurrentY() == monsterCol)) {
                chosenMonster = monster;
            }
        }

        return chosenMonster;

    }

    public boolean potentiallyAttackHero (Monster monster) {
        int monsterX = monster.getCurrentX();
        int monsterY = monster.getCurrentY();

        // Collect possible adjacent positions in the target lane
        BoardPiece[][] board = this.getBoard();
        List<int[]> validPositions = new ArrayList<>();
        int[][] directions = {{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}}; // Adjacent directions: North, South,

        for (int[] dir : directions) {
            int newX = monsterX + dir[0];
            int newY = monsterY + dir[1];

            // Check board boundaries
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }

            BoardPiece targetPiece = board[newX][newY];

            //Add all monster pieces
            if ((targetPiece.getGamePieces() != null) && (targetPiece.getGamePieces().stream().anyMatch(piece -> piece.getName().startsWith("H")))) {
                validPositions.add(new int[]{newX, newY});
            }
        }

        // Abort if no valid positions
        if (validPositions.isEmpty()) {
            return false;
        }

        int[] randomHero = validPositions.get(new Random().nextInt(validPositions.size()));

        int heroRow = randomHero [0];
        int heroCol = randomHero [1];
        Hero chosenHero = null;

        //Find the Hero
        for (Hero hero  : chosenHeroList) {
            if ((hero.getCurrentX() == heroRow) && (hero.getCurrentY() == heroCol)) {
                chosenHero = hero;
            }
        }

        //Attack the hero
        Battle.monsterAttack(chosenHero, monster);

        //Update Hero if needed (check to see if it died)
        if (!chosenHero.isAlive()) {
            GamePiece heroPiece = LegendsOfValor.getHeroGamePiece(getBoardPieceFromID(chosenHero.getCurrentX() * boardLength + chosenHero.getCurrentY() + 1));
            BoardGame.removeSpecificGamePieceOnBoardPiece(heroPiece, getBoardPieceFromID(getBoxIDOfHero(chosenHero)));
        }
        return true;
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
                        || (newBoardPiece.getFirstGamePiece().getName().equals("H3")))) ||
                ((newBoardPiece.getFirstGamePiece() != null) && (newBoardPiece.getGamePieces().size() == 2))) {
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
                && (newBoardPiece.getFirstGamePiece().getName().equals("M"))) || ((newBoardPiece.getFirstGamePiece() != null)
                && (newBoardPiece.getGamePieces().size() == 2))) {
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
        System.out.println("\nA monster has moved towards your nexus this round!");
        removeSpecificGamePieceOnBoardPiece(getMonsterGamePiece(currentBoardPiece), currentBoardPiece);
        putGamePieceOnBoardPiece(new GamePiece("M", "\u001B[1m\u001B[31m"), newBoxID);
        int newRow = (newBoxID - 1) / boardLength;
        int newColumn = (newBoxID - 1) % boardLength;
        monster.setCurrentX(newRow);
        monster.setCurrentY(newColumn);
    }

    // Moves the player into a correct boxID
    public void moveHero(Hero hero, int newPlayerBoxID) {
        hero.resetTerrainBonus();
        int currentBoxID = getBoxIDOfHero(hero);
        BoardPiece currentBoardPiece = getBoardPieceFromID(currentBoxID);
        BoardPiece newBoardPiece = getBoardPieceFromID(newPlayerBoxID);
        putGamePieceOnBoardPiece(getHeroGamePiece(currentBoardPiece), newPlayerBoxID);
        removeSpecificGamePieceOnBoardPiece(getHeroGamePiece(currentBoardPiece), currentBoardPiece);
        int newRow = (newPlayerBoxID - 1) / boardLength;
        int newColumn = (newPlayerBoxID - 1) % boardLength;
        hero.setCurrentX(newRow);
        hero.setCurrentY(newColumn);
        if (newBoardPiece.getLabel() != null) {
            hero.setTerrainType(newBoardPiece.getLabel());
            hero.applyTerrainBonus();
        } else {
            hero.setTerrainType("");
        }
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

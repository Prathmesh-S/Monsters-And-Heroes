import java.util.*;

//The main class that starts a Heroes and Monsters Game, managing gameplay elements and interactions between Heroes and Monsters.
public class MonstersAndHeroes extends BoardGame {

    private int boardLength;
    private int numHeroes;
    private MonstersAndHeroesPlayer monstersAndHeroesPlayer;
    private Team monstersAndHeroesTeam;

    public MonstersAndHeroes(List<Player> players) {
        super("Monsters And Heroes (Single-Player)", players);
    }

    public MonstersAndHeroes(String name, List<Player> players) {
        super(name, players);
    }

    @Override
    public void startGame() {

        //Explain the Game
        System.out.println(gameExplained());

        //Get and Setup Board Size from user
        boardLength = getNumberResponse(5, 10, "size of the board you would like to play on",
                "A board needs to have a size ", "A board needs to have a size ", "Please enter a new board size: ");
        this.setBoardSize(this.boardLength);
        setUpBoard();

        //Get the number of heroes the player wants to play with
        numHeroes = getNumberResponse(1, 3, "number of heroes you would like to play with",
                "The number of heroes must be ", "The number of heroes must be ", "Please enter a valid hero amount");

        //Allow the user to choose their heroes they want!
        List<Hero> randomGeneratedHeroes = new HeroFactoryManager(numHeroes * 2).getHeroes();
        List<Hero> chosenHeroList = chooseHeroes(randomGeneratedHeroes, numHeroes);

        //Create our Specific Player/Heroes and place on the map
        Player generalPlayer = getPlayers().get(0);
        monstersAndHeroesPlayer = new MonstersAndHeroesPlayer(generalPlayer.getName(), chosenHeroList);
        monstersAndHeroesPlayer.setCurrentBoxID(1);
        GamePiece monstersAndHeroesPlayerGamePiece = new GamePiece("YOU", "\u001B[92m");
        monstersAndHeroesTeam = new Team(monstersAndHeroesPlayer.getName(), Arrays.asList(monstersAndHeroesPlayerGamePiece));
        putGamePieceOnBoardPiece(monstersAndHeroesTeam.getOnlySymbol(), 1);

        this.startNewRoundOfGame();
    }

    @Override
    public void startNewRoundOfGame() {

        while (true) {
            System.out.println(printBoard());
            outOfBattleChoices();
        }

    }

    //Create Inaccessible, Market, and Common Space Tiles
    public void setUpBoard() {
        BoardPiece[][] board = getBoard();
        Random random = new Random();
        double randomProb;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                //First piece must be commonSpace to allow for player to be put there
                if (i == 0 && j == 0) {
                    continue;
                }

                randomProb = random.nextDouble();
                GamePiece currentBoardType;
                if (randomProb <= 0.20) { //"Inaccessible" Piece
                    board[i][j].setAccessible(false);
                    board[i][j].setLabel("X", "\u001B[31m");
                } else if (randomProb <= 0.40) {//"Market" Piece
                    board[i][j] = new MarketBoardTile();
                    swapBoardPieces(i * boardLength + j + 1, board[i][j]);
                    board[i][j].setLabel("M", "\u001B[34m");
                }
            }
        }
    }

    //Create and return a string representing our 2D board and its state
    public String printBoard() {

        BoardPiece[][] board = getBoard();

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < board.length; i++) {
            sb = printRow(i, sb);
            if (i < board.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    //Print a specific row of a BoardGame
    public StringBuilder printRow(int i, StringBuilder sb) {

        BoardPiece[][] board = getBoard();

        for (int j = 0; j < board[i].length; j++) {
            String boxText;
            String colorCode;
            if (board[i][j].getFirstGamePiece() != null) {

                //Check to see if multiple gamePieces exist:
                List<GamePiece> gamePieces = board[i][j].getGamePieces();
                if (gamePieces.size() == 2) {
                    boxText = gamePieces.get(0).getColorCode() + gamePieces.get(0).getName() + ANSI_RESET + "," + gamePieces.get(1).getColorCode() + gamePieces.get(1).getName();
                } else {
                    boxText = board[i][j].getFirstGamePiece().getName();
                }

                colorCode = board[i][j].getFirstGamePiece().getColorCode();
            } else {
                if (board[i][j].isLabled()) {
                    boxText = board[i][j].getLabel();
                } else {
                    boxText = "    ";
                }
                colorCode = board[i][j].getColorCode();
            }
            if (boxText.length() == 1) {
                boxText = "   " + boxText;
            } else if (boxText.length() == 2) {
                boxText = "  " + boxText;
            } else if (boxText.length() == 3) {
                boxText = " " + boxText;
            }
            sb.append("[").append(colorCode).append(boxText).append(ANSI_RESET).append("] ");
        }

        return sb;
    }

    public void outOfBattleChoices() {
        System.out.println("\nPlease Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. \n");

        while (true) {
            String userResponse = scanner.next();
            //Move the player
            if (userResponse.equalsIgnoreCase("w") || userResponse.equalsIgnoreCase("a") ||
                    userResponse.equalsIgnoreCase("s") || userResponse.equalsIgnoreCase("d")) {
                int newPlayerBoxID = getNewTileID(userResponse, monstersAndHeroesPlayer.getCurrentBoxID());
                if (newPlayerBoxID != -1) {
                    movePlayer(newPlayerBoxID);
                    BoardPiece newBoardPiece = getBoardPieceFromID(newPlayerBoxID);
                    if (!(newBoardPiece instanceof MarketBoardTile)) {
                        possibleMatch();
                    }
                    break;
                } else {
                    System.out.println("Please enter a valid response.");
                }
                // Quit the Game
            } else if (userResponse.equalsIgnoreCase("q")) {
                System.out.println("The program has quit. Thank you for playing!");
                System.exit(0);
                //Show Game Information
            } else if (userResponse.equalsIgnoreCase("i")) {
                System.out.println("Hero Information: ");
                monstersAndHeroesPlayer.displayHeroesInTableFormat();
                break;
                //Enter the Market!
            } else if (userResponse.equalsIgnoreCase("m")) {
                System.out.println("Attempting to enter a market.\n");
                int currentTile = monstersAndHeroesPlayer.getCurrentBoxID();
                BoardPiece currentPiece = getBoardPieceFromID(currentTile);
                if (currentPiece instanceof MarketBoardTile) {
                    ((MarketBoardTile) currentPiece).enterMarket((MarketBoardTile) currentPiece, monstersAndHeroesPlayer);
                    break;
                } else {
                    System.out.println("You are not in a Market Right Now! Select another option.");
                }
            } else if (userResponse.equalsIgnoreCase("map")) {
                System.out.println(printBoard());
                System.out.println("\nPlease Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. \n");
                //Potentially consume potions
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

    public void potentiallyConsumePotions() {
        List<Hero> heroes = monstersAndHeroesPlayer.getHeroes();
        BattleStrategy potionStrategy = new PotionStrategy();
        for (Hero hero : heroes) {
            potionStrategy.executeStrategy(monstersAndHeroesPlayer, hero, null);
        }
    }

    public void equipWeaponAndArmour(MonstersAndHeroesPlayer monstersAndHeroesPlayer) {
        List<Hero> heroes = monstersAndHeroesPlayer.getHeroes();
        BattleStrategy equipStrategy = new EquipStrategy();
        for (Hero hero : heroes) {
            equipStrategy.executeStrategy(monstersAndHeroesPlayer, hero, null);
        }
    }

    //Gets new tile location for W/A/S/D commands
    public Integer getNewTileID(String direction, int currentTileID) {
        int numRows = boardLength, numCols = boardLength;
        int row = (currentTileID - 1) / numCols, col = (currentTileID - 1) % numCols;

        switch (direction.toLowerCase()) {
            case "w":
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
        if ((newBoardPiece == null) || !newBoardPiece.isAccessible()) {
            return -1;
        }

        return (row >= 0 && row < numRows && col >= 0 && col < numCols)
                ? row * numCols + col + 1
                : -1;
    }

    //Moves the player into a correct boxID
    public void movePlayer(int newPlayerBoxID) {
        removeGamePieceOnBoardPiece(monstersAndHeroesPlayer.getCurrentBoxID());
        putGamePieceOnBoardPiece(monstersAndHeroesTeam.getOnlySymbol(), newPlayerBoxID);
        monstersAndHeroesPlayer.setCurrentBoxID(newPlayerBoxID);
    }

    //Potentially creates a Battle between Heroes and Monsters
    public void possibleMatch() {

        //Dice Roll
        Random random = new Random();
        int chance = random.nextInt(100);

        //We Start a Fight!
        if (chance < 15) {

            //Set up the Monsters
            MonsterFactoryManager monsterFactory = new MonsterFactoryManager(numHeroes);
            List<Monster> monsters = monsterFactory.getMonsters();
            MonsterFactoryManager.scaleLevels(monstersAndHeroesPlayer.getHeroes(), monsters);

            //Start Battle.
            Battle newBattle = new Battle(monstersAndHeroesPlayer.getHeroes(), monsters, monstersAndHeroesPlayer);
            String input = scanner.nextLine();
            newBattle.startBattle();

        }
    }

    //Allow the user to choose their selected heroes.
    public List<Hero> chooseHeroes(List<Hero> heroes, int numHeroes) {
        List<Hero> newHeroes = new ArrayList<>();

        while (numHeroes > 0) {
            System.out.println("\nThis is the remaining list of your possible heroes!");
            HeroFactoryManager.displayHeroesInTableFormat(heroes);
            System.out.println("\nYou must select " + numHeroes + " more heroes. Please choose the index of the next hero you would like to select!");
            int chosenIndex = BoardGame.getNumberResponse(0, heroes.size() - 1, "chosen index of your next hero", "Your index must be ",
                    "Your index must be ", "Incorrect hero index chosen!");
            newHeroes.add(heroes.get(chosenIndex));
            heroes.remove(chosenIndex);
            numHeroes--;
            System.out.println("\nYou have chosen a hero. ");
        }
        System.out.println("\nAll of your heroes have been selected! They are below:");
        HeroFactoryManager.displayHeroesInTableFormat(newHeroes);

        return newHeroes;
    }


    public String gameExplained() {
        return "\nWelcome to Legends: Monsters and Heroes! The game board is a square grid of three types of tiles: common spaces, market tiles, and inaccessible spaces.\n" +
                "Common spaces are empty and serve as areas where battles with monsters may occur.\n" +
                "Market tiles, marked with a blue 'M,' allow heroes to buy and sell items to aid them in battle.\n" +
                "Inaccessible spaces, marked with a red 'X,' cannot be entered by heroes.\n\n" +
                "Heroes move across the board to fight monsters, gather gold, and gain experience.\n" +
                "When heroes enter a common space, there's a chance of encountering monsters.\n" +
                "Battles are turn-based, where heroes can attack, cast spells, use items, or equip new gear.\n" +
                "Each hero has unique stats that influence their actions, and heroes gain experience to level up and strengthen their skills.\n\n" +
                "The objective of the game is to defeat monsters, level up, and survive the challenges of the world.\n" +
                "Enjoy the adventure and aim to make your heroes as powerful as possible!\n";
    }
}

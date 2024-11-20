import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//The main class that starts a Legends of Valor Game, managing gameplay elements and interactions between Heroes and Monsters within the game.
public class LegendsOfValor extends MonstersAndHeroes {

    private MonstersAndHeroesPlayer monstersAndHeroesPlayer;
    private int boardLength = 8;
    private int rounds = 0;
    private List <Hero> chosenHeroList = new ArrayList<>();
    private List <Monster> chosenMonsterList = new ArrayList<>();

    public LegendsOfValor(List<Player> players) {
        super("Legends Of Valor (Single-Player)", players);

    }

    @Override
    public void startGame() {

        //Explain the Game
        System.out.println(gameExplained());

        //Set up board
        this.setBoardSize(this.boardLength);
        setUpBoard();

        //Allow the user to choose their heroes they want!
        System.out.println("\nIt is time to choose 3 heroes! Your i-th chosen hero will live in the i-th column of the game.");
        List<Hero> randomGeneratedHeroes = new HeroFactoryManager(5).getHeroes();
        chosenHeroList = chooseHeroes(randomGeneratedHeroes, 3);

        //Create our Player and Init our heroes with positions on the map.
        Player generalPlayer = getPlayers().get(0);
        monstersAndHeroesPlayer = new MonstersAndHeroesPlayer(generalPlayer.getName(),chosenHeroList);
        GamePiece monstersAndHeroesPlayerGamePiece1 = new GamePiece("H1", "\u001B[1m\u001B[92m");
        GamePiece monstersAndHeroesPlayerGamePiece2 = new GamePiece("H2", "\u001B[1m\u001B[92m");
        GamePiece monstersAndHeroesPlayerGamePiece3 = new GamePiece("H3", "\u001B[1m\u001B[92m");
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece1, 57);
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece2, 60);
        putGamePieceOnBoardPiece(monstersAndHeroesPlayerGamePiece3, 63);
        chosenHeroList.get(0).setCurrentX(7);
        chosenHeroList.get(0).setCurrentX(0);
        chosenHeroList.get(1).setCurrentX(7);
        chosenHeroList.get(1).setCurrentX(3);
        chosenHeroList.get(2).setCurrentX(7);
        chosenHeroList.get(2).setCurrentX(6);

        //Create Our Monsters
        setUpMonsters();

        //Start our Game
        startNewRoundOfGame();
    }

    @Override
    public void startNewRoundOfGame() {
        while (true) {
            System.out.println(printBoard());

            //Hero Rounds
            for (Hero hero : chosenHeroList) {
                System.out.println("A Hero Exists");
            }

            //Monster Rounds
            for (Monster monster : chosenMonsterList) {
                System.out.println("A Monster Exists");
            }

            rounds++;

            break;
        }
    }

    //Create Inaccessible, Market, and Common Space Tiles
    @Override
    public void setUpBoard() {
        BoardPiece[][] board = getBoard();
        Random random = new Random();
        double randomProb;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                //Inaccessible Columns/Walls
                if (j == 2 || j == 5) {
                    board[i][j].setAccessible(false);
                    board[i][j].setType(BoardPieceType.INACCESSIBLE);
                    continue;
                }

                //First and last row is Monster Nexus
                if (i == 0 || i == 7) {
                    board[i][j] = new MarketBoardTile();
                    swapBoardPieces(i * boardLength + j + 1, board[i][j]);
                    board[i][j].setType(BoardPieceType.NEXUS);
                    continue;
                }

                //Else, generate random Board Cells:
                randomProb = random.nextDouble();

                if (randomProb <= 0.05) { //"Inaccessible" Piece
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
        sb.append("\u001B[1m\u001B[30mXXXX\u001B[0m - Inaccessible\n");  // Black
        sb.append("\u001B[1m\u001B[92mH1,H2,H3\u001B[0m - Your heroes!\n");
        sb.append("\u001B[1m\u001B[31mM\u001B[0m - The monsters!\n");
        sb.append("\u001B[34mN\u001B[0m - Nexus/Market\n");         // Blue
        sb.append("\u001B[32mB\u001B[0m - Bush (Dexterity Boost)\n");  // Green
        sb.append("\u001B[90mC\u001B[0m - Cave (Agility Boost)\n");    // Dark Gray
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
        return "\nWelcome to Legends of Valor! The game board is an 8x8 grid, divided into three lanes with various types of spaces: Nexus, Inaccessible, Plain, Bush, Cave, and Koulou.\n" +
                "Each lane spans two columns, with impassable columns separating them. Heroes aim to reach the monsters' Nexus at the top, while monsters attempt to invade the heroes' Nexus at the bottom.\n\n" +
                "Spaces have different effects: Nexus spaces are spawning points and markets for heroes; Bush spaces boost hero dexterity; Cave spaces increase agility; and Koulou spaces enhance strength. \n" +
                "Monsters receive no terrain bonuses.\n\n" +
                "Heroes control a team of three, with each hero occupying a lane. Heroes can perform actions such as moving, attacking, casting spells, using items, or teleporting to other lanes. \n" +
                "They battle invading monsters, gathering gold and experience along the way.\n\n" +
                "Heroes and monsters act in rounds, with heroes going first. If a hero reaches the monster Nexus, they win. If a monster reaches the hero Nexus, the heroes lose.\n\n" +
                "The objective is to coordinate actions, use terrain to your advantage, and stop the monster invasion. Level up, strengthen your heroes, and protect the Nexus!\n";
    }

    public void setUpMonsters() {
        //Create Monsters
        MonsterFactoryManager monsterFactory = new MonsterFactoryManager(3);
        List<Monster> monsters = monsterFactory.getMonsters();
        MonsterFactoryManager.scaleLevels(monstersAndHeroesPlayer.getHeroes(), monsters);

        //Add to Monster List
        chosenMonsterList.addAll(monsters);

        //Add Monster Pieces to the Board
        GamePiece monster1 = new GamePiece("M", "\u001B[1m\u001B[31m");
        GamePiece monster2 = new GamePiece("M", "\u001B[1m\u001B[31m");
        GamePiece monster3 = new GamePiece("M", "\u001B[1m\u001B[31m");
        putGamePieceOnBoardPiece(monster1, 2);
        putGamePieceOnBoardPiece(monster2, 5);
        putGamePieceOnBoardPiece(monster3, 8);

        //Set Monster Positions
        monsters.get(0).setCurrentX(0);
        monsters.get(0).setCurrentX(1);
        monsters.get(1).setCurrentX(0);
        monsters.get(1).setCurrentX(4);
        monsters.get(2).setCurrentX(0);
        monsters.get(2).setCurrentX(7);
    }

}

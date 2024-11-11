//This class extends BoardPiece and represents a merchant board piece.
//In addition to capturing BoardPiece state, this clas includes merchant state as well.

import java.util.*;

public class MarketBoardTile extends BoardPiece {

    private List<Item> items = new ArrayList<>();

    public MarketBoardTile(){
        super();
        ItemFactoryManager itemFactory = new ItemFactoryManager(5);
        items = itemFactory.getItems();
    }

    public void displayItemsInTableFormat() {
        ItemFactoryManager.displayItemsInTableFormat(items);
    }

    public List<Item> getItems() {
        return items;
    }

    //Market Functionality
    public void enterMarket(BoardPiece currentPiece, MonstersAndHeroesPlayer monstersAndHeroesPlayer) {
        System.out.println("\nWelcome to the Market! Below are things you can buy!\n");
        List<Item> marketItems = ((MarketBoardTile) currentPiece).getItems();

        for (Hero hero : monstersAndHeroesPlayer.getHeroes()) {

            //Allow hero to buy
            System.out.println("\n\033[0;31mTime to Buy!" + "\n\033[0m");
            System.out.println("\033[0;35m**********************************************************************Market Information" +
                    "*******************************************************************************************\033[0m");
            ((MarketBoardTile) currentPiece).displayItemsInTableFormat();
            marketBuying(monstersAndHeroesPlayer, hero, marketItems, currentPiece);
            System.out.println("\n\n\n");

            //Allow hero to sell
            System.out.println("\n\033[0;34mTime to sell!" + "\n\033[0m");
            HeroFactoryManager.displayHeroesInTableFormat(Arrays.asList(hero));
            marketSelling(monstersAndHeroesPlayer, hero, marketItems);
        }

        System.out.println("\n\n Now leaving the market!\n");
    }

    public void marketBuying(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, List<Item> marketItems, BoardPiece currentPiece) {
        //Allow hero to buy
        System.out.println("\033[0;31m\nWould you like to buy any items for hero " + hero.getName() + "?\n\033[0m");

        boolean userResponse = BoardGame.userYesOrNoResponse();

        if (userResponse) {
            while (true) {
                if (marketItems.isEmpty()) {
                    System.out.println("\nNo more items to buy!\n");
                    break;
                }
                int chosenIndex = getIndexResponse(monstersAndHeroesPlayer, 0, marketItems.size() - 1,
                        "\nPlease select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                //User is done buying items for the hero.
                if (chosenIndex == -1) {
                    break;
                }
                //At this point, a hero has picked something to buy. See if it is valid!
                Item chosenItem = marketItems.get(chosenIndex);
                if (chosenItem.getPrice() > hero.getGold()) {
                    System.out.println("You do not have enough gold!");
                    continue;
                }

                if (chosenItem.getLevel() > hero.getLevel()) {
                    System.out.println("Your level is not high enough!\n");
                    continue;
                }

                //Chosen thing is valid!
                hero.addItemToInventory(chosenItem);
                hero.subtractGold(chosenItem.getPrice());
                marketItems.remove(chosenIndex);

                System.out.println("\nYou have bought the item! Here is the updated Market!:\n");
                System.out.println("\033[0;35m**********************************************************************Market Information" +
                        "*******************************************************************************************\033[0m");
                ((MarketBoardTile) currentPiece).displayItemsInTableFormat();
            }
        }
    }

    public void marketSelling(MonstersAndHeroesPlayer monstersAndHeroesPlayer,Hero hero, List<Item> marketItems) {
        //Allow hero to Sell
        System.out.println("\033[0;34m\nNext, would you like to sell any of " + hero.getName() + "'s items?\n\033[0m");

        boolean userResponse = BoardGame.userYesOrNoResponse();

        if (userResponse) {
            while (true) {
                if (hero.getInventory().isEmpty()) {
                    System.out.println("\nNo more items to sell!\n");
                    break;
                }
                int chosenIndex = getIndexResponse(monstersAndHeroesPlayer, 0, hero.getInventory().size() - 1,
                        "\nPlease select the index of an item from the table to sell it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                //User is done buying items for the hero.
                if (chosenIndex == -1) {
                    break;
                }
                //At this point, a hero has picked something to sell.
                Item chosenItem = hero.getInventory().get(chosenIndex);
                hero.getInventory().remove(chosenIndex);
                marketItems.add(chosenItem);
                hero.addGold((int) chosenItem.getPrice() / 2);

                System.out.println("\nYou have sold the item! Here is the hero's updated inventory!:\n");
                HeroFactoryManager.displayHeroesInTableFormat(Arrays.asList(hero));
            }
        }
    }

    //Responsible for getting an in index of a potential item from th user.
    public static int getIndexResponse(MonstersAndHeroesPlayer monstersAndHeroesPlayer, int min, int max, String intro, String tryAgain) {
        System.out.println(intro);

        //Clear Scanner Buffer
        Scanner scanner = ScannerSingleton.getInstance();
        BoardGame.clearBuffer();

        //Validate boardSize
        int boardSize;
        while (true) {

            try {
                boardSize = scanner.nextInt();

                if (boardSize == -1) {
                    break;
                }
                if (boardSize == -2) {
                    monstersAndHeroesPlayer.displayHeroesInTableFormat();
                    System.out.println(intro);
                    continue;
                }
                if (boardSize < min) {

                    System.out.println(tryAgain);
                } else if (boardSize > max) {
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


}

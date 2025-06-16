package strategies;

import java.util.List;

import models.MonstersAndHeroesPlayer;
import models.Hero;
import models.Monster;
import models.Item;
import models.Potion;
import factories.ItemFactoryManager;
import ui.MarketBoardTile;
import ui.BoardGame;

//A class responsible for handling the Use Potion strategy in battle, allowing heroes to consume potions to restore health or other attributes.
public class PotionStrategy implements BattleStrategy {
    @Override
    public void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster) {
        while (true) {
            List<Item> potionList = hero.getItemsByType(Potion.class);
            if (!potionList.isEmpty()) {
                System.out.println("\033[0;35m" + hero.getName()+"'s Potions:\033[0m");
                System.out.println("\033[0;35m**********************************************************************************************" +
                        "**********************************************************************************\033[0m");
                ItemFactoryManager.displayItemsInTableFormat(potionList);
                System.out.println("\nWould you like to use a potion?\n");
                boolean usePotion = BoardGame.userYesOrNoResponse();
                if (usePotion) {
                    int index = MarketBoardTile.getIndexResponse(monstersAndHeroesPlayer, 0, potionList.size() - 1,
                            "\nPlease select the index of potion from the table to use it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                    //User is done consuming potions
                    if (index == -1) {
                        break;
                    }

                    Potion chosenPotion = (Potion) potionList.get(index);
                    if (chosenPotion.getLevel() > hero.getLevel()) {
                        System.out.println("\nThis potion is too high-level for your current hero! Please try again!");
                        continue;
                    }

                    System.out.println("\nPotion Consumed!");
                    hero.applyChosenPotion(chosenPotion);
                    hero.removeItemFromInventory(chosenPotion);
                } else {
                    System.out.println("No more potions to look at for hero " + hero.getName() + "!");
                    break;
                }
            } else {
                System.out.println("No more potions to look at for hero " + hero.getName() + "!");
                break;
            }
        }
    }
}

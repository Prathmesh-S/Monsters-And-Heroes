//A class responsible for handling the Equip Item strategy in battle, allowing heroes to equip items during their turn.
import java.util.ArrayList;
import java.util.List;

public class EquipStrategy implements BattleStrategy {

    @Override
    public void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster) {
        helperEquipWeapon(monstersAndHeroesPlayer, hero);
        helperEquipArmor(monstersAndHeroesPlayer, hero);
    }

    public static void helperEquipArmor(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero) {
        // Specifically Equip Armor
        while (true) {
            List<Item> armorList = hero.getItemsByType(Armor.class);
            if (!armorList.isEmpty()) {
                System.out.println("\033[0;35m" + hero.getName() + "'s Unequipped Armor:\033[0m");
                System.out.println("\033[0;35m********************************************************************************************************" +
                        "************************************************************************\033[0m");
                ItemFactoryManager.displayItemsInTableFormat(armorList);
                System.out.println("\nWould you like to Equip a certain Armor?\n");
                boolean equipArmor = BoardGame.userYesOrNoResponse();
                if (equipArmor) {
                    int index = MarketBoardTile.getIndexResponse(monstersAndHeroesPlayer, 0, armorList.size() - 1,
                            "\nPlease select the index of an armor from the table to equip it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");

                    if (index == -1) {
                        break; // User is done Equipping Armor
                    }

                    Armor chosenArmor = (Armor) armorList.get(index);

                    if (chosenArmor.getLevel() > hero.getLevel()) {
                        System.out.println("\nThis armor is too high-level for your current hero! Please try again!");
                        continue;
                    }

                    // Equip the armor (only one piece)
                    hero.setArmor(chosenArmor);
                    hero.removeItemFromInventory(chosenArmor);
                    System.out.println(hero.getName() + " has equipped " + chosenArmor.getName() + " as their armor.");
                } else {
                    System.out.println("No more Armor to look at!\n");
                    break;
                }
            } else {
                System.out.println("No more Armor to look at!\n");
                break;
            }
        }

        // Specifically un-equip (If a hero wants to sell at a market)
        while (true) {
            if (hero.getArmor() == null) {
                break; // No armor equipped, exit the loop
            }

            List<Item> armorList = new ArrayList<>();
            Armor equippedArmor = hero.getArmor();
            armorList.add(equippedArmor);
            System.out.println("\033[0;35m" + hero.getName() + "'s Equipped Armor:\033[0m");
            System.out.println("\033[0;35m**********************************************************************************************" +
                    "**********************************************************************************\033[0m");
            ItemFactoryManager.displayItemsInTableFormat(armorList);

            System.out.println("\nWould you like to unequip your armor?\n");
            boolean unequipArmor = BoardGame.userYesOrNoResponse();
            if (!unequipArmor) {
                break; // User doesn't want to unequip, exit the loop
            } else {
                // Unequip the armor
                hero.setArmor(null);
                hero.addItemToInventory(equippedArmor);
                System.out.println(hero.getName() + " has unequipped their armor.");
            }
        }
    }

    public static void helperEquipWeapon(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero) {
        //Specifically Equip
        while (true) {
            List<Item> weaponList = hero.getItemsByType(Weapon.class);
            if (!weaponList.isEmpty()) {
                System.out.println("\033[0;35m" + hero.getName() + "'s Unequipped Weapons:\033[0m");
                System.out.println("\033[0;35m**********************************************************************************************" +
                        "**********************************************************************************\033[0m");
                ItemFactoryManager.displayItemsInTableFormat(weaponList);
                System.out.println("\nWould you like to Equip a certain Weapon?\n");
                boolean equipWeapon = BoardGame.userYesOrNoResponse();
                if (equipWeapon) {
                    int index = MarketBoardTile.getIndexResponse(monstersAndHeroesPlayer, 0, weaponList.size() - 1,
                            "\nPlease select the index of a weapon from the table to equip it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                    //User is done Equipping Weapons
                    if (index == -1) {
                        break;
                    }
                    Weapon chosenWeapon = (Weapon) weaponList.get(index);

                    if (chosenWeapon.getLevel() > hero.getLevel()) {
                        System.out.println("\nThis weapon is too high-level for your current hero! Please try again!");
                        continue;
                    }

                    //If two hands are required
                    if (chosenWeapon.getHandsRequired() == 2) {
                        System.out.println("\nWeapon has been Equipped!");
                        hero.equipTwoHandedWeapon(chosenWeapon);
                    } else {

                        System.out.println("\nWould you like to Equip your chosen one-handed weapon in both hands of the hero?\n");
                        boolean equipWeaponOnBothHands = BoardGame.userYesOrNoResponse();

                        if (equipWeaponOnBothHands) {
                            System.out.println("\nWeapon has been Equipped!");
                            hero.equipTwoHandedWeapon(chosenWeapon);
                        } else {
                            System.out.println("\nWould you like to Equip your chosen weapon in the hero's left hand?\n");
                            boolean equipWeaponOnLeftHand = BoardGame.userYesOrNoResponse();

                            if (equipWeaponOnLeftHand) {
                                System.out.println("\nWeapon has been Equipped!");
                                hero.equipLeftHandedWeapon(chosenWeapon);
                            } else {
                                System.out.println("\nWeapon has been Equipped!");
                                hero.equipRightHandedWeapon(chosenWeapon);
                            }
                        }
                    }

                } else {
                    System.out.println("No more Weapons to look at!\n");
                    break;
                }
            } else {
                System.out.println("No more Weapons to look at!\n");
                break;
            }
        }

        //Specifically un-equip (If a hero wants to sell at a market)
        while (true) {
            if (hero.getLeftHand() == null && (hero.getRightHand() == null)) {
                break;
            }

            List<Item> weaponList = hero.getEquippedWeapons();
            System.out.println("\033[0;35m" + hero.getName() + "'s Equipped Weapons:\033[0m");
            System.out.println("\033[0;35m********************************************************************************************************" +
                    "************************************************************************\033[0m");
            ItemFactoryManager.displayItemsInTableFormat(weaponList);

            System.out.println("\nWould you like to unequip a certain Weapon?\n");
            boolean unequipWeapon = BoardGame.userYesOrNoResponse();
            if (!unequipWeapon) {
                break;
            } else {
                int index = MarketBoardTile.getIndexResponse(monstersAndHeroesPlayer, 0, weaponList.size() - 1,
                        "\nPlease select the index of a weapon from the table to unequip it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                //User is done Equipping Weapons
                if (index == -1) {
                    break;
                }
                Weapon chosenWeapon = (Weapon) weaponList.get(index);
                //If two hands are required
                if (chosenWeapon.getHandsRequired() == 2) {
                    System.out.println("\nWeapon has been unequipped!");
                    hero.dequipTwoHandedWeapon();
                } else if ((hero.getLeftHand() != null) && chosenWeapon.equals(hero.getLeftHand())) {
                    System.out.println("\nWeapon has been unequipped!");
                    hero.dequipLeftHandedWeapon();
                } else if ((hero.getRightHand() != null) && chosenWeapon.equals(hero.getRightHand())) {
                    System.out.println("\nWeapon has been unequipped!");
                    hero.dequipRightHandedWeapon();
                }
            }
        }
    }
}

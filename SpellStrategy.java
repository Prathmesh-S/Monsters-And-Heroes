// A class responsible for handling the Cast Spell strategy in battle, allowing heroes to use magical attacks against monsters.

import java.util.List;

public class SpellStrategy implements BattleStrategy {
    @Override
    public void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster) {

        //Get Spell
        Spell chosenSpell = getSpellFromUser(monstersAndHeroesPlayer, hero);

        if (chosenSpell == null) {
            System.out.print("\033[0;34m\n----------------------------------Hero's Turn--------------------------------------------\033[0m\n");
            System.out.print("You had no spells or chose to use none! Thus, you just stared at the monster!\n");
            System.out.print("\033[0;34m-----------------------------------------------------------------------------------------\033[0m\n");
            return;
        }
        System.out.print("\033[0;34m----------------------------------Hero's Turn--------------------------------------------\033[0m\n");
        System.out.println("The spell " + chosenSpell.getName() + " has just been used on the monster!");
        double attackDamage = chosenSpell.getDamageValue() * (hero.getDexterity()/10000 + 1) ;
        hero.setMP( (int) (hero.getMP() - chosenSpell.getManaCost()));

        //Spell Effect!
        //Damage only affected the defense of the monster!
        if (monster.getDefense() >= attackDamage ) {
            System.out.println("\nYour hero " + hero.getName()+ " did " + attackDamage + " damage to monster " + monster.getName() +"'s defence!\n");
            monster.setDefense((int)(monster.getDefense() - attackDamage));
        } else {
            //Damage effected the HP of the monster.

            attackDamage = attackDamage - monster.getDefense();

            System.out.println("\nYour hero " + hero.getName()+ " did " + monster.getDefense() + " damage to monster " + monster.getName() +"'s defence!\n");
            monster.setDefense(0);


            System.out.println("\nYour hero " + hero.getName()+ " did " + attackDamage + " damage to monster " + monster.getName() +"'s HP!\n");
            monster.setHP((int)(monster.getHP() - attackDamage));
        }

        //Special Effects
        switch (chosenSpell.getSpellType()) {
            case "Ice":
                monster.setBaseDamage((int) (monster.getBaseDamage() - 50));
                System.out.println("The Ice spell has reduced " + monster.getName() + "'s damage by 50.");
                break;
            case "Fire":
                monster.setDefense((int) (monster.getDefense() - 50));
                System.out.println("The Fire spell has reduced " + monster.getName() + "'s defense by 50.");
                break;
            case "Lightning":
                monster.setDodgeAbility(monster.getDodgeAbility() - 20);
                System.out.println("The Lightning spell has reduced " + monster.getName() + "'s dodge value by 20!");
                break;
        }

        if (monster.getHP() <=0) {
            System.out.println("\nThe Monster has been defeated as it has lost all of its HP!\n");
        }


        System.out.print("\033[0;34m-----------------------------------------------------------------------------------------\033[0m\n");
    }

    public Spell getSpellFromUser(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero) {
        Spell chosenSpell;
        while (true) {
            List<Item> spellList = hero.getItemsByType(Spell.class);
            if (!spellList.isEmpty()) {
                System.out.println("\033[0;35m" + hero.getName()+"'s Spells:\033[0m");
                System.out.println("\033[0;35m**********************************************************************************************" +
                        "**********************************************************************************\033[0m");
                ItemFactoryManager.displayItemsInTableFormat(spellList);
                System.out.println("\nWould you like to use a Spell?\n");
                boolean useSpell = BoardGame.userYesOrNoResponse();
                if (useSpell) {
                    int index = MarketBoardTile.getIndexResponse(monstersAndHeroesPlayer, 0, spellList.size() - 1,
                            "\nPlease select the index of a spell from the table to use it or type -1 to stop or -2 for hero information.\n", "Incorrect Index Chosen!");
                    //User is done consuming Spells
                    if (index == -1) {
                        break;
                    }

                    chosenSpell = (Spell) spellList.get(index);
                    if (chosenSpell.getLevel() > hero.getLevel()) {
                        System.out.println("\nThis spell is too high-level for your current hero! Please try again!");
                        continue;
                    }

                    if (chosenSpell.getManaCost() > hero.getMP()) {
                        System.out.println("\nYou do not have enough mana to use this! Please try again!");
                        continue;
                    }

                    System.out.println("\nSpell Consumed!");
                    hero.removeItemFromInventory(chosenSpell);
                    return chosenSpell;
                } else {
                    System.out.println("No more Spells to look at for hero " + hero.getName() + "!");
                    break;
                }
            } else {
                System.out.println("No more Spells to look at for hero " + hero.getName() + "!");
                break;
            }
        }
        return null;
    }
}

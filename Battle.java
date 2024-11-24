import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This class starts and maintains a Heroes Vs Monsters Battle.
public class Battle {
    private List<Hero> heroes;
    private List<Monster> monsters;
    private List<Hero> tempHeroes = new ArrayList<>();
    private List<Monster> tempMonsters = new ArrayList<>();
    private Scanner scanner;
    private MonstersAndHeroesPlayer monstersAndHeroesPlayer;

    public Battle(List<Hero> heroes, List<Monster> monsters, MonstersAndHeroesPlayer monstersAndHeroesPlayer) {
        this.heroes = heroes;
        this.monsters = monsters;
        tempHeroes.addAll(heroes);
        tempMonsters.addAll(monsters);
        scanner = ScannerSingleton.getInstance();
        this.monstersAndHeroesPlayer = monstersAndHeroesPlayer;
    }

    public void startBattle() {
        System.out.println("\nA fierce battle has begun! Heroes are facing off against monsters...\n");
        while (!tempHeroes.isEmpty() && !tempMonsters.isEmpty()) {
            //Get our Fighters!
            Hero hero = tempHeroes.get(0);
            Monster monster = tempMonsters.get(0);
            List<Hero> listOfHero = new ArrayList<>();
            List<Monster> listOfMonster = new ArrayList<>();
            listOfHero.add(hero);
            listOfMonster.add(monster);
            System.out.println(hero.getName() + " (Hero) vs " + monster.getName() + " (Monster)");

            //Fight till a hero or Monster Dies.
            while (hero.getHP() > 0 && monster.getHP() > 0) {

                //Hero Turn
                showHeroOptions(hero);
                String userResponse = scanner.nextLine().toLowerCase();

                switch (userResponse) {
                    case "a":
                        System.out.print("\033[0;34m----------------------------------Hero's Turn--------------------------------------------\033[0m");
                        BattleStrategy attackStrategy = new AttackStrategy();
                        attackStrategy.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                        System.out.print("\033[0;34m-----------------------------------------------------------------------------------------\033[0m\n");
                        break;
                    case "s":
                        BattleStrategy spellStrategy = new SpellStrategy();
                        spellStrategy.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                        scanner.nextLine();
                        break;
                    case "p":
                        BattleStrategy potionStrategy = new PotionStrategy();
                        potionStrategy.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                        break;
                    case "e":
                        BattleStrategy equipStrategy = new EquipStrategy();
                        equipStrategy.executeStrategy(monstersAndHeroesPlayer, hero, monster);
                        break;
                    case "i":
                        System.out.println("\nHere is some information about your match-up:\n");
                        HeroFactoryManager.displayHeroesInTableFormat(listOfHero);
                        MonsterFactoryManager.displayMonstersInTableFormat(listOfMonster);
                        continue;
                    case "q":
                        System.out.println("\nYour Game has Ended.\n");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please choose a valid action.");
                        scanner.nextLine();
                        continue;
                }


                if (monster.getHP() <= 0) {
                    break;
                }

                //Monster Turn
                System.out.print("\n\033[0;31m----------------------------------Monster's Turn--------------------------------------------\033[0m");
                monsterAttack(hero, monster);
                System.out.print("\033[0;31m--------------------------------------------------------------------------------------------\033[0m\n");

            }

            if (monster.getHP() <= 0) {
                tempMonsters.remove(monster);
            }

            if (hero.getHP() <= 0) {
                tempHeroes.remove(hero);
            }

        }

        if (tempHeroes.isEmpty()) {
            System.out.println("\nAll of the heroes have died! The game is now over!\n");
            System.exit(0);
        }

        //Update Hero Values Since if we pass this, we defeated all the monsters!
        //experience, money, level

        int sumMonsterLevel = getSumMonsterLevel(monsters);

        System.out.print("\n\033[0;32m----------------------------------After The Battle!------------------------------------\n");

        for (Hero hero : heroes) {
            //Revive dead hero's with HP/Mana
            if (!tempHeroes.contains(hero)) {
                hero.setHP(hero.getMaxHP() / 2);
                hero.setMP(hero.getMaxMana() / 2);
                System.out.println("Hero " + hero.getName() + " has been revived with half their max HP/MP.");
            } else {
                //Reward Heroes that lived!
                hero.setGold(hero.getGold() + sumMonsterLevel * 100);
                hero.setExperiencePoints(hero.getExperiencePoints() + sumMonsterLevel);
                System.out.println("Hero " + hero.getName() + " was victorious in the battle and gained "
                        + (sumMonsterLevel * 100) + " gold and " + sumMonsterLevel + " experience points.");
                hero.levelUp();
            }
        }

        System.out.print("\n\033[0;32m--------------------------------------------------------------------------------------");
    }

    private void showHeroOptions(Hero hero) {
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Choose an action for " + hero.getName() + ":");
        System.out.println("A: Attack with equipped weapon (Make sure its equipped!)");
        System.out.println("S: Cast a spell from your inventory");
        System.out.println("P: Use a potion from your inventory");
        System.out.println("E: Equip a new item (weapon/armor)");
        System.out.println("I: Display stats (hero or monster)");
        System.out.println("Q: Quit");
        System.out.println("--------------------------------------------------------------");
    }

    public static void monsterAttack(Hero hero, Monster monster) {

        //Check if the hero has dodged!
        double dodgeChange = hero.getAgility() * 0.02 / 100;
        double randomDecimal = Math.random();
        if (randomDecimal < dodgeChange) {
            System.out.println("\nThe hero " + hero.getName() + " dodged the monster's attack!\n");
            return;
        }

        double attackDamage = monster.getBaseDamage();
        Armor heroArmor = hero.getArmor();

        //Damage directly affected the HP of our hero
        if (heroArmor == null) {
            System.out.println("\nThe monster " + monster.getName() + " did " + attackDamage + " damage to hero " + hero.getName() + "'s HP!\n");
            hero.setHP((int) (hero.getHP() - attackDamage));
        } else {
            //Damage effected Armor + HP
            if (attackDamage <= heroArmor.getDamageReductionValue()) {
                System.out.println("\nThe monster " + monster.getName() + " did " + attackDamage + " damage to hero " + hero.getName() + "'s armor!\n");
                heroArmor.setDamageReductionValue((int) (heroArmor.getDamageReductionValue() - attackDamage));
            } else {
                attackDamage = attackDamage - heroArmor.getDamageReductionValue();
                System.out.println("\nThe monster " + monster.getName() + " did " + heroArmor.getDamageReductionValue() + " damage to hero " + hero.getName() + "'s armor!\n");
                heroArmor.setDamageReductionValue(0);

                System.out.println("\nThe monster " + monster.getName() + " did " + attackDamage + " damage to hero " + hero.getName() + "'s HP!\n");
                hero.setHP((int) (hero.getHP() - attackDamage));
            }

            if (hero.getArmor().getDamageReductionValue() <= 0) {
                System.out.println("\nYour armour has broke and will no longer be usable next round!\n");
                hero.setArmor(null);
            }
        }


        if (hero.getHP() <= 0) {
            System.out.println("\nThe Hero has fainted as it has lost all of its HP!\n");
        }

    }

    public int getSumMonsterLevel(List<Monster> monsters) {
        int sum = 0;
        for (Monster monster : monsters) {
            sum += monster.getLevel();
        }
        return sum;
    }
}
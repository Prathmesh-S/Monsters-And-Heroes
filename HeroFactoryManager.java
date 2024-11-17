import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Factory to create an arbitrary amount of Heroes. A manager class responsible for overseeing and managing the creation and handling of multiple Hero instances.
public class HeroFactoryManager {
    private List<Hero> heroes = new ArrayList<>();
    private HeroFactory[] factories = {new PaladinFactory("Paladins.txt"),
            new SorcererFactory("Sorcerers.txt"), new WarriorFactory("Warriors.txt")};
    private Random random = new Random();

    public HeroFactoryManager(int numHeroes) {
        generateRandomHeroes(numHeroes);
    }

    public void generateRandomHeroes(int heroCount) {
        heroes.clear();
        for (int i = 0; i < heroCount; i++) {
            int randomNumber = (random.nextInt(factories.length));
            Hero newHero = (factories[randomNumber].createCharacter());
            if (!heroes.contains(newHero)) {
                heroes.add(newHero);
                ItemFactoryManager itemFactory = new ItemFactoryManager(3);
                newHero.getInventoryObject().setInventory(itemFactory.getItems());
                if (randomNumber == 0) {
                    newHero.setHeroType("Paladin");
                }
                else if (randomNumber == 1) {
                    newHero.setHeroType("Sorcerer");
                }
                else {
                    newHero.setHeroType("Warrior");
                }
            } else {
                i = i -1;
            }
        }
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public static void displayHeroesInTableFormat(List<Hero> heroes) {
        System.out.println("\033[0;32m**********************************************************************Hero Information" +
                "*********************************************************************\033[0m");
        System.out.printf("%-10s %-10s %-20s %-10s %-10s %-20s %-10s %-10s %-10s %-10s %-5s %-10s %-10s %-12s%n",
                "Index", "Type", "Name", "HP", "Level", "Experience Points", "Mana", "Strength", "Agility", "Dexterity", "Gold", "Left Hand", "Right Hand", "Armour");

        int index = 0;

        for (Hero hero : heroes) {
            String name = hero.getName();
            String type = hero.getHeroType();
            int hp = hero.getHP();
            int level = hero.getLevel();
            int experience = hero.getExperiencePoints();
            int mana = hero.getMP();
            int strength = (int) hero.getStrength();
            int agility = (int) hero.getAgility();
            int dexterity = (int) hero.getDexterity();
            int gold = hero.getGold();
            String leftHand = (hero.getLeftHand() != null) ? hero.getLeftHand().toString() : "";
            String rightHand = (hero.getRightHand() != null) ? hero.getRightHand().toString() : "";
            String armor= (hero.getArmor() != null) ? hero.getArmor().toString() : "";


            System.out.printf("%-10s %-10s %-20s %-10d %-10d %-20d %-10d %-10d %-10d %-10d %-5s %-10s %-10s %-12s%n",
                    index, type, name, hp, level, experience, mana, strength, agility, dexterity, gold, leftHand, rightHand, armor);

            index = index + 1;
        }

        System.out.println("\033[0;32m******************************************************************************************" +
                "*****************************************************************\033[0m");

        for (Hero hero : heroes) {
            System.out.printf("\nInventory of " + hero.getName() + ":\n");
            System.out.println("\033[0;35m**********************************************************************Item Information" +
                    "******************************************************************************************\033[0m");
            ItemFactoryManager.displayItemsInTableFormat(hero.getInventoryObject().getInventory());
        }
    }

}

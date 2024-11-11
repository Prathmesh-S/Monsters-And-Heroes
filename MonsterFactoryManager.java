import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// A manager class responsible for overseeing and managing the creation and handling of multiple Monsters instances.
public class MonsterFactoryManager {
    private List<Monster> monsters = new ArrayList<>();
    private MonsterFactory[] factories = {
            new DragonFactory("Dragons.txt"),
            new ExoskeletonFactory("Exoskeletons.txt"),
            new SpiritFactory("Spirits.txt")
    };
    private Random random = new Random();

    public MonsterFactoryManager(int numMonsters) {
        generateRandomMonsters(numMonsters);
    }

    public void generateRandomMonsters(int monsterCount) {
        monsters.clear();
        for (int i = 0; i < monsterCount; i++) {
            int randomNumber = (random.nextInt(factories.length));
            Monster newMonster = (factories[randomNumber].createCharacter());
            if (!monsters.contains(newMonster)) {
                monsters.add(newMonster);

                if (randomNumber == 0) {
                    newMonster.setMonsterType("Dragon");
                }
                else if (randomNumber == 1) {
                    newMonster.setMonsterType("Exoskeleton");
                }
                else {
                    newMonster.setMonsterType("Spirit");
                }
            } else {
                i = i -1;
            }
        }
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public static void displayMonstersInTableFormat(List<Monster> monsters) {
        System.out.println("\033[38;5;197m***************************************************************Monster Information" +
                "*********************************************************************\033[0m");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-15s%n",
                "Type", "Name", "HP", "Level", "Base Damage", "Defense", "Dodge Ability");

        for (Monster monster : monsters) {
            String name = monster.getName();
            String type = monster.getClass().getSimpleName();
            int hp = monster.getHP();
            int level = monster.getLevel();
            int baseDamage = (int)monster.getBaseDamage();
            int defense = (int) monster.getDefense();
            int dodgeAbility = (int) monster.getDodgeAbility();

            System.out.printf("%-15s %-20s %-15d %-15d %-15d %-15d %-15d%n",
                    type, name, hp, level, baseDamage, defense, dodgeAbility);
        }

        System.out.println("\033[38;5;197m**************************************************************************************" +
                "*****************************************************************\033[0m");
    }

    public static List <Monster> scaleLevels(List<Hero> heroes, List <Monster> monsters) {
        int i = 0;
        for (Hero hero : heroes) {
            int heroLevel = hero.getLevel();
            monsters.get(i).setLevel(heroLevel);
            i = i + 1;
        }
        return monsters;
    }
}
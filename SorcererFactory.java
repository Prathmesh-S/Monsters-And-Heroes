import java.util.Random;

//Factory to create Sorcerers
public class SorcererFactory implements HeroFactory {
    private String filePath;

    public SorcererFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Hero createCharacter() {
        String line = Util.getRandomLineFromFile(filePath);
        if (line == null) return null;

        String[] attributes = line.trim().split("\\s+");
        String name = attributes[0];
        int mp = Integer.parseInt(attributes[1]);
        int strength = Integer.parseInt(attributes[2]);
        int agility = Integer.parseInt(attributes[3]);
        int dexterity = Integer.parseInt(attributes[4]);
        int gold = Integer.parseInt(attributes[5]);
        int experiencePoints = Integer.parseInt(attributes[6]);
        Random random = new Random();
        int level = random.nextInt(5) + 3;

        // Create a new Sorcerer object. Assuming level starts at 1 and HP is set to 0 initially.
        return new Sorcerer(name, level, experiencePoints, mp, 100 * level * 2, strength, dexterity, agility, gold);
    }
}
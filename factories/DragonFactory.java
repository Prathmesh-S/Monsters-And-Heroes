package factories;

import models.Monster;
import models.Dragon;
import utils.Util;

// A factory class responsible for creating instances of the Dragon monster.
public class DragonFactory implements MonsterFactory {
    private String filePath;

    public DragonFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Monster createCharacter() {
        String line = Util.getRandomLineFromFile(filePath);
        if (line == null) return null;

        String[] attributes = line.trim().split("\\s+");
        String name = attributes[0];
        int level = Integer.parseInt(attributes[1]);
        int baseDamage = Integer.parseInt(attributes[2]);
        int defense = Integer.parseInt(attributes[3]);
        double dodgeAbility = Double.parseDouble(attributes[4]);

        // Create a new Dragon object
        return new Dragon(name, level, level * 100 * 2, baseDamage, defense, dodgeAbility);
    }
}
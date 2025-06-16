package factories;

import models.Monster;
import models.Spirit;
import utils.Util;

// A factory class responsible for creating instances of Spirit with randomized attributes.
public class SpiritFactory implements MonsterFactory {
    private String filePath;

    public SpiritFactory(String filePath) {
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

        // Create a new Spirit object
        return new Spirit(name, level, level * 100 * 2, baseDamage, defense, dodgeAbility); // Assuming HP is set to 1000
    }
}
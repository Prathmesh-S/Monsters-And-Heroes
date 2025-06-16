package factories;

//A factory class responsible for creating instances of Spell, managing the different types of spells like fire, ice, and lightning.
import java.util.Random;

import models.Item;
import models.Spell;
import utils.Util;

public class SpellFactory implements ItemFactory {
    private String filePath;
    private static final Random random = new Random();
    private String affectedAttribute;

    public SpellFactory(String lightningFilePath, String iceFilePath, String fireFilePath) {
        String[] filePaths = {lightningFilePath, iceFilePath, fireFilePath};
        this.filePath = filePaths[random.nextInt(filePaths.length)];
        //String spellType = filePath.substring(31, filePath.length() - 10);
        if (filePath.contains("Ice")) {
            affectedAttribute = "Ice";
        }
        else if (filePath.contains("Fire")) {
            affectedAttribute = "Fire";
        }
        else {
            affectedAttribute = "Lightning";
        }
    }

    @Override
    public Item createItem() {
        String line = Util.getRandomLineFromFile(filePath);
        if (line == null) return null;

        String[] attributes = line.trim().split("\\s+");
        String name = attributes[0];
        double price = Double.parseDouble(attributes[1]);
        int level = Integer.parseInt(attributes[2]);
        int damage = Integer.parseInt(attributes[3]);
        int manaCost = Integer.parseInt(attributes[4]);

        return new Spell(name, price, level, damage, manaCost, affectedAttribute);
    }
}
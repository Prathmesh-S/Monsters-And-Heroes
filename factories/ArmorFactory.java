package factories;

import models.Item;
import models.Armor;
import utils.Util;

//A Factory that creates random pieces of armor!
public class ArmorFactory implements ItemFactory {
    private String filePath;

    public ArmorFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Item createItem() {
        String line = Util.getRandomLineFromFile(filePath);
        if (line == null) return null;

        String[] attributes = line.trim().split("\\s+");
        String name = attributes[0];
        double price = Double.parseDouble(attributes[1]);
        int level = Integer.parseInt(attributes[2]);
        int damageReduction = Integer.parseInt(attributes[3]);

        return new Armor(name, price, level, 5, damageReduction);
    }
}
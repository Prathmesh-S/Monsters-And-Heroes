package factories;

import models.Item;
import models.Weapon;
import utils.Util;

//Concrete Factory creating a Weapon
public class WeaponFactory implements ItemFactory {
    private String filePath;

    public WeaponFactory(String filePath) {
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
        int damageValue = Integer.parseInt(attributes[3]);
        int handsRequired = Integer.parseInt(attributes[4]);

        return new Weapon(name, price, level, 3, damageValue, handsRequired); // Assuming 10 uses
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Factory to create an arbitrary amount of Items
public class ItemFactoryManager {
    private List<Item> items = new ArrayList<>();
    private ItemFactory[] factories = {new WeaponFactory("Weaponry.txt"), new ArmorFactory("Armory.txt"),
            new PotionFactory("Potions.txt"), new SpellFactory("LightningSpells.txt",
            "IceSpells.txt", "FireSpells.txt")};
    private Random random = new Random();

    public ItemFactoryManager(int numItems) {
        generateRandomItems(numItems);
    }

    public void generateRandomItems(int itemCount) {
        items.clear();
        for (int i = 0; i < itemCount; i++) {
            Item newItem = (factories[(random.nextInt(factories.length))].createItem());
            if (!items.contains(newItem)) {
                items.add(newItem);
            }
            else {
                i = i -1;
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public static void displayItemsInTableFormat(List<Item> items) {

        System.out.printf("%-6s %-18s %-10s %-10s %-13s %-8s %-8s %-15s %-17s %-15s %-17s %-20s%n",
               "Index", "Name", "ItemType", "Buy Price", "Sell Price", "Level", "Damage", "Hands Required",
                "Damage Reduction", "Effect Amount", "Available Uses", "Attribute Affected");

        int i = 0;

        for (Item item : items) {
            String name = item.getName();
            String itemType = item.getClass().getSimpleName();
            String price = String.valueOf(item.getPrice());
            String sellPrice =  String.valueOf(item.getPrice()/2);
            String level = String.valueOf(item.getLevel());
            String damage = item instanceof Weapon ? String.valueOf(((Weapon) item).getDamageValue()) : "";
            String handsRequired = item instanceof Weapon ? String.valueOf(((Weapon) item).getHandsRequired()) : "";
            String damageReduction = item instanceof Armor ? String.valueOf(((Armor) item).getDamageReductionValue()) : "";
            String effectAmount = item instanceof Potion ? String.valueOf(((Potion) item).getEffectAmount()) :
                    item instanceof Spell ? String.valueOf(((Spell) item).getDamageValue()) : "";
            String availableUses = String.valueOf(item.getUses());
            String attributeAffected = item instanceof Potion ? ((Potion) item).getEffectType() :
                    item instanceof Spell ? ((Spell) item).getSpellType() : "";

            System.out.printf("%-6s %-18s %-10s %-10s %-13s %-8s %-8s %-15s %-17s %-15s %-17s %-20s%n",
                    i, name, itemType, price, sellPrice, level, damage, handsRequired,
                    damageReduction, effectAmount,  availableUses, attributeAffected);
            i = i + 1;
        }

        System.out.println("\033[0;35m**********************************************************************************************" +
                "**********************************************************************************\033[0m");
    }
}

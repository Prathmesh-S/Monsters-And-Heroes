//A factory class responsible for creating instances of Potion with randomized effects.
public class PotionFactory implements ItemFactory {
    private String filePath;

    public PotionFactory(String filePath) {
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
        int effectAmount = Integer.parseInt(attributes[3]);
        String attributeAffected = attributes[4];

        return new Potion(name, price, level, effectAmount, attributeAffected);
    }
}
package models;

// A base abstract class for items that can be used by characters, such as weapons, armor, or potions.
public abstract class Item {
    private String name;
    private double price;
    private int level;
    private int uses;

    public Item(String name, double price, int level, int uses) {
        this.name = name;
        this.price = price;
        this.level = level;
        this.uses = uses;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }

    public int getUses() {
        return uses;
    }

    public void use() {
        if (uses > 0) {
            uses--;
        }
    }

    public boolean isUsable() {
        return uses > 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == null || (o == null)) {
            return false;
        }
        Item x = (Item) o;
        if (this.getName().equals(x.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void useItem() {
        this.uses = this.uses - 1;
    }
}

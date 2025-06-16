package models;

//A concrete class representing a consumable potion that can affect a character’s attributes, like health or mana.
public class Potion extends Item {
    private String effectType; // e.g., "HP", "MP", "Strength", etc.
    private int effectAmount;

    public Potion(String name, double price, int level, int effectAmount, String effectType) {
        super(name, price, level, 1); // Potions are single-use
        this.effectAmount = effectAmount;
        this.effectType = effectType;
    }

    public String getEffectType() {
        return effectType;
    }

    public int getEffectAmount() {
        return effectAmount;
    }
}

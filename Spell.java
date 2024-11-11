//Concrete Class representing a certain Spell.
public class Spell extends Item {
    private int damageValue;
    private int manaCost;
    private String spellType; // e.g., "Ice", "Fire", "Lightning"

    public Spell(String name, double price, int level, int damageValue, int manaCost, String spellType) {
        super(name, price, level, 1);
        this.damageValue = damageValue;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

}

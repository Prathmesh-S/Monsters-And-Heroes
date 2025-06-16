package models;

//Concrete Class representing a weapon.
public class Weapon extends Item {
    private int damageValue;
    private int handsRequired;

    public Weapon(String name, double price, int level, int uses, int damageValue, int handsRequired) {
        super(name, price, level, uses);
        this.damageValue = damageValue;
        this.handsRequired = handsRequired;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public int getHandsRequired() {
        return handsRequired;
    }

    public void increaseDamageIfTwoHanded() {
        if (handsRequired == 1) {
            damageValue += 2; // Example increase
        }
    }
}

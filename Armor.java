//Concrete Class representing a piece of armour.
public class Armor extends Item {
    private int damageReductionValue;

    public Armor(String name, double price, int level, int uses, int damageReductionValue) {
        super(name, price, level, uses);
        this.damageReductionValue = damageReductionValue;
    }

    public int getDamageReductionValue() {
        return damageReductionValue;
    }

    public void setDamageReductionValue(int damageReductionValue) {
        this.damageReductionValue = damageReductionValue;
    }
}

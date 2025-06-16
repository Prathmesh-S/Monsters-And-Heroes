package models;

//Concrete Class to create a dragon
public class Dragon extends Monster {
    public Dragon(String name, int level, int HP, int baseDamage, int defense, double dodgeAbility) {
        super(name, level, HP, baseDamage, defense, dodgeAbility);
    }

    @Override
    public double getBaseDamage() {
        double baseDamage = super.getBaseDamage();
        baseDamage = baseDamage * 1.1;
        return baseDamage;
    }
}
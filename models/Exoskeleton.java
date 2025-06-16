package models;

//Concrete Class to create an Exoskeleton
public class Exoskeleton extends Monster {
    public Exoskeleton(String name, int level, int HP, int baseDamage, int defense, double dodgeAbility) {
        super(name, level, HP, baseDamage, defense, dodgeAbility);
    }

    @Override
    public double getDefense() {
        double defense = super.getDefense();
        defense = defense * 1.1;
        return defense;
    }
}
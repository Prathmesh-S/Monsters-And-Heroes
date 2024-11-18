//Concrete Class to create a Paladin; A concrete class representing a Paladin hero type with unique abilities and attributes.
public class Paladin extends Hero {
    public Paladin(String name, int level, int experiencePoints, int mp, int hp, int strength, int dexterity,
            int agility, double baseDefense, int gold) {
        super(name, level, experiencePoints, mp, hp, strength, dexterity, agility, baseDefense, gold);
    }

    @Override
    public double getStrength() {
        double strength = super.getStrength();
        strength = strength * 1.1;
        return strength;
    }

    @Override
    public double getDexterity() {
        double dexterity = super.getDexterity();
        dexterity = dexterity * 1.1;
        return dexterity;
    }
}
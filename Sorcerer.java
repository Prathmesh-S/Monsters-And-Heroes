//Concrete Class to create a Sorcerer
public class Sorcerer extends Hero {
    public Sorcerer(String name, int level, int experiencePoints, int mp, int hp, int strength, int dexterity,
            int agility, double baseDefense, int gold) {
        super(name, level, experiencePoints, mp, hp, strength, dexterity, agility, baseDefense, gold);
    }

    @Override
    public double getDexterity() {
        double dexterity = super.getDexterity();
        dexterity = dexterity * 1.1;
        return dexterity;
    }

    @Override
    public double getAgility() {
        double agility = super.getAgility();
        agility = agility * 1.1;
        return agility;
    }
}